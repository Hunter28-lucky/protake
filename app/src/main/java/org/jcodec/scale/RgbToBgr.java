package org.jcodec.scale;

import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class RgbToBgr implements Transform {
    @Override // org.jcodec.scale.Transform
    public void transform(Picture picture, Picture picture2) {
        ColorSpace color = picture.getColor();
        ColorSpace colorSpace = ColorSpace.RGB;
        if ((color != colorSpace && picture.getColor() != ColorSpace.BGR) || (picture2.getColor() != colorSpace && picture2.getColor() != ColorSpace.BGR)) {
            throw new IllegalArgumentException("Expected RGB or BGR inputs, was: " + picture.getColor() + ", " + picture2.getColor());
        }
        byte[] planeData = picture.getPlaneData(0);
        byte[] planeData2 = picture2.getPlaneData(0);
        for (int i = 0; i < planeData.length; i += 3) {
            int i2 = i + 2;
            byte b = planeData[i2];
            planeData2[i2] = planeData[i];
            planeData2[i] = b;
            int i3 = i + 1;
            planeData2[i3] = planeData[i3];
        }
    }
}
