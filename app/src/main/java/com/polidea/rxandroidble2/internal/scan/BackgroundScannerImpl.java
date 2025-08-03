package com.polidea.rxandroidble2.internal.scan;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.scan.BackgroundScanner;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanResult;
import com.polidea.rxandroidble2.scan.ScanSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(26)
/* loaded from: classes2.dex */
public class BackgroundScannerImpl implements BackgroundScanner {
    private static final int NO_ERROR = 0;
    private final InternalScanResultCreator internalScanResultCreator;
    private final InternalToExternalScanResultConverter internalToExternalScanResultConverter;
    private final RxBleAdapterWrapper rxBleAdapterWrapper;
    private final AndroidScanObjectsConverter scanObjectsConverter;

    public BackgroundScannerImpl(RxBleAdapterWrapper rxBleAdapterWrapper, AndroidScanObjectsConverter androidScanObjectsConverter, InternalScanResultCreator internalScanResultCreator, InternalToExternalScanResultConverter internalToExternalScanResultConverter) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
        this.scanObjectsConverter = androidScanObjectsConverter;
        this.internalScanResultCreator = internalScanResultCreator;
        this.internalToExternalScanResultConverter = internalToExternalScanResultConverter;
    }

    private ScanResult convertScanResultToRxAndroidBLEModel(int i, android.bluetooth.le.ScanResult scanResult) {
        return this.internalToExternalScanResultConverter.apply(this.internalScanResultCreator.create(i, scanResult));
    }

    private static List<android.bluetooth.le.ScanResult> extractScanResults(@NonNull Intent intent) {
        return (List) intent.getSerializableExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT");
    }

    @Override // com.polidea.rxandroidble2.scan.BackgroundScanner
    public List<ScanResult> onScanResultReceived(@NonNull Intent intent) {
        int intExtra = intent.getIntExtra("android.bluetooth.le.extra.CALLBACK_TYPE", -1);
        int intExtra2 = intent.getIntExtra("android.bluetooth.le.extra.ERROR_CODE", 0);
        List<android.bluetooth.le.ScanResult> listExtractScanResults = extractScanResults(intent);
        ArrayList arrayList = new ArrayList();
        if (intExtra2 != 0) {
            throw new BleScanException(intExtra2);
        }
        Iterator<android.bluetooth.le.ScanResult> it = listExtractScanResults.iterator();
        while (it.hasNext()) {
            arrayList.add(convertScanResultToRxAndroidBLEModel(intExtra, it.next()));
        }
        return arrayList;
    }

    @Override // com.polidea.rxandroidble2.scan.BackgroundScanner
    @RequiresApi(26)
    public void scanBleDeviceInBackground(@NonNull PendingIntent pendingIntent, ScanSettings scanSettings, ScanFilter... scanFilterArr) {
        if (Build.VERSION.SDK_INT < 26) {
            RxBleLog.w("PendingIntent based scanning is available for Android O and higher only.", new Object[0]);
            return;
        }
        if (!this.rxBleAdapterWrapper.isBluetoothEnabled()) {
            RxBleLog.w("PendingIntent based scanning is available only when Bluetooth is ON.", new Object[0]);
            throw new BleScanException(1);
        }
        RxBleLog.i("Requesting pending intent based scan.", new Object[0]);
        int iStartLeScan = this.rxBleAdapterWrapper.startLeScan(this.scanObjectsConverter.toNativeFilters(scanFilterArr), this.scanObjectsConverter.toNativeSettings(scanSettings), pendingIntent);
        if (iStartLeScan == 0) {
            return;
        }
        BleScanException bleScanException = new BleScanException(iStartLeScan);
        RxBleLog.w(bleScanException, "Failed to start scan", new Object[0]);
        throw bleScanException;
    }

    @Override // com.polidea.rxandroidble2.scan.BackgroundScanner
    @RequiresApi(26)
    public void stopBackgroundBleScan(@NonNull PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT < 26) {
            RxBleLog.w("PendingIntent based scanning is available for Android O and higher only.", new Object[0]);
        } else if (!this.rxBleAdapterWrapper.isBluetoothEnabled()) {
            RxBleLog.w("PendingIntent based scanning is available only when Bluetooth is ON.", new Object[0]);
        } else {
            RxBleLog.i("Stopping pending intent based scan.", new Object[0]);
            this.rxBleAdapterWrapper.stopLeScan(pendingIntent);
        }
    }
}
