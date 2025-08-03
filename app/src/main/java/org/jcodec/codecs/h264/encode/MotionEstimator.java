package org.jcodec.codecs.h264.encode;

import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class MotionEstimator {
    private int maxSearchRange;

    public MotionEstimator(int i) {
        this.maxSearchRange = i;
    }

    private int sad(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = (i3 * i) + i2;
        int iAbs = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < 16; i6++) {
            int i7 = 0;
            while (i7 < 16) {
                iAbs += MathUtil.abs(bArr[i4] - bArr2[i5]);
                i7++;
                i4++;
                i5++;
            }
            i4 += i - 16;
        }
        return iAbs;
    }

    public int[] estimate(Picture picture, byte[] bArr, int i, int i2, int i3, int i4) {
        int i5;
        int iSad;
        int i6;
        int iSad2;
        int i7 = this.maxSearchRange;
        byte[] bArr2 = new byte[((i7 * 2) + 16) * ((i7 * 2) + 16)];
        int i8 = i << 4;
        int i9 = i2 << 4;
        int iMax = Math.max(i8 - i7, 0);
        int iMax2 = Math.max(i9 - this.maxSearchRange, 0);
        int i10 = i8 - iMax;
        int i11 = i9 - iMax2;
        int iMin = Math.min((this.maxSearchRange + i8) + 16, picture.getPlaneWidth(0)) - iMax;
        int iMin2 = Math.min((this.maxSearchRange + i9) + 16, picture.getPlaneHeight(0)) - iMax2;
        MBEncoderHelper.takeSafe(picture.getPlaneData(0), picture.getPlaneWidth(0), picture.getPlaneHeight(0), iMax, iMax2, bArr2, iMin, iMin2);
        int iSad3 = sad(bArr2, iMin, bArr, i10, i11);
        int i12 = 0;
        int i13 = i10;
        int i14 = i11;
        while (i12 < this.maxSearchRange) {
            int iSad4 = i13 > 0 ? sad(bArr2, iMin, bArr, i13 - 1, i14) : Integer.MAX_VALUE;
            int iSad5 = i13 < iMin + (-1) ? sad(bArr2, iMin, bArr, i13 + 1, i14) : Integer.MAX_VALUE;
            if (i14 > 0) {
                i5 = iSad5;
                iSad = sad(bArr2, iMin, bArr, i13, i14 - 1);
            } else {
                i5 = iSad5;
                iSad = Integer.MAX_VALUE;
            }
            if (i14 < iMin2 - 1) {
                i6 = iSad;
                iSad2 = sad(bArr2, iMin, bArr, i13, i14 + 1);
            } else {
                i6 = iSad;
                iSad2 = Integer.MAX_VALUE;
            }
            int iMin3 = Math.min(Math.min(Math.min(iSad4, i5), i6), iSad2);
            if (iMin3 > iSad3) {
                break;
            }
            if (iSad4 == iMin3) {
                i13--;
            } else if (i5 == iMin3) {
                i13++;
            } else {
                i14 = i6 == iMin3 ? i14 - 1 : i14 + 1;
            }
            i12++;
            iSad3 = iMin3;
        }
        return new int[]{(i13 - i10) << 2, (i14 - i11) << 2};
    }
}
