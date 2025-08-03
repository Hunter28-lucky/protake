package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices;
import defpackage.AbstractC4585;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class OperationsProviderImpl_Factory implements InterfaceC3628<OperationsProviderImpl> {
    private final InterfaceC4461<LoggerUtilBluetoothServices> bleServicesLoggerProvider;
    private final InterfaceC4461<BluetoothGatt> bluetoothGattProvider;
    private final InterfaceC4461<AbstractC4585> bluetoothInteractionSchedulerProvider;
    private final InterfaceC4461<ReadRssiOperation> rssiReadOperationProvider;
    private final InterfaceC4461<RxBleGattCallback> rxBleGattCallbackProvider;
    private final InterfaceC4461<TimeoutConfiguration> timeoutConfigurationProvider;
    private final InterfaceC4461<AbstractC4585> timeoutSchedulerProvider;

    public OperationsProviderImpl_Factory(InterfaceC4461<RxBleGattCallback> interfaceC4461, InterfaceC4461<BluetoothGatt> interfaceC44612, InterfaceC4461<LoggerUtilBluetoothServices> interfaceC44613, InterfaceC4461<TimeoutConfiguration> interfaceC44614, InterfaceC4461<AbstractC4585> interfaceC44615, InterfaceC4461<AbstractC4585> interfaceC44616, InterfaceC4461<ReadRssiOperation> interfaceC44617) {
        this.rxBleGattCallbackProvider = interfaceC4461;
        this.bluetoothGattProvider = interfaceC44612;
        this.bleServicesLoggerProvider = interfaceC44613;
        this.timeoutConfigurationProvider = interfaceC44614;
        this.bluetoothInteractionSchedulerProvider = interfaceC44615;
        this.timeoutSchedulerProvider = interfaceC44616;
        this.rssiReadOperationProvider = interfaceC44617;
    }

    public static OperationsProviderImpl_Factory create(InterfaceC4461<RxBleGattCallback> interfaceC4461, InterfaceC4461<BluetoothGatt> interfaceC44612, InterfaceC4461<LoggerUtilBluetoothServices> interfaceC44613, InterfaceC4461<TimeoutConfiguration> interfaceC44614, InterfaceC4461<AbstractC4585> interfaceC44615, InterfaceC4461<AbstractC4585> interfaceC44616, InterfaceC4461<ReadRssiOperation> interfaceC44617) {
        return new OperationsProviderImpl_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614, interfaceC44615, interfaceC44616, interfaceC44617);
    }

    public static OperationsProviderImpl newOperationsProviderImpl(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, LoggerUtilBluetoothServices loggerUtilBluetoothServices, TimeoutConfiguration timeoutConfiguration, AbstractC4585 abstractC4585, AbstractC4585 abstractC45852, InterfaceC4461<ReadRssiOperation> interfaceC4461) {
        return new OperationsProviderImpl(rxBleGattCallback, bluetoothGatt, loggerUtilBluetoothServices, timeoutConfiguration, abstractC4585, abstractC45852, interfaceC4461);
    }

    @Override // defpackage.InterfaceC4461
    public OperationsProviderImpl get() {
        return new OperationsProviderImpl(this.rxBleGattCallbackProvider.get(), this.bluetoothGattProvider.get(), this.bleServicesLoggerProvider.get(), this.timeoutConfigurationProvider.get(), this.bluetoothInteractionSchedulerProvider.get(), this.timeoutSchedulerProvider.get(), this.rssiReadOperationProvider);
    }
}
