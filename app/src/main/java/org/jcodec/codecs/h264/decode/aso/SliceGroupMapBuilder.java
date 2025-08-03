package org.jcodec.codecs.h264.decode.aso;

/* loaded from: classes2.dex */
public class SliceGroupMapBuilder {
    private static int Max(int i, int i2) {
        return i > i2 ? i : i2;
    }

    private static int Min(int i, int i2) {
        return i < i2 ? i : i2;
    }

    public static int[] buildBoxOutMap(int i, int i2, boolean z, int i3) {
        int i4 = i * i2;
        int[] iArr = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            iArr[i5] = 1;
        }
        int iMin = (i - (z ? 1 : 0)) / 2;
        int i6 = (i2 - (z ? 1 : 0)) / 2;
        int i7 = (z ? 1 : 0) - 1;
        int i8 = z ? 1 : 0;
        int i9 = 0;
        int iMin2 = i6;
        int i10 = iMin2;
        int i11 = i10;
        int i12 = i7;
        int i13 = iMin;
        int i14 = i13;
        while (i9 < i3) {
            int i15 = (iMin2 * i) + iMin;
            int i16 = iArr[i15] == 1 ? 1 : 0;
            if (i16 != 0) {
                iArr[i15] = 0;
            }
            if (i12 == -1 && iMin == i13) {
                iMin = Max(i13 - 1, 0);
                i8 = ((z ? 1 : 0) * 2) - 1;
                i13 = iMin;
            } else if (i12 == 1 && iMin == i14) {
                iMin = Min(i14 + 1, i - 1);
                i8 = 1 - ((z ? 1 : 0) * 2);
                i14 = iMin;
            } else {
                if (i8 == -1 && iMin2 == i10) {
                    iMin2 = Max(i10 - 1, 0);
                    i8 = 0;
                    i12 = 1 - ((z ? 1 : 0) * 2);
                    i10 = iMin2;
                } else if (i8 == 1 && iMin2 == i11) {
                    iMin2 = Min(i11 + 1, i2 - 1);
                    i8 = 0;
                    i12 = ((z ? 1 : 0) * 2) - 1;
                    i11 = iMin2;
                } else {
                    iMin += i12;
                    iMin2 += i8;
                }
                i9 += i16;
            }
            i12 = 0;
            i9 += i16;
        }
        return iArr;
    }

    public static int[] buildDispersedMap(int i, int i2, int i3) {
        int i4 = i2 * i;
        int[] iArr = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            iArr[i5] = ((i5 % i) + (((i5 / i) * i3) / 2)) % i3;
        }
        return iArr;
    }

    public static int[] buildForegroundMap(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        int i4 = i2 * i;
        int[] iArr3 = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            iArr3[i5] = i3 - 1;
        }
        for (int i6 = i3 - 2; i6 >= 0; i6--) {
            int i7 = iArr[i6];
            int i8 = i7 % i;
            int i9 = iArr2[i6];
            int i10 = i9 / i;
            int i11 = i9 % i;
            for (int i12 = i7 / i; i12 <= i10; i12++) {
                for (int i13 = i8; i13 <= i11; i13++) {
                    iArr3[(i12 * i) + i13] = i6;
                }
            }
        }
        return iArr3;
    }

    public static int[] buildInterleavedMap(int i, int i2, int[] iArr) {
        int i3;
        int i4;
        int length = iArr.length;
        int i5 = i * i2;
        int[] iArr2 = new int[i5];
        int i6 = 0;
        do {
            int i7 = 0;
            while (i7 < length && i6 < i5) {
                int i8 = 0;
                while (true) {
                    i3 = iArr[i7];
                    if (i8 >= i3 || (i4 = i6 + i8) >= i5) {
                        break;
                    }
                    iArr2[i4] = i7;
                    i8++;
                }
                i7++;
                i6 += i3;
            }
        } while (i6 < i5);
        return iArr2;
    }

    public static int[] buildRasterScanMap(int i, int i2, int i3, boolean z) {
        int i4 = i * i2;
        int[] iArr = new int[i4];
        int i5 = 0;
        while (i5 < i3) {
            iArr[i5] = z ? 1 : 0;
            i5++;
        }
        while (i5 < i4) {
            iArr[i5] = 1 - (z ? 1 : 0);
            i5++;
        }
        return iArr;
    }

    public static int[] buildWipeMap(int i, int i2, int i3, boolean z) {
        int[] iArr = new int[i * i2];
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = 0;
            while (i6 < i2) {
                int i7 = (i6 * i) + i5;
                int i8 = i4 + 1;
                if (i4 < i3) {
                    iArr[i7] = z ? 1 : 0;
                } else {
                    iArr[i7] = 1 - (z ? 1 : 0);
                }
                i6++;
                i4 = i8;
            }
        }
        return iArr;
    }
}
