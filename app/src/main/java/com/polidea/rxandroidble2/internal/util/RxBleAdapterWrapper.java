package com.polidea.rxandroidble2.internal.util;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.polidea.rxandroidble2.internal.RxBleLog;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class RxBleAdapterWrapper {
    private final BluetoothAdapter bluetoothAdapter;

    public RxBleAdapterWrapper(@Nullable BluetoothAdapter bluetoothAdapter) {
        this.bluetoothAdapter = bluetoothAdapter;
    }

    public Set<BluetoothDevice> getBondedDevices() {
        return this.bluetoothAdapter.getBondedDevices();
    }

    public BluetoothDevice getRemoteDevice(String str) {
        return this.bluetoothAdapter.getRemoteDevice(str);
    }

    public boolean hasBluetoothAdapter() {
        return this.bluetoothAdapter != null;
    }

    public boolean isBluetoothEnabled() {
        BluetoothAdapter bluetoothAdapter = this.bluetoothAdapter;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    @TargetApi(21)
    public void startLeScan(List<ScanFilter> list, ScanSettings scanSettings, ScanCallback scanCallback) {
        this.bluetoothAdapter.getBluetoothLeScanner().startScan(list, scanSettings, scanCallback);
    }

    public boolean startLegacyLeScan(BluetoothAdapter.LeScanCallback leScanCallback) {
        return this.bluetoothAdapter.startLeScan(leScanCallback);
    }

    @RequiresApi(26)
    public void stopLeScan(PendingIntent pendingIntent) {
        this.bluetoothAdapter.getBluetoothLeScanner().stopScan(pendingIntent);
    }

    public void stopLegacyLeScan(BluetoothAdapter.LeScanCallback leScanCallback) {
        this.bluetoothAdapter.stopLeScan(leScanCallback);
    }

    @RequiresApi(26)
    public int startLeScan(List<ScanFilter> list, ScanSettings scanSettings, PendingIntent pendingIntent) {
        return this.bluetoothAdapter.getBluetoothLeScanner().startScan((List<ScanFilter>) list, scanSettings, pendingIntent);
    }

    @TargetApi(21)
    public void stopLeScan(ScanCallback scanCallback) {
        if (!this.bluetoothAdapter.isEnabled()) {
            RxBleLog.v("BluetoothAdapter is disabled, calling BluetoothLeScanner.stopScan(ScanCallback) may cause IllegalStateException", new Object[0]);
            return;
        }
        BluetoothLeScanner bluetoothLeScanner = this.bluetoothAdapter.getBluetoothLeScanner();
        if (bluetoothLeScanner == null) {
            RxBleLog.w("Cannot call BluetoothLeScanner.stopScan(ScanCallback) on 'null' reference; BluetoothAdapter.isEnabled() == %b", Boolean.valueOf(this.bluetoothAdapter.isEnabled()));
        } else {
            bluetoothLeScanner.stopScan(scanCallback);
        }
    }
}
