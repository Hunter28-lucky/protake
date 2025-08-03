package defpackage;

import defpackage.C4305;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.ErrorCode;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* compiled from: Http2Reader.kt */
/* renamed from: ҷ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3083 implements Closeable {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final Logger f10958;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final C3084 f10959 = new C3084(null);

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C3085 f10960;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C4305.C4306 f10961;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final BufferedSource f10962;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean f10963;

    /* compiled from: Http2Reader.kt */
    /* renamed from: ҷ$Ϳ, reason: contains not printable characters */
    public static final class C3084 {
        public C3084() {
        }

        public /* synthetic */ C3084(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Logger m10670() {
            return C3083.f10958;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final int m10671(int i, int i2, int i3) throws IOException {
            if ((i2 & 8) != 0) {
                i--;
            }
            if (i3 <= i) {
                return i - i3;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i3 + " > remaining length " + i);
        }
    }

    /* compiled from: Http2Reader.kt */
    /* renamed from: ҷ$Ԩ, reason: contains not printable characters */
    public static final class C3085 implements Source {

        /* renamed from: ԫ, reason: contains not printable characters */
        public int f10964;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public int f10965;

        /* renamed from: ԭ, reason: contains not printable characters */
        public int f10966;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public int f10967;

        /* renamed from: ԯ, reason: contains not printable characters */
        public int f10968;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final BufferedSource f10969;

        public C3085(BufferedSource bufferedSource) {
            C3921.m12667(bufferedSource, "source");
            this.f10969 = bufferedSource;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            C3921.m12667(buffer, "sink");
            while (true) {
                int i = this.f10967;
                if (i != 0) {
                    long j2 = this.f10969.read(buffer, Math.min(j, i));
                    if (j2 == -1) {
                        return -1L;
                    }
                    this.f10967 -= (int) j2;
                    return j2;
                }
                this.f10969.skip(this.f10968);
                this.f10968 = 0;
                if ((this.f10965 & 4) != 0) {
                    return -1L;
                }
                m10673();
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.f10969.timeout();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final int m10672() {
            return this.f10967;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final void m10673() throws IOException {
            int i = this.f10966;
            int iM6263 = i5.m6263(this.f10969);
            this.f10967 = iM6263;
            this.f10964 = iM6263;
            int iM6232 = i5.m6232(this.f10969.readByte(), 255);
            this.f10965 = i5.m6232(this.f10969.readByte(), 255);
            C3084 c3084 = C3083.f10959;
            if (c3084.m10670().isLoggable(Level.FINE)) {
                c3084.m10670().fine(C3700.f12833.m11851(true, this.f10966, this.f10964, iM6232, this.f10965));
            }
            int i2 = this.f10969.readInt() & Integer.MAX_VALUE;
            this.f10966 = i2;
            if (iM6232 == 9) {
                if (i2 != i) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iM6232 + " != TYPE_CONTINUATION");
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final void m10674(int i) {
            this.f10965 = i;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final void m10675(int i) {
            this.f10967 = i;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final void m10676(int i) {
            this.f10964 = i;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final void m10677(int i) {
            this.f10968 = i;
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final void m10678(int i) {
            this.f10966 = i;
        }
    }

    /* compiled from: Http2Reader.kt */
    /* renamed from: ҷ$Ԫ, reason: contains not printable characters */
    public interface InterfaceC3086 {
        /* renamed from: Ϳ */
        void mo8988();

        /* renamed from: ԩ */
        void mo8989(boolean z, int i, int i2, List<C3168> list);

        /* renamed from: Ԫ */
        void mo8990(int i, long j);

        /* renamed from: ԫ */
        void mo8991(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        /* renamed from: Ԭ */
        void mo8992(boolean z, int i, int i2);

        /* renamed from: ԭ */
        void mo8993(int i, int i2, int i3, boolean z);

        /* renamed from: Ԯ */
        void mo8994(int i, ErrorCode errorCode);

        /* renamed from: ԯ */
        void mo8995(boolean z, C4825 c4825);

        /* renamed from: ՠ */
        void mo8996(int i, int i2, List<C3168> list) throws IOException;

        /* renamed from: ֈ */
        void mo8997(int i, ErrorCode errorCode, ByteString byteString);
    }

    static {
        Logger logger = Logger.getLogger(C3700.class.getName());
        C3921.m12663(logger, "Logger.getLogger(Http2::class.java.name)");
        f10958 = logger;
    }

    public C3083(BufferedSource bufferedSource, boolean z) {
        C3921.m12667(bufferedSource, "source");
        this.f10962 = bufferedSource;
        this.f10963 = z;
        C3085 c3085 = new C3085(bufferedSource);
        this.f10960 = c3085;
        this.f10961 = new C4305.C4306(c3085, 4096, 0, 4, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f10962.close();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean m10657(boolean z, InterfaceC3086 interfaceC3086) throws IOException {
        C3921.m12667(interfaceC3086, "handler");
        try {
            this.f10962.require(9L);
            int iM6263 = i5.m6263(this.f10962);
            if (iM6263 > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + iM6263);
            }
            int iM6232 = i5.m6232(this.f10962.readByte(), 255);
            int iM62322 = i5.m6232(this.f10962.readByte(), 255);
            int i = this.f10962.readInt() & Integer.MAX_VALUE;
            Logger logger = f10958;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C3700.f12833.m11851(true, i, iM6263, iM6232, iM62322));
            }
            if (z && iM6232 != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + C3700.f12833.m11850(iM6232));
            }
            switch (iM6232) {
                case 0:
                    m10659(interfaceC3086, iM6263, iM62322, i);
                    return true;
                case 1:
                    m10662(interfaceC3086, iM6263, iM62322, i);
                    return true;
                case 2:
                    m10665(interfaceC3086, iM6263, iM62322, i);
                    return true;
                case 3:
                    m10667(interfaceC3086, iM6263, iM62322, i);
                    return true;
                case 4:
                    m10668(interfaceC3086, iM6263, iM62322, i);
                    return true;
                case 5:
                    m10666(interfaceC3086, iM6263, iM62322, i);
                    return true;
                case 6:
                    m10663(interfaceC3086, iM6263, iM62322, i);
                    return true;
                case 7:
                    m10660(interfaceC3086, iM6263, iM62322, i);
                    return true;
                case 8:
                    m10669(interfaceC3086, iM6263, iM62322, i);
                    return true;
                default:
                    this.f10962.skip(iM6263);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m10658(InterfaceC3086 interfaceC3086) throws IOException {
        C3921.m12667(interfaceC3086, "handler");
        if (this.f10963) {
            if (!m10657(true, interfaceC3086)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        BufferedSource bufferedSource = this.f10962;
        ByteString byteString = C3700.f12829;
        ByteString byteString2 = bufferedSource.readByteString(byteString.size());
        Logger logger = f10958;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(i5.m6247("<< CONNECTION " + byteString2.hex(), new Object[0]));
        }
        if (!C3921.m12662(byteString, byteString2)) {
            throw new IOException("Expected a connection header but was " + byteString2.utf8());
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m10659(InterfaceC3086 interfaceC3086, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z = (i2 & 1) != 0;
        if ((i2 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iM6232 = (i2 & 8) != 0 ? i5.m6232(this.f10962.readByte(), 255) : 0;
        interfaceC3086.mo8991(z, i3, this.f10962, f10959.m10671(i, i2, iM6232));
        this.f10962.skip(iM6232);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m10660(InterfaceC3086 interfaceC3086, int i, int i2, int i3) throws IOException {
        if (i < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + i);
        }
        if (i3 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i4 = this.f10962.readInt();
        int i5 = this.f10962.readInt();
        int i6 = i - 8;
        ErrorCode errorCodeM7849 = ErrorCode.f8228.m7849(i5);
        if (errorCodeM7849 == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + i5);
        }
        ByteString byteString = ByteString.EMPTY;
        if (i6 > 0) {
            byteString = this.f10962.readByteString(i6);
        }
        interfaceC3086.mo8997(i4, errorCodeM7849, byteString);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final List<C3168> m10661(int i, int i2, int i3, int i4) throws IOException {
        this.f10960.m10675(i);
        C3085 c3085 = this.f10960;
        c3085.m10676(c3085.m10672());
        this.f10960.m10677(i2);
        this.f10960.m10674(i3);
        this.f10960.m10678(i4);
        this.f10961.m13439();
        return this.f10961.m13433();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m10662(InterfaceC3086 interfaceC3086, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z = (i2 & 1) != 0;
        int iM6232 = (i2 & 8) != 0 ? i5.m6232(this.f10962.readByte(), 255) : 0;
        if ((i2 & 32) != 0) {
            m10664(interfaceC3086, i3);
            i -= 5;
        }
        interfaceC3086.mo8989(z, i3, -1, m10661(f10959.m10671(i, i2, iM6232), iM6232, i2, i3));
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m10663(InterfaceC3086 interfaceC3086, int i, int i2, int i3) throws IOException {
        if (i != 8) {
            throw new IOException("TYPE_PING length != 8: " + i);
        }
        if (i3 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        interfaceC3086.mo8992((i2 & 1) != 0, this.f10962.readInt(), this.f10962.readInt());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m10664(InterfaceC3086 interfaceC3086, int i) throws IOException {
        int i2 = this.f10962.readInt();
        interfaceC3086.mo8993(i, i2 & Integer.MAX_VALUE, i5.m6232(this.f10962.readByte(), 255) + 1, (((int) 2147483648L) & i2) != 0);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m10665(InterfaceC3086 interfaceC3086, int i, int i2, int i3) throws IOException {
        if (i == 5) {
            if (i3 == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            m10664(interfaceC3086, i3);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + i + " != 5");
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m10666(InterfaceC3086 interfaceC3086, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iM6232 = (i2 & 8) != 0 ? i5.m6232(this.f10962.readByte(), 255) : 0;
        interfaceC3086.mo8996(i3, this.f10962.readInt() & Integer.MAX_VALUE, m10661(f10959.m10671(i - 4, i2, iM6232), iM6232, i2, i3));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m10667(InterfaceC3086 interfaceC3086, int i, int i2, int i3) throws IOException {
        if (i != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i + " != 4");
        }
        if (i3 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i4 = this.f10962.readInt();
        ErrorCode errorCodeM7849 = ErrorCode.f8228.m7849(i4);
        if (errorCodeM7849 != null) {
            interfaceC3086.mo8994(i3, errorCodeM7849);
            return;
        }
        throw new IOException("TYPE_RST_STREAM unexpected error code: " + i4);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m10668(InterfaceC3086 interfaceC3086, int i, int i2, int i3) throws IOException {
        int i4;
        if (i3 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i2 & 1) != 0) {
            if (i != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            interfaceC3086.mo8988();
            return;
        }
        if (i % 6 != 0) {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + i);
        }
        C4825 c4825 = new C4825();
        C3181 c3181M13949 = C4542.m13949(C4542.m13950(0, i), 6);
        int iM10810 = c3181M13949.m10810();
        int iM10811 = c3181M13949.m10811();
        int iM10812 = c3181M13949.m10812();
        if (iM10812 < 0 ? iM10810 >= iM10811 : iM10810 <= iM10811) {
            while (true) {
                int iM6233 = i5.m6233(this.f10962.readShort(), 65535);
                i4 = this.f10962.readInt();
                if (iM6233 != 2) {
                    if (iM6233 == 3) {
                        iM6233 = 4;
                    } else if (iM6233 == 4) {
                        iM6233 = 7;
                        if (i4 < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                    } else if (iM6233 == 5 && (i4 < 16384 || i4 > 16777215)) {
                        break;
                    }
                } else if (i4 != 0 && i4 != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                c4825.m14559(iM6233, i4);
                if (iM10810 == iM10811) {
                    break;
                } else {
                    iM10810 += iM10812;
                }
            }
            throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + i4);
        }
        interfaceC3086.mo8995(false, c4825);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m10669(InterfaceC3086 interfaceC3086, int i, int i2, int i3) throws IOException {
        if (i != 4) {
            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i);
        }
        long jM6234 = i5.m6234(this.f10962.readInt(), 2147483647L);
        if (jM6234 == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        interfaceC3086.mo8990(i3, jM6234);
    }
}
