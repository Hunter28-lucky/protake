package org.jcodec.scale;

import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class Yuv422pToYuv420p implements Transform {
    private void copyAvg(byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2 / 2; i5++) {
            int i6 = 0;
            while (i6 < i) {
                bArr2[i4] = (byte) (((bArr[i3] + bArr[i3 + i]) + 1) >> 1);
                i6++;
                i4++;
                i3++;
            }
            i3 += i;
        }
    }

    @Override // org.jcodec.scale.Transform
    public void transform(Picture picture, Picture picture2) {
        System.arraycopy(picture.getPlaneData(0), 0, picture2.getPlaneData(0), 0, picture.getWidth() * picture.getHeight());
        copyAvg(picture.getPlaneData(1), picture2.getPlaneData(1), picture.getPlaneWidth(1), picture.getPlaneHeight(1));
        copyAvg(picture.getPlaneData(2), picture2.getPlaneData(2), picture.getPlaneWidth(2), picture.getPlaneHeight(2));
    }
}
