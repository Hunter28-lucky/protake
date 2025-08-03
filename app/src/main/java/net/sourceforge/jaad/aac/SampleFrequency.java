package net.sourceforge.jaad.aac;

import com.uc.crashsdk.export.LogType;

/* loaded from: classes2.dex */
public final class SampleFrequency {
    public static final SampleFrequency SAMPLE_FREQUENCY_11025;
    public static final SampleFrequency SAMPLE_FREQUENCY_12000;
    public static final SampleFrequency SAMPLE_FREQUENCY_16000;
    public static final SampleFrequency SAMPLE_FREQUENCY_22050;
    public static final SampleFrequency SAMPLE_FREQUENCY_24000;
    public static final SampleFrequency SAMPLE_FREQUENCY_32000;
    public static final SampleFrequency SAMPLE_FREQUENCY_44100;
    public static final SampleFrequency SAMPLE_FREQUENCY_48000;
    public static final SampleFrequency SAMPLE_FREQUENCY_64000;
    public static final SampleFrequency SAMPLE_FREQUENCY_8000;
    public static final SampleFrequency SAMPLE_FREQUENCY_88200;
    public static final SampleFrequency SAMPLE_FREQUENCY_96000;
    public static final SampleFrequency SAMPLE_FREQUENCY_NONE;
    private static final SampleFrequency[] _values;
    private final int frequency;
    private final int index;
    private final int[] maxTNS_SFB;
    private final int[] prediction;

    static {
        SampleFrequency sampleFrequency = new SampleFrequency(0, 96000, new int[]{33, 512}, new int[]{31, 9});
        SAMPLE_FREQUENCY_96000 = sampleFrequency;
        SampleFrequency sampleFrequency2 = new SampleFrequency(1, 88200, new int[]{33, 512}, new int[]{31, 9});
        SAMPLE_FREQUENCY_88200 = sampleFrequency2;
        SampleFrequency sampleFrequency3 = new SampleFrequency(2, 64000, new int[]{38, 664}, new int[]{34, 10});
        SAMPLE_FREQUENCY_64000 = sampleFrequency3;
        SampleFrequency sampleFrequency4 = new SampleFrequency(3, 48000, new int[]{40, 672}, new int[]{40, 14});
        SAMPLE_FREQUENCY_48000 = sampleFrequency4;
        SampleFrequency sampleFrequency5 = new SampleFrequency(4, 44100, new int[]{40, 672}, new int[]{42, 14});
        SAMPLE_FREQUENCY_44100 = sampleFrequency5;
        SampleFrequency sampleFrequency6 = new SampleFrequency(5, LogType.UNEXP_KNOWN_REASON, new int[]{40, 672}, new int[]{51, 14});
        SAMPLE_FREQUENCY_32000 = sampleFrequency6;
        SampleFrequency sampleFrequency7 = new SampleFrequency(6, 24000, new int[]{41, 652}, new int[]{46, 14});
        SAMPLE_FREQUENCY_24000 = sampleFrequency7;
        SampleFrequency sampleFrequency8 = new SampleFrequency(7, 22050, new int[]{41, 652}, new int[]{46, 14});
        SAMPLE_FREQUENCY_22050 = sampleFrequency8;
        SampleFrequency sampleFrequency9 = new SampleFrequency(8, 16000, new int[]{37, 664}, new int[]{42, 14});
        SAMPLE_FREQUENCY_16000 = sampleFrequency9;
        SampleFrequency sampleFrequency10 = new SampleFrequency(9, 12000, new int[]{37, 664}, new int[]{42, 14});
        SAMPLE_FREQUENCY_12000 = sampleFrequency10;
        SampleFrequency sampleFrequency11 = new SampleFrequency(10, 11025, new int[]{37, 664}, new int[]{42, 14});
        SAMPLE_FREQUENCY_11025 = sampleFrequency11;
        SampleFrequency sampleFrequency12 = new SampleFrequency(11, 8000, new int[]{34, 664}, new int[]{39, 14});
        SAMPLE_FREQUENCY_8000 = sampleFrequency12;
        SampleFrequency sampleFrequency13 = new SampleFrequency(-1, 0, new int[]{0, 0}, new int[]{0, 0});
        SAMPLE_FREQUENCY_NONE = sampleFrequency13;
        _values = new SampleFrequency[]{sampleFrequency, sampleFrequency2, sampleFrequency3, sampleFrequency4, sampleFrequency5, sampleFrequency6, sampleFrequency7, sampleFrequency8, sampleFrequency9, sampleFrequency10, sampleFrequency11, sampleFrequency12, sampleFrequency13};
    }

    private SampleFrequency(int i, int i2, int[] iArr, int[] iArr2) {
        this.index = i;
        this.frequency = i2;
        this.prediction = iArr;
        this.maxTNS_SFB = iArr2;
    }

    public static SampleFrequency forFrequency(int i) {
        SampleFrequency[] sampleFrequencyArrValues = values();
        SampleFrequency sampleFrequency = null;
        for (int i2 = 0; sampleFrequency == null && i2 < 12; i2++) {
            SampleFrequency sampleFrequency2 = sampleFrequencyArrValues[i2];
            if (i == sampleFrequency2.frequency) {
                sampleFrequency = sampleFrequency2;
            }
        }
        return sampleFrequency == null ? SAMPLE_FREQUENCY_NONE : sampleFrequency;
    }

    public static SampleFrequency forInt(int i) {
        return (i < 0 || i >= 12) ? SAMPLE_FREQUENCY_NONE : values()[i];
    }

    public static SampleFrequency[] values() {
        return _values;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public int getIndex() {
        return this.index;
    }

    public int getMaximalPredictionSFB() {
        return this.prediction[0];
    }

    public int getMaximalTNS_SFB(boolean z) {
        return this.maxTNS_SFB[z ? 1 : 0];
    }

    public int getPredictorCount() {
        return this.prediction[1];
    }

    public String toString() {
        return Integer.toString(this.frequency);
    }
}
