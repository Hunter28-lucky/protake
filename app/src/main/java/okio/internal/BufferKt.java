package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.cb;
import defpackage.C3921;
import defpackage.C4955;
import defpackage.InterfaceC2849;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Platform;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio.Util;
import org.jcodec.containers.mxf.model.BER;

/* compiled from: Buffer.kt */
/* loaded from: classes2.dex */
public final class BufferKt {
    private static final byte[] HEX_DIGIT_BYTES = Platform.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(Buffer buffer) throws EOFException {
        C3921.m12667(buffer, "$this$commonClear");
        buffer.skip(buffer.size());
    }

    public static final long commonCompleteSegmentByteCount(Buffer buffer) {
        C3921.m12667(buffer, "$this$commonCompleteSegmentByteCount");
        long size = buffer.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C3921.m12675();
        }
        Segment segment2 = segment.prev;
        if (segment2 == null) {
            C3921.m12675();
        }
        return (segment2.limit >= 8192 || !segment2.owner) ? size : size - (r2 - segment2.pos);
    }

    public static final Buffer commonCopy(Buffer buffer) {
        C3921.m12667(buffer, "$this$commonCopy");
        Buffer buffer2 = new Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C3921.m12675();
        }
        Segment segmentSharedCopy = segment.sharedCopy();
        buffer2.head = segmentSharedCopy;
        segmentSharedCopy.prev = segmentSharedCopy;
        segmentSharedCopy.next = segmentSharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = segmentSharedCopy.prev;
            if (segment3 == null) {
                C3921.m12675();
            }
            if (segment2 == null) {
                C3921.m12675();
            }
            segment3.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    public static final Buffer commonCopyTo(Buffer buffer, Buffer buffer2, long j, long j2) {
        C3921.m12667(buffer, "$this$commonCopyTo");
        C3921.m12667(buffer2, "out");
        Util.checkOffsetAndCount(buffer.size(), j, j2);
        if (j2 == 0) {
            return buffer;
        }
        buffer2.setSize$okio(buffer2.size() + j2);
        Segment segment = buffer.head;
        while (true) {
            if (segment == null) {
                C3921.m12675();
            }
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            segment = segment.next;
        }
        while (j2 > 0) {
            if (segment == null) {
                C3921.m12675();
            }
            Segment segmentSharedCopy = segment.sharedCopy();
            int i3 = segmentSharedCopy.pos + ((int) j);
            segmentSharedCopy.pos = i3;
            segmentSharedCopy.limit = Math.min(i3 + ((int) j2), segmentSharedCopy.limit);
            Segment segment2 = buffer2.head;
            if (segment2 == null) {
                segmentSharedCopy.prev = segmentSharedCopy;
                segmentSharedCopy.next = segmentSharedCopy;
                buffer2.head = segmentSharedCopy;
            } else {
                if (segment2 == null) {
                    C3921.m12675();
                }
                Segment segment3 = segment2.prev;
                if (segment3 == null) {
                    C3921.m12675();
                }
                segment3.push(segmentSharedCopy);
            }
            j2 -= segmentSharedCopy.limit - segmentSharedCopy.pos;
            segment = segment.next;
            j = 0;
        }
        return buffer;
    }

    public static final boolean commonEquals(Buffer buffer, Object obj) {
        C3921.m12667(buffer, "$this$commonEquals");
        if (buffer == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer2 = (Buffer) obj;
        if (buffer.size() != buffer2.size()) {
            return false;
        }
        if (buffer.size() == 0) {
            return true;
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C3921.m12675();
        }
        Segment segment2 = buffer2.head;
        if (segment2 == null) {
            C3921.m12675();
        }
        int i = segment.pos;
        int i2 = segment2.pos;
        long j = 0;
        while (j < buffer.size()) {
            long jMin = Math.min(segment.limit - i, segment2.limit - i2);
            long j2 = 0;
            while (j2 < jMin) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                j2++;
                i = i3;
                i2 = i4;
            }
            if (i == segment.limit) {
                segment = segment.next;
                if (segment == null) {
                    C3921.m12675();
                }
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                if (segment2 == null) {
                    C3921.m12675();
                }
                i2 = segment2.pos;
            }
            j += jMin;
        }
        return true;
    }

    public static final byte commonGet(Buffer buffer, long j) {
        C3921.m12667(buffer, "$this$commonGet");
        Util.checkOffsetAndCount(buffer.size(), j, 1L);
        Segment segment = buffer.head;
        if (segment == null) {
            C3921.m12675();
            throw null;
        }
        if (buffer.size() - j < j) {
            long size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                if (segment == null) {
                    C3921.m12675();
                }
                size -= segment.limit - segment.pos;
            }
            return segment.data[(int) ((segment.pos + j) - size)];
        }
        long j2 = 0;
        while (true) {
            int i = segment.limit;
            int i2 = segment.pos;
            long j3 = (i - i2) + j2;
            if (j3 > j) {
                return segment.data[(int) ((i2 + j) - j2)];
            }
            segment = segment.next;
            if (segment == null) {
                C3921.m12675();
            }
            j2 = j3;
        }
    }

    public static final int commonHashCode(Buffer buffer) {
        C3921.m12667(buffer, "$this$commonHashCode");
        Segment segment = buffer.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
            if (segment == null) {
                C3921.m12675();
            }
        } while (segment != buffer.head);
        return i;
    }

    public static final long commonIndexOf(Buffer buffer, byte b, long j, long j2) {
        Segment segment;
        int i;
        C3921.m12667(buffer, "$this$commonIndexOf");
        long size = 0;
        if (!(0 <= j && j2 >= j)) {
            throw new IllegalArgumentException(("size=" + buffer.size() + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        if (j2 > buffer.size()) {
            j2 = buffer.size();
        }
        if (j == j2 || (segment = buffer.head) == null) {
            return -1L;
        }
        if (buffer.size() - j < j) {
            size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                if (segment == null) {
                    C3921.m12675();
                }
                size -= segment.limit - segment.pos;
            }
            while (size < j2) {
                byte[] bArr = segment.data;
                int iMin = (int) Math.min(segment.limit, (segment.pos + j2) - size);
                i = (int) ((segment.pos + j) - size);
                while (i < iMin) {
                    if (bArr[i] != b) {
                        i++;
                    }
                }
                size += segment.limit - segment.pos;
                segment = segment.next;
                if (segment == null) {
                    C3921.m12675();
                }
                j = size;
            }
            return -1L;
        }
        while (true) {
            long j3 = (segment.limit - segment.pos) + size;
            if (j3 > j) {
                break;
            }
            segment = segment.next;
            if (segment == null) {
                C3921.m12675();
            }
            size = j3;
        }
        while (size < j2) {
            byte[] bArr2 = segment.data;
            int iMin2 = (int) Math.min(segment.limit, (segment.pos + j2) - size);
            i = (int) ((segment.pos + j) - size);
            while (i < iMin2) {
                if (bArr2[i] != b) {
                    i++;
                }
            }
            size += segment.limit - segment.pos;
            segment = segment.next;
            if (segment == null) {
                C3921.m12675();
            }
            j = size;
        }
        return -1L;
        return (i - segment.pos) + size;
    }

    public static final long commonIndexOfElement(Buffer buffer, ByteString byteString, long j) {
        int i;
        int i2;
        C3921.m12667(buffer, "$this$commonIndexOfElement");
        C3921.m12667(byteString, "targetBytes");
        long size = 0;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
        }
        Segment segment = buffer.head;
        if (segment == null) {
            return -1L;
        }
        if (buffer.size() - j < j) {
            size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                if (segment == null) {
                    C3921.m12675();
                }
                size -= segment.limit - segment.pos;
            }
            if (byteString.size() == 2) {
                byte b = byteString.getByte(0);
                byte b2 = byteString.getByte(1);
                while (size < buffer.size()) {
                    byte[] bArr = segment.data;
                    i = (int) ((segment.pos + j) - size);
                    int i3 = segment.limit;
                    while (i < i3) {
                        byte b3 = bArr[i];
                        if (b3 == b || b3 == b2) {
                            i2 = segment.pos;
                        } else {
                            i++;
                        }
                    }
                    size += segment.limit - segment.pos;
                    segment = segment.next;
                    if (segment == null) {
                        C3921.m12675();
                    }
                    j = size;
                }
            } else {
                byte[] bArrInternalArray$okio = byteString.internalArray$okio();
                while (size < buffer.size()) {
                    byte[] bArr2 = segment.data;
                    i = (int) ((segment.pos + j) - size);
                    int i4 = segment.limit;
                    while (i < i4) {
                        byte b4 = bArr2[i];
                        for (byte b5 : bArrInternalArray$okio) {
                            if (b4 == b5) {
                                i2 = segment.pos;
                            }
                        }
                        i++;
                    }
                    size += segment.limit - segment.pos;
                    segment = segment.next;
                    if (segment == null) {
                        C3921.m12675();
                    }
                    j = size;
                }
            }
            return -1L;
        }
        while (true) {
            long j2 = (segment.limit - segment.pos) + size;
            if (j2 > j) {
                break;
            }
            segment = segment.next;
            if (segment == null) {
                C3921.m12675();
            }
            size = j2;
        }
        if (byteString.size() == 2) {
            byte b6 = byteString.getByte(0);
            byte b7 = byteString.getByte(1);
            while (size < buffer.size()) {
                byte[] bArr3 = segment.data;
                i = (int) ((segment.pos + j) - size);
                int i5 = segment.limit;
                while (i < i5) {
                    byte b8 = bArr3[i];
                    if (b8 == b6 || b8 == b7) {
                        i2 = segment.pos;
                    } else {
                        i++;
                    }
                }
                size += segment.limit - segment.pos;
                segment = segment.next;
                if (segment == null) {
                    C3921.m12675();
                }
                j = size;
            }
        } else {
            byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
            while (size < buffer.size()) {
                byte[] bArr4 = segment.data;
                i = (int) ((segment.pos + j) - size);
                int i6 = segment.limit;
                while (i < i6) {
                    byte b9 = bArr4[i];
                    for (byte b10 : bArrInternalArray$okio2) {
                        if (b9 == b10) {
                            i2 = segment.pos;
                        }
                    }
                    i++;
                }
                size += segment.limit - segment.pos;
                segment = segment.next;
                if (segment == null) {
                    C3921.m12675();
                }
                j = size;
            }
        }
        return -1L;
        return (i - i2) + size;
    }

    public static final boolean commonRangeEquals(Buffer buffer, long j, ByteString byteString, int i, int i2) {
        C3921.m12667(buffer, "$this$commonRangeEquals");
        C3921.m12667(byteString, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || buffer.size() - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (buffer.getByte(i3 + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(Buffer buffer, byte[] bArr) {
        C3921.m12667(buffer, "$this$commonRead");
        C3921.m12667(bArr, "sink");
        return buffer.read(bArr, 0, bArr.length);
    }

    public static final long commonReadAll(Buffer buffer, Sink sink) throws IOException {
        C3921.m12667(buffer, "$this$commonReadAll");
        C3921.m12667(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    public static final byte commonReadByte(Buffer buffer) throws EOFException {
        C3921.m12667(buffer, "$this$commonReadByte");
        if (buffer.size() == 0) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C3921.m12675();
        }
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b = segment.data[i];
        buffer.setSize$okio(buffer.size() - 1);
        if (i3 == i2) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i3;
        }
        return b;
    }

    public static final byte[] commonReadByteArray(Buffer buffer) {
        C3921.m12667(buffer, "$this$commonReadByteArray");
        return buffer.readByteArray(buffer.size());
    }

    public static final ByteString commonReadByteString(Buffer buffer) {
        C3921.m12667(buffer, "$this$commonReadByteString");
        return buffer.readByteString(buffer.size());
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c8 A[EDGE_INSN: B:54:0x00c8->B:44:0x00c8 BREAK  A[LOOP:0: B:5:0x0016->B:56:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadDecimalLong(okio.Buffer r17) throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadDecimalLong(okio.Buffer):long");
    }

    public static final void commonReadFully(Buffer buffer, byte[] bArr) throws EOFException {
        C3921.m12667(buffer, "$this$commonReadFully");
        C3921.m12667(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int i2 = buffer.read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b5 A[EDGE_INSN: B:46:0x00b5->B:40:0x00b5 BREAK  A[LOOP:0: B:5:0x0012->B:48:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadHexadecimalUnsignedLong(okio.Buffer r14) throws java.io.EOFException {
        /*
            java.lang.String r0 = "$this$commonReadHexadecimalUnsignedLong"
            defpackage.C3921.m12667(r14, r0)
            long r0 = r14.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lbf
            r0 = 0
            r1 = r0
            r4 = r2
        L12:
            okio.Segment r6 = r14.head
            if (r6 != 0) goto L19
            defpackage.C3921.m12675()
        L19:
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L1f:
            if (r8 >= r9) goto La1
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L30
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L30
            int r11 = r10 - r11
            goto L4a
        L30:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L3f
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L3f
        L3a:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L4a
        L3f:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L82
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L82
            goto L3a
        L4a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L5a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L1f
        L5a:
            okio.Buffer r14 = new okio.Buffer
            r14.<init>()
            okio.Buffer r14 = r14.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r14 = r14.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r14 = r14.readUtf8()
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            r0.<init>(r14)
            throw r0
        L82:
            if (r0 == 0) goto L86
            r1 = 1
            goto La1
        L86:
            java.lang.NumberFormatException r14 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = okio.Util.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        La1:
            if (r8 != r9) goto Lad
            okio.Segment r7 = r6.pop()
            r14.head = r7
            okio.SegmentPool.recycle(r6)
            goto Laf
        Lad:
            r6.pos = r8
        Laf:
            if (r1 != 0) goto Lb5
            okio.Segment r6 = r14.head
            if (r6 != 0) goto L12
        Lb5:
            long r1 = r14.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.setSize$okio(r1)
            return r4
        Lbf:
            java.io.EOFException r14 = new java.io.EOFException
            r14.<init>()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final int commonReadInt(Buffer buffer) throws EOFException {
        C3921.m12667(buffer, "$this$commonReadInt");
        if (buffer.size() < 4) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C3921.m12675();
        }
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return (buffer.readByte() & ExifInterface.MARKER) | ((buffer.readByte() & ExifInterface.MARKER) << 24) | ((buffer.readByte() & ExifInterface.MARKER) << 16) | ((buffer.readByte() & ExifInterface.MARKER) << 8);
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & ExifInterface.MARKER) << 24) | ((bArr[i3] & ExifInterface.MARKER) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & ExifInterface.MARKER) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & ExifInterface.MARKER);
        buffer.setSize$okio(buffer.size() - 4);
        if (i8 == i2) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i8;
        }
        return i9;
    }

    public static final long commonReadLong(Buffer buffer) throws EOFException {
        C3921.m12667(buffer, "$this$commonReadLong");
        if (buffer.size() < 8) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C3921.m12675();
        }
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((buffer.readInt() & 4294967295L) << 32) | (4294967295L & buffer.readInt());
        }
        byte[] bArr = segment.data;
        long j = (bArr[i] & 255) << 56;
        int i3 = i + 1 + 1 + 1;
        long j2 = j | ((bArr[r7] & 255) << 48) | ((bArr[r1] & 255) << 40);
        long j3 = j2 | ((bArr[i3] & 255) << 32) | ((bArr[r1] & 255) << 24);
        long j4 = j3 | ((bArr[r8] & 255) << 16);
        long j5 = j4 | ((bArr[r1] & 255) << 8);
        int i4 = i3 + 1 + 1 + 1 + 1 + 1;
        long j6 = j5 | (bArr[r8] & 255);
        buffer.setSize$okio(buffer.size() - 8);
        if (i4 == i2) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return j6;
    }

    public static final short commonReadShort(Buffer buffer) throws EOFException {
        C3921.m12667(buffer, "$this$commonReadShort");
        if (buffer.size() < 2) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C3921.m12675();
        }
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) ((buffer.readByte() & ExifInterface.MARKER) | ((buffer.readByte() & ExifInterface.MARKER) << 8));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & ExifInterface.MARKER) << 8) | (bArr[i3] & ExifInterface.MARKER);
        buffer.setSize$okio(buffer.size() - 2);
        if (i4 == i2) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return (short) i5;
    }

    public static final String commonReadUtf8(Buffer buffer, long j) throws EOFException {
        C3921.m12667(buffer, "$this$commonReadUtf8");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (buffer.size() < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C3921.m12675();
        }
        int i = segment.pos;
        if (i + j > segment.limit) {
            return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j), 0, 0, 3, null);
        }
        int i2 = (int) j;
        String strCommonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i, i + i2);
        segment.pos += i2;
        buffer.setSize$okio(buffer.size() - j);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return strCommonToUtf8String;
    }

    public static final int commonReadUtf8CodePoint(Buffer buffer) throws EOFException {
        int i;
        int i2;
        int i3;
        C3921.m12667(buffer, "$this$commonReadUtf8CodePoint");
        if (buffer.size() == 0) {
            throw new EOFException();
        }
        byte b = buffer.getByte(0L);
        if ((b & BER.ASN_LONG_LEN) == 0) {
            i = b & Byte.MAX_VALUE;
            i3 = 0;
            i2 = 1;
        } else if ((b & 224) == 192) {
            i = b & 31;
            i2 = 2;
            i3 = 128;
        } else if ((b & 240) == 224) {
            i = b & cb.m;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((b & 248) != 240) {
                buffer.skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i = b & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (buffer.size() < j) {
            throw new EOFException("size < " + i2 + ": " + buffer.size() + " (to read code point prefixed 0x" + Util.toHexString(b) + ')');
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b2 = buffer.getByte(j2);
            if ((b2 & 192) != 128) {
                buffer.skip(j2);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i = (i << 6) | (b2 & Utf8.REPLACEMENT_BYTE);
        }
        buffer.skip(j);
        return i > 1114111 ? Utf8.REPLACEMENT_CODE_POINT : ((55296 <= i && 57343 >= i) || i < i3) ? Utf8.REPLACEMENT_CODE_POINT : i;
    }

    public static final String commonReadUtf8Line(Buffer buffer) {
        C3921.m12667(buffer, "$this$commonReadUtf8Line");
        long jIndexOf = buffer.indexOf((byte) 10);
        if (jIndexOf != -1) {
            return readUtf8Line(buffer, jIndexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(Buffer buffer, long j) throws EOFException {
        C3921.m12667(buffer, "$this$commonReadUtf8LineStrict");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        byte b = (byte) 10;
        long jIndexOf = buffer.indexOf(b, 0L, j2);
        if (jIndexOf != -1) {
            return readUtf8Line(buffer, jIndexOf);
        }
        if (j2 < buffer.size() && buffer.getByte(j2 - 1) == ((byte) 13) && buffer.getByte(j2) == b) {
            return readUtf8Line(buffer, j2);
        }
        Buffer buffer2 = new Buffer();
        buffer.copyTo(buffer2, 0L, Math.min(32, buffer.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), j) + " content=" + buffer2.readByteString().hex() + (char) 8230);
    }

    public static final int commonSelect(Buffer buffer, Options options) throws EOFException {
        C3921.m12667(buffer, "$this$commonSelect");
        C3921.m12667(options, "options");
        int iSelectPrefix$default = selectPrefix$default(buffer, options, false, 2, null);
        if (iSelectPrefix$default == -1) {
            return -1;
        }
        buffer.skip(options.getByteStrings$okio()[iSelectPrefix$default].size());
        return iSelectPrefix$default;
    }

    public static final void commonSkip(Buffer buffer, long j) throws EOFException {
        C3921.m12667(buffer, "$this$commonSkip");
        while (j > 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, segment.limit - segment.pos);
            long j2 = iMin;
            buffer.setSize$okio(buffer.size() - j2);
            j -= j2;
            int i = segment.pos + iMin;
            segment.pos = i;
            if (i == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public static final ByteString commonSnapshot(Buffer buffer) {
        C3921.m12667(buffer, "$this$commonSnapshot");
        if (buffer.size() <= ((long) Integer.MAX_VALUE)) {
            return buffer.snapshot((int) buffer.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + buffer.size()).toString());
    }

    public static final Segment commonWritableSegment(Buffer buffer, int i) {
        C3921.m12667(buffer, "$this$commonWritableSegment");
        if (!(i >= 1 && i <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        Segment segment = buffer.head;
        if (segment == null) {
            Segment segmentTake = SegmentPool.take();
            buffer.head = segmentTake;
            segmentTake.prev = segmentTake;
            segmentTake.next = segmentTake;
            return segmentTake;
        }
        if (segment == null) {
            C3921.m12675();
        }
        Segment segment2 = segment.prev;
        if (segment2 == null) {
            C3921.m12675();
        }
        return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
    }

    public static final Buffer commonWrite(Buffer buffer, ByteString byteString, int i, int i2) {
        C3921.m12667(buffer, "$this$commonWrite");
        C3921.m12667(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer buffer, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.size();
        }
        C3921.m12667(buffer, "$this$commonWrite");
        C3921.m12667(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static final long commonWriteAll(Buffer buffer, Source source) throws IOException {
        C3921.m12667(buffer, "$this$commonWriteAll");
        C3921.m12667(source, "source");
        long j = 0;
        while (true) {
            long j2 = source.read(buffer, 8192);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    public static final Buffer commonWriteByte(Buffer buffer, int i) {
        C3921.m12667(buffer, "$this$commonWriteByte");
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    public static final Buffer commonWriteDecimalLong(Buffer buffer, long j) {
        int i;
        C3921.m12667(buffer, "$this$commonWriteDecimalLong");
        if (j == 0) {
            return buffer.writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return buffer.writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j < 100000000) {
            if (j >= 10000) {
                i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
            } else if (j >= 100) {
                i = j < 1000 ? 3 : 4;
            } else if (j >= 10) {
                i2 = 2;
            }
            i2 = i;
        } else if (j < 1000000000000L) {
            if (j < 10000000000L) {
                i2 = j < 1000000000 ? 9 : 10;
            } else {
                i = j < 100000000000L ? 11 : 12;
                i2 = i;
            }
        } else if (j >= 1000000000000000L) {
            i2 = j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j < 10000000000000L) {
            i2 = 13;
        } else {
            i = j < 100000000000000L ? 14 : 15;
            i2 = i;
        }
        if (z) {
            i2++;
        }
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i3 = segmentWritableSegment$okio.limit + i2;
        while (j != 0) {
            long j2 = 10;
            i3--;
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i3 - 1] = (byte) 45;
        }
        segmentWritableSegment$okio.limit += i2;
        buffer.setSize$okio(buffer.size() + i2);
        return buffer;
    }

    public static final Buffer commonWriteHexadecimalUnsignedLong(Buffer buffer, long j) {
        C3921.m12667(buffer, "$this$commonWriteHexadecimalUnsignedLong");
        if (j == 0) {
            return buffer.writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        segmentWritableSegment$okio.limit += i;
        buffer.setSize$okio(buffer.size() + i);
        return buffer;
    }

    public static final Buffer commonWriteInt(Buffer buffer, int i) {
        C3921.m12667(buffer, "$this$commonWriteInt");
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(4);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i5 + 1;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    public static final Buffer commonWriteLong(Buffer buffer, long j) {
        C3921.m12667(buffer, "$this$commonWriteLong");
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(8);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i = segmentWritableSegment$okio.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        segmentWritableSegment$okio.limit = i8 + 1;
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    public static final Buffer commonWriteShort(Buffer buffer, int i) {
        C3921.m12667(buffer, "$this$commonWriteShort");
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i3 + 1;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    public static final Buffer commonWriteUtf8(Buffer buffer, String str, int i, int i2) {
        C3921.m12667(buffer, "$this$commonWriteUtf8");
        C3921.m12667(str, TypedValues.Custom.S_STRING);
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (!(i2 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
        }
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
                byte[] bArr = segmentWritableSegment$okio.data;
                int i3 = segmentWritableSegment$okio.limit - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt;
                while (i4 < iMin) {
                    char cCharAt2 = str.charAt(i4);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i4 + i3] = (byte) cCharAt2;
                    i4++;
                }
                int i5 = segmentWritableSegment$okio.limit;
                int i6 = (i3 + i4) - i5;
                segmentWritableSegment$okio.limit = i5 + i6;
                buffer.setSize$okio(buffer.size() + i6);
                i = i4;
            } else {
                if (cCharAt < 2048) {
                    Segment segmentWritableSegment$okio2 = buffer.writableSegment$okio(2);
                    byte[] bArr2 = segmentWritableSegment$okio2.data;
                    int i7 = segmentWritableSegment$okio2.limit;
                    bArr2[i7] = (byte) ((cCharAt >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((cCharAt & '?') | 128);
                    segmentWritableSegment$okio2.limit = i7 + 2;
                    buffer.setSize$okio(buffer.size() + 2);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    Segment segmentWritableSegment$okio3 = buffer.writableSegment$okio(3);
                    byte[] bArr3 = segmentWritableSegment$okio3.data;
                    int i8 = segmentWritableSegment$okio3.limit;
                    bArr3[i8] = (byte) ((cCharAt >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt & '?') | 128);
                    segmentWritableSegment$okio3.limit = i8 + 3;
                    buffer.setSize$okio(buffer.size() + 3);
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt > 56319 || 56320 > cCharAt3 || 57343 < cCharAt3) {
                        buffer.writeByte(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        Segment segmentWritableSegment$okio4 = buffer.writableSegment$okio(4);
                        byte[] bArr4 = segmentWritableSegment$okio4.data;
                        int i11 = segmentWritableSegment$okio4.limit;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        segmentWritableSegment$okio4.limit = i11 + 4;
                        buffer.setSize$okio(buffer.size() + 4);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return buffer;
    }

    public static final Buffer commonWriteUtf8CodePoint(Buffer buffer, int i) {
        C3921.m12667(buffer, "$this$commonWriteUtf8CodePoint");
        if (i < 128) {
            buffer.writeByte(i);
        } else if (i < 2048) {
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(2);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i2 = segmentWritableSegment$okio.limit;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio.limit = i2 + 2;
            buffer.setSize$okio(buffer.size() + 2);
        } else if (55296 <= i && 57343 >= i) {
            buffer.writeByte(63);
        } else if (i < 65536) {
            Segment segmentWritableSegment$okio2 = buffer.writableSegment$okio(3);
            byte[] bArr2 = segmentWritableSegment$okio2.data;
            int i3 = segmentWritableSegment$okio2.limit;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio2.limit = i3 + 3;
            buffer.setSize$okio(buffer.size() + 3);
        } else {
            if (i > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i));
            }
            Segment segmentWritableSegment$okio3 = buffer.writableSegment$okio(4);
            byte[] bArr3 = segmentWritableSegment$okio3.data;
            int i4 = segmentWritableSegment$okio3.limit;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio3.limit = i4 + 4;
            buffer.setSize$okio(buffer.size() + 4);
        }
        return buffer;
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(Segment segment, int i, byte[] bArr, int i2, int i3) {
        C3921.m12667(segment, "segment");
        C3921.m12667(bArr, "bytes");
        int i4 = segment.limit;
        byte[] bArr2 = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                if (segment == null) {
                    C3921.m12675();
                }
                byte[] bArr3 = segment.data;
                bArr2 = bArr3;
                i = segment.pos;
                i4 = segment.limit;
            }
            if (bArr2[i] != bArr[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static final String readUtf8Line(Buffer buffer, long j) throws EOFException {
        C3921.m12667(buffer, "$this$readUtf8Line");
        if (j > 0) {
            long j2 = j - 1;
            if (buffer.getByte(j2) == ((byte) 13)) {
                String utf8 = buffer.readUtf8(j2);
                buffer.skip(2L);
                return utf8;
            }
        }
        String utf82 = buffer.readUtf8(j);
        buffer.skip(1L);
        return utf82;
    }

    public static final <T> T seek(Buffer buffer, long j, InterfaceC2849<? super Segment, ? super Long, ? extends T> interfaceC2849) {
        C3921.m12667(buffer, "$this$seek");
        C3921.m12667(interfaceC2849, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return interfaceC2849.invoke(null, -1L);
        }
        if (buffer.size() - j < j) {
            long size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                if (segment == null) {
                    C3921.m12675();
                }
                size -= segment.limit - segment.pos;
            }
            return interfaceC2849.invoke(segment, Long.valueOf(size));
        }
        long j2 = 0;
        while (true) {
            long j3 = (segment.limit - segment.pos) + j2;
            if (j3 > j) {
                return interfaceC2849.invoke(segment, Long.valueOf(j2));
            }
            segment = segment.next;
            if (segment == null) {
                C3921.m12675();
            }
            j2 = j3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        if (r19 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0063, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0064, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int selectPrefix(okio.Buffer r17, okio.Options r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 183
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.selectPrefix(okio.Buffer, okio.Options, boolean):int");
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final int commonRead(Buffer buffer, byte[] bArr, int i, int i2) {
        C3921.m12667(buffer, "$this$commonRead");
        C3921.m12667(bArr, "sink");
        Util.checkOffsetAndCount(bArr.length, i, i2);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i2, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i3 = segment.pos;
        C4955.m14726(bArr2, bArr, i, i3, i3 + iMin);
        segment.pos += iMin;
        buffer.setSize$okio(buffer.size() - iMin);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    public static final byte[] commonReadByteArray(Buffer buffer, long j) throws EOFException {
        C3921.m12667(buffer, "$this$commonReadByteArray");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (buffer.size() < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        buffer.readFully(bArr);
        return bArr;
    }

    public static final ByteString commonReadByteString(Buffer buffer, long j) throws EOFException {
        C3921.m12667(buffer, "$this$commonReadByteString");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (buffer.size() < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new ByteString(buffer.readByteArray(j));
        }
        ByteString byteStringSnapshot = buffer.snapshot((int) j);
        buffer.skip(j);
        return byteStringSnapshot;
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] bArr) {
        C3921.m12667(buffer, "$this$commonWrite");
        C3921.m12667(bArr, "source");
        return buffer.write(bArr, 0, bArr.length);
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] bArr, int i, int i2) {
        C3921.m12667(buffer, "$this$commonWrite");
        C3921.m12667(bArr, "source");
        long j = i2;
        Util.checkOffsetAndCount(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
            int iMin = Math.min(i3 - i, 8192 - segmentWritableSegment$okio.limit);
            int i4 = i + iMin;
            C4955.m14726(bArr, segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, i, i4);
            segmentWritableSegment$okio.limit += iMin;
            i = i4;
        }
        buffer.setSize$okio(buffer.size() + j);
        return buffer;
    }

    public static final void commonReadFully(Buffer buffer, Buffer buffer2, long j) throws EOFException {
        C3921.m12667(buffer, "$this$commonReadFully");
        C3921.m12667(buffer2, "sink");
        if (buffer.size() >= j) {
            buffer2.write(buffer, j);
        } else {
            buffer2.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    public static final ByteString commonSnapshot(Buffer buffer, int i) {
        C3921.m12667(buffer, "$this$commonSnapshot");
        if (i == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(buffer.size(), 0L, i);
        Segment segment = buffer.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (segment == null) {
                C3921.m12675();
            }
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        Segment segment2 = buffer.head;
        int i7 = 0;
        while (i2 < i) {
            if (segment2 == null) {
                C3921.m12675();
            }
            bArr[i7] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = segment2.pos;
            segment2.shared = true;
            i7++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    public static final Buffer commonWrite(Buffer buffer, Source source, long j) throws IOException {
        C3921.m12667(buffer, "$this$commonWrite");
        C3921.m12667(source, "source");
        while (j > 0) {
            long j2 = source.read(buffer, j);
            if (j2 == -1) {
                throw new EOFException();
            }
            j -= j2;
        }
        return buffer;
    }

    public static final long commonRead(Buffer buffer, Buffer buffer2, long j) {
        C3921.m12667(buffer, "$this$commonRead");
        C3921.m12667(buffer2, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (buffer.size() == 0) {
            return -1L;
        }
        if (j > buffer.size()) {
            j = buffer.size();
        }
        buffer2.write(buffer, j);
        return j;
    }

    public static final void commonWrite(Buffer buffer, Buffer buffer2, long j) {
        Segment segment;
        C3921.m12667(buffer, "$this$commonWrite");
        C3921.m12667(buffer2, "source");
        if (buffer2 != buffer) {
            Util.checkOffsetAndCount(buffer2.size(), 0L, j);
            while (j > 0) {
                Segment segment2 = buffer2.head;
                if (segment2 == null) {
                    C3921.m12675();
                }
                int i = segment2.limit;
                if (buffer2.head == null) {
                    C3921.m12675();
                }
                if (j < i - r2.pos) {
                    Segment segment3 = buffer.head;
                    if (segment3 != null) {
                        if (segment3 == null) {
                            C3921.m12675();
                        }
                        segment = segment3.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((segment.limit + j) - (segment.shared ? 0 : segment.pos) <= 8192) {
                            Segment segment4 = buffer2.head;
                            if (segment4 == null) {
                                C3921.m12675();
                            }
                            segment4.writeTo(segment, (int) j);
                            buffer2.setSize$okio(buffer2.size() - j);
                            buffer.setSize$okio(buffer.size() + j);
                            return;
                        }
                    }
                    Segment segment5 = buffer2.head;
                    if (segment5 == null) {
                        C3921.m12675();
                    }
                    buffer2.head = segment5.split((int) j);
                }
                Segment segment6 = buffer2.head;
                if (segment6 == null) {
                    C3921.m12675();
                }
                long j2 = segment6.limit - segment6.pos;
                buffer2.head = segment6.pop();
                Segment segment7 = buffer.head;
                if (segment7 == null) {
                    buffer.head = segment6;
                    segment6.prev = segment6;
                    segment6.next = segment6;
                } else {
                    if (segment7 == null) {
                        C3921.m12675();
                    }
                    Segment segment8 = segment7.prev;
                    if (segment8 == null) {
                        C3921.m12675();
                    }
                    segment8.push(segment6).compact();
                }
                buffer2.setSize$okio(buffer2.size() - j2);
                buffer.setSize$okio(buffer.size() + j2);
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static final long commonIndexOf(Buffer buffer, ByteString byteString, long j) {
        long j2 = j;
        C3921.m12667(buffer, "$this$commonIndexOf");
        C3921.m12667(byteString, "bytes");
        boolean z = true;
        if (!(byteString.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j3 = 0;
        if (j2 >= 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                return -1L;
            }
            if (buffer.size() - j2 < j2) {
                long size = buffer.size();
                while (size > j2) {
                    segment = segment.prev;
                    if (segment == null) {
                        C3921.m12675();
                    }
                    size -= segment.limit - segment.pos;
                }
                byte[] bArrInternalArray$okio = byteString.internalArray$okio();
                byte b = bArrInternalArray$okio[0];
                int size2 = byteString.size();
                long size3 = (buffer.size() - size2) + 1;
                while (size < size3) {
                    byte[] bArr = segment.data;
                    int iMin = (int) Math.min(segment.limit, (segment.pos + size3) - size);
                    for (int i = (int) ((segment.pos + j2) - size); i < iMin; i++) {
                        if (bArr[i] == b && rangeEquals(segment, i + 1, bArrInternalArray$okio, 1, size2)) {
                            return (i - segment.pos) + size;
                        }
                    }
                    size += segment.limit - segment.pos;
                    segment = segment.next;
                    if (segment == null) {
                        C3921.m12675();
                    }
                    j2 = size;
                }
                return -1L;
            }
            while (true) {
                long j4 = (segment.limit - segment.pos) + j3;
                if (j4 > j2) {
                    break;
                }
                boolean z2 = z;
                segment = segment.next;
                if (segment == null) {
                    C3921.m12675();
                }
                j3 = j4;
                z = z2;
            }
            byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
            byte b2 = bArrInternalArray$okio2[0];
            int size4 = byteString.size();
            long size5 = (buffer.size() - size4) + 1;
            while (j3 < size5) {
                byte[] bArr2 = segment.data;
                long j5 = j3;
                int iMin2 = (int) Math.min(segment.limit, (segment.pos + size5) - j3);
                for (int i2 = (int) ((segment.pos + j2) - j5); i2 < iMin2; i2++) {
                    if (bArr2[i2] == b2 && rangeEquals(segment, i2 + 1, bArrInternalArray$okio2, 1, size4)) {
                        return (i2 - segment.pos) + j5;
                    }
                }
                j3 = j5 + (segment.limit - segment.pos);
                segment = segment.next;
                if (segment == null) {
                    C3921.m12675();
                }
                j2 = j3;
            }
            return -1L;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
    }
}
