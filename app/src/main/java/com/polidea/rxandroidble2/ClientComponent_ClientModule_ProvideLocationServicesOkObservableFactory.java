package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory;
import defpackage.AbstractC4262;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory implements InterfaceC3628<AbstractC4262<Boolean>> {
    private final InterfaceC4461<Integer> deviceSdkProvider;
    private final InterfaceC4461<LocationServicesOkObservableApi23Factory> locationServicesOkObservableApi23FactoryProvider;

    public ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory(InterfaceC4461<Integer> interfaceC4461, InterfaceC4461<LocationServicesOkObservableApi23Factory> interfaceC44612) {
        this.deviceSdkProvider = interfaceC4461;
        this.locationServicesOkObservableApi23FactoryProvider = interfaceC44612;
    }

    public static ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory create(InterfaceC4461<Integer> interfaceC4461, InterfaceC4461<LocationServicesOkObservableApi23Factory> interfaceC44612) {
        return new ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory(interfaceC4461, interfaceC44612);
    }

    public static AbstractC4262<Boolean> proxyProvideLocationServicesOkObservable(int i, LocationServicesOkObservableApi23Factory locationServicesOkObservableApi23Factory) {
        return (AbstractC4262) C4618.m14073(ClientComponent.ClientModule.provideLocationServicesOkObservable(i, locationServicesOkObservableApi23Factory), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public AbstractC4262<Boolean> get() {
        return (AbstractC4262) C4618.m14073(ClientComponent.ClientModule.provideLocationServicesOkObservable(this.deviceSdkProvider.get().intValue(), this.locationServicesOkObservableApi23FactoryProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
