package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import defpackage.InterfaceC4815;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class Uploader_Factory implements Factory<Uploader> {
    private final InterfaceC4815<BackendRegistry> backendRegistryProvider;
    private final InterfaceC4815<ClientHealthMetricsStore> clientHealthMetricsStoreProvider;
    private final InterfaceC4815<Clock> clockProvider;
    private final InterfaceC4815<Context> contextProvider;
    private final InterfaceC4815<EventStore> eventStoreProvider;
    private final InterfaceC4815<Executor> executorProvider;
    private final InterfaceC4815<SynchronizationGuard> guardProvider;
    private final InterfaceC4815<Clock> uptimeClockProvider;
    private final InterfaceC4815<WorkScheduler> workSchedulerProvider;

    public Uploader_Factory(InterfaceC4815<Context> interfaceC4815, InterfaceC4815<BackendRegistry> interfaceC48152, InterfaceC4815<EventStore> interfaceC48153, InterfaceC4815<WorkScheduler> interfaceC48154, InterfaceC4815<Executor> interfaceC48155, InterfaceC4815<SynchronizationGuard> interfaceC48156, InterfaceC4815<Clock> interfaceC48157, InterfaceC4815<Clock> interfaceC48158, InterfaceC4815<ClientHealthMetricsStore> interfaceC48159) {
        this.contextProvider = interfaceC4815;
        this.backendRegistryProvider = interfaceC48152;
        this.eventStoreProvider = interfaceC48153;
        this.workSchedulerProvider = interfaceC48154;
        this.executorProvider = interfaceC48155;
        this.guardProvider = interfaceC48156;
        this.clockProvider = interfaceC48157;
        this.uptimeClockProvider = interfaceC48158;
        this.clientHealthMetricsStoreProvider = interfaceC48159;
    }

    public static Uploader_Factory create(InterfaceC4815<Context> interfaceC4815, InterfaceC4815<BackendRegistry> interfaceC48152, InterfaceC4815<EventStore> interfaceC48153, InterfaceC4815<WorkScheduler> interfaceC48154, InterfaceC4815<Executor> interfaceC48155, InterfaceC4815<SynchronizationGuard> interfaceC48156, InterfaceC4815<Clock> interfaceC48157, InterfaceC4815<Clock> interfaceC48158, InterfaceC4815<ClientHealthMetricsStore> interfaceC48159) {
        return new Uploader_Factory(interfaceC4815, interfaceC48152, interfaceC48153, interfaceC48154, interfaceC48155, interfaceC48156, interfaceC48157, interfaceC48158, interfaceC48159);
    }

    public static Uploader newInstance(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        return new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock, clock2, clientHealthMetricsStore);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public Uploader get() {
        return newInstance(this.contextProvider.get(), this.backendRegistryProvider.get(), this.eventStoreProvider.get(), this.workSchedulerProvider.get(), this.executorProvider.get(), this.guardProvider.get(), this.clockProvider.get(), this.uptimeClockProvider.get(), this.clientHealthMetricsStoreProvider.get());
    }
}
