package com.polidea.rxandroidble2.internal;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.RxBleConnection;
import defpackage.C4618;
import defpackage.InterfaceC3628;

/* loaded from: classes2.dex */
public final class DeviceModule_ProvideConnectionStateRelayFactory implements InterfaceC3628<BehaviorRelay<RxBleConnection.RxBleConnectionState>> {
    private static final DeviceModule_ProvideConnectionStateRelayFactory INSTANCE = new DeviceModule_ProvideConnectionStateRelayFactory();

    public static DeviceModule_ProvideConnectionStateRelayFactory create() {
        return INSTANCE;
    }

    public static BehaviorRelay<RxBleConnection.RxBleConnectionState> proxyProvideConnectionStateRelay() {
        return (BehaviorRelay) C4618.m14073(DeviceModule.provideConnectionStateRelay(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public BehaviorRelay<RxBleConnection.RxBleConnectionState> get() {
        return (BehaviorRelay) C4618.m14073(DeviceModule.provideConnectionStateRelay(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
