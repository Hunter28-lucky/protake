package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import defpackage.InterfaceC4815;

/* loaded from: classes.dex */
public final class ProviderOfLazy<T> implements InterfaceC4815<Lazy<T>> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final InterfaceC4815<T> provider;

    private ProviderOfLazy(InterfaceC4815<T> interfaceC4815) {
        this.provider = interfaceC4815;
    }

    public static <T> InterfaceC4815<Lazy<T>> create(InterfaceC4815<T> interfaceC4815) {
        return new ProviderOfLazy((InterfaceC4815) Preconditions.checkNotNull(interfaceC4815));
    }

    @Override // defpackage.InterfaceC4815
    public Lazy<T> get() {
        return DoubleCheck.lazy(this.provider);
    }
}
