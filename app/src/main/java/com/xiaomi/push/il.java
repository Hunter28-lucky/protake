package com.xiaomi.push;

/* loaded from: classes2.dex */
public abstract class il {
    public abstract int a(byte[] bArr, int i, int i2);

    public void a(int i) {
    }

    /* renamed from: a */
    public abstract void mo5685a(byte[] bArr, int i, int i2);

    public byte[] a() {
        return null;
    }

    public int a_() {
        return 0;
    }

    public int b() {
        return -1;
    }

    public int b(byte[] bArr, int i, int i2) throws im {
        int i3 = 0;
        while (i3 < i2) {
            int iA = a(bArr, i + i3, i2 - i3);
            if (iA <= 0) {
                throw new im("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes.");
            }
            i3 += iA;
        }
        return i3;
    }
}
