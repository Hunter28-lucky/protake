package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import defpackage.AbstractC4585;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class RxBleConnectionImpl_Factory implements InterfaceC3628<RxBleConnectionImpl> {
    private final InterfaceC4461<BluetoothGatt> bluetoothGattProvider;
    private final InterfaceC4461<AbstractC4585> callbackSchedulerProvider;
    private final InterfaceC4461<DescriptorWriter> descriptorWriterProvider;
    private final InterfaceC4461<RxBleGattCallback> gattCallbackProvider;
    private final InterfaceC4461<IllegalOperationChecker> illegalOperationCheckerProvider;
    private final InterfaceC4461<RxBleConnection.LongWriteOperationBuilder> longWriteOperationBuilderProvider;
    private final InterfaceC4461<MtuProvider> mtuProvider;
    private final InterfaceC4461<NotificationAndIndicationManager> notificationIndicationManagerProvider;
    private final InterfaceC4461<OperationsProvider> operationProvider;
    private final InterfaceC4461<ConnectionOperationQueue> operationQueueProvider;
    private final InterfaceC4461<ServiceDiscoveryManager> serviceDiscoveryManagerProvider;

    public RxBleConnectionImpl_Factory(InterfaceC4461<ConnectionOperationQueue> interfaceC4461, InterfaceC4461<RxBleGattCallback> interfaceC44612, InterfaceC4461<BluetoothGatt> interfaceC44613, InterfaceC4461<ServiceDiscoveryManager> interfaceC44614, InterfaceC4461<NotificationAndIndicationManager> interfaceC44615, InterfaceC4461<MtuProvider> interfaceC44616, InterfaceC4461<DescriptorWriter> interfaceC44617, InterfaceC4461<OperationsProvider> interfaceC44618, InterfaceC4461<RxBleConnection.LongWriteOperationBuilder> interfaceC44619, InterfaceC4461<AbstractC4585> interfaceC446110, InterfaceC4461<IllegalOperationChecker> interfaceC446111) {
        this.operationQueueProvider = interfaceC4461;
        this.gattCallbackProvider = interfaceC44612;
        this.bluetoothGattProvider = interfaceC44613;
        this.serviceDiscoveryManagerProvider = interfaceC44614;
        this.notificationIndicationManagerProvider = interfaceC44615;
        this.mtuProvider = interfaceC44616;
        this.descriptorWriterProvider = interfaceC44617;
        this.operationProvider = interfaceC44618;
        this.longWriteOperationBuilderProvider = interfaceC44619;
        this.callbackSchedulerProvider = interfaceC446110;
        this.illegalOperationCheckerProvider = interfaceC446111;
    }

    public static RxBleConnectionImpl_Factory create(InterfaceC4461<ConnectionOperationQueue> interfaceC4461, InterfaceC4461<RxBleGattCallback> interfaceC44612, InterfaceC4461<BluetoothGatt> interfaceC44613, InterfaceC4461<ServiceDiscoveryManager> interfaceC44614, InterfaceC4461<NotificationAndIndicationManager> interfaceC44615, InterfaceC4461<MtuProvider> interfaceC44616, InterfaceC4461<DescriptorWriter> interfaceC44617, InterfaceC4461<OperationsProvider> interfaceC44618, InterfaceC4461<RxBleConnection.LongWriteOperationBuilder> interfaceC44619, InterfaceC4461<AbstractC4585> interfaceC446110, InterfaceC4461<IllegalOperationChecker> interfaceC446111) {
        return new RxBleConnectionImpl_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614, interfaceC44615, interfaceC44616, interfaceC44617, interfaceC44618, interfaceC44619, interfaceC446110, interfaceC446111);
    }

    public static RxBleConnectionImpl newRxBleConnectionImpl(ConnectionOperationQueue connectionOperationQueue, RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, Object obj, Object obj2, Object obj3, Object obj4, OperationsProvider operationsProvider, InterfaceC4461<RxBleConnection.LongWriteOperationBuilder> interfaceC4461, AbstractC4585 abstractC4585, IllegalOperationChecker illegalOperationChecker) {
        return new RxBleConnectionImpl(connectionOperationQueue, rxBleGattCallback, bluetoothGatt, (ServiceDiscoveryManager) obj, (NotificationAndIndicationManager) obj2, (MtuProvider) obj3, (DescriptorWriter) obj4, operationsProvider, interfaceC4461, abstractC4585, illegalOperationChecker);
    }

    @Override // defpackage.InterfaceC4461
    public RxBleConnectionImpl get() {
        return new RxBleConnectionImpl(this.operationQueueProvider.get(), this.gattCallbackProvider.get(), this.bluetoothGattProvider.get(), this.serviceDiscoveryManagerProvider.get(), this.notificationIndicationManagerProvider.get(), this.mtuProvider.get(), this.descriptorWriterProvider.get(), this.operationProvider.get(), this.longWriteOperationBuilderProvider, this.callbackSchedulerProvider.get(), this.illegalOperationCheckerProvider.get());
    }
}
