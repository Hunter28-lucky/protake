package org.jcodec.scale.highbd;

import org.jcodec.common.model.PictureHiBD;

/* loaded from: classes2.dex */
public class RgbToYuv422pHiBD implements TransformHiBD {
    private int downShift;
    private int downShiftChr;
    private int upShift;

    public RgbToYuv422pHiBD(int i, int i2) {
        this.upShift = i;
        this.downShift = i2;
        this.downShiftChr = i2 + 1;
    }

    @Override // org.jcodec.scale.highbd.TransformHiBD
    public void transform(PictureHiBD pictureHiBD, PictureHiBD pictureHiBD2) {
        int[] iArr = pictureHiBD.getData()[0];
        int[][] data = pictureHiBD2.getData();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < pictureHiBD.getHeight(); i3++) {
            int i4 = 0;
            while (i4 < (pictureHiBD.getWidth() >> 1)) {
                int[] iArr2 = data[1];
                iArr2[i] = 0;
                int[] iArr3 = data[2];
                iArr3[i] = 0;
                int i5 = i << 1;
                int i6 = i2 + 1;
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                int i9 = i;
                int i10 = i;
                RgbToYuv420pHiBD.rgb2yuv(iArr[i2], iArr[i6], iArr[i7], data[0], i5, iArr2, i9, iArr3, i10);
                int[] iArr4 = data[0];
                iArr4[i5] = (iArr4[i5] << this.upShift) >> this.downShift;
                int i11 = i8 + 1;
                int i12 = i11 + 1;
                int i13 = i12 + 1;
                int i14 = i5 + 1;
                RgbToYuv420pHiBD.rgb2yuv(iArr[i8], iArr[i11], iArr[i12], iArr4, i14, data[1], i9, data[2], i10);
                int[] iArr5 = data[0];
                int i15 = iArr5[i14];
                int i16 = this.upShift;
                iArr5[i14] = (i15 << i16) >> this.downShift;
                int[] iArr6 = data[1];
                int i17 = iArr6[i] << i16;
                int i18 = this.downShiftChr;
                iArr6[i] = i17 >> i18;
                int[] iArr7 = data[2];
                iArr7[i] = (iArr7[i] << i16) >> i18;
                i++;
                i4++;
                i2 = i13;
            }
        }
    }
}
