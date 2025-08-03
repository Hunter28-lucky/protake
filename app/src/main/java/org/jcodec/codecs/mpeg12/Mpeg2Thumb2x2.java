package org.jcodec.codecs.mpeg12;

import org.jcodec.codecs.mpeg12.MPEGDecoder;
import org.jcodec.codecs.mpeg12.bitstream.PictureCodingExtension;
import org.jcodec.codecs.mpeg12.bitstream.PictureHeader;
import org.jcodec.codecs.mpeg12.bitstream.SequenceHeader;
import org.jcodec.common.dct.IDCT2x2;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;

/* loaded from: classes2.dex */
public class Mpeg2Thumb2x2 extends MPEGDecoder {
    public static int[] BLOCK_POS_X = {0, 2, 0, 2, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 2, 2, 2, 2};
    public static int[] BLOCK_POS_Y = {0, 0, 2, 2, 0, 0, 2, 2, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1};
    public static int[][] scan2x2 = {new int[]{0, 1, 2, 4, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, new int[]{0, 2, 4, 4, 1, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}};
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
        iArr[3] = 0;
        iArr[2] = 0;
        iArr[1] = 0;
        if (vlc == MPEGConst.vlcCoeff0 && bitReader.checkNBit(1) == 1) {
            bitReader.read1Bit();
            iArr[0] = MPEGDecoder.toSigned(MPEGDecoder.quantInter(1, iArr3[0] * i2), bitReader.read1Bit());
            nBit = 0;
        } else {
            iArr[0] = 0;
            nBit = -1;
        }
        int vlc2 = 0;
        while (nBit < 6 && (vlc2 = vlc.readVLC(bitReader)) != 2048) {
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
        IDCT2x2.idct(iArr, 0);
    }

    @Override // org.jcodec.codecs.mpeg12.MPEGDecoder
    public void blockIntra(BitReader bitReader, VLC vlc, int[] iArr, int[] iArr2, int i, int[] iArr3, int i2, int i3, int i4, int[] iArr4) {
        int signed;
        int i5 = MPEGConst.BLOCK_TO_CC[i];
        int vlc2 = (i5 == 0 ? MPEGConst.vlcDCSizeLuma : MPEGConst.vlcDCSizeChroma).readVLC(bitReader);
        int iMpegSigned = iArr2[i5] + (vlc2 != 0 ? MPEGDecoder.mpegSigned(bitReader, vlc2) : 0);
        iArr2[i5] = iMpegSigned;
        iArr[0] = iMpegSigned * i3;
        iArr[3] = 0;
        iArr[2] = 0;
        iArr[1] = 0;
        int nBit = 0;
        int vlc3 = 0;
        while (nBit < 6 && (vlc3 = vlc.readVLC(bitReader)) != 2048) {
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
        IDCT2x2.idct(iArr, 0);
    }

    @Override // org.jcodec.codecs.mpeg12.MPEGDecoder
    public int decodeMacroblock(PictureHeader pictureHeader, MPEGDecoder.Context context, int i, int[] iArr, byte[][] bArr, int i2, BitReader bitReader, int i3, int i4, MPEGPred mPEGPred) {
        if (this.localPred == null || this.oldPred != mPEGPred) {
            this.localPred = new MPEGPredQuad(mPEGPred);
            this.oldPred = mPEGPred;
        }
        return super.decodeMacroblock(pictureHeader, context, i, iArr, bArr, i2, bitReader, i3, i4, this.localPred);
    }

    @Override // org.jcodec.codecs.mpeg12.MPEGDecoder
    public MPEGDecoder.Context initContext(SequenceHeader sequenceHeader, PictureHeader pictureHeader) {
        MPEGDecoder.Context contextInitContext = super.initContext(sequenceHeader, pictureHeader);
        contextInitContext.codedWidth >>= 2;
        contextInitContext.codedHeight >>= 2;
        contextInitContext.picWidth >>= 2;
        contextInitContext.picHeight >>= 2;
        int[][] iArr = scan2x2;
        PictureCodingExtension pictureCodingExtension = pictureHeader.pictureCodingExtension;
        contextInitContext.scan = iArr[pictureCodingExtension == null ? 0 : pictureCodingExtension.alternate_scan];
        return contextInitContext;
    }

    @Override // org.jcodec.codecs.mpeg12.MPEGDecoder
    public void mapBlock(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        int i4 = (i3 == 1 && (i == 4 || i == 5)) ? 0 : i2;
        int i5 = i < 4 ? 2 : 2 - MPEGConst.SQUEEZE_X[i3];
        int i6 = i + (i2 << 4);
        int i7 = (BLOCK_POS_Y[i6] << i5) + BLOCK_POS_X[i6];
        int i8 = 1 << (i5 + i4);
        iArr2[i7] = iArr2[i7] + iArr[0];
        int i9 = i7 + 1;
        iArr2[i9] = iArr2[i9] + iArr[1];
        int i10 = i7 + i8;
        iArr2[i10] = iArr2[i10] + iArr[2];
        int i11 = i10 + 1;
        iArr2[i11] = iArr2[i11] + iArr[3];
    }

    @Override // org.jcodec.codecs.mpeg12.MPEGDecoder
    public void put(int[][] iArr, byte[][] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = MPEGConst.SQUEEZE_X[i2];
        int i10 = ((i + (1 << i9)) - 1) >> i9;
        int i11 = 2 - i9;
        int i12 = 2 - MPEGConst.SQUEEZE_Y[i2];
        int i13 = i << i8;
        putSub(bArr[0], (i3 << 2) + ((i4 << 2) * i13) + (i7 * i), i13, iArr[0], 2, 2);
        int i14 = i10 << i8;
        int i15 = (i3 << i11) + ((i4 << i12) * i14) + (i10 * i7);
        putSub(bArr[1], i15, i14, iArr[1], i11, i12);
        putSub(bArr[2], i15, i14, iArr[2], i11, i12);
    }

    @Override // org.jcodec.codecs.mpeg12.MPEGDecoder
    public void putSub(byte[] bArr, int i, int i2, int[] iArr, int i3, int i4) {
        if (i3 != 1) {
            int i5 = 0;
            for (int i6 = 0; i6 < 4; i6++) {
                bArr[i] = MPEGDecoder.clipTo8Bit(iArr[i5]);
                bArr[i + 1] = MPEGDecoder.clipTo8Bit(iArr[i5 + 1]);
                bArr[i + 2] = MPEGDecoder.clipTo8Bit(iArr[i5 + 2]);
                bArr[i + 3] = MPEGDecoder.clipTo8Bit(iArr[i5 + 3]);
                i += i2;
                i5 += 4;
            }
            return;
        }
        bArr[i] = MPEGDecoder.clipTo8Bit(iArr[0]);
        bArr[i + 1] = MPEGDecoder.clipTo8Bit(iArr[1]);
        int i7 = i + i2;
        bArr[i7] = MPEGDecoder.clipTo8Bit(iArr[2]);
        bArr[i7 + 1] = MPEGDecoder.clipTo8Bit(iArr[3]);
        if (i4 == 2) {
            int i8 = i + (i2 << 1);
            bArr[i8] = MPEGDecoder.clipTo8Bit(iArr[4]);
            bArr[i8 + 1] = MPEGDecoder.clipTo8Bit(iArr[5]);
            int i9 = i8 + i2;
            bArr[i9] = MPEGDecoder.clipTo8Bit(iArr[6]);
            bArr[i9 + 1] = MPEGDecoder.clipTo8Bit(iArr[7]);
        }
    }
}
