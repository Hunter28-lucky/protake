package org.jcodec.scale.highbd;

import org.jcodec.common.model.PictureHiBD;

/* loaded from: classes2.dex */
public class Yuv420jToYuv420HiBD implements TransformHiBD {
    public static int Y_COEFF = 7168;

    @Override // org.jcodec.scale.highbd.TransformHiBD
    public void transform(PictureHiBD pictureHiBD, PictureHiBD pictureHiBD2) {
        int[] planeData = pictureHiBD.getPlaneData(0);
        int[] planeData2 = pictureHiBD2.getPlaneData(0);
        for (int i = 0; i < pictureHiBD.getPlaneWidth(0) * pictureHiBD.getPlaneHeight(0); i++) {
            planeData2[i] = ((planeData[i] * Y_COEFF) >> 13) + 16;
        }
        int[] planeData3 = pictureHiBD.getPlaneData(1);
        int[] planeData4 = pictureHiBD2.getPlaneData(1);
        for (int i2 = 0; i2 < pictureHiBD.getPlaneWidth(1) * pictureHiBD.getPlaneHeight(1); i2++) {
            planeData4[i2] = (((planeData3[i2] - 128) * Y_COEFF) >> 13) + 128;
        }
        int[] planeData5 = pictureHiBD.getPlaneData(2);
        int[] planeData6 = pictureHiBD2.getPlaneData(2);
        for (int i3 = 0; i3 < pictureHiBD.getPlaneWidth(2) * pictureHiBD.getPlaneHeight(2); i3++) {
            planeData6[i3] = (((planeData5[i3] - 128) * Y_COEFF) >> 13) + 128;
        }
    }
}
