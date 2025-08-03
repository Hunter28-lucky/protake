package com.google.android.datatransport.runtime.dagger.internal;

import defpackage.InterfaceC4815;

/* loaded from: classes.dex */
public final class SingleCheck<T> implements InterfaceC4815<T> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile InterfaceC4815<T> provider;

    private SingleCheck(InterfaceC4815<T> interfaceC4815) {
        this.provider = interfaceC4815;
    }

    public static <P extends InterfaceC4815<T>, T> InterfaceC4815<T> provider(P p) {
        return ((p instanceof SingleCheck) || (p instanceof DoubleCheck)) ? p : new SingleCheck((InterfaceC4815) Preconditions.checkNotNull(p));
    }

    @Override // defpackage.InterfaceC4815
    public T get() {
        T t = (T) this.instance;
        if (t != UNINITIALIZED) {
            return t;
        }
        InterfaceC4815<T> interfaceC4815 = this.provider;
        if (interfaceC4815 == null) {
            return (T) this.instance;
        }
        T t2 = interfaceC4815.get();
        this.instance = t2;
        this.provider = null;
        return t2;
    }
}
