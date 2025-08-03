package org.jcodec.codecs.h264.io.model;

/* loaded from: classes2.dex */
public class PredictionWeightTable {
    public int chromaLog2WeightDenom;
    public int lumaLog2WeightDenom;
    public int[][] lumaWeight = new int[2][];
    public int[][][] chromaWeight = new int[2][][];
    public int[][] lumaOffset = new int[2][];
    public int[][][] chromaOffset = new int[2][][];
}
