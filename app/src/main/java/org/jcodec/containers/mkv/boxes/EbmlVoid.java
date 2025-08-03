package org.jcodec.containers.mkv.boxes;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.io.SeekableByteChannel;

/* loaded from: classes2.dex */
public class EbmlVoid extends EbmlBase {
    public EbmlVoid(byte[] bArr) {
        super(bArr);
    }

    @Override // org.jcodec.containers.mkv.boxes.EbmlBase
    public ByteBuffer getData() {
        return null;
    }

    public void skip(SeekableByteChannel seekableByteChannel) throws IOException {
        seekableByteChannel.setPosition(this.dataOffset + this.dataLen);
    }
}
