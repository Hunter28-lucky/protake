package net.sourceforge.jaad.aac.syntax;

import defpackage.C3244;
import defpackage.C5073;
import defpackage.C5096;
import java.lang.reflect.Array;
import net.sourceforge.jaad.aac.AACDecoderConfig;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.ChannelConfiguration;
import net.sourceforge.jaad.aac.Profile;
import net.sourceforge.jaad.aac.SampleBuffer;
import net.sourceforge.jaad.aac.SampleFrequency;
import net.sourceforge.jaad.aac.filterbank.FilterBank;
import net.sourceforge.jaad.aac.sbr.SBR;
import net.sourceforge.jaad.aac.syntax.ICSInfo;
import net.sourceforge.jaad.aac.tools.IS;
import net.sourceforge.jaad.aac.tools.MS;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class SyntacticElements implements SyntaxConstants {
    private int bitsRead;
    private AACDecoderConfig config;
    private int curCCE;
    private int curDSE;
    private int curElem;
    private int curFIL;
    private float[][] data;
    private boolean psPresent;
    private boolean sbrPresent;
    private PCE pce = new PCE();
    private final Element[] elements = new Element[64];
    private final C5073[] cces = new C5073[16];
    private final C3244[] dses = new C3244[16];
    private final FIL[] fils = new FIL[16];

    public SyntacticElements(AACDecoderConfig aACDecoderConfig) {
        this.config = aACDecoderConfig;
        startNewFrame();
    }

    private void decodeCCE(IBitStream iBitStream) throws AACException {
        int i = this.curCCE;
        if (i == 16) {
            throw new AACException("too much CCE elements");
        }
        C5073[] c5073Arr = this.cces;
        if (c5073Arr[i] == null) {
            c5073Arr[i] = new C5073(this.config.getFrameLength());
        }
        this.cces[this.curCCE].decode(iBitStream, this.config);
        this.curCCE++;
    }

    private Element decodeCPE(IBitStream iBitStream) throws AACException {
        Element[] elementArr = this.elements;
        int i = this.curElem;
        if (elementArr[i] == null) {
            elementArr[i] = new CPE(this.config.getFrameLength());
        }
        ((CPE) this.elements[this.curElem]).decode(iBitStream, this.config);
        int i2 = this.curElem + 1;
        this.curElem = i2;
        return this.elements[i2 - 1];
    }

    private void decodeDSE(IBitStream iBitStream) throws AACException {
        int i = this.curDSE;
        if (i == 16) {
            throw new AACException("too much CCE elements");
        }
        C3244[] c3244Arr = this.dses;
        if (c3244Arr[i] == null) {
            c3244Arr[i] = new C3244();
        }
        this.dses[this.curDSE].decode(iBitStream);
        this.curDSE++;
    }

    private void decodeFIL(IBitStream iBitStream, Element element) throws AACException {
        int i = this.curFIL;
        if (i == 16) {
            throw new AACException("too much FIL elements");
        }
        FIL[] filArr = this.fils;
        if (filArr[i] == null) {
            filArr[i] = new FIL(this.config.isSBRDownSampled());
        }
        this.fils[this.curFIL].m7649(iBitStream, element, this.config.getSampleFrequency(), this.config.isSBREnabled(), this.config.isSmallFrameUsed());
        this.curFIL++;
        if (element == null || !element.isSBRPresent()) {
            return;
        }
        this.sbrPresent = true;
        if (this.psPresent || !element.getSBR().isPSUsed()) {
            return;
        }
        this.psPresent = true;
    }

    private void decodePCE(IBitStream iBitStream) throws AACException {
        this.pce.decode(iBitStream);
        this.config.setProfile(this.pce.getProfile());
        this.config.setSampleFrequency(this.pce.getSampleFrequency());
        this.config.setChannelConfiguration(ChannelConfiguration.forInt(this.pce.getChannelCount()));
    }

    private Element decodeSCE_LFE(IBitStream iBitStream) throws AACException {
        Element[] elementArr = this.elements;
        int i = this.curElem;
        if (elementArr[i] == null) {
            elementArr[i] = new C5096(this.config.getFrameLength());
        }
        ((C5096) this.elements[this.curElem]).decode(iBitStream, this.config);
        int i2 = this.curElem + 1;
        this.curElem = i2;
        return this.elements[i2 - 1];
    }

    private void processDependentCoupling(boolean z, int i, int i2, float[] fArr, float[] fArr2) {
        int i3 = 0;
        while (true) {
            C5073[] c5073Arr = this.cces;
            if (i3 >= c5073Arr.length) {
                return;
            }
            C5073 c5073 = c5073Arr[i3];
            if (c5073 != null && c5073.m14892() == i2) {
                int i4 = 0;
                for (int i5 = 0; i5 <= c5073.m14891(); i5++) {
                    int iM14890 = c5073.m14890(i5);
                    if (c5073.m14894(i5) == z && c5073.m14893(i5) == i) {
                        if (iM14890 != 1) {
                            c5073.m14888(i4, fArr);
                            if (iM14890 != 0) {
                                i4++;
                            }
                        }
                        if (iM14890 != 2) {
                            c5073.m14888(i4, fArr2);
                            i4++;
                        }
                    } else {
                        i4 += (iM14890 == 3 ? 1 : 0) + 1;
                    }
                }
            }
            i3++;
        }
    }

    private void processIndependentCoupling(boolean z, int i, float[] fArr, float[] fArr2) {
        int i2 = 0;
        while (true) {
            C5073[] c5073Arr = this.cces;
            if (i2 >= c5073Arr.length) {
                return;
            }
            C5073 c5073 = c5073Arr[i2];
            if (c5073 != null && c5073.m14892() == 2) {
                int i3 = 0;
                for (int i4 = 0; i4 <= c5073.m14891(); i4++) {
                    int iM14890 = c5073.m14890(i4);
                    if (c5073.m14894(i4) == z && c5073.m14893(i4) == i) {
                        if (iM14890 != 1) {
                            c5073.m14889(i3, fArr);
                            if (iM14890 != 0) {
                                i3++;
                            }
                        }
                        if (iM14890 != 2) {
                            c5073.m14889(i3, fArr2);
                            i3++;
                        }
                    } else {
                        i3 += (iM14890 == 3 ? 1 : 0) + 1;
                    }
                }
            }
            i2++;
        }
    }

    private void processPair(CPE cpe, FilterBank filterBank, int i, Profile profile, SampleFrequency sampleFrequency) throws AACException {
        float[] fArr;
        float[] fArr2;
        int i2;
        ICStream leftChannel = cpe.getLeftChannel();
        ICStream rightChannel = cpe.getRightChannel();
        ICSInfo info = leftChannel.getInfo();
        ICSInfo info2 = rightChannel.getInfo();
        ICSInfo.LTPrediction lTPrediction1 = info.getLTPrediction1();
        ICSInfo.LTPrediction lTPrediction2 = cpe.isCommonWindow() ? info.getLTPrediction2() : info2.getLTPrediction1();
        int elementInstanceTag = cpe.getElementInstanceTag();
        float[] invQuantData = leftChannel.getInvQuantData();
        float[] invQuantData2 = rightChannel.getInvQuantData();
        if (cpe.isCommonWindow() && cpe.isMSMaskPresent()) {
            MS.process(cpe, invQuantData, invQuantData2);
        }
        if (profile.equals(Profile.AAC_MAIN)) {
            if (info.isICPredictionPresent()) {
                info.getICPrediction().process(leftChannel, invQuantData, sampleFrequency);
            }
            if (info2.isICPredictionPresent()) {
                info2.getICPrediction().process(rightChannel, invQuantData2, sampleFrequency);
            }
        }
        IS.process(cpe, invQuantData, invQuantData2);
        if (ICSInfo.LTPrediction.isLTPProfile(profile)) {
            if (info.isLTPrediction1Present()) {
                lTPrediction1.process(leftChannel, invQuantData, filterBank, sampleFrequency);
            }
            if ((cpe.isCommonWindow() && info.isLTPrediction2Present()) || info2.isLTPrediction1Present()) {
                lTPrediction2.process(rightChannel, invQuantData2, filterBank, sampleFrequency);
            }
        }
        processDependentCoupling(true, elementInstanceTag, 0, invQuantData, invQuantData2);
        if (leftChannel.isTNSDataPresent()) {
            fArr = invQuantData;
            leftChannel.getTNS().process(leftChannel, fArr, sampleFrequency, false);
        } else {
            fArr = invQuantData;
        }
        if (rightChannel.isTNSDataPresent()) {
            fArr2 = invQuantData2;
            rightChannel.getTNS().process(rightChannel, fArr2, sampleFrequency, false);
        } else {
            fArr2 = invQuantData2;
        }
        float[] fArr3 = fArr2;
        float[] fArr4 = fArr;
        processDependentCoupling(true, elementInstanceTag, 1, fArr, fArr3);
        filterBank.process(info.getWindowSequence(), info.getWindowShape(1), info.getWindowShape(0), fArr4, this.data[i], i);
        int i3 = i + 1;
        filterBank.process(info2.getWindowSequence(), info2.getWindowShape(1), info2.getWindowShape(0), fArr3, this.data[i3], i3);
        if (ICSInfo.LTPrediction.isLTPProfile(profile)) {
            lTPrediction1.updateState(this.data[i], filterBank.getOverlap(i), profile);
            i2 = i3;
            lTPrediction2.updateState(this.data[i2], filterBank.getOverlap(i2), profile);
        } else {
            i2 = i3;
        }
        float[][] fArr5 = this.data;
        processIndependentCoupling(true, elementInstanceTag, fArr5[i], fArr5[i2]);
        if (leftChannel.isGainControlPresent()) {
            leftChannel.getGainControl().process(fArr4, info.getWindowShape(1), info.getWindowShape(0), info.getWindowSequence());
        }
        if (rightChannel.isGainControlPresent()) {
            rightChannel.getGainControl().process(fArr3, info2.getWindowShape(1), info2.getWindowShape(0), info2.getWindowSequence());
        }
        if (this.sbrPresent && this.config.isSBREnabled()) {
            if (this.data[i].length == this.config.getFrameLength()) {
                Logger.warn("SBR data present, but buffer has normal size!");
            }
            SBR sbr = cpe.getSBR();
            float[][] fArr6 = this.data;
            sbr._process(fArr6[i], fArr6[i2], false);
        }
    }

    private int processSingle(C5096 c5096, FilterBank filterBank, int i, Profile profile, SampleFrequency sampleFrequency) throws AACException {
        ICStream iCStreamM14926 = c5096.m14926();
        ICSInfo info = iCStreamM14926.getInfo();
        ICSInfo.LTPrediction lTPrediction1 = info.getLTPrediction1();
        int elementInstanceTag = c5096.getElementInstanceTag();
        float[] invQuantData = iCStreamM14926.getInvQuantData();
        if (profile.equals(Profile.AAC_MAIN) && info.isICPredictionPresent()) {
            info.getICPrediction().process(iCStreamM14926, invQuantData, sampleFrequency);
        }
        if (ICSInfo.LTPrediction.isLTPProfile(profile) && info.isLTPrediction1Present()) {
            lTPrediction1.process(iCStreamM14926, invQuantData, filterBank, sampleFrequency);
        }
        processDependentCoupling(false, elementInstanceTag, 0, invQuantData, null);
        if (iCStreamM14926.isTNSDataPresent()) {
            iCStreamM14926.getTNS().process(iCStreamM14926, invQuantData, sampleFrequency, false);
        }
        processDependentCoupling(false, elementInstanceTag, 1, invQuantData, null);
        filterBank.process(info.getWindowSequence(), info.getWindowShape(1), info.getWindowShape(0), invQuantData, this.data[i], i);
        if (ICSInfo.LTPrediction.isLTPProfile(profile)) {
            lTPrediction1.updateState(this.data[i], filterBank.getOverlap(i), profile);
        }
        processIndependentCoupling(false, elementInstanceTag, this.data[i], null);
        if (iCStreamM14926.isGainControlPresent()) {
            iCStreamM14926.getGainControl().process(invQuantData, info.getWindowShape(1), info.getWindowShape(0), info.getWindowSequence());
        }
        if (!this.sbrPresent || !this.config.isSBREnabled()) {
            return 1;
        }
        if (this.data[i].length == this.config.getFrameLength()) {
            Logger.warn("SBR data present, but buffer has normal size!");
        }
        if (!c5096.getSBR().isPSUsed()) {
            c5096.getSBR().process(this.data[i], false);
            return 1;
        }
        SBR sbr = c5096.getSBR();
        float[][] fArr = this.data;
        sbr._process(fArr[i], fArr[i + 1], false);
        return 2;
    }

    public void decode(IBitStream iBitStream) throws AACException {
        int position = iBitStream.getPosition();
        if (this.config.getProfile().isErrorResilientProfile()) {
            ChannelConfiguration channelConfiguration = this.config.getChannelConfiguration();
            if (ChannelConfiguration.CHANNEL_CONFIG_MONO == channelConfiguration) {
                decodeSCE_LFE(iBitStream);
            } else if (ChannelConfiguration.CHANNEL_CONFIG_STEREO == channelConfiguration) {
                decodeCPE(iBitStream);
            } else if (ChannelConfiguration.CHANNEL_CONFIG_STEREO_PLUS_CENTER == channelConfiguration) {
                decodeSCE_LFE(iBitStream);
                decodeCPE(iBitStream);
            } else if (ChannelConfiguration.CHANNEL_CONFIG_STEREO_PLUS_CENTER_PLUS_REAR_MONO == channelConfiguration) {
                decodeSCE_LFE(iBitStream);
                decodeCPE(iBitStream);
                decodeSCE_LFE(iBitStream);
            } else if (ChannelConfiguration.CHANNEL_CONFIG_FIVE == channelConfiguration) {
                decodeSCE_LFE(iBitStream);
                decodeCPE(iBitStream);
                decodeCPE(iBitStream);
            } else if (ChannelConfiguration.CHANNEL_CONFIG_FIVE_PLUS_ONE == channelConfiguration) {
                decodeSCE_LFE(iBitStream);
                decodeCPE(iBitStream);
                decodeCPE(iBitStream);
                decodeSCE_LFE(iBitStream);
            } else {
                if (ChannelConfiguration.CHANNEL_CONFIG_SEVEN_PLUS_ONE != channelConfiguration) {
                    throw new AACException("unsupported channel configuration for error resilience: " + channelConfiguration);
                }
                decodeSCE_LFE(iBitStream);
                decodeCPE(iBitStream);
                decodeCPE(iBitStream);
                decodeCPE(iBitStream);
                decodeSCE_LFE(iBitStream);
            }
        } else {
            while (true) {
                Element elementDecodeSCE_LFE = null;
                while (true) {
                    int bits = iBitStream.readBits(3);
                    if (bits != 7) {
                        switch (bits) {
                            case 0:
                            case 3:
                                Logger.debug("SCE");
                                elementDecodeSCE_LFE = decodeSCE_LFE(iBitStream);
                                break;
                            case 1:
                                Logger.debug("CPE");
                                elementDecodeSCE_LFE = decodeCPE(iBitStream);
                                break;
                            case 2:
                                Logger.debug("CCE");
                                decodeCCE(iBitStream);
                                continue;
                            case 4:
                                Logger.debug("DSE");
                                decodeDSE(iBitStream);
                                continue;
                            case 5:
                                Logger.debug("PCE");
                                decodePCE(iBitStream);
                                continue;
                            case 6:
                                Logger.debug("FIL");
                                decodeFIL(iBitStream, elementDecodeSCE_LFE);
                                continue;
                        }
                    } else {
                        Logger.debug("END");
                    }
                }
            }
        }
        iBitStream.byteAlign();
        this.bitsRead = iBitStream.getPosition() - position;
    }

    public void process(FilterBank filterBank) throws AACException {
        Profile profile = this.config.getProfile();
        SampleFrequency sampleFrequency = this.config.getSampleFrequency();
        int channelCount = this.config.getChannelConfiguration().getChannelCount();
        if (channelCount == 1 && this.psPresent) {
            channelCount++;
        }
        int i = channelCount;
        int i2 = this.sbrPresent ? 2 : 1;
        float[][] fArr = this.data;
        if (fArr == null || i != fArr.length || this.config.getFrameLength() * i2 != this.data[0].length) {
            this.data = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i, i2 * this.config.getFrameLength());
        }
        int i3 = 0;
        int iProcessSingle = 0;
        while (true) {
            Element[] elementArr = this.elements;
            if (i3 >= elementArr.length || iProcessSingle >= i) {
                return;
            }
            Element element = elementArr[i3];
            if (element != null) {
                if (element instanceof C5096) {
                    iProcessSingle += processSingle((C5096) element, filterBank, iProcessSingle, profile, sampleFrequency);
                } else if (element instanceof CPE) {
                    processPair((CPE) element, filterBank, iProcessSingle, profile, sampleFrequency);
                    iProcessSingle += 2;
                } else if (element instanceof C5073) {
                    ((C5073) element).m14895();
                    iProcessSingle++;
                }
            }
            i3++;
        }
    }

    public void sendToOutput(SampleBuffer sampleBuffer) {
        boolean zIsBigEndian = sampleBuffer.isBigEndian();
        int length = this.data.length;
        int i = (this.sbrPresent && this.config.isSBREnabled()) ? 2 : 1;
        int frameLength = this.config.getFrameLength() * i;
        int frequency = this.config.getSampleFrequency().getFrequency() * i;
        byte[] data = sampleBuffer.getData();
        int i2 = length * frameLength * 2;
        if (data.length != i2) {
            data = new byte[i2];
        }
        for (int i3 = 0; i3 < length; i3++) {
            float[] fArr = this.data[i3];
            for (int i4 = 0; i4 < frameLength; i4++) {
                short sMax = (short) Math.max(Math.min(Math.round(fArr[i4]), 32767), -32768);
                int i5 = ((i4 * length) + i3) * 2;
                if (zIsBigEndian) {
                    data[i5] = (byte) ((sMax >> 8) & 255);
                    data[i5 + 1] = (byte) (sMax & 255);
                } else {
                    data[i5 + 1] = (byte) ((sMax >> 8) & 255);
                    data[i5] = (byte) (sMax & 255);
                }
            }
        }
        sampleBuffer.setData(data, frequency, length, 16, this.bitsRead);
    }

    public final void startNewFrame() {
        this.curElem = 0;
        this.curCCE = 0;
        this.curDSE = 0;
        this.curFIL = 0;
        this.sbrPresent = false;
        this.psPresent = false;
        this.bitsRead = 0;
    }
}
