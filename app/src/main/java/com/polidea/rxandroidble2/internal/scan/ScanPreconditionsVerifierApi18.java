package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;

/* loaded from: classes2.dex */
public class ScanPreconditionsVerifierApi18 implements ScanPreconditionsVerifier {
    public final LocationServicesStatus locationServicesStatus;
    public final RxBleAdapterWrapper rxBleAdapterWrapper;

    public ScanPreconditionsVerifierApi18(RxBleAdapterWrapper rxBleAdapterWrapper, LocationServicesStatus locationServicesStatus) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
        this.locationServicesStatus = locationServicesStatus;
    }

    @Override // com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier
    public void verify(boolean z) {
        if (!this.rxBleAdapterWrapper.hasBluetoothAdapter()) {
            throw new BleScanException(2);
        }
        if (!this.rxBleAdapterWrapper.isBluetoothEnabled()) {
            throw new BleScanException(1);
        }
        if (!this.locationServicesStatus.isLocationPermissionOk()) {
            throw new BleScanException(3);
        }
        if (z && !this.locationServicesStatus.isLocationProviderOk()) {
            throw new BleScanException(4);
        }
    }
}
