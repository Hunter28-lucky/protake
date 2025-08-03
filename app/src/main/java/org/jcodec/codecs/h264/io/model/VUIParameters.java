package org.jcodec.codecs.h264.io.model;

/* loaded from: classes2.dex */
public class VUIParameters {
    public AspectRatio aspectRatio;
    public boolean aspectRatioInfoPresentFlag;
    public BitstreamRestriction bitstreamRestriction;
    public boolean chromaLocInfoPresentFlag;
    public int chromaSampleLocTypeBottomField;
    public int chromaSampleLocTypeTopField;
    public boolean colourDescriptionPresentFlag;
    public int colourPrimaries;
    public boolean fixedFrameRateFlag;
    public boolean lowDelayHrdFlag;
    public int matrixCoefficients;
    public HRDParameters nalHRDParams;
    public int numUnitsInTick;
    public boolean overscanAppropriateFlag;
    public boolean overscanInfoPresentFlag;
    public boolean picStructPresentFlag;
    public int sarHeight;
    public int sarWidth;
    public int timeScale;
    public boolean timingInfoPresentFlag;
    public int transferCharacteristics;
    public HRDParameters vclHRDParams;
    public int videoFormat;
    public boolean videoFullRangeFlag;
    public boolean videoSignalTypePresentFlag;

    public static class BitstreamRestriction {
        public int log2MaxMvLengthHorizontal;
        public int log2MaxMvLengthVertical;
        public int maxBitsPerMbDenom;
        public int maxBytesPerPicDenom;
        public int maxDecFrameBuffering;
        public boolean motionVectorsOverPicBoundariesFlag;
        public int numReorderFrames;
    }
}
