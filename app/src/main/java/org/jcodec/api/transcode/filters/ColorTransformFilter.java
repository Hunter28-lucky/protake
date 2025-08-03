package org.jcodec.api.transcode.filters;

import org.jcodec.api.transcode.Filter;
import org.jcodec.api.transcode.PixelStore;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.ColorUtil;
import org.jcodec.scale.Transform;

/* loaded from: classes2.dex */
public class ColorTransformFilter implements Filter {
    private ColorSpace outputColor;
    private Transform transform;

    public ColorTransformFilter(ColorSpace colorSpace) {
        this.outputColor = colorSpace;
    }

    @Override // org.jcodec.api.transcode.Filter
    public PixelStore.LoanerPicture filter(Picture picture, PixelStore pixelStore) {
        if (this.transform == null) {
            this.transform = ColorUtil.getTransform(picture.getColor(), this.outputColor);
            Logger.debug("Creating transform: " + this.transform);
        }
        PixelStore.LoanerPicture picture2 = pixelStore.getPicture(picture.getWidth(), picture.getHeight(), this.outputColor);
        picture2.getPicture().setCrop(picture.getCrop());
        this.transform.transform(picture, picture2.getPicture());
        return picture2;
    }

    @Override // org.jcodec.api.transcode.Filter
    public ColorSpace getInputColor() {
        return ColorSpace.ANY_PLANAR;
    }

    @Override // org.jcodec.api.transcode.Filter
    public ColorSpace getOutputColor() {
        return this.outputColor;
    }
}
