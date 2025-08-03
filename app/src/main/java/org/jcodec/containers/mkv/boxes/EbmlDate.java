package org.jcodec.containers.mkv.boxes;

import java.nio.ByteBuffer;
import java.util.Date;

/* loaded from: classes2.dex */
public class EbmlDate extends EbmlSint {
    private static final int MILISECONDS_IN_A_SECOND = 1000;
    public static long MILISECONDS_SINCE_UNIX_EPOCH_START = 978307200;
    private static final int NANOSECONDS_IN_A_MILISECOND = 1000000;
    private static final int NANOSECONDS_IN_A_SECOND = 1000000000;

    public EbmlDate(byte[] bArr) {
        super(bArr);
    }

    private void setMiliseconds(long j) {
        setLong((j - MILISECONDS_SINCE_UNIX_EPOCH_START) * 1000000);
    }

    public Date getDate() {
        return new Date((getLong() / 1000000) + MILISECONDS_SINCE_UNIX_EPOCH_START);
    }

    public void setDate(Date date) {
        setMiliseconds(date.getTime());
    }

    @Override // org.jcodec.containers.mkv.boxes.EbmlSint
    public void setLong(long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        this.data = byteBufferAllocate;
        byteBufferAllocate.putLong(j);
        this.data.flip();
    }
}
