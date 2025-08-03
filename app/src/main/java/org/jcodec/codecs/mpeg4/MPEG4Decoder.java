package org.jcodec.codecs.mpeg4;

import java.nio.ByteBuffer;
import org.jcodec.codecs.mpeg4.Macroblock;
import org.jcodec.common.UsedViaReflection;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.model.Size;

/* loaded from: classes2.dex */
public class MPEG4Decoder extends VideoDecoder {
    private MPEG4DecodingContext ctx;
    private Macroblock[] mbs;
    private Macroblock[] prevMBs;
    private Picture[] refs = new Picture[2];

    /* JADX WARN: Multi-variable type inference failed */
    private Picture decodeBFrame(BitReader bitReader, MPEG4DecodingContext mPEG4DecodingContext, byte[][] bArr, int i, int i2, int i3) {
        Macroblock macroblock;
        int i4;
        int i5;
        int i6;
        Macroblock.Vector vector;
        BitReader bitReader2 = bitReader;
        int i7 = 0;
        Picture picture = new Picture(mPEG4DecodingContext.mbWidth << 4, mPEG4DecodingContext.mbHeight << 4, bArr, null, ColorSpace.YUV420, 0, new Rect(0, 0, mPEG4DecodingContext.width, mPEG4DecodingContext.height));
        Macroblock.Vector vectorVec = Macroblock.vec();
        Macroblock.Vector vectorVec2 = Macroblock.vec();
        int i8 = i2 > i3 ? i2 : i3;
        int i9 = 0;
        while (i9 < mPEG4DecodingContext.mbHeight) {
            vectorVec.y = i7;
            vectorVec.x = i7;
            vectorVec2.y = i7;
            vectorVec2.x = i7;
            int i10 = i7;
            while (true) {
                int i11 = mPEG4DecodingContext.mbWidth;
                if (i10 < i11) {
                    Macroblock macroblock2 = this.mbs[(i9 * i11) + i10];
                    Macroblock macroblock3 = this.prevMBs[(i11 * i9) + i10];
                    int i12 = i8 - 1;
                    if (MPEG4Bitstream.checkResyncMarker(bitReader2, i12)) {
                        macroblock = macroblock3;
                        int videoPacketHeader = MPEG4Bitstream.readVideoPacketHeader(bitReader, mPEG4DecodingContext, i12, i2 != 0 ? 1 : i7, i3 != 0 ? 1 : i7, mPEG4DecodingContext.intraDCThreshold != 0 ? 1 : i7);
                        int i13 = mPEG4DecodingContext.mbWidth;
                        vectorVec.y = i7;
                        vectorVec.x = i7;
                        vectorVec2.y = i7;
                        vectorVec2.x = i7;
                        i4 = videoPacketHeader / i13;
                        i5 = videoPacketHeader % i13;
                    } else {
                        macroblock = macroblock3;
                        i4 = i9;
                        i5 = i10;
                    }
                    macroblock2.x = i5;
                    macroblock2.y = i4;
                    macroblock2.quant = i;
                    Macroblock macroblock4 = macroblock;
                    if (macroblock4.mode == 16) {
                        macroblock2.cbp = i7;
                        macroblock2.mode = 3;
                        MPEG4Bitstream.readInterCoeffs(bitReader2, mPEG4DecodingContext, macroblock2);
                        i6 = i5;
                        int i14 = i4;
                        MPEG4Renderer.renderInter(mPEG4DecodingContext, this.refs, macroblock4, i2, 1, true);
                        putPix(picture, macroblock4, i6, i14);
                        i9 = i14;
                        vector = vectorVec2;
                    } else {
                        i6 = i5;
                        vector = vectorVec2;
                        MPEG4Bitstream.readBi(bitReader, mPEG4DecodingContext, i2, i3, macroblock2, macroblock4, vectorVec, vectorVec2);
                        MPEG4BiRenderer.renderBi(mPEG4DecodingContext, this.refs, i2, i3, macroblock2);
                        i9 = i4;
                        putPix(picture, macroblock2, i6, i9);
                    }
                    i10 = i6 + 1;
                    bitReader2 = bitReader;
                    vectorVec2 = vector;
                    i7 = 0;
                }
            }
            i9++;
            bitReader2 = bitReader;
            i7 = 0;
        }
        return picture;
    }

    private Picture decodeIFrame(BitReader bitReader, MPEG4DecodingContext mPEG4DecodingContext, byte[][] bArr) {
        int i = 0;
        Picture picture = new Picture(mPEG4DecodingContext.mbWidth << 4, mPEG4DecodingContext.mbHeight << 4, bArr, null, ColorSpace.YUV420, 0, new Rect(0, 0, mPEG4DecodingContext.width, mPEG4DecodingContext.height));
        int i2 = 0;
        int i3 = 0;
        while (i2 < mPEG4DecodingContext.mbHeight) {
            int i4 = i;
            while (true) {
                int i5 = mPEG4DecodingContext.mbWidth;
                if (i4 < i5) {
                    Macroblock macroblock = this.mbs[(i5 * i2) + i4];
                    macroblock.reset(i4, i2, i3);
                    MPEG4Bitstream.readIntraMode(bitReader, mPEG4DecodingContext, macroblock);
                    int i6 = mPEG4DecodingContext.mbWidth;
                    int i7 = (i2 * i6) + i4;
                    int i8 = i7 - i6;
                    int i9 = i7 - 1;
                    int i10 = i9 - i6;
                    Macroblock macroblock2 = null;
                    Macroblock macroblock3 = i8 >= i3 ? this.mbs[i8] : null;
                    Macroblock macroblock4 = i10 >= i3 ? this.mbs[i10] : null;
                    if (i4 > 0 && i9 >= i3) {
                        macroblock2 = this.mbs[i9];
                    }
                    Macroblock macroblock5 = macroblock3;
                    int i11 = i;
                    Macroblock macroblock6 = macroblock2;
                    Picture picture2 = picture;
                    MPEG4Bitstream.readCoeffIntra(bitReader, mPEG4DecodingContext, macroblock, macroblock5, macroblock6, macroblock4);
                    int i12 = macroblock.x;
                    int i13 = macroblock.y;
                    int i14 = macroblock.bound;
                    MPEG4Renderer.renderIntra(macroblock, mPEG4DecodingContext);
                    putPix(picture2, macroblock, i12, i13);
                    i = i11;
                    picture = picture2;
                    i4 = i12 + 1;
                    i2 = i13;
                    i3 = i14;
                }
            }
            i2++;
        }
        return picture;
    }

    @UsedViaReflection
    public static int probe(ByteBuffer byteBuffer) {
        MPEG4DecodingContext fromHeaders = MPEG4DecodingContext.readFromHeaders(byteBuffer.duplicate());
        if (fromHeaders == null) {
            return 0;
        }
        int i = fromHeaders.width;
        int i2 = (i <= 320 || i >= 1280) ? 50 : 100;
        int i3 = fromHeaders.height;
        return Math.min(i2, (i3 <= 240 || i3 >= 720) ? 50 : 100);
    }

    public static void putPix(Picture picture, Macroblock macroblock, int i, int i2) {
        byte[] planeData = picture.getPlaneData(0);
        int width = ((i2 << 4) * picture.getWidth()) + (i << 4);
        int i3 = 0;
        int i4 = 0;
        while (i3 < 16) {
            int i5 = 0;
            while (i5 < 16) {
                planeData[width + i5] = macroblock.pred[0][i4];
                i5++;
                i4++;
            }
            i3++;
            width += picture.getWidth();
        }
        for (int i6 = 1; i6 < 3; i6++) {
            byte[] planeData2 = picture.getPlaneData(i6);
            int planeWidth = ((i2 << 3) * picture.getPlaneWidth(i6)) + (i << 3);
            int i7 = 0;
            int i8 = 0;
            while (i7 < 8) {
                int i9 = 0;
                while (i9 < 8) {
                    planeData2[planeWidth + i9] = macroblock.pred[i6][i8];
                    i9++;
                    i8++;
                }
                i7++;
                planeWidth += picture.getPlaneWidth(i6);
            }
        }
    }

    @Override // org.jcodec.common.VideoDecoder
    public Picture decodeFrame(ByteBuffer byteBuffer, byte[][] bArr) {
        if (this.ctx == null) {
            this.ctx = new MPEG4DecodingContext();
        }
        Picture pictureDecodeBFrame = null;
        if (!this.ctx.readHeaders(byteBuffer)) {
            return null;
        }
        MPEG4DecodingContext mPEG4DecodingContext = this.ctx;
        mPEG4DecodingContext.intraDCThreshold = 0;
        mPEG4DecodingContext.fcodeBackward = 0;
        mPEG4DecodingContext.fcodeForward = 0;
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        if (!this.ctx.readVOPHeader(bitReaderCreateBitReader)) {
            return null;
        }
        MPEG4DecodingContext mPEG4DecodingContext2 = this.ctx;
        this.mbs = new Macroblock[mPEG4DecodingContext2.mbWidth * mPEG4DecodingContext2.mbHeight];
        int i = 0;
        while (true) {
            Macroblock[] macroblockArr = this.mbs;
            if (i >= macroblockArr.length) {
                break;
            }
            macroblockArr[i] = new Macroblock();
            i++;
        }
        MPEG4DecodingContext mPEG4DecodingContext3 = this.ctx;
        int i2 = mPEG4DecodingContext3.codingType;
        if (i2 != 2) {
            if (i2 == 0) {
                pictureDecodeBFrame = decodeIFrame(bitReaderCreateBitReader, mPEG4DecodingContext3, bArr);
            } else if (i2 == 1) {
                pictureDecodeBFrame = decodePFrame(bitReaderCreateBitReader, mPEG4DecodingContext3, bArr, mPEG4DecodingContext3.fcodeForward);
            } else {
                if (i2 == 3) {
                    throw new RuntimeException("GMC not supported.");
                }
                if (i2 == 4) {
                    return null;
                }
            }
            Picture[] pictureArr = this.refs;
            pictureArr[1] = pictureArr[0];
            pictureArr[0] = pictureDecodeBFrame;
            this.prevMBs = this.mbs;
        } else {
            pictureDecodeBFrame = decodeBFrame(bitReaderCreateBitReader, mPEG4DecodingContext3, bArr, mPEG4DecodingContext3.quant, mPEG4DecodingContext3.fcodeForward, mPEG4DecodingContext3.fcodeBackward);
        }
        bitReaderCreateBitReader.terminate();
        return pictureDecodeBFrame;
    }

    public Picture decodePFrame(BitReader bitReader, MPEG4DecodingContext mPEG4DecodingContext, byte[][] bArr, int i) {
        int i2;
        int i3;
        int i4 = mPEG4DecodingContext.mbWidth;
        int i5 = mPEG4DecodingContext.mbHeight;
        int i6 = 0;
        Picture picture = new Picture(i4 << 4, i5 << 4, bArr, null, ColorSpace.YUV420, 0, new Rect(0, 0, mPEG4DecodingContext.width, mPEG4DecodingContext.height));
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            int i9 = i6;
            while (i9 < i4) {
                while (bitReader.checkNBit(10) == 1) {
                    bitReader.skip(10);
                }
                int i10 = i - 1;
                if (MPEG4Bitstream.checkResyncMarker(bitReader, i10)) {
                    int videoPacketHeader = MPEG4Bitstream.readVideoPacketHeader(bitReader, mPEG4DecodingContext, i10, true, false, true);
                    i9 = videoPacketHeader % i4;
                    i3 = videoPacketHeader;
                    i2 = videoPacketHeader / i4;
                } else {
                    i2 = i7;
                    i3 = i8;
                }
                int i11 = i9;
                int i12 = mPEG4DecodingContext.mbWidth;
                int i13 = (i2 * i12) + i11;
                int i14 = i13 - i12;
                int i15 = i13 - 1;
                int i16 = i15 - i12;
                int i17 = (i13 + 1) - i12;
                Macroblock macroblock = i14 >= i3 ? this.mbs[i14] : null;
                Macroblock macroblock2 = i16 >= i3 ? this.mbs[i16] : null;
                Macroblock macroblock3 = (i11 <= 0 || i15 < i3) ? null : this.mbs[i15];
                Macroblock macroblock4 = (i17 < i3 || i11 >= i12 + (-1)) ? null : this.mbs[i17];
                Macroblock macroblock5 = this.mbs[(i12 * i2) + i11];
                macroblock5.reset(i11, i2, i3);
                MPEG4Bitstream.readInterModeCoeffs(bitReader, mPEG4DecodingContext, i, macroblock5, macroblock, macroblock3, macroblock2, macroblock4);
                MPEG4Renderer.renderInter(mPEG4DecodingContext, this.refs, macroblock5, i, 0, false);
                putPix(picture, macroblock5, i11, i2);
                i9 = i11 + 1;
                i7 = i2;
                i8 = i3;
            }
            i7++;
            i6 = 0;
        }
        return picture;
    }

    @Override // org.jcodec.common.VideoDecoder
    public VideoCodecMeta getCodecMeta(ByteBuffer byteBuffer) {
        MPEG4DecodingContext fromHeaders = MPEG4DecodingContext.readFromHeaders(byteBuffer.duplicate());
        if (fromHeaders == null) {
            return null;
        }
        return VideoCodecMeta.createSimpleVideoCodecMeta(new Size(fromHeaders.width, fromHeaders.height), ColorSpace.YUV420J);
    }
}
