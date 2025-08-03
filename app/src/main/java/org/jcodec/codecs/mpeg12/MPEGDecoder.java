package org.jcodec.codecs.mpeg12;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.socket.TransmitHelper;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.codecs.mpeg12.bitstream.GOPHeader;
import org.jcodec.codecs.mpeg12.bitstream.PictureCodingExtension;
import org.jcodec.codecs.mpeg12.bitstream.PictureHeader;
import org.jcodec.codecs.mpeg12.bitstream.QuantMatrixExtension;
import org.jcodec.codecs.mpeg12.bitstream.SequenceExtension;
import org.jcodec.codecs.mpeg12.bitstream.SequenceHeader;
import org.jcodec.codecs.mpeg12.bitstream.SequenceScalableExtension;
import org.jcodec.common.UsedViaReflection;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.dct.SparseIDCT;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.model.Size;

/* loaded from: classes2.dex */
public class MPEGDecoder extends VideoDecoder {
    public GOPHeader gh;
    public SequenceHeader sh;
    private Picture[] refFrames = new Picture[2];
    private Picture[] refFields = new Picture[2];

    public static class Context {
        public int codedHeight;
        public int codedWidth;
        public ColorSpace color;
        public int[] intra_dc_predictor = new int[3];
        public MPEGConst.MBType lastPredB;
        public int mbHeight;
        public int mbNo;
        public int mbWidth;
        public int picHeight;
        public int picWidth;
        public int[][] qMats;
        public int[] scan;
    }

    private static final void avgPred(int[][] iArr, int[][] iArr2) {
        for (int i = 0; i < iArr.length; i++) {
            int i2 = 0;
            while (true) {
                int[] iArr3 = iArr[i];
                if (i2 < iArr3.length) {
                    int i3 = iArr3[i2];
                    int[] iArr4 = iArr2[i];
                    iArr3[i2] = ((i3 + iArr4[i2]) + 1) >> 1;
                    int i4 = i2 + 1;
                    iArr3[i4] = ((iArr3[i4] + iArr4[i4]) + 1) >> 1;
                    int i5 = i2 + 2;
                    iArr3[i5] = ((iArr3[i5] + iArr4[i5]) + 1) >> 1;
                    int i6 = i2 + 3;
                    iArr3[i6] = ((iArr3[i6] + iArr4[i6]) + 1) >> 1;
                    i2 += 4;
                }
            }
        }
    }

    private static final int[][] buildPred(int[][] iArr, int[][] iArr2) {
        if (iArr != null && iArr2 != null) {
            avgPred(iArr, iArr2);
            return iArr;
        }
        if (iArr != null) {
            return iArr;
        }
        if (iArr2 != null) {
            return iArr2;
        }
        throw new RuntimeException("Omited pred _in B-frames --> invalid");
    }

    public static final int clip(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }

    public static final byte clipTo8Bit(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 255) {
            i = 255;
        }
        return (byte) (i - 128);
    }

    private Picture copyAndCreateIfNeeded(Picture picture, Picture picture2) {
        if (picture2 == null || !picture2.compatible(picture)) {
            picture2 = picture.createCompatible();
        }
        picture2.copyFrom(picture);
        return picture2;
    }

    private void doDecodeSlice(Context context, PictureHeader pictureHeader, byte[][] bArr, int i, int i2, ByteBuffer byteBuffer) throws IOException {
        int i3 = byteBuffer.get(3) & ExifInterface.MARKER;
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(4);
        try {
            decodeSlice(pictureHeader, i3, context, bArr, BitReader.createBitReader(byteBufferDuplicate), i, i2);
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        }
    }

    public static int getCodedHeight(SequenceHeader sequenceHeader, PictureHeader pictureHeader) {
        PictureCodingExtension pictureCodingExtension = pictureHeader.pictureCodingExtension;
        int i = (pictureCodingExtension == null || pictureCodingExtension.picture_structure == 3) ? 0 : 1;
        return (((sequenceHeader.vertical_size >> i) + 15) & (-16)) << i;
    }

    private ColorSpace getColor(int i) {
        if (i == 1) {
            return ColorSpace.YUV420;
        }
        if (i == 2) {
            return ColorSpace.YUV422;
        }
        if (i != 3) {
            return null;
        }
        return ColorSpace.YUV444;
    }

    public static PictureHeader getPictureHeader(ByteBuffer byteBuffer) {
        ByteBuffer rawPictureHeader = getRawPictureHeader(byteBuffer);
        if (rawPictureHeader == null) {
            return null;
        }
        return PictureHeader.read(rawPictureHeader);
    }

    private static ByteBuffer getRawPictureHeader(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferNextSegment = MPEGUtil.nextSegment(byteBuffer);
        while (byteBufferNextSegment != null) {
            if (byteBufferNextSegment.getInt() == 256) {
                return byteBufferNextSegment;
            }
            byteBufferNextSegment = MPEGUtil.nextSegment(byteBuffer);
        }
        return null;
    }

    private static ByteBuffer getSequenceHeader(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferNextSegment = MPEGUtil.nextSegment(byteBuffer);
        while (byteBufferNextSegment != null) {
            if (byteBufferNextSegment.getInt() == 435) {
                return byteBufferNextSegment;
            }
            byteBufferNextSegment = MPEGUtil.nextSegment(byteBuffer);
        }
        return null;
    }

    public static int getSequenceNumber(ByteBuffer byteBuffer) {
        PictureHeader pictureHeader = getPictureHeader(byteBuffer);
        if (pictureHeader == null) {
            return -1;
        }
        return pictureHeader.temporal_reference;
    }

    public static final int mpegSigned(BitReader bitReader, int i) {
        int nBit = bitReader.readNBit(i);
        int i2 = (nBit >>> (i - 1)) ^ 1;
        return (nBit + i2) - (i2 << i);
    }

    private void mvZero(Context context, PictureHeader pictureHeader, MPEGPred mPEGPred, int i, int i2, int[][] iArr) {
        int[][] iArr2;
        if (pictureHeader.picture_coding_type == 2) {
            Picture picture = this.refFrames[0];
            int i3 = i << 4;
            int i4 = i2 << 4;
            PictureCodingExtension pictureCodingExtension = pictureHeader.pictureCodingExtension;
            mPEGPred.predict16x16NoMV(picture, i3, i4, pictureCodingExtension != null ? pictureCodingExtension.picture_structure : 3, 0, iArr);
            return;
        }
        if (context.lastPredB.macroblock_motion_backward == 1) {
            Picture picture2 = this.refFrames[0];
            int i5 = i << 4;
            int i6 = i2 << 4;
            PictureCodingExtension pictureCodingExtension2 = pictureHeader.pictureCodingExtension;
            mPEGPred.predict16x16NoMV(picture2, i5, i6, pictureCodingExtension2 == null ? 3 : pictureCodingExtension2.picture_structure, 1, iArr);
            iArr2 = new int[][]{new int[iArr[0].length], new int[iArr[1].length], new int[iArr[2].length]};
        } else {
            iArr2 = iArr;
        }
        if (context.lastPredB.macroblock_motion_forward == 1) {
            Picture picture3 = this.refFrames[1];
            int i7 = i << 4;
            int i8 = i2 << 4;
            PictureCodingExtension pictureCodingExtension3 = pictureHeader.pictureCodingExtension;
            mPEGPred.predict16x16NoMV(picture3, i7, i8, pictureCodingExtension3 != null ? pictureCodingExtension3.picture_structure : 3, 0, iArr2);
            if (iArr != iArr2) {
                avgPred(iArr, iArr2);
            }
        }
    }

    @UsedViaReflection
    public static int probe(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        for (int i = 0; i < 2 && MPEGUtil.gotoNextMarker(byteBufferDuplicate) != null && byteBufferDuplicate.hasRemaining(); i++) {
            int i2 = byteBufferDuplicate.getInt();
            if (i2 == 256 || (i2 >= 432 && i2 <= 440)) {
                return 50 - (i * 10);
            }
            if (i2 > 256 && i2 < 432) {
                return 20 - (i * 10);
            }
        }
        return 0;
    }

    public static final int quantInter(int i, int i2) {
        return (((i << 1) + 1) * i2) >> 5;
    }

    public static final int quantInterSigned(int i, int i2) {
        return i >= 0 ? quantInter(i, i2) : -quantInter(-i, i2);
    }

    private final int readCbPattern(BitReader bitReader) {
        int i;
        int i2;
        int nBit;
        int vlc = MPEGConst.vlcCBP.readVLC(bitReader);
        SequenceExtension sequenceExtension = this.sh.sequenceExtension;
        if (sequenceExtension == null || (i = sequenceExtension.chroma_format) == 1) {
            return vlc;
        }
        if (i == 2) {
            i2 = vlc << 2;
            nBit = bitReader.readNBit(2);
        } else {
            if (i != 3) {
                throw new RuntimeException("Unsupported chroma format: " + this.sh.sequenceExtension.chroma_format);
            }
            i2 = vlc << 6;
            nBit = bitReader.readNBit(6);
        }
        return nBit | i2;
    }

    private PictureHeader readHeader(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        PictureHeader pictureHeader = null;
        while (true) {
            ByteBuffer byteBufferNextSegment = MPEGUtil.nextSegment(byteBufferDuplicate);
            if (byteBufferNextSegment == null) {
                break;
            }
            int i = byteBufferNextSegment.getInt() & 255;
            if (i != 179) {
                if (i != 184) {
                    if (i != 0) {
                        if (i != 181) {
                            if (i != 178) {
                                break;
                            }
                        } else {
                            int i2 = byteBufferNextSegment.get(4) >> 4;
                            if (i2 == 1 || i2 == 5 || i2 == 2) {
                                SequenceHeader.readExtension(byteBufferNextSegment, this.sh);
                            } else {
                                PictureHeader.readExtension(byteBufferNextSegment, pictureHeader, this.sh);
                            }
                        }
                    } else {
                        pictureHeader = PictureHeader.read(byteBufferNextSegment);
                    }
                } else {
                    this.gh = GOPHeader.read(byteBufferNextSegment);
                }
            } else {
                SequenceHeader sequenceHeader = SequenceHeader.read(byteBufferNextSegment);
                SequenceHeader sequenceHeader2 = this.sh;
                if (sequenceHeader2 != null) {
                    sequenceHeader.copyExtensions(sequenceHeader2);
                }
                this.sh = sequenceHeader;
            }
            byteBuffer.position(byteBufferDuplicate.position());
        }
        return pictureHeader;
    }

    private void resetDCPredictors(Context context, PictureHeader pictureHeader) {
        PictureCodingExtension pictureCodingExtension = pictureHeader.pictureCodingExtension;
        int i = pictureCodingExtension != null ? 1 << (pictureCodingExtension.intra_dc_precision + 7) : 128;
        int[] iArr = context.intra_dc_predictor;
        iArr[2] = i;
        iArr[1] = i;
        iArr[0] = i;
    }

    public static final int toSigned(int i, int i2) {
        int i3 = (i2 << 31) >> 31;
        return (i ^ i3) - i3;
    }

    public static final int twosSigned(BitReader bitReader, int i) {
        int i2 = 32 - i;
        return (bitReader.readNBit(i) << i2) >> i2;
    }

    private int[] zigzag(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[64];
        for (int i = 0; i < iArr2.length; i++) {
            iArr3[i] = iArr[iArr2[i]];
        }
        return iArr3;
    }

    public void blockInter(BitReader bitReader, VLC vlc, int[] iArr, int[] iArr2, int i, int i2, int[] iArr3) {
        int vlc2;
        int signed;
        int nBit = 0;
        if (vlc == MPEGConst.vlcCoeff0 && bitReader.checkNBit(1) == 1) {
            bitReader.read1Bit();
            SparseIDCT.start(iArr, toSigned(quantInter(1, iArr3[0] * i2), bitReader.read1Bit()));
        } else {
            SparseIDCT.start(iArr, 0);
            nBit = -1;
        }
        while (nBit < 64 && (vlc2 = vlc.readVLC(bitReader)) != 2048) {
            if (vlc2 == 2049) {
                nBit += bitReader.readNBit(6) + 1;
                signed = quantInterSigned(twosSigned(bitReader, i), iArr3[nBit] * i2);
            } else {
                nBit += (vlc2 >> 6) + 1;
                signed = toSigned(quantInter(vlc2 & 63, iArr3[nBit] * i2), bitReader.read1Bit());
            }
            SparseIDCT.coeff(iArr, iArr2[nBit], signed);
        }
        SparseIDCT.finish(iArr);
    }

    public void blockIntra(BitReader bitReader, VLC vlc, int[] iArr, int[] iArr2, int i, int[] iArr3, int i2, int i3, int i4, int[] iArr4) {
        int vlc2;
        int signed;
        int i5 = MPEGConst.BLOCK_TO_CC[i];
        int vlc3 = (i5 == 0 ? MPEGConst.vlcDCSizeLuma : MPEGConst.vlcDCSizeChroma).readVLC(bitReader);
        int nBit = 0;
        int iMpegSigned = iArr2[i5] + (vlc3 != 0 ? mpegSigned(bitReader, vlc3) : 0);
        iArr2[i5] = iMpegSigned;
        SparseIDCT.start(iArr, iMpegSigned * i3);
        while (nBit < 64 && (vlc2 = vlc.readVLC(bitReader)) != 2048) {
            if (vlc2 == 2049) {
                nBit += bitReader.readNBit(6) + 1;
                int iTwosSigned = twosSigned(bitReader, i2) * i4 * iArr4[nBit];
                signed = iTwosSigned >= 0 ? iTwosSigned >> 4 : -((-iTwosSigned) >> 4);
            } else {
                nBit += (vlc2 >> 6) + 1;
                signed = toSigned((((vlc2 & 63) * i4) * iArr4[nBit]) >> 4, bitReader.read1Bit());
            }
            SparseIDCT.coeff(iArr, iArr3[nBit], signed);
        }
        SparseIDCT.finish(iArr);
    }

    @Override // org.jcodec.common.VideoDecoder
    public Picture decodeFrame(ByteBuffer byteBuffer, byte[][] bArr) {
        Picture picture;
        int i;
        PictureHeader header = readHeader(byteBuffer);
        Picture[] pictureArr = this.refFrames;
        if ((pictureArr[0] == null && header.picture_coding_type > 1) || (pictureArr[1] == null && header.picture_coding_type > 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Not enough references to decode ");
            sb.append(header.picture_coding_type == 1 ? "P" : TransmitHelper.CAMERA_UNIT_B_CONTENT);
            sb.append(" frame");
            throw new RuntimeException(sb.toString());
        }
        Context contextInitContext = initContext(this.sh, header);
        Picture picture2 = new Picture(contextInitContext.codedWidth, contextInitContext.codedHeight, bArr, null, contextInitContext.color, 0, new Rect(0, 0, contextInitContext.picWidth, contextInitContext.picHeight));
        PictureCodingExtension pictureCodingExtension = header.pictureCodingExtension;
        if (pictureCodingExtension == null || (i = pictureCodingExtension.picture_structure) == 3) {
            picture = picture2;
            decodePicture(contextInitContext, header, byteBuffer, bArr, 0, 0);
        } else {
            picture = picture2;
            decodePicture(contextInitContext, header, byteBuffer, bArr, i - 1, 1);
            header = readHeader(byteBuffer);
            decodePicture(initContext(this.sh, header), header, byteBuffer, bArr, header.pictureCodingExtension.picture_structure - 1, 1);
        }
        int i2 = header.picture_coding_type;
        if (i2 == 1 || i2 == 2) {
            Picture[] pictureArr2 = this.refFrames;
            Picture picture3 = pictureArr2[1];
            pictureArr2[1] = pictureArr2[0];
            pictureArr2[0] = copyAndCreateIfNeeded(picture, picture3);
        }
        return picture;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0202  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int decodeMacroblock(org.jcodec.codecs.mpeg12.bitstream.PictureHeader r35, org.jcodec.codecs.mpeg12.MPEGDecoder.Context r36, int r37, int[] r38, byte[][] r39, int r40, org.jcodec.common.io.BitReader r41, int r42, int r43, org.jcodec.codecs.mpeg12.MPEGPred r44) {
        /*
            Method dump skipped, instructions count: 984
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.mpeg12.MPEGDecoder.decodeMacroblock(org.jcodec.codecs.mpeg12.bitstream.PictureHeader, org.jcodec.codecs.mpeg12.MPEGDecoder$Context, int, int[], byte[][], int, org.jcodec.common.io.BitReader, int, int, org.jcodec.codecs.mpeg12.MPEGPred):int");
    }

    public Picture decodePicture(Context context, PictureHeader pictureHeader, ByteBuffer byteBuffer, byte[][] bArr, int i, int i2) {
        PictureCodingExtension pictureCodingExtension;
        int i3;
        int i4 = context.codedWidth * context.codedHeight;
        if (bArr.length < 3 || bArr[0].length < i4 || bArr[1].length < i4 || bArr[2].length < i4) {
            throw new RuntimeException("ByteBuffer too small to hold output picture [" + context.codedWidth + "x" + context.codedHeight + "]");
        }
        while (true) {
            try {
                ByteBuffer byteBufferNextSegment = MPEGUtil.nextSegment(byteBuffer);
                if (byteBufferNextSegment == null) {
                    break;
                }
                int i5 = byteBufferNextSegment.get(3) & ExifInterface.MARKER;
                if (i5 < 1 || i5 > 175) {
                    if (i5 >= 179 && i5 != 182 && i5 != 183) {
                        throw new RuntimeException("Unexpected start code " + i5);
                    }
                    if (i5 == 0) {
                        byteBuffer.reset();
                        break;
                    }
                } else {
                    doDecodeSlice(context, pictureHeader, bArr, i, i2, byteBufferNextSegment);
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        Picture pictureCreatePicture = Picture.createPicture(context.codedWidth, context.codedHeight, bArr, context.color);
        int i6 = pictureHeader.picture_coding_type;
        if ((i6 == 1 || i6 == 2) && (pictureCodingExtension = pictureHeader.pictureCodingExtension) != null && (i3 = pictureCodingExtension.picture_structure) != 3) {
            Picture[] pictureArr = this.refFields;
            pictureArr[i3 - 1] = copyAndCreateIfNeeded(pictureCreatePicture, pictureArr[i3 - 1]);
        }
        return pictureCreatePicture;
    }

    public void decodeSlice(PictureHeader pictureHeader, int i, Context context, byte[][] bArr, BitReader bitReader, int i2, int i3) throws IOException {
        int[][] iArr;
        int i4 = context.codedWidth;
        resetDCPredictors(context, pictureHeader);
        boolean z = true;
        int nBit = i - 1;
        if (this.sh.vertical_size > 2800) {
            nBit += bitReader.readNBit(3) << 7;
        }
        SequenceScalableExtension sequenceScalableExtension = this.sh.sequenceScalableExtension;
        if (sequenceScalableExtension != null && sequenceScalableExtension.scalable_mode == 0) {
            bitReader.readNBit(7);
        }
        int nBit2 = bitReader.readNBit(5);
        if (bitReader.read1Bit() == 1) {
            bitReader.read1Bit();
            bitReader.skip(7);
            while (bitReader.read1Bit() == 1) {
                bitReader.readNBit(8);
            }
        }
        PictureCodingExtension pictureCodingExtension = pictureHeader.pictureCodingExtension;
        if (pictureCodingExtension != null) {
            iArr = pictureCodingExtension.f_code;
        } else {
            int i5 = pictureHeader.forward_f_code;
            int i6 = pictureHeader.backward_f_code;
            iArr = new int[][]{new int[]{i5, i5}, new int[]{i6, i6}};
        }
        SequenceExtension sequenceExtension = this.sh.sequenceExtension;
        MPEGPred mPEGPred = new MPEGPred(iArr, sequenceExtension != null ? sequenceExtension.chroma_format : 1, pictureCodingExtension == null || pictureCodingExtension.top_field_first != 0);
        int[] iArr2 = {nBit2};
        int iDecodeMacroblock = (nBit * context.mbWidth) - 1;
        while (bitReader.checkNBit(23) != 0) {
            MPEGPred mPEGPred2 = mPEGPred;
            iDecodeMacroblock = decodeMacroblock(pictureHeader, context, iDecodeMacroblock, iArr2, bArr, i4, bitReader, i2, i3, mPEGPred2);
            context.mbNo++;
            iArr2 = iArr2;
            mPEGPred = mPEGPred2;
            z = z;
        }
    }

    @Override // org.jcodec.common.VideoDecoder
    public VideoCodecMeta getCodecMeta(ByteBuffer byteBuffer) {
        SequenceHeader sequenceHeader = SequenceHeader.read(getSequenceHeader(byteBuffer.duplicate()).duplicate());
        return VideoCodecMeta.createSimpleVideoCodecMeta(new Size(sequenceHeader.horizontal_size, sequenceHeader.vertical_size), ColorSpace.YUV420);
    }

    public Context initContext(SequenceHeader sequenceHeader, PictureHeader pictureHeader) {
        Context context = new Context();
        context.codedWidth = (sequenceHeader.horizontal_size + 15) & (-16);
        context.codedHeight = getCodedHeight(sequenceHeader, pictureHeader);
        int i = sequenceHeader.horizontal_size;
        context.mbWidth = (i + 15) >> 4;
        int i2 = sequenceHeader.vertical_size;
        context.mbHeight = (i2 + 15) >> 4;
        context.picWidth = i;
        context.picHeight = i2;
        SequenceExtension sequenceExtension = sequenceHeader.sequenceExtension;
        context.color = getColor(sequenceExtension != null ? sequenceExtension.chroma_format : 1);
        int[][] iArr = MPEGConst.scan;
        PictureCodingExtension pictureCodingExtension = pictureHeader.pictureCodingExtension;
        int[] iArr2 = iArr[pictureCodingExtension == null ? 0 : pictureCodingExtension.alternate_scan];
        context.scan = iArr2;
        int[] iArrZigzag = sequenceHeader.non_intra_quantiser_matrix;
        if (iArrZigzag == null) {
            iArrZigzag = zigzag(MPEGConst.defaultQMatInter, iArr2);
        }
        int[] iArrZigzag2 = sequenceHeader.intra_quantiser_matrix;
        if (iArrZigzag2 == null) {
            iArrZigzag2 = zigzag(MPEGConst.defaultQMatIntra, context.scan);
        }
        int[][] iArr3 = {iArrZigzag, iArrZigzag, iArrZigzag2, iArrZigzag2};
        context.qMats = iArr3;
        QuantMatrixExtension quantMatrixExtension = pictureHeader.quantMatrixExtension;
        if (quantMatrixExtension != null) {
            int[] iArr4 = quantMatrixExtension.non_intra_quantiser_matrix;
            if (iArr4 != null) {
                iArr3[0] = iArr4;
            }
            int[] iArr5 = quantMatrixExtension.chroma_non_intra_quantiser_matrix;
            if (iArr5 != null) {
                iArr3[1] = iArr5;
            }
            int[] iArr6 = quantMatrixExtension.intra_quantiser_matrix;
            if (iArr6 != null) {
                iArr3[2] = iArr6;
            }
            int[] iArr7 = quantMatrixExtension.chroma_intra_quantiser_matrix;
            if (iArr7 != null) {
                iArr3[3] = iArr7;
            }
        }
        return context;
    }

    public void mapBlock(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = (i3 == 1 && (i == 4 || i == 5)) ? 0 : i2;
        int i6 = i < 4 ? 4 : 4 - MPEGConst.SQUEEZE_X[i3];
        int i7 = i + (i2 << 4);
        int i8 = (MPEGConst.BLOCK_POS_Y[i7] << i6) + MPEGConst.BLOCK_POS_X[i7];
        int i9 = 1 << (i6 + i5);
        int i10 = 0;
        while (i4 < 8) {
            iArr2[i8] = iArr2[i8] + iArr[i10];
            int i11 = i8 + 1;
            iArr2[i11] = iArr2[i11] + iArr[i10 + 1];
            int i12 = i8 + 2;
            iArr2[i12] = iArr2[i12] + iArr[i10 + 2];
            int i13 = i8 + 3;
            iArr2[i13] = iArr2[i13] + iArr[i10 + 3];
            int i14 = i8 + 4;
            iArr2[i14] = iArr2[i14] + iArr[i10 + 4];
            int i15 = i8 + 5;
            iArr2[i15] = iArr2[i15] + iArr[i10 + 5];
            int i16 = i8 + 6;
            iArr2[i16] = iArr2[i16] + iArr[i10 + 6];
            int i17 = i8 + 7;
            iArr2[i17] = iArr2[i17] + iArr[i10 + 7];
            i8 += i9;
            i4++;
            i10 += 8;
        }
    }

    public void put(int[][] iArr, byte[][] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = MPEGConst.SQUEEZE_X[i2];
        int i10 = (((1 << i9) + i) - 1) >> i9;
        int i11 = 4 - i9;
        int i12 = 4 - MPEGConst.SQUEEZE_Y[i2];
        int i13 = i << i8;
        putSub(bArr[0], (i3 << 4) + ((i4 << 4) * i13) + (i7 * i), i13, iArr[0], 4, 4);
        int i14 = i10 << i8;
        int i15 = (i3 << i11) + ((i4 << i12) * i14) + (i10 * i7);
        putSub(bArr[1], i15, i14, iArr[1], i11, i12);
        putSub(bArr[2], i15, i14, iArr[2], i11, i12);
    }

    public void putSub(byte[] bArr, int i, int i2, int[] iArr, int i3, int i4) {
        int i5 = 0;
        if (i3 == 3) {
            int i6 = 0;
            while (i5 < (1 << i4)) {
                bArr[i] = clipTo8Bit(iArr[i6]);
                bArr[i + 1] = clipTo8Bit(iArr[i6 + 1]);
                bArr[i + 2] = clipTo8Bit(iArr[i6 + 2]);
                bArr[i + 3] = clipTo8Bit(iArr[i6 + 3]);
                bArr[i + 4] = clipTo8Bit(iArr[i6 + 4]);
                bArr[i + 5] = clipTo8Bit(iArr[i6 + 5]);
                bArr[i + 6] = clipTo8Bit(iArr[i6 + 6]);
                bArr[i + 7] = clipTo8Bit(iArr[i6 + 7]);
                i6 += 8;
                i += i2;
                i5++;
            }
            return;
        }
        int i7 = 0;
        while (i5 < (1 << i4)) {
            bArr[i] = clipTo8Bit(iArr[i7]);
            bArr[i + 1] = clipTo8Bit(iArr[i7 + 1]);
            bArr[i + 2] = clipTo8Bit(iArr[i7 + 2]);
            bArr[i + 3] = clipTo8Bit(iArr[i7 + 3]);
            bArr[i + 4] = clipTo8Bit(iArr[i7 + 4]);
            bArr[i + 5] = clipTo8Bit(iArr[i7 + 5]);
            bArr[i + 6] = clipTo8Bit(iArr[i7 + 6]);
            bArr[i + 7] = clipTo8Bit(iArr[i7 + 7]);
            bArr[i + 8] = clipTo8Bit(iArr[i7 + 8]);
            bArr[i + 9] = clipTo8Bit(iArr[i7 + 9]);
            bArr[i + 10] = clipTo8Bit(iArr[i7 + 10]);
            bArr[i + 11] = clipTo8Bit(iArr[i7 + 11]);
            bArr[i + 12] = clipTo8Bit(iArr[i7 + 12]);
            bArr[i + 13] = clipTo8Bit(iArr[i7 + 13]);
            bArr[i + 14] = clipTo8Bit(iArr[i7 + 14]);
            bArr[i + 15] = clipTo8Bit(iArr[i7 + 15]);
            i7 += 16;
            i += i2;
            i5++;
        }
    }
}
