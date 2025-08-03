package org.jcodec.scale.highbd;

import org.jcodec.common.model.PictureHiBD;

/* loaded from: classes2.dex */
public class Yuv422pToYuv420pHiBD implements TransformHiBD {
    private int shiftDown;
    private int shiftUp;

    public Yuv422pToYuv420pHiBD(int i, int i2) {
        this.shiftUp = i;
        this.shiftDown = i2;
    }

    private void copyAvg(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2 / 2; i5++) {
            int i6 = 0;
            while (i6 < i) {
                iArr2[i4] = ((iArr[i3] + iArr[i3 + i]) + 1) >> 1;
                i6++;
                i4++;
                i3++;
            }
            i3 += i;
        }
    }

    private void down(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = iArr[i2] >> i;
        }
    }

    private void up(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = iArr[i2] << i;
        }
    }

    @Override // org.jcodec.scale.highbd.TransformHiBD
    public void transform(PictureHiBD pictureHiBD, PictureHiBD pictureHiBD2) {
        System.arraycopy(pictureHiBD.getPlaneData(0), 0, pictureHiBD2.getPlaneData(0), 0, pictureHiBD.getWidth() * pictureHiBD.getHeight());
        copyAvg(pictureHiBD.getPlaneData(1), pictureHiBD2.getPlaneData(1), pictureHiBD.getPlaneWidth(1), pictureHiBD.getPlaneHeight(1));
        copyAvg(pictureHiBD.getPlaneData(2), pictureHiBD2.getPlaneData(2), pictureHiBD.getPlaneWidth(2), pictureHiBD.getPlaneHeight(2));
        int i = this.shiftUp;
        int i2 = this.shiftDown;
        if (i > i2) {
            up(pictureHiBD2.getPlaneData(0), this.shiftUp - this.shiftDown);
            up(pictureHiBD2.getPlaneData(1), this.shiftUp - this.shiftDown);
            up(pictureHiBD2.getPlaneData(2), this.shiftUp - this.shiftDown);
        } else if (i2 > i) {
            down(pictureHiBD2.getPlaneData(0), this.shiftDown - this.shiftUp);
            down(pictureHiBD2.getPlaneData(1), this.shiftDown - this.shiftUp);
            down(pictureHiBD2.getPlaneData(2), this.shiftDown - this.shiftUp);
        }
    }
}
