package net.sourceforge.jaad.aac.syntax;

import androidx.core.view.InputDeviceCompat;
import defpackage.InterfaceC2812;
import defpackage.InterfaceC4646;
import java.util.Arrays;
import net.sourceforge.jaad.aac.AACDecoderConfig;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.ChannelConfiguration;
import net.sourceforge.jaad.aac.error.RVLC;
import net.sourceforge.jaad.aac.gain.GainControl;
import net.sourceforge.jaad.aac.huffman.HCB;
import net.sourceforge.jaad.aac.huffman.Huffman;
import net.sourceforge.jaad.aac.tools.TNS;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class ICStream implements SyntaxConstants, HCB, InterfaceC4646, InterfaceC2812 {
    private static final int SF_DELTA = 60;
    private static final int SF_OFFSET = 200;
    private static int randomState = 523124044;
    private final float[] data;
    private final int frameLength;
    private GainControl gainControl;
    private boolean gainControlPresent;
    private int globalGain;
    private final ICSInfo info;
    private int longestCodewordLen;
    private boolean noiseUsed;
    private int[] pulseAmp;
    private int pulseCount;
    private boolean pulseDataPresent;
    private int[] pulseOffset;
    private int pulseStartSWB;
    private int reorderedSpectralDataLen;
    private RVLC rvlc;
    private TNS tns;
    private boolean tnsDataPresent;
    private final int[] sfbCB = new int[120];
    private final int[] sectEnd = new int[120];
    private final float[] scaleFactors = new float[120];

    public ICStream(int i) {
        this.frameLength = i;
        this.info = new ICSInfo(i);
        this.data = new float[i];
    }

    private void decodePulseData(IBitStream iBitStream) throws AACException {
        this.pulseCount = iBitStream.readBits(2) + 1;
        int bits = iBitStream.readBits(6);
        this.pulseStartSWB = bits;
        if (bits >= this.info.getSWBCount()) {
            throw new AACException("pulse SWB out of range: " + this.pulseStartSWB + " > " + this.info.getSWBCount());
        }
        int[] iArr = this.pulseOffset;
        if (iArr == null || this.pulseCount != iArr.length) {
            int i = this.pulseCount;
            this.pulseOffset = new int[i];
            this.pulseAmp = new int[i];
        }
        this.pulseOffset[0] = this.info.getSWBOffsets()[this.pulseStartSWB];
        int[] iArr2 = this.pulseOffset;
        iArr2[0] = iArr2[0] + iBitStream.readBits(5);
        this.pulseAmp[0] = iBitStream.readBits(4);
        for (int i2 = 1; i2 < this.pulseCount; i2++) {
            int[] iArr3 = this.pulseOffset;
            int bits2 = iBitStream.readBits(5);
            int[] iArr4 = this.pulseOffset;
            iArr3[i2] = bits2 + iArr4[i2 - 1];
            if (iArr4[i2] > 1023) {
                throw new AACException("pulse offset out of range: " + this.pulseOffset[0]);
            }
            this.pulseAmp[i2] = iBitStream.readBits(4);
        }
    }

    private void decodeSpectralData(IBitStream iBitStream) throws AACException {
        int i;
        int i2;
        int[] iArr;
        int[] iArr2;
        float f;
        float f2 = 0.0f;
        Arrays.fill(this.data, 0.0f);
        int maxSFB = this.info.getMaxSFB();
        int windowGroupCount = this.info.getWindowGroupCount();
        int[] sWBOffsets = this.info.getSWBOffsets();
        int[] iArr3 = new int[4];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < windowGroupCount) {
            int windowGroupLength = this.info.getWindowGroupLength(i3);
            int i6 = 0;
            while (i6 < maxSFB) {
                int i7 = this.sfbCB[i5];
                int i8 = sWBOffsets[i6];
                int i9 = i4 + i8;
                i6++;
                int i10 = sWBOffsets[i6] - i8;
                if (i7 == 0 || i7 == 15 || i7 == 14) {
                    i = maxSFB;
                    i2 = windowGroupCount;
                    iArr = sWBOffsets;
                    iArr2 = iArr3;
                    int i11 = 0;
                    while (i11 < windowGroupLength) {
                        Arrays.fill(this.data, i9, i9 + i10, 0.0f);
                        i11++;
                        i9 += 128;
                    }
                } else if (i7 == 13) {
                    int i12 = 0;
                    while (i12 < windowGroupLength) {
                        int i13 = 0;
                        while (i13 < i10) {
                            int i14 = randomState * 1015568748;
                            randomState = i14;
                            float f3 = i14;
                            this.data[i9 + i13] = f3;
                            f2 += f3 * f3;
                            i13++;
                            maxSFB = maxSFB;
                        }
                        int i15 = maxSFB;
                        int i16 = windowGroupCount;
                        int[] iArr4 = sWBOffsets;
                        float fSqrt = (float) (this.scaleFactors[i5] / Math.sqrt(f2));
                        for (int i17 = 0; i17 < i10; i17++) {
                            float[] fArr = this.data;
                            int i18 = i9 + i17;
                            fArr[i18] = fArr[i18] * fSqrt;
                        }
                        i12++;
                        i9 += 128;
                        windowGroupCount = i16;
                        maxSFB = i15;
                        sWBOffsets = iArr4;
                        f2 = 0.0f;
                    }
                    i = maxSFB;
                    iArr = sWBOffsets;
                    f = f2;
                    i2 = windowGroupCount;
                    iArr2 = iArr3;
                    i5++;
                    f2 = f;
                    maxSFB = i;
                    sWBOffsets = iArr;
                    windowGroupCount = i2;
                    iArr3 = iArr2;
                } else {
                    i = maxSFB;
                    int i19 = windowGroupCount;
                    iArr = sWBOffsets;
                    int i20 = 0;
                    while (i20 < windowGroupLength) {
                        int i21 = i7 >= 5 ? 2 : 4;
                        for (int i22 = 0; i22 < i10; i22 += i21) {
                            int i23 = 0;
                            Huffman.decodeSpectralData(iBitStream, i7, iArr3, 0);
                            while (i23 < i21) {
                                float[] fArr2 = this.data;
                                int i24 = i9 + i22 + i23;
                                int i25 = i19;
                                int i26 = iArr3[i23];
                                float[] fArr3 = InterfaceC2812.f10257;
                                float f4 = i26 > 0 ? fArr3[i26] : -fArr3[-i26];
                                fArr2[i24] = f4;
                                fArr2[i24] = f4 * this.scaleFactors[i5];
                                i23++;
                                i19 = i25;
                                iArr3 = iArr3;
                            }
                        }
                        i20++;
                        i9 += 128;
                    }
                    iArr2 = iArr3;
                    i2 = i19;
                }
                f = 0.0f;
                i5++;
                f2 = f;
                maxSFB = i;
                sWBOffsets = iArr;
                windowGroupCount = i2;
                iArr3 = iArr2;
            }
            i4 += windowGroupLength << 7;
            i3++;
            maxSFB = maxSFB;
            sWBOffsets = sWBOffsets;
        }
    }

    public void decode(IBitStream iBitStream, boolean z, AACDecoderConfig aACDecoderConfig) throws AACException {
        if (aACDecoderConfig.isScalefactorResilienceUsed() && this.rvlc == null) {
            this.rvlc = new RVLC();
        }
        boolean zIsErrorResilientProfile = aACDecoderConfig.getProfile().isErrorResilientProfile();
        this.globalGain = iBitStream.readBits(8);
        if (!z) {
            this.info.decode(iBitStream, aACDecoderConfig, z);
        }
        decodeSectionData(iBitStream, aACDecoderConfig.isSectionDataResilienceUsed());
        decodeScaleFactors(iBitStream);
        boolean bool = iBitStream.readBool();
        this.pulseDataPresent = bool;
        if (bool) {
            if (this.info.isEightShortFrame()) {
                throw new AACException("pulse data not allowed for short frames");
            }
            Logger.debug("PULSE");
            decodePulseData(iBitStream);
        }
        boolean bool2 = iBitStream.readBool();
        this.tnsDataPresent = bool2;
        if (bool2 && !zIsErrorResilientProfile) {
            if (this.tns == null) {
                this.tns = new TNS();
            }
            this.tns.decode(iBitStream, this.info);
        }
        boolean bool3 = iBitStream.readBool();
        this.gainControlPresent = bool3;
        if (bool3) {
            if (this.gainControl == null) {
                this.gainControl = new GainControl(this.frameLength);
            }
            Logger.debug("GAIN");
            this.gainControl.decode(iBitStream, this.info.getWindowSequence());
        }
        if (!aACDecoderConfig.isSpectralDataResilienceUsed()) {
            decodeSpectralData(iBitStream);
        } else {
            this.reorderedSpectralDataLen = Math.max(iBitStream.readBits(14), aACDecoderConfig.getChannelConfiguration() == ChannelConfiguration.CHANNEL_CONFIG_STEREO ? 6144 : 12288);
            this.longestCodewordLen = Math.max(iBitStream.readBits(6), 49);
        }
    }

    public void decodeScaleFactors(IBitStream iBitStream) throws AACException {
        int windowGroupCount = this.info.getWindowGroupCount();
        int maxSFB = this.info.getMaxSFB();
        int i = this.globalGain;
        int[] iArr = {i, i - 90, 0};
        int i2 = 0;
        boolean z = true;
        for (int i3 = 0; i3 < windowGroupCount; i3++) {
            int i4 = 0;
            while (i4 < maxSFB) {
                int i5 = this.sectEnd[i2];
                int i6 = this.sfbCB[i2];
                if (i6 != 0) {
                    switch (i6) {
                        case 13:
                            while (i4 < i5) {
                                if (z) {
                                    iArr[1] = iArr[1] + iBitStream.readBits(9) + InputDeviceCompat.SOURCE_ANY;
                                    z = false;
                                } else {
                                    iArr[1] = iArr[1] + (Huffman.decodeScaleFactor(iBitStream) - 60);
                                }
                                this.scaleFactors[i2] = -InterfaceC4646.f15814[Math.min(Math.max(iArr[1], -100), 155) + 200];
                                i4++;
                                i2++;
                            }
                            break;
                        case 14:
                        case 15:
                            while (i4 < i5) {
                                int iDecodeScaleFactor = iArr[2] + (Huffman.decodeScaleFactor(iBitStream) - 60);
                                iArr[2] = iDecodeScaleFactor;
                                this.scaleFactors[i2] = InterfaceC4646.f15814[(-Math.min(Math.max(iDecodeScaleFactor, -155), 100)) + 200];
                                i4++;
                                i2++;
                            }
                            break;
                        default:
                            while (i4 < i5) {
                                int iDecodeScaleFactor2 = iArr[0] + (Huffman.decodeScaleFactor(iBitStream) - 60);
                                iArr[0] = iDecodeScaleFactor2;
                                if (iDecodeScaleFactor2 > 255) {
                                    throw new AACException("scalefactor out of range: " + iArr[0]);
                                }
                                this.scaleFactors[i2] = InterfaceC4646.f15814[(iDecodeScaleFactor2 - 100) + 200];
                                i4++;
                                i2++;
                            }
                            break;
                    }
                } else {
                    while (i4 < i5) {
                        this.scaleFactors[i2] = 0.0f;
                        i4++;
                        i2++;
                    }
                }
            }
        }
    }

    public void decodeSectionData(IBitStream iBitStream, boolean z) throws AACException {
        int bits;
        Arrays.fill(this.sfbCB, 0);
        Arrays.fill(this.sectEnd, 0);
        int i = this.info.isEightShortFrame() ? 3 : 5;
        int i2 = (1 << i) - 1;
        int windowGroupCount = this.info.getWindowGroupCount();
        int maxSFB = this.info.getMaxSFB();
        int i3 = 0;
        for (int i4 = 0; i4 < windowGroupCount; i4++) {
            int i5 = 0;
            while (i5 < maxSFB) {
                int bits2 = iBitStream.readBits(4);
                if (bits2 == 12) {
                    throw new AACException("invalid huffman codebook: 12");
                }
                int i6 = i5;
                while (true) {
                    bits = iBitStream.readBits(i);
                    if (bits != i2) {
                        break;
                    } else {
                        i6 += bits;
                    }
                }
                int i7 = i6 + bits;
                if (i7 > maxSFB) {
                    throw new AACException("too many bands: " + i7 + ", allowed: " + maxSFB);
                }
                while (i5 < i7) {
                    this.sfbCB[i3] = bits2;
                    this.sectEnd[i3] = i7;
                    i5++;
                    i3++;
                }
            }
        }
    }

    public GainControl getGainControl() {
        return this.gainControl;
    }

    public int getGlobalGain() {
        return this.globalGain;
    }

    public ICSInfo getInfo() {
        return this.info;
    }

    public float[] getInvQuantData() throws AACException {
        return this.data;
    }

    public int getLongestCodewordLength() {
        return this.longestCodewordLen;
    }

    public int getReorderedSpectralDataLength() {
        return this.reorderedSpectralDataLen;
    }

    public float[] getScaleFactors() {
        return this.scaleFactors;
    }

    public int[] getSectEnd() {
        return this.sectEnd;
    }

    public int[] getSfbCB() {
        return this.sfbCB;
    }

    public TNS getTNS() {
        return this.tns;
    }

    public boolean isGainControlPresent() {
        return this.gainControlPresent;
    }

    public boolean isNoiseUsed() {
        return this.noiseUsed;
    }

    public boolean isTNSDataPresent() {
        return this.tnsDataPresent;
    }
}
