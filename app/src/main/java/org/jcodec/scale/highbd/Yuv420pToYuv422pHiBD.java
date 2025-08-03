package org.jcodec.scale.highbd;

import org.jcodec.common.model.PictureHiBD;

/* loaded from: classes2.dex */
public class Yuv420pToYuv422pHiBD implements TransformHiBD {
    private int shiftDown;
    private int shiftUp;

    public Yuv420pToYuv422pHiBD(int i, int i2) {
        this.shiftUp = i;
        this.shiftDown = i2;
    }

    private static final void _copy(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = i + (i2 * i6);
        int i12 = 0;
        for (int i13 = 0; i13 < i7; i13++) {
            int i14 = 0;
            while (i14 < i5) {
                iArr2[i11] = (iArr[i12] & 255) << 2;
                i11 += i3;
                i14++;
                i12++;
            }
            int i15 = i11 - i3;
            int i16 = i5 * i3;
            while (i16 < i6) {
                iArr2[i11] = iArr2[i15];
                i11 += i3;
                i16 += i3;
            }
            i11 += (i4 - 1) * i6;
        }
        int i17 = i11 - (i4 * i6);
        int i18 = i7 * i4;
        while (i18 < i8) {
            int i19 = 0;
            while (i19 < i6) {
                iArr2[i11] = iArr2[i17 + i19];
                i11 += i3;
                i19 += i3;
            }
            i11 += (i4 - 1) * i6;
            i18 += i4;
        }
    }

    private static void copy(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5) {
        int length = iArr.length / i;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = 0;
            while (i9 < i) {
                iArr2[i6] = (iArr[i7] & 255) << 2;
                i9++;
                i6++;
                i7++;
            }
            int i10 = i;
            while (i10 < i2) {
                iArr2[i6] = iArr2[i - 1];
                i10++;
                i6++;
            }
        }
        int i11 = (length - 1) * i2;
        while (length < i3) {
            int i12 = 0;
            while (i12 < i2) {
                iArr2[i6] = iArr2[i11 + i12];
                i12++;
                i6++;
            }
            length++;
        }
    }

    @Override // org.jcodec.scale.highbd.TransformHiBD
    public void transform(PictureHiBD pictureHiBD, PictureHiBD pictureHiBD2) {
        copy(pictureHiBD.getPlaneData(0), pictureHiBD2.getPlaneData(0), pictureHiBD.getWidth(), pictureHiBD2.getWidth(), pictureHiBD2.getHeight(), this.shiftUp, this.shiftDown);
        _copy(pictureHiBD.getPlaneData(1), pictureHiBD2.getPlaneData(1), 0, 0, 1, 2, pictureHiBD.getWidth() >> 1, pictureHiBD2.getWidth() >> 1, pictureHiBD.getHeight() >> 1, pictureHiBD2.getHeight(), this.shiftUp, this.shiftDown);
        _copy(pictureHiBD.getPlaneData(1), pictureHiBD2.getPlaneData(1), 0, 1, 1, 2, pictureHiBD.getWidth() >> 1, pictureHiBD2.getWidth() >> 1, pictureHiBD.getHeight() >> 1, pictureHiBD2.getHeight(), this.shiftUp, this.shiftDown);
        _copy(pictureHiBD.getPlaneData(2), pictureHiBD2.getPlaneData(2), 0, 0, 1, 2, pictureHiBD.getWidth() >> 1, pictureHiBD2.getWidth() >> 1, pictureHiBD.getHeight() >> 1, pictureHiBD2.getHeight(), this.shiftUp, this.shiftDown);
        _copy(pictureHiBD.getPlaneData(2), pictureHiBD2.getPlaneData(2), 0, 1, 1, 2, pictureHiBD.getWidth() >> 1, pictureHiBD2.getWidth() >> 1, pictureHiBD.getHeight() >> 1, pictureHiBD2.getHeight(), this.shiftUp, this.shiftDown);
    }
}
