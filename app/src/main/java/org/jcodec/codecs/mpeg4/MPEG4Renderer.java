package org.jcodec.codecs.mpeg4;

import org.jcodec.codecs.mpeg4.Macroblock;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class MPEG4Renderer {
    public static int calcChromaMv(MPEG4DecodingContext mPEG4DecodingContext, int i) {
        if (mPEG4DecodingContext.quarterPel) {
            if (mPEG4DecodingContext.bsVersion <= 1) {
                i = (i & 1) | (i >> 1);
            } else {
                i /= 2;
            }
        }
        return (i >> 1) + MPEG4Consts.ROUNDTAB_79[i & 3];
    }

    public static int calcChromaMvAvg(MPEG4DecodingContext mPEG4DecodingContext, Macroblock.Vector[] vectorArr, boolean z) {
        int i;
        int i2;
        int i3;
        if (mPEG4DecodingContext.quarterPel) {
            if (mPEG4DecodingContext.bsVersion <= 1) {
                i3 = 0;
                for (int i4 = 0; i4 < 4; i4++) {
                    int i5 = z ? vectorArr[i4].x : vectorArr[i4].y;
                    i3 += (i5 & 1) | (i5 >> 1);
                }
                return (i3 >> 3) + MPEG4Consts.ROUNDTAB_76[i3 & 15];
            }
            if (z) {
                i = (vectorArr[0].x / 2) + (vectorArr[1].x / 2) + (vectorArr[2].x / 2);
                i2 = vectorArr[3].x / 2;
            } else {
                i = (vectorArr[0].y / 2) + (vectorArr[1].y / 2) + (vectorArr[2].y / 2);
                i2 = vectorArr[3].y / 2;
            }
        } else if (z) {
            i = vectorArr[0].x + vectorArr[1].x + vectorArr[2].x;
            i2 = vectorArr[3].x;
        } else {
            i = vectorArr[0].y + vectorArr[1].y + vectorArr[2].y;
            i2 = vectorArr[3].y;
        }
        i3 = i + i2;
        return (i3 >> 3) + MPEG4Consts.ROUNDTAB_76[i3 & 15];
    }

    private static void checkMV(Macroblock.Vector vector, int i, int i2, int i3, int i4) {
        int i5 = vector.x;
        if (i5 > i) {
            vector.x = i;
        } else if (i5 < i2) {
            vector.x = i2;
        }
        int i6 = vector.y;
        if (i6 > i3) {
            vector.y = i3;
        } else if (i6 < i4) {
            vector.y = i4;
        }
    }

    public static void renderInter(MPEG4DecodingContext mPEG4DecodingContext, Picture[] pictureArr, Macroblock macroblock, int i, int i2, boolean z) {
        if (!macroblock.coded) {
            renderMBInter(mPEG4DecodingContext, pictureArr, macroblock, i2, z);
            return;
        }
        if (macroblock.mcsel) {
            throw new RuntimeException("GMC");
        }
        int i3 = macroblock.mode;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            renderIntra(macroblock, mPEG4DecodingContext);
        } else {
            if (macroblock.fieldPred) {
                throw new RuntimeException("interlaced");
            }
            renderMBInter(mPEG4DecodingContext, pictureArr, macroblock, i2, z);
        }
    }

    public static void renderIntra(Macroblock macroblock, MPEG4DecodingContext mPEG4DecodingContext) {
        MPEG4DCT.idctPut(macroblock.pred, macroblock.block, mPEG4DecodingContext.interlacing && macroblock.fieldDCT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void renderMBInter(MPEG4DecodingContext mPEG4DecodingContext, Picture[] pictureArr, Macroblock macroblock, int i, boolean z) {
        int iCalcChromaMv;
        int iCalcChromaMv2;
        int i2;
        int i3;
        Macroblock.Vector[] vectorArr = new Macroblock.Vector[4];
        for (int i4 = 0; i4 < 4; i4++) {
            Macroblock.Vector vector = macroblock.mvs[i4];
            vectorArr[i4] = new Macroblock.Vector(vector.x, vector.y);
        }
        validateVector(vectorArr, mPEG4DecodingContext, macroblock.x, macroblock.y);
        int i5 = macroblock.x << 4;
        int i6 = macroblock.y << 4;
        int i7 = mPEG4DecodingContext.mbWidth;
        int i8 = i7 << 4;
        int i9 = mPEG4DecodingContext.mbHeight;
        int i10 = i9 << 4;
        int i11 = i7 << 3;
        int i12 = i9 << 3;
        if (macroblock.mode != 2 || z) {
            Picture picture = pictureArr[i];
            iCalcChromaMv = calcChromaMv(mPEG4DecodingContext, vectorArr[0].x);
            iCalcChromaMv2 = calcChromaMv(mPEG4DecodingContext, vectorArr[0].y);
            if (mPEG4DecodingContext.quarterPel) {
                byte[] bArr = macroblock.pred[0];
                byte[] planeData = picture.getPlaneData(0);
                Macroblock.Vector vector2 = vectorArr[0];
                i2 = 1;
                MPEG4Interpolator.interpolate16x16QP(bArr, planeData, i5, i6, i8, i10, vector2.x, vector2.y, picture.getWidth(), mPEG4DecodingContext.rounding);
            } else {
                byte[] bArr2 = macroblock.pred[0];
                byte[] planeData2 = picture.getPlaneData(0);
                Macroblock.Vector vector3 = vectorArr[0];
                i2 = 1;
                MPEG4Interpolator.interpolate16x16Planar(bArr2, planeData2, i5, i6, i8, i10, vector3.x, vector3.y, picture.getWidth(), mPEG4DecodingContext.rounding);
            }
        } else {
            int iCalcChromaMvAvg = calcChromaMvAvg(mPEG4DecodingContext, vectorArr, true);
            int iCalcChromaMvAvg2 = calcChromaMvAvg(mPEG4DecodingContext, vectorArr, false);
            Picture picture2 = pictureArr[0];
            byte[] planeData3 = picture2.getPlaneData(0);
            int width = picture2.getWidth();
            if (mPEG4DecodingContext.quarterPel) {
                byte[] bArr3 = macroblock.pred[0];
                Macroblock.Vector vector4 = vectorArr[0];
                MPEG4Interpolator.interpolate8x8QP(bArr3, 0, planeData3, i5, i6, i8, i10, vector4.x, vector4.y, width, mPEG4DecodingContext.rounding);
                byte[] bArr4 = macroblock.pred[0];
                int i13 = i5 + 8;
                Macroblock.Vector vector5 = vectorArr[1];
                MPEG4Interpolator.interpolate8x8QP(bArr4, 8, planeData3, i13, i6, i8, i10, vector5.x, vector5.y, width, mPEG4DecodingContext.rounding);
                byte[] bArr5 = macroblock.pred[0];
                int i14 = i6 + 8;
                Macroblock.Vector vector6 = vectorArr[2];
                i3 = 1;
                MPEG4Interpolator.interpolate8x8QP(bArr5, 128, planeData3, i5, i14, i8, i10, vector6.x, vector6.y, width, mPEG4DecodingContext.rounding);
                byte[] bArr6 = macroblock.pred[0];
                Macroblock.Vector vector7 = vectorArr[3];
                MPEG4Interpolator.interpolate8x8QP(bArr6, 136, planeData3, i13, i14, i8, i10, vector7.x, vector7.y, width, mPEG4DecodingContext.rounding);
            } else {
                byte[] bArr7 = macroblock.pred[0];
                Macroblock.Vector vector8 = vectorArr[0];
                MPEG4Interpolator.interpolate8x8Planar(bArr7, 0, 16, planeData3, i5, i6, i8, i10, vector8.x, vector8.y, width, mPEG4DecodingContext.rounding);
                byte[] bArr8 = macroblock.pred[0];
                int i15 = i5 + 8;
                Macroblock.Vector vector9 = vectorArr[1];
                MPEG4Interpolator.interpolate8x8Planar(bArr8, 8, 16, planeData3, i15, i6, i8, i10, vector9.x, vector9.y, width, mPEG4DecodingContext.rounding);
                byte[] bArr9 = macroblock.pred[0];
                int i16 = i6 + 8;
                Macroblock.Vector vector10 = vectorArr[2];
                i3 = 1;
                MPEG4Interpolator.interpolate8x8Planar(bArr9, 128, 16, planeData3, i5, i16, i8, i10, vector10.x, vector10.y, width, mPEG4DecodingContext.rounding);
                byte[] bArr10 = macroblock.pred[0];
                Macroblock.Vector vector11 = vectorArr[3];
                MPEG4Interpolator.interpolate8x8Planar(bArr10, 136, 16, planeData3, i15, i16, i8, i10, vector11.x, vector11.y, width, mPEG4DecodingContext.rounding);
            }
            i2 = i3;
            iCalcChromaMv = iCalcChromaMvAvg;
            iCalcChromaMv2 = iCalcChromaMvAvg2;
        }
        int i17 = iCalcChromaMv;
        int i18 = iCalcChromaMv2;
        MPEG4Interpolator.interpolate8x8Planar(macroblock.pred[i2], 0, 8, pictureArr[i].getPlaneData(i2), macroblock.x * 8, macroblock.y * 8, i11, i12, i17, i18, pictureArr[i].getPlaneWidth(i2), mPEG4DecodingContext.rounding);
        MPEG4Interpolator.interpolate8x8Planar(macroblock.pred[2], 0, 8, pictureArr[i].getPlaneData(2), macroblock.x * 8, macroblock.y * 8, i11, i12, i17, i18, pictureArr[i].getPlaneWidth(2), mPEG4DecodingContext.rounding);
        if (macroblock.cbp != 0) {
            for (int i19 = 0; i19 < 6; i19++) {
                short[] sArr = macroblock.block[i19];
                if ((macroblock.cbp & (i2 << (5 - i19))) != 0) {
                    MPEG4DCT.idctAdd(macroblock.pred, sArr, i19, (mPEG4DecodingContext.interlacing && macroblock.fieldDCT) ? i2 : 0);
                }
            }
        }
    }

    public static final int sanitize(int i, boolean z, int i2) {
        int i3 = 1 << (i2 + 4);
        int i4 = -i3;
        return i < i4 ? i4 : i >= i3 ? i3 - 1 : i;
    }

    public static void validateVector(Macroblock.Vector[] vectorArr, MPEG4DecodingContext mPEG4DecodingContext, int i, int i2) {
        int i3 = (mPEG4DecodingContext.quarterPel ? 1 : 0) + 5;
        int i4 = (mPEG4DecodingContext.mbWidth - i) << i3;
        int i5 = ((-i) - 1) << i3;
        int i6 = (mPEG4DecodingContext.mbHeight - i2) << i3;
        int i7 = ((-i2) - 1) << i3;
        checkMV(vectorArr[0], i4, i5, i6, i7);
        checkMV(vectorArr[1], i4, i5, i6, i7);
        checkMV(vectorArr[2], i4, i5, i6, i7);
        checkMV(vectorArr[3], i4, i5, i6, i7);
    }
}
