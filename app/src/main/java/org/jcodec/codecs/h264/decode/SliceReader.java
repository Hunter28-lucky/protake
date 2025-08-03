package org.jcodec.codecs.h264.decode;

import org.jcodec.codecs.common.biari.MDecoder;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.decode.aso.Mapper;
import org.jcodec.codecs.h264.io.CABAC;
import org.jcodec.codecs.h264.io.CAVLC;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.ColorSpace;

/* loaded from: classes2.dex */
public class SliceReader {
    private PictureParameterSet activePps;
    private CABAC cabac;
    private CAVLC[] cavlc;
    public ColorSpace chromaFormat;
    private boolean endOfData;
    public int[] i4x4PredLeft;
    public int[] i4x4PredTop;
    public int leftCBPChroma;
    public int leftCBPLuma;
    public MBType leftMBType;
    private MDecoder mDecoder;
    private Mapper mapper;
    private int mbIdx;
    private int mbSkipRun;
    private NALUnit nalUnit;
    public int[] numRef;
    public H264Const.PartPred[] predModeLeft;
    public H264Const.PartPred[] predModeTop;
    private BitReader reader;
    private SliceHeader sh;
    public boolean tf8x8Left;
    public boolean[] tf8x8Top;
    public int[] topCBPChroma;
    public int[] topCBPLuma;
    public MBType[] topMBType;
    public boolean transform8x8;
    private boolean prevMbSkipped = false;
    private MBType prevMBType = null;

    public SliceReader(PictureParameterSet pictureParameterSet, CABAC cabac, CAVLC[] cavlcArr, MDecoder mDecoder, BitReader bitReader, Mapper mapper, SliceHeader sliceHeader, NALUnit nALUnit) {
        this.activePps = pictureParameterSet;
        this.cabac = cabac;
        this.mDecoder = mDecoder;
        this.cavlc = cavlcArr;
        this.reader = bitReader;
        this.mapper = mapper;
        this.sh = sliceHeader;
        this.nalUnit = nALUnit;
        SeqParameterSet seqParameterSet = sliceHeader.sps;
        int i = seqParameterSet.picWidthInMbsMinus1 + 1;
        this.topMBType = new MBType[i];
        this.topCBPLuma = new int[i];
        this.topCBPChroma = new int[i];
        this.chromaFormat = seqParameterSet.chromaFormatIdc;
        PictureParameterSet pictureParameterSet2 = sliceHeader.pps;
        PictureParameterSet.PPSExt pPSExt = pictureParameterSet2.extended;
        this.transform8x8 = pPSExt == null ? false : pPSExt.transform8x8ModeFlag;
        if (sliceHeader.numRefIdxActiveOverrideFlag) {
            int[] iArr = sliceHeader.numRefIdxActiveMinus1;
            this.numRef = new int[]{iArr[0] + 1, iArr[1] + 1};
        } else {
            int[] iArr2 = pictureParameterSet2.numRefIdxActiveMinus1;
            this.numRef = new int[]{iArr2[0] + 1, iArr2[1] + 1};
        }
        this.tf8x8Top = new boolean[i];
        this.predModeLeft = new H264Const.PartPred[2];
        this.predModeTop = new H264Const.PartPred[i << 1];
        this.i4x4PredLeft = new int[4];
        this.i4x4PredTop = new int[i << 2];
    }

    private void _readChromaAC(boolean z, boolean z2, int i, int[] iArr, int i2, MBType mBType, boolean z3, int[][] iArr2) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int[] iArr3 = iArr2[i3];
            int i4 = H264Const.MB_BLK_OFF_LEFT[i3];
            int i5 = H264Const.MB_BLK_OFF_TOP[i3];
            int i6 = (i << 1) + i4;
            if (z3) {
                readChromaAC(z, z2, i, i2, mBType, iArr3, i4, i5, i6);
            } else {
                if (!this.sh.pps.entropyCodingModeFlag) {
                    setZeroCoeff(i2, i6, i5);
                }
            }
        }
    }

    private void readIPCM(MBlock mBlock) {
        this.reader.align();
        for (int i = 0; i < 256; i++) {
            mBlock.ipcm.samplesLuma[i] = this.reader.readNBit(8);
        }
        ColorSpace colorSpace = this.chromaFormat;
        int i2 = 16 >> colorSpace.compWidth[1];
        int i3 = 16 >> colorSpace.compHeight[1];
        for (int i4 = 0; i4 < i2 * 2 * i3; i4++) {
            mBlock.ipcm.samplesChroma[i4] = this.reader.readNBit(8);
        }
    }

    private void readLuma(MBlock mBlock, boolean z, boolean z2, int i, int i2) {
        for (int i3 = 0; i3 < 16; i3++) {
            int i4 = H264Const.MB_BLK_OFF_LEFT[i3];
            int i5 = H264Const.MB_BLK_OFF_TOP[i3];
            int i6 = (i << 2) + i4;
            int i7 = (i2 << 2) + i5;
            if ((mBlock.cbpLuma() & (1 << (i3 >> 2))) != 0) {
                mBlock.nCoeff[i3] = readResidualAC(z, z2, i, mBlock.curMbType, mBlock.cbpLuma(), i4, i5, i6, i7, mBlock.ac[0][i3]);
            } else if (!this.sh.pps.entropyCodingModeFlag) {
                setZeroCoeff(0, i6, i5);
            }
        }
        savePrevCBP(mBlock._cbp);
    }

    private void readLuma8x8CABAC(MBlock mBlock, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = (i << 2) + ((i3 & 1) << 1);
            int i5 = (i2 << 2) + (i3 & 2);
            if (((1 << i3) & mBlock.cbpLuma()) != 0) {
                int lumaAC8x8 = readLumaAC8x8(i4, i5, mBlock.ac[0][i3]);
                int i6 = i3 << 2;
                int[] iArr = mBlock.nCoeff;
                iArr[i6 + 3] = lumaAC8x8;
                iArr[i6 + 2] = lumaAC8x8;
                iArr[i6 + 1] = lumaAC8x8;
                iArr[i6] = lumaAC8x8;
            }
        }
        savePrevCBP(mBlock._cbp);
    }

    private void readLuma8x8CAVLC(MBlock mBlock, boolean z, boolean z2, int i, int i2) {
        int i3 = 0;
        while (true) {
            if (i3 >= 4) {
                return;
            }
            int i4 = (i3 & 1) << 1;
            int i5 = i3 & 2;
            int i6 = (i << 2) + i4;
            if ((mBlock.cbpLuma() & (1 << i3)) == 0) {
                setZeroCoeff(0, i6, i5);
                int i7 = i6 + 1;
                setZeroCoeff(0, i7, i5);
                int i8 = i5 + 1;
                setZeroCoeff(0, i6, i8);
                setZeroCoeff(0, i7, i8);
            } else {
                int i9 = 0;
                int lumaAC = 0;
                for (int i10 = 4; i9 < i10; i10 = 4) {
                    int[] iArr = new int[16];
                    int i11 = i9;
                    int i12 = i6;
                    int i13 = i5;
                    lumaAC += readLumaAC(z, z2, i, mBlock.curMbType, i6, i9, iArr, i4 + (i9 & 1), i5 + (i9 >> 1));
                    for (int i14 = 0; i14 < 16; i14++) {
                        mBlock.ac[0][i3][CoeffTransformer.zigzag8x8[(i14 << 2) + i11]] = iArr[i14];
                    }
                    i9 = i11 + 1;
                    i5 = i13;
                    i6 = i12;
                }
                int i15 = i3 << 2;
                int[] iArr2 = mBlock.nCoeff;
                iArr2[i15 + 3] = lumaAC;
                iArr2[i15 + 2] = lumaAC;
                iArr2[i15 + 1] = lumaAC;
                iArr2[i15] = lumaAC;
            }
            i3++;
        }
    }

    private void readMBlockB(MBlock mBlock) {
        int i = mBlock.mbIdx;
        int mBTypeB = readMBTypeB(i, this.mapper.leftAvailable(i), this.mapper.topAvailable(mBlock.mbIdx), this.leftMBType, this.topMBType[this.mapper.getMbX(mBlock.mbIdx)]);
        mBlock.mbType = mBTypeB;
        if (mBTypeB >= 23) {
            readMBlockIInt(mBlock, mBTypeB - 23);
            return;
        }
        mBlock.curMbType = H264Const.bMbTypes[mBTypeB];
        if (mBTypeB == 0) {
            readMBlockBDirect(mBlock);
            return;
        }
        if (mBTypeB <= 3) {
            readInter16x16(H264Const.bPredModes[mBTypeB][0], mBlock);
            return;
        }
        if (mBTypeB == 22) {
            readMBlock8x8(mBlock);
        } else if ((mBTypeB & 1) == 0) {
            H264Const.PartPred[] partPredArr = H264Const.bPredModes[mBTypeB];
            readInter16x8(partPredArr[0], partPredArr[1], mBlock);
        } else {
            H264Const.PartPred[] partPredArr2 = H264Const.bPredModes[mBTypeB];
            readIntra8x16(partPredArr2[0], partPredArr2[1], mBlock);
        }
    }

    private void readMBlockI(MBlock mBlock) {
        int i = mBlock.mbIdx;
        int iDecodeMBTypeI = decodeMBTypeI(i, this.mapper.leftAvailable(i), this.mapper.topAvailable(mBlock.mbIdx), this.leftMBType, this.topMBType[this.mapper.getMbX(mBlock.mbIdx)]);
        mBlock.mbType = iDecodeMBTypeI;
        readMBlockIInt(mBlock, iDecodeMBTypeI);
    }

    private void readMBlockIInt(MBlock mBlock, int i) {
        if (i == 0) {
            mBlock.curMbType = MBType.I_NxN;
            readIntraNxN(mBlock);
        } else if (i >= 1 && i <= 24) {
            mBlock.curMbType = MBType.I_16x16;
            readIntra16x16(i - 1, mBlock);
        } else {
            Logger.warn("IPCM macroblock found. Not tested, may cause unpredictable behavior.");
            mBlock.curMbType = MBType.I_PCM;
            readIPCM(mBlock);
        }
    }

    private void readMBlockP(MBlock mBlock) {
        int mBTypeP = readMBTypeP();
        mBlock.mbType = mBTypeP;
        if (mBTypeP == 0) {
            mBlock.curMbType = MBType.P_16x16;
            readInter16x16(H264Const.PartPred.L0, mBlock);
            return;
        }
        if (mBTypeP == 1) {
            mBlock.curMbType = MBType.P_16x8;
            H264Const.PartPred partPred = H264Const.PartPred.L0;
            readInter16x8(partPred, partPred, mBlock);
        } else if (mBTypeP == 2) {
            mBlock.curMbType = MBType.P_8x16;
            H264Const.PartPred partPred2 = H264Const.PartPred.L0;
            readIntra8x16(partPred2, partPred2, mBlock);
        } else if (mBTypeP == 3) {
            mBlock.curMbType = MBType.P_8x8;
            readMBlock8x8(mBlock);
        } else if (mBTypeP != 4) {
            readMBlockIInt(mBlock, mBTypeP - 5);
        } else {
            mBlock.curMbType = MBType.P_8x8ref0;
            readMBlock8x8(mBlock);
        }
    }

    private void readPredInter8x16(MBlock mBlock, int i, boolean z, boolean z2, int i2, H264Const.PartPred partPred, H264Const.PartPred partPred2) {
        int i3;
        int i4 = i << 1;
        if (H264Const.usesList(partPred, i2)) {
            mBlock.pb168x168.mvdX1[i2] = readMVD(0, z, z2, this.leftMBType, this.topMBType[i], this.predModeLeft[0], this.predModeTop[i4], partPred, i, 0, 0, 2, 4, i2);
            i3 = i2;
            mBlock.pb168x168.mvdY1[i3] = readMVD(1, z, z2, this.leftMBType, this.topMBType[i], this.predModeLeft[0], this.predModeTop[i4], partPred, i, 0, 0, 2, 4, i2);
        } else {
            i3 = i2;
        }
        if (H264Const.usesList(partPred2, i3)) {
            int[] iArr = mBlock.pb168x168.mvdX2;
            MBType mBType = MBType.P_8x16;
            int i5 = i4 + 1;
            iArr[i2] = readMVD(0, true, z2, mBType, this.topMBType[i], partPred, this.predModeTop[i5], partPred2, i, 2, 0, 2, 4, i2);
            mBlock.pb168x168.mvdY2[i2] = readMVD(1, true, z2, mBType, this.topMBType[i], partPred, this.predModeTop[i5], partPred2, i, 2, 0, 2, 4, i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readPrediction8x8B(MBlock mBlock, int i, boolean z, boolean z2) {
        byte b;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        H264Const.PartPred[] partPredArr;
        int i8;
        int i9;
        int i10;
        int i11;
        byte b2;
        int i12;
        SliceReader sliceReader = this;
        MBlock mBlock2 = mBlock;
        H264Const.PartPred[] partPredArr2 = new H264Const.PartPred[4];
        for (int i13 = 0; i13 < 4; i13++) {
            mBlock2.pb8x8.subMbTypes[i13] = readSubMBTypeB();
            partPredArr2[i13] = H264Const.bPartPredModes[mBlock2.pb8x8.subMbTypes[i13]];
        }
        int i14 = 0;
        while (i14 < 2) {
            if (sliceReader.numRef[i14] <= 1) {
                i12 = i14;
                partPredArr = partPredArr2;
            } else {
                if (H264Const.usesList(partPredArr2[0], i14)) {
                    i7 = i14;
                    partPredArr = partPredArr2;
                    mBlock2.pb8x8.refIdx[i14][0] = readRefIdx(z, z2, sliceReader.leftMBType, sliceReader.topMBType[i], sliceReader.predModeLeft[0], sliceReader.predModeTop[i << 1], partPredArr2[0], i, 0, 0, 2, 2, i7);
                    i8 = 1;
                } else {
                    i7 = i14;
                    partPredArr = partPredArr2;
                    i8 = 1;
                }
                int i15 = i7;
                if (H264Const.usesList(partPredArr[i8], i15)) {
                    i9 = i15;
                    i10 = i8;
                    mBlock2.pb8x8.refIdx[i15][i10] = readRefIdx(true, z2, MBType.B_8x8, sliceReader.topMBType[i], partPredArr[0], sliceReader.predModeTop[(i << 1) + i8], partPredArr[i8], i, 2, 0, 2, 2, i9);
                } else {
                    i9 = i15;
                    i10 = i8;
                }
                int i16 = i9;
                if (H264Const.usesList(partPredArr[2], i16)) {
                    i11 = i16;
                    b2 = 2;
                    mBlock2.pb8x8.refIdx[i16][2] = readRefIdx(z, true, this.leftMBType, MBType.B_8x8, this.predModeLeft[i10], partPredArr[0], partPredArr[2], i, 0, 2, 2, 2, i11);
                } else {
                    i11 = i16;
                    b2 = 2;
                }
                int i17 = i11;
                if (H264Const.usesList(partPredArr[3], i17)) {
                    int[] iArr = mBlock2.pb8x8.refIdx[i17];
                    MBType mBType = MBType.B_8x8;
                    i12 = i17;
                    iArr[3] = readRefIdx(true, true, mBType, mBType, partPredArr[b2], partPredArr[1], partPredArr[3], i, 2, 2, 2, 2, i17);
                } else {
                    i12 = i17;
                }
            }
            i14 = i12 + 1;
            sliceReader = this;
            partPredArr2 = partPredArr;
        }
        byte b3 = true;
        int i18 = 2;
        H264Const.PartPred[] partPredArr3 = partPredArr2;
        MBlockDecoderUtils.debugPrint("Pred: " + partPredArr3[0] + ", " + partPredArr3[1] + ", " + partPredArr3[2] + ", " + partPredArr3[3]);
        int i19 = i << 1;
        int i20 = 0;
        while (i20 < i18) {
            if (H264Const.usesList(partPredArr3[0], i20)) {
                i3 = i18;
                b = b3;
                i2 = i20;
                readSubMb8x8(mBlock, 0, H264Const.bSubMbTypes[mBlock2.pb8x8.subMbTypes[0]], z2, z, 0, 0, i, this.leftMBType, this.topMBType[i], MBType.B_8x8, this.predModeLeft[0], this.predModeTop[i19], partPredArr3[0], i2);
            } else {
                b = b3;
                i2 = i20;
                i3 = i18;
            }
            int i21 = i2;
            if (H264Const.usesList(partPredArr3[b], i21)) {
                int i22 = H264Const.bSubMbTypes[mBlock.pb8x8.subMbTypes[b]];
                MBType mBType2 = MBType.B_8x8;
                i4 = i21;
                readSubMb8x8(mBlock, 1, i22, z2, true, 2, 0, i, mBType2, this.topMBType[i], mBType2, partPredArr3[0], this.predModeTop[i19 + 1], partPredArr3[b], i21);
            } else {
                i4 = i21;
            }
            int i23 = i4;
            if (H264Const.usesList(partPredArr3[i3], i23)) {
                int i24 = H264Const.bSubMbTypes[mBlock.pb8x8.subMbTypes[i3]];
                MBType mBType3 = this.leftMBType;
                MBType mBType4 = MBType.B_8x8;
                i5 = i23;
                readSubMb8x8(mBlock, 2, i24, true, z, 0, 2, i, mBType3, mBType4, mBType4, this.predModeLeft[b], partPredArr3[0], partPredArr3[i3], i23);
            } else {
                i5 = i23;
            }
            int i25 = i5;
            if (H264Const.usesList(partPredArr3[3], i25)) {
                int i26 = H264Const.bSubMbTypes[mBlock.pb8x8.subMbTypes[3]];
                MBType mBType5 = MBType.B_8x8;
                i6 = i25;
                readSubMb8x8(mBlock, 3, i26, true, true, 2, 2, i, mBType5, mBType5, mBType5, partPredArr3[i3], partPredArr3[b], partPredArr3[3], i25);
            } else {
                i6 = i25;
            }
            i20 = i6 + 1;
            mBlock2 = mBlock;
            i18 = i3;
            b3 = b;
        }
        byte b4 = b3;
        H264Const.PartPred[] partPredArr4 = this.predModeLeft;
        partPredArr4[0] = partPredArr3[b4 == true ? 1 : 0];
        H264Const.PartPred[] partPredArr5 = this.predModeTop;
        partPredArr5[i19] = partPredArr3[i18];
        H264Const.PartPred partPred = partPredArr3[3];
        partPredArr5[i19 + 1] = partPred;
        partPredArr4[b4 == true ? 1 : 0] = partPred;
    }

    private void readPrediction8x8P(MBlock mBlock, int i, boolean z, boolean z2) {
        char c;
        for (int i2 = 0; i2 < 4; i2++) {
            mBlock.pb8x8.subMbTypes[i2] = readSubMBTypeP();
        }
        if (this.numRef[0] <= 1 || mBlock.curMbType == MBType.P_8x8ref0) {
            c = 1;
        } else {
            int[] iArr = mBlock.pb8x8.refIdx[0];
            MBType mBType = this.leftMBType;
            MBType mBType2 = this.topMBType[i];
            H264Const.PartPred partPred = H264Const.PartPred.L0;
            c = 1;
            iArr[0] = readRefIdx(z, z2, mBType, mBType2, partPred, partPred, partPred, i, 0, 0, 2, 2, 0);
            int[] iArr2 = mBlock.pb8x8.refIdx[0];
            MBType mBType3 = MBType.P_8x8;
            iArr2[1] = readRefIdx(true, z2, mBType3, this.topMBType[i], partPred, partPred, partPred, i, 2, 0, 2, 2, 0);
            mBlock.pb8x8.refIdx[0][2] = readRefIdx(z, true, this.leftMBType, mBType3, partPred, partPred, partPred, i, 0, 2, 2, 2, 0);
            mBlock.pb8x8.refIdx[0][3] = readRefIdx(true, true, mBType3, mBType3, partPred, partPred, partPred, i, 2, 2, 2, 2, 0);
        }
        int i3 = mBlock.pb8x8.subMbTypes[0];
        MBType mBType4 = this.leftMBType;
        MBType mBType5 = this.topMBType[i];
        MBType mBType6 = MBType.P_8x8;
        H264Const.PartPred partPred2 = H264Const.PartPred.L0;
        readSubMb8x8(mBlock, 0, i3, z2, z, 0, 0, i, mBType4, mBType5, mBType6, partPred2, partPred2, partPred2, 0);
        readSubMb8x8(mBlock, 1, mBlock.pb8x8.subMbTypes[c], z2, true, 2, 0, i, mBType6, this.topMBType[i], mBType6, partPred2, partPred2, partPred2, 0);
        readSubMb8x8(mBlock, 2, mBlock.pb8x8.subMbTypes[2], true, z, 0, 2, i, this.leftMBType, mBType6, mBType6, partPred2, partPred2, partPred2, 0);
        readSubMb8x8(mBlock, 3, mBlock.pb8x8.subMbTypes[3], true, true, 2, 2, i, mBType6, mBType6, mBType6, partPred2, partPred2, partPred2, 0);
        int i4 = i << 1;
        H264Const.PartPred[] partPredArr = this.predModeLeft;
        H264Const.PartPred[] partPredArr2 = this.predModeTop;
        partPredArr2[i4 + 1] = partPred2;
        partPredArr2[i4] = partPred2;
        partPredArr[c] = partPred2;
        partPredArr[0] = partPred2;
    }

    private void readPredictionInter16x16(MBlock mBlock, int i, boolean z, boolean z2, int i2, H264Const.PartPred partPred) {
        int i3 = i << 1;
        if (H264Const.usesList(partPred, i2)) {
            mBlock.pb16x16.mvdX[i2] = readMVD(0, z, z2, this.leftMBType, this.topMBType[i], this.predModeLeft[0], this.predModeTop[i3], partPred, i, 0, 0, 4, 4, i2);
            mBlock.pb16x16.mvdY[i2] = readMVD(1, z, z2, this.leftMBType, this.topMBType[i], this.predModeLeft[0], this.predModeTop[i3], partPred, i, 0, 0, 4, 4, i2);
        }
    }

    private void readPredictionInter16x8(MBlock mBlock, int i, boolean z, boolean z2, H264Const.PartPred partPred, H264Const.PartPred partPred2, int i2) {
        SliceReader sliceReader = this;
        int i3 = i << 1;
        if (H264Const.usesList(partPred, i2)) {
            mBlock.pb168x168.mvdX1[i2] = readMVD(0, z, z2, sliceReader.leftMBType, sliceReader.topMBType[i], sliceReader.predModeLeft[0], sliceReader.predModeTop[i3], partPred, i, 0, 0, 4, 2, i2);
            sliceReader = this;
            mBlock.pb168x168.mvdY1[i2] = readMVD(1, z, z2, sliceReader.leftMBType, sliceReader.topMBType[i], sliceReader.predModeLeft[0], sliceReader.predModeTop[i3], partPred, i, 0, 0, 4, 2, i2);
        }
        if (H264Const.usesList(partPred2, i2)) {
            int[] iArr = mBlock.pb168x168.mvdX2;
            MBType mBType = sliceReader.leftMBType;
            MBType mBType2 = MBType.P_16x8;
            iArr[i2] = readMVD(0, z, true, mBType, mBType2, sliceReader.predModeLeft[1], partPred, partPred2, i, 0, 2, 4, 2, i2);
            mBlock.pb168x168.mvdY2[i2] = readMVD(1, z, true, this.leftMBType, mBType2, this.predModeLeft[1], partPred, partPred2, i, 0, 2, 4, 2, i2);
        }
    }

    private void readResidualInter(MBlock mBlock, boolean z, boolean z2, int i, int i2) {
        mBlock._cbp = readCodedBlockPatternInter(z, z2, this.leftCBPLuma | (this.leftCBPChroma << 4), this.topCBPLuma[i] | (this.topCBPChroma[i] << 4), this.leftMBType, this.topMBType[i]);
        mBlock.transform8x8Used = false;
        if (mBlock.cbpLuma() != 0 && this.transform8x8) {
            mBlock.transform8x8Used = readTransform8x8Flag(z, z2, this.leftMBType, this.topMBType[i], this.tf8x8Left, this.tf8x8Top[i]);
        }
        if (mBlock.cbpLuma() > 0 || mBlock.cbpChroma() > 0) {
            mBlock.mbQPDelta = readMBQpDelta(mBlock.prevMbType);
        }
        readResidualLuma(mBlock, z, z2, i, i2);
        if (this.chromaFormat != ColorSpace.MONO) {
            readChromaResidual(mBlock, z, z2, i);
        }
    }

    private void readSub4x4(MBlock mBlock, int i, boolean z, boolean z2, int i2, int i3, int i4, MBType mBType, MBType mBType2, MBType mBType3, H264Const.PartPred partPred, H264Const.PartPred partPred2, H264Const.PartPred partPred3, int i5) {
        mBlock.pb8x8.mvdX1[i5][i] = readMVD(0, z2, z, mBType, mBType2, partPred, partPred2, partPred3, i4, i2, i3, 1, 1, i5);
        mBlock.pb8x8.mvdY1[i5][i] = readMVD(1, z2, z, mBType, mBType2, partPred, partPred2, partPred3, i4, i2, i3, 1, 1, i5);
        int i6 = i2 + 1;
        mBlock.pb8x8.mvdX2[i5][i] = readMVD(0, true, z, mBType3, mBType2, partPred3, partPred2, partPred3, i4, i6, i3, 1, 1, i5);
        mBlock.pb8x8.mvdY2[i5][i] = readMVD(1, true, z, mBType3, mBType2, partPred3, partPred2, partPred3, i4, i6, i3, 1, 1, i5);
        int i7 = i3 + 1;
        mBlock.pb8x8.mvdX3[i5][i] = readMVD(0, z2, true, mBType, mBType3, partPred, partPred3, partPred3, i4, i2, i7, 1, 1, i5);
        mBlock.pb8x8.mvdY3[i5][i] = readMVD(1, z2, true, mBType, mBType3, partPred, partPred3, partPred3, i4, i2, i7, 1, 1, i5);
        mBlock.pb8x8.mvdX4[i5][i] = readMVD(0, true, true, mBType3, mBType3, partPred3, partPred3, partPred3, i4, i6, i7, 1, 1, i5);
        mBlock.pb8x8.mvdY4[i5][i] = readMVD(1, true, true, mBType3, mBType3, partPred3, partPred3, partPred3, i4, i6, i7, 1, 1, i5);
    }

    private void readSub4x8(MBlock mBlock, int i, boolean z, boolean z2, int i2, int i3, int i4, MBType mBType, MBType mBType2, MBType mBType3, H264Const.PartPred partPred, H264Const.PartPred partPred2, H264Const.PartPred partPred3, int i5) {
        mBlock.pb8x8.mvdX1[i5][i] = readMVD(0, z2, z, mBType, mBType2, partPred, partPred2, partPred3, i4, i2, i3, 1, 2, i5);
        mBlock.pb8x8.mvdY1[i5][i] = readMVD(1, z2, z, mBType, mBType2, partPred, partPred2, partPred3, i4, i2, i3, 1, 2, i5);
        int i6 = i2 + 1;
        mBlock.pb8x8.mvdX2[i5][i] = readMVD(0, true, z, mBType3, mBType2, partPred3, partPred2, partPred3, i4, i6, i3, 1, 2, i5);
        mBlock.pb8x8.mvdY2[i5][i] = readMVD(1, true, z, mBType3, mBType2, partPred3, partPred2, partPred3, i4, i6, i3, 1, 2, i5);
    }

    private void readSub8x4(MBlock mBlock, int i, boolean z, boolean z2, int i2, int i3, int i4, MBType mBType, MBType mBType2, MBType mBType3, H264Const.PartPred partPred, H264Const.PartPred partPred2, H264Const.PartPred partPred3, int i5) {
        mBlock.pb8x8.mvdX1[i5][i] = readMVD(0, z2, z, mBType, mBType2, partPred, partPred2, partPred3, i4, i2, i3, 2, 1, i5);
        mBlock.pb8x8.mvdY1[i5][i] = readMVD(1, z2, z, mBType, mBType2, partPred, partPred2, partPred3, i4, i2, i3, 2, 1, i5);
        int i6 = i3 + 1;
        mBlock.pb8x8.mvdX2[i5][i] = readMVD(0, z2, true, mBType, mBType3, partPred, partPred3, partPred3, i4, i2, i6, 2, 1, i5);
        mBlock.pb8x8.mvdY2[i5][i] = readMVD(1, z2, true, mBType, mBType3, partPred, partPred3, partPred3, i4, i2, i6, 2, 1, i5);
    }

    private void readSub8x8(MBlock mBlock, int i, boolean z, boolean z2, int i2, int i3, int i4, MBType mBType, MBType mBType2, H264Const.PartPred partPred, H264Const.PartPred partPred2, H264Const.PartPred partPred3, int i5) {
        mBlock.pb8x8.mvdX1[i5][i] = readMVD(0, z2, z, mBType, mBType2, partPred, partPred2, partPred3, i4, i2, i3, 2, 2, i5);
        mBlock.pb8x8.mvdY1[i5][i] = readMVD(1, z2, z, mBType, mBType2, partPred, partPred2, partPred3, i4, i2, i3, 2, 2, i5);
        MBlockDecoderUtils.debugPrint("mvd: (%d, %d)", Integer.valueOf(mBlock.pb8x8.mvdX1[i5][i]), Integer.valueOf(mBlock.pb8x8.mvdY1[i5][i]));
    }

    private void readSubMb8x8(MBlock mBlock, int i, int i2, boolean z, boolean z2, int i3, int i4, int i5, MBType mBType, MBType mBType2, MBType mBType3, H264Const.PartPred partPred, H264Const.PartPred partPred2, H264Const.PartPred partPred3, int i6) {
        if (i2 == 0) {
            readSub8x8(mBlock, i, z, z2, i3, i4, i5, mBType, mBType2, partPred, partPred2, partPred3, i6);
            return;
        }
        if (i2 == 1) {
            readSub8x4(mBlock, i, z, z2, i3, i4, i5, mBType, mBType2, mBType3, partPred, partPred2, partPred3, i6);
        } else if (i2 == 2) {
            readSub4x8(mBlock, i, z, z2, i3, i4, i5, mBType, mBType2, mBType3, partPred, partPred2, partPred3, i6);
        } else {
            if (i2 != 3) {
                return;
            }
            readSub4x4(mBlock, i, z, z2, i3, i4, i5, mBType, mBType2, mBType3, partPred, partPred2, partPred3, i6);
        }
    }

    public int decodeMBTypeI(int i, boolean z, boolean z2, MBType mBType, MBType mBType2) {
        return !this.activePps.entropyCodingModeFlag ? CAVLCReader.readUEtrace(this.reader, "MB: mb_type") : this.cabac.readMBTypeI(this.mDecoder, mBType, mBType2, z, z2);
    }

    public NALUnit getNALUnit() {
        return this.nalUnit;
    }

    public SliceHeader getSliceHeader() {
        return this.sh;
    }

    public boolean prev4x4PredMode() {
        return !this.activePps.entropyCodingModeFlag ? CAVLCReader.readBool(this.reader, "MBP: prev_intra4x4_pred_mode_flag") : this.cabac.prev4x4PredModeFlag(this.mDecoder);
    }

    public int read16x16AC(boolean z, boolean z2, int i, int i2, int[] iArr, int i3, int i4, int i5, int i6) {
        if (!this.activePps.entropyCodingModeFlag) {
            return this.cavlc[0].readACBlock(this.reader, iArr, i5, i4, i3 != 0 || z, i3 == 0 ? this.leftMBType : MBType.I_16x16, i4 != 0 || z2, i4 == 0 ? this.topMBType[i] : MBType.I_16x16, 1, 15, CoeffTransformer.zigzag4x4);
        }
        CABAC cabac = this.cabac;
        MDecoder mDecoder = this.mDecoder;
        CABAC.BlockType blockType = CABAC.BlockType.LUMA_15_AC;
        if (cabac.readCodedBlockFlagLumaAC(mDecoder, blockType, i5, i4, 0, this.leftMBType, this.topMBType[i], z, z2, this.leftCBPLuma, this.topCBPLuma[i], i2, MBType.I_16x16) != 1) {
            return 0;
        }
        CABAC cabac2 = this.cabac;
        MDecoder mDecoder2 = this.mDecoder;
        int[] iArr2 = CoeffTransformer.zigzag4x4;
        int[] iArr3 = H264Const.identityMapping16;
        return cabac2.readCoeffs(mDecoder2, blockType, iArr, 1, 15, iArr2, iArr3, iArr3);
    }

    public void read16x16DC(boolean z, boolean z2, int i, int[] iArr) {
        if (!this.activePps.entropyCodingModeFlag) {
            this.cavlc[0].readLumaDCBlock(this.reader, iArr, i, z, this.leftMBType, z2, this.topMBType[i], CoeffTransformer.zigzag4x4);
            return;
        }
        if (this.cabac.readCodedBlockFlagLumaDC(this.mDecoder, i, this.leftMBType, this.topMBType[i], z, z2, MBType.I_16x16) == 1) {
            CABAC cabac = this.cabac;
            MDecoder mDecoder = this.mDecoder;
            CABAC.BlockType blockType = CABAC.BlockType.LUMA_16_DC;
            int[] iArr2 = CoeffTransformer.zigzag4x4;
            int[] iArr3 = H264Const.identityMapping16;
            cabac.readCoeffs(mDecoder, blockType, iArr, 0, 16, iArr2, iArr3, iArr3);
        }
    }

    public void readChromaAC(boolean z, boolean z2, int i, int i2, MBType mBType, int[] iArr, int i3, int i4, int i5) {
        if (!this.activePps.entropyCodingModeFlag) {
            if (this.reader.remaining() <= 0) {
                return;
            }
            this.cavlc[i2].readACBlock(this.reader, iArr, i5, i4, i3 != 0 || z, i3 == 0 ? this.leftMBType : mBType, i4 != 0 || z2, i4 == 0 ? this.topMBType[i] : mBType, 1, 15, CoeffTransformer.zigzag4x4);
        } else if (this.cabac.readCodedBlockFlagChromaAC(this.mDecoder, i5, i4, i2, this.leftMBType, this.topMBType[i], z, z2, this.leftCBPChroma, this.topCBPChroma[i], mBType) == 1) {
            CABAC cabac = this.cabac;
            MDecoder mDecoder = this.mDecoder;
            CABAC.BlockType blockType = CABAC.BlockType.CHROMA_AC;
            int[] iArr2 = CoeffTransformer.zigzag4x4;
            int[] iArr3 = H264Const.identityMapping16;
            cabac.readCoeffs(mDecoder, blockType, iArr, 1, 15, iArr2, iArr3, iArr3);
        }
    }

    public void readChromaDC(int i, boolean z, boolean z2, int[] iArr, int i2, MBType mBType) {
        if (!this.activePps.entropyCodingModeFlag) {
            this.cavlc[i2].readChromaDCBlock(this.reader, iArr, z, z2);
            return;
        }
        if (this.cabac.readCodedBlockFlagChromaDC(this.mDecoder, i, i2, this.leftMBType, this.topMBType[i], z, z2, this.leftCBPChroma, this.topCBPChroma[i], mBType) == 1) {
            CABAC cabac = this.cabac;
            MDecoder mDecoder = this.mDecoder;
            CABAC.BlockType blockType = CABAC.BlockType.CHROMA_DC;
            int[] iArr2 = H264Const.identityMapping16;
            cabac.readCoeffs(mDecoder, blockType, iArr, 0, 4, iArr2, iArr2, iArr2);
        }
    }

    public int readChromaPredMode(int i, boolean z, boolean z2) {
        return !this.activePps.entropyCodingModeFlag ? CAVLCReader.readUEtrace(this.reader, "MBP: intra_chroma_pred_mode") : this.cabac.readIntraChromaPredMode(this.mDecoder, i, this.leftMBType, this.topMBType[i], z, z2);
    }

    public void readChromaResidual(MBlock mBlock, boolean z, boolean z2, int i) {
        if (mBlock.cbpChroma() != 0) {
            if ((mBlock.cbpChroma() & 3) > 0) {
                readChromaDC(i, z, z2, mBlock.dc1, 1, mBlock.curMbType);
                readChromaDC(i, z, z2, mBlock.dc2, 2, mBlock.curMbType);
            }
            _readChromaAC(z, z2, i, mBlock.dc1, 1, mBlock.curMbType, (mBlock.cbpChroma() & 2) > 0, mBlock.ac[1]);
            _readChromaAC(z, z2, i, mBlock.dc2, 2, mBlock.curMbType, (mBlock.cbpChroma() & 2) > 0, mBlock.ac[2]);
            return;
        }
        if (this.sh.pps.entropyCodingModeFlag) {
            return;
        }
        int i2 = i << 1;
        setZeroCoeff(1, i2, 0);
        int i3 = i2 + 1;
        setZeroCoeff(1, i3, 1);
        setZeroCoeff(2, i2, 0);
        setZeroCoeff(2, i3, 1);
    }

    public int readCodedBlockPatternInter(boolean z, boolean z2, int i, int i2, MBType mBType, MBType mBType2) {
        if (this.activePps.entropyCodingModeFlag) {
            return this.cabac.codedBlockPatternIntra(this.mDecoder, z, z2, i, i2, mBType, mBType2);
        }
        return H264Const.CODED_BLOCK_PATTERN_INTER_COLOR[CAVLCReader.readUEtrace(this.reader, "coded_block_pattern")];
    }

    public int readCodedBlockPatternIntra(boolean z, boolean z2, int i, int i2, MBType mBType, MBType mBType2) {
        return !this.activePps.entropyCodingModeFlag ? H264Const.CODED_BLOCK_PATTERN_INTRA_COLOR[CAVLCReader.readUEtrace(this.reader, "coded_block_pattern")] : this.cabac.codedBlockPatternIntra(this.mDecoder, z, z2, i, i2, mBType, mBType2);
    }

    public void readInter16x16(H264Const.PartPred partPred, MBlock mBlock) {
        int i;
        MBlock mBlock2 = mBlock;
        int mbX = this.mapper.getMbX(mBlock2.mbIdx);
        int mbY = this.mapper.getMbY(mBlock2.mbIdx);
        boolean zLeftAvailable = this.mapper.leftAvailable(mBlock2.mbIdx);
        boolean z = this.mapper.topAvailable(mBlock2.mbIdx);
        int i2 = 0;
        while (i2 < 2) {
            if (!H264Const.usesList(partPred, i2) || this.numRef[i2] <= 1) {
                i = i2;
            } else {
                i = i2;
                mBlock2.pb16x16.refIdx[i] = readRefIdx(zLeftAvailable, z, this.leftMBType, this.topMBType[mbX], this.predModeLeft[0], this.predModeTop[mbX << 1], partPred, mbX, 0, 0, 4, 4, i);
            }
            i2 = i + 1;
            mBlock2 = mBlock;
        }
        for (int i3 = 0; i3 < 2; i3++) {
            readPredictionInter16x16(mBlock, mbX, zLeftAvailable, z, i3, partPred);
        }
        readResidualInter(mBlock, zLeftAvailable, z, mbX, mbY);
        H264Const.PartPred[] partPredArr = this.predModeLeft;
        H264Const.PartPred[] partPredArr2 = this.predModeTop;
        int i4 = mbX << 1;
        partPredArr2[i4 + 1] = partPred;
        partPredArr2[i4] = partPred;
        partPredArr[1] = partPred;
        partPredArr[0] = partPred;
    }

    public void readInter16x8(H264Const.PartPred partPred, H264Const.PartPred partPred2, MBlock mBlock) {
        H264Const.PartPred partPred3;
        int i;
        int i2;
        H264Const.PartPred partPred4 = partPred;
        H264Const.PartPred partPred5 = partPred2;
        MBlock mBlock2 = mBlock;
        int mbX = this.mapper.getMbX(mBlock2.mbIdx);
        int mbY = this.mapper.getMbY(mBlock2.mbIdx);
        boolean zLeftAvailable = this.mapper.leftAvailable(mBlock2.mbIdx);
        boolean z = this.mapper.topAvailable(mBlock2.mbIdx);
        int i3 = 0;
        while (i3 < 2) {
            if (!H264Const.usesList(partPred4, i3) || this.numRef[i3] <= 1) {
                partPred3 = partPred5;
                i = i3;
            } else {
                partPred3 = partPred5;
                i = i3;
                mBlock2.pb168x168.refIdx1[i] = readRefIdx(zLeftAvailable, z, this.leftMBType, this.topMBType[mbX], this.predModeLeft[0], this.predModeTop[mbX << 1], partPred, mbX, 0, 0, 4, 2, i);
            }
            if (!H264Const.usesList(partPred3, i) || this.numRef[i] <= 1) {
                i2 = i;
            } else {
                i2 = i;
                mBlock.pb168x168.refIdx2[i2] = readRefIdx(zLeftAvailable, true, this.leftMBType, mBlock.curMbType, this.predModeLeft[1], partPred, partPred2, mbX, 0, 2, 4, 2, i);
            }
            i3 = i2 + 1;
            mBlock2 = mBlock;
            partPred5 = partPred3;
            partPred4 = partPred;
        }
        for (int i4 = 0; i4 < 2; i4++) {
            readPredictionInter16x8(mBlock, mbX, zLeftAvailable, z, partPred, partPred2, i4);
        }
        readResidualInter(mBlock, zLeftAvailable, z, mbX, mbY);
        H264Const.PartPred[] partPredArr = this.predModeLeft;
        partPredArr[0] = partPred;
        H264Const.PartPred[] partPredArr2 = this.predModeTop;
        int i5 = mbX << 1;
        partPredArr2[i5 + 1] = partPred2;
        partPredArr2[i5] = partPred2;
        partPredArr[1] = partPred2;
    }

    public void readIntra16x16(int i, MBlock mBlock) {
        int i2;
        int i3;
        int i4;
        int mbX = this.mapper.getMbX(mBlock.mbIdx);
        int mbY = this.mapper.getMbY(mBlock.mbIdx);
        boolean zLeftAvailable = this.mapper.leftAvailable(mBlock.mbIdx);
        boolean z = this.mapper.topAvailable(mBlock.mbIdx);
        mBlock.cbp((i / 12) * 15, (i / 4) % 3);
        mBlock.luma16x16Mode = i % 4;
        mBlock.chromaPredictionMode = readChromaPredMode(mbX, zLeftAvailable, z);
        mBlock.mbQPDelta = readMBQpDelta(mBlock.prevMbType);
        read16x16DC(zLeftAvailable, z, mbX, mBlock.dc);
        int i5 = 0;
        int i6 = 0;
        while (i6 < 16) {
            int i7 = H264Const.MB_BLK_OFF_LEFT[i6];
            int i8 = H264Const.MB_BLK_OFF_TOP[i6];
            int i9 = (mbX << 2) + i7;
            int i10 = (mbY << 2) + i8;
            if ((mBlock.cbpLuma() & (1 << (i6 >> 2))) != 0) {
                i2 = i6;
                i3 = mbY;
                i4 = i5;
                mBlock.nCoeff[i2] = read16x16AC(zLeftAvailable, z, mbX, mBlock.cbpLuma(), mBlock.ac[i5][i6], i7, i8, i9, i10);
            } else {
                i2 = i6;
                i3 = mbY;
                i4 = i5;
                if (!this.sh.pps.entropyCodingModeFlag) {
                    setZeroCoeff(i4, i9, i8);
                }
            }
            i6 = i2 + 1;
            i5 = i4;
            mbY = i3;
        }
        if (this.chromaFormat != ColorSpace.MONO) {
            readChromaResidual(mBlock, zLeftAvailable, z, mbX);
        }
    }

    public void readIntra8x16(H264Const.PartPred partPred, H264Const.PartPred partPred2, MBlock mBlock) {
        H264Const.PartPred partPred3;
        int i;
        int i2;
        H264Const.PartPred partPred4 = partPred;
        H264Const.PartPred partPred5 = partPred2;
        MBlock mBlock2 = mBlock;
        int mbX = this.mapper.getMbX(mBlock2.mbIdx);
        int mbY = this.mapper.getMbY(mBlock2.mbIdx);
        boolean zLeftAvailable = this.mapper.leftAvailable(mBlock2.mbIdx);
        boolean z = this.mapper.topAvailable(mBlock2.mbIdx);
        int i3 = 0;
        while (i3 < 2) {
            if (!H264Const.usesList(partPred4, i3) || this.numRef[i3] <= 1) {
                partPred3 = partPred5;
                i = i3;
            } else {
                partPred3 = partPred5;
                i = i3;
                mBlock2.pb168x168.refIdx1[i] = readRefIdx(zLeftAvailable, z, this.leftMBType, this.topMBType[mbX], this.predModeLeft[0], this.predModeTop[mbX << 1], partPred, mbX, 0, 0, 2, 4, i);
            }
            if (!H264Const.usesList(partPred3, i) || this.numRef[i] <= 1) {
                i2 = i;
            } else {
                i2 = i;
                mBlock.pb168x168.refIdx2[i2] = readRefIdx(true, z, mBlock.curMbType, this.topMBType[mbX], partPred, this.predModeTop[(mbX << 1) + 1], partPred2, mbX, 2, 0, 2, 4, i);
            }
            i3 = i2 + 1;
            mBlock2 = mBlock;
            partPred5 = partPred3;
            partPred4 = partPred;
        }
        for (int i4 = 0; i4 < 2; i4++) {
            readPredInter8x16(mBlock, mbX, zLeftAvailable, z, i4, partPred, partPred2);
        }
        readResidualInter(mBlock, zLeftAvailable, z, mbX, mbY);
        H264Const.PartPred[] partPredArr = this.predModeTop;
        int i5 = mbX << 1;
        partPredArr[i5] = partPred;
        H264Const.PartPred[] partPredArr2 = this.predModeLeft;
        partPredArr2[1] = partPred2;
        partPredArr2[0] = partPred2;
        partPredArr[i5 + 1] = partPred2;
    }

    public void readIntraNxN(MBlock mBlock) {
        int mbX = this.mapper.getMbX(mBlock.mbIdx);
        int mbY = this.mapper.getMbY(mBlock.mbIdx);
        boolean zLeftAvailable = this.mapper.leftAvailable(mBlock.mbIdx);
        boolean z = this.mapper.topAvailable(mBlock.mbIdx);
        mBlock.transform8x8Used = false;
        if (this.transform8x8) {
            mBlock.transform8x8Used = readTransform8x8Flag(zLeftAvailable, z, this.leftMBType, this.topMBType[mbX], this.tf8x8Left, this.tf8x8Top[mbX]);
        }
        if (mBlock.transform8x8Used) {
            for (int i = 0; i < 4; i++) {
                int i2 = (i & 1) << 1;
                int i3 = i & 2;
                mBlock.lumaModes[i] = readPredictionI4x4Block(zLeftAvailable, z, this.leftMBType, this.topMBType[mbX], i2, i3, mbX);
                int[] iArr = this.i4x4PredLeft;
                iArr[i3 + 1] = iArr[i3];
                int[] iArr2 = this.i4x4PredTop;
                int i4 = (mbX << 2) + i2;
                iArr2[i4 + 1] = iArr2[i4];
            }
        } else {
            for (int i5 = 0; i5 < 16; i5++) {
                mBlock.lumaModes[i5] = readPredictionI4x4Block(zLeftAvailable, z, this.leftMBType, this.topMBType[mbX], H264Const.MB_BLK_OFF_LEFT[i5], H264Const.MB_BLK_OFF_TOP[i5], mbX);
            }
        }
        mBlock.chromaPredictionMode = readChromaPredMode(mbX, zLeftAvailable, z);
        mBlock._cbp = readCodedBlockPatternIntra(zLeftAvailable, z, this.leftCBPLuma | (this.leftCBPChroma << 4), this.topCBPLuma[mbX] | (this.topCBPChroma[mbX] << 4), this.leftMBType, this.topMBType[mbX]);
        if (mBlock.cbpLuma() > 0 || mBlock.cbpChroma() > 0) {
            mBlock.mbQPDelta = readMBQpDelta(mBlock.prevMbType);
        }
        readResidualLuma(mBlock, zLeftAvailable, z, mbX, mbY);
        if (this.chromaFormat != ColorSpace.MONO) {
            readChromaResidual(mBlock, zLeftAvailable, z, mbX);
        }
    }

    public int readLumaAC(boolean z, boolean z2, int i, MBType mBType, int i2, int i3, int[] iArr, int i4, int i5) {
        return this.cavlc[0].readACBlock(this.reader, iArr, i2 + (i3 & 1), i5, i4 != 0 || z, i4 == 0 ? this.leftMBType : mBType, i5 != 0 || z2, i5 == 0 ? this.topMBType[i] : mBType, 0, 16, H264Const.identityMapping16);
    }

    public int readLumaAC8x8(int i, int i2, int[] iArr) {
        int coeffs = this.cabac.readCoeffs(this.mDecoder, CABAC.BlockType.LUMA_64, iArr, 0, 64, CoeffTransformer.zigzag8x8, H264Const.sig_coeff_map_8x8, H264Const.last_sig_coeff_map_8x8);
        this.cabac.setCodedBlock(i, i2);
        int i3 = i + 1;
        this.cabac.setCodedBlock(i3, i2);
        int i4 = i2 + 1;
        this.cabac.setCodedBlock(i, i4);
        this.cabac.setCodedBlock(i3, i4);
        return coeffs;
    }

    public int readMBQpDelta(MBType mBType) {
        return !this.activePps.entropyCodingModeFlag ? CAVLCReader.readSE(this.reader, "mb_qp_delta") : this.cabac.readMBQpDelta(this.mDecoder, mBType);
    }

    public boolean readMBSkipFlag(SliceType sliceType, boolean z, boolean z2, int i) {
        return this.cabac.readMBSkipFlag(this.mDecoder, sliceType, z, z2, i);
    }

    public int readMBTypeB(int i, boolean z, boolean z2, MBType mBType, MBType mBType2) {
        return !this.activePps.entropyCodingModeFlag ? CAVLCReader.readUEtrace(this.reader, "MB: mb_type") : this.cabac.readMBTypeB(this.mDecoder, mBType, mBType2, z, z2);
    }

    public int readMBTypeP() {
        return !this.activePps.entropyCodingModeFlag ? CAVLCReader.readUEtrace(this.reader, "MB: mb_type") : this.cabac.readMBTypeP(this.mDecoder);
    }

    public void readMBlock(MBlock mBlock, SliceType sliceType) {
        if (sliceType == SliceType.I) {
            readMBlockI(mBlock);
        } else if (sliceType == SliceType.P) {
            readMBlockP(mBlock);
        } else {
            readMBlockB(mBlock);
        }
        int mbX = this.mapper.getMbX(mBlock.mbIdx);
        int[] iArr = this.topCBPLuma;
        int iCbpLuma = mBlock.cbpLuma();
        this.leftCBPLuma = iCbpLuma;
        iArr[mbX] = iCbpLuma;
        int[] iArr2 = this.topCBPChroma;
        int iCbpChroma = mBlock.cbpChroma();
        this.leftCBPChroma = iCbpChroma;
        iArr2[mbX] = iCbpChroma;
        boolean[] zArr = this.tf8x8Top;
        boolean z = mBlock.transform8x8Used;
        zArr[mbX] = z;
        this.tf8x8Left = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void readMBlock8x8(org.jcodec.codecs.h264.decode.MBlock r16) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.h264.decode.SliceReader.readMBlock8x8(org.jcodec.codecs.h264.decode.MBlock):void");
    }

    public void readMBlockBDirect(MBlock mBlock) {
        int mbX = this.mapper.getMbX(mBlock.mbIdx);
        int mbY = this.mapper.getMbY(mBlock.mbIdx);
        boolean zLeftAvailable = this.mapper.leftAvailable(mBlock.mbIdx);
        boolean z = this.mapper.topAvailable(mBlock.mbIdx);
        mBlock._cbp = readCodedBlockPatternInter(zLeftAvailable, z, this.leftCBPLuma | (this.leftCBPChroma << 4), this.topCBPLuma[mbX] | (this.topCBPChroma[mbX] << 4), this.leftMBType, this.topMBType[mbX]);
        mBlock.transform8x8Used = false;
        if (this.transform8x8 && mBlock.cbpLuma() != 0 && this.sh.sps.direct8x8InferenceFlag) {
            mBlock.transform8x8Used = readTransform8x8Flag(zLeftAvailable, z, this.leftMBType, this.topMBType[mbX], this.tf8x8Left, this.tf8x8Top[mbX]);
        }
        if (mBlock.cbpLuma() > 0 || mBlock.cbpChroma() > 0) {
            mBlock.mbQPDelta = readMBQpDelta(mBlock.prevMbType);
        }
        readResidualLuma(mBlock, zLeftAvailable, z, mbX, mbY);
        readChromaResidual(mBlock, zLeftAvailable, z, mbX);
        H264Const.PartPred[] partPredArr = this.predModeTop;
        int i = mbX << 1;
        H264Const.PartPred[] partPredArr2 = this.predModeLeft;
        H264Const.PartPred partPred = H264Const.PartPred.Direct;
        partPredArr2[1] = partPred;
        partPredArr2[0] = partPred;
        partPredArr[i + 1] = partPred;
        partPredArr[i] = partPred;
    }

    public int readMVD(int i, boolean z, boolean z2, MBType mBType, MBType mBType2, H264Const.PartPred partPred, H264Const.PartPred partPred2, H264Const.PartPred partPred3, int i2, int i3, int i4, int i5, int i6, int i7) {
        return !this.activePps.entropyCodingModeFlag ? CAVLCReader.readSE(this.reader, "mvd_l0_x") : this.cabac.readMVD(this.mDecoder, i, z, z2, mBType, mBType2, partPred, partPred2, partPred3, i2, i3, i4, i5, i6, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean readMacroblock(org.jcodec.codecs.h264.decode.MBlock r11) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.h264.decode.SliceReader.readMacroblock(org.jcodec.codecs.h264.decode.MBlock):boolean");
    }

    public int readPredictionI4x4Block(boolean z, boolean z2, MBType mBType, MBType mBType2, int i, int i2, int i3) {
        int iMin;
        if ((z || i > 0) && (z2 || i2 > 0)) {
            MBType mBType3 = MBType.I_NxN;
            iMin = Math.min((mBType2 == mBType3 || i2 > 0) ? this.i4x4PredTop[(i3 << 2) + i] : 2, (mBType == mBType3 || i > 0) ? this.i4x4PredLeft[i2] : 2);
        } else {
            iMin = 2;
        }
        if (!prev4x4PredMode()) {
            int iRem4x4PredMode = rem4x4PredMode();
            iMin = (iRem4x4PredMode < iMin ? 0 : 1) + iRem4x4PredMode;
        }
        this.i4x4PredLeft[i2] = iMin;
        this.i4x4PredTop[(i3 << 2) + i] = iMin;
        return iMin;
    }

    public int readRefIdx(boolean z, boolean z2, MBType mBType, MBType mBType2, H264Const.PartPred partPred, H264Const.PartPred partPred2, H264Const.PartPred partPred3, int i, int i2, int i3, int i4, int i5, int i6) {
        return !this.activePps.entropyCodingModeFlag ? CAVLCReader.readTE(this.reader, this.numRef[i6] - 1) : this.cabac.readRefIdx(this.mDecoder, z, z2, mBType, mBType2, partPred, partPred2, partPred3, i, i2, i3, i4, i5, i6);
    }

    public int readResidualAC(boolean z, boolean z2, int i, MBType mBType, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (!this.activePps.entropyCodingModeFlag) {
            if (this.reader.remaining() <= 0) {
                return 0;
            }
            return this.cavlc[0].readACBlock(this.reader, iArr, i5, i4, i3 != 0 || z, i3 == 0 ? this.leftMBType : mBType, i4 != 0 || z2, i4 == 0 ? this.topMBType[i] : mBType, 0, 16, CoeffTransformer.zigzag4x4);
        }
        CABAC cabac = this.cabac;
        MDecoder mDecoder = this.mDecoder;
        CABAC.BlockType blockType = CABAC.BlockType.LUMA_16;
        if (cabac.readCodedBlockFlagLumaAC(mDecoder, blockType, i5, i4, 0, this.leftMBType, this.topMBType[i], z, z2, this.leftCBPLuma, this.topCBPLuma[i], i2, mBType) != 1) {
            return 0;
        }
        CABAC cabac2 = this.cabac;
        MDecoder mDecoder2 = this.mDecoder;
        int[] iArr2 = CoeffTransformer.zigzag4x4;
        int[] iArr3 = H264Const.identityMapping16;
        return cabac2.readCoeffs(mDecoder2, blockType, iArr, 0, 16, iArr2, iArr3, iArr3);
    }

    public void readResidualLuma(MBlock mBlock, boolean z, boolean z2, int i, int i2) {
        if (!mBlock.transform8x8Used) {
            readLuma(mBlock, z, z2, i, i2);
        } else if (this.sh.pps.entropyCodingModeFlag) {
            readLuma8x8CABAC(mBlock, i, i2);
        } else {
            readLuma8x8CAVLC(mBlock, z, z2, i, i2);
        }
    }

    public int readSubMBTypeB() {
        return !this.activePps.entropyCodingModeFlag ? CAVLCReader.readUEtrace(this.reader, "SUB: sub_mb_type") : this.cabac.readSubMbTypeB(this.mDecoder);
    }

    public int readSubMBTypeP() {
        return !this.activePps.entropyCodingModeFlag ? CAVLCReader.readUEtrace(this.reader, "SUB: sub_mb_type") : this.cabac.readSubMbTypeP(this.mDecoder);
    }

    public boolean readTransform8x8Flag(boolean z, boolean z2, MBType mBType, MBType mBType2, boolean z3, boolean z4) {
        return !this.activePps.entropyCodingModeFlag ? CAVLCReader.readBool(this.reader, "transform_size_8x8_flag") : this.cabac.readTransform8x8Flag(this.mDecoder, z, z2, mBType, mBType2, z3, z4);
    }

    public int rem4x4PredMode() {
        return !this.activePps.entropyCodingModeFlag ? CAVLCReader.readNBit(this.reader, 3, "MB: rem_intra4x4_pred_mode") : this.cabac.rem4x4PredMode(this.mDecoder);
    }

    public void savePrevCBP(int i) {
        if (this.activePps.entropyCodingModeFlag) {
            this.cabac.setPrevCBP(i);
        }
    }

    public void setZeroCoeff(int i, int i2, int i3) {
        this.cavlc[i].setZeroCoeff(i2, i3);
    }
}
