package org.jcodec.containers.mkv.boxes;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mkv.util.EbmlUtil;

/* loaded from: classes2.dex */
public class EbmlBin extends EbmlBase {
    public ByteBuffer data;
    public boolean dataRead;

    public EbmlBin(byte[] bArr) {
        super(bArr);
        this.dataRead = false;
    }

    @Override // org.jcodec.containers.mkv.boxes.EbmlBase
    public ByteBuffer getData() {
        int iEbmlLength = EbmlUtil.ebmlLength(this.data.limit());
        byte[] bArrEbmlEncodeLen = EbmlUtil.ebmlEncodeLen(this.data.limit(), iEbmlLength);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.id.length + iEbmlLength + this.data.limit());
        byteBufferAllocate.put(this.id);
        byteBufferAllocate.put(bArrEbmlEncodeLen);
        byteBufferAllocate.put(this.data);
        byteBufferAllocate.flip();
        this.data.flip();
        return byteBufferAllocate;
    }

    public void read(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        this.data = byteBufferSlice;
        byteBufferSlice.limit(this.dataLen);
        this.dataRead = true;
    }

    public void readChannel(SeekableByteChannel seekableByteChannel) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.dataLen);
        seekableByteChannel.read(byteBufferAllocate);
        byteBufferAllocate.flip();
        read(byteBufferAllocate);
    }

    public void setBuf(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        this.data = byteBufferSlice;
        this.dataLen = byteBufferSlice.limit();
    }

    @Override // org.jcodec.containers.mkv.boxes.EbmlBase
    public long size() {
        ByteBuffer byteBuffer = this.data;
        return (byteBuffer == null || byteBuffer.limit() == 0) ? super.size() : this.data.limit() + EbmlUtil.ebmlLength(this.data.limit()) + this.id.length;
    }

    public void skip(ByteBuffer byteBuffer) {
        if (this.dataRead) {
            return;
        }
        byteBuffer.position((int) (this.dataOffset + this.dataLen));
        this.dataRead = true;
    }
}
