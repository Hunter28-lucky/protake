package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ArrayIterator.kt */
/* renamed from: ຉ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4946<T> implements Iterator<T>, InterfaceC4947 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final T[] f16663;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f16664;

    public C4946(T[] tArr) {
        C3921.m12666(tArr, "array");
        this.f16663 = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16664 < this.f16663.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f16663;
            int i = this.f16664;
            this.f16664 = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f16664--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
