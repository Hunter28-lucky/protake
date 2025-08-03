package org.jcodec.scale;

import java.lang.reflect.Array;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public class RgbToYuv420j implements Transform {
    public static final void rgb2yuv(byte b, byte b2, byte b3, int[] iArr) {
        int i = b + BER.ASN_LONG_LEN;
        int i2 = b2 + BER.ASN_LONG_LEN;
        int i3 = b3 + BER.ASN_LONG_LEN;
        int i4 = (i * 77) + (i2 * 150) + (i3 * 15);
        iArr[0] = MathUtil.clip(((i4 + 128) >> 8) - 128, -128, 127);
        iArr[1] = MathUtil.clip(((((i * (-43)) - (i2 * 85)) + (i3 * 128)) + 128) >> 8, -128, 127);
        iArr[2] = MathUtil.clip(((((i * 128) - (i2 * 107)) - (i3 * 21)) + 128) >> 8, -128, 127);
    }

    @Override // org.jcodec.scale.Transform
    public void transform(Picture picture, Picture picture2) {
        byte[] bArr = picture.getData()[0];
        byte[][] data = picture2.getData();
        char c = 2;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, 3);
        char c2 = 3;
        int width = picture.getWidth() * 3;
        int width2 = picture2.getWidth();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = 1;
            if (i >= (picture.getHeight() >> 1)) {
                return;
            }
            int i6 = 0;
            while (i6 < (picture.getWidth() >> i5)) {
                data[i5][i2] = 0;
                data[c][i2] = 0;
                rgb2yuv(bArr[i4], bArr[i4 + 1], bArr[i4 + 2], iArr[0]);
                data[0][i3] = (byte) iArr[0][0];
                int i7 = i4 + width;
                int i8 = i;
                rgb2yuv(bArr[i7], bArr[i7 + 1], bArr[i7 + 2], iArr[i5]);
                data[0][i3 + width2] = (byte) iArr[i5][0];
                int i9 = i3 + 1;
                rgb2yuv(bArr[i4 + 3], bArr[i4 + 4], bArr[i4 + 5], iArr[2]);
                data[0][i9] = (byte) iArr[2][0];
                rgb2yuv(bArr[i7 + 3], bArr[i7 + 4], bArr[i7 + 5], iArr[3]);
                int[] iArr2 = iArr[3];
                data[0][i9 + width2] = (byte) iArr2[0];
                i3 = i9 + 1;
                byte[] bArr2 = data[1];
                int[] iArr3 = iArr[0];
                int i10 = iArr3[1];
                int[] iArr4 = iArr[1];
                int i11 = i10 + iArr4[1];
                int[] iArr5 = iArr[2];
                bArr2[i2] = (byte) ((((i11 + iArr5[1]) + iArr2[1]) + 2) >> 2);
                data[2][i2] = (byte) (((((iArr3[2] + iArr4[2]) + iArr5[2]) + iArr2[2]) + 2) >> 2);
                i2++;
                i4 += 6;
                i6++;
                i = i8;
                c2 = 3;
                i5 = 1;
                c = 2;
            }
            i3 += width2;
            i4 += width;
            i++;
        }
    }
}
