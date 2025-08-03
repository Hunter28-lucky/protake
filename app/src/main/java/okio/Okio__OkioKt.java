package okio;

import defpackage.C3921;

/* compiled from: Okio.kt */
/* loaded from: classes2.dex */
final /* synthetic */ class Okio__OkioKt {
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    public static final BufferedSource buffer(Source source) {
        C3921.m12667(source, "$this$buffer");
        return new RealBufferedSource(source);
    }

    public static final BufferedSink buffer(Sink sink) {
        C3921.m12667(sink, "$this$buffer");
        return new RealBufferedSink(sink);
    }
}
