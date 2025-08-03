package defpackage;

import defpackage.C4305;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.ErrorCode;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: Http2Writer.kt */
/* renamed from: ΰ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2809 implements Closeable {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Buffer f10243;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f10244;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f10245;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final C4305.C4307 f10246;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final BufferedSink f10247;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final boolean f10248;

    /* renamed from: ֏, reason: contains not printable characters */
    public static final C2810 f10242 = new C2810(null);

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final Logger f10241 = Logger.getLogger(C3700.class.getName());

    /* compiled from: Http2Writer.kt */
    /* renamed from: ΰ$Ϳ, reason: contains not printable characters */
    public static final class C2810 {
        public C2810() {
        }

        public /* synthetic */ C2810(C4184 c4184) {
            this();
        }
    }

    public C2809(BufferedSink bufferedSink, boolean z) {
        C3921.m12667(bufferedSink, "sink");
        this.f10247 = bufferedSink;
        this.f10248 = z;
        Buffer buffer = new Buffer();
        this.f10243 = buffer;
        this.f10244 = 16384;
        this.f10246 = new C4305.C4307(0, false, buffer, 3, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f10245 = true;
        this.f10247.close();
    }

    public final synchronized void flush() throws IOException {
        if (this.f10245) {
            throw new IOException("closed");
        }
        this.f10247.flush();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final synchronized void m10126(C4825 c4825) throws IOException {
        C3921.m12667(c4825, "peerSettings");
        if (this.f10245) {
            throw new IOException("closed");
        }
        this.f10244 = c4825.m14556(this.f10244);
        if (c4825.m14553() != -1) {
            this.f10246.m13450(c4825.m14553());
        }
        m10130(0, 0, 4, 1);
        this.f10247.flush();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final synchronized void m10127() throws IOException {
        if (this.f10245) {
            throw new IOException("closed");
        }
        if (this.f10248) {
            Logger logger = f10241;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(i5.m6247(">> CONNECTION " + C3700.f12829.hex(), new Object[0]));
            }
            this.f10247.write(C3700.f12829);
            this.f10247.flush();
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final synchronized void m10128(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (this.f10245) {
            throw new IOException("closed");
        }
        m10129(i, z ? 1 : 0, buffer, i2);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m10129(int i, int i2, Buffer buffer, int i3) throws IOException {
        m10130(i, i3, 0, i2);
        if (i3 > 0) {
            BufferedSink bufferedSink = this.f10247;
            if (buffer == null) {
                C3921.m12675();
            }
            bufferedSink.write(buffer, i3);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m10130(int i, int i2, int i3, int i4) throws IOException {
        Logger logger = f10241;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C3700.f12833.m11851(false, i, i2, i3, i4));
        }
        if (!(i2 <= this.f10244)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f10244 + ": " + i2).toString());
        }
        if (!((((int) 2147483648L) & i) == 0)) {
            throw new IllegalArgumentException(("reserved bit set: " + i).toString());
        }
        i5.m6278(this.f10247, i2);
        this.f10247.writeByte(i3 & 255);
        this.f10247.writeByte(i4 & 255);
        this.f10247.writeInt(i & Integer.MAX_VALUE);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final synchronized void m10131(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        C3921.m12667(errorCode, "errorCode");
        C3921.m12667(bArr, "debugData");
        if (this.f10245) {
            throw new IOException("closed");
        }
        if (!(errorCode.m7848() != -1)) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        m10130(0, bArr.length + 8, 7, 0);
        this.f10247.writeInt(i);
        this.f10247.writeInt(errorCode.m7848());
        if (!(bArr.length == 0)) {
            this.f10247.write(bArr);
        }
        this.f10247.flush();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final synchronized void m10132(boolean z, int i, List<C3168> list) throws IOException {
        C3921.m12667(list, "headerBlock");
        if (this.f10245) {
            throw new IOException("closed");
        }
        this.f10246.m13452(list);
        long size = this.f10243.size();
        long jMin = Math.min(this.f10244, size);
        int i2 = size == jMin ? 4 : 0;
        if (z) {
            i2 |= 1;
        }
        m10130(i, (int) jMin, 1, i2);
        this.f10247.write(this.f10243, jMin);
        if (size > jMin) {
            m10139(i, size - jMin);
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int m10133() {
        return this.f10244;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final synchronized void m10134(boolean z, int i, int i2) throws IOException {
        if (this.f10245) {
            throw new IOException("closed");
        }
        m10130(0, 8, 6, z ? 1 : 0);
        this.f10247.writeInt(i);
        this.f10247.writeInt(i2);
        this.f10247.flush();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final synchronized void m10135(int i, int i2, List<C3168> list) throws IOException {
        C3921.m12667(list, "requestHeaders");
        if (this.f10245) {
            throw new IOException("closed");
        }
        this.f10246.m13452(list);
        long size = this.f10243.size();
        int iMin = (int) Math.min(this.f10244 - 4, size);
        long j = iMin;
        m10130(i, iMin + 4, 5, size == j ? 4 : 0);
        this.f10247.writeInt(i2 & Integer.MAX_VALUE);
        this.f10247.write(this.f10243, j);
        if (size > j) {
            m10139(i, size - j);
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final synchronized void m10136(int i, ErrorCode errorCode) throws IOException {
        C3921.m12667(errorCode, "errorCode");
        if (this.f10245) {
            throw new IOException("closed");
        }
        if (!(errorCode.m7848() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        m10130(i, 4, 3, 0);
        this.f10247.writeInt(errorCode.m7848());
        this.f10247.flush();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final synchronized void m10137(C4825 c4825) throws IOException {
        C3921.m12667(c4825, "settings");
        if (this.f10245) {
            throw new IOException("closed");
        }
        int i = 0;
        m10130(0, c4825.m14560() * 6, 4, 0);
        while (i < 10) {
            if (c4825.m14557(i)) {
                this.f10247.writeShort(i != 4 ? i != 7 ? i : 4 : 3);
                this.f10247.writeInt(c4825.m14552(i));
            }
            i++;
        }
        this.f10247.flush();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final synchronized void m10138(int i, long j) throws IOException {
        if (this.f10245) {
            throw new IOException("closed");
        }
        if (!(j != 0 && j <= 2147483647L)) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
        }
        m10130(i, 4, 8, 0);
        this.f10247.writeInt((int) j);
        this.f10247.flush();
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m10139(int i, long j) throws IOException {
        while (j > 0) {
            long jMin = Math.min(this.f10244, j);
            j -= jMin;
            m10130(i, (int) jMin, 9, j == 0 ? 4 : 0);
            this.f10247.write(this.f10243, jMin);
        }
    }
}
