package okio.internal;

import defpackage.C3921;
import defpackage.C5042;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Timeout;
import okio.Util;

/* compiled from: RealBufferedSource.kt */
/* loaded from: classes2.dex */
public final class RealBufferedSourceKt {
    public static final void commonClose(RealBufferedSource realBufferedSource) throws IOException {
        C3921.m12667(realBufferedSource, "$this$commonClose");
        if (realBufferedSource.closed) {
            return;
        }
        realBufferedSource.closed = true;
        realBufferedSource.source.close();
        realBufferedSource.bufferField.clear();
    }

    public static final boolean commonExhausted(RealBufferedSource realBufferedSource) {
        C3921.m12667(realBufferedSource, "$this$commonExhausted");
        if (!realBufferedSource.closed) {
            return realBufferedSource.bufferField.exhausted() && realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(RealBufferedSource realBufferedSource, byte b, long j, long j2) {
        C3921.m12667(realBufferedSource, "$this$commonIndexOf");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j && j2 >= j)) {
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        while (j < j2) {
            long jIndexOf = realBufferedSource.bufferField.indexOf(b, j, j2);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = realBufferedSource.bufferField.size();
            if (size >= j2 || realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                break;
            }
            j = Math.max(j, size);
        }
        return -1L;
    }

    public static final long commonIndexOfElement(RealBufferedSource realBufferedSource, ByteString byteString, long j) {
        C3921.m12667(realBufferedSource, "$this$commonIndexOfElement");
        C3921.m12667(byteString, "targetBytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOfElement = realBufferedSource.bufferField.indexOfElement(byteString, j);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                return -1L;
            }
            j = Math.max(j, size);
        }
    }

    public static final BufferedSource commonPeek(RealBufferedSource realBufferedSource) {
        C3921.m12667(realBufferedSource, "$this$commonPeek");
        return Okio.buffer(new PeekSource(realBufferedSource));
    }

    public static final boolean commonRangeEquals(RealBufferedSource realBufferedSource, long j, ByteString byteString, int i, int i2) {
        C3921.m12667(realBufferedSource, "$this$commonRangeEquals");
        C3921.m12667(byteString, "bytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!realBufferedSource.request(1 + j2) || realBufferedSource.bufferField.getByte(j2) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public static final long commonRead(RealBufferedSource realBufferedSource, Buffer buffer, long j) {
        C3921.m12667(realBufferedSource, "$this$commonRead");
        C3921.m12667(buffer, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
            return -1L;
        }
        return realBufferedSource.bufferField.read(buffer, Math.min(j, realBufferedSource.bufferField.size()));
    }

    public static final long commonReadAll(RealBufferedSource realBufferedSource, Sink sink) throws IOException {
        C3921.m12667(realBufferedSource, "$this$commonReadAll");
        C3921.m12667(sink, "sink");
        long j = 0;
        while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) != -1) {
            long jCompleteSegmentByteCount = realBufferedSource.bufferField.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j += jCompleteSegmentByteCount;
                sink.write(realBufferedSource.bufferField, jCompleteSegmentByteCount);
            }
        }
        if (realBufferedSource.bufferField.size() <= 0) {
            return j;
        }
        long size = j + realBufferedSource.bufferField.size();
        Buffer buffer = realBufferedSource.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    public static final byte commonReadByte(RealBufferedSource realBufferedSource) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonReadByte");
        realBufferedSource.require(1L);
        return realBufferedSource.bufferField.readByte();
    }

    public static final byte[] commonReadByteArray(RealBufferedSource realBufferedSource, long j) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonReadByteArray");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readByteArray(j);
    }

    public static final ByteString commonReadByteString(RealBufferedSource realBufferedSource, long j) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonReadByteString");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readByteString(j);
    }

    public static final long commonReadDecimalLong(RealBufferedSource realBufferedSource) throws EOFException {
        byte b;
        C3921.m12667(realBufferedSource, "$this$commonReadDecimalLong");
        realBufferedSource.require(1L);
        long j = 0;
        while (true) {
            long j2 = j + 1;
            if (!realBufferedSource.request(j2)) {
                break;
            }
            b = realBufferedSource.bufferField.getByte(j);
            if ((b < ((byte) 48) || b > ((byte) 57)) && !(j == 0 && b == ((byte) 45))) {
                break;
            }
            j = j2;
        }
        if (j == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9] or '-' character but was 0x");
            String string = Integer.toString(b, C5042.m14848(C5042.m14848(16)));
            C3921.m12663(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return realBufferedSource.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(RealBufferedSource realBufferedSource, byte[] bArr) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonReadFully");
        C3921.m12667(bArr, "sink");
        try {
            realBufferedSource.require(bArr.length);
            realBufferedSource.bufferField.readFully(bArr);
        } catch (EOFException e2) {
            int i = 0;
            while (realBufferedSource.bufferField.size() > 0) {
                Buffer buffer = realBufferedSource.bufferField;
                int i2 = buffer.read(bArr, i, (int) buffer.size());
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
            throw e2;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(RealBufferedSource realBufferedSource) throws EOFException {
        byte b;
        C3921.m12667(realBufferedSource, "$this$commonReadHexadecimalUnsignedLong");
        realBufferedSource.require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!realBufferedSource.request(i2)) {
                break;
            }
            b = realBufferedSource.bufferField.getByte(i);
            if ((b < ((byte) 48) || b > ((byte) 57)) && ((b < ((byte) 97) || b > ((byte) 102)) && (b < ((byte) 65) || b > ((byte) 70)))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            String string = Integer.toString(b, C5042.m14848(C5042.m14848(16)));
            C3921.m12663(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return realBufferedSource.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(RealBufferedSource realBufferedSource) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonReadInt");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readInt();
    }

    public static final int commonReadIntLe(RealBufferedSource realBufferedSource) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonReadIntLe");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readIntLe();
    }

    public static final long commonReadLong(RealBufferedSource realBufferedSource) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonReadLong");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLong();
    }

    public static final long commonReadLongLe(RealBufferedSource realBufferedSource) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonReadLongLe");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLongLe();
    }

    public static final short commonReadShort(RealBufferedSource realBufferedSource) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonReadShort");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShort();
    }

    public static final short commonReadShortLe(RealBufferedSource realBufferedSource) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonReadShortLe");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShortLe();
    }

    public static final String commonReadUtf8(RealBufferedSource realBufferedSource, long j) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonReadUtf8");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readUtf8(j);
    }

    public static final int commonReadUtf8CodePoint(RealBufferedSource realBufferedSource) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonReadUtf8CodePoint");
        realBufferedSource.require(1L);
        byte b = realBufferedSource.bufferField.getByte(0L);
        if ((b & 224) == 192) {
            realBufferedSource.require(2L);
        } else if ((b & 240) == 224) {
            realBufferedSource.require(3L);
        } else if ((b & 248) == 240) {
            realBufferedSource.require(4L);
        }
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }

    public static final String commonReadUtf8Line(RealBufferedSource realBufferedSource) {
        C3921.m12667(realBufferedSource, "$this$commonReadUtf8Line");
        long jIndexOf = realBufferedSource.indexOf((byte) 10);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, jIndexOf);
        }
        if (realBufferedSource.bufferField.size() != 0) {
            return realBufferedSource.readUtf8(realBufferedSource.bufferField.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(RealBufferedSource realBufferedSource, long j) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonReadUtf8LineStrict");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        byte b = (byte) 10;
        long jIndexOf = realBufferedSource.indexOf(b, 0L, j2);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, jIndexOf);
        }
        if (j2 < Long.MAX_VALUE && realBufferedSource.request(j2) && realBufferedSource.bufferField.getByte(j2 - 1) == ((byte) 13) && realBufferedSource.request(1 + j2) && realBufferedSource.bufferField.getByte(j2) == b) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, j2);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = realBufferedSource.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(realBufferedSource.bufferField.size(), j) + " content=" + buffer.readByteString().hex() + "…");
    }

    public static final boolean commonRequest(RealBufferedSource realBufferedSource, long j) {
        C3921.m12667(realBufferedSource, "$this$commonRequest");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (realBufferedSource.bufferField.size() < j) {
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final void commonRequire(RealBufferedSource realBufferedSource, long j) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonRequire");
        if (!realBufferedSource.request(j)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(RealBufferedSource realBufferedSource, Options options) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonSelect");
        C3921.m12667(options, "options");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int iSelectPrefix = BufferKt.selectPrefix(realBufferedSource.bufferField, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix == -1) {
                    return -1;
                }
                realBufferedSource.bufferField.skip(options.getByteStrings$okio()[iSelectPrefix].size());
                return iSelectPrefix;
            }
        } while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) != -1);
        return -1;
    }

    public static final void commonSkip(RealBufferedSource realBufferedSource, long j) throws EOFException {
        C3921.m12667(realBufferedSource, "$this$commonSkip");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j > 0) {
            if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, realBufferedSource.bufferField.size());
            realBufferedSource.bufferField.skip(jMin);
            j -= jMin;
        }
    }

    public static final Timeout commonTimeout(RealBufferedSource realBufferedSource) {
        C3921.m12667(realBufferedSource, "$this$commonTimeout");
        return realBufferedSource.source.timeout();
    }

    public static final String commonToString(RealBufferedSource realBufferedSource) {
        C3921.m12667(realBufferedSource, "$this$commonToString");
        return "buffer(" + realBufferedSource.source + ')';
    }

    public static final byte[] commonReadByteArray(RealBufferedSource realBufferedSource) throws IOException {
        C3921.m12667(realBufferedSource, "$this$commonReadByteArray");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    public static final ByteString commonReadByteString(RealBufferedSource realBufferedSource) throws IOException {
        C3921.m12667(realBufferedSource, "$this$commonReadByteString");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    public static final String commonReadUtf8(RealBufferedSource realBufferedSource) throws IOException {
        C3921.m12667(realBufferedSource, "$this$commonReadUtf8");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }

    public static final void commonReadFully(RealBufferedSource realBufferedSource, Buffer buffer, long j) throws IOException {
        C3921.m12667(realBufferedSource, "$this$commonReadFully");
        C3921.m12667(buffer, "sink");
        try {
            realBufferedSource.require(j);
            realBufferedSource.bufferField.readFully(buffer, j);
        } catch (EOFException e2) {
            buffer.writeAll(realBufferedSource.bufferField);
            throw e2;
        }
    }

    public static final long commonIndexOf(RealBufferedSource realBufferedSource, ByteString byteString, long j) throws IOException {
        C3921.m12667(realBufferedSource, "$this$commonIndexOf");
        C3921.m12667(byteString, "bytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOf = realBufferedSource.bufferField.indexOf(byteString, j);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                return -1L;
            }
            j = Math.max(j, (size - byteString.size()) + 1);
        }
    }

    public static final int commonRead(RealBufferedSource realBufferedSource, byte[] bArr, int i, int i2) {
        C3921.m12667(realBufferedSource, "$this$commonRead");
        C3921.m12667(bArr, "sink");
        long j = i2;
        Util.checkOffsetAndCount(bArr.length, i, j);
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
            return -1;
        }
        return realBufferedSource.bufferField.read(bArr, i, (int) Math.min(j, realBufferedSource.bufferField.size()));
    }
}
