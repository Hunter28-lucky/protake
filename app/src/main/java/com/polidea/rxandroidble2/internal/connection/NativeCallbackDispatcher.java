package com.polidea.rxandroidble2.internal.connection;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.rxandroidble2.HiddenBluetoothGattCallback;

/* loaded from: classes2.dex */
class NativeCallbackDispatcher {
    private BluetoothGattCallback nativeCallback;
    private HiddenBluetoothGattCallback nativeCallbackHidden;

    public void notifyNativeChangedCallback(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattCallback bluetoothGattCallback = this.nativeCallback;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        }
    }

    public void notifyNativeConnectionStateCallback(BluetoothGatt bluetoothGatt, int i, int i2) {
        BluetoothGattCallback bluetoothGattCallback = this.nativeCallback;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onConnectionStateChange(bluetoothGatt, i, i2);
        }
    }

    public void notifyNativeDescriptorReadCallback(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        BluetoothGattCallback bluetoothGattCallback = this.nativeCallback;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        }
    }

    public void notifyNativeDescriptorWriteCallback(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        BluetoothGattCallback bluetoothGattCallback = this.nativeCallback;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        }
    }

    @TargetApi(21)
    public void notifyNativeMtuChangedCallback(BluetoothGatt bluetoothGatt, int i, int i2) {
        BluetoothGattCallback bluetoothGattCallback = this.nativeCallback;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onMtuChanged(bluetoothGatt, i, i2);
        }
    }

    public void notifyNativeParamsUpdateCallback(BluetoothGatt bluetoothGatt, int i, int i2, int i3, int i4) {
        HiddenBluetoothGattCallback hiddenBluetoothGattCallback = this.nativeCallbackHidden;
        if (hiddenBluetoothGattCallback != null) {
            hiddenBluetoothGattCallback.onConnectionUpdated(bluetoothGatt, i, i2, i3, i4);
        }
    }

    public void notifyNativeReadCallback(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        BluetoothGattCallback bluetoothGattCallback = this.nativeCallback;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
    }

    public void notifyNativeReadRssiCallback(BluetoothGatt bluetoothGatt, int i, int i2) {
        BluetoothGattCallback bluetoothGattCallback = this.nativeCallback;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onReadRemoteRssi(bluetoothGatt, i, i2);
        }
    }

    public void notifyNativeReliableWriteCallback(BluetoothGatt bluetoothGatt, int i) {
        BluetoothGattCallback bluetoothGattCallback = this.nativeCallback;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onReliableWriteCompleted(bluetoothGatt, i);
        }
    }

    public void notifyNativeServicesDiscoveredCallback(BluetoothGatt bluetoothGatt, int i) {
        BluetoothGattCallback bluetoothGattCallback = this.nativeCallback;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onServicesDiscovered(bluetoothGatt, i);
        }
    }

    public void notifyNativeWriteCallback(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        BluetoothGattCallback bluetoothGattCallback = this.nativeCallback;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
    }

    public void setNativeCallback(BluetoothGattCallback bluetoothGattCallback) {
        this.nativeCallback = bluetoothGattCallback;
    }

    public void setNativeCallbackHidden(HiddenBluetoothGattCallback hiddenBluetoothGattCallback) {
        this.nativeCallbackHidden = hiddenBluetoothGattCallback;
    }
}
