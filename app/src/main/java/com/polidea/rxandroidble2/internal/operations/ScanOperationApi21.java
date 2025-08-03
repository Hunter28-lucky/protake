package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.scan.AndroidScanObjectsConverter;
import com.polidea.rxandroidble2.internal.scan.EmulatedScanFilterMatcher;
import com.polidea.rxandroidble2.internal.scan.InternalScanResultCreator;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;
import defpackage.InterfaceC5245;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes2.dex */
public class ScanOperationApi21 extends ScanOperation<RxBleInternalScanResult, ScanCallback> {

    @NonNull
    private final AndroidScanObjectsConverter androidScanObjectsConverter;

    @NonNull
    public final EmulatedScanFilterMatcher emulatedScanFilterMatcher;

    @NonNull
    public final InternalScanResultCreator internalScanResultCreator;

    @Nullable
    private final ScanFilter[] scanFilters;

    @NonNull
    private final ScanSettings scanSettings;

    public ScanOperationApi21(@NonNull RxBleAdapterWrapper rxBleAdapterWrapper, @NonNull InternalScanResultCreator internalScanResultCreator, @NonNull AndroidScanObjectsConverter androidScanObjectsConverter, @NonNull ScanSettings scanSettings, @NonNull EmulatedScanFilterMatcher emulatedScanFilterMatcher, @Nullable ScanFilter[] scanFilterArr) {
        super(rxBleAdapterWrapper);
        this.internalScanResultCreator = internalScanResultCreator;
        this.scanSettings = scanSettings;
        this.emulatedScanFilterMatcher = emulatedScanFilterMatcher;
        this.scanFilters = scanFilterArr;
        this.androidScanObjectsConverter = androidScanObjectsConverter;
    }

    public static int errorCodeToBleErrorCode(int i) {
        if (i == 1) {
            return 5;
        }
        if (i == 2) {
            return 6;
        }
        if (i == 3) {
            return 7;
        }
        if (i == 4) {
            return 8;
        }
        if (i == 5) {
            return 9;
        }
        RxBleLog.w("Encountered unknown scanning error code: %d -> check android.bluetooth.le.ScanCallback", new Object[0]);
        return Integer.MAX_VALUE;
    }

    public String toString() {
        String str;
        ScanFilter[] scanFilterArr = this.scanFilters;
        boolean z = scanFilterArr == null || scanFilterArr.length == 0;
        boolean zIsEmpty = this.emulatedScanFilterMatcher.isEmpty();
        StringBuilder sb = new StringBuilder();
        sb.append("ScanOperationApi21{");
        String str2 = "";
        if (z) {
            str = "";
        } else {
            str = "ANY_MUST_MATCH -> nativeFilters=" + Arrays.toString(this.scanFilters);
        }
        sb.append(str);
        sb.append((z || zIsEmpty) ? "" : " and then ");
        if (!zIsEmpty) {
            str2 = "ANY_MUST_MATCH -> " + this.emulatedScanFilterMatcher;
        }
        sb.append(str2);
        sb.append('}');
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.polidea.rxandroidble2.internal.operations.ScanOperation
    public ScanCallback createScanCallback(final InterfaceC5245<RxBleInternalScanResult> interfaceC5245) {
        return new ScanCallback() { // from class: com.polidea.rxandroidble2.internal.operations.ScanOperationApi21.1
            @Override // android.bluetooth.le.ScanCallback
            public void onBatchScanResults(List<ScanResult> list) {
                Iterator<ScanResult> it = list.iterator();
                while (it.hasNext()) {
                    RxBleInternalScanResult rxBleInternalScanResultCreate = ScanOperationApi21.this.internalScanResultCreator.create(it.next());
                    if (ScanOperationApi21.this.emulatedScanFilterMatcher.matches(rxBleInternalScanResultCreate)) {
                        interfaceC5245.onNext(rxBleInternalScanResultCreate);
                    }
                }
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanFailed(int i) {
                interfaceC5245.mo6761(new BleScanException(ScanOperationApi21.errorCodeToBleErrorCode(i)));
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(int i, ScanResult scanResult) {
                if (!ScanOperationApi21.this.emulatedScanFilterMatcher.isEmpty() && RxBleLog.isAtLeast(3) && RxBleLog.getShouldLogScannedPeripherals()) {
                    ScanRecord scanRecord = scanResult.getScanRecord();
                    Object[] objArr = new Object[4];
                    objArr[0] = LoggerUtil.commonMacMessage(scanResult.getDevice().getAddress());
                    objArr[1] = scanResult.getDevice().getName();
                    objArr[2] = Integer.valueOf(scanResult.getRssi());
                    objArr[3] = LoggerUtil.bytesToHex(scanRecord != null ? scanRecord.getBytes() : null);
                    RxBleLog.d("%s, name=%s, rssi=%d, data=%s", objArr);
                }
                RxBleInternalScanResult rxBleInternalScanResultCreate = ScanOperationApi21.this.internalScanResultCreator.create(i, scanResult);
                if (ScanOperationApi21.this.emulatedScanFilterMatcher.matches(rxBleInternalScanResultCreate)) {
                    interfaceC5245.onNext(rxBleInternalScanResultCreate);
                }
            }
        };
    }

    @Override // com.polidea.rxandroidble2.internal.operations.ScanOperation
    public boolean startScan(RxBleAdapterWrapper rxBleAdapterWrapper, ScanCallback scanCallback) {
        if (this.emulatedScanFilterMatcher.isEmpty()) {
            RxBleLog.d("No library side filtering —> debug logs of scanned devices disabled", new Object[0]);
        }
        rxBleAdapterWrapper.startLeScan(this.androidScanObjectsConverter.toNativeFilters(this.scanFilters), this.androidScanObjectsConverter.toNativeSettings(this.scanSettings), scanCallback);
        return true;
    }

    @Override // com.polidea.rxandroidble2.internal.operations.ScanOperation
    public void stopScan(RxBleAdapterWrapper rxBleAdapterWrapper, ScanCallback scanCallback) {
        rxBleAdapterWrapper.stopLeScan(scanCallback);
    }
}
