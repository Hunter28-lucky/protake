package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothDevice;
import com.polidea.rxandroidble2.internal.connection.BluetoothGattProvider;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.util.BleConnectionCompat;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ConnectOperation_Factory implements InterfaceC3628<ConnectOperation> {
    private final InterfaceC4461<Boolean> autoConnectProvider;
    private final InterfaceC4461<BluetoothDevice> bluetoothDeviceProvider;
    private final InterfaceC4461<BluetoothGattProvider> bluetoothGattProvider;
    private final InterfaceC4461<TimeoutConfiguration> connectTimeoutProvider;
    private final InterfaceC4461<BleConnectionCompat> connectionCompatProvider;
    private final InterfaceC4461<ConnectionStateChangeListener> connectionStateChangedActionProvider;
    private final InterfaceC4461<RxBleGattCallback> rxBleGattCallbackProvider;

    public ConnectOperation_Factory(InterfaceC4461<BluetoothDevice> interfaceC4461, InterfaceC4461<BleConnectionCompat> interfaceC44612, InterfaceC4461<RxBleGattCallback> interfaceC44613, InterfaceC4461<BluetoothGattProvider> interfaceC44614, InterfaceC4461<TimeoutConfiguration> interfaceC44615, InterfaceC4461<Boolean> interfaceC44616, InterfaceC4461<ConnectionStateChangeListener> interfaceC44617) {
        this.bluetoothDeviceProvider = interfaceC4461;
        this.connectionCompatProvider = interfaceC44612;
        this.rxBleGattCallbackProvider = interfaceC44613;
        this.bluetoothGattProvider = interfaceC44614;
        this.connectTimeoutProvider = interfaceC44615;
        this.autoConnectProvider = interfaceC44616;
        this.connectionStateChangedActionProvider = interfaceC44617;
    }

    public static ConnectOperation_Factory create(InterfaceC4461<BluetoothDevice> interfaceC4461, InterfaceC4461<BleConnectionCompat> interfaceC44612, InterfaceC4461<RxBleGattCallback> interfaceC44613, InterfaceC4461<BluetoothGattProvider> interfaceC44614, InterfaceC4461<TimeoutConfiguration> interfaceC44615, InterfaceC4461<Boolean> interfaceC44616, InterfaceC4461<ConnectionStateChangeListener> interfaceC44617) {
        return new ConnectOperation_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614, interfaceC44615, interfaceC44616, interfaceC44617);
    }

    public static ConnectOperation newConnectOperation(BluetoothDevice bluetoothDevice, BleConnectionCompat bleConnectionCompat, RxBleGattCallback rxBleGattCallback, BluetoothGattProvider bluetoothGattProvider, TimeoutConfiguration timeoutConfiguration, boolean z, ConnectionStateChangeListener connectionStateChangeListener) {
        return new ConnectOperation(bluetoothDevice, bleConnectionCompat, rxBleGattCallback, bluetoothGattProvider, timeoutConfiguration, z, connectionStateChangeListener);
    }

    @Override // defpackage.InterfaceC4461
    public ConnectOperation get() {
        return new ConnectOperation(this.bluetoothDeviceProvider.get(), this.connectionCompatProvider.get(), this.rxBleGattCallbackProvider.get(), this.bluetoothGattProvider.get(), this.connectTimeoutProvider.get(), this.autoConnectProvider.get().booleanValue(), this.connectionStateChangedActionProvider.get());
    }
}
