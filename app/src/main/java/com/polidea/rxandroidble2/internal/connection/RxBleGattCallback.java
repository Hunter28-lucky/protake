package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.polidea.rxandroidble2.ConnectionParameters;
import com.polidea.rxandroidble2.HiddenBluetoothGattCallback;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleGattCharacteristicException;
import com.polidea.rxandroidble2.exceptions.BleGattDescriptorException;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.util.ByteAssociation;
import com.polidea.rxandroidble2.internal.util.CharacteristicChangedEvent;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.InterfaceC2368;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@ConnectionScope
/* loaded from: classes2.dex */
public class RxBleGattCallback {
    public final BluetoothGattProvider bluetoothGattProvider;
    private final AbstractC4585 callbackScheduler;
    public final DisconnectionRouter disconnectionRouter;
    public final NativeCallbackDispatcher nativeCallbackDispatcher;
    public final PublishRelay<RxBleConnection.RxBleConnectionState> connectionStatePublishRelay = PublishRelay.create();
    public final Output<RxBleDeviceServices> servicesDiscoveredOutput = new Output<>();
    public final Output<ByteAssociation<UUID>> readCharacteristicOutput = new Output<>();
    public final Output<ByteAssociation<UUID>> writeCharacteristicOutput = new Output<>();
    public final Relay<CharacteristicChangedEvent> changedCharacteristicSerializedPublishRelay = PublishRelay.create().toSerialized();
    public final Output<ByteAssociation<BluetoothGattDescriptor>> readDescriptorOutput = new Output<>();
    public final Output<ByteAssociation<BluetoothGattDescriptor>> writeDescriptorOutput = new Output<>();
    public final Output<Integer> readRssiOutput = new Output<>();
    public final Output<Integer> changedMtuOutput = new Output<>();
    public final Output<ConnectionParameters> updatedConnectionOutput = new Output<>();
    private final InterfaceC2368<BleGattException, AbstractC4262<?>> errorMapper = new InterfaceC2368<BleGattException, AbstractC4262<?>>() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleGattCallback.1
        @Override // defpackage.InterfaceC2368
        public AbstractC4262<?> apply(BleGattException bleGattException) {
            return AbstractC4262.error(bleGattException);
        }
    };
    private final BluetoothGattCallback bluetoothGattCallback = new BluetoothGattCallback() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleGattCallback.2
        private boolean isDisconnectedOrDisconnecting(int i) {
            return i == 0 || i == 3;
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            LoggerUtil.logCallback("onCharacteristicChanged", bluetoothGatt, bluetoothGattCharacteristic, true);
            RxBleGattCallback.this.nativeCallbackDispatcher.notifyNativeChangedCallback(bluetoothGatt, bluetoothGattCharacteristic);
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            if (RxBleGattCallback.this.changedCharacteristicSerializedPublishRelay.hasObservers()) {
                RxBleGattCallback.this.changedCharacteristicSerializedPublishRelay.accept(new CharacteristicChangedEvent(bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getValue()));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            LoggerUtil.logCallback("onCharacteristicRead", bluetoothGatt, i, bluetoothGattCharacteristic, true);
            RxBleGattCallback.this.nativeCallbackDispatcher.notifyNativeReadCallback(bluetoothGatt, bluetoothGattCharacteristic, i);
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            if (!RxBleGattCallback.this.readCharacteristicOutput.hasObservers() || RxBleGattCallback.propagateErrorIfOccurred(RxBleGattCallback.this.readCharacteristicOutput, bluetoothGatt, bluetoothGattCharacteristic, i, BleGattOperationType.CHARACTERISTIC_READ)) {
                return;
            }
            RxBleGattCallback.this.readCharacteristicOutput.valueRelay.accept(new ByteAssociation<>(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue()));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            LoggerUtil.logCallback("onCharacteristicWrite", bluetoothGatt, i, bluetoothGattCharacteristic, false);
            RxBleGattCallback.this.nativeCallbackDispatcher.notifyNativeWriteCallback(bluetoothGatt, bluetoothGattCharacteristic, i);
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            if (!RxBleGattCallback.this.writeCharacteristicOutput.hasObservers() || RxBleGattCallback.propagateErrorIfOccurred(RxBleGattCallback.this.writeCharacteristicOutput, bluetoothGatt, bluetoothGattCharacteristic, i, BleGattOperationType.CHARACTERISTIC_WRITE)) {
                return;
            }
            RxBleGattCallback.this.writeCharacteristicOutput.valueRelay.accept(new ByteAssociation<>(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue()));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            LoggerUtil.logCallback("onConnectionStateChange", bluetoothGatt, i, i2);
            RxBleGattCallback.this.nativeCallbackDispatcher.notifyNativeConnectionStateCallback(bluetoothGatt, i, i2);
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            RxBleGattCallback.this.bluetoothGattProvider.updateBluetoothGatt(bluetoothGatt);
            if (isDisconnectedOrDisconnecting(i2)) {
                RxBleGattCallback.this.disconnectionRouter.onDisconnectedException(new BleDisconnectedException(bluetoothGatt.getDevice().getAddress(), i));
            } else if (i != 0) {
                RxBleGattCallback.this.disconnectionRouter.onGattConnectionStateException(new BleGattException(bluetoothGatt, i, BleGattOperationType.CONNECTION_STATE));
            }
            RxBleGattCallback.this.connectionStatePublishRelay.accept(RxBleGattCallback.mapConnectionStateToRxBleConnectionStatus(i2));
        }

        public void onConnectionUpdated(BluetoothGatt bluetoothGatt, int i, int i2, int i3, int i4) {
            LoggerUtil.logConnectionUpdateCallback("onConnectionUpdated", bluetoothGatt, i4, i, i2, i3);
            RxBleGattCallback.this.nativeCallbackDispatcher.notifyNativeParamsUpdateCallback(bluetoothGatt, i, i2, i3, i4);
            if (!RxBleGattCallback.this.updatedConnectionOutput.hasObservers() || RxBleGattCallback.propagateErrorIfOccurred(RxBleGattCallback.this.updatedConnectionOutput, bluetoothGatt, i4, BleGattOperationType.CONNECTION_PRIORITY_CHANGE)) {
                return;
            }
            RxBleGattCallback.this.updatedConnectionOutput.valueRelay.accept(new ConnectionParametersImpl(i, i2, i3));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            LoggerUtil.logCallback("onDescriptorRead", bluetoothGatt, i, bluetoothGattDescriptor, true);
            RxBleGattCallback.this.nativeCallbackDispatcher.notifyNativeDescriptorReadCallback(bluetoothGatt, bluetoothGattDescriptor, i);
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
            if (!RxBleGattCallback.this.readDescriptorOutput.hasObservers() || RxBleGattCallback.propagateErrorIfOccurred(RxBleGattCallback.this.readDescriptorOutput, bluetoothGatt, bluetoothGattDescriptor, i, BleGattOperationType.DESCRIPTOR_READ)) {
                return;
            }
            RxBleGattCallback.this.readDescriptorOutput.valueRelay.accept(new ByteAssociation<>(bluetoothGattDescriptor, bluetoothGattDescriptor.getValue()));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            LoggerUtil.logCallback("onDescriptorWrite", bluetoothGatt, i, bluetoothGattDescriptor, false);
            RxBleGattCallback.this.nativeCallbackDispatcher.notifyNativeDescriptorWriteCallback(bluetoothGatt, bluetoothGattDescriptor, i);
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            if (!RxBleGattCallback.this.writeDescriptorOutput.hasObservers() || RxBleGattCallback.propagateErrorIfOccurred(RxBleGattCallback.this.writeDescriptorOutput, bluetoothGatt, bluetoothGattDescriptor, i, BleGattOperationType.DESCRIPTOR_WRITE)) {
                return;
            }
            RxBleGattCallback.this.writeDescriptorOutput.valueRelay.accept(new ByteAssociation<>(bluetoothGattDescriptor, bluetoothGattDescriptor.getValue()));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            LoggerUtil.logCallback("onMtuChanged", bluetoothGatt, i2, i);
            RxBleGattCallback.this.nativeCallbackDispatcher.notifyNativeMtuChangedCallback(bluetoothGatt, i, i2);
            super.onMtuChanged(bluetoothGatt, i, i2);
            if (!RxBleGattCallback.this.changedMtuOutput.hasObservers() || RxBleGattCallback.propagateErrorIfOccurred(RxBleGattCallback.this.changedMtuOutput, bluetoothGatt, i2, BleGattOperationType.ON_MTU_CHANGED)) {
                return;
            }
            RxBleGattCallback.this.changedMtuOutput.valueRelay.accept(Integer.valueOf(i));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            LoggerUtil.logCallback("onReadRemoteRssi", bluetoothGatt, i2, i);
            RxBleGattCallback.this.nativeCallbackDispatcher.notifyNativeReadRssiCallback(bluetoothGatt, i, i2);
            super.onReadRemoteRssi(bluetoothGatt, i, i2);
            if (!RxBleGattCallback.this.readRssiOutput.hasObservers() || RxBleGattCallback.propagateErrorIfOccurred(RxBleGattCallback.this.readRssiOutput, bluetoothGatt, i2, BleGattOperationType.READ_RSSI)) {
                return;
            }
            RxBleGattCallback.this.readRssiOutput.valueRelay.accept(Integer.valueOf(i));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
            LoggerUtil.logCallback("onReliableWriteCompleted", bluetoothGatt, i);
            RxBleGattCallback.this.nativeCallbackDispatcher.notifyNativeReliableWriteCallback(bluetoothGatt, i);
            super.onReliableWriteCompleted(bluetoothGatt, i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            LoggerUtil.logCallback("onServicesDiscovered", bluetoothGatt, i);
            RxBleGattCallback.this.nativeCallbackDispatcher.notifyNativeServicesDiscoveredCallback(bluetoothGatt, i);
            super.onServicesDiscovered(bluetoothGatt, i);
            if (!RxBleGattCallback.this.servicesDiscoveredOutput.hasObservers() || RxBleGattCallback.propagateErrorIfOccurred(RxBleGattCallback.this.servicesDiscoveredOutput, bluetoothGatt, i, BleGattOperationType.SERVICE_DISCOVERY)) {
                return;
            }
            RxBleGattCallback.this.servicesDiscoveredOutput.valueRelay.accept(new RxBleDeviceServices(bluetoothGatt.getServices()));
        }
    };

    public static class Output<T> {
        public final PublishRelay<T> valueRelay = PublishRelay.create();
        public final PublishRelay<BleGattException> errorRelay = PublishRelay.create();

        public boolean hasObservers() {
            return this.valueRelay.hasObservers() || this.errorRelay.hasObservers();
        }
    }

    public RxBleGattCallback(AbstractC4585 abstractC4585, BluetoothGattProvider bluetoothGattProvider, DisconnectionRouter disconnectionRouter, NativeCallbackDispatcher nativeCallbackDispatcher) {
        this.callbackScheduler = abstractC4585;
        this.bluetoothGattProvider = bluetoothGattProvider;
        this.disconnectionRouter = disconnectionRouter;
        this.nativeCallbackDispatcher = nativeCallbackDispatcher;
    }

    private static boolean isException(int i) {
        return i != 0;
    }

    public static RxBleConnection.RxBleConnectionState mapConnectionStateToRxBleConnectionStatus(int i) {
        return i != 1 ? i != 2 ? i != 3 ? RxBleConnection.RxBleConnectionState.DISCONNECTED : RxBleConnection.RxBleConnectionState.DISCONNECTING : RxBleConnection.RxBleConnectionState.CONNECTED : RxBleConnection.RxBleConnectionState.CONNECTING;
    }

    public static boolean propagateErrorIfOccurred(Output<?> output, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, BleGattOperationType bleGattOperationType) {
        return isException(i) && propagateStatusError(output, new BleGattCharacteristicException(bluetoothGatt, bluetoothGattCharacteristic, i, bleGattOperationType));
    }

    private static boolean propagateStatusError(Output<?> output, BleGattException bleGattException) {
        output.errorRelay.accept(bleGattException);
        return true;
    }

    private <T> AbstractC4262<T> withDisconnectionHandling(Output<T> output) {
        return AbstractC4262.merge(this.disconnectionRouter.asErrorOnlyObservable(), output.valueRelay, output.errorRelay.flatMap(this.errorMapper));
    }

    public BluetoothGattCallback getBluetoothGattCallback() {
        return this.bluetoothGattCallback;
    }

    public AbstractC4262<ConnectionParameters> getConnectionParametersUpdates() {
        return withDisconnectionHandling(this.updatedConnectionOutput).delay(0L, TimeUnit.SECONDS, this.callbackScheduler);
    }

    public AbstractC4262<CharacteristicChangedEvent> getOnCharacteristicChanged() {
        return AbstractC4262.merge(this.disconnectionRouter.asErrorOnlyObservable(), this.changedCharacteristicSerializedPublishRelay).delay(0L, TimeUnit.SECONDS, this.callbackScheduler);
    }

    public AbstractC4262<ByteAssociation<UUID>> getOnCharacteristicRead() {
        return withDisconnectionHandling(this.readCharacteristicOutput).delay(0L, TimeUnit.SECONDS, this.callbackScheduler);
    }

    public AbstractC4262<ByteAssociation<UUID>> getOnCharacteristicWrite() {
        return withDisconnectionHandling(this.writeCharacteristicOutput).delay(0L, TimeUnit.SECONDS, this.callbackScheduler);
    }

    public AbstractC4262<RxBleConnection.RxBleConnectionState> getOnConnectionStateChange() {
        return this.connectionStatePublishRelay.delay(0L, TimeUnit.SECONDS, this.callbackScheduler);
    }

    public AbstractC4262<ByteAssociation<BluetoothGattDescriptor>> getOnDescriptorRead() {
        return withDisconnectionHandling(this.readDescriptorOutput).delay(0L, TimeUnit.SECONDS, this.callbackScheduler);
    }

    public AbstractC4262<ByteAssociation<BluetoothGattDescriptor>> getOnDescriptorWrite() {
        return withDisconnectionHandling(this.writeDescriptorOutput).delay(0L, TimeUnit.SECONDS, this.callbackScheduler);
    }

    public AbstractC4262<Integer> getOnMtuChanged() {
        return withDisconnectionHandling(this.changedMtuOutput).delay(0L, TimeUnit.SECONDS, this.callbackScheduler);
    }

    public AbstractC4262<Integer> getOnRssiRead() {
        return withDisconnectionHandling(this.readRssiOutput).delay(0L, TimeUnit.SECONDS, this.callbackScheduler);
    }

    public AbstractC4262<RxBleDeviceServices> getOnServicesDiscovered() {
        return withDisconnectionHandling(this.servicesDiscoveredOutput).delay(0L, TimeUnit.SECONDS, this.callbackScheduler);
    }

    public <T> AbstractC4262<T> observeDisconnect() {
        return this.disconnectionRouter.asErrorOnlyObservable();
    }

    public void setHiddenNativeCallback(HiddenBluetoothGattCallback hiddenBluetoothGattCallback) {
        this.nativeCallbackDispatcher.setNativeCallbackHidden(hiddenBluetoothGattCallback);
    }

    public void setNativeCallback(BluetoothGattCallback bluetoothGattCallback) {
        this.nativeCallbackDispatcher.setNativeCallback(bluetoothGattCallback);
    }

    public static boolean propagateErrorIfOccurred(Output<?> output, BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i, BleGattOperationType bleGattOperationType) {
        return isException(i) && propagateStatusError(output, new BleGattDescriptorException(bluetoothGatt, bluetoothGattDescriptor, i, bleGattOperationType));
    }

    public static boolean propagateErrorIfOccurred(Output<?> output, BluetoothGatt bluetoothGatt, int i, BleGattOperationType bleGattOperationType) {
        return isException(i) && propagateStatusError(output, new BleGattException(bluetoothGatt, i, bleGattOperationType));
    }
}
