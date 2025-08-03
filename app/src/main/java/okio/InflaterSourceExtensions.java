package okio;

import defpackage.C3921;
import java.util.zip.Inflater;

/* compiled from: InflaterSource.kt */
/* renamed from: okio.-InflaterSourceExtensions, reason: invalid class name */
/* loaded from: classes2.dex */
public final class InflaterSourceExtensions {
    public static final InflaterSource inflate(Source source, Inflater inflater) {
        C3921.m12667(source, "$this$inflate");
        C3921.m12667(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source source, Inflater inflater, int i, Object obj) {
        if ((i & 1) != 0) {
            inflater = new Inflater();
        }
        C3921.m12667(source, "$this$inflate");
        C3921.m12667(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }
}
