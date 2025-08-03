package org.jcodec.codecs.h264.decode;

import org.jcodec.codecs.h264.H264Const;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class ChromaPredictionBuilder {
    public static void predictDC(int[][] iArr, int i, boolean z, boolean z2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        predictDCInside(iArr, 0, 0, i, z, z2, bArr, bArr2, bArr3);
        predictDCTopBorder(iArr, 1, 0, i, z, z2, bArr, bArr2, bArr3);
        predictDCLeftBorder(iArr, 0, 1, i, z, z2, bArr, bArr2, bArr3);
        predictDCInside(iArr, 1, 1, i, z, z2, bArr, bArr2, bArr3);
    }

    public static void predictDCInside(int[][] iArr, int i, int i2, int i3, boolean z, boolean z2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i4;
        int i5 = i << 2;
        int i6 = (i3 << 3) + i5;
        int i7 = i2 << 2;
        int i8 = 0;
        if (z && z2) {
            int i9 = 0;
            for (int i10 = 0; i10 < 4; i10++) {
                i9 += bArr[i10 + i7];
            }
            for (int i11 = 0; i11 < 4; i11++) {
                i9 += bArr2[i6 + i11];
            }
            i4 = (i9 + 4) >> 3;
        } else if (z) {
            int i12 = 0;
            for (int i13 = 0; i13 < 4; i13++) {
                i12 += bArr[i7 + i13];
            }
            i4 = (i12 + 2) >> 2;
        } else if (z2) {
            int i14 = 0;
            for (int i15 = 0; i15 < 4; i15++) {
                i14 += bArr2[i6 + i15];
            }
            i4 = (i14 + 2) >> 2;
        } else {
            i4 = 0;
        }
        int i16 = (i2 << 5) + i5;
        while (i8 < 4) {
            int[] iArr2 = H264Const.CHROMA_BLOCK_LUT;
            int[] iArr3 = iArr[iArr2[i16]];
            int[] iArr4 = H264Const.CHROMA_POS_LUT;
            bArr3[i16] = (byte) MathUtil.clip(iArr3[iArr4[i16]] + i4, -128, 127);
            int i17 = i16 + 1;
            bArr3[i17] = (byte) MathUtil.clip(iArr[iArr2[i17]][iArr4[i17]] + i4, -128, 127);
            int i18 = i16 + 2;
            bArr3[i18] = (byte) MathUtil.clip(iArr[iArr2[i18]][iArr4[i18]] + i4, -128, 127);
            int i19 = i16 + 3;
            bArr3[i19] = (byte) MathUtil.clip(iArr[iArr2[i19]][iArr4[i19]] + i4, -128, 127);
            i8++;
            i16 += 8;
        }
    }

    public static void predictDCLeftBorder(int[][] iArr, int i, int i2, int i3, boolean z, boolean z2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i4;
        int i5 = i << 2;
        int i6 = (i3 << 3) + i5;
        int i7 = i2 << 2;
        int i8 = 0;
        if (z) {
            int i9 = 0;
            for (int i10 = 0; i10 < 4; i10++) {
                i9 += bArr[i7 + i10];
            }
            i4 = (i9 + 2) >> 2;
        } else if (z2) {
            int i11 = 0;
            for (int i12 = 0; i12 < 4; i12++) {
                i11 += bArr2[i6 + i12];
            }
            i4 = (i11 + 2) >> 2;
        } else {
            i4 = 0;
        }
        int i13 = (i2 << 5) + i5;
        while (i8 < 4) {
            int[] iArr2 = H264Const.CHROMA_BLOCK_LUT;
            int[] iArr3 = iArr[iArr2[i13]];
            int[] iArr4 = H264Const.CHROMA_POS_LUT;
            bArr3[i13] = (byte) MathUtil.clip(iArr3[iArr4[i13]] + i4, -128, 127);
            int i14 = i13 + 1;
            bArr3[i14] = (byte) MathUtil.clip(iArr[iArr2[i14]][iArr4[i14]] + i4, -128, 127);
            int i15 = i13 + 2;
            bArr3[i15] = (byte) MathUtil.clip(iArr[iArr2[i15]][iArr4[i15]] + i4, -128, 127);
            int i16 = i13 + 3;
            bArr3[i16] = (byte) MathUtil.clip(iArr[iArr2[i16]][iArr4[i16]] + i4, -128, 127);
            i8++;
            i13 += 8;
        }
    }

    public static void predictDCTopBorder(int[][] iArr, int i, int i2, int i3, boolean z, boolean z2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i4;
        int i5 = i << 2;
        int i6 = (i3 << 3) + i5;
        int i7 = i2 << 2;
        int i8 = 0;
        if (z2) {
            int i9 = 0;
            for (int i10 = 0; i10 < 4; i10++) {
                i9 += bArr2[i6 + i10];
            }
            i4 = (i9 + 2) >> 2;
        } else if (z) {
            int i11 = 0;
            for (int i12 = 0; i12 < 4; i12++) {
                i11 += bArr[i7 + i12];
            }
            i4 = (i11 + 2) >> 2;
        } else {
            i4 = 0;
        }
        int i13 = (i2 << 5) + i5;
        while (i8 < 4) {
            int[] iArr2 = H264Const.CHROMA_BLOCK_LUT;
            int[] iArr3 = iArr[iArr2[i13]];
            int[] iArr4 = H264Const.CHROMA_POS_LUT;
            bArr3[i13] = (byte) MathUtil.clip(iArr3[iArr4[i13]] + i4, -128, 127);
            int i14 = i13 + 1;
            bArr3[i14] = (byte) MathUtil.clip(iArr[iArr2[i14]][iArr4[i14]] + i4, -128, 127);
            int i15 = i13 + 2;
            bArr3[i15] = (byte) MathUtil.clip(iArr[iArr2[i15]][iArr4[i15]] + i4, -128, 127);
            int i16 = i13 + 3;
            bArr3[i16] = (byte) MathUtil.clip(iArr[iArr2[i16]][iArr4[i16]] + i4, -128, 127);
            i8++;
            i13 += 8;
        }
    }

    public static void predictHorizontal(int[][] iArr, int i, boolean z, byte[] bArr, byte[] bArr2) {
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = 0;
            while (i4 < 8) {
                bArr2[i2] = (byte) MathUtil.clip(iArr[H264Const.CHROMA_BLOCK_LUT[i2]][H264Const.CHROMA_POS_LUT[i2]] + bArr[i3], -128, 127);
                i4++;
                i2++;
            }
        }
    }

    public static void predictPlane(int[][] iArr, int i, boolean z, boolean z2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int i2 = i << 3;
        int i3 = 0;
        int i4 = 0;
        while (i3 < 3) {
            int i5 = i3 + 1;
            i4 += (bArr2[(i2 + 4) + i3] - bArr2[(i2 + 2) - i3]) * i5;
            i3 = i5;
        }
        int i6 = i2 + 7;
        int i7 = i4 + ((bArr2[i6] - bArr3[0]) * 4);
        int i8 = 0;
        int i9 = 0;
        while (i8 < 3) {
            int i10 = i8 + 1;
            i9 += (bArr[i8 + 4] - bArr[2 - i8]) * i10;
            i8 = i10;
        }
        byte b = bArr[7];
        int i11 = (((i9 + ((b - bArr3[0]) * 4)) * 34) + 32) >> 6;
        int i12 = ((i7 * 34) + 32) >> 6;
        int i13 = (b + bArr2[i6]) * 16;
        int i14 = 0;
        for (int i15 = 0; i15 < 8; i15++) {
            int i16 = 0;
            while (i16 < 8) {
                bArr4[i14] = (byte) MathUtil.clip(iArr[H264Const.CHROMA_BLOCK_LUT[i14]][H264Const.CHROMA_POS_LUT[i14]] + MathUtil.clip((((((i16 - 3) * i12) + i13) + ((i15 - 3) * i11)) + 16) >> 5, -128, 127), -128, 127);
                i16++;
                i14++;
            }
        }
    }

    public static void predictVertical(int[][] iArr, int i, boolean z, byte[] bArr, byte[] bArr2) {
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = 0;
            while (i4 < 8) {
                bArr2[i2] = (byte) MathUtil.clip(iArr[H264Const.CHROMA_BLOCK_LUT[i2]][H264Const.CHROMA_POS_LUT[i2]] + bArr[(i << 3) + i4], -128, 127);
                i4++;
                i2++;
            }
        }
    }

    public static void predictWithMode(int[][] iArr, int i, int i2, boolean z, boolean z2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (i == 0) {
            predictDC(iArr, i2, z, z2, bArr, bArr2, bArr4);
            return;
        }
        if (i == 1) {
            predictHorizontal(iArr, i2, z, bArr, bArr4);
        } else if (i == 2) {
            predictVertical(iArr, i2, z2, bArr2, bArr4);
        } else {
            if (i != 3) {
                return;
            }
            predictPlane(iArr, i2, z, z2, bArr, bArr2, bArr3, bArr4);
        }
    }
}
