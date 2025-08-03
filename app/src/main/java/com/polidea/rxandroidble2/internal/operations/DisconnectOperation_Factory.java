package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothManager;
import com.polidea.rxandroidble2.internal.connection.BluetoothGattProvider;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import defpackage.AbstractC4585;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class DisconnectOperation_Factory implements InterfaceC3628<DisconnectOperation> {
    private final InterfaceC4461<BluetoothGattProvider> bluetoothGattProvider;
    private final InterfaceC4461<AbstractC4585> bluetoothInteractionSchedulerProvider;
    private final InterfaceC4461<BluetoothManager> bluetoothManagerProvider;
    private final InterfaceC4461<ConnectionStateChangeListener> connectionStateChangeListenerProvider;
    private final InterfaceC4461<String> macAddressProvider;
    private final InterfaceC4461<RxBleGattCallback> rxBleGattCallbackProvider;
    private final InterfaceC4461<TimeoutConfiguration> timeoutConfigurationProvider;

    public DisconnectOperation_Factory(InterfaceC4461<RxBleGattCallback> interfaceC4461, InterfaceC4461<BluetoothGattProvider> interfaceC44612, InterfaceC4461<String> interfaceC44613, InterfaceC4461<BluetoothManager> interfaceC44614, InterfaceC4461<AbstractC4585> interfaceC44615, InterfaceC4461<TimeoutConfiguration> interfaceC44616, InterfaceC4461<ConnectionStateChangeListener> interfaceC44617) {
        this.rxBleGattCallbackProvider = interfaceC4461;
        this.bluetoothGattProvider = interfaceC44612;
        this.macAddressProvider = interfaceC44613;
        this.bluetoothManagerProvider = interfaceC44614;
        this.bluetoothInteractionSchedulerProvider = interfaceC44615;
        this.timeoutConfigurationProvider = interfaceC44616;
        this.connectionStateChangeListenerProvider = interfaceC44617;
    }

    public static DisconnectOperation_Factory create(InterfaceC4461<RxBleGattCallback> interfaceC4461, InterfaceC4461<BluetoothGattProvider> interfaceC44612, InterfaceC4461<String> interfaceC44613, InterfaceC4461<BluetoothManager> interfaceC44614, InterfaceC4461<AbstractC4585> interfaceC44615, InterfaceC4461<TimeoutConfiguration> interfaceC44616, InterfaceC4461<ConnectionStateChangeListener> interfaceC44617) {
        return new DisconnectOperation_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614, interfaceC44615, interfaceC44616, interfaceC44617);
    }

    public static DisconnectOperation newDisconnectOperation(RxBleGattCallback rxBleGattCallback, BluetoothGattProvider bluetoothGattProvider, String str, BluetoothManager bluetoothManager, AbstractC4585 abstractC4585, TimeoutConfiguration timeoutConfiguration, ConnectionStateChangeListener connectionStateChangeListener) {
        return new DisconnectOperation(rxBleGattCallback, bluetoothGattProvider, str, bluetoothManager, abstractC4585, timeoutConfiguration, connectionStateChangeListener);
    }

    @Override // defpackage.InterfaceC4461
    public DisconnectOperation get() {
        return new DisconnectOperation(this.rxBleGattCallbackProvider.get(), this.bluetoothGattProvider.get(), this.macAddressProvider.get(), this.bluetoothManagerProvider.get(), this.bluetoothInteractionSchedulerProvider.get(), this.timeoutConfigurationProvider.get(), this.connectionStateChangeListenerProvider.get());
    }
}
