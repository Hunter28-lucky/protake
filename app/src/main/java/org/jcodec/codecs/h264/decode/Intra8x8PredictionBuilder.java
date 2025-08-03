package org.jcodec.codecs.h264.decode;

import org.jcodec.common.Preconditions;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class Intra8x8PredictionBuilder {
    public byte[] topBuf = new byte[16];
    public byte[] leftBuf = new byte[8];
    public byte[] genBuf = new byte[24];

    private void interpolateLeft(boolean z, byte[] bArr, byte[] bArr2, int i, byte[] bArr3) {
        bArr3[0] = (byte) (((((z ? bArr[i >> 2] : bArr2[0]) + (bArr2[i] << 1)) + bArr2[i + 1]) + 2) >> 2);
        for (int i2 = 1; i2 < 7; i2++) {
            int i3 = i + i2;
            bArr3[i2] = (byte) ((((bArr2[i3 - 1] + (bArr2[i3] << 1)) + bArr2[i3 + 1]) + 2) >> 2);
        }
        byte b = bArr2[i + 6];
        byte b2 = bArr2[i + 7];
        bArr3[7] = (byte) ((((b + (b2 << 1)) + b2) + 2) >> 2);
    }

    private void interpolateTop(boolean z, boolean z2, byte[] bArr, byte[] bArr2, int i, int i2, byte[] bArr3) {
        bArr3[0] = (byte) (((((z ? bArr[i2 >> 2] : bArr2[i]) + (bArr2[i] << 1)) + bArr2[i + 1]) + 2) >> 2);
        int i3 = 1;
        while (i3 < 7) {
            int i4 = i + i3;
            bArr3[i3] = (byte) ((((bArr2[i4 - 1] + (bArr2[i4] << 1)) + bArr2[i4 + 1]) + 2) >> 2);
            i3++;
        }
        if (z2) {
            while (i3 < 15) {
                int i5 = i + i3;
                bArr3[i3] = (byte) ((((bArr2[i5 - 1] + (bArr2[i5] << 1)) + bArr2[i5 + 1]) + 2) >> 2);
                i3++;
            }
            byte b = bArr2[i + 14];
            byte b2 = bArr2[i + 15];
            bArr3[15] = (byte) ((((b + (b2 << 1)) + b2) + 2) >> 2);
            return;
        }
        byte b3 = bArr2[i + 6];
        int i6 = i + 7;
        byte b4 = bArr2[i6];
        bArr3[7] = (byte) ((((b3 + (b4 << 1)) + b4) + 2) >> 2);
        for (int i7 = 8; i7 < 16; i7++) {
            bArr3[i7] = bArr2[i6];
        }
    }

    private int interpolateTopLeft(boolean z, boolean z2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3) {
        byte b = bArr[i3 >> 2];
        return ((((b << 1) + (z ? bArr2[i + i2] : b)) + (z2 ? bArr3[i3] : b)) + 2) >> 2;
    }

    public void copyAdd(byte[] bArr, int i, int[] iArr, int i2, int i3, byte[] bArr2) {
        bArr2[i2] = (byte) MathUtil.clip(iArr[i3] + bArr[i], -128, 127);
        bArr2[i2 + 1] = (byte) MathUtil.clip(iArr[i3 + 1] + bArr[i + 1], -128, 127);
        bArr2[i2 + 2] = (byte) MathUtil.clip(iArr[i3 + 2] + bArr[i + 2], -128, 127);
        bArr2[i2 + 3] = (byte) MathUtil.clip(iArr[i3 + 3] + bArr[i + 3], -128, 127);
        bArr2[i2 + 4] = (byte) MathUtil.clip(iArr[i3 + 4] + bArr[i + 4], -128, 127);
        bArr2[i2 + 5] = (byte) MathUtil.clip(iArr[i3 + 5] + bArr[i + 5], -128, 127);
        bArr2[i2 + 6] = (byte) MathUtil.clip(iArr[i3 + 6] + bArr[i + 6], -128, 127);
        bArr2[i2 + 7] = (byte) MathUtil.clip(iArr[i3 + 7] + bArr[i + 7], -128, 127);
    }

    public void fillAdd(int[] iArr, int i, int i2, byte[] bArr) {
        int i3 = 0;
        for (int i4 = 0; i4 < 8; i4++) {
            bArr[i] = (byte) MathUtil.clip(iArr[i3] + i2, -128, 127);
            bArr[i + 1] = (byte) MathUtil.clip(iArr[i3 + 1] + i2, -128, 127);
            bArr[i + 2] = (byte) MathUtil.clip(iArr[i3 + 2] + i2, -128, 127);
            bArr[i + 3] = (byte) MathUtil.clip(iArr[i3 + 3] + i2, -128, 127);
            bArr[i + 4] = (byte) MathUtil.clip(iArr[i3 + 4] + i2, -128, 127);
            bArr[i + 5] = (byte) MathUtil.clip(iArr[i3 + 5] + i2, -128, 127);
            bArr[i + 6] = (byte) MathUtil.clip(iArr[i3 + 6] + i2, -128, 127);
            bArr[i + 7] = (byte) MathUtil.clip(iArr[i3 + 7] + i2, -128, 127);
            i += 16;
            i3 += 8;
        }
    }

    public void predictDC(int[] iArr, boolean z, boolean z2, boolean z3, boolean z4, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, byte[] bArr4) {
        if (z4 && z3) {
            interpolateTop(z, z2, bArr, bArr3, i + i2, i3, this.topBuf);
            interpolateLeft(z, bArr, bArr2, i3, this.leftBuf);
            byte[] bArr5 = this.topBuf;
            int i4 = bArr5[0] + bArr5[1] + bArr5[2] + bArr5[3];
            int i5 = bArr5[4] + bArr5[5] + bArr5[6] + bArr5[7];
            byte[] bArr6 = this.leftBuf;
            int i6 = bArr6[0] + bArr6[1] + bArr6[2] + bArr6[3];
            fillAdd(iArr, (i3 << 4) + i2, ((((i4 + i5) + i6) + (((bArr6[4] + bArr6[5]) + bArr6[6]) + bArr6[7])) + 8) >> 4, bArr4);
            return;
        }
        if (z3) {
            interpolateLeft(z, bArr, bArr2, i3, this.leftBuf);
            byte[] bArr7 = this.leftBuf;
            fillAdd(iArr, (i3 << 4) + i2, (((((bArr7[0] + bArr7[1]) + bArr7[2]) + bArr7[3]) + (((bArr7[4] + bArr7[5]) + bArr7[6]) + bArr7[7])) + 4) >> 3, bArr4);
            return;
        }
        if (!z4) {
            fillAdd(iArr, (i3 << 4) + i2, 0, bArr4);
            return;
        }
        interpolateTop(z, z2, bArr, bArr3, i + i2, i3, this.topBuf);
        byte[] bArr8 = this.topBuf;
        fillAdd(iArr, (i3 << 4) + i2, (((((bArr8[0] + bArr8[1]) + bArr8[2]) + bArr8[3]) + (((bArr8[4] + bArr8[5]) + bArr8[6]) + bArr8[7])) + 4) >> 3, bArr4);
    }

    public void predictDiagonalDownLeft(int[] iArr, boolean z, boolean z2, boolean z3, byte[] bArr, byte[] bArr2, int i, int i2, int i3, byte[] bArr3) {
        interpolateTop(z, z3, bArr, bArr2, i + i2, i3, this.topBuf);
        byte[] bArr4 = this.genBuf;
        byte[] bArr5 = this.topBuf;
        byte b = bArr5[0];
        byte b2 = bArr5[2];
        byte b3 = bArr5[1];
        bArr4[0] = (byte) ((((b + b2) + (b3 << 1)) + 2) >> 2);
        byte b4 = bArr5[3];
        bArr4[1] = (byte) ((((b3 + b4) + (b2 << 1)) + 2) >> 2);
        byte b5 = bArr5[4];
        bArr4[2] = (byte) ((((b2 + b5) + (b4 << 1)) + 2) >> 2);
        byte b6 = bArr5[5];
        bArr4[3] = (byte) ((((b4 + b6) + (b5 << 1)) + 2) >> 2);
        byte b7 = bArr5[6];
        bArr4[4] = (byte) ((((b5 + b7) + (b6 << 1)) + 2) >> 2);
        byte b8 = bArr5[7];
        bArr4[5] = (byte) ((((b6 + b8) + (b7 << 1)) + 2) >> 2);
        byte b9 = bArr5[8];
        bArr4[6] = (byte) ((((b7 + b9) + (b8 << 1)) + 2) >> 2);
        byte b10 = bArr5[9];
        bArr4[7] = (byte) ((((b8 + b10) + (b9 << 1)) + 2) >> 2);
        byte b11 = bArr5[10];
        bArr4[8] = (byte) ((((b9 + b11) + (b10 << 1)) + 2) >> 2);
        byte b12 = bArr5[11];
        bArr4[9] = (byte) ((((b10 + b12) + (b11 << 1)) + 2) >> 2);
        byte b13 = bArr5[12];
        bArr4[10] = (byte) ((((b11 + b13) + (b12 << 1)) + 2) >> 2);
        byte b14 = bArr5[13];
        bArr4[11] = (byte) ((((b12 + b14) + (b13 << 1)) + 2) >> 2);
        byte b15 = bArr5[14];
        bArr4[12] = (byte) ((((b13 + b15) + (b14 << 1)) + 2) >> 2);
        byte b16 = bArr5[15];
        bArr4[13] = (byte) ((((b14 + b16) + (b15 << 1)) + 2) >> 2);
        bArr4[14] = (byte) ((((b15 + b16) + (b16 << 1)) + 2) >> 2);
        int i4 = (i3 << 4) + i2;
        copyAdd(bArr4, 0, iArr, i4, 0, bArr3);
        copyAdd(this.genBuf, 1, iArr, i4 + 16, 8, bArr3);
        copyAdd(this.genBuf, 2, iArr, i4 + 32, 16, bArr3);
        copyAdd(this.genBuf, 3, iArr, i4 + 48, 24, bArr3);
        copyAdd(this.genBuf, 4, iArr, i4 + 64, 32, bArr3);
        copyAdd(this.genBuf, 5, iArr, i4 + 80, 40, bArr3);
        copyAdd(this.genBuf, 6, iArr, i4 + 96, 48, bArr3);
        copyAdd(this.genBuf, 7, iArr, i4 + 112, 56, bArr3);
    }

    public void predictDiagonalDownRight(int[] iArr, boolean z, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, byte[] bArr4) {
        interpolateTop(true, z, bArr, bArr3, i + i2, i3, this.topBuf);
        interpolateLeft(true, bArr, bArr2, i3, this.leftBuf);
        int iInterpolateTopLeft = interpolateTopLeft(true, true, bArr, bArr3, bArr2, i, i2, i3);
        byte[] bArr5 = this.genBuf;
        byte[] bArr6 = this.leftBuf;
        byte b = bArr6[7];
        byte b2 = bArr6[5];
        byte b3 = bArr6[6];
        bArr5[0] = (byte) ((((b + b2) + (b3 << 1)) + 2) >> 2);
        byte b4 = bArr6[4];
        bArr5[1] = (byte) ((((b3 + b4) + (b2 << 1)) + 2) >> 2);
        byte b5 = bArr6[3];
        bArr5[2] = (byte) ((((b2 + b5) + (b4 << 1)) + 2) >> 2);
        byte b6 = bArr6[2];
        bArr5[3] = (byte) ((((b4 + b6) + (b5 << 1)) + 2) >> 2);
        byte b7 = bArr6[3];
        byte b8 = bArr6[1];
        bArr5[4] = (byte) ((((b7 + b8) + (b6 << 1)) + 2) >> 2);
        byte b9 = bArr6[0];
        bArr5[5] = (byte) ((((b6 + b9) + (b8 << 1)) + 2) >> 2);
        bArr5[6] = (byte) ((((b8 + iInterpolateTopLeft) + (b9 << 1)) + 2) >> 2);
        byte[] bArr7 = this.topBuf;
        byte b10 = bArr7[0];
        bArr5[7] = (byte) ((((b9 + b10) + (iInterpolateTopLeft << 1)) + 2) >> 2);
        byte b11 = bArr7[1];
        bArr5[8] = (byte) ((((iInterpolateTopLeft + b11) + (b10 << 1)) + 2) >> 2);
        byte b12 = bArr7[2];
        bArr5[9] = (byte) ((((b10 + b12) + (b11 << 1)) + 2) >> 2);
        byte b13 = bArr7[3];
        bArr5[10] = (byte) ((((b11 + b13) + (b12 << 1)) + 2) >> 2);
        byte b14 = bArr7[4];
        bArr5[11] = (byte) ((((b12 + b14) + (b13 << 1)) + 2) >> 2);
        byte b15 = bArr7[5];
        bArr5[12] = (byte) ((((b13 + b15) + (b14 << 1)) + 2) >> 2);
        byte b16 = bArr7[6];
        bArr5[13] = (byte) ((((b14 + b16) + (b15 << 1)) + 2) >> 2);
        bArr5[14] = (byte) ((((b15 + bArr7[7]) + (b16 << 1)) + 2) >> 2);
        int i4 = (i3 << 4) + i2;
        copyAdd(bArr5, 7, iArr, i4, 0, bArr4);
        copyAdd(this.genBuf, 6, iArr, i4 + 16, 8, bArr4);
        copyAdd(this.genBuf, 5, iArr, i4 + 32, 16, bArr4);
        copyAdd(this.genBuf, 4, iArr, i4 + 48, 24, bArr4);
        copyAdd(this.genBuf, 3, iArr, i4 + 64, 32, bArr4);
        copyAdd(this.genBuf, 2, iArr, i4 + 80, 40, bArr4);
        copyAdd(this.genBuf, 1, iArr, i4 + 96, 48, bArr4);
        copyAdd(this.genBuf, 0, iArr, i4 + 112, 56, bArr4);
    }

    public void predictHorizontal(int[] iArr, boolean z, byte[] bArr, byte[] bArr2, int i, int i2, int i3, byte[] bArr3) {
        interpolateLeft(z, bArr, bArr2, i3, this.leftBuf);
        int i4 = (i3 << 4) + i2;
        int i5 = 0;
        for (int i6 = 0; i6 < 8; i6++) {
            bArr3[i4] = (byte) MathUtil.clip(iArr[i5] + this.leftBuf[i6], -128, 127);
            bArr3[i4 + 1] = (byte) MathUtil.clip(iArr[i5 + 1] + this.leftBuf[i6], -128, 127);
            bArr3[i4 + 2] = (byte) MathUtil.clip(iArr[i5 + 2] + this.leftBuf[i6], -128, 127);
            bArr3[i4 + 3] = (byte) MathUtil.clip(iArr[i5 + 3] + this.leftBuf[i6], -128, 127);
            bArr3[i4 + 4] = (byte) MathUtil.clip(iArr[i5 + 4] + this.leftBuf[i6], -128, 127);
            bArr3[i4 + 5] = (byte) MathUtil.clip(iArr[i5 + 5] + this.leftBuf[i6], -128, 127);
            bArr3[i4 + 6] = (byte) MathUtil.clip(iArr[i5 + 6] + this.leftBuf[i6], -128, 127);
            bArr3[i4 + 7] = (byte) MathUtil.clip(iArr[i5 + 7] + this.leftBuf[i6], -128, 127);
            i4 += 16;
            i5 += 8;
        }
    }

    public void predictHorizontalDown(int[] iArr, boolean z, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, byte[] bArr4) {
        interpolateTop(true, z, bArr, bArr3, i + i2, i3, this.topBuf);
        interpolateLeft(true, bArr, bArr2, i3, this.leftBuf);
        int iInterpolateTopLeft = interpolateTopLeft(true, true, bArr, bArr3, bArr2, i, i2, i3);
        byte[] bArr5 = this.genBuf;
        byte[] bArr6 = this.leftBuf;
        byte b = bArr6[7];
        byte b2 = bArr6[6];
        bArr5[0] = (byte) (((b + b2) + 1) >> 1);
        byte b3 = bArr6[5];
        bArr5[1] = (byte) ((((b + b3) + (b2 << 1)) + 2) >> 2);
        bArr5[2] = (byte) (((b2 + b3) + 1) >> 1);
        byte b4 = bArr6[4];
        bArr5[3] = (byte) ((((b2 + b4) + (b3 << 1)) + 2) >> 2);
        bArr5[4] = (byte) (((b4 + b3) + 1) >> 1);
        byte b5 = bArr6[3];
        byte b6 = bArr6[4];
        bArr5[5] = (byte) ((((b3 + b5) + (b6 << 1)) + 2) >> 2);
        bArr5[6] = (byte) (((b6 + b5) + 1) >> 1);
        byte b7 = bArr6[2];
        bArr5[7] = (byte) ((((b6 + b7) + (b5 << 1)) + 2) >> 2);
        bArr5[8] = (byte) (((b5 + b7) + 1) >> 1);
        byte b8 = bArr6[1];
        bArr5[9] = (byte) ((((b5 + b8) + (b7 << 1)) + 2) >> 2);
        bArr5[10] = (byte) (((b7 + b8) + 1) >> 1);
        byte b9 = bArr6[0];
        bArr5[11] = (byte) ((((b7 + b9) + (b8 << 1)) + 2) >> 2);
        bArr5[12] = (byte) (((b8 + b9) + 1) >> 1);
        bArr5[13] = (byte) ((((b8 + iInterpolateTopLeft) + (b9 << 1)) + 2) >> 2);
        bArr5[14] = (byte) (((b9 + iInterpolateTopLeft) + 1) >> 1);
        byte[] bArr7 = this.topBuf;
        byte b10 = bArr7[0];
        bArr5[15] = (byte) ((((b9 + b10) + (iInterpolateTopLeft << 1)) + 2) >> 2);
        byte b11 = bArr7[1];
        bArr5[16] = (byte) ((((iInterpolateTopLeft + b11) + (b10 << 1)) + 2) >> 2);
        byte b12 = bArr7[2];
        bArr5[17] = (byte) ((((b10 + b12) + (b11 << 1)) + 2) >> 2);
        byte b13 = bArr7[3];
        bArr5[18] = (byte) ((((b11 + b13) + (b12 << 1)) + 2) >> 2);
        byte b14 = bArr7[4];
        bArr5[19] = (byte) ((((b12 + b14) + (b13 << 1)) + 2) >> 2);
        byte b15 = bArr7[5];
        bArr5[20] = (byte) ((((b13 + b15) + (b14 << 1)) + 2) >> 2);
        bArr5[21] = (byte) ((((b14 + bArr7[6]) + (b15 << 1)) + 2) >> 2);
        int i4 = (i3 << 4) + i2;
        copyAdd(bArr5, 14, iArr, i4, 0, bArr4);
        copyAdd(this.genBuf, 12, iArr, i4 + 16, 8, bArr4);
        copyAdd(this.genBuf, 10, iArr, i4 + 32, 16, bArr4);
        copyAdd(this.genBuf, 8, iArr, i4 + 48, 24, bArr4);
        copyAdd(this.genBuf, 6, iArr, i4 + 64, 32, bArr4);
        copyAdd(this.genBuf, 4, iArr, i4 + 80, 40, bArr4);
        copyAdd(this.genBuf, 2, iArr, i4 + 96, 48, bArr4);
        copyAdd(this.genBuf, 0, iArr, i4 + 112, 56, bArr4);
    }

    public void predictHorizontalUp(int[] iArr, boolean z, byte[] bArr, byte[] bArr2, int i, int i2, int i3, byte[] bArr3) {
        interpolateLeft(z, bArr, bArr2, i3, this.leftBuf);
        byte[] bArr4 = this.genBuf;
        byte[] bArr5 = this.leftBuf;
        byte b = bArr5[0];
        byte b2 = bArr5[1];
        bArr4[0] = (byte) (((b + b2) + 1) >> 1);
        byte b3 = bArr5[2];
        bArr4[1] = (byte) ((((bArr5[0] + b3) + (b2 << 1)) + 2) >> 2);
        byte b4 = bArr5[1];
        bArr4[2] = (byte) (((b3 + b4) + 1) >> 1);
        int i4 = bArr5[3] + b4;
        byte b5 = bArr5[2];
        bArr4[3] = (byte) (((i4 + (b5 << 1)) + 2) >> 2);
        byte b6 = bArr5[3];
        bArr4[4] = (byte) (((b5 + b6) + 1) >> 1);
        byte b7 = bArr5[4];
        bArr4[5] = (byte) ((((b5 + b7) + (b6 << 1)) + 2) >> 2);
        bArr4[6] = (byte) (((b6 + b7) + 1) >> 1);
        byte b8 = bArr5[5];
        bArr4[7] = (byte) ((((b6 + b8) + (b7 << 1)) + 2) >> 2);
        bArr4[8] = (byte) (((b7 + b8) + 1) >> 1);
        byte b9 = bArr5[6];
        bArr4[9] = (byte) ((((b7 + b9) + (b8 << 1)) + 2) >> 2);
        bArr4[10] = (byte) (((b8 + b9) + 1) >> 1);
        byte b10 = bArr5[7];
        bArr4[11] = (byte) ((((b8 + b10) + (b9 << 1)) + 2) >> 2);
        bArr4[12] = (byte) (((b9 + b10) + 1) >> 1);
        bArr4[13] = (byte) ((((b9 + b10) + (b10 << 1)) + 2) >> 2);
        bArr4[21] = b10;
        bArr4[20] = b10;
        bArr4[19] = b10;
        bArr4[18] = b10;
        bArr4[17] = b10;
        bArr4[16] = b10;
        bArr4[15] = b10;
        bArr4[14] = b10;
        int i5 = (i3 << 4) + i2;
        copyAdd(bArr4, 0, iArr, i5, 0, bArr3);
        copyAdd(this.genBuf, 2, iArr, i5 + 16, 8, bArr3);
        copyAdd(this.genBuf, 4, iArr, i5 + 32, 16, bArr3);
        copyAdd(this.genBuf, 6, iArr, i5 + 48, 24, bArr3);
        copyAdd(this.genBuf, 8, iArr, i5 + 64, 32, bArr3);
        copyAdd(this.genBuf, 10, iArr, i5 + 80, 40, bArr3);
        copyAdd(this.genBuf, 12, iArr, i5 + 96, 48, bArr3);
        copyAdd(this.genBuf, 14, iArr, i5 + 112, 56, bArr3);
    }

    public void predictVertical(int[] iArr, boolean z, boolean z2, byte[] bArr, byte[] bArr2, int i, int i2, int i3, byte[] bArr3) {
        interpolateTop(z, z2, bArr, bArr2, i + i2, i3, this.topBuf);
        int i4 = (i3 << 4) + i2;
        int i5 = 0;
        for (int i6 = 0; i6 < 8; i6++) {
            bArr3[i4] = (byte) MathUtil.clip(iArr[i5] + this.topBuf[0], -128, 127);
            bArr3[i4 + 1] = (byte) MathUtil.clip(iArr[i5 + 1] + this.topBuf[1], -128, 127);
            bArr3[i4 + 2] = (byte) MathUtil.clip(iArr[i5 + 2] + this.topBuf[2], -128, 127);
            bArr3[i4 + 3] = (byte) MathUtil.clip(iArr[i5 + 3] + this.topBuf[3], -128, 127);
            bArr3[i4 + 4] = (byte) MathUtil.clip(iArr[i5 + 4] + this.topBuf[4], -128, 127);
            bArr3[i4 + 5] = (byte) MathUtil.clip(iArr[i5 + 5] + this.topBuf[5], -128, 127);
            bArr3[i4 + 6] = (byte) MathUtil.clip(iArr[i5 + 6] + this.topBuf[6], -128, 127);
            bArr3[i4 + 7] = (byte) MathUtil.clip(iArr[i5 + 7] + this.topBuf[7], -128, 127);
            i4 += 16;
            i5 += 8;
        }
    }

    public void predictVerticalLeft(int[] iArr, boolean z, boolean z2, byte[] bArr, byte[] bArr2, int i, int i2, int i3, byte[] bArr3) {
        interpolateTop(z, z2, bArr, bArr2, i + i2, i3, this.topBuf);
        byte[] bArr4 = this.genBuf;
        byte[] bArr5 = this.topBuf;
        byte b = bArr5[0];
        byte b2 = bArr5[1];
        bArr4[0] = (byte) (((b + b2) + 1) >> 1);
        byte b3 = bArr5[2];
        bArr4[1] = (byte) (((b2 + b3) + 1) >> 1);
        byte b4 = bArr5[3];
        bArr4[2] = (byte) (((b3 + b4) + 1) >> 1);
        byte b5 = bArr5[4];
        bArr4[3] = (byte) (((b4 + b5) + 1) >> 1);
        byte b6 = bArr5[5];
        bArr4[4] = (byte) (((b5 + b6) + 1) >> 1);
        byte b7 = bArr5[6];
        bArr4[5] = (byte) (((b6 + b7) + 1) >> 1);
        byte b8 = bArr5[7];
        bArr4[6] = (byte) (((b7 + b8) + 1) >> 1);
        byte b9 = bArr5[8];
        bArr4[7] = (byte) (((b8 + b9) + 1) >> 1);
        byte b10 = bArr5[9];
        bArr4[8] = (byte) (((b9 + b10) + 1) >> 1);
        byte b11 = bArr5[10];
        bArr4[9] = (byte) (((b10 + b11) + 1) >> 1);
        bArr4[10] = (byte) (((b11 + bArr5[11]) + 1) >> 1);
        byte b12 = bArr5[0];
        byte b13 = bArr5[2];
        byte b14 = bArr5[1];
        bArr4[11] = (byte) ((((b12 + b13) + (b14 << 1)) + 2) >> 2);
        byte b15 = bArr5[3];
        bArr4[12] = (byte) ((((b14 + b15) + (b13 << 1)) + 2) >> 2);
        byte b16 = bArr5[4];
        bArr4[13] = (byte) ((((b13 + b16) + (b15 << 1)) + 2) >> 2);
        byte b17 = bArr5[5];
        bArr4[14] = (byte) ((((b15 + b17) + (b16 << 1)) + 2) >> 2);
        byte b18 = bArr5[6];
        bArr4[15] = (byte) ((((b16 + b18) + (b17 << 1)) + 2) >> 2);
        byte b19 = bArr5[7];
        bArr4[16] = (byte) ((((b17 + b19) + (b18 << 1)) + 2) >> 2);
        byte b20 = bArr5[8];
        bArr4[17] = (byte) ((((b18 + b20) + (b19 << 1)) + 2) >> 2);
        byte b21 = bArr5[9];
        bArr4[18] = (byte) ((((b19 + b21) + (b20 << 1)) + 2) >> 2);
        byte b22 = bArr5[10];
        bArr4[19] = (byte) ((((b20 + b22) + (b21 << 1)) + 2) >> 2);
        byte b23 = bArr5[11];
        bArr4[20] = (byte) ((((b21 + b23) + (b22 << 1)) + 2) >> 2);
        bArr4[21] = (byte) ((((b22 + bArr5[12]) + (b23 << 1)) + 2) >> 2);
        int i4 = (i3 << 4) + i2;
        copyAdd(bArr4, 0, iArr, i4, 0, bArr3);
        copyAdd(this.genBuf, 11, iArr, i4 + 16, 8, bArr3);
        copyAdd(this.genBuf, 1, iArr, i4 + 32, 16, bArr3);
        copyAdd(this.genBuf, 12, iArr, i4 + 48, 24, bArr3);
        copyAdd(this.genBuf, 2, iArr, i4 + 64, 32, bArr3);
        copyAdd(this.genBuf, 13, iArr, i4 + 80, 40, bArr3);
        copyAdd(this.genBuf, 3, iArr, i4 + 96, 48, bArr3);
        copyAdd(this.genBuf, 14, iArr, i4 + 112, 56, bArr3);
    }

    public void predictVerticalRight(int[] iArr, boolean z, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, byte[] bArr4) {
        interpolateTop(true, z, bArr, bArr3, i + i2, i3, this.topBuf);
        interpolateLeft(true, bArr, bArr2, i3, this.leftBuf);
        int iInterpolateTopLeft = interpolateTopLeft(true, true, bArr, bArr3, bArr2, i, i2, i3);
        byte[] bArr5 = this.genBuf;
        byte[] bArr6 = this.leftBuf;
        byte b = bArr6[5];
        byte b2 = bArr6[3];
        bArr5[0] = (byte) ((((b + b2) + (bArr6[4] << 1)) + 2) >> 2);
        bArr5[1] = (byte) ((((b2 + bArr6[1]) + (bArr6[2] << 1)) + 2) >> 2);
        byte b3 = bArr6[1];
        byte b4 = bArr6[0];
        bArr5[2] = (byte) ((((b3 + iInterpolateTopLeft) + (b4 << 1)) + 2) >> 2);
        byte[] bArr7 = this.topBuf;
        byte b5 = bArr7[0];
        bArr5[3] = (byte) (((iInterpolateTopLeft + b5) + 1) >> 1);
        byte b6 = bArr7[1];
        bArr5[4] = (byte) (((b5 + b6) + 1) >> 1);
        byte b7 = bArr7[2];
        bArr5[5] = (byte) (((b6 + b7) + 1) >> 1);
        byte b8 = bArr7[3];
        bArr5[6] = (byte) (((b7 + b8) + 1) >> 1);
        byte b9 = bArr7[4];
        bArr5[7] = (byte) (((b8 + b9) + 1) >> 1);
        byte b10 = bArr7[5];
        bArr5[8] = (byte) (((b9 + b10) + 1) >> 1);
        byte b11 = bArr7[6];
        bArr5[9] = (byte) (((b10 + b11) + 1) >> 1);
        byte b12 = bArr7[7];
        bArr5[10] = (byte) (((b11 + b12) + 1) >> 1);
        byte b13 = bArr6[6];
        byte b14 = bArr6[4];
        bArr5[11] = (byte) ((((b13 + b14) + (bArr6[5] << 1)) + 2) >> 2);
        byte b15 = bArr6[2];
        bArr5[12] = (byte) ((((b14 + b15) + (bArr6[3] << 1)) + 2) >> 2);
        bArr5[13] = (byte) ((((b15 + b4) + (b3 << 1)) + 2) >> 2);
        bArr5[14] = (byte) ((((b4 + b5) + (iInterpolateTopLeft << 1)) + 2) >> 2);
        bArr5[15] = (byte) ((((iInterpolateTopLeft + b6) + (b5 << 1)) + 2) >> 2);
        bArr5[16] = (byte) ((((b5 + b7) + (b6 << 1)) + 2) >> 2);
        bArr5[17] = (byte) ((((b6 + b8) + (b7 << 1)) + 2) >> 2);
        bArr5[18] = (byte) ((((b7 + b9) + (b8 << 1)) + 2) >> 2);
        bArr5[19] = (byte) ((((b8 + b10) + (b9 << 1)) + 2) >> 2);
        bArr5[20] = (byte) ((((b9 + b11) + (b10 << 1)) + 2) >> 2);
        bArr5[21] = (byte) ((((b10 + b12) + (b11 << 1)) + 2) >> 2);
        int i4 = (i3 << 4) + i2;
        copyAdd(bArr5, 3, iArr, i4, 0, bArr4);
        copyAdd(this.genBuf, 14, iArr, i4 + 16, 8, bArr4);
        copyAdd(this.genBuf, 2, iArr, i4 + 32, 16, bArr4);
        copyAdd(this.genBuf, 13, iArr, i4 + 48, 24, bArr4);
        copyAdd(this.genBuf, 1, iArr, i4 + 64, 32, bArr4);
        copyAdd(this.genBuf, 12, iArr, i4 + 80, 40, bArr4);
        copyAdd(this.genBuf, 0, iArr, i4 + 96, 48, bArr4);
        copyAdd(this.genBuf, 11, iArr, i4 + 112, 56, bArr4);
    }

    public void predictWithMode(int i, int[] iArr, boolean z, boolean z2, boolean z3, boolean z4, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3, int i4, byte[] bArr4) {
        switch (i) {
            case 0:
                Preconditions.checkState(z2, "");
                predictVertical(iArr, z3, z4, bArr3, bArr2, i2, i3, i4, bArr4);
                break;
            case 1:
                Preconditions.checkState(z, "");
                predictHorizontal(iArr, z3, bArr3, bArr, i2, i3, i4, bArr4);
                break;
            case 2:
                predictDC(iArr, z3, z4, z, z2, bArr3, bArr, bArr2, i2, i3, i4, bArr4);
                break;
            case 3:
                Preconditions.checkState(z2, "");
                predictDiagonalDownLeft(iArr, z3, z2, z4, bArr3, bArr2, i2, i3, i4, bArr4);
                break;
            case 4:
                Preconditions.checkState(z2 && z && z3, "");
                predictDiagonalDownRight(iArr, z4, bArr3, bArr, bArr2, i2, i3, i4, bArr4);
                break;
            case 5:
                Preconditions.checkState(z2 && z && z3, "");
                predictVerticalRight(iArr, z4, bArr3, bArr, bArr2, i2, i3, i4, bArr4);
                break;
            case 6:
                Preconditions.checkState(z2 && z && z3, "");
                predictHorizontalDown(iArr, z4, bArr3, bArr, bArr2, i2, i3, i4, bArr4);
                break;
            case 7:
                Preconditions.checkState(z2, "");
                predictVerticalLeft(iArr, z3, z4, bArr3, bArr2, i2, i3, i4, bArr4);
                break;
            case 8:
                Preconditions.checkState(z, "");
                predictHorizontalUp(iArr, z3, bArr3, bArr, i2, i3, i4, bArr4);
                break;
        }
        int i5 = i2 + i3;
        int i6 = (i4 << 4) + i3;
        int i7 = i6 + 7;
        int i8 = i4 >> 2;
        bArr3[i8] = bArr2[i5 + 7];
        for (int i9 = 0; i9 < 8; i9++) {
            bArr[i4 + i9] = bArr4[(i9 << 4) + i7];
        }
        int i10 = i6 + 112;
        for (int i11 = 0; i11 < 8; i11++) {
            bArr2[i5 + i11] = bArr4[i10 + i11];
        }
        bArr3[i8 + 1] = bArr[i4 + 3];
    }
}
