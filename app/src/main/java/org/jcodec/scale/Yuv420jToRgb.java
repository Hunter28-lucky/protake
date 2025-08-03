package org.jcodec.scale;

import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public class Yuv420jToRgb implements Transform {
    private static final int ONE_HALF = 512;
    private static final int SCALEBITS = 10;
    private static final int FIX_0_71414 = FIX(0.71414d);
    private static final int FIX_1_772 = FIX(1.772d);
    private static final int _FIX_0_34414 = -FIX(0.34414d);
    private static final int FIX_1_402 = FIX(1.402d);

    private static final int FIX(double d) {
        return (int) ((d * 1024.0d) + 0.5d);
    }

    public static final void YUVJtoRGB(byte b, byte b2, byte b3, byte[] bArr, int i) {
        int i2 = (b + BER.ASN_LONG_LEN) << 10;
        int i3 = (FIX_1_402 * b3) + 512;
        int i4 = ((_FIX_0_34414 * b2) - (FIX_0_71414 * b3)) + 512;
        int i5 = (FIX_1_772 * b2) + 512;
        bArr[i] = (byte) MathUtil.clip(((i3 + i2) >> 10) - 128, -128, 127);
        bArr[i + 1] = (byte) MathUtil.clip(((i4 + i2) >> 10) - 128, -128, 127);
        bArr[i + 2] = (byte) MathUtil.clip(((i2 + i5) >> 10) - 128, -128, 127);
    }

    @Override // org.jcodec.scale.Transform
    public final void transform(Picture picture, Picture picture2) {
        int i = 0;
        byte[] planeData = picture.getPlaneData(0);
        byte[] planeData2 = picture.getPlaneData(1);
        byte[] planeData3 = picture.getPlaneData(2);
        byte[] planeData4 = picture2.getPlaneData(0);
        int width = picture2.getWidth();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < (picture2.getHeight() >> 1)) {
            for (int i5 = i; i5 < (picture2.getWidth() >> 1); i5++) {
                int i6 = (i5 << 1) + i3;
                YUVJtoRGB(planeData[i6], planeData2[i4], planeData3[i4], planeData4, i6 * 3);
                int i7 = i6 + 1;
                YUVJtoRGB(planeData[i7], planeData2[i4], planeData3[i4], planeData4, i7 * 3);
                int i8 = i6 + width;
                YUVJtoRGB(planeData[i8], planeData2[i4], planeData3[i4], planeData4, i8 * 3);
                int i9 = i8 + 1;
                YUVJtoRGB(planeData[i9], planeData2[i4], planeData3[i4], planeData4, i9 * 3);
                i4++;
            }
            if ((picture2.getWidth() & 1) != 0) {
                int width2 = (picture2.getWidth() - 1) + i3;
                YUVJtoRGB(planeData[width2], planeData2[i4], planeData3[i4], planeData4, width2 * 3);
                int i10 = width2 + width;
                YUVJtoRGB(planeData[i10], planeData2[i4], planeData3[i4], planeData4, i10 * 3);
                i4++;
            }
            i3 += width * 2;
            i2++;
            i = 0;
        }
        if ((picture2.getHeight() & 1) != 0) {
            for (int i11 = 0; i11 < (picture2.getWidth() >> 1); i11++) {
                int i12 = (i11 << 1) + i3;
                YUVJtoRGB(planeData[i12], planeData2[i4], planeData3[i4], planeData4, i12 * 3);
                int i13 = i12 + 1;
                YUVJtoRGB(planeData[i13], planeData2[i4], planeData3[i4], planeData4, i13 * 3);
                i4++;
            }
            if ((picture2.getWidth() & 1) != 0) {
                int width3 = i3 + (picture2.getWidth() - 1);
                YUVJtoRGB(planeData[width3], planeData2[i4], planeData3[i4], planeData4, width3 * 3);
            }
        }
    }
}
