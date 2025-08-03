package androidx.core.os;

import defpackage.C2679;
import defpackage.C3921;
import defpackage.InterfaceC4090;

/* compiled from: Trace.kt */
/* loaded from: classes.dex */
public final class TraceKt {
    public static final <T> T trace(String str, InterfaceC4090<? extends T> interfaceC4090) {
        C3921.m12666(str, "sectionName");
        C3921.m12666(interfaceC4090, "block");
        TraceCompat.beginSection(str);
        try {
            return interfaceC4090.invoke();
        } finally {
            C2679.m9826(1);
            TraceCompat.endSection();
            C2679.m9825(1);
        }
    }
}
