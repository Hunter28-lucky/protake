package org.jcodec.codecs.h264.decode;

import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.common.ArrayUtil;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class MBlockDecoderUtils {
    public static final int NULL_VECTOR = H264Utils.Mv.packMv(0, 0, -1);
    private static boolean debug;

    public static int calcMVPredictionMedian(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6) {
        if (!z3) {
            i3 = i4;
            z3 = z4;
        }
        if (z && !z2 && !z3) {
            i2 = i;
            i3 = i2;
            z2 = z;
            z3 = z2;
        }
        if (!z) {
            i = NULL_VECTOR;
        }
        if (!z2) {
            i2 = NULL_VECTOR;
        }
        if (!z3) {
            i3 = NULL_VECTOR;
        }
        return (H264Utils.Mv.mvRef(i) != i5 || H264Utils.Mv.mvRef(i2) == i5 || H264Utils.Mv.mvRef(i3) == i5) ? (H264Utils.Mv.mvRef(i2) != i5 || H264Utils.Mv.mvRef(i) == i5 || H264Utils.Mv.mvRef(i3) == i5) ? (H264Utils.Mv.mvRef(i3) != i5 || H264Utils.Mv.mvRef(i) == i5 || H264Utils.Mv.mvRef(i2) == i5) ? (((H264Utils.Mv.mvC(i, i6) + H264Utils.Mv.mvC(i2, i6)) + H264Utils.Mv.mvC(i3, i6)) - min(H264Utils.Mv.mvC(i, i6), H264Utils.Mv.mvC(i2, i6), H264Utils.Mv.mvC(i3, i6))) - max(H264Utils.Mv.mvC(i, i6), H264Utils.Mv.mvC(i2, i6), H264Utils.Mv.mvC(i3, i6)) : H264Utils.Mv.mvC(i3, i6) : H264Utils.Mv.mvC(i2, i6) : H264Utils.Mv.mvC(i, i6);
    }

    public static void collectChromaPredictors(DecoderState decoderState, Picture picture, int i) {
        byte[][] bArr = decoderState.topLeft;
        byte[] bArr2 = bArr[1];
        byte[][] bArr3 = decoderState.topLine;
        int i2 = i << 3;
        int i3 = i2 + 7;
        bArr2[0] = bArr3[1][i3];
        bArr[2][0] = bArr3[2][i3];
        System.arraycopy(picture.getPlaneData(1), 56, decoderState.topLine[1], i2, 8);
        System.arraycopy(picture.getPlaneData(2), 56, decoderState.topLine[2], i2, 8);
        copyCol(picture.getPlaneData(1), 8, 7, 8, decoderState.leftRow[1]);
        copyCol(picture.getPlaneData(2), 8, 7, 8, decoderState.leftRow[2]);
    }

    public static void collectPredictors(DecoderState decoderState, Picture picture, int i) {
        byte[] bArr = decoderState.topLeft[0];
        int i2 = i << 4;
        bArr[0] = decoderState.topLine[0][i2 + 15];
        bArr[1] = picture.getPlaneData(0)[63];
        decoderState.topLeft[0][2] = picture.getPlaneData(0)[127];
        decoderState.topLeft[0][3] = picture.getPlaneData(0)[191];
        System.arraycopy(picture.getPlaneData(0), 240, decoderState.topLine[0], i2, 16);
        copyCol(picture.getPlaneData(0), 16, 15, 16, decoderState.leftRow[0]);
        collectChromaPredictors(decoderState, picture, i);
    }

    private static void copyCol(byte[] bArr, int i, int i2, int i3, byte[] bArr2) {
        int i4 = 0;
        while (i4 < i) {
            bArr2[i4] = bArr[i2];
            i4++;
            i2 += i3;
        }
    }

    public static void debugPrint(Object... objArr) {
        if (!debug || objArr.length <= 0) {
            return;
        }
        if (objArr.length != 1) {
            String str = (String) objArr[0];
            ArrayUtil.shiftLeft1(objArr);
            Logger.debug(String.format(str, objArr));
        } else {
            Logger.debug("" + objArr[0]);
        }
    }

    public static int max(int i, int i2, int i3) {
        if (i > i2) {
            if (i > i3) {
                return i;
            }
        } else if (i2 > i3) {
            return i2;
        }
        return i3;
    }

    public static void mergeResidual(Picture picture, int[][][] iArr, int[][] iArr2, int[][] iArr3) {
        for (int i = 0; i < 3; i++) {
            byte[] planeData = picture.getPlaneData(i);
            for (int i2 = 0; i2 < planeData.length; i2++) {
                planeData[i2] = (byte) MathUtil.clip(planeData[i2] + iArr[i][iArr2[i][i2]][iArr3[i][i2]], -128, 127);
            }
        }
    }

    public static int min(int i, int i2, int i3) {
        if (i < i2) {
            if (i < i3) {
                return i;
            }
        } else if (i2 < i3) {
            return i2;
        }
        return i3;
    }

    public static void saveMvs(DeblockerInput deblockerInput, H264Utils.MvList mvList, int i, int i2) {
        int i3 = i2 << 2;
        int i4 = 0;
        int i5 = 0;
        while (i4 < 4) {
            int i6 = i << 2;
            int i7 = 0;
            while (i7 < 4) {
                deblockerInput.mvs.setMv(i6, i3, 0, mvList.getMv(i5, 0));
                deblockerInput.mvs.setMv(i6, i3, 1, mvList.getMv(i5, 1));
                i7++;
                i6++;
                i5++;
            }
            i4++;
            i3++;
        }
    }

    public static void saveMvsIntra(DeblockerInput deblockerInput, int i, int i2) {
        int i3 = i2 << 2;
        int i4 = 0;
        while (i4 < 4) {
            int i5 = i << 2;
            int i6 = 0;
            while (i6 < 4) {
                H264Utils.MvList2D mvList2D = deblockerInput.mvs;
                int i7 = NULL_VECTOR;
                mvList2D.setMv(i5, i3, 0, i7);
                deblockerInput.mvs.setMv(i5, i3, 1, i7);
                i6++;
                i5++;
            }
            i4++;
            i3++;
        }
    }

    public static void savePrediction8x8(DecoderState decoderState, int i, H264Utils.MvList mvList) {
        int i2 = i << 2;
        int i3 = i2 + 3;
        decoderState.mvTopLeft.copyPair(0, decoderState.mvTop, i3);
        decoderState.mvLeft.copyPair(0, mvList, 3);
        decoderState.mvLeft.copyPair(1, mvList, 7);
        decoderState.mvLeft.copyPair(2, mvList, 11);
        decoderState.mvLeft.copyPair(3, mvList, 15);
        decoderState.mvTop.copyPair(i2, mvList, 12);
        decoderState.mvTop.copyPair(i2 + 1, mvList, 13);
        decoderState.mvTop.copyPair(i2 + 2, mvList, 14);
        decoderState.mvTop.copyPair(i3, mvList, 15);
    }

    public static void saveVect(H264Utils.MvList mvList, int i, int i2, int i3, int i4) {
        while (i2 < i3) {
            mvList.setMv(i2, i, i4);
            i2++;
        }
    }

    public static void saveVectIntra(DecoderState decoderState, int i) {
        int i2 = i << 2;
        decoderState.mvTopLeft.copyPair(0, decoderState.mvTop, i2 + 3);
        H264Utils.MvList mvList = decoderState.mvTop;
        int i3 = i2 + 4;
        int i4 = NULL_VECTOR;
        saveVect(mvList, 0, i2, i3, i4);
        saveVect(decoderState.mvLeft, 0, 0, 4, i4);
        saveVect(decoderState.mvTop, 1, i2, i3, i4);
        saveVect(decoderState.mvLeft, 1, 0, 4, i4);
    }
}
