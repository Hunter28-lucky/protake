package androidx.core.util;

import android.util.SparseArray;
import defpackage.AbstractC2348;
import defpackage.C3921;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC4090;
import defpackage.InterfaceC4947;
import defpackage.i4;
import java.util.Iterator;

/* compiled from: SparseArray.kt */
/* loaded from: classes.dex */
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SparseArray.kt */
    /* renamed from: androidx.core.util.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C53311<T> implements Iterator<T>, InterfaceC4947 {
        public final /* synthetic */ SparseArray<T> $this_valueIterator;
        private int index;

        public C53311(SparseArray<T> sparseArray) {
            this.$this_valueIterator = sparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArray<T> sparseArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseArray.valueAt(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    public static final <T> boolean contains(SparseArray<T> sparseArray, int i) {
        C3921.m12666(sparseArray, "<this>");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i) {
        C3921.m12666(sparseArray, "<this>");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t) {
        C3921.m12666(sparseArray, "<this>");
        return sparseArray.indexOfValue(t) >= 0;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, InterfaceC2849<? super Integer, ? super T, i4> interfaceC2849) {
        C3921.m12666(sparseArray, "<this>");
        C3921.m12666(interfaceC2849, "action");
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            interfaceC2849.invoke(Integer.valueOf(sparseArray.keyAt(i)), sparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i, T t) {
        C3921.m12666(sparseArray, "<this>");
        T t2 = sparseArray.get(i);
        return t2 == null ? t : t2;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i, InterfaceC4090<? extends T> interfaceC4090) {
        C3921.m12666(sparseArray, "<this>");
        C3921.m12666(interfaceC4090, "defaultValue");
        T t = sparseArray.get(i);
        return t == null ? interfaceC4090.invoke() : t;
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        C3921.m12666(sparseArray, "<this>");
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        C3921.m12666(sparseArray, "<this>");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        C3921.m12666(sparseArray, "<this>");
        return sparseArray.size() != 0;
    }

    public static final <T> AbstractC2348 keyIterator(final SparseArray<T> sparseArray) {
        C3921.m12666(sparseArray, "<this>");
        return new AbstractC2348() { // from class: androidx.core.util.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // defpackage.AbstractC2348
            public int nextInt() {
                SparseArray<T> sparseArray2 = sparseArray;
                int i = this.index;
                this.index = i + 1;
                return sparseArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        C3921.m12666(sparseArray, "<this>");
        C3921.m12666(sparseArray2, "other");
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size() + sparseArray2.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        C3921.m12666(sparseArray, "<this>");
        C3921.m12666(sparseArray2, "other");
        int size = sparseArray2.size();
        for (int i = 0; i < size; i++) {
            sparseArray.put(sparseArray2.keyAt(i), sparseArray2.valueAt(i));
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i, T t) {
        C3921.m12666(sparseArray, "<this>");
        int iIndexOfKey = sparseArray.indexOfKey(i);
        if (iIndexOfKey < 0 || !C3921.m12662(t, sparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i, T t) {
        C3921.m12666(sparseArray, "<this>");
        sparseArray.put(i, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        C3921.m12666(sparseArray, "<this>");
        return new C53311(sparseArray);
    }
}
