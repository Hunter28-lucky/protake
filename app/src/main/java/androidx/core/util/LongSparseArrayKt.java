package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4899;
import defpackage.C3921;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC4090;
import defpackage.InterfaceC4947;
import defpackage.i4;
import java.util.Iterator;

/* compiled from: LongSparseArray.kt */
/* loaded from: classes.dex */
public final class LongSparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: LongSparseArray.kt */
    /* renamed from: androidx.core.util.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C53301<T> implements Iterator<T>, InterfaceC4947 {
        public final /* synthetic */ LongSparseArray<T> $this_valueIterator;
        private int index;

        public C53301(LongSparseArray<T> longSparseArray) {
            this.$this_valueIterator = longSparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        @SuppressLint({"ClassVerificationFailure"})
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        @SuppressLint({"ClassVerificationFailure"})
        public T next() {
            LongSparseArray<T> longSparseArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return longSparseArray.valueAt(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j) {
        C3921.m12666(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean containsKey(LongSparseArray<T> longSparseArray, long j) {
        C3921.m12666(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean containsValue(LongSparseArray<T> longSparseArray, T t) {
        C3921.m12666(longSparseArray, "<this>");
        return longSparseArray.indexOfValue(t) >= 0;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> void forEach(LongSparseArray<T> longSparseArray, InterfaceC2849<? super Long, ? super T, i4> interfaceC2849) {
        C3921.m12666(longSparseArray, "<this>");
        C3921.m12666(interfaceC2849, "action");
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            interfaceC2849.invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
        }
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j, T t) {
        C3921.m12666(longSparseArray, "<this>");
        T t2 = longSparseArray.get(j);
        return t2 == null ? t : t2;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j, InterfaceC4090<? extends T> interfaceC4090) {
        C3921.m12666(longSparseArray, "<this>");
        C3921.m12666(interfaceC4090, "defaultValue");
        T t = longSparseArray.get(j);
        return t == null ? interfaceC4090.invoke() : t;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        C3921.m12666(longSparseArray, "<this>");
        return longSparseArray.size();
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean isEmpty(LongSparseArray<T> longSparseArray) {
        C3921.m12666(longSparseArray, "<this>");
        return longSparseArray.size() == 0;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        C3921.m12666(longSparseArray, "<this>");
        return longSparseArray.size() != 0;
    }

    @RequiresApi(16)
    public static final <T> AbstractC4899 keyIterator(final LongSparseArray<T> longSparseArray) {
        C3921.m12666(longSparseArray, "<this>");
        return new AbstractC4899() { // from class: androidx.core.util.LongSparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            @SuppressLint({"ClassVerificationFailure"})
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // defpackage.AbstractC4899
            @SuppressLint({"ClassVerificationFailure"})
            public long nextLong() {
                LongSparseArray<T> longSparseArray2 = longSparseArray;
                int i = this.index;
                this.index = i + 1;
                return longSparseArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        C3921.m12666(longSparseArray, "<this>");
        C3921.m12666(longSparseArray2, "other");
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    @RequiresApi(16)
    public static final <T> void putAll(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        C3921.m12666(longSparseArray, "<this>");
        C3921.m12666(longSparseArray2, "other");
        int size = longSparseArray2.size();
        for (int i = 0; i < size; i++) {
            longSparseArray.put(longSparseArray2.keyAt(i), longSparseArray2.valueAt(i));
        }
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j, T t) {
        C3921.m12666(longSparseArray, "<this>");
        int iIndexOfKey = longSparseArray.indexOfKey(j);
        if (iIndexOfKey < 0 || !C3921.m12662(t, longSparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(iIndexOfKey);
        return true;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> void set(LongSparseArray<T> longSparseArray, long j, T t) {
        C3921.m12666(longSparseArray, "<this>");
        longSparseArray.put(j, t);
    }

    @RequiresApi(16)
    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        C3921.m12666(longSparseArray, "<this>");
        return new C53301(longSparseArray);
    }
}
