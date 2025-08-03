package okio;

import com.polidea.rxandroidble2.ClientComponent;
import defpackage.C2679;
import defpackage.C3921;
import defpackage.C4184;
import defpackage.InterfaceC4090;
import defpackage.i4;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: AsyncTimeout.kt */
/* loaded from: classes2.dex */
public class AsyncTimeout extends Timeout {
    public static final Companion Companion = new Companion(null);
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    /* compiled from: AsyncTimeout.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C4184 c4184) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
            synchronized (AsyncTimeout.class) {
                for (AsyncTimeout asyncTimeout2 = AsyncTimeout.head; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.next) {
                    if (asyncTimeout2.next == asyncTimeout) {
                        asyncTimeout2.next = asyncTimeout.next;
                        asyncTimeout.next = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void scheduleTimeout(AsyncTimeout asyncTimeout, long j, boolean z) {
            synchronized (AsyncTimeout.class) {
                if (AsyncTimeout.head == null) {
                    AsyncTimeout.head = new AsyncTimeout();
                    new Watchdog().start();
                }
                long jNanoTime = System.nanoTime();
                if (j != 0 && z) {
                    asyncTimeout.timeoutAt = Math.min(j, asyncTimeout.deadlineNanoTime() - jNanoTime) + jNanoTime;
                } else if (j != 0) {
                    asyncTimeout.timeoutAt = j + jNanoTime;
                } else {
                    if (!z) {
                        throw new AssertionError();
                    }
                    asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
                }
                long jRemainingNanos = asyncTimeout.remainingNanos(jNanoTime);
                AsyncTimeout asyncTimeout2 = AsyncTimeout.head;
                if (asyncTimeout2 == null) {
                    C3921.m12675();
                }
                while (asyncTimeout2.next != null) {
                    AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                    if (asyncTimeout3 == null) {
                        C3921.m12675();
                    }
                    if (jRemainingNanos < asyncTimeout3.remainingNanos(jNanoTime)) {
                        break;
                    }
                    asyncTimeout2 = asyncTimeout2.next;
                    if (asyncTimeout2 == null) {
                        C3921.m12675();
                    }
                }
                asyncTimeout.next = asyncTimeout2.next;
                asyncTimeout2.next = asyncTimeout;
                if (asyncTimeout2 == AsyncTimeout.head) {
                    AsyncTimeout.class.notify();
                }
                i4 i4Var = i4.f6762;
            }
        }

        public final AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head;
            if (asyncTimeout == null) {
                C3921.m12675();
            }
            AsyncTimeout asyncTimeout2 = asyncTimeout.next;
            if (asyncTimeout2 == null) {
                long jNanoTime = System.nanoTime();
                AsyncTimeout.class.wait(AsyncTimeout.IDLE_TIMEOUT_MILLIS);
                AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
                if (asyncTimeout3 == null) {
                    C3921.m12675();
                }
                if (asyncTimeout3.next != null || System.nanoTime() - jNanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long jRemainingNanos = asyncTimeout2.remainingNanos(System.nanoTime());
            if (jRemainingNanos > 0) {
                long j = jRemainingNanos / 1000000;
                AsyncTimeout.class.wait(j, (int) (jRemainingNanos - (1000000 * j)));
                return null;
            }
            AsyncTimeout asyncTimeout4 = AsyncTimeout.head;
            if (asyncTimeout4 == null) {
                C3921.m12675();
            }
            asyncTimeout4.next = asyncTimeout2.next;
            asyncTimeout2.next = null;
            return asyncTimeout2;
        }
    }

    /* compiled from: AsyncTimeout.kt */
    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AsyncTimeout asyncTimeoutAwaitTimeout$okio;
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        asyncTimeoutAwaitTimeout$okio = AsyncTimeout.Companion.awaitTimeout$okio();
                        if (asyncTimeoutAwaitTimeout$okio == AsyncTimeout.head) {
                            AsyncTimeout.head = null;
                            return;
                        }
                        i4 i4Var = i4.f6762;
                    }
                    if (asyncTimeoutAwaitTimeout$okio != null) {
                        asyncTimeoutAwaitTimeout$okio.timedOut();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        if (!(!this.inQueue)) {
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        }
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            this.inQueue = true;
            Companion.scheduleTimeout(this, jTimeoutNanos, zHasDeadline);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return Companion.cancelScheduledTimeout(this);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException(ClientComponent.NamedSchedulers.TIMEOUT);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(final Sink sink) {
        C3921.m12667(sink, "sink");
        return new Sink() { // from class: okio.AsyncTimeout.sink.1
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    sink.close();
                    i4 i4Var = i4.f6762;
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e2) {
                    if (!asyncTimeout.exit()) {
                        throw e2;
                    }
                    throw asyncTimeout.access$newTimeoutException(e2);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    sink.flush();
                    i4 i4Var = i4.f6762;
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e2) {
                    if (!asyncTimeout.exit()) {
                        throw e2;
                    }
                    throw asyncTimeout.access$newTimeoutException(e2);
                } finally {
                    asyncTimeout.exit();
                }
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ')';
            }

            @Override // okio.Sink
            public void write(Buffer buffer, long j) throws IOException {
                C3921.m12667(buffer, "source");
                Util.checkOffsetAndCount(buffer.size(), 0L, j);
                while (true) {
                    long j2 = 0;
                    if (j <= 0) {
                        return;
                    }
                    Segment segment = buffer.head;
                    if (segment == null) {
                        C3921.m12675();
                    }
                    while (true) {
                        if (j2 >= 65536) {
                            break;
                        }
                        j2 += segment.limit - segment.pos;
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        } else {
                            segment = segment.next;
                            if (segment == null) {
                                C3921.m12675();
                            }
                        }
                    }
                    AsyncTimeout asyncTimeout = AsyncTimeout.this;
                    asyncTimeout.enter();
                    try {
                        sink.write(buffer, j2);
                        i4 i4Var = i4.f6762;
                        if (asyncTimeout.exit()) {
                            throw asyncTimeout.access$newTimeoutException(null);
                        }
                        j -= j2;
                    } catch (IOException e2) {
                        if (!asyncTimeout.exit()) {
                            throw e2;
                        }
                        throw asyncTimeout.access$newTimeoutException(e2);
                    } finally {
                        asyncTimeout.exit();
                    }
                }
            }

            @Override // okio.Sink
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }
        };
    }

    public final Source source(final Source source) {
        C3921.m12667(source, "source");
        return new Source() { // from class: okio.AsyncTimeout.source.1
            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    source.close();
                    i4 i4Var = i4.f6762;
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e2) {
                    if (!asyncTimeout.exit()) {
                        throw e2;
                    }
                    throw asyncTimeout.access$newTimeoutException(e2);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                C3921.m12667(buffer, "sink");
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    long j2 = source.read(buffer, j);
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                    return j2;
                } catch (IOException e2) {
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(e2);
                    }
                    throw e2;
                } finally {
                    asyncTimeout.exit();
                }
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ')';
            }

            @Override // okio.Source
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }
        };
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(InterfaceC4090<? extends T> interfaceC4090) throws IOException {
        C3921.m12667(interfaceC4090, "block");
        enter();
        try {
            try {
                T tInvoke = interfaceC4090.invoke();
                C2679.m9826(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                C2679.m9825(1);
                return tInvoke;
            } catch (IOException e2) {
                if (exit()) {
                    throw access$newTimeoutException(e2);
                }
                throw e2;
            }
        } catch (Throwable th) {
            C2679.m9826(1);
            exit();
            C2679.m9825(1);
            throw th;
        }
    }
}
