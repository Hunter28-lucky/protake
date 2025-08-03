package org.jcodec.containers.mkv.boxes;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class EbmlFloat extends EbmlBin {
    public EbmlFloat(byte[] bArr) {
        super(bArr);
    }

    public double getDouble() {
        return this.data.limit() == 4 ? this.data.duplicate().getFloat() : this.data.duplicate().getDouble();
    }

    public void setDouble(double d) {
        if (d < 3.4028234663852886E38d) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.putFloat((float) d);
            byteBufferAllocate.flip();
            this.data = byteBufferAllocate;
            return;
        }
        if (d < Double.MAX_VALUE) {
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(8);
            byteBufferAllocate2.putDouble(d);
            byteBufferAllocate2.flip();
            this.data = byteBufferAllocate2;
        }
    }
}
