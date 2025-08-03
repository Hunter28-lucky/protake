package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.internal.operations.DisconnectOperation;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class DisconnectAction_Factory implements InterfaceC3628<DisconnectAction> {
    private final InterfaceC4461<ClientOperationQueue> clientOperationQueueProvider;
    private final InterfaceC4461<DisconnectOperation> operationDisconnectProvider;

    public DisconnectAction_Factory(InterfaceC4461<ClientOperationQueue> interfaceC4461, InterfaceC4461<DisconnectOperation> interfaceC44612) {
        this.clientOperationQueueProvider = interfaceC4461;
        this.operationDisconnectProvider = interfaceC44612;
    }

    public static DisconnectAction_Factory create(InterfaceC4461<ClientOperationQueue> interfaceC4461, InterfaceC4461<DisconnectOperation> interfaceC44612) {
        return new DisconnectAction_Factory(interfaceC4461, interfaceC44612);
    }

    public static DisconnectAction newDisconnectAction(ClientOperationQueue clientOperationQueue, DisconnectOperation disconnectOperation) {
        return new DisconnectAction(clientOperationQueue, disconnectOperation);
    }

    @Override // defpackage.InterfaceC4461
    public DisconnectAction get() {
        return new DisconnectAction(this.clientOperationQueueProvider.get(), this.operationDisconnectProvider.get());
    }
}
