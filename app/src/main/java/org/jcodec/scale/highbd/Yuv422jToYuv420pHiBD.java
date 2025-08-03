package org.jcodec.scale.highbd;

import org.jcodec.common.model.PictureHiBD;

/* loaded from: classes2.dex */
public class Yuv422jToYuv420pHiBD implements TransformHiBD {
    public static int Y_COEFF = 7168;

    private void copyAvg(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2 / 2; i5++) {
            int i6 = 0;
            while (i6 < i) {
                int i7 = iArr[i3] - 128;
                int i8 = Y_COEFF;
                iArr2[i4] = (((((i7 * i8) >> 13) + 128) + ((((iArr[i3 + i] - 128) * i8) >> 13) + 128)) + 1) >> 1;
                i6++;
                i4++;
                i3++;
            }
            i3 += i;
        }
    }

    @Override // org.jcodec.scale.highbd.TransformHiBD
    public void transform(PictureHiBD pictureHiBD, PictureHiBD pictureHiBD2) {
        int[] planeData = pictureHiBD.getPlaneData(0);
        int[] planeData2 = pictureHiBD2.getPlaneData(0);
        for (int i = 0; i < pictureHiBD.getPlaneWidth(0) * pictureHiBD.getPlaneHeight(0); i++) {
            planeData2[i] = ((planeData[i] * Y_COEFF) >> 13) + 16;
        }
        copyAvg(pictureHiBD.getPlaneData(1), pictureHiBD2.getPlaneData(1), pictureHiBD.getPlaneWidth(1), pictureHiBD.getPlaneHeight(1));
        copyAvg(pictureHiBD.getPlaneData(2), pictureHiBD2.getPlaneData(2), pictureHiBD.getPlaneWidth(2), pictureHiBD.getPlaneHeight(2));
    }
}
