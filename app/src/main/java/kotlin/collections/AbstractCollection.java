package kotlin.collections;

import defpackage.C2543;
import defpackage.C3921;
import defpackage.C4931;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC4947;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: AbstractCollection.kt */
/* loaded from: classes2.dex */
public abstract class AbstractCollection<E> implements Collection<E>, InterfaceC4947 {
    @Override // java.util.Collection
    public boolean add(E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(E e2) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (C3921.m12662(it.next(), e2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
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

    public abstract int getSize();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public abstract Iterator<E> iterator();

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
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return C4931.m14663(this);
    }

    public String toString() {
        return C2543.m9374(this, ", ", "[", "]", 0, null, new InterfaceC2392<E, CharSequence>(this) { // from class: kotlin.collections.AbstractCollection.toString.1
            public final /* synthetic */ AbstractCollection<E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // defpackage.InterfaceC2392
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public final CharSequence invoke(E e2) {
                return e2 == this.this$0 ? "(this Collection)" : String.valueOf(e2);
            }
        }, 24, null);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        C3921.m12666(tArr, "array");
        return (T[]) C4931.m14664(this, tArr);
    }
}
