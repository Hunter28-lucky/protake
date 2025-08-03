package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.ClientComponent;
import defpackage.AbstractC4585;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideFinalizationCloseableFactory implements InterfaceC3628<ClientComponent.ClientComponentFinalizer> {
    private final InterfaceC4461<AbstractC4585> callbacksSchedulerProvider;
    private final InterfaceC4461<ExecutorService> connectionQueueExecutorServiceProvider;
    private final InterfaceC4461<ExecutorService> interactionExecutorServiceProvider;

    public ClientComponent_ClientModule_ProvideFinalizationCloseableFactory(InterfaceC4461<ExecutorService> interfaceC4461, InterfaceC4461<AbstractC4585> interfaceC44612, InterfaceC4461<ExecutorService> interfaceC44613) {
        this.interactionExecutorServiceProvider = interfaceC4461;
        this.callbacksSchedulerProvider = interfaceC44612;
        this.connectionQueueExecutorServiceProvider = interfaceC44613;
    }

    public static ClientComponent_ClientModule_ProvideFinalizationCloseableFactory create(InterfaceC4461<ExecutorService> interfaceC4461, InterfaceC4461<AbstractC4585> interfaceC44612, InterfaceC4461<ExecutorService> interfaceC44613) {
        return new ClientComponent_ClientModule_ProvideFinalizationCloseableFactory(interfaceC4461, interfaceC44612, interfaceC44613);
    }

    public static ClientComponent.ClientComponentFinalizer proxyProvideFinalizationCloseable(ExecutorService executorService, AbstractC4585 abstractC4585, ExecutorService executorService2) {
        return (ClientComponent.ClientComponentFinalizer) C4618.m14073(ClientComponent.ClientModule.provideFinalizationCloseable(executorService, abstractC4585, executorService2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public ClientComponent.ClientComponentFinalizer get() {
        return (ClientComponent.ClientComponentFinalizer) C4618.m14073(ClientComponent.ClientModule.provideFinalizationCloseable(this.interactionExecutorServiceProvider.get(), this.callbacksSchedulerProvider.get(), this.connectionQueueExecutorServiceProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
