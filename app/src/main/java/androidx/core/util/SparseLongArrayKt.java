package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC2348;
import defpackage.AbstractC4899;
import defpackage.C3921;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC4090;
import defpackage.i4;

/* compiled from: SparseLongArray.kt */
/* loaded from: classes.dex */
public final class SparseLongArrayKt {
    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean contains(SparseLongArray sparseLongArray, int i) {
        C3921.m12666(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean containsKey(SparseLongArray sparseLongArray, int i) {
        C3921.m12666(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean containsValue(SparseLongArray sparseLongArray, long j) {
        C3921.m12666(sparseLongArray, "<this>");
        return sparseLongArray.indexOfValue(j) >= 0;
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final void forEach(SparseLongArray sparseLongArray, InterfaceC2849<? super Integer, ? super Long, i4> interfaceC2849) {
        C3921.m12666(sparseLongArray, "<this>");
        C3921.m12666(interfaceC2849, "action");
        int size = sparseLongArray.size();
        for (int i = 0; i < size; i++) {
            interfaceC2849.invoke(Integer.valueOf(sparseLongArray.keyAt(i)), Long.valueOf(sparseLongArray.valueAt(i)));
        }
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long getOrDefault(SparseLongArray sparseLongArray, int i, long j) {
        C3921.m12666(sparseLongArray, "<this>");
        return sparseLongArray.get(i, j);
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long getOrElse(SparseLongArray sparseLongArray, int i, InterfaceC4090<Long> interfaceC4090) {
        C3921.m12666(sparseLongArray, "<this>");
        C3921.m12666(interfaceC4090, "defaultValue");
        int iIndexOfKey = sparseLongArray.indexOfKey(i);
        return iIndexOfKey >= 0 ? sparseLongArray.valueAt(iIndexOfKey) : interfaceC4090.invoke().longValue();
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final int getSize(SparseLongArray sparseLongArray) {
        C3921.m12666(sparseLongArray, "<this>");
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean isEmpty(SparseLongArray sparseLongArray) {
        C3921.m12666(sparseLongArray, "<this>");
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean isNotEmpty(SparseLongArray sparseLongArray) {
        C3921.m12666(sparseLongArray, "<this>");
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final AbstractC2348 keyIterator(final SparseLongArray sparseLongArray) {
        C3921.m12666(sparseLongArray, "<this>");
        return new AbstractC2348() { // from class: androidx.core.util.SparseLongArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // defpackage.AbstractC2348
            public int nextInt() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i = this.index;
                this.index = i + 1;
                return sparseLongArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final SparseLongArray plus(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        C3921.m12666(sparseLongArray, "<this>");
        C3921.m12666(sparseLongArray2, "other");
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final void putAll(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        C3921.m12666(sparseLongArray, "<this>");
        C3921.m12666(sparseLongArray2, "other");
        int size = sparseLongArray2.size();
        for (int i = 0; i < size; i++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i), sparseLongArray2.valueAt(i));
        }
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean remove(SparseLongArray sparseLongArray, int i, long j) {
        C3921.m12666(sparseLongArray, "<this>");
        int iIndexOfKey = sparseLongArray.indexOfKey(i);
        if (iIndexOfKey < 0 || j != sparseLongArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(iIndexOfKey);
        return true;
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final void set(SparseLongArray sparseLongArray, int i, long j) {
        C3921.m12666(sparseLongArray, "<this>");
        sparseLongArray.put(i, j);
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final AbstractC4899 valueIterator(final SparseLongArray sparseLongArray) {
        C3921.m12666(sparseLongArray, "<this>");
        return new AbstractC4899() { // from class: androidx.core.util.SparseLongArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // defpackage.AbstractC4899
            public long nextLong() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i = this.index;
                this.index = i + 1;
                return sparseLongArray2.valueAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }
}
