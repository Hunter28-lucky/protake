package org.jcodec.codecs.h264.io.write;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.common.io.NIOUtils;

/* loaded from: classes2.dex */
public class NALUnitWriter {
    private static ByteBuffer _MARKER;
    private final WritableByteChannel to;

    static {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        _MARKER = byteBufferAllocate;
        byteBufferAllocate.putInt(1);
        _MARKER.flip();
    }

    public NALUnitWriter(WritableByteChannel writableByteChannel) {
        this.to = writableByteChannel;
    }

    private void emprev(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
        byte b = 1;
        byte b2 = 1;
        while (byteBufferDuplicate.hasRemaining()) {
            byte b3 = byteBufferDuplicate.get();
            if (b == 0 && b2 == 0 && (b3 & 3) == b3) {
                byteBuffer.put((byte) 3);
                b2 = 3;
            } else {
                b2 = b;
            }
            byteBuffer.put(b3);
            b = b3;
        }
    }

    public void writeUnit(NALUnit nALUnit, ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining() + 1024);
        NIOUtils.write(byteBufferAllocate, _MARKER);
        nALUnit.write(byteBufferAllocate);
        emprev(byteBufferAllocate, byteBuffer);
        byteBufferAllocate.flip();
        this.to.write(byteBufferAllocate);
    }
}
