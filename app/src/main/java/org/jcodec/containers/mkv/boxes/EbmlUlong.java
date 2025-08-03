package org.jcodec.containers.mkv.boxes;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class EbmlUlong extends EbmlBin {
    public EbmlUlong(byte[] bArr) {
        super(bArr);
        this.data = ByteBuffer.allocate(8);
    }

    public static EbmlUlong createEbmlUlong(byte[] bArr, long j) {
        EbmlUlong ebmlUlong = new EbmlUlong(bArr);
        ebmlUlong.setUlong(j);
        return ebmlUlong;
    }

    public long getUlong() {
        return this.data.duplicate().getLong();
    }

    public void setUlong(long j) {
        this.data.putLong(j);
        this.data.flip();
    }
}
