package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import defpackage.InterfaceC4815;

/* loaded from: classes.dex */
public final class MetadataBackendRegistry_Factory implements Factory<MetadataBackendRegistry> {
    private final InterfaceC4815<Context> applicationContextProvider;
    private final InterfaceC4815<CreationContextFactory> creationContextFactoryProvider;

    public MetadataBackendRegistry_Factory(InterfaceC4815<Context> interfaceC4815, InterfaceC4815<CreationContextFactory> interfaceC48152) {
        this.applicationContextProvider = interfaceC4815;
        this.creationContextFactoryProvider = interfaceC48152;
    }

    public static MetadataBackendRegistry_Factory create(InterfaceC4815<Context> interfaceC4815, InterfaceC4815<CreationContextFactory> interfaceC48152) {
        return new MetadataBackendRegistry_Factory(interfaceC4815, interfaceC48152);
    }

    public static MetadataBackendRegistry newInstance(Context context, Object obj) {
        return new MetadataBackendRegistry(context, (CreationContextFactory) obj);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public MetadataBackendRegistry get() {
        return newInstance(this.applicationContextProvider.get(), this.creationContextFactoryProvider.get());
    }
}
