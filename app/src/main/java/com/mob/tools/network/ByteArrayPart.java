package com.mob.tools.network;

import com.mob.tools.utils.Data;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Deprecated
/* loaded from: classes2.dex */
public class ByteArrayPart extends HTTPPart {
    private BufferedByteArrayOutputStream a;

    @Override // com.mob.tools.network.HTTPPart
    public InputStream a() throws Throwable {
        BufferedByteArrayOutputStream bufferedByteArrayOutputStream = this.a;
        if (bufferedByteArrayOutputStream == null) {
            return new ByteArrayInputStream(new byte[0]);
        }
        byte[] buffer = bufferedByteArrayOutputStream.getBuffer();
        return (buffer == null || this.a.size() <= 0) ? new ByteArrayInputStream(new byte[0]) : new ByteArrayInputStream(buffer, 0, this.a.size());
    }

    public ByteArrayPart append(byte[] bArr) throws Throwable {
        if (this.a == null) {
            this.a = new BufferedByteArrayOutputStream(bArr.length);
        }
        this.a.write(bArr);
        this.a.flush();
        return this;
    }

    @Override // com.mob.tools.network.HTTPPart
    public long b() throws Throwable {
        if (this.a == null) {
            return 0L;
        }
        return r0.size();
    }

    public String toString() {
        byte[] buffer;
        BufferedByteArrayOutputStream bufferedByteArrayOutputStream = this.a;
        if (bufferedByteArrayOutputStream == null || (buffer = bufferedByteArrayOutputStream.getBuffer()) == null) {
            return null;
        }
        return Data.byteToHex(buffer, 0, this.a.size());
    }
}
