package com.xiaomi.push;

/* loaded from: classes2.dex */
public final class ik extends il {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f6312a;
    private int b;

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.il
    public int a_() {
        return this.a;
    }

    public void b(byte[] bArr, int i, int i2) {
        this.f6312a = bArr;
        this.a = i;
        this.b = i + i2;
    }

    @Override // com.xiaomi.push.il
    public int a(byte[] bArr, int i, int i2) {
        int iB = b();
        if (i2 > iB) {
            i2 = iB;
        }
        if (i2 > 0) {
            System.arraycopy(this.f6312a, this.a, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.il
    public int b() {
        return this.b - this.a;
    }

    @Override // com.xiaomi.push.il
    /* renamed from: a */
    public void mo5685a(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.il
    public byte[] a() {
        return this.f6312a;
    }

    @Override // com.xiaomi.push.il
    public void a(int i) {
        this.a += i;
    }
}
