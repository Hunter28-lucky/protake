package org.jcodec.scale.highbd;

import org.jcodec.common.model.PictureHiBD;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class Yuv420jToRgbHiBD implements TransformHiBD {
    private static final int ONE_HALF = 512;
    private static final int SCALEBITS = 10;
    private static final int FIX_0_71414 = FIX(0.71414d);
    private static final int FIX_1_772 = FIX(1.772d);
    private static final int _FIX_0_34414 = -FIX(0.34414d);
    private static final int FIX_1_402 = FIX(1.402d);

    private static final int FIX(double d) {
        return (int) ((d * 1024.0d) + 0.5d);
    }

    public static final void YUVJtoRGB(int i, int i2, int i3, int[] iArr, int i4) {
        int i5 = i << 10;
        int i6 = i2 - 128;
        int i7 = i3 - 128;
        int i8 = (FIX_1_402 * i7) + 512;
        int i9 = ((_FIX_0_34414 * i6) - (FIX_0_71414 * i7)) + 512;
        int i10 = (FIX_1_772 * i6) + 512;
        iArr[i4] = MathUtil.clip((i8 + i5) >> 10, 0, 255);
        iArr[i4 + 1] = MathUtil.clip((i9 + i5) >> 10, 0, 255);
        iArr[i4 + 2] = MathUtil.clip((i5 + i10) >> 10, 0, 255);
    }

    @Override // org.jcodec.scale.highbd.TransformHiBD
    public final void transform(PictureHiBD pictureHiBD, PictureHiBD pictureHiBD2) {
        int i = 0;
        int[] planeData = pictureHiBD.getPlaneData(0);
        int[] planeData2 = pictureHiBD.getPlaneData(1);
        int[] planeData3 = pictureHiBD.getPlaneData(2);
        int[] planeData4 = pictureHiBD2.getPlaneData(0);
        int width = pictureHiBD2.getWidth();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < (pictureHiBD2.getHeight() >> 1)) {
            for (int i5 = i; i5 < (pictureHiBD2.getWidth() >> 1); i5++) {
                int i6 = (i5 << 1) + i3;
                YUVJtoRGB(planeData[i6], planeData2[i4], planeData3[i4], planeData4, i6 * 3);
                int i7 = i6 + 1;
                YUVJtoRGB(planeData[i7], planeData2[i4], planeData3[i4], planeData4, i7 * 3);
                int i8 = i6 + width;
                YUVJtoRGB(planeData[i8], planeData2[i4], planeData3[i4], planeData4, i8 * 3);
                int i9 = i8 + 1;
                YUVJtoRGB(planeData[i9], planeData2[i4], planeData3[i4], planeData4, i9 * 3);
                i4++;
            }
            if ((pictureHiBD2.getWidth() & 1) != 0) {
                int width2 = (pictureHiBD2.getWidth() - 1) + i3;
                YUVJtoRGB(planeData[width2], planeData2[i4], planeData3[i4], planeData4, width2 * 3);
                int i10 = width2 + width;
                YUVJtoRGB(planeData[i10], planeData2[i4], planeData3[i4], planeData4, i10 * 3);
                i4++;
            }
            i3 += width * 2;
            i2++;
            i = 0;
        }
        if ((pictureHiBD2.getHeight() & 1) != 0) {
            for (int i11 = 0; i11 < (pictureHiBD2.getWidth() >> 1); i11++) {
                int i12 = (i11 << 1) + i3;
                YUVJtoRGB(planeData[i12], planeData2[i4], planeData3[i4], planeData4, i12 * 3);
                int i13 = i12 + 1;
                YUVJtoRGB(planeData[i13], planeData2[i4], planeData3[i4], planeData4, i13 * 3);
                i4++;
            }
            if ((pictureHiBD2.getWidth() & 1) != 0) {
                int width3 = i3 + (pictureHiBD2.getWidth() - 1);
                YUVJtoRGB(planeData[width3], planeData2[i4], planeData3[i4], planeData4, width3 * 3);
            }
        }
    }
}
