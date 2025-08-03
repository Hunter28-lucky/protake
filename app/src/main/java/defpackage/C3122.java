package defpackage;

import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* compiled from: FaultHidingSink.kt */
/* renamed from: ӭ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3122 extends ForwardingSink {

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f11111;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2392<IOException, i4> f11112;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C3122(Sink sink, InterfaceC2392<? super IOException, i4> interfaceC2392) {
        super(sink);
        C3921.m12667(sink, "delegate");
        C3921.m12667(interfaceC2392, "onException");
        this.f11112 = interfaceC2392;
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f11111) {
            return;
        }
        try {
            super.close();
        } catch (IOException e2) {
            this.f11111 = true;
            this.f11112.invoke(e2);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (this.f11111) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e2) {
            this.f11111 = true;
            this.f11112.invoke(e2);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer buffer, long j) throws EOFException {
        C3921.m12667(buffer, "source");
        if (this.f11111) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException e2) {
            this.f11111 = true;
            this.f11112.invoke(e2);
        }
    }
}
