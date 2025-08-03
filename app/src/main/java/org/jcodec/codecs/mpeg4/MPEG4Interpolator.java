package org.jcodec.codecs.mpeg4;

import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class MPEG4Interpolator {
    private static byte[] qpi = new byte[272];

    public static final void fulpel16x16(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5) {
        if (i >= 0 && i2 >= 0 && i <= i3 - 16 && i2 <= i4 - 16) {
            int i6 = (i2 * i5) + i;
            for (int i7 = 0; i7 < 16; i7++) {
                for (int i8 = 0; i8 < 16; i8++) {
                    bArr[(i7 << 4) + i8] = bArr2[(i7 * i5) + i8 + i6];
                }
            }
            return;
        }
        for (int i9 = 0; i9 < 16; i9++) {
            for (int i10 = 0; i10 < 16; i10++) {
                bArr[(i9 << 4) + i10] = bArr2[(MathUtil.clip(i2 + i9, 0, i4 - 1) * i5) + MathUtil.clip(i + i10, 0, i3 - 1)];
            }
        }
    }

    public static final void fulpel8x8(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7) {
        if (i3 < 0 || i4 < 0 || i3 > i5 - 8 || i4 > i6 - 8) {
            int i8 = 0;
            while (i8 < 8) {
                for (int i9 = 0; i9 < 8; i9++) {
                    bArr[i + i9] = bArr2[(MathUtil.clip(i4 + i8, 0, i6 - 1) * i7) + MathUtil.clip(i3 + i9, 0, i5 - 1)];
                }
                i8++;
                i += i2;
            }
            return;
        }
        int i10 = (i4 * i7) + i3;
        int i11 = 0;
        while (i11 < 8) {
            for (int i12 = 0; i12 < 8; i12++) {
                bArr[i + i12] = bArr2[i10 + i12];
            }
            i11++;
            i += i2;
            i10 += i7;
        }
    }

    private static final void horzMiddle16(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = 8;
        int i9 = 4;
        if (i >= 0 && i2 >= 0 && i <= i3 - 17 && i2 <= i4 - i5) {
            int i10 = (i2 * i6) + i;
            int i11 = 0;
            for (int i12 = 0; i12 < i5; i12++) {
                for (int i13 = 0; i13 < 4; i13++) {
                    int i14 = 0;
                    int i15 = 0;
                    for (int i16 = 0; i16 < i13 + 5; i16++) {
                        int i17 = MPEG4Consts.FILTER_TAB[i13][i16];
                        i14 += bArr2[i10 + i16] * i17;
                        i15 += i17 * bArr2[(i10 + 16) - i16];
                    }
                    bArr[i11 + i13] = (byte) MathUtil.clip(((i14 + 16) - i7) >> 5, -128, 127);
                    bArr[(i11 + 15) - i13] = (byte) MathUtil.clip(((i15 + 16) - i7) >> 5, -128, 127);
                }
                for (int i18 = 0; i18 < 8; i18++) {
                    int i19 = 0;
                    for (int i20 = 0; i20 < 8; i20++) {
                        i19 += MPEG4Consts.FILTER_TAB[3][i20] * bArr2[i10 + i20 + i18 + 1];
                    }
                    bArr[i11 + i18 + 4] = (byte) MathUtil.clip(((i19 + 16) - i7) >> 5, -128, 127);
                }
                i10 += i6;
                i11 += 16;
            }
            return;
        }
        int i21 = 0;
        int i22 = 0;
        while (i21 < i5) {
            int iClip = MathUtil.clip(i2 + i21, 0, i4 - 1) * i6;
            int i23 = 0;
            while (i23 < i9) {
                int i24 = 0;
                int i25 = 0;
                for (int i26 = 0; i26 < i23 + 5; i26++) {
                    int i27 = i3 - 1;
                    int iClip2 = MathUtil.clip(i + i26, 0, i27) + iClip;
                    int iClip3 = MathUtil.clip((i + 16) - i26, 0, i27) + iClip;
                    int i28 = MPEG4Consts.FILTER_TAB[i23][i26];
                    i24 += bArr2[iClip2] * i28;
                    i25 += i28 * bArr2[iClip3];
                }
                bArr[i22 + i23] = (byte) MathUtil.clip(((i24 + 16) - i7) >> 5, -128, 127);
                bArr[(i22 + 15) - i23] = (byte) MathUtil.clip(((i25 + 16) - i7) >> 5, -128, 127);
                i23++;
                i8 = 8;
                i9 = 4;
            }
            for (int i29 = 0; i29 < i8; i29++) {
                int i30 = 0;
                for (int i31 = 0; i31 < i8; i31++) {
                    i30 += MPEG4Consts.FILTER_TAB[3][i31] * bArr2[MathUtil.clip(i + i31 + i29 + 1, 0, i3 - 1) + iClip];
                }
                bArr[i22 + i29 + 4] = (byte) MathUtil.clip(((i30 + 16) - i7) >> 5, -128, 127);
            }
            i22 += 16;
            i21++;
            i9 = 4;
        }
    }

    private static final void horzMiddle8(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = 4;
        if (i2 >= 0 && i3 >= 0 && i2 <= i4 - 9 && i3 <= i5 - i6) {
            int i10 = (i3 * i7) + i2;
            int i11 = i;
            for (int i12 = 0; i12 < i6; i12++) {
                for (int i13 = 0; i13 < 4; i13++) {
                    int i14 = 0;
                    int i15 = 0;
                    for (int i16 = 0; i16 < i13 + 5; i16++) {
                        int i17 = MPEG4Consts.FILTER_TAB[i13][i16];
                        i14 += bArr2[i10 + i16] * i17;
                        i15 += i17 * bArr2[(i10 + 8) - i16];
                    }
                    bArr[i11 + i13] = (byte) MathUtil.clip(((i14 + 16) - i8) >> 5, -128, 127);
                    bArr[(i11 + 7) - i13] = (byte) MathUtil.clip(((i15 + 16) - i8) >> 5, -128, 127);
                }
                i10 += i7;
                i11 += 16;
            }
            return;
        }
        int i18 = i;
        int i19 = 0;
        while (i19 < i6) {
            int i20 = 0;
            while (i20 < i9) {
                int iClip = MathUtil.clip(i3 + i19, 0, i5 - 1) * i7;
                int i21 = 0;
                int i22 = 0;
                for (int i23 = 0; i23 < i20 + 5; i23++) {
                    int i24 = i4 - 1;
                    int iClip2 = MathUtil.clip(i2 + i23, 0, i24);
                    int iClip3 = MathUtil.clip((i2 + 8) - i23, 0, i24);
                    int i25 = MPEG4Consts.FILTER_TAB[i20][i23];
                    i21 += bArr2[iClip2 + iClip] * i25;
                    i22 += i25 * bArr2[iClip3 + iClip];
                }
                bArr[i18 + i20] = (byte) MathUtil.clip(((i21 + 16) - i8) >> 5, -128, 127);
                bArr[(i18 + 7) - i20] = (byte) MathUtil.clip(((i22 + 16) - i8) >> 5, -128, 127);
                i20++;
                i9 = 4;
            }
            i18 += 16;
            i19++;
            i9 = 4;
        }
    }

    public static final void interpolate16x16Planar(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        interpolate8x8Planar(bArr, 0, 16, bArr2, i, i2, i3, i4, i5, i6, i7, z);
        int i8 = i + 8;
        interpolate8x8Planar(bArr, 8, 16, bArr2, i8, i2, i3, i4, i5, i6, i7, z);
        int i9 = i2 + 8;
        interpolate8x8Planar(bArr, 128, 16, bArr2, i, i9, i3, i4, i5, i6, i7, z);
        interpolate8x8Planar(bArr, 136, 16, bArr2, i8, i9, i3, i4, i5, i6, i7, z);
    }

    public static final void interpolate16x16QP(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        int i8 = (i * 4) + i5;
        int i9 = (i2 * 4) + i6;
        int i10 = (i5 & 3) | ((i6 & 3) << 2);
        int i11 = i8 / 4;
        if (i8 < 0 && (i8 & 3) != 0) {
            i11--;
        }
        int i12 = i9 / 4;
        if (i9 < 0 && (i9 & 3) != 0) {
            i12--;
        }
        switch (i10) {
            case 0:
                fulpel16x16(bArr, bArr2, i11, i12, i3, i4, i7);
                break;
            case 1:
                horzMiddle16(bArr, bArr2, i11, i12, i3, i4, 16, i7, z ? 1 : 0);
                qOff(bArr, bArr2, i11, i12, i3, i4, 16, i7, z ? 1 : 0);
                break;
            case 2:
                horzMiddle16(bArr, bArr2, i11, i12, i3, i4, 16, i7, z ? 1 : 0);
                break;
            case 3:
                horzMiddle16(bArr, bArr2, i11, i12, i3, i4, 16, i7, z ? 1 : 0);
                qOff(bArr, bArr2, i11 + 1, i12, i3, i4, 16, i7, z ? 1 : 0);
                break;
            case 4:
                vertMiddle16(bArr, bArr2, i11, i12, i3, i4, 16, i7, z ? 1 : 0);
                qOff(bArr, bArr2, i11, i12, i3, i4, 16, i7, z ? 1 : 0);
                break;
            case 5:
                horzMiddle16(qpi, bArr2, i11, i12, i3, i4, 17, i7, z ? 1 : 0);
                qOff(qpi, bArr2, i11, i12, i3, i4, 17, i7, z ? 1 : 0);
                vertMiddle16Safe(bArr, qpi, 0, 16, 16, z ? 1 : 0);
                qOffSafe(bArr, qpi, 0, 16, 16, z ? 1 : 0);
                break;
            case 6:
                horzMiddle16(qpi, bArr2, i11, i12, i3, i4, 17, i7, z ? 1 : 0);
                vertMiddle16Safe(bArr, qpi, 0, 16, 16, z ? 1 : 0);
                qOffSafe(bArr, qpi, 0, 16, 16, z ? 1 : 0);
                break;
            case 7:
                horzMiddle16(qpi, bArr2, i11, i12, i3, i4, 17, i7, z ? 1 : 0);
                qOff(qpi, bArr2, i11 + 1, i12, i3, i4, 17, i7, z ? 1 : 0);
                vertMiddle16Safe(bArr, qpi, 0, 16, 16, z ? 1 : 0);
                qOffSafe(bArr, qpi, 0, 16, 16, z ? 1 : 0);
                break;
            case 8:
                vertMiddle16(bArr, bArr2, i11, i12, i3, i4, 16, i7, z ? 1 : 0);
                break;
            case 9:
                horzMiddle16(qpi, bArr2, i11, i12, i3, i4, 17, i7, z ? 1 : 0);
                qOff(qpi, bArr2, i11, i12, i3, i4, 17, i7, z ? 1 : 0);
                vertMiddle16Safe(bArr, qpi, 0, 16, 16, z ? 1 : 0);
                break;
            case 10:
                horzMiddle16(qpi, bArr2, i11, i12, i3, i4, 17, i7, z ? 1 : 0);
                vertMiddle16Safe(bArr, qpi, 0, 16, 16, z ? 1 : 0);
                break;
            case 11:
                horzMiddle16(qpi, bArr2, i11, i12, i3, i4, 17, i7, z ? 1 : 0);
                qOff(qpi, bArr2, i11 + 1, i12, i3, i4, 17, i7, z ? 1 : 0);
                vertMiddle16Safe(bArr, qpi, 0, 16, 16, z ? 1 : 0);
                break;
            case 12:
                vertMiddle16(bArr, bArr2, i11, i12, i3, i4, 16, i7, z ? 1 : 0);
                qOff(bArr, bArr2, i11, i12 + 1, i3, i4, 16, i7, z ? 1 : 0);
                break;
            case 13:
                horzMiddle16(qpi, bArr2, i11, i12, i3, i4, 17, i7, z ? 1 : 0);
                qOff(qpi, bArr2, i11, i12, i3, i4, 17, i7, z ? 1 : 0);
                vertMiddle16Safe(bArr, qpi, 0, 16, 16, z ? 1 : 0);
                qOffSafe(bArr, qpi, 16, 16, 16, z ? 1 : 0);
                break;
            case 14:
                horzMiddle16(qpi, bArr2, i11, i12, i3, i4, 17, i7, z ? 1 : 0);
                vertMiddle16Safe(bArr, qpi, 0, 16, 16, z ? 1 : 0);
                qOffSafe(bArr, qpi, 16, 16, 16, z ? 1 : 0);
                break;
            case 15:
                horzMiddle16(qpi, bArr2, i11, i12, i3, i4, 17, i7, z ? 1 : 0);
                qOff(qpi, bArr2, i11 + 1, i12, i3, i4, 17, i7, z ? 1 : 0);
                vertMiddle16Safe(bArr, qpi, 0, 16, 16, z ? 1 : 0);
                qOffSafe(bArr, qpi, 16, 16, 16, z ? 1 : 0);
                break;
        }
    }

    private static final void interpolate8PlanarVer(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        int i8 = !z ? 1 : 0;
        if (i3 >= 0 && i4 >= 0 && i3 <= i5 - 8 && i4 <= i6 - 9) {
            int i9 = (i4 * i7) + i3;
            int i10 = i;
            int i11 = 0;
            while (i11 < i7 * 8) {
                for (int i12 = 0; i12 < 8; i12++) {
                    int i13 = i9 + i11;
                    bArr[i10 + i12] = (byte) (((bArr2[i13 + i12] + bArr2[(i13 + i7) + i12]) + i8) >> 1);
                }
                i11 += i7;
                i10 += i2;
            }
            return;
        }
        int i14 = i;
        int i15 = 0;
        while (i15 < 8) {
            for (int i16 = 0; i16 < 8; i16++) {
                int i17 = i4 + i15;
                int i18 = i6 - 1;
                int i19 = i3 + i16;
                int i20 = i5 - 1;
                bArr[i14 + i16] = (byte) (((bArr2[(MathUtil.clip(i17, 0, i18) * i7) + MathUtil.clip(i19, 0, i20)] + bArr2[(MathUtil.clip(i17 + 1, 0, i18) * i7) + MathUtil.clip(i19, 0, i20)]) + i8) >> 1);
            }
            i15++;
            i14 += i2;
        }
    }

    public static final void interpolate8x8Planar(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        int i10 = i3 + (i7 >> 1);
        int i11 = i4 + (i8 >> 1);
        int i12 = ((i7 & 1) << 1) + (i8 & 1);
        if (i12 == 0) {
            fulpel8x8(bArr, i, i2, bArr2, i10, i11, i5, i6, i9);
            return;
        }
        if (i12 == 1) {
            interpolate8PlanarVer(bArr, i, i2, bArr2, i10, i11, i5, i6, i9, z);
        } else if (i12 != 2) {
            interpolate8x8PlanarBoth(bArr, i, i2, bArr2, i10, i11, i5, i6, i9, z);
        } else {
            interpolate8x8PlanarHor(bArr, i, i2, bArr2, i10, i11, i5, i6, i9, z);
        }
    }

    private static final void interpolate8x8PlanarBoth(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        int i8 = z ? 1 : 2;
        int i9 = 8;
        if (i3 >= 0 && i4 >= 0 && i3 <= i5 - 9 && i4 <= i6 - 9) {
            int i10 = (i4 * i7) + i3;
            int i11 = i;
            int i12 = 0;
            while (i12 < i7 * 8) {
                for (int i13 = 0; i13 < 8; i13++) {
                    int i14 = i10 + i12;
                    int i15 = i14 + i13;
                    int i16 = i14 + i7 + i13;
                    bArr[i11 + i13] = (byte) (((((bArr2[i15] + bArr2[i15 + 1]) + bArr2[i16]) + bArr2[i16 + 1]) + i8) >> 2);
                }
                i12 += i7;
                i11 += i2;
            }
            return;
        }
        int i17 = i;
        int i18 = 0;
        while (i18 < i9) {
            int i19 = 0;
            while (i19 < i9) {
                int i20 = i4 + i18;
                int i21 = i6 - 1;
                int i22 = i3 + i19;
                int i23 = i5 - 1;
                int iClip = (MathUtil.clip(i20, 0, i21) * i7) + MathUtil.clip(i22, 0, i23);
                int i24 = i22 + 1;
                int iClip2 = (MathUtil.clip(i20, 0, i21) * i7) + MathUtil.clip(i24, 0, i23);
                int i25 = i20 + 1;
                bArr[i17 + i19] = (byte) (((((bArr2[iClip] + bArr2[iClip2]) + bArr2[(MathUtil.clip(i25, 0, i21) * i7) + MathUtil.clip(i22, 0, i23)]) + bArr2[(MathUtil.clip(i25, 0, i21) * i7) + MathUtil.clip(i24, 0, i23)]) + i8) >> 2);
                i19++;
                i9 = 8;
            }
            i18++;
            i17 += i2;
            i9 = 8;
        }
    }

    private static final void interpolate8x8PlanarHor(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        int i8 = !z ? 1 : 0;
        if (i3 >= 0 && i4 >= 0 && i3 <= i5 - 9 && i4 <= i6 - 8) {
            int i9 = (i4 * i7) + i3;
            int i10 = i;
            int i11 = 0;
            while (i11 < i7 * 8) {
                for (int i12 = 0; i12 < 8; i12++) {
                    int i13 = i9 + i11 + i12;
                    bArr[i10 + i12] = (byte) (((bArr2[i13] + bArr2[i13 + 1]) + i8) >> 1);
                }
                i11 += i7;
                i10 += i2;
            }
            return;
        }
        int i14 = i;
        int i15 = 0;
        while (i15 < 8) {
            for (int i16 = 0; i16 < 8; i16++) {
                int i17 = i4 + i15;
                int i18 = i6 - 1;
                int i19 = i3 + i16;
                int i20 = i5 - 1;
                bArr[i14 + i16] = (byte) (((bArr2[(MathUtil.clip(i17, 0, i18) * i7) + MathUtil.clip(i19, 0, i20)] + bArr2[(MathUtil.clip(i17, 0, i18) * i7) + MathUtil.clip(i19 + 1, 0, i20)]) + i8) >> 1);
            }
            i15++;
            i14 += i2;
        }
    }

    public static final void interpolate8x8QP(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        int i9 = (i2 * 4) + i6;
        int i10 = (i3 * 4) + i7;
        int i11 = (i6 & 3) | ((i7 & 3) << 2);
        int i12 = i9 / 4;
        if (i9 < 0 && i9 % 4 != 0) {
            i12--;
        }
        int i13 = i10 / 4;
        if (i10 < 0 && i10 % 4 != 0) {
            i13--;
        }
        switch (i11) {
            case 0:
                fulpel8x8(bArr, i, 16, bArr2, i12, i13, i4, i5, i8);
                break;
            case 1:
                horzMiddle8(bArr, i, bArr2, i12, i13, i4, i5, 8, i8, z ? 1 : 0);
                qOff8x8(bArr, i, bArr2, i12, i13, i4, i5, 8, i8, z ? 1 : 0);
                break;
            case 2:
                horzMiddle8(bArr, i, bArr2, i12, i13, i4, i5, 8, i8, z ? 1 : 0);
                break;
            case 3:
                horzMiddle8(bArr, i, bArr2, i12, i13, i4, i5, 8, i8, z ? 1 : 0);
                qOff8x8(bArr, i, bArr2, i12 + 1, i13, i4, i5, 8, i8, z ? 1 : 0);
                break;
            case 4:
                vertMiddle8(bArr, i, bArr2, i12, i13, i4, i5, 8, i8, z ? 1 : 0);
                qOff8x8(bArr, i, bArr2, i12, i13, i4, i5, 8, i8, z ? 1 : 0);
                break;
            case 5:
                horzMiddle8(qpi, 0, bArr2, i12, i13, i4, i5, 9, i8, z ? 1 : 0);
                qOff8x8(qpi, 0, bArr2, i12, i13, i4, i5, 9, i8, z ? 1 : 0);
                vertMiddle8Safe(bArr, i, qpi, 0, 8, 16, z ? 1 : 0);
                qOff8x8Safe(bArr, i, qpi, 0, 8, 16, z ? 1 : 0);
                break;
            case 6:
                horzMiddle8(qpi, 0, bArr2, i12, i13, i4, i5, 9, i8, z ? 1 : 0);
                vertMiddle8Safe(bArr, i, qpi, 0, 8, 16, z ? 1 : 0);
                qOff8x8Safe(bArr, i, qpi, 0, 8, 16, z ? 1 : 0);
                break;
            case 7:
                horzMiddle8(qpi, 0, bArr2, i12, i13, i4, i5, 9, i8, z ? 1 : 0);
                qOff8x8(qpi, 0, bArr2, i12 + 1, i13, i4, i5, 9, i8, z ? 1 : 0);
                vertMiddle8Safe(bArr, i, qpi, 0, 8, 16, z ? 1 : 0);
                qOff8x8Safe(bArr, i, qpi, 0, 8, 16, z ? 1 : 0);
                break;
            case 8:
                vertMiddle8(bArr, i, bArr2, i12, i13, i4, i5, 8, i8, z ? 1 : 0);
                break;
            case 9:
                horzMiddle8(qpi, 0, bArr2, i12, i13, i4, i5, 9, i8, z ? 1 : 0);
                qOff8x8(qpi, 0, bArr2, i12, i13, i4, i5, 9, i8, z ? 1 : 0);
                vertMiddle8Safe(bArr, i, qpi, 0, 8, 16, z ? 1 : 0);
                break;
            case 10:
                horzMiddle8(qpi, 0, bArr2, i12, i13, i4, i5, 9, i8, z ? 1 : 0);
                vertMiddle8Safe(bArr, i, qpi, 0, 8, 16, z ? 1 : 0);
                break;
            case 11:
                horzMiddle8(qpi, 0, bArr2, i12, i13, i4, i5, 9, i8, z ? 1 : 0);
                qOff8x8(qpi, 0, bArr2, i12 + 1, i13, i4, i5, 9, i8, z ? 1 : 0);
                vertMiddle8Safe(bArr, i, qpi, 0, 8, 16, z ? 1 : 0);
                break;
            case 12:
                vertMiddle8(bArr, i, bArr2, i12, i13, i4, i5, 8, i8, z ? 1 : 0);
                qOff8x8(bArr, i, bArr2, i12, i13 + 1, i4, i5, 8, i8, z ? 1 : 0);
                break;
            case 13:
                horzMiddle8(qpi, 0, bArr2, i12, i13, i4, i5, 9, i8, z ? 1 : 0);
                qOff8x8(qpi, 0, bArr2, i12, i13, i4, i5, 9, i8, z ? 1 : 0);
                vertMiddle8Safe(bArr, i, qpi, 0, 8, 16, z ? 1 : 0);
                qOff8x8Safe(bArr, i, qpi, 16, 8, 16, z ? 1 : 0);
                break;
            case 14:
                horzMiddle8(qpi, 0, bArr2, i12, i13, i4, i5, 9, i8, z ? 1 : 0);
                vertMiddle8Safe(bArr, i, qpi, 0, 8, 16, z ? 1 : 0);
                qOff8x8Safe(bArr, i, qpi, 16, 8, 16, z ? 1 : 0);
                break;
            case 15:
                horzMiddle8(qpi, 0, bArr2, i12, i13, i4, i5, 9, i8, z ? 1 : 0);
                qOff8x8(qpi, 0, bArr2, i12 + 1, i13, i4, i5, 9, i8, z ? 1 : 0);
                vertMiddle8Safe(bArr, i, qpi, 0, 8, 16, z ? 1 : 0);
                qOff8x8Safe(bArr, i, qpi, 16, 8, 16, z ? 1 : 0);
                break;
        }
    }

    private static void qOff(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i >= 0 && i2 >= 0 && i <= i3 - 16 && i2 <= i4 - i5) {
            qOffSafe(bArr, bArr2, (i2 * i6) + i, i5, i6, i7);
            return;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < i5; i9++) {
            int iClip = MathUtil.clip(i2 + i9, 0, i4 - 1) * i6;
            int i10 = 0;
            while (i10 < 16) {
                bArr[i8] = (byte) (((bArr[i8] + bArr2[MathUtil.clip(i + i10, 0, i3 - 1) + iClip]) + 1) >> 1);
                i10++;
                i8++;
            }
        }
    }

    private static void qOff8x8(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i2 >= 0 && i3 >= 0 && i2 <= i4 - 8 && i3 <= i5 - i6) {
            qOff8x8Safe(bArr, i, bArr2, (i3 * i7) + i2, i6, i7, i8);
            return;
        }
        int i9 = i;
        int i10 = 0;
        while (i10 < i6) {
            int iClip = MathUtil.clip(i3 + i10, 0, i5 - 1) * i7;
            int i11 = 0;
            while (i11 < 8) {
                bArr[i9] = (byte) (((bArr[i9] + bArr2[MathUtil.clip(i2 + i11, 0, i4 - 1) + iClip]) + 1) >> 1);
                i11++;
                i9++;
            }
            i10++;
            i9 += 8;
        }
    }

    private static void qOff8x8Safe(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        while (i6 < i3) {
            int i7 = 0;
            while (i7 < 8) {
                bArr[i] = (byte) (((bArr[i] + bArr2[i2 + i7]) + 1) >> 1);
                i7++;
                i++;
            }
            i6++;
            i2 += i4;
            i += 8;
        }
    }

    private static void qOffSafe(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        while (i5 < i2) {
            int i7 = 0;
            while (i7 < 16) {
                bArr[i6] = (byte) (((bArr[i6] + bArr2[i + i7]) + 1) >> 1);
                i7++;
                i6++;
            }
            i5++;
            i += i3;
        }
    }

    private static final void vertMiddle16(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i5;
        if (i >= 0 && i2 >= 0 && i <= i3 - i8 && i2 <= i4 - 17) {
            vertMiddle16Safe(bArr, bArr2, (i2 * i6) + i, i5, i6, i7);
            return;
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int i11 = i10 + 240;
            int i12 = 0;
            int i13 = i10;
            while (i12 < 4) {
                int i14 = 0;
                int i15 = 0;
                for (int i16 = 0; i16 < i12 + 5; i16++) {
                    int i17 = i4 - 1;
                    int i18 = i + i9;
                    int i19 = i3 - 1;
                    int iClip = (MathUtil.clip(i2 + i16, 0, i17) * i6) + MathUtil.clip(i18, 0, i19);
                    int iClip2 = (MathUtil.clip((i2 - i16) + 16, 0, i17) * i6) + MathUtil.clip(i18, 0, i19);
                    int i20 = MPEG4Consts.FILTER_TAB[i12][i16];
                    i14 += bArr2[iClip] * i20;
                    i15 += i20 * bArr2[iClip2];
                }
                bArr[i13] = (byte) MathUtil.clip(((i14 + 16) - i7) >> 5, -128, 127);
                bArr[i11] = (byte) MathUtil.clip(((i15 + 16) - i7) >> 5, -128, 127);
                i12++;
                i13 += 16;
                i11 -= 16;
            }
            int i21 = i10 + 64;
            int i22 = 0;
            while (i22 < 8) {
                int i23 = 0;
                for (int i24 = 0; i24 < 8; i24++) {
                    i23 += MPEG4Consts.FILTER_TAB[3][i24] * bArr2[(MathUtil.clip(i2 + i22 + i24 + 1, 0, i4 - 1) * i6) + MathUtil.clip(i + i9, 0, i3 - 1)];
                }
                bArr[i21] = (byte) MathUtil.clip(((i23 + 16) - i7) >> 5, -128, 127);
                i22++;
                i21 += 16;
            }
            i10++;
            i9++;
            i8 = i5;
        }
    }

    private static final void vertMiddle16Safe(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = 0;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = i6 + 240;
            int i9 = 0;
            int i10 = i6;
            while (i9 < 4) {
                int i11 = (i3 << 4) + i5;
                int i12 = 0;
                int i13 = 0;
                int i14 = i5;
                for (int i15 = 0; i15 < i9 + 5; i15++) {
                    int i16 = MPEG4Consts.FILTER_TAB[i9][i15];
                    i12 += bArr2[i14] * i16;
                    i13 += i16 * bArr2[i11];
                    i14 += i3;
                    i11 -= i3;
                }
                bArr[i10] = (byte) MathUtil.clip(((i12 + 16) - i4) >> 5, -128, 127);
                bArr[i8] = (byte) MathUtil.clip(((i13 + 16) - i4) >> 5, -128, 127);
                i9++;
                i10 += 16;
                i8 -= 16;
            }
            int i17 = i6 + 64;
            int i18 = i5 + i3;
            int i19 = 0;
            while (i19 < 8) {
                int i20 = 0;
                int i21 = 0;
                int i22 = i18;
                while (i20 < 8) {
                    i21 += MPEG4Consts.FILTER_TAB[3][i20] * bArr2[i22];
                    i20++;
                    i22 += i3;
                }
                bArr[i17] = (byte) MathUtil.clip(((i21 + 16) - i4) >> 5, -128, 127);
                i19++;
                i17 += 16;
                i18 += i3;
            }
            i5++;
            i6++;
        }
    }

    private static final void vertMiddle8(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i2 >= 0 && i3 >= 0 && i2 <= i4 - i6 && i3 <= i5 - 9) {
            vertMiddle8Safe(bArr, i, bArr2, (i3 * i7) + i2, i6, i7, i8);
            return;
        }
        int i9 = i;
        for (int i10 = 0; i10 < i6; i10++) {
            for (int i11 = 0; i11 < 4; i11++) {
                int i12 = 0;
                int i13 = 0;
                for (int i14 = 0; i14 < i11 + 5; i14++) {
                    int i15 = i5 - 1;
                    int i16 = i2 + i10;
                    int i17 = i4 - 1;
                    int iClip = (MathUtil.clip(i3 + i14, 0, i15) * i7) + MathUtil.clip(i16, 0, i17);
                    int iClip2 = (MathUtil.clip((i3 + 8) - i14, 0, i15) * i7) + MathUtil.clip(i16, 0, i17);
                    int i18 = MPEG4Consts.FILTER_TAB[i11][i14];
                    i12 += bArr2[iClip] * i18;
                    i13 += i18 * bArr2[iClip2];
                }
                bArr[(i11 * 16) + i9] = (byte) MathUtil.clip(((i12 + 16) - i8) >> 5, -128, 127);
                bArr[((7 - i11) * 16) + i9] = (byte) MathUtil.clip(((i13 + 16) - i8) >> 5, -128, 127);
            }
            i9++;
        }
    }

    private static final void vertMiddle8Safe(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        for (int i8 = 0; i8 < i3; i8++) {
            for (int i9 = 0; i9 < 4; i9++) {
                int i10 = (i4 << 3) + i7;
                int i11 = 0;
                int i12 = 0;
                int i13 = i7;
                for (int i14 = 0; i14 < i9 + 5; i14++) {
                    int i15 = MPEG4Consts.FILTER_TAB[i9][i14];
                    i11 += bArr2[i13] * i15;
                    i12 += i15 * bArr2[i10];
                    i13 += i4;
                    i10 -= i4;
                }
                bArr[(i9 * 16) + i6] = (byte) MathUtil.clip(((i11 + 16) - i5) >> 5, -128, 127);
                bArr[((7 - i9) * 16) + i6] = (byte) MathUtil.clip(((i12 + 16) - i5) >> 5, -128, 127);
            }
            i7++;
            i6++;
        }
    }
}
