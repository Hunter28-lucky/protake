package org.jcodec.codecs.h264.decode;

import org.jcodec.codecs.h264.H264Const;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class Intra16x16PredictionBuilder {
    public static void predictDC(int[][] iArr, boolean z, boolean z2, byte[] bArr, byte[] bArr2, int i, byte[] bArr3) {
        int i2;
        int i3;
        if (z && z2) {
            int i4 = 0;
            for (int i5 = 0; i5 < 16; i5++) {
                i4 += bArr[i5];
            }
            for (int i6 = 0; i6 < 16; i6++) {
                i4 += bArr2[i + i6];
            }
            i2 = (i4 + 16) >> 5;
        } else {
            if (z) {
                i3 = 0;
                for (int i7 = 0; i7 < 16; i7++) {
                    i3 += bArr[i7];
                }
            } else if (z2) {
                i3 = 0;
                for (int i8 = 0; i8 < 16; i8++) {
                    i3 += bArr2[i + i8];
                }
            } else {
                i2 = 0;
            }
            i2 = (i3 + 8) >> 4;
        }
        for (int i9 = 0; i9 < 256; i9++) {
            bArr3[i9] = (byte) MathUtil.clip(iArr[H264Const.LUMA_4x4_BLOCK_LUT[i9]][H264Const.LUMA_4x4_POS_LUT[i9]] + i2, -128, 127);
        }
    }

    public static void predictHorizontal(int[][] iArr, boolean z, byte[] bArr, int i, byte[] bArr2) {
        int i2 = 0;
        for (int i3 = 0; i3 < 16; i3++) {
            int i4 = 0;
            while (i4 < 16) {
                bArr2[i2] = (byte) MathUtil.clip(iArr[H264Const.LUMA_4x4_BLOCK_LUT[i2]][H264Const.LUMA_4x4_POS_LUT[i2]] + bArr[i3], -128, 127);
                i4++;
                i2++;
            }
        }
    }

    public static void predictPlane(int[][] iArr, boolean z, boolean z2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 7) {
            int i4 = i2 + 1;
            i3 += (bArr2[(i + 8) + i2] - bArr2[(i + 6) - i2]) * i4;
            i2 = i4;
        }
        int i5 = i + 15;
        int i6 = i3 + ((bArr2[i5] - bArr3[0]) * 8);
        int i7 = 0;
        int i8 = 0;
        while (i7 < 7) {
            int i9 = i7 + 1;
            i8 += (bArr[i7 + 8] - bArr[6 - i7]) * i9;
            i7 = i9;
        }
        int i10 = bArr[15];
        int i11 = (((i8 + ((i10 - bArr3[0]) * 8)) * 5) + 32) >> 6;
        int i12 = ((i6 * 5) + 32) >> 6;
        int i13 = (i10 + bArr2[i5]) * 16;
        int i14 = 0;
        for (int i15 = 0; i15 < 16; i15++) {
            int i16 = 0;
            while (i16 < 16) {
                bArr4[i14] = (byte) MathUtil.clip(iArr[H264Const.LUMA_4x4_BLOCK_LUT[i14]][H264Const.LUMA_4x4_POS_LUT[i14]] + MathUtil.clip((((((i16 - 7) * i12) + i13) + ((i15 - 7) * i11)) + 16) >> 5, -128, 127), -128, 127);
                i16++;
                i14++;
            }
        }
    }

    public static void predictVertical(int[][] iArr, boolean z, byte[] bArr, int i, byte[] bArr2) {
        int i2 = 0;
        for (int i3 = 0; i3 < 16; i3++) {
            int i4 = 0;
            while (i4 < 16) {
                bArr2[i2] = (byte) MathUtil.clip(iArr[H264Const.LUMA_4x4_BLOCK_LUT[i2]][H264Const.LUMA_4x4_POS_LUT[i2]] + bArr[i + i4], -128, 127);
                i4++;
                i2++;
            }
        }
    }

    public static void predictWithMode(int i, int[][] iArr, boolean z, boolean z2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4) {
        if (i == 0) {
            predictVertical(iArr, z2, bArr2, i2, bArr4);
            return;
        }
        if (i == 1) {
            predictHorizontal(iArr, z, bArr, i2, bArr4);
        } else if (i == 2) {
            predictDC(iArr, z, z2, bArr, bArr2, i2, bArr4);
        } else {
            if (i != 3) {
                return;
            }
            predictPlane(iArr, z, z2, bArr, bArr2, bArr3, i2, bArr4);
        }
    }
}
