package org.jcodec.codecs.prores;

/* loaded from: classes2.dex */
public class Codebook {
    public int expOrder;
    public int golombBits;
    public int golombOffset;
    public int riceMask;
    public int riceOrder;
    public int switchBits;

    public Codebook(int i, int i2, int i3) {
        this.riceOrder = i;
        this.expOrder = i2;
        this.switchBits = i3;
        this.golombOffset = (1 << i2) - ((i3 + 1) << i);
        this.golombBits = (i2 - i3) - 1;
        this.riceMask = (1 << i) - 1;
    }
}
