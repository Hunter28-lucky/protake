package org.jcodec.common;

/* loaded from: classes2.dex */
public class IntIntHistogram extends IntIntMap {
    private int maxBin = -1;

    public void increment(int i) {
        int i2 = get(i);
        int i3 = i2 != Integer.MIN_VALUE ? 1 + i2 : 1;
        put(i, i3);
        if (this.maxBin == -1) {
            this.maxBin = i;
        }
        if (i3 > get(this.maxBin)) {
            this.maxBin = i;
        }
    }

    public int max() {
        return this.maxBin;
    }
}
