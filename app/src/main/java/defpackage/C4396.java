package defpackage;

import java.util.concurrent.CancellationException;

/* compiled from: Exceptions.kt */
/* renamed from: ଏ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4396 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final CancellationException m13589(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
