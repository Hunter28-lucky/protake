package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.os.Process;

/* compiled from: BluetoothUtil.java */
/* renamed from: ː, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2749 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean m10006() {
        return true;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m10007(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        }
        throw new IllegalArgumentException("permission is null");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m10008(Context context) {
        if (Build.VERSION.SDK_INT < 31) {
            return !m10006() || m10007(context, "android.permission.ACCESS_COARSE_LOCATION") || m10007(context, "android.permission.ACCESS_FINE_LOCATION");
        }
        if (m10007(context, "android.permission.BLUETOOTH_CONNECT") && m10007(context, "android.permission.BLUETOOTH_SCAN")) {
            return m10007(context, "android.permission.ACCESS_COARSE_LOCATION") || m10007(context, "android.permission.ACCESS_FINE_LOCATION");
        }
        return false;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m10009(Context context) {
        if (!m10006()) {
            return true;
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean m10010() {
        return BluetoothAdapter.getDefaultAdapter().isEnabled();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static boolean m10011() {
        return BluetoothAdapter.getDefaultAdapter() != null;
    }
}
