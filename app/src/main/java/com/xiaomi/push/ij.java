package com.xiaomi.push;

import java.io.IOException;

/* loaded from: classes2.dex */
public class ij extends il {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private ht f6311a;

    public ij(int i) {
        this.f6311a = new ht(i);
    }

    @Override // com.xiaomi.push.il
    public int a(byte[] bArr, int i, int i2) {
        byte[] bArrM5663a = this.f6311a.m5663a();
        if (i2 > this.f6311a.a() - this.a) {
            i2 = this.f6311a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(bArrM5663a, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.il
    /* renamed from: a */
    public void mo5685a(byte[] bArr, int i, int i2) throws IOException {
        this.f6311a.write(bArr, i, i2);
    }

    public int a() {
        return this.f6311a.size();
    }
}
