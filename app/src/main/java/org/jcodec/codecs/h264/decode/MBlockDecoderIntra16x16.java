package org.jcodec.codecs.h264.decode;

import org.jcodec.codecs.h264.decode.aso.Mapper;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class MBlockDecoderIntra16x16 extends MBlockDecoderBase {
    private Mapper mapper;

    public MBlockDecoderIntra16x16(Mapper mapper, SliceHeader sliceHeader, DeblockerInput deblockerInput, int i, DecoderState decoderState) {
        super(sliceHeader, deblockerInput, i, decoderState);
        this.mapper = mapper;
    }

    private void residualLumaI16x16(MBlock mBlock, boolean z, boolean z2, int i, int i2) {
        CoeffTransformer.invDC4x4(mBlock.dc);
        int[] scalingList = getScalingList(0);
        CoeffTransformer.dequantizeDC4x4(mBlock.dc, this.s.qp, scalingList);
        CoeffTransformer.reorderDC4x4(mBlock.dc);
        for (int i3 = 0; i3 < 16; i3++) {
            if ((mBlock.cbpLuma() & (1 << (i3 >> 2))) != 0) {
                CoeffTransformer.dequantizeAC(mBlock.ac[0][i3], this.s.qp, scalingList);
            }
            int[] iArr = mBlock.ac[0][i3];
            iArr[0] = mBlock.dc[i3];
            CoeffTransformer.idct4x4(iArr);
        }
    }

    public void decode(MBlock mBlock, Picture picture) {
        int mbX = this.mapper.getMbX(mBlock.mbIdx);
        int mbY = this.mapper.getMbY(mBlock.mbIdx);
        int address = this.mapper.getAddress(mBlock.mbIdx);
        boolean zLeftAvailable = this.mapper.leftAvailable(mBlock.mbIdx);
        boolean z = this.mapper.topAvailable(mBlock.mbIdx);
        DecoderState decoderState = this.s;
        int i = ((decoderState.qp + mBlock.mbQPDelta) + 52) % 52;
        decoderState.qp = i;
        this.di.mbQps[0][address] = i;
        residualLumaI16x16(mBlock, zLeftAvailable, z, mbX, mbY);
        int i2 = mBlock.luma16x16Mode;
        int[][] iArr = mBlock.ac[0];
        DecoderState decoderState2 = this.s;
        Intra16x16PredictionBuilder.predictWithMode(i2, iArr, zLeftAvailable, z, decoderState2.leftRow[0], decoderState2.topLine[0], decoderState2.topLeft[0], mbX << 4, picture.getPlaneData(0));
        decodeChroma(mBlock, mbX, mbY, zLeftAvailable, z, picture, this.s.qp);
        this.di.mbTypes[address] = mBlock.curMbType;
        MBlockDecoderUtils.collectPredictors(this.s, picture, mbX);
        MBlockDecoderUtils.saveMvsIntra(this.di, mbX, mbY);
        MBlockDecoderUtils.saveVectIntra(this.s, this.mapper.getMbX(mBlock.mbIdx));
    }
}
