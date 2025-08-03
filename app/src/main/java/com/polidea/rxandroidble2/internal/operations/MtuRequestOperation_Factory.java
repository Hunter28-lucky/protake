package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class MtuRequestOperation_Factory implements InterfaceC3628<MtuRequestOperation> {
    private final InterfaceC4461<BluetoothGatt> bluetoothGattProvider;
    private final InterfaceC4461<Integer> requestedMtuProvider;
    private final InterfaceC4461<RxBleGattCallback> rxBleGattCallbackProvider;
    private final InterfaceC4461<TimeoutConfiguration> timeoutConfigurationProvider;

    public MtuRequestOperation_Factory(InterfaceC4461<RxBleGattCallback> interfaceC4461, InterfaceC4461<BluetoothGatt> interfaceC44612, InterfaceC4461<TimeoutConfiguration> interfaceC44613, InterfaceC4461<Integer> interfaceC44614) {
        this.rxBleGattCallbackProvider = interfaceC4461;
        this.bluetoothGattProvider = interfaceC44612;
        this.timeoutConfigurationProvider = interfaceC44613;
        this.requestedMtuProvider = interfaceC44614;
    }

    public static MtuRequestOperation_Factory create(InterfaceC4461<RxBleGattCallback> interfaceC4461, InterfaceC4461<BluetoothGatt> interfaceC44612, InterfaceC4461<TimeoutConfiguration> interfaceC44613, InterfaceC4461<Integer> interfaceC44614) {
        return new MtuRequestOperation_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614);
    }

    public static MtuRequestOperation newMtuRequestOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, TimeoutConfiguration timeoutConfiguration, int i) {
        return new MtuRequestOperation(rxBleGattCallback, bluetoothGatt, timeoutConfiguration, i);
    }

    @Override // defpackage.InterfaceC4461
    public MtuRequestOperation get() {
        return new MtuRequestOperation(this.rxBleGattCallbackProvider.get(), this.bluetoothGattProvider.get(), this.timeoutConfigurationProvider.get(), this.requestedMtuProvider.get().intValue());
    }
}
