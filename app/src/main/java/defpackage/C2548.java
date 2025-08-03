package defpackage;

import android.opengl.GLES20;
import android.util.Log;
import com.blink.academy.filter.core.C1788;
import com.blink.academy.filter.core.C1793;
import com.blink.academy.filter.core.C1794;
import com.blink.academy.filter.core.Drawable2d;
import com.blink.academy.filter.core.FramebufferTexture;

/* renamed from: Ⱥ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2548 {

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final String f9410 = "OooOOO";

    /* renamed from: ؠ, reason: contains not printable characters */
    public static boolean f9411 = false;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C1793 f9412;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public C4609 f9413;

    /* renamed from: ԩ, reason: contains not printable characters */
    public C1794 f9414;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C5114 f9415;

    /* renamed from: ԫ, reason: contains not printable characters */
    public C2413 f9416;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C3766 f9417;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C4249 f9418;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public Drawable2d f9419;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C1788 f9420;

    /* renamed from: ՠ, reason: contains not printable characters */
    public C1788 f9421;

    /* renamed from: ֈ, reason: contains not printable characters */
    public C1788 f9422;

    /* renamed from: ֏, reason: contains not printable characters */
    public C1788 f9423;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C1788 m9387(int i, int i2, int i3, int i4, int i5) {
        long jNanoTime = System.nanoTime();
        C1788 c1788 = this.f9420;
        if (c1788 == null || c1788.f5101 != i2 || c1788.f5102 != i3) {
            if (c1788 != null) {
                c1788.m4789();
            }
            this.f9420 = new C1788(i2, i3, FramebufferTexture.Format.f5087);
        }
        C1788 c17882 = this.f9421;
        if (c17882 == null || c17882.f5101 != i2 || c17882.f5102 != i3) {
            if (c17882 != null) {
                c17882.m4789();
            }
            this.f9421 = new C1788(i2, i3, FramebufferTexture.Format.f5087);
        }
        C1788 c17883 = this.f9422;
        if (c17883 == null || c17883.f5101 != i2 || c17883.f5102 != i3) {
            if (c17883 != null) {
                c17883.m4789();
            }
            this.f9422 = new C1788(i2, i3, FramebufferTexture.Format.f5087);
        }
        C1788 c17884 = this.f9423;
        if (c17884 == null || c17884.f5101 != i4 || c17884.f5102 != i5) {
            if (c17884 != null) {
                c17884.m4789();
            }
            this.f9423 = new C1788(i4, i5, FramebufferTexture.Format.f5087);
        }
        long jNanoTime2 = System.nanoTime();
        this.f9420.m4786();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.f9412.mo4809(i, this.f9419);
        this.f9420.m4793();
        long jNanoTime3 = System.nanoTime();
        this.f9421.m4786();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        float f = 1.0f / i3;
        this.f9413.m14069(0.0f, f);
        this.f9413.mo4809(this.f9420.m4792(), this.f9419);
        this.f9421.m4793();
        long jNanoTime4 = System.nanoTime();
        this.f9422.m4786();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        float f2 = 1.0f / i2;
        this.f9415.m14947(f2, 0.0f);
        this.f9415.m4806(this.f9421.m4792(), false);
        this.f9416.m8911(0.0f, f);
        this.f9417.m12062(f2, 0.0f);
        this.f9414.m4826(this.f9422, this.f9420, this.f9419);
        this.f9422.m4793();
        long jNanoTime5 = System.nanoTime();
        this.f9423.m4786();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.f9418.m4806(this.f9422.m4792(), false);
        this.f9418.mo4809(i, this.f9419);
        this.f9423.m4793();
        long jNanoTime6 = System.nanoTime();
        if (f9411) {
            Log.d(f9410, String.format(C4625.m14082("KA0CT2pSSgdBR0VAVkBaNApNVXBXHFRNSxZGVkMDblVNSiNSQ1RQRlYSCRMWPU9BTzYbARUNS18SFkATYk8eGj1SVVREGEU="), Long.valueOf((jNanoTime2 - jNanoTime) / 1000000), Long.valueOf((jNanoTime3 - jNanoTime2) / 1000000), Long.valueOf((jNanoTime4 - jNanoTime3) / 1000000), Long.valueOf((jNanoTime5 - jNanoTime4) / 1000000), Long.valueOf((jNanoTime6 - jNanoTime5) / 1000000), Long.valueOf((jNanoTime6 - jNanoTime) / 1000000)));
        }
        return this.f9423;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m9388() {
        C1793 c1793 = this.f9412;
        if (c1793 != null) {
            c1793.mo4800();
        }
        C1794 c1794 = this.f9414;
        if (c1794 != null) {
            c1794.mo4800();
            this.f9414.m4825();
        }
        C4609 c4609 = this.f9413;
        if (c4609 != null) {
            c4609.mo4800();
        }
        C5114 c5114 = this.f9415;
        if (c5114 != null) {
            c5114.mo4800();
            this.f9415.m4805();
        }
        C2413 c2413 = this.f9416;
        if (c2413 != null) {
            c2413.mo4800();
        }
        C3766 c3766 = this.f9417;
        if (c3766 != null) {
            c3766.mo4800();
        }
        C4249 c4249 = this.f9418;
        if (c4249 != null) {
            c4249.mo4800();
            this.f9418.m4805();
        }
        C1788 c1788 = this.f9420;
        if (c1788 != null) {
            c1788.m4789();
            this.f9420 = null;
        }
        C1788 c17882 = this.f9421;
        if (c17882 != null) {
            c17882.m4789();
            this.f9421 = null;
        }
        C1788 c17883 = this.f9422;
        if (c17883 != null) {
            c17883.m4789();
            this.f9422 = null;
        }
        C1788 c17884 = this.f9423;
        if (c17884 != null) {
            c17884.m4789();
            this.f9423 = null;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m9389(float f) {
        this.f9418.m13362(f);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m9390() {
        this.f9412 = new C1793();
        C4609 c4609 = new C4609();
        this.f9413 = c4609;
        c4609.mo4803();
        C5114 c5114 = new C5114();
        this.f9415 = c5114;
        c5114.mo4803();
        C2413 c2413 = new C2413();
        this.f9416 = c2413;
        c2413.mo4803();
        C3766 c3766 = new C3766();
        this.f9417 = c3766;
        c3766.mo4803();
        C1794 c1794 = new C1794();
        this.f9414 = c1794;
        c1794.m4824(this.f9415);
        this.f9414.m4824(this.f9416);
        this.f9414.m4824(this.f9417);
        C4249 c4249 = new C4249();
        this.f9418 = c4249;
        c4249.mo4803();
        this.f9418.m13362(0.0f);
        this.f9419 = new Drawable2d();
    }
}
