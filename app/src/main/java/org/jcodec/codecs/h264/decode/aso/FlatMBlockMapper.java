package org.jcodec.codecs.h264.decode.aso;

/* loaded from: classes2.dex */
public class FlatMBlockMapper implements Mapper {
    private int firstMBAddr;
    private int frameWidthInMbs;

    public FlatMBlockMapper(int i, int i2) {
        this.frameWidthInMbs = i;
        this.firstMBAddr = i2;
    }

    @Override // org.jcodec.codecs.h264.decode.aso.Mapper
    public int getAddress(int i) {
        return this.firstMBAddr + i;
    }

    @Override // org.jcodec.codecs.h264.decode.aso.Mapper
    public int getMbX(int i) {
        return getAddress(i) % this.frameWidthInMbs;
    }

    @Override // org.jcodec.codecs.h264.decode.aso.Mapper
    public int getMbY(int i) {
        return getAddress(i) / this.frameWidthInMbs;
    }

    @Override // org.jcodec.codecs.h264.decode.aso.Mapper
    public boolean leftAvailable(int i) {
        int i2 = this.firstMBAddr;
        int i3 = i + i2;
        return !(i3 % this.frameWidthInMbs == 0) && i3 > i2;
    }

    @Override // org.jcodec.codecs.h264.decode.aso.Mapper
    public boolean topAvailable(int i) {
        int i2 = this.firstMBAddr;
        return (i + i2) - this.frameWidthInMbs >= i2;
    }

    @Override // org.jcodec.codecs.h264.decode.aso.Mapper
    public boolean topLeftAvailable(int i) {
        int i2 = this.firstMBAddr;
        int i3 = i + i2;
        int i4 = this.frameWidthInMbs;
        return !(i3 % i4 == 0) && (i3 - i4) - 1 >= i2;
    }

    @Override // org.jcodec.codecs.h264.decode.aso.Mapper
    public boolean topRightAvailable(int i) {
        int i2 = this.firstMBAddr;
        int i3 = i + i2;
        int i4 = this.frameWidthInMbs;
        return !((i3 + 1) % i4 == 0) && (i3 - i4) + 1 >= i2;
    }
}
