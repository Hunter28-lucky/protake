package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.ClientComponent;
import defpackage.AbstractC4585;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideBluetoothInteractionSchedulerFactory implements InterfaceC3628<AbstractC4585> {
    private final InterfaceC4461<ExecutorService> serviceProvider;

    public ClientComponent_ClientModule_ProvideBluetoothInteractionSchedulerFactory(InterfaceC4461<ExecutorService> interfaceC4461) {
        this.serviceProvider = interfaceC4461;
    }

    public static ClientComponent_ClientModule_ProvideBluetoothInteractionSchedulerFactory create(InterfaceC4461<ExecutorService> interfaceC4461) {
        return new ClientComponent_ClientModule_ProvideBluetoothInteractionSchedulerFactory(interfaceC4461);
    }

    public static AbstractC4585 proxyProvideBluetoothInteractionScheduler(ExecutorService executorService) {
        return (AbstractC4585) C4618.m14073(ClientComponent.ClientModule.provideBluetoothInteractionScheduler(executorService), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public AbstractC4585 get() {
        return (AbstractC4585) C4618.m14073(ClientComponent.ClientModule.provideBluetoothInteractionScheduler(this.serviceProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
