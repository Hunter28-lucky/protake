package org.jcodec.codecs.vpx;

/* loaded from: classes2.dex */
public class NopRateControl implements RateControl {
    private int qp;

    public NopRateControl(int i) {
        this.qp = i;
    }

    @Override // org.jcodec.codecs.vpx.RateControl
    public int getSegment() {
        return 0;
    }

    @Override // org.jcodec.codecs.vpx.RateControl
    public int[] getSegmentQps() {
        return new int[]{this.qp};
    }

    @Override // org.jcodec.codecs.vpx.RateControl
    public void report(int i) {
    }

    @Override // org.jcodec.codecs.vpx.RateControl
    public void reset() {
    }
}
