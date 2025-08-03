package org.jcodec.codecs.mpa;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.jcodec.codecs.mpa.Mp3Bitstream;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.AudioDecoder;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.AudioBuffer;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class Mp3Decoder implements AudioDecoder {
    private static final boolean[] ALL_TRUE = {true, true, true, true};
    private static final int NUM_BANDS = 32;
    private static final int SAMPLES_PER_BAND = 18;
    private static final double fourByThree = 1.3333333333333333d;
    private int channels;
    private boolean initialized;
    private float[][] prevBlk;
    private int sfreq;
    private ChannelSynthesizer[] filter = {null, null};
    private ByteBuffer frameData = ByteBuffer.allocate(4096);
    private float[] samples = new float[32];
    private float[] mdctIn = new float[18];
    private float[] mdctOut = new float[36];
    private float[][] dequant = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 2, 576);
    private short[][] tmpOut = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 2, 576);

    private void antialias(Mp3Bitstream.Granule granule, float[] fArr) {
        boolean z = granule.windowSwitchingFlag;
        if (z && granule.blockType == 2 && !granule.mixedBlockFlag) {
            return;
        }
        int i = (z && granule.mixedBlockFlag && granule.blockType == 2) ? 1 : 31;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            for (int i4 = 0; i4 < 8; i4++) {
                int i5 = (i3 + 17) - i4;
                int i6 = i3 + 18 + i4;
                float f = fArr[i5];
                float f2 = fArr[i6];
                float[] fArr2 = MpaConst.cs;
                float f3 = fArr2[i4] * f;
                float[] fArr3 = MpaConst.ca;
                fArr[i5] = f3 - (fArr3[i4] * f2);
                fArr[i6] = (f2 * fArr2[i4]) + (f * fArr3[i4]);
            }
            i2++;
            i3 += 18;
        }
    }

    public static void appendSamples(ByteBuffer byteBuffer, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            byteBuffer.putShort(sArr[i2]);
        }
    }

    public static void appendSamplesInterleave(ByteBuffer byteBuffer, short[] sArr, short[] sArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            byteBuffer.putShort(sArr[i2]);
            byteBuffer.putShort(sArr2[i2]);
        }
    }

    private void decodeGranule(MpaHeader mpaHeader, ByteBuffer byteBuffer, Mp3Bitstream.MP3SideInfo mP3SideInfo, BitReader bitReader, Mp3Bitstream.ScaleFactors[] scaleFactorsArr, int i) {
        int i2;
        int i3;
        Arrays.fill(this.dequant[0], 0.0f);
        Arrays.fill(this.dequant[1], 0.0f);
        int i4 = 0;
        while (true) {
            i2 = this.channels;
            if (i4 >= i2) {
                break;
            }
            int iPosition = bitReader.position();
            Mp3Bitstream.Granule granule = mP3SideInfo.granule[i4][i];
            if (mpaHeader.version == 1) {
                Mp3Bitstream.ScaleFactors scaleFactors = scaleFactorsArr[i4];
                boolean[] zArr = i == 0 ? ALL_TRUE : mP3SideInfo.scfsi[i4];
                Mp3Bitstream.ScaleFactors scaleFactors2 = Mp3Bitstream.readScaleFactors(bitReader, granule, zArr);
                scaleFactorsArr[i4] = scaleFactors2;
                mergeScaleFac(scaleFactors2, scaleFactors, zArr);
            } else {
                scaleFactorsArr[i4] = Mp3Bitstream.readLSFScaleFactors(bitReader, mpaHeader, granule, i4);
            }
            int[] iArr = new int[580];
            dequantizeCoeffs(iArr, Mp3Bitstream.readCoeffs(bitReader, granule, i4, iPosition, this.sfreq, iArr), granule, scaleFactorsArr[i4], this.dequant[i4]);
            i4++;
        }
        if ((mpaHeader.mode == 1 && (mpaHeader.modeExtension & 2) != 0) && i2 == 2) {
            decodeMsStereo(mpaHeader, mP3SideInfo.granule[0][i], scaleFactorsArr, this.dequant);
        }
        int i5 = 0;
        while (true) {
            i3 = this.channels;
            if (i5 >= i3) {
                break;
            }
            float[] fArr = this.dequant[i5];
            Mp3Bitstream.Granule granule2 = mP3SideInfo.granule[i5][i];
            antialias(granule2, fArr);
            mdctDecode(i5, granule2, fArr);
            for (int i6 = 18; i6 < 576; i6 += 36) {
                for (int i7 = 1; i7 < 18; i7 += 2) {
                    int i8 = i6 + i7;
                    fArr[i8] = -fArr[i8];
                }
            }
            int i9 = 0;
            int i10 = 0;
            while (i9 < 18) {
                int i11 = 0;
                int i12 = 0;
                while (i11 < 576) {
                    this.samples[i12] = fArr[i11 + i9];
                    i11 += 18;
                    i12++;
                }
                this.filter[i5].synthesize(this.samples, this.tmpOut[i5], i10);
                i9++;
                i10 += 32;
            }
            i5++;
        }
        if (i3 != 2) {
            appendSamples(byteBuffer, this.tmpOut[0], 576);
        } else {
            short[][] sArr = this.tmpOut;
            appendSamplesInterleave(byteBuffer, sArr[0], sArr[1], 576);
        }
    }

    private void decodeMsStereo(MpaHeader mpaHeader, Mp3Bitstream.Granule granule, Mp3Bitstream.ScaleFactors[] scaleFactorsArr, float[][] fArr) {
        for (int i = 0; i < 576; i++) {
            float[] fArr2 = fArr[0];
            float f = fArr2[i];
            float[] fArr3 = fArr[1];
            float f2 = fArr3[i];
            fArr2[i] = (f + f2) * 0.70710677f;
            fArr3[i] = (f - f2) * 0.70710677f;
        }
    }

    private void dequantLong(int[] iArr, int i, Mp3Bitstream.Granule granule, Mp3Bitstream.ScaleFactors scaleFactors, float f, float[] fArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i2 + 1;
            if (i3 == MpaConst.sfbLong[this.sfreq][i4]) {
                i2 = i4;
            }
            fArr[i3] = pow43(iArr[i3]) * f * MpaConst.quantizerTab[(scaleFactors.large[i2] + (granule.preflag ? MpaConst.pretab[i2] : 0)) << granule.scalefacScale];
        }
    }

    private void dequantMixed(int[] iArr, int i, Mp3Bitstream.Granule granule, Mp3Bitstream.ScaleFactors scaleFactors, float f, float[] fArr) {
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (i3 < 8 && i4 < i) {
            while (true) {
                i2 = i3 + 1;
                if (i4 >= MpaConst.sfbLong[this.sfreq][i2] || i4 >= i) {
                    break;
                }
                fArr[i4] = pow43(iArr[i4]) * f * MpaConst.quantizerTab[(scaleFactors.large[i3] + (granule.preflag ? MpaConst.pretab[i3] : 0)) << granule.scalefacScale];
                i4++;
            }
            i3 = i2;
        }
        int i5 = 3;
        while (i5 < 12 && i4 < i) {
            int[] iArr2 = MpaConst.sfbShort[this.sfreq];
            int i6 = i5 + 1;
            int i7 = iArr2[i6] - iArr2[i5];
            int i8 = i4;
            for (int i9 = 0; i9 < 3; i9++) {
                int i10 = 0;
                while (i10 < i7 && i8 < i) {
                    fArr[(i10 * 3) + i4 + i9] = pow43(iArr[i8]) * f * MpaConst.quantizerTab[(scaleFactors.small[i9][i5] << granule.scalefacScale) + (granule.subblockGain[i9] << 2)];
                    i10++;
                    i8++;
                }
            }
            i4 = i8;
            i5 = i6;
        }
    }

    private void dequantShort(int[] iArr, int i, Mp3Bitstream.Granule granule, Mp3Bitstream.ScaleFactors scaleFactors, float f, float[] fArr) {
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4 = i2) {
            int[] iArr2 = MpaConst.sfbShort[this.sfreq];
            int i5 = i3 + 1;
            int i6 = iArr2[i5] - iArr2[i3];
            i2 = i4;
            for (int i7 = 0; i7 < 3; i7++) {
                int i8 = 0;
                while (i8 < i6 && i2 < i) {
                    fArr[(i8 * 3) + i4 + i7] = pow43(iArr[i2]) * f * MpaConst.quantizerTab[(scaleFactors.small[i7][i3] << granule.scalefacScale) + (granule.subblockGain[i7] << 2)];
                    i8++;
                    i2++;
                }
            }
            i3 = i5;
        }
    }

    private void dequantizeCoeffs(int[] iArr, int i, Mp3Bitstream.Granule granule, Mp3Bitstream.ScaleFactors scaleFactors, float[] fArr) {
        float fPow = (float) Math.pow(2.0d, (granule.globalGain - 210.0d) * 0.25d);
        if (!granule.windowSwitchingFlag || granule.blockType != 2) {
            dequantLong(iArr, i, granule, scaleFactors, fPow, fArr);
        } else if (granule.mixedBlockFlag) {
            dequantMixed(iArr, i, granule, scaleFactors, fPow, fArr);
        } else {
            dequantShort(iArr, i, granule, scaleFactors, fPow, fArr);
        }
    }

    private void init(MpaHeader mpaHeader) {
        this.channels = mpaHeader.mode == 3 ? 1 : 2;
        this.filter[0] = new ChannelSynthesizer(0, 32700.0f);
        if (this.channels == 2) {
            this.filter[1] = new ChannelSynthesizer(1, 32700.0f);
        }
        this.prevBlk = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 2, 576);
        int i = mpaHeader.sampleFreq;
        int i2 = mpaHeader.version;
        this.sfreq = i + (i2 != 1 ? i2 == 2 ? 6 : 0 : 3);
        for (int i3 = 0; i3 < 2; i3++) {
            Arrays.fill(this.prevBlk[i3], 0.0f);
        }
        this.initialized = true;
    }

    private void mdctDecode(int i, Mp3Bitstream.Granule granule, float[] fArr) {
        int i2 = 0;
        while (i2 < 576) {
            int i3 = (granule.windowSwitchingFlag && granule.mixedBlockFlag && i2 < 36) ? 0 : granule.blockType;
            for (int i4 = 0; i4 < 18; i4++) {
                this.mdctIn[i4] = fArr[i4 + i2];
            }
            if (i3 == 2) {
                Mp3Mdct.threeShort(this.mdctIn, this.mdctOut);
            } else {
                Mp3Mdct.oneLong(this.mdctIn, this.mdctOut);
                for (int i5 = 0; i5 < 36; i5++) {
                    float[] fArr2 = this.mdctOut;
                    fArr2[i5] = fArr2[i5] * MpaConst.win[i3][i5];
                }
            }
            for (int i6 = 0; i6 < 18; i6++) {
                int i7 = i6 + i2;
                float[] fArr3 = this.mdctOut;
                float f = fArr3[i6];
                float[] fArr4 = this.prevBlk[i];
                fArr[i7] = f + fArr4[i7];
                fArr4[i7] = fArr3[i6 + 18];
            }
            i2 += 18;
        }
    }

    private void mergeScaleFac(Mp3Bitstream.ScaleFactors scaleFactors, Mp3Bitstream.ScaleFactors scaleFactors2, boolean[] zArr) {
        if (!zArr[0]) {
            for (int i = 0; i < 6; i++) {
                scaleFactors.large[i] = scaleFactors2.large[i];
            }
        }
        if (!zArr[1]) {
            for (int i2 = 6; i2 < 11; i2++) {
                scaleFactors.large[i2] = scaleFactors2.large[i2];
            }
        }
        if (!zArr[2]) {
            for (int i3 = 11; i3 < 16; i3++) {
                scaleFactors.large[i3] = scaleFactors2.large[i3];
            }
        }
        if (zArr[3]) {
            return;
        }
        for (int i4 = 16; i4 < 21; i4++) {
            scaleFactors.large[i4] = scaleFactors2.large[i4];
        }
    }

    private float pow43(int i) {
        float f;
        float fPow;
        if (i == 0) {
            return 0.0f;
        }
        int i2 = 1 - ((i >>> 31) << 1);
        int iAbs = MathUtil.abs(i);
        float[] fArr = MpaConst.power43Tab;
        if (iAbs < fArr.length) {
            f = i2;
            fPow = fArr[iAbs];
        } else {
            f = i2;
            fPow = (float) Math.pow(iAbs, fourByThree);
        }
        return f * fPow;
    }

    @Override // org.jcodec.common.AudioDecoder
    public AudioBuffer decodeFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws IOException {
        MpaHeader mpaHeader = MpaHeader.read_header(byteBuffer);
        if (!this.initialized) {
            init(mpaHeader);
        }
        if (mpaHeader.mode == 1 && (mpaHeader.modeExtension & 1) != 0) {
            throw new RuntimeException("Intensity stereo is not supported.");
        }
        byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        Mp3Bitstream.MP3SideInfo sideInfo = Mp3Bitstream.readSideInfo(mpaHeader, byteBuffer, this.channels);
        int iPosition = this.frameData.position();
        this.frameData.put(NIOUtils.read(byteBuffer, mpaHeader.frameBytes));
        this.frameData.flip();
        if (mpaHeader.protectionBit == 0) {
            byteBuffer.getShort();
        }
        NIOUtils.skip(this.frameData, iPosition - sideInfo.mainDataBegin);
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(this.frameData);
        Mp3Bitstream.ScaleFactors[] scaleFactorsArr = new Mp3Bitstream.ScaleFactors[2];
        decodeGranule(mpaHeader, byteBuffer2, sideInfo, bitReaderCreateBitReader, scaleFactorsArr, 0);
        if (mpaHeader.version == 1) {
            decodeGranule(mpaHeader, byteBuffer2, sideInfo, bitReaderCreateBitReader, scaleFactorsArr, 1);
        }
        bitReaderCreateBitReader.terminate();
        NIOUtils.relocateLeftover(this.frameData);
        byteBuffer2.flip();
        return new AudioBuffer(byteBuffer2, null, 1);
    }

    @Override // org.jcodec.common.AudioDecoder
    public AudioCodecMeta getCodecMeta(ByteBuffer byteBuffer) throws IOException {
        MpaHeader mpaHeader = MpaHeader.read_header(byteBuffer.duplicate());
        return AudioCodecMeta.fromAudioFormat(new AudioFormat(MpaConst.frequencies[mpaHeader.version][mpaHeader.sampleFreq], 16, mpaHeader.mode == 3 ? 1 : 2, true, false));
    }
}
