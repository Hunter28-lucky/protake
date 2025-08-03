package org.jcodec.api.transcode;

import org.jcodec.api.transcode.PixelStore;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public interface Filter {
    PixelStore.LoanerPicture filter(Picture picture, PixelStore pixelStore);

    ColorSpace getInputColor();

    ColorSpace getOutputColor();
}
