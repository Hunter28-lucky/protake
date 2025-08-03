package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.AbstractCollection;

/* compiled from: AbstractList.kt */
/* renamed from: ֈ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC3260<E> extends AbstractCollection<E> implements List<E> {
    public static final C3261 Companion = new C3261(null);

    /* compiled from: AbstractList.kt */
    /* renamed from: ֈ$Ϳ, reason: contains not printable characters */
    public static final class C3261 {
        public C3261() {
        }

        public /* synthetic */ C3261(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void m10928(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final void m10929(int i, int i2) {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final void m10930(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
            }
            if (i <= i2) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i2);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final boolean m10931(Collection<?> collection, Collection<?> collection2) {
            C3921.m12666(collection, "c");
            C3921.m12666(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!C3921.m12662(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final int m10932(Collection<?> collection) {
            C3921.m12666(collection, "c");
            Iterator<?> it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }
    }

    /* compiled from: AbstractList.kt */
    /* renamed from: ֈ$Ԩ, reason: contains not printable characters */
    public class C3262 implements Iterator<E>, InterfaceC4947 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public int f11443;

        public C3262() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11443 < AbstractC3260.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractC3260<E> abstractC3260 = AbstractC3260.this;
            int i = this.f11443;
            this.f11443 = i + 1;
            return abstractC3260.get(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final int m10933() {
            return this.f11443;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final void m10934(int i) {
            this.f11443 = i;
        }
    }

    /* compiled from: AbstractList.kt */
    /* renamed from: ֈ$Ԫ, reason: contains not printable characters */
    public class C3263 extends AbstractC3260<E>.C3262 implements ListIterator<E> {
        public C3263(int i) {
            super();
            AbstractC3260.Companion.m10929(i, AbstractC3260.this.size());
            m10934(i);
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return m10933() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return m10933();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractC3260<E> abstractC3260 = AbstractC3260.this;
            m10934(m10933() - 1);
            return abstractC3260.get(m10933());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return m10933() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* renamed from: ֈ$Ԭ, reason: contains not printable characters */
    public static final class C3264<E> extends AbstractC3260<E> implements RandomAccess {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AbstractC3260<E> f11446;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final int f11447;

        /* renamed from: ԭ, reason: contains not printable characters */
        public int f11448;

        /* JADX WARN: Multi-variable type inference failed */
        public C3264(AbstractC3260<? extends E> abstractC3260, int i, int i2) {
            C3921.m12666(abstractC3260, "list");
            this.f11446 = abstractC3260;
            this.f11447 = i;
            AbstractC3260.Companion.m10930(i, i2, abstractC3260.size());
            this.f11448 = i2 - i;
        }

        @Override // defpackage.AbstractC3260, java.util.List
        public E get(int i) {
            AbstractC3260.Companion.m10928(i, this.f11448);
            return this.f11446.get(this.f11447 + i);
        }

        @Override // defpackage.AbstractC3260, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f11448;
        }
    }

    @Override // java.util.List
    public void add(int i, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.m10931(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i);

    @Override // kotlin.collections.AbstractCollection
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.m10932(this);
    }

    public int indexOf(E e2) {
        Iterator<E> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (C3921.m12662(it.next(), e2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new C3262();
    }

    public int lastIndexOf(E e2) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (C3921.m12662(listIterator.previous(), e2)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new C3263(0);
    }

    @Override // java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return new C3264(this, i, i2);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return new C3263(i);
    }
}
