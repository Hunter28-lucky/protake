package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi18;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi23;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideLocationServicesStatusFactory implements InterfaceC3628<LocationServicesStatus> {
    private final InterfaceC4461<Integer> deviceSdkProvider;
    private final InterfaceC4461<LocationServicesStatusApi18> locationServicesStatusApi18Provider;
    private final InterfaceC4461<LocationServicesStatusApi23> locationServicesStatusApi23Provider;

    public ClientComponent_ClientModule_ProvideLocationServicesStatusFactory(InterfaceC4461<Integer> interfaceC4461, InterfaceC4461<LocationServicesStatusApi18> interfaceC44612, InterfaceC4461<LocationServicesStatusApi23> interfaceC44613) {
        this.deviceSdkProvider = interfaceC4461;
        this.locationServicesStatusApi18Provider = interfaceC44612;
        this.locationServicesStatusApi23Provider = interfaceC44613;
    }

    public static ClientComponent_ClientModule_ProvideLocationServicesStatusFactory create(InterfaceC4461<Integer> interfaceC4461, InterfaceC4461<LocationServicesStatusApi18> interfaceC44612, InterfaceC4461<LocationServicesStatusApi23> interfaceC44613) {
        return new ClientComponent_ClientModule_ProvideLocationServicesStatusFactory(interfaceC4461, interfaceC44612, interfaceC44613);
    }

    public static LocationServicesStatus proxyProvideLocationServicesStatus(int i, InterfaceC4461<LocationServicesStatusApi18> interfaceC4461, InterfaceC4461<LocationServicesStatusApi23> interfaceC44612) {
        return (LocationServicesStatus) C4618.m14073(ClientComponent.ClientModule.provideLocationServicesStatus(i, interfaceC4461, interfaceC44612), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public LocationServicesStatus get() {
        return (LocationServicesStatus) C4618.m14073(ClientComponent.ClientModule.provideLocationServicesStatus(this.deviceSdkProvider.get().intValue(), this.locationServicesStatusApi18Provider, this.locationServicesStatusApi23Provider), "Cannot return null from a non-@Nullable @Provides method");
    }
}
