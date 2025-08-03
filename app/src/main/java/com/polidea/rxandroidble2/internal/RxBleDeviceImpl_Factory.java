package com.polidea.rxandroidble2.internal;

import android.bluetooth.BluetoothDevice;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.connection.Connector;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class RxBleDeviceImpl_Factory implements InterfaceC3628<RxBleDeviceImpl> {
    private final InterfaceC4461<BluetoothDevice> bluetoothDeviceProvider;
    private final InterfaceC4461<BehaviorRelay<RxBleConnection.RxBleConnectionState>> connectionStateRelayProvider;
    private final InterfaceC4461<Connector> connectorProvider;

    public RxBleDeviceImpl_Factory(InterfaceC4461<BluetoothDevice> interfaceC4461, InterfaceC4461<Connector> interfaceC44612, InterfaceC4461<BehaviorRelay<RxBleConnection.RxBleConnectionState>> interfaceC44613) {
        this.bluetoothDeviceProvider = interfaceC4461;
        this.connectorProvider = interfaceC44612;
        this.connectionStateRelayProvider = interfaceC44613;
    }

    public static RxBleDeviceImpl_Factory create(InterfaceC4461<BluetoothDevice> interfaceC4461, InterfaceC4461<Connector> interfaceC44612, InterfaceC4461<BehaviorRelay<RxBleConnection.RxBleConnectionState>> interfaceC44613) {
        return new RxBleDeviceImpl_Factory(interfaceC4461, interfaceC44612, interfaceC44613);
    }

    public static RxBleDeviceImpl newRxBleDeviceImpl(BluetoothDevice bluetoothDevice, Connector connector, BehaviorRelay<RxBleConnection.RxBleConnectionState> behaviorRelay) {
        return new RxBleDeviceImpl(bluetoothDevice, connector, behaviorRelay);
    }

    @Override // defpackage.InterfaceC4461
    public RxBleDeviceImpl get() {
        return new RxBleDeviceImpl(this.bluetoothDeviceProvider.get(), this.connectorProvider.get(), this.connectionStateRelayProvider.get());
    }
}
