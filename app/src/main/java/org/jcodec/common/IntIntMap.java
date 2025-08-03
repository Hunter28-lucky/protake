package org.jcodec.common;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class IntIntMap {
    private static final int GROW_BY = 128;
    private static final int MIN_VALUE = Integer.MIN_VALUE;
    private int _size;
    private int[] storage;

    public IntIntMap() {
        int[] iArrCreateArray = createArray(128);
        this.storage = iArrCreateArray;
        Arrays.fill(iArrCreateArray, Integer.MIN_VALUE);
    }

    private static int[] createArray(int i) {
        return new int[i];
    }

    public void clear() {
        int i = 0;
        while (true) {
            int[] iArr = this.storage;
            if (i >= iArr.length) {
                this._size = 0;
                return;
            } else {
                iArr[i] = Integer.MIN_VALUE;
                i++;
            }
        }
    }

    public boolean contains(int i) {
        return i >= 0 && i < this.storage.length;
    }

    public int get(int i) {
        int[] iArr = this.storage;
        if (i >= iArr.length) {
            return Integer.MIN_VALUE;
        }
        return iArr[i];
    }

    public int[] keys() {
        int[] iArr = new int[this._size];
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr2 = this.storage;
            if (i >= iArr2.length) {
                return iArr;
            }
            if (iArr2[i] != Integer.MIN_VALUE) {
                iArr[i2] = i;
                i2++;
            }
            i++;
        }
    }

    public void put(int i, int i2) {
        if (i2 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("This implementation can not store -2147483648");
        }
        if (this.storage.length <= i) {
            int[] iArrCreateArray = createArray(i + 128);
            int[] iArr = this.storage;
            System.arraycopy(iArr, 0, iArrCreateArray, 0, iArr.length);
            Arrays.fill(iArrCreateArray, this.storage.length, iArrCreateArray.length, Integer.MIN_VALUE);
            this.storage = iArrCreateArray;
        }
        int[] iArr2 = this.storage;
        if (iArr2[i] == Integer.MIN_VALUE) {
            this._size++;
        }
        iArr2[i] = i2;
    }

    public void remove(int i) {
        int[] iArr = this.storage;
        if (iArr[i] != Integer.MIN_VALUE) {
            this._size--;
        }
        iArr[i] = Integer.MIN_VALUE;
    }

    public int size() {
        return this._size;
    }

    public int[] values() {
        int[] iArrCreateArray = createArray(this._size);
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.storage;
            if (i >= iArr.length) {
                return iArrCreateArray;
            }
            int i3 = iArr[i];
            if (i3 != Integer.MIN_VALUE) {
                iArrCreateArray[i2] = i3;
                i2++;
            }
            i++;
        }
    }
}
