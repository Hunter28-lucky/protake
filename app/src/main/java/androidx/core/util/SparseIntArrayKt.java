package androidx.core.util;

import android.util.SparseIntArray;
import defpackage.AbstractC2348;
import defpackage.C3921;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC4090;
import defpackage.i4;

/* compiled from: SparseIntArray.kt */
/* loaded from: classes.dex */
public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray sparseIntArray, int i) {
        C3921.m12666(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(SparseIntArray sparseIntArray, int i) {
        C3921.m12666(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(SparseIntArray sparseIntArray, int i) {
        C3921.m12666(sparseIntArray, "<this>");
        return sparseIntArray.indexOfValue(i) >= 0;
    }

    public static final void forEach(SparseIntArray sparseIntArray, InterfaceC2849<? super Integer, ? super Integer, i4> interfaceC2849) {
        C3921.m12666(sparseIntArray, "<this>");
        C3921.m12666(interfaceC2849, "action");
        int size = sparseIntArray.size();
        for (int i = 0; i < size; i++) {
            interfaceC2849.invoke(Integer.valueOf(sparseIntArray.keyAt(i)), Integer.valueOf(sparseIntArray.valueAt(i)));
        }
    }

    public static final int getOrDefault(SparseIntArray sparseIntArray, int i, int i2) {
        C3921.m12666(sparseIntArray, "<this>");
        return sparseIntArray.get(i, i2);
    }

    public static final int getOrElse(SparseIntArray sparseIntArray, int i, InterfaceC4090<Integer> interfaceC4090) {
        C3921.m12666(sparseIntArray, "<this>");
        C3921.m12666(interfaceC4090, "defaultValue");
        int iIndexOfKey = sparseIntArray.indexOfKey(i);
        return iIndexOfKey >= 0 ? sparseIntArray.valueAt(iIndexOfKey) : interfaceC4090.invoke().intValue();
    }

    public static final int getSize(SparseIntArray sparseIntArray) {
        C3921.m12666(sparseIntArray, "<this>");
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(SparseIntArray sparseIntArray) {
        C3921.m12666(sparseIntArray, "<this>");
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseIntArray sparseIntArray) {
        C3921.m12666(sparseIntArray, "<this>");
        return sparseIntArray.size() != 0;
    }

    public static final AbstractC2348 keyIterator(final SparseIntArray sparseIntArray) {
        C3921.m12666(sparseIntArray, "<this>");
        return new AbstractC2348() { // from class: androidx.core.util.SparseIntArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // defpackage.AbstractC2348
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i = this.index;
                this.index = i + 1;
                return sparseIntArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final SparseIntArray plus(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        C3921.m12666(sparseIntArray, "<this>");
        C3921.m12666(sparseIntArray2, "other");
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray.size() + sparseIntArray2.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        C3921.m12666(sparseIntArray, "<this>");
        C3921.m12666(sparseIntArray2, "other");
        int size = sparseIntArray2.size();
        for (int i = 0; i < size; i++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i), sparseIntArray2.valueAt(i));
        }
    }

    public static final boolean remove(SparseIntArray sparseIntArray, int i, int i2) {
        C3921.m12666(sparseIntArray, "<this>");
        int iIndexOfKey = sparseIntArray.indexOfKey(i);
        if (iIndexOfKey < 0 || i2 != sparseIntArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final void set(SparseIntArray sparseIntArray, int i, int i2) {
        C3921.m12666(sparseIntArray, "<this>");
        sparseIntArray.put(i, i2);
    }

    public static final AbstractC2348 valueIterator(final SparseIntArray sparseIntArray) {
        C3921.m12666(sparseIntArray, "<this>");
        return new AbstractC2348() { // from class: androidx.core.util.SparseIntArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // defpackage.AbstractC2348
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i = this.index;
                this.index = i + 1;
                return sparseIntArray2.valueAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }
}
