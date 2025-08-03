package com.polidea.rxandroidble2.exceptions;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.utils.GattStatusParser;

/* loaded from: classes2.dex */
public class BleGattException extends BleException {
    public static final int UNKNOWN_STATUS = -1;
    private final BleGattOperationType bleGattOperationType;

    @Nullable
    private final BluetoothGatt gatt;
    private final int status;

    @Deprecated
    public BleGattException(int i, BleGattOperationType bleGattOperationType) {
        super(createMessage(null, i, bleGattOperationType));
        this.gatt = null;
        this.status = i;
        this.bleGattOperationType = bleGattOperationType;
    }

    @SuppressLint({"DefaultLocale"})
    private static String createMessage(@Nullable BluetoothGatt bluetoothGatt, int i, BleGattOperationType bleGattOperationType) {
        return i == -1 ? String.format("GATT exception from MAC address %s, with type %s", getMacAddress(bluetoothGatt), bleGattOperationType) : String.format("GATT exception from %s, status %d (%s), type %s. (Look up status 0x%02x here %s)", LoggerUtil.commonMacMessage(bluetoothGatt), Integer.valueOf(i), GattStatusParser.getGattCallbackStatusDescription(i), bleGattOperationType, Integer.valueOf(i), "https://android.googlesource.com/platform/external/bluetooth/bluedroid/+/android-5.1.0_r1/stack/include/gatt_api.h");
    }

    public BleGattOperationType getBleGattOperationType() {
        return this.bleGattOperationType;
    }

    public String getMacAddress() {
        return getMacAddress(this.gatt);
    }

    public int getStatus() {
        return this.status;
    }

    private static String getMacAddress(@Nullable BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt == null || bluetoothGatt.getDevice() == null) {
            return null;
        }
        return bluetoothGatt.getDevice().getAddress();
    }

    public BleGattException(@NonNull BluetoothGatt bluetoothGatt, int i, BleGattOperationType bleGattOperationType) {
        super(createMessage(bluetoothGatt, i, bleGattOperationType));
        this.gatt = bluetoothGatt;
        this.status = i;
        this.bleGattOperationType = bleGattOperationType;
    }

    public BleGattException(BluetoothGatt bluetoothGatt, BleGattOperationType bleGattOperationType) {
        this(bluetoothGatt, -1, bleGattOperationType);
    }
}
