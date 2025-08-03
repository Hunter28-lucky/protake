package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: BufferedOutputStream.java */
/* renamed from: ͱ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2758 extends OutputStream {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final OutputStream f10097;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public byte[] f10098;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC4950 f10099;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f10100;

    public C2758(@NonNull OutputStream outputStream, @NonNull InterfaceC4950 interfaceC4950) {
        this(outputStream, interfaceC4950, 65536);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f10097.close();
            release();
        } catch (Throwable th) {
            this.f10097.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        m10012();
        this.f10097.flush();
    }

    public final void release() {
        byte[] bArr = this.f10098;
        if (bArr != null) {
            this.f10099.put(bArr);
            this.f10098 = null;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.f10098;
        int i2 = this.f10100;
        this.f10100 = i2 + 1;
        bArr[i2] = (byte) i;
        m10013();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m10012() throws IOException {
        int i = this.f10100;
        if (i > 0) {
            this.f10097.write(this.f10098, 0, i);
            this.f10100 = 0;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m10013() throws IOException {
        if (this.f10100 == this.f10098.length) {
            m10012();
        }
    }

    @VisibleForTesting
    public C2758(@NonNull OutputStream outputStream, InterfaceC4950 interfaceC4950, int i) {
        this.f10097 = outputStream;
        this.f10099 = interfaceC4950;
        this.f10098 = (byte[]) interfaceC4950.mo9474(i, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.f10100;
            if (i6 == 0 && i4 >= this.f10098.length) {
                this.f10097.write(bArr, i5, i4);
                return;
            }
            int iMin = Math.min(i4, this.f10098.length - i6);
            System.arraycopy(bArr, i5, this.f10098, this.f10100, iMin);
            this.f10100 += iMin;
            i3 += iMin;
            m10013();
        } while (i3 < i2);
    }
}
