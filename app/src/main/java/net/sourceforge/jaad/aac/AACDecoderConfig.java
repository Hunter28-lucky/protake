package net.sourceforge.jaad.aac;

import net.sourceforge.jaad.aac.syntax.BitStream;
import net.sourceforge.jaad.aac.syntax.IBitStream;
import net.sourceforge.jaad.aac.syntax.PCE;
import net.sourceforge.jaad.aac.syntax.SyntaxConstants;

/* loaded from: classes2.dex */
public class AACDecoderConfig implements SyntaxConstants {
    private int coreCoderDelay;
    private boolean dependsOnCoreCoder;
    private boolean extensionFlag;
    private Profile profile = Profile.AAC_MAIN;
    private Profile extProfile = Profile.UNKNOWN;
    private SampleFrequency sampleFrequency = SampleFrequency.SAMPLE_FREQUENCY_NONE;
    private ChannelConfiguration channelConfiguration = ChannelConfiguration.CHANNEL_CONFIG_UNSUPPORTED;
    private boolean frameLengthFlag = false;
    private boolean sbrPresent = false;
    private boolean downSampledSBR = false;
    private boolean sbrEnabled = true;
    private boolean sectionDataResilience = false;
    private boolean scalefactorResilience = false;
    private boolean spectralDataResilience = false;

    private AACDecoderConfig() {
    }

    public static AACDecoderConfig parseMP4DecoderSpecificInfo(byte[] bArr) throws AACException {
        BitStream bitStreamCreateBitStream = BitStream.createBitStream(bArr);
        AACDecoderConfig aACDecoderConfig = new AACDecoderConfig();
        try {
            aACDecoderConfig.profile = readProfile(bitStreamCreateBitStream);
            int bits = bitStreamCreateBitStream.readBits(4);
            if (bits == 15) {
                aACDecoderConfig.sampleFrequency = SampleFrequency.forFrequency(bitStreamCreateBitStream.readBits(24));
            } else {
                aACDecoderConfig.sampleFrequency = SampleFrequency.forInt(bits);
            }
            aACDecoderConfig.channelConfiguration = ChannelConfiguration.forInt(bitStreamCreateBitStream.readBits(4));
            Profile profile = aACDecoderConfig.profile;
            if (Profile.AAC_SBR == profile) {
                aACDecoderConfig.extProfile = profile;
                aACDecoderConfig.sbrPresent = true;
                int bits2 = bitStreamCreateBitStream.readBits(4);
                aACDecoderConfig.downSampledSBR = aACDecoderConfig.sampleFrequency.getIndex() == bits2;
                aACDecoderConfig.sampleFrequency = SampleFrequency.forInt(bits2);
                aACDecoderConfig.profile = readProfile(bitStreamCreateBitStream);
            } else {
                if (Profile.AAC_MAIN != profile && Profile.AAC_LC != profile && Profile.AAC_SSR != profile && Profile.AAC_LTP != profile && Profile.ER_AAC_LC != profile && Profile.ER_AAC_LTP != profile && Profile.ER_AAC_LD != profile) {
                    throw new AACException("profile not supported: " + profile.getIndex());
                }
                boolean bool = bitStreamCreateBitStream.readBool();
                aACDecoderConfig.frameLengthFlag = bool;
                if (bool) {
                    throw new AACException("config uses 960-sample frames, not yet supported");
                }
                boolean bool2 = bitStreamCreateBitStream.readBool();
                aACDecoderConfig.dependsOnCoreCoder = bool2;
                if (bool2) {
                    aACDecoderConfig.coreCoderDelay = bitStreamCreateBitStream.readBits(14);
                } else {
                    aACDecoderConfig.coreCoderDelay = 0;
                }
                boolean bool3 = bitStreamCreateBitStream.readBool();
                aACDecoderConfig.extensionFlag = bool3;
                if (bool3) {
                    if (profile.isErrorResilientProfile()) {
                        aACDecoderConfig.sectionDataResilience = bitStreamCreateBitStream.readBool();
                        aACDecoderConfig.scalefactorResilience = bitStreamCreateBitStream.readBool();
                        aACDecoderConfig.spectralDataResilience = bitStreamCreateBitStream.readBool();
                    }
                    bitStreamCreateBitStream.skipBit();
                }
                if (aACDecoderConfig.channelConfiguration == ChannelConfiguration.CHANNEL_CONFIG_NONE) {
                    bitStreamCreateBitStream.skipBits(3);
                    PCE pce = new PCE();
                    pce.decode(bitStreamCreateBitStream);
                    aACDecoderConfig.profile = pce.getProfile();
                    aACDecoderConfig.sampleFrequency = pce.getSampleFrequency();
                    aACDecoderConfig.channelConfiguration = ChannelConfiguration.forInt(pce.getChannelCount());
                }
                if (bitStreamCreateBitStream.getBitsLeft() > 10) {
                    readSyncExtension(bitStreamCreateBitStream, aACDecoderConfig);
                }
            }
            return aACDecoderConfig;
        } finally {
            bitStreamCreateBitStream.destroy();
        }
    }

    private static Profile readProfile(IBitStream iBitStream) throws AACException {
        int bits = iBitStream.readBits(5);
        if (bits == 31) {
            bits = iBitStream.readBits(6) + 32;
        }
        return Profile.forInt(bits);
    }

    private static void readSyncExtension(IBitStream iBitStream, AACDecoderConfig aACDecoderConfig) throws AACException {
        if (iBitStream.readBits(11) != 695) {
            return;
        }
        Profile profileForInt = Profile.forInt(iBitStream.readBits(5));
        if (profileForInt.equals(Profile.AAC_SBR)) {
            boolean bool = iBitStream.readBool();
            aACDecoderConfig.sbrPresent = bool;
            if (bool) {
                aACDecoderConfig.profile = profileForInt;
                int bits = iBitStream.readBits(4);
                if (bits == aACDecoderConfig.sampleFrequency.getIndex()) {
                    aACDecoderConfig.downSampledSBR = true;
                }
                if (bits == 15) {
                    throw new AACException("sample rate specified explicitly, not supported yet!");
                }
            }
        }
    }

    public ChannelConfiguration getChannelConfiguration() {
        return this.channelConfiguration;
    }

    public int getCoreCoderDelay() {
        return this.coreCoderDelay;
    }

    public Profile getExtObjectType() {
        return this.extProfile;
    }

    public int getFrameLength() {
        if (this.frameLengthFlag) {
            return SyntaxConstants.WINDOW_SMALL_LEN_LONG;
        }
        return 1024;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public SampleFrequency getSampleFrequency() {
        return this.sampleFrequency;
    }

    public boolean isDependsOnCoreCoder() {
        return this.dependsOnCoreCoder;
    }

    public boolean isSBRDownSampled() {
        return this.downSampledSBR;
    }

    public boolean isSBREnabled() {
        return this.sbrEnabled;
    }

    public boolean isSBRPresent() {
        return this.sbrPresent;
    }

    public boolean isScalefactorResilienceUsed() {
        return this.scalefactorResilience;
    }

    public boolean isSectionDataResilienceUsed() {
        return this.sectionDataResilience;
    }

    public boolean isSmallFrameUsed() {
        return this.frameLengthFlag;
    }

    public boolean isSpectralDataResilienceUsed() {
        return this.spectralDataResilience;
    }

    public void setChannelConfiguration(ChannelConfiguration channelConfiguration) {
        this.channelConfiguration = channelConfiguration;
    }

    public void setCoreCoderDelay(int i) {
        this.coreCoderDelay = i;
    }

    public void setDependsOnCoreCoder(boolean z) {
        this.dependsOnCoreCoder = z;
    }

    public void setExtObjectType(Profile profile) {
        this.extProfile = profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setSBREnabled(boolean z) {
        this.sbrEnabled = z;
    }

    public void setSampleFrequency(SampleFrequency sampleFrequency) {
        this.sampleFrequency = sampleFrequency;
    }

    public void setSmallFrameUsed(boolean z) {
        this.frameLengthFlag = z;
    }
}
