package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ByteBufferUtil.java */
/* renamed from: ł, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2360 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final AtomicReference<byte[]> f8901 = new AtomicReference<>();

    /* compiled from: ByteBufferUtil.java */
    /* renamed from: ł$Ԩ, reason: contains not printable characters */
    public static final class C2362 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final int f8904;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final int f8905;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final byte[] f8906;

        public C2362(@NonNull byte[] bArr, int i, int i2) {
            this.f8906 = bArr;
            this.f8904 = i;
            this.f8905 = i2;
        }
    }

    @NonNull
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static ByteBuffer m8825(@NonNull File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel channel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                channel = randomAccessFile.getChannel();
                MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                try {
                    channel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                return mappedByteBufferLoad;
            } catch (Throwable th) {
                th = th;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    @Nullable
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static C2362 m8826(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new C2362(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters */
    public static byte[] m8827(@NonNull ByteBuffer byteBuffer) {
        C2362 c2362M8826 = m8826(byteBuffer);
        if (c2362M8826 != null && c2362M8826.f8904 == 0 && c2362M8826.f8905 == c2362M8826.f8906.length) {
            return byteBuffer.array();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        byteBufferAsReadOnlyBuffer.position(0);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m8828(@NonNull ByteBuffer byteBuffer, @NonNull File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            channel = randomAccessFile.getChannel();
            channel.write(byteBuffer);
            channel.force(false);
            channel.close();
            randomAccessFile.close();
            try {
                channel.close();
            } catch (IOException unused) {
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException unused3) {
                }
            }
            if (randomAccessFile == null) {
                throw th;
            }
            try {
                randomAccessFile.close();
                throw th;
            } catch (IOException unused4) {
                throw th;
            }
        }
    }

    @NonNull
    /* renamed from: ԫ, reason: contains not printable characters */
    public static InputStream m8829(@NonNull ByteBuffer byteBuffer) {
        return new C2361(byteBuffer);
    }

    /* compiled from: ByteBufferUtil.java */
    /* renamed from: ł$Ϳ, reason: contains not printable characters */
    public static class C2361 extends InputStream {

        /* renamed from: ԫ, reason: contains not printable characters */
        @NonNull
        public final ByteBuffer f8902;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public int f8903 = -1;

        public C2361(@NonNull ByteBuffer byteBuffer) {
            this.f8902 = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f8902.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.f8903 = this.f8902.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f8902.hasRemaining()) {
                return this.f8902.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            int i = this.f8903;
            if (i == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f8902.position(i);
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            if (!this.f8902.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j, available());
            this.f8902.position((int) (r0.position() + jMin));
            return jMin;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
            if (!this.f8902.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i2, available());
            this.f8902.get(bArr, i, iMin);
            return iMin;
        }
    }
}
