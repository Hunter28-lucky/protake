package org.jcodec.codecs.h264.decode;

import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.decode.aso.MapManager;
import org.jcodec.codecs.h264.decode.aso.Mapper;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.IntObjectMap;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class SliceDecoder {
    private SeqParameterSet activeSps;
    private MBlockDecoderBDirect decoderBDirect;
    private MBlockDecoderIPCM decoderIPCM;
    private MBlockDecoderInter decoderInter;
    private MBlockDecoderInter8x8 decoderInter8x8;
    private MBlockDecoderIntra16x16 decoderIntra16x16;
    private MBlockDecoderIntraNxN decoderIntraNxN;
    private DecoderState decoderState;
    private DeblockerInput di;
    private Frame frameOut;
    private IntObjectMap<Frame> lRefs;
    private Mapper mapper;
    private SliceReader parser;
    private RefListManager refListManager;
    private Frame[] sRefs;
    private MBlockSkipDecoder skipDecoder;

    public SliceDecoder(SeqParameterSet seqParameterSet, Frame[] frameArr, IntObjectMap<Frame> intObjectMap, DeblockerInput deblockerInput, Frame frame) {
        this.di = deblockerInput;
        this.activeSps = seqParameterSet;
        this.frameOut = frame;
        this.sRefs = frameArr;
        this.lRefs = intObjectMap;
    }

    private void decodeMBlockB(MBlock mBlock, Picture picture, Frame[][] frameArr) {
        if (mBlock.curMbType.isIntra()) {
            decodeMBlockIInt(mBlock, picture);
            return;
        }
        if (mBlock.curMbType == MBType.B_Direct_16x16) {
            this.decoderBDirect.decode(mBlock, picture, frameArr);
            return;
        }
        int i = mBlock.mbType;
        if (i <= 3) {
            this.decoderInter.decode16x16(mBlock, picture, frameArr, H264Const.bPredModes[i][0]);
            return;
        }
        if (i == 22) {
            this.decoderInter8x8.decode(mBlock, frameArr, picture, SliceType.B, false);
            return;
        }
        if ((i & 1) == 0) {
            MBlockDecoderInter mBlockDecoderInter = this.decoderInter;
            H264Const.PartPred[] partPredArr = H264Const.bPredModes[i];
            mBlockDecoderInter.decode16x8(mBlock, picture, frameArr, partPredArr[0], partPredArr[1]);
        } else {
            MBlockDecoderInter mBlockDecoderInter2 = this.decoderInter;
            H264Const.PartPred[] partPredArr2 = H264Const.bPredModes[i];
            mBlockDecoderInter2.decode8x16(mBlock, picture, frameArr, partPredArr2[0], partPredArr2[1]);
        }
    }

    private void decodeMBlockI(MBlock mBlock, Picture picture) {
        decodeMBlockIInt(mBlock, picture);
    }

    private void decodeMBlockIInt(MBlock mBlock, Picture picture) {
        MBType mBType = mBlock.curMbType;
        if (mBType == MBType.I_NxN) {
            this.decoderIntraNxN.decode(mBlock, picture);
        } else if (mBType == MBType.I_16x16) {
            this.decoderIntra16x16.decode(mBlock, picture);
        } else {
            Logger.warn("IPCM macroblock found. Not tested, may cause unpredictable behavior.");
            this.decoderIPCM.decode(mBlock, picture);
        }
    }

    private void decodeMBlockP(MBlock mBlock, Picture picture, Frame[][] frameArr) {
        MBType mBType = MBType.P_16x16;
        MBType mBType2 = mBlock.curMbType;
        if (mBType == mBType2) {
            this.decoderInter.decode16x16(mBlock, picture, frameArr, H264Const.PartPred.L0);
            return;
        }
        if (MBType.P_16x8 == mBType2) {
            MBlockDecoderInter mBlockDecoderInter = this.decoderInter;
            H264Const.PartPred partPred = H264Const.PartPred.L0;
            mBlockDecoderInter.decode16x8(mBlock, picture, frameArr, partPred, partPred);
        } else if (MBType.P_8x16 == mBType2) {
            MBlockDecoderInter mBlockDecoderInter2 = this.decoderInter;
            H264Const.PartPred partPred2 = H264Const.PartPred.L0;
            mBlockDecoderInter2.decode8x16(mBlock, picture, frameArr, partPred2, partPred2);
        } else if (MBType.P_8x8 == mBType2) {
            this.decoderInter8x8.decode(mBlock, frameArr, picture, SliceType.P, false);
        } else if (MBType.P_8x8ref0 == mBType2) {
            this.decoderInter8x8.decode(mBlock, frameArr, picture, SliceType.P, true);
        } else {
            decodeMBlockIInt(mBlock, picture);
        }
    }

    private void decodeMacroblocks(Frame[][] frameArr) {
        Picture pictureCreate = Picture.create(16, 16, this.activeSps.chromaFormatIdc);
        SeqParameterSet seqParameterSet = this.activeSps;
        int i = seqParameterSet.picWidthInMbsMinus1 + 1;
        MBlock mBlock = new MBlock(seqParameterSet.chromaFormatIdc);
        while (this.parser.readMacroblock(mBlock)) {
            decode(mBlock, this.parser.getSliceHeader().sliceType, pictureCreate, frameArr);
            int address = this.mapper.getAddress(mBlock.mbIdx);
            int i2 = address % i;
            int i3 = address / i;
            putMacroblock(this.frameOut, pictureCreate, i2, i3);
            this.di.shs[address] = this.parser.getSliceHeader();
            this.di.refsUsed[address] = frameArr;
            fillCoeff(mBlock, i2, i3);
            pictureCreate.fill(0);
            mBlock.clear();
        }
    }

    private void fillCoeff(MBlock mBlock, int i, int i2) {
        for (int i3 = 0; i3 < 16; i3++) {
            this.di.nCoeff[(i2 << 2) + H264Const.MB_BLK_OFF_TOP[i3]][(i << 2) + H264Const.MB_BLK_OFF_LEFT[i3]] = mBlock.nCoeff[i3];
        }
    }

    private void initContext() {
        SliceHeader sliceHeader = this.parser.getSliceHeader();
        this.decoderState = new DecoderState(sliceHeader);
        Mapper mapper = new MapManager(sliceHeader.sps, sliceHeader.pps).getMapper(sliceHeader);
        this.mapper = mapper;
        this.decoderIntra16x16 = new MBlockDecoderIntra16x16(mapper, sliceHeader, this.di, this.frameOut.getPOC(), this.decoderState);
        this.decoderIntraNxN = new MBlockDecoderIntraNxN(this.mapper, sliceHeader, this.di, this.frameOut.getPOC(), this.decoderState);
        this.decoderInter = new MBlockDecoderInter(this.mapper, sliceHeader, this.di, this.frameOut.getPOC(), this.decoderState);
        MBlockDecoderBDirect mBlockDecoderBDirect = new MBlockDecoderBDirect(this.mapper, sliceHeader, this.di, this.frameOut.getPOC(), this.decoderState);
        this.decoderBDirect = mBlockDecoderBDirect;
        this.decoderInter8x8 = new MBlockDecoderInter8x8(this.mapper, mBlockDecoderBDirect, sliceHeader, this.di, this.frameOut.getPOC(), this.decoderState);
        this.skipDecoder = new MBlockSkipDecoder(this.mapper, this.decoderBDirect, sliceHeader, this.di, this.frameOut.getPOC(), this.decoderState);
        this.decoderIPCM = new MBlockDecoderIPCM(this.mapper, this.decoderState);
        this.refListManager = new RefListManager(sliceHeader, this.sRefs, this.lRefs, this.frameOut);
    }

    private static void putMacroblock(Picture picture, Picture picture2, int i, int i2) {
        byte[] planeData = picture.getPlaneData(0);
        int planeWidth = picture.getPlaneWidth(0);
        byte[] planeData2 = picture.getPlaneData(1);
        byte[] planeData3 = picture.getPlaneData(2);
        int planeWidth2 = picture.getPlaneWidth(1);
        int i3 = i * 16;
        int i4 = i2 * 16;
        byte[] planeData4 = picture2.getPlaneData(0);
        int i5 = 0;
        for (int i6 = 0; i6 < 16; i6++) {
            System.arraycopy(planeData4, i5, planeData, ((i4 + i6) * planeWidth) + i3, 16);
            i5 += 16;
        }
        int i7 = i * 8;
        int i8 = i2 * 8;
        byte[] planeData5 = picture2.getPlaneData(1);
        byte[] planeData6 = picture2.getPlaneData(2);
        for (int i9 = 0; i9 < 8; i9++) {
            int i10 = i9 << 3;
            int i11 = ((i8 + i9) * planeWidth2) + i7;
            System.arraycopy(planeData5, i10, planeData2, i11, 8);
            System.arraycopy(planeData6, i10, planeData3, i11, 8);
        }
    }

    public void decode(MBlock mBlock, SliceType sliceType, Picture picture, Frame[][] frameArr) {
        if (mBlock.skipped) {
            this.skipDecoder.decodeSkip(mBlock, frameArr, picture, sliceType);
            return;
        }
        if (sliceType == SliceType.I) {
            decodeMBlockI(mBlock, picture);
        } else if (sliceType == SliceType.P) {
            decodeMBlockP(mBlock, picture, frameArr);
        } else {
            decodeMBlockB(mBlock, picture, frameArr);
        }
    }

    public void decodeFromReader(SliceReader sliceReader) {
        this.parser = sliceReader;
        initContext();
        MBlockDecoderUtils.debugPrint("============%d============= ", Integer.valueOf(this.frameOut.getPOC()));
        decodeMacroblocks(this.refListManager.getRefList());
    }
}
