package com.polidea.rxandroidble2.internal;

import com.polidea.rxandroidble2.RxBleDevice;

@DeviceScope
/* loaded from: classes2.dex */
public interface DeviceComponent {

    public interface Builder {
        DeviceComponent build();

        Builder macAddress(String str);
    }

    @DeviceScope
    RxBleDevice provideDevice();
}
