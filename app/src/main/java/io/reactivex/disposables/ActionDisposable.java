package io.reactivex.disposables;

import defpackage.InterfaceC3809;
import io.reactivex.internal.util.ExceptionHelper;

/* loaded from: classes2.dex */
final class ActionDisposable extends ReferenceDisposable<InterfaceC3809> {
    private static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(InterfaceC3809 interfaceC3809) {
        super(interfaceC3809);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo6296(InterfaceC3809 interfaceC3809) {
        try {
            interfaceC3809.run();
        } catch (Throwable th) {
            throw ExceptionHelper.m7024(th);
        }
    }
}
