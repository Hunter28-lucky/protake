package org.jcodec.codecs.h264.io.model;

import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class SliceHeader {
    public boolean bottomFieldFlag;
    public int cabacInitIdc;
    public int[] deltaPicOrderCnt;
    public int deltaPicOrderCntBottom;
    public boolean directSpatialMvPredFlag;
    public int disableDeblockingFilterIdc;
    public boolean fieldPicFlag;
    public int firstMbInSlice;
    public int frameNum;
    public int idrPicId;
    public int[] numRefIdxActiveMinus1 = new int[2];
    public boolean numRefIdxActiveOverrideFlag;
    public int picOrderCntLsb;
    public int picParameterSetId;
    public PictureParameterSet pps;
    public PredictionWeightTable predWeightTable;
    public int redundantPicCnt;
    public RefPicMarkingIDR refPicMarkingIDR;
    public RefPicMarking refPicMarkingNonIDR;
    public int[][][] refPicReordering;
    public int sliceAlphaC0OffsetDiv2;
    public int sliceBetaOffsetDiv2;
    public int sliceGroupChangeCycle;
    public int sliceQpDelta;
    public int sliceQsDelta;
    public SliceType sliceType;
    public boolean sliceTypeRestr;
    public boolean spForSwitchFlag;
    public SeqParameterSet sps;

    public String toString() {
        return Platform.toJSON(this);
    }
}
