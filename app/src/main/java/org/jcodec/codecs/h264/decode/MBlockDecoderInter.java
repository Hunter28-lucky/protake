package org.jcodec.codecs.h264.decode;

import com.xiaomi.mipush.sdk.Constants;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.decode.MBlock;
import org.jcodec.codecs.h264.decode.aso.Mapper;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class MBlockDecoderInter extends MBlockDecoderBase {
    private Mapper mapper;

    public MBlockDecoderInter(Mapper mapper, SliceHeader sliceHeader, DeblockerInput deblockerInput, int i, DecoderState decoderState) {
        super(sliceHeader, deblockerInput, i, decoderState);
        this.mapper = mapper;
    }

    private void predictInter16x8(MBlock mBlock, Picture picture, Picture[][] pictureArr, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, int i3, H264Utils.MvList mvList, H264Const.PartPred partPred, H264Const.PartPred partPred2, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = -1;
        if (H264Const.usesList(partPred, i4)) {
            int i17 = i << 2;
            int i18 = i17 + 4;
            int iCalcMVPrediction16x8Top = calcMVPrediction16x8Top(this.s.mvLeft.getMv(0, i4), this.s.mvTop.getMv(i17, i4), this.s.mvTop.getMv(i18, i4), this.s.mvTopLeft.getMv(0, i4), z, z2, z4, z3, mBlock.pb168x168.refIdx1[i4], 0);
            int iCalcMVPrediction16x8Top2 = calcMVPrediction16x8Top(this.s.mvLeft.getMv(0, i4), this.s.mvTop.getMv(i17, i4), this.s.mvTop.getMv(i18, i4), this.s.mvTopLeft.getMv(0, i4), z, z2, z4, z3, mBlock.pb168x168.refIdx1[i4], 1);
            MBlock.PB168x168 pB168x168 = mBlock.pb168x168;
            i9 = pB168x168.mvdX1[i4] + iCalcMVPrediction16x8Top;
            i8 = pB168x168.mvdY1[i4] + iCalcMVPrediction16x8Top2;
            i6 = 0;
            i5 = 1;
            i7 = 2;
            MBlockDecoderUtils.debugPrint("MVP: (%d, %d), MVD: (%d, %d), MV: (%d,%d,%d)", Integer.valueOf(iCalcMVPrediction16x8Top), Integer.valueOf(iCalcMVPrediction16x8Top2), Integer.valueOf(mBlock.pb168x168.mvdX1[i4]), Integer.valueOf(mBlock.pb168x168.mvdY1[i4]), Integer.valueOf(i9), Integer.valueOf(i8), Integer.valueOf(mBlock.pb168x168.refIdx1[i4]));
            this.interpolator.getBlockLuma(pictureArr[i4][mBlock.pb168x168.refIdx1[i4]], picture, 0, (i << 6) + i9, (i2 << 6) + i8, 16, 8);
            i10 = mBlock.pb168x168.refIdx1[i4];
        } else {
            i5 = 1;
            i6 = 0;
            i7 = 2;
            i8 = 0;
            i9 = 0;
            i10 = -1;
        }
        int iPackMv = H264Utils.Mv.packMv(i9, i8, i10);
        if (H264Const.usesList(partPred2, i4)) {
            int mv = this.s.mvLeft.getMv(i7, i4);
            int i19 = MBlockDecoderUtils.NULL_VECTOR;
            i11 = iPackMv;
            i12 = i7;
            int iCalcMVPrediction16x8Bottom = calcMVPrediction16x8Bottom(mv, iPackMv, i19, this.s.mvLeft.getMv(i5, i4), z, true, false, z, mBlock.pb168x168.refIdx2[i4], 0);
            int iCalcMVPrediction16x8Bottom2 = calcMVPrediction16x8Bottom(this.s.mvLeft.getMv(i12, i4), i11, i19, this.s.mvLeft.getMv(1, i4), z, true, false, z, mBlock.pb168x168.refIdx2[i4], 1);
            MBlock.PB168x168 pB168x1682 = mBlock.pb168x168;
            i15 = pB168x1682.mvdX2[i4] + iCalcMVPrediction16x8Bottom;
            i14 = pB168x1682.mvdY2[i4] + iCalcMVPrediction16x8Bottom2;
            Object[] objArr = new Object[8];
            i13 = 0;
            objArr[0] = "MVP: (%d, %d), MVD: (%d, %d), MV: (%d,%d,%d)";
            objArr[1] = Integer.valueOf(iCalcMVPrediction16x8Bottom);
            objArr[i12] = Integer.valueOf(iCalcMVPrediction16x8Bottom2);
            objArr[3] = Integer.valueOf(mBlock.pb168x168.mvdX2[i4]);
            objArr[4] = Integer.valueOf(mBlock.pb168x168.mvdY2[i4]);
            objArr[5] = Integer.valueOf(i15);
            objArr[6] = Integer.valueOf(i14);
            objArr[7] = Integer.valueOf(mBlock.pb168x168.refIdx2[i4]);
            MBlockDecoderUtils.debugPrint(objArr);
            this.interpolator.getBlockLuma(pictureArr[i4][mBlock.pb168x168.refIdx2[i4]], picture, 128, (i << 6) + i15, (i2 << 6) + 32 + i14, 16, 8);
            i16 = mBlock.pb168x168.refIdx2[i4];
        } else {
            i11 = iPackMv;
            i12 = i7;
            i13 = i6;
            i14 = i13;
            i15 = i14;
        }
        int iPackMv2 = H264Utils.Mv.packMv(i15, i14, i16);
        DecoderState decoderState = this.s;
        decoderState.mvTopLeft.setMv(i13, i4, decoderState.mvTop.getMv(i3 + 3, i4));
        int i20 = i11;
        MBlockDecoderUtils.saveVect(this.s.mvLeft, i4, i13, i12, i20);
        MBlockDecoderUtils.saveVect(this.s.mvLeft, i4, i12, 4, iPackMv2);
        MBlockDecoderUtils.saveVect(this.s.mvTop, i4, i3, i3 + 4, iPackMv2);
        for (int i21 = i13; i21 < 8; i21++) {
            mvList.setMv(i21, i4, i20);
        }
        for (int i22 = 8; i22 < 16; i22++) {
            mvList.setMv(i22, i4, iPackMv2);
        }
    }

    private void predictInter8x16(MBlock mBlock, Picture picture, Picture[][] pictureArr, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, H264Utils.MvList mvList, int i3, H264Const.PartPred partPred, H264Const.PartPred partPred2) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = i << 2;
        if (H264Const.usesList(partPred, i3)) {
            int i13 = i12 + 2;
            int iCalcMVPrediction8x16Left = calcMVPrediction8x16Left(this.s.mvLeft.getMv(0, i3), this.s.mvTop.getMv(i12, i3), this.s.mvTop.getMv(i13, i3), this.s.mvTopLeft.getMv(0, i3), z, z2, z2, z3, mBlock.pb168x168.refIdx1[i3], 0);
            int iCalcMVPrediction8x16Left2 = calcMVPrediction8x16Left(this.s.mvLeft.getMv(0, i3), this.s.mvTop.getMv(i12, i3), this.s.mvTop.getMv(i13, i3), this.s.mvTopLeft.getMv(0, i3), z, z2, z2, z3, mBlock.pb168x168.refIdx1[i3], 1);
            MBlock.PB168x168 pB168x168 = mBlock.pb168x168;
            i5 = pB168x168.mvdX1[i3] + iCalcMVPrediction8x16Left;
            i4 = pB168x168.mvdY1[i3] + iCalcMVPrediction8x16Left2;
            MBlockDecoderUtils.debugPrint("MVP: (%d, %d), MVD: (%d, %d), MV: (%d,%d,%d)", Integer.valueOf(iCalcMVPrediction8x16Left), Integer.valueOf(iCalcMVPrediction8x16Left2), Integer.valueOf(mBlock.pb168x168.mvdX1[i3]), Integer.valueOf(mBlock.pb168x168.mvdY1[i3]), Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(mBlock.pb168x168.refIdx1[i3]));
            this.interpolator.getBlockLuma(pictureArr[i3][mBlock.pb168x168.refIdx1[i3]], picture, 0, (i << 6) + i5, (i2 << 6) + i4, 8, 16);
            i6 = mBlock.pb168x168.refIdx1[i3];
        } else {
            i4 = 0;
            i5 = 0;
            i6 = -1;
        }
        int iPackMv = H264Utils.Mv.packMv(i5, i4, i6);
        if (H264Const.usesList(partPred2, i3)) {
            int i14 = i12 + 2;
            int i15 = i12 + 4;
            int i16 = i12 + 1;
            i7 = iPackMv;
            int iCalcMVPrediction8x16Right = calcMVPrediction8x16Right(iPackMv, this.s.mvTop.getMv(i14, i3), this.s.mvTop.getMv(i15, i3), this.s.mvTop.getMv(i16, i3), true, z2, z4, z2, mBlock.pb168x168.refIdx2[i3], 0);
            i8 = i12;
            int iCalcMVPrediction8x16Right2 = calcMVPrediction8x16Right(i7, this.s.mvTop.getMv(i14, i3), this.s.mvTop.getMv(i15, i3), this.s.mvTop.getMv(i16, i3), true, z2, z4, z2, mBlock.pb168x168.refIdx2[i3], 1);
            MBlock.PB168x168 pB168x1682 = mBlock.pb168x168;
            i11 = pB168x1682.mvdX2[i3] + iCalcMVPrediction8x16Right;
            i10 = pB168x1682.mvdY2[i3] + iCalcMVPrediction8x16Right2;
            MBlockDecoderUtils.debugPrint("MVP: (" + iCalcMVPrediction8x16Right + ", " + iCalcMVPrediction8x16Right2 + "), MVD: (" + mBlock.pb168x168.mvdX2[i3] + ", " + mBlock.pb168x168.mvdY2[i3] + "), MV: (" + i11 + Constants.ACCEPT_TIME_SEPARATOR_SP + i10 + Constants.ACCEPT_TIME_SEPARATOR_SP + mBlock.pb168x168.refIdx2[i3] + ")");
            this.interpolator.getBlockLuma(pictureArr[i3][mBlock.pb168x168.refIdx2[i3]], picture, 8, (i << 6) + 32 + i11, (i2 << 6) + i10, 8, 16);
            i9 = mBlock.pb168x168.refIdx2[i3];
        } else {
            i7 = iPackMv;
            i8 = i12;
            i9 = -1;
            i10 = 0;
            i11 = 0;
        }
        int iPackMv2 = H264Utils.Mv.packMv(i11, i10, i9);
        DecoderState decoderState = this.s;
        decoderState.mvTopLeft.setMv(0, i3, decoderState.mvTop.getMv(i8 + 3, i3));
        int i17 = i8 + 2;
        int i18 = i7;
        int i19 = i8;
        MBlockDecoderUtils.saveVect(this.s.mvTop, i3, i19, i17, i18);
        MBlockDecoderUtils.saveVect(this.s.mvTop, i3, i17, i19 + 4, iPackMv2);
        MBlockDecoderUtils.saveVect(this.s.mvLeft, i3, 0, 4, iPackMv2);
        for (int i20 = 0; i20 < 16; i20 += 4) {
            mvList.setMv(i20, i3, i18);
            mvList.setMv(i20 + 1, i3, i18);
            mvList.setMv(i20 + 2, i3, iPackMv2);
            mvList.setMv(i20 + 3, i3, iPackMv2);
        }
    }

    private void residualInter(MBlock mBlock, Frame[][] frameArr, boolean z, boolean z2, int i, int i2, int i3) {
        if (mBlock.cbpLuma() > 0 || mBlock.cbpChroma() > 0) {
            DecoderState decoderState = this.s;
            decoderState.qp = ((decoderState.qp + mBlock.mbQPDelta) + 52) % 52;
        }
        this.di.mbQps[0][i3] = this.s.qp;
        residualLuma(mBlock, z, z2, i, i2);
        DecoderState decoderState2 = this.s;
        if (decoderState2.chromaFormat != ColorSpace.MONO) {
            int iCalcQpChroma = MBlockDecoderBase.calcQpChroma(decoderState2.qp, decoderState2.chromaQpOffset[0]);
            DecoderState decoderState3 = this.s;
            int iCalcQpChroma2 = MBlockDecoderBase.calcQpChroma(decoderState3.qp, decoderState3.chromaQpOffset[1]);
            decodeChromaResidual(mBlock, z, z2, i, i2, iCalcQpChroma, iCalcQpChroma2);
            int[][] iArr = this.di.mbQps;
            iArr[1][i3] = iCalcQpChroma;
            iArr[2][i3] = iCalcQpChroma2;
        }
        this.di.tr8x8Used[i3] = mBlock.transform8x8Used;
    }

    public int calcMVPrediction16x8Bottom(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6) {
        return (z && H264Utils.Mv.mvRef(i) == i5) ? H264Utils.Mv.mvC(i, i6) : MBlockDecoderUtils.calcMVPredictionMedian(i, i2, i3, i4, z, z2, z3, z4, i5, i6);
    }

    public int calcMVPrediction16x8Top(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6) {
        return (z2 && H264Utils.Mv.mvRef(i2) == i5) ? H264Utils.Mv.mvC(i2, i6) : MBlockDecoderUtils.calcMVPredictionMedian(i, i2, i3, i4, z, z2, z3, z4, i5, i6);
    }

    public int calcMVPrediction8x16Left(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6) {
        return (z && H264Utils.Mv.mvRef(i) == i5) ? H264Utils.Mv.mvC(i, i6) : MBlockDecoderUtils.calcMVPredictionMedian(i, i2, i3, i4, z, z2, z3, z4, i5, i6);
    }

    public int calcMVPrediction8x16Right(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6) {
        int i7 = z3 ? i3 : z4 ? i4 : MBlockDecoderUtils.NULL_VECTOR;
        return H264Utils.Mv.mvRef(i7) == i5 ? H264Utils.Mv.mvC(i7, i6) : MBlockDecoderUtils.calcMVPredictionMedian(i, i2, i3, i4, z, z2, z3, z4, i5, i6);
    }

    public void decode16x16(MBlock mBlock, Picture picture, Frame[][] frameArr, H264Const.PartPred partPred) {
        int mbX = this.mapper.getMbX(mBlock.mbIdx);
        int mbY = this.mapper.getMbY(mBlock.mbIdx);
        boolean zLeftAvailable = this.mapper.leftAvailable(mBlock.mbIdx);
        boolean z = this.mapper.topAvailable(mBlock.mbIdx);
        boolean z2 = this.mapper.topLeftAvailable(mBlock.mbIdx);
        boolean z3 = this.mapper.topRightAvailable(mBlock.mbIdx);
        int address = this.mapper.getAddress(mBlock.mbIdx);
        int i = mbX << 2;
        int i2 = 0;
        while (i2 < 2) {
            int i3 = i2;
            predictInter16x16(mBlock, this.mbb[i2], frameArr, mbX, mbY, zLeftAvailable, z, z2, z3, mBlock.x, i, i3, partPred);
            i2 = i3 + 1;
            mbY = mbY;
            mbX = mbX;
        }
        int i4 = mbY;
        int i5 = mbX;
        PredictionMerger.mergePrediction(this.sh, mBlock.x.mv0R(0), mBlock.x.mv1R(0), partPred, 0, this.mbb[0].getPlaneData(0), this.mbb[1].getPlaneData(0), 0, 16, 16, 16, picture.getPlaneData(0), frameArr, this.poc);
        H264Const.PartPred[] partPredArr = mBlock.partPreds;
        partPredArr[3] = partPred;
        partPredArr[2] = partPred;
        partPredArr[1] = partPred;
        partPredArr[0] = partPred;
        int i6 = i5 << 3;
        int i7 = i4 << 3;
        predictChromaInter(frameArr, mBlock.x, i6, i7, 1, picture, partPredArr);
        predictChromaInter(frameArr, mBlock.x, i6, i7, 2, picture, mBlock.partPreds);
        residualInter(mBlock, frameArr, zLeftAvailable, z, i5, i4, this.mapper.getAddress(mBlock.mbIdx));
        MBlockDecoderUtils.saveMvs(this.di, mBlock.x, i5, i4);
        int[][][] iArr = mBlock.ac;
        boolean z4 = mBlock.transform8x8Used;
        MBlockDecoderUtils.mergeResidual(picture, iArr, z4 ? H264Const.COMP_BLOCK_8x8_LUT : H264Const.COMP_BLOCK_4x4_LUT, z4 ? H264Const.COMP_POS_8x8_LUT : H264Const.COMP_POS_4x4_LUT);
        MBlockDecoderUtils.collectPredictors(this.s, picture, i5);
        this.di.mbTypes[address] = mBlock.curMbType;
    }

    public void decode16x8(MBlock mBlock, Picture picture, Frame[][] frameArr, H264Const.PartPred partPred, H264Const.PartPred partPred2) {
        MBlock mBlock2 = mBlock;
        int mbX = this.mapper.getMbX(mBlock2.mbIdx);
        int mbY = this.mapper.getMbY(mBlock2.mbIdx);
        boolean zLeftAvailable = this.mapper.leftAvailable(mBlock2.mbIdx);
        boolean z = this.mapper.topAvailable(mBlock2.mbIdx);
        boolean z2 = this.mapper.topLeftAvailable(mBlock2.mbIdx);
        boolean z3 = this.mapper.topRightAvailable(mBlock2.mbIdx);
        int address = this.mapper.getAddress(mBlock2.mbIdx);
        int i = mbX << 2;
        int i2 = 0;
        while (i2 < 2) {
            int i3 = i2;
            predictInter16x8(mBlock, this.mbb[i2], frameArr, mbX, mbY, zLeftAvailable, z, z2, z3, i, mBlock2.x, partPred, partPred2, i3);
            i2 = i3 + 1;
            mBlock2 = mBlock;
            mbY = mbY;
            mbX = mbX;
        }
        int i4 = mbY;
        int i5 = mbX;
        PredictionMerger.mergePrediction(this.sh, mBlock.x.mv0R(0), mBlock.x.mv1R(0), partPred, 0, this.mbb[0].getPlaneData(0), this.mbb[1].getPlaneData(0), 0, 16, 16, 8, picture.getPlaneData(0), frameArr, this.poc);
        PredictionMerger.mergePrediction(this.sh, mBlock.x.mv0R(8), mBlock.x.mv1R(8), partPred2, 0, this.mbb[0].getPlaneData(0), this.mbb[1].getPlaneData(0), 128, 16, 16, 8, picture.getPlaneData(0), frameArr, this.poc);
        H264Const.PartPred[] partPredArr = mBlock.partPreds;
        partPredArr[1] = partPred;
        partPredArr[0] = partPred;
        partPredArr[3] = partPred2;
        partPredArr[2] = partPred2;
        int i6 = i5 << 3;
        int i7 = i4 << 3;
        predictChromaInter(frameArr, mBlock.x, i6, i7, 1, picture, partPredArr);
        predictChromaInter(frameArr, mBlock.x, i6, i7, 2, picture, mBlock.partPreds);
        residualInter(mBlock, frameArr, zLeftAvailable, z, i5, i4, this.mapper.getAddress(mBlock.mbIdx));
        MBlockDecoderUtils.saveMvs(this.di, mBlock.x, i5, i4);
        int[][][] iArr = mBlock.ac;
        boolean z4 = mBlock.transform8x8Used;
        MBlockDecoderUtils.mergeResidual(picture, iArr, z4 ? H264Const.COMP_BLOCK_8x8_LUT : H264Const.COMP_BLOCK_4x4_LUT, z4 ? H264Const.COMP_POS_8x8_LUT : H264Const.COMP_POS_4x4_LUT);
        MBlockDecoderUtils.collectPredictors(this.s, picture, i5);
        this.di.mbTypes[address] = mBlock.curMbType;
    }

    public void decode8x16(MBlock mBlock, Picture picture, Frame[][] frameArr, H264Const.PartPred partPred, H264Const.PartPred partPred2) {
        int mbX = this.mapper.getMbX(mBlock.mbIdx);
        int mbY = this.mapper.getMbY(mBlock.mbIdx);
        boolean zLeftAvailable = this.mapper.leftAvailable(mBlock.mbIdx);
        boolean z = this.mapper.topAvailable(mBlock.mbIdx);
        boolean z2 = this.mapper.topLeftAvailable(mBlock.mbIdx);
        boolean z3 = this.mapper.topRightAvailable(mBlock.mbIdx);
        int address = this.mapper.getAddress(mBlock.mbIdx);
        int i = 0;
        while (i < 2) {
            int i2 = i;
            predictInter8x16(mBlock, this.mbb[i], frameArr, mbX, mbY, zLeftAvailable, z, z2, z3, mBlock.x, i2, partPred, partPred2);
            i = i2 + 1;
            mbY = mbY;
            mbX = mbX;
        }
        int i3 = mbY;
        int i4 = mbX;
        PredictionMerger.mergePrediction(this.sh, mBlock.x.mv0R(0), mBlock.x.mv1R(0), partPred, 0, this.mbb[0].getPlaneData(0), this.mbb[1].getPlaneData(0), 0, 16, 8, 16, picture.getPlaneData(0), frameArr, this.poc);
        PredictionMerger.mergePrediction(this.sh, mBlock.x.mv0R(2), mBlock.x.mv1R(2), partPred2, 0, this.mbb[0].getPlaneData(0), this.mbb[1].getPlaneData(0), 8, 16, 8, 16, picture.getPlaneData(0), frameArr, this.poc);
        H264Const.PartPred[] partPredArr = mBlock.partPreds;
        partPredArr[2] = partPred;
        partPredArr[0] = partPred;
        partPredArr[3] = partPred2;
        partPredArr[1] = partPred2;
        int i5 = i4 << 3;
        int i6 = i3 << 3;
        predictChromaInter(frameArr, mBlock.x, i5, i6, 1, picture, partPredArr);
        predictChromaInter(frameArr, mBlock.x, i5, i6, 2, picture, mBlock.partPreds);
        residualInter(mBlock, frameArr, zLeftAvailable, z, i4, i3, this.mapper.getAddress(mBlock.mbIdx));
        MBlockDecoderUtils.saveMvs(this.di, mBlock.x, i4, i3);
        int[][][] iArr = mBlock.ac;
        boolean z4 = mBlock.transform8x8Used;
        MBlockDecoderUtils.mergeResidual(picture, iArr, z4 ? H264Const.COMP_BLOCK_8x8_LUT : H264Const.COMP_BLOCK_4x4_LUT, z4 ? H264Const.COMP_POS_8x8_LUT : H264Const.COMP_POS_4x4_LUT);
        MBlockDecoderUtils.collectPredictors(this.s, picture, i4);
        this.di.mbTypes[address] = mBlock.curMbType;
    }

    public void predictInter16x16(MBlock mBlock, Picture picture, Picture[][] pictureArr, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, H264Utils.MvList mvList, int i3, int i4, H264Const.PartPred partPred) {
        int i5;
        int i6;
        int i7;
        if (H264Const.usesList(partPred, i4)) {
            int i8 = i << 2;
            int i9 = i8 + 4;
            int iCalcMVPredictionMedian = MBlockDecoderUtils.calcMVPredictionMedian(this.s.mvLeft.getMv(0, i4), this.s.mvTop.getMv(i8, i4), this.s.mvTop.getMv(i9, i4), this.s.mvTopLeft.getMv(0, i4), z, z2, z4, z3, mBlock.pb16x16.refIdx[i4], 0);
            int iCalcMVPredictionMedian2 = MBlockDecoderUtils.calcMVPredictionMedian(this.s.mvLeft.getMv(0, i4), this.s.mvTop.getMv(i8, i4), this.s.mvTop.getMv(i9, i4), this.s.mvTopLeft.getMv(0, i4), z, z2, z4, z3, mBlock.pb16x16.refIdx[i4], 1);
            MBlock.PB16x16 pB16x16 = mBlock.pb16x16;
            i7 = pB16x16.mvdX[i4] + iCalcMVPredictionMedian;
            i6 = pB16x16.mvdY[i4] + iCalcMVPredictionMedian2;
            MBlockDecoderUtils.debugPrint("MVP: (%d, %d), MVD: (%d, %d), MV: (%d,%d,%d)", Integer.valueOf(iCalcMVPredictionMedian), Integer.valueOf(iCalcMVPredictionMedian2), Integer.valueOf(mBlock.pb16x16.mvdX[i4]), Integer.valueOf(mBlock.pb16x16.mvdY[i4]), Integer.valueOf(i7), Integer.valueOf(i6), Integer.valueOf(mBlock.pb16x16.refIdx[i4]));
            i5 = mBlock.pb16x16.refIdx[i4];
            this.interpolator.getBlockLuma(pictureArr[i4][i5], picture, 0, (i << 6) + i7, (i2 << 6) + i6, 16, 16);
        } else {
            i5 = -1;
            i6 = 0;
            i7 = 0;
        }
        int iPackMv = H264Utils.Mv.packMv(i7, i6, i5);
        DecoderState decoderState = this.s;
        decoderState.mvTopLeft.setMv(0, i4, decoderState.mvTop.getMv(i3 + 3, i4));
        MBlockDecoderUtils.saveVect(this.s.mvTop, i4, i3, i3 + 4, iPackMv);
        MBlockDecoderUtils.saveVect(this.s.mvLeft, i4, 0, 4, iPackMv);
        for (int i10 = 0; i10 < 16; i10++) {
            mvList.setMv(i10, i4, iPackMv);
        }
    }
}
