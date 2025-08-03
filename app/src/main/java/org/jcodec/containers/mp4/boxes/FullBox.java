package org.jcodec.containers.mp4.boxes;

import androidx.core.view.ViewCompat;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class FullBox extends Box {
    public int flags;
    public byte version;

    public FullBox(Header header) {
        super(header);
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.version << 24) | (this.flags & ViewCompat.MEASURED_SIZE_MASK));
    }

    public int getFlags() {
        return this.flags;
    }

    public byte getVersion() {
        return this.version;
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public void parse(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        this.version = (byte) ((i >> 24) & 255);
        this.flags = i & ViewCompat.MEASURED_SIZE_MASK;
    }

    public void setFlags(int i) {
        this.flags = i;
    }

    public void setVersion(byte b) {
        this.version = b;
    }
}
