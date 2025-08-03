package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ReadRssiOperation_Factory implements InterfaceC3628<ReadRssiOperation> {
    private final InterfaceC4461<RxBleGattCallback> bleGattCallbackProvider;
    private final InterfaceC4461<BluetoothGatt> bluetoothGattProvider;
    private final InterfaceC4461<TimeoutConfiguration> timeoutConfigurationProvider;

    public ReadRssiOperation_Factory(InterfaceC4461<RxBleGattCallback> interfaceC4461, InterfaceC4461<BluetoothGatt> interfaceC44612, InterfaceC4461<TimeoutConfiguration> interfaceC44613) {
        this.bleGattCallbackProvider = interfaceC4461;
        this.bluetoothGattProvider = interfaceC44612;
        this.timeoutConfigurationProvider = interfaceC44613;
    }

    public static ReadRssiOperation_Factory create(InterfaceC4461<RxBleGattCallback> interfaceC4461, InterfaceC4461<BluetoothGatt> interfaceC44612, InterfaceC4461<TimeoutConfiguration> interfaceC44613) {
        return new ReadRssiOperation_Factory(interfaceC4461, interfaceC44612, interfaceC44613);
    }

    public static ReadRssiOperation newReadRssiOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, TimeoutConfiguration timeoutConfiguration) {
        return new ReadRssiOperation(rxBleGattCallback, bluetoothGatt, timeoutConfiguration);
    }

    @Override // defpackage.InterfaceC4461
    public ReadRssiOperation get() {
        return new ReadRssiOperation(this.bleGattCallbackProvider.get(), this.bluetoothGattProvider.get(), this.timeoutConfigurationProvider.get());
    }
}
