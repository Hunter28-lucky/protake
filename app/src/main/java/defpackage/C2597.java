package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.view.Surface;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.videotools.CameraView;
import com.google.android.gms.common.util.GmsVersion;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.AbstractC2341;
import defpackage.C5220;
import defpackage.q5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: CameraDirectVideoMuxer.java */
/* renamed from: ɩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2597 {

    /* renamed from: ޑ, reason: contains not printable characters */
    public static final String f9661 = "ɩ";

    /* renamed from: ޒ, reason: contains not printable characters */
    public static int f9662 = 30;

    /* renamed from: ޓ, reason: contains not printable characters */
    public static int f9663 = 30;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public a2 f9665;

    /* renamed from: ԩ, reason: contains not printable characters */
    public C5220.C5226 f9666;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f9667;

    /* renamed from: ԫ, reason: contains not printable characters */
    public long f9668;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f9669;

    /* renamed from: ԭ, reason: contains not printable characters */
    public long f9670;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public long f9671;

    /* renamed from: ԯ, reason: contains not printable characters */
    public String f9672;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f9673;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f9674;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f9675;

    /* renamed from: ׯ, reason: contains not printable characters */
    public long f9676;

    /* renamed from: ؠ, reason: contains not printable characters */
    public MediaRecorder f9677;

    /* renamed from: ހ, reason: contains not printable characters */
    public CameraView.InterfaceC0828 f9678;

    /* renamed from: ށ, reason: contains not printable characters */
    public q5.InterfaceC2244 f9679;

    /* renamed from: ނ, reason: contains not printable characters */
    public C5220.InterfaceC5224 f9680;

    /* renamed from: ބ, reason: contains not printable characters */
    public AudioManager f9682;

    /* renamed from: ކ, reason: contains not printable characters */
    public boolean f9684;

    /* renamed from: ވ, reason: contains not printable characters */
    public HandlerThread f9686;

    /* renamed from: މ, reason: contains not printable characters */
    public Handler f9687;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f9690;

    /* renamed from: ލ, reason: contains not printable characters */
    public int f9691;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f9664 = false;

    /* renamed from: ރ, reason: contains not printable characters */
    public C5220.InterfaceC5225 f9681 = null;

    /* renamed from: ޅ, reason: contains not printable characters */
    public boolean f9683 = false;

    /* renamed from: އ, reason: contains not printable characters */
    public final Object f9685 = new Object();

    /* renamed from: ފ, reason: contains not printable characters */
    public int f9688 = -1;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f9689 = -1;

    /* renamed from: ގ, reason: contains not printable characters */
    public long f9692 = -1;

    /* renamed from: ޏ, reason: contains not printable characters */
    public long f9693 = -1;

    /* renamed from: ސ, reason: contains not printable characters */
    public Uri f9694 = null;

    /* compiled from: CameraDirectVideoMuxer.java */
    /* renamed from: ɩ$Ϳ, reason: contains not printable characters */
    public class RunnableC2598 implements Runnable {
        public RunnableC2598() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            C2597 c2597 = C2597.this;
            c2597.m9526(c2597.f9665, C2597.this.f9666);
        }
    }

    /* compiled from: CameraDirectVideoMuxer.java */
    /* renamed from: ɩ$Ԩ, reason: contains not printable characters */
    public class RunnableC2599 implements Runnable {
        public RunnableC2599() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2597.this.m9530();
            C2597.this.m9518();
        }
    }

    /* compiled from: CameraDirectVideoMuxer.java */
    /* renamed from: ɩ$Ԫ, reason: contains not printable characters */
    public class RunnableC2600 implements Runnable {
        public RunnableC2600() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            C2597.this.m9523();
        }
    }

    /* compiled from: CameraDirectVideoMuxer.java */
    /* renamed from: ɩ$Ԭ, reason: contains not printable characters */
    public class RunnableC2601 implements Runnable {
        public RunnableC2601() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            C2597.this.m9517();
        }
    }

    /* compiled from: CameraDirectVideoMuxer.java */
    /* renamed from: ɩ$Ԯ, reason: contains not printable characters */
    public class RunnableC2602 implements Runnable {
        public RunnableC2602() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            C2597.this.m9517();
        }
    }

    /* compiled from: CameraDirectVideoMuxer.java */
    /* renamed from: ɩ$ՠ, reason: contains not printable characters */
    public class RunnableC2603 implements Runnable {
        public RunnableC2603() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException, InterruptedException {
            C2597.this.m9524(false);
        }
    }

    /* compiled from: CameraDirectVideoMuxer.java */
    /* renamed from: ɩ$ֈ, reason: contains not printable characters */
    public class RunnableC2604 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C5220.C5226 f9701;

        public RunnableC2604(C5220.C5226 c5226) {
            this.f9701 = c5226;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException, InterruptedException {
            C2597.this.f9673 = false;
            if (C2597.this.f9664) {
                C4638.m14101(C2597.f9661, String.format("DirectVideoMuxer reConfigVideoMuxer ! : %s ", "!"));
            }
            try {
                C2597.this.f9677.stop();
                C2597.this.f9677.setOnErrorListener(null);
                C2597.this.f9677.setOnInfoListener(null);
                C2597.this.f9677.reset();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            C2597.this.f9666 = this.f9701;
            C2597 c2597 = C2597.this;
            c2597.m9526(c2597.f9665, C2597.this.f9666);
        }
    }

    /* compiled from: CameraDirectVideoMuxer.java */
    /* renamed from: ɩ$֏, reason: contains not printable characters */
    public class C2605 implements MediaRecorder.OnInfoListener {
        public C2605() {
        }

        @Override // android.media.MediaRecorder.OnInfoListener
        public void onInfo(MediaRecorder mediaRecorder, int i, int i2) throws IllegalStateException, InterruptedException, IOException {
            if (C2597.this.f9664) {
                C4638.m14099(C2597.f9661, String.format("what : %s, extra : %s", Integer.valueOf(i), Integer.valueOf(i2)));
            }
            if (i == 802) {
                if (Build.VERSION.SDK_INT < 26) {
                    C2597.this.m9524(true);
                    return;
                }
                try {
                    C2597.this.f9677.setNextOutputFile(new File(C2462.m9035().m9053()));
                    return;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    C2597.this.m9524(true);
                    return;
                }
            }
            if (i == 803) {
                C2597.this.m9519();
                if (C2597.this.f9678 != null) {
                    AbstractC2341.C2344 c2344 = new AbstractC2341.C2344();
                    c2344.m8795(C2597.this.f9672);
                    c2344.m8791(true);
                    C2597.this.f9672 = C2462.m9035().m9053();
                    if (C2597.this.f9664) {
                        C4638.m14099(C2597.f9661, String.format("filePath : %s", C2597.this.f9672));
                    }
                    C2597.this.f9678.mo1360(c2344);
                }
            }
        }
    }

    /* compiled from: CameraDirectVideoMuxer.java */
    /* renamed from: ɩ$ׯ, reason: contains not printable characters */
    public class C2606 implements MediaRecorder.OnErrorListener {

        /* compiled from: CameraDirectVideoMuxer.java */
        /* renamed from: ɩ$ׯ$Ϳ, reason: contains not printable characters */
        public class RunnableC2607 implements Runnable {
            public RunnableC2607() {
            }

            @Override // java.lang.Runnable
            public void run() throws IllegalStateException, InterruptedException {
                C2597.this.m9524(true);
            }
        }

        public C2606() {
        }

        @Override // android.media.MediaRecorder.OnErrorListener
        public void onError(MediaRecorder mediaRecorder, int i, int i2) {
            if (C2597.this.f9664) {
                C4638.m14099(C2597.f9661, String.format("what : %s, extra : %s", Integer.valueOf(i), Integer.valueOf(i2)));
            }
            C2597.this.f9687.postDelayed(new RunnableC2607(), 500L);
        }
    }

    public C2597(boolean z, boolean z2, a2 a2Var, C5220.C5226 c5226) {
        this.f9674 = z;
        this.f9675 = z2;
        this.f9665 = a2Var;
        this.f9666 = c5226;
        if (a2Var == null) {
            throw new RuntimeException("config cont null");
        }
        if (this.f9677 == null) {
            this.f9677 = new MediaRecorder();
        }
        int i = a2Var.f4;
        f9662 = i;
        int i2 = a2Var.f5;
        f9663 = i2;
        int i3 = a2Var.f7;
        if (i3 != 0) {
            this.f9671 = i3;
            this.f9667 = i3;
            this.f9668 = i3 * 1000;
        } else {
            this.f9667 = 1000 / i;
            this.f9668 = 1000000 / i;
            this.f9671 = 0L;
        }
        this.f9669 = 1000 / i2;
        this.f9670 = (1000000 / i2) + 1;
        this.f9676 = this.f9668 * 1000;
        this.f9682 = (AudioManager) FilmApp.m402().getSystemService("audio");
        m9525();
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m9517() throws IllegalStateException {
        C5220.InterfaceC5224 interfaceC5224;
        if (this.f9673) {
            int maxAmplitude = this.f9677.getMaxAmplitude();
            if (this.f9664 && (interfaceC5224 = this.f9680) != null) {
                double d = maxAmplitude;
                interfaceC5224.mo1333(d, d, this.f9666.f17328 == 2);
            }
            this.f9687.postDelayed(new RunnableC2602(), 30L);
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m9518() {
        if (this.f9664) {
            C4638.m14101(f9661, "directVideoMuxer exitThread ... ");
        }
        synchronized (this.f9685) {
            HandlerThread handlerThread = this.f9686;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.f9686 = null;
            this.f9687 = null;
            this.f9684 = false;
            this.f9685.notify();
        }
        if (this.f9664) {
            C4638.m14101(f9661, "directVideoMuxer exitThread 完毕... ");
        }
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m9519() {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_pending", (Integer) 0);
            if (this.f9694 != null) {
                FilmApp.m402().getContentResolver().update(this.f9694, contentValues, null, null);
                this.f9694 = null;
            }
        }
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final int m9520() {
        int i;
        try {
            i = CamcorderProfile.get(2004).videoBitRate;
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                i = CamcorderProfile.get(6).videoBitRate;
            } catch (Exception e3) {
                e3.printStackTrace();
                i = GmsVersion.VERSION_MANCHEGO;
            }
        }
        if (this.f9664) {
            C4638.m14099(f9661, String.format("videoBitRate : %s ", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final int m9521() {
        int i;
        try {
            i = CamcorderProfile.get(2005).videoBitRate;
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                i = CamcorderProfile.get(8).videoBitRate;
            } catch (Exception e3) {
                e3.printStackTrace();
                i = GmsVersion.VERSION_MANCHEGO;
            }
        }
        if (this.f9664) {
            C4638.m14099(f9661, String.format("videoBitRate : %s ", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final int m9522() {
        int i;
        try {
            i = CamcorderProfile.get(2003).videoBitRate;
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                i = CamcorderProfile.get(5).videoBitRate;
            } catch (Exception e3) {
                e3.printStackTrace();
                i = GmsVersion.VERSION_MANCHEGO;
            }
        }
        if (this.f9664) {
            C4638.m14099(f9661, String.format("videoBitRate : %s ", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m9523() throws IllegalStateException {
        if (this.f9664) {
            C4638.m14101(f9661, String.format("DirectVideoMuxer handleStartRecording ! : %s ", "!"));
        }
        this.f9692 = System.nanoTime();
        this.f9693 = -1L;
        this.f9673 = false;
        this.f9677.start();
        this.f9673 = true;
        q5.InterfaceC2244 interfaceC2244 = this.f9679;
        if (interfaceC2244 != null) {
            interfaceC2244.mo1352();
        }
        if (this.f9674) {
            this.f9687.postDelayed(new RunnableC2601(), 100L);
        }
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m9524(boolean z) throws IllegalStateException, InterruptedException {
        this.f9673 = false;
        if (this.f9664) {
            C4638.m14101(f9661, String.format("DirectVideoMuxer handleStopRecording ! : %s ", "!"));
        }
        if (this.f9692 == -1) {
            if (this.f9664) {
                C4638.m14101(f9661, String.format("DirectVideoMuxer should not run here ! : %s ", "!"));
            }
            this.f9677.release();
            this.f9677 = null;
            if (this.f9664) {
                C4638.m14101(f9661, "mMediaRecorder 释放完毕... ");
            }
            m9519();
            boolean zM10795 = C3180.m10795(this.f9672);
            if (this.f9664) {
                C4638.m14101(f9661, String.format("DirectVideoMuxer delete file  success ? : %s ", Boolean.valueOf(zM10795)));
                return;
            }
            return;
        }
        if (this.f9693 != -1) {
            return;
        }
        this.f9693 = System.nanoTime();
        try {
            C5220.InterfaceC5224 interfaceC5224 = this.f9680;
            if (interfaceC5224 != null) {
                interfaceC5224.mo1333(-1.0d, -1.0d, this.f9666.f17328 == 2);
            }
            this.f9677.stop();
            m9519();
            if (this.f9678 != null) {
                AbstractC2341.C2344 c2344 = new AbstractC2341.C2344();
                c2344.m8795(this.f9672);
                c2344.m8791(true);
                this.f9678.mo1365(c2344);
            }
            this.f9677.setOnErrorListener(null);
            this.f9677.setOnInfoListener(null);
            this.f9677.reset();
            if (z) {
                this.f9677.release();
                this.f9677 = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (z) {
            this.f9677 = new MediaRecorder();
        }
        m9526(this.f9665, this.f9666);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m9525() {
        if (this.f9684) {
            synchronized (this.f9685) {
                try {
                    this.f9685.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        synchronized (this.f9685) {
            HandlerThread handlerThread = new HandlerThread(f9661);
            this.f9686 = handlerThread;
            handlerThread.setPriority(3);
            this.f9686.start();
            Handler handler = new Handler(this.f9686.getLooper());
            this.f9687 = handler;
            handler.post(new RunnableC2598());
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m9526(a2 a2Var, C5220.C5226 c5226) throws InterruptedException {
        this.f9688 = a2Var.f0;
        this.f9689 = a2Var.f1;
        this.f9690 = a2Var.f9;
        this.f9691 = a2Var.f10;
        this.f9672 = C2462.m9035().m9047();
        this.f9692 = -1L;
        int i = c5226.f17330 ? 6 : c5226.f17328 == 0 ? 5 : 0;
        if (this.f9682.isBluetoothScoAvailableOffCall()) {
            this.f9683 = true;
        }
        if (c5226.f17328 == 2) {
            if (this.f9683) {
                if (this.f9682.isBluetoothScoOn()) {
                    this.f9682.stopBluetoothSco();
                    if (this.f9664) {
                        C4638.m14099(f9661, "mAudioManager.stopBluetoothSco()");
                    }
                }
                if (this.f9664) {
                    C4638.m14099(f9661, "mAudioManager.startBluetoothSco()");
                }
                this.f9682.startBluetoothSco();
                int i2 = 100;
                while (!this.f9682.isBluetoothScoOn()) {
                    int i3 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    if (i3 == 50) {
                        if (this.f9664) {
                            C4638.m14101(f9661, "2startBluetoothSco");
                        }
                        this.f9682.startBluetoothSco();
                    }
                    if (this.f9664) {
                        C4638.m14101(f9661, "change BluetoothScoOn" + this.f9682.isBluetoothScoOn() + Constants.COLON_SEPARATOR + i3);
                    }
                    i2 = i3;
                }
                i = 6;
            }
        } else if (this.f9683 && this.f9682.isBluetoothScoOn()) {
            this.f9682.stopBluetoothSco();
            C4638.m14099(f9661, "mAudioManager.stopBluetoothSco()");
        }
        int i4 = a2Var.f7;
        int i5 = f9663;
        double d = i4 == 0 ? i5 : 1000.0d / i4;
        int i6 = c5226.f17326;
        int i7 = c5226.f17325;
        if (this.f9664) {
            C4638.m14099(f9661, String.format("hasAudio : %s , videoBitRate : %s , videoFrameRate : %s , captureFrameRate : %s , videoWidth : %s , videoHeight : %s  , cameraFlipped : %s , videoMime : %s , audioSource : %s , audioBitRate : %s , audioSampleRate : %s , filePath : %s ", Boolean.valueOf(this.f9674), Integer.valueOf(a2Var.f2), Integer.valueOf(i5), Double.valueOf(d), Integer.valueOf(this.f9688), Integer.valueOf(this.f9689), Boolean.valueOf(this.f9675), a2Var.f6, Integer.valueOf(i), Integer.valueOf(i6), Integer.valueOf(i7), this.f9672));
        }
        if (m9536(this.f9672, a2Var.f13 ? 0 : 270, Integer.MAX_VALUE, a2Var.f2, i5, d, this.f9688, this.f9689, this.f9675, a2Var.f6, i, i6, i7)) {
            Surface surface = this.f9677.getSurface();
            Handler handler = a2Var.f8;
            if (handler != null) {
                handler.sendMessage(handler.obtainMessage(2, surface));
            }
            if (this.f9664) {
                C4638.m14099(f9661, String.format("init Direct Video Muxer  : %s ", "success"));
            }
            C5220.InterfaceC5225 interfaceC5225 = this.f9681;
            if (interfaceC5225 != null) {
                interfaceC5225.mo1330();
            }
        }
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final ParcelFileDescriptor m9527(String str) {
        String name = new File(str).getName();
        ContentValues contentValues = new ContentValues();
        ContentResolver contentResolver = FilmApp.m402().getContentResolver();
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", (Integer) 1);
            contentValues.put("mime_type", "video/mp4");
            contentValues.put("title", name);
            contentValues.put("_display_name", name);
            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("relative_path", Environment.DIRECTORY_DCIM + "/" + C4062.f14103);
            Uri uriInsert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
            this.f9694 = uriInsert;
            try {
                return contentResolver.openFileDescriptor(uriInsert, "w");
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m9528(C5220.C5226 c5226) {
        Handler handler = this.f9687;
        if (handler == null) {
            return;
        }
        handler.post(new RunnableC2604(c5226));
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m9529() {
        Handler handler = this.f9687;
        if (handler == null) {
            return;
        }
        handler.post(new RunnableC2599());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f A[Catch: all -> 0x004f, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:8:0x000d, B:12:0x0015, B:14:0x0021, B:11:0x0012, B:15:0x0028, B:18:0x002f, B:20:0x0033, B:21:0x004b), top: B:29:0x0001, inners: #0 }] */
    /* renamed from: ސ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void m9530() {
        /*
            r10 = this;
            monitor-enter(r10)
            android.media.MediaRecorder r0 = r10.f9677     // Catch: java.lang.Throwable -> L4f
            r1 = -1
            if (r0 == 0) goto L28
            long r3 = r10.f9692     // Catch: java.lang.Throwable -> L4f
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L15
            r0.stop()     // Catch: java.lang.IllegalStateException -> L11 java.lang.Throwable -> L4f
            goto L15
        L11:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L4f
        L15:
            android.media.MediaRecorder r0 = r10.f9677     // Catch: java.lang.Throwable -> L4f
            r0.release()     // Catch: java.lang.Throwable -> L4f
            r0 = 0
            r10.f9677 = r0     // Catch: java.lang.Throwable -> L4f
            boolean r0 = r10.f9664     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L28
            java.lang.String r0 = defpackage.C2597.f9661     // Catch: java.lang.Throwable -> L4f
            java.lang.String r3 = "mMediaRecorder 释放完毕... "
            defpackage.C4638.m14101(r0, r3)     // Catch: java.lang.Throwable -> L4f
        L28:
            long r3 = r10.f9692     // Catch: java.lang.Throwable -> L4f
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L2f
            goto L4d
        L2f:
            boolean r0 = r10.f9664     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L4b
            java.lang.String r0 = defpackage.C2597.f9661     // Catch: java.lang.Throwable -> L4f
            java.lang.String r5 = "video audio mux end   need video time : %s "
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L4f
            r7 = 0
            long r8 = r10.f9693     // Catch: java.lang.Throwable -> L4f
            long r8 = r8 - r3
            java.lang.Long r3 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L4f
            r6[r7] = r3     // Catch: java.lang.Throwable -> L4f
            java.lang.String r3 = java.lang.String.format(r5, r6)     // Catch: java.lang.Throwable -> L4f
            defpackage.C4638.m14099(r0, r3)     // Catch: java.lang.Throwable -> L4f
        L4b:
            r10.f9692 = r1     // Catch: java.lang.Throwable -> L4f
        L4d:
            monitor-exit(r10)
            return
        L4f:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C2597.m9530():void");
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public C2597 m9531(C5220.InterfaceC5224 interfaceC5224) {
        this.f9680 = interfaceC5224;
        return this;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m9532(CameraView.InterfaceC0828 interfaceC0828) {
        this.f9678 = interfaceC0828;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public C2597 m9533(q5.InterfaceC2244 interfaceC2244) {
        this.f9679 = interfaceC2244;
        return this;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m9534(String str, int i, int i2, int i3, double d, int i4, int i5, boolean z, String str2, int i6, int i7, int i8) throws IllegalStateException, IllegalArgumentException {
        AudioDeviceInfo audioDeviceInfo;
        int i9 = i2;
        this.f9677.reset();
        this.f9677.setOnInfoListener(new C2605());
        this.f9677.setOnErrorListener(new C2606());
        if (this.f9674) {
            this.f9677.setAudioSource(i6);
        }
        this.f9677.setVideoSource(2);
        this.f9677.setOutputFormat(2);
        ParcelFileDescriptor parcelFileDescriptorM9527 = m9527(str);
        if (parcelFileDescriptorM9527 != null) {
            this.f9677.setOutputFile(parcelFileDescriptorM9527.getFileDescriptor());
        } else {
            this.f9677.setOutputFile(str);
        }
        int i10 = 0;
        try {
            this.f9677.setVideoEncodingBitRate(i9);
        } catch (Exception e2) {
            e2.printStackTrace();
            int i11 = this.f9689;
            int iM9521 = i11 > 1080 ? m9521() : i11 > 720 ? m9520() : m9522();
            if (this.f9664) {
                C4638.m14099(f9661, String.format("videoBitRate : %s ", Integer.valueOf(iM9521)));
            }
            if (i9 > iM9521) {
                i9 = iM9521;
            }
            this.f9677.setVideoEncodingBitRate(i9);
        }
        this.f9677.setVideoSize(i4, i5);
        if (!"video/avc".equals(str2) && "video/hevc".equals(str2) && Build.VERSION.SDK_INT >= 24) {
            this.f9677.setVideoEncoder(5);
        } else {
            this.f9677.setVideoEncoder(2);
        }
        if (i3 == d) {
            this.f9677.setVideoFrameRate(i3);
        } else {
            this.f9677.setVideoFrameRate(i3);
            this.f9677.setCaptureRate(d);
        }
        if (this.f9674) {
            this.f9677.setAudioEncoder(3);
            this.f9677.setAudioEncodingBitRate(i7);
            this.f9677.setAudioChannels(2);
            this.f9677.setAudioSamplingRate(i8);
            if (Build.VERSION.SDK_INT >= 28 && (audioDeviceInfo = C5075.m14899().m14901().get(this.f9666.f17328)) != null) {
                try {
                    this.f9677.setPreferredDevice(audioDeviceInfo);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        if (z) {
            if (i == 0 || i == 180) {
                i10 = 270;
            }
        } else if (i == 0 || i == 180) {
            i10 = 90;
        } else if (i == 90) {
            i10 = 180;
        }
        this.f9677.setOrientationHint(i10);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f9677.setMaxFileSize(-1L);
        } else {
            this.f9677.setMaxFileSize(4080218931L);
        }
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public C2597 m9535(C5220.InterfaceC5225 interfaceC5225) {
        this.f9681 = interfaceC5225;
        return this;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final boolean m9536(String str, int i, int i2, int i3, int i4, double d, int i5, int i6, boolean z, String str2, int i7, int i8, int i9) throws IllegalStateException, InterruptedException, IOException {
        try {
            m9534(str, i, i3, i4, d, i5, i6, z, str2, i7, i8, i9);
            this.f9677.prepare();
            try {
                Thread.sleep(200L);
                return true;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                return true;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            if (this.f9664) {
                C4638.m14101(f9661, String.format("MediaRecorder init fail : %s ", e3.getMessage()));
            }
            int i10 = this.f9689;
            int iM9521 = i10 > 1080 ? m9521() : i10 > 720 ? m9520() : m9522();
            if (this.f9664) {
                C4638.m14099(f9661, String.format("videoBitRate : %s ", Integer.valueOf(iM9521)));
            }
            try {
                m9534(str, i, i3 > iM9521 ? iM9521 : i3, i4, d, i5, i6, z, str2, i7, i8, i9);
                this.f9677.prepare();
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
                return true;
            } catch (Exception unused) {
                CameraView.InterfaceC0828 interfaceC0828 = this.f9678;
                if (interfaceC0828 != null) {
                    interfaceC0828.mo1364();
                }
                return false;
            }
        }
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public void m9537() {
        this.f9687.post(new RunnableC2600());
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public void m9538() {
        Handler handler = this.f9687;
        if (handler == null) {
            return;
        }
        handler.post(new RunnableC2603());
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public void m9539() {
        HandlerThread handlerThread;
        if (this.f9687 == null || (handlerThread = this.f9686) == null) {
            return;
        }
        try {
            handlerThread.join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }
}
