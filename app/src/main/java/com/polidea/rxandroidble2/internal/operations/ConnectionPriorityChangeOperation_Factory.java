package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ConnectionPriorityChangeOperation_Factory implements InterfaceC3628<ConnectionPriorityChangeOperation> {
    private final InterfaceC4461<BluetoothGatt> bluetoothGattProvider;
    private final InterfaceC4461<Integer> connectionPriorityProvider;
    private final InterfaceC4461<RxBleGattCallback> rxBleGattCallbackProvider;
    private final InterfaceC4461<TimeoutConfiguration> successTimeoutConfigurationAndTimeoutConfigurationProvider;

    public ConnectionPriorityChangeOperation_Factory(InterfaceC4461<RxBleGattCallback> interfaceC4461, InterfaceC4461<BluetoothGatt> interfaceC44612, InterfaceC4461<TimeoutConfiguration> interfaceC44613, InterfaceC4461<Integer> interfaceC44614) {
        this.rxBleGattCallbackProvider = interfaceC4461;
        this.bluetoothGattProvider = interfaceC44612;
        this.successTimeoutConfigurationAndTimeoutConfigurationProvider = interfaceC44613;
        this.connectionPriorityProvider = interfaceC44614;
    }

    public static ConnectionPriorityChangeOperation_Factory create(InterfaceC4461<RxBleGattCallback> interfaceC4461, InterfaceC4461<BluetoothGatt> interfaceC44612, InterfaceC4461<TimeoutConfiguration> interfaceC44613, InterfaceC4461<Integer> interfaceC44614) {
        return new ConnectionPriorityChangeOperation_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614);
    }

    public static ConnectionPriorityChangeOperation newConnectionPriorityChangeOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, TimeoutConfiguration timeoutConfiguration, int i, TimeoutConfiguration timeoutConfiguration2) {
        return new ConnectionPriorityChangeOperation(rxBleGattCallback, bluetoothGatt, timeoutConfiguration, i, timeoutConfiguration2);
    }

    @Override // defpackage.InterfaceC4461
    public ConnectionPriorityChangeOperation get() {
        return new ConnectionPriorityChangeOperation(this.rxBleGattCallbackProvider.get(), this.bluetoothGattProvider.get(), this.successTimeoutConfigurationAndTimeoutConfigurationProvider.get(), this.connectionPriorityProvider.get().intValue(), this.successTimeoutConfigurationAndTimeoutConfigurationProvider.get());
    }
}
