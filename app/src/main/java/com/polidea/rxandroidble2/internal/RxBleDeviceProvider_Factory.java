package com.polidea.rxandroidble2.internal;

import com.polidea.rxandroidble2.internal.DeviceComponent;
import com.polidea.rxandroidble2.internal.cache.DeviceComponentCache;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class RxBleDeviceProvider_Factory implements InterfaceC3628<RxBleDeviceProvider> {
    private final InterfaceC4461<DeviceComponent.Builder> deviceComponentBuilderProvider;
    private final InterfaceC4461<DeviceComponentCache> deviceComponentCacheProvider;

    public RxBleDeviceProvider_Factory(InterfaceC4461<DeviceComponentCache> interfaceC4461, InterfaceC4461<DeviceComponent.Builder> interfaceC44612) {
        this.deviceComponentCacheProvider = interfaceC4461;
        this.deviceComponentBuilderProvider = interfaceC44612;
    }

    public static RxBleDeviceProvider_Factory create(InterfaceC4461<DeviceComponentCache> interfaceC4461, InterfaceC4461<DeviceComponent.Builder> interfaceC44612) {
        return new RxBleDeviceProvider_Factory(interfaceC4461, interfaceC44612);
    }

    @Override // defpackage.InterfaceC4461
    public RxBleDeviceProvider get() {
        return new RxBleDeviceProvider(this.deviceComponentCacheProvider.get(), this.deviceComponentBuilderProvider);
    }
}
