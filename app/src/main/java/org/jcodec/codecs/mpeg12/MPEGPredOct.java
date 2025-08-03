package org.jcodec.codecs.mpeg12;

import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class MPEGPredOct extends MPEGPred {
    private static final int[][] COEFF = {new int[]{0, 0, 128, 0, 0, 0}, new int[]{0, -6, 123, 12, -1, 0}, new int[]{2, -11, 108, 36, -8, 1}, new int[]{0, -9, 93, 50, -6, 0}, new int[]{3, -16, 77, 77, -16, 3}, new int[]{0, -6, 50, 93, -9, 0}, new int[]{1, -8, 36, 108, -11, 2}, new int[]{0, -1, 12, 123, -6, 0}};
    private int[] tmp;

    public MPEGPredOct(MPEGPred mPEGPred) {
        super(mPEGPred.fCode, mPEGPred.chromaFormat, mPEGPred.topFieldFirst);
        this.tmp = new int[336];
    }

    private void predictFullXSubYSafe(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int i8, int i9, int i10, int i11) {
        int[] iArr2 = COEFF[i3];
        int i12 = i9 * i8;
        int i13 = (((i2 << i6) + i7) * i4) + i;
        int i14 = i4 << i6;
        int i15 = i4 << (i6 + 1);
        int i16 = i15 + i14;
        int i17 = i11 * i9;
        int i18 = i14 - i9;
        for (int i19 = 0; i19 < i10; i19++) {
            int i20 = 0;
            while (i20 < i9) {
                iArr[i12] = ((((((((bArr[i13 - i15] * iArr2[0]) + (bArr[i13 - i14] * iArr2[1])) + (bArr[i13] * iArr2[2])) + (bArr[i13 + i14] * iArr2[3])) + (bArr[i13 + i15] * iArr2[4])) + (bArr[i13 + i16] * iArr2[5])) + 64) >> 7) + 128;
                i20++;
                i12++;
                i13++;
            }
            i13 += i18;
            i12 += i17;
        }
    }

    private void predictFullXSubYUnSafe(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int i8, int i9, int i10, int i11) {
        int[] iArr2 = COEFF[i3];
        int i12 = i9 * i8;
        int i13 = i11 * i9;
        for (int i14 = 0; i14 < i10; i14++) {
            int i15 = ((i14 + i2) << i6) + i7;
            int i16 = i12;
            int i17 = 0;
            while (i17 < i9) {
                iArr[i16] = (getPix6Vert(bArr, i4, i5, i17 + i, i15, i6, i7, iArr2) + 64) >> 7;
                i17++;
                i16++;
            }
            i12 = i16 + i13;
        }
    }

    private void predictSubXFullYSafe(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int i8, int i9, int i10, int i11) {
        int[] iArr2 = COEFF[i2];
        int i12 = (((i3 << i6) + i7) * i4) + i;
        int i13 = i9 * i8;
        int i14 = (i4 << i6) - i9;
        int i15 = i11 * i9;
        for (int i16 = 0; i16 < i10; i16++) {
            int i17 = 0;
            while (i17 < i9) {
                int i18 = i12 + 1;
                iArr[i13] = ((((((((bArr[i12 - 2] * iArr2[0]) + (bArr[i12 - 1] * iArr2[1])) + (bArr[i12] * iArr2[2])) + (bArr[i18] * iArr2[3])) + (bArr[i12 + 2] * iArr2[4])) + (bArr[i12 + 3] * iArr2[5])) + 64) >> 7) + 128;
                i17++;
                i13++;
                i12 = i18;
            }
            i12 += i14;
            i13 += i15;
        }
    }

    private void predictSubXFullYUnSafe(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int i8, int i9, int i10, int i11) {
        int[] iArr2 = COEFF[i2];
        int i12 = i9 * i8;
        int i13 = i11 * i9;
        for (int i14 = 0; i14 < i10; i14++) {
            int i15 = ((i14 + i3) << i6) + i7;
            int i16 = i12;
            int i17 = 0;
            while (i17 < i9) {
                iArr[i16] = (getPix6(bArr, i4, i5, i17 + i, i15, i6, i7, iArr2) + 64) >> 7;
                i17++;
                i16++;
            }
            i12 = i16 + i13;
        }
    }

    private void predictSubXSubYSafe(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int[] iArr, int i9, int i10, int i11, int i12) {
        int[] iArr2 = COEFF[i2];
        int i13 = ((((i3 - 2) << i7) + i8) * i5) + i;
        int i14 = i10 * i9;
        int i15 = (i5 << i7) - i10;
        int i16 = i12 * i10;
        int i17 = i10 << 1;
        int i18 = i17 + i10;
        int i19 = 0;
        for (int i20 = 0; i20 < i11 + 5; i20++) {
            int i21 = 0;
            while (i21 < i10) {
                int i22 = i13 + 1;
                this.tmp[i19] = (bArr[i13 - 2] * iArr2[0]) + (bArr[i13 - 1] * iArr2[1]) + (bArr[i13] * iArr2[2]) + (bArr[i22] * iArr2[3]) + (bArr[i13 + 2] * iArr2[4]) + (bArr[i13 + 3] * iArr2[5]);
                i21++;
                i19++;
                i13 = i22;
            }
            i13 += i15;
        }
        int[] iArr3 = COEFF[i4];
        int i23 = i17;
        for (int i24 = 0; i24 < i11; i24++) {
            int i25 = 0;
            while (i25 < i10) {
                int[] iArr4 = this.tmp;
                iArr[i14] = ((((((((iArr4[i23 - i17] * iArr3[0]) + (iArr4[i23 - i10] * iArr3[1])) + (iArr4[i23] * iArr3[2])) + (iArr4[i23 + i10] * iArr3[3])) + (iArr4[i23 + i17] * iArr3[4])) + (iArr4[i23 + i18] * iArr3[5])) + 8192) >> 14) + 128;
                i25++;
                i23++;
                i14++;
            }
            i14 += i16;
        }
    }

    private void predictSubXSubYUnSafe(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int[] iArr, int i9, int i10, int i11, int i12) {
        int i13 = i10 * i9;
        int i14 = i10 << 1;
        int i15 = i14 + i10;
        int i16 = i12 * i10;
        int[] iArr2 = COEFF[i2];
        int i17 = -2;
        int i18 = 0;
        while (i17 < i11 + 3) {
            int i19 = ((i17 + i3) << i7) + i8;
            int i20 = i18;
            int i21 = 0;
            while (i21 < i10) {
                this.tmp[i20] = getPix6(bArr, i5, i6, i21 + i, i19, i7, i8, iArr2);
                i21++;
                i20++;
                i17 = i17;
            }
            i17++;
            i18 = i20;
        }
        int[] iArr3 = COEFF[i4];
        int i22 = i14;
        for (int i23 = 0; i23 < i11; i23++) {
            int i24 = 0;
            while (i24 < i10) {
                int[] iArr4 = this.tmp;
                iArr[i13] = (((((((iArr4[i22 - i14] * iArr3[0]) + (iArr4[i22 - i10] * iArr3[1])) + (iArr4[i22] * iArr3[2])) + (iArr4[i22 + i10] * iArr3[3])) + (iArr4[i22 + i14] * iArr3[4])) + (iArr4[i22 + i15] * iArr3[5])) + 8192) >> 14;
                i24++;
                i22++;
                i13++;
            }
            i13 += i16;
        }
    }

    public int getPix6(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        int i7 = i - 1;
        int iClip = MathUtil.clip(i3 - 2, 0, i7);
        int iClip2 = MathUtil.clip(i3 - 1, 0, i7);
        int iClip3 = MathUtil.clip(i3, 0, i7);
        int iClip4 = MathUtil.clip(i3 + 1, 0, i7);
        int iClip5 = MathUtil.clip(i3 + 2, 0, i7);
        int iClip6 = MathUtil.clip(i3 + 3, 0, i7);
        int iClip7 = MathUtil.clip(i4, i6, (i2 - (1 << i5)) + i6) * i;
        return (bArr[iClip + iClip7] * iArr[0]) + (bArr[iClip2 + iClip7] * iArr[1]) + (bArr[iClip3 + iClip7] * iArr[2]) + (bArr[iClip4 + iClip7] * iArr[3]) + (bArr[iClip5 + iClip7] * iArr[4]) + (bArr[iClip7 + iClip6] * iArr[5]) + 16384;
    }

    public int getPix6Vert(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        int i7 = 1 << i5;
        int i8 = (i2 - i7) + i6;
        int i9 = 2 << i5;
        int iClip = MathUtil.clip(i4 - i9, i6, i8);
        int iClip2 = MathUtil.clip(i4 - i7, i6, i8);
        int iClip3 = MathUtil.clip(i4, 0, i8);
        int iClip4 = MathUtil.clip(i7 + i4, i6, i8);
        int iClip5 = MathUtil.clip(i9 + i4, i6, i8);
        int iClip6 = MathUtil.clip(i4 + (3 << i5), i6, i8);
        int iClip7 = MathUtil.clip(i3, 0, i - 1);
        return (bArr[(iClip * i) + iClip7] * iArr[0]) + (bArr[(iClip2 * i) + iClip7] * iArr[1]) + (bArr[(iClip3 * i) + iClip7] * iArr[2]) + (bArr[(iClip4 * i) + iClip7] * iArr[3]) + (bArr[(iClip5 * i) + iClip7] * iArr[4]) + (bArr[(iClip6 * i) + iClip7] * iArr[5]) + 16384;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0098  */
    @Override // org.jcodec.codecs.mpeg12.MPEGPred
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void predictPlane(byte[] r16, int r17, int r18, int r19, int r20, int r21, int r22, int[] r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.mpeg12.MPEGPredOct.predictPlane(byte[], int, int, int, int, int, int, int[], int, int, int, int):void");
    }
}
