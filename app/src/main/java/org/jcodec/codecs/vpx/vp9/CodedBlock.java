package org.jcodec.codecs.vpx.vp9;

import org.jcodec.codecs.vpx.VPXBooleanDecoder;

/* loaded from: classes2.dex */
public class CodedBlock {
    public static final CodedBlock[] EMPTY_ARR = new CodedBlock[0];
    private ModeInfo mode;
    private Residual residual;

    public CodedBlock(ModeInfo modeInfo, Residual residual) {
        this.mode = modeInfo;
        this.residual = residual;
    }

    public static CodedBlock read(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        ModeInfo modeInfo = decodingContext.isKeyIntraFrame() ? new ModeInfo().read(i, i2, i3, vPXBooleanDecoder, decodingContext) : new InterModeInfo().read(i, i2, i3, vPXBooleanDecoder, decodingContext);
        return new CodedBlock(modeInfo, Residual.readResidual(i, i2, i3, vPXBooleanDecoder, decodingContext, modeInfo));
    }

    public ModeInfo getMode() {
        return this.mode;
    }

    public Residual getResidual() {
        return this.residual;
    }
}
