package defpackage;

import androidx.core.app.NotificationCompat;
import defpackage.InterfaceC2818;
import java.io.IOException;
import java.util.List;

/* compiled from: RealInterceptorChain.kt */
/* renamed from: ݡ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3739 implements InterfaceC2818.InterfaceC2819 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f12945;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C2503 f12946;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final List<InterfaceC2818> f12947;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int f12948;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C3282 f12949;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C4539 f12950;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f12951;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f12952;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f12953;

    /* JADX WARN: Multi-variable type inference failed */
    public C3739(C2503 c2503, List<? extends InterfaceC2818> list, int i, C3282 c3282, C4539 c4539, int i2, int i3, int i4) {
        C3921.m12667(c2503, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(list, "interceptors");
        C3921.m12667(c4539, "request");
        this.f12946 = c2503;
        this.f12947 = list;
        this.f12948 = i;
        this.f12949 = c3282;
        this.f12950 = c4539;
        this.f12951 = i2;
        this.f12952 = i3;
        this.f12953 = i4;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static /* synthetic */ C3739 m11974(C3739 c3739, int i, C3282 c3282, C4539 c4539, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = c3739.f12948;
        }
        if ((i5 & 2) != 0) {
            c3282 = c3739.f12949;
        }
        C3282 c32822 = c3282;
        if ((i5 & 4) != 0) {
            c4539 = c3739.f12950;
        }
        C4539 c45392 = c4539;
        if ((i5 & 8) != 0) {
            i2 = c3739.f12951;
        }
        int i6 = i2;
        if ((i5 & 16) != 0) {
            i3 = c3739.f12952;
        }
        int i7 = i3;
        if ((i5 & 32) != 0) {
            i4 = c3739.f12953;
        }
        return c3739.m11975(i, c32822, c45392, i6, i7, i4);
    }

    @Override // defpackage.InterfaceC2818.InterfaceC2819
    public InterfaceC5054 call() {
        return this.f12946;
    }

    @Override // defpackage.InterfaceC2818.InterfaceC2819
    public C4539 request() {
        return this.f12950;
    }

    @Override // defpackage.InterfaceC2818.InterfaceC2819
    /* renamed from: Ϳ */
    public C4770 mo10160(C4539 c4539) throws IOException {
        C3921.m12667(c4539, "request");
        if (!(this.f12948 < this.f12947.size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f12945++;
        C3282 c3282 = this.f12949;
        if (c3282 != null) {
            if (!c3282.m10965().m9552(c4539.m13925())) {
                throw new IllegalStateException(("network interceptor " + this.f12947.get(this.f12948 - 1) + " must retain the same host and port").toString());
            }
            if (!(this.f12945 == 1)) {
                throw new IllegalStateException(("network interceptor " + this.f12947.get(this.f12948 - 1) + " must call proceed() exactly once").toString());
            }
        }
        C3739 c3739M11974 = m11974(this, this.f12948 + 1, null, c4539, 0, 0, 0, 58, null);
        InterfaceC2818 interfaceC2818 = this.f12947.get(this.f12948);
        C4770 c4770Intercept = interfaceC2818.intercept(c3739M11974);
        if (c4770Intercept == null) {
            throw new NullPointerException("interceptor " + interfaceC2818 + " returned null");
        }
        if (this.f12949 != null) {
            if (!(this.f12948 + 1 >= this.f12947.size() || c3739M11974.f12945 == 1)) {
                throw new IllegalStateException(("network interceptor " + interfaceC2818 + " must call proceed() exactly once").toString());
            }
        }
        if (c4770Intercept.m14330() != null) {
            return c4770Intercept;
        }
        throw new IllegalStateException(("interceptor " + interfaceC2818 + " returned a response with no body").toString());
    }

    @Override // defpackage.InterfaceC2818.InterfaceC2819
    /* renamed from: Ԩ */
    public InterfaceC5051 mo10161() {
        C3282 c3282 = this.f12949;
        if (c3282 != null) {
            return c3282.m10963();
        }
        return null;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C3739 m11975(int i, C3282 c3282, C4539 c4539, int i2, int i3, int i4) {
        C3921.m12667(c4539, "request");
        return new C3739(this.f12946, this.f12947, i, c3282, c4539, i2, i3, i4);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C2503 m11976() {
        return this.f12946;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int m11977() {
        return this.f12951;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final C3282 m11978() {
        return this.f12949;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int m11979() {
        return this.f12952;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final C4539 m11980() {
        return this.f12950;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final int m11981() {
        return this.f12953;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public int m11982() {
        return this.f12952;
    }
}
