package defpackage;

import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.blink.academy.filter.core.C1788;
import com.blink.academy.filter.core.C1793;
import com.blink.academy.filter.core.Drawable2d;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: У, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2870 {

    /* renamed from: ޖ, reason: contains not printable characters */
    public static final String f10502 = "FaceDetectEngine";

    /* renamed from: Ԩ, reason: contains not printable characters */
    public C3472 f10504;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public HandlerThread f10510;

    /* renamed from: ԯ, reason: contains not printable characters */
    public Handler f10511;

    /* renamed from: ՠ, reason: contains not printable characters */
    public EGLContext f10512;

    /* renamed from: ֈ, reason: contains not printable characters */
    public C3234 f10513;

    /* renamed from: ֏, reason: contains not printable characters */
    public EGLSurface f10514;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f10522;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f10523;

    /* renamed from: އ, reason: contains not printable characters */
    public Drawable2d f10524;

    /* renamed from: ވ, reason: contains not printable characters */
    public Drawable2d f10525;

    /* renamed from: މ, reason: contains not printable characters */
    public C1793 f10526;

    /* renamed from: ފ, reason: contains not printable characters */
    public C4874 f10527;

    /* renamed from: ދ, reason: contains not printable characters */
    public C2398 f10528;

    /* renamed from: ތ, reason: contains not printable characters */
    public C1788 f10529;

    /* renamed from: ލ, reason: contains not printable characters */
    public IntBuffer f10530;

    /* renamed from: ގ, reason: contains not printable characters */
    public C1788 f10531;

    /* renamed from: ޏ, reason: contains not printable characters */
    public C1788 f10532;

    /* renamed from: ސ, reason: contains not printable characters */
    public C1788 f10533;

    /* renamed from: ޒ, reason: contains not printable characters */
    public long f10535;

    /* renamed from: ޕ, reason: contains not printable characters */
    public InterfaceC2871 f10538;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f10503 = false;

    /* renamed from: ԩ, reason: contains not printable characters */
    public float[] f10505 = new float[16];

    /* renamed from: Ԫ, reason: contains not printable characters */
    public float[] f10506 = new float[16];

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f10507 = false;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Object f10508 = new Object();

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Object f10509 = new Object();

    /* renamed from: ׯ, reason: contains not printable characters */
    public InterfaceC3930 f10515 = new C2872();

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f10516 = false;

    /* renamed from: ހ, reason: contains not printable characters */
    public final float f10517 = 0.25f;

    /* renamed from: ށ, reason: contains not printable characters */
    public final float f10518 = 0.4f;

    /* renamed from: ނ, reason: contains not printable characters */
    public final float f10519 = 0.55f;

    /* renamed from: ރ, reason: contains not printable characters */
    public final float f10520 = 0.7f;

    /* renamed from: ބ, reason: contains not printable characters */
    public final float f10521 = 0.85f;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f10534 = 0;

    /* renamed from: ޓ, reason: contains not printable characters */
    public boolean f10536 = false;

    /* renamed from: ޔ, reason: contains not printable characters */
    public List<C3483> f10537 = null;

    /* renamed from: У$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2871 {
        void onFaceDetected(List<C3483> list, int i, int i2);
    }

    /* renamed from: У$Ԩ, reason: contains not printable characters */
    public class C2872 implements InterfaceC3930 {
        public C2872() {
        }

        @Override // defpackage.InterfaceC3930
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo10224(Bitmap bitmap) {
            if (C2870.this.f10503) {
                Log.d(C2870.f10502, String.format(C4625.m14082("Ph0CDDUBHFQOBSNTWl8="), new Object[0]));
            }
            bitmap.recycle();
            if (C2870.this.f10507) {
                return;
            }
            synchronized (C2870.this.f10509) {
                C2870.this.f10537 = new ArrayList();
                C2870.this.f10509.notifyAll();
            }
        }

        @Override // defpackage.InterfaceC3930
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo10225(List<C3483> list, Bitmap bitmap) {
            if (C2870.this.f10503) {
                Log.d(C2870.f10502, String.format(C4625.m14082("Ph0CDDUBHFQOBTZHUFBWPRxNCTERClQSAh9XEwkTaxxN"), Integer.valueOf(list.size())));
            }
            bitmap.recycle();
            if (C2870.this.f10507) {
                return;
            }
            synchronized (C2870.this.f10509) {
                C2870.this.f10537 = list;
                C2870.this.f10509.notifyAll();
            }
        }
    }

    /* renamed from: У$Ԫ, reason: contains not printable characters */
    public class RunnableC2873 implements Runnable {
        public RunnableC2873() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2870.this.m10219();
        }
    }

    /* renamed from: У$Ԭ, reason: contains not printable characters */
    public class RunnableC2874 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ long f10541;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ long f10542;

        public RunnableC2874(long j, long j2) {
            this.f10541 = j;
            this.f10542 = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jNanoTime = System.nanoTime();
            C2870.this.m10218();
            long jNanoTime2 = System.nanoTime();
            if (C2870.this.f10503) {
                Log.d(C2870.f10502, String.format(C4625.m14082("LQAeG3AGBhkES0VWQVJEAR0ECDkcT05BThYSHxNDIRwZT2pSSgdBR0VVVl1WPA4ZChYTDBElChFTEwkTaxxN"), Long.valueOf((this.f10541 - this.f10542) / 1000000), Long.valueOf((jNanoTime - this.f10541) / 1000000), Long.valueOf((jNanoTime2 - jNanoTime) / 1000000)));
            }
        }
    }

    /* renamed from: У$Ԯ, reason: contains not printable characters */
    public class RunnableC2875 implements Runnable {
        public RunnableC2875() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2870.this.m10220();
        }
    }

    public C2870(EGLContext eGLContext) {
        this.f10512 = eGLContext;
        HandlerThread handlerThread = new HandlerThread(C4625.m14082("CA4OChQXGxECHyBcVFpdKw=="));
        this.f10510 = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.f10510.getLooper());
        this.f10511 = handler;
        handler.post(new RunnableC2873());
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012f  */
    /* renamed from: Ԫ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m10218() {
        /*
            Method dump skipped, instructions count: 926
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C2870.m10218():int");
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m10219() {
        C3234 c3234 = new C3234(this.f10512, 0);
        this.f10513 = c3234;
        EGLSurface eGLSurfaceM10895 = c3234.m10895(16, 16);
        this.f10514 = eGLSurfaceM10895;
        this.f10513.m10897(eGLSurfaceM10895);
        this.f10504 = new C3472();
        this.f10526 = new C1793();
        this.f10527 = new C4874();
        this.f10528 = new C2398(C4625.m14082("KAYBGzUAHFsHCgZXHFVSLQouADwdHTITCgJfVl1HYAgBHDw="));
        this.f10524 = new Drawable2d();
        this.f10525 = new Drawable2d();
        this.f10516 = true;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m10220() {
        C1788 c1788 = this.f10529;
        if (c1788 != null) {
            c1788.m4789();
        }
        this.f10526.mo4800();
        this.f10527.mo4800();
        this.f10528.mo4800();
        IntBuffer intBuffer = this.f10530;
        if (intBuffer != null) {
            intBuffer.clear();
        }
        C1788 c17882 = this.f10532;
        if (c17882 != null) {
            c17882.m4789();
        }
        C1788 c17883 = this.f10533;
        if (c17883 != null) {
            c17883.m4789();
        }
        this.f10504.m11325();
        this.f10513.m10898();
        this.f10513.m10900(this.f10514);
        this.f10513.m10899();
        this.f10510.quit();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0074 A[Catch: all -> 0x00a2, TryCatch #0 {, blocks: (B:13:0x003f, B:15:0x0043, B:17:0x0045, B:19:0x0049, B:25:0x005f, B:26:0x0061, B:28:0x0074, B:30:0x008b, B:31:0x00a0, B:29:0x0080, B:20:0x004f, B:22:0x0053, B:24:0x0057), top: B:36:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0080 A[Catch: all -> 0x00a2, TryCatch #0 {, blocks: (B:13:0x003f, B:15:0x0043, B:17:0x0045, B:19:0x0049, B:25:0x005f, B:26:0x0061, B:28:0x0074, B:30:0x008b, B:31:0x00a0, B:29:0x0080, B:20:0x004f, B:22:0x0053, B:24:0x0057), top: B:36:0x003f }] */
    /* renamed from: ֏, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m10221(int r8, com.blink.academy.filter.core.TextureFormat r9, int r10, int r11, boolean r12, boolean r13) {
        /*
            r7 = this;
            long r4 = java.lang.System.nanoTime()
            boolean r0 = r7.f10516
            if (r0 != 0) goto L9
            return r8
        L9:
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r7.f10535
            long r0 = r0 - r2
            r2 = 30
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            if (r0 >= 0) goto L36
            boolean r9 = r7.f10503
            if (r9 == 0) goto L35
            java.lang.String r9 = defpackage.C2870.f10502
            java.lang.String r10 = "Ph0CDDUBHFQVBAoSXkZQJk8ZBj0XT1hBDRVBEwkTaxxN"
            java.lang.String r10 = defpackage.C4625.m14082(r10)
            r11 = 1
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r12 = r7.f10534
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11[r1] = r12
            java.lang.String r10 = java.lang.String.format(r10, r11)
            android.util.Log.e(r9, r10)
        L35:
            return r8
        L36:
            long r2 = java.lang.System.currentTimeMillis()
            r7.f10535 = r2
            java.lang.Object r6 = r7.f10508
            monitor-enter(r6)
            boolean r0 = r7.f10536     // Catch: java.lang.Throwable -> La2
            if (r0 == 0) goto L45
            monitor-exit(r6)     // Catch: java.lang.Throwable -> La2
            return r8
        L45:
            com.blink.academy.filter.core.Ϳ r0 = r7.f10531     // Catch: java.lang.Throwable -> La2
            if (r0 != 0) goto L4f
            com.blink.academy.filter.core.Ϳ r0 = new com.blink.academy.filter.core.Ϳ     // Catch: java.lang.Throwable -> La2
            r0.<init>(r10, r11)     // Catch: java.lang.Throwable -> La2
            goto L5f
        L4f:
            int r2 = r0.f5101     // Catch: java.lang.Throwable -> La2
            if (r2 != r10) goto L57
            int r2 = r0.f5102     // Catch: java.lang.Throwable -> La2
            if (r2 == r11) goto L61
        L57:
            r0.m4789()     // Catch: java.lang.Throwable -> La2
            com.blink.academy.filter.core.Ϳ r0 = new com.blink.academy.filter.core.Ϳ     // Catch: java.lang.Throwable -> La2
            r0.<init>(r10, r11)     // Catch: java.lang.Throwable -> La2
        L5f:
            r7.f10531 = r0     // Catch: java.lang.Throwable -> La2
        L61:
            com.blink.academy.filter.core.Ϳ r10 = r7.f10531     // Catch: java.lang.Throwable -> La2
            r10.m4786()     // Catch: java.lang.Throwable -> La2
            float[] r10 = r7.f10505     // Catch: java.lang.Throwable -> La2
            android.opengl.Matrix.setIdentityM(r10, r1)     // Catch: java.lang.Throwable -> La2
            float[] r10 = r7.f10505     // Catch: java.lang.Throwable -> La2
            defpackage.C2498.m9208(r10, r12, r13)     // Catch: java.lang.Throwable -> La2
            com.blink.academy.filter.core.TextureFormat r10 = com.blink.academy.filter.core.TextureFormat.f5094     // Catch: java.lang.Throwable -> La2
            if (r9 != r10) goto L80
            com.blink.academy.filter.core.Ԯ r9 = r7.f10526     // Catch: java.lang.Throwable -> La2
            float[] r10 = r7.f10505     // Catch: java.lang.Throwable -> La2
            float[] r11 = defpackage.C2498.f9252     // Catch: java.lang.Throwable -> La2
            com.blink.academy.filter.core.Drawable2d r12 = r7.f10524     // Catch: java.lang.Throwable -> La2
            r9.mo4802(r8, r10, r11, r12)     // Catch: java.lang.Throwable -> La2
            goto L8b
        L80:
            ฏ r9 = r7.f10527     // Catch: java.lang.Throwable -> La2
            float[] r10 = r7.f10505     // Catch: java.lang.Throwable -> La2
            float[] r11 = defpackage.C2498.f9252     // Catch: java.lang.Throwable -> La2
            com.blink.academy.filter.core.Drawable2d r12 = r7.f10524     // Catch: java.lang.Throwable -> La2
            r9.mo4802(r8, r10, r11, r12)     // Catch: java.lang.Throwable -> La2
        L8b:
            com.blink.academy.filter.core.Ϳ r9 = r7.f10531     // Catch: java.lang.Throwable -> La2
            r9.m4793()     // Catch: java.lang.Throwable -> La2
            long r2 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> La2
            android.os.Handler r9 = r7.f10511     // Catch: java.lang.Throwable -> La2
            У$Ԭ r10 = new У$Ԭ     // Catch: java.lang.Throwable -> La2
            r0 = r10
            r1 = r7
            r0.<init>(r2, r4)     // Catch: java.lang.Throwable -> La2
            r9.post(r10)     // Catch: java.lang.Throwable -> La2
            monitor-exit(r6)     // Catch: java.lang.Throwable -> La2
            return r8
        La2:
            r8 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> La2
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C2870.m10221(int, com.blink.academy.filter.core.TextureFormat, int, int, boolean, boolean):int");
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m10222() {
        this.f10516 = false;
        C1788 c1788 = this.f10531;
        if (c1788 != null) {
            c1788.m4789();
        }
        this.f10511.post(new RunnableC2875());
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m10223(InterfaceC2871 interfaceC2871) {
        this.f10538 = interfaceC2871;
    }
}
