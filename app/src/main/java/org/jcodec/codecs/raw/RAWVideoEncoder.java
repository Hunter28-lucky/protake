package org.jcodec.codecs.raw;

import java.nio.ByteBuffer;
import org.jcodec.common.VideoEncoder;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public class RAWVideoEncoder extends VideoEncoder {
    @Override // org.jcodec.common.VideoEncoder
    public VideoEncoder.EncodedFrame encodeFrame(Picture picture, ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        ColorSpace color = picture.getColor();
        if (color.planar) {
            for (int i = 0; i < color.nComp; i++) {
                int width = picture.getWidth() >> color.compWidth[i];
                int startX = picture.getStartX();
                int startY = picture.getStartY();
                int croppedWidth = picture.getCroppedWidth() >> color.compWidth[i];
                int croppedHeight = picture.getCroppedHeight() >> color.compHeight[i];
                byte[] planeData = picture.getPlaneData(i);
                int i2 = (startY * width) + startX;
                for (int i3 = 0; i3 < croppedHeight; i3++) {
                    for (int i4 = 0; i4 < croppedWidth; i4++) {
                        byteBufferDuplicate.put((byte) (planeData[i2 + i4] + BER.ASN_LONG_LEN));
                    }
                    i2 += width;
                }
            }
        } else {
            int i5 = (color.bitsPerPixel + 7) >> 3;
            int width2 = picture.getWidth() * i5;
            int startX2 = picture.getStartX();
            int startY2 = picture.getStartY();
            int croppedWidth2 = picture.getCroppedWidth();
            int croppedHeight2 = picture.getCroppedHeight();
            byte[] planeData2 = picture.getPlaneData(0);
            int i6 = (startY2 * width2) + (startX2 * i5);
            for (int i7 = 0; i7 < croppedHeight2; i7++) {
                int i8 = 0;
                int i9 = 0;
                while (i8 < croppedWidth2) {
                    for (int i10 = 0; i10 < i5; i10++) {
                        byteBufferDuplicate.put((byte) (planeData2[i6 + i9 + i10] + BER.ASN_LONG_LEN));
                    }
                    i8++;
                    i9 += i5;
                }
                i6 += width2;
            }
        }
        byteBufferDuplicate.flip();
        return new VideoEncoder.EncodedFrame(byteBufferDuplicate, true);
    }

    @Override // org.jcodec.common.VideoEncoder
    public int estimateBufferSize(Picture picture) {
        int width = picture.getWidth() * picture.getCroppedHeight();
        ColorSpace color = picture.getColor();
        int i = 0;
        for (int i2 = 0; i2 < color.nComp; i2++) {
            i += (width >> color.compWidth[i2]) >> color.compHeight[i2];
        }
        return i;
    }

    @Override // org.jcodec.common.VideoEncoder
    public ColorSpace[] getSupportedColorSpaces() {
        return null;
    }
}
