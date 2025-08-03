package com.polidea.rxandroidble2.internal;

import android.bluetooth.BluetoothDevice;
import androidx.annotation.Nullable;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.ConnectionSetup;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.Timeout;
import com.polidea.rxandroidble2.exceptions.BleAlreadyConnectedException;
import com.polidea.rxandroidble2.internal.connection.Connector;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import defpackage.AbstractC4262;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC3809;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

@DeviceScope
/* loaded from: classes2.dex */
class RxBleDeviceImpl implements RxBleDevice {
    public final BluetoothDevice bluetoothDevice;
    private final BehaviorRelay<RxBleConnection.RxBleConnectionState> connectionStateRelay;
    public final Connector connector;
    public final AtomicBoolean isConnected = new AtomicBoolean(false);

    public RxBleDeviceImpl(BluetoothDevice bluetoothDevice, Connector connector, BehaviorRelay<RxBleConnection.RxBleConnectionState> behaviorRelay) {
        this.bluetoothDevice = bluetoothDevice;
        this.connector = connector;
        this.connectionStateRelay = behaviorRelay;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RxBleDeviceImpl) {
            return this.bluetoothDevice.equals(((RxBleDeviceImpl) obj).bluetoothDevice);
        }
        return false;
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public AbstractC4262<RxBleConnection> establishConnection(boolean z) {
        return establishConnection(new ConnectionSetup.Builder().setAutoConnect(z).setSuppressIllegalOperationCheck(true).build());
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public BluetoothDevice getBluetoothDevice() {
        return this.bluetoothDevice;
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public RxBleConnection.RxBleConnectionState getConnectionState() {
        return this.connectionStateRelay.getValue();
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public String getMacAddress() {
        return this.bluetoothDevice.getAddress();
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    @Nullable
    public String getName() {
        return this.bluetoothDevice.getName();
    }

    public int hashCode() {
        return this.bluetoothDevice.hashCode();
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public AbstractC4262<RxBleConnection.RxBleConnectionState> observeConnectionStateChanges() {
        return this.connectionStateRelay.distinctUntilChanged().skip(1L);
    }

    public String toString() {
        return "RxBleDeviceImpl{" + LoggerUtil.commonMacMessage(this.bluetoothDevice.getAddress()) + ", name=" + this.bluetoothDevice.getName() + '}';
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public AbstractC4262<RxBleConnection> establishConnection(boolean z, Timeout timeout) {
        return establishConnection(new ConnectionSetup.Builder().setAutoConnect(z).setOperationTimeout(timeout).setSuppressIllegalOperationCheck(true).build());
    }

    public AbstractC4262<RxBleConnection> establishConnection(final ConnectionSetup connectionSetup) {
        return AbstractC4262.defer(new Callable<InterfaceC2856<RxBleConnection>>() { // from class: com.polidea.rxandroidble2.internal.RxBleDeviceImpl.1
            @Override // java.util.concurrent.Callable
            public InterfaceC2856<RxBleConnection> call() {
                return RxBleDeviceImpl.this.isConnected.compareAndSet(false, true) ? RxBleDeviceImpl.this.connector.prepareConnection(connectionSetup).doFinally(new InterfaceC3809() { // from class: com.polidea.rxandroidble2.internal.RxBleDeviceImpl.1.1
                    @Override // defpackage.InterfaceC3809
                    public void run() {
                        RxBleDeviceImpl.this.isConnected.set(false);
                    }
                }) : AbstractC4262.error(new BleAlreadyConnectedException(RxBleDeviceImpl.this.bluetoothDevice.getAddress()));
            }
        });
    }
}
