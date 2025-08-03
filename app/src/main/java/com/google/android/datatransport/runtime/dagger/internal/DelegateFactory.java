package com.google.android.datatransport.runtime.dagger.internal;

import defpackage.InterfaceC4815;

/* loaded from: classes.dex */
public final class DelegateFactory<T> implements Factory<T> {
    private InterfaceC4815<T> delegate;

    public static <T> void setDelegate(InterfaceC4815<T> interfaceC4815, InterfaceC4815<T> interfaceC48152) {
        Preconditions.checkNotNull(interfaceC48152);
        DelegateFactory delegateFactory = (DelegateFactory) interfaceC4815;
        if (delegateFactory.delegate != null) {
            throw new IllegalStateException();
        }
        delegateFactory.delegate = interfaceC48152;
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public T get() {
        InterfaceC4815<T> interfaceC4815 = this.delegate;
        if (interfaceC4815 != null) {
            return interfaceC4815.get();
        }
        throw new IllegalStateException();
    }

    public InterfaceC4815<T> getDelegate() {
        return (InterfaceC4815) Preconditions.checkNotNull(this.delegate);
    }

    @Deprecated
    public void setDelegatedProvider(InterfaceC4815<T> interfaceC4815) {
        setDelegate(this, interfaceC4815);
    }
}
