package org.jcodec.scale;

import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class Yuv422pToRgb implements Transform {
    public static final void YUV444toRGB888(byte b, byte b2, byte b3, byte[] bArr, int i) {
        int i2 = (((b3 * 409) + ((b + 112) * 298)) + 128) >> 8;
        bArr[i] = (byte) (MathUtil.clip(i2, 0, 255) - 128);
        bArr[i + 1] = (byte) (MathUtil.clip((((r2 - (b2 * 100)) - (b3 * 208)) + 128) >> 8, 0, 255) - 128);
        bArr[i + 2] = (byte) (MathUtil.clip(((r2 + (b2 * 516)) + 128) >> 8, 0, 255) - 128);
    }

    @Override // org.jcodec.scale.Transform
    public void transform(Picture picture, Picture picture2) {
        byte[] planeData = picture.getPlaneData(0);
        byte[] planeData2 = picture.getPlaneData(1);
        byte[] planeData3 = picture.getPlaneData(2);
        byte[] planeData4 = picture2.getPlaneData(0);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < picture2.getHeight(); i3++) {
            for (int i4 = 0; i4 < picture2.getWidth(); i4 += 2) {
                YUV444toRGB888(planeData[i], planeData2[i2], planeData3[i2], planeData4, i * 3);
                int i5 = i + 1;
                YUV444toRGB888(planeData[i5], planeData2[i2], planeData3[i2], planeData4, i5 * 3);
                i += 2;
                i2++;
            }
        }
    }
}
