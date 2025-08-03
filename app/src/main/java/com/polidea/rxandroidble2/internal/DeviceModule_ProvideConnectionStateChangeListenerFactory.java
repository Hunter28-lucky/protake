package com.polidea.rxandroidble2.internal;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class DeviceModule_ProvideConnectionStateChangeListenerFactory implements InterfaceC3628<ConnectionStateChangeListener> {
    private final InterfaceC4461<BehaviorRelay<RxBleConnection.RxBleConnectionState>> connectionStateBehaviorRelayProvider;

    public DeviceModule_ProvideConnectionStateChangeListenerFactory(InterfaceC4461<BehaviorRelay<RxBleConnection.RxBleConnectionState>> interfaceC4461) {
        this.connectionStateBehaviorRelayProvider = interfaceC4461;
    }

    public static DeviceModule_ProvideConnectionStateChangeListenerFactory create(InterfaceC4461<BehaviorRelay<RxBleConnection.RxBleConnectionState>> interfaceC4461) {
        return new DeviceModule_ProvideConnectionStateChangeListenerFactory(interfaceC4461);
    }

    public static ConnectionStateChangeListener proxyProvideConnectionStateChangeListener(BehaviorRelay<RxBleConnection.RxBleConnectionState> behaviorRelay) {
        return (ConnectionStateChangeListener) C4618.m14073(DeviceModule.provideConnectionStateChangeListener(behaviorRelay), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public ConnectionStateChangeListener get() {
        return (ConnectionStateChangeListener) C4618.m14073(DeviceModule.provideConnectionStateChangeListener(this.connectionStateBehaviorRelayProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
