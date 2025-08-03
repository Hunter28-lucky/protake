package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.internal.connection.ConnectionComponent;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import defpackage.AbstractC4585;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ConnectorImpl_Factory implements InterfaceC3628<ConnectorImpl> {
    private final InterfaceC4461<AbstractC4585> callbacksSchedulerProvider;
    private final InterfaceC4461<ClientOperationQueue> clientOperationQueueProvider;
    private final InterfaceC4461<ConnectionComponent.Builder> connectionComponentBuilderProvider;

    public ConnectorImpl_Factory(InterfaceC4461<ClientOperationQueue> interfaceC4461, InterfaceC4461<ConnectionComponent.Builder> interfaceC44612, InterfaceC4461<AbstractC4585> interfaceC44613) {
        this.clientOperationQueueProvider = interfaceC4461;
        this.connectionComponentBuilderProvider = interfaceC44612;
        this.callbacksSchedulerProvider = interfaceC44613;
    }

    public static ConnectorImpl_Factory create(InterfaceC4461<ClientOperationQueue> interfaceC4461, InterfaceC4461<ConnectionComponent.Builder> interfaceC44612, InterfaceC4461<AbstractC4585> interfaceC44613) {
        return new ConnectorImpl_Factory(interfaceC4461, interfaceC44612, interfaceC44613);
    }

    @Override // defpackage.InterfaceC4461
    public ConnectorImpl get() {
        return new ConnectorImpl(this.clientOperationQueueProvider.get(), this.connectionComponentBuilderProvider.get(), this.callbacksSchedulerProvider.get());
    }
}
