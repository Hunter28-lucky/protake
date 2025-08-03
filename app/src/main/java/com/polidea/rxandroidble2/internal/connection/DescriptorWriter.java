package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import defpackage.AbstractC2900;

@ConnectionScope
/* loaded from: classes2.dex */
class DescriptorWriter {
    private final ConnectionOperationQueue operationQueue;
    private final OperationsProvider operationsProvider;

    public DescriptorWriter(ConnectionOperationQueue connectionOperationQueue, OperationsProvider operationsProvider) {
        this.operationQueue = connectionOperationQueue;
        this.operationsProvider = operationsProvider;
    }

    public AbstractC2900 writeDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        return this.operationQueue.queue(this.operationsProvider.provideWriteDescriptor(bluetoothGattDescriptor, bArr)).ignoreElements();
    }
}
