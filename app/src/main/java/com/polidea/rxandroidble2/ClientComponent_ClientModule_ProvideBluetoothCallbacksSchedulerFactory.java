package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.ClientComponent;
import defpackage.AbstractC4585;
import defpackage.C4618;
import defpackage.InterfaceC3628;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory implements InterfaceC3628<AbstractC4585> {
    private static final ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory INSTANCE = new ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory();

    public static ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory create() {
        return INSTANCE;
    }

    public static AbstractC4585 proxyProvideBluetoothCallbacksScheduler() {
        return (AbstractC4585) C4618.m14073(ClientComponent.ClientModule.provideBluetoothCallbacksScheduler(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public AbstractC4585 get() {
        return (AbstractC4585) C4618.m14073(ClientComponent.ClientModule.provideBluetoothCallbacksScheduler(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
