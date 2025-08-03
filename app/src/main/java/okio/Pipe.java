package okio;

import defpackage.C2679;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.i4;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;

/* compiled from: Pipe.kt */
/* loaded from: classes2.dex */
public final class Pipe {
    private final Buffer buffer = new Buffer();
    private boolean canceled;
    private Sink foldedSink;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j) {
        this.maxBufferSize = j;
        if (j >= 1) {
            this.sink = new Sink() { // from class: okio.Pipe.sink.1
                private final Timeout timeout = new Timeout();

                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    synchronized (Pipe.this.getBuffer$okio()) {
                        if (Pipe.this.getSinkClosed$okio()) {
                            return;
                        }
                        Sink foldedSink$okio = Pipe.this.getFoldedSink$okio();
                        if (foldedSink$okio == null) {
                            if (Pipe.this.getSourceClosed$okio() && Pipe.this.getBuffer$okio().size() > 0) {
                                throw new IOException("source is closed");
                            }
                            Pipe.this.setSinkClosed$okio(true);
                            Buffer buffer$okio = Pipe.this.getBuffer$okio();
                            if (buffer$okio == null) {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                            }
                            buffer$okio.notifyAll();
                            foldedSink$okio = null;
                        }
                        i4 i4Var = i4.f6762;
                        if (foldedSink$okio != null) {
                            Pipe pipe = Pipe.this;
                            Timeout timeout = foldedSink$okio.timeout();
                            Timeout timeout2 = pipe.sink().timeout();
                            long jTimeoutNanos = timeout.timeoutNanos();
                            long jMinTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            timeout.timeout(jMinTimeout, timeUnit);
                            if (!timeout.hasDeadline()) {
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                                }
                                try {
                                    foldedSink$okio.close();
                                    timeout.timeout(jTimeoutNanos, timeUnit);
                                    if (timeout2.hasDeadline()) {
                                        timeout.clearDeadline();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                                    if (timeout2.hasDeadline()) {
                                        timeout.clearDeadline();
                                    }
                                    throw th;
                                }
                            }
                            long jDeadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink$okio.close();
                                timeout.timeout(jTimeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(jDeadlineNanoTime);
                                }
                            } catch (Throwable th2) {
                                timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(jDeadlineNanoTime);
                                }
                                throw th2;
                            }
                        }
                    }
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() {
                    Sink foldedSink$okio;
                    synchronized (Pipe.this.getBuffer$okio()) {
                        if (!(!Pipe.this.getSinkClosed$okio())) {
                            throw new IllegalStateException("closed".toString());
                        }
                        if (Pipe.this.getCanceled$okio()) {
                            throw new IOException("canceled");
                        }
                        foldedSink$okio = Pipe.this.getFoldedSink$okio();
                        if (foldedSink$okio == null) {
                            if (Pipe.this.getSourceClosed$okio() && Pipe.this.getBuffer$okio().size() > 0) {
                                throw new IOException("source is closed");
                            }
                            foldedSink$okio = null;
                        }
                        i4 i4Var = i4.f6762;
                    }
                    if (foldedSink$okio != null) {
                        Pipe pipe = Pipe.this;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe.sink().timeout();
                        long jTimeoutNanos = timeout.timeoutNanos();
                        long jMinTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(jMinTimeout, timeUnit);
                        if (!timeout.hasDeadline()) {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink$okio.flush();
                                timeout.timeout(jTimeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                                throw th;
                            }
                        }
                        long jDeadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            foldedSink$okio.flush();
                            timeout.timeout(jTimeoutNanos, timeUnit);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(jDeadlineNanoTime);
                            }
                        } catch (Throwable th2) {
                            timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(jDeadlineNanoTime);
                            }
                            throw th2;
                        }
                    }
                }

                @Override // okio.Sink
                public Timeout timeout() {
                    return this.timeout;
                }

                /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
                
                    r1 = defpackage.i4.f6762;
                 */
                @Override // okio.Sink
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void write(okio.Buffer r13, long r14) {
                    /*
                        Method dump skipped, instructions count: 319
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: okio.Pipe.AnonymousClass1.write(okio.Buffer, long):void");
                }
            };
            this.source = new Source() { // from class: okio.Pipe.source.1
                private final Timeout timeout = new Timeout();

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    synchronized (Pipe.this.getBuffer$okio()) {
                        Pipe.this.setSourceClosed$okio(true);
                        Buffer buffer$okio = Pipe.this.getBuffer$okio();
                        if (buffer$okio == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                        }
                        buffer$okio.notifyAll();
                        i4 i4Var = i4.f6762;
                    }
                }

                @Override // okio.Source
                public long read(Buffer buffer, long j2) {
                    C3921.m12667(buffer, "sink");
                    synchronized (Pipe.this.getBuffer$okio()) {
                        if (!(!Pipe.this.getSourceClosed$okio())) {
                            throw new IllegalStateException("closed".toString());
                        }
                        if (Pipe.this.getCanceled$okio()) {
                            throw new IOException("canceled");
                        }
                        while (Pipe.this.getBuffer$okio().size() == 0) {
                            if (Pipe.this.getSinkClosed$okio()) {
                                return -1L;
                            }
                            this.timeout.waitUntilNotified(Pipe.this.getBuffer$okio());
                            if (Pipe.this.getCanceled$okio()) {
                                throw new IOException("canceled");
                            }
                        }
                        long j3 = Pipe.this.getBuffer$okio().read(buffer, j2);
                        Buffer buffer$okio = Pipe.this.getBuffer$okio();
                        if (buffer$okio == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                        }
                        buffer$okio.notifyAll();
                        return j3;
                    }
                }

                @Override // okio.Source
                public Timeout timeout() {
                    return this.timeout;
                }
            };
        } else {
            throw new IllegalArgumentException(("maxBufferSize < 1: " + j).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forward(Sink sink, InterfaceC2392<? super Sink, i4> interfaceC2392) {
        Timeout timeout = sink.timeout();
        Timeout timeout2 = sink().timeout();
        long jTimeoutNanos = timeout.timeoutNanos();
        long jMinTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(jMinTimeout, timeUnit);
        if (!timeout.hasDeadline()) {
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                interfaceC2392.invoke(sink);
                C2679.m9826(1);
                timeout.timeout(jTimeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                C2679.m9825(1);
                return;
            } catch (Throwable th) {
                C2679.m9826(1);
                timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                C2679.m9825(1);
                throw th;
            }
        }
        long jDeadlineNanoTime = timeout.deadlineNanoTime();
        if (timeout2.hasDeadline()) {
            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
        }
        try {
            interfaceC2392.invoke(sink);
            C2679.m9826(1);
            timeout.timeout(jTimeoutNanos, timeUnit);
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(jDeadlineNanoTime);
            }
            C2679.m9825(1);
        } catch (Throwable th2) {
            C2679.m9826(1);
            timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(jDeadlineNanoTime);
            }
            C2679.m9825(1);
            throw th2;
        }
    }

    /* renamed from: -deprecated_sink, reason: not valid java name */
    public final Sink m7878deprecated_sink() {
        return this.sink;
    }

    /* renamed from: -deprecated_source, reason: not valid java name */
    public final Source m7879deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        synchronized (this.buffer) {
            this.canceled = true;
            this.buffer.clear();
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
            }
            buffer.notifyAll();
            i4 i4Var = i4.f6762;
        }
    }

    public final void fold(Sink sink) throws IOException {
        boolean z;
        Buffer buffer;
        C3921.m12667(sink, "sink");
        while (true) {
            synchronized (this.buffer) {
                if (!(this.foldedSink == null)) {
                    throw new IllegalStateException("sink already folded".toString());
                }
                if (this.canceled) {
                    this.foldedSink = sink;
                    throw new IOException("canceled");
                }
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    return;
                }
                z = this.sinkClosed;
                buffer = new Buffer();
                Buffer buffer2 = this.buffer;
                buffer.write(buffer2, buffer2.size());
                Buffer buffer3 = this.buffer;
                if (buffer3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                }
                buffer3.notifyAll();
                i4 i4Var = i4.f6762;
            }
            try {
                sink.write(buffer, buffer.size());
                if (z) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th) {
                synchronized (this.buffer) {
                    this.sourceClosed = true;
                    Buffer buffer4 = this.buffer;
                    if (buffer4 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                    }
                    buffer4.notifyAll();
                    i4 i4Var2 = i4.f6762;
                    throw th;
                }
            }
        }
    }

    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z) {
        this.canceled = z;
    }

    public final void setFoldedSink$okio(Sink sink) {
        this.foldedSink = sink;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
