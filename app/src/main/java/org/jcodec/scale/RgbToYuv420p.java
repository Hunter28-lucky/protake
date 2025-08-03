package org.jcodec.scale;

import java.lang.reflect.Array;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public class RgbToYuv420p implements Transform {
    public static final void rgb2yuv(byte b, byte b2, byte b3, byte[] bArr) {
        int i = b + BER.ASN_LONG_LEN;
        int i2 = b2 + BER.ASN_LONG_LEN;
        int i3 = b3 + BER.ASN_LONG_LEN;
        int i4 = (i * 66) + (i2 * 129) + (i3 * 25);
        bArr[0] = (byte) MathUtil.clip(((i4 + 128) >> 8) - 112, -128, 127);
        bArr[1] = (byte) MathUtil.clip(((((i * (-38)) - (i2 * 74)) + (i3 * 112)) + 128) >> 8, -128, 127);
        bArr[2] = (byte) MathUtil.clip(((((i * 112) - (i2 * 94)) - (i3 * 18)) + 128) >> 8, -128, 127);
    }

    @Override // org.jcodec.scale.Transform
    public void transform(Picture picture, Picture picture2) {
        byte[] bArr = picture.getData()[0];
        byte[][] data = picture2.getData();
        char c = 2;
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 3);
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
                rgb2yuv(bArr[i4], bArr[i4 + 1], bArr[i4 + 2], bArr2[0]);
                data[0][i3] = bArr2[0][0];
                int i7 = i4 + width;
                int i8 = i;
                rgb2yuv(bArr[i7], bArr[i7 + 1], bArr[i7 + 2], bArr2[i5]);
                data[0][i3 + width2] = bArr2[i5][0];
                int i9 = i3 + 1;
                rgb2yuv(bArr[i4 + 3], bArr[i4 + 4], bArr[i4 + 5], bArr2[2]);
                data[0][i9] = bArr2[2][0];
                rgb2yuv(bArr[i7 + 3], bArr[i7 + 4], bArr[i7 + 5], bArr2[3]);
                byte[] bArr3 = bArr2[3];
                data[0][i9 + width2] = bArr3[0];
                i3 = i9 + 1;
                byte[] bArr4 = data[1];
                byte[] bArr5 = bArr2[0];
                byte b = bArr5[1];
                byte[] bArr6 = bArr2[1];
                int i10 = b + bArr6[1];
                byte[] bArr7 = bArr2[2];
                bArr4[i2] = (byte) ((((i10 + bArr7[1]) + bArr3[1]) + 2) >> 2);
                data[2][i2] = (byte) (((((bArr5[2] + bArr6[2]) + bArr7[2]) + bArr3[2]) + 2) >> 2);
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
