package org.jcodec.scale.highbd;

import org.jcodec.common.model.PictureHiBD;

/* loaded from: classes2.dex */
public class RgbToYuv420pHiBD implements TransformHiBD {
    private int downShift;
    private int downShiftChr;
    private int upShift;

    public RgbToYuv420pHiBD(int i, int i2) {
        this.upShift = i;
        this.downShift = i2;
        this.downShiftChr = i2 + 2;
    }

    private static final int clip(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }

    public static final void rgb2yuv(int i, int i2, int i3, int[] iArr, int i4, int[] iArr2, int i5, int[] iArr3, int i6) {
        int i7 = (i * 66) + (i2 * 129) + (i3 * 25);
        int i8 = ((i * (-38)) - (i2 * 74)) + (i3 * 112);
        iArr[i4] = clip(((i7 + 128) >> 8) + 16);
        iArr2[i5] = iArr2[i5] + clip(((i8 + 128) >> 8) + 128);
        iArr3[i6] = iArr3[i6] + clip((((((i * 112) - (i2 * 94)) - (i3 * 18)) + 128) >> 8) + 128);
    }

    @Override // org.jcodec.scale.highbd.TransformHiBD
    public void transform(PictureHiBD pictureHiBD, PictureHiBD pictureHiBD2) {
        int[] iArr = pictureHiBD.getData()[0];
        int[][] data = pictureHiBD2.getData();
        int width = pictureHiBD.getWidth() * 3;
        int width2 = pictureHiBD2.getWidth();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < (pictureHiBD.getHeight() >> 1); i4++) {
            for (int i5 = 0; i5 < (pictureHiBD.getWidth() >> 1); i5++) {
                int[] iArr2 = data[1];
                iArr2[i] = 0;
                int[] iArr3 = data[2];
                iArr3[i] = 0;
                int i6 = i;
                int i7 = i;
                rgb2yuv(iArr[i3], iArr[i3 + 1], iArr[i3 + 2], data[0], i2, iArr2, i6, iArr3, i7);
                int[] iArr4 = data[0];
                iArr4[i2] = (iArr4[i2] << this.upShift) >> this.downShift;
                int i8 = i3 + width;
                int i9 = i2 + width2;
                rgb2yuv(iArr[i8], iArr[i8 + 1], iArr[i8 + 2], iArr4, i9, data[1], i6, data[2], i7);
                int[] iArr5 = data[0];
                iArr5[i9] = (iArr5[i9] << this.upShift) >> this.downShift;
                int i10 = i2 + 1;
                rgb2yuv(iArr[i3 + 3], iArr[i3 + 4], iArr[i3 + 5], iArr5, i10, data[1], i6, data[2], i7);
                int[] iArr6 = data[0];
                iArr6[i10] = (iArr6[i10] << this.upShift) >> this.downShift;
                int i11 = iArr[i8 + 3];
                int i12 = iArr[i8 + 4];
                int i13 = iArr[i8 + 5];
                int i14 = i10 + width2;
                rgb2yuv(i11, i12, i13, iArr6, i14, data[1], i6, data[2], i7);
                int[] iArr7 = data[0];
                int i15 = iArr7[i14];
                int i16 = this.upShift;
                iArr7[i14] = (i15 << i16) >> this.downShift;
                i2 = i10 + 1;
                int[] iArr8 = data[1];
                int i17 = iArr8[i] << i16;
                int i18 = this.downShiftChr;
                iArr8[i] = i17 >> i18;
                int[] iArr9 = data[2];
                iArr9[i] = (iArr9[i] << i16) >> i18;
                i++;
                i3 += 6;
            }
            i2 += width2;
            i3 += width;
        }
    }
}
