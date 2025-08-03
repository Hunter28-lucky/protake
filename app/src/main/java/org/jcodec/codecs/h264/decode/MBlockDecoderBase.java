package org.jcodec.codecs.h264.decode;

import java.util.Arrays;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class MBlockDecoderBase {
    public DeblockerInput di;
    public BlockInterpolator interpolator = new BlockInterpolator();
    public Picture[] mbb;
    public int poc;
    public DecoderState s;
    public int[][] scalingMatrix;
    public SliceHeader sh;

    public MBlockDecoderBase(SliceHeader sliceHeader, DeblockerInput deblockerInput, int i, DecoderState decoderState) {
        this.s = decoderState;
        this.sh = sliceHeader;
        this.di = deblockerInput;
        this.poc = i;
        this.mbb = new Picture[]{Picture.create(16, 16, decoderState.chromaFormat), Picture.create(16, 16, this.s.chromaFormat)};
        this.scalingMatrix = initScalingMatrix(sliceHeader);
    }

    public static int calcQpChroma(int i, int i2) {
        return H264Const.QP_SCALE_CR[MathUtil.clip(i + i2, 0, 51)];
    }

    private void chromaAC(boolean z, boolean z2, int i, int i2, int[] iArr, int i3, int i4, MBType mBType, boolean z3, int[][] iArr2) {
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int[] iArr3 = iArr2[i5];
            if (z3) {
                CoeffTransformer.dequantizeAC(iArr3, i4, getScalingList((mBType.intra ? 0 : 3) + i3));
            }
            iArr3[0] = iArr[i5];
            CoeffTransformer.idct4x4(iArr3);
        }
    }

    private void chromaDC(int i, boolean z, boolean z2, int[] iArr, int i2, int i3, MBType mBType) {
        CoeffTransformer.invDC2x2(iArr);
        CoeffTransformer.dequantizeDC2x2(iArr, i3, getScalingList((mBType.intra ? 6 : 7) + (i2 * 2)));
    }

    public static int[][] initScalingMatrix(SliceHeader sliceHeader) {
        int[][] iArr;
        int[] iArr2;
        int[] iArr3;
        PictureParameterSet.PPSExt pPSExt;
        if (sliceHeader.sps.scalingMatrix == null && ((pPSExt = sliceHeader.pps.extended) == null || pPSExt.scalingMatrix == null)) {
            return null;
        }
        int[][] iArr4 = {H264Const.defaultScalingList4x4Intra, null, null, H264Const.defaultScalingList4x4Inter, null, null, H264Const.defaultScalingList8x8Intra, H264Const.defaultScalingList8x8Inter, null, null, null, null};
        for (int i = 0; i < 8; i++) {
            int[][] iArr5 = sliceHeader.sps.scalingMatrix;
            if (iArr5 != null && (iArr3 = iArr5[i]) != null) {
                iArr4[i] = iArr3;
            }
            PictureParameterSet.PPSExt pPSExt2 = sliceHeader.pps.extended;
            if (pPSExt2 != null && (iArr = pPSExt2.scalingMatrix) != null && (iArr2 = iArr[i]) != null) {
                iArr4[i] = iArr2;
            }
        }
        if (iArr4[1] == null) {
            iArr4[1] = iArr4[0];
        }
        if (iArr4[2] == null) {
            iArr4[2] = iArr4[0];
        }
        if (iArr4[4] == null) {
            iArr4[4] = iArr4[3];
        }
        if (iArr4[5] == null) {
            iArr4[5] = iArr4[3];
        }
        if (iArr4[8] == null) {
            iArr4[8] = iArr4[6];
        }
        if (iArr4[10] == null) {
            iArr4[10] = iArr4[6];
        }
        if (iArr4[9] == null) {
            iArr4[9] = iArr4[7];
        }
        if (iArr4[11] == null) {
            iArr4[11] = iArr4[7];
        }
        return iArr4;
    }

    private void residualLuma4x4(MBlock mBlock) {
        for (int i = 0; i < 16; i++) {
            if ((mBlock.cbpLuma() & (1 << (i >> 2))) != 0) {
                CoeffTransformer.dequantizeAC(mBlock.ac[0][i], this.s.qp, getScalingList(mBlock.curMbType.intra ? 0 : 3));
                CoeffTransformer.idct4x4(mBlock.ac[0][i]);
            }
        }
    }

    private void residualLuma8x8CABAC(MBlock mBlock) {
        for (int i = 0; i < 4; i++) {
            if ((mBlock.cbpLuma() & (1 << i)) != 0) {
                CoeffTransformer.dequantizeAC8x8(mBlock.ac[0][i], this.s.qp, getScalingList(mBlock.curMbType.intra ? 6 : 7));
                CoeffTransformer.idct8x8(mBlock.ac[0][i]);
            }
        }
    }

    private void residualLuma8x8CAVLC(MBlock mBlock) {
        for (int i = 0; i < 4; i++) {
            if ((mBlock.cbpLuma() & (1 << i)) != 0) {
                CoeffTransformer.dequantizeAC8x8(mBlock.ac[0][i], this.s.qp, getScalingList(mBlock.curMbType.intra ? 6 : 7));
                CoeffTransformer.idct8x8(mBlock.ac[0][i]);
            }
        }
    }

    public void decodeChroma(MBlock mBlock, int i, int i2, boolean z, boolean z2, Picture picture, int i3) {
        DecoderState decoderState = this.s;
        if (decoderState.chromaFormat == ColorSpace.MONO) {
            Arrays.fill(picture.getPlaneData(1), (byte) 0);
            Arrays.fill(picture.getPlaneData(2), (byte) 0);
            return;
        }
        int iCalcQpChroma = calcQpChroma(i3, decoderState.chromaQpOffset[0]);
        int iCalcQpChroma2 = calcQpChroma(i3, this.s.chromaQpOffset[1]);
        if (mBlock.cbpChroma() != 0) {
            decodeChromaResidual(mBlock, z, z2, i, i2, iCalcQpChroma, iCalcQpChroma2);
        }
        int i4 = ((this.sh.sps.picWidthInMbsMinus1 + 1) * i2) + i;
        int[][] iArr = this.di.mbQps;
        iArr[1][i4] = iCalcQpChroma;
        iArr[2][i4] = iCalcQpChroma2;
        int[][] iArr2 = mBlock.ac[1];
        int i5 = mBlock.chromaPredictionMode;
        DecoderState decoderState2 = this.s;
        ChromaPredictionBuilder.predictWithMode(iArr2, i5, i, z, z2, decoderState2.leftRow[1], decoderState2.topLine[1], decoderState2.topLeft[1], picture.getPlaneData(1));
        int[][] iArr3 = mBlock.ac[2];
        int i6 = mBlock.chromaPredictionMode;
        DecoderState decoderState3 = this.s;
        ChromaPredictionBuilder.predictWithMode(iArr3, i6, i, z, z2, decoderState3.leftRow[2], decoderState3.topLine[2], decoderState3.topLeft[2], picture.getPlaneData(2));
    }

    public void decodeChromaResidual(MBlock mBlock, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        if (mBlock.cbpChroma() != 0) {
            if ((mBlock.cbpChroma() & 3) > 0) {
                chromaDC(i, z, z2, mBlock.dc1, 1, i3, mBlock.curMbType);
                chromaDC(i, z, z2, mBlock.dc2, 2, i4, mBlock.curMbType);
            }
            chromaAC(z, z2, i, i2, mBlock.dc1, 1, i3, mBlock.curMbType, (mBlock.cbpChroma() & 2) > 0, mBlock.ac[1]);
            chromaAC(z, z2, i, i2, mBlock.dc2, 2, i4, mBlock.curMbType, (mBlock.cbpChroma() & 2) > 0, mBlock.ac[2]);
        }
    }

    public int[] getScalingList(int i) {
        int[][] iArr = this.scalingMatrix;
        if (iArr == null) {
            return null;
        }
        return iArr[i];
    }

    public void predictChromaInter(Frame[][] frameArr, H264Utils.MvList mvList, int i, int i2, int i3, Picture picture, H264Const.PartPred[] partPredArr) {
        int i4 = i3;
        Picture picture2 = picture;
        int i5 = 0;
        while (i5 < 4) {
            for (int i6 = 0; i6 < 2; i6++) {
                if (H264Const.usesList(partPredArr[i5], i6)) {
                    for (int i7 = 0; i7 < 4; i7++) {
                        int i8 = H264Const.BLK_INV_MAP[(i5 << 2) + i7];
                        int mv = mvList.getMv(i8, i6);
                        Frame frame = frameArr[i6][H264Utils.Mv.mvRef(mv)];
                        int i9 = (i8 & 3) << 1;
                        int i10 = (i8 >> 2) << 1;
                        BlockInterpolator.getBlockChroma(frame.getPlaneData(i4), frame.getPlaneWidth(i4), frame.getPlaneHeight(i4), this.mbb[i6].getPlaneData(i4), (i10 * picture2.getPlaneWidth(i4)) + i9, picture2.getPlaneWidth(i4), ((i + i9) << 3) + H264Utils.Mv.mvX(mv), ((i2 + i10) << 3) + H264Utils.Mv.mvY(mv), 2, 2);
                    }
                }
            }
            int i11 = H264Const.BLK8x8_BLOCKS[i5][0];
            PredictionMerger.mergePrediction(this.sh, mvList.mv0R(i11), mvList.mv1R(i11), partPredArr[i5], i3, this.mbb[0].getPlaneData(i4), this.mbb[1].getPlaneData(i4), H264Const.BLK_8x8_MB_OFF_CHROMA[i5], picture2.getPlaneWidth(i4), 4, 4, picture2.getPlaneData(i4), frameArr, this.poc);
            i5++;
            i4 = i3;
            picture2 = picture;
        }
    }

    public void residualLuma(MBlock mBlock, boolean z, boolean z2, int i, int i2) {
        if (!mBlock.transform8x8Used) {
            residualLuma4x4(mBlock);
        } else if (this.sh.pps.entropyCodingModeFlag) {
            residualLuma8x8CABAC(mBlock);
        } else {
            residualLuma8x8CAVLC(mBlock);
        }
    }
}
