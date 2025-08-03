package org.jcodec.codecs.h264.decode.aso;

import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;

/* loaded from: classes2.dex */
public class MapManager {
    private MBToSliceGroupMap mbToSliceGroupMap;
    private PictureParameterSet pps;
    private int prevSliceGroupChangeCycle;
    private SeqParameterSet sps;

    public MapManager(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet) {
        this.sps = seqParameterSet;
        this.pps = pictureParameterSet;
        this.mbToSliceGroupMap = buildMap(seqParameterSet, pictureParameterSet);
    }

    private MBToSliceGroupMap buildMap(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet) {
        int[] iArrBuildForegroundMap;
        int i = pictureParameterSet.numSliceGroupsMinus1 + 1;
        if (i <= 1) {
            return null;
        }
        int i2 = seqParameterSet.picWidthInMbsMinus1 + 1;
        int picHeightInMbs = SeqParameterSet.getPicHeightInMbs(seqParameterSet);
        int i3 = pictureParameterSet.sliceGroupMapType;
        if (i3 == 0) {
            int[] iArr = new int[i];
            for (int i4 = 0; i4 < i; i4++) {
                iArr[i4] = pictureParameterSet.runLengthMinus1[i4] + 1;
            }
            iArrBuildForegroundMap = SliceGroupMapBuilder.buildInterleavedMap(i2, picHeightInMbs, iArr);
        } else if (i3 == 1) {
            iArrBuildForegroundMap = SliceGroupMapBuilder.buildDispersedMap(i2, picHeightInMbs, i);
        } else if (i3 == 2) {
            iArrBuildForegroundMap = SliceGroupMapBuilder.buildForegroundMap(i2, picHeightInMbs, i, pictureParameterSet.topLeft, pictureParameterSet.bottomRight);
        } else {
            if (i3 >= 3 && i3 <= 5) {
                return null;
            }
            if (i3 != 6) {
                throw new RuntimeException("Unsupported slice group map type");
            }
            iArrBuildForegroundMap = pictureParameterSet.sliceGroupId;
        }
        return buildMapIndices(iArrBuildForegroundMap, i);
    }

    private MBToSliceGroupMap buildMapIndices(int[] iArr, int i) {
        int[] iArr2 = new int[i];
        int[] iArr3 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            int i4 = iArr2[i3];
            iArr2[i3] = i4 + 1;
            iArr3[i2] = i4;
        }
        int[][] iArr4 = new int[i][];
        for (int i5 = 0; i5 < i; i5++) {
            iArr4[i5] = new int[iArr2[i5]];
        }
        int[] iArr5 = new int[i];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            int i7 = iArr[i6];
            int[] iArr6 = iArr4[i7];
            int i8 = iArr5[i7];
            iArr5[i7] = i8 + 1;
            iArr6[i8] = i6;
        }
        return new MBToSliceGroupMap(iArr, iArr3, iArr4);
    }

    private void updateMap(SliceHeader sliceHeader) {
        PictureParameterSet pictureParameterSet = this.pps;
        int i = pictureParameterSet.sliceGroupMapType;
        int i2 = pictureParameterSet.numSliceGroupsMinus1 + 1;
        if (i2 <= 1 || i < 3 || i > 5) {
            return;
        }
        int i3 = sliceHeader.sliceGroupChangeCycle;
        if (i3 != this.prevSliceGroupChangeCycle || this.mbToSliceGroupMap == null) {
            this.prevSliceGroupChangeCycle = i3;
            SeqParameterSet seqParameterSet = this.sps;
            int i4 = seqParameterSet.picWidthInMbsMinus1 + 1;
            int picHeightInMbs = SeqParameterSet.getPicHeightInMbs(seqParameterSet);
            int i5 = i4 * picHeightInMbs;
            int i6 = sliceHeader.sliceGroupChangeCycle;
            PictureParameterSet pictureParameterSet2 = this.pps;
            int i7 = i6 * (pictureParameterSet2.sliceGroupChangeRateMinus1 + 1);
            if (i7 > i5) {
                i7 = i5;
            }
            boolean z = pictureParameterSet2.sliceGroupChangeDirectionFlag;
            int i8 = z ? i5 - i7 : i7;
            this.mbToSliceGroupMap = buildMapIndices(i == 3 ? SliceGroupMapBuilder.buildBoxOutMap(i4, picHeightInMbs, z, i7) : i == 4 ? SliceGroupMapBuilder.buildRasterScanMap(i4, picHeightInMbs, i8, z) : SliceGroupMapBuilder.buildWipeMap(i4, picHeightInMbs, i8, z), i2);
        }
    }

    public Mapper getMapper(SliceHeader sliceHeader) {
        updateMap(sliceHeader);
        int i = sliceHeader.firstMbInSlice;
        return this.pps.numSliceGroupsMinus1 > 0 ? new PrebuiltMBlockMapper(this.mbToSliceGroupMap, i, this.sps.picWidthInMbsMinus1 + 1) : new FlatMBlockMapper(this.sps.picWidthInMbsMinus1 + 1, i);
    }
}
