package org.jcodec.codecs.h264.decode;

import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.io.model.PredictionWeightTable;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class PredictionMerger {
    private static void _mergePrediction(byte[] bArr, byte[] bArr2, int i, H264Const.PartPred partPred, int i2, int i3, int i4, byte[] bArr3) {
        int i5 = 0;
        while (i5 < i4) {
            int i6 = 0;
            while (i6 < i3) {
                bArr3[i2] = (byte) (((bArr[i2] + bArr2[i2]) + 1) >> 1);
                i6++;
                i2++;
            }
            i5++;
            i2 += i - i3;
        }
    }

    private static void _weightPrediction(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, byte[] bArr3) {
        int i10 = (1 << i5) + ((i6 + i7) << 7);
        int i11 = (((i8 + i9) + 1) >> 1) - 128;
        int i12 = i5 + 1;
        int i13 = i2;
        int i14 = 0;
        while (i14 < i4) {
            int i15 = 0;
            while (i15 < i3) {
                bArr3[i13] = (byte) MathUtil.clip(((((bArr[i13] * i6) + (bArr2[i13] * i7)) + i10) >> i12) + i11, -128, 127);
                i15++;
                i13++;
            }
            i14++;
            i13 += i - i3;
        }
    }

    private static void copyPrediction(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2) {
        int i5 = 0;
        while (i5 < i4) {
            int i6 = 0;
            while (i6 < i3) {
                bArr2[i2] = bArr[i2];
                i6++;
                i2++;
            }
            i5++;
            i2 += i - i3;
        }
    }

    private static void mergeAvg(byte[] bArr, byte[] bArr2, int i, H264Const.PartPred partPred, int i2, int i3, int i4, byte[] bArr3) {
        if (partPred == H264Const.PartPred.Bi) {
            _mergePrediction(bArr, bArr2, i, partPred, i2, i3, i4, bArr3);
        } else if (partPred == H264Const.PartPred.L0) {
            copyPrediction(bArr, i, i2, i3, i4, bArr3);
        } else if (partPred == H264Const.PartPred.L1) {
            copyPrediction(bArr2, i, i2, i3, i4, bArr3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        if (r22 != org.jcodec.codecs.h264.H264Const.PartPred.Bi) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void mergePrediction(org.jcodec.codecs.h264.io.model.SliceHeader r19, int r20, int r21, org.jcodec.codecs.h264.H264Const.PartPred r22, int r23, byte[] r24, byte[] r25, int r26, int r27, int r28, int r29, byte[] r30, org.jcodec.codecs.h264.io.model.Frame[][] r31, int r32) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.h264.decode.PredictionMerger.mergePrediction(org.jcodec.codecs.h264.io.model.SliceHeader, int, int, org.jcodec.codecs.h264.H264Const$PartPred, int, byte[], byte[], int, int, int, int, byte[], org.jcodec.codecs.h264.io.model.Frame[][], int):void");
    }

    private static void mergeWeight(byte[] bArr, byte[] bArr2, int i, H264Const.PartPred partPred, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, byte[] bArr3) {
        if (partPred == H264Const.PartPred.L0) {
            weight(bArr, i, i2, i3, i4, i5, i6, i8, bArr3);
        } else if (partPred == H264Const.PartPred.L1) {
            weight(bArr2, i, i2, i3, i4, i5, i7, i9, bArr3);
        } else if (partPred == H264Const.PartPred.Bi) {
            _weightPrediction(bArr, bArr2, i, i2, i3, i4, i5, i6, i7, i8, i9, bArr3);
        }
    }

    private static void weight(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, byte[] bArr2) {
        int i8 = 1 << (i5 - 1);
        if (i5 < 1) {
            int i9 = i7 + ((i6 << 7) - 128);
            int i10 = 0;
            while (i10 < i4) {
                int i11 = 0;
                while (i11 < i3) {
                    bArr2[i2] = (byte) MathUtil.clip((bArr[i2] * i6) + i9, -128, 127);
                    i11++;
                    i2++;
                }
                i10++;
                i2 += i - i3;
            }
            return;
        }
        int i12 = i7 - 128;
        int i13 = i8 + (i6 << 7);
        int i14 = 0;
        while (i14 < i4) {
            int i15 = 0;
            while (i15 < i3) {
                bArr2[i2] = (byte) MathUtil.clip((((bArr[i2] * i6) + i13) >> i5) + i12, -128, 127);
                i15++;
                i2++;
            }
            i14++;
            i2 += i - i3;
        }
    }

    public static void weightPrediction(SliceHeader sliceHeader, int i, int i2, byte[] bArr, int i3, int i4, int i5, int i6, byte[] bArr2) {
        PredictionWeightTable predictionWeightTable;
        if (!sliceHeader.pps.weightedPredFlag || (predictionWeightTable = sliceHeader.predWeightTable) == null) {
            copyPrediction(bArr, i4, i3, i5, i6, bArr2);
        } else {
            weight(bArr, i4, i3, i5, i6, i2 == 0 ? predictionWeightTable.lumaLog2WeightDenom : predictionWeightTable.chromaLog2WeightDenom, i2 == 0 ? predictionWeightTable.lumaWeight[0][i] : predictionWeightTable.chromaWeight[0][i2 - 1][i], i2 == 0 ? predictionWeightTable.lumaOffset[0][i] : predictionWeightTable.chromaOffset[0][i2 - 1][i], bArr2);
        }
    }
}
