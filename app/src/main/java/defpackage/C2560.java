package defpackage;

import java.util.concurrent.CancellationException;

/* compiled from: Channels.common.kt */
/* renamed from: ɍ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2560 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final void m9414(InterfaceC4230<?> interfaceC4230, Throwable th) {
        if (th != null) {
            cancellationExceptionM13589 = th instanceof CancellationException ? (CancellationException) th : null;
            if (cancellationExceptionM13589 == null) {
                cancellationExceptionM13589 = C4396.m13589("Channel was consumed, consumer had failed", th);
            }
        }
        interfaceC4230.mo7331(cancellationExceptionM13589);
    }
}
