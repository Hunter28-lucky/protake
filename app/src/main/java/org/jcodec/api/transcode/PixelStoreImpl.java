package org.jcodec.api.transcode;

import java.util.ArrayList;
import java.util.List;
import org.jcodec.api.transcode.PixelStore;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class PixelStoreImpl implements PixelStore {
    private List<Picture> buffers = new ArrayList();

    @Override // org.jcodec.api.transcode.PixelStore
    public PixelStore.LoanerPicture getPicture(int i, int i2, ColorSpace colorSpace) {
        for (Picture picture : this.buffers) {
            if (picture.getWidth() == i && picture.getHeight() == i2 && picture.getColor() == colorSpace) {
                this.buffers.remove(picture);
                return new PixelStore.LoanerPicture(picture, 1);
            }
        }
        return new PixelStore.LoanerPicture(Picture.create(i, i2, colorSpace), 1);
    }

    @Override // org.jcodec.api.transcode.PixelStore
    public void putBack(PixelStore.LoanerPicture loanerPicture) {
        loanerPicture.decRefCnt();
        if (loanerPicture.unused()) {
            Picture picture = loanerPicture.getPicture();
            picture.setCrop(null);
            this.buffers.add(picture);
        }
    }

    @Override // org.jcodec.api.transcode.PixelStore
    public void retake(PixelStore.LoanerPicture loanerPicture) {
        loanerPicture.incRefCnt();
    }
}
