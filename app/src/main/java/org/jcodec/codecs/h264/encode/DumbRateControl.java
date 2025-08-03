package org.jcodec.codecs.h264.encode;

import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.model.Size;

/* loaded from: classes2.dex */
public class DumbRateControl implements RateControl {
    private static final int QP = 20;
    private int bitsPerMb;
    private boolean justSwitched;
    private int totalQpDelta;

    @Override // org.jcodec.codecs.h264.encode.RateControl
    public int accept(int i) {
        int i2 = this.bitsPerMb;
        if (i >= i2) {
            this.totalQpDelta++;
            this.justSwitched = true;
            return 1;
        }
        int i3 = this.totalQpDelta;
        if (i3 <= 0 || this.justSwitched || i2 - i <= (i2 >> 3)) {
            this.justSwitched = false;
            return 0;
        }
        this.totalQpDelta = i3 - 1;
        this.justSwitched = true;
        return -1;
    }

    @Override // org.jcodec.codecs.h264.encode.RateControl
    public int initialQpDelta() {
        return 0;
    }

    @Override // org.jcodec.codecs.h264.encode.RateControl
    public int startPicture(Size size, int i, SliceType sliceType) {
        this.bitsPerMb = (i << 3) / (((size.getWidth() + 15) >> 4) * ((size.getHeight() + 15) >> 4));
        this.totalQpDelta = 0;
        this.justSwitched = false;
        return (sliceType == SliceType.P ? 6 : 0) + 20;
    }
}
