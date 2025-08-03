package org.jcodec.codecs.h264.encode;

import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class MBEncoderHelper {
    private static void pubBlkOnePlane(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5) {
        int i6 = (i5 * i) + i4;
        int i7 = 0;
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = 0;
            while (i9 < i2) {
                bArr[i6] = bArr2[i7];
                i9++;
                i6++;
                i7++;
            }
            i6 += i - i2;
        }
    }

    public static final void putBlk(byte[] bArr, int[] iArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5) {
        int i6 = 1 << i;
        int i7 = (i3 << i) + i2;
        int i8 = 0;
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = i7;
            for (int i11 = 0; i11 < i4; i11 += 4) {
                bArr[i10] = (byte) MathUtil.clip(iArr[i8] + bArr2[i8], -128, 127);
                int i12 = i8 + 1;
                bArr[i10 + 1] = (byte) MathUtil.clip(iArr[i12] + bArr2[i12], -128, 127);
                int i13 = i8 + 2;
                bArr[i10 + 2] = (byte) MathUtil.clip(iArr[i13] + bArr2[i13], -128, 127);
                int i14 = i8 + 3;
                bArr[i10 + 3] = (byte) MathUtil.clip(iArr[i14] + bArr2[i14], -128, 127);
                i8 += 4;
                i10 += 4;
            }
            i7 += i6;
        }
    }

    public static final void putBlkPic(Picture picture, Picture picture2, int i, int i2) {
        if (picture.getColor() != picture2.getColor()) {
            throw new RuntimeException("Incompatible color");
        }
        for (int i3 = 0; i3 < picture.getColor().nComp; i3++) {
            pubBlkOnePlane(picture.getPlaneData(i3), picture.getPlaneWidth(i3), picture2.getPlaneData(i3), picture2.getPlaneWidth(i3), picture2.getPlaneHeight(i3), i >> picture.getColor().compWidth[i3], i2 >> picture.getColor().compHeight[i3]);
        }
    }

    public static final void take(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2, int i5, int i6) {
        if (i3 + i5 >= i || i4 + i6 >= i2) {
            takeExtendBorder(bArr, i, i2, i3, i4, bArr2, i5, i6);
        } else {
            takeSafe(bArr, i, i2, i3, i4, bArr2, i5, i6);
        }
    }

    public static final void takeExtendBorder(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        int i11 = i4;
        while (true) {
            i7 = i4 + i6;
            if (i11 >= Math.min(i7, i2)) {
                break;
            }
            int iMin = (i11 * i) + Math.min(i3, i);
            int i12 = i3;
            while (true) {
                i9 = i3 + i5;
                if (i12 >= Math.min(i9, i)) {
                    break;
                }
                bArr2[i10] = bArr[iMin];
                i12++;
                i10++;
                iMin++;
            }
            int i13 = iMin - 1;
            while (i12 < i9) {
                bArr2[i10] = bArr[i13];
                i12++;
                i10++;
            }
            i11++;
        }
        while (i11 < i7) {
            int iMin2 = ((i2 * i) - i) + Math.min(i3, i);
            int i14 = i3;
            while (true) {
                i8 = i3 + i5;
                if (i14 >= Math.min(i8, i)) {
                    break;
                }
                bArr2[i10] = bArr[iMin2];
                i14++;
                i10++;
                iMin2++;
            }
            int i15 = iMin2 - 1;
            while (i14 < i8) {
                bArr2[i10] = bArr[i15];
                i14++;
                i10++;
            }
            i11++;
        }
    }

    public static final void takeSafe(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2, int i5, int i6) {
        int i7 = (i4 * i) + i3;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            int i10 = 0;
            int i11 = i7;
            while (i10 < i5) {
                bArr2[i9] = bArr[i11];
                i10++;
                i9++;
                i11++;
            }
            i8++;
            i7 += i;
        }
    }

    public static final void takeSafe2(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) {
        int i7 = (i4 * i) + i3;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            int i10 = 0;
            int i11 = i7;
            while (i10 < i5) {
                iArr[i9] = bArr[i11];
                i10++;
                i9++;
                i11++;
            }
            i8++;
            i7 += i;
        }
    }

    public static final void takeSubtract(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr, byte[] bArr2, int i5, int i6) {
        if (i3 + i5 >= i || i4 + i6 >= i2) {
            takeSubtractUnsafe(bArr, i, i2, i3, i4, iArr, bArr2, i5, i6);
        } else {
            takeSubtractSafe(bArr, i, i2, i3, i4, iArr, bArr2, i5, i6);
        }
    }

    public static final void takeSubtractSafe(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr, byte[] bArr2, int i5, int i6) {
        int i7 = (i4 * i) + i3;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            int i10 = 0;
            int i11 = i7;
            while (i10 < i5) {
                iArr[i9] = bArr[i11] - bArr2[i9];
                int i12 = i9 + 1;
                iArr[i12] = bArr[i11 + 1] - bArr2[i12];
                int i13 = i9 + 2;
                iArr[i13] = bArr[i11 + 2] - bArr2[i13];
                int i14 = i9 + 3;
                iArr[i14] = bArr[i11 + 3] - bArr2[i14];
                i10 += 4;
                i9 += 4;
                i11 += 4;
            }
            i8++;
            i7 += i;
        }
    }

    public static final void takeSubtractUnsafe(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr, byte[] bArr2, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        int i11 = i4;
        while (true) {
            i7 = i4 + i6;
            if (i11 >= Math.min(i7, i2)) {
                break;
            }
            int iMin = (i11 * i) + Math.min(i3, i);
            int i12 = i3;
            while (true) {
                i9 = i3 + i5;
                if (i12 >= Math.min(i9, i)) {
                    break;
                }
                iArr[i10] = bArr[iMin] - bArr2[i10];
                i12++;
                i10++;
                iMin++;
            }
            int i13 = iMin - 1;
            while (i12 < i9) {
                iArr[i10] = bArr[i13] - bArr2[i10];
                i12++;
                i10++;
            }
            i11++;
        }
        while (i11 < i7) {
            int iMin2 = ((i2 * i) - i) + Math.min(i3, i);
            int i14 = i3;
            while (true) {
                i8 = i3 + i5;
                if (i14 >= Math.min(i8, i)) {
                    break;
                }
                iArr[i10] = bArr[iMin2] - bArr2[i10];
                i14++;
                i10++;
                iMin2++;
            }
            int i15 = iMin2 - 1;
            while (i14 < i8) {
                iArr[i10] = bArr[i15] - bArr2[i10];
                i14++;
                i10++;
            }
            i11++;
        }
    }
}
