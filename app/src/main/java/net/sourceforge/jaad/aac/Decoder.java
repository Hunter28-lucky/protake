package net.sourceforge.jaad.aac;

import net.sourceforge.jaad.aac.filterbank.FilterBank;
import net.sourceforge.jaad.aac.syntax.BitStream;
import net.sourceforge.jaad.aac.syntax.IBitStream;
import net.sourceforge.jaad.aac.syntax.PCE;
import net.sourceforge.jaad.aac.syntax.SyntacticElements;
import net.sourceforge.jaad.aac.syntax.SyntaxConstants;
import net.sourceforge.jaad.aac.transport.ADIFHeader;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class Decoder implements SyntaxConstants {
    private IBitStream _in;
    private ADIFHeader adifHeader;
    private final AACDecoderConfig config;
    private final FilterBank filterBank;
    private final SyntacticElements syntacticElements;

    public Decoder(byte[] bArr) throws AACException {
        AACDecoderConfig mP4DecoderSpecificInfo = AACDecoderConfig.parseMP4DecoderSpecificInfo(bArr);
        this.config = mP4DecoderSpecificInfo;
        if (mP4DecoderSpecificInfo == null) {
            throw new IllegalArgumentException("illegal MP4 decoder specific info");
        }
        if (!canDecode(mP4DecoderSpecificInfo.getProfile())) {
            throw new AACException("unsupported profile: " + mP4DecoderSpecificInfo.getProfile().getDescription());
        }
        this.syntacticElements = new SyntacticElements(mP4DecoderSpecificInfo);
        this.filterBank = new FilterBank(mP4DecoderSpecificInfo.isSmallFrameUsed(), mP4DecoderSpecificInfo.getChannelConfiguration().getChannelCount());
        this._in = new BitStream();
        Logger.debug("profile: {0}", mP4DecoderSpecificInfo.getProfile());
        Logger.debug("sf: {0}", Integer.valueOf(mP4DecoderSpecificInfo.getSampleFrequency().getFrequency()));
        Logger.debug("channels: {0}", mP4DecoderSpecificInfo.getChannelConfiguration().getDescription());
    }

    public static boolean canDecode(Profile profile) {
        return profile.isDecodingSupported();
    }

    private void decode(SampleBuffer sampleBuffer) throws AACException {
        if (ADIFHeader.isPresent(this._in)) {
            ADIFHeader header = ADIFHeader.readHeader(this._in);
            this.adifHeader = header;
            PCE firstPCE = header.getFirstPCE();
            this.config.setProfile(firstPCE.getProfile());
            this.config.setSampleFrequency(firstPCE.getSampleFrequency());
            this.config.setChannelConfiguration(ChannelConfiguration.forInt(firstPCE.getChannelCount()));
        }
        if (!canDecode(this.config.getProfile())) {
            throw new AACException("unsupported profile: " + this.config.getProfile().getDescription());
        }
        this.syntacticElements.startNewFrame();
        try {
            this.syntacticElements.decode(this._in);
            this.syntacticElements.process(this.filterBank);
            this.syntacticElements.sendToOutput(sampleBuffer);
        } catch (Exception e2) {
            sampleBuffer.setData(new byte[0], 0, 0, 0, 0);
            throw AACException.wrap(e2);
        }
    }

    public void decodeFrame(byte[] bArr, SampleBuffer sampleBuffer) throws AACException {
        if (bArr != null) {
            this._in.setData(bArr);
        }
        Logger.debug("bits left " + this._in.getBitsLeft());
        try {
            decode(sampleBuffer);
        } catch (AACException e2) {
            if (!e2.isEndOfStream()) {
                throw e2;
            }
            Logger.warn("unexpected end of frame");
        }
    }

    public AACDecoderConfig getConfig() {
        return this.config;
    }
}
