package net.sourceforge.jaad.aac.syntax;

import java.util.Arrays;
import net.sourceforge.jaad.aac.AACDecoderConfig;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.Profile;
import net.sourceforge.jaad.aac.SampleFrequency;
import net.sourceforge.jaad.aac.tools.MSMask;

/* loaded from: classes2.dex */
public class CPE extends Element {
    private boolean commonWindow;
    public ICStream icsL;
    public ICStream icsR;
    private MSMask msMask;
    private boolean[] msUsed = new boolean[128];

    public CPE(int i) {
        this.icsL = new ICStream(i);
        this.icsR = new ICStream(i);
    }

    public static MSMask msMaskFromInt(int i) throws AACException {
        MSMask[] mSMaskArrValues = MSMask.values();
        if (i < mSMaskArrValues.length) {
            return mSMaskArrValues[i];
        }
        throw new AACException("unknown MS mask type");
    }

    public void decode(IBitStream iBitStream, AACDecoderConfig aACDecoderConfig) throws AACException {
        Profile profile = aACDecoderConfig.getProfile();
        if (aACDecoderConfig.getSampleFrequency().equals(SampleFrequency.SAMPLE_FREQUENCY_NONE)) {
            throw new AACException("invalid sample frequency");
        }
        readElementInstanceTag(iBitStream);
        this.commonWindow = iBitStream.readBool();
        ICSInfo info = this.icsL.getInfo();
        boolean z = this.commonWindow;
        if (z) {
            info.decode(iBitStream, aACDecoderConfig, z);
            this.icsR.getInfo().setData(info);
            MSMask mSMaskMsMaskFromInt = msMaskFromInt(iBitStream.readBits(2));
            this.msMask = mSMaskMsMaskFromInt;
            if (mSMaskMsMaskFromInt.equals(MSMask.TYPE_USED)) {
                int maxSFB = info.getMaxSFB();
                int windowGroupCount = info.getWindowGroupCount();
                for (int i = 0; i < windowGroupCount * maxSFB; i++) {
                    this.msUsed[i] = iBitStream.readBool();
                }
            } else if (this.msMask.equals(MSMask.TYPE_ALL_1)) {
                Arrays.fill(this.msUsed, true);
            } else {
                if (!this.msMask.equals(MSMask.TYPE_ALL_0)) {
                    throw new AACException("reserved MS mask type used");
                }
                Arrays.fill(this.msUsed, false);
            }
        } else {
            this.msMask = MSMask.TYPE_ALL_0;
            Arrays.fill(this.msUsed, false);
        }
        if (profile.isErrorResilientProfile() && info.isLTPrediction1Present()) {
            boolean bool = iBitStream.readBool();
            info.ltpData2Present = bool;
            if (bool) {
                info.getLTPrediction2().decode(iBitStream, info, profile);
            }
        }
        this.icsL.decode(iBitStream, this.commonWindow, aACDecoderConfig);
        this.icsR.decode(iBitStream, this.commonWindow, aACDecoderConfig);
    }

    public ICStream getLeftChannel() {
        return this.icsL;
    }

    public MSMask getMSMask() {
        return this.msMask;
    }

    public ICStream getRightChannel() {
        return this.icsR;
    }

    public boolean isCommonWindow() {
        return this.commonWindow;
    }

    public boolean isMSMaskPresent() {
        return !this.msMask.equals(MSMask.TYPE_ALL_0);
    }

    public boolean isMSUsed(int i) {
        return this.msUsed[i];
    }
}
