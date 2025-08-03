package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.ClientComponent;
import defpackage.InterfaceC3628;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideDeviceSdkFactory implements InterfaceC3628<Integer> {
    private static final ClientComponent_ClientModule_ProvideDeviceSdkFactory INSTANCE = new ClientComponent_ClientModule_ProvideDeviceSdkFactory();

    public static ClientComponent_ClientModule_ProvideDeviceSdkFactory create() {
        return INSTANCE;
    }

    public static int proxyProvideDeviceSdk() {
        return ClientComponent.ClientModule.provideDeviceSdk();
    }

    @Override // defpackage.InterfaceC4461
    public Integer get() {
        return Integer.valueOf(ClientComponent.ClientModule.provideDeviceSdk());
    }
}
