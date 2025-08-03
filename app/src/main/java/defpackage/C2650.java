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

/* compiled from: FilmLittlePreview.java */
/* renamed from: ʈ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2650 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int f9854 = 4;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final String f9855 = "ʈ";

    /* renamed from: ԩ, reason: contains not printable characters */
    public static byte[] f9856 = null;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean f9858 = false;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static C2390 f9859 = null;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static C2483 f9860 = null;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static FloatBuffer f9861 = null;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static FloatBuffer f9862 = null;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static int f9863 = 640;

    /* renamed from: ֈ, reason: contains not printable characters */
    public static int f9864 = 360;

    /* renamed from: ֏, reason: contains not printable characters */
    public static C4077 f9865 = null;

    /* renamed from: ׯ, reason: contains not printable characters */
    public static boolean f9866 = false;

    /* renamed from: ހ, reason: contains not printable characters */
    public static EGLSurface f9868;

    /* renamed from: ށ, reason: contains not printable characters */
    public static int f9869;

    /* renamed from: ނ, reason: contains not printable characters */
    public static int f9870;

    /* renamed from: ރ, reason: contains not printable characters */
    public static C4100 f9871;

    /* renamed from: ބ, reason: contains not printable characters */
    public static C2878 f9872;

    /* renamed from: ޏ, reason: contains not printable characters */
    public static int f9883;

    /* renamed from: ސ, reason: contains not printable characters */
    public static long f9884;

    /* renamed from: ޑ, reason: contains not printable characters */
    public static long f9885;

    /* renamed from: ޒ, reason: contains not printable characters */
    public static int f9886;

    /* renamed from: ޓ, reason: contains not printable characters */
    public static int f9887;

    /* renamed from: ޔ, reason: contains not printable characters */
    public static long f9888;

    /* renamed from: ޕ, reason: contains not printable characters */
    public static long f9889;

    /* renamed from: ޖ, reason: contains not printable characters */
    public static int f9890;

    /* renamed from: ޗ, reason: contains not printable characters */
    public static EGLSurface f9891;

    /* renamed from: ޘ, reason: contains not printable characters */
    public static C2377 f9892;

    /* renamed from: ޙ, reason: contains not printable characters */
    public static Handler f9893;

    /* renamed from: ޚ, reason: contains not printable characters */
    public static Thread f9894;

    /* renamed from: ޛ, reason: contains not printable characters */
    public static int f9895;

    /* renamed from: ޜ, reason: contains not printable characters */
    public static int f9896;

    /* renamed from: ޝ, reason: contains not printable characters */
    public static boolean f9897;

    /* renamed from: ޟ, reason: contains not printable characters */
    public static int f9899;

    /* renamed from: ޠ, reason: contains not printable characters */
    public static boolean f9900;

    /* renamed from: ޡ, reason: contains not printable characters */
    public static boolean f9901;

    /* renamed from: ޢ, reason: contains not printable characters */
    public static Runnable f9902;

    /* renamed from: ޣ, reason: contains not printable characters */
    public static InterfaceC2658 f9903;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final Object f9857 = new Object();

    /* renamed from: ؠ, reason: contains not printable characters */
    public static Runnable f9867 = new RunnableC2651();

    /* renamed from: ޅ, reason: contains not printable characters */
    public static int[] f9873 = new int[128];

    /* renamed from: ކ, reason: contains not printable characters */
    public static int[] f9874 = new int[128];

    /* renamed from: އ, reason: contains not printable characters */
    public static int f9875 = 0;

    /* renamed from: ވ, reason: contains not printable characters */
    public static int[] f9876 = new int[128];

    /* renamed from: މ, reason: contains not printable characters */
    public static int[] f9877 = new int[128];

    /* renamed from: ފ, reason: contains not printable characters */
    public static int[] f9878 = new int[128];

    /* renamed from: ދ, reason: contains not printable characters */
    public static int[] f9879 = new int[128];

    /* renamed from: ތ, reason: contains not printable characters */
    public static int[] f9880 = new int[128];

    /* renamed from: ލ, reason: contains not printable characters */
    public static int[] f9881 = new int[128];

    /* renamed from: ގ, reason: contains not printable characters */
    public static int f9882 = 2;

    /* renamed from: ޞ, reason: contains not printable characters */
    public static final Object f9898 = new Object();

    /* compiled from: FilmLittlePreview.java */
    /* renamed from: ʈ$Ϳ, reason: contains not printable characters */
    public class RunnableC2651 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (C2650.f9865 == null || C2650.f9868 == null) {
                return;
            }
            if (jCurrentTimeMillis - C2650.f9888 >= 66.0f) {
                C2650.f9888 = jCurrentTimeMillis;
                if (C2650.f9882 < 2) {
                    Object obj = C2650.f9857;
                    synchronized (obj) {
                        if (C2650.f9858) {
                            return;
                        }
                        boolean unused = C2650.f9866 = true;
                        C2650.f9892.m8853(C2650.f9891);
                        C2650.f9865.m13013(C2650.f9899);
                        synchronized (obj) {
                            boolean unused2 = C2650.f9866 = false;
                        }
                        C2650.f9856 = C2650.f9865.m13010();
                        System.currentTimeMillis();
                        byte[] bArr = C2650.f9856;
                        if (bArr == null) {
                            return;
                        }
                        C2650.m9776(bArr);
                        System.currentTimeMillis();
                    }
                }
            }
            System.currentTimeMillis();
            if (jCurrentTimeMillis - C2650.f9889 >= 33.0f) {
                C2650.f9889 = jCurrentTimeMillis;
                if (C2650.f9882 < 2 && C2650.f9856 != null && C2650.f9868 != null) {
                    try {
                        C2650.f9892.m8853(C2650.f9868);
                        C2650.m9798();
                        C2650.f9871.m13048(C2650.f9881, C2650.f9877, C2650.f9874);
                        C2650.f9872.m10228(C2650.f9879);
                        if (C2650.f9882 == 0) {
                            C2650.f9865.m13012(C2650.f9872, C2650.f9869, C2650.f9870);
                        } else if (C2650.f9882 == 1) {
                            C2650.f9865.m13012(C2650.f9871, C2650.f9869, C2650.f9870);
                        }
                        C2650.f9892.m8857(C2650.f9868);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                } else if (C2650.f9868 != null) {
                    Object obj2 = C2650.f9857;
                    synchronized (obj2) {
                        if (C2650.f9858) {
                            return;
                        }
                        boolean unused3 = C2650.f9866 = true;
                        try {
                            C2650.f9892.m8853(C2650.f9868);
                            C2650.f9865.m13013(C2650.f9899);
                            C2650.f9892.m8857(C2650.f9868);
                            synchronized (obj2) {
                                boolean unused4 = C2650.f9866 = false;
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                }
                C3439.f11831.m11210();
                System.currentTimeMillis();
            }
        }
    }

    /* compiled from: FilmLittlePreview.java */
    /* renamed from: ʈ$Ԩ, reason: contains not printable characters */
    public class RunnableC2652 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ SurfaceTexture f9904;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f9905;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f9906;

        public RunnableC2652(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f9904 = surfaceTexture;
            this.f9905 = i;
            this.f9906 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C2650.f9892 == null) {
                return;
            }
            C2650.m9781();
            C3732.m11943("after destroyOtherSurface");
            if (Build.VERSION.SDK_INT < 26 || !this.f9904.isReleased()) {
                EGLSurface unused = C2650.f9868 = C2650.f9892.m8851(this.f9904);
                C3732.m11943("after createWindowSurface OtherSurface");
                int unused2 = C2650.f9869 = this.f9905;
                int unused3 = C2650.f9870 = this.f9906;
                if (C2650.f9871 != null) {
                    C2650.f9871.m13471();
                    C4100 unused4 = C2650.f9871 = null;
                }
                if (C2650.f9872 != null) {
                    C2650.f9872.m13471();
                    C2878 unused5 = C2650.f9872 = null;
                }
                C4100 unused6 = C2650.f9871 = new C4100();
                C2650.f9871.m13477();
                C2878 unused7 = C2650.f9872 = new C2878();
                C2650.f9872.m13477();
            }
        }
    }

    /* compiled from: FilmLittlePreview.java */
    /* renamed from: ʈ$Ԫ, reason: contains not printable characters */
    public class RunnableC2653 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f9907;

        /* compiled from: FilmLittlePreview.java */
        /* renamed from: ʈ$Ԫ$Ϳ, reason: contains not printable characters */
        public class RunnableC2654 implements Runnable {
            public RunnableC2654() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C2650.m9778();
            }
        }

        public RunnableC2653(int i) {
            this.f9907 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2650.m9797(this.f9907);
            int i = C2650.f9882;
            if (i == 0 || i == 1) {
                C2650.m9779();
                return;
            }
            if (i == 2 || i == 3) {
                C2650.m9780();
                C2650.f9865.m13015(C2650.f9882);
            } else {
                if (i != 4) {
                    return;
                }
                C2650.f9893.post(new RunnableC2654());
            }
        }
    }

    /* compiled from: FilmLittlePreview.java */
    /* renamed from: ʈ$Ԭ, reason: contains not printable characters */
    public class RunnableC2655 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f9909;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f9910;

        public RunnableC2655(int i, int i2) {
            this.f9909 = i;
            this.f9910 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setPriority(1);
            Looper.prepare();
            C2650.f9896 = this.f9909;
            C2650.f9895 = this.f9910;
            C2377 c2377 = new C2377(C3732.m11945().m11954(), 0);
            C2650.f9892 = c2377;
            C2650.f9891 = c2377.m8850(C2650.f9896, C2650.f9895);
            Object obj = C2650.f9898;
            synchronized (obj) {
                C2650.f9893 = new Handler();
                C2650.f9897 = true;
                obj.notify();
                C2650.f9900 = true;
            }
            Looper.loop();
            synchronized (obj) {
                C2650.f9899 = 0;
                C2650.f9900 = false;
                C2650.f9897 = false;
                C2650.f9893 = null;
                C2650.f9894 = null;
            }
            C2650.m9782();
            C2377 c23772 = C2650.f9892;
            if (c23772 != null) {
                c23772.m8855(C2650.f9891);
                C2650.f9892.m8854();
                C2650.f9892 = null;
            }
            if (C2650.f9902 != null) {
                C2650.f9902.run();
                Runnable unused = C2650.f9902 = null;
            }
        }
    }

    /* compiled from: FilmLittlePreview.java */
    /* renamed from: ʈ$Ԯ, reason: contains not printable characters */
    public class RunnableC2656 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f9911;

        public RunnableC2656(Runnable runnable) {
            this.f9911 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2650.m9782();
            Runnable unused = C2650.f9902 = this.f9911;
            try {
                Looper.myLooper().quitSafely();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: FilmLittlePreview.java */
    /* renamed from: ʈ$ՠ, reason: contains not printable characters */
    public class RunnableC2657 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f9912;

        public RunnableC2657(int i) {
            this.f9912 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C2650.f9892.m8853(C2650.f9891);
                int i = C2650.f9882;
                if (i == 0 || i == 1) {
                    C2650.m9779();
                } else if (i == 2 || i == 3) {
                    C2650.m9780();
                    C2650.f9865.m13015(C2650.f9882);
                }
                C2650.f9899 = this.f9912;
                C2650.f9888 = System.currentTimeMillis();
                C2650.f9889 = System.currentTimeMillis();
                int unused = C2650.f9890 = 1;
                C2650.f9901 = true;
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
            if (C2650.f9903 != null) {
                C2650.f9903.mo9800();
            }
        }
    }

    /* compiled from: FilmLittlePreview.java */
    /* renamed from: ʈ$ֈ, reason: contains not printable characters */
    public interface InterfaceC2658 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo9800();
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public static void m9776(byte[] bArr) {
        long jNanoTime = System.nanoTime();
        Arrays.fill(f9880, 0);
        Arrays.fill(f9876, 0);
        Arrays.fill(f9873, 0);
        Arrays.fill(f9878, 0);
        f9886 = 0;
        f9887 = 0;
        f9875 = bArr.length / 4;
        for (int i = 1; i < f9875; i++) {
            int i2 = i * 4;
            int i3 = bArr[i2] & ExifInterface.MARKER;
            int i4 = bArr[i2 + 1] & ExifInterface.MARKER;
            int i5 = bArr[i2 + 2] & ExifInterface.MARKER;
            int i6 = (int) ((i3 * 0.2126f) + (i4 * 0.7152f) + (i5 * 0.0722f));
            int[] iArr = f9880;
            int i7 = i3 / 2;
            iArr[i7] = iArr[i7] + 1;
            int[] iArr2 = f9876;
            int i8 = i4 / 2;
            iArr2[i8] = iArr2[i8] + 1;
            int[] iArr3 = f9873;
            int i9 = i5 / 2;
            iArr3[i9] = iArr3[i9] + 1;
            int[] iArr4 = f9878;
            int i10 = i6 / 2;
            iArr4[i10] = iArr4[i10] + 1;
            if (i10 >= 120) {
                f9886++;
            } else if (i10 <= 7) {
                f9887++;
            }
        }
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        int i11 = f9883 + 1;
        f9883 = i11;
        long j = f9885 + jNanoTime2;
        f9885 = j;
        f9884 = j / i11;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public static void m9777(int i) {
        Handler handler = f9893;
        if (handler == null || f9869 == 0 || f9870 == 0 || !f9901) {
            return;
        }
        handler.post(new RunnableC2653(i));
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public static void m9778() {
        EGLSurface eGLSurface = f9868;
        if (eGLSurface == null) {
            return;
        }
        try {
            f9892.m8853(eGLSurface);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            f9892.m8857(f9868);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public static void m9779() {
        C4077 c4077 = f9865;
        if (c4077 != null && !c4077.m13011()) {
            f9865.mo11907();
            f9865 = null;
        }
        if (f9865 == null) {
            f9865 = new C4077(true, f9896, f9895);
        }
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public static void m9780() {
        C4077 c4077 = f9865;
        if (c4077 != null && c4077.m13011()) {
            f9865.mo11907();
            f9865 = null;
        }
        if (f9865 == null) {
            f9865 = new C4077(false, f9869, f9870);
        }
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public static void m9781() {
        EGLSurface eGLSurface = f9868;
        if (eGLSurface != null) {
            f9868 = null;
            f9892.m8855(eGLSurface);
        }
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public static void m9782() {
        C4077 c4077 = f9865;
        if (c4077 != null) {
            c4077.mo11907();
            f9865 = null;
        }
        m9781();
        C4100 c4100 = f9871;
        if (c4100 != null) {
            c4100.m13471();
            f9871 = null;
        }
        C2878 c2878 = f9872;
        if (c2878 != null) {
            c2878.m13471();
            f9872 = null;
        }
        C3439.f11831.m11208();
        f9901 = false;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public static void m9783(int i, int i2) {
        synchronized (f9898) {
            if (f9894 != null && f9893 != null) {
                m9791(null);
                try {
                    f9894.join();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        Thread thread = new Thread(new RunnableC2655(i, i2), f9855);
        f9894 = thread;
        thread.start();
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public static boolean m9784() {
        return f9901;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public static boolean m9785() {
        return f9890 != 0;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public static boolean m9786() {
        return f9900;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public static boolean m9787() {
        if (m9789()) {
            return false;
        }
        synchronized (f9898) {
            if (f9897 && f9901) {
                if (!m9785() || f9865 == null || f9891 == null) {
                    return false;
                }
                f9893.post(f9867);
                return true;
            }
            return false;
        }
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public static int m9788(int i) {
        if (i == 1) {
            return 4;
        }
        if (i == 4) {
            return 2;
        }
        return (i + 1) % f9854;
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public static boolean m9789() {
        return f9882 == 4;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public static void m9790(Runnable runnable) {
        Handler handler = f9893;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public static void m9791(Runnable runnable) {
        Handler handler = f9893;
        if (handler != null) {
            handler.post(new RunnableC2656(runnable));
        }
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public static void m9792() {
        C2483 c2483 = f9860;
        if (c2483 != null) {
            c2483.m13471();
            f9860.mo10877();
            f9860 = null;
        }
        C2390 c2390 = f9859;
        if (c2390 != null) {
            c2390.m8880();
            f9859 = null;
        }
        FloatBuffer floatBuffer = f9861;
        if (floatBuffer != null) {
            floatBuffer.clear();
            f9861 = null;
        }
        FloatBuffer floatBuffer2 = f9862;
        if (floatBuffer2 != null) {
            floatBuffer2.clear();
            f9862 = null;
        }
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public static void m9793(int i, boolean z, boolean z2, boolean z3, int i2) {
        if (f9901 && m9789()) {
            return;
        }
        System.nanoTime();
        Object obj = f9857;
        synchronized (obj) {
            if (f9866) {
                return;
            }
            f9858 = true;
            if (f9859 == null) {
                f9859 = new C2390(f9863, f9864, true);
            }
            if (f9860 == null) {
                C2483 c2483 = new C2483();
                f9860 = c2483;
                c2483.m13477();
                f9860.mo9491(f9863, f9864);
            }
            if (f9861 == null) {
                FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
                f9861 = floatBufferAsFloatBuffer;
                floatBufferAsFloatBuffer.put(b2.f93).position(0);
            }
            if (f9862 == null) {
                FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
                f9862 = floatBufferAsFloatBuffer2;
                floatBufferAsFloatBuffer2.put(b2.f98).position(0);
            }
            C3732.m11943("before resizeSourceTexture");
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(0, 0, f9863, f9864);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            f9861.clear();
            if (z3) {
                if (z2) {
                    f9861.put(b2.f97).position(0);
                } else {
                    f9861.put(b2.f96).position(0);
                }
            } else if (z2) {
                f9861.put(b2.f95).position(0);
            } else {
                f9861.put(b2.f93).position(0);
            }
            f9862.clear();
            if (z) {
                if (z2) {
                    f9862.put(b2.f99).position(0);
                } else {
                    f9862.put(b2.f101).position(0);
                }
            } else if (z2) {
                f9862.put(b2.f99).position(0);
            } else {
                f9862.put(b2.f98).position(0);
            }
            GLES20.glBindFramebuffer(36160, f9859.m8881());
            C3732.m11943("resizeSourceTexture after glBindFramebuffer ");
            GLES20.glViewport(0, 0, f9863, f9864);
            GLES20.glClearColor(0.0745f, 0.0706f, 0.0667f, 1.0f);
            f9860.m13479(i, f9861, f9862);
            GLES20.glBindFramebuffer(36160, 0);
            C3439.f11831.m11210();
            synchronized (obj) {
                f9858 = false;
            }
            if (f9899 != f9859.m8882()) {
                m9799(f9859.m8882(), EGL14.eglGetCurrentContext());
            }
            System.nanoTime();
        }
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public static void m9794(SurfaceTexture surfaceTexture, int i, int i2) {
        Handler handler = f9893;
        if (handler == null) {
            return;
        }
        handler.post(new RunnableC2652(surfaceTexture, i, i2));
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public static void m9795(int i, int i2) {
        f9869 = i;
        f9870 = i2;
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public static void m9796(InterfaceC2658 interfaceC2658) {
        f9903 = interfaceC2658;
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public static void m9797(int i) {
        f9882 = i;
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public static void m9798() {
        for (int i = 0; i < 128; i++) {
            int[] iArr = f9879;
            int i2 = iArr[i];
            iArr[i] = i2 + ((f9878[i] - i2) / 3);
            int[] iArr2 = f9881;
            int i3 = iArr2[i];
            iArr2[i] = i3 + ((f9880[i] - i3) / 3);
            int[] iArr3 = f9877;
            int i4 = iArr3[i];
            iArr3[i] = i4 + ((f9876[i] - i4) / 3);
            int[] iArr4 = f9874;
            int i5 = iArr4[i];
            iArr4[i] = i5 + ((f9873[i] - i5) / 3);
        }
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public static void m9799(int i, EGLContext eGLContext) {
        synchronized (f9898) {
            if (f9897 && f9869 != 0 && f9870 != 0) {
                f9899 = i;
                f9893.post(new RunnableC2657(i));
            }
        }
    }
}
