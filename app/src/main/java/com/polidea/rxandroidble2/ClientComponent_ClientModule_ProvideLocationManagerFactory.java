package com.polidea.rxandroidble2;

import android.content.Context;
import android.location.LocationManager;
import com.polidea.rxandroidble2.ClientComponent;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideLocationManagerFactory implements InterfaceC3628<LocationManager> {
    private final InterfaceC4461<Context> contextProvider;

    public ClientComponent_ClientModule_ProvideLocationManagerFactory(InterfaceC4461<Context> interfaceC4461) {
        this.contextProvider = interfaceC4461;
    }

    public static ClientComponent_ClientModule_ProvideLocationManagerFactory create(InterfaceC4461<Context> interfaceC4461) {
        return new ClientComponent_ClientModule_ProvideLocationManagerFactory(interfaceC4461);
    }

    public static LocationManager proxyProvideLocationManager(Context context) {
        return (LocationManager) C4618.m14073(ClientComponent.ClientModule.provideLocationManager(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public LocationManager get() {
        return (LocationManager) C4618.m14073(ClientComponent.ClientModule.provideLocationManager(this.contextProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
