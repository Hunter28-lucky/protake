package com.polidea.rxandroidble2.internal;

import android.bluetooth.BluetoothGatt;
import android.os.DeadObjectException;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import com.polidea.rxandroidble2.exceptions.BleGattCannotStartException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import com.polidea.rxandroidble2.internal.util.QueueReleasingEmitterWrapper;
import defpackage.AbstractC4585;
import defpackage.AbstractC4838;
import defpackage.InterfaceC5245;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class SingleResponseOperation<T> extends QueueOperation<T> {
    private final BluetoothGatt bluetoothGatt;
    private final BleGattOperationType operationType;
    private final RxBleGattCallback rxBleGattCallback;
    private final TimeoutConfiguration timeoutConfiguration;

    public SingleResponseOperation(BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, BleGattOperationType bleGattOperationType, TimeoutConfiguration timeoutConfiguration) {
        this.bluetoothGatt = bluetoothGatt;
        this.rxBleGattCallback = rxBleGattCallback;
        this.operationType = bleGattOperationType;
        this.timeoutConfiguration = timeoutConfiguration;
    }

    public abstract AbstractC4838<T> getCallback(RxBleGattCallback rxBleGattCallback);

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public final void protectedRun(InterfaceC5245<T> interfaceC5245, QueueReleaseInterface queueReleaseInterface) {
        QueueReleasingEmitterWrapper queueReleasingEmitterWrapper = new QueueReleasingEmitterWrapper(interfaceC5245, queueReleaseInterface);
        AbstractC4838<T> callback = getCallback(this.rxBleGattCallback);
        TimeoutConfiguration timeoutConfiguration = this.timeoutConfiguration;
        long j = timeoutConfiguration.timeout;
        TimeUnit timeUnit = timeoutConfiguration.timeoutTimeUnit;
        AbstractC4585 abstractC4585 = timeoutConfiguration.timeoutScheduler;
        callback.timeout(j, timeUnit, abstractC4585, timeoutFallbackProcedure(this.bluetoothGatt, this.rxBleGattCallback, abstractC4585)).toObservable().subscribe(queueReleasingEmitterWrapper);
        if (startOperation(this.bluetoothGatt)) {
            return;
        }
        queueReleasingEmitterWrapper.cancel();
        queueReleasingEmitterWrapper.onError(new BleGattCannotStartException(this.bluetoothGatt, this.operationType));
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public BleException provideException(DeadObjectException deadObjectException) {
        return new BleDisconnectedException(deadObjectException, this.bluetoothGatt.getDevice().getAddress(), -1);
    }

    public abstract boolean startOperation(BluetoothGatt bluetoothGatt);

    public AbstractC4838<T> timeoutFallbackProcedure(BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, AbstractC4585 abstractC4585) {
        return AbstractC4838.error(new BleGattCallbackTimeoutException(this.bluetoothGatt, this.operationType));
    }

    public String toString() {
        return LoggerUtil.commonMacMessage(this.bluetoothGatt);
    }
}
