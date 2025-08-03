package org.jcodec.containers.mkv.boxes;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class EbmlUint extends EbmlBin {
    public EbmlUint(byte[] bArr) {
        super(bArr);
    }

    public static int calculatePayloadSize(long j) {
        if (j == 0) {
            return 1;
        }
        return j <= 2147483647L ? 4 - (Integer.numberOfLeadingZeros((int) j) >> 3) : 8 - (Long.numberOfLeadingZeros(j) >> 3);
    }

    public static EbmlUint createEbmlUint(byte[] bArr, long j) {
        EbmlUint ebmlUint = new EbmlUint(bArr);
        ebmlUint.setUint(j);
        return ebmlUint;
    }

    public static byte[] longToBytes(long j) {
        int iCalculatePayloadSize = calculatePayloadSize(j);
        byte[] bArr = new byte[iCalculatePayloadSize];
        for (int i = iCalculatePayloadSize - 1; i >= 0; i--) {
            bArr[i] = (byte) (j >>> (((iCalculatePayloadSize - i) - 1) * 8));
        }
        return bArr;
    }

    public long getUint() {
        long j = 0;
        for (int i = 0; i < this.data.limit(); i++) {
            ByteBuffer byteBuffer = this.data;
            j |= (byteBuffer.get((byteBuffer.limit() - 1) - i) << 56) >>> (56 - (i * 8));
        }
        return j;
    }

    public void setUint(long j) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(longToBytes(j));
        this.data = byteBufferWrap;
        this.dataLen = byteBufferWrap.limit();
    }
}
