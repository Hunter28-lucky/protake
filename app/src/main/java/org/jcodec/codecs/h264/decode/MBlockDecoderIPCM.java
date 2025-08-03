package org.jcodec.codecs.h264.decode;

import org.jcodec.codecs.h264.decode.aso.Mapper;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class MBlockDecoderIPCM {
    private Mapper mapper;
    private DecoderState s;

    public MBlockDecoderIPCM(Mapper mapper, DecoderState decoderState) {
        this.mapper = mapper;
        this.s = decoderState;
    }

    public void decode(MBlock mBlock, Picture picture) {
        MBlockDecoderUtils.collectPredictors(this.s, picture, this.mapper.getMbX(mBlock.mbIdx));
        MBlockDecoderUtils.saveVectIntra(this.s, this.mapper.getMbX(mBlock.mbIdx));
    }
}
