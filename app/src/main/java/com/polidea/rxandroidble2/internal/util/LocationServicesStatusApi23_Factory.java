package com.polidea.rxandroidble2.internal.util;

import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class LocationServicesStatusApi23_Factory implements InterfaceC3628<LocationServicesStatusApi23> {
    private final InterfaceC4461<CheckerLocationPermission> checkerLocationPermissionProvider;
    private final InterfaceC4461<CheckerLocationProvider> checkerLocationProvider;
    private final InterfaceC4461<Boolean> isAndroidWearProvider;
    private final InterfaceC4461<Integer> targetSdkProvider;

    public LocationServicesStatusApi23_Factory(InterfaceC4461<CheckerLocationProvider> interfaceC4461, InterfaceC4461<CheckerLocationPermission> interfaceC44612, InterfaceC4461<Integer> interfaceC44613, InterfaceC4461<Boolean> interfaceC44614) {
        this.checkerLocationProvider = interfaceC4461;
        this.checkerLocationPermissionProvider = interfaceC44612;
        this.targetSdkProvider = interfaceC44613;
        this.isAndroidWearProvider = interfaceC44614;
    }

    public static LocationServicesStatusApi23_Factory create(InterfaceC4461<CheckerLocationProvider> interfaceC4461, InterfaceC4461<CheckerLocationPermission> interfaceC44612, InterfaceC4461<Integer> interfaceC44613, InterfaceC4461<Boolean> interfaceC44614) {
        return new LocationServicesStatusApi23_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614);
    }

    public static LocationServicesStatusApi23 newLocationServicesStatusApi23(CheckerLocationProvider checkerLocationProvider, CheckerLocationPermission checkerLocationPermission, int i, boolean z) {
        return new LocationServicesStatusApi23(checkerLocationProvider, checkerLocationPermission, i, z);
    }

    @Override // defpackage.InterfaceC4461
    public LocationServicesStatusApi23 get() {
        return new LocationServicesStatusApi23(this.checkerLocationProvider.get(), this.checkerLocationPermissionProvider.get(), this.targetSdkProvider.get().intValue(), this.isAndroidWearProvider.get().booleanValue());
    }
}
