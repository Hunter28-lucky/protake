package net.sourceforge.jaad.aac.syntax;

import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.Profile;
import net.sourceforge.jaad.aac.SampleFrequency;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class PCE extends Element {
    private static final int MAX_ASSOC_DATA_ELEMENTS = 8;
    private static final int MAX_BACK_CHANNEL_ELEMENTS = 16;
    private static final int MAX_FRONT_CHANNEL_ELEMENTS = 16;
    private static final int MAX_LFE_CHANNEL_ELEMENTS = 4;
    private static final int MAX_SIDE_CHANNEL_ELEMENTS = 16;
    private static final int MAX_VALID_CC_ELEMENTS = 16;
    private int assocDataElementsCount;
    private int backChannelElementsCount;
    private byte[] commentFieldData;
    private int frontChannelElementsCount;
    private int lfeChannelElementsCount;
    private int matrixMixdownIDX;
    private boolean matrixMixdownIDXPresent;
    private boolean monoMixdown;
    private int monoMixdownElementNumber;
    private Profile profile;
    private boolean pseudoSurround;
    private int sideChannelElementsCount;
    private boolean stereoMixdown;
    private int stereoMixdownElementNumber;
    private int validCCElementsCount;
    private final TaggedElement[] frontElements = new TaggedElement[16];
    private final TaggedElement[] sideElements = new TaggedElement[16];
    private final TaggedElement[] backElements = new TaggedElement[16];
    private final int[] lfeElementTags = new int[4];
    private final int[] assocDataElementTags = new int[8];
    private final CCE[] ccElements = new CCE[16];
    private SampleFrequency sampleFrequency = SampleFrequency.SAMPLE_FREQUENCY_NONE;

    public static class CCE {
        private final boolean isIndSW;
        private final int tag;

        public CCE(boolean z, int i) {
            this.isIndSW = z;
            this.tag = i;
        }

        public int getTag() {
            return this.tag;
        }

        public boolean isIsIndSW() {
            return this.isIndSW;
        }
    }

    public static class TaggedElement {
        private final boolean isCPE;
        private final int tag;

        public TaggedElement(boolean z, int i) {
            this.isCPE = z;
            this.tag = i;
        }

        public int getTag() {
            return this.tag;
        }

        public boolean isIsCPE() {
            return this.isCPE;
        }
    }

    private void readTaggedElementArray(TaggedElement[] taggedElementArr, IBitStream iBitStream, int i) throws AACException {
        for (int i2 = 0; i2 < i; i2++) {
            taggedElementArr[i2] = new TaggedElement(iBitStream.readBool(), iBitStream.readBits(4));
        }
    }

    public void decode(IBitStream iBitStream) throws AACException {
        readElementInstanceTag(iBitStream);
        this.profile = Profile.forInt(iBitStream.readBits(2));
        this.sampleFrequency = SampleFrequency.forInt(iBitStream.readBits(4));
        this.frontChannelElementsCount = iBitStream.readBits(4);
        this.sideChannelElementsCount = iBitStream.readBits(4);
        this.backChannelElementsCount = iBitStream.readBits(4);
        this.lfeChannelElementsCount = iBitStream.readBits(2);
        this.assocDataElementsCount = iBitStream.readBits(3);
        this.validCCElementsCount = iBitStream.readBits(4);
        boolean bool = iBitStream.readBool();
        this.monoMixdown = bool;
        if (bool) {
            Logger.warn("mono mixdown present, but not yet supported");
            this.monoMixdownElementNumber = iBitStream.readBits(4);
        }
        boolean bool2 = iBitStream.readBool();
        this.stereoMixdown = bool2;
        if (bool2) {
            Logger.warn("stereo mixdown present, but not yet supported");
            this.stereoMixdownElementNumber = iBitStream.readBits(4);
        }
        boolean bool3 = iBitStream.readBool();
        this.matrixMixdownIDXPresent = bool3;
        if (bool3) {
            Logger.warn("matrix mixdown present, but not yet supported");
            this.matrixMixdownIDX = iBitStream.readBits(2);
            this.pseudoSurround = iBitStream.readBool();
        }
        readTaggedElementArray(this.frontElements, iBitStream, this.frontChannelElementsCount);
        readTaggedElementArray(this.sideElements, iBitStream, this.sideChannelElementsCount);
        readTaggedElementArray(this.backElements, iBitStream, this.backChannelElementsCount);
        for (int i = 0; i < this.lfeChannelElementsCount; i++) {
            this.lfeElementTags[i] = iBitStream.readBits(4);
        }
        for (int i2 = 0; i2 < this.assocDataElementsCount; i2++) {
            this.assocDataElementTags[i2] = iBitStream.readBits(4);
        }
        for (int i3 = 0; i3 < this.validCCElementsCount; i3++) {
            this.ccElements[i3] = new CCE(iBitStream.readBool(), iBitStream.readBits(4));
        }
        iBitStream.byteAlign();
        int bits = iBitStream.readBits(8);
        this.commentFieldData = new byte[bits];
        for (int i4 = 0; i4 < bits; i4++) {
            this.commentFieldData[i4] = (byte) iBitStream.readBits(8);
        }
    }

    public int getChannelCount() {
        return this.frontChannelElementsCount + this.sideChannelElementsCount + this.backChannelElementsCount + this.lfeChannelElementsCount + this.assocDataElementsCount;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public SampleFrequency getSampleFrequency() {
        return this.sampleFrequency;
    }
}
