package org.jcodec.scale;

import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Size;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public abstract class BaseResampler {
    private Size fromSize;
    private final double scaleFactorX;
    private final double scaleFactorY;
    private final ThreadLocal<int[]> tempBuffers = new ThreadLocal<>();
    private Size toSize;

    public BaseResampler(Size size, Size size2) {
        this.toSize = size2;
        this.fromSize = size;
        this.scaleFactorX = size.getWidth() / size2.getWidth();
        this.scaleFactorY = size.getHeight() / size2.getHeight();
    }

    private static byte getPel(Picture picture, int i, int i2, int i3) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int planeWidth = picture.getPlaneWidth(i);
        int i4 = planeWidth - 1;
        if (i2 > i4) {
            i2 = i4;
        }
        int planeHeight = picture.getPlaneHeight(i) - 1;
        if (i3 > planeHeight) {
            i3 = planeHeight;
        }
        return picture.getData()[i][i2 + (i3 * planeWidth)];
    }

    public static void normalizeAndGenerateFixedPrecision(double[] dArr, int i, short[] sArr) {
        double d = 0.0d;
        for (double d2 : dArr) {
            d += d2;
        }
        int i2 = 1 << i;
        int i3 = 0;
        for (int i4 = 0; i4 < dArr.length; i4++) {
            double d3 = i2;
            double d4 = ((dArr[i4] * d3) / d) + d3;
            int i5 = (int) d4;
            dArr[i4] = d4 - i5;
            short s = (short) (i5 - i2);
            sArr[i4] = s;
            i3 += s;
        }
        long j = 0;
        while (i3 < i2) {
            int i6 = -1;
            for (int i7 = 0; i7 < dArr.length; i7++) {
                if (((1 << i7) & j) == 0 && (i6 == -1 || dArr[i7] > dArr[i6])) {
                    i6 = i7;
                }
            }
            sArr[i6] = (short) (sArr[i6] + 1);
            i3++;
            j |= 1 << i6;
        }
        for (int i8 = 0; i8 < dArr.length; i8++) {
            double d5 = dArr[i8] + sArr[i8];
            dArr[i8] = d5;
            if (((1 << i8) & j) != 0) {
                dArr[i8] = d5 - 1.0d;
            }
        }
    }

    public abstract short[] getTapsX(int i);

    public abstract short[] getTapsY(int i);

    public abstract int nTaps();

    public void resample(Picture picture, Picture picture2) {
        int[] iArr = this.tempBuffers.get();
        int iNTaps = nTaps();
        if (iArr == null) {
            iArr = new int[this.toSize.getWidth() * (this.fromSize.getHeight() + iNTaps)];
            this.tempBuffers.set(iArr);
        }
        for (int i = 0; i < picture.getColor().nComp; i++) {
            for (int i2 = 0; i2 < picture.getPlaneHeight(i) + iNTaps; i2++) {
                for (int i3 = 0; i3 < picture2.getPlaneWidth(i); i3++) {
                    short[] tapsX = getTapsX(i3);
                    int i4 = iNTaps / 2;
                    int i5 = (((int) (this.scaleFactorX * i3)) - i4) + 1;
                    int pel = 0;
                    for (int i6 = 0; i6 < iNTaps; i6++) {
                        pel += (getPel(picture, i, i5 + i6, (i2 - i4) + 1) + BER.ASN_LONG_LEN) * tapsX[i6];
                    }
                    iArr[(this.toSize.getWidth() * i2) + i3] = pel;
                }
            }
            for (int i7 = 0; i7 < picture2.getPlaneHeight(i); i7++) {
                for (int i8 = 0; i8 < picture2.getPlaneWidth(i); i8++) {
                    short[] tapsY = getTapsY(i7);
                    int i9 = (int) (this.scaleFactorY * i7);
                    int i10 = 0;
                    for (int i11 = 0; i11 < iNTaps; i11++) {
                        i10 += iArr[((i9 + i11) * this.toSize.getWidth()) + i8] * tapsY[i11];
                    }
                    picture2.getPlaneData(i)[(picture2.getPlaneWidth(i) * i7) + i8] = (byte) (MathUtil.clip((i10 + 8192) >> 14, 0, 255) - 128);
                }
            }
        }
    }
}
