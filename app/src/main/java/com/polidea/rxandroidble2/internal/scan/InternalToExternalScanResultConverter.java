package com.polidea.rxandroidble2.internal.scan;

import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;
import com.polidea.rxandroidble2.scan.ScanResult;
import defpackage.InterfaceC2368;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class InternalToExternalScanResultConverter implements InterfaceC2368<RxBleInternalScanResult, ScanResult> {
    private final RxBleDeviceProvider deviceProvider;

    public InternalToExternalScanResultConverter(RxBleDeviceProvider rxBleDeviceProvider) {
        this.deviceProvider = rxBleDeviceProvider;
    }

    @Override // defpackage.InterfaceC2368
    public ScanResult apply(RxBleInternalScanResult rxBleInternalScanResult) {
        return new ScanResult(this.deviceProvider.getBleDevice(rxBleInternalScanResult.getBluetoothDevice().getAddress()), rxBleInternalScanResult.getRssi(), rxBleInternalScanResult.getTimestampNanos(), rxBleInternalScanResult.getScanCallbackType(), rxBleInternalScanResult.getScanRecord());
    }
}
