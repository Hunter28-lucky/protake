package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ServiceDiscoveryManager_Factory implements InterfaceC3628<ServiceDiscoveryManager> {
    private final InterfaceC4461<BluetoothGatt> bluetoothGattProvider;
    private final InterfaceC4461<OperationsProvider> operationProvider;
    private final InterfaceC4461<ConnectionOperationQueue> operationQueueProvider;

    public ServiceDiscoveryManager_Factory(InterfaceC4461<ConnectionOperationQueue> interfaceC4461, InterfaceC4461<BluetoothGatt> interfaceC44612, InterfaceC4461<OperationsProvider> interfaceC44613) {
        this.operationQueueProvider = interfaceC4461;
        this.bluetoothGattProvider = interfaceC44612;
        this.operationProvider = interfaceC44613;
    }

    public static ServiceDiscoveryManager_Factory create(InterfaceC4461<ConnectionOperationQueue> interfaceC4461, InterfaceC4461<BluetoothGatt> interfaceC44612, InterfaceC4461<OperationsProvider> interfaceC44613) {
        return new ServiceDiscoveryManager_Factory(interfaceC4461, interfaceC44612, interfaceC44613);
    }

    public static ServiceDiscoveryManager newServiceDiscoveryManager(ConnectionOperationQueue connectionOperationQueue, BluetoothGatt bluetoothGatt, OperationsProvider operationsProvider) {
        return new ServiceDiscoveryManager(connectionOperationQueue, bluetoothGatt, operationsProvider);
    }

    @Override // defpackage.InterfaceC4461
    public ServiceDiscoveryManager get() {
        return new ServiceDiscoveryManager(this.operationQueueProvider.get(), this.bluetoothGattProvider.get(), this.operationProvider.get());
    }
}
