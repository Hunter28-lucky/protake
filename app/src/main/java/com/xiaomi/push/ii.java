package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class ii extends il {
    public InputStream a;

    /* renamed from: a, reason: collision with other field name */
    public OutputStream f6310a;

    public ii() {
        this.a = null;
        this.f6310a = null;
    }

    @Override // com.xiaomi.push.il
    public int a(byte[] bArr, int i, int i2) throws IOException, im {
        InputStream inputStream = this.a;
        if (inputStream == null) {
            throw new im(1, "Cannot read from null inputStream");
        }
        try {
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 >= 0) {
                return i3;
            }
            throw new im(4);
        } catch (IOException e2) {
            throw new im(0, e2);
        }
    }

    public ii(OutputStream outputStream) {
        this.a = null;
        this.f6310a = outputStream;
    }

    @Override // com.xiaomi.push.il
    /* renamed from: a, reason: collision with other method in class */
    public void mo5685a(byte[] bArr, int i, int i2) throws IOException, im {
        OutputStream outputStream = this.f6310a;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
                return;
            } catch (IOException e2) {
                throw new im(0, e2);
            }
        }
        throw new im(1, "Cannot write to null outputStream");
    }
}
