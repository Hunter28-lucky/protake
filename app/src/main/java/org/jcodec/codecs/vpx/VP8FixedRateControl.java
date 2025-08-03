package org.jcodec.codecs.vpx;

/* loaded from: classes2.dex */
public class VP8FixedRateControl implements RateControl {
    private int rate;

    public VP8FixedRateControl(int i) {
        this.rate = i;
    }

    @Override // org.jcodec.codecs.vpx.RateControl
    public int getSegment() {
        return 0;
    }

    @Override // org.jcodec.codecs.vpx.RateControl
    public int[] getSegmentQps() {
        return null;
    }

    @Override // org.jcodec.codecs.vpx.RateControl
    public void report(int i) {
    }

    @Override // org.jcodec.codecs.vpx.RateControl
    public void reset() {
    }
}
