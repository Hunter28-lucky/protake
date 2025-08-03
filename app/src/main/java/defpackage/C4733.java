package defpackage;

/* compiled from: progressionUtil.kt */
/* renamed from: ള, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4733 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final int m14272(int i, int i2, int i3) {
        return m14274(m14274(i, i3) - m14274(i2, i3), i3);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final int m14273(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - m14272(i2, i, i3);
        }
        if (i3 < 0) {
            return i <= i2 ? i2 : i2 + m14272(i, i2, -i3);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final int m14274(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }
}
