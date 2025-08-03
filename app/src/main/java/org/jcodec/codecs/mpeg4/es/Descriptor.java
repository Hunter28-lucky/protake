package org.jcodec.codecs.mpeg4.es;

import java.nio.ByteBuffer;
import org.jcodec.common.JCodecUtil2;
import org.jcodec.common.io.NIOUtils;

/* loaded from: classes2.dex */
public abstract class Descriptor {
    private int _tag;
    private int size;

    public Descriptor(int i, int i2) {
        this._tag = i;
        this.size = i2;
    }

    public abstract void doWrite(ByteBuffer byteBuffer);

    public int getTag() {
        return this._tag;
    }

    public void write(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        NIOUtils.skip(byteBuffer, 5);
        doWrite(byteBuffer);
        int iPosition = (byteBuffer.position() - byteBufferDuplicate.position()) - 5;
        byteBufferDuplicate.put((byte) this._tag);
        JCodecUtil2.writeBER32(byteBufferDuplicate, iPosition);
    }
}
