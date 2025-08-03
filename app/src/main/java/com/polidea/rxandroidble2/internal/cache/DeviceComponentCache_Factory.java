package com.polidea.rxandroidble2.internal.cache;

import defpackage.InterfaceC3628;

/* loaded from: classes2.dex */
public final class DeviceComponentCache_Factory implements InterfaceC3628<DeviceComponentCache> {
    private static final DeviceComponentCache_Factory INSTANCE = new DeviceComponentCache_Factory();

    public static DeviceComponentCache_Factory create() {
        return INSTANCE;
    }

    @Override // defpackage.InterfaceC4461
    public DeviceComponentCache get() {
        return new DeviceComponentCache();
    }
}
