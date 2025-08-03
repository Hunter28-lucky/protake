package org.jcodec.codecs.h264.io;

import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.decode.CAVLCReader;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.common.SaveRestore;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.io.VLC;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class CAVLC implements SaveRestore {
    public static int[] NO_ZIGZAG = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private VLC chromaDCVLC = codeTableChromaDC();
    private ColorSpace color;
    private int mbMask;
    private int mbWidth;
    private int[] tokensLeft;
    private int[] tokensLeftSaved;
    private int[] tokensTop;
    private int[] tokensTopSaved;

    public CAVLC(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, int i, int i2) {
        this.color = seqParameterSet.chromaFormatIdc;
        int i3 = seqParameterSet.picWidthInMbsMinus1 + 1;
        this.mbWidth = i3;
        this.mbMask = (1 << i2) - 1;
        this.tokensLeft = new int[4];
        this.tokensTop = new int[i3 << i];
        this.tokensLeftSaved = new int[4];
        this.tokensTopSaved = new int[i3 << i];
    }

    private static int Abs(int i) {
        return i < 0 ? -i : i;
    }

    private static int Min(int i, int i2) {
        return i < i2 ? i : i2;
    }

    public static final int totalCoeff(int i) {
        return i >> 4;
    }

    public static final int trailingOnes(int i) {
        return i & 15;
    }

    private final int unsigned(int i) {
        int i2 = i >> 31;
        return ((((i ^ i2) - i2) << 1) + (i >>> 31)) - 2;
    }

    private int writeBlockGen(BitWriter bitWriter, int[] iArr, VLC[] vlcArr, int i, int i2, int[] iArr2, VLC vlc) {
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = iArr[iArr2[i6 + i]];
            if (i7 == 0) {
                iArr3[i4] = iArr3[i4] + 1;
                i5++;
            } else {
                iArr4[i4] = i7;
                i4++;
            }
        }
        if (i4 < i2) {
            i5 -= iArr3[i4];
        }
        while (i3 < i4 && i3 < 3 && Math.abs(iArr4[(i4 - i3) - 1]) == 1) {
            i3++;
        }
        int iCoeffToken = H264Const.coeffToken(i4, i3);
        vlc.writeVLC(bitWriter, iCoeffToken);
        if (i4 > 0) {
            writeTrailingOnes(bitWriter, iArr4, i4, i3);
            writeLevels(bitWriter, iArr4, i4, i3);
            if (i4 < i2) {
                vlcArr[i4 - 1].writeVLC(bitWriter, i5);
                writeRuns(bitWriter, iArr3, i4, i5);
            }
        }
        return iCoeffToken;
    }

    private void writeLevels(BitWriter bitWriter, int[] iArr, int i, int i2) {
        int i3;
        int i4 = (i <= 10 || i2 >= 3) ? 0 : 1;
        int i5 = (i - i2) - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            int iUnsigned = unsigned(iArr[i6]);
            if (i6 == i5 && i2 < 3) {
                iUnsigned -= 2;
            }
            int i7 = iUnsigned >> i4;
            if ((i4 == 0 && i7 < 14) || (i4 > 0 && i7 < 15)) {
                bitWriter.writeNBit(1, i7 + 1);
                bitWriter.writeNBit(iUnsigned, i4);
            } else if (i4 != 0 || iUnsigned >= 30) {
                if (i4 == 0) {
                    iUnsigned -= 15;
                }
                int i8 = 12;
                while (true) {
                    int i9 = 1 << i8;
                    i3 = ((iUnsigned - ((i8 + 3) << i4)) - i9) + 4096;
                    if (i3 < i9) {
                        break;
                    } else {
                        i8++;
                    }
                }
                bitWriter.writeNBit(1, i8 + 4);
                bitWriter.writeNBit(i3, i8);
            } else {
                bitWriter.writeNBit(1, 15);
                bitWriter.writeNBit(iUnsigned - 14, 4);
            }
            if (i4 == 0) {
                i4 = 1;
            }
            if (MathUtil.abs(iArr[i6]) > (3 << (i4 - 1)) && i4 < 6) {
                i4++;
            }
        }
    }

    private void writeRuns(BitWriter bitWriter, int[] iArr, int i, int i2) {
        for (int i3 = i - 1; i3 > 0 && i2 > 0; i3--) {
            H264Const.run[Math.min(6, i2 - 1)].writeVLC(bitWriter, iArr[i3]);
            i2 -= iArr[i3];
        }
    }

    private void writeTrailingOnes(BitWriter bitWriter, int[] iArr, int i, int i2) {
        for (int i3 = i - 1; i3 >= i - i2; i3--) {
            bitWriter.write1Bit(iArr[i3] >>> 31);
        }
    }

    public VLC codeTableChromaDC() {
        ColorSpace colorSpace = this.color;
        if (colorSpace == ColorSpace.YUV420J) {
            return H264Const.coeffTokenChromaDCY420;
        }
        if (colorSpace == ColorSpace.YUV422) {
            return H264Const.coeffTokenChromaDCY422;
        }
        if (colorSpace == ColorSpace.YUV444) {
            return H264Const.CoeffToken[0];
        }
        return null;
    }

    public int codeTableLuma(boolean z, MBType mBType, int i, boolean z2, MBType mBType2, int i2) {
        int i3 = mBType == null ? 0 : totalCoeff(i);
        int i4 = mBType2 == null ? 0 : totalCoeff(i2);
        if (z && z2) {
            return ((i3 + i4) + 1) >> 1;
        }
        if (z) {
            return i3;
        }
        if (z2) {
            return i4;
        }
        return 0;
    }

    public VLC getCoeffTokenVLCForChromaDC() {
        return this.chromaDCVLC;
    }

    public VLC getCoeffTokenVLCForLuma(boolean z, MBType mBType, int i, boolean z2, MBType mBType2, int i2) {
        return H264Const.CoeffToken[Math.min(codeTableLuma(z, mBType, i, z2, mBType2, i2), 8)];
    }

    public int readACBlock(BitReader bitReader, int[] iArr, int i, int i2, boolean z, MBType mBType, boolean z2, MBType mBType2, int i3, int i4, int[] iArr2) {
        int coeffs = readCoeffs(bitReader, getCoeffTokenVLCForLuma(z, mBType, this.tokensLeft[this.mbMask & i2], z2, mBType2, this.tokensTop[i]), H264Const.totalZeros16, iArr, i3, i4, iArr2);
        int[] iArr3 = this.tokensLeft;
        int i5 = this.mbMask & i2;
        this.tokensTop[i] = coeffs;
        iArr3[i5] = coeffs;
        return totalCoeff(coeffs);
    }

    public void readChromaDCBlock(BitReader bitReader, int[] iArr, boolean z, boolean z2) {
        readCoeffs(bitReader, getCoeffTokenVLCForChromaDC(), iArr.length == 16 ? H264Const.totalZeros16 : iArr.length == 8 ? H264Const.totalZeros8 : H264Const.totalZeros4, iArr, 0, iArr.length, NO_ZIGZAG);
    }

    public int readCoeffs(BitReader bitReader, VLC vlc, VLC[] vlcArr, int[] iArr, int i, int i2, int[] iArr2) {
        int i3;
        int vlc2 = vlc.readVLC(bitReader);
        int i4 = totalCoeff(vlc2);
        int iTrailingOnes = trailingOnes(vlc2);
        if (i4 > 0) {
            int i5 = (i4 <= 10 || iTrailingOnes >= 3) ? 0 : 1;
            int[] iArr3 = new int[i4];
            int i6 = 0;
            while (i6 < iTrailingOnes) {
                iArr3[i6] = 1 - (bitReader.read1Bit() * 2);
                i6++;
            }
            while (true) {
                if (i6 >= i4) {
                    break;
                }
                int zeroBitCount = CAVLCReader.readZeroBitCount(bitReader, "");
                int i7 = (zeroBitCount == 14 && i5 == 0) ? 4 : i5;
                if (zeroBitCount >= 15) {
                    i7 = zeroBitCount - 3;
                }
                int iMin = Min(15, zeroBitCount) << i5;
                if (i7 > 0) {
                    iMin += CAVLCReader.readU(bitReader, i7, "RB: level_suffix");
                }
                if (zeroBitCount >= 15 && i5 == 0) {
                    iMin += 15;
                }
                if (zeroBitCount >= 16) {
                    iMin += (1 << (zeroBitCount - 3)) - 4096;
                }
                if (i6 == iTrailingOnes && iTrailingOnes < 3) {
                    iMin += 2;
                }
                int i8 = iMin;
                if (i8 % 2 == 0) {
                    iArr3[i6] = (i8 + 2) >> 1;
                } else {
                    iArr3[i6] = ((-i8) - 1) >> 1;
                }
                if (i5 == 0) {
                    i5 = 1;
                }
                if (Abs(iArr3[i6]) > (3 << (i5 - 1)) && i5 < 6) {
                    i5++;
                }
                i6++;
            }
            int vlc3 = i4 < i2 ? iArr.length == 4 ? H264Const.totalZeros4[i4 - 1].readVLC(bitReader) : iArr.length == 8 ? H264Const.totalZeros8[i4 - 1].readVLC(bitReader) : H264Const.totalZeros16[i4 - 1].readVLC(bitReader) : 0;
            int[] iArr4 = new int[i4];
            int i9 = 0;
            while (true) {
                i3 = i4 - 1;
                if (i9 >= i3 || vlc3 <= 0) {
                    break;
                }
                int vlc4 = H264Const.run[Math.min(6, vlc3 - 1)].readVLC(bitReader);
                vlc3 -= vlc4;
                iArr4[i9] = vlc4;
                i9++;
            }
            iArr4[i9] = vlc3;
            int i10 = 0;
            while (i3 >= 0 && i10 < i2) {
                int i11 = i10 + iArr4[i3];
                iArr[iArr2[i11 + i]] = iArr3[i3];
                i3--;
                i10 = i11 + 1;
            }
        }
        return vlc2;
    }

    public void readLumaDCBlock(BitReader bitReader, int[] iArr, int i, boolean z, MBType mBType, boolean z2, MBType mBType2, int[] iArr2) {
        readCoeffs(bitReader, getCoeffTokenVLCForLuma(z, mBType, this.tokensLeft[0], z2, mBType2, this.tokensTop[i << 2]), H264Const.totalZeros16, iArr, 0, 16, iArr2);
    }

    @Override // org.jcodec.common.SaveRestore
    public void restore() {
        int[] iArr = this.tokensLeft;
        this.tokensLeft = this.tokensLeftSaved;
        this.tokensLeftSaved = iArr;
        int[] iArr2 = this.tokensTop;
        this.tokensTop = this.tokensTopSaved;
        this.tokensTopSaved = iArr2;
    }

    @Override // org.jcodec.common.SaveRestore
    public void save() {
        int[] iArr = this.tokensLeft;
        System.arraycopy(iArr, 0, this.tokensLeftSaved, 0, iArr.length);
        int[] iArr2 = this.tokensTop;
        System.arraycopy(iArr2, 0, this.tokensTopSaved, 0, iArr2.length);
    }

    public void setZeroCoeff(int i, int i2) {
        int[] iArr = this.tokensLeft;
        int i3 = i2 & this.mbMask;
        this.tokensTop[i] = 0;
        iArr[i3] = 0;
    }

    public int writeACBlock(BitWriter bitWriter, int i, int i2, MBType mBType, MBType mBType2, int[] iArr, VLC[] vlcArr, int i3, int i4, int[] iArr2) {
        int iWriteBlockGen = writeBlockGen(bitWriter, iArr, vlcArr, i3, i4, iArr2, getCoeffTokenVLCForLuma(i != 0, mBType, this.tokensLeft[this.mbMask & i2], i2 != 0, mBType2, this.tokensTop[i]));
        this.tokensLeft[this.mbMask & i2] = iWriteBlockGen;
        this.tokensTop[i] = iWriteBlockGen;
        return iWriteBlockGen;
    }

    public void writeChrDCBlock(BitWriter bitWriter, int[] iArr, VLC[] vlcArr, int i, int i2, int[] iArr2) {
        writeBlockGen(bitWriter, iArr, vlcArr, i, i2, iArr2, getCoeffTokenVLCForChromaDC());
    }

    public void writeLumaDCBlock(BitWriter bitWriter, int i, int i2, MBType mBType, MBType mBType2, int[] iArr, VLC[] vlcArr, int i3, int i4, int[] iArr2) {
        writeBlockGen(bitWriter, iArr, vlcArr, i3, i4, iArr2, getCoeffTokenVLCForLuma(i != 0, mBType, this.tokensLeft[this.mbMask & i2], i2 != 0, mBType2, this.tokensTop[i]));
    }
}
