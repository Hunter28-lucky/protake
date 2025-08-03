package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.os.DeadObjectException;
import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.internal.QueueOperation;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.connection.BluetoothGattProvider;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import defpackage.AbstractC4585;
import defpackage.AbstractC4838;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3487;
import defpackage.InterfaceC4178;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5245;

/* loaded from: classes2.dex */
public class DisconnectOperation extends QueueOperation<Void> {
    private final BluetoothGattProvider bluetoothGattProvider;
    private final AbstractC4585 bluetoothInteractionScheduler;
    private final BluetoothManager bluetoothManager;
    private final ConnectionStateChangeListener connectionStateChangeListener;
    private final String macAddress;
    private final RxBleGattCallback rxBleGattCallback;
    private final TimeoutConfiguration timeoutConfiguration;

    public static class DisconnectGattObservable extends AbstractC4838<BluetoothGatt> {
        public final BluetoothGatt bluetoothGatt;
        private final AbstractC4585 disconnectScheduler;
        private final RxBleGattCallback rxBleGattCallback;

        public DisconnectGattObservable(BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, AbstractC4585 abstractC4585) {
            this.bluetoothGatt = bluetoothGatt;
            this.rxBleGattCallback = rxBleGattCallback;
            this.disconnectScheduler = abstractC4585;
        }

        @Override // defpackage.AbstractC4838
        public void subscribeActual(InterfaceC4782<? super BluetoothGatt> interfaceC4782) {
            this.rxBleGattCallback.getOnConnectionStateChange().filter(new InterfaceC4178<RxBleConnection.RxBleConnectionState>() { // from class: com.polidea.rxandroidble2.internal.operations.DisconnectOperation.DisconnectGattObservable.2
                @Override // defpackage.InterfaceC4178
                public boolean test(RxBleConnection.RxBleConnectionState rxBleConnectionState) {
                    return rxBleConnectionState == RxBleConnection.RxBleConnectionState.DISCONNECTED;
                }
            }).firstOrError().map(new InterfaceC2368<RxBleConnection.RxBleConnectionState, BluetoothGatt>() { // from class: com.polidea.rxandroidble2.internal.operations.DisconnectOperation.DisconnectGattObservable.1
                @Override // defpackage.InterfaceC2368
                public BluetoothGatt apply(RxBleConnection.RxBleConnectionState rxBleConnectionState) {
                    return DisconnectGattObservable.this.bluetoothGatt;
                }
            }).subscribe(interfaceC4782);
            this.disconnectScheduler.mo6986().mo6990(new Runnable() { // from class: com.polidea.rxandroidble2.internal.operations.DisconnectOperation.DisconnectGattObservable.3
                @Override // java.lang.Runnable
                public void run() {
                    DisconnectGattObservable.this.bluetoothGatt.disconnect();
                }
            });
        }
    }

    public DisconnectOperation(RxBleGattCallback rxBleGattCallback, BluetoothGattProvider bluetoothGattProvider, String str, BluetoothManager bluetoothManager, AbstractC4585 abstractC4585, TimeoutConfiguration timeoutConfiguration, ConnectionStateChangeListener connectionStateChangeListener) {
        this.rxBleGattCallback = rxBleGattCallback;
        this.bluetoothGattProvider = bluetoothGattProvider;
        this.macAddress = str;
        this.bluetoothManager = bluetoothManager;
        this.bluetoothInteractionScheduler = abstractC4585;
        this.timeoutConfiguration = timeoutConfiguration;
        this.connectionStateChangeListener = connectionStateChangeListener;
    }

    private AbstractC4838<BluetoothGatt> disconnect(BluetoothGatt bluetoothGatt) {
        DisconnectGattObservable disconnectGattObservable = new DisconnectGattObservable(bluetoothGatt, this.rxBleGattCallback, this.bluetoothInteractionScheduler);
        TimeoutConfiguration timeoutConfiguration = this.timeoutConfiguration;
        return disconnectGattObservable.timeout(timeoutConfiguration.timeout, timeoutConfiguration.timeoutTimeUnit, timeoutConfiguration.timeoutScheduler, AbstractC4838.just(bluetoothGatt));
    }

    private AbstractC4838<BluetoothGatt> disconnectIfRequired(BluetoothGatt bluetoothGatt) {
        return isDisconnected(bluetoothGatt) ? AbstractC4838.just(bluetoothGatt) : disconnect(bluetoothGatt);
    }

    private boolean isDisconnected(BluetoothGatt bluetoothGatt) {
        return this.bluetoothManager.getConnectionState(bluetoothGatt.getDevice(), 7) == 0;
    }

    @RestrictTo({RestrictTo.Scope.SUBCLASSES})
    public void considerGattDisconnected(InterfaceC3487<Void> interfaceC3487, QueueReleaseInterface queueReleaseInterface) {
        this.connectionStateChangeListener.onConnectionStateChange(RxBleConnection.RxBleConnectionState.DISCONNECTED);
        queueReleaseInterface.release();
        interfaceC3487.onComplete();
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public void protectedRun(final InterfaceC5245<Void> interfaceC5245, final QueueReleaseInterface queueReleaseInterface) {
        this.connectionStateChangeListener.onConnectionStateChange(RxBleConnection.RxBleConnectionState.DISCONNECTING);
        BluetoothGatt bluetoothGatt = this.bluetoothGattProvider.getBluetoothGatt();
        if (bluetoothGatt != null) {
            disconnectIfRequired(bluetoothGatt).observeOn(this.bluetoothInteractionScheduler).subscribe(new InterfaceC4782<BluetoothGatt>() { // from class: com.polidea.rxandroidble2.internal.operations.DisconnectOperation.1
                @Override // defpackage.InterfaceC4782
                public void onError(Throwable th) {
                    RxBleLog.w(th, "Disconnect operation has been executed but finished with an error - considering disconnected.", new Object[0]);
                    DisconnectOperation.this.considerGattDisconnected(interfaceC5245, queueReleaseInterface);
                }

                @Override // defpackage.InterfaceC4782
                public void onSubscribe(InterfaceC4478 interfaceC4478) {
                }

                @Override // defpackage.InterfaceC4782
                public void onSuccess(BluetoothGatt bluetoothGatt2) {
                    bluetoothGatt2.close();
                    DisconnectOperation.this.considerGattDisconnected(interfaceC5245, queueReleaseInterface);
                }
            });
        } else {
            RxBleLog.w("Disconnect operation has been executed but GATT instance was null - considering disconnected.", new Object[0]);
            considerGattDisconnected(interfaceC5245, queueReleaseInterface);
        }
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public BleException provideException(DeadObjectException deadObjectException) {
        return new BleDisconnectedException(deadObjectException, this.macAddress, -1);
    }

    public String toString() {
        return "DisconnectOperation{" + LoggerUtil.commonMacMessage(this.macAddress) + '}';
    }
}
