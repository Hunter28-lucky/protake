package org.jcodec.codecs.png;

import java.nio.ByteBuffer;
import org.jcodec.common.model.ColorSpace;

/* loaded from: classes2.dex */
class IHDR {
    public byte bitDepth;
    public byte colorType;
    private byte compressionType;
    private byte filterType;
    public int height;
    public byte interlaceType;
    public int width;

    private int getNBChannels() {
        byte b = this.colorType;
        int i = (b & 3) == 2 ? 3 : 1;
        return (b & 4) != 0 ? i + 1 : i;
    }

    public ColorSpace colorSpace() {
        return ColorSpace.RGB;
    }

    public int getBitsPerPixel() {
        return this.bitDepth * getNBChannels();
    }

    public void parse(ByteBuffer byteBuffer) {
        this.width = byteBuffer.getInt();
        this.height = byteBuffer.getInt();
        this.bitDepth = byteBuffer.get();
        this.colorType = byteBuffer.get();
        this.compressionType = byteBuffer.get();
        this.filterType = byteBuffer.get();
        this.interlaceType = byteBuffer.get();
        byteBuffer.getInt();
    }

    public int rowSize() {
        return ((this.width * getBitsPerPixel()) + 7) >> 3;
    }

    public void write(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.width);
        byteBuffer.putInt(this.height);
        byteBuffer.put(this.bitDepth);
        byteBuffer.put(this.colorType);
        byteBuffer.put(this.compressionType);
        byteBuffer.put(this.filterType);
        byteBuffer.put(this.interlaceType);
    }
}
