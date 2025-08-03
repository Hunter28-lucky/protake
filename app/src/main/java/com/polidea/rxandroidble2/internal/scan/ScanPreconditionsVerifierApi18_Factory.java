package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ScanPreconditionsVerifierApi18_Factory implements InterfaceC3628<ScanPreconditionsVerifierApi18> {
    private final InterfaceC4461<LocationServicesStatus> locationServicesStatusProvider;
    private final InterfaceC4461<RxBleAdapterWrapper> rxBleAdapterWrapperProvider;

    public ScanPreconditionsVerifierApi18_Factory(InterfaceC4461<RxBleAdapterWrapper> interfaceC4461, InterfaceC4461<LocationServicesStatus> interfaceC44612) {
        this.rxBleAdapterWrapperProvider = interfaceC4461;
        this.locationServicesStatusProvider = interfaceC44612;
    }

    public static ScanPreconditionsVerifierApi18_Factory create(InterfaceC4461<RxBleAdapterWrapper> interfaceC4461, InterfaceC4461<LocationServicesStatus> interfaceC44612) {
        return new ScanPreconditionsVerifierApi18_Factory(interfaceC4461, interfaceC44612);
    }

    @Override // defpackage.InterfaceC4461
    public ScanPreconditionsVerifierApi18 get() {
        return new ScanPreconditionsVerifierApi18(this.rxBleAdapterWrapperProvider.get(), this.locationServicesStatusProvider.get());
    }
}
