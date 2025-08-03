package com.xiaomi.push;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class e {
    public abstract int a();

    public abstract e a(b bVar);

    public abstract void a(c cVar);

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m5437a() {
        int iB = b();
        byte[] bArr = new byte[iB];
        m5436a(bArr, 0, iB);
        return bArr;
    }

    public abstract int b();

    /* renamed from: a, reason: collision with other method in class */
    public void m5436a(byte[] bArr, int i, int i2) {
        try {
            c cVarA = c.a(bArr, i, i2);
            a(cVarA);
            cVarA.b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public e a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public e a(byte[] bArr, int i, int i2) throws d {
        try {
            b bVarA = b.a(bArr, i, i2);
            a(bVarA);
            bVarA.m5232a(0);
            return this;
        } catch (d e2) {
            throw e2;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public boolean a(b bVar, int i) {
        return bVar.m5234a(i);
    }
}
