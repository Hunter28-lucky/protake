package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import defpackage.InterfaceC4815;

/* loaded from: classes.dex */
public final class SchedulingConfigModule_ConfigFactory implements Factory<SchedulerConfig> {
    private final InterfaceC4815<Clock> clockProvider;

    public SchedulingConfigModule_ConfigFactory(InterfaceC4815<Clock> interfaceC4815) {
        this.clockProvider = interfaceC4815;
    }

    public static SchedulerConfig config(Clock clock) {
        return (SchedulerConfig) Preconditions.checkNotNull(SchedulingConfigModule.config(clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static SchedulingConfigModule_ConfigFactory create(InterfaceC4815<Clock> interfaceC4815) {
        return new SchedulingConfigModule_ConfigFactory(interfaceC4815);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public SchedulerConfig get() {
        return config(this.clockProvider.get());
    }
}
