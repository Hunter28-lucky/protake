package defpackage;

/* compiled from: Progressions.kt */
/* renamed from: Թ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3181 implements Iterable<Integer>, InterfaceC4947 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final C3182 f11260 = new C3182(null);

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f11261;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f11262;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f11263;

    /* compiled from: Progressions.kt */
    /* renamed from: Թ$Ϳ, reason: contains not printable characters */
    public static final class C3182 {
        public C3182() {
        }

        public /* synthetic */ C3182(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C3181 m10814(int i, int i2, int i3) {
            return new C3181(i, i2, i3);
        }
    }

    public C3181(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f11261 = i;
        this.f11262 = C4733.m14273(i, i2, i3);
        this.f11263 = i3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C3181) {
            if (!isEmpty() || !((C3181) obj).isEmpty()) {
                C3181 c3181 = (C3181) obj;
                if (this.f11261 != c3181.f11261 || this.f11262 != c3181.f11262 || this.f11263 != c3181.f11263) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f11261 * 31) + this.f11262) * 31) + this.f11263;
    }

    public boolean isEmpty() {
        if (this.f11263 > 0) {
            if (this.f11261 > this.f11262) {
                return true;
            }
        } else if (this.f11261 < this.f11262) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f11263 > 0) {
            sb = new StringBuilder();
            sb.append(this.f11261);
            sb.append("..");
            sb.append(this.f11262);
            sb.append(" step ");
            i = this.f11263;
        } else {
            sb = new StringBuilder();
            sb.append(this.f11261);
            sb.append(" downTo ");
            sb.append(this.f11262);
            sb.append(" step ");
            i = -this.f11263;
        }
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int m10810() {
        return this.f11261;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int m10811() {
        return this.f11262;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int m10812() {
        return this.f11263;
    }

    @Override // java.lang.Iterable
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public AbstractC2348 iterator() {
        return new C3753(this.f11261, this.f11262, this.f11263);
    }
}
