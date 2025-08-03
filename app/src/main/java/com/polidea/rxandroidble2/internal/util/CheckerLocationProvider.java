package com.polidea.rxandroidble2.internal.util;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.location.LocationManager;
import android.provider.Settings;
import com.polidea.rxandroidble2.internal.RxBleLog;

@TargetApi(19)
/* loaded from: classes2.dex */
public class CheckerLocationProvider {
    private final ContentResolver contentResolver;
    private final LocationManager locationManager;

    public CheckerLocationProvider(ContentResolver contentResolver, LocationManager locationManager) {
        this.contentResolver = contentResolver;
        this.locationManager = locationManager;
    }

    public boolean isLocationProviderEnabled() {
        try {
            return Settings.Secure.getInt(this.contentResolver, "location_mode") != 0;
        } catch (Settings.SettingNotFoundException e2) {
            RxBleLog.w(e2, "Could not use LOCATION_MODE check. Falling back to legacy method.", new Object[0]);
            return this.locationManager.isProviderEnabled("network") || this.locationManager.isProviderEnabled("gps");
        }
    }
}
