package defpackage;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: Collections.kt */
/* renamed from: ൟ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4750<T> implements Collection<T>, InterfaceC4947 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final T[] f16021;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean f16022;

    public C4750(T[] tArr, boolean z) {
        C3921.m12666(tArr, "values");
        this.f16021 = tArr;
        this.f16022 = z;
    }

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return C4962.m14738(this.f16021, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        C3921.m12666(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f16021.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return C4948.m14719(this.f16021);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return m14293();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return C5064.m14876(this.f16021, this.f16022);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        C3921.m12666(tArr, "array");
        return (T[]) C4931.m14664(this, tArr);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int m14293() {
        return this.f16021.length;
    }
}
