package defpackage;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream.java */
/* renamed from: ݫ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3754 extends FilterInputStream {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final long f12976;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f12977;

    public C3754(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.f12976 = j;
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static InputStream m12029(@NonNull InputStream inputStream, long j) {
        return new C3754(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f12976 - this.f12977, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i;
        i = super.read();
        m12030(i >= 0 ? 1 : -1);
        return i;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int m12030(int i) throws IOException {
        if (i >= 0) {
            this.f12977 += i;
        } else if (this.f12976 - this.f12977 > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f12976 + ", but read: " + this.f12977);
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return m12030(super.read(bArr, i, i2));
    }
}
