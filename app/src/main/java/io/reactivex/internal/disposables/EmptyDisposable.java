package io.reactivex.internal.disposables;

import defpackage.InterfaceC3164;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5053;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5216;

/* loaded from: classes2.dex */
public enum EmptyDisposable implements InterfaceC3164<Object> {
    INSTANCE,
    NEVER;

    public static void complete(InterfaceC5102<?> interfaceC5102) {
        interfaceC5102.onSubscribe(INSTANCE);
        interfaceC5102.onComplete();
    }

    public static void error(Throwable th, InterfaceC5102<?> interfaceC5102) {
        interfaceC5102.onSubscribe(INSTANCE);
        interfaceC5102.onError(th);
    }

    @Override // defpackage.InterfaceC4851
    public void clear() {
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // defpackage.InterfaceC4851
    public boolean isEmpty() {
        return true;
    }

    @Override // defpackage.InterfaceC4851
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // defpackage.InterfaceC4851
    public Object poll() throws Exception {
        return null;
    }

    @Override // defpackage.InterfaceC3460
    /* renamed from: ԩ, reason: contains not printable characters */
    public int mo6310(int i) {
        return i & 2;
    }

    public static void complete(InterfaceC5216<?> interfaceC5216) {
        interfaceC5216.onSubscribe(INSTANCE);
        interfaceC5216.onComplete();
    }

    public static void error(Throwable th, InterfaceC5053 interfaceC5053) {
        interfaceC5053.onSubscribe(INSTANCE);
        interfaceC5053.onError(th);
    }

    public static void complete(InterfaceC5053 interfaceC5053) {
        interfaceC5053.onSubscribe(INSTANCE);
        interfaceC5053.onComplete();
    }

    public static void error(Throwable th, InterfaceC4782<?> interfaceC4782) {
        interfaceC4782.onSubscribe(INSTANCE);
        interfaceC4782.onError(th);
    }

    public static void error(Throwable th, InterfaceC5216<?> interfaceC5216) {
        interfaceC5216.onSubscribe(INSTANCE);
        interfaceC5216.onError(th);
    }
}
