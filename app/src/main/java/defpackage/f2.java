package defpackage;

import defpackage.g2;
import java.lang.Comparable;
import java.util.Arrays;

/* compiled from: ThreadSafeHeap.kt */
/* loaded from: classes2.dex */
public class f2<T extends g2 & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public T[] f6634;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m6036(T t) {
        t.mo6074(this);
        g2[] g2VarArrM6041 = m6041();
        int iM6038 = m6038();
        m6045(iM6038 + 1);
        g2VarArrM6041[iM6038] = t;
        t.setIndex(iM6038);
        m6047(iM6038);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final T m6037() {
        T[] tArr = this.f6634;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int m6038() {
        return this._size;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final boolean m6039() {
        return m6038() == 0;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final T m6040() {
        T t;
        synchronized (this) {
            t = (T) m6037();
        }
        return t;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final T[] m6041() {
        T[] tArr = this.f6634;
        if (tArr == null) {
            T[] tArr2 = (T[]) new g2[4];
            this.f6634 = tArr2;
            return tArr2;
        }
        if (m6038() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, m6038() * 2);
        C3921.m12665(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((g2[]) objArrCopyOf);
        this.f6634 = tArr3;
        return tArr3;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean m6042(T t) {
        boolean z;
        synchronized (this) {
            if (t.mo6073() == null) {
                z = false;
            } else {
                m6043(t.getIndex());
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /* renamed from: Ԯ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T m6043(int r6) {
        /*
            r5 = this;
            T extends g2 & java.lang.Comparable<? super T>[] r0 = r5.f6634
            defpackage.C3921.m12664(r0)
            int r1 = r5.m6038()
            r2 = -1
            int r1 = r1 + r2
            r5.m6045(r1)
            int r1 = r5.m6038()
            if (r6 >= r1) goto L3d
            int r1 = r5.m6038()
            r5.m6048(r6, r1)
            int r1 = r6 + (-1)
            int r1 = r1 / 2
            if (r6 <= 0) goto L3a
            r3 = r0[r6]
            defpackage.C3921.m12664(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r0[r1]
            defpackage.C3921.m12664(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L3a
            r5.m6048(r6, r1)
            r5.m6047(r1)
            goto L3d
        L3a:
            r5.m6046(r6)
        L3d:
            int r6 = r5.m6038()
            r6 = r0[r6]
            defpackage.C3921.m12664(r6)
            r1 = 0
            r6.mo6074(r1)
            r6.setIndex(r2)
            int r2 = r5.m6038()
            r0[r2] = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f2.m6043(int):g2");
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final T m6044() {
        T t;
        synchronized (this) {
            t = m6038() > 0 ? (T) m6043(0) : null;
        }
        return t;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m6045(int i) {
        this._size = i;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m6046(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= m6038()) {
                return;
            }
            T[] tArr = this.f6634;
            C3921.m12664(tArr);
            int i3 = i2 + 1;
            if (i3 < m6038()) {
                T t = tArr[i3];
                C3921.m12664(t);
                T t2 = tArr[i2];
                C3921.m12664(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    i2 = i3;
                }
            }
            T t3 = tArr[i];
            C3921.m12664(t3);
            T t4 = tArr[i2];
            C3921.m12664(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            m6048(i, i2);
            i = i2;
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m6047(int i) {
        while (i > 0) {
            T[] tArr = this.f6634;
            C3921.m12664(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            C3921.m12664(t);
            T t2 = tArr[i];
            C3921.m12664(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            m6048(i, i2);
            i = i2;
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m6048(int i, int i2) {
        T[] tArr = this.f6634;
        C3921.m12664(tArr);
        T t = tArr[i2];
        C3921.m12664(t);
        T t2 = tArr[i];
        C3921.m12664(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.setIndex(i);
        t2.setIndex(i2);
    }
}
