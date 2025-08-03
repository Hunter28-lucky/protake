package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.C3921;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* compiled from: RealBufferedSink.kt */
/* loaded from: classes2.dex */
public final class RealBufferedSinkKt {
    public static final void commonClose(RealBufferedSink realBufferedSink) throws Throwable {
        C3921.m12667(realBufferedSink, "$this$commonClose");
        if (realBufferedSink.closed) {
            return;
        }
        Throwable th = null;
        try {
            if (realBufferedSink.bufferField.size() > 0) {
                Sink sink = realBufferedSink.sink;
                Buffer buffer = realBufferedSink.bufferField;
                sink.write(buffer, buffer.size());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            realBufferedSink.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        realBufferedSink.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public static final BufferedSink commonEmit(RealBufferedSink realBufferedSink) throws IOException {
        C3921.m12667(realBufferedSink, "$this$commonEmit");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long size = realBufferedSink.bufferField.size();
        if (size > 0) {
            realBufferedSink.sink.write(realBufferedSink.bufferField, size);
        }
        return realBufferedSink;
    }

    public static final BufferedSink commonEmitCompleteSegments(RealBufferedSink realBufferedSink) throws IOException {
        C3921.m12667(realBufferedSink, "$this$commonEmitCompleteSegments");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long jCompleteSegmentByteCount = realBufferedSink.bufferField.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            realBufferedSink.sink.write(realBufferedSink.bufferField, jCompleteSegmentByteCount);
        }
        return realBufferedSink;
    }

    public static final void commonFlush(RealBufferedSink realBufferedSink) throws IOException {
        C3921.m12667(realBufferedSink, "$this$commonFlush");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (realBufferedSink.bufferField.size() > 0) {
            Sink sink = realBufferedSink.sink;
            Buffer buffer = realBufferedSink.bufferField;
            sink.write(buffer, buffer.size());
        }
        realBufferedSink.sink.flush();
    }

    public static final Timeout commonTimeout(RealBufferedSink realBufferedSink) {
        C3921.m12667(realBufferedSink, "$this$commonTimeout");
        return realBufferedSink.sink.timeout();
    }

    public static final String commonToString(RealBufferedSink realBufferedSink) {
        C3921.m12667(realBufferedSink, "$this$commonToString");
        return "buffer(" + realBufferedSink.sink + ')';
    }

    public static final void commonWrite(RealBufferedSink realBufferedSink, Buffer buffer, long j) throws IOException {
        C3921.m12667(realBufferedSink, "$this$commonWrite");
        C3921.m12667(buffer, "source");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.write(buffer, j);
        realBufferedSink.emitCompleteSegments();
    }

    public static final long commonWriteAll(RealBufferedSink realBufferedSink, Source source) throws IOException {
        C3921.m12667(realBufferedSink, "$this$commonWriteAll");
        C3921.m12667(source, "source");
        long j = 0;
        while (true) {
            long j2 = source.read(realBufferedSink.bufferField, 8192);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            realBufferedSink.emitCompleteSegments();
        }
    }

    public static final BufferedSink commonWriteByte(RealBufferedSink realBufferedSink, int i) {
        C3921.m12667(realBufferedSink, "$this$commonWriteByte");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeByte(i);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteDecimalLong(RealBufferedSink realBufferedSink, long j) {
        C3921.m12667(realBufferedSink, "$this$commonWriteDecimalLong");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeDecimalLong(j);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteHexadecimalUnsignedLong(RealBufferedSink realBufferedSink, long j) {
        C3921.m12667(realBufferedSink, "$this$commonWriteHexadecimalUnsignedLong");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeHexadecimalUnsignedLong(j);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteInt(RealBufferedSink realBufferedSink, int i) {
        C3921.m12667(realBufferedSink, "$this$commonWriteInt");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeInt(i);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteIntLe(RealBufferedSink realBufferedSink, int i) {
        C3921.m12667(realBufferedSink, "$this$commonWriteIntLe");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeIntLe(i);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLong(RealBufferedSink realBufferedSink, long j) {
        C3921.m12667(realBufferedSink, "$this$commonWriteLong");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeLong(j);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLongLe(RealBufferedSink realBufferedSink, long j) {
        C3921.m12667(realBufferedSink, "$this$commonWriteLongLe");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeLongLe(j);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShort(RealBufferedSink realBufferedSink, int i) {
        C3921.m12667(realBufferedSink, "$this$commonWriteShort");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeShort(i);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShortLe(RealBufferedSink realBufferedSink, int i) {
        C3921.m12667(realBufferedSink, "$this$commonWriteShortLe");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeShortLe(i);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink realBufferedSink, String str) {
        C3921.m12667(realBufferedSink, "$this$commonWriteUtf8");
        C3921.m12667(str, TypedValues.Custom.S_STRING);
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeUtf8(str);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8CodePoint(RealBufferedSink realBufferedSink, int i) {
        C3921.m12667(realBufferedSink, "$this$commonWriteUtf8CodePoint");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeUtf8CodePoint(i);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, ByteString byteString) {
        C3921.m12667(realBufferedSink, "$this$commonWrite");
        C3921.m12667(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink realBufferedSink, String str, int i, int i2) {
        C3921.m12667(realBufferedSink, "$this$commonWriteUtf8");
        C3921.m12667(str, TypedValues.Custom.S_STRING);
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(str, i, i2);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, ByteString byteString, int i, int i2) {
        C3921.m12667(realBufferedSink, "$this$commonWrite");
        C3921.m12667(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString, i, i2);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, byte[] bArr) {
        C3921.m12667(realBufferedSink, "$this$commonWrite");
        C3921.m12667(bArr, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, byte[] bArr, int i, int i2) {
        C3921.m12667(realBufferedSink, "$this$commonWrite");
        C3921.m12667(bArr, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr, i, i2);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, Source source, long j) throws IOException {
        C3921.m12667(realBufferedSink, "$this$commonWrite");
        C3921.m12667(source, "source");
        while (j > 0) {
            long j2 = source.read(realBufferedSink.bufferField, j);
            if (j2 != -1) {
                j -= j2;
                realBufferedSink.emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return realBufferedSink;
    }
}
