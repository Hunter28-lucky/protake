package org.jcodec.codecs.h264.decode;

import java.util.Arrays;
import java.util.Comparator;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.IntObjectMap;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class RefListManager {
    private Frame frameOut;
    private IntObjectMap<Frame> lRefs;
    private int[] numRef;
    private Frame[] sRefs;
    private SliceHeader sh;

    public RefListManager(SliceHeader sliceHeader, Frame[] frameArr, IntObjectMap<Frame> intObjectMap, Frame frame) {
        this.sh = sliceHeader;
        this.sRefs = frameArr;
        this.lRefs = intObjectMap;
        if (sliceHeader.numRefIdxActiveOverrideFlag) {
            int[] iArr = sliceHeader.numRefIdxActiveMinus1;
            this.numRef = new int[]{iArr[0] + 1, iArr[1] + 1};
        } else {
            int[] iArr2 = sliceHeader.pps.numRefIdxActiveMinus1;
            this.numRef = new int[]{iArr2[0] + 1, iArr2[1] + 1};
        }
        this.frameOut = frame;
    }

    private Frame[] buildList(Comparator<Frame> comparator, Comparator<Frame> comparator2) {
        Frame[] frameArr = new Frame[this.sRefs.length + this.lRefs.size()];
        Frame[] frameArrCopySort = copySort(comparator, this.frameOut);
        Frame[] frameArrCopySort2 = copySort(comparator2, this.frameOut);
        int iCount = count(frameArrCopySort);
        int iCount2 = count(frameArrCopySort2);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < iCount) {
            frameArr[i3] = frameArrCopySort[i2];
            i2++;
            i3++;
        }
        int i4 = 0;
        while (i4 < iCount2) {
            frameArr[i3] = frameArrCopySort2[i4];
            i4++;
            i3++;
        }
        int[] iArrKeys = this.lRefs.keys();
        Arrays.sort(iArrKeys);
        while (i < iArrKeys.length) {
            frameArr[i3] = this.lRefs.get(iArrKeys[i]);
            i++;
            i3++;
        }
        return frameArr;
    }

    private Frame[][] buildRefListB() {
        Frame[] frameArrBuildList = buildList(Frame.POCDesc, Frame.POCAsc);
        Frame[] frameArrBuildList2 = buildList(Frame.POCAsc, Frame.POCDesc);
        if (Platform.arrayEqualsObj(frameArrBuildList, frameArrBuildList2) && count(frameArrBuildList2) > 1) {
            Frame frame = frameArrBuildList2[1];
            frameArrBuildList2[1] = frameArrBuildList2[0];
            frameArrBuildList2[0] = frame;
        }
        Frame[][] frameArr = {(Frame[]) Platform.copyOfObj(frameArrBuildList, this.numRef[0]), (Frame[]) Platform.copyOfObj(frameArrBuildList2, this.numRef[1])};
        reorder(frameArr[0], 0);
        reorder(frameArr[1], 1);
        return frameArr;
    }

    private Frame[] buildRefListP() {
        SliceHeader sliceHeader = this.sh;
        int i = sliceHeader.frameNum;
        int i2 = 1 << (sliceHeader.sps.log2MaxFrameNumMinus4 + 4);
        Frame[] frameArr = new Frame[this.numRef[0]];
        int i3 = i - 1;
        int i4 = 0;
        while (i3 >= i - i2 && i4 < this.numRef[0]) {
            Frame frame = this.sRefs[i3 < 0 ? i3 + i2 : i3];
            if (frame != null) {
                if (frame == H264Const.NO_PIC) {
                    frame = null;
                }
                frameArr[i4] = frame;
                i4++;
            }
            i3--;
        }
        int[] iArrKeys = this.lRefs.keys();
        Arrays.sort(iArrKeys);
        int i5 = 0;
        while (i5 < iArrKeys.length && i4 < this.numRef[0]) {
            frameArr[i4] = this.lRefs.get(iArrKeys[i5]);
            i5++;
            i4++;
        }
        reorder(frameArr, 0);
        return frameArr;
    }

    private Frame[] copySort(Comparator<Frame> comparator, Frame frame) {
        Frame[] frameArr = this.sRefs;
        Frame[] frameArr2 = (Frame[]) Platform.copyOfObj(frameArr, frameArr.length);
        for (int i = 0; i < frameArr2.length; i++) {
            if (comparator.compare(frame, frameArr2[i]) > 0) {
                frameArr2[i] = null;
            }
        }
        Arrays.sort(frameArr2, comparator);
        return frameArr2;
    }

    private int count(Frame[] frameArr) {
        for (int i = 0; i < frameArr.length; i++) {
            if (frameArr[i] == null) {
                return i;
            }
        }
        return frameArr.length;
    }

    private void reorder(Picture[] pictureArr, int i) {
        Picture picture;
        SliceHeader sliceHeader = this.sh;
        if (sliceHeader.refPicReordering[i] == null) {
            return;
        }
        int iWrap = sliceHeader.frameNum;
        int i2 = 1 << (sliceHeader.sps.log2MaxFrameNumMinus4 + 4);
        int i3 = 0;
        while (true) {
            int[][] iArr = this.sh.refPicReordering[i];
            int[] iArr2 = iArr[0];
            if (i3 >= iArr2.length) {
                return;
            }
            int i4 = iArr2[i3];
            if (i4 == 0) {
                iWrap = MathUtil.wrap((iWrap - iArr[1][i3]) - 1, i2);
            } else if (i4 == 1) {
                iWrap = MathUtil.wrap(iWrap + iArr[1][i3] + 1, i2);
            } else if (i4 == 2) {
                throw new RuntimeException("long term");
            }
            for (int i5 = this.numRef[i] - 1; i5 > i3; i5--) {
                pictureArr[i5] = pictureArr[i5 - 1];
            }
            pictureArr[i3] = this.sRefs[iWrap];
            i3++;
            int i6 = i3;
            int i7 = i6;
            while (i6 < this.numRef[i] && (picture = pictureArr[i6]) != null) {
                if (picture != this.sRefs[iWrap]) {
                    pictureArr[i7] = picture;
                    i7++;
                }
                i6++;
            }
        }
    }

    public Frame[][] getRefList() {
        SliceType sliceType = this.sh.sliceType;
        Frame[][] frameArrBuildRefListB = null;
        if (sliceType == SliceType.P) {
            frameArrBuildRefListB = new Frame[][]{buildRefListP(), null};
        } else if (sliceType == SliceType.B) {
            frameArrBuildRefListB = buildRefListB();
        }
        MBlockDecoderUtils.debugPrint("------");
        if (frameArrBuildRefListB != null) {
            for (int i = 0; i < 2; i++) {
                if (frameArrBuildRefListB[i] != null) {
                    int i2 = 0;
                    while (true) {
                        Frame[] frameArr = frameArrBuildRefListB[i];
                        if (i2 < frameArr.length) {
                            if (frameArr[i2] != null) {
                                MBlockDecoderUtils.debugPrint("REF[%d][%d]: ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(frameArrBuildRefListB[i][i2].getPOC()));
                            }
                            i2++;
                        }
                    }
                }
            }
        }
        return frameArrBuildRefListB;
    }
}
