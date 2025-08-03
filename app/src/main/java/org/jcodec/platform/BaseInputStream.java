package org.jcodec.platform;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class BaseInputStream extends InputStream {
    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return readBuffer(bArr, 0, bArr.length);
    }

    public abstract int readBuffer(byte[] bArr, int i, int i2) throws IOException;

    public abstract int readByte() throws IOException;

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return readBuffer(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return readByte();
    }
}
