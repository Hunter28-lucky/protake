package org.jcodec.api;

import org.jcodec.common.model.Size;

/* loaded from: classes2.dex */
public class MediaInfo {
    private Size dim;

    public MediaInfo(Size size) {
        this.dim = size;
    }

    public Size getDim() {
        return this.dim;
    }

    public void setDim(Size size) {
        this.dim = size;
    }
}
