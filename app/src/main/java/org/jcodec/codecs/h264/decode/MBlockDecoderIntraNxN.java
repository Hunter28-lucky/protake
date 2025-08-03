package org.jcodec.codecs.h264.decode;

import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.decode.aso.Mapper;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class MBlockDecoderIntraNxN extends MBlockDecoderBase {
    private Mapper mapper;
    private Intra8x8PredictionBuilder prediction8x8Builder;

    public MBlockDecoderIntraNxN(Mapper mapper, SliceHeader sliceHeader, DeblockerInput deblockerInput, int i, DecoderState decoderState) {
        super(sliceHeader, deblockerInput, i, decoderState);
        this.mapper = mapper;
        this.prediction8x8Builder = new Intra8x8PredictionBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v6 */
    public void decode(MBlock mBlock, Picture picture) {
        int mbX = this.mapper.getMbX(mBlock.mbIdx);
        int mbY = this.mapper.getMbY(mBlock.mbIdx);
        int address = this.mapper.getAddress(mBlock.mbIdx);
        boolean zLeftAvailable = this.mapper.leftAvailable(mBlock.mbIdx);
        boolean z = this.mapper.topAvailable(mBlock.mbIdx);
        boolean z2 = this.mapper.topLeftAvailable(mBlock.mbIdx);
        boolean z3 = this.mapper.topRightAvailable(mBlock.mbIdx);
        if (mBlock.cbpLuma() > 0 || mBlock.cbpChroma() > 0) {
            DecoderState decoderState = this.s;
            decoderState.qp = ((decoderState.qp + mBlock.mbQPDelta) + 52) % 52;
        }
        this.di.mbQps[0][address] = this.s.qp;
        residualLuma(mBlock, zLeftAvailable, z, mbX, mbY);
        int i = 4;
        int i2 = 2;
        ?? r5 = 1;
        if (mBlock.transform8x8Used) {
            int i3 = 0;
            while (i3 < i) {
                int i4 = (i3 & 1) << r5;
                int i5 = i3 & 2;
                boolean z4 = ((i3 == 0 && z) || (i3 == r5 && z3) || i3 == i2) ? r5 : false;
                boolean z5 = i3 == 0 ? z2 : i3 == r5 ? z : i3 == i2 ? zLeftAvailable : r5;
                Intra8x8PredictionBuilder intra8x8PredictionBuilder = this.prediction8x8Builder;
                int i6 = mBlock.lumaModes[i3];
                int[] iArr = mBlock.ac[0][i3];
                boolean z6 = i4 == 0 ? zLeftAvailable : r5;
                boolean z7 = i5 == 0 ? z : r5;
                DecoderState decoderState2 = this.s;
                intra8x8PredictionBuilder.predictWithMode(i6, iArr, z6, z7, z5, z4, decoderState2.leftRow[0], decoderState2.topLine[0], decoderState2.topLeft[0], mbX << 4, i4 << 2, i5 << 2, picture.getPlaneData(0));
                i3++;
                i = 4;
                i2 = 2;
                r5 = 1;
            }
        } else {
            for (int i7 = 0; i7 < 16; i7++) {
                int i8 = (i7 & 3) << 2;
                int i9 = i7 & (-4);
                int i10 = H264Const.BLK_INV_MAP[i7];
                boolean z8 = ((i10 == 0 || i10 == 1 || i10 == 4) && z) || (i10 == 5 && z3) || i10 == 2 || i10 == 6 || i10 == 8 || i10 == 9 || i10 == 10 || i10 == 12 || i10 == 14;
                int i11 = mBlock.lumaModes[i10];
                int[] iArr2 = mBlock.ac[0][i10];
                boolean z9 = i8 == 0 ? zLeftAvailable : true;
                boolean z10 = i9 == 0 ? z : true;
                DecoderState decoderState3 = this.s;
                Intra4x4PredictionBuilder.predictWithMode(i11, iArr2, z9, z10, z8, decoderState3.leftRow[0], decoderState3.topLine[0], decoderState3.topLeft[0], mbX << 4, i8, i9, picture.getPlaneData(0));
            }
        }
        decodeChroma(mBlock, mbX, mbY, zLeftAvailable, z, picture, this.s.qp);
        DeblockerInput deblockerInput = this.di;
        deblockerInput.mbTypes[address] = mBlock.curMbType;
        deblockerInput.tr8x8Used[address] = mBlock.transform8x8Used;
        MBlockDecoderUtils.collectChromaPredictors(this.s, picture, mbX);
        MBlockDecoderUtils.saveMvsIntra(this.di, mbX, mbY);
        MBlockDecoderUtils.saveVectIntra(this.s, this.mapper.getMbX(mBlock.mbIdx));
    }
}
