package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.QueueOperation;
import com.polidea.rxandroidble2.internal.connection.BluetoothGattProvider;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import com.polidea.rxandroidble2.internal.util.BleConnectionCompat;
import com.polidea.rxandroidble2.internal.util.DisposableUtil;
import defpackage.AbstractC2349;
import defpackage.AbstractC4838;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4178;
import defpackage.InterfaceC4452;
import defpackage.InterfaceC4671;
import defpackage.InterfaceC4807;
import defpackage.InterfaceC5245;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class ConnectOperation extends QueueOperation<BluetoothGatt> {
    public final boolean autoConnect;
    public final BluetoothDevice bluetoothDevice;
    public final BluetoothGattProvider bluetoothGattProvider;
    public final TimeoutConfiguration connectTimeout;
    public final BleConnectionCompat connectionCompat;
    public final ConnectionStateChangeListener connectionStateChangedAction;
    public final RxBleGattCallback rxBleGattCallback;

    public ConnectOperation(BluetoothDevice bluetoothDevice, BleConnectionCompat bleConnectionCompat, RxBleGattCallback rxBleGattCallback, BluetoothGattProvider bluetoothGattProvider, TimeoutConfiguration timeoutConfiguration, boolean z, ConnectionStateChangeListener connectionStateChangeListener) {
        this.bluetoothDevice = bluetoothDevice;
        this.connectionCompat = bleConnectionCompat;
        this.rxBleGattCallback = rxBleGattCallback;
        this.bluetoothGattProvider = bluetoothGattProvider;
        this.connectTimeout = timeoutConfiguration;
        this.autoConnect = z;
        this.connectionStateChangedAction = connectionStateChangeListener;
    }

    @NonNull
    private AbstractC4838<BluetoothGatt> getConnectedBluetoothGatt() {
        return AbstractC4838.create(new InterfaceC4807<BluetoothGatt>() { // from class: com.polidea.rxandroidble2.internal.operations.ConnectOperation.4
            @Override // defpackage.InterfaceC4807
            public void subscribe(InterfaceC4671<BluetoothGatt> interfaceC4671) {
                interfaceC4671.mo6949((AbstractC2349) ConnectOperation.this.getBluetoothGattAndChangeStatusToConnected().delaySubscription(ConnectOperation.this.rxBleGattCallback.getOnConnectionStateChange().filter(new InterfaceC4178<RxBleConnection.RxBleConnectionState>() { // from class: com.polidea.rxandroidble2.internal.operations.ConnectOperation.4.1
                    @Override // defpackage.InterfaceC4178
                    public boolean test(RxBleConnection.RxBleConnectionState rxBleConnectionState) {
                        return rxBleConnectionState == RxBleConnection.RxBleConnectionState.CONNECTED;
                    }
                })).mergeWith(ConnectOperation.this.rxBleGattCallback.observeDisconnect().firstOrError()).firstOrError().subscribeWith(DisposableUtil.disposableSingleObserverFromEmitter(interfaceC4671)));
                ConnectOperation.this.connectionStateChangedAction.onConnectionStateChange(RxBleConnection.RxBleConnectionState.CONNECTING);
                ConnectOperation connectOperation = ConnectOperation.this;
                ConnectOperation.this.bluetoothGattProvider.updateBluetoothGatt(connectOperation.connectionCompat.connectGatt(connectOperation.bluetoothDevice, connectOperation.autoConnect, connectOperation.rxBleGattCallback.getBluetoothGattCallback()));
            }
        });
    }

    private InterfaceC4452<BluetoothGatt, BluetoothGatt> wrapWithTimeoutWhenNotAutoconnecting() {
        return new InterfaceC4452<BluetoothGatt, BluetoothGatt>() { // from class: com.polidea.rxandroidble2.internal.operations.ConnectOperation.2
            @Override // defpackage.InterfaceC4452
            public InterfaceC3951<BluetoothGatt> apply(AbstractC4838<BluetoothGatt> abstractC4838) {
                ConnectOperation connectOperation = ConnectOperation.this;
                if (connectOperation.autoConnect) {
                    return abstractC4838;
                }
                TimeoutConfiguration timeoutConfiguration = connectOperation.connectTimeout;
                return abstractC4838.timeout(timeoutConfiguration.timeout, timeoutConfiguration.timeoutTimeUnit, timeoutConfiguration.timeoutScheduler, connectOperation.prepareConnectionTimeoutError());
            }
        };
    }

    public AbstractC4838<BluetoothGatt> getBluetoothGattAndChangeStatusToConnected() {
        return AbstractC4838.fromCallable(new Callable<BluetoothGatt>() { // from class: com.polidea.rxandroidble2.internal.operations.ConnectOperation.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public BluetoothGatt call() {
                ConnectOperation.this.connectionStateChangedAction.onConnectionStateChange(RxBleConnection.RxBleConnectionState.CONNECTED);
                return ConnectOperation.this.bluetoothGattProvider.getBluetoothGatt();
            }
        });
    }

    @NonNull
    public AbstractC4838<BluetoothGatt> prepareConnectionTimeoutError() {
        return AbstractC4838.fromCallable(new Callable<BluetoothGatt>() { // from class: com.polidea.rxandroidble2.internal.operations.ConnectOperation.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public BluetoothGatt call() {
                throw new BleGattCallbackTimeoutException(ConnectOperation.this.bluetoothGattProvider.getBluetoothGatt(), BleGattOperationType.CONNECTION_STATE);
            }
        });
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public void protectedRun(InterfaceC5245<BluetoothGatt> interfaceC5245, final QueueReleaseInterface queueReleaseInterface) {
        interfaceC5245.mo6762((AbstractC2349) getConnectedBluetoothGatt().compose(wrapWithTimeoutWhenNotAutoconnecting()).doFinally(new InterfaceC3809() { // from class: com.polidea.rxandroidble2.internal.operations.ConnectOperation.1
            @Override // defpackage.InterfaceC3809
            public void run() {
                queueReleaseInterface.release();
            }
        }).subscribeWith(DisposableUtil.disposableSingleObserverFromEmitter(interfaceC5245)));
        if (this.autoConnect) {
            queueReleaseInterface.release();
        }
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public BleException provideException(DeadObjectException deadObjectException) {
        return new BleDisconnectedException(deadObjectException, this.bluetoothDevice.getAddress(), -1);
    }

    public String toString() {
        return "ConnectOperation{" + LoggerUtil.commonMacMessage(this.bluetoothDevice.getAddress()) + ", autoConnect=" + this.autoConnect + '}';
    }
}
