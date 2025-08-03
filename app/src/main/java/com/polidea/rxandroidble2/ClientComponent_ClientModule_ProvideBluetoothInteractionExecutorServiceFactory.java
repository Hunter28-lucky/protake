package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.ClientComponent;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory implements InterfaceC3628<ExecutorService> {
    private static final ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory INSTANCE = new ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory();

    public static ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory create() {
        return INSTANCE;
    }

    public static ExecutorService proxyProvideBluetoothInteractionExecutorService() {
        return (ExecutorService) C4618.m14073(ClientComponent.ClientModule.provideBluetoothInteractionExecutorService(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public ExecutorService get() {
        return (ExecutorService) C4618.m14073(ClientComponent.ClientModule.provideBluetoothInteractionExecutorService(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
