package org.jcodec.codecs.h264.decode;

import java.util.Arrays;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.decode.aso.Mapper;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class MBlockSkipDecoder extends MBlockDecoderBase {
    private MBlockDecoderBDirect bDirectDecoder;
    private Mapper mapper;

    public MBlockSkipDecoder(Mapper mapper, MBlockDecoderBDirect mBlockDecoderBDirect, SliceHeader sliceHeader, DeblockerInput deblockerInput, int i, DecoderState decoderState) {
        super(sliceHeader, deblockerInput, i, decoderState);
        this.mapper = mapper;
        this.bDirectDecoder = mBlockDecoderBDirect;
    }

    public void decodeChromaSkip(Frame[][] frameArr, H264Utils.MvList mvList, H264Const.PartPred[] partPredArr, int i, int i2, Picture picture) {
        int i3 = i << 3;
        int i4 = i2 << 3;
        predictChromaInter(frameArr, mvList, i3, i4, 1, picture, partPredArr);
        predictChromaInter(frameArr, mvList, i3, i4, 2, picture, partPredArr);
    }

    public void decodeSkip(MBlock mBlock, Frame[][] frameArr, Picture picture, SliceType sliceType) {
        int i;
        int i2;
        int mbX = this.mapper.getMbX(mBlock.mbIdx);
        int mbY = this.mapper.getMbY(mBlock.mbIdx);
        int address = this.mapper.getAddress(mBlock.mbIdx);
        if (sliceType == SliceType.P) {
            predictPSkip(frameArr, mbX, mbY, this.mapper.leftAvailable(mBlock.mbIdx), this.mapper.topAvailable(mBlock.mbIdx), this.mapper.topLeftAvailable(mBlock.mbIdx), this.mapper.topRightAvailable(mBlock.mbIdx), mBlock.x, picture);
            Arrays.fill(mBlock.partPreds, H264Const.PartPred.L0);
            i = mbY;
            i2 = mbX;
        } else {
            i = mbY;
            i2 = mbX;
            this.bDirectDecoder.predictBDirect(frameArr, mbX, i, this.mapper.leftAvailable(mBlock.mbIdx), this.mapper.topAvailable(mBlock.mbIdx), this.mapper.topLeftAvailable(mBlock.mbIdx), this.mapper.topRightAvailable(mBlock.mbIdx), mBlock.x, mBlock.partPreds, picture, H264Const.identityMapping4);
            MBlockDecoderUtils.savePrediction8x8(this.s, i2, mBlock.x);
        }
        decodeChromaSkip(frameArr, mBlock.x, mBlock.partPreds, i2, i, picture);
        MBlockDecoderUtils.collectPredictors(this.s, picture, i2);
        MBlockDecoderUtils.saveMvs(this.di, mBlock.x, i2, i);
        DeblockerInput deblockerInput = this.di;
        deblockerInput.mbTypes[address] = mBlock.curMbType;
        int[][] iArr = deblockerInput.mbQps;
        int[] iArr2 = iArr[0];
        DecoderState decoderState = this.s;
        int i3 = decoderState.qp;
        iArr2[address] = i3;
        iArr[1][address] = MBlockDecoderBase.calcQpChroma(i3, decoderState.chromaQpOffset[0]);
        int[] iArr3 = this.di.mbQps[2];
        DecoderState decoderState2 = this.s;
        iArr3[address] = MBlockDecoderBase.calcQpChroma(decoderState2.qp, decoderState2.chromaQpOffset[1]);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void predictPSkip(org.jcodec.codecs.h264.io.model.Frame[][] r26, int r27, int r28, boolean r29, boolean r30, boolean r31, boolean r32, org.jcodec.codecs.h264.H264Utils.MvList r33, org.jcodec.common.model.Picture r34) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.h264.decode.MBlockSkipDecoder.predictPSkip(org.jcodec.codecs.h264.io.model.Frame[][], int, int, boolean, boolean, boolean, boolean, org.jcodec.codecs.h264.H264Utils$MvList, org.jcodec.common.model.Picture):void");
    }
}
