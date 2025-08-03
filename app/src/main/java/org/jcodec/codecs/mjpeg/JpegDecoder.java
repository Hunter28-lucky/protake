package org.jcodec.codecs.mjpeg;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jcodec.api.UnhandledStateException;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.dct.SimpleIDCT10Bit;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.VLC;
import org.jcodec.common.io.VLCBuilder;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.model.Size;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class JpegDecoder extends VideoDecoder {
    public int[] buf = new int[64];
    private boolean interlace;
    private boolean topFieldFirst;

    private void decodeMCU(BitReader bitReader, int[] iArr, int[][] iArr2, VLC[] vlcArr, Picture picture, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i << (i3 - 1);
        int i8 = i2 << (i4 - 1);
        int i9 = 0;
        while (i9 < i4) {
            int i10 = 0;
            while (i10 < i3) {
                decodeBlock(bitReader, iArr, iArr2, vlcArr, picture, this.buf, (i7 + i10) << 3, (i8 + i9) << 3, 0, 0, i5, i6);
                i10++;
                i9 = i9;
            }
            i9++;
        }
        int i11 = i << 3;
        int i12 = i2 << 3;
        decodeBlock(bitReader, iArr, iArr2, vlcArr, picture, this.buf, i11, i12, 1, 1, i5, i6);
        decodeBlock(bitReader, iArr, iArr2, vlcArr, picture, this.buf, i11, i12, 2, 1, i5, i6);
    }

    private Picture decodeScan(ByteBuffer byteBuffer, FrameHeader frameHeader, ScanHeader scanHeader, VLC[] vlcArr, int[][] iArr, byte[][] bArr, int i, int i2) {
        int hmax = frameHeader.getHmax();
        int vmax = frameHeader.getVmax();
        int i3 = hmax + 2;
        int i4 = (((hmax << 3) + r3) - 1) >> i3;
        int i5 = vmax + 2;
        int i6 = (((vmax << 3) + r0) - 1) >> i5;
        int i7 = hmax + vmax;
        int i8 = 0;
        Picture picture = new Picture(i4 << i3, i6 << i5, bArr, null, i7 == 4 ? ColorSpace.YUV420J : i7 == 3 ? ColorSpace.YUV422J : ColorSpace.YUV444J, 0, new Rect(0, 0, frameHeader.width, frameHeader.height));
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        int[] iArr2 = {1024, 1024, 1024};
        int i9 = 0;
        while (i9 < i6) {
            int i10 = i8;
            while (i10 < i4 && bitReaderCreateBitReader.moreData()) {
                decodeMCU(bitReaderCreateBitReader, iArr2, iArr, vlcArr, picture, i10, i9, hmax, vmax, i, i2);
                i10++;
                i9 = i9;
                iArr2 = iArr2;
                i8 = i8;
            }
            i9++;
            iArr2 = iArr2;
            i8 = i8;
        }
        return picture;
    }

    private static void putBlock(byte[] bArr, int i, int[] iArr, int i2, int i3, int i4, int i5) {
        int i6 = i5 * i;
        int i7 = (i4 * i) + (i3 * i6) + i2;
        int i8 = 0;
        for (int i9 = 0; i9 < 8; i9++) {
            for (int i10 = 0; i10 < 8; i10++) {
                bArr[i10 + i7] = (byte) (MathUtil.clip(iArr[i10 + i8], 0, 255) - 128);
            }
            i7 += i6;
            i8 += 8;
        }
    }

    public static int readDCValue(BitReader bitReader, VLC vlc) {
        int vlc16 = vlc.readVLC16(bitReader);
        if (vlc16 != 0) {
            return toValue(bitReader.readNBit(vlc16), vlc16);
        }
        return 0;
    }

    private static VLC readHuffmanTable(ByteBuffer byteBuffer) {
        VLCBuilder vLCBuilder = new VLCBuilder();
        byte[] array = NIOUtils.toArray(NIOUtils.read(byteBuffer, 16));
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            int i3 = array[i2] & ExifInterface.MARKER;
            int i4 = 0;
            while (i4 < i3) {
                vLCBuilder.setInt(i, i2 + 1, byteBuffer.get() & ExifInterface.MARKER);
                i4++;
                i++;
            }
            i <<= 1;
        }
        return vLCBuilder.getVLC();
    }

    private static int[] readQuantTable(ByteBuffer byteBuffer) {
        int[] iArr = new int[64];
        for (int i = 0; i < 64; i++) {
            iArr[i] = byteBuffer.get() & ExifInterface.MARKER;
        }
        return iArr;
    }

    private static ByteBuffer readToMarker(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        while (true) {
            if (!byteBuffer.hasRemaining()) {
                break;
            }
            byte b = byteBuffer.get();
            if (b != -1) {
                byteBufferAllocate.put(b);
            } else {
                if (byteBuffer.get() != 0) {
                    byteBuffer.position(byteBuffer.position() - 2);
                    break;
                }
                byteBufferAllocate.put((byte) -1);
            }
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static int toValue(int i, int i2) {
        return (i2 < 1 || i >= (1 << (i2 + (-1)))) ? i : i + (-(1 << i2)) + 1;
    }

    public void decodeBlock(BitReader bitReader, int[] iArr, int[][] iArr2, VLC[] vlcArr, Picture picture, int[] iArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        Arrays.fill(iArr3, 0);
        int dCValue = readDCValue(bitReader, vlcArr[i4]);
        int[] iArr4 = iArr2[i4];
        int i7 = (dCValue * iArr4[0]) + iArr[i3];
        iArr3[0] = i7;
        iArr[i3] = i7;
        readACValues(bitReader, iArr3, vlcArr[i4 + 2], iArr4);
        SimpleIDCT10Bit.idct10(iArr3, 0);
        putBlock(picture.getPlaneData(i3), picture.getPlaneWidth(i3), iArr3, i, i2, i5, i6);
    }

    public Picture decodeField(ByteBuffer byteBuffer, byte[][] bArr, int i, int i2) {
        int i3;
        int i4;
        VLC[] vlcArr = new VLC[4];
        vlcArr[0] = JpegConst.YDC_DEFAULT;
        vlcArr[1] = JpegConst.CDC_DEFAULT;
        vlcArr[2] = JpegConst.YAC_DEFAULT;
        vlcArr[3] = JpegConst.CAC_DEFAULT;
        int[][] iArr = new int[2][];
        iArr[0] = JpegConst.DEFAULT_QUANT_LUMA;
        iArr[1] = JpegConst.DEFAULT_QUANT_CHROMA;
        ScanHeader scanHeader = null;
        Picture pictureDecodeScan = null;
        FrameHeader frameHeader = null;
        loop0: while (true) {
            boolean z = false;
            while (byteBuffer.hasRemaining()) {
                if (z) {
                    do {
                        i3 = byteBuffer.get() & ExifInterface.MARKER;
                    } while (i3 != 255);
                } else {
                    i3 = byteBuffer.get() & ExifInterface.MARKER;
                }
                if (i3 != 0) {
                    if (i3 != 255) {
                        throw new RuntimeException("@" + Long.toHexString(byteBuffer.position()) + " Marker expected: 0x" + Integer.toHexString(i3));
                    }
                    do {
                        i4 = byteBuffer.get() & ExifInterface.MARKER;
                    } while (i4 == 255);
                    if (i4 == 192) {
                        frameHeader = FrameHeader.read(byteBuffer);
                    } else if (i4 == 196) {
                        ByteBuffer byteBuffer2 = NIOUtils.read(byteBuffer, (byteBuffer.getShort() & 65535) - 2);
                        while (byteBuffer2.hasRemaining()) {
                            int i5 = byteBuffer2.get() & ExifInterface.MARKER;
                            vlcArr[((i5 >> 3) & 2) | (i5 & 1)] = readHuffmanTable(byteBuffer2);
                        }
                    } else if (i4 == 219) {
                        ByteBuffer byteBuffer3 = NIOUtils.read(byteBuffer, (byteBuffer.getShort() & 65535) - 2);
                        while (byteBuffer3.hasRemaining()) {
                            iArr[byteBuffer3.get() & ExifInterface.MARKER] = readQuantTable(byteBuffer3);
                        }
                    } else if (i4 != 218) {
                        if (i4 == 216 || (i4 >= 208 && i4 <= 215)) {
                            Logger.warn("SOI not supported.");
                        } else {
                            if (i4 == 217) {
                                break loop0;
                            }
                            if (i4 >= 224 && i4 <= 254) {
                                NIOUtils.read(byteBuffer, (byteBuffer.getShort() & 65535) - 2);
                            } else if (i4 == 221) {
                                Logger.warn("DRI not supported.");
                            } else if (i4 != 0) {
                                Logger.warn("unhandled marker " + JpegConst.markerToString(i4));
                            }
                        }
                        z = true;
                    } else {
                        if (scanHeader != null) {
                            throw new UnhandledStateException("unhandled - more than one scan header");
                        }
                        ScanHeader scanHeader2 = ScanHeader.read(byteBuffer);
                        pictureDecodeScan = decodeScan(readToMarker(byteBuffer), frameHeader, scanHeader2, vlcArr, iArr, bArr, i, i2);
                        z = false;
                        scanHeader = scanHeader2;
                    }
                }
            }
            break loop0;
        }
        return pictureDecodeScan;
    }

    @Override // org.jcodec.common.VideoDecoder
    public Picture decodeFrame(ByteBuffer byteBuffer, byte[][] bArr) {
        if (!this.interlace) {
            return decodeField(byteBuffer, bArr, 0, 1);
        }
        Picture pictureDecodeField = decodeField(byteBuffer, bArr, !this.topFieldFirst ? 1 : 0, 2);
        decodeField(byteBuffer, bArr, this.topFieldFirst ? 1 : 0, 2);
        return Picture.createPicture(pictureDecodeField.getWidth(), pictureDecodeField.getHeight() << 1, bArr, pictureDecodeField.getColor());
    }

    @Override // org.jcodec.common.VideoDecoder
    public VideoCodecMeta getCodecMeta(ByteBuffer byteBuffer) {
        FrameHeader frameHeader;
        int i;
        while (true) {
            if (!byteBuffer.hasRemaining()) {
                frameHeader = null;
                break;
            }
            while (byteBuffer.hasRemaining() && (byteBuffer.get() & ExifInterface.MARKER) != 255) {
            }
            do {
                i = byteBuffer.get() & ExifInterface.MARKER;
            } while (i == 255);
            if (i == 192) {
                frameHeader = FrameHeader.read(byteBuffer);
                break;
            }
        }
        if (frameHeader == null) {
            return null;
        }
        int hmax = frameHeader.getHmax() + frameHeader.getVmax();
        return VideoCodecMeta.createSimpleVideoCodecMeta(new Size(frameHeader.width, frameHeader.height), hmax == 4 ? ColorSpace.YUV420J : hmax == 3 ? ColorSpace.YUV422J : ColorSpace.YUV444J);
    }

    public void readACValues(BitReader bitReader, int[] iArr, VLC vlc, int[] iArr2) {
        int i = 1;
        do {
            int vlc16 = vlc.readVLC16(bitReader);
            if (vlc16 == 240) {
                i += 16;
            } else if (vlc16 > 0) {
                int i2 = i + (vlc16 >> 4);
                int i3 = vlc16 & 15;
                iArr[JpegConst.naturalOrder[i2]] = toValue(bitReader.readNBit(i3), i3) * iArr2[i2];
                i = i2 + 1;
            }
            if (vlc16 == 0) {
                return;
            }
        } while (i < 64);
    }

    public void setInterlace(boolean z, boolean z2) {
        this.interlace = z;
        this.topFieldFirst = z2;
    }
}
