package org.jcodec.codecs.h264.encode;

import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.model.Size;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class H264FixedRateControl implements RateControl {
    private static final int INIT_QP = 26;
    private int balance;
    private int curQp = 26;
    private int perMb;

    public H264FixedRateControl(int i) {
        this.perMb = i;
    }

    @Override // org.jcodec.codecs.h264.encode.RateControl
    public int accept(int i) {
        this.balance += this.perMb - i;
        return 0;
    }

    public int calcFrameSize(int i) {
        return ((((this.perMb + 9) * i) + 256) >> 3) + (i >> 6);
    }

    @Override // org.jcodec.codecs.h264.encode.RateControl
    public int initialQpDelta() {
        int i = this.balance;
        int i2 = 2;
        if (i >= 0) {
            int i3 = this.perMb;
            i2 = i > i3 ? i > (i3 << 2) ? -2 : -1 : 0;
        } else if (i >= (-(this.perMb >> 1))) {
            i2 = 1;
        }
        int i4 = this.curQp;
        int iClip = MathUtil.clip(i2 + i4, 12, 30);
        this.curQp = iClip;
        return iClip - i4;
    }

    public void reset() {
        this.balance = 0;
        this.curQp = 26;
    }

    public void setRate(int i) {
        this.perMb = i;
    }

    @Override // org.jcodec.codecs.h264.encode.RateControl
    public int startPicture(Size size, int i, SliceType sliceType) {
        return (sliceType == SliceType.P ? 4 : 0) + 26;
    }
}
