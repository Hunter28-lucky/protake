package io.reactivex.internal.queue;

import defpackage.C4729;
import defpackage.InterfaceC2475;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements InterfaceC2475<E> {
    private static final long serialVersionUID = -1296597691183856449L;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final Integer f7644 = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    public final AtomicLong consumerIndex;
    public final int lookAheadStep;
    public final int mask;
    public final AtomicLong producerIndex;
    public long producerLookAhead;

    public SpscArrayQueue(int i) {
        super(C4729.m14270(i));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(i / 4, f7644.intValue());
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
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    @Override // defpackage.InterfaceC4851
    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i = this.mask;
        long j = this.producerIndex.get();
        int iM6980 = m6980(j, i);
        if (j >= this.producerLookAhead) {
            long j2 = this.lookAheadStep + j;
            if (m6981(m6980(j2, i)) == null) {
                this.producerLookAhead = j2;
            } else if (m6981(iM6980) != null) {
                return false;
            }
        }
        m6983(iM6980, e2);
        m6984(j + 1);
        return true;
    }

    @Override // defpackage.InterfaceC2475, defpackage.InterfaceC4851
    public E poll() {
        long j = this.consumerIndex.get();
        int iM6979 = m6979(j);
        E eM6981 = m6981(iM6979);
        if (eM6981 == null) {
            return null;
        }
        m6982(j + 1);
        m6983(iM6979, null);
        return eM6981;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int m6979(long j) {
        return ((int) j) & this.mask;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m6980(long j, int i) {
        return ((int) j) & i;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public E m6981(int i) {
        return get(i);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m6982(long j) {
        this.consumerIndex.lazySet(j);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m6983(int i, E e2) {
        lazySet(i, e2);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m6984(long j) {
        this.producerIndex.lazySet(j);
    }
}
