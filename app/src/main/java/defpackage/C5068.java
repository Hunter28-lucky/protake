package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream.java */
/* renamed from: ཧ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5068 extends InputStream {

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final Queue<C5068> f16843 = j5.m7088(0);

    /* renamed from: ԫ, reason: contains not printable characters */
    public InputStream f16844;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public IOException f16845;

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static C5068 m14880(@NonNull InputStream inputStream) {
        C5068 c5068Poll;
        Queue<C5068> queue = f16843;
        synchronized (queue) {
            c5068Poll = queue.poll();
        }
        if (c5068Poll == null) {
            c5068Poll = new C5068();
        }
        c5068Poll.m14882(inputStream);
        return c5068Poll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f16844.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f16844.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f16844.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f16844.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f16844.read(bArr);
        } catch (IOException e2) {
            this.f16845 = e2;
            return -1;
        }
    }

    public void release() {
        this.f16845 = null;
        this.f16844 = null;
        Queue<C5068> queue = f16843;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f16844.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f16844.skip(j);
        } catch (IOException e2) {
            this.f16845 = e2;
            return 0L;
        }
    }

    @Nullable
    /* renamed from: Ϳ, reason: contains not printable characters */
    public IOException m14881() {
        return this.f16845;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m14882(@NonNull InputStream inputStream) {
        this.f16844 = inputStream;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f16844.read(bArr, i, i2);
        } catch (IOException e2) {
            this.f16845 = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f16844.read();
        } catch (IOException e2) {
            this.f16845 = e2;
            return -1;
        }
    }
}
