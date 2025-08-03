package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m7018(Throwable th) {
        return ExceptionHelper.m7020(this, th);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Throwable m7019() {
        return ExceptionHelper.m7021(this);
    }
}
