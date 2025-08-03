package com.polidea.rxandroidble2.internal.scan;

import android.annotation.SuppressLint;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble2.scan.ScanSettings;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class AndroidScanObjectsConverter {
    private final int deviceSdk;

    public AndroidScanObjectsConverter(int i) {
        this.deviceSdk = i;
    }

    @RequiresApi(23)
    private static void setMarshmallowSettings(ScanSettings scanSettings, ScanSettings.Builder builder) {
        builder.setCallbackType(scanSettings.getCallbackType()).setMatchMode(scanSettings.getMatchMode()).setNumOfMatches(scanSettings.getNumOfMatches());
    }

    @RequiresApi(21)
    private static ScanFilter toNative(com.polidea.rxandroidble2.scan.ScanFilter scanFilter) {
        ScanFilter.Builder builder = new ScanFilter.Builder();
        if (scanFilter.getServiceDataUuid() != null) {
            builder.setServiceData(scanFilter.getServiceDataUuid(), scanFilter.getServiceData(), scanFilter.getServiceDataMask());
        }
        return builder.setDeviceAddress(scanFilter.getDeviceAddress()).setDeviceName(scanFilter.getDeviceName()).setManufacturerData(scanFilter.getManufacturerId(), scanFilter.getManufacturerData(), scanFilter.getManufacturerDataMask()).setServiceUuid(scanFilter.getServiceUuid(), scanFilter.getServiceUuidMask()).build();
    }

    @Nullable
    @RequiresApi(21)
    public List<ScanFilter> toNativeFilters(com.polidea.rxandroidble2.scan.ScanFilter... scanFilterArr) {
        if (!(scanFilterArr != null && scanFilterArr.length > 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(scanFilterArr.length);
        for (com.polidea.rxandroidble2.scan.ScanFilter scanFilter : scanFilterArr) {
            arrayList.add(toNative(scanFilter));
        }
        return arrayList;
    }

    @RequiresApi(21)
    @SuppressLint({"NewApi"})
    public android.bluetooth.le.ScanSettings toNativeSettings(com.polidea.rxandroidble2.scan.ScanSettings scanSettings) {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        if (this.deviceSdk >= 23) {
            setMarshmallowSettings(scanSettings, builder);
        }
        return builder.setReportDelay(scanSettings.getReportDelayMillis()).setScanMode(scanSettings.getScanMode()).build();
    }
}
