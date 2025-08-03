package org.jcodec.common.dct;

/* loaded from: classes2.dex */
public class IDCT2x2 {
    public static void idct(int[] iArr, int i) {
        int i2 = iArr[i];
        int i3 = i + 1;
        int i4 = iArr[i3];
        int i5 = i + 2;
        int i6 = iArr[i5];
        int i7 = i + 3;
        int i8 = iArr[i7];
        int i9 = i2 + i6;
        int i10 = i2 - i6;
        int i11 = i4 + i8;
        int i12 = i4 - i8;
        iArr[i] = (i9 + i11) >> 3;
        iArr[i3] = (i9 - i11) >> 3;
        iArr[i5] = (i10 + i12) >> 3;
        iArr[i7] = (i10 - i12) >> 3;
    }
}
