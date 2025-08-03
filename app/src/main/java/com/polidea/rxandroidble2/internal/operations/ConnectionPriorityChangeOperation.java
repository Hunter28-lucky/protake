package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import androidx.annotation.RequiresApi;
import com.polidea.rxandroidble2.exceptions.BleGattCannotStartException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.SingleResponseOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import defpackage.AbstractC4838;

/* loaded from: classes2.dex */
public class ConnectionPriorityChangeOperation extends SingleResponseOperation<Long> {
    private final int connectionPriority;
    private final TimeoutConfiguration successTimeoutConfiguration;

    public ConnectionPriorityChangeOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, TimeoutConfiguration timeoutConfiguration, int i, TimeoutConfiguration timeoutConfiguration2) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.CONNECTION_PRIORITY_CHANGE, timeoutConfiguration);
        this.connectionPriority = i;
        this.successTimeoutConfiguration = timeoutConfiguration2;
    }

    private static String connectionPriorityToString(int i) {
        return i != 0 ? i != 2 ? "CONNECTION_PRIORITY_HIGH" : "CONNECTION_PRIORITY_LOW_POWER" : "CONNECTION_PRIORITY_BALANCED";
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public AbstractC4838<Long> getCallback(RxBleGattCallback rxBleGattCallback) {
        TimeoutConfiguration timeoutConfiguration = this.successTimeoutConfiguration;
        return AbstractC4838.timer(timeoutConfiguration.timeout, timeoutConfiguration.timeoutTimeUnit, timeoutConfiguration.timeoutScheduler);
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    @RequiresApi(21)
    public boolean startOperation(BluetoothGatt bluetoothGatt) throws BleGattCannotStartException, IllegalArgumentException {
        return bluetoothGatt.requestConnectionPriority(this.connectionPriority);
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public String toString() {
        return "ConnectionPriorityChangeOperation{" + super.toString() + ", connectionPriority=" + connectionPriorityToString(this.connectionPriority) + ", successTimeout=" + this.successTimeoutConfiguration + '}';
    }
}
