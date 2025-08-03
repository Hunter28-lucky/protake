package defpackage;

import com.google.android.gms.common.internal.ImagesContract;
import defpackage.C4770;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* compiled from: Http1ExchangeCodec.kt */
/* renamed from: ბ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5249 implements InterfaceC2891 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final C5253 f17385 = new C5253(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f17386;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C2879 f17387;

    /* renamed from: ԩ, reason: contains not printable characters */
    public C5207 f17388;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C5121 f17389;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final RealConnection f17390;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final BufferedSource f17391;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final BufferedSink f17392;

    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: ბ$Ϳ, reason: contains not printable characters */
    public abstract class AbstractC5250 implements Source {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final ForwardingTimeout f17393;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f17394;

        public AbstractC5250() {
            this.f17393 = new ForwardingTimeout(C5249.this.f17391.timeout());
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            C3921.m12667(buffer, "sink");
            try {
                return C5249.this.f17391.read(buffer, j);
            } catch (IOException e2) {
                C5249.this.mo10258().m7822();
                m15297();
                throw e2;
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.f17393;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final boolean m15296() {
            return this.f17394;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final void m15297() {
            if (C5249.this.f17386 == 6) {
                return;
            }
            if (C5249.this.f17386 == 5) {
                C5249.this.m15286(this.f17393);
                C5249.this.f17386 = 6;
            } else {
                throw new IllegalStateException("state: " + C5249.this.f17386);
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final void m15298(boolean z) {
            this.f17394 = z;
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: ბ$Ԩ, reason: contains not printable characters */
    public final class C5251 implements Sink {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final ForwardingTimeout f17396;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f17397;

        public C5251() {
            this.f17396 = new ForwardingTimeout(C5249.this.f17392.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f17397) {
                return;
            }
            this.f17397 = true;
            C5249.this.f17392.writeUtf8("0\r\n\r\n");
            C5249.this.m15286(this.f17396);
            C5249.this.f17386 = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() {
            if (this.f17397) {
                return;
            }
            C5249.this.f17392.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.f17396;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            C3921.m12667(buffer, "source");
            if (!(!this.f17397)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j == 0) {
                return;
            }
            C5249.this.f17392.writeHexadecimalUnsignedLong(j);
            C5249.this.f17392.writeUtf8("\r\n");
            C5249.this.f17392.write(buffer, j);
            C5249.this.f17392.writeUtf8("\r\n");
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: ბ$Ԫ, reason: contains not printable characters */
    public final class C5252 extends AbstractC5250 {

        /* renamed from: Ԯ, reason: contains not printable characters */
        public long f17399;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f17400;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final C3573 f17401;

        /* renamed from: ֈ, reason: contains not printable characters */
        public final /* synthetic */ C5249 f17402;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C5252(C5249 c5249, C3573 c3573) {
            super();
            C3921.m12667(c3573, ImagesContract.URL);
            this.f17402 = c5249;
            this.f17401 = c3573;
            this.f17399 = -1L;
            this.f17400 = true;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (m15296()) {
                return;
            }
            if (this.f17400 && !i5.m6246(this, 100, TimeUnit.MILLISECONDS)) {
                this.f17402.mo10258().m7822();
                m15297();
            }
            m15298(true);
        }

        @Override // defpackage.C5249.AbstractC5250, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            C3921.m12667(buffer, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (!(!m15296())) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.f17400) {
                return -1L;
            }
            long j2 = this.f17399;
            if (j2 == 0 || j2 == -1) {
                m15299();
                if (!this.f17400) {
                    return -1L;
                }
            }
            long j3 = super.read(buffer, Math.min(j, this.f17399));
            if (j3 != -1) {
                this.f17399 -= j3;
                return j3;
            }
            this.f17402.mo10258().m7822();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            m15297();
            throw protocolException;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final void m15299() throws IOException {
            if (this.f17399 != -1) {
                this.f17402.f17391.readUtf8LineStrict();
            }
            try {
                this.f17399 = this.f17402.f17391.readHexadecimalUnsignedLong();
                String utf8LineStrict = this.f17402.f17391.readUtf8LineStrict();
                if (utf8LineStrict == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String string = StringsKt__StringsKt.m7319(utf8LineStrict).toString();
                if (this.f17399 >= 0) {
                    if (!(string.length() > 0) || e0.m5980(string, ";", false, 2, null)) {
                        if (this.f17399 == 0) {
                            this.f17400 = false;
                            C5249 c5249 = this.f17402;
                            c5249.f17388 = c5249.f17387.m10229();
                            C5121 c5121 = this.f17402.f17389;
                            if (c5121 == null) {
                                C3921.m12675();
                            }
                            InterfaceC2896 interfaceC2896M14960 = c5121.m14960();
                            C3573 c3573 = this.f17401;
                            C5207 c5207 = this.f17402.f17388;
                            if (c5207 == null) {
                                C3921.m12675();
                            }
                            C4186.m13209(interfaceC2896M14960, c3573, c5207);
                            m15297();
                            return;
                        }
                        return;
                    }
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f17399 + string + '\"');
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: ბ$Ԭ, reason: contains not printable characters */
    public static final class C5253 {
        public C5253() {
        }

        public /* synthetic */ C5253(C4184 c4184) {
            this();
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: ბ$Ԯ, reason: contains not printable characters */
    public final class C5254 extends AbstractC5250 {

        /* renamed from: Ԯ, reason: contains not printable characters */
        public long f17403;

        public C5254(long j) {
            super();
            this.f17403 = j;
            if (j == 0) {
                m15297();
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (m15296()) {
                return;
            }
            if (this.f17403 != 0 && !i5.m6246(this, 100, TimeUnit.MILLISECONDS)) {
                C5249.this.mo10258().m7822();
                m15297();
            }
            m15298(true);
        }

        @Override // defpackage.C5249.AbstractC5250, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            C3921.m12667(buffer, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (!(!m15296())) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.f17403;
            if (j2 == 0) {
                return -1L;
            }
            long j3 = super.read(buffer, Math.min(j2, j));
            if (j3 == -1) {
                C5249.this.mo10258().m7822();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                m15297();
                throw protocolException;
            }
            long j4 = this.f17403 - j3;
            this.f17403 = j4;
            if (j4 == 0) {
                m15297();
            }
            return j3;
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: ბ$ՠ, reason: contains not printable characters */
    public final class C5255 implements Sink {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final ForwardingTimeout f17405;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f17406;

        public C5255() {
            this.f17405 = new ForwardingTimeout(C5249.this.f17392.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f17406) {
                return;
            }
            this.f17406 = true;
            C5249.this.m15286(this.f17405);
            C5249.this.f17386 = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.f17406) {
                return;
            }
            C5249.this.f17392.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.f17405;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            C3921.m12667(buffer, "source");
            if (!(!this.f17406)) {
                throw new IllegalStateException("closed".toString());
            }
            i5.m6239(buffer.size(), 0L, j);
            C5249.this.f17392.write(buffer, j);
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: ბ$ֈ, reason: contains not printable characters */
    public final class C5256 extends AbstractC5250 {

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f17408;

        public C5256() {
            super();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (m15296()) {
                return;
            }
            if (!this.f17408) {
                m15297();
            }
            m15298(true);
        }

        @Override // defpackage.C5249.AbstractC5250, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            C3921.m12667(buffer, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (!(!m15296())) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.f17408) {
                return -1L;
            }
            long j2 = super.read(buffer, j);
            if (j2 != -1) {
                return j2;
            }
            this.f17408 = true;
            m15297();
            return -1L;
        }
    }

    public C5249(C5121 c5121, RealConnection realConnection, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        C3921.m12667(realConnection, "connection");
        C3921.m12667(bufferedSource, "source");
        C3921.m12667(bufferedSink, "sink");
        this.f17389 = c5121;
        this.f17390 = realConnection;
        this.f17391 = bufferedSource;
        this.f17392 = bufferedSink;
        this.f17387 = new C2879(bufferedSource);
    }

    @Override // defpackage.InterfaceC2891
    public void cancel() throws IOException {
        mo10258().m7801();
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: Ϳ */
    public Source mo10252(C4770 c4770) {
        C3921.m12667(c4770, "response");
        if (!C4186.m13205(c4770)) {
            return m15291(0L);
        }
        if (m15288(c4770)) {
            return m15290(c4770.m14347().m13925());
        }
        long jM6249 = i5.m6249(c4770);
        return jM6249 != -1 ? m15291(jM6249) : m15293();
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: Ԩ */
    public void mo10253(C4539 c4539) {
        C3921.m12667(c4539, "request");
        C3941 c3941 = C3941.f13581;
        Proxy.Type type = mo10258().m7823().m14512().type();
        C3921.m12663(type, "connection.route().proxy.type()");
        m15295(c4539.m13920(), c3941.m12714(c4539, type));
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: ԩ */
    public void mo10254() {
        this.f17392.flush();
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: Ԫ */
    public long mo10255(C4770 c4770) {
        C3921.m12667(c4770, "response");
        if (!C4186.m13205(c4770)) {
            return 0L;
        }
        if (m15288(c4770)) {
            return -1L;
        }
        return i5.m6249(c4770);
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: ԫ */
    public Sink mo10256(C4539 c4539, long j) throws ProtocolException {
        C3921.m12667(c4539, "request");
        if (c4539.m13916() != null && c4539.m13916().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (m15287(c4539)) {
            return m15289();
        }
        if (j != -1) {
            return m15292();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: Ԭ */
    public C4770.C4771 mo10257(boolean z) {
        int i = this.f17386;
        boolean z2 = true;
        if (i != 1 && i != 3) {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalStateException(("state: " + this.f17386).toString());
        }
        try {
            k kVarM7170 = k.f7814.m7170(this.f17387.m10230());
            C4770.C4771 c4771M14359 = new C4770.C4771().m14364(kVarM7170.f7815).m14355(kVarM7170.f7816).m14361(kVarM7170.f7817).m14359(this.f17387.m10229());
            if (z && kVarM7170.f7816 == 100) {
                return null;
            }
            if (kVarM7170.f7816 == 100) {
                this.f17386 = 3;
                return c4771M14359;
            }
            this.f17386 = 4;
            return c4771M14359;
        } catch (EOFException e2) {
            throw new IOException("unexpected end of stream on " + mo10258().m7823().m14511().m12820().m11541(), e2);
        }
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: ԭ */
    public RealConnection mo10258() {
        return this.f17390;
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: Ԯ */
    public void mo10259() throws IOException {
        this.f17392.flush();
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m15286(ForwardingTimeout forwardingTimeout) {
        Timeout timeoutDelegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        timeoutDelegate.clearDeadline();
        timeoutDelegate.clearTimeout();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final boolean m15287(C4539 c4539) {
        return e0.m5967("chunked", c4539.m13919("Transfer-Encoding"), true);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final boolean m15288(C4770 c4770) {
        return e0.m5967("chunked", C4770.m14329(c4770, "Transfer-Encoding", null, 2, null), true);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final Sink m15289() {
        if (this.f17386 == 1) {
            this.f17386 = 2;
            return new C5251();
        }
        throw new IllegalStateException(("state: " + this.f17386).toString());
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final Source m15290(C3573 c3573) {
        if (this.f17386 == 4) {
            this.f17386 = 5;
            return new C5252(this, c3573);
        }
        throw new IllegalStateException(("state: " + this.f17386).toString());
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final Source m15291(long j) {
        if (this.f17386 == 4) {
            this.f17386 = 5;
            return new C5254(j);
        }
        throw new IllegalStateException(("state: " + this.f17386).toString());
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final Sink m15292() {
        if (this.f17386 == 1) {
            this.f17386 = 2;
            return new C5255();
        }
        throw new IllegalStateException(("state: " + this.f17386).toString());
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final Source m15293() {
        if (this.f17386 == 4) {
            this.f17386 = 5;
            mo10258().m7822();
            return new C5256();
        }
        throw new IllegalStateException(("state: " + this.f17386).toString());
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m15294(C4770 c4770) {
        C3921.m12667(c4770, "response");
        long jM6249 = i5.m6249(c4770);
        if (jM6249 == -1) {
            return;
        }
        Source sourceM15291 = m15291(jM6249);
        i5.m6265(sourceM15291, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        sourceM15291.close();
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m15295(C5207 c5207, String str) {
        C3921.m12667(c5207, "headers");
        C3921.m12667(str, "requestLine");
        if (!(this.f17386 == 0)) {
            throw new IllegalStateException(("state: " + this.f17386).toString());
        }
        this.f17392.writeUtf8(str).writeUtf8("\r\n");
        int size = c5207.size();
        for (int i = 0; i < size; i++) {
            this.f17392.writeUtf8(c5207.m15183(i)).writeUtf8(": ").writeUtf8(c5207.m15185(i)).writeUtf8("\r\n");
        }
        this.f17392.writeUtf8("\r\n");
        this.f17386 = 1;
    }
}
