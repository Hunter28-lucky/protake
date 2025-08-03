package org.jcodec.codecs.raw;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class V210Decoder {
    private int height;
    private int width;

    public V210Decoder(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    private byte to8Bit(int i) {
        return (byte) (((i + 2) >> 2) - 128);
    }

    public Picture decode(byte[] bArr) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[this.width * this.height]);
        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(new byte[(this.width * this.height) / 2]);
        ByteBuffer byteBufferWrap3 = ByteBuffer.wrap(new byte[(this.width * this.height) / 2]);
        while (intBufferAsIntBuffer.hasRemaining()) {
            int i = intBufferAsIntBuffer.get();
            byteBufferWrap3.put(to8Bit(i >> 20));
            byteBufferWrap.put(to8Bit((i >> 10) & 1023));
            byteBufferWrap2.put(to8Bit(i & 1023));
            int i2 = intBufferAsIntBuffer.get();
            byteBufferWrap.put(to8Bit(i2 & 1023));
            byteBufferWrap.put(to8Bit(i2 >> 20));
            byteBufferWrap2.put(to8Bit((i2 >> 10) & 1023));
            int i3 = intBufferAsIntBuffer.get();
            byteBufferWrap2.put(to8Bit(i3 >> 20));
            byteBufferWrap.put(to8Bit((i3 >> 10) & 1023));
            byteBufferWrap3.put(to8Bit(i3 & 1023));
            int i4 = intBufferAsIntBuffer.get();
            byteBufferWrap.put(to8Bit(i4 & 1023));
            byteBufferWrap.put(to8Bit(i4 >> 20));
            byteBufferWrap3.put(to8Bit((i4 >> 10) & 1023));
        }
        return Picture.createPicture(this.width, this.height, new byte[][]{byteBufferWrap.array(), byteBufferWrap2.array(), byteBufferWrap3.array()}, ColorSpace.YUV422);
    }
}
