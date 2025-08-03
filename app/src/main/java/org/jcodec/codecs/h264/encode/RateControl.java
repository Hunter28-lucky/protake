package org.jcodec.codecs.h264.encode;

import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.model.Size;

/* loaded from: classes2.dex */
public interface RateControl {
    int accept(int i);

    int initialQpDelta();

    int startPicture(Size size, int i, SliceType sliceType);
}
