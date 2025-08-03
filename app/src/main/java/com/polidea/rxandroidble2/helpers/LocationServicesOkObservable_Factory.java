package com.polidea.rxandroidble2.helpers;

import defpackage.AbstractC4262;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class LocationServicesOkObservable_Factory implements InterfaceC3628<LocationServicesOkObservable> {
    private final InterfaceC4461<AbstractC4262<Boolean>> locationServicesOkObsImplProvider;

    public LocationServicesOkObservable_Factory(InterfaceC4461<AbstractC4262<Boolean>> interfaceC4461) {
        this.locationServicesOkObsImplProvider = interfaceC4461;
    }

    public static LocationServicesOkObservable_Factory create(InterfaceC4461<AbstractC4262<Boolean>> interfaceC4461) {
        return new LocationServicesOkObservable_Factory(interfaceC4461);
    }

    public static LocationServicesOkObservable newLocationServicesOkObservable(AbstractC4262<Boolean> abstractC4262) {
        return new LocationServicesOkObservable(abstractC4262);
    }

    @Override // defpackage.InterfaceC4461
    public LocationServicesOkObservable get() {
        return new LocationServicesOkObservable(this.locationServicesOkObsImplProvider.get());
    }
}
