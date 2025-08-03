package org.jcodec.api.transcode.filters;

import org.jcodec.api.transcode.Filter;
import org.jcodec.api.transcode.PixelStore;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Size;
import org.jcodec.scale.BaseResampler;
import org.jcodec.scale.LanczosResampler;

/* loaded from: classes2.dex */
public class ScaleFilter implements Filter {
    private ColorSpace currentColor;
    private Size currentSize;
    private int height;
    private BaseResampler resampler;
    private Size targetSize;
    private int width;

    public ScaleFilter(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    @Override // org.jcodec.api.transcode.Filter
    public PixelStore.LoanerPicture filter(Picture picture, PixelStore pixelStore) {
        Size size = picture.getSize();
        if (this.resampler == null || this.currentColor != picture.getColor() || !size.equals(this.currentSize)) {
            this.currentColor = picture.getColor();
            this.currentSize = picture.getSize();
            Size size2 = new Size(this.width & this.currentColor.getWidthMask(), this.height & this.currentColor.getHeightMask());
            this.targetSize = size2;
            this.resampler = new LanczosResampler(this.currentSize, size2);
        }
        PixelStore.LoanerPicture picture2 = pixelStore.getPicture(this.targetSize.getWidth(), this.targetSize.getHeight(), this.currentColor);
        this.resampler.resample(picture, picture2.getPicture());
        return picture2;
    }

    @Override // org.jcodec.api.transcode.Filter
    public ColorSpace getInputColor() {
        return ColorSpace.ANY_PLANAR;
    }

    @Override // org.jcodec.api.transcode.Filter
    public ColorSpace getOutputColor() {
        return ColorSpace.SAME;
    }

    public Size getTarget() {
        return new Size(this.width, this.height);
    }
}
