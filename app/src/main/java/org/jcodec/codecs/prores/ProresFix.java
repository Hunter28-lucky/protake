package org.jcodec.codecs.prores;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.codecs.prores.ProresConsts;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class ProresFix {
    public static List<String> check(ByteBuffer byteBuffer) {
        ArrayList arrayList = new ArrayList();
        byteBuffer.getInt();
        if (!"icpf".equals(ProresDecoder.readSig(byteBuffer))) {
            arrayList.add("[ERROR] Missing ProRes signature (icpf).");
            return arrayList;
        }
        if (byteBuffer.getShort() > 148) {
            arrayList.add("[ERROR] Wrong ProRes frame header.");
            return arrayList;
        }
        byteBuffer.getShort();
        byteBuffer.getInt();
        short s = byteBuffer.getShort();
        short s2 = byteBuffer.getShort();
        if (s < 0 || s > 10000 || s2 < 0 || s2 > 10000) {
            arrayList.add("[ERROR] Wrong ProRes frame header, invalid image size [" + ((int) s) + "x" + ((int) s2) + "].");
            return arrayList;
        }
        byte b = byteBuffer.get();
        byteBuffer.position((byteBuffer.position() + r1) - 13);
        if (((b >> 2) & 3) == 0) {
            checkPicture(byteBuffer, s, s2, arrayList);
        } else {
            int i = s2 / 2;
            checkPicture(byteBuffer, s, i, arrayList);
            checkPicture(byteBuffer, s, i, arrayList);
        }
        return arrayList;
    }

    private static void checkCoeff(BitReader bitReader, int i) {
        int[] iArr = new int[i << 6];
        readDCCoeffs(bitReader, iArr, i);
        readACCoeffs(bitReader, iArr, i, new int[64]);
    }

    private static void checkPicture(ByteBuffer byteBuffer, int i, int i2, List<String> list) {
        ProresConsts.PictureHeader pictureHeader = ProresDecoder.readPictureHeader(byteBuffer);
        int i3 = (i + 15) >> 4;
        int i4 = 1 << pictureHeader.log2SliceMbWidth;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < pictureHeader.sliceSizes.length; i7++) {
            while (i3 - i5 < i4) {
                i4 >>= 1;
            }
            try {
                checkSlice(NIOUtils.read(byteBuffer, pictureHeader.sliceSizes[i7]), i4);
            } catch (Exception e2) {
                list.add("[ERROR] Slice data corrupt: mbX = " + i5 + ", mbY = " + i6 + ". " + e2.getMessage());
            }
            i5 += i4;
            if (i5 == i3) {
                i4 = 1 << pictureHeader.log2SliceMbWidth;
                i6++;
                i5 = 0;
            }
        }
    }

    private static void checkSlice(ByteBuffer byteBuffer, int i) {
        int iRemaining = byteBuffer.remaining();
        int i2 = (byteBuffer.get() & ExifInterface.MARKER) >> 3;
        byteBuffer.get();
        short s = byteBuffer.getShort();
        short s2 = byteBuffer.getShort();
        checkCoeff(ProresDecoder.bitstream(byteBuffer, s), i << 2);
        int i3 = i << 1;
        checkCoeff(ProresDecoder.bitstream(byteBuffer, s2), i3);
        checkCoeff(ProresDecoder.bitstream(byteBuffer, ((iRemaining - s2) - s) - i2), i3);
    }

    public static void copyCoeff(BitReader bitReader, BitWriter bitWriter, int i, int[] iArr) {
        int[] iArr2 = new int[i << 6];
        try {
            readDCCoeffs(bitReader, iArr2, i);
            readACCoeffs(bitReader, iArr2, i, iArr);
        } catch (RuntimeException unused) {
        }
        writeDCCoeffs(bitWriter, iArr2, i);
        writeACCoeffs(bitWriter, iArr2, i, iArr);
        bitWriter.flush();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
    
        throw new java.lang.RuntimeException("Run codeword damaged");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void readACCoeffs(org.jcodec.common.io.BitReader r8, int[] r9, int r10, int[] r11) {
        /*
            int r0 = r10 + (-1)
            int r10 = org.jcodec.common.tools.MathUtil.log2(r10)
            r1 = 64
            int r1 = r1 << r10
            r2 = 4
            r3 = 2
            r4 = r0
        Lc:
            int r5 = r8.remaining()
            r6 = 32
            if (r5 > r6) goto L1e
            r5 = 24
            int r5 = r8.checkNBit(r5)
            if (r5 == 0) goto L1d
            goto L1e
        L1d:
            return
        L1e:
            org.jcodec.codecs.prores.Codebook[] r5 = org.jcodec.codecs.prores.ProresConsts.runCodebooks
            r6 = 15
            int r2 = java.lang.Math.min(r2, r6)
            r2 = r5[r2]
            int r2 = org.jcodec.codecs.prores.ProresDecoder.readCodeword(r8, r2)
            if (r2 < 0) goto L6b
            int r5 = r1 - r4
            int r5 = r5 + (-1)
            if (r2 >= r5) goto L6b
            int r5 = r2 + 1
            int r4 = r4 + r5
            org.jcodec.codecs.prores.Codebook[] r5 = org.jcodec.codecs.prores.ProresConsts.levCodebooks
            r6 = 9
            int r3 = java.lang.Math.min(r3, r6)
            r3 = r5[r3]
            int r3 = org.jcodec.codecs.prores.ProresDecoder.readCodeword(r8, r3)
            int r3 = r3 + 1
            if (r3 < 0) goto L63
            r5 = 65535(0xffff, float:9.1834E-41)
            if (r3 > r5) goto L63
            int r5 = r8.read1Bit()
            int r5 = -r5
            int r6 = r4 >> r10
            r7 = r4 & r0
            int r7 = r7 << 6
            r6 = r11[r6]
            int r7 = r7 + r6
            int r5 = org.jcodec.common.tools.MathUtil.toSigned(r3, r5)
            r9[r7] = r5
            goto Lc
        L63:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r9 = "Level codeword damaged"
            r8.<init>(r9)
            throw r8
        L6b:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r9 = "Run codeword damaged"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.prores.ProresFix.readACCoeffs(org.jcodec.common.io.BitReader, int[], int, int[]):void");
    }

    public static final void readDCCoeffs(BitReader bitReader, int[] iArr, int i) {
        int codeword = ProresDecoder.readCodeword(bitReader, ProresConsts.firstDCCodebook);
        iArr[0] = codeword;
        if (codeword < 0) {
            throw new RuntimeException("First DC coeff damaged");
        }
        int codeword2 = 5;
        int i2 = 1;
        int i3 = 64;
        while (i2 < i) {
            codeword2 = ProresDecoder.readCodeword(bitReader, ProresConsts.dcCodebooks[Math.min(codeword2, 6)]);
            if (codeword2 < 0) {
                throw new RuntimeException("DC coeff damaged");
            }
            iArr[i3] = codeword2;
            i2++;
            i3 += 64;
        }
    }

    public static ByteBuffer transcode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        ByteBuffer byteBufferSlice = byteBuffer2.slice();
        ByteBuffer byteBufferDuplicate = byteBufferSlice.duplicate();
        ProresConsts.FrameHeader frameHeader = ProresDecoder.readFrameHeader(byteBuffer);
        ProresEncoder.writeFrameHeader(byteBufferSlice, frameHeader);
        if (frameHeader.frameType == 0) {
            transcodePicture(byteBuffer, byteBufferSlice, frameHeader);
        } else {
            transcodePicture(byteBuffer, byteBufferSlice, frameHeader);
            transcodePicture(byteBuffer, byteBufferSlice, frameHeader);
        }
        ProresEncoder.writeFrameHeader(byteBufferDuplicate, frameHeader);
        byteBufferSlice.flip();
        return byteBufferSlice;
    }

    private static void transcodePicture(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ProresConsts.FrameHeader frameHeader) {
        ProresConsts.PictureHeader pictureHeader = ProresDecoder.readPictureHeader(byteBuffer);
        ProresEncoder.writePictureHeader(pictureHeader.log2SliceMbWidth, pictureHeader.sliceSizes.length, byteBuffer2);
        ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
        byteBuffer2.position(byteBuffer2.position() + (pictureHeader.sliceSizes.length << 1));
        int i = (frameHeader.width + 15) >> 4;
        int i2 = 1 << pictureHeader.log2SliceMbWidth;
        int i3 = 0;
        for (int i4 = 0; i4 < pictureHeader.sliceSizes.length; i4++) {
            while (i - i3 < i2) {
                i2 >>= 1;
            }
            int iPosition = byteBuffer2.position();
            transcodeSlice(byteBuffer, byteBuffer2, i2, pictureHeader.sliceSizes[i4], frameHeader);
            byteBufferDuplicate.putShort((short) (byteBuffer2.position() - iPosition));
            i3 += i2;
            if (i3 == i) {
                i2 = 1 << pictureHeader.log2SliceMbWidth;
                i3 = 0;
            }
        }
    }

    private static void transcodeSlice(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, short s, ProresConsts.FrameHeader frameHeader) {
        int i2 = (byteBuffer.get() & ExifInterface.MARKER) >> 3;
        int i3 = byteBuffer.get() & ExifInterface.MARKER;
        short s2 = byteBuffer.getShort();
        short s3 = byteBuffer.getShort();
        int i4 = ((s - s3) - s2) - i2;
        byteBuffer2.put((byte) 48);
        byteBuffer2.put((byte) i3);
        ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
        byteBuffer2.putInt(0);
        int iPosition = byteBuffer2.position();
        copyCoeff(ProresDecoder.bitstream(byteBuffer, s2), new BitWriter(byteBuffer2), i << 2, frameHeader.scan);
        int iPosition2 = byteBuffer2.position();
        int i5 = i << 1;
        copyCoeff(ProresDecoder.bitstream(byteBuffer, s3), new BitWriter(byteBuffer2), i5, frameHeader.scan);
        int iPosition3 = byteBuffer2.position();
        copyCoeff(ProresDecoder.bitstream(byteBuffer, i4), new BitWriter(byteBuffer2), i5, frameHeader.scan);
        byteBufferDuplicate.putShort((short) (iPosition2 - iPosition));
        byteBufferDuplicate.putShort((short) (iPosition3 - iPosition2));
    }

    public static final void writeACCoeffs(BitWriter bitWriter, int[] iArr, int i, int[] iArr2) {
        int i2 = 4;
        int i3 = 2;
        int i4 = 0;
        for (int i5 = 1; i5 < 64; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < i; i7++) {
                int i8 = iArr[(i7 << 6) + i6];
                if (i8 == 0) {
                    i4++;
                } else {
                    ProresEncoder.writeCodeword(bitWriter, ProresConsts.runCodebooks[Math.min(i2, 15)], i4);
                    int level = ProresEncoder.getLevel(i8);
                    ProresEncoder.writeCodeword(bitWriter, ProresConsts.levCodebooks[Math.min(i3, 9)], level - 1);
                    bitWriter.write1Bit(MathUtil.sign(i8));
                    i3 = level;
                    i2 = i4;
                    i4 = 0;
                }
            }
        }
    }

    public static final void writeDCCoeffs(BitWriter bitWriter, int[] iArr, int i) {
        ProresEncoder.writeCodeword(bitWriter, ProresConsts.firstDCCodebook, iArr[0]);
        int i2 = 1;
        int i3 = 5;
        int i4 = 64;
        while (i2 < i) {
            ProresEncoder.writeCodeword(bitWriter, ProresConsts.dcCodebooks[Math.min(i3, 6)], iArr[i4]);
            i3 = iArr[i4];
            i2++;
            i4 += 64;
        }
    }
}
