package org.jcodec.common.dct;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class SparseIDCT {
    public static final int[][] COEFF;
    public static final int DC_SHIFT = 10;
    public static final int PRECISION = 13;

    static {
        int[][] iArr = new int[64][];
        COEFF = iArr;
        int[] iArr2 = new int[64];
        iArr[0] = iArr2;
        Arrays.fill(iArr2, 1024);
        for (int i = 1; i < 64; i++) {
            int[] iArr3 = new int[64];
            COEFF[i] = iArr3;
            iArr3[i] = 8192;
            SimpleIDCT10Bit.idct10(iArr3, 0);
        }
    }

    public static final void coeff(int[] iArr, int i, int i2) {
        for (int i3 = 0; i3 < 64; i3 += 4) {
            int i4 = iArr[i3];
            int[] iArr2 = COEFF[i];
            iArr[i3] = i4 + (iArr2[i3] * i2);
            int i5 = i3 + 1;
            iArr[i5] = iArr[i5] + (iArr2[i5] * i2);
            int i6 = i3 + 2;
            iArr[i6] = iArr[i6] + (iArr2[i6] * i2);
            int i7 = i3 + 3;
            iArr[i7] = iArr[i7] + (iArr2[i7] * i2);
        }
    }

    private static final int div(int i) {
        int i2 = i >> 31;
        int i3 = i >>> 31;
        return ((((i ^ i2) + i3) >> 13) ^ i2) + i3;
    }

    public static final void finish(int[] iArr) {
        for (int i = 0; i < 64; i += 4) {
            iArr[i] = div(iArr[i]);
            int i2 = i + 1;
            iArr[i2] = div(iArr[i2]);
            int i3 = i + 2;
            iArr[i3] = div(iArr[i3]);
            int i4 = i + 3;
            iArr[i4] = div(iArr[i4]);
        }
    }

    public static final void start(int[] iArr, int i) {
        int i2 = i << 10;
        for (int i3 = 0; i3 < 64; i3 += 4) {
            iArr[i3 + 0] = i2;
            iArr[i3 + 1] = i2;
            iArr[i3 + 2] = i2;
            iArr[i3 + 3] = i2;
        }
    }
}
