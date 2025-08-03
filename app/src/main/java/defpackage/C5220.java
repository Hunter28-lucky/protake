package defpackage;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.HandlerThread;
import com.blink.academy.film.FilmApp;
import java.util.Locale;

/* compiled from: FilmAudioRecord.java */
/* renamed from: Ⴗ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5220 {

    /* renamed from: ޑ, reason: contains not printable characters */
    public static final String f17291 = "Ⴗ";

    /* renamed from: Ԩ, reason: contains not printable characters */
    public HandlerThread f17293;

    /* renamed from: ԩ, reason: contains not printable characters */
    public Handler f17294;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f17296;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f17297;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f17298;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f17299;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f17300;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f17301;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f17302;

    /* renamed from: ހ, reason: contains not printable characters */
    public C5226 f17306;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f17309;

    /* renamed from: ބ, reason: contains not printable characters */
    public boolean f17310;

    /* renamed from: ޅ, reason: contains not printable characters */
    public short[] f17311;

    /* renamed from: ކ, reason: contains not printable characters */
    public long f17312;

    /* renamed from: އ, reason: contains not printable characters */
    public boolean f17313;

    /* renamed from: ޏ, reason: contains not printable characters */
    public InterfaceC5223 f17321;

    /* renamed from: ސ, reason: contains not printable characters */
    public InterfaceC5224 f17322;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f17292 = false;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public AudioRecord f17295 = null;

    /* renamed from: ֏, reason: contains not printable characters */
    public float f17303 = 1.0f;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f17304 = 0;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f17305 = false;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f17307 = false;

    /* renamed from: ނ, reason: contains not printable characters */
    public final Object f17308 = new Object();

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean f17314 = false;

    /* renamed from: މ, reason: contains not printable characters */
    public final double f17315 = 2500.0d / Math.pow(10.0d, 4.5d);

    /* renamed from: ފ, reason: contains not printable characters */
    public double f17316 = 10.0d;

    /* renamed from: ދ, reason: contains not printable characters */
    public double f17317 = 2500.0d / Math.pow(10.0d, 4.5d);

    /* renamed from: ތ, reason: contains not printable characters */
    public double f17318 = 0.0d;

    /* renamed from: ލ, reason: contains not printable characters */
    public double f17319 = 0.9d;

    /* renamed from: ގ, reason: contains not printable characters */
    public InterfaceC5225 f17320 = null;

    /* compiled from: FilmAudioRecord.java */
    /* renamed from: Ⴗ$Ϳ, reason: contains not printable characters */
    public class RunnableC5221 implements Runnable {
        public RunnableC5221() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C5220.this.m15230();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (C5220.this.f17304 == 1) {
                try {
                    C5220.this.m15233();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    if (C5220.this.f17304 == 1) {
                        C5220.this.m15230();
                        C5220.this.m15233();
                    }
                }
            }
        }
    }

    /* compiled from: FilmAudioRecord.java */
    /* renamed from: Ⴗ$Ԩ, reason: contains not printable characters */
    public class RunnableC5222 implements Runnable {
        public RunnableC5222() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C5220.this.f17292) {
                C4638.m14099(C5220.f17291, String.format("mAudioRecord : %s ", "handle stop run"));
            }
            C5220.this.m15234();
        }
    }

    /* compiled from: FilmAudioRecord.java */
    /* renamed from: Ⴗ$Ԫ, reason: contains not printable characters */
    public interface InterfaceC5223 {
        /* renamed from: Ϳ */
        void mo10300(byte[] bArr, int i, long j);
    }

    /* compiled from: FilmAudioRecord.java */
    /* renamed from: Ⴗ$Ԭ, reason: contains not printable characters */
    public interface InterfaceC5224 {
        /* renamed from: Ϳ */
        void mo1333(double d, double d2, boolean z);
    }

    /* compiled from: FilmAudioRecord.java */
    /* renamed from: Ⴗ$Ԯ, reason: contains not printable characters */
    public interface InterfaceC5225 {
        /* renamed from: Ϳ */
        void mo1328();

        /* renamed from: Ԩ */
        void mo1329(String str);

        /* renamed from: ԩ */
        void mo1330();
    }

    /* compiled from: FilmAudioRecord.java */
    /* renamed from: Ⴗ$ՠ, reason: contains not printable characters */
    public static class C5226 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final int f17325;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final int f17326;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final float f17327;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final int f17328;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final int f17329;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final boolean f17330;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f17331;

        public C5226(int i, int i2, float f, int i3, int i4, boolean z, boolean z2) {
            this.f17325 = i;
            this.f17326 = i2;
            this.f17327 = f;
            this.f17328 = i3;
            this.f17329 = i4;
            this.f17330 = z;
            this.f17331 = z2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007e A[Catch: all -> 0x0140, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000a, B:6:0x0040, B:8:0x0044, B:10:0x0048, B:11:0x0059, B:14:0x0063, B:15:0x0066, B:17:0x007e, B:19:0x0082, B:20:0x00b7, B:22:0x00c2, B:24:0x00ce, B:25:0x00d3, B:27:0x00e7, B:28:0x00ec, B:30:0x00f9, B:37:0x011b, B:38:0x011d, B:41:0x0126, B:43:0x012a, B:48:0x013f, B:31:0x00fd, B:33:0x0101, B:34:0x0112, B:36:0x0116, B:39:0x011e, B:40:0x0125), top: B:52:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fd A[Catch: all -> 0x0140, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000a, B:6:0x0040, B:8:0x0044, B:10:0x0048, B:11:0x0059, B:14:0x0063, B:15:0x0066, B:17:0x007e, B:19:0x0082, B:20:0x00b7, B:22:0x00c2, B:24:0x00ce, B:25:0x00d3, B:27:0x00e7, B:28:0x00ec, B:30:0x00f9, B:37:0x011b, B:38:0x011d, B:41:0x0126, B:43:0x012a, B:48:0x013f, B:31:0x00fd, B:33:0x0101, B:34:0x0112, B:36:0x0116, B:39:0x011e, B:40:0x0125), top: B:52:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: ԭ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void m15230() {
        /*
            Method dump skipped, instructions count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C5220.m15230():void");
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean m15231() {
        return this.f17313;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final long m15232(int i, int i2) {
        long j = i * i2;
        if (((int) j) == j) {
            return j;
        }
        throw new ArithmeticException("integer overflow");
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m15233() {
        boolean z;
        if (this.f17292) {
            String str = f17291;
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.f17305);
            objArr[1] = Boolean.valueOf(this.f17295 == null);
            C4638.m14099(str, String.format("init start recordAudioData : %s , %s ", objArr));
        }
        this.f17311 = new short[this.f17301 / 2];
        this.f17313 = false;
        while (this.f17305 && this.f17295 != null) {
            try {
                if (System.nanoTime() - this.f17312 > 20000000000L) {
                    this.f17312 = System.nanoTime();
                    z = true;
                } else {
                    z = false;
                }
                if (this.f17292 && z) {
                    C4638.m14099(f17291, String.format("mAudioRecord before readLength : %s ", Integer.valueOf(this.f17301)));
                }
                AudioRecord audioRecord = this.f17295;
                short[] sArr = this.f17311;
                int i = audioRecord.read(sArr, 0, sArr.length);
                this.f17313 = true;
                if (this.f17292 && z) {
                    C4638.m14099(f17291, String.format("mAudioRecord readLength : %s ", Integer.valueOf(i)));
                }
                if (i > 0) {
                    m15241(this.f17311);
                    InterfaceC5223 interfaceC5223 = this.f17321;
                    if (interfaceC5223 != null) {
                        interfaceC5223.mo10300(m15240(this.f17311), i * 2, System.nanoTime());
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.f17292) {
            C4638.m14099(f17291, String.format("mAudioRecord : %s ", "recordAudioData break finish"));
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final synchronized void m15234() {
        AudioManager audioManager = (AudioManager) FilmApp.m402().getSystemService("audio");
        if (audioManager != null && audioManager.isBluetoothScoOn()) {
            audioManager.stopBluetoothSco();
            if (this.f17292) {
                C4638.m14099(f17291, "releaseAll mAudioManager.stopBluetoothSco()");
            }
        }
        AudioRecord audioRecord = this.f17295;
        if (audioRecord != null) {
            audioRecord.release();
            int state = this.f17295.getState();
            int recordingState = this.f17295.getRecordingState();
            if (this.f17292) {
                C4638.m14101(f17291, String.format("mAudioRecord : %s  , state : %s  ,  recordingState : %s ", "release", Integer.valueOf(state), Integer.valueOf(recordingState)));
            }
            this.f17295 = null;
        }
        if (this.f17292) {
            C4638.m14101(f17291, String.format("mAudioRecord : %s ", "stopped"));
        }
        synchronized (this.f17308) {
            HandlerThread handlerThread = this.f17293;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.f17293 = null;
            this.f17294 = null;
            InterfaceC5225 interfaceC5225 = this.f17320;
            if (interfaceC5225 != null) {
                interfaceC5225.mo1328();
            }
            this.f17309 = false;
            this.f17308.notify();
            if (this.f17292) {
                C4638.m14101(f17291, String.format("mAudioRecord : %s ", "thread exited"));
            }
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m15235(C5226 c5226) {
        if (this.f17304 != 0) {
            m15243();
            m15244();
        }
        m15242(c5226);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public C5220 m15236(InterfaceC5223 interfaceC5223) {
        this.f17321 = interfaceC5223;
        return this;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public C5220 m15237(float f) {
        this.f17303 = f;
        return this;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public C5220 m15238(InterfaceC5224 interfaceC5224) {
        this.f17322 = interfaceC5224;
        return this;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public C5220 m15239(InterfaceC5225 interfaceC5225) {
        this.f17320 = interfaceC5225;
        return this;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final byte[] m15240(short[] sArr) {
        int length = sArr.length;
        byte[] bArr = new byte[length * 2];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            short s = sArr[i];
            bArr[i2] = (byte) (s & 255);
            bArr[i2 + 1] = (byte) (s >> 8);
            sArr[i] = 0;
        }
        return bArr;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m15241(short[] sArr) {
        int i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int length = sArr.length / 2;
        long jM15232 = 0;
        long jM152322 = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            short s = sArr[i3];
            sArr[i3] = (short) (s * this.f17303);
            jM15232 += m15232(s, s);
            int i4 = i3 + 1;
            short s2 = sArr[i4];
            sArr[i4] = (short) (s2 * this.f17303);
            jM152322 += m15232(s2, s2);
        }
        long j = length;
        double dSqrt = Math.sqrt(jM15232 / j) * this.f17303;
        double dSqrt2 = Math.sqrt(jM152322 / j) * this.f17303;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (this.f17314) {
            i = 2;
            C4638.m14099(f17291, String.format(Locale.US, "LevelMeter split data cost : %s , leftRms : %s , rightRms : %s ", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), Double.valueOf(dSqrt), Double.valueOf(dSqrt2)));
        } else {
            i = 2;
        }
        InterfaceC5224 interfaceC5224 = this.f17322;
        if (interfaceC5224 != null) {
            interfaceC5224.mo1333(dSqrt, dSqrt2, this.f17306.f17328 == i);
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m15242(C5226 c5226) throws InterruptedException {
        String str = f17291;
        C4638.m14099(str, "FilmAudioRecord start()");
        if (this.f17309) {
            if (this.f17292) {
                C4638.m14099(str, "mReadyFence synchronized()");
            }
            synchronized (this.f17308) {
                try {
                    this.f17308.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            if (this.f17292) {
                C4638.m14099(f17291, "mReadyFence synchronized end");
            }
        }
        this.f17310 = true;
        this.f17306 = c5226;
        if (c5226 == null) {
            this.f17304 = 0;
            return;
        }
        if (c5226.f17330) {
            this.f17296 = 6;
        } else if (c5226.f17328 == 0) {
            this.f17296 = 5;
        } else {
            this.f17296 = 0;
        }
        if (this.f17292) {
            C4638.m14099(f17291, String.format("mRecorderConfig.mAudioSource : %s , mAudioSource : %s ", Integer.valueOf(c5226.f17328), Integer.valueOf(this.f17296)));
        }
        AudioManager audioManager = (AudioManager) FilmApp.m402().getSystemService("audio");
        if (audioManager != null) {
            if (audioManager.isBluetoothScoAvailableOffCall()) {
                this.f17307 = true;
            }
            if (this.f17306.f17328 == 2) {
                if (this.f17307) {
                    if (audioManager.isBluetoothScoOn()) {
                        audioManager.stopBluetoothSco();
                        if (this.f17292) {
                            C4638.m14099(f17291, "mAudioManager.stopBluetoothSco() : " + audioManager.isBluetoothScoOn());
                        }
                    }
                    if (this.f17292) {
                        C4638.m14099(f17291, "mAudioManager.startBluetoothSco()  mAudioManager.isBluetoothScoOn() : " + audioManager.isBluetoothScoOn());
                    }
                    audioManager.startBluetoothSco();
                    int i = 200;
                    while (true) {
                        if (!audioManager.isBluetoothScoOn()) {
                            int i2 = i - 1;
                            if (i <= 0) {
                                i = i2;
                                break;
                            }
                            try {
                                Thread.sleep(10L);
                            } catch (InterruptedException e3) {
                                e3.printStackTrace();
                            }
                            if (i2 == 50) {
                                if (this.f17292) {
                                    C4638.m14101(f17291, "2startBluetoothSco");
                                }
                                audioManager.startBluetoothSco();
                            }
                            if (this.f17292) {
                                C4638.m14101(f17291, "change BluetoothScoOn  " + audioManager.isBluetoothScoOn() + " : " + i2);
                            }
                            i = i2;
                        } else {
                            break;
                        }
                    }
                    if (this.f17292) {
                        C4638.m14099(f17291, "change BluetoothScoOn  " + audioManager.isBluetoothScoOn() + " : " + i);
                    }
                    this.f17296 = 6;
                }
            } else if (this.f17307 && audioManager.isBluetoothScoOn()) {
                audioManager.stopBluetoothSco();
                if (this.f17292) {
                    C4638.m14099(f17291, "mAudioManager.stopBluetoothSco()");
                }
            }
        }
        C5226 c52262 = this.f17306;
        int i3 = c52262.f17325;
        this.f17297 = i3;
        this.f17300 = c52262.f17329;
        this.f17302 = c52262.f17331;
        this.f17298 = 12;
        this.f17299 = 2;
        this.f17301 = AudioRecord.getMinBufferSize(i3, 12, 2);
        synchronized (this.f17308) {
            HandlerThread handlerThread = new HandlerThread(f17291);
            this.f17293 = handlerThread;
            handlerThread.setPriority(3);
            this.f17293.start();
            Handler handler = new Handler(this.f17293.getLooper());
            this.f17294 = handler;
            handler.post(new RunnableC5221());
        }
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m15243() {
        if (this.f17292) {
            C4638.m14099(f17291, String.format("mAudioRecord : %s ", "handle stop"));
        }
        if (this.f17310) {
            if (this.f17292) {
                C4638.m14099(f17291, "mReadyFence synchronized()");
            }
            synchronized (this.f17308) {
                try {
                    this.f17308.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            if (this.f17292) {
                C4638.m14099(f17291, "mReadyFence synchronized end");
            }
        }
        this.f17309 = true;
        this.f17305 = false;
        this.f17304 = 0;
        if (this.f17294 != null) {
            if (this.f17292) {
                C4638.m14099(f17291, String.format("mAudioRecord : %s , canReadData : %s ", "handle not null", Boolean.valueOf(this.f17313)));
            }
            if (this.f17313) {
                this.f17294.post(new RunnableC5222());
                return;
            } else {
                m15234();
                return;
            }
        }
        if (this.f17292) {
            C4638.m14099(f17291, String.format("mAudioRecord : %s ", "handle null"));
        }
        synchronized (this.f17308) {
            this.f17309 = false;
            this.f17308.notify();
        }
        if (this.f17292) {
            C4638.m14099(f17291, String.format("mAudioRecord : %s ", "handle stop finish"));
        }
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m15244() {
        HandlerThread handlerThread = this.f17293;
        if (handlerThread != null) {
            try {
                handlerThread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }
}
