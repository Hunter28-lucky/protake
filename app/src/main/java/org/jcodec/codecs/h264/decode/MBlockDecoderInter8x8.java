package org.jcodec.codecs.h264.decode;

import java.util.Arrays;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.decode.MBlock;
import org.jcodec.codecs.h264.decode.aso.Mapper;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class MBlockDecoderInter8x8 extends MBlockDecoderBase {
    private MBlockDecoderBDirect bDirectDecoder;
    private Mapper mapper;

    public MBlockDecoderInter8x8(Mapper mapper, MBlockDecoderBDirect mBlockDecoderBDirect, SliceHeader sliceHeader, DeblockerInput deblockerInput, int i, DecoderState decoderState) {
        super(sliceHeader, deblockerInput, i, decoderState);
        this.mapper = mapper;
        this.bDirectDecoder = mBlockDecoderBDirect;
    }

    private void decodeSub4x4(MBlock mBlock, int i, Picture[] pictureArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, boolean z2, boolean z3, boolean z4, H264Utils.MvList mvList, int i10, int i11, int i12, int i13, int i14, Picture picture, int i15, int i16) {
        int iCalcMVPredictionMedian = MBlockDecoderUtils.calcMVPredictionMedian(i8, i5, i6, i4, z4, z2, z2, z, i14, 0);
        int iCalcMVPredictionMedian2 = MBlockDecoderUtils.calcMVPredictionMedian(i8, i5, i6, i4, z4, z2, z2, z, i14, 1);
        MBlock.PB8x8 pB8x8 = mBlock.pb8x8;
        int iPackMv = H264Utils.Mv.packMv(pB8x8.mvdX1[i16][i] + iCalcMVPredictionMedian, pB8x8.mvdY1[i16][i] + iCalcMVPredictionMedian2, i14);
        mvList.setMv(i10, i16, iPackMv);
        MBlockDecoderUtils.debugPrint("MVP: (%d, %d), MVD: (%d, %d), MV: (%d,%d,%d)", Integer.valueOf(iCalcMVPredictionMedian), Integer.valueOf(iCalcMVPredictionMedian2), Integer.valueOf(mBlock.pb8x8.mvdX1[i16][i]), Integer.valueOf(mBlock.pb8x8.mvdY1[i16][i]), Integer.valueOf(H264Utils.Mv.mvX(iPackMv)), Integer.valueOf(H264Utils.Mv.mvY(iPackMv)), Integer.valueOf(i14));
        int iCalcMVPredictionMedian3 = MBlockDecoderUtils.calcMVPredictionMedian(iPackMv, i6, i7, i5, true, z2, z3, z2, i14, 0);
        int iCalcMVPredictionMedian4 = MBlockDecoderUtils.calcMVPredictionMedian(iPackMv, i6, i7, i5, true, z2, z3, z2, i14, 1);
        MBlock.PB8x8 pB8x82 = mBlock.pb8x8;
        int iPackMv2 = H264Utils.Mv.packMv(pB8x82.mvdX2[i16][i] + iCalcMVPredictionMedian3, pB8x82.mvdY2[i16][i] + iCalcMVPredictionMedian4, i14);
        mvList.setMv(i11, i16, iPackMv2);
        MBlockDecoderUtils.debugPrint("MVP: (%d, %d), MVD: (%d, %d), MV: (%d,%d,%d)", Integer.valueOf(iCalcMVPredictionMedian3), Integer.valueOf(iCalcMVPredictionMedian4), Integer.valueOf(mBlock.pb8x8.mvdX2[i16][i]), Integer.valueOf(mBlock.pb8x8.mvdY2[i16][i]), Integer.valueOf(H264Utils.Mv.mvX(iPackMv2)), Integer.valueOf(H264Utils.Mv.mvY(iPackMv2)), Integer.valueOf(i14));
        int iCalcMVPredictionMedian5 = MBlockDecoderUtils.calcMVPredictionMedian(i9, iPackMv, iPackMv2, i8, z4, true, true, z4, i14, 0);
        int iCalcMVPredictionMedian6 = MBlockDecoderUtils.calcMVPredictionMedian(i9, iPackMv, iPackMv2, i8, z4, true, true, z4, i14, 1);
        MBlock.PB8x8 pB8x83 = mBlock.pb8x8;
        int iPackMv3 = H264Utils.Mv.packMv(pB8x83.mvdX3[i16][i] + iCalcMVPredictionMedian5, pB8x83.mvdY3[i16][i] + iCalcMVPredictionMedian6, i14);
        mvList.setMv(i12, i16, iPackMv3);
        MBlockDecoderUtils.debugPrint("MVP: (%d, %d), MVD: (%d, %d), MV: (%d,%d,%d)", Integer.valueOf(iCalcMVPredictionMedian5), Integer.valueOf(iCalcMVPredictionMedian6), Integer.valueOf(mBlock.pb8x8.mvdX3[i16][i]), Integer.valueOf(mBlock.pb8x8.mvdY3[i16][i]), Integer.valueOf(H264Utils.Mv.mvX(iPackMv3)), Integer.valueOf(H264Utils.Mv.mvY(iPackMv3)), Integer.valueOf(i14));
        int i17 = MBlockDecoderUtils.NULL_VECTOR;
        int iCalcMVPredictionMedian7 = MBlockDecoderUtils.calcMVPredictionMedian(iPackMv3, iPackMv2, i17, iPackMv, true, true, false, true, i14, 0);
        int iCalcMVPredictionMedian8 = MBlockDecoderUtils.calcMVPredictionMedian(iPackMv3, iPackMv2, i17, iPackMv, true, true, false, true, i14, 1);
        MBlock.PB8x8 pB8x84 = mBlock.pb8x8;
        int iPackMv4 = H264Utils.Mv.packMv(pB8x84.mvdX4[i16][i] + iCalcMVPredictionMedian7, pB8x84.mvdY4[i16][i] + iCalcMVPredictionMedian8, i14);
        mvList.setMv(i13, i16, iPackMv4);
        MBlockDecoderUtils.debugPrint("MVP: (%d, %d), MVD: (%d, %d), MV: (%d,%d,%d)", Integer.valueOf(iCalcMVPredictionMedian7), Integer.valueOf(iCalcMVPredictionMedian8), Integer.valueOf(mBlock.pb8x8.mvdX4[i16][i]), Integer.valueOf(mBlock.pb8x8.mvdY4[i16][i]), Integer.valueOf(H264Utils.Mv.mvX(iPackMv4)), Integer.valueOf(H264Utils.Mv.mvY(iPackMv4)), Integer.valueOf(i14));
        this.interpolator.getBlockLuma(pictureArr[i14], picture, i15, i2 + H264Utils.Mv.mvX(iPackMv), i3 + H264Utils.Mv.mvY(iPackMv), 4, 4);
        this.interpolator.getBlockLuma(pictureArr[i14], picture, i15 + 4, i2 + H264Utils.Mv.mvX(iPackMv2) + 16, i3 + H264Utils.Mv.mvY(iPackMv2), 4, 4);
        this.interpolator.getBlockLuma(pictureArr[i14], picture, i15 + (picture.getWidth() * 4), i2 + H264Utils.Mv.mvX(iPackMv3), i3 + H264Utils.Mv.mvY(iPackMv3) + 16, 4, 4);
        this.interpolator.getBlockLuma(pictureArr[i14], picture, i15 + (picture.getWidth() * 4) + 4, i2 + H264Utils.Mv.mvX(iPackMv4) + 16, i3 + H264Utils.Mv.mvY(iPackMv4) + 16, 4, 4);
    }

    private void decodeSub4x8(MBlock mBlock, int i, Picture[] pictureArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, boolean z2, boolean z3, boolean z4, H264Utils.MvList mvList, int i9, int i10, int i11, int i12, int i13, Picture picture, int i14, int i15) {
        int iCalcMVPredictionMedian = MBlockDecoderUtils.calcMVPredictionMedian(i8, i5, i6, i4, z4, z2, z2, z, i13, 0);
        int iCalcMVPredictionMedian2 = MBlockDecoderUtils.calcMVPredictionMedian(i8, i5, i6, i4, z4, z2, z2, z, i13, 1);
        MBlock.PB8x8 pB8x8 = mBlock.pb8x8;
        int iPackMv = H264Utils.Mv.packMv(pB8x8.mvdX1[i15][i] + iCalcMVPredictionMedian, pB8x8.mvdY1[i15][i] + iCalcMVPredictionMedian2, i13);
        mvList.setMv(i9, i15, iPackMv);
        mvList.setMv(i11, i15, iPackMv);
        MBlockDecoderUtils.debugPrint("MVP: (%d, %d), MVD: (%d, %d), MV: (%d,%d,%d)", Integer.valueOf(iCalcMVPredictionMedian), Integer.valueOf(iCalcMVPredictionMedian2), Integer.valueOf(mBlock.pb8x8.mvdX1[i15][i]), Integer.valueOf(mBlock.pb8x8.mvdY1[i15][i]), Integer.valueOf(H264Utils.Mv.mvX(iPackMv)), Integer.valueOf(H264Utils.Mv.mvY(iPackMv)), Integer.valueOf(i13));
        int iCalcMVPredictionMedian3 = MBlockDecoderUtils.calcMVPredictionMedian(iPackMv, i6, i7, i5, true, z2, z3, z2, i13, 0);
        int iCalcMVPredictionMedian4 = MBlockDecoderUtils.calcMVPredictionMedian(iPackMv, i6, i7, i5, true, z2, z3, z2, i13, 1);
        MBlock.PB8x8 pB8x82 = mBlock.pb8x8;
        int iPackMv2 = H264Utils.Mv.packMv(pB8x82.mvdX2[i15][i] + iCalcMVPredictionMedian3, pB8x82.mvdY2[i15][i] + iCalcMVPredictionMedian4, i13);
        mvList.setMv(i10, i15, iPackMv2);
        mvList.setMv(i12, i15, iPackMv2);
        MBlockDecoderUtils.debugPrint("MVP: (%d, %d), MVD: (%d, %d), MV: (%d,%d,%d)", Integer.valueOf(iCalcMVPredictionMedian3), Integer.valueOf(iCalcMVPredictionMedian4), Integer.valueOf(mBlock.pb8x8.mvdX2[i15][i]), Integer.valueOf(mBlock.pb8x8.mvdY2[i15][i]), Integer.valueOf(H264Utils.Mv.mvX(iPackMv2)), Integer.valueOf(H264Utils.Mv.mvY(iPackMv2)), Integer.valueOf(i13));
        this.interpolator.getBlockLuma(pictureArr[i13], picture, i14, i2 + H264Utils.Mv.mvX(iPackMv), i3 + H264Utils.Mv.mvY(iPackMv), 4, 8);
        this.interpolator.getBlockLuma(pictureArr[i13], picture, i14 + 4, i2 + H264Utils.Mv.mvX(iPackMv2) + 16, i3 + H264Utils.Mv.mvY(iPackMv2), 4, 8);
    }

    private void decodeSub8x4(MBlock mBlock, int i, Picture[] pictureArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, boolean z2, boolean z3, boolean z4, H264Utils.MvList mvList, int i9, int i10, int i11, int i12, int i13, Picture picture, int i14, int i15) {
        int iCalcMVPredictionMedian = MBlockDecoderUtils.calcMVPredictionMedian(i7, i5, i6, i4, z4, z2, z3, z, i13, 0);
        int iCalcMVPredictionMedian2 = MBlockDecoderUtils.calcMVPredictionMedian(i7, i5, i6, i4, z4, z2, z3, z, i13, 1);
        MBlock.PB8x8 pB8x8 = mBlock.pb8x8;
        int iPackMv = H264Utils.Mv.packMv(pB8x8.mvdX1[i15][i] + iCalcMVPredictionMedian, pB8x8.mvdY1[i15][i] + iCalcMVPredictionMedian2, i13);
        mvList.setMv(i9, i15, iPackMv);
        mvList.setMv(i10, i15, iPackMv);
        MBlockDecoderUtils.debugPrint("MVP: (%d, %d), MVD: (%d, %d), MV: (%d,%d,%d)", Integer.valueOf(iCalcMVPredictionMedian), Integer.valueOf(iCalcMVPredictionMedian2), Integer.valueOf(mBlock.pb8x8.mvdX1[i15][i]), Integer.valueOf(mBlock.pb8x8.mvdY1[i15][i]), Integer.valueOf(H264Utils.Mv.mvX(iPackMv)), Integer.valueOf(H264Utils.Mv.mvY(iPackMv)), Integer.valueOf(i13));
        int i16 = MBlockDecoderUtils.NULL_VECTOR;
        int iCalcMVPredictionMedian3 = MBlockDecoderUtils.calcMVPredictionMedian(i8, iPackMv, i16, i7, z4, true, false, z4, i13, 0);
        int iCalcMVPredictionMedian4 = MBlockDecoderUtils.calcMVPredictionMedian(i8, iPackMv, i16, i7, z4, true, false, z4, i13, 1);
        MBlock.PB8x8 pB8x82 = mBlock.pb8x8;
        int iPackMv2 = H264Utils.Mv.packMv(pB8x82.mvdX2[i15][i] + iCalcMVPredictionMedian3, pB8x82.mvdY2[i15][i] + iCalcMVPredictionMedian4, i13);
        mvList.setMv(i11, i15, iPackMv2);
        mvList.setMv(i12, i15, iPackMv2);
        MBlockDecoderUtils.debugPrint("MVP: (%d, %d), MVD: (%d, %d), MV: (%d,%d,%d)", Integer.valueOf(iCalcMVPredictionMedian3), Integer.valueOf(iCalcMVPredictionMedian4), Integer.valueOf(mBlock.pb8x8.mvdX2[i15][i]), Integer.valueOf(mBlock.pb8x8.mvdY2[i15][i]), Integer.valueOf(H264Utils.Mv.mvX(iPackMv2)), Integer.valueOf(H264Utils.Mv.mvY(iPackMv2)), Integer.valueOf(i13));
        this.interpolator.getBlockLuma(pictureArr[i13], picture, i14, i2 + H264Utils.Mv.mvX(iPackMv), i3 + H264Utils.Mv.mvY(iPackMv), 8, 4);
        this.interpolator.getBlockLuma(pictureArr[i13], picture, i14 + (picture.getWidth() * 4), i2 + H264Utils.Mv.mvX(iPackMv2), i3 + H264Utils.Mv.mvY(iPackMv2) + 16, 8, 4);
    }

    private void decodeSub8x8(MBlock mBlock, int i, Picture[] pictureArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2, boolean z3, boolean z4, H264Utils.MvList mvList, int i8, int i9, int i10, int i11, int i12, Picture picture, int i13, int i14) {
        int iCalcMVPredictionMedian = MBlockDecoderUtils.calcMVPredictionMedian(i7, i5, i6, i4, z4, z2, z3, z, i12, 0);
        int iCalcMVPredictionMedian2 = MBlockDecoderUtils.calcMVPredictionMedian(i7, i5, i6, i4, z4, z2, z3, z, i12, 1);
        MBlock.PB8x8 pB8x8 = mBlock.pb8x8;
        int iPackMv = H264Utils.Mv.packMv(pB8x8.mvdX1[i14][i] + iCalcMVPredictionMedian, pB8x8.mvdY1[i14][i] + iCalcMVPredictionMedian2, i12);
        mvList.setMv(i8, i14, iPackMv);
        mvList.setMv(i9, i14, iPackMv);
        mvList.setMv(i10, i14, iPackMv);
        mvList.setMv(i11, i14, iPackMv);
        MBlockDecoderUtils.debugPrint("MVP: (%d, %d), MVD: (%d, %d), MV: (%d,%d,%d)", Integer.valueOf(iCalcMVPredictionMedian), Integer.valueOf(iCalcMVPredictionMedian2), Integer.valueOf(mBlock.pb8x8.mvdX1[i14][i]), Integer.valueOf(mBlock.pb8x8.mvdY1[i14][i]), Integer.valueOf(H264Utils.Mv.mvX(iPackMv)), Integer.valueOf(H264Utils.Mv.mvY(iPackMv)), Integer.valueOf(i12));
        this.interpolator.getBlockLuma(pictureArr[i12], picture, i13, i2 + H264Utils.Mv.mvX(iPackMv), i3 + H264Utils.Mv.mvY(iPackMv), 8, 8);
    }

    private void decodeSubMb8x8(MBlock mBlock, int i, int i2, Picture[] pictureArr, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z, boolean z2, boolean z3, boolean z4, H264Utils.MvList mvList, int i11, int i12, int i13, int i14, int i15, Picture picture, int i16, int i17) {
        if (i2 == 0) {
            decodeSub8x8(mBlock, i, pictureArr, i3, i4, i5, i6, i8, i9, z, z2, z3, z4, mvList, i11, i12, i13, i14, i15, picture, i16, i17);
            return;
        }
        if (i2 == 1) {
            decodeSub8x4(mBlock, i, pictureArr, i3, i4, i5, i6, i8, i9, i10, z, z2, z3, z4, mvList, i11, i12, i13, i14, i15, picture, i16, i17);
        } else if (i2 == 2) {
            decodeSub4x8(mBlock, i, pictureArr, i3, i4, i5, i6, i7, i8, i9, z, z2, z3, z4, mvList, i11, i12, i13, i14, i15, picture, i16, i17);
        } else {
            if (i2 != 3) {
                return;
            }
            decodeSub4x4(mBlock, i, pictureArr, i3, i4, i5, i6, i7, i8, i9, i10, z, z2, z3, z4, mvList, i11, i12, i13, i14, i15, picture, i16, i17);
        }
    }

    private void predict8x8B(MBlock mBlock, Frame[][] frameArr, Picture picture, boolean z, int i, int i2, boolean z2, boolean z3, boolean z4, boolean z5, H264Utils.MvList mvList, H264Const.PartPred[] partPredArr) {
        int i3;
        int i4;
        int i5;
        char c;
        int i6;
        MBlock mBlock2;
        int i7;
        int i8;
        int i9;
        MBlockDecoderInter8x8 mBlockDecoderInter8x8 = this;
        MBlock mBlock3 = mBlock;
        int i10 = i;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 >= 4) {
                break;
            }
            partPredArr[i12] = H264Const.bPartPredModes[mBlock3.pb8x8.subMbTypes[i12]];
            i12++;
        }
        int i13 = 0;
        for (i3 = 4; i13 < i3; i3 = 4) {
            if (partPredArr[i13] == H264Const.PartPred.Direct) {
                i8 = i13;
                i9 = i11;
                mBlockDecoderInter8x8.bDirectDecoder.predictBDirect(frameArr, i, i2, z2, z3, z4, z5, mvList, partPredArr, picture, H264Const.ARRAY[i13]);
            } else {
                i8 = i13;
                i9 = i11;
            }
            i13 = i8 + 1;
            i11 = i9;
        }
        int i14 = i11;
        int i15 = i14;
        while (i15 < 2) {
            H264Const.PartPred[] partPredArr2 = H264Const.bPartPredModes;
            if (H264Const.usesList(partPredArr2[mBlock3.pb8x8.subMbTypes[i14]], i15)) {
                int i16 = i10 << 2;
                i4 = i15;
                decodeSubMb8x8(mBlock, 0, H264Const.bSubMbTypes[mBlock3.pb8x8.subMbTypes[i14]], frameArr[i15], i10 << 6, i2 << 6, mBlockDecoderInter8x8.s.mvTopLeft.getMv(i14, i15), mBlockDecoderInter8x8.s.mvTop.getMv(i16, i15), mBlockDecoderInter8x8.s.mvTop.getMv(i16 + 1, i15), mBlockDecoderInter8x8.s.mvTop.getMv(i16 + 2, i15), mBlockDecoderInter8x8.s.mvLeft.getMv(i14, i15), mBlockDecoderInter8x8.s.mvLeft.getMv(1, i15), z4, z3, z3, z2, mvList, 0, 1, 4, 5, mBlock3.pb8x8.refIdx[i15][i14], mBlockDecoderInter8x8.mbb[i15], 0, i4);
            } else {
                i4 = i15;
            }
            int i17 = i4;
            if (H264Const.usesList(partPredArr2[mBlock.pb8x8.subMbTypes[1]], i17)) {
                int i18 = i << 2;
                i5 = i17;
                decodeSubMb8x8(mBlock, 1, H264Const.bSubMbTypes[mBlock.pb8x8.subMbTypes[1]], frameArr[i17], (i << 6) + 32, i2 << 6, this.s.mvTop.getMv(i18 + 1, i17), this.s.mvTop.getMv(i18 + 2, i17), this.s.mvTop.getMv(i18 + 3, i17), this.s.mvTop.getMv(i18 + 4, i17), mvList.getMv(1, i17), mvList.getMv(5, i17), z3, z3, z5, true, mvList, 2, 3, 6, 7, mBlock.pb8x8.refIdx[i17][1], this.mbb[i17], 8, i5);
            } else {
                i5 = i17;
            }
            int i19 = i5;
            if (H264Const.usesList(partPredArr2[mBlock.pb8x8.subMbTypes[2]], i19)) {
                c = 3;
                mBlock2 = mBlock;
                i6 = i19;
                decodeSubMb8x8(mBlock2, 2, H264Const.bSubMbTypes[mBlock.pb8x8.subMbTypes[2]], frameArr[i19], i << 6, (i2 << 6) + 32, this.s.mvLeft.getMv(1, i19), mvList.getMv(4, i19), mvList.getMv(5, i19), mvList.getMv(6, i19), this.s.mvLeft.getMv(2, i19), this.s.mvLeft.getMv(3, i19), z2, true, true, z2, mvList, 8, 9, 12, 13, mBlock.pb8x8.refIdx[i19][2], this.mbb[i19], 128, i19);
            } else {
                c = 3;
                i6 = i19;
                mBlock2 = mBlock;
            }
            int i20 = i6;
            if (H264Const.usesList(partPredArr2[mBlock2.pb8x8.subMbTypes[c]], i20)) {
                i7 = i20;
                decodeSubMb8x8(mBlock, 3, H264Const.bSubMbTypes[mBlock2.pb8x8.subMbTypes[c]], frameArr[i20], (i << 6) + 32, (i2 << 6) + 32, mvList.getMv(5, i20), mvList.getMv(6, i20), mvList.getMv(7, i20), MBlockDecoderUtils.NULL_VECTOR, mvList.getMv(9, i20), mvList.getMv(13, i20), true, true, false, true, mvList, 10, 11, 14, 15, mBlock2.pb8x8.refIdx[i7][c], this.mbb[i7], 136, i7);
            } else {
                i7 = i20;
            }
            i15 = i7 + 1;
            mBlockDecoderInter8x8 = this;
            mBlock3 = mBlock;
            i10 = i;
            i14 = 0;
        }
        char c2 = 1;
        int i21 = 0;
        while (i21 < 4) {
            int i22 = H264Const.BLK8x8_BLOCKS[i21][0];
            PredictionMerger.mergePrediction(this.sh, mvList.mv0R(i22), mvList.mv1R(i22), H264Const.bPartPredModes[mBlock.pb8x8.subMbTypes[i21]], 0, this.mbb[0].getPlaneData(0), this.mbb[c2].getPlaneData(0), H264Const.BLK_8x8_MB_OFF_LUMA[i21], 16, 8, 8, picture.getPlaneData(0), frameArr, this.poc);
            i21++;
            c2 = c2;
        }
        MBlockDecoderUtils.savePrediction8x8(this.s, i, mvList);
    }

    private void predict8x8P(MBlock mBlock, Picture[] pictureArr, Picture picture, boolean z, int i, int i2, boolean z2, boolean z3, boolean z4, boolean z5, H264Utils.MvList mvList, H264Const.PartPred[] partPredArr) {
        int i3 = i << 6;
        int i4 = i2 << 6;
        int i5 = i << 2;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        decodeSubMb8x8(mBlock, 0, mBlock.pb8x8.subMbTypes[0], pictureArr, i3, i4, this.s.mvTopLeft.getMv(0, 0), this.s.mvTop.getMv(i5, 0), this.s.mvTop.getMv(i6, 0), this.s.mvTop.getMv(i7, 0), this.s.mvLeft.getMv(0, 0), this.s.mvLeft.getMv(1, 0), z4, z3, z3, z2, mBlock.x, 0, 1, 4, 5, mBlock.pb8x8.refIdx[0][0], picture, 0, 0);
        int i8 = i3 + 32;
        decodeSubMb8x8(mBlock, 1, mBlock.pb8x8.subMbTypes[1], pictureArr, i8, i4, this.s.mvTop.getMv(i6, 0), this.s.mvTop.getMv(i7, 0), this.s.mvTop.getMv(i5 + 3, 0), this.s.mvTop.getMv(i5 + 4, 0), mvList.getMv(1, 0), mvList.getMv(5, 0), z3, z3, z5, true, mvList, 2, 3, 6, 7, mBlock.pb8x8.refIdx[0][1], picture, 8, 0);
        int i9 = i4 + 32;
        decodeSubMb8x8(mBlock, 2, mBlock.pb8x8.subMbTypes[2], pictureArr, i3, i9, this.s.mvLeft.getMv(1, 0), mvList.getMv(4, 0), mvList.getMv(5, 0), mvList.getMv(6, 0), this.s.mvLeft.getMv(2, 0), this.s.mvLeft.getMv(3, 0), z2, true, true, z2, mvList, 8, 9, 12, 13, mBlock.pb8x8.refIdx[0][2], picture, 128, 0);
        decodeSubMb8x8(mBlock, 3, mBlock.pb8x8.subMbTypes[3], pictureArr, i8, i9, mvList.getMv(5, 0), mvList.getMv(6, 0), mvList.getMv(7, 0), MBlockDecoderUtils.NULL_VECTOR, mvList.getMv(9, 0), mvList.getMv(13, 0), true, true, false, true, mvList, 10, 11, 14, 15, mBlock.pb8x8.refIdx[0][3], picture, 136, 0);
        for (int i10 = 0; i10 < 4; i10++) {
            PredictionMerger.weightPrediction(this.sh, mvList.mv0R(H264Const.BLK8x8_BLOCKS[i10][0]), 0, picture.getPlaneData(0), H264Const.BLK_8x8_MB_OFF_LUMA[i10], 16, 8, 8, picture.getPlaneData(0));
        }
        MBlockDecoderUtils.savePrediction8x8(this.s, i, mvList);
        Arrays.fill(partPredArr, H264Const.PartPred.L0);
    }

    public void decode(MBlock mBlock, Frame[][] frameArr, Picture picture, SliceType sliceType, boolean z) {
        int i;
        int i2;
        int mbX = this.mapper.getMbX(mBlock.mbIdx);
        int mbY = this.mapper.getMbY(mBlock.mbIdx);
        boolean zLeftAvailable = this.mapper.leftAvailable(mBlock.mbIdx);
        boolean z2 = this.mapper.topAvailable(mBlock.mbIdx);
        int address = this.mapper.getAddress(mBlock.mbIdx);
        boolean z3 = this.mapper.topLeftAvailable(mBlock.mbIdx);
        boolean z4 = this.mapper.topRightAvailable(mBlock.mbIdx);
        if (sliceType == SliceType.P) {
            i = mbY;
            i2 = mbX;
            predict8x8P(mBlock, frameArr[0], picture, z, mbX, mbY, zLeftAvailable, z2, z3, z4, mBlock.x, mBlock.partPreds);
        } else {
            i = mbY;
            i2 = mbX;
            predict8x8B(mBlock, frameArr, picture, z, i2, i, zLeftAvailable, z2, z3, z4, mBlock.x, mBlock.partPreds);
        }
        int i3 = i2;
        int i4 = i3 << 3;
        int i5 = i;
        int i6 = i5 << 3;
        predictChromaInter(frameArr, mBlock.x, i4, i6, 1, picture, mBlock.partPreds);
        predictChromaInter(frameArr, mBlock.x, i4, i6, 2, picture, mBlock.partPreds);
        if (mBlock.cbpLuma() > 0 || mBlock.cbpChroma() > 0) {
            DecoderState decoderState = this.s;
            decoderState.qp = ((decoderState.qp + mBlock.mbQPDelta) + 52) % 52;
        }
        this.di.mbQps[0][address] = this.s.qp;
        residualLuma(mBlock, zLeftAvailable, z2, i3, i5);
        MBlockDecoderUtils.saveMvs(this.di, mBlock.x, i3, i5);
        DecoderState decoderState2 = this.s;
        int iCalcQpChroma = MBlockDecoderBase.calcQpChroma(decoderState2.qp, decoderState2.chromaQpOffset[0]);
        DecoderState decoderState3 = this.s;
        int iCalcQpChroma2 = MBlockDecoderBase.calcQpChroma(decoderState3.qp, decoderState3.chromaQpOffset[1]);
        decodeChromaResidual(mBlock, zLeftAvailable, z2, i3, i5, iCalcQpChroma, iCalcQpChroma2);
        int[][] iArr = this.di.mbQps;
        iArr[1][address] = iCalcQpChroma;
        iArr[2][address] = iCalcQpChroma2;
        int[][][] iArr2 = mBlock.ac;
        boolean z5 = mBlock.transform8x8Used;
        MBlockDecoderUtils.mergeResidual(picture, iArr2, z5 ? H264Const.COMP_BLOCK_8x8_LUT : H264Const.COMP_BLOCK_4x4_LUT, z5 ? H264Const.COMP_POS_8x8_LUT : H264Const.COMP_POS_4x4_LUT);
        MBlockDecoderUtils.collectPredictors(this.s, picture, i3);
        DeblockerInput deblockerInput = this.di;
        deblockerInput.mbTypes[address] = mBlock.curMbType;
        deblockerInput.tr8x8Used[address] = mBlock.transform8x8Used;
    }
}
