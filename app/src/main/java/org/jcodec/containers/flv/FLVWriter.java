package org.jcodec.containers.flv;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.flv.FLVTag;

/* loaded from: classes2.dex */
public class FLVWriter {
    private static final int WRITE_BUFFER_SIZE = 1048576;
    private SeekableByteChannel out;
    private int startOfLastPacket = 9;
    private ByteBuffer writeBuf;

    public FLVWriter(SeekableByteChannel seekableByteChannel) {
        this.out = seekableByteChannel;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1048576);
        this.writeBuf = byteBufferAllocate;
        writeHeader(byteBufferAllocate);
    }

    private static void writeHeader(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) 70);
        byteBuffer.put((byte) 76);
        byteBuffer.put((byte) 86);
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 5);
        byteBuffer.putInt(9);
    }

    private boolean writePacket(ByteBuffer byteBuffer, FLVTag fLVTag) {
        int i = fLVTag.getType() == FLVTag.Type.VIDEO ? 9 : fLVTag.getType() == FLVTag.Type.SCRIPT ? 18 : 8;
        int iRemaining = fLVTag.getData().remaining();
        if (byteBuffer.remaining() < iRemaining + 15) {
            return false;
        }
        byteBuffer.putInt(byteBuffer.position() - this.startOfLastPacket);
        this.startOfLastPacket = byteBuffer.position();
        byteBuffer.put((byte) i);
        byteBuffer.putShort((short) (iRemaining >> 8));
        byteBuffer.put((byte) (iRemaining & 255));
        byteBuffer.putShort((short) ((fLVTag.getPts() >> 8) & 65535));
        byteBuffer.put((byte) (fLVTag.getPts() & 255));
        byteBuffer.put((byte) ((fLVTag.getPts() >> 24) & 255));
        byteBuffer.putShort((short) 0);
        byteBuffer.put((byte) 0);
        NIOUtils.write(byteBuffer, fLVTag.getData().duplicate());
        return true;
    }

    public void addPacket(FLVTag fLVTag) throws IOException {
        if (writePacket(this.writeBuf, fLVTag)) {
            return;
        }
        this.writeBuf.flip();
        this.startOfLastPacket -= this.out.write(this.writeBuf);
        this.writeBuf.clear();
        if (!writePacket(this.writeBuf, fLVTag)) {
            throw new RuntimeException("Unexpected");
        }
    }

    public void finish() throws IOException {
        this.writeBuf.flip();
        this.out.write(this.writeBuf);
    }
}
