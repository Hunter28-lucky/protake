package org.jcodec.codecs.mpeg12;

import java.util.Arrays;
import org.jcodec.codecs.mpeg12.MPEGDecoder;
import org.jcodec.codecs.mpeg12.bitstream.PictureCodingExtension;
import org.jcodec.codecs.mpeg12.bitstream.PictureHeader;
import org.jcodec.codecs.mpeg12.bitstream.SequenceHeader;
import org.jcodec.common.dct.IDCT4x4;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;

/* loaded from: classes2.dex */
public class Mpeg2Thumb4x4 extends MPEGDecoder {
    public static int[] BLOCK_POS_X = {0, 4, 0, 4, 0, 0, 0, 0, 4, 4, 4, 4, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 4, 4, 4, 4};
    public static int[] BLOCK_POS_Y = {0, 0, 4, 4, 0, 0, 4, 4, 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1};
    public static int[][] scan4x4 = {new int[]{0, 1, 4, 8, 5, 2, 3, 6, 9, 12, 16, 13, 10, 7, 16, 16, 16, 11, 14, 16, 16, 16, 16, 16, 15, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16}, new int[]{0, 4, 8, 12, 1, 5, 2, 6, 9, 13, 16, 16, 16, 16, 16, 16, 16, 16, 14, 10, 3, 7, 16, 16, 11, 15, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16}};
    private MPEGPred localPred;
    private MPEGPred oldPred;

    private void finishOff(BitReader bitReader, int i, VLC vlc, int i2) {
        int vlc2;
        while (i < 64 && (vlc2 = vlc.readVLC(bitReader)) != 2048) {
            if (vlc2 == 2049) {
                i += bitReader.readNBit(6) + 1;
                bitReader.readNBit(i2);
            } else {
                bitReader.read1Bit();
            }
        }
    }

    @Override // org.jcodec.codecs.mpeg12.MPEGDecoder
    public void blockInter(BitReader bitReader, VLC vlc, int[] iArr, int[] iArr2, int i, int i2, int[] iArr3) {
        int nBit;
        int signed;
        Arrays.fill(iArr, 1, 16, 0);
        if (vlc == MPEGConst.vlcCoeff0 && bitReader.checkNBit(1) == 1) {
            bitReader.read1Bit();
            iArr[0] = MPEGDecoder.toSigned(MPEGDecoder.quantInter(1, iArr3[0] * i2), bitReader.read1Bit());
            nBit = 0;
        } else {
            iArr[0] = 0;
            nBit = -1;
        }
        int vlc2 = 0;
        while (true) {
            if (nBit >= (iArr2 == scan4x4[1] ? 7 : 0) + 19 || (vlc2 = vlc.readVLC(bitReader)) == 2048) {
                break;
            }
            if (vlc2 == 2049) {
                nBit += bitReader.readNBit(6) + 1;
                signed = MPEGDecoder.quantInterSigned(MPEGDecoder.twosSigned(bitReader, i), iArr3[nBit] * i2);
            } else {
                nBit += (vlc2 >> 6) + 1;
                signed = MPEGDecoder.toSigned(MPEGDecoder.quantInter(vlc2 & 63, iArr3[nBit] * i2), bitReader.read1Bit());
            }
            iArr[iArr2[nBit]] = signed;
        }
        if (vlc2 != 2048) {
            finishOff(bitReader, nBit, vlc, i);
        }
        IDCT4x4.idct(iArr, 0);
    }

    @Override // org.jcodec.codecs.mpeg12.MPEGDecoder
    public void blockIntra(BitReader bitReader, VLC vlc, int[] iArr, int[] iArr2, int i, int[] iArr3, int i2, int i3, int i4, int[] iArr4) {
        int signed;
        int i5 = MPEGConst.BLOCK_TO_CC[i];
        int vlc2 = (i5 == 0 ? MPEGConst.vlcDCSizeLuma : MPEGConst.vlcDCSizeChroma).readVLC(bitReader);
        iArr2[i5] = iArr2[i5] + (vlc2 != 0 ? MPEGDecoder.mpegSigned(bitReader, vlc2) : 0);
        Arrays.fill(iArr, 1, 16, 0);
        iArr[0] = iArr2[i5] * i3;
        int nBit = 0;
        int vlc3 = 0;
        while (true) {
            if (nBit >= (iArr3 == scan4x4[1] ? 7 : 0) + 19 || (vlc3 = vlc.readVLC(bitReader)) == 2048) {
                break;
            }
            if (vlc3 == 2049) {
                nBit += bitReader.readNBit(6) + 1;
                int iTwosSigned = MPEGDecoder.twosSigned(bitReader, i2) * i4 * iArr4[nBit];
                signed = iTwosSigned >= 0 ? iTwosSigned >> 4 : -((-iTwosSigned) >> 4);
            } else {
                nBit += (vlc3 >> 6) + 1;
                signed = MPEGDecoder.toSigned((((vlc3 & 63) * i4) * iArr4[nBit]) >> 4, bitReader.read1Bit());
            }
            iArr[iArr3[nBit]] = signed;
        }
        if (vlc3 != 2048) {
            finishOff(bitReader, nBit, vlc, i2);
        }
        IDCT4x4.idct(iArr, 0);
    }

    @Override // org.jcodec.codecs.mpeg12.MPEGDecoder
    public int decodeMacroblock(PictureHeader pictureHeader, MPEGDecoder.Context context, int i, int[] iArr, byte[][] bArr, int i2, BitReader bitReader, int i3, int i4, MPEGPred mPEGPred) {
        if (this.localPred == null || this.oldPred != mPEGPred) {
            this.localPred = new MPEGPredDbl(mPEGPred);
            this.oldPred = mPEGPred;
        }
        return super.decodeMacroblock(pictureHeader, context, i, iArr, bArr, i2, bitReader, i3, i4, this.localPred);
    }

    @Override // org.jcodec.codecs.mpeg12.MPEGDecoder
    public MPEGDecoder.Context initContext(SequenceHeader sequenceHeader, PictureHeader pictureHeader) {
        MPEGDecoder.Context contextInitContext = super.initContext(sequenceHeader, pictureHeader);
        contextInitContext.codedWidth >>= 1;
        contextInitContext.codedHeight >>= 1;
        contextInitContext.picWidth >>= 1;
        contextInitContext.picHeight >>= 1;
        int[][] iArr = scan4x4;
        PictureCodingExtension pictureCodingExtension = pictureHeader.pictureCodingExtension;
        contextInitContext.scan = iArr[pictureCodingExtension == null ? 0 : pictureCodingExtension.alternate_scan];
        return contextInitContext;
    }

    @Override // org.jcodec.codecs.mpeg12.MPEGDecoder
    public void mapBlock(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = (i3 == 1 && (i == 4 || i == 5)) ? 0 : i2;
        int i6 = i >= 4 ? 3 - MPEGConst.SQUEEZE_X[i3] : 3;
        int i7 = i + (i2 << 4);
        int i8 = (BLOCK_POS_Y[i7] << i6) + BLOCK_POS_X[i7];
        int i9 = 1 << (i6 + i5);
        while (i4 < 16) {
            iArr2[i8] = iArr2[i8] + iArr[i4];
            int i10 = i8 + 1;
            iArr2[i10] = iArr2[i10] + iArr[i4 + 1];
            int i11 = i8 + 2;
            iArr2[i11] = iArr2[i11] + iArr[i4 + 2];
            int i12 = i8 + 3;
            iArr2[i12] = iArr2[i12] + iArr[i4 + 3];
            i4 += 4;
            i8 += i9;
        }
    }

    @Override // org.jcodec.codecs.mpeg12.MPEGDecoder
    public void put(int[][] iArr, byte[][] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = MPEGConst.SQUEEZE_X[i2];
        int i10 = (((1 << i9) + i) - 1) >> i9;
        int i11 = 3 - i9;
        int i12 = 3 - MPEGConst.SQUEEZE_Y[i2];
        int i13 = i << i8;
        putSub(bArr[0], (i3 << 3) + ((i4 << 3) * i13) + (i7 * i), i13, iArr[0], 3, 3);
        int i14 = i10 << i8;
        int i15 = (i3 << i11) + ((i4 << i12) * i14) + (i10 * i7);
        putSub(bArr[1], i15, i14, iArr[1], i11, i12);
        putSub(bArr[2], i15, i14, iArr[2], i11, i12);
    }

    @Override // org.jcodec.codecs.mpeg12.MPEGDecoder
    public void putSub(byte[] bArr, int i, int i2, int[] iArr, int i3, int i4) {
        int i5 = 0;
        if (i3 == 2) {
            int i6 = 0;
            while (i5 < (1 << i4)) {
                bArr[i] = MPEGDecoder.clipTo8Bit(iArr[i6]);
                bArr[i + 1] = MPEGDecoder.clipTo8Bit(iArr[i6 + 1]);
                bArr[i + 2] = MPEGDecoder.clipTo8Bit(iArr[i6 + 2]);
                bArr[i + 3] = MPEGDecoder.clipTo8Bit(iArr[i6 + 3]);
                i6 += 4;
                i += i2;
                i5++;
            }
            return;
        }
        int i7 = 0;
        while (i5 < (1 << i4)) {
            bArr[i] = MPEGDecoder.clipTo8Bit(iArr[i7]);
            bArr[i + 1] = MPEGDecoder.clipTo8Bit(iArr[i7 + 1]);
            bArr[i + 2] = MPEGDecoder.clipTo8Bit(iArr[i7 + 2]);
            bArr[i + 3] = MPEGDecoder.clipTo8Bit(iArr[i7 + 3]);
            bArr[i + 4] = MPEGDecoder.clipTo8Bit(iArr[i7 + 4]);
            bArr[i + 5] = MPEGDecoder.clipTo8Bit(iArr[i7 + 5]);
            bArr[i + 6] = MPEGDecoder.clipTo8Bit(iArr[i7 + 6]);
            bArr[i + 7] = MPEGDecoder.clipTo8Bit(iArr[i7 + 7]);
            i7 += 8;
            i += i2;
            i5++;
        }
    }
}
