package org.jcodec.scale.highbd;

import org.jcodec.api.NotSupportedException;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.PictureHiBD;

@Deprecated
/* loaded from: classes2.dex */
public class RgbToBgrHiBD implements TransformHiBD {
    @Override // org.jcodec.scale.highbd.TransformHiBD
    public void transform(PictureHiBD pictureHiBD, PictureHiBD pictureHiBD2) {
        ColorSpace color = pictureHiBD.getColor();
        ColorSpace colorSpace = ColorSpace.RGB;
        if ((color != colorSpace && pictureHiBD.getColor() != ColorSpace.BGR) || (pictureHiBD2.getColor() != colorSpace && pictureHiBD2.getColor() != ColorSpace.BGR)) {
            throw new IllegalArgumentException("Expected RGB or BGR inputs, was: " + pictureHiBD.getColor() + ", " + pictureHiBD2.getColor());
        }
        if (pictureHiBD.getCrop() != null || pictureHiBD2.getCrop() != null) {
            throw new NotSupportedException("Cropped images not supported");
        }
        int[] planeData = pictureHiBD.getPlaneData(0);
        int[] planeData2 = pictureHiBD2.getPlaneData(0);
        for (int i = 0; i < planeData.length; i += 3) {
            int i2 = i + 2;
            int i3 = planeData[i2];
            planeData2[i2] = planeData[i];
            planeData2[i] = i3;
        }
    }
}
