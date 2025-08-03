package com.polidea.rxandroidble2.internal.scan;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble2.ClientScope;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.util.UUIDUtil;
import com.polidea.rxandroidble2.scan.ScanCallbackType;

@ClientScope
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class InternalScanResultCreator {
    private final UUIDUtil uuidUtil;

    public InternalScanResultCreator(UUIDUtil uUIDUtil) {
        this.uuidUtil = uUIDUtil;
    }

    @RequiresApi(21)
    private static ScanCallbackType toScanCallbackType(int i) {
        if (i == 1) {
            return ScanCallbackType.CALLBACK_TYPE_ALL_MATCHES;
        }
        if (i == 2) {
            return ScanCallbackType.CALLBACK_TYPE_FIRST_MATCH;
        }
        if (i == 4) {
            return ScanCallbackType.CALLBACK_TYPE_MATCH_LOST;
        }
        RxBleLog.w("Unknown callback type %d -> check android.bluetooth.le.ScanSettings", Integer.valueOf(i));
        return ScanCallbackType.CALLBACK_TYPE_UNKNOWN;
    }

    public RxBleInternalScanResult create(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        return new RxBleInternalScanResult(bluetoothDevice, i, System.nanoTime(), this.uuidUtil.parseFromBytes(bArr), ScanCallbackType.CALLBACK_TYPE_UNSPECIFIED);
    }

    @RequiresApi(21)
    public RxBleInternalScanResult create(ScanResult scanResult) {
        return new RxBleInternalScanResult(scanResult.getDevice(), scanResult.getRssi(), scanResult.getTimestampNanos(), new ScanRecordImplNativeWrapper(scanResult.getScanRecord()), ScanCallbackType.CALLBACK_TYPE_BATCH);
    }

    @RequiresApi(21)
    public RxBleInternalScanResult create(int i, ScanResult scanResult) {
        return new RxBleInternalScanResult(scanResult.getDevice(), scanResult.getRssi(), scanResult.getTimestampNanos(), new ScanRecordImplNativeWrapper(scanResult.getScanRecord()), toScanCallbackType(i));
    }
}
