package okio;

import defpackage.C3921;
import java.util.zip.Deflater;

/* compiled from: DeflaterSink.kt */
/* renamed from: okio.-DeflaterSinkExtensions, reason: invalid class name */
/* loaded from: classes2.dex */
public final class DeflaterSinkExtensions {
    public static final DeflaterSink deflate(Sink sink, Deflater deflater) {
        C3921.m12667(sink, "$this$deflate");
        C3921.m12667(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink sink, Deflater deflater, int i, Object obj) {
        if ((i & 1) != 0) {
            deflater = new Deflater();
        }
        C3921.m12667(sink, "$this$deflate");
        C3921.m12667(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }
}
