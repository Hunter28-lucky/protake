package com.mob.tools.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Point;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mob.MobSDK;
import com.mob.commons.C5340r;
import com.mob.commons.j;
import com.mob.tools.MobLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DH;
import com.umeng.analytics.pro.aq;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public class ResHelper implements PublicMemberKeeper {
    private static float a;
    private static int b;
    private static Uri c;

    public static void clearCache(Context context) throws Throwable {
        deleteFileAndFolder(new File(getCachePath(context, null)));
    }

    public static void closeIOs(Closeable... closeableArr) {
        if (closeableArr == null || closeableArr.length <= 0) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
            }
        }
    }

    public static boolean copyFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str).exists()) {
            return false;
        }
        try {
            copyFile(new FileInputStream(str), new FileOutputStream(str2));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Deprecated
    public static long dateStrToLong(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").parse(str, new ParsePosition(0)).getTime();
    }

    @Deprecated
    public static long dateToLong(String str) {
        try {
            Date date = new Date(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.getTimeInMillis();
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return 0L;
        }
    }

    @Deprecated
    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length < 2 || strArrSplit[1] == null) {
                    bundle.putString(URLDecoder.decode(strArrSplit[0]), "");
                } else {
                    bundle.putString(URLDecoder.decode(strArrSplit[0]), URLDecoder.decode(strArrSplit[1]));
                }
            }
        }
        return bundle;
    }

    public static void deleteFileAndFolder(File file) throws Throwable {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            file.delete();
            return;
        }
        for (String str : list) {
            File file2 = new File(file, str);
            if (file2.isDirectory()) {
                deleteFileAndFolder(file2);
            } else {
                file2.delete();
            }
        }
        file.delete();
    }

    public static int designToDevice(Context context, int i, int i2) {
        if (b == 0) {
            int[] screenSize = getScreenSize(context);
            int i3 = screenSize[0];
            int i4 = screenSize[1];
            if (i3 >= i4) {
                i3 = i4;
            }
            b = i3;
        }
        return (int) (((i2 * b) / i) + 0.5f);
    }

    public static int dipToPx(Context context, int i) {
        if (a <= 0.0f) {
            a = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((i * a) + 0.5f);
    }

    @Deprecated
    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                obj = "";
            }
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(Data.urlEncode(str) + "=" + Data.urlEncode(String.valueOf(obj)));
        }
        return sb.toString();
    }

    public static <T> T forceCast(Object obj) {
        return (T) forceCast(obj, null);
    }

    public static int getAnimRes(Context context, String str) {
        return getResId(context, "anim", str);
    }

    public static int getBitmapRes(Context context, String str) {
        int resId = getResId(context, "drawable", str);
        return resId <= 0 ? getResId(context, "mipmap", str) : resId;
    }

    public static String getCachePath(Context context, String str) {
        String str2 = context.getFilesDir().getAbsolutePath() + j.a("001e") + "MobSDK" + j.a("007e bebdbeBage");
        try {
            String sandboxPath = DH.SyncMtd.getSandboxPath();
            if (sandboxPath != null) {
                str2 = sandboxPath + j.a("001e") + "MobSDK" + j.a("001e") + DH.SyncMtd.getPackageName() + j.a("007eKbebdbeAage");
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + str + j.a("001e");
        }
        File file = new File(str2);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return str2;
    }

    public static String getCacheRoot(Context context) {
        return getCacheRoot(context, false);
    }

    public static File getCacheRootFile(Context context, String str) {
        try {
            String cacheRoot = getCacheRoot(context);
            if (cacheRoot == null) {
                return null;
            }
            File file = new File(cacheRoot, str);
            if (!file.getParentFile().exists() || !file.getParentFile().isDirectory()) {
                file.getParentFile().delete();
                file.getParentFile().mkdirs();
            }
            return file;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static int getColorRes(Context context, String str) {
        return getResId(context, TypedValues.Custom.S_COLOR, str);
    }

    public static String getDataCache(Context context) {
        String str = context.getFilesDir().getAbsolutePath() + j.a("001e") + "MobSDK";
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        return str;
    }

    public static File getDataCacheFile(Context context, String str) {
        return getDataCacheFile(context, str, false);
    }

    public static float getDensity(Context context) {
        if (a <= 0.0f) {
            a = context.getResources().getDisplayMetrics().density;
        }
        return a;
    }

    public static int getDensityDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static float[] getDensityXYDpi(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new float[]{displayMetrics.xdpi, displayMetrics.ydpi};
    }

    @Deprecated
    public static long getFileSize(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return getFileSize(new File(str));
    }

    public static int getIdRes(Context context, String str) {
        return getResId(context, j.a("0027bcBf"), str);
    }

    public static String getImageCachePath(Context context) {
        return getCachePath(context, "images");
    }

    public static int getLayoutRes(Context context, String str) {
        return getResId(context, j.a("006VcbbdbgcabaCb"), str);
    }

    @Deprecated
    public static synchronized Uri getMediaUri(Context context, String str, String str2) {
        Uri uri;
        final Object obj = new Object();
        c = null;
        MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{str2}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.mob.tools.utils.ResHelper.1
            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str3, Uri uri2) {
                Uri unused = ResHelper.c = uri2;
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (c == null) {
                synchronized (obj) {
                    obj.wait(10000L);
                }
            }
        } catch (Throwable unused) {
        }
        uri = c;
        c = null;
        return uri;
    }

    public static int getRawRes(Context context, String str) {
        return getResId(context, "raw", str);
    }

    public static int getResId(Context context, String str, String str2) {
        int identifier = 0;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return 0;
            }
            identifier = context.getResources().getIdentifier(str2, str, packageName);
            if (identifier <= 0) {
                identifier = context.getResources().getIdentifier(str2.toLowerCase(), str, packageName);
            }
            if (identifier <= 0) {
                MobLog.getInstance().w("failed to parse " + str + " resource \"" + str2 + "\"");
            }
        }
        return identifier;
    }

    public static int getScreenHeight(Context context) {
        return getScreenSize(context)[1];
    }

    public static int[] getScreenSize(Context context) {
        WindowManager windowManager;
        Display defaultDisplay = null;
        try {
            windowManager = (WindowManager) DH.SyncMtd.getSystemServiceSafe("window");
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            windowManager = null;
        }
        if (windowManager == null) {
            return new int[]{0, 0};
        }
        try {
            defaultDisplay = windowManager.getDefaultDisplay();
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
        if (defaultDisplay == null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
            } catch (Throwable th3) {
                MobLog.getInstance().w(th3);
                return new int[]{0, 0};
            }
        }
        try {
            Point point = new Point();
            Method method = defaultDisplay.getClass().getMethod(j.a("0119ddAgbKec+g;bdcbcfbcea;g"), Point.class);
            method.setAccessible(true);
            method.invoke(defaultDisplay, point);
            return new int[]{point.x, point.y};
        } catch (Throwable th4) {
            MobLog.getInstance().w(th4);
            return new int[]{0, 0};
        }
    }

    public static int getScreenWidth(Context context) {
        return getScreenSize(context)[0];
    }

    public static int getStringArrayRes(Context context, String str) {
        return getResId(context, "array", str);
    }

    public static int getStringRes(Context context, String str) {
        return getResId(context, TypedValues.Custom.S_STRING, str);
    }

    public static int getStyleRes(Context context, String str) {
        return getResId(context, "style", str);
    }

    public static int[] getStyleableRes(Context context, String str) {
        try {
            Object staticField = ReflectHelper.getStaticField(ReflectHelper.importClass(context.getPackageName() + ".R$styleable"), str);
            return staticField == null ? new int[0] : staticField.getClass().isArray() ? (int[]) staticField : new int[]{((Integer) staticField).intValue()};
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return new int[0];
        }
    }

    public static <T> boolean isEqual(T t, T t2) {
        return !((t == null && t2 != null) || !(t == null || t.equals(t2)));
    }

    @Deprecated
    public static int parseInt(String str) throws Throwable {
        return parseInt(str, 10);
    }

    @Deprecated
    public static long parseLong(String str) throws Throwable {
        return parseLong(str, 10);
    }

    @Deprecated
    public static Uri pathToContentUri(Context context, String str) {
        try {
            if (!DH.SyncMtd.checkPermission(j.a("040WbdbiVf.bfcabcMf.cjPcgHbfDjHbcdedebccabicjecebchdgbbebfecgebeccdchcibbcfcgdjecchfieb"))) {
                return null;
            }
            Cursor cursorQuery = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{aq.d}, "_data=? ", new String[]{str}, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                if (!new File(str).exists()) {
                    return null;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("_data", str);
                return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            }
            int i = cursorQuery.getInt(cursorQuery.getColumnIndex(aq.d));
            return Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), "" + i);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static int pxToDip(Context context, int i) {
        if (a <= 0.0f) {
            a = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((i / a) + 0.5f);
    }

    public static ArrayList<HashMap<String, String>> readArrayListFromFile(String str) {
        return readArrayListFromFile(str, false);
    }

    public static long readLongFromFile(String str) {
        Throwable th;
        DataInputStream dataInputStream;
        File dataCacheFile = getDataCacheFile(MobSDK.getContext(), str);
        if (!dataCacheFile.exists()) {
            return 0L;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(dataCacheFile));
        } catch (Throwable th2) {
            th = th2;
            dataInputStream = null;
        }
        try {
            long j = dataInputStream.readLong();
            C5340r.a(dataInputStream);
            return j;
        } catch (Throwable th3) {
            th = th3;
            try {
                MobLog.getInstance().d(th);
                C5340r.a(dataInputStream);
                return 0L;
            } catch (Throwable th4) {
                C5340r.a(dataInputStream);
                throw th4;
            }
        }
    }

    public static Object readObjectFromFile(String str) {
        File file;
        GZIPInputStream gZIPInputStream;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        if (!TextUtils.isEmpty(str)) {
            try {
                file = new File(str);
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
            if (!file.exists()) {
                file = null;
            }
            if (file != null) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        gZIPInputStream = new GZIPInputStream(fileInputStream);
                        try {
                            objectInputStream = new ObjectInputStream(gZIPInputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            objectInputStream = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        gZIPInputStream = null;
                        objectInputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    gZIPInputStream = null;
                    fileInputStream = null;
                    objectInputStream = null;
                }
                try {
                    Object object = objectInputStream.readObject();
                    objectInputStream.close();
                    closeIOs(objectInputStream, gZIPInputStream, fileInputStream);
                    return object;
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        MobLog.getInstance().d(th);
                        closeIOs(objectInputStream, gZIPInputStream, fileInputStream);
                        return null;
                    } catch (Throwable th6) {
                        closeIOs(objectInputStream, gZIPInputStream, fileInputStream);
                        throw th6;
                    }
                }
            }
        }
        return null;
    }

    public static void saveArrayListToFile(ArrayList<HashMap<String, String>> arrayList, String str) {
        saveArrayListToFile(arrayList, str, false);
    }

    public static boolean saveLongToFile(long j, String str) {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(getDataCacheFile(MobSDK.getContext(), str)));
        } catch (Throwable th) {
            th = th;
        }
        try {
            dataOutputStream.writeLong(j);
            dataOutputStream.flush();
            C5340r.a(dataOutputStream);
            return true;
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            try {
                MobLog.getInstance().d(th);
                C5340r.a(dataOutputStream2);
                return false;
            } catch (Throwable th3) {
                C5340r.a(dataOutputStream2);
                throw th3;
            }
        }
    }

    public static boolean saveObjectToFile(String str, Object obj) {
        File file;
        GZIPOutputStream gZIPOutputStream;
        ObjectOutputStream objectOutputStream;
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
                file = null;
            }
            if (obj == null) {
                return true;
            }
            if (!file.getParentFile().exists() || !file.getParentFile().isDirectory()) {
                file.getParentFile().delete();
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            if (file != null) {
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        gZIPOutputStream = new GZIPOutputStream(fileOutputStream);
                        try {
                            objectOutputStream = new ObjectOutputStream(gZIPOutputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            objectOutputStream = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        gZIPOutputStream = null;
                        objectOutputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    gZIPOutputStream = null;
                    objectOutputStream = null;
                }
                try {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    closeIOs(objectOutputStream, gZIPOutputStream, fileOutputStream);
                    return true;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        MobLog.getInstance().d(th);
                        closeIOs(objectOutputStream, gZIPOutputStream, fileOutputStream2);
                        return false;
                    } catch (Throwable th6) {
                        closeIOs(objectOutputStream, gZIPOutputStream, fileOutputStream2);
                        throw th6;
                    }
                }
            }
        }
        return false;
    }

    @Deprecated
    public static long strToDate(String str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str, new ParsePosition(0)).getTime();
    }

    @Deprecated
    public static Bundle urlToBundle(String str) {
        String str2;
        int iIndexOf = str.indexOf("://");
        if (iIndexOf >= 0) {
            str2 = j.a("007abbcdee") + str.substring(iIndexOf + 1);
        } else {
            str2 = j.a("007abbcdee") + str;
        }
        try {
            URL url = new URL(str2);
            Bundle bundleDecodeUrl = decodeUrl(url.getQuery());
            bundleDecodeUrl.putAll(decodeUrl(url.getRef()));
            return bundleDecodeUrl;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return new Bundle();
        }
    }

    @Deprecated
    public static Uri videoPathToContentUri(Context context, String str) {
        try {
            if (!DH.SyncMtd.checkPermission(j.a("040ObdbiDf-bfcabc>f!cjCcgIbf<jCbcdedebccabicjecebchdgbbebfecgebeccdchcibbcfcgdjecchfieb"))) {
                return null;
            }
            Cursor cursorQuery = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{aq.d}, "_data=? ", new String[]{str}, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                if (!new File(str).exists()) {
                    return null;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("_data", str);
                return context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
            }
            int i = cursorQuery.getInt(cursorQuery.getColumnIndex(aq.d));
            return Uri.withAppendedPath(Uri.parse("content://media/external/video/media"), "" + i);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T forceCast(Object obj, T t) {
        if (obj != 0) {
            try {
                if (obj instanceof Integer) {
                    return t instanceof Long ? (T) Long.valueOf(((Integer) obj).intValue()) : obj;
                }
                return obj;
            } catch (Throwable unused) {
            }
        }
        return t;
    }

    public static String getCacheRoot(Context context, boolean z) {
        String dataCache;
        if (z) {
            dataCache = null;
        } else {
            try {
                dataCache = getDataCache(context);
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
                return null;
            }
        }
        String sandboxPath = DH.SyncMtd.getSandboxPath();
        if (sandboxPath != null) {
            dataCache = sandboxPath + j.a("001e") + "MobSDK";
        }
        if (TextUtils.isEmpty(dataCache)) {
            return null;
        }
        File file = new File(dataCache);
        if (!file.exists() || !file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        return dataCache;
    }

    public static File getDataCacheFile(Context context, String str, boolean z) {
        File file = new File(getDataCache(context), str);
        if (z && !file.exists()) {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        }
        return file;
    }

    @Deprecated
    public static int parseInt(String str, int i) throws Throwable {
        return Integer.parseInt(str, i);
    }

    @Deprecated
    public static long parseLong(String str, int i) throws Throwable {
        return Long.parseLong(str, i);
    }

    public static ArrayList<HashMap<String, String>> readArrayListFromFile(String str, boolean z) {
        ArrayList<HashMap<String, String>> arrayList;
        BufferedReader bufferedReader;
        File dataCacheFile = getDataCacheFile(MobSDK.getContext(), str, true);
        if (dataCacheFile.exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                arrayList = new ArrayList<>();
                bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(dataCacheFile)), "utf-8"));
            } catch (Throwable th) {
                th = th;
            }
            try {
                String line = bufferedReader.readLine();
                while (line != null) {
                    if (z) {
                        line = new String(Base64.decode(line, 2), "utf-8");
                    }
                    arrayList.add(HashonHelper.fromJson(line));
                    line = bufferedReader.readLine();
                }
                closeIOs(bufferedReader);
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                try {
                    MobLog.getInstance().d(th);
                    closeIOs(bufferedReader2);
                    return new ArrayList<>();
                } catch (Throwable th3) {
                    closeIOs(bufferedReader2);
                    throw th3;
                }
            }
        }
        return new ArrayList<>();
    }

    public static void saveArrayListToFile(ArrayList<HashMap<String, String>> arrayList, String str, boolean z) {
        OutputStreamWriter outputStreamWriter;
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            outputStreamWriter = new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(getDataCacheFile(MobSDK.getContext(), str, true))), "utf-8");
        } catch (Throwable th) {
            th = th;
        }
        try {
            Iterator<HashMap<String, String>> it = arrayList.iterator();
            while (it.hasNext()) {
                String strFromHashMap = HashonHelper.fromHashMap(it.next());
                if (z) {
                    strFromHashMap = new String(Base64.encode(strFromHashMap.getBytes("utf-8"), 2), "utf-8");
                }
                outputStreamWriter.append((CharSequence) strFromHashMap).append('\n');
            }
            closeIOs(outputStreamWriter);
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter2 = outputStreamWriter;
            try {
                MobLog.getInstance().d(th);
                closeIOs(outputStreamWriter2);
            } catch (Throwable th3) {
                closeIOs(outputStreamWriter2);
                throw th3;
            }
        }
    }

    @Deprecated
    public static long getFileSize(File file) throws Throwable {
        if (!file.exists()) {
            return 0L;
        }
        if (file.isDirectory()) {
            int fileSize = 0;
            for (String str : file.list()) {
                fileSize = (int) (fileSize + getFileSize(new File(file, str)));
            }
            return fileSize;
        }
        return file.length();
    }

    public static int designToDevice(Context context, float f, int i) {
        if (a <= 0.0f) {
            a = context.getResources().getDisplayMetrics().density;
        }
        return (int) (((i * a) / f) + 0.5f);
    }

    public static void copyFile(FileInputStream fileInputStream, FileOutputStream fileOutputStream) throws Throwable {
        byte[] bArr = new byte[65536];
        int i = fileInputStream.read(bArr);
        while (i > 0) {
            fileOutputStream.write(bArr, 0, i);
            i = fileInputStream.read(bArr);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Deprecated
    public static String encodeUrl(ArrayList<KVPair<String>> arrayList) {
        if (arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Iterator<KVPair<String>> it = arrayList.iterator();
        while (it.hasNext()) {
            KVPair<String> next = it.next();
            if (i > 0) {
                sb.append('&');
            }
            String str = next.name;
            String str2 = next.value;
            if (str != null) {
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(Data.urlEncode(str) + "=" + Data.urlEncode(str2));
                i++;
            }
        }
        return sb.toString();
    }
}
