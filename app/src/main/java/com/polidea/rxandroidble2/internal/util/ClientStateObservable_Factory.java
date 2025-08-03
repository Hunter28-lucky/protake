package com.polidea.rxandroidble2.internal.util;

import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ClientStateObservable_Factory implements InterfaceC3628<ClientStateObservable> {
    private final InterfaceC4461<AbstractC4262<RxBleAdapterStateObservable.BleAdapterState>> bleAdapterStateObservableProvider;
    private final InterfaceC4461<AbstractC4262<Boolean>> locationServicesOkObservableProvider;
    private final InterfaceC4461<LocationServicesStatus> locationServicesStatusProvider;
    private final InterfaceC4461<RxBleAdapterWrapper> rxBleAdapterWrapperProvider;
    private final InterfaceC4461<AbstractC4585> timerSchedulerProvider;

    public ClientStateObservable_Factory(InterfaceC4461<RxBleAdapterWrapper> interfaceC4461, InterfaceC4461<AbstractC4262<RxBleAdapterStateObservable.BleAdapterState>> interfaceC44612, InterfaceC4461<AbstractC4262<Boolean>> interfaceC44613, InterfaceC4461<LocationServicesStatus> interfaceC44614, InterfaceC4461<AbstractC4585> interfaceC44615) {
        this.rxBleAdapterWrapperProvider = interfaceC4461;
        this.bleAdapterStateObservableProvider = interfaceC44612;
        this.locationServicesOkObservableProvider = interfaceC44613;
        this.locationServicesStatusProvider = interfaceC44614;
        this.timerSchedulerProvider = interfaceC44615;
    }

    public static ClientStateObservable_Factory create(InterfaceC4461<RxBleAdapterWrapper> interfaceC4461, InterfaceC4461<AbstractC4262<RxBleAdapterStateObservable.BleAdapterState>> interfaceC44612, InterfaceC4461<AbstractC4262<Boolean>> interfaceC44613, InterfaceC4461<LocationServicesStatus> interfaceC44614, InterfaceC4461<AbstractC4585> interfaceC44615) {
        return new ClientStateObservable_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614, interfaceC44615);
    }

    public static ClientStateObservable newClientStateObservable(RxBleAdapterWrapper rxBleAdapterWrapper, AbstractC4262<RxBleAdapterStateObservable.BleAdapterState> abstractC4262, AbstractC4262<Boolean> abstractC42622, LocationServicesStatus locationServicesStatus, AbstractC4585 abstractC4585) {
        return new ClientStateObservable(rxBleAdapterWrapper, abstractC4262, abstractC42622, locationServicesStatus, abstractC4585);
    }

    @Override // defpackage.InterfaceC4461
    public ClientStateObservable get() {
        return new ClientStateObservable(this.rxBleAdapterWrapperProvider.get(), this.bleAdapterStateObservableProvider.get(), this.locationServicesOkObservableProvider.get(), this.locationServicesStatusProvider.get(), this.timerSchedulerProvider.get());
    }
}
