package com.umeng.analytics.pro;

/* compiled from: TMemoryInputTransport.java */
/* loaded from: classes2.dex */
public final class ch extends ci {
    private byte[] a;
    private int b;
    private int c;

    public ch() {
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.ci
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.ci
    public void b() throws cj {
    }

    @Override // com.umeng.analytics.pro.ci
    public void b(byte[] bArr, int i, int i2) throws cj {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.ci
    public void c() {
    }

    public void c(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i + i2;
    }

    public void e() {
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.ci
    public byte[] f() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.ci
    public int g() {
        return this.b;
    }

    @Override // com.umeng.analytics.pro.ci
    public int h() {
        return this.c - this.b;
    }

    public ch(byte[] bArr) {
        a(bArr);
    }

    @Override // com.umeng.analytics.pro.ci
    public int a(byte[] bArr, int i, int i2) throws cj {
        int iH = h();
        if (i2 > iH) {
            i2 = iH;
        }
        if (i2 > 0) {
            System.arraycopy(this.a, this.b, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    public ch(byte[] bArr, int i, int i2) {
        c(bArr, i, i2);
    }

    @Override // com.umeng.analytics.pro.ci
    public void a(int i) {
        this.b += i;
    }
}
