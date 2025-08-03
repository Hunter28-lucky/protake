package defpackage;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscLinkedArrayQueue.java */
/* loaded from: classes2.dex */
public final class d<T> implements InterfaceC2475<T> {

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final int f6522 = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: ؠ, reason: contains not printable characters */
    public static final Object f6523 = new Object();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f6525;

    /* renamed from: ԭ, reason: contains not printable characters */
    public long f6526;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f6527;

    /* renamed from: ԯ, reason: contains not printable characters */
    public AtomicReferenceArray<Object> f6528;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final int f6529;

    /* renamed from: ֈ, reason: contains not printable characters */
    public AtomicReferenceArray<Object> f6530;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AtomicLong f6524 = new AtomicLong();

    /* renamed from: ֏, reason: contains not printable characters */
    public final AtomicLong f6531 = new AtomicLong();

    public d(int i) {
        int iM14270 = C4729.m14270(Math.max(8, i));
        int i2 = iM14270 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iM14270 + 1);
        this.f6528 = atomicReferenceArray;
        this.f6527 = i2;
        m5876(iM14270);
        this.f6530 = atomicReferenceArray;
        this.f6529 = i2;
        this.f6526 = i2 - 1;
        m5890(0L);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static int m5872(int i) {
        return i;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static int m5873(long j, int i) {
        return m5872(((int) j) & i);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static <E> Object m5874(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static void m5875(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    @Override // defpackage.InterfaceC4851
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // defpackage.InterfaceC4851
    public boolean isEmpty() {
        return m5881() == m5879();
    }

    @Override // defpackage.InterfaceC4851
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.f6528;
        long jM5878 = m5878();
        int i = this.f6527;
        int iM5873 = m5873(jM5878, i);
        if (jM5878 < this.f6526) {
            return m5891(atomicReferenceArray, t, jM5878, iM5873);
        }
        long j = this.f6525 + jM5878;
        if (m5874(atomicReferenceArray, m5873(j, i)) == null) {
            this.f6526 = j - 1;
            return m5891(atomicReferenceArray, t, jM5878, iM5873);
        }
        if (m5874(atomicReferenceArray, m5873(1 + jM5878, i)) == null) {
            return m5891(atomicReferenceArray, t, jM5878, iM5873);
        }
        m5886(atomicReferenceArray, jM5878, iM5873, t, i);
        return true;
    }

    @Override // defpackage.InterfaceC2475, defpackage.InterfaceC4851
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f6530;
        long jM5877 = m5877();
        int i = this.f6529;
        int iM5873 = m5873(jM5877, i);
        T t = (T) m5874(atomicReferenceArray, iM5873);
        boolean z = t == f6523;
        if (t == null || z) {
            if (z) {
                return m5883(m5880(atomicReferenceArray, i + 1), jM5877, i);
            }
            return null;
        }
        m5875(atomicReferenceArray, iM5873, null);
        m5888(jM5877 + 1);
        return t;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m5876(int i) {
        this.f6525 = Math.min(i / 4, f6522);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final long m5877() {
        return this.f6531.get();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long m5878() {
        return this.f6524.get();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long m5879() {
        return this.f6531.get();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AtomicReferenceArray<Object> m5880(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int iM5872 = m5872(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) m5874(atomicReferenceArray, iM5872);
        m5875(atomicReferenceArray, iM5872, null);
        return atomicReferenceArray2;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final long m5881() {
        return this.f6524.get();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final T m5882(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f6530 = atomicReferenceArray;
        return (T) m5874(atomicReferenceArray, m5873(j, i));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final T m5883(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f6530 = atomicReferenceArray;
        int iM5873 = m5873(j, i);
        T t = (T) m5874(atomicReferenceArray, iM5873);
        if (t != null) {
            m5875(atomicReferenceArray, iM5873, null);
            m5888(j + 1);
        }
        return t;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean m5884(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f6528;
        long jM5881 = m5881();
        int i = this.f6527;
        long j = 2 + jM5881;
        if (m5874(atomicReferenceArray, m5873(j, i)) == null) {
            int iM5873 = m5873(jM5881, i);
            m5875(atomicReferenceArray, iM5873 + 1, t2);
            m5875(atomicReferenceArray, iM5873, t);
            m5890(j);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f6528 = atomicReferenceArray2;
        int iM58732 = m5873(jM5881, i);
        m5875(atomicReferenceArray2, iM58732 + 1, t2);
        m5875(atomicReferenceArray2, iM58732, t);
        m5889(atomicReferenceArray, atomicReferenceArray2);
        m5875(atomicReferenceArray, iM58732, f6523);
        m5890(j);
        return true;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public T m5885() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f6530;
        long jM5877 = m5877();
        int i = this.f6529;
        T t = (T) m5874(atomicReferenceArray, m5873(jM5877, i));
        return t == f6523 ? m5882(m5880(atomicReferenceArray, i + 1), jM5877, i) : t;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m5886(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f6528 = atomicReferenceArray2;
        this.f6526 = (j2 + j) - 1;
        m5875(atomicReferenceArray2, i, t);
        m5889(atomicReferenceArray, atomicReferenceArray2);
        m5875(atomicReferenceArray, i, f6523);
        m5890(j + 1);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public int m5887() {
        long jM5879 = m5879();
        while (true) {
            long jM5881 = m5881();
            long jM58792 = m5879();
            if (jM5879 == jM58792) {
                return (int) (jM5881 - jM58792);
            }
            jM5879 = jM58792;
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m5888(long j) {
        this.f6531.lazySet(j);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m5889(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        m5875(atomicReferenceArray, m5872(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m5890(long j) {
        this.f6524.lazySet(j);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final boolean m5891(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        m5875(atomicReferenceArray, i, t);
        m5890(j + 1);
        return true;
    }
}
