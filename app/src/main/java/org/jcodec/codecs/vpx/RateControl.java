package org.jcodec.codecs.vpx;

/* loaded from: classes2.dex */
public interface RateControl {
    int getSegment();

    int[] getSegmentQps();

    void report(int i);

    void reset();
}
