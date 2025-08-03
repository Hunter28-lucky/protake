package org.jcodec.codecs.h264.decode.aso;

/* loaded from: classes2.dex */
public class PrebuiltMBlockMapper implements Mapper {
    private int firstMBInSlice;
    private int groupId;
    private int indexOfFirstMb;
    private MBToSliceGroupMap map;
    private int picWidthInMbs;

    public PrebuiltMBlockMapper(MBToSliceGroupMap mBToSliceGroupMap, int i, int i2) {
        this.map = mBToSliceGroupMap;
        this.firstMBInSlice = i;
        this.groupId = mBToSliceGroupMap.getGroups()[i];
        this.picWidthInMbs = i2;
        this.indexOfFirstMb = mBToSliceGroupMap.getIndices()[i];
    }

    @Override // org.jcodec.codecs.h264.decode.aso.Mapper
    public int getAddress(int i) {
        return this.map.getInverse()[this.groupId][i + this.indexOfFirstMb];
    }

    @Override // org.jcodec.codecs.h264.decode.aso.Mapper
    public int getMbX(int i) {
        return getAddress(i) % this.picWidthInMbs;
    }

    @Override // org.jcodec.codecs.h264.decode.aso.Mapper
    public int getMbY(int i) {
        return getAddress(i) / this.picWidthInMbs;
    }

    @Override // org.jcodec.codecs.h264.decode.aso.Mapper
    public boolean leftAvailable(int i) {
        int i2 = this.map.getInverse()[this.groupId][i + this.indexOfFirstMb];
        int i3 = i2 - 1;
        return i3 >= this.firstMBInSlice && i2 % this.picWidthInMbs != 0 && this.map.getGroups()[i3] == this.groupId;
    }

    @Override // org.jcodec.codecs.h264.decode.aso.Mapper
    public boolean topAvailable(int i) {
        int i2 = this.map.getInverse()[this.groupId][i + this.indexOfFirstMb] - this.picWidthInMbs;
        return i2 >= this.firstMBInSlice && this.map.getGroups()[i2] == this.groupId;
    }

    @Override // org.jcodec.codecs.h264.decode.aso.Mapper
    public boolean topLeftAvailable(int i) {
        int i2 = this.map.getInverse()[this.groupId][i + this.indexOfFirstMb];
        int i3 = this.picWidthInMbs;
        int i4 = (i2 - i3) - 1;
        return i4 >= this.firstMBInSlice && i2 % i3 != 0 && this.map.getGroups()[i4] == this.groupId;
    }

    @Override // org.jcodec.codecs.h264.decode.aso.Mapper
    public boolean topRightAvailable(int i) {
        int i2 = this.map.getInverse()[this.groupId][i + this.indexOfFirstMb];
        int i3 = this.picWidthInMbs;
        int i4 = (i2 - i3) + 1;
        return i4 >= this.firstMBInSlice && (i2 + 1) % i3 != 0 && this.map.getGroups()[i4] == this.groupId;
    }
}
