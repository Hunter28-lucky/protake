package org.jcodec.codecs.h264.decode;

import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class BlockInterpolator {
    private int[] tmp1 = new int[1024];
    private int[] tmp2 = new int[1024];
    private byte[] tmp3 = new byte[1024];
    private LumaInterpolator[] safe = initSafe();
    private LumaInterpolator[] unsafe = initUnsafe();

    public interface LumaInterpolator {
        void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8);
    }

    public static void getBlockChroma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i5 & 7;
        int i10 = i6 & 7;
        int i11 = i5 >> 3;
        int i12 = i6 >> 3;
        if (i11 < 0 || i11 > (i - i7) - 1 || i12 < 0 || i12 > (i2 - i8) - 1) {
            if (i9 == 0 && i10 == 0) {
                getChroma00Unsafe(bArr, i, i2, bArr2, i3, i4, i11, i12, i7, i8);
                return;
            }
            if (i10 == 0) {
                getChromaX0Unsafe(bArr, i, i2, bArr2, i3, i4, i11, i12, i9, i7, i8);
                return;
            } else if (i9 == 0) {
                getChroma0XUnsafe(bArr, i, i2, bArr2, i3, i4, i11, i12, i10, i7, i8);
                return;
            } else {
                getChromaXXUnsafe(bArr, i, i2, bArr2, i3, i4, i11, i12, i9, i10, i7, i8);
                return;
            }
        }
        if (i9 == 0 && i10 == 0) {
            getChroma00(bArr, i, i2, bArr2, i3, i4, i11, i12, i7, i8);
            return;
        }
        if (i10 == 0) {
            getChromaX0(bArr, i, i2, bArr2, i3, i4, i11, i12, i9, i7, i8);
        } else if (i9 == 0) {
            getChroma0X(bArr, i, i2, bArr2, i3, i4, i11, i12, i10, i7, i8);
        } else {
            getChromaXX(bArr, i, i2, bArr2, i3, i4, i11, i12, i9, i10, i7, i8);
        }
    }

    private static void getChroma00(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = (i6 * i) + i5;
        for (int i10 = 0; i10 < i8; i10++) {
            System.arraycopy(bArr, i9, bArr2, i3, i7);
            i9 += i;
            i3 += i4;
        }
    }

    private static void getChroma00Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 - 1;
        int i10 = i - 1;
        int i11 = i3;
        for (int i12 = 0; i12 < i8; i12++) {
            int iClip = MathUtil.clip(i12 + i6, 0, i9) * i;
            for (int i13 = 0; i13 < i7; i13++) {
                bArr2[i11 + i13] = bArr[MathUtil.clip(i5 + i13, 0, i10) + iClip];
            }
            i11 += i4;
        }
    }

    private static void getChroma0X(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = (i6 * i) + i5;
        int i11 = 8 - i7;
        int i12 = i10;
        int i13 = (i6 < i2 + (-1) ? i : 0) + i10;
        int i14 = i3;
        for (int i15 = 0; i15 < i9; i15++) {
            for (int i16 = 0; i16 < i8; i16++) {
                bArr2[i14 + i16] = (byte) ((((bArr[i12 + i16] * i11) + (bArr[i13 + i16] * i7)) + 4) >> 3);
            }
            i12 += i;
            i13 += i;
            i14 += i4;
        }
    }

    private static void getChroma0XUnsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i - 1;
        int i11 = i2 - 1;
        int i12 = 8 - i7;
        int i13 = i3;
        for (int i14 = 0; i14 < i9; i14++) {
            int i15 = i6 + i14;
            int iClip = MathUtil.clip(i15, 0, i11) * i;
            int iClip2 = MathUtil.clip(i15 + 1, 0, i11) * i;
            for (int i16 = 0; i16 < i8; i16++) {
                int i17 = i5 + i16;
                bArr2[i13 + i16] = (byte) ((((bArr[MathUtil.clip(i17, 0, i10) + iClip] * i12) + (bArr[MathUtil.clip(i17, 0, i10) + iClip2] * i7)) + 4) >> 3);
            }
            i13 += i4;
        }
    }

    private static void getChromaX0(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = (i6 * i) + i5;
        int i11 = 8 - i7;
        int i12 = i10;
        int i13 = (i5 < i + (-1) ? 1 : 0) + i10;
        int i14 = i3;
        for (int i15 = 0; i15 < i9; i15++) {
            for (int i16 = 0; i16 < i8; i16++) {
                bArr2[i14 + i16] = (byte) ((((bArr[i12 + i16] * i11) + (bArr[i13 + i16] * i7)) + 4) >> 3);
            }
            i12 += i;
            i13 += i;
            i14 += i4;
        }
    }

    private static void getChromaX0Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = 8 - i7;
        int i11 = i - 1;
        int i12 = i2 - 1;
        int i13 = i3;
        for (int i14 = 0; i14 < i9; i14++) {
            for (int i15 = 0; i15 < i8; i15++) {
                int i16 = i6 + i14;
                int i17 = i5 + i15;
                bArr2[i13 + i15] = (byte) ((((bArr[(MathUtil.clip(i16, 0, i12) * i) + MathUtil.clip(i17, 0, i11)] * i10) + (bArr[(MathUtil.clip(i16, 0, i12) * i) + MathUtil.clip(i17 + 1, 0, i11)] * i7)) + 4) >> 3);
            }
            i13 += i4;
        }
    }

    private static void getChromaXX(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = (i6 * i) + i5;
        int i12 = (i6 < i2 + (-1) ? i : 0) + i11;
        int i13 = (i5 >= i + (-1) ? 0 : 1) + i11;
        int i14 = (i13 + i12) - i11;
        int i15 = 8 - i7;
        int i16 = 8 - i8;
        int i17 = i13;
        int i18 = i11;
        int i19 = i12;
        int i20 = i14;
        int i21 = i3;
        for (int i22 = 0; i22 < i10; i22++) {
            for (int i23 = 0; i23 < i9; i23++) {
                bArr2[i21 + i23] = (byte) (((((((i15 * i16) * bArr[i18 + i23]) + ((i7 * i16) * bArr[i17 + i23])) + ((i15 * i8) * bArr[i19 + i23])) + ((i7 * i8) * bArr[i20 + i23])) + 32) >> 6);
            }
            i21 += i4;
            i18 += i;
            i19 += i;
            i17 += i;
            i20 += i;
        }
    }

    private static void getChromaXXUnsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = i2 - 1;
        int i12 = i - 1;
        int i13 = 8 - i7;
        int i14 = 8 - i8;
        int i15 = i3;
        for (int i16 = 0; i16 < i10; i16++) {
            for (int i17 = 0; i17 < i9; i17++) {
                int i18 = i6 + i16;
                int i19 = i5 + i17;
                int iClip = (MathUtil.clip(i18, 0, i11) * i) + MathUtil.clip(i19, 0, i12);
                int i20 = i18 + 1;
                int iClip2 = (MathUtil.clip(i20, 0, i11) * i) + MathUtil.clip(i19, 0, i12);
                int i21 = i19 + 1;
                bArr2[i15 + i17] = (byte) (((((((i13 * i14) * bArr[iClip]) + ((i7 * i14) * bArr[(MathUtil.clip(i18, 0, i11) * i) + MathUtil.clip(i21, 0, i12)])) + ((i13 * i8) * bArr[iClip2])) + ((i7 * i8) * bArr[(MathUtil.clip(i20, 0, i11) * i) + MathUtil.clip(i21, 0, i12)])) + 32) >> 6);
            }
            i15 += i4;
        }
    }

    public static void getLuma00(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = (i5 * i) + i4;
        for (int i9 = 0; i9 < i7; i9++) {
            System.arraycopy(bArr, i8, bArr2, i2, i6);
            i8 += i;
            i2 += i3;
        }
    }

    public static void getLuma00Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 - 1;
        int i10 = i - 1;
        int i11 = i3;
        for (int i12 = 0; i12 < i8; i12++) {
            int iClip = MathUtil.clip(i12 + i6, 0, i9) * i;
            for (int i13 = 0; i13 < i7; i13++) {
                bArr2[i11 + i13] = bArr[MathUtil.clip(i5 + i13, 0, i10) + iClip];
            }
            i11 += i4;
        }
    }

    public static void getLuma01(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma02(bArr, i, bArr2, i2, i3, i4, i5, i6, i7);
        int i8 = (i5 * i) + i4;
        for (int i9 = 0; i9 < i7; i9++) {
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = i2 + i10;
                bArr2[i11] = (byte) (((bArr2[i11] + bArr[i8 + i10]) + 1) >> 1);
            }
            i8 += i;
            i2 += i3;
        }
    }

    public static void getLuma02(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + i;
        int i9 = i8 + i;
        int i10 = i9 + i;
        int i11 = i10 + i;
        int i12 = ((i5 - 2) * i) + i4;
        int i13 = i2;
        for (int i14 = 0; i14 < i7; i14++) {
            for (int i15 = 0; i15 < i6; i15++) {
                int i16 = i12 + i15;
                bArr2[i13 + i15] = (byte) MathUtil.clip((((bArr[i16] + bArr[i16 + i11]) + ((((bArr[i16 + i8] + bArr[i16 + i9]) << 2) - (bArr[i16 + i] + bArr[i16 + i10])) * 5)) + 16) >> 5, -128, 127);
            }
            i12 += i;
            i13 += i3;
        }
    }

    public static void getLuma02NoRound(byte[] bArr, int i, int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + i;
        int i9 = i8 + i;
        int i10 = i9 + i;
        int i11 = i10 + i;
        int i12 = ((i5 - 2) * i) + i4;
        int i13 = i2;
        for (int i14 = 0; i14 < i7; i14++) {
            for (int i15 = 0; i15 < i6; i15++) {
                int i16 = i12 + i15;
                iArr[i13 + i15] = bArr[i16] + bArr[i16 + i11] + ((((bArr[i16 + i8] + bArr[i16 + i9]) << 2) - (bArr[i16 + i] + bArr[i16 + i10])) * 5);
            }
            i12 += i;
            i13 += i3;
        }
    }

    public static void getLuma02NoRoundInt(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + i;
        int i9 = i8 + i;
        int i10 = i9 + i;
        int i11 = i10 + i;
        int i12 = ((i5 - 2) * i) + i4;
        int i13 = i2;
        for (int i14 = 0; i14 < i7; i14++) {
            for (int i15 = 0; i15 < i6; i15++) {
                int i16 = i12 + i15;
                iArr2[i13 + i15] = iArr[i16] + iArr[i16 + i11] + ((((iArr[i16 + i8] + iArr[i16 + i9]) << 2) - (iArr[i16 + i] + iArr[i16 + i10])) * 5);
            }
            i12 += i;
            i13 += i3;
        }
    }

    public static void getLuma02UnsafeNoRound(byte[] bArr, int i, int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 - 1;
        int i10 = i - 1;
        int i11 = i3;
        for (int i12 = 0; i12 < i8; i12++) {
            int i13 = i6 + i12;
            int iClip = MathUtil.clip(i13 - 2, 0, i9) * i;
            int iClip2 = MathUtil.clip(i13 - 1, 0, i9) * i;
            int iClip3 = MathUtil.clip(i13, 0, i9) * i;
            int iClip4 = MathUtil.clip(i13 + 1, 0, i9) * i;
            int iClip5 = MathUtil.clip(i13 + 2, 0, i9) * i;
            int iClip6 = MathUtil.clip(i13 + 3, 0, i9) * i;
            for (int i14 = 0; i14 < i7; i14++) {
                int iClip7 = MathUtil.clip(i5 + i14, 0, i10);
                iArr[i11 + i14] = bArr[iClip7 + iClip] + bArr[iClip7 + iClip6] + ((((bArr[iClip7 + iClip3] + bArr[iClip7 + iClip4]) << 2) - (bArr[iClip7 + iClip2] + bArr[iClip7 + iClip5])) * 5);
            }
            i11 += i4;
        }
    }

    public static void getLuma03(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma02(bArr, i, bArr2, i2, i3, i4, i5, i6, i7);
        int i8 = (i5 * i) + i4;
        for (int i9 = 0; i9 < i7; i9++) {
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = i2 + i10;
                bArr2[i11] = (byte) (((bArr2[i11] + bArr[(i8 + i10) + i]) + 1) >> 1);
            }
            i8 += i;
            i2 += i3;
        }
    }

    public static void getLuma10(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20(bArr, i, bArr2, i2, i3, i4, i5, i6, i7);
        int i8 = (i5 * i) + i4;
        for (int i9 = 0; i9 < i7; i9++) {
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = i2 + i10;
                bArr2[i11] = (byte) (((bArr2[i11] + bArr[i8 + i10]) + 1) >> 1);
            }
            i8 += i;
            i2 += i3;
        }
    }

    public static void getLuma20(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = (i5 * i) + i4;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = -2;
            for (int i11 = 0; i11 < i6; i11++) {
                int i12 = i8 + i10;
                bArr2[i2 + i11] = (byte) MathUtil.clip((((bArr[i12] + bArr[i12 + 5]) + ((((bArr[i12 + 2] + bArr[i12 + 3]) << 2) - (bArr[i12 + 1] + bArr[i12 + 4])) * 5)) + 16) >> 5, -128, 127);
                i10++;
            }
            i8 += i;
            i2 += i3;
        }
    }

    public static void getLuma20NoRound(byte[] bArr, int i, int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = (i5 * i) + i4;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = -2;
            for (int i11 = 0; i11 < i6; i11++) {
                int i12 = i8 + i10;
                iArr[i2 + i11] = bArr[i12] + bArr[i12 + 5] + ((((bArr[i12 + 2] + bArr[i12 + 3]) << 2) - (bArr[i12 + 1] + bArr[i12 + 4])) * 5);
                i10++;
            }
            i8 += i;
            i2 += i3;
        }
    }

    public static void getLuma20NoRoundInt(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = (i5 * i) + i4;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = -2;
            for (int i11 = 0; i11 < i6; i11++) {
                int i12 = i8 + i10;
                iArr2[i2 + i11] = iArr[i12] + iArr[i12 + 5] + ((((iArr[i12 + 2] + iArr[i12 + 3]) << 2) - (iArr[i12 + 1] + iArr[i12 + 4])) * 5);
                i10++;
            }
            i8 += i;
            i2 += i3;
        }
    }

    public static void getLuma20UnsafeNoRound(byte[] bArr, int i, int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i - 1;
        int i10 = i2 - 1;
        for (int i11 = 0; i11 < i7; i11++) {
            int i12 = i5 + i11;
            int iClip = MathUtil.clip(i12 - 2, 0, i9);
            int iClip2 = MathUtil.clip(i12 - 1, 0, i9);
            int iClip3 = MathUtil.clip(i12, 0, i9);
            int iClip4 = MathUtil.clip(i12 + 1, 0, i9);
            int iClip5 = MathUtil.clip(i12 + 2, 0, i9);
            int iClip6 = MathUtil.clip(i12 + 3, 0, i9);
            int i13 = i3;
            for (int i14 = 0; i14 < i8; i14++) {
                int iClip7 = MathUtil.clip(i14 + i6, 0, i10) * i;
                iArr[i13 + i11] = bArr[iClip7 + iClip] + bArr[iClip7 + iClip6] + ((((bArr[iClip7 + iClip3] + bArr[iClip7 + iClip4]) << 2) - (bArr[iClip7 + iClip2] + bArr[iClip7 + iClip5])) * 5);
                i13 += i4;
            }
        }
    }

    public static void getLuma30(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20(bArr, i, bArr2, i2, i3, i4, i5, i6, i7);
        int i8 = (i5 * i) + i4;
        for (int i9 = 0; i9 < i7; i9++) {
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = i2 + i10;
                bArr2[i11] = (byte) (((bArr[(i8 + i10) + 1] + bArr2[i11]) + 1) >> 1);
            }
            i8 += i;
            i2 += i3;
        }
    }

    private LumaInterpolator[] initSafe() {
        return new LumaInterpolator[]{new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.1
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BlockInterpolator.getLuma00(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.2
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BlockInterpolator.getLuma10(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.3
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BlockInterpolator.getLuma20(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.4
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BlockInterpolator.getLuma30(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.5
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BlockInterpolator.getLuma01(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.6
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma11(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.7
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma21(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.8
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma31(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.9
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BlockInterpolator.getLuma02(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.10
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma12(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.11
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma22(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.12
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma32(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.13
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BlockInterpolator.getLuma03(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.14
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma13(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.15
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma23(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.16
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma33(bArr, i, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }};
    }

    private LumaInterpolator[] initUnsafe() {
        return new LumaInterpolator[]{new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.17
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BlockInterpolator.getLuma00Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.18
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma10Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.19
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma20Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.20
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma30Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.21
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma01Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.22
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma11Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.23
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma21Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.24
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma31Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.25
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma02Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.26
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma12Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.27
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma22Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.28
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma32Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.29
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma03Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.30
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma13Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.31
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma23Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }, new LumaInterpolator() { // from class: org.jcodec.codecs.h264.decode.BlockInterpolator.32
            @Override // org.jcodec.codecs.h264.decode.BlockInterpolator.LumaInterpolator
            public void getLuma(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.getLuma33Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
            }
        }};
    }

    private static void merge(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = i + i7;
                bArr[i8] = (byte) (((bArr[i8] + bArr2[i5 + i7]) + 1) >> 1);
            }
            i += i2;
            i5 += i3;
        }
    }

    public void getBlockLuma(Picture picture, Picture picture2, int i, int i2, int i3, int i4, int i5) {
        int i6 = i2 & 3;
        int i7 = i3 & 3;
        int i8 = i2 >> 2;
        int i9 = i3 >> 2;
        if (i8 < 2 || i9 < 2 || i8 > (picture.getWidth() - i4) - 5 || i9 > (picture.getHeight() - i5) - 5) {
            this.unsafe[(i7 << 2) + i6].getLuma(picture.getData()[0], picture.getWidth(), picture.getHeight(), picture2.getPlaneData(0), i, picture2.getPlaneWidth(0), i8, i9, i4, i5);
        } else {
            this.safe[(i7 << 2) + i6].getLuma(picture.getData()[0], picture.getWidth(), picture.getHeight(), picture2.getPlaneData(0), i, picture2.getPlaneWidth(0), i8, i9, i4, i5);
        }
    }

    public void getLuma01Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 - 1;
        int i10 = i - 1;
        getLuma02Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
        int i11 = i3;
        for (int i12 = 0; i12 < i8; i12++) {
            int iClip = MathUtil.clip(i6 + i12, 0, i9) * i;
            for (int i13 = 0; i13 < i7; i13++) {
                int i14 = i11 + i13;
                bArr2[i14] = (byte) (((bArr2[i14] + bArr[MathUtil.clip(i5 + i13, 0, i10) + iClip]) + 1) >> 1);
            }
            i11 += i4;
        }
    }

    public void getLuma02Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma02UnsafeNoRound(bArr, i, i2, this.tmp1, i3, i4, i5, i6, i7, i8);
        int i9 = i3;
        for (int i10 = 0; i10 < i8; i10++) {
            for (int i11 = 0; i11 < i7; i11++) {
                int i12 = i9 + i11;
                bArr2[i12] = (byte) MathUtil.clip((this.tmp1[i12] + 16) >> 5, -128, 127);
            }
            i9 += i4;
        }
    }

    public void getLuma03Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 - 1;
        int i10 = i - 1;
        getLuma02Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
        int i11 = i3;
        for (int i12 = 0; i12 < i8; i12++) {
            int iClip = MathUtil.clip(i6 + i12 + 1, 0, i9) * i;
            for (int i13 = 0; i13 < i7; i13++) {
                int i14 = i11 + i13;
                bArr2[i14] = (byte) (((bArr2[i14] + bArr[MathUtil.clip(i5 + i13, 0, i10) + iClip]) + 1) >> 1);
            }
            i11 += i4;
        }
    }

    public void getLuma10Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 - 1;
        int i10 = i - 1;
        getLuma20Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
        int i11 = i3;
        for (int i12 = 0; i12 < i8; i12++) {
            int iClip = MathUtil.clip(i12 + i6, 0, i9) * i;
            for (int i13 = 0; i13 < i7; i13++) {
                int i14 = i11 + i13;
                bArr2[i14] = (byte) (((bArr2[i14] + bArr[MathUtil.clip(i5 + i13, 0, i10) + iClip]) + 1) >> 1);
            }
            i11 += i4;
        }
    }

    public void getLuma11(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20(bArr, i, bArr2, i2, i3, i4, i5, i6, i7);
        getLuma02(bArr, i, this.tmp3, 0, i6, i4, i5, i6, i7);
        merge(bArr2, this.tmp3, i2, i3, i6, i7);
    }

    public void getLuma11Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma20Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
        getLuma02Unsafe(bArr, i, i2, this.tmp3, 0, i7, i5, i6, i7, i8);
        merge(bArr2, this.tmp3, i3, i4, i7, i8);
    }

    public void getLuma12(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i6 + 7;
        int i9 = 2;
        getLuma02NoRound(bArr, i, this.tmp1, 0, i8, i4 - 2, i5, i8, i7);
        getLuma20NoRoundInt(this.tmp1, i8, this.tmp2, i2, i3, 2, 0, i6, i7);
        int i10 = i2;
        for (int i11 = 0; i11 < i7; i11++) {
            for (int i12 = 0; i12 < i6; i12++) {
                int i13 = i10 + i12;
                bArr2[i13] = (byte) (((MathUtil.clip((this.tmp2[i13] + 512) >> 10, -128, 127) + MathUtil.clip((this.tmp1[i9 + i12] + 16) >> 5, -128, 127)) + 1) >> 1);
            }
            i10 += i3;
            i9 += i8;
        }
    }

    public void getLuma12Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i7 + 7;
        int i10 = 2;
        getLuma02UnsafeNoRound(bArr, i, i2, this.tmp1, 0, i9, i5 - 2, i6, i9, i8);
        getLuma20NoRoundInt(this.tmp1, i9, this.tmp2, i3, i4, 2, 0, i7, i8);
        int i11 = i3;
        for (int i12 = 0; i12 < i8; i12++) {
            for (int i13 = 0; i13 < i7; i13++) {
                int i14 = i11 + i13;
                bArr2[i14] = (byte) (((MathUtil.clip((this.tmp2[i14] + 512) >> 10, -128, 127) + MathUtil.clip((this.tmp1[i10 + i13] + 16) >> 5, -128, 127)) + 1) >> 1);
            }
            i11 += i4;
            i10 += i9;
        }
    }

    public void getLuma13(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20(bArr, i, bArr2, i2, i3, i4, i5 + 1, i6, i7);
        getLuma02(bArr, i, this.tmp3, 0, i6, i4, i5, i6, i7);
        merge(bArr2, this.tmp3, i2, i3, i6, i7);
    }

    public void getLuma13Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma20Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6 + 1, i7, i8);
        getLuma02Unsafe(bArr, i, i2, this.tmp3, 0, i7, i5, i6, i7, i8);
        merge(bArr2, this.tmp3, i3, i4, i7, i8);
    }

    public void getLuma20Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma20UnsafeNoRound(bArr, i, i2, this.tmp1, i3, i4, i5, i6, i7, i8);
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = i3;
            for (int i11 = 0; i11 < i8; i11++) {
                int i12 = i10 + i9;
                bArr2[i12] = (byte) MathUtil.clip((this.tmp1[i12] + 16) >> 5, -128, 127);
                i10 += i4;
            }
        }
    }

    public void getLuma21(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20NoRound(bArr, i, this.tmp1, 0, i6, i4, i5 - 2, i6, i7 + 7);
        getLuma02NoRoundInt(this.tmp1, i6, this.tmp2, i2, i3, 0, 2, i6, i7);
        int i8 = i6 << 1;
        int i9 = i2;
        for (int i10 = 0; i10 < i7; i10++) {
            for (int i11 = 0; i11 < i6; i11++) {
                int i12 = i9 + i11;
                bArr2[i12] = (byte) (((MathUtil.clip((this.tmp2[i12] + 512) >> 10, -128, 127) + MathUtil.clip((this.tmp1[i8 + i11] + 16) >> 5, -128, 127)) + 1) >> 1);
            }
            i9 += i3;
            i8 += i6;
        }
    }

    public void getLuma21Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma20UnsafeNoRound(bArr, i, i2, this.tmp1, 0, i7, i5, i6 - 2, i7, i8 + 7);
        getLuma02NoRoundInt(this.tmp1, i7, this.tmp2, i3, i4, 0, 2, i7, i8);
        int i9 = i7 << 1;
        int i10 = i3;
        for (int i11 = 0; i11 < i8; i11++) {
            for (int i12 = 0; i12 < i7; i12++) {
                int i13 = i10 + i12;
                bArr2[i13] = (byte) (((MathUtil.clip((this.tmp2[i13] + 512) >> 10, -128, 127) + MathUtil.clip((this.tmp1[i9 + i12] + 16) >> 5, -128, 127)) + 1) >> 1);
            }
            i10 += i4;
            i9 += i7;
        }
    }

    public void getLuma22(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20NoRound(bArr, i, this.tmp1, 0, i6, i4, i5 - 2, i6, i7 + 7);
        getLuma02NoRoundInt(this.tmp1, i6, this.tmp2, i2, i3, 0, 2, i6, i7);
        int i8 = i2;
        for (int i9 = 0; i9 < i7; i9++) {
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = i8 + i10;
                bArr2[i11] = (byte) MathUtil.clip((this.tmp2[i11] + 512) >> 10, -128, 127);
            }
            i8 += i3;
        }
    }

    public void getLuma22Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma20UnsafeNoRound(bArr, i, i2, this.tmp1, 0, i7, i5, i6 - 2, i7, i8 + 7);
        getLuma02NoRoundInt(this.tmp1, i7, this.tmp2, i3, i4, 0, 2, i7, i8);
        int i9 = i3;
        for (int i10 = 0; i10 < i8; i10++) {
            for (int i11 = 0; i11 < i7; i11++) {
                int i12 = i9 + i11;
                bArr2[i12] = (byte) MathUtil.clip((this.tmp2[i12] + 512) >> 10, -128, 127);
            }
            i9 += i4;
        }
    }

    public void getLuma23(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20NoRound(bArr, i, this.tmp1, 0, i6, i4, i5 - 2, i6, i7 + 7);
        getLuma02NoRoundInt(this.tmp1, i6, this.tmp2, i2, i3, 0, 2, i6, i7);
        int i8 = i6 << 1;
        int i9 = i2;
        for (int i10 = 0; i10 < i7; i10++) {
            for (int i11 = 0; i11 < i6; i11++) {
                int i12 = i9 + i11;
                bArr2[i12] = (byte) (((MathUtil.clip((this.tmp2[i12] + 512) >> 10, -128, 127) + MathUtil.clip((this.tmp1[(i8 + i11) + i6] + 16) >> 5, -128, 127)) + 1) >> 1);
            }
            i9 += i3;
            i8 += i6;
        }
    }

    public void getLuma23Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma20UnsafeNoRound(bArr, i, i2, this.tmp1, 0, i7, i5, i6 - 2, i7, i8 + 7);
        getLuma02NoRoundInt(this.tmp1, i7, this.tmp2, i3, i4, 0, 2, i7, i8);
        int i9 = i7 << 1;
        int i10 = i3;
        for (int i11 = 0; i11 < i8; i11++) {
            for (int i12 = 0; i12 < i7; i12++) {
                int i13 = i10 + i12;
                bArr2[i13] = (byte) (((MathUtil.clip((this.tmp2[i13] + 512) >> 10, -128, 127) + MathUtil.clip((this.tmp1[(i9 + i12) + i7] + 16) >> 5, -128, 127)) + 1) >> 1);
            }
            i10 += i4;
            i9 += i7;
        }
    }

    public void getLuma30Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 - 1;
        int i10 = i - 1;
        getLuma20Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
        int i11 = i3;
        for (int i12 = 0; i12 < i8; i12++) {
            int iClip = MathUtil.clip(i12 + i6, 0, i9) * i;
            for (int i13 = 0; i13 < i7; i13++) {
                int i14 = i11 + i13;
                bArr2[i14] = (byte) (((bArr2[i14] + bArr[MathUtil.clip((i5 + i13) + 1, 0, i10) + iClip]) + 1) >> 1);
            }
            i11 += i4;
        }
    }

    public void getLuma31(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20(bArr, i, bArr2, i2, i3, i4, i5, i6, i7);
        getLuma02(bArr, i, this.tmp3, 0, i6, i4 + 1, i5, i6, i7);
        merge(bArr2, this.tmp3, i2, i3, i6, i7);
    }

    public void getLuma31Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma20Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6, i7, i8);
        getLuma02Unsafe(bArr, i, i2, this.tmp3, 0, i7, i5 + 1, i6, i7, i8);
        merge(bArr2, this.tmp3, i3, i4, i7, i8);
    }

    public void getLuma32(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i6 + 7;
        int i9 = 2;
        getLuma02NoRound(bArr, i, this.tmp1, 0, i8, i4 - 2, i5, i8, i7);
        getLuma20NoRoundInt(this.tmp1, i8, this.tmp2, i2, i3, 2, 0, i6, i7);
        int i10 = i2;
        for (int i11 = 0; i11 < i7; i11++) {
            for (int i12 = 0; i12 < i6; i12++) {
                int i13 = i10 + i12;
                bArr2[i13] = (byte) (((MathUtil.clip((this.tmp2[i13] + 512) >> 10, -128, 127) + MathUtil.clip((this.tmp1[(i9 + i12) + 1] + 16) >> 5, -128, 127)) + 1) >> 1);
            }
            i10 += i3;
            i9 += i8;
        }
    }

    public void getLuma32Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i7 + 7;
        int i10 = 2;
        getLuma02UnsafeNoRound(bArr, i, i2, this.tmp1, 0, i9, i5 - 2, i6, i9, i8);
        getLuma20NoRoundInt(this.tmp1, i9, this.tmp2, i3, i4, 2, 0, i7, i8);
        int i11 = i3;
        for (int i12 = 0; i12 < i8; i12++) {
            for (int i13 = 0; i13 < i7; i13++) {
                int i14 = i11 + i13;
                bArr2[i14] = (byte) (((MathUtil.clip((this.tmp2[i14] + 512) >> 10, -128, 127) + MathUtil.clip((this.tmp1[(i10 + i13) + 1] + 16) >> 5, -128, 127)) + 1) >> 1);
            }
            i11 += i4;
            i10 += i9;
        }
    }

    public void getLuma33(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20(bArr, i, bArr2, i2, i3, i4, i5 + 1, i6, i7);
        getLuma02(bArr, i, this.tmp3, 0, i6, i4 + 1, i5, i6, i7);
        merge(bArr2, this.tmp3, i2, i3, i6, i7);
    }

    public void getLuma33Unsafe(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma20Unsafe(bArr, i, i2, bArr2, i3, i4, i5, i6 + 1, i7, i8);
        getLuma02Unsafe(bArr, i, i2, this.tmp3, 0, i7, i5 + 1, i6, i7, i8);
        merge(bArr2, this.tmp3, i3, i4, i7, i8);
    }
}
