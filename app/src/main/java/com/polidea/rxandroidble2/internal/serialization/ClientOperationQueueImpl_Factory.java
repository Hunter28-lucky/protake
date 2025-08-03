package com.polidea.rxandroidble2.internal.serialization;

import defpackage.AbstractC4585;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ClientOperationQueueImpl_Factory implements InterfaceC3628<ClientOperationQueueImpl> {
    private final InterfaceC4461<AbstractC4585> callbackSchedulerProvider;

    public ClientOperationQueueImpl_Factory(InterfaceC4461<AbstractC4585> interfaceC4461) {
        this.callbackSchedulerProvider = interfaceC4461;
    }

    public static ClientOperationQueueImpl_Factory create(InterfaceC4461<AbstractC4585> interfaceC4461) {
        return new ClientOperationQueueImpl_Factory(interfaceC4461);
    }

    @Override // defpackage.InterfaceC4461
    public ClientOperationQueueImpl get() {
        return new ClientOperationQueueImpl(this.callbackSchedulerProvider.get());
    }
}
