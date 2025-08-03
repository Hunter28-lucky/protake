package defpackage;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

/* compiled from: FilmMonitorLittlePreview.java */
/* renamed from: ऎ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4041 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String f14015 = "ऎ";

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static byte[] f14016 = null;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean f14018 = false;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static C2390 f14019 = null;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static C4327 f14020 = null;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static FloatBuffer f14021 = null;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static FloatBuffer f14022 = null;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static int f14023 = 640;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static int f14024 = 360;

    /* renamed from: ֈ, reason: contains not printable characters */
    public static C4077 f14025 = null;

    /* renamed from: ֏, reason: contains not printable characters */
    public static boolean f14026 = false;

    /* renamed from: ؠ, reason: contains not printable characters */
    public static EGLSurface f14028;

    /* renamed from: ހ, reason: contains not printable characters */
    public static int f14029;

    /* renamed from: ށ, reason: contains not printable characters */
    public static int f14030;

    /* renamed from: ނ, reason: contains not printable characters */
    public static C4100 f14031;

    /* renamed from: ރ, reason: contains not printable characters */
    public static C2878 f14032;

    /* renamed from: ގ, reason: contains not printable characters */
    public static int f14043;

    /* renamed from: ޏ, reason: contains not printable characters */
    public static long f14044;

    /* renamed from: ސ, reason: contains not printable characters */
    public static long f14045;

    /* renamed from: ޑ, reason: contains not printable characters */
    public static int f14046;

    /* renamed from: ޒ, reason: contains not printable characters */
    public static int f14047;

    /* renamed from: ޓ, reason: contains not printable characters */
    public static long f14048;

    /* renamed from: ޔ, reason: contains not printable characters */
    public static long f14049;

    /* renamed from: ޕ, reason: contains not printable characters */
    public static int f14050;

    /* renamed from: ޖ, reason: contains not printable characters */
    public static EGLSurface f14051;

    /* renamed from: ޗ, reason: contains not printable characters */
    public static C2377 f14052;

    /* renamed from: ޘ, reason: contains not printable characters */
    public static Handler f14053;

    /* renamed from: ޙ, reason: contains not printable characters */
    public static Thread f14054;

    /* renamed from: ޚ, reason: contains not printable characters */
    public static int f14055;

    /* renamed from: ޛ, reason: contains not printable characters */
    public static int f14056;

    /* renamed from: ޜ, reason: contains not printable characters */
    public static boolean f14057;

    /* renamed from: ޞ, reason: contains not printable characters */
    public static int f14059;

    /* renamed from: ޟ, reason: contains not printable characters */
    public static boolean f14060;

    /* renamed from: ޠ, reason: contains not printable characters */
    public static boolean f14061;

    /* renamed from: ޡ, reason: contains not printable characters */
    public static Runnable f14062;

    /* renamed from: ޢ, reason: contains not printable characters */
    public static InterfaceC4050 f14063;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final Object f14017 = new Object();

    /* renamed from: ׯ, reason: contains not printable characters */
    public static Runnable f14027 = new RunnableC4043();

    /* renamed from: ބ, reason: contains not printable characters */
    public static int[] f14033 = new int[128];

    /* renamed from: ޅ, reason: contains not printable characters */
    public static int[] f14034 = new int[128];

    /* renamed from: ކ, reason: contains not printable characters */
    public static int f14035 = 0;

    /* renamed from: އ, reason: contains not printable characters */
    public static int[] f14036 = new int[128];

    /* renamed from: ވ, reason: contains not printable characters */
    public static int[] f14037 = new int[128];

    /* renamed from: މ, reason: contains not printable characters */
    public static int[] f14038 = new int[128];

    /* renamed from: ފ, reason: contains not printable characters */
    public static int[] f14039 = new int[128];

    /* renamed from: ދ, reason: contains not printable characters */
    public static int[] f14040 = new int[128];

    /* renamed from: ތ, reason: contains not printable characters */
    public static int[] f14041 = new int[128];

    /* renamed from: ލ, reason: contains not printable characters */
    public static int f14042 = 2;

    /* renamed from: ޝ, reason: contains not printable characters */
    public static final Object f14058 = new Object();

    /* compiled from: FilmMonitorLittlePreview.java */
    /* renamed from: ऎ$Ϳ, reason: contains not printable characters */
    public class RunnableC4042 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            C4041.m12951();
        }
    }

    /* compiled from: FilmMonitorLittlePreview.java */
    /* renamed from: ऎ$Ԩ, reason: contains not printable characters */
    public class RunnableC4043 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (C4041.f14025 == null || C4041.f14028 == null) {
                return;
            }
            if (jCurrentTimeMillis - C4041.f14048 >= 66.0f) {
                C4041.f14048 = jCurrentTimeMillis;
                if (C4041.f14042 < 2) {
                    Object obj = C4041.f14017;
                    synchronized (obj) {
                        if (C4041.f14018) {
                            return;
                        }
                        boolean unused = C4041.f14026 = true;
                        C4041.f14052.m8853(C4041.f14051);
                        C4041.f14025.m13013(C4041.f14059);
                        synchronized (obj) {
                            boolean unused2 = C4041.f14026 = false;
                        }
                        C4041.f14016 = C4041.f14025.m13010();
                        System.currentTimeMillis();
                        byte[] bArr = C4041.f14016;
                        if (bArr == null) {
                            return;
                        }
                        C4041.m12948(bArr);
                        System.currentTimeMillis();
                    }
                }
            }
            System.currentTimeMillis();
            if (jCurrentTimeMillis - C4041.f14049 >= 33.0f) {
                C4041.f14049 = jCurrentTimeMillis;
                if (C4041.f14042 < 2 && C4041.f14016 != null && C4041.f14028 != null) {
                    C4041.f14052.m8853(C4041.f14028);
                    C4041.m12969();
                    C4041.f14031.m13048(C4041.f14041, C4041.f14037, C4041.f14034);
                    C4041.f14032.m10228(C4041.f14039);
                    if (C4041.f14042 == 0) {
                        C4041.f14025.m13012(C4041.f14032, C4041.f14029, C4041.f14030);
                    } else if (C4041.f14042 == 1) {
                        C4041.f14025.m13012(C4041.f14031, C4041.f14029, C4041.f14030);
                    }
                    C4041.f14052.m8857(C4041.f14028);
                } else if (C4041.f14028 != null) {
                    Object obj2 = C4041.f14017;
                    synchronized (obj2) {
                        if (C4041.f14018) {
                            return;
                        }
                        boolean unused3 = C4041.f14026 = true;
                        C4041.f14052.m8853(C4041.f14028);
                        C4041.f14025.m13013(C4041.f14059);
                        C4041.f14052.m8857(C4041.f14028);
                        synchronized (obj2) {
                            boolean unused4 = C4041.f14026 = false;
                        }
                    }
                }
                C3439.f11831.m11210();
                System.currentTimeMillis();
            }
        }
    }

    /* compiled from: FilmMonitorLittlePreview.java */
    /* renamed from: ऎ$Ԫ, reason: contains not printable characters */
    public class RunnableC4044 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ SurfaceTexture f14064;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f14065;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f14066;

        public RunnableC4044(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f14064 = surfaceTexture;
            this.f14065 = i;
            this.f14066 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C4041.f14052 == null) {
                return;
            }
            C4041.m12954();
            C3732.m11943("after destroyOtherSurface");
            if (Build.VERSION.SDK_INT < 26 || !this.f14064.isReleased()) {
                EGLSurface unused = C4041.f14028 = C4041.f14052.m8851(this.f14064);
                C3732.m11943("after createWindowSurface OtherSurface");
                int unused2 = C4041.f14029 = this.f14065;
                int unused3 = C4041.f14030 = this.f14066;
                if (C4041.f14031 != null) {
                    C4041.f14031.m13471();
                    C4100 unused4 = C4041.f14031 = null;
                }
                if (C4041.f14032 != null) {
                    C4041.f14032.m13471();
                    C2878 unused5 = C4041.f14032 = null;
                }
                C4100 unused6 = C4041.f14031 = new C4100();
                C4041.f14031.m13477();
                C2878 unused7 = C4041.f14032 = new C2878();
                C4041.f14032.m13477();
                C4041.f14052.m8853(C4041.f14051);
            }
        }
    }

    /* compiled from: FilmMonitorLittlePreview.java */
    /* renamed from: ऎ$Ԭ, reason: contains not printable characters */
    public class RunnableC4045 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f14067;

        /* compiled from: FilmMonitorLittlePreview.java */
        /* renamed from: ऎ$Ԭ$Ϳ, reason: contains not printable characters */
        public class RunnableC4046 implements Runnable {
            public RunnableC4046() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C4041.m12951();
            }
        }

        public RunnableC4045(int i) {
            this.f14067 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4041.m12968(this.f14067);
            int i = C4041.f14042;
            if (i == 0 || i == 1) {
                C4041.m12952();
                return;
            }
            if (i == 2 || i == 3) {
                C4041.m12953();
                C4041.f14025.m13015(C4041.f14042);
            } else {
                if (i != 4) {
                    return;
                }
                C4041.f14053.post(new RunnableC4046());
            }
        }
    }

    /* compiled from: FilmMonitorLittlePreview.java */
    /* renamed from: ऎ$Ԯ, reason: contains not printable characters */
    public class RunnableC4047 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f14069;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f14070;

        public RunnableC4047(int i, int i2) {
            this.f14069 = i;
            this.f14070 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setPriority(1);
            Looper.prepare();
            Object obj = C4041.f14058;
            synchronized (obj) {
                C4041.f14053 = new Handler();
                C4041.f14056 = this.f14069;
                C4041.f14055 = this.f14070;
                C4041.f14057 = true;
                obj.notify();
                C4041.f14060 = true;
            }
            Looper.loop();
            synchronized (obj) {
                C4041.f14059 = 0;
                C4041.f14060 = false;
                C4041.f14057 = false;
                C4041.f14053 = null;
                C4041.f14054 = null;
            }
            if (C4041.f14062 != null) {
                C4041.f14062.run();
                Runnable unused = C4041.f14062 = null;
            }
        }
    }

    /* compiled from: FilmMonitorLittlePreview.java */
    /* renamed from: ऎ$ՠ, reason: contains not printable characters */
    public class RunnableC4048 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f14071;

        public RunnableC4048(Runnable runnable) {
            this.f14071 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4041.m12955();
            Runnable unused = C4041.f14062 = this.f14071;
            try {
                Looper.myLooper().quitSafely();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: FilmMonitorLittlePreview.java */
    /* renamed from: ऎ$ֈ, reason: contains not printable characters */
    public class RunnableC4049 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f14072;

        public RunnableC4049(int i) {
            this.f14072 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            EGLSurface eGLSurfaceM8850;
            C4041.m12955();
            try {
                C2377 c2377 = new C2377(C3732.m11945().m11954(), 0);
                C4041.f14052 = c2377;
                eGLSurfaceM8850 = c2377.m8850(C4041.f14056, C4041.f14055);
                C4041.f14051 = eGLSurfaceM8850;
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
            if (eGLSurfaceM8850 == null) {
                throw new RuntimeException("surface was null");
            }
            C4041.f14052.m8853(C4041.f14051);
            int i = C4041.f14042;
            if (i == 0 || i == 1) {
                C4041.f14025 = new C4077(0, 1, true, C4041.f14056, C4041.f14055);
            } else if (i == 2 || i == 3) {
                C4077 c4077 = new C4077(0, 1, false, C4041.f14029, C4041.f14030);
                C4041.f14025 = c4077;
                c4077.m13015(C4041.f14042);
            }
            C4041.f14059 = this.f14072;
            C4041.f14048 = System.currentTimeMillis();
            C4041.f14049 = System.currentTimeMillis();
            int unused = C4041.f14050 = 1;
            C4041.f14061 = true;
            if (C4041.f14063 != null) {
                C4041.f14063.mo4707();
            }
        }
    }

    /* compiled from: FilmMonitorLittlePreview.java */
    /* renamed from: ऎ$֏, reason: contains not printable characters */
    public interface InterfaceC4050 {
        /* renamed from: Ϳ */
        void mo4707();
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public static void m12948(byte[] bArr) {
        long jNanoTime = System.nanoTime();
        Arrays.fill(f14040, 0);
        Arrays.fill(f14036, 0);
        Arrays.fill(f14033, 0);
        Arrays.fill(f14038, 0);
        f14046 = 0;
        f14047 = 0;
        f14035 = bArr.length / 4;
        for (int i = 1; i < f14035; i++) {
            int i2 = i * 4;
            int i3 = bArr[i2] & ExifInterface.MARKER;
            int i4 = bArr[i2 + 1] & ExifInterface.MARKER;
            int i5 = bArr[i2 + 2] & ExifInterface.MARKER;
            int i6 = (int) ((i3 * 0.2126f) + (i4 * 0.7152f) + (i5 * 0.0722f));
            int[] iArr = f14040;
            int i7 = i3 / 2;
            iArr[i7] = iArr[i7] + 1;
            int[] iArr2 = f14036;
            int i8 = i4 / 2;
            iArr2[i8] = iArr2[i8] + 1;
            int[] iArr3 = f14033;
            int i9 = i5 / 2;
            iArr3[i9] = iArr3[i9] + 1;
            int[] iArr4 = f14038;
            int i10 = i6 / 2;
            iArr4[i10] = iArr4[i10] + 1;
            if (i10 >= 120) {
                f14046++;
            } else if (i10 <= 7) {
                f14047++;
            }
        }
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        int i11 = f14043 + 1;
        f14043 = i11;
        long j = f14045 + jNanoTime2;
        f14045 = j;
        f14044 = j / i11;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public static void m12949(int i) {
        Handler handler = f14053;
        if (handler == null || f14029 == 0 || f14030 == 0 || !f14061) {
            return;
        }
        handler.post(new RunnableC4045(i));
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public static void m12950() {
        Handler handler = f14053;
        if (handler == null) {
            return;
        }
        handler.post(new RunnableC4042());
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public static void m12951() {
        EGLSurface eGLSurface;
        if (f14061 && (eGLSurface = f14028) != null) {
            f14052.m8853(eGLSurface);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            f14052.m8857(f14028);
        }
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public static void m12952() {
        C4077 c4077 = f14025;
        if (c4077 != null && !c4077.m13011()) {
            f14025.mo11907();
            f14025 = null;
        }
        if (f14025 == null) {
            f14025 = new C4077(true, C2650.f9896, C2650.f9895);
        }
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public static void m12953() {
        C4077 c4077 = f14025;
        if (c4077 != null && c4077.m13011()) {
            f14025.mo11907();
            f14025 = null;
        }
        if (f14025 == null) {
            f14025 = new C4077(false, f14029, f14030);
        }
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public static void m12954() {
        EGLSurface eGLSurface = f14028;
        if (eGLSurface != null) {
            f14028 = null;
            f14052.m8855(eGLSurface);
        }
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public static void m12955() {
        C4077 c4077 = f14025;
        if (c4077 != null) {
            c4077.mo11907();
            f14025 = null;
        }
        m12954();
        C4100 c4100 = f14031;
        if (c4100 != null) {
            c4100.m13471();
            f14031 = null;
        }
        C2878 c2878 = f14032;
        if (c2878 != null) {
            c2878.m13471();
            f14032 = null;
        }
        C3439.f11831.m11208();
        C2377 c2377 = f14052;
        if (c2377 != null) {
            c2377.m8855(f14051);
            f14052.m8854();
            f14052 = null;
        }
        f14061 = false;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public static void m12956(int i, int i2) {
        synchronized (f14058) {
            if (f14054 != null && f14053 != null) {
                m12962(null);
                try {
                    f14054.join();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        Thread thread = new Thread(new RunnableC4047(i, i2), f14015);
        f14054 = thread;
        thread.start();
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public static boolean m12957() {
        return f14061;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public static boolean m12958() {
        return f14050 != 0;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public static boolean m12959() {
        return f14060;
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public static boolean m12960() {
        if (m12961()) {
            return false;
        }
        synchronized (f14058) {
            if (f14057 && f14061) {
                if (!m12958() || f14025 == null || f14051 == null) {
                    return false;
                }
                f14053.post(f14027);
                return true;
            }
            return false;
        }
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public static boolean m12961() {
        return f14042 == 4;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public static void m12962(Runnable runnable) {
        f14060 = false;
        if (f14053 != null) {
            m12950();
            f14053.post(new RunnableC4048(runnable));
        }
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public static void m12963() {
        C4327 c4327 = f14020;
        if (c4327 != null) {
            c4327.m13471();
            f14020.mo10877();
            f14020 = null;
        }
        C2390 c2390 = f14019;
        if (c2390 != null) {
            c2390.m8880();
            f14019 = null;
        }
        FloatBuffer floatBuffer = f14021;
        if (floatBuffer != null) {
            floatBuffer.clear();
            f14021 = null;
        }
        FloatBuffer floatBuffer2 = f14022;
        if (floatBuffer2 != null) {
            floatBuffer2.clear();
            f14022 = null;
        }
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public static void m12964(int i, boolean z, boolean z2, boolean z3, int i2) {
        if (f14061 && m12961()) {
            return;
        }
        System.nanoTime();
        Object obj = f14017;
        synchronized (obj) {
            if (f14026) {
                return;
            }
            f14018 = true;
            if (f14019 == null) {
                f14019 = new C2390(f14023, f14024, true);
            }
            if (f14020 == null) {
                C4327 c4327 = new C4327();
                f14020 = c4327;
                c4327.m13477();
                f14020.mo9491(f14023, f14024);
            }
            if (f14021 == null) {
                FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
                f14021 = floatBufferAsFloatBuffer;
                floatBufferAsFloatBuffer.put(b2.f93).position(0);
            }
            if (f14022 == null) {
                FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
                f14022 = floatBufferAsFloatBuffer2;
                floatBufferAsFloatBuffer2.put(b2.f98).position(0);
            }
            C3732.m11943("before resizeSourceTexture");
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(0, 0, f14023, f14024);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            f14021.clear();
            if (z3) {
                if (z2) {
                    f14021.put(b2.f97).position(0);
                } else {
                    f14021.put(b2.f96).position(0);
                }
            } else if (z2) {
                f14021.put(b2.f95).position(0);
            } else {
                f14021.put(b2.f93).position(0);
            }
            f14022.clear();
            if (z) {
                if (z2) {
                    f14022.put(b2.f99).position(0);
                } else {
                    f14022.put(b2.f101).position(0);
                }
            } else if (z2) {
                f14022.put(b2.f99).position(0);
            } else {
                f14022.put(b2.f98).position(0);
            }
            GLES20.glBindFramebuffer(36160, f14019.m8881());
            C3732.m11943("resizeSourceTexture after glBindFramebuffer ");
            GLES20.glViewport(0, 0, f14023, f14024);
            GLES20.glClearColor(0.0745f, 0.0706f, 0.0667f, 1.0f);
            f14020.m13479(i, f14021, f14022);
            GLES20.glBindFramebuffer(36160, 0);
            C3439.f11831.m11210();
            synchronized (obj) {
                f14018 = false;
            }
            if (f14059 != f14019.m8882()) {
                m12970(f14019.m8882(), EGL14.eglGetCurrentContext());
            }
            System.nanoTime();
        }
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public static void m12965(SurfaceTexture surfaceTexture, int i, int i2) {
        Handler handler = f14053;
        if (handler == null) {
            return;
        }
        handler.post(new RunnableC4044(surfaceTexture, i, i2));
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public static void m12966(int i, int i2) {
        f14029 = i;
        f14030 = i2;
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public static void m12967(InterfaceC4050 interfaceC4050) {
        f14063 = interfaceC4050;
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public static void m12968(int i) {
        f14042 = i;
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public static void m12969() {
        for (int i = 0; i < 128; i++) {
            int[] iArr = f14039;
            int i2 = iArr[i];
            iArr[i] = i2 + ((f14038[i] - i2) / 3);
            int[] iArr2 = f14041;
            int i3 = iArr2[i];
            iArr2[i] = i3 + ((f14040[i] - i3) / 3);
            int[] iArr3 = f14037;
            int i4 = iArr3[i];
            iArr3[i] = i4 + ((f14036[i] - i4) / 3);
            int[] iArr4 = f14034;
            int i5 = iArr4[i];
            iArr4[i] = i5 + ((f14033[i] - i5) / 3);
        }
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public static void m12970(int i, EGLContext eGLContext) {
        synchronized (f14058) {
            if (f14057 && f14029 != 0 && f14030 != 0) {
                f14059 = i;
                f14053.post(new RunnableC4049(i));
            }
        }
    }
}
