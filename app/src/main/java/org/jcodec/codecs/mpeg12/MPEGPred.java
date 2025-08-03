package org.jcodec.codecs.mpeg12;

import java.lang.reflect.Array;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public class MPEGPred {
    public int chromaFormat;
    public int[][] fCode;
    public int[][][] mvPred = (int[][][]) Array.newInstance((Class<?>) Integer.TYPE, 2, 2, 2);
    public boolean topFieldFirst;

    public MPEGPred(int[][] iArr, int i, boolean z) {
        this.fCode = iArr;
        this.chromaFormat = i;
        this.topFieldFirst = z;
    }

    private final int dpXField(int i, int i2, int i3) {
        return ((i + (i > 0 ? 1 : 0)) >> 1) + i2;
    }

    private final int dpYField(int i, int i2, int i3) {
        return ((i + (i > 0 ? 1 : 0)) >> 1) + (1 - (i3 << 1)) + i2;
    }

    private final int mvectDecode(BitReader bitReader, int i, int i2) {
        int vlc = MPEGConst.vlcMotionCode.readVLC(bitReader);
        if (vlc == 0) {
            return i2;
        }
        if (vlc < 0) {
            return 65535;
        }
        int i3 = bitReader.read1Bit();
        int i4 = i - 1;
        if (i4 > 0) {
            vlc = (bitReader.readNBit(i4) | ((vlc - 1) << i4)) + 1;
        }
        if (i3 != 0) {
            vlc = -vlc;
        }
        return sign_extend(vlc + i2, i4 + 5);
    }

    private void predict16x16DualPrimeField(Picture[] pictureArr, int i, int i2, BitReader bitReader, int[][] iArr, int i3) {
        int iMvectDecode = mvectDecode(bitReader, this.fCode[0][0], this.mvPred[0][0][0]);
        VLC vlc = MPEGConst.vlcDualPrime;
        int vlc2 = vlc.readVLC(bitReader) - 1;
        int iMvectDecode2 = mvectDecode(bitReader, this.fCode[0][1], this.mvPred[0][0][1]);
        int vlc3 = vlc.readVLC(bitReader) - 1;
        int i4 = 1 - i3;
        int iDpXField = dpXField(iMvectDecode, vlc2, i4);
        int iDpYField = dpYField(iMvectDecode2, vlc3, i4);
        int i5 = this.chromaFormat;
        int i6 = i5 == 1 ? 1 : 0;
        int i7 = i5 == 3 ? 0 : 1;
        int i8 = i5 == 1 ? 2 : 1;
        int i9 = i5 == 3 ? 1 : 2;
        Class cls = Integer.TYPE;
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, 3, 256);
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) cls, 3, 256);
        int i10 = i << 1;
        int i11 = i2 << 1;
        int i12 = i10 >> i7;
        int i13 = i12 + (iMvectDecode / i9);
        int i14 = i11 >> i6;
        int i15 = i14 + (iMvectDecode2 / i8);
        predictPlane(pictureArr[i3].getPlaneData(0), i10 + iMvectDecode, i11 + iMvectDecode2, pictureArr[i3].getPlaneWidth(0), pictureArr[i3].getPlaneHeight(0), 1, i3, iArr2[0], 0, 16, 16, 0);
        int i16 = 16 >> i7;
        int i17 = 16 >> i6;
        predictPlane(pictureArr[i3].getPlaneData(1), i13, i15, pictureArr[i3].getPlaneWidth(1), pictureArr[i3].getPlaneHeight(1), 1, i3, iArr2[1], 0, i16, i17, 0);
        predictPlane(pictureArr[i3].getPlaneData(2), i13, i15, pictureArr[i3].getPlaneWidth(2), pictureArr[i3].getPlaneHeight(2), 1, i3, iArr2[2], 0, i16, i17, 0);
        int i18 = i10 + iDpXField;
        int i19 = i11 + iDpYField;
        int i20 = i12 + (iDpXField / i9);
        int i21 = i14 + (iDpYField / i8);
        predictPlane(pictureArr[i4].getPlaneData(0), i18, i19, pictureArr[i4].getPlaneWidth(0), pictureArr[i4].getPlaneHeight(0), 1, i4, iArr3[0], 0, 16, 16, 0);
        predictPlane(pictureArr[i4].getPlaneData(1), i20, i21, pictureArr[i4].getPlaneWidth(1), pictureArr[i4].getPlaneHeight(1), 1, i4, iArr3[1], 0, i16, i17, 0);
        predictPlane(pictureArr[i4].getPlaneData(2), i20, i21, pictureArr[i4].getPlaneWidth(2), pictureArr[i4].getPlaneHeight(2), 1, i4, iArr3[2], 0, i16, i17, 0);
        for (int i22 = 0; i22 < 3; i22++) {
            int i23 = 0;
            while (true) {
                int[] iArr4 = iArr[i22];
                if (i23 < iArr4.length) {
                    iArr4[i23] = ((iArr2[i22][i23] + iArr3[i22][i23]) + 1) >> 1;
                    i23++;
                }
            }
        }
        int[][][] iArr5 = this.mvPred;
        int[] iArr6 = iArr5[1][0];
        int[] iArr7 = iArr5[0][0];
        iArr7[0] = iMvectDecode;
        iArr6[0] = iMvectDecode;
        iArr7[1] = iMvectDecode2;
        iArr6[1] = iMvectDecode2;
    }

    private void predict16x16DualPrimeFrame(Picture[] pictureArr, int i, int i2, BitReader bitReader, int i3, int[][] iArr) {
        int iMvectDecode = mvectDecode(bitReader, this.fCode[0][0], this.mvPred[0][0][0]);
        VLC vlc = MPEGConst.vlcDualPrime;
        int vlc2 = vlc.readVLC(bitReader) - 1;
        int iMvectDecode2 = mvectDecode(bitReader, this.fCode[0][1], this.mvPred[0][0][1] >> 1);
        int vlc3 = vlc.readVLC(bitReader) - 1;
        int i4 = this.topFieldFirst ? 1 : 3;
        int i5 = (((iMvectDecode * i4) + (iMvectDecode > 0 ? 1 : 0)) >> 1) + vlc2;
        int i6 = ((((iMvectDecode2 * i4) + (iMvectDecode2 > 0 ? 1 : 0)) >> 1) + vlc3) - 1;
        int i7 = 4 - i4;
        int i8 = (((iMvectDecode * i7) + (iMvectDecode > 0 ? 1 : 0)) >> 1) + vlc2;
        int i9 = (((i7 * iMvectDecode2) + (iMvectDecode2 > 0 ? 1 : 0)) >> 1) + vlc3 + 1;
        int i10 = this.chromaFormat;
        int i11 = i10 == 1 ? 1 : 0;
        int i12 = i10 == 3 ? 0 : 1;
        int i13 = i10 == 1 ? 2 : 1;
        int i14 = i10 == 3 ? 1 : 2;
        Class cls = Integer.TYPE;
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, 3, 256);
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) cls, 3, 256);
        int i15 = i << 1;
        int i16 = i15 + iMvectDecode;
        int i17 = i2 + iMvectDecode2;
        int i18 = i15 >> i12;
        int i19 = i18 + (iMvectDecode / i14);
        int i20 = i2 >> i11;
        int i21 = i20 + (iMvectDecode2 / i13);
        predictPlane(pictureArr[0].getPlaneData(0), i16, i17, pictureArr[0].getPlaneWidth(0), pictureArr[0].getPlaneHeight(0), 1, 0, iArr2[0], 0, 16, 8, 1);
        int i22 = 16 >> i12;
        int i23 = 8 >> i11;
        predictPlane(pictureArr[0].getPlaneData(1), i19, i21, pictureArr[0].getPlaneWidth(1), pictureArr[0].getPlaneHeight(1), 1, 0, iArr2[1], 0, i22, i23, 1);
        predictPlane(pictureArr[0].getPlaneData(2), i19, i21, pictureArr[0].getPlaneWidth(2), pictureArr[0].getPlaneHeight(2), 1, 0, iArr2[2], 0, i22, i23, 1);
        predictPlane(pictureArr[1].getPlaneData(0), i16, i17, pictureArr[1].getPlaneWidth(0), pictureArr[1].getPlaneHeight(0), 1, 1, iArr2[0], 1, 16, 8, 1);
        predictPlane(pictureArr[1].getPlaneData(1), i19, i21, pictureArr[1].getPlaneWidth(1), pictureArr[1].getPlaneHeight(1), 1, 1, iArr2[1], 1, i22, i23, 1);
        predictPlane(pictureArr[1].getPlaneData(2), i19, i21, pictureArr[1].getPlaneWidth(2), pictureArr[1].getPlaneHeight(2), 1, 1, iArr2[2], 1, i22, i23, 1);
        int i24 = i15 + i5;
        int i25 = i2 + i6;
        int i26 = i18 + (i5 / i14);
        int i27 = i20 + (i6 / i13);
        predictPlane(pictureArr[1].getPlaneData(0), i24, i25, pictureArr[1].getPlaneWidth(0), pictureArr[1].getPlaneHeight(0), 1, 1, iArr3[0], 0, 16, 8, 1);
        predictPlane(pictureArr[1].getPlaneData(1), i26, i27, pictureArr[1].getPlaneWidth(1), pictureArr[1].getPlaneHeight(1), 1, 1, iArr3[1], 0, i22, i23, 1);
        predictPlane(pictureArr[1].getPlaneData(2), i26, i27, pictureArr[1].getPlaneWidth(2), pictureArr[1].getPlaneHeight(2), 1, 1, iArr3[2], 0, i22, i23, 1);
        int i28 = i18 + (i8 / i14);
        int i29 = i20 + (i9 / i13);
        predictPlane(pictureArr[0].getPlaneData(0), i15 + i8, i2 + i9, pictureArr[0].getPlaneWidth(0), pictureArr[0].getPlaneHeight(0), 1, 0, iArr3[0], 1, 16, 8, 1);
        predictPlane(pictureArr[0].getPlaneData(1), i28, i29, pictureArr[0].getPlaneWidth(1), pictureArr[0].getPlaneHeight(1), 1, 0, iArr3[1], 1, i22, i23, 1);
        predictPlane(pictureArr[0].getPlaneData(2), i28, i29, pictureArr[0].getPlaneWidth(2), pictureArr[0].getPlaneHeight(2), 1, 0, iArr3[2], 1, i22, i23, 1);
        for (int i30 = 0; i30 < 3; i30++) {
            int i31 = 0;
            while (true) {
                int[] iArr4 = iArr[i30];
                if (i31 < iArr4.length) {
                    iArr4[i31] = ((iArr2[i30][i31] + iArr3[i30][i31]) + 1) >> 1;
                    i31++;
                }
            }
        }
        int[][][] iArr5 = this.mvPred;
        int[] iArr6 = iArr5[1][0];
        int[] iArr7 = iArr5[0][0];
        iArr7[0] = iMvectDecode;
        iArr6[0] = iMvectDecode;
        int i32 = iMvectDecode2 << 1;
        iArr7[1] = i32;
        iArr6[1] = i32;
    }

    private void predict16x8MC(Picture[] pictureArr, int i, int i2, BitReader bitReader, int i3, int[][] iArr, int i4, int i5) {
        int i6 = bitReader.read1Bit();
        predictGeneric(pictureArr[i6], i, i2 + i4, bitReader, i3, iArr, i4, 16, 8, 1, i6, 0, i5, 0);
    }

    private void predictFieldInFrame(Picture picture, int i, int i2, int[][] iArr, BitReader bitReader, int i3, int i4) {
        int i5 = i2 >> 1;
        int i6 = bitReader.read1Bit();
        predictGeneric(picture, i, i5, bitReader, i3, iArr, 0, 16, 8, 1, i6, 1, 0, 1);
        if (i4 == 0 || i4 == 1) {
            predictGeneric(picture, i, i5, bitReader, i3, iArr, 1, 16, 8, 1, bitReader.read1Bit(), 1, 1, 1);
            return;
        }
        int[][][] iArr2 = this.mvPred;
        int[] iArr3 = iArr2[1][i3];
        int[] iArr4 = iArr2[0][i3];
        int i7 = iArr4[0];
        iArr3[0] = i7;
        int i8 = iArr4[1];
        iArr3[1] = i8;
        predictMB(picture, i7, 0, i8, 0, 16, 8, 1, 1 - i6, iArr, 1, 1);
    }

    private final int sign_extend(int i, int i2) {
        int i3 = 32 - i2;
        return (i << i3) >> i3;
    }

    public final int getPix1(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        return bArr[(MathUtil.clip(i4, 0, (i2 - (1 << i5)) + i6) * i) + MathUtil.clip(i3, 0, i - 1)] + BER.ASN_LONG_LEN;
    }

    public final int getPix2(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i - 1;
        int i10 = (i2 - (1 << i7)) + i8;
        return (((bArr[(MathUtil.clip(i4, 0, i10) * i) + MathUtil.clip(i3, 0, i9)] + bArr[(MathUtil.clip(i6, 0, i10) * i) + MathUtil.clip(i5, 0, i9)]) + 1) >> 1) + 128;
    }

    public final int getPix4(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int i13 = (i2 - (1 << i11)) + i12;
        int i14 = i - 1;
        return (((((bArr[(MathUtil.clip(i4, 0, i13) * i) + MathUtil.clip(i3, 0, i14)] + bArr[(MathUtil.clip(i6, 0, i13) * i) + MathUtil.clip(i5, 0, i14)]) + bArr[(MathUtil.clip(i8, 0, i13) * i) + MathUtil.clip(i7, 0, i14)]) + bArr[(MathUtil.clip(i10, 0, i13) * i) + MathUtil.clip(i9, 0, i14)]) + 3) >> 2) + 128;
    }

    public void predict16x16Field(Picture[] pictureArr, int i, int i2, BitReader bitReader, int i3, int[][] iArr) {
        int i4 = bitReader.read1Bit();
        predictGeneric(pictureArr[i4], i, i2, bitReader, i3, iArr, 0, 16, 16, 1, i4, 0, 0, 0);
        int[][][] iArr2 = this.mvPred;
        int[] iArr3 = iArr2[1][i3];
        int[] iArr4 = iArr2[0][i3];
        iArr3[0] = iArr4[0];
        iArr3[1] = iArr4[1];
    }

    public void predict16x16Frame(Picture picture, int i, int i2, BitReader bitReader, int i3, int[][] iArr) {
        predictGeneric(picture, i, i2, bitReader, i3, iArr, 0, 16, 16, 0, 0, 0, 0, 0);
        int[][][] iArr2 = this.mvPred;
        int[] iArr3 = iArr2[1][i3];
        int[] iArr4 = iArr2[0][i3];
        iArr3[0] = iArr4[0];
        iArr3[1] = iArr4[1];
    }

    public void predict16x16NoMV(Picture picture, int i, int i2, int i3, int i4, int[][] iArr) {
        if (i3 == 3) {
            int[] iArr2 = this.mvPred[0][i4];
            predictMB(picture, i << 1, iArr2[0], i2 << 1, iArr2[1], 16, 16, 0, 0, iArr, 0, 0);
        } else {
            int[] iArr3 = this.mvPred[0][i4];
            predictMB(picture, i << 1, iArr3[0], i2 << 1, iArr3[1], 16, 16, 1, i3 - 1, iArr, 0, 0);
        }
    }

    public void predictEvenOddSafe(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr, int i7, int i8, int i9, int i10) {
        int i11 = (((i2 << i5) + i6) * i3) + i;
        int i12 = i7 * i8;
        int i13 = (i3 << i5) - i8;
        int i14 = i10 * i8;
        for (int i15 = 0; i15 < i9; i15++) {
            int i16 = 0;
            while (i16 < i8) {
                int i17 = bArr[i11];
                i11++;
                iArr[i12] = (((i17 + bArr[i11]) + 1) >> 1) + 128;
                i16++;
                i12++;
            }
            i11 += i13;
            i12 += i14;
        }
    }

    public void predictEvenOddUnSafe(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr, int i7, int i8, int i9, int i10) {
        int i11 = i8 * i7;
        int i12 = i10 * i8;
        for (int i13 = 0; i13 < i9; i13++) {
            int i14 = ((i13 + i2) << i5) + i6;
            int i15 = 0;
            while (i15 < i8) {
                int i16 = i15 + i;
                iArr[i11] = getPix2(bArr, i3, i4, i16, i14, i16 + 1, i14, i5, i6);
                i15++;
                i11++;
            }
            i11 += i12;
        }
    }

    public void predictFullXFullYSafe(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr, int i7, int i8, int i9, int i10) {
        int i11 = (((i2 << i5) + i6) * i3) + i;
        int i12 = i7 * i8;
        int i13 = (i3 << i5) - i8;
        int i14 = i10 * i8;
        for (int i15 = 0; i15 < i9; i15++) {
            int i16 = 0;
            while (i16 < i8) {
                iArr[i12] = bArr[i11] + 128;
                i16++;
                i12++;
                i11++;
            }
            i11 += i13;
            i12 += i14;
        }
    }

    public void predictFullXFullYUnSafe(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr, int i7, int i8, int i9, int i10) {
        int i11 = i8 * i7;
        int i12 = i10 * i8;
        for (int i13 = 0; i13 < i9; i13++) {
            int i14 = ((i13 + i2) << i5) + i6;
            int i15 = 0;
            while (i15 < i8) {
                iArr[i11] = getPix1(bArr, i3, i4, i15 + i, i14, i5, i6);
                i15++;
                i11++;
            }
            i11 += i12;
        }
    }

    public void predictGeneric(Picture picture, int i, int i2, BitReader bitReader, int i3, int[][] iArr, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int iMvectDecode = mvectDecode(bitReader, this.fCode[i3][0], this.mvPred[i10][i3][0]);
        int iMvectDecode2 = mvectDecode(bitReader, this.fCode[i3][1], this.mvPred[i10][i3][1] >> i11);
        predictMB(picture, i << 1, iMvectDecode, i2 << 1, iMvectDecode2, i5, i6, i7, i8, iArr, i4, i9);
        int[] iArr2 = this.mvPred[i10][i3];
        iArr2[0] = iMvectDecode;
        iArr2[1] = iMvectDecode2 << i11;
    }

    public void predictInField(Picture[] pictureArr, int i, int i2, int[][] iArr, BitReader bitReader, int i3, int i4, int i5) {
        if (i3 == 1) {
            predict16x16Field(pictureArr, i, i2, bitReader, i4, iArr);
            return;
        }
        if (i3 == 2) {
            predict16x8MC(pictureArr, i, i2, bitReader, i4, iArr, 0, 0);
            predict16x8MC(pictureArr, i, i2, bitReader, i4, iArr, 8, 1);
        } else {
            if (i3 != 3) {
                return;
            }
            predict16x16DualPrimeField(pictureArr, i, i2, bitReader, iArr, i5);
        }
    }

    public void predictInFrame(Picture picture, int i, int i2, int[][] iArr, BitReader bitReader, int i3, int i4, int i5) {
        Picture[] pictureArr = {picture, picture};
        if (i3 == 1) {
            predictFieldInFrame(picture, i, i2, iArr, bitReader, i4, i5);
        } else if (i3 == 2) {
            predict16x16Frame(picture, i, i2, bitReader, i4, iArr);
        } else {
            if (i3 != 3) {
                return;
            }
            predict16x16DualPrimeFrame(pictureArr, i, i2, bitReader, i4, iArr);
        }
    }

    public void predictMB(Picture picture, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int[][] iArr, int i9, int i10) {
        int i11 = this.chromaFormat;
        int i12 = i11 == 1 ? 1 : 0;
        int i13 = i11 == 3 ? 0 : 1;
        int i14 = i11 == 1 ? 2 : 1;
        int i15 = i11 == 3 ? 1 : 2;
        predictPlane(picture.getPlaneData(0), i + i2, i3 + i4, picture.getPlaneWidth(0), picture.getPlaneHeight(0), i7, i8, iArr[0], i9, i5, i6, i10);
        int i16 = (i >> i13) + (i2 / i15);
        int i17 = (i3 >> i12) + (i4 / i14);
        int i18 = i5 >> i13;
        int i19 = i6 >> i12;
        predictPlane(picture.getPlaneData(1), i16, i17, picture.getPlaneWidth(1), picture.getPlaneHeight(1), i7, i8, iArr[1], i9, i18, i19, i10);
        predictPlane(picture.getPlaneData(2), i16, i17, picture.getPlaneWidth(2), picture.getPlaneHeight(2), i7, i8, iArr[2], i9, i18, i19, i10);
    }

    public void predictOddEvenSafe(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr, int i7, int i8, int i9, int i10) {
        int i11 = (((i2 << i5) + i6) * i3) + i;
        int i12 = i7 * i8;
        int i13 = i3 << i5;
        int i14 = i13 - i8;
        int i15 = i10 * i8;
        for (int i16 = 0; i16 < i9; i16++) {
            int i17 = 0;
            while (i17 < i8) {
                iArr[i12] = (((bArr[i11] + bArr[i11 + i13]) + 1) >> 1) + 128;
                i11++;
                i17++;
                i12++;
            }
            i11 += i14;
            i12 += i15;
        }
    }

    public void predictOddEvenUnSafe(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr, int i7, int i8, int i9, int i10) {
        int i11 = i8 * i7;
        int i12 = i10 * i8;
        for (int i13 = 0; i13 < i9; i13++) {
            int i14 = i13 + i2;
            int i15 = (i14 << i5) + i6;
            int i16 = ((i14 + 1) << i5) + i6;
            int i17 = i11;
            int i18 = 0;
            while (i18 < i8) {
                int i19 = i18 + i;
                iArr[i17] = getPix2(bArr, i3, i4, i19, i15, i19, i16, i5, i6);
                i18++;
                i17++;
            }
            i11 = i17 + i12;
        }
    }

    public void predictOddOddSafe(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr, int i7, int i8, int i9, int i10) {
        int i11 = (((i2 << i5) + i6) * i3) + i;
        int i12 = i8 * i7;
        int i13 = i3 << i5;
        int i14 = i13 - i8;
        int i15 = i10 * i8;
        for (int i16 = 0; i16 < i9; i16++) {
            int i17 = 0;
            while (i17 < i8) {
                int i18 = i11 + 1;
                int i19 = bArr[i11] + bArr[i18];
                int i20 = i11 + i13;
                iArr[i12] = ((((i19 + bArr[i20]) + bArr[i20 + 1]) + 3) >> 2) + 128;
                i17++;
                i12++;
                i11 = i18;
            }
            i11 += i14;
            i12 += i15;
        }
    }

    public void predictOddOddUnSafe(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr, int i7, int i8, int i9, int i10) {
        int i11 = i8 * i7;
        int i12 = i10 * i8;
        int i13 = i9;
        int i14 = 0;
        while (i14 < i13) {
            int i15 = i14 + i2;
            int i16 = (i15 << i5) + i6;
            int i17 = ((i15 + 1) << i5) + i6;
            int i18 = i11;
            int i19 = 0;
            while (i19 < i8) {
                int i20 = i19 + i;
                int i21 = i20 + 1;
                iArr[i18] = getPix4(bArr, i3, i4, i20, i16, i21, i16, i20, i17, i21, i17, i5, i6);
                i19++;
                i18++;
                i14 = i14;
            }
            i11 = i18 + i12;
            i14++;
            i13 = i9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void predictPlane(byte[] r14, int r15, int r16, int r17, int r18, int r19, int r20, int[] r21, int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.mpeg12.MPEGPred.predictPlane(byte[], int, int, int, int, int, int, int[], int, int, int, int):void");
    }

    public void reset() {
        int[][][] iArr = this.mvPred;
        int[][] iArr2 = iArr[0];
        int[] iArr3 = iArr2[0];
        int[] iArr4 = iArr2[1];
        int[][] iArr5 = iArr[1];
        int[] iArr6 = iArr5[0];
        int[] iArr7 = iArr5[1];
        iArr7[1] = 0;
        iArr7[0] = 0;
        iArr6[1] = 0;
        iArr6[0] = 0;
        iArr4[1] = 0;
        iArr4[0] = 0;
        iArr3[1] = 0;
        iArr3[0] = 0;
    }
}
