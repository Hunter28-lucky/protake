package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.RawNetworkCallback;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public class BitmapProcessor {
    private static final int CAPACITY = 3;
    private static final int MAX_CACHE_SIZE = 50;
    private static final int MAX_CACHE_TIME = 60000;
    private static final int MAX_REQ_TIME = 20000;
    private static final int MAX_SIZE = 100;
    private static final int OVERFLOW_SIZE = 120;
    private static final int SCAN_INTERVAL = 20000;
    private static File cacheDir;
    private static CachePoolInner<String, SoftReference<Bitmap>> cachePool;
    private static ManagerThread manager;
    private static ArrayList<ImageReq> netReqTPS;
    private static ArrayList<ImageReq> reqList;
    private static NetworkHelper.NetworkTimeOut timeout;
    private static boolean work;
    private static WorkerThread[] workerList;

    public interface BitmapCallback {
        void onImageGot(String str, Bitmap bitmap);
    }

    public static class BitmapDesiredOptions {
        public int desiredWidth = 0;
        public int desiredHeight = 0;
        public long maxBytes = 0;
        public int quality = 0;

        public boolean equals(Object obj) {
            return super.equals(obj) || (obj != null && obj.toString().equals(toString()));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            int i = this.desiredWidth;
            if (i > 0) {
                sb.append(i);
            }
            int i2 = this.desiredHeight;
            if (i2 > 0) {
                sb.append(i2);
            }
            long j = this.maxBytes;
            if (j > 0) {
                sb.append(j);
            }
            int i3 = this.quality;
            if (i3 > 0) {
                sb.append(i3);
            }
            return sb.toString();
        }
    }

    public static class ImageReq {
        private BitmapDesiredOptions bitmapDesiredOptions;
        private String url;
        private WorkerThread worker;
        private boolean useRamCache = true;
        private boolean useDiskCache = true;
        private long diskCacheTime = 0;
        private long reqTime = System.currentTimeMillis();
        private ArrayList<BitmapCallback> callbacks = new ArrayList<>();

        /* JADX INFO: Access modifiers changed from: private */
        public void throwComplete(Bitmap bitmap) {
            Iterator<BitmapCallback> it = this.callbacks.iterator();
            while (it.hasNext()) {
                it.next().onImageGot(this.url, bitmap);
            }
            this.callbacks.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void throwError() {
            Iterator<BitmapCallback> it = this.callbacks.iterator();
            while (it.hasNext()) {
                it.next().onImageGot(this.url, null);
            }
            this.callbacks.clear();
        }

        public String toString() {
            return "url=" + this.url + "time=" + this.reqTime + "worker=" + this.worker.getName() + " (" + this.worker.getId() + "";
        }
    }

    public static class ManagerThread implements Handler.Callback {
        private Handler handler;

        public ManagerThread() {
            Handler handlerNewHandler = MobHandlerThread.newHandler(new Runnable() { // from class: com.mob.tools.gui.BitmapProcessor.ManagerThread.1
                @Override // java.lang.Runnable
                public void run() {
                    int i = 0;
                    while (i < BitmapProcessor.workerList.length) {
                        if (BitmapProcessor.workerList[i] == null) {
                            BitmapProcessor.workerList[i] = new WorkerThread();
                            BitmapProcessor.workerList[i].setName("worker " + i);
                            BitmapProcessor.workerList[i].localType = i == 0;
                            BitmapProcessor.workerList[i].start();
                        }
                        i++;
                    }
                }
            }, this);
            this.handler = handlerNewHandler;
            handlerNewHandler.sendEmptyMessageDelayed(1, 20000L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (BitmapProcessor.cachePool != null) {
                BitmapProcessor.cachePool.trimBeforeTime(System.currentTimeMillis() - 60000);
            }
            int size = BitmapProcessor.cachePool == null ? 0 : BitmapProcessor.cachePool.size();
            MobLog.getInstance().d(">>>> BitmapProcessor.cachePool: " + size, new Object[0]);
            int size2 = BitmapProcessor.reqList == null ? 0 : BitmapProcessor.reqList.size();
            MobLog.getInstance().d(">>>> BitmapProcessor.reqList: " + size2, new Object[0]);
            if (BitmapProcessor.work) {
                this.handler.sendEmptyMessageDelayed(1, 20000L);
            }
            return false;
        }

        public void quit() {
            this.handler.removeMessages(1);
            this.handler.getLooper().quit();
            for (int i = 0; i < BitmapProcessor.workerList.length; i++) {
                if (BitmapProcessor.workerList[i] != null) {
                    BitmapProcessor.workerList[i].interrupt();
                    BitmapProcessor.workerList[i] = null;
                }
            }
        }
    }

    public static class PatchInputStream extends FilterInputStream {
        public InputStream in;

        public PatchInputStream(InputStream inputStream) {
            super(inputStream);
            this.in = inputStream;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long j2 = 0;
            while (j2 < j) {
                long jSkip = this.in.skip(j - j2);
                if (jSkip == 0) {
                    break;
                }
                j2 += jSkip;
            }
            return j2;
        }
    }

    public static class WorkerThread extends Thread {
        private ImageReq curReq;
        private boolean localType;

        private WorkerThread() {
        }

        private void doLocalTask() throws Throwable {
            Bitmap bitmap;
            ImageReq imageReq;
            SoftReference softReference;
            synchronized (BitmapProcessor.reqList) {
                bitmap = null;
                imageReq = BitmapProcessor.reqList.size() > 0 ? (ImageReq) BitmapProcessor.reqList.remove(0) : null;
            }
            if (imageReq == null) {
                try {
                    Thread.sleep(30L);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            if (imageReq.useRamCache && (softReference = (SoftReference) BitmapProcessor.cachePool.get(BitmapProcessor.getCacheKey(imageReq.url, imageReq.bitmapDesiredOptions))) != null) {
                bitmap = (Bitmap) softReference.get();
            }
            if (bitmap != null) {
                this.curReq = imageReq;
                imageReq.worker = this;
                imageReq.throwComplete(bitmap);
            } else {
                if (imageReq.useDiskCache && BitmapProcessor.cacheDir != null && new File(BitmapProcessor.cacheDir, Data.MD5(imageReq.url)).exists()) {
                    doTask(imageReq);
                    return;
                }
                synchronized (BitmapProcessor.reqList) {
                    if (BitmapProcessor.netReqTPS.size() > 100) {
                        synchronized (BitmapProcessor.reqList) {
                            while (BitmapProcessor.reqList.size() > 0) {
                                BitmapProcessor.reqList.remove(0);
                            }
                        }
                        BitmapProcessor.netReqTPS.remove(0);
                    }
                }
                BitmapProcessor.netReqTPS.add(imageReq);
            }
        }

        private void doNetworkTask() throws Throwable {
            Bitmap bitmap;
            ImageReq imageReq;
            SoftReference softReference;
            synchronized (BitmapProcessor.netReqTPS) {
                bitmap = null;
                imageReq = BitmapProcessor.netReqTPS.size() > 0 ? (ImageReq) BitmapProcessor.netReqTPS.remove(0) : null;
            }
            if (imageReq == null) {
                synchronized (BitmapProcessor.reqList) {
                    if (BitmapProcessor.reqList.size() > 0) {
                        imageReq = (ImageReq) BitmapProcessor.reqList.remove(0);
                    }
                }
            }
            if (imageReq == null) {
                try {
                    Thread.sleep(30L);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            if (imageReq.useRamCache && (softReference = (SoftReference) BitmapProcessor.cachePool.get(BitmapProcessor.getCacheKey(imageReq.url, imageReq.bitmapDesiredOptions))) != null) {
                bitmap = (Bitmap) softReference.get();
            }
            if (bitmap == null) {
                doTask(imageReq);
                return;
            }
            this.curReq = imageReq;
            imageReq.worker = this;
            imageReq.throwComplete(bitmap);
        }

        private void doTask(final ImageReq imageReq) throws Throwable {
            try {
                this.curReq = imageReq;
                imageReq.worker = this;
                final String strMD5 = Data.MD5(imageReq.url);
                File file = new File(BitmapProcessor.cacheDir, strMD5);
                if (imageReq.useDiskCache && imageReq.diskCacheTime > 0 && file.exists()) {
                    if (file.lastModified() + imageReq.diskCacheTime < System.currentTimeMillis()) {
                        file.delete();
                    }
                }
                if (!imageReq.useDiskCache || BitmapProcessor.cacheDir == null || !file.exists()) {
                    new NetworkHelper().rawGet(imageReq.url, new RawNetworkCallback() { // from class: com.mob.tools.gui.BitmapProcessor.WorkerThread.1
                        @Override // com.mob.tools.network.RawNetworkCallback
                        public void onResponse(InputStream inputStream) throws Throwable {
                            Bitmap bitmap;
                            PatchInputStream patchInputStream = new PatchInputStream(inputStream);
                            if (BitmapProcessor.cacheDir != null) {
                                File file2 = new File(BitmapProcessor.cacheDir, strMD5);
                                WorkerThread.this.saveFile(patchInputStream, file2);
                                bitmap = (imageReq.bitmapDesiredOptions == null || imageReq.bitmapDesiredOptions.equals("")) ? BitmapHelper.getBitmap(file2, 1) : BitmapHelper.getBitmapByCompressQuality(file2.getAbsolutePath(), imageReq.bitmapDesiredOptions.desiredWidth, imageReq.bitmapDesiredOptions.desiredHeight, imageReq.bitmapDesiredOptions.quality, imageReq.bitmapDesiredOptions.maxBytes);
                                if (!imageReq.useDiskCache) {
                                    file2.delete();
                                }
                            } else {
                                bitmap = BitmapHelper.getBitmap(patchInputStream, 1);
                            }
                            if (bitmap == null || bitmap.isRecycled()) {
                                imageReq.throwError();
                            } else {
                                if (imageReq.useRamCache) {
                                    BitmapProcessor.cachePool.put(BitmapProcessor.getCacheKey(imageReq.url, imageReq.bitmapDesiredOptions), new SoftReference(bitmap));
                                }
                                imageReq.throwComplete(bitmap);
                            }
                            WorkerThread.this.curReq = null;
                        }
                    }, BitmapProcessor.timeout);
                    return;
                }
                Bitmap bitmap = (imageReq.bitmapDesiredOptions == null || imageReq.bitmapDesiredOptions.equals("")) ? BitmapHelper.getBitmap(file.getAbsolutePath()) : BitmapHelper.getBitmapByCompressQuality(new File(BitmapProcessor.cacheDir, strMD5).getAbsolutePath(), imageReq.bitmapDesiredOptions.desiredWidth, imageReq.bitmapDesiredOptions.desiredHeight, imageReq.bitmapDesiredOptions.quality, imageReq.bitmapDesiredOptions.maxBytes);
                if (bitmap != null) {
                    if (imageReq.useRamCache) {
                        BitmapProcessor.cachePool.put(BitmapProcessor.getCacheKey(imageReq.url, imageReq.bitmapDesiredOptions), new SoftReference(bitmap));
                    }
                    imageReq.throwComplete(bitmap);
                } else {
                    imageReq.throwError();
                }
                this.curReq = null;
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
                imageReq.throwError();
                this.curReq = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void saveFile(InputStream inputStream, File file) {
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable unused) {
                }
                try {
                    byte[] bArr = new byte[256];
                    int i = inputStream.read(bArr);
                    while (i > 0) {
                        fileOutputStream.write(bArr, 0, i);
                        i = inputStream.read(bArr);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                    fileOutputStream2 = fileOutputStream;
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                        fileOutputStream2.close();
                        inputStream.close();
                    } catch (Throwable th) {
                        try {
                            fileOutputStream2.close();
                            inputStream.close();
                        } catch (Throwable unused3) {
                        }
                        throw th;
                    }
                }
                inputStream.close();
            } catch (Throwable unused4) {
            }
        }

        @Override // java.lang.Thread
        public void interrupt() {
            try {
                super.interrupt();
            } catch (Throwable unused) {
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (BitmapProcessor.work) {
                try {
                    if (this.localType) {
                        doLocalTask();
                    } else {
                        doNetworkTask();
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().w(th);
                }
            }
        }
    }

    static {
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        timeout = networkTimeOut;
        networkTimeOut.connectionTimeout = 5000;
        networkTimeOut.readTimout = 20000 - 5000;
        reqList = new ArrayList<>();
        netReqTPS = new ArrayList<>();
        workerList = new WorkerThread[3];
        cachePool = new CachePoolInner<>(50);
    }

    public static void deleteCacheDir(boolean z) {
        if (z) {
            deleteCacheDir();
        } else {
            new Thread() { // from class: com.mob.tools.gui.BitmapProcessor.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    BitmapProcessor.deleteCacheDir();
                }
            }.start();
        }
    }

    public static void deleteCachedFile(String str, BitmapDesiredOptions bitmapDesiredOptions) {
        removeBitmapFromRamCache(str, bitmapDesiredOptions);
        try {
            new File(cacheDir, Data.MD5(str)).delete();
        } catch (Throwable unused) {
        }
    }

    public static Bitmap getBitmapFromCache(String str) {
        return getBitmapFromCache(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getCacheKey(String str, BitmapDesiredOptions bitmapDesiredOptions) {
        if (bitmapDesiredOptions == null) {
            return str;
        }
        return str + bitmapDesiredOptions.toString();
    }

    public static long getCacheSizeInByte() {
        long length = 0;
        for (File file : new File(cacheDir.getPath()).listFiles()) {
            length += file.length();
        }
        return length;
    }

    public static String getCacheSizeText() {
        float cacheSizeInByte = getCacheSizeInByte();
        if (cacheSizeInByte < 1024.0f) {
            return String.format(Locale.CHINA, "%.02f", Float.valueOf(cacheSizeInByte)) + " B";
        }
        float f = cacheSizeInByte / 1024.0f;
        if (f < 1000.0f) {
            return String.format(Locale.CHINA, "%.02f", Float.valueOf(f)) + " KB";
        }
        return String.format(Locale.CHINA, "%.02f", Float.valueOf(f / 1204.0f)) + " MB";
    }

    public static synchronized void prepare(Context context) {
        cacheDir = new File(ResHelper.getImageCachePath(context));
    }

    public static synchronized void process(String str, BitmapCallback bitmapCallback) {
        process(str, null, bitmapCallback);
    }

    public static void removeBitmapFromRamCache(String str, BitmapDesiredOptions bitmapDesiredOptions) {
        CachePoolInner<String, SoftReference<Bitmap>> cachePoolInner = cachePool;
        if (cachePoolInner != null) {
            cachePoolInner.put(getCacheKey(str, bitmapDesiredOptions), null);
        }
    }

    public static synchronized void start() {
        if (!work) {
            work = true;
            manager = new ManagerThread();
        }
    }

    public static synchronized void stop() {
        if (work) {
            work = false;
            synchronized (reqList) {
                reqList.clear();
                cachePool.clear();
            }
            manager.quit();
        }
    }

    public static Bitmap getBitmapFromCache(String str, BitmapDesiredOptions bitmapDesiredOptions) {
        CachePoolInner<String, SoftReference<Bitmap>> cachePoolInner = cachePool;
        if (cachePoolInner == null || str == null || cachePoolInner.get(getCacheKey(str, bitmapDesiredOptions)) == null) {
            return null;
        }
        return cachePool.get(getCacheKey(str, bitmapDesiredOptions)).get();
    }

    public static synchronized void process(String str, BitmapDesiredOptions bitmapDesiredOptions, BitmapCallback bitmapCallback) {
        process(str, bitmapDesiredOptions, true, bitmapCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void deleteCacheDir() {
        File file = new File(cacheDir.getPath());
        if (file.isDirectory()) {
            for (String str : file.list()) {
                new File(file, str).delete();
            }
        }
    }

    public static synchronized void process(String str, BitmapDesiredOptions bitmapDesiredOptions, boolean z, BitmapCallback bitmapCallback) {
        process(str, bitmapDesiredOptions, z, true, bitmapCallback);
    }

    public static synchronized void process(String str, BitmapDesiredOptions bitmapDesiredOptions, boolean z, boolean z2, BitmapCallback bitmapCallback) {
        process(str, bitmapDesiredOptions, z, z2, 0L, bitmapCallback);
    }

    public static synchronized void process(String str, BitmapDesiredOptions bitmapDesiredOptions, boolean z, boolean z2, long j, BitmapCallback bitmapCallback) {
        if (str == null) {
            return;
        }
        synchronized (reqList) {
            int size = reqList.size();
            for (int i = 0; i < size; i++) {
                ImageReq imageReq = reqList.get(i);
                boolean zEquals = imageReq.url.equals(str);
                boolean z3 = (imageReq.bitmapDesiredOptions == null && bitmapDesiredOptions == null) || (imageReq.bitmapDesiredOptions != null && imageReq.bitmapDesiredOptions.equals(bitmapDesiredOptions));
                if (zEquals && z3) {
                    if (bitmapCallback != null && imageReq.callbacks.indexOf(bitmapCallback) == -1) {
                        imageReq.callbacks.add(bitmapCallback);
                    }
                    start();
                    return;
                }
            }
            ImageReq imageReq2 = new ImageReq();
            imageReq2.url = str;
            imageReq2.bitmapDesiredOptions = bitmapDesiredOptions;
            imageReq2.useRamCache = z;
            imageReq2.diskCacheTime = j;
            imageReq2.useDiskCache = z2;
            if (bitmapCallback != null) {
                imageReq2.callbacks.add(bitmapCallback);
            }
            synchronized (reqList) {
                reqList.add(imageReq2);
                if (reqList.size() > 120) {
                    while (reqList.size() > 100) {
                        reqList.remove(0);
                    }
                }
            }
            start();
        }
    }
}
