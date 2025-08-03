package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: TIOStreamTransport.java */
/* loaded from: classes2.dex */
public class cg extends ci {
    public InputStream a;
    public OutputStream b;

    public cg() {
        this.a = null;
        this.b = null;
    }

    @Override // com.umeng.analytics.pro.ci
    public int a(byte[] bArr, int i, int i2) throws cj, IOException {
        InputStream inputStream = this.a;
        if (inputStream == null) {
            throw new cj(1, "Cannot read from null inputStream");
        }
        try {
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 >= 0) {
                return i3;
            }
            throw new cj(4);
        } catch (IOException e2) {
            throw new cj(0, e2);
        }
    }

    @Override // com.umeng.analytics.pro.ci
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.ci
    public void b() throws cj {
    }

    @Override // com.umeng.analytics.pro.ci
    public void b(byte[] bArr, int i, int i2) throws cj, IOException {
        OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new cj(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (IOException e2) {
            throw new cj(0, e2);
        }
    }

    @Override // com.umeng.analytics.pro.ci
    public void c() throws IOException {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.a = null;
        }
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.b = null;
        }
    }

    @Override // com.umeng.analytics.pro.ci
    public void d() throws cj, IOException {
        OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new cj(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (IOException e2) {
            throw new cj(0, e2);
        }
    }

    public cg(InputStream inputStream) {
        this.b = null;
        this.a = inputStream;
    }

    public cg(OutputStream outputStream) {
        this.a = null;
        this.b = outputStream;
    }

    public cg(InputStream inputStream, OutputStream outputStream) {
        this.a = inputStream;
        this.b = outputStream;
    }
}
