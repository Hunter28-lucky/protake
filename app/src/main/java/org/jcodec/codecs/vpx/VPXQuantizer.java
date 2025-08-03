package org.jcodec.codecs.vpx;

import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class VPXQuantizer {
    private int uv_ac_delta_q;
    private int uv_dc_delta_q;
    private int y1_dc_delta_q;
    private int y2_ac_delta_q;
    private int y2_dc_delta_q;

    private final void dequantize(int[] iArr, int i, int i2) {
        iArr[0] = iArr[0] * i;
        for (int i3 = 1; i3 < 16; i3++) {
            iArr[i3] = iArr[i3] * i2;
        }
    }

    private final void quantize(int[] iArr, int i, int i2) {
        iArr[0] = iArr[0] / i;
        for (int i3 = 1; i3 < 16; i3++) {
            iArr[i3] = iArr[i3] / i2;
        }
    }

    public final void dequantizeUV(int[] iArr, int i) {
        dequantize(iArr, MathUtil.clip(VPXConst.dc_qlookup[this.uv_dc_delta_q + i], 8, 132), MathUtil.clip(VPXConst.ac_qlookup[i + this.uv_ac_delta_q], 8, 132));
    }

    public final void dequantizeY(int[] iArr, int i) {
        dequantize(iArr, MathUtil.clip(VPXConst.dc_qlookup[this.y1_dc_delta_q + i], 8, 132), MathUtil.clip(VPXConst.ac_qlookup[i], 8, 132));
    }

    public final void dequantizeY2(int[] iArr, int i) {
        dequantize(iArr, MathUtil.clip(VPXConst.dc_qlookup[this.y2_dc_delta_q + i] * 2, 8, 132), MathUtil.clip((VPXConst.ac_qlookup[i + this.y2_ac_delta_q] * 155) / 100, 8, 132));
    }

    public final void quantizeUV(int[] iArr, int i) {
        quantize(iArr, MathUtil.clip(VPXConst.dc_qlookup[this.uv_dc_delta_q + i], 8, 132), MathUtil.clip(VPXConst.ac_qlookup[i + this.uv_ac_delta_q], 8, 132));
    }

    public final void quantizeY(int[] iArr, int i) {
        quantize(iArr, MathUtil.clip(VPXConst.dc_qlookup[this.y1_dc_delta_q + i], 8, 132), MathUtil.clip(VPXConst.ac_qlookup[i], 8, 132));
    }

    public final void quantizeY2(int[] iArr, int i) {
        quantize(iArr, MathUtil.clip(VPXConst.dc_qlookup[this.y2_dc_delta_q + i] * 2, 8, 132), MathUtil.clip((VPXConst.ac_qlookup[i + this.y2_ac_delta_q] * 155) / 100, 8, 132));
    }
}
