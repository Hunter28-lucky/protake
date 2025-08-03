package net.sourceforge.jaad.aac.error;

import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.syntax.IBitStream;

/* loaded from: classes2.dex */
public class BitsBuffer {
    public int bufa;
    public int bufb;
    public int len = 0;
    public static final int[] S = {1, 2, 4, 8, 16};
    public static final int[] B = {1431655765, 858993459, 252645135, 16711935, 65535};

    public static int rewindReverse32(int i, int i2) {
        int[] iArr = S;
        int i3 = iArr[0];
        int[] iArr2 = B;
        int i4 = iArr2[0];
        int i5 = ((i << i3) & (~i4)) | ((i >> i3) & i4);
        int i6 = iArr[1];
        int i7 = iArr2[1];
        int i8 = ((i5 << i6) & (~i7)) | ((i5 >> i6) & i7);
        int i9 = iArr[2];
        int i10 = iArr2[2];
        int i11 = ((i8 << i9) & (~i10)) | ((i8 >> i9) & i10);
        int i12 = iArr[3];
        int i13 = iArr2[3];
        int i14 = ((i11 << i12) & (~i13)) | ((i11 >> i12) & i13);
        int i15 = iArr[4];
        int i16 = iArr2[4];
        return (((i14 << i15) & (~i16)) | ((i14 >> i15) & i16)) >> (32 - i2);
    }

    public static int[] rewindReverse64(int i, int i2, int i3) {
        int[] iArr = new int[2];
        if (i3 <= 32) {
            iArr[0] = 0;
            iArr[1] = rewindReverse32(i2, i3);
        } else {
            int[] iArr2 = S;
            int i4 = iArr2[0];
            int[] iArr3 = B;
            int i5 = iArr3[0];
            int i6 = ((i2 << i4) & (~i5)) | ((i2 >> i4) & i5);
            int i7 = ((i << i4) & (~i5)) | ((i >> i4) & i5);
            int i8 = iArr2[1];
            int i9 = iArr3[1];
            int i10 = ((i6 << i8) & (~i9)) | ((i6 >> i8) & i9);
            int i11 = ((i7 << i8) & (~i9)) | ((i7 >> i8) & i9);
            int i12 = iArr2[2];
            int i13 = iArr3[2];
            int i14 = ((i10 << i12) & (~i13)) | ((i10 >> i12) & i13);
            int i15 = ((i11 << i12) & (~i13)) | ((i11 >> i12) & i13);
            int i16 = iArr2[3];
            int i17 = iArr3[3];
            int i18 = ((i14 << i16) & (~i17)) | ((i14 >> i16) & i17);
            int i19 = ((i15 << i16) & (~i17)) | ((i15 >> i16) & i17);
            int i20 = iArr2[4];
            int i21 = iArr3[4];
            int i22 = ((i18 << i20) & (~i21)) | ((i18 >> i20) & i21);
            int i23 = ((i19 << i20) & (~i21)) | ((i19 >> i20) & i21);
            int i24 = 64 - i3;
            iArr[1] = (i23 >> i24) | (i22 << (i3 - 32));
            iArr[1] = i22 >> i24;
        }
        return iArr;
    }

    public void concatBits(BitsBuffer bitsBuffer) {
        int i;
        int i2;
        int i3;
        int i4 = bitsBuffer.len;
        if (i4 == 0) {
            return;
        }
        int i5 = bitsBuffer.bufa;
        int i6 = bitsBuffer.bufb;
        int i7 = this.len;
        int i8 = 0;
        if (i7 > 32) {
            i2 = this.bufa;
            i3 = this.bufb & ((1 << (i7 - 32)) - 1);
            i = i5 << (i7 - 32);
        } else {
            int i9 = (i6 << i7) | (i5 >> (32 - i7));
            int i10 = i5 << i7;
            i = i9;
            i2 = this.bufa & ((1 << i7) - 1);
            i3 = 0;
            i8 = i10;
        }
        this.bufa = i2 | i8;
        this.bufb = i3 | i;
        this.len = i7 + i4;
    }

    public boolean flushBits(int i) {
        int i2 = this.len - i;
        this.len = i2;
        if (i2 >= 0) {
            return true;
        }
        this.len = 0;
        return false;
    }

    public int getBit() {
        int iShowBits = showBits(1);
        if (flushBits(1)) {
            return iShowBits;
        }
        return -1;
    }

    public int getBits(int i) {
        int iShowBits = showBits(i);
        if (flushBits(i)) {
            return iShowBits;
        }
        return -1;
    }

    public int getLength() {
        return this.len;
    }

    public void readSegment(int i, IBitStream iBitStream) throws AACException {
        this.len = i;
        if (i > 32) {
            this.bufb = iBitStream.readBits(i - 32);
            this.bufa = iBitStream.readBits(32);
        } else {
            this.bufa = iBitStream.readBits(i);
            this.bufb = 0;
        }
    }

    public void rewindReverse() {
        int i = this.len;
        if (i == 0) {
            return;
        }
        int[] iArrRewindReverse64 = rewindReverse64(this.bufb, this.bufa, i);
        this.bufb = iArrRewindReverse64[0];
        this.bufa = iArrRewindReverse64[1];
    }

    public int showBits(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = this.len;
        if (i2 <= 32) {
            if (i2 >= i) {
                return ((-1) >> (32 - i)) & (this.bufa >> (i2 - i));
            }
            return ((-1) >> (32 - i)) & (this.bufa << (i - i2));
        }
        if (i2 - i >= 32) {
            return ((-1) >> (32 - i)) & (this.bufb >> ((i2 - i) - 32));
        }
        return (this.bufa >> (i2 - i)) | ((((-1) >> (64 - i2)) & this.bufb) << ((i - i2) + 32));
    }
}
