package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import defpackage.InterfaceC4815;

/* loaded from: classes.dex */
public final class SchedulingModule_WorkSchedulerFactory implements Factory<WorkScheduler> {
    private final InterfaceC4815<Clock> clockProvider;
    private final InterfaceC4815<SchedulerConfig> configProvider;
    private final InterfaceC4815<Context> contextProvider;
    private final InterfaceC4815<EventStore> eventStoreProvider;

    public SchedulingModule_WorkSchedulerFactory(InterfaceC4815<Context> interfaceC4815, InterfaceC4815<EventStore> interfaceC48152, InterfaceC4815<SchedulerConfig> interfaceC48153, InterfaceC4815<Clock> interfaceC48154) {
        this.contextProvider = interfaceC4815;
        this.eventStoreProvider = interfaceC48152;
        this.configProvider = interfaceC48153;
        this.clockProvider = interfaceC48154;
    }

    public static SchedulingModule_WorkSchedulerFactory create(InterfaceC4815<Context> interfaceC4815, InterfaceC4815<EventStore> interfaceC48152, InterfaceC4815<SchedulerConfig> interfaceC48153, InterfaceC4815<Clock> interfaceC48154) {
        return new SchedulingModule_WorkSchedulerFactory(interfaceC4815, interfaceC48152, interfaceC48153, interfaceC48154);
    }

    public static WorkScheduler workScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig, Clock clock) {
        return (WorkScheduler) Preconditions.checkNotNull(SchedulingModule.workScheduler(context, eventStore, schedulerConfig, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public WorkScheduler get() {
        return workScheduler(this.contextProvider.get(), this.eventStoreProvider.get(), this.configProvider.get(), this.clockProvider.get());
    }
}
