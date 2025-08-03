package org.jcodec.scale.highbd;

import org.jcodec.common.model.PictureHiBD;

/* loaded from: classes2.dex */
public class Yuv420pToRgbHiBD implements TransformHiBD {
    private final int downShift;
    private final int upShift;

    public Yuv420pToRgbHiBD(int i, int i2) {
        this.upShift = i;
        this.downShift = i2;
    }

    @Override // org.jcodec.scale.highbd.TransformHiBD
    public final void transform(PictureHiBD pictureHiBD, PictureHiBD pictureHiBD2) {
        int i = 0;
        int[] planeData = pictureHiBD.getPlaneData(0);
        int i2 = 1;
        int[] planeData2 = pictureHiBD.getPlaneData(1);
        int[] planeData3 = pictureHiBD.getPlaneData(2);
        int[] planeData4 = pictureHiBD2.getPlaneData(0);
        int width = pictureHiBD2.getWidth();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < (pictureHiBD2.getHeight() >> i2)) {
            int i6 = i;
            while (i6 < (pictureHiBD2.getWidth() >> i2)) {
                int i7 = (i6 << 1) + i4;
                int i8 = planeData[i7];
                int i9 = this.upShift;
                int i10 = this.downShift;
                Yuv422pToRgbHiBD.YUV444toRGB888((i8 << i9) >> i10, (planeData2[i5] << i9) >> i10, (planeData3[i5] << i9) >> i10, planeData4, i7 * 3);
                int i11 = i7 + 1;
                int i12 = planeData[i11];
                int i13 = this.upShift;
                int i14 = this.downShift;
                Yuv422pToRgbHiBD.YUV444toRGB888((i12 << i13) >> i14, (planeData2[i5] << i13) >> i14, (planeData3[i5] << i13) >> i14, planeData4, i11 * 3);
                int i15 = i7 + width;
                int i16 = planeData[i15];
                int i17 = this.upShift;
                int i18 = this.downShift;
                Yuv422pToRgbHiBD.YUV444toRGB888((i16 << i17) >> i18, (planeData2[i5] << i17) >> i18, (planeData3[i5] << i17) >> i18, planeData4, i15 * 3);
                int i19 = i15 + 1;
                int i20 = planeData[i19];
                int i21 = this.upShift;
                int i22 = this.downShift;
                Yuv422pToRgbHiBD.YUV444toRGB888((i20 << i21) >> i22, (planeData2[i5] << i21) >> i22, (planeData3[i5] << i21) >> i22, planeData4, i19 * 3);
                i5++;
                i6++;
                i2 = 1;
            }
            if ((pictureHiBD2.getWidth() & 1) != 0) {
                int width2 = (pictureHiBD2.getWidth() - 1) + i4;
                int i23 = planeData[width2];
                int i24 = this.upShift;
                int i25 = this.downShift;
                Yuv422pToRgbHiBD.YUV444toRGB888((i23 << i24) >> i25, (planeData2[i5] << i24) >> i25, (planeData3[i5] << i24) >> i25, planeData4, width2 * 3);
                int i26 = width2 + width;
                int i27 = planeData[i26];
                int i28 = this.upShift;
                int i29 = this.downShift;
                Yuv422pToRgbHiBD.YUV444toRGB888((i27 << i28) >> i29, (planeData2[i5] << i28) >> i29, (planeData3[i5] << i28) >> i29, planeData4, i26 * 3);
                i5++;
            }
            i4 += width * 2;
            i3++;
            i = 0;
            i2 = 1;
        }
        if ((pictureHiBD2.getHeight() & 1) != 0) {
            int i30 = 0;
            for (int i31 = 1; i30 < (pictureHiBD2.getWidth() >> i31); i31 = 1) {
                int i32 = (i30 << 1) + i4;
                int i33 = planeData[i32];
                int i34 = this.upShift;
                int i35 = this.downShift;
                Yuv422pToRgbHiBD.YUV444toRGB888((i33 << i34) >> i35, (planeData2[i5] << i34) >> i35, (planeData3[i5] << i34) >> i35, planeData4, i32 * 3);
                int i36 = i32 + 1;
                int i37 = planeData[i36];
                int i38 = this.upShift;
                int i39 = this.downShift;
                Yuv422pToRgbHiBD.YUV444toRGB888((i37 << i38) >> i39, (planeData2[i5] << i38) >> i39, (planeData3[i5] << i38) >> i39, planeData4, i36 * 3);
                i5++;
                i30++;
            }
            if ((pictureHiBD2.getWidth() & 1) != 0) {
                int width3 = i4 + (pictureHiBD2.getWidth() - 1);
                int i40 = planeData[width3];
                int i41 = this.upShift;
                int i42 = this.downShift;
                Yuv422pToRgbHiBD.YUV444toRGB888((i40 << i41) >> i42, (planeData2[i5] << i41) >> i42, (planeData3[i5] << i41) >> i42, planeData4, width3 * 3);
            }
        }
    }
}
