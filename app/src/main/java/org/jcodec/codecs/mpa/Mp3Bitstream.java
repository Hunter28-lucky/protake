package org.jcodec.codecs.mpa;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.common.Vector2Int;
import org.jcodec.common.Vector4Int;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class Mp3Bitstream {

    public static class Granule {
        public int bigValues;
        public int blockType;
        public int count1tableSelect;
        public int globalGain;
        public boolean mixedBlockFlag;
        public int part23Length;
        public boolean preflag;
        public int region0Count;
        public int region1Count;
        public int scalefacCompress;
        public int scalefacScale;
        public boolean windowSwitchingFlag;
        public int[] tableSelect = new int[3];
        public int[] subblockGain = new int[3];
    }

    public static class MP3SideInfo {
        public int mainDataBegin;
        public int privateBits;
        public boolean[][] scfsi = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, 2, 4);
        public Granule[][] granule = {new Granule[]{new Granule(), new Granule()}, new Granule[]{new Granule(), new Granule()}};
    }

    public static class ScaleFactors {
        public int[] large = new int[23];
        public int[][] small = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 3, 13);
    }

    public static int readBigVal(int i, BitReader bitReader) {
        int vlc = MpaConst.bigValVlc[i].readVLC(bitReader);
        int nBit = vlc >>> 4;
        int nBit2 = vlc & 15;
        if (MpaConst.bigValEscBits[i] != 0 && MpaConst.bigValMaxval[i] - 1 == nBit) {
            nBit += bitReader.readNBit(MpaConst.bigValEscBits[i]);
        }
        if (nBit != 0 && bitReader.read1Bit() != 0) {
            nBit = -nBit;
        }
        if (MpaConst.bigValEscBits[i] != 0 && MpaConst.bigValMaxval[i] - 1 == nBit2) {
            nBit2 += bitReader.readNBit(MpaConst.bigValEscBits[i]);
        }
        if (nBit2 != 0 && bitReader.read1Bit() != 0) {
            nBit2 = -nBit2;
        }
        return Vector2Int.pack16(nBit, nBit2);
    }

    public static int readCoeffs(BitReader bitReader, Granule granule, int i, int i2, int i3, int[] iArr) {
        int i4;
        int i5 = i2 + granule.part23Length;
        int i6 = i3 == 8 ? 72 : 36;
        if (granule.windowSwitchingFlag && granule.blockType == 2) {
            i4 = 576;
        } else {
            int iClip = MathUtil.clip(granule.region0Count + granule.region1Count + 2, 0, MpaConst.sfbLong[i3].length - 1);
            int[] iArr2 = MpaConst.sfbLong[i3];
            int i7 = iArr2[granule.region0Count + 1];
            i4 = iArr2[iClip];
            i6 = i7;
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < (granule.bigValues << 1)) {
            int i10 = i8 < i6 ? granule.tableSelect[0] : i8 < i4 ? granule.tableSelect[1] : granule.tableSelect[2];
            if (i10 == 0 || i10 == 4 || i10 == 14) {
                int i11 = i9 + 1;
                iArr[i9] = 0;
                i9 = i11 + 1;
                iArr[i11] = 0;
            } else {
                int bigVal = readBigVal(i10, bitReader);
                int i12 = i9 + 1;
                iArr[i9] = Vector2Int.el16_0(bigVal);
                i9 = i12 + 1;
                iArr[i12] = Vector2Int.el16_1(bigVal);
            }
            i8 += 2;
        }
        while (bitReader.position() < i5 && i9 < 576) {
            int count1 = readCount1(granule.count1tableSelect, bitReader);
            int i13 = i9 + 1;
            iArr[i9] = Vector4Int.el8_0(count1);
            int i14 = i13 + 1;
            iArr[i13] = Vector4Int.el8_1(count1);
            int i15 = i14 + 1;
            iArr[i14] = Vector4Int.el8_2(count1);
            i9 = i15 + 1;
            iArr[i15] = Vector4Int.el8_3(count1);
        }
        if (bitReader.position() < i5) {
            bitReader.readNBit(i5 - bitReader.position());
        }
        return MathUtil.clip(i9, 0, 576);
    }

    public static int readCount1(int i, BitReader bitReader) {
        int vlc = (i == 0 ? MpaConst.cnt1A : MpaConst.cnt1B).readVLC(bitReader);
        int i2 = (vlc >> 3) & 1;
        int i3 = (vlc >> 2) & 1;
        int i4 = (vlc >> 1) & 1;
        int i5 = vlc & 1;
        if (i2 != 0 && bitReader.read1Bit() != 0) {
            i2 = -i2;
        }
        if (i3 != 0 && bitReader.read1Bit() != 0) {
            i3 = -i3;
        }
        if (i4 != 0 && bitReader.read1Bit() != 0) {
            i4 = -i4;
        }
        if (i5 != 0 && bitReader.read1Bit() != 0) {
            i5 = -i5;
        }
        return Vector4Int.pack8(i2, i3, i4, i5);
    }

    private static int[] readLSFScaleData(BitReader bitReader, MpaHeader mpaHeader, Granule granule, int i) {
        int[] iArr = new int[54];
        int[] iArr2 = new int[4];
        int i2 = granule.scalefacCompress;
        char c = 2;
        char c2 = granule.blockType == 2 ? granule.mixedBlockFlag ? (char) 2 : (char) 1 : (char) 0;
        int i3 = mpaHeader.modeExtension;
        if ((i3 == 1 || i3 == 3) && i == 1) {
            int i4 = i2 >>> 1;
            if (i4 < 180) {
                iArr2[0] = i4 / 36;
                int i5 = i4 % 36;
                iArr2[1] = i5 / 6;
                iArr2[2] = i5 % 6;
                iArr2[3] = 0;
                granule.preflag = false;
                c = 3;
            } else if (i4 < 244) {
                int i6 = i4 - MPEGConst.SEQUENCE_ERROR_CODE;
                iArr2[0] = (i6 & 63) >>> 4;
                iArr2[1] = (i6 & 15) >>> 2;
                iArr2[2] = i6 & 3;
                iArr2[3] = 0;
                granule.preflag = false;
                c = 4;
            } else if (i4 < 255) {
                int i7 = i4 - H264Const.PROFILE_HIGH_444;
                iArr2[0] = i7 / 3;
                iArr2[1] = i7 % 3;
                iArr2[2] = 0;
                iArr2[3] = 0;
                granule.preflag = false;
                c = 5;
            } else {
                c = 0;
            }
        } else {
            if (i2 < 400) {
                int i8 = i2 >>> 4;
                iArr2[0] = i8 / 5;
                iArr2[1] = i8 % 5;
                iArr2[2] = (i2 & 15) >>> 2;
                iArr2[3] = i2 & 3;
                granule.preflag = false;
            } else if (i2 < 500) {
                int i9 = i2 - 400;
                int i10 = i9 >>> 2;
                iArr2[0] = i10 / 5;
                iArr2[1] = i10 % 5;
                iArr2[2] = i9 & 3;
                iArr2[3] = 0;
                granule.preflag = false;
                c = 1;
            } else if (i2 < 512) {
                int i11 = i2 - 500;
                iArr2[0] = i11 / 3;
                iArr2[1] = i11 % 3;
                iArr2[2] = 0;
                iArr2[3] = 0;
                granule.preflag = true;
            }
            c = 0;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < 4; i13++) {
            int i14 = 0;
            while (i14 < MpaConst.numberOfScaleFactors[c][c2][i13]) {
                int i15 = iArr2[i13];
                iArr[i12] = i15 == 0 ? 0 : bitReader.readNBit(i15);
                i14++;
                i12++;
            }
        }
        return iArr;
    }

    public static ScaleFactors readLSFScaleFactors(BitReader bitReader, MpaHeader mpaHeader, Granule granule, int i) {
        ScaleFactors scaleFactors = new ScaleFactors();
        int[] lSFScaleData = readLSFScaleData(bitReader, mpaHeader, granule, i);
        if (!granule.windowSwitchingFlag || granule.blockType != 2) {
            int i2 = 0;
            for (int i3 = 0; i3 < 21; i3++) {
                scaleFactors.large[i3] = lSFScaleData[i2];
                i2++;
            }
            int[] iArr = scaleFactors.large;
            iArr[21] = 0;
            iArr[22] = 0;
        } else if (granule.mixedBlockFlag) {
            int i4 = 0;
            for (int i5 = 0; i5 < 8; i5++) {
                scaleFactors.large[i5] = lSFScaleData[i4];
                i4++;
            }
            for (int i6 = 3; i6 < 12; i6++) {
                for (int i7 = 0; i7 < 3; i7++) {
                    scaleFactors.small[i7][i6] = lSFScaleData[i4];
                    i4++;
                }
            }
            for (int i8 = 0; i8 < 3; i8++) {
                scaleFactors.small[i8][12] = 0;
            }
        } else {
            int i9 = 0;
            for (int i10 = 0; i10 < 12; i10++) {
                for (int i11 = 0; i11 < 3; i11++) {
                    scaleFactors.small[i11][i10] = lSFScaleData[i9];
                    i9++;
                }
            }
            for (int i12 = 0; i12 < 3; i12++) {
                scaleFactors.small[i12][12] = 0;
            }
        }
        return scaleFactors;
    }

    private static ScaleFactors readScaleFacMixed(BitReader bitReader, Granule granule) {
        int i;
        ScaleFactors scaleFactors = new ScaleFactors();
        for (int i2 = 0; i2 < 8; i2++) {
            scaleFactors.large[i2] = bitReader.readNBit(MpaConst.scaleFactorLen[0][granule.scalefacCompress]);
        }
        int i3 = 3;
        while (true) {
            if (i3 >= 6) {
                break;
            }
            for (int i4 = 0; i4 < 3; i4++) {
                scaleFactors.small[i4][i3] = bitReader.readNBit(MpaConst.scaleFactorLen[0][granule.scalefacCompress]);
            }
            i3++;
        }
        for (i = 6; i < 12; i++) {
            for (int i5 = 0; i5 < 3; i5++) {
                scaleFactors.small[i5][i] = bitReader.readNBit(MpaConst.scaleFactorLen[1][granule.scalefacCompress]);
            }
        }
        for (int i6 = 0; i6 < 3; i6++) {
            scaleFactors.small[i6][12] = 0;
        }
        return scaleFactors;
    }

    private static ScaleFactors readScaleFacNonSwitch(BitReader bitReader, Granule granule, boolean[] zArr) {
        ScaleFactors scaleFactors = new ScaleFactors();
        int[][] iArr = MpaConst.scaleFactorLen;
        int[] iArr2 = iArr[0];
        int i = granule.scalefacCompress;
        int i2 = iArr2[i];
        int i3 = iArr[1][i];
        if (zArr[0]) {
            for (int i4 = 0; i4 < 6; i4++) {
                scaleFactors.large[i4] = bitReader.readNBit(i2);
            }
        }
        if (zArr[1]) {
            for (int i5 = 6; i5 < 11; i5++) {
                scaleFactors.large[i5] = bitReader.readNBit(i2);
            }
        }
        if (zArr[2]) {
            for (int i6 = 11; i6 < 16; i6++) {
                scaleFactors.large[i6] = bitReader.readNBit(i3);
            }
        }
        if (zArr[3]) {
            for (int i7 = 16; i7 < 21; i7++) {
                scaleFactors.large[i7] = bitReader.readNBit(i3);
            }
        }
        int[] iArr3 = scaleFactors.large;
        iArr3[21] = 0;
        iArr3[22] = 0;
        return scaleFactors;
    }

    private static ScaleFactors readScaleFacShort(BitReader bitReader, Granule granule) {
        int i;
        ScaleFactors scaleFactors = new ScaleFactors();
        int[][] iArr = MpaConst.scaleFactorLen;
        int[] iArr2 = iArr[0];
        int i2 = granule.scalefacCompress;
        int i3 = iArr2[i2];
        int i4 = iArr[1][i2];
        int i5 = 0;
        while (true) {
            if (i5 >= 6) {
                break;
            }
            for (int i6 = 0; i6 < 3; i6++) {
                scaleFactors.small[i6][i5] = bitReader.readNBit(i3);
            }
            i5++;
        }
        for (i = 6; i < 12; i++) {
            for (int i7 = 0; i7 < 3; i7++) {
                scaleFactors.small[i7][i] = bitReader.readNBit(i4);
            }
        }
        int[][] iArr3 = scaleFactors.small;
        iArr3[0][12] = 0;
        iArr3[1][12] = 0;
        iArr3[2][12] = 0;
        return scaleFactors;
    }

    public static ScaleFactors readScaleFactors(BitReader bitReader, Granule granule, boolean[] zArr) {
        return (granule.windowSwitchingFlag && granule.blockType == 2) ? granule.mixedBlockFlag ? readScaleFacMixed(bitReader, granule) : readScaleFacShort(bitReader, granule) : readScaleFacNonSwitch(bitReader, granule, zArr);
    }

    public static MP3SideInfo readSideInfo(MpaHeader mpaHeader, ByteBuffer byteBuffer, int i) {
        MP3SideInfo mP3SideInfo = new MP3SideInfo();
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        int i2 = 12;
        if (mpaHeader.version == 1) {
            mP3SideInfo.mainDataBegin = bitReaderCreateBitReader.readNBit(9);
            if (i == 1) {
                mP3SideInfo.privateBits = bitReaderCreateBitReader.readNBit(5);
            } else {
                mP3SideInfo.privateBits = bitReaderCreateBitReader.readNBit(3);
            }
            for (int i3 = 0; i3 < i; i3++) {
                mP3SideInfo.scfsi[i3][0] = bitReaderCreateBitReader.read1Bit() == 0;
                mP3SideInfo.scfsi[i3][1] = bitReaderCreateBitReader.read1Bit() == 0;
                mP3SideInfo.scfsi[i3][2] = bitReaderCreateBitReader.read1Bit() == 0;
                mP3SideInfo.scfsi[i3][3] = bitReaderCreateBitReader.read1Bit() == 0;
            }
            for (int i4 = 0; i4 < 2; i4++) {
                for (int i5 = 0; i5 < i; i5++) {
                    Granule granule = mP3SideInfo.granule[i5][i4];
                    granule.part23Length = bitReaderCreateBitReader.readNBit(12);
                    granule.bigValues = bitReaderCreateBitReader.readNBit(9);
                    granule.globalGain = bitReaderCreateBitReader.readNBit(8);
                    granule.scalefacCompress = bitReaderCreateBitReader.readNBit(4);
                    boolean z = bitReaderCreateBitReader.readNBit(1) != 0;
                    granule.windowSwitchingFlag = z;
                    if (z) {
                        granule.blockType = bitReaderCreateBitReader.readNBit(2);
                        granule.mixedBlockFlag = bitReaderCreateBitReader.readNBit(1) != 0;
                        granule.tableSelect[0] = bitReaderCreateBitReader.readNBit(5);
                        granule.tableSelect[1] = bitReaderCreateBitReader.readNBit(5);
                        granule.subblockGain[0] = bitReaderCreateBitReader.readNBit(3);
                        granule.subblockGain[1] = bitReaderCreateBitReader.readNBit(3);
                        granule.subblockGain[2] = bitReaderCreateBitReader.readNBit(3);
                        int i6 = granule.blockType;
                        if (i6 == 0) {
                            return null;
                        }
                        if (i6 != 2 || granule.mixedBlockFlag) {
                            granule.region0Count = 7;
                        } else {
                            granule.region0Count = 8;
                        }
                        granule.region1Count = 20 - granule.region0Count;
                    } else {
                        granule.tableSelect[0] = bitReaderCreateBitReader.readNBit(5);
                        granule.tableSelect[1] = bitReaderCreateBitReader.readNBit(5);
                        granule.tableSelect[2] = bitReaderCreateBitReader.readNBit(5);
                        granule.region0Count = bitReaderCreateBitReader.readNBit(4);
                        granule.region1Count = bitReaderCreateBitReader.readNBit(3);
                        granule.blockType = 0;
                    }
                    granule.preflag = bitReaderCreateBitReader.readNBit(1) != 0;
                    granule.scalefacScale = bitReaderCreateBitReader.readNBit(1);
                    granule.count1tableSelect = bitReaderCreateBitReader.readNBit(1);
                }
            }
        } else {
            mP3SideInfo.mainDataBegin = bitReaderCreateBitReader.readNBit(8);
            if (i == 1) {
                mP3SideInfo.privateBits = bitReaderCreateBitReader.readNBit(1);
            } else {
                mP3SideInfo.privateBits = bitReaderCreateBitReader.readNBit(2);
            }
            int i7 = 0;
            while (i7 < i) {
                Granule granule2 = mP3SideInfo.granule[i7][0];
                granule2.part23Length = bitReaderCreateBitReader.readNBit(i2);
                granule2.bigValues = bitReaderCreateBitReader.readNBit(9);
                granule2.globalGain = bitReaderCreateBitReader.readNBit(8);
                granule2.scalefacCompress = bitReaderCreateBitReader.readNBit(9);
                boolean z2 = bitReaderCreateBitReader.readNBit(1) != 0;
                granule2.windowSwitchingFlag = z2;
                if (z2) {
                    granule2.blockType = bitReaderCreateBitReader.readNBit(2);
                    granule2.mixedBlockFlag = bitReaderCreateBitReader.readNBit(1) != 0;
                    granule2.tableSelect[0] = bitReaderCreateBitReader.readNBit(5);
                    granule2.tableSelect[1] = bitReaderCreateBitReader.readNBit(5);
                    granule2.subblockGain[0] = bitReaderCreateBitReader.readNBit(3);
                    granule2.subblockGain[1] = bitReaderCreateBitReader.readNBit(3);
                    granule2.subblockGain[2] = bitReaderCreateBitReader.readNBit(3);
                    int i8 = granule2.blockType;
                    if (i8 == 0) {
                        return null;
                    }
                    if (i8 != 2 || granule2.mixedBlockFlag) {
                        granule2.region0Count = 7;
                        granule2.region1Count = 20 - 7;
                    } else {
                        granule2.region0Count = 8;
                    }
                } else {
                    granule2.tableSelect[0] = bitReaderCreateBitReader.readNBit(5);
                    granule2.tableSelect[1] = bitReaderCreateBitReader.readNBit(5);
                    granule2.tableSelect[2] = bitReaderCreateBitReader.readNBit(5);
                    granule2.region0Count = bitReaderCreateBitReader.readNBit(4);
                    granule2.region1Count = bitReaderCreateBitReader.readNBit(3);
                    granule2.blockType = 0;
                }
                granule2.scalefacScale = bitReaderCreateBitReader.readNBit(1);
                granule2.count1tableSelect = bitReaderCreateBitReader.readNBit(1);
                i7++;
                i2 = 12;
            }
        }
        bitReaderCreateBitReader.terminate();
        return mP3SideInfo;
    }
}
