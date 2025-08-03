package org.jcodec.containers.mxf.model;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.io.SeekableByteChannel;

/* loaded from: classes2.dex */
public class KLV {
    public final long dataOffset;
    public final UL key;
    public final long len;
    public final long offset;
    public ByteBuffer value;

    public KLV(UL ul, long j, long j2, long j3) {
        this.key = ul;
        this.len = j;
        this.offset = j2;
        this.dataOffset = j3;
    }

    public static boolean matches(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static KLV readKL(SeekableByteChannel seekableByteChannel) throws IOException {
        long jPosition = seekableByteChannel.position();
        if (jPosition >= seekableByteChannel.size() - 1) {
            return null;
        }
        byte[] bArr = new byte[16];
        seekableByteChannel.read(ByteBuffer.wrap(bArr));
        return new KLV(new UL(bArr), BER.decodeLength(seekableByteChannel), jPosition, seekableByteChannel.position());
    }

    public static KLV readKLFromBuffer(ByteBuffer byteBuffer, long j) {
        if (byteBuffer.remaining() < 17) {
            return null;
        }
        return new KLV(UL.read(byteBuffer), BER.decodeLengthBuf(byteBuffer), j + byteBuffer.position(), j + byteBuffer.position());
    }

    public int getLenByteCount() {
        int i = (int) ((this.dataOffset - this.offset) - 16);
        if (i <= 0) {
            return 4;
        }
        return i;
    }

    public String toString() {
        return "KLV [offset=" + this.offset + ", dataOffset=" + this.dataOffset + ", key=" + this.key + ", len=" + this.len + ", value=" + this.value + "]";
    }
}
