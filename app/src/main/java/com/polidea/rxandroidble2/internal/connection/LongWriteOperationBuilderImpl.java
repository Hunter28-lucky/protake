package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import defpackage.AbstractC4262;
import defpackage.AbstractC4838;
import defpackage.InterfaceC2368;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class LongWriteOperationBuilderImpl implements RxBleConnection.LongWriteOperationBuilder {
    public byte[] bytes;
    public PayloadSizeLimitProvider maxBatchSizeProvider;
    public final ConnectionOperationQueue operationQueue;
    public final OperationsProvider operationsProvider;
    private final RxBleConnection rxBleConnection;
    public RxBleConnection.WriteOperationAckStrategy writeOperationAckStrategy = new ImmediateSerializedBatchAckStrategy();
    public RxBleConnection.WriteOperationRetryStrategy writeOperationRetryStrategy = new NoRetryStrategy();
    private AbstractC4838<BluetoothGattCharacteristic> writtenCharacteristicObservable;

    public LongWriteOperationBuilderImpl(ConnectionOperationQueue connectionOperationQueue, MtuBasedPayloadSizeLimit mtuBasedPayloadSizeLimit, RxBleConnection rxBleConnection, OperationsProvider operationsProvider) {
        this.operationQueue = connectionOperationQueue;
        this.maxBatchSizeProvider = mtuBasedPayloadSizeLimit;
        this.rxBleConnection = rxBleConnection;
        this.operationsProvider = operationsProvider;
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection.LongWriteOperationBuilder
    public AbstractC4262<byte[]> build() {
        AbstractC4838<BluetoothGattCharacteristic> abstractC4838 = this.writtenCharacteristicObservable;
        if (abstractC4838 == null) {
            throw new IllegalArgumentException("setCharacteristicUuid() or setCharacteristic() needs to be called before build()");
        }
        if (this.bytes != null) {
            return abstractC4838.flatMapObservable(new InterfaceC2368<BluetoothGattCharacteristic, AbstractC4262<byte[]>>() { // from class: com.polidea.rxandroidble2.internal.connection.LongWriteOperationBuilderImpl.1
                @Override // defpackage.InterfaceC2368
                public AbstractC4262<byte[]> apply(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                    LongWriteOperationBuilderImpl longWriteOperationBuilderImpl = LongWriteOperationBuilderImpl.this;
                    return longWriteOperationBuilderImpl.operationQueue.queue(longWriteOperationBuilderImpl.operationsProvider.provideLongWriteOperation(bluetoothGattCharacteristic, longWriteOperationBuilderImpl.writeOperationAckStrategy, longWriteOperationBuilderImpl.writeOperationRetryStrategy, longWriteOperationBuilderImpl.maxBatchSizeProvider, longWriteOperationBuilderImpl.bytes));
                }
            });
        }
        throw new IllegalArgumentException("setBytes() needs to be called before build()");
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection.LongWriteOperationBuilder
    public RxBleConnection.LongWriteOperationBuilder setBytes(@NonNull byte[] bArr) {
        this.bytes = bArr;
        return this;
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection.LongWriteOperationBuilder
    public RxBleConnection.LongWriteOperationBuilder setCharacteristic(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.writtenCharacteristicObservable = AbstractC4838.just(bluetoothGattCharacteristic);
        return this;
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection.LongWriteOperationBuilder
    public RxBleConnection.LongWriteOperationBuilder setCharacteristicUuid(@NonNull UUID uuid) {
        this.writtenCharacteristicObservable = this.rxBleConnection.getCharacteristic(uuid);
        return this;
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection.LongWriteOperationBuilder
    public RxBleConnection.LongWriteOperationBuilder setMaxBatchSize(int i) {
        this.maxBatchSizeProvider = new ConstantPayloadSizeLimit(i);
        return this;
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection.LongWriteOperationBuilder
    public RxBleConnection.LongWriteOperationBuilder setWriteOperationAckStrategy(@NonNull RxBleConnection.WriteOperationAckStrategy writeOperationAckStrategy) {
        this.writeOperationAckStrategy = writeOperationAckStrategy;
        return this;
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection.LongWriteOperationBuilder
    public RxBleConnection.LongWriteOperationBuilder setWriteOperationRetryStrategy(@NonNull RxBleConnection.WriteOperationRetryStrategy writeOperationRetryStrategy) {
        this.writeOperationRetryStrategy = writeOperationRetryStrategy;
        return this;
    }
}
