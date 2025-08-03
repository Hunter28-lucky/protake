package defpackage;

import com.polidea.rxandroidble2.ClientComponent;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.TypeCastException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* compiled from: Http2Stream.kt */
/* renamed from: ଦ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4419 {

    /* renamed from: ހ, reason: contains not printable characters */
    public static final C4420 f15235 = new C4420(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public long f15236;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public long f15237;

    /* renamed from: ԩ, reason: contains not printable characters */
    public long f15238;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public long f15239;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final ArrayDeque<C5207> f15240;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f15241;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final C4422 f15242;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final C4421 f15243;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final C4423 f15244;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final C4423 f15245;

    /* renamed from: ֈ, reason: contains not printable characters */
    public ErrorCode f15246;

    /* renamed from: ֏, reason: contains not printable characters */
    public IOException f15247;

    /* renamed from: ׯ, reason: contains not printable characters */
    public final int f15248;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final C2426 f15249;

    /* compiled from: Http2Stream.kt */
    /* renamed from: ଦ$Ϳ, reason: contains not printable characters */
    public static final class C4420 {
        public C4420() {
        }

        public /* synthetic */ C4420(C4184 c4184) {
            this();
        }
    }

    /* compiled from: Http2Stream.kt */
    /* renamed from: ଦ$Ԩ, reason: contains not printable characters */
    public final class C4421 implements Sink {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Buffer f15250 = new Buffer();

        /* renamed from: Ԭ, reason: contains not printable characters */
        public C5207 f15251;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f15252;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f15253;

        public C4421(boolean z) {
            this.f15253 = z;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C4419 c4419 = C4419.this;
            if (i5.f6770 && Thread.holdsLock(c4419)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                C3921.m12663(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(c4419);
                throw new AssertionError(sb.toString());
            }
            synchronized (C4419.this) {
                if (this.f15252) {
                    return;
                }
                boolean z = C4419.this.m13620() == null;
                i4 i4Var = i4.f6762;
                if (!C4419.this.m13627().f15253) {
                    boolean z2 = this.f15250.size() > 0;
                    if (this.f15251 != null) {
                        while (this.f15250.size() > 0) {
                            m13644(false);
                        }
                        C2426 c2426M13619 = C4419.this.m13619();
                        int iM13622 = C4419.this.m13622();
                        C5207 c5207 = this.f15251;
                        if (c5207 == null) {
                            C3921.m12675();
                        }
                        c2426M13619.m8969(iM13622, z, i5.m6267(c5207));
                    } else if (z2) {
                        while (this.f15250.size() > 0) {
                            m13644(true);
                        }
                    } else if (z) {
                        C4419.this.m13619().m8968(C4419.this.m13622(), true, null, 0L);
                    }
                }
                synchronized (C4419.this) {
                    this.f15252 = true;
                    i4 i4Var2 = i4.f6762;
                }
                C4419.this.m13619().flush();
                C4419.this.m13614();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            C4419 c4419 = C4419.this;
            if (i5.f6770 && Thread.holdsLock(c4419)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                C3921.m12663(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(c4419);
                throw new AssertionError(sb.toString());
            }
            synchronized (C4419.this) {
                C4419.this.m13615();
                i4 i4Var = i4.f6762;
            }
            while (this.f15250.size() > 0) {
                m13644(false);
                C4419.this.m13619().flush();
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return C4419.this.m13631();
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            C3921.m12667(buffer, "source");
            C4419 c4419 = C4419.this;
            if (!i5.f6770 || !Thread.holdsLock(c4419)) {
                this.f15250.write(buffer, j);
                while (this.f15250.size() >= 16384) {
                    m13644(false);
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(c4419);
            throw new AssertionError(sb.toString());
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void m13644(boolean z) throws IOException {
            long jMin;
            boolean z2;
            synchronized (C4419.this) {
                C4419.this.m13631().enter();
                while (C4419.this.m13630() >= C4419.this.m13629() && !this.f15253 && !this.f15252 && C4419.this.m13620() == null) {
                    try {
                        C4419.this.m13642();
                    } finally {
                    }
                }
                C4419.this.m13631().m13653();
                C4419.this.m13615();
                jMin = Math.min(C4419.this.m13629() - C4419.this.m13630(), this.f15250.size());
                C4419 c4419 = C4419.this;
                c4419.m13640(c4419.m13630() + jMin);
                z2 = z && jMin == this.f15250.size() && C4419.this.m13620() == null;
                i4 i4Var = i4.f6762;
            }
            C4419.this.m13631().enter();
            try {
                C4419.this.m13619().m8968(C4419.this.m13622(), z2, this.f15250, jMin);
            } finally {
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean m13645() {
            return this.f15252;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final boolean m13646() {
            return this.f15253;
        }
    }

    /* compiled from: Http2Stream.kt */
    /* renamed from: ଦ$Ԫ, reason: contains not printable characters */
    public final class C4422 implements Source {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Buffer f15255 = new Buffer();

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Buffer f15256 = new Buffer();

        /* renamed from: ԭ, reason: contains not printable characters */
        public C5207 f15257;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f15258;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final long f15259;

        /* renamed from: ՠ, reason: contains not printable characters */
        public boolean f15260;

        public C4422(long j, boolean z) {
            this.f15259 = j;
            this.f15260 = z;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            synchronized (C4419.this) {
                this.f15258 = true;
                size = this.f15256.size();
                this.f15256.clear();
                C4419 c4419 = C4419.this;
                if (c4419 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                }
                c4419.notifyAll();
                i4 i4Var = i4.f6762;
            }
            if (size > 0) {
                m13652(size);
            }
            C4419.this.m13614();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long j2;
            boolean z;
            C3921.m12667(buffer, "sink");
            long j3 = 0;
            if (!(j >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            while (true) {
                IOException iOExceptionM13621 = null;
                synchronized (C4419.this) {
                    C4419.this.m13625().enter();
                    try {
                        if (C4419.this.m13620() != null && (iOExceptionM13621 = C4419.this.m13621()) == null) {
                            ErrorCode errorCodeM13620 = C4419.this.m13620();
                            if (errorCodeM13620 == null) {
                                C3921.m12675();
                            }
                            iOExceptionM13621 = new StreamResetException(errorCodeM13620);
                        }
                        if (this.f15258) {
                            throw new IOException("stream closed");
                        }
                        if (this.f15256.size() > j3) {
                            Buffer buffer2 = this.f15256;
                            j2 = buffer2.read(buffer, Math.min(j, buffer2.size()));
                            C4419 c4419 = C4419.this;
                            c4419.m13639(c4419.m13624() + j2);
                            long jM13624 = C4419.this.m13624() - C4419.this.m13623();
                            if (iOExceptionM13621 == null && jM13624 >= C4419.this.m13619().m8947().m14554() / 2) {
                                C4419.this.m13619().m8973(C4419.this.m13622(), jM13624);
                                C4419 c44192 = C4419.this;
                                c44192.m13638(c44192.m13624());
                            }
                        } else if (this.f15260 || iOExceptionM13621 != null) {
                            j2 = -1;
                        } else {
                            C4419.this.m13642();
                            j2 = -1;
                            z = true;
                            C4419.this.m13625().m13653();
                            i4 i4Var = i4.f6762;
                        }
                        z = false;
                        C4419.this.m13625().m13653();
                        i4 i4Var2 = i4.f6762;
                    } finally {
                    }
                }
                if (!z) {
                    if (j2 != -1) {
                        m13652(j2);
                        return j2;
                    }
                    if (iOExceptionM13621 == null) {
                        return -1L;
                    }
                    throw iOExceptionM13621;
                }
                j3 = 0;
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return C4419.this.m13625();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final boolean m13647() {
            return this.f15258;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean m13648() {
            return this.f15260;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final void m13649(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long size;
            C3921.m12667(bufferedSource, "source");
            C4419 c4419 = C4419.this;
            if (i5.f6770 && Thread.holdsLock(c4419)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                C3921.m12663(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(c4419);
                throw new AssertionError(sb.toString());
            }
            while (j > 0) {
                synchronized (C4419.this) {
                    z = this.f15260;
                    z2 = true;
                    z3 = this.f15256.size() + j > this.f15259;
                    i4 i4Var = i4.f6762;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    C4419.this.m13618(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    bufferedSource.skip(j);
                    return;
                }
                long j2 = bufferedSource.read(this.f15255, j);
                if (j2 == -1) {
                    throw new EOFException();
                }
                j -= j2;
                synchronized (C4419.this) {
                    if (this.f15258) {
                        size = this.f15255.size();
                        this.f15255.clear();
                    } else {
                        if (this.f15256.size() != 0) {
                            z2 = false;
                        }
                        this.f15256.writeAll(this.f15255);
                        if (z2) {
                            C4419 c44192 = C4419.this;
                            if (c44192 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                            }
                            c44192.notifyAll();
                        }
                        size = 0;
                    }
                }
                if (size > 0) {
                    m13652(size);
                }
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final void m13650(boolean z) {
            this.f15260 = z;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final void m13651(C5207 c5207) {
            this.f15257 = c5207;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final void m13652(long j) {
            C4419 c4419 = C4419.this;
            if (!i5.f6770 || !Thread.holdsLock(c4419)) {
                C4419.this.m13619().m8967(j);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(c4419);
            throw new AssertionError(sb.toString());
        }
    }

    /* compiled from: Http2Stream.kt */
    /* renamed from: ଦ$Ԭ, reason: contains not printable characters */
    public final class C4423 extends AsyncTimeout {
        public C4423() {
        }

        @Override // okio.AsyncTimeout
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(ClientComponent.NamedSchedulers.TIMEOUT);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            C4419.this.m13618(ErrorCode.CANCEL);
            C4419.this.m13619().m8962();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void m13653() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }
    }

    public C4419(int i, C2426 c2426, boolean z, boolean z2, C5207 c5207) {
        C3921.m12667(c2426, "connection");
        this.f15248 = i;
        this.f15249 = c2426;
        this.f15239 = c2426.m8948().m14554();
        ArrayDeque<C5207> arrayDeque = new ArrayDeque<>();
        this.f15240 = arrayDeque;
        this.f15242 = new C4422(c2426.m8947().m14554(), z2);
        this.f15243 = new C4421(z);
        this.f15244 = new C4423();
        this.f15245 = new C4423();
        if (c5207 == null) {
            if (!m13632()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!m13632())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(c5207);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m13613(long j) {
        this.f15239 += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m13614() throws IOException {
        boolean z;
        boolean zM13633;
        if (i5.f6770 && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        synchronized (this) {
            z = !this.f15242.m13648() && this.f15242.m13647() && (this.f15243.m13646() || this.f15243.m13645());
            zM13633 = m13633();
            i4 i4Var = i4.f6762;
        }
        if (z) {
            m13616(ErrorCode.CANCEL, null);
        } else {
            if (zM13633) {
                return;
            }
            this.f15249.m8961(this.f15248);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m13615() throws IOException {
        if (this.f15243.m13645()) {
            throw new IOException("stream closed");
        }
        if (this.f15243.m13646()) {
            throw new IOException("stream finished");
        }
        if (this.f15246 != null) {
            IOException iOException = this.f15247;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.f15246;
            if (errorCode == null) {
                C3921.m12675();
            }
            throw new StreamResetException(errorCode);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m13616(ErrorCode errorCode, IOException iOException) throws IOException {
        C3921.m12667(errorCode, "rstStatusCode");
        if (m13617(errorCode, iOException)) {
            this.f15249.m8971(this.f15248, errorCode);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final boolean m13617(ErrorCode errorCode, IOException iOException) {
        if (i5.f6770 && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        synchronized (this) {
            if (this.f15246 != null) {
                return false;
            }
            if (this.f15242.m13648() && this.f15243.m13646()) {
                return false;
            }
            this.f15246 = errorCode;
            this.f15247 = iOException;
            notifyAll();
            i4 i4Var = i4.f6762;
            this.f15249.m8961(this.f15248);
            return true;
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m13618(ErrorCode errorCode) {
        C3921.m12667(errorCode, "errorCode");
        if (m13617(errorCode, null)) {
            this.f15249.m8972(this.f15248, errorCode);
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final C2426 m13619() {
        return this.f15249;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final synchronized ErrorCode m13620() {
        return this.f15246;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final IOException m13621() {
        return this.f15247;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final int m13622() {
        return this.f15248;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final long m13623() {
        return this.f15237;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final long m13624() {
        return this.f15236;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final C4423 m13625() {
        return this.f15244;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final Sink m13626() {
        synchronized (this) {
            if (!(this.f15241 || m13632())) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
            i4 i4Var = i4.f6762;
        }
        return this.f15243;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final C4421 m13627() {
        return this.f15243;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final C4422 m13628() {
        return this.f15242;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final long m13629() {
        return this.f15239;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final long m13630() {
        return this.f15238;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final C4423 m13631() {
        return this.f15245;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final boolean m13632() {
        return this.f15249.m8942() == ((this.f15248 & 1) == 1);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final synchronized boolean m13633() {
        if (this.f15246 != null) {
            return false;
        }
        if ((this.f15242.m13648() || this.f15242.m13647()) && (this.f15243.m13646() || this.f15243.m13645())) {
            if (this.f15241) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final Timeout m13634() {
        return this.f15244;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final void m13635(BufferedSource bufferedSource, int i) throws IOException {
        C3921.m12667(bufferedSource, "source");
        if (!i5.f6770 || !Thread.holdsLock(this)) {
            this.f15242.m13649(bufferedSource, i);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        C3921.m12663(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m13636(C5207 c5207, boolean z) {
        boolean zM13633;
        C3921.m12667(c5207, "headers");
        if (i5.f6770 && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        synchronized (this) {
            if (this.f15241 && z) {
                this.f15242.m13651(c5207);
            } else {
                this.f15241 = true;
                this.f15240.add(c5207);
            }
            if (z) {
                this.f15242.m13650(true);
            }
            zM13633 = m13633();
            notifyAll();
            i4 i4Var = i4.f6762;
        }
        if (zM13633) {
            return;
        }
        this.f15249.m8961(this.f15248);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final synchronized void m13637(ErrorCode errorCode) {
        C3921.m12667(errorCode, "errorCode");
        if (this.f15246 == null) {
            this.f15246 = errorCode;
            notifyAll();
        }
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m13638(long j) {
        this.f15237 = j;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m13639(long j) {
        this.f15236 = j;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m13640(long j) {
        this.f15238 = j;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final synchronized C5207 m13641() throws IOException {
        C5207 c5207RemoveFirst;
        this.f15244.enter();
        while (this.f15240.isEmpty() && this.f15246 == null) {
            try {
                m13642();
            } catch (Throwable th) {
                this.f15244.m13653();
                throw th;
            }
        }
        this.f15244.m13653();
        if (!(!this.f15240.isEmpty())) {
            IOException iOException = this.f15247;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.f15246;
            if (errorCode == null) {
                C3921.m12675();
            }
            throw new StreamResetException(errorCode);
        }
        c5207RemoveFirst = this.f15240.removeFirst();
        C3921.m12663(c5207RemoveFirst, "headersQueue.removeFirst()");
        return c5207RemoveFirst;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final void m13642() throws InterruptedException, InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final Timeout m13643() {
        return this.f15245;
    }
}
