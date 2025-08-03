package org.jcodec.scale.highbd;

import org.jcodec.common.model.PictureHiBD;

/* loaded from: classes2.dex */
public class Yuv422pToYuv420jHiBD implements TransformHiBD {
    public static int COEFF = 9362;
    private int halfDst;
    private int halfSrc;
    private int shift;

    public Yuv422pToYuv420jHiBD(int i, int i2) {
        int i3 = i2 + 13;
        int i4 = i3 - i;
        this.shift = i4;
        if (i4 >= 0) {
            this.halfSrc = 128 << Math.max(i2 - i, 0);
            this.halfDst = 128 << Math.max(i - i2, 0);
        } else {
            throw new IllegalArgumentException("Maximum upshift allowed: " + i3);
        }
    }

    private void copyAvg(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2 / 2; i5++) {
            int i6 = 0;
            while (i6 < i) {
                int i7 = iArr[i3];
                int i8 = this.halfSrc;
                int i9 = COEFF;
                int i10 = this.shift;
                int i11 = this.halfDst;
                iArr2[i4] = ((((((i7 - i8) * i9) >> i10) + i11) + ((((iArr[i3 + i] - i8) * i9) >> i10) + i11)) + 1) >> 1;
                i6++;
                i4++;
                i3++;
            }
            i3 += i;
        }
    }

    @Override // org.jcodec.scale.highbd.TransformHiBD
    public void transform(PictureHiBD pictureHiBD, PictureHiBD pictureHiBD2) {
        int[] planeData = pictureHiBD.getPlaneData(0);
        int[] planeData2 = pictureHiBD2.getPlaneData(0);
        for (int i = 0; i < pictureHiBD.getPlaneWidth(0) * pictureHiBD.getPlaneHeight(0); i++) {
            planeData2[i] = ((planeData[i] - 16) * COEFF) >> this.shift;
        }
        copyAvg(pictureHiBD.getPlaneData(1), pictureHiBD2.getPlaneData(1), pictureHiBD.getPlaneWidth(1), pictureHiBD.getPlaneHeight(1));
        copyAvg(pictureHiBD.getPlaneData(2), pictureHiBD2.getPlaneData(2), pictureHiBD.getPlaneWidth(2), pictureHiBD.getPlaneHeight(2));
    }
}
