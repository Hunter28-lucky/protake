package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import defpackage.AbstractC4262;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class DisconnectionRouter_Factory implements InterfaceC3628<DisconnectionRouter> {
    private final InterfaceC4461<AbstractC4262<RxBleAdapterStateObservable.BleAdapterState>> adapterStateObservableProvider;
    private final InterfaceC4461<RxBleAdapterWrapper> adapterWrapperProvider;
    private final InterfaceC4461<String> macAddressProvider;

    public DisconnectionRouter_Factory(InterfaceC4461<String> interfaceC4461, InterfaceC4461<RxBleAdapterWrapper> interfaceC44612, InterfaceC4461<AbstractC4262<RxBleAdapterStateObservable.BleAdapterState>> interfaceC44613) {
        this.macAddressProvider = interfaceC4461;
        this.adapterWrapperProvider = interfaceC44612;
        this.adapterStateObservableProvider = interfaceC44613;
    }

    public static DisconnectionRouter_Factory create(InterfaceC4461<String> interfaceC4461, InterfaceC4461<RxBleAdapterWrapper> interfaceC44612, InterfaceC4461<AbstractC4262<RxBleAdapterStateObservable.BleAdapterState>> interfaceC44613) {
        return new DisconnectionRouter_Factory(interfaceC4461, interfaceC44612, interfaceC44613);
    }

    public static DisconnectionRouter newDisconnectionRouter(String str, RxBleAdapterWrapper rxBleAdapterWrapper, AbstractC4262<RxBleAdapterStateObservable.BleAdapterState> abstractC4262) {
        return new DisconnectionRouter(str, rxBleAdapterWrapper, abstractC4262);
    }

    @Override // defpackage.InterfaceC4461
    public DisconnectionRouter get() {
        return new DisconnectionRouter(this.macAddressProvider.get(), this.adapterWrapperProvider.get(), this.adapterStateObservableProvider.get());
    }
}
