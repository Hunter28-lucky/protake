package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import defpackage.InterfaceC4815;

/* loaded from: classes.dex */
public final class TransportRuntime_Factory implements Factory<TransportRuntime> {
    private final InterfaceC4815<Clock> eventClockProvider;
    private final InterfaceC4815<WorkInitializer> initializerProvider;
    private final InterfaceC4815<Scheduler> schedulerProvider;
    private final InterfaceC4815<Uploader> uploaderProvider;
    private final InterfaceC4815<Clock> uptimeClockProvider;

    public TransportRuntime_Factory(InterfaceC4815<Clock> interfaceC4815, InterfaceC4815<Clock> interfaceC48152, InterfaceC4815<Scheduler> interfaceC48153, InterfaceC4815<Uploader> interfaceC48154, InterfaceC4815<WorkInitializer> interfaceC48155) {
        this.eventClockProvider = interfaceC4815;
        this.uptimeClockProvider = interfaceC48152;
        this.schedulerProvider = interfaceC48153;
        this.uploaderProvider = interfaceC48154;
        this.initializerProvider = interfaceC48155;
    }

    public static TransportRuntime_Factory create(InterfaceC4815<Clock> interfaceC4815, InterfaceC4815<Clock> interfaceC48152, InterfaceC4815<Scheduler> interfaceC48153, InterfaceC4815<Uploader> interfaceC48154, InterfaceC4815<WorkInitializer> interfaceC48155) {
        return new TransportRuntime_Factory(interfaceC4815, interfaceC48152, interfaceC48153, interfaceC48154, interfaceC48155);
    }

    public static TransportRuntime newInstance(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        return new TransportRuntime(clock, clock2, scheduler, uploader, workInitializer);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public TransportRuntime get() {
        return newInstance(this.eventClockProvider.get(), this.uptimeClockProvider.get(), this.schedulerProvider.get(), this.uploaderProvider.get(), this.initializerProvider.get());
    }
}
