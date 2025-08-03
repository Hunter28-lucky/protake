package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class DescriptorWriter_Factory implements InterfaceC3628<DescriptorWriter> {
    private final InterfaceC4461<ConnectionOperationQueue> operationQueueProvider;
    private final InterfaceC4461<OperationsProvider> operationsProvider;

    public DescriptorWriter_Factory(InterfaceC4461<ConnectionOperationQueue> interfaceC4461, InterfaceC4461<OperationsProvider> interfaceC44612) {
        this.operationQueueProvider = interfaceC4461;
        this.operationsProvider = interfaceC44612;
    }

    public static DescriptorWriter_Factory create(InterfaceC4461<ConnectionOperationQueue> interfaceC4461, InterfaceC4461<OperationsProvider> interfaceC44612) {
        return new DescriptorWriter_Factory(interfaceC4461, interfaceC44612);
    }

    public static DescriptorWriter newDescriptorWriter(ConnectionOperationQueue connectionOperationQueue, OperationsProvider operationsProvider) {
        return new DescriptorWriter(connectionOperationQueue, operationsProvider);
    }

    @Override // defpackage.InterfaceC4461
    public DescriptorWriter get() {
        return new DescriptorWriter(this.operationQueueProvider.get(), this.operationsProvider.get());
    }
}
