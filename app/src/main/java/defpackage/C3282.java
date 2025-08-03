package defpackage;

import androidx.core.app.NotificationCompat;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import defpackage.C4770;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* compiled from: Exchange.kt */
/* renamed from: כ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3282 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f11480;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final RealConnection f11481;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C2503 f11482;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final AbstractC3415 f11483;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C2611 f11484;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2891 f11485;

    /* compiled from: Exchange.kt */
    /* renamed from: כ$Ϳ, reason: contains not printable characters */
    public final class C3283 extends ForwardingSink {

        /* renamed from: ԫ, reason: contains not printable characters */
        public boolean f11486;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public long f11487;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f11488;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final long f11489;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final /* synthetic */ C3282 f11490;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3283(C3282 c3282, Sink sink, long j) {
            super(sink);
            C3921.m12667(sink, "delegate");
            this.f11490 = c3282;
            this.f11489 = j;
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f11488) {
                return;
            }
            this.f11488 = true;
            long j = this.f11489;
            if (j != -1 && this.f11487 != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                m10976(null);
            } catch (IOException e2) {
                throw m10976(e2);
            }
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e2) {
                throw m10976(e2);
            }
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            C3921.m12667(buffer, "source");
            if (!(!this.f11488)) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.f11489;
            if (j2 == -1 || this.f11487 + j <= j2) {
                try {
                    super.write(buffer, j);
                    this.f11487 += j;
                    return;
                } catch (IOException e2) {
                    throw m10976(e2);
                }
            }
            throw new ProtocolException("expected " + this.f11489 + " bytes but received " + (this.f11487 + j));
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final <E extends IOException> E m10976(E e2) {
            if (this.f11486) {
                return e2;
            }
            this.f11486 = true;
            return (E) this.f11490.m10956(this.f11487, false, true, e2);
        }
    }

    /* compiled from: Exchange.kt */
    /* renamed from: כ$Ԩ, reason: contains not printable characters */
    public final class C3284 extends ForwardingSource {

        /* renamed from: ԫ, reason: contains not printable characters */
        public long f11491;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f11492;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f11493;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f11494;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final long f11495;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final /* synthetic */ C3282 f11496;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3284(C3282 c3282, Source source, long j) {
            super(source);
            C3921.m12667(source, "delegate");
            this.f11496 = c3282;
            this.f11495 = j;
            this.f11492 = true;
            if (j == 0) {
                m10977(null);
            }
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f11494) {
                return;
            }
            this.f11494 = true;
            try {
                super.close();
                m10977(null);
            } catch (IOException e2) {
                throw m10977(e2);
            }
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            C3921.m12667(buffer, "sink");
            if (!(!this.f11494)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long j2 = delegate().read(buffer, j);
                if (this.f11492) {
                    this.f11492 = false;
                    this.f11496.m10964().responseBodyStart(this.f11496.m10962());
                }
                if (j2 == -1) {
                    m10977(null);
                    return -1L;
                }
                long j3 = this.f11491 + j2;
                long j4 = this.f11495;
                if (j4 != -1 && j3 > j4) {
                    throw new ProtocolException("expected " + this.f11495 + " bytes but received " + j3);
                }
                this.f11491 = j3;
                if (j3 == j4) {
                    m10977(null);
                }
                return j2;
            } catch (IOException e2) {
                throw m10977(e2);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final <E extends IOException> E m10977(E e2) {
            if (this.f11493) {
                return e2;
            }
            this.f11493 = true;
            if (e2 == null && this.f11492) {
                this.f11492 = false;
                this.f11496.m10964().responseBodyStart(this.f11496.m10962());
            }
            return (E) this.f11496.m10956(this.f11491, true, false, e2);
        }
    }

    public C3282(C2503 c2503, AbstractC3415 abstractC3415, C2611 c2611, InterfaceC2891 interfaceC2891) {
        C3921.m12667(c2503, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(abstractC3415, "eventListener");
        C3921.m12667(c2611, "finder");
        C3921.m12667(interfaceC2891, "codec");
        this.f11482 = c2503;
        this.f11483 = abstractC3415;
        this.f11484 = c2611;
        this.f11485 = interfaceC2891;
        this.f11481 = interfaceC2891.mo10258();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final <E extends IOException> E m10956(long j, boolean z, boolean z2, E e2) {
        if (e2 != null) {
            m10974(e2);
        }
        if (z2) {
            if (e2 != null) {
                this.f11483.requestFailed(this.f11482, e2);
            } else {
                this.f11483.requestBodyEnd(this.f11482, j);
            }
        }
        if (z) {
            if (e2 != null) {
                this.f11483.responseFailed(this.f11482, e2);
            } else {
                this.f11483.responseBodyEnd(this.f11482, j);
            }
        }
        return (E) this.f11482.m9241(this, z2, z, e2);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m10957() {
        this.f11485.cancel();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Sink m10958(C4539 c4539, boolean z) throws IOException {
        C3921.m12667(c4539, "request");
        this.f11480 = z;
        AbstractC2613 abstractC2613M13916 = c4539.m13916();
        if (abstractC2613M13916 == null) {
            C3921.m12675();
        }
        long jContentLength = abstractC2613M13916.contentLength();
        this.f11483.requestBodyStart(this.f11482);
        return new C3283(this, this.f11485.mo10256(c4539, jContentLength), jContentLength);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m10959() {
        this.f11485.cancel();
        this.f11482.m9241(this, true, true, null);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m10960() throws IOException {
        try {
            this.f11485.mo10254();
        } catch (IOException e2) {
            this.f11483.requestFailed(this.f11482, e2);
            m10974(e2);
            throw e2;
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m10961() throws IOException {
        try {
            this.f11485.mo10259();
        } catch (IOException e2) {
            this.f11483.requestFailed(this.f11482, e2);
            m10974(e2);
            throw e2;
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final C2503 m10962() {
        return this.f11482;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final RealConnection m10963() {
        return this.f11481;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AbstractC3415 m10964() {
        return this.f11483;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final C2611 m10965() {
        return this.f11484;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final boolean m10966() {
        return !C3921.m12662(this.f11484.m9549().m12820().m11532(), this.f11481.m7823().m14511().m12820().m11532());
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final boolean m10967() {
        return this.f11480;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m10968() {
        this.f11485.mo10258().m7822();
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m10969() {
        this.f11482.m9241(this, true, false, null);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final AbstractC4809 m10970(C4770 c4770) throws IOException {
        C3921.m12667(c4770, "response");
        try {
            String strM14329 = C4770.m14329(c4770, HttpHeaders.HEAD_KEY_CONTENT_TYPE, null, 2, null);
            long jMo10255 = this.f11485.mo10255(c4770);
            return new C4829(strM14329, jMo10255, Okio.buffer(new C3284(this, this.f11485.mo10252(c4770), jMo10255)));
        } catch (IOException e2) {
            this.f11483.responseFailed(this.f11482, e2);
            m10974(e2);
            throw e2;
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final C4770.C4771 m10971(boolean z) throws IOException {
        try {
            C4770.C4771 c4771Mo10257 = this.f11485.mo10257(z);
            if (c4771Mo10257 != null) {
                c4771Mo10257.m14360(this);
            }
            return c4771Mo10257;
        } catch (IOException e2) {
            this.f11483.responseFailed(this.f11482, e2);
            m10974(e2);
            throw e2;
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m10972(C4770 c4770) {
        C3921.m12667(c4770, "response");
        this.f11483.responseHeadersEnd(this.f11482, c4770);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m10973() {
        this.f11483.responseHeadersStart(this.f11482);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m10974(IOException iOException) {
        this.f11484.m9553(iOException);
        this.f11485.mo10258().m7830(this.f11482, iOException);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m10975(C4539 c4539) throws IOException {
        C3921.m12667(c4539, "request");
        try {
            this.f11483.requestHeadersStart(this.f11482);
            this.f11485.mo10253(c4539);
            this.f11483.requestHeadersEnd(this.f11482, c4539);
        } catch (IOException e2) {
            this.f11483.requestFailed(this.f11482, e2);
            m10974(e2);
            throw e2;
        }
    }
}
