package androidx.core.util;

import android.util.SparseBooleanArray;
import defpackage.AbstractC2348;
import defpackage.AbstractC3257;
import defpackage.C3921;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC4090;
import defpackage.i4;

/* compiled from: SparseBooleanArray.kt */
/* loaded from: classes.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray sparseBooleanArray, int i) {
        C3921.m12666(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(SparseBooleanArray sparseBooleanArray, int i) {
        C3921.m12666(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(SparseBooleanArray sparseBooleanArray, boolean z) {
        C3921.m12666(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfValue(z) >= 0;
    }

    public static final void forEach(SparseBooleanArray sparseBooleanArray, InterfaceC2849<? super Integer, ? super Boolean, i4> interfaceC2849) {
        C3921.m12666(sparseBooleanArray, "<this>");
        C3921.m12666(interfaceC2849, "action");
        int size = sparseBooleanArray.size();
        for (int i = 0; i < size; i++) {
            interfaceC2849.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i)), Boolean.valueOf(sparseBooleanArray.valueAt(i)));
        }
    }

    public static final boolean getOrDefault(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        C3921.m12666(sparseBooleanArray, "<this>");
        return sparseBooleanArray.get(i, z);
    }

    public static final boolean getOrElse(SparseBooleanArray sparseBooleanArray, int i, InterfaceC4090<Boolean> interfaceC4090) {
        C3921.m12666(sparseBooleanArray, "<this>");
        C3921.m12666(interfaceC4090, "defaultValue");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i);
        return iIndexOfKey >= 0 ? sparseBooleanArray.valueAt(iIndexOfKey) : interfaceC4090.invoke().booleanValue();
    }

    public static final int getSize(SparseBooleanArray sparseBooleanArray) {
        C3921.m12666(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        C3921.m12666(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseBooleanArray sparseBooleanArray) {
        C3921.m12666(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() != 0;
    }

    public static final AbstractC2348 keyIterator(final SparseBooleanArray sparseBooleanArray) {
        C3921.m12666(sparseBooleanArray, "<this>");
        return new AbstractC2348() { // from class: androidx.core.util.SparseBooleanArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // defpackage.AbstractC2348
            public int nextInt() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i = this.index;
                this.index = i + 1;
                return sparseBooleanArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final SparseBooleanArray plus(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        C3921.m12666(sparseBooleanArray, "<this>");
        C3921.m12666(sparseBooleanArray2, "other");
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        C3921.m12666(sparseBooleanArray, "<this>");
        C3921.m12666(sparseBooleanArray2, "other");
        int size = sparseBooleanArray2.size();
        for (int i = 0; i < size; i++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i), sparseBooleanArray2.valueAt(i));
        }
    }

    public static final boolean remove(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        C3921.m12666(sparseBooleanArray, "<this>");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i);
        if (iIndexOfKey < 0 || z != sparseBooleanArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i);
        return true;
    }

    public static final void set(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        C3921.m12666(sparseBooleanArray, "<this>");
        sparseBooleanArray.put(i, z);
    }

    public static final AbstractC3257 valueIterator(final SparseBooleanArray sparseBooleanArray) {
        C3921.m12666(sparseBooleanArray, "<this>");
        return new AbstractC3257() { // from class: androidx.core.util.SparseBooleanArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // defpackage.AbstractC3257
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i = this.index;
                this.index = i + 1;
                return sparseBooleanArray2.valueAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }
}
