package org.jcodec.codecs.prores;

import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import org.jcodec.codecs.prores.ProresConsts;
import org.jcodec.common.UsedViaReflection;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.dct.SimpleIDCT10Bit;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.model.Size;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class ProresDecoder extends VideoDecoder {
    public static final int[] table = {8, 7, 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final int[] mask = {0, 0, 0, 0, 0, 0, 0, 0, -1};

    public static final BitReader bitstream(ByteBuffer byteBuffer, int i) {
        return BitReader.createBitReader(NIOUtils.read(byteBuffer, i));
    }

    public static final int clip(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private void decodeSlice(ByteBuffer byteBuffer, int[] iArr, int[] iArr2, int[] iArr3, int i, int i2, int i3, short s, byte[][] bArr, byte[][] bArr2, int i4, int i5, int i6) {
        int i7 = (byteBuffer.get() & ExifInterface.MARKER) >> 3;
        int iClip = clip(byteBuffer.get() & ExifInterface.MARKER, 1, 224);
        if (iClip > 128) {
            iClip = (iClip - 96) << 2;
        }
        short s2 = byteBuffer.getShort();
        short s3 = byteBuffer.getShort();
        int i8 = i7 > 7 ? byteBuffer.getShort() : ((s - s3) - s2) - i7;
        int[] iArr4 = new int[i << 8];
        decodeOnePlane(bitstream(byteBuffer, s2), i << 2, iArr4, scaleMat(iArr, iClip), iArr3, i2, i3, 0);
        int i9 = (i << i6) >> 1;
        int i10 = i9 << 6;
        int[] iArr5 = new int[i10];
        decodeOnePlane(bitstream(byteBuffer, s3), i9, iArr5, scaleMat(iArr2, iClip), iArr3, i2, i3, 1);
        int[] iArr6 = new int[i10];
        decodeOnePlane(bitstream(byteBuffer, i8), i9, iArr6, scaleMat(iArr2, iClip), iArr3, i2, i3, 2);
        putSlice(bArr, bArr2, i4, i2, i3, iArr4, iArr5, iArr6, i5 == 0 ? 0 : 1, i5 == 2 ? 1 : 0, i6, i);
    }

    public static final int golumbSign(int i) {
        return -(i & 1);
    }

    public static final int golumbToSigned(int i) {
        return golumbSign(i) ^ (i >> 1);
    }

    public static final boolean hasQMatChroma(int i) {
        return (i & 1) != 0;
    }

    public static final boolean hasQMatLuma(int i) {
        return (i & 2) != 0;
    }

    public static final int nZeros(int i) {
        int[] iArr = table;
        int i2 = iArr[i & 255];
        int i3 = iArr[i >> 8];
        return i3 + (mask[i3] & i2);
    }

    @UsedViaReflection
    public static int probe(ByteBuffer byteBuffer) {
        return (byteBuffer.get(4) == 105 && byteBuffer.get(5) == 99 && byteBuffer.get(6) == 112 && byteBuffer.get(7) == 102) ? 100 : 0;
    }

    private void putBlock(byte[] bArr, byte[] bArr2, int i, int i2, int[] iArr, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i3;
        int i8 = 0;
        while (i8 < 8) {
            for (int i9 = 0; i9 < 8; i9++) {
                bArr[i9 + i6] = (byte) (MathUtil.clip((iArr[i9 + i7] + 2) >> 2, 1, 255) - 128);
            }
            i8++;
            i6 += i2;
            i7 += 8;
        }
        if (bArr2 != null) {
            int i10 = i;
            int i11 = i3;
            int i12 = 0;
            while (i12 < 8) {
                for (int i13 = 0; i13 < 8; i13++) {
                    int i14 = i13 + i11;
                    bArr2[i13 + i10] = (byte) (MathUtil.clip(iArr[i14], 4, PointerIconCompat.TYPE_ZOOM_OUT) - (MathUtil.clip((iArr[i14] + 2) >> 2, 1, 255) << 2));
                }
                i12++;
                i10 += i2;
                i11 += 8;
            }
        }
    }

    private void putChroma(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7) {
        int i8 = i + (i3 << 3) + ((i4 << 4) * i2);
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = i9 << 7;
            putBlock(bArr, bArr2, i8, i2, iArr, i10, i6, i7);
            putBlock(bArr, bArr2, i8 + (i2 * 8), i2, iArr, i10 + 64, i6, i7);
            i8 += 8;
        }
    }

    private void putLuma(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7) {
        int i8 = i + (i3 << 4) + ((i4 << 4) * i2);
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = i9 << 8;
            putBlock(bArr, bArr2, i8, i2, iArr, i10, i6, i7);
            putBlock(bArr, bArr2, i8 + 8, i2, iArr, i10 + 64, i6, i7);
            int i11 = i8 + (i2 * 8);
            putBlock(bArr, bArr2, i11, i2, iArr, i10 + 128, i6, i7);
            putBlock(bArr, bArr2, i11 + 8, i2, iArr, i10 + 192, i6, i7);
            i8 += 16;
        }
    }

    private static final int qScale(int[] iArr, int i, int i2) {
        return (i2 * iArr[i]) >> 2;
    }

    public static final void readACCoeffs(BitReader bitReader, int[] iArr, int[] iArr2, int i, int[] iArr3, int i2, int i3) {
        int i4 = i - 1;
        int iLog2 = MathUtil.log2(i);
        int i5 = 64 << iLog2;
        int codeword = 4;
        int codeword2 = 2;
        int i6 = i4;
        while (true) {
            if ((bitReader.remaining() <= 32 && bitReader.checkAllBits() == 0) || (codeword = readCodeword(bitReader, ProresConsts.runCodebooks[Math.min(codeword, 15)])) < 0 || codeword >= (i5 - i6) - 1) {
                return;
            }
            i6 += codeword + 1;
            codeword2 = readCodeword(bitReader, ProresConsts.levCodebooks[Math.min(codeword2, 9)]) + 1;
            if (codeword2 < 0 || codeword2 > 65535) {
                return;
            }
            int i7 = -bitReader.read1Bit();
            int i8 = i6 >> iLog2;
            if (i8 >= i2) {
                return;
            } else {
                iArr2[((i6 & i4) << i3) + iArr3[i8]] = qScale(iArr, i8, MathUtil.toSigned(codeword2, i7));
            }
        }
    }

    public static final int readCodeword(BitReader bitReader, Codebook codebook) {
        int iNZeros = nZeros(bitReader.check16Bits());
        bitReader.skipFast(iNZeros + 1);
        if (iNZeros > codebook.switchBits) {
            int i = codebook.golombBits + iNZeros;
            if (i > 16) {
                Logger.error("Broken prores slice");
            }
            return (bitReader.readFast16(i) | (1 << i)) - codebook.golombOffset;
        }
        int i2 = codebook.riceOrder;
        if (i2 <= 0) {
            return iNZeros;
        }
        return bitReader.readFast16(i2) | (iNZeros << i2);
    }

    public static final void readDCCoeffs(BitReader bitReader, int[] iArr, int[] iArr2, int i, int i2) {
        int codeword = readCodeword(bitReader, ProresConsts.firstDCCodebook);
        if (codeword < 0) {
            return;
        }
        int iGolumbToSigned = golumbToSigned(codeword);
        iArr2[0] = qScale(iArr, 0, iGolumbToSigned) + 4096;
        int codeword2 = 5;
        int i3 = i2;
        int iGolumbSign = 0;
        int i4 = 1;
        while (i4 < i) {
            codeword2 = readCodeword(bitReader, ProresConsts.dcCodebooks[Math.min(codeword2, 6)]);
            if (codeword2 < 0) {
                return;
            }
            iGolumbSign = codeword2 != 0 ? iGolumbSign ^ golumbSign(codeword2) : 0;
            iGolumbToSigned += MathUtil.toSigned((codeword2 + 1) >> 1, iGolumbSign);
            iArr2[i3] = qScale(iArr, 0, iGolumbToSigned) + 4096;
            i4++;
            i3 += i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.jcodec.codecs.prores.ProresConsts.FrameHeader readFrameHeader(java.nio.ByteBuffer r15) {
        /*
            int r0 = r15.getInt()
            java.lang.String r1 = readSig(r15)
            java.lang.String r2 = "icpf"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L9f
            short r1 = r15.getShort()
            r15.getShort()
            r15.getInt()
            short r4 = r15.getShort()
            short r5 = r15.getShort()
            byte r2 = r15.get()
            int r3 = r2 >> 2
            r6 = r3 & 3
            int r2 = r2 >> 6
            r11 = r2 & 3
            r2 = 1
            r3 = 0
            if (r6 != 0) goto L36
            int[] r2 = org.jcodec.codecs.prores.ProresConsts.progressive_scan
            r8 = r2
            goto L3d
        L36:
            int[] r7 = org.jcodec.codecs.prores.ProresConsts.interlaced_scan
            r8 = r7
            if (r6 != r2) goto L3d
            r7 = r2
            goto L3e
        L3d:
            r7 = r3
        L3e:
            r15.get()
            r15.get()
            r15.get()
            r15.get()
            r15.get()
            r15.get()
            byte r2 = r15.get()
            r2 = r2 & 255(0xff, float:3.57E-43)
            r9 = 64
            int[] r10 = new int[r9]
            int[] r12 = new int[r9]
            boolean r13 = hasQMatLuma(r2)
            r14 = 4
            if (r13 == 0) goto L67
            readQMat(r15, r10, r8)
            goto L6a
        L67:
            java.util.Arrays.fill(r10, r14)
        L6a:
            boolean r13 = hasQMatChroma(r2)
            if (r13 == 0) goto L74
            readQMat(r15, r12, r8)
            goto L77
        L74:
            java.util.Arrays.fill(r12, r14)
        L77:
            int r13 = r15.position()
            int r13 = r13 + r1
            boolean r14 = hasQMatLuma(r2)
            if (r14 == 0) goto L84
            r14 = r9
            goto L85
        L84:
            r14 = r3
        L85:
            int r14 = r14 + 20
            boolean r2 = hasQMatChroma(r2)
            if (r2 == 0) goto L8e
            r3 = r9
        L8e:
            int r14 = r14 + r3
            int r13 = r13 - r14
            r15.position(r13)
            org.jcodec.codecs.prores.ProresConsts$FrameHeader r15 = new org.jcodec.codecs.prores.ProresConsts$FrameHeader
            int r0 = r0 - r1
            int r3 = r0 + (-8)
            r2 = r15
            r9 = r10
            r10 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r15
        L9f:
            java.lang.RuntimeException r15 = new java.lang.RuntimeException
            java.lang.String r0 = "Not a prores frame"
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.prores.ProresDecoder.readFrameHeader(java.nio.ByteBuffer):org.jcodec.codecs.prores.ProresConsts$FrameHeader");
    }

    public static ProresConsts.PictureHeader readPictureHeader(ByteBuffer byteBuffer) {
        byteBuffer.get();
        byteBuffer.getInt();
        int i = byteBuffer.getShort();
        int i2 = (byteBuffer.get() & ExifInterface.MARKER) >> 4;
        short[] sArr = new short[i];
        for (int i3 = 0; i3 < i; i3++) {
            sArr[i3] = byteBuffer.getShort();
        }
        return new ProresConsts.PictureHeader(i2, sArr);
    }

    public static final void readQMat(ByteBuffer byteBuffer, int[] iArr, int[] iArr2) {
        byte[] bArr = new byte[64];
        byteBuffer.get(bArr);
        for (int i = 0; i < 64; i++) {
            iArr[i] = bArr[iArr2[i]] & ExifInterface.MARKER;
        }
    }

    public static final String readSig(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return Platform.stringFromBytes(bArr);
    }

    public static final int[] scaleMat(int[] iArr, int i) {
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = iArr[i2] * i;
        }
        return iArr2;
    }

    public Picture[] decodeFields(ByteBuffer byteBuffer, byte[][][] bArr) {
        return decodeFieldsHiBD(byteBuffer, bArr, null);
    }

    public Picture[] decodeFieldsHiBD(ByteBuffer byteBuffer, byte[][][] bArr, byte[][][] bArr2) {
        ProresConsts.FrameHeader frameHeader = readFrameHeader(byteBuffer);
        int i = frameHeader.width;
        int i2 = (i + 15) & (-16);
        int i3 = frameHeader.height;
        int i4 = (i3 + 15) & (-16);
        int i5 = i2 * i4;
        int i6 = i5 >> 1;
        if (frameHeader.frameType == 0) {
            if (bArr != null) {
                byte[][] bArr3 = bArr[0];
                if (bArr3[0].length >= i5 && bArr3[1].length >= i6 && bArr3[2].length >= i6) {
                    decodePicture(byteBuffer, bArr3, bArr2[0], i, i3, i2 >> 4, frameHeader.qMatLuma, frameHeader.qMatChroma, frameHeader.scan, 0, frameHeader.chromaType);
                    return new Picture[]{Picture.createPicture(i2, i4, bArr[0], ColorSpace.YUV422)};
                }
            }
            throw new RuntimeException("Provided output picture won't fit into provided buffer");
        }
        int i7 = i6 >> 1;
        if (bArr != null) {
            byte[][] bArr4 = bArr[0];
            if (bArr4[0].length >= i6 && bArr4[1].length >= i7 && bArr4[2].length >= i7) {
                byte[][] bArr5 = bArr[1];
                if (bArr5[0].length >= i6 && bArr5[1].length >= i7 && bArr5[2].length >= i7) {
                    boolean z = frameHeader.topFieldFirst;
                    int i8 = i2 >> 4;
                    decodePicture(byteBuffer, bArr[!z ? 1 : 0], bArr2[!z ? 1 : 0], i, i3 >> 1, i8, frameHeader.qMatLuma, frameHeader.qMatChroma, frameHeader.scan, 0, frameHeader.chromaType);
                    boolean z2 = frameHeader.topFieldFirst;
                    decodePicture(byteBuffer, bArr[z2 ? 1 : 0], bArr2[!z2 ? 1 : 0], frameHeader.width, frameHeader.height >> 1, i8, frameHeader.qMatLuma, frameHeader.qMatChroma, frameHeader.scan, 0, frameHeader.chromaType);
                    int i9 = i4 >> 1;
                    byte[][] bArr6 = bArr[0];
                    ColorSpace colorSpace = ColorSpace.YUV422;
                    return new Picture[]{Picture.createPicture(i2, i9, bArr6, colorSpace), Picture.createPicture(i2, i9, bArr[1], colorSpace)};
                }
            }
        }
        throw new RuntimeException("Provided output picture won't fit into provided buffer");
    }

    @Override // org.jcodec.common.VideoDecoder
    public Picture decodeFrame(ByteBuffer byteBuffer, byte[][] bArr) {
        return decodeFrameHiBD(byteBuffer, bArr, null);
    }

    public Picture decodeFrameHiBD(ByteBuffer byteBuffer, byte[][] bArr, byte[][] bArr2) {
        int i;
        ProresConsts.FrameHeader frameHeader = readFrameHeader(byteBuffer);
        int i2 = (frameHeader.width + 15) & (-16);
        int i3 = (frameHeader.height + 15) & (-16);
        int i4 = i2 * i3;
        int i5 = frameHeader.chromaType;
        int i6 = i4 >> (3 - i5);
        if (bArr == null || bArr[0].length < i4 || bArr[1].length < i6 || bArr[2].length < i6) {
            throw new RuntimeException("Provided output picture won't fit into provided buffer");
        }
        if (frameHeader.frameType == 0) {
            i = 2;
            decodePicture(byteBuffer, bArr, bArr2, i2, i3, i2 >> 4, frameHeader.qMatLuma, frameHeader.qMatChroma, frameHeader.scan, 0, i5);
        } else {
            i = 2;
            int i7 = i3 >> 1;
            int i8 = i2 >> 4;
            decodePicture(byteBuffer, bArr, bArr2, i2, i7, i8, frameHeader.qMatLuma, frameHeader.qMatChroma, frameHeader.scan, frameHeader.topFieldFirst ? 1 : 2, i5);
            decodePicture(byteBuffer, bArr, bArr2, i2, i7, i8, frameHeader.qMatLuma, frameHeader.qMatChroma, frameHeader.scan, frameHeader.topFieldFirst ? 2 : 1, frameHeader.chromaType);
        }
        ColorSpace colorSpace = frameHeader.chromaType == i ? ColorSpace.YUV422 : ColorSpace.YUV444;
        return new Picture(i2, i3, bArr, bArr2, colorSpace, bArr2 == null ? 0 : i, new Rect(0, 0, frameHeader.width & colorSpace.getWidthMask(), frameHeader.height & colorSpace.getHeightMask()));
    }

    public void decodeOnePlane(BitReader bitReader, int i, int[] iArr, int[] iArr2, int[] iArr3, int i2, int i3, int i4) {
        try {
            readDCCoeffs(bitReader, iArr2, iArr, i, 64);
            readACCoeffs(bitReader, iArr2, iArr, i, iArr3, 64, 6);
        } catch (RuntimeException unused) {
            System.err.println("Suppressing slice error at [" + i2 + ", " + i3 + "].");
        }
        for (int i5 = 0; i5 < i; i5++) {
            SimpleIDCT10Bit.idct10(iArr, i5 << 6);
        }
    }

    public void decodePicture(ByteBuffer byteBuffer, byte[][] bArr, byte[][] bArr2, int i, int i2, int i3, int[] iArr, int[] iArr2, int[] iArr3, int i4, int i5) {
        ProresConsts.PictureHeader pictureHeader = readPictureHeader(byteBuffer);
        int i6 = 1 << pictureHeader.log2SliceMbWidth;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < pictureHeader.sliceSizes.length; i9++) {
            while (i3 - i7 < i6) {
                i6 >>= 1;
            }
            decodeSlice(NIOUtils.read(byteBuffer, pictureHeader.sliceSizes[i9]), iArr, iArr2, iArr3, i6, i7, i8, pictureHeader.sliceSizes[i9], bArr, bArr2, i, i4, i5);
            int i10 = i7 + i6;
            if (i10 == i3) {
                i6 = 1 << pictureHeader.log2SliceMbWidth;
                i8++;
                i7 = 0;
            } else {
                i7 = i10;
            }
        }
    }

    @Override // org.jcodec.common.VideoDecoder
    public VideoCodecMeta getCodecMeta(ByteBuffer byteBuffer) {
        ProresConsts.FrameHeader frameHeader = readFrameHeader(byteBuffer);
        return VideoCodecMeta.createSimpleVideoCodecMeta(new Size(frameHeader.width, frameHeader.height), frameHeader.chromaType == 2 ? ColorSpace.YUV422 : ColorSpace.YUV444);
    }

    public boolean isProgressive(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(20) & ExifInterface.MARKER) >> 2) & 3) == 0;
    }

    public void putSlice(byte[][] bArr, byte[][] bArr2, int i, int i2, int i3, int[] iArr, int[] iArr2, int[] iArr3, int i4, int i5, int i6, int i7) {
        int i8 = i >> 1;
        int i9 = i5 * i;
        int i10 = i << i4;
        putLuma(bArr[0], bArr2 != null ? bArr2[0] : null, i9, i10, i2, i3, iArr, i7, i4, i5);
        if (i6 != 2) {
            putLuma(bArr[1], bArr2 != null ? bArr2[1] : null, i9, i10, i2, i3, iArr2, i7, i4, i5);
            putLuma(bArr[2], bArr2 != null ? bArr2[2] : null, i9, i10, i2, i3, iArr3, i7, i4, i5);
        } else {
            int i11 = i5 * i8;
            int i12 = i8 << i4;
            putChroma(bArr[1], bArr2 != null ? bArr2[1] : null, i11, i12, i2, i3, iArr2, i7, i4, i5);
            putChroma(bArr[2], bArr2 != null ? bArr2[2] : null, i11, i12, i2, i3, iArr3, i7, i4, i5);
        }
    }
}
