package defpackage;

import java.util.Arrays;
import java.util.logging.Logger;
import org.jcodec.containers.mkv.muxer.MKVMuxerTrack;

/* compiled from: TaskLogger.kt */
/* loaded from: classes2.dex */
public final class j1 {
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final String m7070(long j) {
        String str;
        if (j <= -999500000) {
            str = ((j - 500000000) / MKVMuxerTrack.DEFAULT_TIMESCALE) + " s ";
        } else if (j <= -999500) {
            str = ((j - 500000) / 1000000) + " ms";
        } else if (j <= 0) {
            str = ((j - 500) / 1000) + " µs";
        } else if (j < 999500) {
            str = ((j + 500) / 1000) + " µs";
        } else if (j < 999500000) {
            str = ((j + 500000) / 1000000) + " ms";
        } else {
            str = ((j + 500000000) / MKVMuxerTrack.DEFAULT_TIMESCALE) + " s ";
        }
        t tVar = t.f8531;
        String str2 = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        C3921.m12663(str2, "java.lang.String.format(format, *args)");
        return str2;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final void m7071(f1 f1Var, l1 l1Var, String str) {
        Logger loggerM7532 = m1.f7972.m7532();
        StringBuilder sb = new StringBuilder();
        sb.append(l1Var.m7464());
        sb.append(' ');
        t tVar = t.f8531;
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        C3921.m12663(str2, "java.lang.String.format(format, *args)");
        sb.append(str2);
        sb.append(": ");
        sb.append(f1Var.m6030());
        loggerM7532.fine(sb.toString());
    }
}
