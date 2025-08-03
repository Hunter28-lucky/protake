package org.jcodec.codecs.mpeg4;

import org.jcodec.codecs.mpeg4.Macroblock;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class MPEG4BiRenderer {
    private static void mergePred(Macroblock macroblock) {
        for (int i = 0; i < 256; i++) {
            byte[][] bArr = macroblock.pred;
            byte[] bArr2 = bArr[0];
            bArr2[i] = (byte) (((bArr2[i] + bArr[3][i]) + 1) >> 1);
        }
        for (int i2 = 1; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 64; i3++) {
                byte[][] bArr3 = macroblock.pred;
                byte[] bArr4 = bArr3[i2];
                bArr4[i3] = (byte) (((bArr4[i3] + bArr3[i2 + 3][i3]) + 1) >> 1);
            }
        }
    }

    public static void renderBi(MPEG4DecodingContext mPEG4DecodingContext, Picture[] pictureArr, int i, int i2, Macroblock macroblock) {
        int i3 = macroblock.mode;
        if (i3 != 0) {
            if (i3 == 1) {
                renderBiDir(mPEG4DecodingContext, pictureArr, macroblock, false);
                return;
            }
            if (i3 == 2) {
                MPEG4Renderer.renderInter(mPEG4DecodingContext, pictureArr, macroblock, i2, 0, true);
                return;
            } else if (i3 == 3) {
                MPEG4Renderer.renderInter(mPEG4DecodingContext, pictureArr, macroblock, i, 1, true);
                return;
            } else if (i3 != 4) {
                return;
            }
        }
        renderBiDir(mPEG4DecodingContext, pictureArr, macroblock, true);
    }

    private static void renderBiDir(MPEG4DecodingContext mPEG4DecodingContext, Picture[] pictureArr, Macroblock macroblock, boolean z) {
        int i = macroblock.cbp;
        MPEG4Renderer.validateVector(macroblock.mvs, mPEG4DecodingContext, macroblock.x, macroblock.y);
        MPEG4Renderer.validateVector(macroblock.bmvs, mPEG4DecodingContext, macroblock.x, macroblock.y);
        renderOneDir(mPEG4DecodingContext, macroblock, z, pictureArr[1], macroblock.mvs, 0);
        renderOneDir(mPEG4DecodingContext, macroblock, z, pictureArr[0], macroblock.bmvs, 3);
        mergePred(macroblock);
        if (i != 0) {
            for (int i2 = 0; i2 < 6; i2++) {
                short[] sArr = macroblock.block[i2];
                if ((macroblock.cbp & (1 << (5 - i2))) != 0) {
                    MPEG4DCT.idctAdd(macroblock.pred, sArr, i2, mPEG4DecodingContext.interlacing && macroblock.fieldDCT);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v6 */
    private static void renderOneDir(MPEG4DecodingContext mPEG4DecodingContext, Macroblock macroblock, boolean z, Picture picture, Macroblock.Vector[] vectorArr, int i) {
        ?? r0;
        int i2;
        ?? r4;
        int i3;
        int iCalcChromaMvAvg;
        int iCalcChromaMvAvg2;
        boolean z2;
        int i4 = macroblock.x * 16;
        int i5 = macroblock.y * 16;
        int i6 = mPEG4DecodingContext.mbWidth;
        int i7 = i6 << 4;
        int i8 = mPEG4DecodingContext.mbHeight;
        int i9 = i8 << 4;
        int i10 = i6 << 3;
        int i11 = i8 << 3;
        if (mPEG4DecodingContext.quarterPel) {
            if (z) {
                byte[] bArr = macroblock.pred[i];
                byte[] planeData = picture.getPlaneData(0);
                Macroblock.Vector vector = vectorArr[0];
                MPEG4Interpolator.interpolate8x8QP(bArr, 0, planeData, i4, i5, i7, i9, vector.x, vector.y, picture.getWidth(), false);
                byte[] bArr2 = macroblock.pred[i];
                byte[] planeData2 = picture.getPlaneData(0);
                int i12 = i4 + 8;
                Macroblock.Vector vector2 = vectorArr[1];
                MPEG4Interpolator.interpolate8x8QP(bArr2, 8, planeData2, i12, i5, i7, i9, vector2.x, vector2.y, picture.getWidth(), false);
                byte[] bArr3 = macroblock.pred[i];
                byte[] planeData3 = picture.getPlaneData(0);
                int i13 = i5 + 8;
                Macroblock.Vector vector3 = vectorArr[2];
                MPEG4Interpolator.interpolate8x8QP(bArr3, 128, planeData3, i4, i13, i7, i9, vector3.x, vector3.y, picture.getWidth(), false);
                byte[] bArr4 = macroblock.pred[i];
                byte[] planeData4 = picture.getPlaneData(0);
                Macroblock.Vector vector4 = vectorArr[3];
                MPEG4Interpolator.interpolate8x8QP(bArr4, 136, planeData4, i12, i13, i7, i9, vector4.x, vector4.y, picture.getWidth(), false);
                i2 = 2;
                z2 = false;
            } else {
                byte[] bArr5 = macroblock.pred[i];
                byte[] planeData5 = picture.getPlaneData(0);
                Macroblock.Vector vector5 = vectorArr[0];
                MPEG4Interpolator.interpolate16x16QP(bArr5, planeData5, i4, i5, i7, i9, vector5.x, vector5.y, picture.getWidth(), false);
                z2 = false;
                i2 = 2;
            }
            r4 = 1;
            r0 = z2;
        } else {
            byte[] bArr6 = macroblock.pred[i];
            byte[] planeData6 = picture.getPlaneData(0);
            Macroblock.Vector vector6 = vectorArr[0];
            r0 = 0;
            MPEG4Interpolator.interpolate8x8Planar(bArr6, 0, 16, planeData6, i4, i5, i7, i9, vector6.x, vector6.y, picture.getWidth(), false);
            byte[] bArr7 = macroblock.pred[i];
            byte[] planeData7 = picture.getPlaneData(0);
            int i14 = i4 + 8;
            Macroblock.Vector vector7 = vectorArr[1];
            MPEG4Interpolator.interpolate8x8Planar(bArr7, 8, 16, planeData7, i14, i5, i7, i9, vector7.x, vector7.y, picture.getWidth(), false);
            byte[] bArr8 = macroblock.pred[i];
            byte[] planeData8 = picture.getPlaneData(0);
            int i15 = i5 + 8;
            i2 = 2;
            Macroblock.Vector vector8 = vectorArr[2];
            r4 = 1;
            MPEG4Interpolator.interpolate8x8Planar(bArr8, 128, 16, planeData8, i4, i15, i7, i9, vector8.x, vector8.y, picture.getWidth(), false);
            byte[] bArr9 = macroblock.pred[i];
            byte[] planeData9 = picture.getPlaneData(0);
            Macroblock.Vector vector9 = vectorArr[3];
            MPEG4Interpolator.interpolate8x8Planar(bArr9, 136, 16, planeData9, i14, i15, i7, i9, vector9.x, vector9.y, picture.getWidth(), false);
        }
        if (z) {
            i3 = i2;
            iCalcChromaMvAvg = MPEG4Renderer.calcChromaMvAvg(mPEG4DecodingContext, vectorArr, r4);
            iCalcChromaMvAvg2 = MPEG4Renderer.calcChromaMvAvg(mPEG4DecodingContext, vectorArr, r0);
        } else {
            i3 = i2;
            iCalcChromaMvAvg = MPEG4Renderer.calcChromaMv(mPEG4DecodingContext, vectorArr[r0].x);
            iCalcChromaMvAvg2 = MPEG4Renderer.calcChromaMv(mPEG4DecodingContext, vectorArr[r0].y);
        }
        int i16 = iCalcChromaMvAvg;
        int i17 = iCalcChromaMvAvg2;
        MPEG4Interpolator.interpolate8x8Planar(macroblock.pred[i + 1], 0, 8, picture.getPlaneData(r4), macroblock.x * 8, macroblock.y * 8, i10, i11, i16, i17, picture.getPlaneWidth(r4), false);
        MPEG4Interpolator.interpolate8x8Planar(macroblock.pred[i + 2], 0, 8, picture.getPlaneData(i3), macroblock.x * 8, macroblock.y * 8, i10, i11, i16, i17, picture.getPlaneWidth(i3), false);
    }
}
