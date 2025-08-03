package defpackage;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkEnforcingInputStream.java */
/* renamed from: ଅ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4381 extends FilterInputStream {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f15064;

    public C4381(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f15064 = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.f15064;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.f15064 = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (m13554(1L) == -1) {
            return -1;
        }
        int i = super.read();
        m13555(1L);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f15064 = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jM13554 = m13554(j);
        if (jM13554 == -1) {
            return 0L;
        }
        long jSkip = super.skip(jM13554);
        m13555(jSkip);
        return jSkip;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final long m13554(long j) {
        int i = this.f15064;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m13555(long j) {
        int i = this.f15064;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f15064 = (int) (i - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int iM13554 = (int) m13554(i2);
        if (iM13554 == -1) {
            return -1;
        }
        int i3 = super.read(bArr, i, iM13554);
        m13555(i3);
        return i3;
    }
}
