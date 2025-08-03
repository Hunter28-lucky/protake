package org.jcodec.codecs.mpeg4;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.jcodec.codecs.mpeg4.Macroblock;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
class MPEG4Bitstream {
    private static final int[] DQUANT_TABLE = {-1, -2, 1, 2};
    private static final byte[][][] vlcTab = (byte[][][]) Array.newInstance((Class<?>) Byte.TYPE, 2, 4096, 4);

    static {
        initVLCTables();
    }

    public static void addAcdc(Macroblock macroblock, int i, int i2, int i3) {
        short[] sArr = macroblock.block[i2];
        byte b = (byte) macroblock.acpredDirections[i2];
        short[] sArr2 = macroblock.predValues[i2];
        short s = (short) (sArr[0] + macroblock.predictors[0]);
        sArr[0] = s;
        short s2 = (short) (s * i3);
        sArr2[0] = s2;
        if (i == 0 || i > 34) {
            if (s2 < -2048) {
                s2 = -2048;
            } else if (s2 > 2047) {
                s2 = 2047;
            }
            sArr2[0] = s2;
        }
        int i4 = 1;
        if (b == 1) {
            while (i4 < 8) {
                short s3 = (short) (sArr[i4] + macroblock.predictors[i4]);
                sArr[i4] = s3;
                sArr2[i4] = s3;
                sArr2[i4 + 7] = sArr[i4 * 8];
                i4++;
            }
            return;
        }
        if (b != 2) {
            while (i4 < 8) {
                sArr2[i4] = sArr[i4];
                sArr2[i4 + 7] = sArr[i4 * 8];
                i4++;
            }
            return;
        }
        while (i4 < 8) {
            int i5 = i4 * 8;
            short s4 = (short) (sArr[i5] + macroblock.predictors[i4]);
            sArr[i5] = s4;
            sArr2[i4 + 7] = s4;
            sArr2[i4] = sArr[i4];
            i4++;
        }
    }

    public static boolean checkResyncMarker(BitReader bitReader, int i) {
        int iBitsToAlign = bitReader.bitsToAlign();
        int i2 = i + 17;
        int iCheckNBitDontCare = bitReader.checkNBitDontCare(i2 + iBitsToAlign);
        return (iCheckNBitDontCare >> i2) == (1 << (iBitsToAlign - 1)) - 1 && (iCheckNBitDontCare & ((1 << i2) - 1)) == 1;
    }

    private static void dequantH263Intra(MPEG4DecodingContext mPEG4DecodingContext, short[] sArr, int i, int i2) {
        int i3 = i << 1;
        if ((i & 1) == 0) {
            i--;
        }
        sArr[0] = (short) MathUtil.clip(sArr[0] * i2, -2048, 2047);
        for (int i4 = 1; i4 < 64; i4++) {
            short s = sArr[i4];
            if (s == 0) {
                sArr[i4] = 0;
            } else if (s < 0) {
                int i5 = ((-s) * i3) + i;
                sArr[i4] = (short) (i5 <= 2048 ? -i5 : -2048);
            } else {
                int i6 = (s * i3) + i;
                if (i6 > 2047) {
                    i6 = 2047;
                }
                sArr[i4] = (short) i6;
            }
        }
    }

    private static void dequantMpegIntra(MPEG4DecodingContext mPEG4DecodingContext, short[] sArr, int i, int i2) {
        sArr[0] = (short) MathUtil.clip(sArr[0] * i2, -2048, 2047);
        for (int i3 = 1; i3 < 64; i3++) {
            short s = sArr[i3];
            if (s == 0) {
                sArr[i3] = 0;
            } else if (s < 0) {
                int i4 = (((-s) * mPEG4DecodingContext.intraMpegQuantMatrix[i3]) * i) >> 3;
                sArr[i3] = (short) (i4 <= 2048 ? -((short) i4) : -2048);
            } else {
                int i5 = ((s * mPEG4DecodingContext.intraMpegQuantMatrix[i3]) * i) >> 3;
                if (i5 > 2047) {
                    i5 = 2047;
                }
                sArr[i3] = (short) i5;
            }
        }
    }

    private static void getBMotionVector(BitReader bitReader, Macroblock.Vector vector, int i, Macroblock.Vector vector2, int i2, int i3) {
        int i4 = 1 << (i - 1);
        int i5 = (i4 * 32) - 1;
        int i6 = i4 * (-32);
        int i7 = i4 * 64;
        int mVComponent = readMVComponent(bitReader, i);
        int mVComponent2 = readMVComponent(bitReader, i);
        int i8 = mVComponent + vector2.x;
        int i9 = mVComponent2 + vector2.y;
        if (i8 < i6) {
            i8 += i7;
        } else if (i8 > i5) {
            i8 -= i7;
        }
        if (i9 < i6) {
            i9 += i7;
        } else if (i9 > i5) {
            i9 -= i7;
        }
        vector.x = i8;
        vector.y = i9;
    }

    private static int getDCScaler(int i, boolean z) {
        if (i < 5) {
            return 8;
        }
        return (i >= 25 || z) ? i < 9 ? i * 2 : i < 25 ? i + 8 : z ? (i * 2) - 16 : i - 6 : (i + 13) / 2;
    }

    private static Macroblock.Vector getPMV2(MPEG4DecodingContext mPEG4DecodingContext, int i, int i2, int i3, int i4, Macroblock macroblock, Macroblock macroblock2, Macroblock macroblock3, Macroblock macroblock4) {
        char c;
        char c2;
        char c3;
        int i5;
        char c4;
        Macroblock.Vector[] vectorArr = new Macroblock.Vector[4];
        for (int i6 = 0; i6 < 4; i6++) {
            vectorArr[i6] = Macroblock.vec();
        }
        if (i4 == 0) {
            c = 2;
            macroblock = macroblock3;
            c2 = 1;
            c3 = 2;
        } else if (i4 == 1) {
            c3 = 3;
            c2 = 0;
            c = 2;
        } else if (i4 != 2) {
            c3 = 0;
            c2 = 2;
            macroblock2 = macroblock;
            macroblock4 = macroblock2;
            c = 1;
        } else {
            c2 = 3;
            macroblock2 = macroblock;
            macroblock4 = macroblock2;
            macroblock = macroblock3;
            c = 1;
            c3 = 0;
        }
        if (macroblock != null) {
            vectorArr[1] = macroblock.mvs[c2];
            i5 = 1;
        } else {
            vectorArr[1] = MPEG4Consts.ZERO_MV;
            i5 = 0;
        }
        if (macroblock2 != null) {
            i5++;
            vectorArr[2] = macroblock2.mvs[c3];
            c4 = 2;
        } else {
            vectorArr[2] = MPEG4Consts.ZERO_MV;
            c4 = 1;
        }
        if (macroblock4 != null) {
            i5++;
            vectorArr[3] = macroblock4.mvs[c];
            c4 = 3;
        } else {
            vectorArr[3] = MPEG4Consts.ZERO_MV;
        }
        if (i5 <= 1) {
            return vectorArr[c4];
        }
        vectorArr[0].x = selectCand(vectorArr[1].x, vectorArr[2].x, vectorArr[3].x);
        vectorArr[0].y = selectCand(vectorArr[1].y, vectorArr[2].y, vectorArr[3].y);
        return vectorArr[0];
    }

    private static Macroblock.Vector getPMV2Interlaced(MPEG4DecodingContext mPEG4DecodingContext, int i, Macroblock macroblock, Macroblock macroblock2, Macroblock macroblock3, Macroblock macroblock4) {
        int i2;
        char c;
        Macroblock.Vector[] vectorArr = new Macroblock.Vector[4];
        for (int i3 = 0; i3 < 4; i3++) {
            vectorArr[i3] = Macroblock.vec();
        }
        if (macroblock3 != null) {
            if (macroblock3.fieldPred) {
                vectorArr[1] = macroblock3.mvsAvg;
            } else {
                vectorArr[1] = macroblock3.mvs[1];
            }
            i2 = 1;
        } else {
            vectorArr[1] = MPEG4Consts.ZERO_MV;
            i2 = 0;
        }
        if (macroblock2 != null) {
            i2++;
            if (macroblock2.fieldPred) {
                vectorArr[2] = macroblock2.mvsAvg;
            } else {
                vectorArr[2] = macroblock2.mvs[2];
            }
            c = 2;
        } else {
            vectorArr[2] = MPEG4Consts.ZERO_MV;
            c = 1;
        }
        if (macroblock4 != null) {
            i2++;
            if (macroblock4.fieldPred) {
                vectorArr[3] = macroblock4.mvsAvg;
            } else {
                vectorArr[3] = macroblock4.mvs[2];
            }
            c = 3;
        } else {
            vectorArr[3] = MPEG4Consts.ZERO_MV;
        }
        if (i2 <= 1) {
            return vectorArr[c];
        }
        vectorArr[0].x = Math.min(Math.max(vectorArr[1].x, vectorArr[2].x), Math.min(Math.max(vectorArr[2].x, vectorArr[3].x), Math.max(vectorArr[1].x, vectorArr[3].x)));
        vectorArr[0].y = Math.min(Math.max(vectorArr[1].y, vectorArr[2].y), Math.min(Math.max(vectorArr[2].y, vectorArr[3].y), Math.max(vectorArr[1].y, vectorArr[3].y)));
        return vectorArr[0];
    }

    private static final void initVLCTables() {
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i2 < 4096; i2++) {
                vlcTab[i][i2][3] = 0;
            }
        }
        for (int i3 = 0; i3 < 2; i3++) {
            for (int i4 = 0; i4 < 102; i4++) {
                int[] iArr = MPEG4Consts.COEFF_TAB[i3][i4];
                int i5 = iArr[1];
                int i6 = iArr[2];
                int i7 = iArr[3];
                int i8 = iArr[4];
                int i9 = iArr[0];
                int i10 = 12 - i5;
                for (int i11 = 0; i11 < (1 << i10); i11++) {
                    byte[] bArr = vlcTab[i3][(i9 << i10) | i11];
                    bArr[0] = (byte) i5;
                    bArr[1] = (byte) i6;
                    bArr[2] = (byte) i7;
                    bArr[3] = (byte) i8;
                }
            }
        }
    }

    public static int last(int i) {
        return i >> 24;
    }

    public static int level(int i) {
        return (short) i;
    }

    public static int neg(int i) {
        if (i < 0) {
            return i;
        }
        return 0;
    }

    public static int packCoeff(int i, int i2, int i3) {
        return (i & 65535) | ((i2 & 255) << 16) | ((i3 & 255) << 24);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void predictAcdc(org.jcodec.codecs.mpeg4.MPEG4DecodingContext r18, int r19, int r20, int r21, int r22, int r23, short[] r24, int r25, org.jcodec.codecs.mpeg4.Macroblock r26, org.jcodec.codecs.mpeg4.Macroblock r27, org.jcodec.codecs.mpeg4.Macroblock r28, org.jcodec.codecs.mpeg4.Macroblock r29) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.mpeg4.MPEG4Bitstream.predictAcdc(org.jcodec.codecs.mpeg4.MPEG4DecodingContext, int, int, int, int, int, short[], int, org.jcodec.codecs.mpeg4.Macroblock, org.jcodec.codecs.mpeg4.Macroblock, org.jcodec.codecs.mpeg4.Macroblock, org.jcodec.codecs.mpeg4.Macroblock):void");
    }

    public static void readBi(BitReader bitReader, MPEG4DecodingContext mPEG4DecodingContext, int i, int i2, Macroblock macroblock, Macroblock macroblock2, Macroblock.Vector vector, Macroblock.Vector vector2) {
        if (bitReader.readBool()) {
            macroblock.mode = 4;
            macroblock.cbp = 0;
        } else {
            boolean bool = bitReader.readBool();
            macroblock.mode = readMBType(bitReader);
            if (bool) {
                macroblock.cbp = 0;
            } else {
                macroblock.cbp = bitReader.readNBit(6);
            }
            if (macroblock.mode != 0 && macroblock.cbp != 0) {
                int dBQuant = macroblock.quant + readDBQuant(bitReader);
                macroblock.quant = dBQuant;
                if (dBQuant > 31) {
                    macroblock.quant = 31;
                } else if (dBQuant < 1) {
                    macroblock.quant = 1;
                }
            }
            if (mPEG4DecodingContext.interlacing) {
                if (macroblock.cbp != 0) {
                    macroblock.fieldDCT = bitReader.readBool();
                }
                if (macroblock.mode != 0) {
                    boolean bool2 = bitReader.readBool();
                    macroblock.fieldPred = bool2;
                    if (bool2) {
                        macroblock.fieldForTop = bitReader.readBool();
                        macroblock.fieldForBottom = bitReader.readBool();
                    }
                }
            }
        }
        Macroblock.Vector vectorVec = Macroblock.vec();
        int i3 = macroblock.mode;
        if (i3 == 0) {
            getBMotionVector(bitReader, vectorVec, 1, MPEG4Consts.ZERO_MV, macroblock.x, macroblock.y);
        } else {
            if (i3 == 1) {
                getBMotionVector(bitReader, macroblock.mvs[0], i, vector, macroblock.x, macroblock.y);
                Macroblock.Vector[] vectorArr = macroblock.mvs;
                Macroblock.Vector vector3 = vectorArr[1];
                Macroblock.Vector vector4 = vectorArr[2];
                Macroblock.Vector vector5 = vectorArr[3];
                Macroblock.Vector vector6 = vectorArr[0];
                int i4 = vector6.x;
                vector5.x = i4;
                vector4.x = i4;
                vector3.x = i4;
                vector.x = i4;
                int i5 = vector6.y;
                vector5.y = i5;
                vector4.y = i5;
                vector3.y = i5;
                vector.y = i5;
                getBMotionVector(bitReader, macroblock.bmvs[0], i2, vector2, macroblock.x, macroblock.y);
                Macroblock.Vector[] vectorArr2 = macroblock.bmvs;
                Macroblock.Vector vector7 = vectorArr2[1];
                Macroblock.Vector vector8 = vectorArr2[2];
                Macroblock.Vector vector9 = vectorArr2[3];
                Macroblock.Vector vector10 = vectorArr2[0];
                int i6 = vector10.x;
                vector9.x = i6;
                vector8.x = i6;
                vector7.x = i6;
                vector2.x = i6;
                int i7 = vector10.y;
                vector9.y = i7;
                vector8.y = i7;
                vector7.y = i7;
                vector2.y = i7;
                readInterCoeffs(bitReader, mPEG4DecodingContext, macroblock);
                return;
            }
            if (i3 == 2) {
                getBMotionVector(bitReader, macroblock.mvs[0], i2, vector2, macroblock.x, macroblock.y);
                Macroblock.Vector[] vectorArr3 = macroblock.mvs;
                Macroblock.Vector vector11 = vectorArr3[1];
                Macroblock.Vector vector12 = vectorArr3[2];
                Macroblock.Vector vector13 = vectorArr3[3];
                Macroblock.Vector vector14 = vectorArr3[0];
                int i8 = vector14.x;
                vector13.x = i8;
                vector12.x = i8;
                vector11.x = i8;
                vector2.x = i8;
                int i9 = vector14.y;
                vector13.y = i9;
                vector12.y = i9;
                vector11.y = i9;
                vector2.y = i9;
                readInterCoeffs(bitReader, mPEG4DecodingContext, macroblock);
                return;
            }
            if (i3 == 3) {
                getBMotionVector(bitReader, macroblock.mvs[0], i, vector, macroblock.x, macroblock.y);
                Macroblock.Vector[] vectorArr4 = macroblock.mvs;
                Macroblock.Vector vector15 = vectorArr4[1];
                Macroblock.Vector vector16 = vectorArr4[2];
                Macroblock.Vector vector17 = vectorArr4[3];
                Macroblock.Vector vector18 = vectorArr4[0];
                int i10 = vector18.x;
                vector17.x = i10;
                vector16.x = i10;
                vector15.x = i10;
                vector.x = i10;
                int i11 = vector18.y;
                vector17.y = i11;
                vector16.y = i11;
                vector15.y = i11;
                vector.y = i11;
                readInterCoeffs(bitReader, mPEG4DecodingContext, macroblock);
                return;
            }
            if (i3 != 4) {
                return;
            }
        }
        for (int i12 = 0; i12 < 4; i12++) {
            Macroblock.Vector vector19 = macroblock.mvs[i12];
            Macroblock.Vector vector20 = macroblock2.mvs[i12];
            int i13 = vector20.x;
            int i14 = mPEG4DecodingContext.bframeTs;
            int i15 = mPEG4DecodingContext.pframeTs;
            int i16 = ((i13 * i14) / i15) + vectorVec.x;
            vector19.x = i16;
            int i17 = ((vector20.y * i14) / i15) + vectorVec.y;
            vector19.y = i17;
            Macroblock.Vector vector21 = macroblock.bmvs[i12];
            vector21.x = vectorVec.x != 0 ? i16 - vector20.x : (vector20.x * (i14 - i15)) / i15;
            int i18 = vectorVec.y;
            int i19 = vector20.y;
            vector21.y = i18 != 0 ? i17 - i19 : (i19 * (i14 - i15)) / i15;
        }
        readInterCoeffs(bitReader, mPEG4DecodingContext, macroblock);
    }

    public static int readCbpy(BitReader bitReader, boolean z) {
        int iCheckNBit = bitReader.checkNBit(6);
        int[][] iArr = MPEG4Consts.CBPY_TABLE;
        bitReader.skip(iArr[iCheckNBit][1]);
        int i = iArr[iCheckNBit][0];
        return !z ? 15 - i : i;
    }

    public static void readCoeffIntra(BitReader bitReader, MPEG4DecodingContext mPEG4DecodingContext, Macroblock macroblock, Macroblock macroblock2, Macroblock macroblock3, Macroblock macroblock4) {
        int i;
        int i2;
        BitReader bitReader2;
        int i3;
        int i4 = 0;
        while (i4 < 6) {
            Arrays.fill(macroblock.block[i4], (short) 0);
            int dCScaler = getDCScaler(macroblock.quant, i4 < 4);
            int i5 = i4;
            predictAcdc(mPEG4DecodingContext, macroblock.x, macroblock.y, i4, macroblock.quant, dCScaler, macroblock.predictors, macroblock.bound, macroblock, macroblock2, macroblock3, macroblock4);
            if (!macroblock.acpredFlag) {
                macroblock.acpredDirections[i5] = 0;
            }
            if (macroblock.quant < mPEG4DecodingContext.intraDCThreshold) {
                int dCSizeLum = i5 < 4 ? readDCSizeLum(bitReader) : readDCSizeChrom(bitReader);
                i2 = i5;
                bitReader2 = bitReader;
                short dCDif = dCSizeLum != 0 ? readDCDif(bitReader2, dCSizeLum) : (short) 0;
                if (dCSizeLum > 8) {
                    i = 1;
                    bitReader2.skip(1);
                } else {
                    i = 1;
                }
                macroblock.block[i2][0] = dCDif;
                i3 = i;
            } else {
                i = 1;
                i2 = i5;
                bitReader2 = bitReader;
                i3 = 0;
            }
            if (((i << (5 - i2)) & macroblock.cbp) != 0) {
                readIntraBlock(bitReader2, macroblock.block[i2], mPEG4DecodingContext.alternateVerticalScan ? 2 : macroblock.acpredDirections[i2], i3);
            }
            addAcdc(macroblock, mPEG4DecodingContext.bsVersion, i2, dCScaler);
            if (mPEG4DecodingContext.quantType) {
                dequantMpegIntra(mPEG4DecodingContext, macroblock.block[i2], macroblock.quant, dCScaler);
            } else {
                dequantH263Intra(mPEG4DecodingContext, macroblock.block[i2], macroblock.quant, dCScaler);
            }
            i4 = i2 + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    public static int readCoeffs(BitReader bitReader, boolean z, boolean z2) {
        ?? r9 = z;
        if (z2) {
            r9 = 0;
        }
        if (bitReader.checkNBit(7) != 3) {
            byte[] bArr = vlcTab[r9][bitReader.checkNBit(12)];
            int i = bArr[3];
            if (i == 0) {
                return packCoeff(0, 64, 1);
            }
            byte b = bArr[1];
            byte b2 = bArr[2];
            bitReader.skip(bArr[0]);
            if (bitReader.readBool()) {
                i = -i;
            }
            return packCoeff(i, b2, b);
        }
        bitReader.skip(7);
        if (z2) {
            int nBit = bitReader.readNBit(1);
            int nBit2 = bitReader.readNBit(6);
            short nBit3 = (byte) bitReader.readNBit(8);
            if (nBit3 == 0 || nBit3 == 128) {
                Logger.error("Illegal LEVEL for ESCAPE mode 4: " + ((int) nBit3));
            }
            return packCoeff(nBit3, nBit2, nBit);
        }
        int iCheckNBit = bitReader.checkNBit(2);
        if (iCheckNBit >= 3) {
            bitReader.skip(2);
            int i2 = bitReader.read1Bit();
            int nBit4 = bitReader.readNBit(6);
            bitReader.skip(1);
            short nBit5 = (short) ((bitReader.readNBit(12) << 20) >> 20);
            bitReader.skip(1);
            return packCoeff(nBit5, nBit4, i2);
        }
        bitReader.skip(iCheckNBit == 2 ? 2 : 1);
        byte[] bArr2 = vlcTab[r9][bitReader.checkNBit(12)];
        int i3 = (short) bArr2[3];
        if (i3 == 0) {
            return packCoeff(0, 64, 1);
        }
        int i4 = bArr2[1];
        int i5 = bArr2[2];
        bitReader.skip(bArr2[0]);
        if (iCheckNBit < 2) {
            i3 = (short) (i3 + MPEG4Consts.MAX_LEVEL[r9][i4][i5]);
        } else {
            i5 += MPEG4Consts.MAX_RUN[r9][i4][i3] + 1;
        }
        if (bitReader.readBool()) {
            i3 = -i3;
        }
        return packCoeff(i3, i5, i4);
    }

    public static int readDBQuant(BitReader bitReader) {
        if (bitReader.readBool()) {
            return !bitReader.readBool() ? -2 : 2;
        }
        return 0;
    }

    public static short readDCDif(BitReader bitReader, int i) {
        int nBit = bitReader.readNBit(i);
        return (nBit >> (i + (-1))) == 0 ? (short) ((nBit ^ ((1 << i) - 1)) * (-1)) : (short) nBit;
    }

    public static int readDCSizeChrom(BitReader bitReader) {
        int iCheckNBit = bitReader.checkNBit(12);
        for (int i = 12; i > 2; i--) {
            if (iCheckNBit == 1) {
                bitReader.skip(i);
                return i;
            }
            iCheckNBit >>= 1;
        }
        return 3 - bitReader.readNBit(2);
    }

    public static int readDCSizeLum(BitReader bitReader) {
        int iCheckNBit = bitReader.checkNBit(11);
        for (int i = 11; i > 3; i--) {
            if (iCheckNBit == 1) {
                bitReader.skip(i);
                return i + 1;
            }
            iCheckNBit >>= 1;
        }
        int[][] iArr = MPEG4Consts.DC_LUM_TAB;
        bitReader.skip(iArr[iCheckNBit][1]);
        return iArr[iCheckNBit][0];
    }

    public static void readInterBlockH263(BitReader bitReader, short[] sArr, int i, int i2) {
        int coeffs;
        short[] sArr2 = MPEG4Consts.SCAN_TABLES[i];
        int i3 = i2 << 1;
        if ((i2 & 1) == 0) {
            i2--;
        }
        int i4 = 0;
        do {
            coeffs = readCoeffs(bitReader, false, false);
            int iLevel = level(coeffs);
            int iRun = i4 + run(coeffs);
            if ((iRun & (-64)) != 0) {
                Logger.error("invalid run or index");
                return;
            }
            if (iLevel < 0) {
                int i5 = (iLevel * i3) - i2;
                short s = sArr2[iRun];
                if (i5 < -2048) {
                    i5 = -2048;
                }
                sArr[s] = (short) i5;
            } else {
                int i6 = (iLevel * i3) + i2;
                short s2 = sArr2[iRun];
                if (i6 > 2047) {
                    i6 = 2047;
                }
                sArr[s2] = (short) i6;
            }
            i4 = iRun + 1;
        } while (last(coeffs) == 0);
    }

    public static void readInterBlockMPEG(BitReader bitReader, short[] sArr, int i, int i2, short[] sArr2) {
        short[] sArr3 = MPEG4Consts.SCAN_TABLES[i];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int coeffs = readCoeffs(bitReader, false, false);
            int iLevel = level(coeffs);
            int iRun = i3 + run(coeffs);
            if ((iRun & (-64)) != 0) {
                Logger.error("invalid run or index");
                break;
            }
            if (iLevel < 0) {
                short s = sArr3[iRun];
                int i5 = (((((-iLevel) * 2) + 1) * sArr2[s]) * i2) >> 4;
                sArr[s] = (short) (i5 <= 2048 ? -i5 : -2048);
            } else {
                short s2 = sArr3[iRun];
                int i6 = ((((iLevel * 2) + 1) * sArr2[s2]) * i2) >> 4;
                if (i6 > 2047) {
                    i6 = 2047;
                }
                sArr[s2] = (short) i6;
            }
            i4 ^= sArr[sArr3[iRun]];
            i3 = iRun + 1;
            if (last(coeffs) != 0) {
                break;
            }
        }
        if ((i4 & 1) == 0) {
            sArr[63] = (short) (sArr[63] ^ 1);
        }
    }

    public static void readInterCoeffs(BitReader bitReader, MPEG4DecodingContext mPEG4DecodingContext, Macroblock macroblock) {
        int i = macroblock.quant;
        int i2 = mPEG4DecodingContext.alternateVerticalScan ? 2 : 0;
        for (int i3 = 0; i3 < 6; i3++) {
            short[] sArr = macroblock.block[i3];
            Arrays.fill(sArr, (short) 0);
            if ((macroblock.cbp & (1 << (5 - i3))) != 0) {
                if (mPEG4DecodingContext.quantType) {
                    readInterBlockMPEG(bitReader, sArr, i2, i, mPEG4DecodingContext.interMpegQuantMatrix);
                } else {
                    readInterBlockH263(bitReader, sArr, i2, i);
                }
            }
        }
    }

    public static void readInterModeCoeffs(BitReader bitReader, MPEG4DecodingContext mPEG4DecodingContext, int i, Macroblock macroblock, Macroblock macroblock2, Macroblock macroblock3, Macroblock macroblock4, Macroblock macroblock5) {
        if (bitReader.readBool()) {
            macroblock.mode = 16;
            macroblock.quant = mPEG4DecodingContext.quant;
            Macroblock.Vector[] vectorArr = macroblock.mvs;
            Macroblock.Vector vector = vectorArr[0];
            Macroblock.Vector vector2 = vectorArr[1];
            Macroblock.Vector vector3 = vectorArr[2];
            Macroblock.Vector vector4 = vectorArr[3];
            vector4.x = 0;
            vector3.x = 0;
            vector2.x = 0;
            vector.x = 0;
            vector4.y = 0;
            vector3.y = 0;
            vector2.y = 0;
            vector.y = 0;
            macroblock.cbp = 0;
            readInterCoeffs(bitReader, mPEG4DecodingContext, macroblock);
            return;
        }
        macroblock.coded = true;
        int mcbpcInter = readMcbpcInter(bitReader);
        int i2 = mcbpcInter & 7;
        macroblock.mode = i2;
        int i3 = mcbpcInter >>> 4;
        boolean z = i2 == 3 || i2 == 4;
        if (z) {
            macroblock.acpredFlag = bitReader.readBool();
        }
        macroblock.mcsel = false;
        macroblock.cbp = i3 | (readCbpy(bitReader, z) << 2);
        int i4 = macroblock.mode;
        if (i4 == 1 || i4 == 4) {
            int i5 = mPEG4DecodingContext.quant + DQUANT_TABLE[bitReader.readNBit(2)];
            mPEG4DecodingContext.quant = i5;
            if (i5 > 31) {
                mPEG4DecodingContext.quant = 31;
            } else if (i5 < 1) {
                mPEG4DecodingContext.quant = 1;
            }
        }
        macroblock.quant = mPEG4DecodingContext.quant;
        if (mPEG4DecodingContext.interlacing) {
            if (macroblock.cbp != 0 || z) {
                macroblock.fieldDCT = bitReader.readBool();
            }
            int i6 = macroblock.mode;
            if (i6 == 0 || i6 == 1) {
                boolean bool = bitReader.readBool();
                macroblock.fieldPred = bool;
                if (bool) {
                    macroblock.fieldForTop = bitReader.readBool();
                    macroblock.fieldForBottom = bitReader.readBool();
                }
            }
        }
        int i7 = macroblock.mode;
        if (i7 != 0 && i7 != 1 && i7 != 2) {
            Macroblock.Vector[] vectorArr2 = macroblock.mvs;
            Macroblock.Vector vector5 = vectorArr2[0];
            Macroblock.Vector vector6 = vectorArr2[1];
            Macroblock.Vector vector7 = vectorArr2[2];
            Macroblock.Vector vector8 = vectorArr2[3];
            vector8.x = 0;
            vector7.x = 0;
            vector6.x = 0;
            vector5.x = 0;
            vector8.y = 0;
            vector7.y = 0;
            vector6.y = 0;
            vector5.y = 0;
            readCoeffIntra(bitReader, mPEG4DecodingContext, macroblock, macroblock2, macroblock3, macroblock4);
            return;
        }
        if (i7 == 0 || i7 == 1) {
            if (mPEG4DecodingContext.interlacing && macroblock.fieldPred) {
                readMVInterlaced(bitReader, mPEG4DecodingContext, macroblock.x, macroblock.y, 0, macroblock, i, macroblock.bound, macroblock, macroblock2, macroblock3, macroblock5);
            } else {
                readMV(bitReader, mPEG4DecodingContext, macroblock.x, macroblock.y, 0, macroblock.mvs[0], i, macroblock.bound, macroblock, macroblock2, macroblock3, macroblock5);
                Macroblock.Vector[] vectorArr3 = macroblock.mvs;
                Macroblock.Vector vector9 = vectorArr3[1];
                Macroblock.Vector vector10 = vectorArr3[2];
                Macroblock.Vector vector11 = vectorArr3[3];
                Macroblock.Vector vector12 = vectorArr3[0];
                int i8 = vector12.x;
                vector11.x = i8;
                vector10.x = i8;
                vector9.x = i8;
                int i9 = vector12.y;
                vector11.y = i9;
                vector10.y = i9;
                vector9.y = i9;
            }
        } else if (i7 == 2) {
            readMV(bitReader, mPEG4DecodingContext, macroblock.x, macroblock.y, 0, macroblock.mvs[0], i, macroblock.bound, macroblock, macroblock2, macroblock3, macroblock5);
            readMV(bitReader, mPEG4DecodingContext, macroblock.x, macroblock.y, 1, macroblock.mvs[1], i, macroblock.bound, macroblock, macroblock2, macroblock3, macroblock5);
            readMV(bitReader, mPEG4DecodingContext, macroblock.x, macroblock.y, 2, macroblock.mvs[2], i, macroblock.bound, macroblock, macroblock2, macroblock3, macroblock5);
            readMV(bitReader, mPEG4DecodingContext, macroblock.x, macroblock.y, 3, macroblock.mvs[3], i, macroblock.bound, macroblock, macroblock2, macroblock3, macroblock5);
        }
        if (macroblock.fieldPred) {
            readInterCoeffs(bitReader, mPEG4DecodingContext, macroblock);
        } else {
            readInterCoeffs(bitReader, mPEG4DecodingContext, macroblock);
        }
    }

    public static void readIntraBlock(BitReader bitReader, short[] sArr, int i, int i2) {
        int coeffs;
        short[] sArr2 = MPEG4Consts.SCAN_TABLES[i];
        do {
            coeffs = readCoeffs(bitReader, true, false);
            int iLevel = level(coeffs);
            int iRun = i2 + run(coeffs);
            if ((iRun & (-64)) != 0) {
                Logger.error("invalid run or index");
                return;
            }
            sArr[sArr2[iRun]] = (short) iLevel;
            if (iLevel < -2047 || iLevel > 2047) {
                Logger.error("intra_overflow: " + iLevel);
            }
            i2 = iRun + 1;
        } while (last(coeffs) == 0);
    }

    public static void readIntraMode(BitReader bitReader, MPEG4DecodingContext mPEG4DecodingContext, Macroblock macroblock) {
        while (bitReader.checkNBit(9) == 1) {
            bitReader.skip(9);
        }
        if (checkResyncMarker(bitReader, 0)) {
            int videoPacketHeader = readVideoPacketHeader(bitReader, mPEG4DecodingContext, 0, false, false, true);
            macroblock.bound = videoPacketHeader;
            int i = mPEG4DecodingContext.mbWidth;
            macroblock.x = videoPacketHeader % i;
            macroblock.y = videoPacketHeader / i;
        }
        int mcbpcIntra = readMcbpcIntra(bitReader);
        macroblock.mode = mcbpcIntra & 7;
        macroblock.acpredFlag = bitReader.readBool();
        macroblock.cbp = (mcbpcIntra >>> 4) | (readCbpy(bitReader, true) << 2);
        if (macroblock.mode == 4) {
            int i2 = mPEG4DecodingContext.quant + DQUANT_TABLE[bitReader.readNBit(2)];
            mPEG4DecodingContext.quant = i2;
            if (i2 > 31) {
                mPEG4DecodingContext.quant = 31;
            } else if (i2 < 1) {
                mPEG4DecodingContext.quant = 1;
            }
        }
        macroblock.quant = mPEG4DecodingContext.quant;
        Macroblock.Vector[] vectorArr = macroblock.mvs;
        Macroblock.Vector vector = vectorArr[0];
        Macroblock.Vector vector2 = vectorArr[1];
        Macroblock.Vector vector3 = vectorArr[2];
        Macroblock.Vector vector4 = vectorArr[3];
        vector4.y = 0;
        vector4.x = 0;
        vector3.y = 0;
        vector3.x = 0;
        vector2.y = 0;
        vector2.x = 0;
        vector.y = 0;
        vector.x = 0;
        if (mPEG4DecodingContext.interlacing) {
            macroblock.fieldDCT = bitReader.readBool();
        }
    }

    public static int readMBType(BitReader bitReader) {
        for (int i = 0; i <= 3; i++) {
            if (bitReader.readBool()) {
                return i;
            }
        }
        return -1;
    }

    private static void readMV(BitReader bitReader, MPEG4DecodingContext mPEG4DecodingContext, int i, int i2, int i3, Macroblock.Vector vector, int i4, int i5, Macroblock macroblock, Macroblock macroblock2, Macroblock macroblock3, Macroblock macroblock4) {
        int i6 = 1 << (i4 - 1);
        int i7 = (i6 * 32) - 1;
        int i8 = i6 * (-32);
        int i9 = i6 * 64;
        Macroblock.Vector pmv2 = getPMV2(mPEG4DecodingContext, i5, i, i2, i3, macroblock, macroblock2, macroblock3, macroblock4);
        Macroblock.Vector vectorVec = Macroblock.vec();
        vectorVec.x = readMVComponent(bitReader, i4);
        int mVComponent = readMVComponent(bitReader, i4);
        vectorVec.y = mVComponent;
        int i10 = vectorVec.x + pmv2.x;
        vectorVec.x = i10;
        int i11 = mVComponent + pmv2.y;
        vectorVec.y = i11;
        if (i10 < i8) {
            vectorVec.x = i10 + i9;
        } else if (i10 > i7) {
            vectorVec.x = i10 - i9;
        }
        if (i11 < i8) {
            vectorVec.y = i11 + i9;
        } else if (i11 > i7) {
            vectorVec.y = i11 - i9;
        }
        vector.x = vectorVec.x;
        vector.y = vectorVec.y;
    }

    public static int readMVComponent(BitReader bitReader, int i) {
        int i2 = i - 1;
        int i3 = 1 << i2;
        int mVData = readMVData(bitReader);
        if (i3 == 1 || mVData == 0) {
            return mVData;
        }
        int iAbs = ((Math.abs(mVData) - 1) * i3) + bitReader.readNBit(i2) + 1;
        return mVData < 0 ? -iAbs : iAbs;
    }

    public static int readMVData(BitReader bitReader) {
        int[] iArr;
        if (bitReader.readBool()) {
            return 0;
        }
        int iCheckNBit = bitReader.checkNBit(12);
        if (iCheckNBit >= 512) {
            iArr = MPEG4Consts.TMNMV_TAB_0[(iCheckNBit >> 8) - 2];
        } else if (iCheckNBit >= 128) {
            iArr = MPEG4Consts.TMNMV_TAB_1[(iCheckNBit >> 2) - 32];
        } else {
            if (iCheckNBit < 4) {
                return 0;
            }
            iArr = MPEG4Consts.TMNMV_TAB_2[iCheckNBit - 4];
        }
        bitReader.skip(iArr[1]);
        return iArr[0];
    }

    private static void readMVInterlaced(BitReader bitReader, MPEG4DecodingContext mPEG4DecodingContext, int i, int i2, int i3, Macroblock macroblock, int i4, int i5, Macroblock macroblock2, Macroblock macroblock3, Macroblock macroblock4, Macroblock macroblock5) {
        int i6 = 1 << (i4 - 1);
        int i7 = (i6 * 32) - 1;
        int i8 = i6 * (-32);
        int i9 = i6 * 64;
        Macroblock.Vector pMV2Interlaced = getPMV2Interlaced(mPEG4DecodingContext, i5, macroblock2, macroblock3, macroblock4, macroblock5);
        Macroblock.Vector vectorVec = Macroblock.vec();
        Macroblock.Vector vectorVec2 = Macroblock.vec();
        Macroblock.Vector vectorVec3 = Macroblock.vec();
        if (!macroblock.fieldPred) {
            vectorVec.x = readMVComponent(bitReader, i4);
            int mVComponent = readMVComponent(bitReader, i4);
            vectorVec.y = mVComponent;
            int i10 = vectorVec.x + pMV2Interlaced.x;
            vectorVec.x = i10;
            int i11 = mVComponent + pMV2Interlaced.y;
            vectorVec.y = i11;
            if (i10 < i8) {
                vectorVec.x = i10 + i9;
            } else if (i10 > i7) {
                vectorVec.x = i10 - i9;
            }
            if (i11 < i8) {
                vectorVec.y = i11 + i9;
            } else if (i11 > i7) {
                vectorVec.y = i11 - i9;
            }
            Macroblock.Vector[] vectorArr = macroblock.mvs;
            vectorArr[3] = vectorVec;
            vectorArr[2] = vectorVec;
            vectorArr[1] = vectorVec;
            vectorArr[0] = vectorVec;
            return;
        }
        vectorVec2.x = readMVComponent(bitReader, i4);
        int mVComponent2 = readMVComponent(bitReader, i4);
        vectorVec2.y = mVComponent2;
        int i12 = vectorVec2.x + pMV2Interlaced.x;
        vectorVec2.x = i12;
        int i13 = (mVComponent2 + (pMV2Interlaced.y / 2)) * 2;
        vectorVec2.y = i13;
        if (i12 < i8) {
            vectorVec2.x = i12 + i9;
        } else if (i12 > i7) {
            vectorVec2.x = i12 - i9;
        }
        if (i13 < i8) {
            vectorVec2.y = i13 + i9;
        } else if (i13 > i7) {
            vectorVec2.y = i13 - i9;
        }
        vectorVec3.x = readMVComponent(bitReader, i4);
        int mVComponent3 = readMVComponent(bitReader, i4);
        vectorVec3.y = mVComponent3;
        int i14 = vectorVec3.x + pMV2Interlaced.x;
        vectorVec3.x = i14;
        int i15 = (mVComponent3 + (pMV2Interlaced.y / 2)) * 2;
        vectorVec3.y = i15;
        if (i14 < i8) {
            vectorVec3.x = i14 + i9;
        } else if (i14 > i7) {
            vectorVec3.x = i14 - i9;
        }
        if (i15 < i8) {
            vectorVec3.y = i15 + i9;
        } else if (i15 > i7) {
            vectorVec3.y = i15 - i9;
        }
        Macroblock.Vector[] vectorArr2 = macroblock.mvs;
        vectorArr2[0] = vectorVec2;
        vectorArr2[1] = vectorVec3;
        Macroblock.Vector vector = vectorArr2[2];
        Macroblock.Vector vector2 = vectorArr2[3];
        vector2.x = 0;
        vector.x = 0;
        vector2.y = 0;
        vector.y = 0;
        int i16 = vectorVec2.x + vectorVec3.x;
        Macroblock.Vector vector3 = macroblock.mvsAvg;
        vector3.x = (i16 & 1) | (i16 >> 1);
        int i17 = vectorVec2.y + vectorVec3.y;
        vector3.y = (i17 & 1) | (i17 >> 1);
    }

    public static int readMcbpcInter(BitReader bitReader) {
        int iMin = Math.min(bitReader.checkNBit(9), 256);
        int[][] iArr = MPEG4Consts.MCBPC_INTER_TABLE;
        bitReader.skip(iArr[iMin][1]);
        return iArr[iMin][0];
    }

    public static int readMcbpcIntra(BitReader bitReader) {
        int iCheckNBit = bitReader.checkNBit(9) >> 3;
        int[][] iArr = MPEG4Consts.MCBPC_INTRA_TABLE;
        bitReader.skip(iArr[iCheckNBit][1]);
        return iArr[iCheckNBit][0];
    }

    public static int readVideoPacketHeader(BitReader bitReader, MPEG4DecodingContext mPEG4DecodingContext, int i, boolean z, boolean z2, boolean z3) {
        boolean bool;
        int iLog2 = MathUtil.log2((mPEG4DecodingContext.mbWidth * mPEG4DecodingContext.mbHeight) - 1) + 1;
        bitReader.align();
        bitReader.skip(i + 17);
        if (mPEG4DecodingContext.shape != 0) {
            bool = bitReader.readBool();
            if (bool && mPEG4DecodingContext.spriteEnable != 1) {
                bitReader.skip(13);
                bitReader.skip(1);
                bitReader.skip(13);
                bitReader.skip(1);
                bitReader.skip(13);
                bitReader.skip(1);
                bitReader.skip(13);
                bitReader.skip(1);
            }
        } else {
            bool = false;
        }
        int nBit = bitReader.readNBit(iLog2);
        if (mPEG4DecodingContext.shape != 2) {
            mPEG4DecodingContext.quant = bitReader.readNBit(mPEG4DecodingContext.quantBits);
        }
        if (mPEG4DecodingContext.shape == 0) {
            bool = bitReader.readBool();
        }
        if (bool) {
            while (bitReader.readBool()) {
            }
            bitReader.skip(1);
            int i2 = mPEG4DecodingContext.timeIncrementBits;
            if (i2 != 0) {
                bitReader.readNBit(i2);
            }
            bitReader.skip(1);
            int nBit2 = bitReader.readNBit(2);
            if (mPEG4DecodingContext.shape != 0) {
                bitReader.skip(1);
                if (nBit2 != 0) {
                    bitReader.skip(1);
                }
            }
            if (mPEG4DecodingContext.shape != 2) {
                if (z3) {
                    mPEG4DecodingContext.intraDCThreshold = MPEG4Consts.INTRA_DC_THRESHOLD_TABLE[bitReader.readNBit(3)];
                }
                int i3 = mPEG4DecodingContext.spriteEnable;
                if (mPEG4DecodingContext.reducedResolutionEnable && mPEG4DecodingContext.shape == 0 && (nBit2 == 1 || nBit2 == 0)) {
                    bitReader.skip(1);
                }
                if (nBit2 != 0 && z) {
                    mPEG4DecodingContext.fcodeForward = bitReader.readNBit(3);
                }
                if (nBit2 == 2 && z2) {
                    mPEG4DecodingContext.fcodeBackward = bitReader.readNBit(3);
                }
            }
        }
        if (mPEG4DecodingContext.newPredEnable) {
            bitReader.readNBit(Math.min(mPEG4DecodingContext.timeIncrementBits + 3, 15));
            if (bitReader.readBool()) {
                bitReader.readNBit(Math.min(mPEG4DecodingContext.timeIncrementBits + 3, 15));
            }
            bitReader.skip(1);
        }
        return nBit;
    }

    public static int run(int i) {
        return (i >> 16) & 255;
    }

    private static int selectCand(int i, int i2, int i3) {
        int i4 = i - i2;
        int iNeg = neg(i4);
        int iNeg2 = neg(i - i3);
        int iNeg3 = neg(i2 - i3);
        int i5 = i2 - i;
        return (i - iNeg) + neg(((i5 + neg((i4 + iNeg3) - iNeg2)) + iNeg) - iNeg3);
    }
}
