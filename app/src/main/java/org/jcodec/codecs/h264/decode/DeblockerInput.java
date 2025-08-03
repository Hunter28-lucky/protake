package org.jcodec.codecs.h264.decode;

import java.lang.reflect.Array;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;

/* loaded from: classes2.dex */
public class DeblockerInput {
    public int[][] mbQps;
    public MBType[] mbTypes;
    public H264Utils.MvList2D mvs;
    public int[][] nCoeff;
    public Frame[][][] refsUsed;
    public SliceHeader[] shs;
    public boolean[] tr8x8Used;

    public DeblockerInput(SeqParameterSet seqParameterSet) {
        int i = seqParameterSet.picWidthInMbsMinus1 + 1;
        int picHeightInMbs = SeqParameterSet.getPicHeightInMbs(seqParameterSet);
        int i2 = picHeightInMbs << 2;
        int i3 = i << 2;
        Class cls = Integer.TYPE;
        this.nCoeff = (int[][]) Array.newInstance((Class<?>) cls, i2, i3);
        this.mvs = new H264Utils.MvList2D(i3, i2);
        int i4 = picHeightInMbs * i;
        this.mbTypes = new MBType[i4];
        this.tr8x8Used = new boolean[i4];
        this.mbQps = (int[][]) Array.newInstance((Class<?>) cls, 3, i4);
        this.shs = new SliceHeader[i4];
        this.refsUsed = new Frame[i4][][];
    }
}
