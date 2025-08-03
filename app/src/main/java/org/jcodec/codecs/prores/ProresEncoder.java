package org.jcodec.codecs.prores;

import java.nio.ByteBuffer;
import org.jcodec.codecs.prores.ProresConsts;
import org.jcodec.common.VideoEncoder;
import org.jcodec.common.dct.SimpleIDCT10Bit;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.tools.ImageOP;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class ProresEncoder extends VideoEncoder {
    private static final int DEFAULT_SLICE_MB_WIDTH = 8;
    private static final int LOG_DEFAULT_SLICE_MB_WIDTH = 3;
    private boolean interlaced;
    public Profile profile;
    private int[][] scaledChroma;
    private int[][] scaledLuma;

    public static final class Profile {
        public static final Profile HQ;
        public static final Profile LT;
        public static final Profile PROXY;
        public static final Profile STANDARD;
        private static final Profile[] _values;
        public final int bitrate;
        public final int firstQp;
        public final String fourcc;
        public final int lastQp;
        public final String name;
        public final int[] qmatChroma;
        public final int[] qmatLuma;

        static {
            Profile profile = new Profile("PROXY", ProresConsts.QMAT_LUMA_APCO, ProresConsts.QMAT_CHROMA_APCO, "apco", 1000, 4, 8);
            PROXY = profile;
            Profile profile2 = new Profile("LT", ProresConsts.QMAT_LUMA_APCS, ProresConsts.QMAT_CHROMA_APCS, "apcs", 2100, 1, 9);
            LT = profile2;
            Profile profile3 = new Profile("STANDARD", ProresConsts.QMAT_LUMA_APCN, ProresConsts.QMAT_CHROMA_APCN, "apcn", 3500, 1, 6);
            STANDARD = profile3;
            Profile profile4 = new Profile("HQ", ProresConsts.QMAT_LUMA_APCH, ProresConsts.QMAT_CHROMA_APCH, "apch", 5400, 1, 6);
            HQ = profile4;
            _values = new Profile[]{profile, profile2, profile3, profile4};
        }

        private Profile(String str, int[] iArr, int[] iArr2, String str2, int i, int i2, int i3) {
            this.name = str;
            this.qmatLuma = iArr;
            this.qmatChroma = iArr2;
            this.fourcc = str2;
            this.bitrate = i;
            this.firstQp = i2;
            this.lastQp = i3;
        }

        public static Profile valueOf(String str) {
            String upperCase = str.toUpperCase();
            for (Profile profile : _values) {
                if (str.equals(upperCase)) {
                    return profile;
                }
            }
            return null;
        }

        public static Profile[] values() {
            return _values;
        }
    }

    public ProresEncoder(Profile profile, boolean z) {
        this.profile = profile;
        this.scaledLuma = scaleQMat(profile.qmatLuma, 1, 16);
        this.scaledChroma = scaleQMat(profile.qmatChroma, 1, 16);
        this.interlaced = z;
    }

    public static final int bits(int[] iArr) {
        return ((iArr[0] + iArr[1]) + iArr[2]) << 3;
    }

    private int calcNSlices(int i, int i2) {
        int i3 = i >> 3;
        for (int i4 = 0; i4 < 3; i4++) {
            i3 += (i >> i4) & 1;
        }
        return i3 * i2;
    }

    public static ProresEncoder createProresEncoder(String str, boolean z) {
        return new ProresEncoder(str == null ? Profile.HQ : Profile.valueOf(str), z);
    }

    private void dctOnePlane(int i, byte[] bArr, byte[] bArr2, int[] iArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            iArr[i2] = (bArr[i2] + 128) << 2;
        }
        if (bArr2 != null) {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                iArr[i3] = iArr[i3] + bArr2[i3];
            }
        }
        for (int i4 = 0; i4 < i; i4++) {
            SimpleIDCT10Bit.fdctProres10(iArr, i4 << 6);
        }
    }

    private static final int diffSign(int i, int i2) {
        return (i >> 31) ^ i2;
    }

    private void doSplit(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i << i6;
        int i9 = ((i3 << 4) * i8) + (i2 << (4 - i5)) + (i * i7);
        int i10 = 0;
        for (int i11 = 0; i11 < i4; i11++) {
            splitBlock(bArr, i8, i9, bArr2, i10);
            int i12 = (i8 << 3) + i9;
            splitBlock(bArr, i8, i12, bArr2, i10 + (128 >> i5));
            if (i5 == 0) {
                splitBlock(bArr, i8, i9 + 8, bArr2, i10 + 64);
                splitBlock(bArr, i8, i12 + 8, bArr2, i10 + 192);
            }
            i10 += 256 >> i5;
            i9 += 16 >> i5;
        }
    }

    public static final void encodeOnePlane(BitWriter bitWriter, int i, int[] iArr, int[] iArr2, int[] iArr3) {
        writeDCCoeffs(bitWriter, iArr, iArr3, i);
        writeACCoeffs(bitWriter, iArr, iArr3, i, iArr2, 64);
    }

    public static final void encodeSliceData(ByteBuffer byteBuffer, int[] iArr, int[] iArr2, int[] iArr3, int i, int[][] iArr4, int i2, int[] iArr5) {
        iArr5[0] = onePlane(byteBuffer, i << 2, iArr, iArr3, iArr4[0]);
        int i3 = i << 1;
        iArr5[1] = onePlane(byteBuffer, i3, iArr2, iArr3, iArr4[1]);
        iArr5[2] = onePlane(byteBuffer, i3, iArr2, iArr3, iArr4[2]);
    }

    public static final int getLevel(int i) {
        int i2 = i >> 31;
        return (i ^ i2) - i2;
    }

    public static final int onePlane(ByteBuffer byteBuffer, int i, int[] iArr, int[] iArr2, int[] iArr3) {
        int iPosition = byteBuffer.position();
        BitWriter bitWriter = new BitWriter(byteBuffer);
        encodeOnePlane(bitWriter, i, iArr, iArr2, iArr3);
        bitWriter.flush();
        return byteBuffer.position() - iPosition;
    }

    private static final int qScale(int[] iArr, int i, int i2) {
        return i2 / iArr[i];
    }

    private int[][] scaleQMat(int[] iArr, int i, int i2) {
        int[][] iArr2 = new int[i2][];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr2[i3] = new int[iArr.length];
            for (int i4 = 0; i4 < iArr.length; i4++) {
                iArr2[i3][i4] = iArr[i4] * (i3 + i);
            }
        }
        return iArr2;
    }

    private void split(Picture picture, Picture picture2, int i, int i2, int i3, int i4, int i5) {
        byte[][] data = picture.getData();
        byte[][] lowBits = picture.getLowBits();
        byte[][] data2 = picture2.getData();
        byte[][] lowBits2 = picture2.getLowBits();
        doSplit(data[0], data2[0], picture.getPlaneWidth(0), i, i2, i3, 0, i4, i5);
        doSplit(data[1], data2[1], picture.getPlaneWidth(1), i, i2, i3, 1, i4, i5);
        doSplit(data[2], data2[2], picture.getPlaneWidth(2), i, i2, i3, 1, i4, i5);
        if (picture.getLowBits() != null) {
            doSplit(lowBits[0], lowBits2[0], picture.getPlaneWidth(0), i, i2, i3, 0, i4, i5);
            doSplit(lowBits[1], lowBits2[1], picture.getPlaneWidth(1), i, i2, i3, 1, i4, i5);
            doSplit(lowBits[2], lowBits2[2], picture.getPlaneWidth(2), i, i2, i3, 1, i4, i5);
        }
    }

    private void splitBlock(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = 0;
            while (i5 < 8) {
                bArr2[i3] = bArr[i2];
                i5++;
                i3++;
                i2++;
            }
            i2 += i - 8;
        }
    }

    private Picture splitSlice(Picture picture, int i, int i2, int i3, boolean z, int i4, int i5) {
        int i6 = i3 << 4;
        int lowBitsNum = picture.getLowBitsNum();
        ColorSpace colorSpace = ColorSpace.YUV422;
        Picture pictureCreateCroppedHiBD = Picture.createCroppedHiBD(i6, 16, lowBitsNum, colorSpace, null);
        if (z) {
            int i7 = 16 << i4;
            Picture pictureCreate = Picture.create(i6, i7, colorSpace);
            ImageOP.subImageWithFillPic8(picture, pictureCreate, new Rect(i << 4, i2 << (i4 + 4), i6, i7));
            split(pictureCreate, pictureCreateCroppedHiBD, 0, 0, i3, i4, i5);
        } else {
            split(picture, pictureCreateCroppedHiBD, i, i2, i3, i4, i5);
        }
        return pictureCreateCroppedHiBD;
    }

    private static final int toGolumb(int i) {
        return (i >> 31) ^ (i << 1);
    }

    private static final int toGolumbSign(int i, int i2) {
        if (i == 0) {
            return 0;
        }
        return (i << 1) + i2;
    }

    public static final void writeACCoeffs(BitWriter bitWriter, int[] iArr, int[] iArr2, int i, int[] iArr3, int i2) {
        int i3 = 4;
        int i4 = 2;
        int i5 = 0;
        for (int i6 = 1; i6 < i2; i6++) {
            int i7 = iArr3[i6];
            for (int i8 = 0; i8 < i; i8++) {
                int iQScale = qScale(iArr, i7, iArr2[(i8 << 6) + i7]);
                if (iQScale == 0) {
                    i5++;
                } else {
                    writeCodeword(bitWriter, ProresConsts.runCodebooks[Math.min(i3, 15)], i5);
                    int level = getLevel(iQScale);
                    writeCodeword(bitWriter, ProresConsts.levCodebooks[Math.min(i4, 9)], level - 1);
                    bitWriter.write1Bit(MathUtil.sign(iQScale));
                    i4 = level;
                    i3 = i5;
                    i5 = 0;
                }
            }
        }
    }

    public static final void writeCodeword(BitWriter bitWriter, Codebook codebook, int i) {
        int i2 = codebook.switchBits + 1;
        int i3 = codebook.riceOrder;
        int i4 = i2 << i3;
        if (i >= i4) {
            int i5 = (i - i4) + (1 << codebook.expOrder);
            int iLog2 = MathUtil.log2(i5);
            int i6 = (iLog2 - codebook.expOrder) + codebook.switchBits + 1;
            for (int i7 = 0; i7 < i6; i7++) {
                bitWriter.write1Bit(0);
            }
            bitWriter.write1Bit(1);
            bitWriter.writeNBit(i5, iLog2);
            return;
        }
        if (i3 <= 0) {
            for (int i8 = 0; i8 < i; i8++) {
                bitWriter.write1Bit(0);
            }
            bitWriter.write1Bit(1);
            return;
        }
        for (int i9 = 0; i9 < (i >> codebook.riceOrder); i9++) {
            bitWriter.write1Bit(0);
        }
        bitWriter.write1Bit(1);
        int i10 = codebook.riceOrder;
        bitWriter.writeNBit(i & ((1 << i10) - 1), i10);
    }

    public static final void writeDCCoeffs(BitWriter bitWriter, int[] iArr, int[] iArr2, int i) {
        int iQScale = qScale(iArr, 0, iArr2[0] - 16384);
        writeCodeword(bitWriter, ProresConsts.firstDCCodebook, toGolumb(iQScale));
        int i2 = 1;
        int i3 = 5;
        int i4 = 0;
        int i5 = 64;
        while (i2 < i) {
            int iQScale2 = qScale(iArr, 0, iArr2[i5] - 16384);
            int i6 = iQScale2 - iQScale;
            int golumbSign = toGolumbSign(getLevel(i6), diffSign(i6, i4));
            writeCodeword(bitWriter, ProresConsts.dcCodebooks[Math.min(i3, 6)], golumbSign);
            i2++;
            i5 += 64;
            i3 = golumbSign;
            i4 = i6 >> 31;
            iQScale = iQScale2;
        }
    }

    public static void writeFrameHeader(ByteBuffer byteBuffer, ProresConsts.FrameHeader frameHeader) {
        byteBuffer.putInt(156 + frameHeader.payloadSize);
        byteBuffer.put(new byte[]{105, 99, 112, 102});
        byteBuffer.putShort((short) 148);
        byteBuffer.putShort((short) 0);
        byteBuffer.put(new byte[]{97, 112, 108, 48});
        byteBuffer.putShort((short) frameHeader.width);
        byteBuffer.putShort((short) frameHeader.height);
        byteBuffer.put((byte) (frameHeader.frameType == 0 ? 131 : 135));
        byteBuffer.put(new byte[]{0, 2, 2, 6, 32, 0});
        byteBuffer.put((byte) 3);
        writeQMat(byteBuffer, frameHeader.qMatLuma);
        writeQMat(byteBuffer, frameHeader.qMatChroma);
    }

    public static void writePictureHeader(int i, int i2, ByteBuffer byteBuffer) {
        byteBuffer.put((byte) 64);
        byteBuffer.putInt(0);
        byteBuffer.putShort((short) i2);
        byteBuffer.put((byte) (i << 4));
    }

    public static final void writeQMat(ByteBuffer byteBuffer, int[] iArr) {
        for (int i = 0; i < 64; i++) {
            byteBuffer.put((byte) iArr[i]);
        }
    }

    @Override // org.jcodec.common.VideoEncoder
    public VideoEncoder.EncodedFrame encodeFrame(Picture picture, ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        ByteBuffer byteBufferDuplicate2 = byteBufferDuplicate.duplicate();
        int[] iArr = this.interlaced ? ProresConsts.interlaced_scan : ProresConsts.progressive_scan;
        int croppedWidth = picture.getCroppedWidth();
        int croppedHeight = picture.getCroppedHeight();
        boolean z = this.interlaced;
        Profile profile = this.profile;
        writeFrameHeader(byteBufferDuplicate, new ProresConsts.FrameHeader(0, croppedWidth, croppedHeight, z ? 1 : 0, true, iArr, profile.qmatLuma, profile.qmatChroma, 2));
        encodePicture(byteBufferDuplicate, this.scaledLuma, this.scaledChroma, iArr, picture, this.interlaced ? 1 : 0, 0);
        boolean z2 = this.interlaced;
        if (z2) {
            encodePicture(byteBufferDuplicate, this.scaledLuma, this.scaledChroma, iArr, picture, z2 ? 1 : 0, 1);
        }
        byteBufferDuplicate.flip();
        byteBufferDuplicate2.putInt(byteBufferDuplicate.remaining());
        return new VideoEncoder.EncodedFrame(byteBufferDuplicate, true);
    }

    public void encodePicture(ByteBuffer byteBuffer, int[][] iArr, int[][] iArr2, int[] iArr3, Picture picture, int i, int i2) {
        int width = (picture.getWidth() + 15) >> 4;
        int height = (picture.getHeight() + ((1 << r0) - 1)) >> (i + 4);
        int i3 = this.profile.firstQp;
        int iCalcNSlices = calcNSlices(width, height);
        writePictureHeader(3, iCalcNSlices, byteBuffer);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        NIOUtils.skip(byteBuffer, iCalcNSlices << 1);
        int[] iArr4 = new int[iCalcNSlices];
        int i4 = 0;
        int i5 = 0;
        while (i5 < height) {
            int i6 = 8;
            int iEncodeSlice = i3;
            int i7 = i4;
            int i8 = 0;
            while (i8 < width) {
                int i9 = i6;
                while (width - i8 < i9) {
                    i9 >>= 1;
                }
                int iPosition = byteBuffer.position();
                int i10 = i9;
                int[] iArr5 = iArr4;
                ByteBuffer byteBuffer2 = byteBufferDuplicate;
                iEncodeSlice = encodeSlice(byteBuffer, iArr, iArr2, iArr3, i9, i8, i5, picture, iEncodeSlice, width, height, (picture.getHeight() % 16 != 0 && i5 == height + (-1)) || (picture.getWidth() % 16 != 0 && i8 + i9 == width), i, i2);
                byteBuffer2.putShort((short) (byteBuffer.position() - iPosition));
                iArr5[i7] = (short) (byteBuffer.position() - iPosition);
                i8 += i10;
                i7++;
                byteBufferDuplicate = byteBuffer2;
                width = width;
                i6 = i10;
                i5 = i5;
                iArr4 = iArr5;
                height = height;
            }
            i5++;
            i3 = iEncodeSlice;
            i4 = i7;
        }
    }

    public int encodeSlice(ByteBuffer byteBuffer, int[][] iArr, int[][] iArr2, int[] iArr3, int i, int i2, int i3, Picture picture, int i4, int i5, int i6, boolean z, int i7, int i8) {
        int i9 = i4;
        Picture pictureSplitSlice = splitSlice(picture, i2, i3, i, z, i7, i8);
        int i10 = i << 7;
        int[][] iArr4 = {new int[i << 8], new int[i10], new int[i10]};
        byte[][] data = pictureSplitSlice.getData();
        byte[][] lowBits = pictureSplitSlice.getLowBits();
        dctOnePlane(i << 2, data[0], lowBits == null ? null : lowBits[0], iArr4[0]);
        int i11 = i << 1;
        dctOnePlane(i11, data[1], lowBits == null ? null : lowBits[1], iArr4[1]);
        dctOnePlane(i11, data[2], lowBits != null ? lowBits[2] : null, iArr4[2]);
        int i12 = (i >> 2) * this.profile.bitrate;
        int i13 = i12 >> 3;
        int i14 = i12 - i13;
        int i15 = i12 + i13;
        byteBuffer.put((byte) 48);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        NIOUtils.skip(byteBuffer, 5);
        int iPosition = byteBuffer.position();
        int[] iArr5 = new int[3];
        int i16 = i9 - 1;
        encodeSliceData(byteBuffer, iArr[i16], iArr2[i16], iArr3, i, iArr4, i4, iArr5);
        if (bits(iArr5) > i15 && i9 < this.profile.lastQp) {
            do {
                i9++;
                byteBuffer.position(iPosition);
                int i17 = i9 - 1;
                encodeSliceData(byteBuffer, iArr[i17], iArr2[i17], iArr3, i, iArr4, i9, iArr5);
                if (bits(iArr5) <= i15) {
                    break;
                }
            } while (i9 < this.profile.lastQp);
        } else if (bits(iArr5) < i14 && i9 > this.profile.firstQp) {
            do {
                i9--;
                byteBuffer.position(iPosition);
                int i18 = i9 - 1;
                encodeSliceData(byteBuffer, iArr[i18], iArr2[i18], iArr3, i, iArr4, i9, iArr5);
                if (bits(iArr5) >= i14) {
                    break;
                }
            } while (i9 > this.profile.firstQp);
        }
        byteBufferDuplicate.put((byte) i9);
        byteBufferDuplicate.putShort((short) iArr5[0]);
        byteBufferDuplicate.putShort((short) iArr5[1]);
        return i9;
    }

    @Override // org.jcodec.common.VideoEncoder
    public int estimateBufferSize(Picture picture) {
        return ((picture.getWidth() * 3) * picture.getHeight()) / 2;
    }

    @Override // org.jcodec.common.VideoEncoder
    public ColorSpace[] getSupportedColorSpaces() {
        return new ColorSpace[]{ColorSpace.YUV422};
    }
}
