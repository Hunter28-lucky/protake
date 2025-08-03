package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.scan.EmulatedScanFilterMatcher;
import com.polidea.rxandroidble2.internal.scan.InternalScanResultCreator;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import defpackage.InterfaceC5245;

/* loaded from: classes2.dex */
public class ScanOperationApi18 extends ScanOperation<RxBleInternalScanResult, BluetoothAdapter.LeScanCallback> {

    @NonNull
    public final EmulatedScanFilterMatcher scanFilterMatcher;

    @NonNull
    public final InternalScanResultCreator scanResultCreator;

    public ScanOperationApi18(@NonNull RxBleAdapterWrapper rxBleAdapterWrapper, @NonNull InternalScanResultCreator internalScanResultCreator, @NonNull EmulatedScanFilterMatcher emulatedScanFilterMatcher) {
        super(rxBleAdapterWrapper);
        this.scanResultCreator = internalScanResultCreator;
        this.scanFilterMatcher = emulatedScanFilterMatcher;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("ScanOperationApi18{");
        if (this.scanFilterMatcher.isEmpty()) {
            str = "";
        } else {
            str = "ANY_MUST_MATCH -> " + this.scanFilterMatcher;
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.polidea.rxandroidble2.internal.operations.ScanOperation
    public BluetoothAdapter.LeScanCallback createScanCallback(final InterfaceC5245<RxBleInternalScanResult> interfaceC5245) {
        return new BluetoothAdapter.LeScanCallback() { // from class: com.polidea.rxandroidble2.internal.operations.ScanOperationApi18.1
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                if (!ScanOperationApi18.this.scanFilterMatcher.isEmpty() && RxBleLog.isAtLeast(3) && RxBleLog.getShouldLogScannedPeripherals()) {
                    RxBleLog.d("%s, name=%s, rssi=%d, data=%s", LoggerUtil.commonMacMessage(bluetoothDevice.getAddress()), bluetoothDevice.getName(), Integer.valueOf(i), LoggerUtil.bytesToHex(bArr));
                }
                RxBleInternalScanResult rxBleInternalScanResultCreate = ScanOperationApi18.this.scanResultCreator.create(bluetoothDevice, i, bArr);
                if (ScanOperationApi18.this.scanFilterMatcher.matches(rxBleInternalScanResultCreate)) {
                    interfaceC5245.onNext(rxBleInternalScanResultCreate);
                }
            }
        };
    }

    @Override // com.polidea.rxandroidble2.internal.operations.ScanOperation
    public boolean startScan(RxBleAdapterWrapper rxBleAdapterWrapper, BluetoothAdapter.LeScanCallback leScanCallback) {
        if (this.scanFilterMatcher.isEmpty()) {
            RxBleLog.d("No library side filtering —> debug logs of scanned devices disabled", new Object[0]);
        }
        return rxBleAdapterWrapper.startLegacyLeScan(leScanCallback);
    }

    @Override // com.polidea.rxandroidble2.internal.operations.ScanOperation
    public void stopScan(RxBleAdapterWrapper rxBleAdapterWrapper, BluetoothAdapter.LeScanCallback leScanCallback) {
        rxBleAdapterWrapper.stopLegacyLeScan(leScanCallback);
    }
}
