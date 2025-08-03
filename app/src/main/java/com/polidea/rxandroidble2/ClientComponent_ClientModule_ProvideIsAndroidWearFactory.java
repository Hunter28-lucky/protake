package com.polidea.rxandroidble2;

import android.content.Context;
import com.polidea.rxandroidble2.ClientComponent;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideIsAndroidWearFactory implements InterfaceC3628<Boolean> {
    private final InterfaceC4461<Context> contextProvider;
    private final InterfaceC4461<Integer> deviceSdkProvider;

    public ClientComponent_ClientModule_ProvideIsAndroidWearFactory(InterfaceC4461<Context> interfaceC4461, InterfaceC4461<Integer> interfaceC44612) {
        this.contextProvider = interfaceC4461;
        this.deviceSdkProvider = interfaceC44612;
    }

    public static ClientComponent_ClientModule_ProvideIsAndroidWearFactory create(InterfaceC4461<Context> interfaceC4461, InterfaceC4461<Integer> interfaceC44612) {
        return new ClientComponent_ClientModule_ProvideIsAndroidWearFactory(interfaceC4461, interfaceC44612);
    }

    public static boolean proxyProvideIsAndroidWear(Context context, int i) {
        return ClientComponent.ClientModule.provideIsAndroidWear(context, i);
    }

    @Override // defpackage.InterfaceC4461
    public Boolean get() {
        return Boolean.valueOf(ClientComponent.ClientModule.provideIsAndroidWear(this.contextProvider.get(), this.deviceSdkProvider.get().intValue()));
    }
}
