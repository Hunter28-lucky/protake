package kotlin.collections;

import defpackage.C2820;
import defpackage.C3921;
import defpackage.C4931;
import defpackage.InterfaceC4947;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: Sets.kt */
/* loaded from: classes2.dex */
public final class EmptySet implements Set, Serializable, InterfaceC4947 {
    private static final long serialVersionUID = 3406603774387020532L;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final EmptySet f7831 = new EmptySet();

    private EmptySet() {
    }

    private final Object readResolve() {
        return f7831;
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return m7233((Void) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        C3921.m12666(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return C2820.f10287;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return m7234();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return C4931.m14663(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        C3921.m12666(tArr, "array");
        return (T[]) C4931.m14664(this, tArr);
    }

    public String toString() {
        return "[]";
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m7233(Void r2) {
        C3921.m12666(r2, "element");
        return false;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m7234() {
        return 0;
    }
}
