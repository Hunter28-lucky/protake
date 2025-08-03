package org.jcodec.scale;

import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class Yuv420pToRgb implements Transform {
    public static void YUV420pToRGBH2H(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, int i, byte[] bArr, byte[] bArr2, int i2, int i3) {
        int i4 = 1 << i2;
        int i5 = (i4 << 8) - 1;
        int i6 = i4 >> 1;
        int i7 = (((b + 128) << i) + b2) - 64;
        int i8 = (((b3 + 128) << i) + b4) - 512;
        int i9 = (((b5 + 128) << i) + b6) - 512;
        int i10 = i7 * 298;
        int iClip = MathUtil.clip((((i9 * 409) + i10) + 128) >> 8, 0, i5);
        int iClip2 = MathUtil.clip((((i10 - (i8 * 100)) - (i9 * JpegConst.RST0)) + 128) >> 8, 0, i5);
        int iClip3 = MathUtil.clip(((i10 + (i8 * 516)) + 128) >> 8, 0, i5);
        int iClip4 = MathUtil.clip((iClip + i6) >> i2, 0, 255);
        bArr[i3] = (byte) (iClip4 - 128);
        bArr2[i3] = (byte) (iClip - (iClip4 << i2));
        int iClip5 = MathUtil.clip((iClip2 + i6) >> i2, 0, 255);
        int i11 = i3 + 1;
        bArr[i11] = (byte) (iClip5 - 128);
        bArr2[i11] = (byte) (iClip2 - (iClip5 << i2));
        int iClip6 = MathUtil.clip((i6 + iClip3) >> i2, 0, 255);
        int i12 = i3 + 2;
        bArr[i12] = (byte) (iClip6 - 128);
        bArr2[i12] = (byte) (iClip3 - (iClip6 << i2));
    }

    public static void YUV420pToRGBN2N(byte b, byte b2, byte b3, byte[] bArr, int i) {
        int i2 = (((b3 * 409) + ((b + 112) * 298)) + 128) >> 8;
        bArr[i] = (byte) (MathUtil.clip(i2, 0, 255) - 128);
        bArr[i + 1] = (byte) (MathUtil.clip((((r2 - (b2 * 100)) - (b3 * 208)) + 128) >> 8, 0, 255) - 128);
        bArr[i + 2] = (byte) (MathUtil.clip(((r2 + (b2 * 516)) + 128) >> 8, 0, 255) - 128);
    }

    @Override // org.jcodec.scale.Transform
    public final void transform(Picture picture, Picture picture2) {
        Picture picture3;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        int i;
        int i2;
        byte[] bArr4;
        int i3 = 0;
        byte[] planeData = picture.getPlaneData(0);
        byte[] planeData2 = picture.getPlaneData(1);
        byte[] planeData3 = picture.getPlaneData(2);
        byte[][] lowBits = picture.getLowBits();
        if (lowBits != null) {
            bArr2 = lowBits[0];
            bArr3 = lowBits[1];
            bArr = lowBits[2];
            picture3 = picture2;
        } else {
            picture3 = picture2;
            bArr = null;
            bArr2 = null;
            bArr3 = null;
        }
        byte[] planeData4 = picture3.getPlaneData(0);
        byte[] bArr5 = picture2.getLowBits() != null ? picture2.getLowBits()[0] : null;
        boolean z = picture.isHiBD() && picture2.isHiBD();
        int lowBitsNum = picture.getLowBitsNum();
        int lowBitsNum2 = picture2.getLowBitsNum();
        int width = picture2.getWidth();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < (picture2.getHeight() >> 1)) {
            int i7 = i3;
            int i8 = i4;
            while (i7 < (picture2.getWidth() >> 1)) {
                int i9 = i7 << 1;
                if (z) {
                    int i10 = i6 + i9;
                    i = i7;
                    i2 = i5;
                    byte[] bArr6 = planeData4;
                    byte[] bArr7 = bArr5;
                    YUV420pToRGBH2H(planeData[i10], bArr2[i10], planeData2[i8], bArr3[i8], planeData3[i8], bArr[i8], lowBitsNum, bArr6, bArr7, lowBitsNum2, i10 * 3);
                    int i11 = i10 + 1;
                    YUV420pToRGBH2H(planeData[i11], bArr2[i11], planeData2[i8], bArr3[i8], planeData3[i8], bArr[i8], lowBitsNum, bArr6, bArr7, lowBitsNum2, i11 * 3);
                    int i12 = i10 + width;
                    YUV420pToRGBH2H(planeData[i12], bArr2[i12], planeData2[i8], bArr3[i8], planeData3[i8], bArr[i8], lowBitsNum, bArr6, bArr7, lowBitsNum2, i12 * 3);
                    int i13 = i12 + 1;
                    YUV420pToRGBH2H(planeData[i13], bArr2[i13], planeData2[i8], bArr3[i8], planeData3[i8], bArr[i8], lowBitsNum, bArr6, bArr7, lowBitsNum2, i13 * 3);
                    bArr4 = bArr6;
                } else {
                    i = i7;
                    i2 = i5;
                    int i14 = i6 + i9;
                    bArr4 = planeData4;
                    YUV420pToRGBN2N(planeData[i14], planeData2[i8], planeData3[i8], bArr4, i14 * 3);
                    int i15 = i14 + 1;
                    YUV420pToRGBN2N(planeData[i15], planeData2[i8], planeData3[i8], bArr4, i15 * 3);
                    int i16 = i14 + width;
                    YUV420pToRGBN2N(planeData[i16], planeData2[i8], planeData3[i8], bArr4, i16 * 3);
                    int i17 = i16 + 1;
                    YUV420pToRGBN2N(planeData[i17], planeData2[i8], planeData3[i8], bArr4, i17 * 3);
                }
                i8++;
                i7 = i + 1;
                planeData4 = bArr4;
                i5 = i2;
            }
            int i18 = i5;
            byte[] bArr8 = planeData4;
            if ((picture2.getWidth() & 1) != 0) {
                int width2 = i6 + (picture2.getWidth() - 1);
                YUV420pToRGBN2N(planeData[width2], planeData2[i8], planeData3[i8], bArr8, width2 * 3);
                int i19 = width2 + width;
                YUV420pToRGBN2N(planeData[i19], planeData2[i8], planeData3[i8], bArr8, i19 * 3);
                i8++;
            }
            i4 = i8;
            i6 += width * 2;
            i5 = i18 + 1;
            planeData4 = bArr8;
            i3 = 0;
        }
        byte[] bArr9 = planeData4;
        if ((picture2.getHeight() & 1) != 0) {
            for (int i20 = 0; i20 < (picture2.getWidth() >> 1); i20++) {
                int i21 = i6 + (i20 << 1);
                YUV420pToRGBN2N(planeData[i21], planeData2[i4], planeData3[i4], bArr9, i21 * 3);
                int i22 = i21 + 1;
                YUV420pToRGBN2N(planeData[i22], planeData2[i4], planeData3[i4], bArr9, i22 * 3);
                i4++;
            }
            if ((picture2.getWidth() & 1) != 0) {
                int width3 = i6 + (picture2.getWidth() - 1);
                YUV420pToRGBN2N(planeData[width3], planeData2[i4], planeData3[i4], bArr9, width3 * 3);
            }
        }
    }
}
