package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import defpackage.InterfaceC4815;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class DefaultScheduler_Factory implements Factory<DefaultScheduler> {
    private final InterfaceC4815<BackendRegistry> backendRegistryProvider;
    private final InterfaceC4815<EventStore> eventStoreProvider;
    private final InterfaceC4815<Executor> executorProvider;
    private final InterfaceC4815<SynchronizationGuard> guardProvider;
    private final InterfaceC4815<WorkScheduler> workSchedulerProvider;

    public DefaultScheduler_Factory(InterfaceC4815<Executor> interfaceC4815, InterfaceC4815<BackendRegistry> interfaceC48152, InterfaceC4815<WorkScheduler> interfaceC48153, InterfaceC4815<EventStore> interfaceC48154, InterfaceC4815<SynchronizationGuard> interfaceC48155) {
        this.executorProvider = interfaceC4815;
        this.backendRegistryProvider = interfaceC48152;
        this.workSchedulerProvider = interfaceC48153;
        this.eventStoreProvider = interfaceC48154;
        this.guardProvider = interfaceC48155;
    }

    public static DefaultScheduler_Factory create(InterfaceC4815<Executor> interfaceC4815, InterfaceC4815<BackendRegistry> interfaceC48152, InterfaceC4815<WorkScheduler> interfaceC48153, InterfaceC4815<EventStore> interfaceC48154, InterfaceC4815<SynchronizationGuard> interfaceC48155) {
        return new DefaultScheduler_Factory(interfaceC4815, interfaceC48152, interfaceC48153, interfaceC48154, interfaceC48155);
    }

    public static DefaultScheduler newInstance(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        return new DefaultScheduler(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public DefaultScheduler get() {
        return newInstance(this.executorProvider.get(), this.backendRegistryProvider.get(), this.workSchedulerProvider.get(), this.eventStoreProvider.get(), this.guardProvider.get());
    }
}
