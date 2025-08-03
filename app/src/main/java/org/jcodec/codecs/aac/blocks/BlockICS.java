package org.jcodec.codecs.aac.blocks;

import androidx.core.view.InputDeviceCompat;
import java.lang.reflect.Array;
import org.jcodec.codecs.aac.Profile;
import org.jcodec.codecs.prores.ProresDecoder;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;
import org.jcodec.common.io.VLCBuilder;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class BlockICS extends Block {
    private static final int MAX_LTP_LONG_SFB = 40;
    private static final int POW_SF2_ZERO = 200;
    private int[] band_type;
    private int[] band_type_run_end;
    private boolean commonWindow;
    public float[][] ff_aac_codebook_vector_vals;
    private int globalGain;
    private int[] group_len;
    public int maxSfb;
    private int numSwb;
    private int numWindows;
    public int num_window_groups;
    private Profile profile;
    private int samplingIndex;
    private boolean scaleFlag;
    private double[] sfs;
    private int[] swbOffset;
    private int windowSequence;
    private static VLC vlc = new VLC(AACTab.ff_aac_scalefactor_code, AACTab.ff_aac_scalefactor_bits);
    private static VLC[] spectral = {VLCBuilder.createVLCBuilder(AACTab.codes1, AACTab.bits1, AACTab.codebook_vector02_idx).getVLC(), VLCBuilder.createVLCBuilder(AACTab.codes2, AACTab.bits2, AACTab.codebook_vector02_idx).getVLC(), VLCBuilder.createVLCBuilder(AACTab.codes3, AACTab.bits3, AACTab.codebook_vector02_idx).getVLC(), VLCBuilder.createVLCBuilder(AACTab.codes4, AACTab.bits4, AACTab.codebook_vector02_idx).getVLC(), VLCBuilder.createVLCBuilder(AACTab.codes5, AACTab.bits5, AACTab.codebook_vector4_idx).getVLC(), VLCBuilder.createVLCBuilder(AACTab.codes6, AACTab.bits6, AACTab.codebook_vector4_idx).getVLC(), VLCBuilder.createVLCBuilder(AACTab.codes7, AACTab.bits7, AACTab.codebook_vector6_idx).getVLC(), VLCBuilder.createVLCBuilder(AACTab.codes8, AACTab.bits8, AACTab.codebook_vector6_idx).getVLC(), VLCBuilder.createVLCBuilder(AACTab.codes9, AACTab.bits9, AACTab.codebook_vector8_idx).getVLC(), VLCBuilder.createVLCBuilder(AACTab.codes10, AACTab.bits10, AACTab.codebook_vector8_idx).getVLC(), VLCBuilder.createVLCBuilder(AACTab.codes11, AACTab.bits11, AACTab.codebook_vector10_idx).getVLC()};
    public static float[] ff_aac_pow2sf_tab = new float[428];

    public enum BandType {
        ZERO_BT,
        BT_1,
        BT_2,
        BT_3,
        BT_4,
        FIRST_PAIR_BT,
        BT_6,
        BT_7,
        BT_8,
        BT_9,
        BT_10,
        ESC_BT,
        BT_12,
        NOISE_BT,
        INTENSITY_BT2,
        INTENSITY_BT
    }

    public static class Pulse {
        private int[] amp;
        private int numPulse;
        private int[] pos;

        public Pulse(int i, int[] iArr, int[] iArr2) {
            this.numPulse = i;
            this.pos = iArr;
            this.amp = iArr2;
        }

        public int[] getAmp() {
            return this.amp;
        }

        public int getNumPulse() {
            return this.numPulse;
        }

        public int[] getPos() {
            return this.pos;
        }
    }

    public static class Tns {
        private float[][][] coeff;
        private int[][] direction;
        private int[][] length;
        private int[] nFilt;
        private int[][] order;

        public Tns(int[] iArr, int[][] iArr2, int[][] iArr3, int[][] iArr4, float[][][] fArr) {
            this.nFilt = iArr;
            this.length = iArr2;
            this.order = iArr3;
            this.direction = iArr4;
            this.coeff = fArr;
        }
    }

    public enum WindowSequence {
        ONLY_LONG_SEQUENCE,
        LONG_START_SEQUENCE,
        EIGHT_SHORT_SEQUENCE,
        LONG_STOP_SEQUENCE
    }

    static {
        for (int i = 0; i < 428; i++) {
            ff_aac_pow2sf_tab[i] = (float) Math.pow(2.0d, (i - 200) / 4.0d);
        }
    }

    public BlockICS() {
        float[] fArr = AACTab.codebook_vector0_vals;
        float[] fArr2 = AACTab.codebook_vector10_vals;
        float[] fArr3 = AACTab.codebook_vector4_vals;
        float[] fArr4 = AACTab.codebook_vector10_vals;
        this.ff_aac_codebook_vector_vals = new float[][]{fArr, fArr, fArr2, fArr2, fArr3, fArr3, fArr4, fArr4, fArr4, fArr4, fArr4};
        this.group_len = new int[8];
        this.band_type = new int[120];
        this.band_type_run_end = new int[120];
    }

    private void decodeBandTypes(BitReader bitReader) {
        int nBit;
        int i;
        int i2 = this.windowSequence == WindowSequence.EIGHT_SHORT_SEQUENCE.ordinal() ? 3 : 5;
        int i3 = 0;
        for (int i4 = 0; i4 < this.num_window_groups; i4++) {
            int i5 = 0;
            while (i5 < this.maxSfb) {
                int nBit2 = bitReader.readNBit(4);
                if (nBit2 == 12) {
                    throw new RuntimeException("invalid band type");
                }
                int i6 = i5;
                while (true) {
                    nBit = bitReader.readNBit(i2);
                    i = (1 << i2) - 1;
                    if (nBit != i) {
                        break;
                    } else {
                        i6 += nBit;
                    }
                }
                int i7 = i6 + nBit;
                if (!bitReader.moreData() || nBit == i) {
                    throw new RuntimeException("Overread");
                }
                if (i7 > this.maxSfb) {
                    throw new RuntimeException(String.format("Number of bands (%d) exceeds limit (%d).\n", Integer.valueOf(i7), Integer.valueOf(this.maxSfb)));
                }
                while (i5 < i7) {
                    this.band_type[i3] = nBit2;
                    this.band_type_run_end[i3] = i7;
                    i5++;
                    i3++;
                }
            }
        }
    }

    private void decodeLtp(BitReader bitReader, int i) {
        bitReader.readNBit(11);
        float f = AACTab.ltpCoefTab[bitReader.readNBit(3)];
        for (int i2 = 0; i2 < Math.min(i, 40); i2++) {
            bitReader.read1Bit();
        }
    }

    private void decodePrediction(BitReader bitReader, int i) {
        if (bitReader.read1Bit() != 0) {
            bitReader.readNBit(5);
        }
        for (int i2 = 0; i2 < Math.min(i, AACTab.maxSfbTab[this.samplingIndex]); i2++) {
            bitReader.read1Bit();
        }
    }

    private Pulse decodePulses(BitReader bitReader) {
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int nBit = bitReader.readNBit(2) + 1;
        int nBit2 = bitReader.readNBit(6);
        if (nBit2 >= this.numSwb) {
            throw new RuntimeException("pulseSwb >= numSwb");
        }
        int i = this.swbOffset[nBit2];
        iArr[0] = i;
        int nBit3 = i + bitReader.readNBit(5);
        iArr[0] = nBit3;
        if (nBit3 > 1023) {
            throw new RuntimeException("pos[0] > 1023");
        }
        iArr2[0] = bitReader.readNBit(4);
        for (int i2 = 1; i2 < nBit; i2++) {
            int nBit4 = bitReader.readNBit(5) + iArr[i2 - 1];
            iArr[i2] = nBit4;
            if (nBit4 > 1023) {
                throw new RuntimeException("pos[" + i2 + "] > 1023");
            }
            iArr2[i2] = bitReader.readNBit(5);
        }
        return new Pulse(nBit, iArr, iArr2);
    }

    private void decodeScalefactors(BitReader bitReader) {
        int i = this.globalGain;
        int[] iArr = {i, i - 90, 0};
        String[] strArr = {"Global gain", "Noise gain", "Intensity stereo position"};
        int i2 = 0;
        int i3 = 1;
        for (int i4 = 0; i4 < this.num_window_groups; i4++) {
            int i5 = 0;
            while (i5 < this.maxSfb) {
                int i6 = this.band_type_run_end[i2];
                if (this.band_type[i2] == BandType.ZERO_BT.ordinal()) {
                    while (i5 < i6) {
                        this.sfs[i2] = 0.0d;
                        i5++;
                        i2++;
                    }
                } else if (this.band_type[i2] == BandType.INTENSITY_BT.ordinal() || this.band_type[i2] == BandType.INTENSITY_BT2.ordinal()) {
                    while (i5 < i6) {
                        int vlc2 = iArr[2] + (vlc.readVLC(bitReader) - 60);
                        iArr[2] = vlc2;
                        int iClip = MathUtil.clip(vlc2, -155, 100);
                        int i7 = iArr[2];
                        if (i7 != iClip) {
                            System.out.println(String.format("Intensity stereo position clipped (%d -> %d).\nIf you heard an audible artifact, there may be a bug _in the decoder. ", Integer.valueOf(i7), Integer.valueOf(iClip)));
                        }
                        this.sfs[i2] = ff_aac_pow2sf_tab[(-iClip) + 200];
                        i5++;
                        i2++;
                    }
                } else if (this.band_type[i2] == BandType.NOISE_BT.ordinal()) {
                    while (i5 < i6) {
                        int i8 = i3 - 1;
                        if (i3 > 0) {
                            iArr[1] = iArr[1] + bitReader.readNBit(9) + InputDeviceCompat.SOURCE_ANY;
                        } else {
                            iArr[1] = iArr[1] + (vlc.readVLC(bitReader) - 60);
                        }
                        int iClip2 = MathUtil.clip(iArr[1], -100, 155);
                        int i9 = iArr[1];
                        if (i9 != iClip2) {
                            System.out.println(String.format("Noise gain clipped (%d -> %d).\nIf you heard an audible artifact, there may be a bug _in the decoder. ", Integer.valueOf(i9), Integer.valueOf(iClip2)));
                        }
                        this.sfs[i2] = -ff_aac_pow2sf_tab[iClip2 + 200];
                        i5++;
                        i2++;
                        i3 = i8;
                    }
                } else {
                    while (i5 < i6) {
                        int vlc3 = iArr[0] + (vlc.readVLC(bitReader) - 60);
                        iArr[0] = vlc3;
                        if (vlc3 > 255) {
                            throw new RuntimeException(String.format("%s (%d) out of range.\n", strArr[0], Integer.valueOf(iArr[0])));
                        }
                        this.sfs[i2] = -ff_aac_pow2sf_tab[(vlc3 - 100) + 200];
                        i5++;
                        i2++;
                    }
                }
            }
        }
    }

    private void decodeSpectrum(BitReader bitReader) {
        float[] fArr = new float[1024];
        int i = 0;
        int i2 = 0;
        while (i2 < this.num_window_groups) {
            int i3 = i;
            int i4 = 0;
            while (i4 < this.maxSfb) {
                int i5 = this.band_type[i3] - 1;
                if (i5 < BandType.INTENSITY_BT2.ordinal() - 1 && i5 != BandType.NOISE_BT.ordinal() - 1) {
                    float[] fArr2 = this.ff_aac_codebook_vector_vals[i5];
                    VLC vlc2 = spectral[i5];
                    int i6 = i5 >> 1;
                    if (i6 == 0) {
                        readBandType1And2(bitReader, fArr, i3, i2, i4, fArr2, vlc2);
                    } else if (i6 == 1) {
                        readBandType3And4(bitReader, fArr, i3, i2, i4, fArr2, vlc2);
                    } else if (i6 == 2) {
                        readBandType5And6(bitReader, fArr, i3, i2, i4, fArr2, vlc2);
                    } else if (i6 == 3 || i6 == 4) {
                        readBandType7Through10(bitReader, fArr, i3, i2, i4, fArr2, vlc2);
                    } else {
                        readOther(bitReader, fArr, i3, i2, i4, fArr2, vlc2);
                    }
                }
                i4++;
                i3++;
            }
            i2++;
            i = i3;
        }
    }

    private Tns decodeTns(BitReader bitReader) {
        int i;
        char c;
        int i2;
        BlockICS blockICS = this;
        int i3 = 0;
        int i4 = blockICS.windowSequence == WindowSequence.EIGHT_SHORT_SEQUENCE.ordinal() ? 1 : 0;
        int i5 = i4 != 0 ? 7 : blockICS.profile == Profile.MAIN ? 20 : 12;
        int i6 = blockICS.numWindows;
        int[] iArr = new int[i6];
        char c2 = 2;
        int[] iArr2 = {i6, 2};
        Class cls = Integer.TYPE;
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) cls, iArr2);
        int[][] iArr4 = (int[][]) Array.newInstance((Class<?>) cls, blockICS.numWindows, 2);
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) cls, blockICS.numWindows, 2);
        int i7 = i4 * 2;
        int i8 = 5 - i7;
        float[][][] fArr = (float[][][]) Array.newInstance((Class<?>) Float.TYPE, blockICS.numWindows, 2, 1 << i8);
        int i9 = 0;
        while (i9 < blockICS.numWindows) {
            int nBit = bitReader.readNBit(2 - i4);
            iArr[i9] = nBit;
            if (nBit != 0) {
                int i10 = bitReader.read1Bit();
                int i11 = i3;
                while (i11 < iArr[i9]) {
                    iArr3[i9][i11] = bitReader.readNBit(6 - i7);
                    int[] iArr6 = iArr4[i9];
                    int nBit2 = bitReader.readNBit(i8);
                    iArr6[i11] = nBit2;
                    if (nBit2 > i5) {
                        throw new RuntimeException(String.format("TNS filter order %d is greater than maximum %d.\n", Integer.valueOf(iArr4[i9][i11]), Integer.valueOf(i5)));
                    }
                    if (iArr4[i9][i11] != 0) {
                        iArr5[i9][i11] = bitReader.read1Bit();
                        int i12 = bitReader.read1Bit();
                        int i13 = (i10 + 3) - i12;
                        int i14 = (i12 * 2) + i10;
                        int i15 = 0;
                        while (true) {
                            i2 = i4;
                            if (i15 < iArr4[i9][i11]) {
                                fArr[i9][i11][i15] = AACTab.tns_tmp2_map[i14][bitReader.readNBit(i13)];
                                i15++;
                                i4 = i2;
                            }
                        }
                    } else {
                        i2 = i4;
                    }
                    i11++;
                    i4 = i2;
                    c2 = 2;
                }
                i = i4;
                c = c2;
                i3 = 0;
            } else {
                i = i4;
                c = c2;
            }
            i9++;
            blockICS = this;
            c2 = c;
            i4 = i;
        }
        return new Tns(iArr, iArr3, iArr4, iArr5, fArr);
    }

    private void readBandType1And2(BitReader bitReader, float[] fArr, int i, int i2, int i3, float[] fArr2, VLC vlc2) {
        int i4 = this.group_len[i2];
        int[] iArr = this.swbOffset;
        int i5 = iArr[i3];
        int i6 = iArr[i3 + 1] - i5;
        int i7 = 0;
        int i8 = i5;
        while (i7 < i4) {
            int i9 = i6;
            int i10 = i8;
            do {
                VMUL4(fArr, i10, fArr2, vlc2.readVLC(bitReader), (float) this.sfs[i]);
                i10 += 4;
                i9 -= 4;
            } while (i9 > 0);
            i7++;
            i8 += 128;
        }
    }

    private void readBandType3And4(BitReader bitReader, float[] fArr, int i, int i2, int i3, float[] fArr2, VLC vlc2) {
        int i4 = this.group_len[i2];
        int[] iArr = this.swbOffset;
        int i5 = iArr[i3];
        int i6 = iArr[i3 + 1] - i5;
        int i7 = i5;
        int i8 = 0;
        while (i8 < i4) {
            int i9 = i6;
            int i10 = i7;
            do {
                int vlc3 = vlc2.readVLC(bitReader);
                int i11 = (vlc3 >> 8) & 15;
                VMUL4S(fArr, i10, fArr2, vlc3, i11 == 0 ? 0 : bitReader.readNBit(i11), (float) this.sfs[i]);
                i10 += 4;
                i9 -= 4;
            } while (i9 > 0);
            i8++;
            i7 += 128;
        }
    }

    private void readBandType5And6(BitReader bitReader, float[] fArr, int i, int i2, int i3, float[] fArr2, VLC vlc2) {
        int i4 = this.group_len[i2];
        int[] iArr = this.swbOffset;
        int i5 = iArr[i3];
        int i6 = iArr[i3 + 1] - i5;
        int i7 = 0;
        int i8 = i5;
        while (i7 < i4) {
            int i9 = i6;
            int i10 = i8;
            do {
                VMUL2(fArr, i10, fArr2, vlc2.readVLC(bitReader), (float) this.sfs[i]);
                i10 += 2;
                i9 -= 2;
            } while (i9 > 0);
            i7++;
            i8 += 128;
        }
    }

    private void readBandType7Through10(BitReader bitReader, float[] fArr, int i, int i2, int i3, float[] fArr2, VLC vlc2) {
        int i4 = this.group_len[i2];
        int[] iArr = this.swbOffset;
        int i5 = iArr[i3];
        int i6 = iArr[i3 + 1] - i5;
        int i7 = i5;
        int i8 = 0;
        while (i8 < i4) {
            int i9 = i6;
            int i10 = i7;
            do {
                int vlc3 = vlc2.readVLC(bitReader);
                int i11 = (vlc3 >> 8) & 15;
                VMUL2S(fArr, i10, fArr2, vlc3, i11 == 0 ? 0 : bitReader.readNBit(i11) << (vlc3 >> 12), (float) this.sfs[i]);
                i10 += 2;
                i9 -= 2;
            } while (i9 > 0);
            i8++;
            i7 += 128;
        }
    }

    private void readOther(BitReader bitReader, float[] fArr, int i, int i2, int i3, float[] fArr2, VLC vlc2) {
        int i4;
        int i5 = this.group_len[i2];
        int[] iArr = this.swbOffset;
        int i6 = iArr[i3];
        int i7 = iArr[i3 + 1] - i6;
        int i8 = 0;
        while (i8 < i5) {
            int i9 = i7;
            int i10 = i6;
            do {
                int vlc3 = vlc2.readVLC(bitReader);
                if (vlc3 != 0) {
                    int i11 = vlc3 >> 12;
                    int i12 = vlc3 >> 8;
                    int nBit = bitReader.readNBit(i11) << (32 - i11);
                    for (int i13 = 0; i13 < 2; i13++) {
                        if (((1 << i13) & i12) != 0) {
                            int iNZeros = ProresDecoder.nZeros(~bitReader.checkNBit(14));
                            if (iNZeros > 8) {
                                throw new RuntimeException("error _in spectral data, ESC overflow\n");
                            }
                            bitReader.skip(iNZeros + 1);
                            int i14 = iNZeros + 4;
                            int nBit2 = (1 << i14) + bitReader.readNBit(i14);
                            i4 = i10 + 1;
                            fArr[i10] = MathUtil.cubeRoot(nBit2) | (nBit & Integer.MIN_VALUE);
                            nBit <<= 1;
                        } else {
                            i4 = i10 + 1;
                            fArr[i10] = (nBit & Integer.MIN_VALUE) | ((int) fArr2[vlc3 & 15]);
                        }
                        i10 = i4;
                        vlc3 >>= 4;
                    }
                    i10 += 2;
                    i9 += 2;
                }
            } while (i9 > 0);
            i8++;
            i6 += 128;
        }
    }

    public void VMUL2(float[] fArr, int i, float[] fArr2, int i2, float f) {
        fArr[i] = fArr2[i2 & 15] * f;
        fArr[i + 1] = fArr2[(i2 >> 4) & 15] * f;
    }

    public void VMUL2S(float[] fArr, int i, float[] fArr2, int i2, int i3, float f) {
        fArr[i] = fArr2[i2 & 15] * f;
        fArr[i + 1] = fArr2[(i2 >> 4) & 15] * f;
    }

    public void VMUL4(float[] fArr, int i, float[] fArr2, int i2, float f) {
        fArr[i] = fArr2[i2 & 3] * f;
        fArr[i + 1] = fArr2[(i2 >> 2) & 3] * f;
        fArr[i + 2] = fArr2[(i2 >> 4) & 3] * f;
        fArr[i + 3] = fArr2[(i2 >> 6) & 3] * f;
    }

    public void VMUL4S(float[] fArr, int i, float[] fArr2, int i2, int i3, float f) {
        fArr[i + 0] = fArr2[i & 3] * f;
        fArr[i + 1] = fArr2[(i >> 2) & 3] * f;
        fArr[i + 2] = fArr2[(i >> 4) & 3] * f;
        fArr[i + 3] = fArr2[(i >> 6) & 3] * f;
    }

    @Override // org.jcodec.codecs.aac.blocks.Block
    public void parse(BitReader bitReader) {
        this.globalGain = bitReader.readNBit(8);
        if (!this.commonWindow && !this.scaleFlag) {
            parseICSInfo(bitReader);
        }
        decodeBandTypes(bitReader);
        decodeScalefactors(bitReader);
        if (!this.scaleFlag) {
            if (bitReader.read1Bit() != 0) {
                if (this.windowSequence == WindowSequence.EIGHT_SHORT_SEQUENCE.ordinal()) {
                    throw new RuntimeException("Pulse tool not allowed _in eight short sequence.");
                }
                decodePulses(bitReader);
            }
            if (bitReader.read1Bit() != 0) {
                decodeTns(bitReader);
            }
            if (bitReader.read1Bit() != 0) {
                throw new RuntimeException("SSR is not supported");
            }
        }
        decodeSpectrum(bitReader);
    }

    public int parseICSInfo(BitReader bitReader) {
        bitReader.read1Bit();
        this.windowSequence = bitReader.readNBit(2);
        bitReader.read1Bit();
        this.num_window_groups = 1;
        this.group_len[0] = 1;
        if (this.windowSequence == WindowSequence.EIGHT_SHORT_SEQUENCE.ordinal()) {
            bitReader.readNBit(4);
            for (int i = 0; i < 7; i++) {
                if (bitReader.read1Bit() != 0) {
                    int[] iArr = this.group_len;
                    int i2 = this.num_window_groups - 1;
                    iArr[i2] = iArr[i2] + 1;
                } else {
                    int i3 = this.num_window_groups + 1;
                    this.num_window_groups = i3;
                    this.group_len[i3 - 1] = 1;
                }
            }
            int[] iArr2 = AACTab.ff_aac_num_swb_128;
            int i4 = this.samplingIndex;
            this.numSwb = iArr2[i4];
            this.swbOffset = AACTab.ff_swb_offset_128[i4];
            this.numWindows = 8;
        } else {
            this.maxSfb = bitReader.readNBit(6);
            int[] iArr3 = AACTab.ff_aac_num_swb_1024;
            int i5 = this.samplingIndex;
            this.numSwb = iArr3[i5];
            this.swbOffset = AACTab.ff_swb_offset_1024[i5];
            this.numWindows = 1;
            if (bitReader.read1Bit() != 0) {
                Profile profile = this.profile;
                if (profile == Profile.MAIN) {
                    decodePrediction(bitReader, this.maxSfb);
                } else {
                    if (profile == Profile.LC) {
                        throw new RuntimeException("Prediction is not allowed _in AAC-LC.\n");
                    }
                    if (bitReader.read1Bit() != 0) {
                        decodeLtp(bitReader, this.maxSfb);
                    }
                }
            }
        }
        return 0;
    }
}
