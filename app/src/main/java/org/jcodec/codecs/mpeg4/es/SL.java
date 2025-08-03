package org.jcodec.codecs.mpeg4.es;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class SL extends Descriptor {
    public SL() {
        super(tag(), 0);
    }

    public static int tag() {
        return 6;
    }

    @Override // org.jcodec.codecs.mpeg4.es.Descriptor
    public void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) 2);
    }
}
