package org.jcodec.scale;

import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class Yuv420pToYuv422p implements Transform {
    private static final void _copy(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i + (i2 * i6);
        int i10 = 0;
        for (int i11 = 0; i11 < i7; i11++) {
            int i12 = 0;
            while (i12 < i5) {
                bArr2[i9] = bArr[i10];
                i9 += i3;
                i12++;
                i10++;
            }
            int i13 = i9 - i3;
            int i14 = i5 * i3;
            while (i14 < i6) {
                bArr2[i9] = bArr2[i13];
                i9 += i3;
                i14 += i3;
            }
            i9 += (i4 - 1) * i6;
        }
        int i15 = i9 - (i4 * i6);
        int i16 = i7 * i4;
        while (i16 < i8) {
            int i17 = 0;
            while (i17 < i6) {
                bArr2[i9] = bArr2[i15 + i17];
                i9 += i3;
                i17 += i3;
            }
            i9 += (i4 - 1) * i6;
            i16 += i4;
        }
    }

    private static void copy(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        int length = bArr.length / i;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = 0;
            while (i7 < i) {
                bArr2[i4] = bArr[i5];
                i7++;
                i4++;
                i5++;
            }
            int i8 = i;
            while (i8 < i2) {
                bArr2[i4] = bArr2[i - 1];
                i8++;
                i4++;
            }
        }
        int i9 = (length - 1) * i2;
        while (length < i3) {
            int i10 = 0;
            while (i10 < i2) {
                bArr2[i4] = bArr2[i9 + i10];
                i10++;
                i4++;
            }
            length++;
        }
    }

    @Override // org.jcodec.scale.Transform
    public void transform(Picture picture, Picture picture2) {
        copy(picture.getPlaneData(0), picture2.getPlaneData(0), picture.getWidth(), picture2.getWidth(), picture2.getHeight());
        _copy(picture.getPlaneData(1), picture2.getPlaneData(1), 0, 0, 1, 2, picture.getWidth() >> 1, picture2.getWidth() >> 1, picture.getHeight() >> 1, picture2.getHeight());
        _copy(picture.getPlaneData(1), picture2.getPlaneData(1), 0, 1, 1, 2, picture.getWidth() >> 1, picture2.getWidth() >> 1, picture.getHeight() >> 1, picture2.getHeight());
        _copy(picture.getPlaneData(2), picture2.getPlaneData(2), 0, 0, 1, 2, picture.getWidth() >> 1, picture2.getWidth() >> 1, picture.getHeight() >> 1, picture2.getHeight());
        _copy(picture.getPlaneData(2), picture2.getPlaneData(2), 0, 1, 1, 2, picture.getWidth() >> 1, picture2.getWidth() >> 1, picture.getHeight() >> 1, picture2.getHeight());
    }
}
