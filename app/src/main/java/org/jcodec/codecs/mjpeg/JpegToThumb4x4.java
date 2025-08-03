package org.jcodec.codecs.mjpeg;

import java.nio.ByteBuffer;
import org.jcodec.common.dct.IDCT4x4;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class JpegToThumb4x4 extends JpegDecoder {
    private static final int[] mapping4x4 = {0, 1, 4, 8, 5, 2, 3, 6, 9, 12, 16, 13, 10, 7, 16, 16, 16, 11, 14, 16, 16, 16, 16, 16, 15, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16};

    private static void putBlock4x4(byte[] bArr, int i, int[] iArr, int i2, int i3, int i4, int i5) {
        int i6 = i >> 1;
        int i7 = i5 * i6;
        int i8 = (i4 * i6) + ((i3 >> 1) * i7) + (i2 >> 1);
        for (int i9 = 0; i9 < 16; i9 += 4) {
            bArr[i8] = (byte) (MathUtil.clip(iArr[i9], 0, 255) - 128);
            bArr[i8 + 1] = (byte) (MathUtil.clip(iArr[i9 + 1], 0, 255) - 128);
            bArr[i8 + 2] = (byte) (MathUtil.clip(iArr[i9 + 2], 0, 255) - 128);
            bArr[i8 + 3] = (byte) (MathUtil.clip(iArr[i9 + 3], 0, 255) - 128);
            i8 += i7;
        }
    }

    @Override // org.jcodec.codecs.mjpeg.JpegDecoder
    public void decodeBlock(BitReader bitReader, int[] iArr, int[][] iArr2, VLC[] vlcArr, Picture picture, int[] iArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        iArr3[15] = 0;
        iArr3[14] = 0;
        iArr3[13] = 0;
        iArr3[12] = 0;
        iArr3[11] = 0;
        iArr3[10] = 0;
        iArr3[9] = 0;
        iArr3[8] = 0;
        iArr3[7] = 0;
        iArr3[6] = 0;
        iArr3[5] = 0;
        iArr3[4] = 0;
        iArr3[3] = 0;
        iArr3[2] = 0;
        iArr3[1] = 0;
        int dCValue = JpegDecoder.readDCValue(bitReader, vlcArr[i4]);
        int[] iArr4 = iArr2[i4];
        int i7 = (dCValue * iArr4[0]) + iArr[i3];
        iArr3[0] = i7;
        iArr[i3] = i7;
        readACValues(bitReader, iArr3, vlcArr[i4 + 2], iArr4);
        IDCT4x4.idct(iArr3, 0);
        putBlock4x4(picture.getPlaneData(i3), picture.getPlaneWidth(i3), iArr3, i, i2, i5, i6);
    }

    @Override // org.jcodec.codecs.mjpeg.JpegDecoder
    public Picture decodeField(ByteBuffer byteBuffer, byte[][] bArr, int i, int i2) {
        Picture pictureDecodeField = super.decodeField(byteBuffer, bArr, i, i2);
        return new Picture(pictureDecodeField.getWidth() >> 1, pictureDecodeField.getHeight() >> 1, pictureDecodeField.getData(), null, pictureDecodeField.getColor(), 0, new Rect(0, 0, pictureDecodeField.getCroppedWidth() >> 1, pictureDecodeField.getCroppedHeight() >> 1));
    }

    @Override // org.jcodec.codecs.mjpeg.JpegDecoder
    public void readACValues(BitReader bitReader, int[] iArr, VLC vlc, int[] iArr2) {
        int vlc16;
        int i = 1;
        do {
            vlc16 = vlc.readVLC16(bitReader);
            if (vlc16 == 240) {
                i += 16;
            } else if (vlc16 > 0) {
                int i2 = i + (vlc16 >> 4);
                int i3 = vlc16 & 15;
                iArr[mapping4x4[i2]] = JpegDecoder.toValue(bitReader.readNBit(i3), i3) * iArr2[i2];
                i = i2 + 1;
            }
            if (vlc16 == 0) {
                break;
            }
        } while (i < 19);
        if (vlc16 != 0) {
            do {
                int vlc162 = vlc.readVLC16(bitReader);
                if (vlc162 == 240) {
                    i += 16;
                } else if (vlc162 > 0) {
                    bitReader.skip(vlc162 & 15);
                    i = i + (vlc162 >> 4) + 1;
                }
                if (vlc162 == 0) {
                    return;
                }
            } while (i < 64);
        }
    }
}
