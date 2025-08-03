package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.SingleResponseOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.util.ByteAssociationUtil;
import defpackage.AbstractC4838;

/* loaded from: classes2.dex */
public class DescriptorWriteOperation extends SingleResponseOperation<byte[]> {
    private final int bluetoothGattCharacteristicDefaultWriteType;
    private final BluetoothGattDescriptor bluetoothGattDescriptor;
    private final byte[] data;

    public DescriptorWriteOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, TimeoutConfiguration timeoutConfiguration, int i, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.DESCRIPTOR_WRITE, timeoutConfiguration);
        this.bluetoothGattCharacteristicDefaultWriteType = i;
        this.bluetoothGattDescriptor = bluetoothGattDescriptor;
        this.data = bArr;
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public AbstractC4838<byte[]> getCallback(RxBleGattCallback rxBleGattCallback) {
        return rxBleGattCallback.getOnDescriptorWrite().filter(ByteAssociationUtil.descriptorPredicate(this.bluetoothGattDescriptor)).firstOrError().map(ByteAssociationUtil.getBytesFromAssociation());
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public boolean startOperation(BluetoothGatt bluetoothGatt) {
        this.bluetoothGattDescriptor.setValue(this.data);
        BluetoothGattCharacteristic characteristic = this.bluetoothGattDescriptor.getCharacteristic();
        int writeType = characteristic.getWriteType();
        characteristic.setWriteType(this.bluetoothGattCharacteristicDefaultWriteType);
        boolean zWriteDescriptor = bluetoothGatt.writeDescriptor(this.bluetoothGattDescriptor);
        characteristic.setWriteType(writeType);
        return zWriteDescriptor;
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public String toString() {
        return "DescriptorWriteOperation{" + super.toString() + ", descriptor=" + new LoggerUtil.AttributeLogWrapper(this.bluetoothGattDescriptor.getUuid(), this.data, true) + '}';
    }
}
