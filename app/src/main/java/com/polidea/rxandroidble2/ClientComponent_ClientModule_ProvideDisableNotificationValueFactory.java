package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.ClientComponent;
import defpackage.C4618;
import defpackage.InterfaceC3628;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideDisableNotificationValueFactory implements InterfaceC3628<byte[]> {
    private static final ClientComponent_ClientModule_ProvideDisableNotificationValueFactory INSTANCE = new ClientComponent_ClientModule_ProvideDisableNotificationValueFactory();

    public static ClientComponent_ClientModule_ProvideDisableNotificationValueFactory create() {
        return INSTANCE;
    }

    public static byte[] proxyProvideDisableNotificationValue() {
        return (byte[]) C4618.m14073(ClientComponent.ClientModule.provideDisableNotificationValue(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public byte[] get() {
        return (byte[]) C4618.m14073(ClientComponent.ClientModule.provideDisableNotificationValue(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
