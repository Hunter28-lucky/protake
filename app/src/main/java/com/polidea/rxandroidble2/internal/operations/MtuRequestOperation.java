package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import androidx.annotation.RequiresApi;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.SingleResponseOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import defpackage.AbstractC4838;

@RequiresApi(21)
/* loaded from: classes2.dex */
public class MtuRequestOperation extends SingleResponseOperation<Integer> {
    private final int mtu;

    public MtuRequestOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, TimeoutConfiguration timeoutConfiguration, int i) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.ON_MTU_CHANGED, timeoutConfiguration);
        this.mtu = i;
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public AbstractC4838<Integer> getCallback(RxBleGattCallback rxBleGattCallback) {
        return rxBleGattCallback.getOnMtuChanged().firstOrError();
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public boolean startOperation(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.requestMtu(this.mtu);
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public String toString() {
        return "MtuRequestOperation{" + super.toString() + ", mtu=" + this.mtu + '}';
    }
}
