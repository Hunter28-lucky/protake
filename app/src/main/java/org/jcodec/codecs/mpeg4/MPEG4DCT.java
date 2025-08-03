package org.jcodec.codecs.mpeg4;

import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class MPEG4DCT {
    private static final int W1 = 2841;
    private static final int W2 = 2676;
    private static final int W3 = 2408;
    private static final int W5 = 1609;
    private static final int W6 = 1108;
    private static final int W7 = 565;

    private static final byte clamp255(int i) {
        int i2 = i - 255;
        int i3 = -((i2 & (i2 >> 31)) + 255);
        return (byte) ((-(i3 & (i3 >> 31))) - 128);
    }

    public static void idctAdd(byte[][] bArr, short[] sArr, int i, boolean z) {
        idctRows(sArr);
        if (i == 0) {
            idctColumnsAdd(sArr, bArr[0], 0, 16);
            return;
        }
        if (i == 1) {
            idctColumnsAdd(sArr, bArr[0], 8, 16);
            return;
        }
        if (i == 2) {
            if (z) {
                idctColumnsAdd(sArr, bArr[0], 16, 32);
                return;
            } else {
                idctColumnsAdd(sArr, bArr[0], 128, 16);
                return;
            }
        }
        if (i == 3) {
            if (z) {
                idctColumnsAdd(sArr, bArr[0], 24, 32);
                return;
            } else {
                idctColumnsAdd(sArr, bArr[0], 136, 16);
                return;
            }
        }
        if (i == 4) {
            idctColumnsAdd(sArr, bArr[1], 0, 8);
        } else {
            if (i != 5) {
                return;
            }
            idctColumnsAdd(sArr, bArr[2], 0, 8);
        }
    }

    public static void idctColumnsAdd(short[] sArr, byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            int i5 = sArr[i3 + 32] << 8;
            short s = sArr[i3 + 48];
            short s2 = sArr[i3 + 16];
            short s3 = sArr[i3 + 8];
            short s4 = sArr[i3 + 56];
            short s5 = sArr[i3 + 40];
            short s6 = sArr[i3 + 24];
            if ((i5 | s | s2 | s3 | s4 | s5 | s6) == 0) {
                int i6 = (sArr[i3 + 0] + 32) >> 6;
                int i7 = (i2 * 0) + i4;
                bArr[i7] = (byte) MathUtil.clip(bArr[i7] + i6, -128, 127);
                int i8 = (i2 * 1) + i4;
                bArr[i8] = (byte) MathUtil.clip(bArr[i8] + i6, -128, 127);
                int i9 = (i2 * 2) + i4;
                bArr[i9] = (byte) MathUtil.clip(bArr[i9] + i6, -128, 127);
                int i10 = (i2 * 3) + i4;
                bArr[i10] = (byte) MathUtil.clip(bArr[i10] + i6, -128, 127);
                int i11 = (i2 * 4) + i4;
                bArr[i11] = (byte) MathUtil.clip(bArr[i11] + i6, -128, 127);
                int i12 = (i2 * 5) + i4;
                bArr[i12] = (byte) MathUtil.clip(bArr[i12] + i6, -128, 127);
                int i13 = (i2 * 6) + i4;
                bArr[i13] = (byte) MathUtil.clip(bArr[i13] + i6, -128, 127);
                int i14 = i4 + (i2 * 7);
                bArr[i14] = (byte) MathUtil.clip(bArr[i14] + i6, -128, 127);
            } else {
                int i15 = (sArr[i3 + 0] << 8) + 8192;
                int i16 = ((s3 + s4) * W7) + 4;
                int i17 = ((s3 * 2276) + i16) >> 3;
                int i18 = (i16 - (s4 * 3406)) >> 3;
                int i19 = ((s5 + s6) * W3) + 4;
                int i20 = (i19 - (s5 * 799)) >> 3;
                int i21 = (i19 - (s6 * 4017)) >> 3;
                int i22 = i15 + i5;
                int i23 = i15 - i5;
                int i24 = ((s2 + s) * W6) + 4;
                int i25 = (i24 - (s * 3784)) >> 3;
                int i26 = (i24 + (s2 * 1568)) >> 3;
                int i27 = i17 + i20;
                int i28 = i17 - i20;
                int i29 = i18 + i21;
                int i30 = i18 - i21;
                int i31 = i22 + i26;
                int i32 = i22 - i26;
                int i33 = i23 + i25;
                int i34 = i23 - i25;
                int i35 = (((i28 + i30) * MPEGConst.EXTENSION_START_CODE) + 128) >> 8;
                int i36 = (((i28 - i30) * MPEGConst.EXTENSION_START_CODE) + 128) >> 8;
                int i37 = (i2 * 0) + i4;
                bArr[i37] = (byte) MathUtil.clip(bArr[i37] + ((i31 + i27) >> 14), -128, 127);
                int i38 = (i2 * 1) + i4;
                bArr[i38] = (byte) MathUtil.clip(bArr[i38] + ((i33 + i35) >> 14), -128, 127);
                int i39 = (i2 * 2) + i4;
                bArr[i39] = (byte) MathUtil.clip(bArr[i39] + ((i34 + i36) >> 14), -128, 127);
                int i40 = (i2 * 3) + i4;
                bArr[i40] = (byte) MathUtil.clip(bArr[i40] + ((i32 + i29) >> 14), -128, 127);
                int i41 = (i2 * 4) + i4;
                bArr[i41] = (byte) MathUtil.clip(bArr[i41] + ((i32 - i29) >> 14), -128, 127);
                int i42 = (i2 * 5) + i4;
                bArr[i42] = (byte) MathUtil.clip(bArr[i42] + ((i34 - i36) >> 14), -128, 127);
                int i43 = (i2 * 6) + i4;
                bArr[i43] = (byte) MathUtil.clip(bArr[i43] + ((i33 - i35) >> 14), -128, 127);
                int i44 = i4 + (i2 * 7);
                bArr[i44] = (byte) MathUtil.clip(bArr[i44] + ((i31 - i27) >> 14), -128, 127);
            }
        }
    }

    public static void idctColumnsPut(short[] sArr, byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            int i5 = sArr[i3 + 32] << 8;
            short s = sArr[i3 + 48];
            short s2 = sArr[i3 + 16];
            short s3 = sArr[i3 + 8];
            short s4 = sArr[i3 + 56];
            short s5 = sArr[i3 + 40];
            short s6 = sArr[i3 + 24];
            if ((i5 | s | s2 | s3 | s4 | s5 | s6) == 0) {
                int i6 = (i2 * 0) + i4;
                int i7 = (i2 * 1) + i4;
                int i8 = (i2 * 2) + i4;
                int i9 = (i2 * 3) + i4;
                int i10 = (i2 * 4) + i4;
                int i11 = (i2 * 5) + i4;
                int i12 = (i2 * 6) + i4;
                byte bClamp255 = clamp255((sArr[i3 + 0] + 32) >> 6);
                bArr[i4 + (i2 * 7)] = bClamp255;
                bArr[i12] = bClamp255;
                bArr[i11] = bClamp255;
                bArr[i10] = bClamp255;
                bArr[i9] = bClamp255;
                bArr[i8] = bClamp255;
                bArr[i7] = bClamp255;
                bArr[i6] = bClamp255;
            } else {
                int i13 = (sArr[i3 + 0] << 8) + 8192;
                int i14 = ((s3 + s4) * W7) + 4;
                int i15 = ((s3 * 2276) + i14) >> 3;
                int i16 = (i14 - (s4 * 3406)) >> 3;
                int i17 = ((s5 + s6) * W3) + 4;
                int i18 = (i17 - (s5 * 799)) >> 3;
                int i19 = (i17 - (s6 * 4017)) >> 3;
                int i20 = i13 + i5;
                int i21 = i13 - i5;
                int i22 = ((s2 + s) * W6) + 4;
                int i23 = (i22 - (s * 3784)) >> 3;
                int i24 = (i22 + (s2 * 1568)) >> 3;
                int i25 = i15 + i18;
                int i26 = i15 - i18;
                int i27 = i16 + i19;
                int i28 = i16 - i19;
                int i29 = i20 + i24;
                int i30 = i20 - i24;
                int i31 = i21 + i23;
                int i32 = i21 - i23;
                int i33 = (((i26 + i28) * MPEGConst.EXTENSION_START_CODE) + 128) >> 8;
                int i34 = (((i26 - i28) * MPEGConst.EXTENSION_START_CODE) + 128) >> 8;
                bArr[(i2 * 0) + i4] = clamp255((i29 + i25) >> 14);
                bArr[(i2 * 1) + i4] = clamp255((i31 + i33) >> 14);
                bArr[(i2 * 2) + i4] = clamp255((i32 + i34) >> 14);
                bArr[(i2 * 3) + i4] = clamp255((i30 + i27) >> 14);
                bArr[(i2 * 4) + i4] = clamp255((i30 - i27) >> 14);
                bArr[(i2 * 5) + i4] = clamp255((i32 - i34) >> 14);
                bArr[(i2 * 6) + i4] = clamp255((i31 - i33) >> 14);
                bArr[i4 + (i2 * 7)] = clamp255((i29 - i25) >> 14);
            }
        }
    }

    public static void idctPut(byte[][] bArr, short[][] sArr, boolean z) {
        int i;
        idctRows(sArr[0]);
        idctRows(sArr[1]);
        idctRows(sArr[2]);
        idctRows(sArr[3]);
        idctRows(sArr[4]);
        idctRows(sArr[5]);
        int i2 = 16;
        if (z) {
            i2 = 32;
            i = 16;
        } else {
            i = 128;
        }
        idctColumnsPut(sArr[0], bArr[0], 0, i2);
        idctColumnsPut(sArr[1], bArr[0], 8, i2);
        idctColumnsPut(sArr[2], bArr[0], i, i2);
        idctColumnsPut(sArr[3], bArr[0], i + 8, i2);
        idctColumnsPut(sArr[4], bArr[1], 0, 8);
        idctColumnsPut(sArr[5], bArr[2], 0, 8);
    }

    public static void idctRows(short[] sArr) {
        int i;
        int i2 = 0;
        while (i2 < 8) {
            int i3 = i2 << 3;
            int i4 = i3 + 4;
            int i5 = sArr[i4] << 11;
            int i6 = i3 + 6;
            short s = sArr[i6];
            int i7 = i3 + 2;
            short s2 = sArr[i7];
            int i8 = i3 + 1;
            short s3 = sArr[i8];
            int i9 = i3 + 7;
            short s4 = sArr[i9];
            int i10 = i3 + 5;
            short s5 = sArr[i10];
            int i11 = i3 + 3;
            short s6 = sArr[i11];
            if ((i5 | s | s2 | s3 | s4 | s5 | s6) == 0) {
                short s7 = (short) (sArr[i3] << 3);
                sArr[i9] = s7;
                sArr[i6] = s7;
                sArr[i10] = s7;
                sArr[i4] = s7;
                sArr[i11] = s7;
                sArr[i7] = s7;
                sArr[i8] = s7;
                sArr[i3] = s7;
                i = i2;
            } else {
                int i12 = (sArr[i3] << 11) + 128;
                i = i2;
                int i13 = (s3 + s4) * W7;
                int i14 = (s3 * 2276) + i13;
                int i15 = i13 - (s4 * 3406);
                int i16 = (s5 + s6) * W3;
                int i17 = i16 - (s5 * 799);
                int i18 = i16 - (s6 * 4017);
                int i19 = i12 + i5;
                int i20 = i12 - i5;
                int i21 = (s2 + s) * W6;
                int i22 = i21 - (s * 3784);
                int i23 = i21 + (s2 * 1568);
                int i24 = i14 + i17;
                int i25 = i14 - i17;
                int i26 = i15 + i18;
                int i27 = i15 - i18;
                int i28 = i19 + i23;
                int i29 = i19 - i23;
                int i30 = i20 + i22;
                int i31 = i20 - i22;
                int i32 = (((i25 + i27) * MPEGConst.EXTENSION_START_CODE) + 128) >> 8;
                int i33 = (((i25 - i27) * MPEGConst.EXTENSION_START_CODE) + 128) >> 8;
                sArr[i3] = (short) ((i28 + i24) >> 8);
                sArr[i8] = (short) ((i30 + i32) >> 8);
                sArr[i7] = (short) ((i31 + i33) >> 8);
                sArr[i11] = (short) ((i29 + i26) >> 8);
                sArr[i4] = (short) ((i29 - i26) >> 8);
                sArr[i10] = (short) ((i31 - i33) >> 8);
                sArr[i6] = (short) ((i30 - i32) >> 8);
                sArr[i9] = (short) ((i28 - i24) >> 8);
            }
            i2 = i + 1;
        }
    }
}
