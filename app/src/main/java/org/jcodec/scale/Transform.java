package org.jcodec.scale;

import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public interface Transform {

    public enum Levels {
        STUDIO,
        PC
    }

    void transform(Picture picture, Picture picture2);
}
