package org.jcodec.codecs.h264.decode;

import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.decode.aso.Mapper;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class MBlockDecoderBDirect extends MBlockDecoderBase {
    private Mapper mapper;

    public MBlockDecoderBDirect(Mapper mapper, SliceHeader sliceHeader, DeblockerInput deblockerInput, int i, DecoderState decoderState) {
        super(sliceHeader, deblockerInput, i, decoderState);
        this.mapper = mapper;
    }

    private int calcRef(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5) {
        int iMvRef = -1;
        int iMinPos = minPos(z ? H264Utils.Mv.mvRef(i) : -1, z2 ? H264Utils.Mv.mvRef(i2) : -1);
        if (z4) {
            iMvRef = H264Utils.Mv.mvRef(i3);
        } else if (z3) {
            iMvRef = H264Utils.Mv.mvRef(i4);
        }
        return minPos(iMinPos, iMvRef);
    }

    private int findPic(Frame[] frameArr, Frame frame) {
        for (int i = 0; i < frameArr.length; i++) {
            if (frameArr[i] == frame) {
                return i;
            }
        }
        Logger.error("RefPicList0 shall contain refPicCol");
        return 0;
    }

    private int minPos(int i, int i2) {
        return (i < 0 || i2 < 0) ? Math.max(i, i2) : Math.min(i, i2);
    }

    private void pred4x4(int i, int i2, H264Utils.MvList mvList, H264Const.PartPred[] partPredArr, int i3, int i4, int i5, int i6, int i7, int i8, Frame frame, H264Const.PartPred partPred, int i9) {
        int i10 = (i << 2) + (i9 & 3);
        int i11 = (i2 << 2) + (i9 >> 2);
        int mv = frame.getMvs().getMv(i10, i11, 0);
        if (H264Utils.Mv.mvRef(mv) == -1) {
            mv = frame.getMvs().getMv(i10, i11, 1);
        }
        boolean z = frame.isShortTerm() && H264Utils.Mv.mvRef(mv) == 0 && (MathUtil.abs(H264Utils.Mv.mvX(mv)) >> 1) == 0 && (MathUtil.abs(H264Utils.Mv.mvY(mv)) >> 1) == 0;
        int iPackMv = H264Utils.Mv.packMv(0, 0, i3);
        int iPackMv2 = H264Utils.Mv.packMv(0, 0, i4);
        if (i3 > 0 || !z) {
            iPackMv = H264Utils.Mv.packMv(i5, i6, i3);
        }
        if (i4 > 0 || !z) {
            iPackMv2 = H264Utils.Mv.packMv(i7, i8, i4);
        }
        mvList.setPair(i9, iPackMv, iPackMv2);
        partPredArr[H264Const.BLK_8x8_IND[i9]] = partPred;
    }

    private void predTemp4x4(Frame[][] frameArr, int i, int i2, H264Utils.MvList mvList, int i3) {
        Frame frame;
        int iFindPic;
        int i4;
        Frame frame2;
        int i5 = this.sh.sps.picWidthInMbsMinus1 + 1;
        Frame frame3 = frameArr[1][0];
        int i6 = (i << 2) + (i3 & 3);
        int i7 = (i2 << 2) + (i3 >> 2);
        int mv = frame3.getMvs().getMv(i6, i7, 0);
        if (H264Utils.Mv.mvRef(mv) == -1) {
            mv = frame3.getMvs().getMv(i6, i7, 1);
            if (H264Utils.Mv.mvRef(mv) == -1) {
                frame2 = frameArr[0][0];
                i4 = 0;
                int iClip = MathUtil.clip(frame3.getPOC() - frame2.getPOC(), -128, 127);
                if (frame2.isShortTerm() || iClip == 0) {
                    mvList.setPair(i3, H264Utils.Mv.packMv(H264Utils.Mv.mvX(mv), H264Utils.Mv.mvY(mv), i4), 0);
                } else {
                    int iClip2 = MathUtil.clip(((MathUtil.clip(this.poc - frame2.getPOC(), -128, 127) * ((Math.abs(iClip / 2) + 16384) / iClip)) + 32) >> 6, -1024, 1023);
                    mvList.setPair(i3, H264Utils.Mv.packMv(((H264Utils.Mv.mvX(mv) * iClip2) + 128) >> 8, ((iClip2 * H264Utils.Mv.mvY(mv)) + 128) >> 8, i4), H264Utils.Mv.packMv(mvList.mv0X(i3) - H264Utils.Mv.mvX(mv), mvList.mv0Y(i3) - H264Utils.Mv.mvY(mv), 0));
                    return;
                }
            }
            frame = frame3.getRefsUsed()[(i2 * i5) + i][1][H264Utils.Mv.mvRef(mv)];
            iFindPic = findPic(frameArr[0], frame);
        } else {
            frame = frame3.getRefsUsed()[(i2 * i5) + i][0][H264Utils.Mv.mvRef(mv)];
            iFindPic = findPic(frameArr[0], frame);
        }
        Frame frame4 = frame;
        i4 = iFindPic;
        frame2 = frame4;
        int iClip3 = MathUtil.clip(frame3.getPOC() - frame2.getPOC(), -128, 127);
        if (frame2.isShortTerm()) {
        }
        mvList.setPair(i3, H264Utils.Mv.packMv(H264Utils.Mv.mvX(mv), H264Utils.Mv.mvY(mv), i4), 0);
    }

    private void predictBSpatialDirect(Frame[][] frameArr, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, H264Utils.MvList mvList, H264Const.PartPred[] partPredArr, Picture picture, int[] iArr) {
        int i3;
        boolean z5;
        int i4;
        int i5;
        int i6;
        MBlockDecoderBDirect mBlockDecoderBDirect = this;
        Picture picture2 = picture;
        int[] iArr2 = iArr;
        int i7 = 0;
        int mv = mBlockDecoderBDirect.s.mvLeft.getMv(0, 0);
        char c = 1;
        int mv2 = mBlockDecoderBDirect.s.mvLeft.getMv(0, 1);
        int i8 = i << 2;
        int mv3 = mBlockDecoderBDirect.s.mvTop.getMv(i8, 0);
        int mv4 = mBlockDecoderBDirect.s.mvTop.getMv(i8, 1);
        int i9 = i8 + 4;
        int mv5 = mBlockDecoderBDirect.s.mvTop.getMv(i9, 0);
        int mv6 = mBlockDecoderBDirect.s.mvTop.getMv(i9, 1);
        int mv7 = mBlockDecoderBDirect.s.mvTopLeft.getMv(0, 0);
        int mv8 = mBlockDecoderBDirect.s.mvTopLeft.getMv(0, 1);
        int iCalcRef = calcRef(mv, mv3, mv5, mv7, z, z2, z3, z4, i);
        int iCalcRef2 = calcRef(mv2, mv4, mv6, mv8, z, z2, z3, z4, i);
        if (iCalcRef < 0 && iCalcRef2 < 0) {
            int i10 = 0;
            while (i10 < iArr2.length) {
                int i11 = iArr2[i10];
                int[] iArr3 = H264Const.BLK8x8_BLOCKS[i11];
                for (int i12 = i7; i12 < iArr3.length; i12++) {
                    mvList.setPair(iArr3[i12], i7, i7);
                }
                H264Const.PartPred partPred = H264Const.PartPred.Bi;
                partPredArr[i11] = partPred;
                BlockInterpolator blockInterpolator = mBlockDecoderBDirect.interpolator;
                Frame frame = frameArr[i7][i7];
                Picture picture3 = mBlockDecoderBDirect.mbb[i7];
                int[] iArr4 = H264Const.BLK_8x8_MB_OFF_LUMA;
                int i13 = (i << 6) + ((i11 & 1) << 5);
                int i14 = (i2 << 6) + ((i11 >> 1) << 5);
                blockInterpolator.getBlockLuma(frame, picture3, iArr4[i11], i13, i14, 8, 8);
                mBlockDecoderBDirect.interpolator.getBlockLuma(frameArr[c][i7], mBlockDecoderBDirect.mbb[c], iArr4[i11], i13, i14, 8, 8);
                char c2 = c;
                PredictionMerger.mergePrediction(mBlockDecoderBDirect.sh, 0, 0, partPred, 0, mBlockDecoderBDirect.mbb[i7].getPlaneData(i7), mBlockDecoderBDirect.mbb[c].getPlaneData(i7), iArr4[i11], 16, 8, 8, picture2.getPlaneData(i7), frameArr, mBlockDecoderBDirect.poc);
                Object[] objArr = new Object[3];
                objArr[0] = "DIRECT_8x8 [%d, %d]: (0,0,0), (0,0,0)";
                objArr[c2] = Integer.valueOf(i11 & 2);
                objArr[2] = Integer.valueOf((i11 << 1) & 2);
                MBlockDecoderUtils.debugPrint(objArr);
                i10++;
                i7 = 0;
                c = c2;
                picture2 = picture;
                iArr2 = iArr;
            }
            return;
        }
        boolean z6 = 3;
        int i15 = 0;
        int iCalcMVPredictionMedian = MBlockDecoderUtils.calcMVPredictionMedian(mv, mv3, mv5, mv7, z, z2, z4, z3, iCalcRef, 0);
        int iCalcMVPredictionMedian2 = MBlockDecoderUtils.calcMVPredictionMedian(mv, mv3, mv5, mv7, z, z2, z4, z3, iCalcRef, 1);
        int iCalcMVPredictionMedian3 = MBlockDecoderUtils.calcMVPredictionMedian(mv2, mv4, mv6, mv8, z, z2, z4, z3, iCalcRef2, 0);
        int iCalcMVPredictionMedian4 = MBlockDecoderUtils.calcMVPredictionMedian(mv2, mv4, mv6, mv8, z, z2, z4, z3, iCalcRef2, 1);
        Frame frame2 = frameArr[1][0];
        H264Const.PartPred partPred2 = (iCalcRef < 0 || iCalcRef2 < 0) ? iCalcRef >= 0 ? H264Const.PartPred.L0 : H264Const.PartPred.L1 : H264Const.PartPred.Bi;
        int[] iArr5 = iArr;
        int i16 = 0;
        while (i16 < iArr5.length) {
            int i17 = iArr5[i16];
            int[] iArr6 = H264Const.BLK8x8_BLOCKS[i17];
            int i18 = iArr6[i15];
            int i19 = 8;
            if (mBlockDecoderBDirect.sh.sps.direct8x8InferenceFlag) {
                i3 = i16;
                z5 = z6;
                int i20 = iCalcRef2;
                int i21 = H264Const.BLK_INV_MAP[i17 * 5];
                i4 = i20;
                pred4x4(i, i2, mvList, partPredArr, iCalcRef, i20, iCalcMVPredictionMedian, iCalcMVPredictionMedian2, iCalcMVPredictionMedian3, iCalcMVPredictionMedian4, frame2, partPred2, i21);
                mBlockDecoderBDirect.propagatePred(mvList, i17, i21);
                i5 = i18;
                int i22 = i5 & 3;
                int i23 = i5 >> 2;
                Object[] objArr2 = new Object[9];
                i6 = 0;
                objArr2[0] = "DIRECT_8x8 [%d, %d]: (%d,%d,%d), (%d,%d,%d)";
                objArr2[1] = Integer.valueOf(i23);
                objArr2[2] = Integer.valueOf(i22);
                objArr2[z5 ? 1 : 0] = Integer.valueOf(mvList.mv0X(i5));
                objArr2[4] = Integer.valueOf(mvList.mv0Y(i5));
                objArr2[5] = Integer.valueOf(iCalcRef);
                objArr2[6] = Integer.valueOf(mvList.mv1X(i5));
                objArr2[7] = Integer.valueOf(mvList.mv1Y(i5));
                objArr2[8] = Integer.valueOf(i4);
                MBlockDecoderUtils.debugPrint(objArr2);
                int i24 = (i << 6) + (i22 << 4);
                int i25 = (i2 << 6) + (i23 << 4);
                if (iCalcRef >= 0) {
                    mBlockDecoderBDirect.interpolator.getBlockLuma(frameArr[0][iCalcRef], mBlockDecoderBDirect.mbb[0], H264Const.BLK_4x4_MB_OFF_LUMA[i5], i24 + mvList.mv0X(i5), i25 + mvList.mv0Y(i5), 8, 8);
                }
                if (i4 >= 0) {
                    mBlockDecoderBDirect.interpolator.getBlockLuma(frameArr[1][i4], mBlockDecoderBDirect.mbb[1], H264Const.BLK_4x4_MB_OFF_LUMA[i5], i24 + mvList.mv1X(i5), i25 + mvList.mv1Y(i5), 8, 8);
                }
            } else {
                int i26 = i15;
                boolean z7 = z6;
                while (i26 < iArr6.length) {
                    int i27 = iArr6[i26];
                    int i28 = iCalcRef2;
                    int i29 = i19;
                    int i30 = i18;
                    int[] iArr7 = iArr6;
                    int i31 = i26;
                    int i32 = i16;
                    boolean z8 = z7;
                    pred4x4(i, i2, mvList, partPredArr, iCalcRef, i28, iCalcMVPredictionMedian, iCalcMVPredictionMedian2, iCalcMVPredictionMedian3, iCalcMVPredictionMedian4, frame2, partPred2, i27);
                    int i33 = i27 & 3;
                    int i34 = i27 >> 2;
                    Object[] objArr3 = new Object[i29];
                    i15 = 0;
                    objArr3[0] = "DIRECT_4x4 [%d, %d]: (%d,%d,%d), (%d,%d," + i28 + ")";
                    objArr3[1] = Integer.valueOf(i34);
                    objArr3[2] = Integer.valueOf(i33);
                    objArr3[z8 ? 1 : 0] = Integer.valueOf(mvList.mv0X(i27));
                    objArr3[4] = Integer.valueOf(mvList.mv0Y(i27));
                    objArr3[5] = Integer.valueOf(iCalcRef);
                    objArr3[6] = Integer.valueOf(mvList.mv1X(i27));
                    objArr3[7] = Integer.valueOf(mvList.mv1Y(i27));
                    MBlockDecoderUtils.debugPrint(objArr3);
                    int i35 = (i << 6) + (i33 << 4);
                    int i36 = (i2 << 6) + (i34 << 4);
                    mBlockDecoderBDirect = this;
                    if (iCalcRef >= 0) {
                        mBlockDecoderBDirect.interpolator.getBlockLuma(frameArr[0][iCalcRef], mBlockDecoderBDirect.mbb[0], H264Const.BLK_4x4_MB_OFF_LUMA[i27], i35 + mvList.mv0X(i27), i36 + mvList.mv0Y(i27), 4, 4);
                    }
                    if (i28 >= 0) {
                        mBlockDecoderBDirect.interpolator.getBlockLuma(frameArr[1][i28], mBlockDecoderBDirect.mbb[1], H264Const.BLK_4x4_MB_OFF_LUMA[i27], i35 + mvList.mv1X(i27), i36 + mvList.mv1Y(i27), 4, 4);
                    }
                    i26 = i31 + 1;
                    iCalcRef2 = i28;
                    iArr6 = iArr7;
                    i16 = i32;
                    z7 = z8 ? 1 : 0;
                    i19 = i29;
                    i18 = i30;
                }
                i3 = i16;
                z5 = z7;
                i4 = iCalcRef2;
                i5 = i18;
                i6 = i15;
            }
            PredictionMerger.mergePrediction(mBlockDecoderBDirect.sh, mvList.mv0R(i5), mvList.mv1R(i5), iCalcRef >= 0 ? i4 >= 0 ? H264Const.PartPred.Bi : H264Const.PartPred.L0 : H264Const.PartPred.L1, 0, mBlockDecoderBDirect.mbb[i6].getPlaneData(i6), mBlockDecoderBDirect.mbb[1].getPlaneData(i6), H264Const.BLK_4x4_MB_OFF_LUMA[i5], 16, 8, 8, picture.getPlaneData(i6), frameArr, mBlockDecoderBDirect.poc);
            i16 = i3 + 1;
            iArr5 = iArr;
            i15 = i6;
            iCalcRef2 = i4;
            z6 = z5;
        }
    }

    private void predictBTemporalDirect(Frame[][] frameArr, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, H264Utils.MvList mvList, H264Const.PartPred[] partPredArr, Picture picture, int[] iArr) {
        H264Utils.MvList mvList2 = mvList;
        int[] iArr2 = iArr;
        int i3 = 0;
        int i4 = 0;
        while (i4 < iArr2.length) {
            int i5 = iArr2[i4];
            int[][] iArr3 = H264Const.BLK8x8_BLOCKS;
            int i6 = iArr3[i5][i3];
            partPredArr[i5] = H264Const.PartPred.Bi;
            if (this.sh.sps.direct8x8InferenceFlag) {
                int i7 = H264Const.BLK_INV_MAP[i5 * 5];
                predTemp4x4(frameArr, i, i2, mvList, i7);
                propagatePred(mvList2, i5, i7);
                int i8 = i6 & 3;
                int i9 = i6 >> 2;
                Object[] objArr = new Object[9];
                objArr[i3] = "DIRECT_8x8 [%d, %d]: (%d,%d,%d), (%d,%d)";
                objArr[1] = Integer.valueOf(i9);
                objArr[2] = Integer.valueOf(i8);
                objArr[3] = Integer.valueOf(mvList2.mv0X(i6));
                objArr[4] = Integer.valueOf(mvList2.mv0Y(i6));
                objArr[5] = Integer.valueOf(mvList2.mv0R(i6));
                objArr[6] = Integer.valueOf(mvList2.mv1X(i6));
                objArr[7] = Integer.valueOf(mvList2.mv1Y(i6));
                objArr[8] = Integer.valueOf(mvList2.mv1R(i6));
                MBlockDecoderUtils.debugPrint(objArr);
                int i10 = (i << 6) + (i8 << 4);
                int i11 = (i2 << 6) + (i9 << 4);
                BlockInterpolator blockInterpolator = this.interpolator;
                Frame frame = frameArr[i3][mvList2.mv0R(i6)];
                Picture picture2 = this.mbb[i3];
                int[] iArr4 = H264Const.BLK_4x4_MB_OFF_LUMA;
                blockInterpolator.getBlockLuma(frame, picture2, iArr4[i6], i10 + mvList2.mv0X(i6), i11 + mvList2.mv0Y(i6), 8, 8);
                this.interpolator.getBlockLuma(frameArr[1][i3], this.mbb[1], iArr4[i6], i10 + mvList2.mv1X(i6), i11 + mvList2.mv1Y(i6), 8, 8);
            } else {
                int[] iArr5 = iArr3[i5];
                for (int i12 = i3; i12 < iArr5.length; i12++) {
                    int i13 = iArr5[i12];
                    predTemp4x4(frameArr, i, i2, mvList, i13);
                    int i14 = i13 & 3;
                    int i15 = i13 >> 2;
                    Object[] objArr2 = new Object[9];
                    objArr2[i3] = "DIRECT_4x4 [%d, %d]: (%d,%d,%d), (%d,%d,%d)";
                    objArr2[1] = Integer.valueOf(i15);
                    objArr2[2] = Integer.valueOf(i14);
                    objArr2[3] = Integer.valueOf(mvList2.mv0X(i13));
                    objArr2[4] = Integer.valueOf(mvList2.mv0Y(i13));
                    objArr2[5] = Integer.valueOf(mvList2.mv0R(i13));
                    objArr2[6] = Integer.valueOf(mvList2.mv1X(i13));
                    objArr2[7] = Integer.valueOf(mvList2.mv1Y(i13));
                    objArr2[8] = Integer.valueOf(mvList2.mv1R(i13));
                    MBlockDecoderUtils.debugPrint(objArr2);
                    int i16 = (i << 6) + (i14 << 4);
                    int i17 = (i2 << 6) + (i15 << 4);
                    BlockInterpolator blockInterpolator2 = this.interpolator;
                    Frame frame2 = frameArr[i3][mvList2.mv0R(i13)];
                    Picture picture3 = this.mbb[i3];
                    int[] iArr6 = H264Const.BLK_4x4_MB_OFF_LUMA;
                    blockInterpolator2.getBlockLuma(frame2, picture3, iArr6[i13], i16 + mvList2.mv0X(i13), i17 + mvList2.mv0Y(i13), 4, 4);
                    this.interpolator.getBlockLuma(frameArr[1][i3], this.mbb[1], iArr6[i13], i16 + mvList2.mv1X(i13), i17 + mvList2.mv1Y(i13), 4, 4);
                }
            }
            PredictionMerger.mergePrediction(this.sh, mvList2.mv0R(i6), mvList2.mv1R(i6), H264Const.PartPred.Bi, 0, this.mbb[i3].getPlaneData(i3), this.mbb[1].getPlaneData(i3), H264Const.BLK_4x4_MB_OFF_LUMA[i6], 16, 8, 8, picture.getPlaneData(i3), frameArr, this.poc);
            i4++;
            mvList2 = mvList;
            iArr2 = iArr;
            i3 = i3;
        }
    }

    private void propagatePred(H264Utils.MvList mvList, int i, int i2) {
        int[] iArr = H264Const.BLK8x8_BLOCKS[i];
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        mvList.copyPair(i3, mvList, i2);
        mvList.copyPair(i4, mvList, i2);
        mvList.copyPair(i5, mvList, i2);
        mvList.copyPair(i6, mvList, i2);
    }

    public void decode(MBlock mBlock, Picture picture, Frame[][] frameArr) {
        int mbX = this.mapper.getMbX(mBlock.mbIdx);
        int mbY = this.mapper.getMbY(mBlock.mbIdx);
        boolean zLeftAvailable = this.mapper.leftAvailable(mBlock.mbIdx);
        boolean z = this.mapper.topAvailable(mBlock.mbIdx);
        int address = this.mapper.getAddress(mBlock.mbIdx);
        predictBDirect(frameArr, mbX, mbY, zLeftAvailable, z, this.mapper.topLeftAvailable(mBlock.mbIdx), this.mapper.topRightAvailable(mBlock.mbIdx), mBlock.x, mBlock.partPreds, picture, H264Const.identityMapping4);
        int i = mbX << 3;
        int i2 = mbY << 3;
        predictChromaInter(frameArr, mBlock.x, i, i2, 1, picture, mBlock.partPreds);
        predictChromaInter(frameArr, mBlock.x, i, i2, 2, picture, mBlock.partPreds);
        if (mBlock.cbpLuma() > 0 || mBlock.cbpChroma() > 0) {
            DecoderState decoderState = this.s;
            decoderState.qp = ((decoderState.qp + mBlock.mbQPDelta) + 52) % 52;
        }
        this.di.mbQps[0][address] = this.s.qp;
        residualLuma(mBlock, zLeftAvailable, z, mbX, mbY);
        MBlockDecoderUtils.savePrediction8x8(this.s, mbX, mBlock.x);
        MBlockDecoderUtils.saveMvs(this.di, mBlock.x, mbX, mbY);
        DecoderState decoderState2 = this.s;
        int iCalcQpChroma = MBlockDecoderBase.calcQpChroma(decoderState2.qp, decoderState2.chromaQpOffset[0]);
        DecoderState decoderState3 = this.s;
        int iCalcQpChroma2 = MBlockDecoderBase.calcQpChroma(decoderState3.qp, decoderState3.chromaQpOffset[1]);
        decodeChromaResidual(mBlock, zLeftAvailable, z, mbX, mbY, iCalcQpChroma, iCalcQpChroma2);
        int[][] iArr = this.di.mbQps;
        iArr[1][address] = iCalcQpChroma;
        iArr[2][address] = iCalcQpChroma2;
        int[][][] iArr2 = mBlock.ac;
        boolean z2 = mBlock.transform8x8Used;
        MBlockDecoderUtils.mergeResidual(picture, iArr2, z2 ? H264Const.COMP_BLOCK_8x8_LUT : H264Const.COMP_BLOCK_4x4_LUT, z2 ? H264Const.COMP_POS_8x8_LUT : H264Const.COMP_POS_4x4_LUT);
        MBlockDecoderUtils.collectPredictors(this.s, picture, mbX);
        DeblockerInput deblockerInput = this.di;
        deblockerInput.mbTypes[address] = mBlock.curMbType;
        deblockerInput.tr8x8Used[address] = mBlock.transform8x8Used;
    }

    public void predictBDirect(Frame[][] frameArr, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, H264Utils.MvList mvList, H264Const.PartPred[] partPredArr, Picture picture, int[] iArr) {
        if (this.sh.directSpatialMvPredFlag) {
            predictBSpatialDirect(frameArr, i, i2, z, z2, z3, z4, mvList, partPredArr, picture, iArr);
        } else {
            predictBTemporalDirect(frameArr, i, i2, z, z2, z3, z4, mvList, partPredArr, picture, iArr);
        }
    }
}
