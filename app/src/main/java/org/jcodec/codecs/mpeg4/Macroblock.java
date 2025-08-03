package org.jcodec.codecs.mpeg4;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public class Macroblock {
    public static final int MBPRED_SIZE = 15;
    public int[] acpredDirections;
    public boolean acpredFlag;
    public Vector amv;
    public short[][] block;
    public int bound;
    public int cbp;
    public boolean coded;
    public boolean fieldDCT;
    public boolean fieldForBottom;
    public boolean fieldForTop;
    public boolean fieldPred;
    public boolean mcsel;
    public int mode;
    public Vector mvsAvg;
    public byte[][] pred;
    public short[][] predValues;
    public short[] predictors;
    public int quant;
    public int x;
    public int y;
    public Vector[] mvs = new Vector[4];
    private Vector[] pmvs = new Vector[4];
    private Vector[] qmvs = new Vector[4];
    public Vector[] bmvs = new Vector[4];
    public Vector[] bqmvs = new Vector[4];

    public static class Vector {
        public int x;
        public int y;

        public Vector(int i, int i2) {
            this.x = i;
            this.y = i2;
        }
    }

    public Macroblock() {
        for (int i = 0; i < 4; i++) {
            this.mvs[i] = vec();
            this.pmvs[i] = vec();
            this.qmvs[i] = vec();
            this.bmvs[i] = vec();
            this.bqmvs[i] = vec();
        }
        this.pred = new byte[][]{new byte[256], new byte[64], new byte[64], new byte[256], new byte[64], new byte[64]};
        this.predValues = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 6, 15);
        this.acpredDirections = new int[6];
        this.amv = vec();
        this.predictors = new short[8];
        this.block = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 6, 64);
    }

    public static Vector vec() {
        return new Vector(0, 0);
    }

    public void reset(int i, int i2, int i3) {
        this.x = i;
        this.y = i2;
        this.bound = i3;
    }
}
