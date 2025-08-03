package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.net.Uri;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.videotools.CameraView;
import com.blink.academy.film.videotools.FrameRenderer;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.AbstractC2341;
import defpackage.C5220;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import org.jcodec.codecs.vpx.vp9.Consts;

/* compiled from: VideoAudioMuxer.java */
/* loaded from: classes.dex */
public class q5 implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: ࢯ, reason: contains not printable characters */
    public static int f8321 = 30;

    /* renamed from: ࢰ, reason: contains not printable characters */
    public static int f8322 = 30;

    /* renamed from: ࢱ, reason: contains not printable characters */
    public static long f8323 = 3758096384L;

    /* renamed from: ࢲ, reason: contains not printable characters */
    public static C2390 f8324;

    /* renamed from: ࢳ, reason: contains not printable characters */
    public static C4327 f8325;

    /* renamed from: ࢴ, reason: contains not printable characters */
    public static FloatBuffer f8326;

    /* renamed from: ࢶ, reason: contains not printable characters */
    public static FloatBuffer f8327;

    /* renamed from: ࢷ, reason: contains not printable characters */
    public static final Object f8328;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public MediaFormat f8330;

    /* renamed from: ԭ, reason: contains not printable characters */
    public MediaFormat f8331;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public HandlerThread f8332;

    /* renamed from: ԯ, reason: contains not printable characters */
    public Handler f8333;

    /* renamed from: ֈ, reason: contains not printable characters */
    public C3848 f8335;

    /* renamed from: ֏, reason: contains not printable characters */
    public C2905 f8336;

    /* renamed from: ׯ, reason: contains not printable characters */
    public MediaMuxer f8337;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f8342;

    /* renamed from: ބ, reason: contains not printable characters */
    public long f8343;

    /* renamed from: ޅ, reason: contains not printable characters */
    public long f8344;

    /* renamed from: އ, reason: contains not printable characters */
    public boolean f8346;

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean f8347;

    /* renamed from: މ, reason: contains not printable characters */
    public boolean f8348;

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean f8349;

    /* renamed from: ދ, reason: contains not printable characters */
    public boolean f8350;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f8351;

    /* renamed from: ލ, reason: contains not printable characters */
    public boolean f8352;

    /* renamed from: ގ, reason: contains not printable characters */
    public C5220 f8353;

    /* renamed from: ޏ, reason: contains not printable characters */
    public a2 f8354;

    /* renamed from: ސ, reason: contains not printable characters */
    public C5220.C5226 f8355;

    /* renamed from: ޒ, reason: contains not printable characters */
    public StringBuilder f8357;

    /* renamed from: ޓ, reason: contains not printable characters */
    public StringBuilder f8358;

    /* renamed from: ޔ, reason: contains not printable characters */
    public CameraView.InterfaceC0828 f8359;

    /* renamed from: ޕ, reason: contains not printable characters */
    public long f8360;

    /* renamed from: ޖ, reason: contains not printable characters */
    public u8 f8361;

    /* renamed from: ޗ, reason: contains not printable characters */
    public C2377 f8362;

    /* renamed from: ޙ, reason: contains not printable characters */
    public C3606 f8364;

    /* renamed from: ޚ, reason: contains not printable characters */
    public C4565 f8365;

    /* renamed from: ޞ, reason: contains not printable characters */
    public SurfaceTexture f8369;

    /* renamed from: ޡ, reason: contains not printable characters */
    public int f8372;

    /* renamed from: ޢ, reason: contains not printable characters */
    public int f8373;

    /* renamed from: ޣ, reason: contains not printable characters */
    public int f8374;

    /* renamed from: ޤ, reason: contains not printable characters */
    public int f8375;

    /* renamed from: ޥ, reason: contains not printable characters */
    public int f8376;

    /* renamed from: ޱ, reason: contains not printable characters */
    public int f8377;

    /* renamed from: ߾, reason: contains not printable characters */
    public boolean f8378;

    /* renamed from: ࡦ, reason: contains not printable characters */
    public boolean f8386;

    /* renamed from: ࡧ, reason: contains not printable characters */
    public int f8387;

    /* renamed from: ࡨ, reason: contains not printable characters */
    public long f8388;

    /* renamed from: ࡩ, reason: contains not printable characters */
    public long f8389;

    /* renamed from: ࡪ, reason: contains not printable characters */
    public long f8390;

    /* renamed from: ࢠ, reason: contains not printable characters */
    public long f8391;

    /* renamed from: ࢢ, reason: contains not printable characters */
    public boolean f8393;

    /* renamed from: ࢥ, reason: contains not printable characters */
    public long f8396;

    /* renamed from: ࢧ, reason: contains not printable characters */
    public long f8398;

    /* renamed from: ࢪ, reason: contains not printable characters */
    public long f8401;

    /* renamed from: ࢫ, reason: contains not printable characters */
    public long f8402;

    /* renamed from: ࢮ, reason: contains not printable characters */
    public InterfaceC2244 f8405;

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f8329 = false;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final Object f8334 = new Object();

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f8338 = -1;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f8339 = -1;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f8340 = 0;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f8341 = 0;

    /* renamed from: ޑ, reason: contains not printable characters */
    public boolean f8356 = false;

    /* renamed from: ޘ, reason: contains not printable characters */
    public FrameRenderer f8363 = null;

    /* renamed from: ޛ, reason: contains not printable characters */
    public int f8366 = -1;

    /* renamed from: ޜ, reason: contains not printable characters */
    public int f8367 = -1;

    /* renamed from: ޝ, reason: contains not printable characters */
    public EGLSurface f8368 = null;

    /* renamed from: ޟ, reason: contains not printable characters */
    public int f8370 = -1;

    /* renamed from: ޠ, reason: contains not printable characters */
    public int f8371 = -1;

    /* renamed from: ߿, reason: contains not printable characters */
    public Uri f8379 = null;

    /* renamed from: ࡠ, reason: contains not printable characters */
    public long f8380 = -1;

    /* renamed from: ࡡ, reason: contains not printable characters */
    public boolean f8381 = false;

    /* renamed from: ࡢ, reason: contains not printable characters */
    public float f8382 = 1.0f;

    /* renamed from: ࡣ, reason: contains not printable characters */
    public long f8383 = -1;

    /* renamed from: ࡤ, reason: contains not printable characters */
    public long f8384 = 0;

    /* renamed from: ࡥ, reason: contains not printable characters */
    public long f8385 = 0;

    /* renamed from: ࢡ, reason: contains not printable characters */
    public long f8392 = -1;

    /* renamed from: ࢣ, reason: contains not printable characters */
    public long f8394 = 0;

    /* renamed from: ࢤ, reason: contains not printable characters */
    public long f8395 = 0;

    /* renamed from: ࢦ, reason: contains not printable characters */
    public long f8397 = 0;

    /* renamed from: ࢨ, reason: contains not printable characters */
    public long f8399 = -1;

    /* renamed from: ࢩ, reason: contains not printable characters */
    public long f8400 = 0;

    /* renamed from: ࢬ, reason: contains not printable characters */
    public float[] f8403 = new float[16];

    /* renamed from: ࢭ, reason: contains not printable characters */
    public boolean f8404 = false;

    /* renamed from: ކ, reason: contains not printable characters */
    public String f8345 = C2462.m9035().m9047();

    /* compiled from: VideoAudioMuxer.java */
    /* renamed from: q5$Ϳ, reason: contains not printable characters */
    public class RunnableC2229 implements Runnable {
        public RunnableC2229() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q5.this.f8335 = null;
        }
    }

    /* compiled from: VideoAudioMuxer.java */
    /* renamed from: q5$Ԩ, reason: contains not printable characters */
    public class RunnableC2230 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ long f8407;

        public RunnableC2230(long j) {
            this.f8407 = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (q5.f8328) {
                q5.this.m8049(this.f8407, q5.f8324.m8882());
            }
        }
    }

    /* compiled from: VideoAudioMuxer.java */
    /* renamed from: q5$Ԫ, reason: contains not printable characters */
    public class RunnableC2231 implements Runnable {
        public RunnableC2231() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q5.this.m8036();
        }
    }

    /* compiled from: VideoAudioMuxer.java */
    /* renamed from: q5$Ԭ, reason: contains not printable characters */
    public class RunnableC2232 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f8410;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f8411;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f8412;

        public RunnableC2232(int i, int i2, int i3) {
            this.f8410 = i;
            this.f8411 = i2;
            this.f8412 = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            q5.this.f8354.m4(this.f8410, this.f8411, this.f8412);
            q5 q5Var = q5.this;
            q5Var.f8370 = q5Var.f8354.f0;
            q5 q5Var2 = q5.this;
            q5Var2.f8371 = q5Var2.f8354.f1;
            if (q5.this.f8350) {
                q5 q5Var3 = q5.this;
                q5Var3.f8370 = q5Var3.f8354.f1;
                q5 q5Var4 = q5.this;
                q5Var4.f8371 = q5Var4.f8354.f0;
            }
        }
    }

    /* compiled from: VideoAudioMuxer.java */
    /* renamed from: q5$Ԯ, reason: contains not printable characters */
    public class RunnableC2233 implements Runnable {
        public RunnableC2233() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q5 q5Var = q5.this;
            q5Var.m8045(q5Var.f8354);
        }
    }

    /* compiled from: VideoAudioMuxer.java */
    /* renamed from: q5$ՠ, reason: contains not printable characters */
    public class RunnableC2234 implements Runnable {
        public RunnableC2234() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q5.this.m8054();
        }
    }

    /* compiled from: VideoAudioMuxer.java */
    /* renamed from: q5$ֈ, reason: contains not printable characters */
    public class RunnableC2235 implements Runnable {
        public RunnableC2235() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q5.this.f8359 != null) {
                q5.this.f8359.mo1364();
            }
            q5.this.m8042();
        }
    }

    /* compiled from: VideoAudioMuxer.java */
    /* renamed from: q5$֏, reason: contains not printable characters */
    public class RunnableC2236 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float f8417;

        public RunnableC2236(float f) {
            this.f8417 = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C4112.m13055() && q5.this.f8344 == 0 && !q5.this.m8032()) {
                if (q5.this.f8359 != null) {
                    q5.this.f8359.mo1364();
                    return;
                }
                return;
            }
            q5.this.m8033();
            q5.this.f8404 = C2764.m10018().m10034();
            if (q5.this.f8404) {
                C2764.m10018().m10020();
                C2764.m10018().m10024();
                C2764.m10018().m10026();
                C2764.m10018().m10027();
                C2764.m10018().m10031();
                C2764.m10018().m10030();
            }
            q5.this.m8041(this.f8417);
        }
    }

    /* compiled from: VideoAudioMuxer.java */
    /* renamed from: q5$ׯ, reason: contains not printable characters */
    public class RunnableC2237 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f8419;

        public RunnableC2237(int i) {
            this.f8419 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f8419;
            if (i != 0) {
                q5.this.f8344 = i;
                q5.this.f8343 = this.f8419 * 1000;
            } else {
                q5.this.f8343 = 1000000 / q5.f8321;
                q5.this.f8344 = 0L;
            }
            q5 q5Var = q5.this;
            q5Var.f8360 = q5Var.f8343 * 1000;
            if (q5.this.f8329) {
                C4638.m14099("VideoAudioMuxer", String.format("timeLapseMs : %s , previewFpsTimeUs : %s , needFpsIntervalNs : %s ", Integer.valueOf(this.f8419), Long.valueOf(q5.this.f8343), Long.valueOf(q5.this.f8360)));
            }
        }
    }

    /* compiled from: VideoAudioMuxer.java */
    /* renamed from: q5$ؠ, reason: contains not printable characters */
    public class RunnableC2238 implements Runnable {
        public RunnableC2238() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q5.this.m8042();
        }
    }

    /* compiled from: VideoAudioMuxer.java */
    /* renamed from: q5$ހ, reason: contains not printable characters */
    public class RunnableC2239 implements Runnable {

        /* compiled from: VideoAudioMuxer.java */
        /* renamed from: q5$ހ$Ϳ, reason: contains not printable characters */
        public class RunnableC2240 implements Runnable {

            /* compiled from: VideoAudioMuxer.java */
            /* renamed from: q5$ހ$Ϳ$Ϳ, reason: contains not printable characters */
            public class RunnableC2241 implements Runnable {

                /* compiled from: VideoAudioMuxer.java */
                /* renamed from: q5$ހ$Ϳ$Ϳ$Ϳ, reason: contains not printable characters */
                public class RunnableC2242 implements Runnable {
                    public RunnableC2242() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (q5.this.f8405 != null) {
                            q5.this.f8405.mo1352();
                        }
                        if (q5.this.f8344 == 0) {
                            q5.this.f8381 = true;
                        } else {
                            q5.this.f8393 = true;
                            q5.this.m8036();
                        }
                        if (q5.this.f8329) {
                            C4638.m14099("VideoAudioMuxer", String.format("true start time : %s ", Long.valueOf(System.nanoTime() - q5.this.f8380)));
                        }
                    }
                }

                public RunnableC2241() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    q5.this.f8333.post(new RunnableC2242());
                }
            }

            public RunnableC2240() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (q5.this.f8361 != null) {
                    q5.this.f8361.m8365();
                }
                q5 q5Var = q5.this;
                q5Var.f8361 = new u8(q5Var.f8362, q5.this.f8335.m12275(), true);
                q5.this.f8335.m12285(new RunnableC2241());
            }
        }

        public RunnableC2239() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q5.this.f8333.post(new RunnableC2240());
        }
    }

    /* compiled from: VideoAudioMuxer.java */
    /* renamed from: q5$ށ, reason: contains not printable characters */
    public class RunnableC2243 implements Runnable {
        public RunnableC2243() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q5.this.m8054();
            q5.this.m8038();
        }
    }

    /* compiled from: VideoAudioMuxer.java */
    /* renamed from: q5$ނ, reason: contains not printable characters */
    public interface InterfaceC2244 {
        /* renamed from: Ϳ */
        void mo1352();

        /* renamed from: Ԩ */
        void mo1353(long j);
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f8323 = Long.MAX_VALUE;
        }
        f8328 = new Object();
    }

    public q5(boolean z, boolean z2, boolean z3, C5220 c5220, a2 a2Var, C5220.C5226 c5226) {
        this.f8350 = false;
        this.f8347 = z;
        this.f8348 = z2;
        this.f8349 = z3;
        this.f8353 = c5220;
        this.f8354 = a2Var;
        this.f8355 = c5226;
        if (a2Var == null) {
            throw new RuntimeException("config cont null");
        }
        this.f8350 = a2Var.f13;
        this.f8352 = a2Var.f15;
        this.f8351 = a2Var.f14;
        int i = a2Var.f4;
        f8321 = i;
        f8322 = a2Var.f5;
        int i2 = a2Var.f7;
        if (i2 != 0) {
            this.f8344 = i2;
            this.f8343 = i2 * 1000;
        } else {
            this.f8343 = 1000000 / i;
            this.f8344 = 0L;
        }
        this.f8360 = this.f8343 * 1000;
        this.f8342 = 1;
        if (z) {
            this.f8342 = 2;
        }
        m8043();
    }

    /* renamed from: ࡠ, reason: contains not printable characters */
    public static void m8028() {
        C4327 c4327 = f8325;
        if (c4327 != null) {
            c4327.m13471();
            f8325.mo10877();
            f8325 = null;
        }
        C2390 c2390 = f8324;
        if (c2390 != null) {
            c2390.m8880();
            f8324 = null;
        }
        FloatBuffer floatBuffer = f8326;
        if (floatBuffer != null) {
            floatBuffer.clear();
            f8326 = null;
        }
        FloatBuffer floatBuffer2 = f8327;
        if (floatBuffer2 != null) {
            floatBuffer2.clear();
            f8327 = null;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        C2905 c2905;
        if (this.f8369 == null) {
            return;
        }
        System.nanoTime();
        if (Build.VERSION.SDK_INT < 26 || !surfaceTexture.isReleased()) {
            surfaceTexture.updateTexImage();
            if (this.f8404) {
                return;
            }
            System.nanoTime();
            if (this.f8381 && this.f8335 != null) {
                if (this.f8387 == 0) {
                    C4621.m14078();
                    C4621.m14079(1.0f);
                    if (m8048() && (c2905 = this.f8336) != null) {
                        c2905.m10308();
                    }
                    this.f8400 = 0L;
                    this.f8388 = 0L;
                    this.f8389 = surfaceTexture.getTimestamp();
                }
                long timestamp = surfaceTexture.getTimestamp();
                this.f8367 = this.f8366;
                m8034(timestamp, false);
            }
            System.nanoTime();
        }
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public synchronized void m8029(int i, MediaFormat mediaFormat) {
        if (i == 0) {
            this.f8331 = mediaFormat;
            this.f8341++;
        } else if (i == 1) {
            this.f8330 = mediaFormat;
            this.f8341++;
        }
        m8058();
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final boolean m8030() {
        return this.f8341 >= this.f8342;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final boolean m8031() {
        return this.f8340 >= this.f8342;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final boolean m8032() {
        C5220 c5220 = this.f8353;
        return c5220 != null && c5220.m15231();
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m8033() {
        this.f8362.m8853(this.f8368);
        this.f8365 = new C4565();
        m8064();
        C3606 c3606M11908 = this.f8365.m11908();
        this.f8364 = c3606M11908;
        c3606M11908.m13477();
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final void m8034(long j, boolean z) {
        long j2;
        boolean z2;
        long j3 = this.f8388 + ((this.f8387 * 1000000000) / f8322);
        long jM14076 = C4621.m14076();
        long j4 = ((j - this.f8389) * f8321) / f8322;
        if (this.f8329) {
            C4638.m14099("VideoAudioMuxer", String.format("frameNum : %s , RecordTime : %s , fpsTime : %s , textureTime : %s ", Integer.valueOf(this.f8387), Long.valueOf(jM14076), Long.valueOf(j3), Long.valueOf(j4)));
        }
        if (j3 - jM14076 > this.f8360) {
            if (this.f8329) {
                C4638.m14099("VideoAudioMuxer", String.format("need drop frame ! ", new Object[0]));
                return;
            }
            return;
        }
        long j5 = j3 / 1000000000;
        int i = this.f8387 % f8322;
        if (this.f8329) {
            C4638.m14099("VideoAudioMuxer", String.format("timeS : %s , frame : %s ", Long.valueOf(j5), Integer.valueOf(i)));
        }
        if (z) {
            if (j5 != this.f8399) {
                if (this.f8357.length() != 0) {
                    StringBuilder sb = this.f8357;
                    sb.append("]");
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                StringBuilder sb2 = this.f8357;
                sb2.append("[");
                sb2.append(j5);
                sb2.append("]");
                sb2.append("[");
                this.f8399 = j5;
                this.f8357.append(i);
            } else {
                StringBuilder sb3 = this.f8357;
                sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb3.append(i);
            }
        }
        if (this.f8394 - this.f8395 > 5 && j4 - j3 > this.f8360) {
            if (this.f8329) {
                C4638.m14099("VideoAudioMuxer", String.format("need change timestamp : %s , curTextureTime : %s ", Long.valueOf(j3), Long.valueOf(j4)));
            }
            j3 = j4;
        }
        long j6 = jM14076 - this.f8390;
        int i2 = this.f8387;
        if (i2 == 0) {
            j6 = this.f8360;
            this.f8397 = 0L;
        }
        long j7 = i2 != 0 ? j - this.f8398 : 0L;
        long j8 = this.f8360;
        if (j6 > j8) {
            this.f8391 += j6 - j8;
        } else {
            this.f8391 -= j8 - j6;
        }
        if (f8321 != f8322) {
            this.f8391 = 0L;
        }
        if (this.f8329) {
            long j9 = this.f8402 / 1000000;
            j2 = j3;
            C4638.m14099("VideoAudioMuxer", String.format("frameNum : %s , needFpsTime : %s , intervalTime : %s , textureFpsTime : %s , lastDrawCostTimeMs : %s , hasDelayedTimeMs : %s ", Integer.valueOf(i2), Long.valueOf(this.f8360), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j9), Long.valueOf(this.f8391 / 1000000)));
            long j10 = this.f8400 + j9;
            this.f8400 = j10;
            long j11 = j10 / (this.f8387 + 1);
            this.f8401 = j11;
            z2 = false;
            C4638.m14101("VideoAudioMuxer", String.format("avg : %s ", Long.valueOf(j11)));
        } else {
            j2 = j3;
            z2 = false;
        }
        long jNanoTime = System.nanoTime();
        if (f8322 == 6) {
            long j12 = j2;
            m8040(j12, z2);
            m8040(41666666 + j12, z2);
            m8040(83333332 + j12, z2);
            m8040(124999998 + j12, this.f8386);
        } else {
            m8040(j2, this.f8386);
        }
        this.f8396 = Math.max(this.f8396, System.nanoTime() - jNanoTime);
        this.f8387++;
        this.f8390 = jM14076;
        this.f8398 = j;
        long j13 = this.f8391;
        if (j13 > 0) {
            long j14 = j13 / this.f8360;
            if (this.f8329) {
                C4638.m14101("VideoAudioMuxer", String.format("curDropped frame num : %s  , maxDrawTimeNs : %s , lastDrawCostTimeNs : %s , hasDroppedFrameCount : %s  , repeatFrameCount : %s ", Long.valueOf(j14), Long.valueOf(this.f8396), Long.valueOf(this.f8402), Long.valueOf(this.f8394), Long.valueOf(this.f8395)));
            }
            if (j14 > 0) {
                long j15 = j14 + this.f8395;
                this.f8394 = j15;
                InterfaceC2244 interfaceC2244 = this.f8405;
                if (interfaceC2244 != null) {
                    interfaceC2244.mo1353(Math.max(j15, this.f8397));
                }
                this.f8397 = Math.max(this.f8394, this.f8397);
            }
            if (j14 <= 0 || this.f8402 >= this.f8360 / 2) {
                return;
            }
            this.f8395++;
            m8034(j, true);
        }
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public void m8035(int i, int i2, int i3, long j) {
        if ((!this.f8381 || this.f8335 == null) && (this.f8344 == 0 || this.f8335 == null)) {
            return;
        }
        long jNanoTime = System.nanoTime();
        synchronized (f8328) {
            if (f8324 == null) {
                f8324 = new C2390(i, i2, true);
            }
            C2390 c2390 = f8324;
            if (c2390.f8945 != i || c2390.f8946 != i2) {
                c2390.m8880();
                f8324 = new C2390(i, i2, true);
            }
            if (f8325 == null) {
                C4327 c4327 = new C4327();
                f8325 = c4327;
                c4327.m13477();
            }
            f8325.mo9491(i, i2);
            if (f8326 == null) {
                FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
                f8326 = floatBufferAsFloatBuffer;
                floatBufferAsFloatBuffer.put(b2.f93).position(0);
            }
            if (f8327 == null) {
                FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
                f8327 = floatBufferAsFloatBuffer2;
                floatBufferAsFloatBuffer2.put(b2.f98).position(0);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glBindFramebuffer(36160, f8324.m8881());
            GLES20.glViewport(0, 0, i, i2);
            GLES20.glClearColor(0.0745f, 0.0706f, 0.0667f, 1.0f);
            f8325.m13479(i3, f8326, f8327);
            GLES20.glFinish();
            GLES20.glBindFramebuffer(36160, 0);
        }
        if (this.f8344 == 0) {
            this.f8333.post(new RunnableC2230(j));
        } else if (this.f8367 != f8324.m8882()) {
            this.f8367 = f8324.m8882();
        }
        long jNanoTime2 = System.nanoTime();
        if (this.f8329) {
            C4638.m14099("VideoAudioMuxer", String.format("cache Preview : %s ", Long.valueOf((jNanoTime2 - jNanoTime) / 1000000)));
        }
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final void m8036() {
        if (this.f8393) {
            if (this.f8387 == 0) {
                C4621.m14078();
                C4621.m14079(1.0f);
                this.f8388 = 0L;
            }
            long j = this.f8388 + ((this.f8387 * 1000000000) / f8322);
            long jM14076 = C4621.m14076();
            if (this.f8329) {
                C4638.m14099("VideoAudioMuxer", String.format("frameNum : %s , RecordTime : %s , fpsTime : %s ", Integer.valueOf(this.f8387), Long.valueOf(jM14076), Long.valueOf(j)));
            }
            m8040(j, false);
            this.f8387++;
            this.f8333.postDelayed(new RunnableC2231(), this.f8344);
        }
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public void m8037() {
        this.f8333.post(new RunnableC2235());
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final void m8038() {
        EGLSurface eGLSurface;
        if (this.f8329) {
            C4638.m14101("VideoAudioMuxer", "mediaMuxer exitThread ... ");
        }
        FrameRenderer frameRenderer = this.f8363;
        if (frameRenderer != null) {
            frameRenderer.m2049();
            this.f8363 = null;
        }
        C3606 c3606 = this.f8364;
        if (c3606 != null) {
            c3606.m13471();
            this.f8364.mo10877();
            this.f8364 = null;
        }
        C4565 c4565 = this.f8365;
        if (c4565 != null) {
            c4565.mo11907();
            this.f8365 = null;
        }
        SurfaceTexture surfaceTexture = this.f8369;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(null);
            this.f8369.release();
            this.f8369 = null;
        }
        C4378.m13548(this.f8366);
        C2377 c2377 = this.f8362;
        if (c2377 != null && (eGLSurface = this.f8368) != null) {
            c2377.m8855(eGLSurface);
        }
        C3439.f11831.m11208();
        C2377 c23772 = this.f8362;
        if (c23772 != null) {
            c23772.m8854();
            this.f8362 = null;
        }
        synchronized (this.f8334) {
            HandlerThread handlerThread = this.f8332;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.f8332 = null;
            this.f8333 = null;
            this.f8378 = false;
            this.f8334.notify();
        }
        if (this.f8329) {
            C4638.m14101("VideoAudioMuxer", "mediaMuxer exitThread 完毕... ");
        }
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public final void m8039() {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_pending", (Integer) 0);
            if (this.f8379 != null) {
                FilmApp.m402().getContentResolver().update(this.f8379, contentValues, null, null);
                this.f8379 = null;
            }
        }
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public final boolean m8040(long j, boolean z) {
        long jNanoTime = System.nanoTime();
        this.f8361.m8860();
        int i = this.f8367;
        float fM5922 = 1.0f / d9.m5921().m5922();
        if (this.f8404 && C2764.m10018().m10024() != 0.0f) {
            fM5922 = 1.0f / (d9.m5921().m5922() + 0.05f);
        }
        Matrix.setIdentityM(this.f8403, 0);
        if (fM5922 != 1.0f) {
            float f = (1.0f - fM5922) * 0.5f;
            Matrix.translateM(this.f8403, 0, f, f, 0.0f);
            Matrix.scaleM(this.f8403, 0, fM5922, fM5922, 0.0f);
        }
        this.f8365.m13992(this.f8403);
        FrameRenderer frameRenderer = this.f8363;
        int i2 = this.f8370;
        int i3 = this.f8371;
        frameRenderer.m2055(true, 0, 0, 0, i2, i3, 0, 0, i2, i3, this.f8364, i, this.f8372, this.f8373, this.f8374, this.f8375, this.f8376, this.f8377, 0, false, this.f8348, this.f8349, this.f8350, this.f8352);
        System.nanoTime();
        this.f8361.m8862(j);
        this.f8361.m8863();
        System.nanoTime();
        this.f8335.m12279(z);
        this.f8402 = System.nanoTime() - jNanoTime;
        return true;
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public final void m8041(float f) {
        if (this.f8329) {
            C4638.m14101("VideoAudioMuxer", String.format("VideoAudioMuxer handleStartRecording ! : %s ", "!"));
        }
        this.f8382 = f;
        m8052();
        this.f8380 = System.nanoTime();
        this.f8383 = -1L;
        this.f8340 = 0;
        this.f8341 = 0;
        this.f8387 = 0;
        this.f8388 = 0L;
        this.f8389 = 0L;
        this.f8390 = 0L;
        this.f8391 = 0L;
        this.f8394 = 0L;
        this.f8396 = 0L;
        this.f8395 = 0L;
        this.f8399 = -1L;
        this.f8384 = 0L;
        this.f8385 = 0L;
        this.f8357 = new StringBuilder();
        this.f8358 = new StringBuilder();
        this.f8345 = C2462.m9035().m9047();
        C4621.m14078();
        C4621.m14079(1.0f);
        this.f8386 = false;
        this.f8346 = false;
        m8046();
        m8044();
        if (m8048()) {
            this.f8336.m10304(this.f8355);
        }
        StringBuilder sb = this.f8358;
        sb.append("videoPath:");
        sb.append(this.f8345);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("videoFps:");
        sb.append(f8322);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("previewSize:");
        sb.append(this.f8372);
        sb.append("*");
        sb.append(this.f8373);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("videoSize:");
        sb.append(this.f8370);
        sb.append("*");
        sb.append(this.f8371);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("videoBitrate:");
        sb.append(this.f8354.f2);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("hasAudioPermission:");
        sb.append(this.f8347);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("mAudioLevel:");
        sb.append(this.f8382);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("hasAudio:");
        sb.append(m8048());
        this.f8335.m12281(new RunnableC2239());
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public final void m8042() {
        C2905 c2905;
        C2905 c29052;
        if (this.f8329) {
            C4638.m14101("VideoAudioMuxer", String.format("VideoAudioMuxer handleStopRecording ! : %s ", "!"));
        }
        if (this.f8380 == -1) {
            if (this.f8329) {
                C4638.m14101("VideoAudioMuxer", String.format("VideoAudioMuxer should not run here ! : %s ", "!"));
            }
            if (m8048() && (c29052 = this.f8336) != null) {
                c29052.m10309();
                this.f8336 = null;
            }
            C3848 c3848 = this.f8335;
            if (c3848 != null) {
                this.f8386 = true;
                c3848.m12286();
                this.f8335 = null;
            }
            m8054();
            return;
        }
        if (this.f8383 != -1) {
            return;
        }
        this.f8383 = System.nanoTime();
        if (m8048() && (c2905 = this.f8336) != null) {
            c2905.m10309();
            this.f8336 = null;
        }
        C3848 c38482 = this.f8335;
        if (c38482 != null) {
            if (this.f8344 == 0) {
                this.f8386 = true;
            } else {
                this.f8393 = false;
                c38482.m12279(true);
            }
        }
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public final void m8043() {
        if (this.f8378) {
            synchronized (this.f8334) {
                try {
                    this.f8334.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        synchronized (this.f8334) {
            HandlerThread handlerThread = new HandlerThread("VideoAudioMuxer");
            this.f8332 = handlerThread;
            handlerThread.setPriority(10);
            this.f8332.start();
            Handler handler = new Handler(this.f8332.getLooper());
            this.f8333 = handler;
            handler.post(new RunnableC2233());
        }
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public final void m8044() {
        if (m8048()) {
            this.f8336 = new C2905(this.f8353, this);
        }
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public final void m8045(a2 a2Var) {
        int i = a2Var.f9;
        this.f8372 = i;
        int i2 = i - (i % 2);
        this.f8372 = i2;
        int i3 = a2Var.f10;
        this.f8373 = i3;
        int i4 = i3 - (i3 % 2);
        this.f8373 = i4;
        this.f8376 = i2;
        this.f8376 = i2 - (i2 % 2);
        int i5 = (int) (i4 / (a2Var.f11 ? a2Var.f12 : 1.0f));
        this.f8377 = i5;
        this.f8377 = i5 - (i5 % 2);
        int i6 = a2Var.f0;
        this.f8370 = i6;
        int i7 = a2Var.f1;
        this.f8371 = i7;
        if (this.f8350) {
            this.f8370 = i7;
            this.f8371 = i6;
        }
        this.f8374 = i2;
        this.f8375 = i4;
        if (this.f8329) {
            C4638.m14099("VideoAudioMuxer", String.format("mVideoWidth : %s , mVideoHeight : %s , texWidth : %s , textHeight : %s , captureWidth : %s , captureheight : %s , filterWidth : %s , filterHeight : %s ", Integer.valueOf(this.f8370), Integer.valueOf(this.f8371), Integer.valueOf(this.f8372), Integer.valueOf(this.f8373), Integer.valueOf(this.f8374), Integer.valueOf(this.f8375), Integer.valueOf(this.f8376), Integer.valueOf(this.f8377)));
        }
        C2377 c2377 = new C2377(C3732.m11945().m11954(), 1);
        this.f8362 = c2377;
        EGLSurface eGLSurfaceM8850 = c2377.m8850(16, 16);
        this.f8368 = eGLSurfaceM8850;
        this.f8362.m8853(eGLSurfaceM8850);
        int iM13547 = C4378.m13547();
        this.f8366 = iM13547;
        this.f8367 = iM13547;
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f8367);
        this.f8369 = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(this.f8372, this.f8373);
        this.f8369.setOnFrameAvailableListener(this, this.f8333);
        Handler handler = a2Var.f8;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1, this.f8369));
        }
        this.f8363 = new FrameRenderer();
        if (this.f8329) {
            C4638.m14099("VideoAudioMuxer", String.format("initGlContext  : %s ", a2Var));
        }
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public final void m8046() {
        if (e5.m5988().m5993() && C4535.m13880().m13890().m12423() == 1) {
            a2 a2Var = this.f8354;
            a2Var.f0 = Consts.BORDERINPIXELS;
            a2Var.f1 = Consts.BORDERINPIXELS;
            if (this.f8329) {
                Log.d("VideoAudioMuxer", "initVideoEncoder change width");
            }
        }
        this.f8335 = new C3848(this.f8354, this, this.f8348);
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public boolean m8047() {
        return this.f8346;
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public final boolean m8048() {
        if (!this.f8347 || this.f8382 == 0.0f) {
            return false;
        }
        return m8032();
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public void m8049(long j, int i) {
        if (!this.f8381 || this.f8335 == null) {
            return;
        }
        this.f8367 = i;
        if (this.f8387 == 0) {
            C4621.m14078();
            C4621.m14079(1.0f);
            if (m8048()) {
                this.f8336.m10308();
            }
            this.f8400 = 0L;
            this.f8388 = 0L;
            this.f8389 = j;
        }
        m8034(j, false);
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public final ParcelFileDescriptor m8050(String str) {
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
            this.f8379 = uriInsert;
            try {
                return contentResolver.openFileDescriptor(uriInsert, "w");
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public final void m8051() throws IOException {
        ParcelFileDescriptor parcelFileDescriptorM8050;
        long jNanoTime = System.nanoTime();
        if (Build.VERSION.SDK_INT < 26 || (parcelFileDescriptorM8050 = m8050(this.f8345)) == null) {
            this.f8337 = new MediaMuxer(this.f8345, 0);
        } else {
            this.f8337 = new MediaMuxer(parcelFileDescriptorM8050.getFileDescriptor(), 0);
        }
        this.f8338 = this.f8337.addTrack(this.f8331);
        if (m8048()) {
            this.f8339 = this.f8337.addTrack(this.f8330);
        }
        long jNanoTime2 = System.nanoTime();
        if (this.f8329) {
            C4638.m14099("VideoAudioMuxer", String.format("prepareMuxer cost : %s ", Long.valueOf(jNanoTime2 - jNanoTime)));
        }
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public void m8052() {
        this.f8342 = 1;
        if (m8048()) {
            this.f8342 = 2;
        }
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public void m8053() {
        Handler handler = this.f8333;
        if (handler == null) {
            return;
        }
        handler.post(new RunnableC2243());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004c A[Catch: all -> 0x0103, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000a, B:8:0x0014, B:12:0x001e, B:13:0x0021, B:19:0x0042, B:21:0x004c, B:16:0x0028, B:18:0x002f, B:11:0x001b, B:22:0x0060, B:24:0x0064, B:25:0x0069, B:28:0x0071, B:30:0x0075, B:31:0x008b, B:33:0x0093, B:34:0x009a, B:36:0x009e, B:37:0x00b3, B:39:0x00b7, B:40:0x00cc, B:42:0x00d0, B:44:0x00e2, B:46:0x00f1, B:45:0x00ec, B:47:0x00ff), top: B:53:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064 A[Catch: all -> 0x0103, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000a, B:8:0x0014, B:12:0x001e, B:13:0x0021, B:19:0x0042, B:21:0x004c, B:16:0x0028, B:18:0x002f, B:11:0x001b, B:22:0x0060, B:24:0x0064, B:25:0x0069, B:28:0x0071, B:30:0x0075, B:31:0x008b, B:33:0x0093, B:34:0x009a, B:36:0x009e, B:37:0x00b3, B:39:0x00b7, B:40:0x00cc, B:42:0x00d0, B:44:0x00e2, B:46:0x00f1, B:45:0x00ec, B:47:0x00ff), top: B:53:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071 A[Catch: all -> 0x0103, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000a, B:8:0x0014, B:12:0x001e, B:13:0x0021, B:19:0x0042, B:21:0x004c, B:16:0x0028, B:18:0x002f, B:11:0x001b, B:22:0x0060, B:24:0x0064, B:25:0x0069, B:28:0x0071, B:30:0x0075, B:31:0x008b, B:33:0x0093, B:34:0x009a, B:36:0x009e, B:37:0x00b3, B:39:0x00b7, B:40:0x00cc, B:42:0x00d0, B:44:0x00e2, B:46:0x00f1, B:45:0x00ec, B:47:0x00ff), top: B:53:0x0001, inners: #1, #2 }] */
    /* renamed from: ࡡ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void m8054() {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q5.m8054():void");
    }

    /* renamed from: ࡢ, reason: contains not printable characters */
    public void m8055(CameraView.InterfaceC0828 interfaceC0828) {
        this.f8359 = interfaceC0828;
    }

    /* renamed from: ࡣ, reason: contains not printable characters */
    public q5 m8056(InterfaceC2244 interfaceC2244) {
        this.f8405 = interfaceC2244;
        return this;
    }

    /* renamed from: ࡤ, reason: contains not printable characters */
    public void m8057(int i) {
        this.f8333.post(new RunnableC2237(i));
    }

    /* renamed from: ࡥ, reason: contains not printable characters */
    public final void m8058() {
        if (this.f8346 || !m8030()) {
            return;
        }
        try {
            m8051();
            this.f8337.start();
            this.f8346 = true;
            if (this.f8329) {
                C4638.m14101("VideoAudioMuxer", "mediaMuxer started 完毕... ");
            }
            this.f8335.m12271();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: ࡦ, reason: contains not printable characters */
    public void m8059(float f) {
        this.f8333.post(new RunnableC2236(f));
    }

    /* renamed from: ࡧ, reason: contains not printable characters */
    public final void m8060() {
        if (m8031()) {
            this.f8378 = true;
            this.f8346 = false;
            Handler handler = this.f8333;
            if (handler != null) {
                handler.post(new RunnableC2234());
            } else {
                this.f8378 = false;
            }
        }
    }

    /* renamed from: ࡨ, reason: contains not printable characters */
    public void m8061() {
        Handler handler = this.f8333;
        if (handler == null) {
            return;
        }
        handler.post(new RunnableC2238());
    }

    /* renamed from: ࡩ, reason: contains not printable characters */
    public void m8062(int i) {
        if (i == 0) {
            this.f8381 = false;
            this.f8340++;
            Handler handler = this.f8333;
            if (handler != null) {
                handler.post(new RunnableC2229());
            }
        } else if (i == 1) {
            this.f8340++;
        }
        m8060();
    }

    /* renamed from: ࡪ, reason: contains not printable characters */
    public void m8063(C5220.C5226 c5226, boolean z, float f) {
        this.f8355 = c5226;
        this.f8347 = z;
        this.f8382 = f;
        m8052();
    }

    /* renamed from: ࢠ, reason: contains not printable characters */
    public final void m8064() {
    }

    /* renamed from: ࢡ, reason: contains not printable characters */
    public void m8065(int i, int i2, int i3) {
        this.f8333.post(new RunnableC2232(i, i2, i3));
    }

    /* renamed from: ࢢ, reason: contains not printable characters */
    public synchronized void m8066(o5 o5Var) {
        int i;
        ParcelFileDescriptor parcelFileDescriptorM8050;
        if (this.f8346) {
            int i2 = o5Var.f8080 == 0 ? this.f8338 : this.f8339;
            MediaCodec.BufferInfo bufferInfo = o5Var.f8082;
            ByteBuffer byteBuffer = o5Var.f8081;
            try {
                if (this.f8329) {
                    C4638.m14099("VideoAudioMuxer", String.format("hasWriteSize : %s , encodedData  : %s ", Long.valueOf(this.f8384), o5Var.toString()));
                }
                if (this.f8384 >= f8323 && o5Var.f8080 == 0 && bufferInfo.flags == 1) {
                    long jNanoTime = System.nanoTime();
                    this.f8337.stop();
                    m8039();
                    this.f8337.release();
                    long jNanoTime2 = System.nanoTime();
                    this.f8384 = 0L;
                    StringBuilder sb = new StringBuilder(this.f8357);
                    if (sb.length() > 0) {
                        sb.append("]");
                    }
                    if (this.f8329) {
                        C4638.m14099("VideoAudioMuxer", String.format("dropFrameInfoBuilder : %s ", sb.toString()));
                    }
                    if (this.f8359 != null) {
                        AbstractC2341.C2344 c2344 = new AbstractC2341.C2344();
                        c2344.m8795(this.f8345);
                        if (this.f8385 == 0) {
                            c2344.m8792(sb.toString());
                        } else {
                            c2344.m8792("");
                        }
                        c2344.m8794(sb.toString());
                        this.f8345 = C2462.m9035().m9053();
                        this.f8359.mo1360(c2344);
                    }
                    if (Build.VERSION.SDK_INT < 26 || (parcelFileDescriptorM8050 = m8050(this.f8345)) == null) {
                        this.f8337 = new MediaMuxer(this.f8345, 0);
                    } else {
                        this.f8337 = new MediaMuxer(parcelFileDescriptorM8050.getFileDescriptor(), 0);
                    }
                    this.f8338 = this.f8337.addTrack(this.f8331);
                    if (m8048()) {
                        this.f8339 = this.f8337.addTrack(this.f8330);
                    }
                    long jNanoTime3 = System.nanoTime();
                    this.f8337.start();
                    long jNanoTime4 = System.nanoTime();
                    i2 = o5Var.f8080 == 0 ? this.f8338 : this.f8339;
                    long j = bufferInfo.presentationTimeUs;
                    this.f8385 = j;
                    if (this.f8329) {
                        C4638.m14099("VideoAudioMuxer", String.format("needReduceTime : %s , release cost : %s , init cost : %s , start cost : %s ", Long.valueOf(j), Long.valueOf(jNanoTime2 - jNanoTime), Long.valueOf(jNanoTime3 - jNanoTime2), Long.valueOf(jNanoTime4 - jNanoTime3)));
                    }
                }
                bufferInfo.presentationTimeUs -= this.f8385;
                int i3 = bufferInfo.size;
                if (i3 >= 0 && (i = bufferInfo.offset) >= 0 && i + i3 <= byteBuffer.capacity() && bufferInfo.presentationTimeUs >= 0) {
                    this.f8337.writeSampleData(i2, byteBuffer, bufferInfo);
                    this.f8384 += bufferInfo.size;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (this.f8329) {
                    C4638.m14101("VideoAudioMuxer", "写入混合数据失败!" + e2.toString());
                }
            }
        }
    }
}
