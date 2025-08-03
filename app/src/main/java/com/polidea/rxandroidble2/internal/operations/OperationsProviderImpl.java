package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.annotation.RequiresApi;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.connection.PayloadSizeLimitProvider;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices;
import defpackage.AbstractC4585;
import defpackage.InterfaceC4461;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class OperationsProviderImpl implements OperationsProvider {
    private final LoggerUtilBluetoothServices bleServicesLogger;
    private final BluetoothGatt bluetoothGatt;
    private final AbstractC4585 bluetoothInteractionScheduler;
    private final InterfaceC4461<ReadRssiOperation> rssiReadOperationProvider;
    private final RxBleGattCallback rxBleGattCallback;
    private final TimeoutConfiguration timeoutConfiguration;
    private final AbstractC4585 timeoutScheduler;

    public OperationsProviderImpl(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, LoggerUtilBluetoothServices loggerUtilBluetoothServices, TimeoutConfiguration timeoutConfiguration, AbstractC4585 abstractC4585, AbstractC4585 abstractC45852, InterfaceC4461<ReadRssiOperation> interfaceC4461) {
        this.rxBleGattCallback = rxBleGattCallback;
        this.bluetoothGatt = bluetoothGatt;
        this.bleServicesLogger = loggerUtilBluetoothServices;
        this.timeoutConfiguration = timeoutConfiguration;
        this.bluetoothInteractionScheduler = abstractC4585;
        this.timeoutScheduler = abstractC45852;
        this.rssiReadOperationProvider = interfaceC4461;
    }

    @Override // com.polidea.rxandroidble2.internal.operations.OperationsProvider
    @RequiresApi(21)
    public ConnectionPriorityChangeOperation provideConnectionPriorityChangeOperation(int i, long j, TimeUnit timeUnit) {
        return new ConnectionPriorityChangeOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, i, new TimeoutConfiguration(j, timeUnit, this.timeoutScheduler));
    }

    @Override // com.polidea.rxandroidble2.internal.operations.OperationsProvider
    public CharacteristicLongWriteOperation provideLongWriteOperation(BluetoothGattCharacteristic bluetoothGattCharacteristic, RxBleConnection.WriteOperationAckStrategy writeOperationAckStrategy, RxBleConnection.WriteOperationRetryStrategy writeOperationRetryStrategy, PayloadSizeLimitProvider payloadSizeLimitProvider, byte[] bArr) {
        return new CharacteristicLongWriteOperation(this.bluetoothGatt, this.rxBleGattCallback, this.bluetoothInteractionScheduler, this.timeoutConfiguration, bluetoothGattCharacteristic, payloadSizeLimitProvider, writeOperationAckStrategy, writeOperationRetryStrategy, bArr);
    }

    @Override // com.polidea.rxandroidble2.internal.operations.OperationsProvider
    @RequiresApi(21)
    public MtuRequestOperation provideMtuChangeOperation(int i) {
        return new MtuRequestOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, i);
    }

    @Override // com.polidea.rxandroidble2.internal.operations.OperationsProvider
    public CharacteristicReadOperation provideReadCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return new CharacteristicReadOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, bluetoothGattCharacteristic);
    }

    @Override // com.polidea.rxandroidble2.internal.operations.OperationsProvider
    public DescriptorReadOperation provideReadDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor) {
        return new DescriptorReadOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, bluetoothGattDescriptor);
    }

    @Override // com.polidea.rxandroidble2.internal.operations.OperationsProvider
    public ReadRssiOperation provideRssiReadOperation() {
        return this.rssiReadOperationProvider.get();
    }

    @Override // com.polidea.rxandroidble2.internal.operations.OperationsProvider
    public ServiceDiscoveryOperation provideServiceDiscoveryOperation(long j, TimeUnit timeUnit) {
        return new ServiceDiscoveryOperation(this.rxBleGattCallback, this.bluetoothGatt, this.bleServicesLogger, new TimeoutConfiguration(j, timeUnit, this.timeoutScheduler));
    }

    @Override // com.polidea.rxandroidble2.internal.operations.OperationsProvider
    public CharacteristicWriteOperation provideWriteCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        return new CharacteristicWriteOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, bluetoothGattCharacteristic, bArr);
    }

    @Override // com.polidea.rxandroidble2.internal.operations.OperationsProvider
    public DescriptorWriteOperation provideWriteDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        return new DescriptorWriteOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, 2, bluetoothGattDescriptor, bArr);
    }
}
