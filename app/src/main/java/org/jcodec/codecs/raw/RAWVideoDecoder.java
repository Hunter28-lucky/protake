package org.jcodec.codecs.raw;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Size;

/* loaded from: classes2.dex */
public class RAWVideoDecoder extends VideoDecoder {
    private int height;
    private int width;

    public RAWVideoDecoder(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public void copy(ByteBuffer byteBuffer, byte[] bArr, int i) {
        for (int i2 = 0; byteBuffer.hasRemaining() && i2 < i; i2++) {
            bArr[i2] = (byte) ((byteBuffer.get() & ExifInterface.MARKER) - 128);
        }
    }

    @Override // org.jcodec.common.VideoDecoder
    public Picture decodeFrame(ByteBuffer byteBuffer, byte[][] bArr) {
        Picture pictureCreatePicture = Picture.createPicture(this.width, this.height, bArr, ColorSpace.YUV420);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        copy(byteBufferDuplicate, pictureCreatePicture.getPlaneData(0), this.width * this.height);
        copy(byteBufferDuplicate, pictureCreatePicture.getPlaneData(1), (this.width * this.height) / 4);
        copy(byteBufferDuplicate, pictureCreatePicture.getPlaneData(2), (this.width * this.height) / 4);
        return pictureCreatePicture;
    }

    @Override // org.jcodec.common.VideoDecoder
    public VideoCodecMeta getCodecMeta(ByteBuffer byteBuffer) {
        return VideoCodecMeta.createSimpleVideoCodecMeta(new Size(this.width, this.height), ColorSpace.YUV420);
    }
}
