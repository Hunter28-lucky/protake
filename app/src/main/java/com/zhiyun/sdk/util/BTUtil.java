package com.zhiyun.sdk.util;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Process;

/* loaded from: classes2.dex */
public class BTUtil {
    private static boolean a() {
        return true;
    }

    private static boolean a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static void disable() {
        BluetoothAdapter.getDefaultAdapter().disable();
    }

    public static void enable() {
        BluetoothAdapter.getDefaultAdapter().enable();
    }

    public static boolean isLocationPermissionOk(Context context) {
        return !a() || a(context, "android.permission.ACCESS_COARSE_LOCATION") || a(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    public static boolean isLocationProviderOk(Context context) {
        if (!a()) {
            return true;
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isOpened() {
        return BluetoothAdapter.getDefaultAdapter().isEnabled();
    }

    public static boolean isSupportBle() {
        return BluetoothAdapter.getDefaultAdapter() != null;
    }

    public static void toLocationService(Activity activity) {
        activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }
}
