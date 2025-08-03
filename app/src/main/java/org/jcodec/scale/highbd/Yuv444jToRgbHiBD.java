package org.jcodec.scale.highbd;

import org.jcodec.common.model.PictureHiBD;

/* loaded from: classes2.dex */
public class Yuv444jToRgbHiBD implements TransformHiBD {
    @Override // org.jcodec.scale.highbd.TransformHiBD
    public void transform(PictureHiBD pictureHiBD, PictureHiBD pictureHiBD2) {
        int[] planeData = pictureHiBD.getPlaneData(0);
        int[] planeData2 = pictureHiBD.getPlaneData(1);
        int[] planeData3 = pictureHiBD.getPlaneData(2);
        int[] planeData4 = pictureHiBD2.getPlaneData(0);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < pictureHiBD2.getHeight(); i3++) {
            int i4 = 0;
            while (i4 < pictureHiBD2.getWidth()) {
                Yuv420jToRgbHiBD.YUVJtoRGB(planeData[i], planeData2[i], planeData3[i], planeData4, i2);
                i4++;
                i++;
                i2 += 3;
            }
        }
    }
}
