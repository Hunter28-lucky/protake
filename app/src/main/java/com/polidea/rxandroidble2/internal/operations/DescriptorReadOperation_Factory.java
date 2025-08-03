package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class DescriptorReadOperation_Factory implements InterfaceC3628<DescriptorReadOperation> {
    private final InterfaceC4461<BluetoothGatt> bluetoothGattProvider;
    private final InterfaceC4461<BluetoothGattDescriptor> descriptorProvider;
    private final InterfaceC4461<RxBleGattCallback> rxBleGattCallbackProvider;
    private final InterfaceC4461<TimeoutConfiguration> timeoutConfigurationProvider;

    public DescriptorReadOperation_Factory(InterfaceC4461<RxBleGattCallback> interfaceC4461, InterfaceC4461<BluetoothGatt> interfaceC44612, InterfaceC4461<TimeoutConfiguration> interfaceC44613, InterfaceC4461<BluetoothGattDescriptor> interfaceC44614) {
        this.rxBleGattCallbackProvider = interfaceC4461;
        this.bluetoothGattProvider = interfaceC44612;
        this.timeoutConfigurationProvider = interfaceC44613;
        this.descriptorProvider = interfaceC44614;
    }

    public static DescriptorReadOperation_Factory create(InterfaceC4461<RxBleGattCallback> interfaceC4461, InterfaceC4461<BluetoothGatt> interfaceC44612, InterfaceC4461<TimeoutConfiguration> interfaceC44613, InterfaceC4461<BluetoothGattDescriptor> interfaceC44614) {
        return new DescriptorReadOperation_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614);
    }

    public static DescriptorReadOperation newDescriptorReadOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, TimeoutConfiguration timeoutConfiguration, BluetoothGattDescriptor bluetoothGattDescriptor) {
        return new DescriptorReadOperation(rxBleGattCallback, bluetoothGatt, timeoutConfiguration, bluetoothGattDescriptor);
    }

    @Override // defpackage.InterfaceC4461
    public DescriptorReadOperation get() {
        return new DescriptorReadOperation(this.rxBleGattCallbackProvider.get(), this.bluetoothGattProvider.get(), this.timeoutConfigurationProvider.get(), this.descriptorProvider.get());
    }
}
