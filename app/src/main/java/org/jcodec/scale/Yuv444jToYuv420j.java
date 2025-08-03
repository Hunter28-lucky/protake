package org.jcodec.scale;

import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class Yuv444jToYuv420j implements Transform {
    @Override // org.jcodec.scale.Transform
    public void transform(Picture picture, Picture picture2) {
        System.arraycopy(picture.getPlaneData(0), 0, picture2.getPlaneData(0), 0, picture.getWidth() * picture.getHeight());
        for (int i = 1; i < 3; i++) {
            byte[] planeData = picture.getPlaneData(i);
            byte[] planeData2 = picture2.getPlaneData(i);
            int planeWidth = picture.getPlaneWidth(i);
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < picture.getHeight()) {
                int i5 = 0;
                while (i5 < picture.getWidth()) {
                    int i6 = i3 + planeWidth;
                    planeData2[i4] = (byte) (((((planeData[i3] + planeData[i3 + 1]) + planeData[i6]) + planeData[i6 + 1]) + 2) >> 2);
                    i5 += 2;
                    i3 += 2;
                    i4++;
                }
                i2 += 2;
                i3 += planeWidth;
            }
        }
    }
}
