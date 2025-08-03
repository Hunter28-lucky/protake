package org.jcodec.api.transcode.filters;

import org.jcodec.api.transcode.Filter;
import org.jcodec.api.transcode.PixelStore;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class CropFilter implements Filter {
    @Override // org.jcodec.api.transcode.Filter
    public PixelStore.LoanerPicture filter(Picture picture, PixelStore pixelStore) {
        return null;
    }

    @Override // org.jcodec.api.transcode.Filter
    public ColorSpace getInputColor() {
        return null;
    }

    @Override // org.jcodec.api.transcode.Filter
    public ColorSpace getOutputColor() {
        return null;
    }
}
