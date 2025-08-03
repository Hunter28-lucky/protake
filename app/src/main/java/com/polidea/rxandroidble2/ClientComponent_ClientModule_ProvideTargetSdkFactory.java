package com.polidea.rxandroidble2;

import android.content.Context;
import com.polidea.rxandroidble2.ClientComponent;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideTargetSdkFactory implements InterfaceC3628<Integer> {
    private final InterfaceC4461<Context> contextProvider;

    public ClientComponent_ClientModule_ProvideTargetSdkFactory(InterfaceC4461<Context> interfaceC4461) {
        this.contextProvider = interfaceC4461;
    }

    public static ClientComponent_ClientModule_ProvideTargetSdkFactory create(InterfaceC4461<Context> interfaceC4461) {
        return new ClientComponent_ClientModule_ProvideTargetSdkFactory(interfaceC4461);
    }

    public static int proxyProvideTargetSdk(Context context) {
        return ClientComponent.ClientModule.provideTargetSdk(context);
    }

    @Override // defpackage.InterfaceC4461
    public Integer get() {
        return Integer.valueOf(ClientComponent.ClientModule.provideTargetSdk(this.contextProvider.get()));
    }
}
