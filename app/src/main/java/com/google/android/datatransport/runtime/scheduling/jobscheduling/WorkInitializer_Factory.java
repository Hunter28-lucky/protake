package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import defpackage.InterfaceC4815;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class WorkInitializer_Factory implements Factory<WorkInitializer> {
    private final InterfaceC4815<Executor> executorProvider;
    private final InterfaceC4815<SynchronizationGuard> guardProvider;
    private final InterfaceC4815<WorkScheduler> schedulerProvider;
    private final InterfaceC4815<EventStore> storeProvider;

    public WorkInitializer_Factory(InterfaceC4815<Executor> interfaceC4815, InterfaceC4815<EventStore> interfaceC48152, InterfaceC4815<WorkScheduler> interfaceC48153, InterfaceC4815<SynchronizationGuard> interfaceC48154) {
        this.executorProvider = interfaceC4815;
        this.storeProvider = interfaceC48152;
        this.schedulerProvider = interfaceC48153;
        this.guardProvider = interfaceC48154;
    }

    public static WorkInitializer_Factory create(InterfaceC4815<Executor> interfaceC4815, InterfaceC4815<EventStore> interfaceC48152, InterfaceC4815<WorkScheduler> interfaceC48153, InterfaceC4815<SynchronizationGuard> interfaceC48154) {
        return new WorkInitializer_Factory(interfaceC4815, interfaceC48152, interfaceC48153, interfaceC48154);
    }

    public static WorkInitializer newInstance(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        return new WorkInitializer(executor, eventStore, workScheduler, synchronizationGuard);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public WorkInitializer get() {
        return newInstance(this.executorProvider.get(), this.storeProvider.get(), this.schedulerProvider.get(), this.guardProvider.get());
    }
}
