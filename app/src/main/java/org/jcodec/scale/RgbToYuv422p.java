package org.jcodec.scale;

import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class RgbToYuv422p implements Transform {
    @Override // org.jcodec.scale.Transform
    public void transform(Picture picture, Picture picture2) {
        byte[] bArr = picture.getData()[0];
        byte[] bArr2 = new byte[3];
        byte[] bArr3 = new byte[3];
        byte[][] data = picture2.getData();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < picture.getHeight(); i3++) {
            int i4 = 0;
            while (i4 < (picture.getWidth() >> 1)) {
                int i5 = i << 1;
                int i6 = i2 + 1;
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                RgbToYuv420p.rgb2yuv(bArr[i2], bArr[i6], bArr[i7], bArr2);
                data[0][i5] = bArr2[0];
                int i9 = i8 + 1;
                int i10 = i9 + 1;
                RgbToYuv420p.rgb2yuv(bArr[i8], bArr[i9], bArr[i10], bArr3);
                data[0][i5 + 1] = bArr3[0];
                data[1][i] = (byte) (((bArr2[1] + bArr3[1]) + 1) >> 1);
                data[2][i] = (byte) (((bArr2[2] + bArr3[2]) + 1) >> 1);
                i++;
                i4++;
                i2 = i10 + 1;
            }
        }
    }
}
