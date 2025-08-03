package net.sourceforge.jaad.aac.tools;

import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.SampleFrequency;
import net.sourceforge.jaad.aac.syntax.IBitStream;
import net.sourceforge.jaad.aac.syntax.ICSInfo;
import net.sourceforge.jaad.aac.syntax.ICStream;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class ICPrediction {
    private static final float A = 0.953125f;
    private static final float ALPHA = 0.90625f;
    private static final float INV_SF_SCALE = -1024.0f;
    private static final int MAX_PREDICTORS = 672;
    private static final float SF_SCALE = -9.765625E-4f;
    private boolean[] predictionUsed;
    private boolean predictorReset;
    private int predictorResetGroup;
    private C2200[] states = new C2200[MAX_PREDICTORS];

    /* renamed from: net.sourceforge.jaad.aac.tools.ICPrediction$Ԩ, reason: contains not printable characters */
    public static final class C2200 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public float f8064;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public float f8065;

        /* renamed from: ԩ, reason: contains not printable characters */
        public float f8066;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public float f8067;

        /* renamed from: ԫ, reason: contains not printable characters */
        public float f8068;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public float f8069;

        public C2200() {
            this.f8064 = 0.0f;
            this.f8065 = 0.0f;
            this.f8066 = 0.0f;
            this.f8067 = 0.0f;
            this.f8068 = 1.0f;
            this.f8069 = 1.0f;
        }
    }

    public ICPrediction() {
        resetAllPredictors();
    }

    private float even(float f) {
        int iFloatToIntBits = Float.floatToIntBits(f);
        return Float.intBitsToFloat((-65536) & (iFloatToIntBits + 32767 + (iFloatToIntBits & 1)));
    }

    private void predict(float[] fArr, int i, boolean z) {
        C2200[] c2200Arr = this.states;
        if (c2200Arr[i] == null) {
            c2200Arr[i] = new C2200();
        }
        C2200 c2200 = this.states[i];
        float f = c2200.f8068;
        float f2 = c2200.f8069;
        float f3 = c2200.f8064;
        float f4 = c2200.f8065;
        float f5 = c2200.f8066;
        float f6 = c2200.f8067;
        float fEven = f5 > 1.0f ? even(A / f5) * f3 : 0.0f;
        float f7 = fEven * f;
        float fRound = round(((f6 > 1.0f ? f4 * even(A / f6) : 0.0f) * f2) + f7);
        if (z) {
            fArr[i] = fArr[i] + (fRound * SF_SCALE);
        }
        float f8 = fArr[i] * INV_SF_SCALE;
        float f9 = f8 - f7;
        c2200.f8065 = trunc((f4 * ALPHA) + (f2 * f9));
        c2200.f8067 = trunc((f6 * ALPHA) + (((f2 * f2) + (f9 * f9)) * 0.5f));
        c2200.f8064 = trunc((f3 * ALPHA) + (f * f8));
        c2200.f8066 = trunc((f5 * ALPHA) + (((f * f) + (f8 * f8)) * 0.5f));
        c2200.f8069 = trunc((f - (fEven * f8)) * A);
        c2200.f8068 = trunc(f8 * A);
    }

    private void resetAllPredictors() {
        for (int i = 0; i < this.states.length; i++) {
            resetPredictState(i);
        }
    }

    private void resetPredictState(int i) {
        C2200[] c2200Arr = this.states;
        if (c2200Arr[i] == null) {
            c2200Arr[i] = new C2200();
        }
        C2200 c2200 = this.states[i];
        c2200.f8068 = 0.0f;
        c2200.f8069 = 0.0f;
        c2200.f8064 = 0.0f;
        c2200.f8065 = 0.0f;
        c2200.f8066 = 16256.0f;
        c2200.f8067 = 16256.0f;
    }

    private void resetPredictorGroup(int i) {
        for (int i2 = i - 1; i2 < this.states.length; i2 += 30) {
            resetPredictState(i2);
        }
    }

    private float round(float f) {
        return Float.intBitsToFloat((Float.floatToIntBits(f) + 32768) & (-65536));
    }

    private float trunc(float f) {
        return Float.intBitsToFloat(Float.floatToIntBits(f) & (-65536));
    }

    public void decode(IBitStream iBitStream, int i, SampleFrequency sampleFrequency) throws AACException {
        sampleFrequency.getPredictorCount();
        boolean bool = iBitStream.readBool();
        this.predictorReset = bool;
        if (bool) {
            this.predictorResetGroup = iBitStream.readBits(5);
        }
        int maximalPredictionSFB = sampleFrequency.getMaximalPredictionSFB();
        int iMin = Math.min(i, maximalPredictionSFB);
        this.predictionUsed = new boolean[iMin];
        for (int i2 = 0; i2 < iMin; i2++) {
            this.predictionUsed[i2] = iBitStream.readBool();
        }
        Logger.warn("ICPrediction: maxSFB={0}, maxPredSFB={1}", new int[]{i, maximalPredictionSFB});
    }

    public void process(ICStream iCStream, float[] fArr, SampleFrequency sampleFrequency) {
        int i;
        ICSInfo info = iCStream.getInfo();
        if (info.isEightShortFrame()) {
            resetAllPredictors();
            return;
        }
        int iMin = Math.min(sampleFrequency.getMaximalPredictionSFB(), info.getMaxSFB());
        int[] sWBOffsets = info.getSWBOffsets();
        int i2 = 0;
        while (i2 < iMin) {
            int i3 = sWBOffsets[i2];
            while (true) {
                i = i2 + 1;
                if (i3 < sWBOffsets[i]) {
                    predict(fArr, i3, this.predictionUsed[i2]);
                    i3++;
                }
            }
            i2 = i;
        }
        if (this.predictorReset) {
            resetPredictorGroup(this.predictorResetGroup);
        }
    }

    public void setPredictionUnused(int i) {
        this.predictionUsed[i] = false;
    }
}
