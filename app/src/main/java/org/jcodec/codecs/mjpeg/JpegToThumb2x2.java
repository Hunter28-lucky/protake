package org.jcodec.codecs.mjpeg;

import java.nio.ByteBuffer;
import org.jcodec.common.dct.IDCT2x2;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class JpegToThumb2x2 extends JpegDecoder {
    private static final int[] mapping2x2 = {0, 1, 2, 4, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};

    private static void putBlock2x2(byte[] bArr, int i, int[] iArr, int i2, int i3, int i4, int i5) {
        int i6 = i >> 2;
        int i7 = i5 * i6;
        int i8 = (i4 * i6) + ((i3 >> 2) * i7) + (i2 >> 2);
        bArr[i8] = (byte) (MathUtil.clip(iArr[0], 0, 255) - 128);
        bArr[i8 + 1] = (byte) (MathUtil.clip(iArr[1], 0, 255) - 128);
        int i9 = i8 + i7;
        bArr[i9] = (byte) (MathUtil.clip(iArr[2], 0, 255) - 128);
        bArr[i9 + 1] = (byte) (MathUtil.clip(iArr[3], 0, 255) - 128);
    }

    @Override // org.jcodec.codecs.mjpeg.JpegDecoder
    public void decodeBlock(BitReader bitReader, int[] iArr, int[][] iArr2, VLC[] vlcArr, Picture picture, int[] iArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        iArr3[3] = 0;
        iArr3[2] = 0;
        iArr3[1] = 0;
        int dCValue = JpegDecoder.readDCValue(bitReader, vlcArr[i4]);
        int[] iArr4 = iArr2[i4];
        int i7 = (dCValue * iArr4[0]) + iArr[i3];
        iArr3[0] = i7;
        iArr[i3] = i7;
        readACValues(bitReader, iArr3, vlcArr[i4 + 2], iArr4);
        IDCT2x2.idct(iArr3, 0);
        putBlock2x2(picture.getPlaneData(i3), picture.getPlaneWidth(i3), iArr3, i, i2, i5, i6);
    }

    @Override // org.jcodec.codecs.mjpeg.JpegDecoder
    public Picture decodeField(ByteBuffer byteBuffer, byte[][] bArr, int i, int i2) {
        Picture pictureDecodeField = super.decodeField(byteBuffer, bArr, i, i2);
        return new Picture(pictureDecodeField.getWidth() >> 2, pictureDecodeField.getHeight() >> 2, pictureDecodeField.getData(), null, pictureDecodeField.getColor(), 0, new Rect(0, 0, pictureDecodeField.getCroppedWidth() >> 2, pictureDecodeField.getCroppedHeight() >> 2));
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
                iArr[mapping2x2[i2]] = JpegDecoder.toValue(bitReader.readNBit(i3), i3) * iArr2[i2];
                i = i2 + 1;
            }
            if (vlc16 == 0) {
                break;
            }
        } while (i < 5);
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
