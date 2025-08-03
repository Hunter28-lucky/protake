package com.polidea.rxandroidble2.internal.util;

import android.content.ContentResolver;
import android.location.LocationManager;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class CheckerLocationProvider_Factory implements InterfaceC3628<CheckerLocationProvider> {
    private final InterfaceC4461<ContentResolver> contentResolverProvider;
    private final InterfaceC4461<LocationManager> locationManagerProvider;

    public CheckerLocationProvider_Factory(InterfaceC4461<ContentResolver> interfaceC4461, InterfaceC4461<LocationManager> interfaceC44612) {
        this.contentResolverProvider = interfaceC4461;
        this.locationManagerProvider = interfaceC44612;
    }

    public static CheckerLocationProvider_Factory create(InterfaceC4461<ContentResolver> interfaceC4461, InterfaceC4461<LocationManager> interfaceC44612) {
        return new CheckerLocationProvider_Factory(interfaceC4461, interfaceC44612);
    }

    public static CheckerLocationProvider newCheckerLocationProvider(ContentResolver contentResolver, LocationManager locationManager) {
        return new CheckerLocationProvider(contentResolver, locationManager);
    }

    @Override // defpackage.InterfaceC4461
    public CheckerLocationProvider get() {
        return new CheckerLocationProvider(this.contentResolverProvider.get(), this.locationManagerProvider.get());
    }
}
