package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import defpackage.InterfaceC4815;

/* loaded from: classes.dex */
public final class EventStoreModule_PackageNameFactory implements Factory<String> {
    private final InterfaceC4815<Context> contextProvider;

    public EventStoreModule_PackageNameFactory(InterfaceC4815<Context> interfaceC4815) {
        this.contextProvider = interfaceC4815;
    }

    public static EventStoreModule_PackageNameFactory create(InterfaceC4815<Context> interfaceC4815) {
        return new EventStoreModule_PackageNameFactory(interfaceC4815);
    }

    public static String packageName(Context context) {
        return (String) Preconditions.checkNotNull(EventStoreModule.packageName(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public String get() {
        return packageName(this.contextProvider.get());
    }
}
