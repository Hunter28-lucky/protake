package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class InternalToExternalScanResultConverter_Factory implements InterfaceC3628<InternalToExternalScanResultConverter> {
    private final InterfaceC4461<RxBleDeviceProvider> deviceProvider;

    public InternalToExternalScanResultConverter_Factory(InterfaceC4461<RxBleDeviceProvider> interfaceC4461) {
        this.deviceProvider = interfaceC4461;
    }

    public static InternalToExternalScanResultConverter_Factory create(InterfaceC4461<RxBleDeviceProvider> interfaceC4461) {
        return new InternalToExternalScanResultConverter_Factory(interfaceC4461);
    }

    @Override // defpackage.InterfaceC4461
    public InternalToExternalScanResultConverter get() {
        return new InternalToExternalScanResultConverter(this.deviceProvider.get());
    }
}
