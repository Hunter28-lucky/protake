package com.polidea.rxandroidble2.internal.util;

import android.content.Context;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class LocationServicesOkObservableApi23Factory_Factory implements InterfaceC3628<LocationServicesOkObservableApi23Factory> {
    private final InterfaceC4461<Context> contextProvider;
    private final InterfaceC4461<LocationServicesStatus> locationServicesStatusProvider;

    public LocationServicesOkObservableApi23Factory_Factory(InterfaceC4461<Context> interfaceC4461, InterfaceC4461<LocationServicesStatus> interfaceC44612) {
        this.contextProvider = interfaceC4461;
        this.locationServicesStatusProvider = interfaceC44612;
    }

    public static LocationServicesOkObservableApi23Factory_Factory create(InterfaceC4461<Context> interfaceC4461, InterfaceC4461<LocationServicesStatus> interfaceC44612) {
        return new LocationServicesOkObservableApi23Factory_Factory(interfaceC4461, interfaceC44612);
    }

    public static LocationServicesOkObservableApi23Factory newLocationServicesOkObservableApi23Factory(Context context, LocationServicesStatus locationServicesStatus) {
        return new LocationServicesOkObservableApi23Factory(context, locationServicesStatus);
    }

    @Override // defpackage.InterfaceC4461
    public LocationServicesOkObservableApi23Factory get() {
        return new LocationServicesOkObservableApi23Factory(this.contextProvider.get(), this.locationServicesStatusProvider.get());
    }
}
