package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public final class c {
    private final int a;

    /* renamed from: a, reason: collision with other field name */
    private final OutputStream f5649a;

    /* renamed from: a, reason: collision with other field name */
    private final byte[] f5650a;
    private int b;

    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(byte[] bArr, int i, int i2) {
        this.f5649a = null;
        this.f5650a = bArr;
        this.b = i;
        this.a = i + i2;
    }

    public static int a(boolean z) {
        return 1;
    }

    public static c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static int c(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private void c() throws IOException {
        OutputStream outputStream = this.f5649a;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f5650a, 0, this.b);
        this.b = 0;
    }

    public static int d(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m5277b(int i, long j) throws IOException {
        c(i, 0);
        m5278b(j);
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m5281d(int i) throws IOException {
        while ((i & (-128)) != 0) {
            m5279c((i & 127) | 128);
            i >>>= 7;
        }
        m5279c(i);
    }

    public static c a(OutputStream outputStream, int i) {
        return new c(outputStream, new byte[i]);
    }

    public static c a(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m5276b(int i, int i2) throws IOException {
        c(i, 0);
        m5275b(i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5264a(int i, long j) throws IOException {
        c(i, 0);
        m5269a(j);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m5278b(long j) throws IOException {
        m5280c(j);
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m5279c(int i) throws IOException {
        a((byte) i);
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f5649a = outputStream;
        this.f5650a = bArr;
        this.b = 0;
        this.a = bArr.length;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5263a(int i, int i2) throws IOException {
        c(i, 0);
        m5262a(i2);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m5275b(int i) throws IOException {
        m5281d(i);
    }

    public void c(int i, int i2) throws IOException {
        m5281d(f.a(i, i2));
    }

    public static int b(int i, long j) {
        return c(i) + b(j);
    }

    public static int c(int i) {
        return d(f.a(i, 0));
    }

    public static int b(int i, int i2) {
        return c(i) + b(i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5268a(int i, boolean z) throws IOException {
        c(i, 0);
        m5273a(z);
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m5280c(long j) throws IOException {
        while (((-128) & j) != 0) {
            m5279c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m5279c((int) j);
    }

    public static int b(long j) {
        return c(j);
    }

    public static int b(int i) {
        return d(i);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5267a(int i, String str) throws IOException {
        c(i, 2);
        m5272a(str);
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5266a(int i, e eVar) throws IOException {
        c(i, 2);
        m5271a(eVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5265a(int i, com.xiaomi.push.a aVar) throws IOException {
        c(i, 2);
        m5270a(aVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5269a(long j) throws IOException {
        m5280c(j);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5262a(int i) throws IOException {
        if (i >= 0) {
            m5281d(i);
        } else {
            m5280c(i);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5273a(boolean z) throws IOException {
        m5279c(z ? 1 : 0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5272a(String str) throws IOException {
        byte[] bytes = str.getBytes(Platform.UTF_8);
        m5281d(bytes.length);
        a(bytes);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5271a(e eVar) throws IOException {
        m5281d(eVar.a());
        eVar.a(this);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5270a(com.xiaomi.push.a aVar) throws IOException {
        byte[] bArrM5192a = aVar.m5192a();
        m5281d(bArrM5192a.length);
        a(bArrM5192a);
    }

    public static int a(int i, long j) {
        return c(i) + a(j);
    }

    public static int a(int i, int i2) {
        return c(i) + a(i2);
    }

    public static int a(int i, boolean z) {
        return c(i) + a(z);
    }

    public static int a(int i, String str) {
        return c(i) + a(str);
    }

    public static int a(int i, e eVar) {
        return c(i) + a(eVar);
    }

    public static int a(int i, com.xiaomi.push.a aVar) {
        return c(i) + a(aVar);
    }

    public static int a(long j) {
        return c(j);
    }

    public static int a(int i) {
        if (i >= 0) {
            return d(i);
        }
        return 10;
    }

    public static int a(String str) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes(Platform.UTF_8);
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(e eVar) {
        int iB = eVar.b();
        return d(iB) + iB;
    }

    public static int a(com.xiaomi.push.a aVar) {
        return d(aVar.a()) + aVar.a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5261a() throws IOException {
        if (this.f5649a != null) {
            c();
        }
    }

    public int a() {
        if (this.f5649a == null) {
            return this.a - this.b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void a(byte b) throws IOException {
        if (this.b == this.a) {
            c();
        }
        byte[] bArr = this.f5650a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
    }

    public void a(byte[] bArr) throws IOException {
        m5274a(bArr, 0, bArr.length);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5274a(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.a;
        int i4 = this.b;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f5650a, i4, i2);
            this.b += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f5650a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.b = this.a;
        c();
        if (i7 <= this.a) {
            System.arraycopy(bArr, i6, this.f5650a, 0, i7);
            this.b = i7;
        } else {
            this.f5649a.write(bArr, i6, i7);
        }
    }
}
