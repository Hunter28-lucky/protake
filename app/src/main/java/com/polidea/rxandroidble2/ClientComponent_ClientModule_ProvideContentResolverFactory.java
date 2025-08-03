package com.polidea.rxandroidble2;

import android.content.ContentResolver;
import android.content.Context;
import com.polidea.rxandroidble2.ClientComponent;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideContentResolverFactory implements InterfaceC3628<ContentResolver> {
    private final InterfaceC4461<Context> contextProvider;

    public ClientComponent_ClientModule_ProvideContentResolverFactory(InterfaceC4461<Context> interfaceC4461) {
        this.contextProvider = interfaceC4461;
    }

    public static ClientComponent_ClientModule_ProvideContentResolverFactory create(InterfaceC4461<Context> interfaceC4461) {
        return new ClientComponent_ClientModule_ProvideContentResolverFactory(interfaceC4461);
    }

    public static ContentResolver proxyProvideContentResolver(Context context) {
        return (ContentResolver) C4618.m14073(ClientComponent.ClientModule.provideContentResolver(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public ContentResolver get() {
        return (ContentResolver) C4618.m14073(ClientComponent.ClientModule.provideContentResolver(this.contextProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
