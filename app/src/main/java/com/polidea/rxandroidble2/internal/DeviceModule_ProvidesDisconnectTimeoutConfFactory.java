package com.polidea.rxandroidble2.internal;

import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import defpackage.AbstractC4585;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class DeviceModule_ProvidesDisconnectTimeoutConfFactory implements InterfaceC3628<TimeoutConfiguration> {
    private final InterfaceC4461<AbstractC4585> timeoutSchedulerProvider;

    public DeviceModule_ProvidesDisconnectTimeoutConfFactory(InterfaceC4461<AbstractC4585> interfaceC4461) {
        this.timeoutSchedulerProvider = interfaceC4461;
    }

    public static DeviceModule_ProvidesDisconnectTimeoutConfFactory create(InterfaceC4461<AbstractC4585> interfaceC4461) {
        return new DeviceModule_ProvidesDisconnectTimeoutConfFactory(interfaceC4461);
    }

    public static TimeoutConfiguration proxyProvidesDisconnectTimeoutConf(AbstractC4585 abstractC4585) {
        return (TimeoutConfiguration) C4618.m14073(DeviceModule.providesDisconnectTimeoutConf(abstractC4585), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public TimeoutConfiguration get() {
        return (TimeoutConfiguration) C4618.m14073(DeviceModule.providesDisconnectTimeoutConf(this.timeoutSchedulerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
