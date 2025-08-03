package org.jcodec.common.dct;

/* loaded from: classes2.dex */
public class IDCT4x4 {
    public static final int CN_SHIFT = 12;
    public static final int C_SHIFT = 18;
    public static final int RN_SHIFT = 15;
    public static final int R_SHIFT = 11;
    public static final int C1 = C_FIX(0.6532814824d);
    public static final int C2 = C_FIX(0.2705980501d);
    public static final int C3 = C_FIX(0.5d);
    public static final int R1 = R_FIX(0.6532814824d);
    public static final int R2 = R_FIX(0.2705980501d);
    public static final int R3 = R_FIX(0.5d);

    public static final int C_FIX(double d) {
        return (int) ((d * 1.414213562d * 4096.0d) + 0.5d);
    }

    public static final int R_FIX(double d) {
        return (int) ((d * 1.414213562d * 32768.0d) + 0.5d);
    }

    public static void idct(int[] iArr, int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            idct4row(iArr, (i2 << 2) + i);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            idct4col_add(iArr, i + i3);
        }
    }

    private static void idct4col_add(int[] iArr, int i) {
        int i2 = iArr[i];
        int i3 = i + 4;
        int i4 = iArr[i3];
        int i5 = i + 8;
        int i6 = iArr[i5];
        int i7 = i + 12;
        int i8 = iArr[i7];
        int i9 = C3;
        int i10 = ((i2 + i6) * i9) + 131072;
        int i11 = ((i2 - i6) * i9) + 131072;
        int i12 = C1;
        int i13 = C2;
        int i14 = (i4 * i12) + (i8 * i13);
        int i15 = (i4 * i13) - (i8 * i12);
        iArr[i] = (i10 + i14) >> 18;
        iArr[i3] = (i11 + i15) >> 18;
        iArr[i5] = (i11 - i15) >> 18;
        iArr[i7] = (i10 - i14) >> 18;
    }

    private static void idct4row(int[] iArr, int i) {
        int i2 = iArr[i];
        int i3 = i + 1;
        int i4 = iArr[i3];
        int i5 = i + 2;
        int i6 = iArr[i5];
        int i7 = i + 3;
        int i8 = iArr[i7];
        int i9 = R3;
        int i10 = ((i2 + i6) * i9) + 1024;
        int i11 = ((i2 - i6) * i9) + 1024;
        int i12 = R1;
        int i13 = R2;
        int i14 = (i4 * i12) + (i8 * i13);
        int i15 = (i4 * i13) - (i8 * i12);
        iArr[i] = (i10 + i14) >> 11;
        iArr[i3] = (i11 + i15) >> 11;
        iArr[i5] = (i11 - i15) >> 11;
        iArr[i7] = (i10 - i14) >> 11;
    }
}
