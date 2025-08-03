package com.polidea.rxandroidble2.internal.serialization;

import com.polidea.rxandroidble2.internal.connection.DisconnectionRouterOutput;
import defpackage.AbstractC4585;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class ConnectionOperationQueueImpl_Factory implements InterfaceC3628<ConnectionOperationQueueImpl> {
    private final InterfaceC4461<AbstractC4585> callbackSchedulerProvider;
    private final InterfaceC4461<String> deviceMacAddressProvider;
    private final InterfaceC4461<DisconnectionRouterOutput> disconnectionRouterOutputProvider;
    private final InterfaceC4461<ExecutorService> executorServiceProvider;

    public ConnectionOperationQueueImpl_Factory(InterfaceC4461<String> interfaceC4461, InterfaceC4461<DisconnectionRouterOutput> interfaceC44612, InterfaceC4461<ExecutorService> interfaceC44613, InterfaceC4461<AbstractC4585> interfaceC44614) {
        this.deviceMacAddressProvider = interfaceC4461;
        this.disconnectionRouterOutputProvider = interfaceC44612;
        this.executorServiceProvider = interfaceC44613;
        this.callbackSchedulerProvider = interfaceC44614;
    }

    public static ConnectionOperationQueueImpl_Factory create(InterfaceC4461<String> interfaceC4461, InterfaceC4461<DisconnectionRouterOutput> interfaceC44612, InterfaceC4461<ExecutorService> interfaceC44613, InterfaceC4461<AbstractC4585> interfaceC44614) {
        return new ConnectionOperationQueueImpl_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614);
    }

    public static ConnectionOperationQueueImpl newConnectionOperationQueueImpl(String str, DisconnectionRouterOutput disconnectionRouterOutput, ExecutorService executorService, AbstractC4585 abstractC4585) {
        return new ConnectionOperationQueueImpl(str, disconnectionRouterOutput, executorService, abstractC4585);
    }

    @Override // defpackage.InterfaceC4461
    public ConnectionOperationQueueImpl get() {
        return new ConnectionOperationQueueImpl(this.deviceMacAddressProvider.get(), this.disconnectionRouterOutputProvider.get(), this.executorServiceProvider.get(), this.callbackSchedulerProvider.get());
    }
}
