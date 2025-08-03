package net.sourceforge.jaad.aac.syntax;

import defpackage.InterfaceC4231;
import net.sourceforge.jaad.aac.AACDecoderConfig;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.Profile;
import net.sourceforge.jaad.aac.SampleFrequency;
import net.sourceforge.jaad.aac.filterbank.FilterBank;
import net.sourceforge.jaad.aac.tools.ICPrediction;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class ICSInfo implements SyntaxConstants, InterfaceC4231 {
    public static final int CURRENT = 1;
    public static final int PREVIOUS = 0;
    public static final int WINDOW_SHAPE_KAISER = 1;
    public static final int WINDOW_SHAPE_SINE = 0;
    private final int frameLength;
    private ICPrediction icPredict;
    private LTPrediction ltPredict1;
    private LTPrediction ltPredict2;
    private int maxSFB;
    private boolean predictionDataPresent;
    private int swbCount;
    private int[] swbOffsets;
    private int windowCount;
    private int windowGroupCount;
    private int[] windowShape = new int[2];
    private WindowSequence windowSequence = WindowSequence.ONLY_LONG_SEQUENCE;
    private int[] windowGroupLength = new int[8];
    public boolean ltpData1Present = false;
    public boolean ltpData2Present = false;

    public static class LTPrediction implements SyntaxConstants {
        private static final float[] CODEBOOK = {0.570829f, 0.696616f, 0.813004f, 0.911304f, 0.9849f, 1.067894f, 1.194601f, 1.369533f};
        private int coef;
        private final int frameLength;
        private int lag;
        private boolean lagUpdate;
        private int lastBand;
        private boolean[] longUsed;
        private int[] shortLag;
        private boolean[] shortLagPresent;
        private boolean[] shortUsed;
        private final int[] states;

        public LTPrediction(int i) {
            this.frameLength = i;
            this.states = new int[i * 4];
        }

        public static boolean isLTPProfile(Profile profile) {
            return profile.equals(Profile.AAC_LTP) || profile.equals(Profile.ER_AAC_LTP) || profile.equals(Profile.AAC_LD);
        }

        public void copy(LTPrediction lTPrediction) {
            int[] iArr = lTPrediction.states;
            int[] iArr2 = this.states;
            System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
            this.coef = lTPrediction.coef;
            this.lag = lTPrediction.lag;
            this.lastBand = lTPrediction.lastBand;
            this.lagUpdate = lTPrediction.lagUpdate;
            boolean[] zArr = lTPrediction.shortUsed;
            this.shortUsed = Platform.copyOfBool(zArr, zArr.length);
            boolean[] zArr2 = lTPrediction.shortLagPresent;
            this.shortLagPresent = Platform.copyOfBool(zArr2, zArr2.length);
            int[] iArr3 = lTPrediction.shortLag;
            this.shortLag = Platform.copyOfInt(iArr3, iArr3.length);
            boolean[] zArr3 = lTPrediction.longUsed;
            this.longUsed = Platform.copyOfBool(zArr3, zArr3.length);
        }

        public void decode(IBitStream iBitStream, ICSInfo iCSInfo, Profile profile) throws AACException {
            int i = 0;
            this.lag = 0;
            if (profile.equals(Profile.AAC_LD)) {
                boolean bool = iBitStream.readBool();
                this.lagUpdate = bool;
                if (bool) {
                    this.lag = iBitStream.readBits(10);
                }
            } else {
                this.lag = iBitStream.readBits(11);
            }
            if (this.lag > (this.frameLength << 1)) {
                throw new AACException("LTP lag too large: " + this.lag);
            }
            this.coef = iBitStream.readBits(3);
            int windowCount = iCSInfo.getWindowCount();
            if (!iCSInfo.isEightShortFrame()) {
                int iMin = Math.min(iCSInfo.getMaxSFB(), 40);
                this.lastBand = iMin;
                this.longUsed = new boolean[iMin];
                while (i < this.lastBand) {
                    this.longUsed[i] = iBitStream.readBool();
                    i++;
                }
                return;
            }
            this.shortUsed = new boolean[windowCount];
            this.shortLagPresent = new boolean[windowCount];
            this.shortLag = new int[windowCount];
            while (i < windowCount) {
                boolean[] zArr = this.shortUsed;
                boolean bool2 = iBitStream.readBool();
                zArr[i] = bool2;
                if (bool2) {
                    this.shortLagPresent[i] = iBitStream.readBool();
                    if (this.shortLagPresent[i]) {
                        this.shortLag[i] = iBitStream.readBits(4);
                    }
                }
                i++;
            }
        }

        public void process(ICStream iCStream, float[] fArr, FilterBank filterBank, SampleFrequency sampleFrequency) {
            ICSInfo info = iCStream.getInfo();
            if (info.isEightShortFrame()) {
                return;
            }
            int i = this.frameLength << 1;
            float[] fArr2 = new float[2048];
            float[] fArr3 = new float[2048];
            for (int i2 = 0; i2 < i; i2++) {
                fArr2[i2] = this.states[(i + i2) - this.lag] * CODEBOOK[this.coef];
            }
            filterBank.processLTP(info.getWindowSequence(), info.getWindowShape(1), info.getWindowShape(0), fArr2, fArr3);
            if (iCStream.isTNSDataPresent()) {
                iCStream.getTNS().process(iCStream, fArr3, sampleFrequency, true);
            }
            int[] sWBOffsets = info.getSWBOffsets();
            int sWBOffsetMax = info.getSWBOffsetMax();
            for (int i3 = 0; i3 < this.lastBand; i3++) {
                if (this.longUsed[i3]) {
                    int iMin = Math.min(sWBOffsets[i3 + 1], sWBOffsetMax);
                    for (int i4 = sWBOffsets[i3]; i4 < iMin; i4++) {
                        fArr[i4] = fArr[i4] + fArr3[i4];
                    }
                }
            }
        }

        public void setPredictionUnused(int i) {
            boolean[] zArr = this.longUsed;
            if (zArr != null) {
                zArr[i] = false;
            }
        }

        public void updateState(float[] fArr, float[] fArr2, Profile profile) {
            int i = 0;
            if (profile.equals(Profile.AAC_LD)) {
                while (true) {
                    int i2 = this.frameLength;
                    if (i >= i2) {
                        return;
                    }
                    int[] iArr = this.states;
                    iArr[i] = iArr[i + i2];
                    iArr[i2 + i] = iArr[(i2 * 2) + i];
                    iArr[(i2 * 2) + i] = Math.round(fArr[i]);
                    this.states[(this.frameLength * 3) + i] = Math.round(fArr2[i]);
                    i++;
                }
            } else {
                while (true) {
                    int i3 = this.frameLength;
                    if (i >= i3) {
                        return;
                    }
                    int[] iArr2 = this.states;
                    iArr2[i] = iArr2[i + i3];
                    iArr2[i3 + i] = Math.round(fArr[i]);
                    this.states[(this.frameLength * 2) + i] = Math.round(fArr2[i]);
                    i++;
                }
            }
        }
    }

    public enum WindowSequence {
        ONLY_LONG_SEQUENCE,
        LONG_START_SEQUENCE,
        EIGHT_SHORT_SEQUENCE,
        LONG_STOP_SEQUENCE
    }

    public ICSInfo(int i) {
        this.frameLength = i;
    }

    private void readPredictionData(IBitStream iBitStream, Profile profile, SampleFrequency sampleFrequency, boolean z) throws AACException {
        if (Profile.AAC_MAIN == profile) {
            if (this.icPredict == null) {
                this.icPredict = new ICPrediction();
            }
            this.icPredict.decode(iBitStream, this.maxSFB, sampleFrequency);
            return;
        }
        if (Profile.AAC_LTP != profile) {
            if (Profile.ER_AAC_LTP != profile) {
                throw new AACException("unexpected profile for LTP: " + profile);
            }
            if (z) {
                return;
            }
            boolean bool = iBitStream.readBool();
            this.ltpData1Present = bool;
            if (bool) {
                if (this.ltPredict1 == null) {
                    this.ltPredict1 = new LTPrediction(this.frameLength);
                }
                this.ltPredict1.decode(iBitStream, this, profile);
                return;
            }
            return;
        }
        boolean bool2 = iBitStream.readBool();
        this.ltpData1Present = bool2;
        if (bool2) {
            if (this.ltPredict1 == null) {
                this.ltPredict1 = new LTPrediction(this.frameLength);
            }
            this.ltPredict1.decode(iBitStream, this, profile);
        }
        if (z) {
            boolean bool3 = iBitStream.readBool();
            this.ltpData2Present = bool3;
            if (bool3) {
                if (this.ltPredict2 == null) {
                    this.ltPredict2 = new LTPrediction(this.frameLength);
                }
                this.ltPredict2.decode(iBitStream, this, profile);
            }
        }
    }

    public static WindowSequence windowSequenceFromInt(int i) throws AACException {
        WindowSequence[] windowSequenceArrValues = WindowSequence.values();
        if (i < windowSequenceArrValues.length) {
            return windowSequenceArrValues[i];
        }
        throw new AACException("unknown window sequence type");
    }

    public void decode(IBitStream iBitStream, AACDecoderConfig aACDecoderConfig, boolean z) throws AACException {
        SampleFrequency sampleFrequency = aACDecoderConfig.getSampleFrequency();
        if (sampleFrequency.equals(SampleFrequency.SAMPLE_FREQUENCY_NONE)) {
            throw new AACException("invalid sample frequency");
        }
        iBitStream.skipBit();
        this.windowSequence = windowSequenceFromInt(iBitStream.readBits(2));
        int[] iArr = this.windowShape;
        iArr[0] = iArr[1];
        iArr[1] = iBitStream.readBit();
        this.windowGroupCount = 1;
        this.windowGroupLength[0] = 1;
        if (!this.windowSequence.equals(WindowSequence.EIGHT_SHORT_SEQUENCE)) {
            this.maxSFB = iBitStream.readBits(6);
            this.windowCount = 1;
            this.swbOffsets = InterfaceC4231.f14549[sampleFrequency.getIndex()];
            this.swbCount = InterfaceC4231.f14541[sampleFrequency.getIndex()];
            boolean bool = iBitStream.readBool();
            this.predictionDataPresent = bool;
            if (bool) {
                readPredictionData(iBitStream, aACDecoderConfig.getProfile(), sampleFrequency, z);
                return;
            }
            return;
        }
        this.maxSFB = iBitStream.readBits(4);
        for (int i = 0; i < 7; i++) {
            if (iBitStream.readBool()) {
                int[] iArr2 = this.windowGroupLength;
                int i2 = this.windowGroupCount - 1;
                iArr2[i2] = iArr2[i2] + 1;
            } else {
                int i3 = this.windowGroupCount + 1;
                this.windowGroupCount = i3;
                this.windowGroupLength[i3 - 1] = 1;
            }
        }
        this.windowCount = 8;
        this.swbOffsets = InterfaceC4231.f14557[sampleFrequency.getIndex()];
        this.swbCount = InterfaceC4231.f14550[sampleFrequency.getIndex()];
        this.predictionDataPresent = false;
    }

    public ICPrediction getICPrediction() {
        return this.icPredict;
    }

    public LTPrediction getLTPrediction1() {
        return this.ltPredict1;
    }

    public LTPrediction getLTPrediction2() {
        return this.ltPredict2;
    }

    public int getMaxSFB() {
        return this.maxSFB;
    }

    public int getSWBCount() {
        return this.swbCount;
    }

    public int getSWBOffsetMax() {
        return this.swbOffsets[this.swbCount];
    }

    public int[] getSWBOffsets() {
        return this.swbOffsets;
    }

    public int getWindowCount() {
        return this.windowCount;
    }

    public int getWindowGroupCount() {
        return this.windowGroupCount;
    }

    public int getWindowGroupLength(int i) {
        return this.windowGroupLength[i];
    }

    public WindowSequence getWindowSequence() {
        return this.windowSequence;
    }

    public int getWindowShape(int i) {
        return this.windowShape[i];
    }

    public boolean isEightShortFrame() {
        return this.windowSequence.equals(WindowSequence.EIGHT_SHORT_SEQUENCE);
    }

    public boolean isICPredictionPresent() {
        return this.predictionDataPresent;
    }

    public boolean isLTPrediction1Present() {
        return this.ltpData1Present;
    }

    public boolean isLTPrediction2Present() {
        return this.ltpData2Present;
    }

    public void setData(ICSInfo iCSInfo) {
        this.windowSequence = WindowSequence.valueOf(iCSInfo.windowSequence.name());
        int[] iArr = this.windowShape;
        iArr[0] = iArr[1];
        iArr[1] = iCSInfo.windowShape[1];
        this.maxSFB = iCSInfo.maxSFB;
        boolean z = iCSInfo.predictionDataPresent;
        this.predictionDataPresent = z;
        if (z) {
            this.icPredict = iCSInfo.icPredict;
        }
        boolean z2 = iCSInfo.ltpData1Present;
        this.ltpData1Present = z2;
        if (z2) {
            this.ltPredict1.copy(iCSInfo.ltPredict1);
            this.ltPredict2.copy(iCSInfo.ltPredict2);
        }
        this.windowCount = iCSInfo.windowCount;
        this.windowGroupCount = iCSInfo.windowGroupCount;
        int[] iArr2 = iCSInfo.windowGroupLength;
        this.windowGroupLength = Platform.copyOfInt(iArr2, iArr2.length);
        this.swbCount = iCSInfo.swbCount;
        int[] iArr3 = iCSInfo.swbOffsets;
        this.swbOffsets = Platform.copyOfInt(iArr3, iArr3.length);
    }

    public void unsetPredictionSFB(int i) {
        if (this.predictionDataPresent) {
            this.icPredict.setPredictionUnused(i);
        }
        if (this.ltpData1Present) {
            this.ltPredict1.setPredictionUnused(i);
        }
        if (this.ltpData2Present) {
            this.ltPredict2.setPredictionUnused(i);
        }
    }
}
