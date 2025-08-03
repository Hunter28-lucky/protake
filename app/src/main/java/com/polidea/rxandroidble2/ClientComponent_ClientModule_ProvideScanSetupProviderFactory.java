package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi18;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi21;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi23;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideScanSetupProviderFactory implements InterfaceC3628<ScanSetupBuilder> {
    private final InterfaceC4461<Integer> deviceSdkProvider;
    private final InterfaceC4461<ScanSetupBuilderImplApi18> scanSetupBuilderProviderForApi18Provider;
    private final InterfaceC4461<ScanSetupBuilderImplApi21> scanSetupBuilderProviderForApi21Provider;
    private final InterfaceC4461<ScanSetupBuilderImplApi23> scanSetupBuilderProviderForApi23Provider;

    public ClientComponent_ClientModule_ProvideScanSetupProviderFactory(InterfaceC4461<Integer> interfaceC4461, InterfaceC4461<ScanSetupBuilderImplApi18> interfaceC44612, InterfaceC4461<ScanSetupBuilderImplApi21> interfaceC44613, InterfaceC4461<ScanSetupBuilderImplApi23> interfaceC44614) {
        this.deviceSdkProvider = interfaceC4461;
        this.scanSetupBuilderProviderForApi18Provider = interfaceC44612;
        this.scanSetupBuilderProviderForApi21Provider = interfaceC44613;
        this.scanSetupBuilderProviderForApi23Provider = interfaceC44614;
    }

    public static ClientComponent_ClientModule_ProvideScanSetupProviderFactory create(InterfaceC4461<Integer> interfaceC4461, InterfaceC4461<ScanSetupBuilderImplApi18> interfaceC44612, InterfaceC4461<ScanSetupBuilderImplApi21> interfaceC44613, InterfaceC4461<ScanSetupBuilderImplApi23> interfaceC44614) {
        return new ClientComponent_ClientModule_ProvideScanSetupProviderFactory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614);
    }

    public static ScanSetupBuilder proxyProvideScanSetupProvider(int i, InterfaceC4461<ScanSetupBuilderImplApi18> interfaceC4461, InterfaceC4461<ScanSetupBuilderImplApi21> interfaceC44612, InterfaceC4461<ScanSetupBuilderImplApi23> interfaceC44613) {
        return (ScanSetupBuilder) C4618.m14073(ClientComponent.ClientModule.provideScanSetupProvider(i, interfaceC4461, interfaceC44612, interfaceC44613), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public ScanSetupBuilder get() {
        return (ScanSetupBuilder) C4618.m14073(ClientComponent.ClientModule.provideScanSetupProvider(this.deviceSdkProvider.get().intValue(), this.scanSetupBuilderProviderForApi18Provider, this.scanSetupBuilderProviderForApi21Provider, this.scanSetupBuilderProviderForApi23Provider), "Cannot return null from a non-@Nullable @Provides method");
    }
}
