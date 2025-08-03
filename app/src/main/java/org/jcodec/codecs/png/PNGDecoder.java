package org.jcodec.codecs.png;

import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Size;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class PNGDecoder extends VideoDecoder {
    private static final int FILTER_TYPE_LOCO = 64;
    private static final int FILTER_VALUE_AVG = 3;
    private static final int FILTER_VALUE_NONE = 0;
    private static final int FILTER_VALUE_PAETH = 4;
    private static final int FILTER_VALUE_SUB = 1;
    private static final int FILTER_VALUE_UP = 2;
    private static final int PNG_COLOR_TYPE_GRAY = 0;
    private static final int PNG_COLOR_TYPE_PALETTE = 3;
    private static final int PNG_COLOR_TYPE_RGB = 2;
    private static final int alphaB = 127;
    private static final int alphaG = 127;
    private static final int alphaR = 127;
    private byte[] ca = new byte[4];
    private static final int[] logPassStep = {3, 3, 2, 2, 1, 1, 0};
    private static final int[] logPassRowStep = {3, 3, 3, 2, 2, 1, 1};
    private static final int[] passOff = {0, 4, 0, 2, 0, 1, 0};
    private static final int[] passRowOff = {0, 0, 4, 0, 2, 0, 1};

    public static class PLTE {
        public int[] palette;

        private PLTE() {
        }

        public void parse(ByteBuffer byteBuffer, int i) {
            if (i % 3 != 0 || i > 768) {
                throw new RuntimeException("Invalid data");
            }
            int i2 = i / 3;
            this.palette = new int[i2];
            int i3 = 0;
            while (i3 < i2) {
                this.palette[i3] = (-16777216) | ((byteBuffer.get() & ExifInterface.MARKER) << 16) | ((byteBuffer.get() & ExifInterface.MARKER) << 8) | (byteBuffer.get() & ExifInterface.MARKER);
                i3++;
            }
            while (i3 < 256) {
                this.palette[i3] = -16777216;
                i3++;
            }
            byteBuffer.getInt();
        }
    }

    public static class TRNS {
        public byte alphaB;
        public byte alphaG;
        public byte alphaGrey;
        public byte[] alphaPal;
        public byte alphaR;
        private int colorType;

        public TRNS(byte b) {
            this.colorType = b;
        }

        public void parse(ByteBuffer byteBuffer, int i) {
            int i2 = this.colorType;
            if (i2 == 3) {
                byte[] bArr = new byte[256];
                this.alphaPal = bArr;
                byteBuffer.get(bArr, 0, i);
                while (i < 256) {
                    this.alphaPal[i] = -1;
                    i++;
                }
            } else if (i2 == 0) {
                this.alphaGrey = byteBuffer.get();
            } else if (i2 == 2) {
                this.alphaR = byteBuffer.get();
                this.alphaG = byteBuffer.get();
                this.alphaG = byteBuffer.get();
            }
            byteBuffer.getInt();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x02ba, code lost:
    
        r5 = 3;
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void decodeData(org.jcodec.codecs.png.IHDR r26, org.jcodec.codecs.png.PNGDecoder.PLTE r27, org.jcodec.codecs.png.PNGDecoder.TRNS r28, java.util.List<java.nio.ByteBuffer> r29, byte[][] r30) throws java.util.zip.DataFormatException {
        /*
            Method dump skipped, instructions count: 713
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.png.PNGDecoder.decodeData(org.jcodec.codecs.png.IHDR, org.jcodec.codecs.png.PNGDecoder$PLTE, org.jcodec.codecs.png.PNGDecoder$TRNS, java.util.List, byte[][]):void");
    }

    public static byte[] deflate(byte[] bArr, Inflater inflater) throws DataFormatException {
        inflater.setInput(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        byte[] bArr2 = new byte[16384];
        while (!inflater.needsInput()) {
            byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
            System.out.println(byteArrayOutputStream.size());
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static void filterAvg(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (i2 == 1) {
            filterAvg1(bArr, bArr2, i);
            return;
        }
        if (i2 == 2) {
            filterAvg2(bArr, bArr2, i);
        } else if (i2 != 3) {
            filterAvg4(bArr, bArr2, i);
        } else {
            filterAvg3(bArr, bArr2, i);
        }
    }

    private static void filterAvg1(byte[] bArr, byte[] bArr2, int i) {
        byte b = (byte) ((bArr[1] & ExifInterface.MARKER) + ((bArr2[0] & ExifInterface.MARKER) >> 1));
        bArr2[0] = b;
        int i2 = 1;
        while (i2 < i) {
            int i3 = i2 + 1;
            b = (byte) ((((bArr2[i2] & ExifInterface.MARKER) + (b & ExifInterface.MARKER)) >> 1) + (bArr[i3] & ExifInterface.MARKER));
            bArr2[i2] = b;
            i2 = i3;
        }
    }

    private static void filterAvg2(byte[] bArr, byte[] bArr2, int i) {
        byte b = (byte) ((bArr[1] & ExifInterface.MARKER) + ((bArr2[0] & ExifInterface.MARKER) >> 1));
        bArr2[0] = b;
        int i2 = 2;
        byte b2 = (byte) ((bArr[2] & ExifInterface.MARKER) + ((bArr2[1] & ExifInterface.MARKER) >> 1));
        bArr2[1] = b2;
        while (i2 < i) {
            int i3 = i2 + 1;
            b = (byte) ((((bArr2[i2] & ExifInterface.MARKER) + (b & ExifInterface.MARKER)) >> 1) + (bArr[i3] & ExifInterface.MARKER));
            bArr2[i2] = b;
            i2 += 2;
            b2 = (byte) ((((bArr2[i3] & ExifInterface.MARKER) + (b2 & ExifInterface.MARKER)) >> 1) + (bArr[i2] & ExifInterface.MARKER));
            bArr2[i3] = b2;
        }
    }

    private static void filterAvg3(byte[] bArr, byte[] bArr2, int i) {
        byte b = (byte) ((bArr[1] & ExifInterface.MARKER) + ((bArr2[0] & ExifInterface.MARKER) >> 1));
        bArr2[0] = b;
        byte b2 = (byte) ((bArr[2] & ExifInterface.MARKER) + ((bArr2[1] & ExifInterface.MARKER) >> 1));
        bArr2[1] = b2;
        int i2 = 3;
        byte b3 = (byte) ((bArr[3] & ExifInterface.MARKER) + ((bArr2[2] & ExifInterface.MARKER) >> 1));
        bArr2[2] = b3;
        while (i2 < i) {
            int i3 = i2 + 1;
            b = (byte) ((((bArr2[i2] & ExifInterface.MARKER) + (b & ExifInterface.MARKER)) >> 1) + (bArr[i3] & ExifInterface.MARKER));
            bArr2[i2] = b;
            int i4 = i2 + 2;
            b2 = (byte) ((((bArr2[i3] & ExifInterface.MARKER) + (b2 & ExifInterface.MARKER)) >> 1) + (bArr[i4] & ExifInterface.MARKER));
            bArr2[i3] = b2;
            i2 += 3;
            b3 = (byte) ((((bArr2[i4] & ExifInterface.MARKER) + (b3 & ExifInterface.MARKER)) >> 1) + (bArr[i2] & ExifInterface.MARKER));
            bArr2[i4] = b3;
        }
    }

    private static void filterAvg4(byte[] bArr, byte[] bArr2, int i) {
        byte b = (byte) ((bArr[1] & ExifInterface.MARKER) + ((bArr2[0] & ExifInterface.MARKER) >> 1));
        bArr2[0] = b;
        byte b2 = (byte) ((bArr[2] & ExifInterface.MARKER) + ((bArr2[1] & ExifInterface.MARKER) >> 1));
        bArr2[1] = b2;
        byte b3 = (byte) ((bArr[3] & ExifInterface.MARKER) + ((bArr2[2] & ExifInterface.MARKER) >> 1));
        bArr2[2] = b3;
        int i2 = 4;
        byte b4 = (byte) ((bArr[4] & ExifInterface.MARKER) + ((bArr2[3] & ExifInterface.MARKER) >> 1));
        bArr2[3] = b4;
        while (i2 < i) {
            int i3 = i2 + 1;
            b = (byte) ((((bArr2[i2] & ExifInterface.MARKER) + (b & ExifInterface.MARKER)) >> 1) + (bArr[i3] & ExifInterface.MARKER));
            bArr2[i2] = b;
            int i4 = i2 + 2;
            b2 = (byte) ((((bArr2[i3] & ExifInterface.MARKER) + (b2 & ExifInterface.MARKER)) >> 1) + (bArr[i4] & ExifInterface.MARKER));
            bArr2[i3] = b2;
            int i5 = ((bArr2[i4] & ExifInterface.MARKER) + (b3 & ExifInterface.MARKER)) >> 1;
            int i6 = i2 + 3;
            byte b5 = (byte) (i5 + (bArr[i6] & ExifInterface.MARKER));
            bArr2[i4] = b5;
            i2 += 4;
            b4 = (byte) ((((bArr2[i6] & ExifInterface.MARKER) + (b4 & ExifInterface.MARKER)) >> 1) + (bArr[i2] & ExifInterface.MARKER));
            bArr2[i6] = b4;
            b3 = b5;
        }
    }

    private void filterPaeth(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            this.ca[i3] = bArr2[i3];
            int i4 = i3 + 1;
            bArr2[i3] = (byte) ((bArr[i4] & ExifInterface.MARKER) + (bArr2[i3] & ExifInterface.MARKER));
            i3 = i4;
        }
        int i5 = i2;
        while (i5 < i) {
            int i6 = bArr2[i5 - i2] & ExifInterface.MARKER;
            int i7 = bArr2[i5] & ExifInterface.MARKER;
            int i8 = i5 % i2;
            int i9 = this.ca[i8] & ExifInterface.MARKER;
            int i10 = i7 - i9;
            int i11 = i6 - i9;
            int iAbs = MathUtil.abs(i10);
            int iAbs2 = MathUtil.abs(i11);
            int iAbs3 = MathUtil.abs(i10 + i11);
            if (iAbs > iAbs2 || iAbs > iAbs3) {
                i6 = iAbs2 <= iAbs3 ? i7 : i9;
            }
            this.ca[i8] = bArr2[i5];
            int i12 = i5 + 1;
            bArr2[i5] = (byte) (i6 + (bArr[i12] & ExifInterface.MARKER));
            i5 = i12;
        }
    }

    private static void filterSub(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (i2 == 1) {
            filterSub1(bArr, bArr2, i);
            return;
        }
        if (i2 == 2) {
            filterSub2(bArr, bArr2, i);
        } else if (i2 != 3) {
            filterSub4(bArr, bArr2, i);
        } else {
            filterSub3(bArr, bArr2, i);
        }
    }

    private static void filterSub1(byte[] bArr, byte[] bArr2, int i) {
        int i2 = 1;
        byte b = bArr[1];
        bArr2[0] = b;
        while (i2 < i) {
            int i3 = i2 + 1;
            b = (byte) ((b & ExifInterface.MARKER) + (bArr[i3] & ExifInterface.MARKER));
            bArr2[i2] = b;
            i2 = i3;
        }
    }

    private static void filterSub2(byte[] bArr, byte[] bArr2, int i) {
        byte b = bArr[1];
        bArr2[0] = b;
        int i2 = 2;
        byte b2 = bArr[2];
        bArr2[1] = b2;
        while (i2 < i) {
            int i3 = b & ExifInterface.MARKER;
            int i4 = i2 + 1;
            byte b3 = (byte) (i3 + (bArr[i4] & ExifInterface.MARKER));
            bArr2[i2] = b3;
            i2 += 2;
            b2 = (byte) ((b2 & ExifInterface.MARKER) + (bArr[i2] & ExifInterface.MARKER));
            bArr2[i4] = b2;
            b = b3;
        }
    }

    private static void filterSub3(byte[] bArr, byte[] bArr2, int i) {
        byte b = bArr[1];
        bArr2[0] = b;
        byte b2 = bArr[2];
        bArr2[1] = b2;
        int i2 = 3;
        byte b3 = bArr[3];
        bArr2[2] = b3;
        while (i2 < i) {
            int i3 = i2 + 1;
            b = (byte) ((b & ExifInterface.MARKER) + (bArr[i3] & ExifInterface.MARKER));
            bArr2[i2] = b;
            int i4 = i2 + 2;
            b2 = (byte) ((b2 & ExifInterface.MARKER) + (bArr[i4] & ExifInterface.MARKER));
            bArr2[i3] = b2;
            i2 += 3;
            b3 = (byte) ((b3 & ExifInterface.MARKER) + (bArr[i2] & ExifInterface.MARKER));
            bArr2[i4] = b3;
        }
    }

    private static void filterSub4(byte[] bArr, byte[] bArr2, int i) {
        byte b = bArr[1];
        bArr2[0] = b;
        byte b2 = bArr[2];
        bArr2[1] = b2;
        byte b3 = bArr[3];
        bArr2[2] = b3;
        int i2 = 4;
        byte b4 = bArr[4];
        bArr2[3] = b4;
        while (i2 < i) {
            int i3 = b & ExifInterface.MARKER;
            int i4 = i2 + 1;
            byte b5 = (byte) (i3 + (bArr[i4] & ExifInterface.MARKER));
            bArr2[i2] = b5;
            int i5 = i2 + 2;
            b2 = (byte) ((b2 & ExifInterface.MARKER) + (bArr[i5] & ExifInterface.MARKER));
            bArr2[i4] = b2;
            int i6 = b3 & ExifInterface.MARKER;
            int i7 = i2 + 3;
            byte b6 = (byte) (i6 + (bArr[i7] & ExifInterface.MARKER));
            bArr2[i5] = b6;
            i2 += 4;
            b4 = (byte) ((b4 & ExifInterface.MARKER) + (bArr[i2] & ExifInterface.MARKER));
            bArr2[i7] = b4;
            b3 = b6;
            b = b5;
        }
    }

    private static void filterUp(byte[] bArr, int i, byte[] bArr2) {
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) ((bArr2[i2] & ExifInterface.MARKER) + (bArr[i3] & ExifInterface.MARKER));
            i2 = i3;
        }
    }

    private static boolean ispng(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        return (i == -1991225785 || i == -1974645177) && (i2 == 218765834 || i2 == 218765834);
    }

    public static int probe(ByteBuffer byteBuffer) {
        return !ispng(byteBuffer) ? 100 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    @Override // org.jcodec.common.VideoDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.jcodec.common.model.Picture decodeFrame(java.nio.ByteBuffer r9, byte[][] r10) {
        /*
            r8 = this;
            boolean r0 = ispng(r9)
            if (r0 == 0) goto L88
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r0 = 0
            r3 = r0
            r4 = r3
            r7 = r4
        Lf:
            int r1 = r9.remaining()
            r2 = 8
            if (r1 < r2) goto L6a
            int r1 = r9.getInt()
            int r2 = r9.getInt()
            int r6 = r9.remaining()
            if (r6 >= r1) goto L26
            goto L6a
        L26:
            r6 = 4
            switch(r2) {
                case 1229209940: goto L5f;
                case 1229278788: goto L5b;
                case 1229472850: goto L52;
                case 1347179589: goto L49;
                case 1951551059: goto L34;
                default: goto L2a;
            }
        L2a:
            int r2 = r9.position()
            int r2 = r2 + r1
            int r2 = r2 + r6
            r9.position(r2)
            goto Lf
        L34:
            if (r7 == 0) goto L41
            org.jcodec.codecs.png.PNGDecoder$TRNS r4 = new org.jcodec.codecs.png.PNGDecoder$TRNS
            byte r2 = r7.colorType
            r4.<init>(r2)
            r4.parse(r9, r1)
            goto Lf
        L41:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "tRNS tag before IHDR"
            r9.<init>(r10)
            throw r9
        L49:
            org.jcodec.codecs.png.PNGDecoder$PLTE r3 = new org.jcodec.codecs.png.PNGDecoder$PLTE
            r3.<init>()
            r3.parse(r9, r1)
            goto Lf
        L52:
            org.jcodec.codecs.png.IHDR r7 = new org.jcodec.codecs.png.IHDR
            r7.<init>()
            r7.parse(r9)
            goto Lf
        L5b:
            org.jcodec.common.io.NIOUtils.skip(r9, r6)
            goto Lf
        L5f:
            java.nio.ByteBuffer r1 = org.jcodec.common.io.NIOUtils.read(r9, r1)
            r5.add(r1)
            org.jcodec.common.io.NIOUtils.skip(r9, r6)
            goto Lf
        L6a:
            if (r7 == 0) goto L80
            r1 = r8
            r2 = r7
            r6 = r10
            r1.decodeData(r2, r3, r4, r5, r6)     // Catch: java.util.zip.DataFormatException -> L7f
            int r9 = r7.width
            int r0 = r7.height
            org.jcodec.common.model.ColorSpace r1 = r7.colorSpace()
            org.jcodec.common.model.Picture r9 = org.jcodec.common.model.Picture.createPicture(r9, r0, r10, r1)
            return r9
        L7f:
            return r0
        L80:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "no IHDR tag"
            r9.<init>(r10)
            throw r9
        L88:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.String r10 = "Not a PNG file."
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.png.PNGDecoder.decodeFrame(java.nio.ByteBuffer, byte[][]):org.jcodec.common.model.Picture");
    }

    @Override // org.jcodec.common.VideoDecoder
    public VideoCodecMeta getCodecMeta(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        if (!ispng(byteBufferDuplicate)) {
            throw new RuntimeException("Not a PNG file.");
        }
        while (byteBufferDuplicate.remaining() >= 8) {
            int i = byteBufferDuplicate.getInt();
            int i2 = byteBufferDuplicate.getInt();
            if (byteBufferDuplicate.remaining() < i) {
                return null;
            }
            if (i2 == 1229472850) {
                IHDR ihdr = new IHDR();
                ihdr.parse(byteBufferDuplicate);
                return VideoCodecMeta.createSimpleVideoCodecMeta(new Size(ihdr.width, ihdr.height), ColorSpace.RGB);
            }
            byteBufferDuplicate.position(byteBufferDuplicate.position() + i + 4);
        }
        return null;
    }
}
