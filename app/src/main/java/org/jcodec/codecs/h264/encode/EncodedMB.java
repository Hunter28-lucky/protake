package org.jcodec.codecs.h264.encode;

import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class EncodedMB {
    private int qp;
    private MBType type;
    private Picture pixels = Picture.create(16, 16, ColorSpace.YUV420J);
    private int[] nc = new int[16];
    private int[] mx = new int[16];
    private int[] my = new int[16];

    public int[] getMx() {
        return this.mx;
    }

    public int[] getMy() {
        return this.my;
    }

    public int[] getNc() {
        return this.nc;
    }

    public Picture getPixels() {
        return this.pixels;
    }

    public int getQp() {
        return this.qp;
    }

    public MBType getType() {
        return this.type;
    }

    public void setQp(int i) {
        this.qp = i;
    }

    public void setType(MBType mBType) {
        this.type = mBType;
    }
}
