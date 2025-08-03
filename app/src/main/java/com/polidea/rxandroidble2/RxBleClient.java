package com.polidea.rxandroidble2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.scan.BackgroundScanner;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanResult;
import com.polidea.rxandroidble2.scan.ScanSettings;
import defpackage.AbstractC4262;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes2.dex */
public abstract class RxBleClient {

    public enum State {
        BLUETOOTH_NOT_AVAILABLE,
        LOCATION_PERMISSION_NOT_GRANTED,
        BLUETOOTH_NOT_ENABLED,
        LOCATION_SERVICES_NOT_ENABLED,
        READY
    }

    public static RxBleClient create(@NonNull Context context) {
        return DaggerClientComponent.builder().applicationContext(context.getApplicationContext()).build().rxBleClient();
    }

    @Deprecated
    public static void setLogLevel(int i) {
        RxBleLog.setLogLevel(i);
    }

    public static void updateLogOptions(LogOptions logOptions) {
        RxBleLog.updateLogOptions(logOptions);
    }

    public abstract BackgroundScanner getBackgroundScanner();

    public abstract RxBleDevice getBleDevice(@NonNull String str);

    public abstract Set<RxBleDevice> getBondedDevices();

    public abstract String[] getRecommendedScanRuntimePermissions();

    public abstract State getState();

    public abstract boolean isScanRuntimePermissionGranted();

    public abstract AbstractC4262<State> observeStateChanges();

    public abstract AbstractC4262<ScanResult> scanBleDevices(ScanSettings scanSettings, ScanFilter... scanFilterArr);

    @Deprecated
    public abstract AbstractC4262<RxBleScanResult> scanBleDevices(@Nullable UUID... uuidArr);
}
