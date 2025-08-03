package com.polidea.rxandroidble2.internal;

import com.polidea.rxandroidble2.ClientScope;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.internal.DeviceComponent;
import com.polidea.rxandroidble2.internal.cache.DeviceComponentCache;
import defpackage.InterfaceC4461;
import java.util.Map;

@ClientScope
/* loaded from: classes2.dex */
public class RxBleDeviceProvider {
    private final Map<String, DeviceComponent> cachedDeviceComponents;
    private final InterfaceC4461<DeviceComponent.Builder> deviceComponentBuilder;

    public RxBleDeviceProvider(DeviceComponentCache deviceComponentCache, InterfaceC4461<DeviceComponent.Builder> interfaceC4461) {
        this.cachedDeviceComponents = deviceComponentCache;
        this.deviceComponentBuilder = interfaceC4461;
    }

    public RxBleDevice getBleDevice(String str) {
        DeviceComponent deviceComponent = this.cachedDeviceComponents.get(str);
        if (deviceComponent != null) {
            return deviceComponent.provideDevice();
        }
        synchronized (this.cachedDeviceComponents) {
            DeviceComponent deviceComponent2 = this.cachedDeviceComponents.get(str);
            if (deviceComponent2 != null) {
                return deviceComponent2.provideDevice();
            }
            DeviceComponent deviceComponentBuild = this.deviceComponentBuilder.get().macAddress(str).build();
            RxBleDevice rxBleDeviceProvideDevice = deviceComponentBuild.provideDevice();
            this.cachedDeviceComponents.put(str, deviceComponentBuild);
            return rxBleDeviceProvideDevice;
        }
    }
}
