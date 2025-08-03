package com.polidea.rxandroidble2.internal.util;

/* loaded from: classes2.dex */
public class LocationServicesStatusApi23 implements LocationServicesStatus {
    private final CheckerLocationPermission checkerLocationPermission;
    private final CheckerLocationProvider checkerLocationProvider;
    private final boolean isAndroidWear;
    private final int targetSdk;

    public LocationServicesStatusApi23(CheckerLocationProvider checkerLocationProvider, CheckerLocationPermission checkerLocationPermission, int i, boolean z) {
        this.checkerLocationProvider = checkerLocationProvider;
        this.checkerLocationPermission = checkerLocationPermission;
        this.targetSdk = i;
        this.isAndroidWear = z;
    }

    private boolean isLocationProviderEnabledRequired() {
        return !this.isAndroidWear && this.targetSdk >= 23;
    }

    @Override // com.polidea.rxandroidble2.internal.util.LocationServicesStatus
    public boolean isLocationPermissionOk() {
        return this.checkerLocationPermission.isScanRuntimePermissionGranted();
    }

    @Override // com.polidea.rxandroidble2.internal.util.LocationServicesStatus
    public boolean isLocationProviderOk() {
        return !isLocationProviderEnabledRequired() || this.checkerLocationProvider.isLocationProviderEnabled();
    }
}
