package org.jcodec.codecs.h264.io.model;

import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class RefPicMarkingIDR {
    public boolean discardDecodedPics;
    public boolean useForlongTerm;

    public RefPicMarkingIDR(boolean z, boolean z2) {
        this.discardDecodedPics = z;
        this.useForlongTerm = z2;
    }

    public boolean isDiscardDecodedPics() {
        return this.discardDecodedPics;
    }

    public boolean isUseForlongTerm() {
        return this.useForlongTerm;
    }

    public String toString() {
        return Platform.toJSON(this);
    }
}
