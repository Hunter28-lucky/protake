package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.Timeout;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import defpackage.AbstractC4585;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ConnectionModule_ProvidesOperationTimeoutConfFactory implements InterfaceC3628<TimeoutConfiguration> {
    private final InterfaceC4461<Timeout> operationTimeoutProvider;
    private final InterfaceC4461<AbstractC4585> timeoutSchedulerProvider;

    public ConnectionModule_ProvidesOperationTimeoutConfFactory(InterfaceC4461<AbstractC4585> interfaceC4461, InterfaceC4461<Timeout> interfaceC44612) {
        this.timeoutSchedulerProvider = interfaceC4461;
        this.operationTimeoutProvider = interfaceC44612;
    }

    public static ConnectionModule_ProvidesOperationTimeoutConfFactory create(InterfaceC4461<AbstractC4585> interfaceC4461, InterfaceC4461<Timeout> interfaceC44612) {
        return new ConnectionModule_ProvidesOperationTimeoutConfFactory(interfaceC4461, interfaceC44612);
    }

    public static TimeoutConfiguration proxyProvidesOperationTimeoutConf(AbstractC4585 abstractC4585, Timeout timeout) {
        return (TimeoutConfiguration) C4618.m14073(ConnectionModule.providesOperationTimeoutConf(abstractC4585, timeout), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public TimeoutConfiguration get() {
        return (TimeoutConfiguration) C4618.m14073(ConnectionModule.providesOperationTimeoutConf(this.timeoutSchedulerProvider.get(), this.operationTimeoutProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
