package defpackage;

/* compiled from: OpenHashSet.java */
/* renamed from: ద, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4541<T> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final float f15557;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f15558;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f15559;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f15560;

    /* renamed from: ԫ, reason: contains not printable characters */
    public T[] f15561;

    public C4541() {
        this(16, 0.75f);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static int m13936(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m13937(T t) {
        T t2;
        T[] tArr = this.f15561;
        int i = this.f15558;
        int iM13936 = m13936(t.hashCode()) & i;
        T t3 = tArr[iM13936];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                iM13936 = (iM13936 + 1) & i;
                t2 = tArr[iM13936];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[iM13936] = t;
        int i2 = this.f15559 + 1;
        this.f15559 = i2;
        if (i2 >= this.f15560) {
            m13939();
        }
        return true;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Object[] m13938() {
        return this.f15561;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m13939() {
        T t;
        T[] tArr = this.f15561;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.f15559;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                this.f15558 = i2;
                this.f15560 = (int) (i * this.f15557);
                this.f15561 = tArr2;
                return;
            }
            do {
                length--;
                t = tArr[length];
            } while (t == null);
            int iM13936 = m13936(t.hashCode()) & i2;
            if (tArr2[iM13936] != null) {
                do {
                    iM13936 = (iM13936 + 1) & i2;
                } while (tArr2[iM13936] != null);
            }
            tArr2[iM13936] = tArr[length];
            i3 = i4;
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean m13940(T t) {
        T t2;
        T[] tArr = this.f15561;
        int i = this.f15558;
        int iM13936 = m13936(t.hashCode()) & i;
        T t3 = tArr[iM13936];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return m13941(iM13936, tArr, i);
        }
        do {
            iM13936 = (iM13936 + 1) & i;
            t2 = tArr[iM13936];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return m13941(iM13936, tArr, i);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean m13941(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f15559--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int iM13936 = m13936(t.hashCode()) & i2;
                if (i <= i3) {
                    if (i >= iM13936 || iM13936 > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < iM13936 || iM13936 <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public int m13942() {
        return this.f15559;
    }

    public C4541(int i, float f) {
        this.f15557 = f;
        int iM14270 = C4729.m14270(i);
        this.f15558 = iM14270 - 1;
        this.f15560 = (int) (f * iM14270);
        this.f15561 = (T[]) new Object[iM14270];
    }
}
