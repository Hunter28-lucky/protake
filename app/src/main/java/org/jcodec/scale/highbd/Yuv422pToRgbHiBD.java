package org.jcodec.scale.highbd;

import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.common.model.PictureHiBD;

/* loaded from: classes2.dex */
public class Yuv422pToRgbHiBD implements TransformHiBD {
    private int downShift;
    private int upShift;

    public Yuv422pToRgbHiBD(int i, int i2) {
        this.downShift = i;
        this.upShift = i2;
    }

    public static final void YUV444toRGB888(int i, int i2, int i3, int[] iArr, int i4) {
        int i5 = i2 - 128;
        int i6 = i3 - 128;
        int i7 = (i - 16) * 298;
        int i8 = (((i6 * 409) + i7) + 128) >> 8;
        int i9 = (((i7 - (i5 * 100)) - (i6 * JpegConst.RST0)) + 128) >> 8;
        iArr[i4] = crop(i8);
        iArr[i4 + 1] = crop(i9);
        iArr[i4 + 2] = crop(((i7 + (i5 * 516)) + 128) >> 8);
    }

    private static int crop(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }

    @Override // org.jcodec.scale.highbd.TransformHiBD
    public void transform(PictureHiBD pictureHiBD, PictureHiBD pictureHiBD2) {
        int[] planeData = pictureHiBD.getPlaneData(0);
        int[] planeData2 = pictureHiBD.getPlaneData(1);
        int[] planeData3 = pictureHiBD.getPlaneData(2);
        int[] planeData4 = pictureHiBD2.getPlaneData(0);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < pictureHiBD2.getHeight(); i3++) {
            for (int i4 = 0; i4 < pictureHiBD2.getWidth(); i4 += 2) {
                int i5 = planeData[i];
                int i6 = this.upShift;
                int i7 = this.downShift;
                YUV444toRGB888((i5 << i6) >> i7, (planeData2[i2] << i6) >> i7, (planeData3[i2] << i6) >> i7, planeData4, i * 3);
                int i8 = i + 1;
                int i9 = planeData[i8];
                int i10 = this.upShift;
                int i11 = this.downShift;
                YUV444toRGB888((i9 << i10) >> i11, (planeData2[i2] << i10) >> i11, (planeData3[i2] << i10) >> i11, planeData4, i8 * 3);
                i += 2;
                i2++;
            }
        }
    }
}
