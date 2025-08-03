package okio;

import defpackage.C3921;
import java.io.IOException;

/* compiled from: ForwardingSink.kt */
/* loaded from: classes2.dex */
public abstract class ForwardingSink implements Sink {
    private final Sink delegate;

    public ForwardingSink(Sink sink) {
        C3921.m12667(sink, "delegate");
        this.delegate = sink;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final Sink m7872deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final Sink delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        C3921.m12667(buffer, "source");
        this.delegate.write(buffer, j);
    }
}
