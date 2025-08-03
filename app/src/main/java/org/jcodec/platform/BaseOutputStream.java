package org.jcodec.platform;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public abstract class BaseOutputStream extends OutputStream {
    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        writeByte(i);
    }

    public abstract void writeByte(int i) throws IOException;
}
