package org.jcodec.common;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class LongArrayList {
    private static final int DEFAULT_GROW_AMOUNT = 128;
    private int growAmount;
    private int limit;
    private int start;
    private long[] storage;

    public LongArrayList(int i) {
        this.growAmount = i;
        this.storage = new long[i];
    }

    public static LongArrayList createLongArrayList() {
        return new LongArrayList(128);
    }

    public void add(long j) {
        int i = this.limit;
        long[] jArr = this.storage;
        if (i > jArr.length - 1) {
            int length = jArr.length + this.growAmount;
            int i2 = this.start;
            long[] jArr2 = new long[length - i2];
            System.arraycopy(jArr, i2, jArr2, 0, jArr.length - i2);
            this.storage = jArr2;
            this.limit -= this.start;
            this.start = 0;
        }
        long[] jArr3 = this.storage;
        int i3 = this.limit;
        this.limit = i3 + 1;
        jArr3[i3] = j;
    }

    public void addAll(long[] jArr) {
        int i = this.limit;
        int length = jArr.length + i;
        long[] jArr2 = this.storage;
        if (length >= jArr2.length) {
            int length2 = this.growAmount + i + jArr.length;
            int i2 = this.start;
            long[] jArr3 = new long[length2 - i2];
            System.arraycopy(jArr2, i2, jArr3, 0, i);
            this.storage = jArr3;
        }
        System.arraycopy(jArr, 0, this.storage, this.limit, jArr.length);
        this.limit += jArr.length;
    }

    public void clear() {
        this.limit = 0;
        this.start = 0;
    }

    public boolean contains(long j) {
        for (int i = this.start; i < this.limit; i++) {
            if (this.storage[i] == j) {
                return true;
            }
        }
        return false;
    }

    public void fill(int i, int i2, int i3) {
        long[] jArr = this.storage;
        if (i2 > jArr.length) {
            int i4 = this.growAmount + i2;
            int i5 = this.start;
            long[] jArr2 = new long[i4 - i5];
            System.arraycopy(jArr, i5, jArr2, 0, jArr.length - i5);
            this.storage = jArr2;
        }
        Arrays.fill(this.storage, i, i2, i3);
        this.limit = Math.max(this.limit, i2);
    }

    public long get(int i) {
        return this.storage[i + this.start];
    }

    public long pop() {
        int i = this.limit;
        if (i <= this.start) {
            throw new IllegalStateException();
        }
        long[] jArr = this.storage;
        this.limit = i - 1;
        return jArr[i];
    }

    public void push(long j) {
        add(j);
    }

    public void set(int i, int i2) {
        this.storage[i + this.start] = i2;
    }

    public long shift() {
        int i = this.start;
        if (i >= this.limit) {
            throw new IllegalStateException();
        }
        long[] jArr = this.storage;
        this.start = i + 1;
        return jArr[i];
    }

    public int size() {
        return this.limit - this.start;
    }

    public long[] toArray() {
        int i = this.limit;
        int i2 = this.start;
        long[] jArr = new long[i - i2];
        System.arraycopy(this.storage, i2, jArr, 0, i - i2);
        return jArr;
    }
}
