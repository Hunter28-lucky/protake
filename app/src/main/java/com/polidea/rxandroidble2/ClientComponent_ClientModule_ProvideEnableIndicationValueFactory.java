package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.ClientComponent;
import defpackage.C4618;
import defpackage.InterfaceC3628;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideEnableIndicationValueFactory implements InterfaceC3628<byte[]> {
    private static final ClientComponent_ClientModule_ProvideEnableIndicationValueFactory INSTANCE = new ClientComponent_ClientModule_ProvideEnableIndicationValueFactory();

    public static ClientComponent_ClientModule_ProvideEnableIndicationValueFactory create() {
        return INSTANCE;
    }

    public static byte[] proxyProvideEnableIndicationValue() {
        return (byte[]) C4618.m14073(ClientComponent.ClientModule.provideEnableIndicationValue(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public byte[] get() {
        return (byte[]) C4618.m14073(ClientComponent.ClientModule.provideEnableIndicationValue(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
