package androidx.core.util;

import defpackage.C3921;
import defpackage.InterfaceC4355;
import defpackage.i4;

/* compiled from: Runnable.kt */
/* loaded from: classes.dex */
public final class RunnableKt {
    public static final Runnable asRunnable(InterfaceC4355<? super i4> interfaceC4355) {
        C3921.m12666(interfaceC4355, "<this>");
        return new ContinuationRunnable(interfaceC4355);
    }
}
