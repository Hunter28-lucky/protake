package okio;

import defpackage.C3921;
import java.io.EOFException;

/* compiled from: Okio.kt */
/* loaded from: classes2.dex */
final class BlackholeSink implements Sink {
    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws EOFException {
        C3921.m12667(buffer, "source");
        buffer.skip(j);
    }
}
