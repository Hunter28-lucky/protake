package okio;

import defpackage.C3921;
import java.io.IOException;

/* compiled from: ForwardingSource.kt */
/* loaded from: classes2.dex */
public abstract class ForwardingSource implements Source {
    private final Source delegate;

    public ForwardingSource(Source source) {
        C3921.m12667(source, "delegate");
        this.delegate = source;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final Source m7873deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final Source delegate() {
        return this.delegate;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        C3921.m12667(buffer, "sink");
        return this.delegate.read(buffer, j);
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
