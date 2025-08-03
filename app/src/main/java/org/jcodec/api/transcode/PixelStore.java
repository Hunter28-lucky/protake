package org.jcodec.api.transcode;

import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public interface PixelStore {

    public static class LoanerPicture {
        private Picture picture;
        private int refCnt;

        public LoanerPicture(Picture picture, int i) {
            this.picture = picture;
            this.refCnt = i;
        }

        public void decRefCnt() {
            this.refCnt--;
        }

        public Picture getPicture() {
            return this.picture;
        }

        public int getRefCnt() {
            return this.refCnt;
        }

        public void incRefCnt() {
            this.refCnt++;
        }

        public boolean unused() {
            return this.refCnt <= 0;
        }
    }

    LoanerPicture getPicture(int i, int i2, ColorSpace colorSpace);

    void putBack(LoanerPicture loanerPicture);

    void retake(LoanerPicture loanerPicture);
}
