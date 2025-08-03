package org.jcodec.scale.highbd;

import org.jcodec.common.model.PictureHiBD;

/* loaded from: classes2.dex */
public interface TransformHiBD {

    public enum Levels {
        STUDIO,
        PC
    }

    void transform(PictureHiBD pictureHiBD, PictureHiBD pictureHiBD2);
}
