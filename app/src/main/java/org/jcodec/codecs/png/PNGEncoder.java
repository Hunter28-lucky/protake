package org.jcodec.codecs.png;

import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.jcodec.common.VideoEncoder;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public class PNGEncoder extends VideoEncoder {
    private static int crc32(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byteBuffer.limit(byteBuffer2.position());
        CRC32 crc32 = new CRC32();
        crc32.update(NIOUtils.toArray(byteBuffer));
        return (int) crc32.getValue();
    }

    @Override // org.jcodec.common.VideoEncoder
    public VideoEncoder.EncodedFrame encodeFrame(Picture picture, ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.putInt(PNGConsts.PNGSIGhi);
        byteBufferDuplicate.putInt(218765834);
        IHDR ihdr = new IHDR();
        ihdr.width = picture.getCroppedWidth();
        ihdr.height = picture.getCroppedHeight();
        ihdr.bitDepth = (byte) 8;
        ihdr.colorType = (byte) 2;
        byteBufferDuplicate.putInt(13);
        ByteBuffer byteBufferDuplicate2 = byteBufferDuplicate.duplicate();
        byteBufferDuplicate.putInt(PNGConsts.TAG_IHDR);
        ihdr.write(byteBufferDuplicate);
        byteBufferDuplicate.putInt(crc32(byteBufferDuplicate2, byteBufferDuplicate));
        Deflater deflater = new Deflater();
        byte[] bArr = new byte[(picture.getCroppedWidth() * 3) + 1];
        byte[] planeData = picture.getPlaneData(0);
        int i = 32768;
        byte[] bArr2 = new byte[32768];
        int width = (picture.getWidth() - picture.getCroppedWidth()) * 3;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 32768;
        while (i2 < picture.getCroppedHeight() + 1) {
            while (true) {
                int iDeflate = deflater.deflate(bArr2, i3, i5);
                if (iDeflate <= 0) {
                    break;
                }
                i3 += iDeflate;
                i5 -= iDeflate;
                if (i5 == 0) {
                    byteBufferDuplicate.putInt(i3);
                    ByteBuffer byteBufferDuplicate3 = byteBufferDuplicate.duplicate();
                    byteBufferDuplicate.putInt(PNGConsts.TAG_IDAT);
                    byteBufferDuplicate.put(bArr2, 0, i3);
                    byteBufferDuplicate.putInt(crc32(byteBufferDuplicate3, byteBufferDuplicate));
                    i3 = 0;
                    i5 = i;
                }
            }
            if (i2 >= picture.getCroppedHeight()) {
                break;
            }
            bArr[0] = 0;
            int i6 = 1;
            while (i6 <= picture.getCroppedWidth() * 3) {
                bArr[i6] = (byte) (planeData[i4] + BER.ASN_LONG_LEN);
                bArr[i6 + 1] = (byte) (planeData[i4 + 1] + BER.ASN_LONG_LEN);
                bArr[i6 + 2] = (byte) (planeData[i4 + 2] + BER.ASN_LONG_LEN);
                i6 += 3;
                i4 += 3;
            }
            i4 += width;
            deflater.setInput(bArr);
            if (i2 >= picture.getCroppedHeight() - 1) {
                deflater.finish();
            }
            i2++;
            i = 32768;
        }
        if (i3 > 0) {
            byteBufferDuplicate.putInt(i3);
            ByteBuffer byteBufferDuplicate4 = byteBufferDuplicate.duplicate();
            byteBufferDuplicate.putInt(PNGConsts.TAG_IDAT);
            byteBufferDuplicate.put(bArr2, 0, i3);
            byteBufferDuplicate.putInt(crc32(byteBufferDuplicate4, byteBufferDuplicate));
        }
        byteBufferDuplicate.putInt(0);
        byteBufferDuplicate.putInt(PNGConsts.TAG_IEND);
        byteBufferDuplicate.putInt(-1371381630);
        byteBufferDuplicate.flip();
        return new VideoEncoder.EncodedFrame(byteBufferDuplicate, true);
    }

    @Override // org.jcodec.common.VideoEncoder
    public int estimateBufferSize(Picture picture) {
        return picture.getCroppedWidth() * picture.getCroppedHeight() * 4;
    }

    @Override // org.jcodec.common.VideoEncoder
    public ColorSpace[] getSupportedColorSpaces() {
        return new ColorSpace[]{ColorSpace.RGB};
    }
}
