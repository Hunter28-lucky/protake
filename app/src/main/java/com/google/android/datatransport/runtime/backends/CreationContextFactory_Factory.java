package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import defpackage.InterfaceC4815;

/* loaded from: classes.dex */
public final class CreationContextFactory_Factory implements Factory<CreationContextFactory> {
    private final InterfaceC4815<Context> applicationContextProvider;
    private final InterfaceC4815<Clock> monotonicClockProvider;
    private final InterfaceC4815<Clock> wallClockProvider;

    public CreationContextFactory_Factory(InterfaceC4815<Context> interfaceC4815, InterfaceC4815<Clock> interfaceC48152, InterfaceC4815<Clock> interfaceC48153) {
        this.applicationContextProvider = interfaceC4815;
        this.wallClockProvider = interfaceC48152;
        this.monotonicClockProvider = interfaceC48153;
    }

    public static CreationContextFactory_Factory create(InterfaceC4815<Context> interfaceC4815, InterfaceC4815<Clock> interfaceC48152, InterfaceC4815<Clock> interfaceC48153) {
        return new CreationContextFactory_Factory(interfaceC4815, interfaceC48152, interfaceC48153);
    }

    public static CreationContextFactory newInstance(Context context, Clock clock, Clock clock2) {
        return new CreationContextFactory(context, clock, clock2);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public CreationContextFactory get() {
        return newInstance(this.applicationContextProvider.get(), this.wallClockProvider.get(), this.monotonicClockProvider.get());
    }
}
