package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import defpackage.InterfaceC4950;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: ԫ, reason: contains not printable characters */
    public volatile byte[] f5368;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f5369;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f5370;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f5371;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f5372;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final InterfaceC4950 f5373;

    public static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull InterfaceC4950 interfaceC4950) {
        this(inputStream, interfaceC4950, 65536);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static IOException m4990() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f5368 == null || inputStream == null) {
            throw m4990();
        }
        return (this.f5369 - this.f5372) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f5368 != null) {
            this.f5373.put(this.f5368);
            this.f5368 = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f5370 = Math.max(this.f5370, i);
        this.f5371 = this.f5372;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f5368;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw m4990();
        }
        if (this.f5372 >= this.f5369 && m4991(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f5368 && (bArr = this.f5368) == null) {
            throw m4990();
        }
        int i = this.f5369;
        int i2 = this.f5372;
        if (i - i2 <= 0) {
            return -1;
        }
        this.f5372 = i2 + 1;
        return bArr[i2] & ExifInterface.MARKER;
    }

    public synchronized void release() {
        if (this.f5368 != null) {
            this.f5373.put(this.f5368);
            this.f5368 = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f5368 == null) {
            throw new IOException("Stream is closed");
        }
        int i = this.f5371;
        if (-1 == i) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f5372 + " markLimit: " + this.f5370);
        }
        this.f5372 = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f5368;
        if (bArr == null) {
            throw m4990();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw m4990();
        }
        int i = this.f5369;
        int i2 = this.f5372;
        if (i - i2 >= j) {
            this.f5372 = (int) (i2 + j);
            return j;
        }
        long j2 = i - i2;
        this.f5372 = i;
        if (this.f5371 == -1 || j > this.f5370) {
            return j2 + inputStream.skip(j - j2);
        }
        if (m4991(inputStream, bArr) == -1) {
            return j2;
        }
        int i3 = this.f5369;
        int i4 = this.f5372;
        if (i3 - i4 >= j - j2) {
            this.f5372 = (int) ((i4 + j) - j2);
            return j;
        }
        long j3 = (j2 + i3) - i4;
        this.f5372 = i3;
        return j3;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int m4991(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.f5371;
        if (i != -1) {
            int i2 = this.f5372 - i;
            int i3 = this.f5370;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.f5369 == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f5373.mo9474(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f5368 = bArr2;
                    this.f5373.put(bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.f5372 - this.f5371;
                this.f5372 = i4;
                this.f5371 = 0;
                this.f5369 = 0;
                int i5 = inputStream.read(bArr, i4, bArr.length - i4);
                int i6 = this.f5372;
                if (i5 > 0) {
                    i6 += i5;
                }
                this.f5369 = i6;
                return i5;
            }
        }
        int i7 = inputStream.read(bArr);
        if (i7 > 0) {
            this.f5371 = -1;
            this.f5372 = 0;
            this.f5369 = i7;
        }
        return i7;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized void m4992() {
        this.f5370 = this.f5368.length;
    }

    @VisibleForTesting
    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull InterfaceC4950 interfaceC4950, int i) {
        super(inputStream);
        this.f5371 = -1;
        this.f5373 = interfaceC4950;
        this.f5368 = (byte[]) interfaceC4950.mo9474(i, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        byte[] bArr2 = this.f5368;
        if (bArr2 == null) {
            throw m4990();
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i5 = this.f5372;
            int i6 = this.f5369;
            if (i5 < i6) {
                int i7 = i6 - i5 >= i2 ? i2 : i6 - i5;
                System.arraycopy(bArr2, i5, bArr, i, i7);
                this.f5372 += i7;
                if (i7 == i2 || inputStream.available() == 0) {
                    return i7;
                }
                i += i7;
                i3 = i2 - i7;
            } else {
                i3 = i2;
            }
            while (true) {
                if (this.f5371 == -1 && i3 >= bArr2.length) {
                    i4 = inputStream.read(bArr, i, i3);
                    if (i4 == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                } else {
                    if (m4991(inputStream, bArr2) == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                    if (bArr2 != this.f5368 && (bArr2 = this.f5368) == null) {
                        throw m4990();
                    }
                    int i8 = this.f5369;
                    int i9 = this.f5372;
                    i4 = i8 - i9 >= i3 ? i3 : i8 - i9;
                    System.arraycopy(bArr2, i9, bArr, i, i4);
                    this.f5372 += i4;
                }
                i3 -= i4;
                if (i3 == 0) {
                    return i2;
                }
                if (inputStream.available() == 0) {
                    return i2 - i3;
                }
                i += i4;
            }
        } else {
            throw m4990();
        }
    }
}
