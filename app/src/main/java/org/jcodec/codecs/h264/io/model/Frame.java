package org.jcodec.codecs.h264.io.model;

import java.util.Comparator;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;

/* loaded from: classes2.dex */
public class Frame extends Picture {
    public static Comparator<Frame> POCAsc = new Comparator<Frame>() { // from class: org.jcodec.codecs.h264.io.model.Frame.1
        @Override // java.util.Comparator
        public int compare(Frame frame, Frame frame2) {
            if (frame == null && frame2 == null) {
                return 0;
            }
            if (frame == null) {
                return 1;
            }
            if (frame2 == null) {
                return -1;
            }
            if (frame.poc > frame2.poc) {
                return 1;
            }
            return frame.poc == frame2.poc ? 0 : -1;
        }
    };
    public static Comparator<Frame> POCDesc = new Comparator<Frame>() { // from class: org.jcodec.codecs.h264.io.model.Frame.2
        @Override // java.util.Comparator
        public int compare(Frame frame, Frame frame2) {
            if (frame == null && frame2 == null) {
                return 0;
            }
            if (frame == null) {
                return 1;
            }
            if (frame2 == null) {
                return -1;
            }
            if (frame.poc < frame2.poc) {
                return 1;
            }
            return frame.poc == frame2.poc ? 0 : -1;
        }
    };
    private int frameNo;
    private SliceType frameType;
    private H264Utils.MvList2D mvs;
    private int poc;
    private Frame[][][] refsUsed;
    private boolean shortTerm;

    public Frame(int i, int i2, byte[][] bArr, ColorSpace colorSpace, Rect rect, int i3, SliceType sliceType, H264Utils.MvList2D mvList2D, Frame[][][] frameArr, int i4) {
        super(i, i2, bArr, null, colorSpace, 0, rect);
        this.frameNo = i3;
        this.mvs = mvList2D;
        this.refsUsed = frameArr;
        this.poc = i4;
        this.shortTerm = true;
    }

    public static Frame createFrame(Frame frame) {
        Picture pictureCreateCompatible = frame.createCompatible();
        return new Frame(pictureCreateCompatible.getWidth(), pictureCreateCompatible.getHeight(), pictureCreateCompatible.getData(), pictureCreateCompatible.getColor(), frame.getCrop(), frame.frameNo, frame.frameType, frame.mvs, frame.refsUsed, frame.poc);
    }

    public void copyFromFrame(Frame frame) {
        super.copyFrom(frame);
        this.frameNo = frame.frameNo;
        this.mvs = frame.mvs;
        this.shortTerm = frame.shortTerm;
        this.refsUsed = frame.refsUsed;
        this.poc = frame.poc;
    }

    public int getFrameNo() {
        return this.frameNo;
    }

    public SliceType getFrameType() {
        return this.frameType;
    }

    public H264Utils.MvList2D getMvs() {
        return this.mvs;
    }

    public int getPOC() {
        return this.poc;
    }

    public Frame[][][] getRefsUsed() {
        return this.refsUsed;
    }

    public boolean isShortTerm() {
        return this.shortTerm;
    }

    public void setShortTerm(boolean z) {
        this.shortTerm = z;
    }

    @Override // org.jcodec.common.model.Picture
    public Frame cloneCropped() {
        if (cropNeeded()) {
            return cropped();
        }
        Frame frameCreateFrame = createFrame(this);
        frameCreateFrame.copyFrom(this);
        return frameCreateFrame;
    }

    @Override // org.jcodec.common.model.Picture
    public Frame cropped() {
        Picture pictureCropped = super.cropped();
        return new Frame(pictureCropped.getWidth(), pictureCropped.getHeight(), pictureCropped.getData(), pictureCropped.getColor(), null, this.frameNo, this.frameType, this.mvs, this.refsUsed, this.poc);
    }
}
