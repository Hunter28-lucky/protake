package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class LongWriteOperationBuilderImpl_Factory implements InterfaceC3628<LongWriteOperationBuilderImpl> {
    private final InterfaceC4461<MtuBasedPayloadSizeLimit> defaultMaxBatchSizeProvider;
    private final InterfaceC4461<ConnectionOperationQueue> operationQueueProvider;
    private final InterfaceC4461<OperationsProvider> operationsProvider;
    private final InterfaceC4461<RxBleConnection> rxBleConnectionProvider;

    public LongWriteOperationBuilderImpl_Factory(InterfaceC4461<ConnectionOperationQueue> interfaceC4461, InterfaceC4461<MtuBasedPayloadSizeLimit> interfaceC44612, InterfaceC4461<RxBleConnection> interfaceC44613, InterfaceC4461<OperationsProvider> interfaceC44614) {
        this.operationQueueProvider = interfaceC4461;
        this.defaultMaxBatchSizeProvider = interfaceC44612;
        this.rxBleConnectionProvider = interfaceC44613;
        this.operationsProvider = interfaceC44614;
    }

    public static LongWriteOperationBuilderImpl_Factory create(InterfaceC4461<ConnectionOperationQueue> interfaceC4461, InterfaceC4461<MtuBasedPayloadSizeLimit> interfaceC44612, InterfaceC4461<RxBleConnection> interfaceC44613, InterfaceC4461<OperationsProvider> interfaceC44614) {
        return new LongWriteOperationBuilderImpl_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614);
    }

    public static LongWriteOperationBuilderImpl newLongWriteOperationBuilderImpl(ConnectionOperationQueue connectionOperationQueue, Object obj, RxBleConnection rxBleConnection, OperationsProvider operationsProvider) {
        return new LongWriteOperationBuilderImpl(connectionOperationQueue, (MtuBasedPayloadSizeLimit) obj, rxBleConnection, operationsProvider);
    }

    @Override // defpackage.InterfaceC4461
    public LongWriteOperationBuilderImpl get() {
        return new LongWriteOperationBuilderImpl(this.operationQueueProvider.get(), this.defaultMaxBatchSizeProvider.get(), this.rxBleConnectionProvider.get(), this.operationsProvider.get());
    }
}
