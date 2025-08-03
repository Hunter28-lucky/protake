package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

@Deprecated
/* loaded from: classes2.dex */
public class BufferedByteArrayOutputStream extends ByteArrayOutputStream implements PublicMemberKeeper {
    public BufferedByteArrayOutputStream() {
    }

    public byte[] getBuffer() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public int getBufferSize() {
        return ((ByteArrayOutputStream) this).buf.length;
    }

    public boolean switchBuffer(byte[] bArr) {
        if (bArr == null || bArr.length != ((ByteArrayOutputStream) this).buf.length) {
            return false;
        }
        ((ByteArrayOutputStream) this).buf = bArr;
        return true;
    }

    public void write(ByteBuffer byteBuffer) throws IOException {
        write(byteBuffer, byteBuffer.limit());
    }

    public BufferedByteArrayOutputStream(int i) {
        super(i);
    }

    public void write(ByteBuffer byteBuffer, int i) throws IOException {
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        int length = bArr.length;
        int i2 = ((ByteArrayOutputStream) this).count;
        if (length - i2 >= i) {
            byteBuffer.get(bArr, i2, i);
            ((ByteArrayOutputStream) this).count += i;
        } else {
            byte[] bArr2 = new byte[i];
            byteBuffer.get(bArr2);
            write(bArr2);
        }
    }
}
