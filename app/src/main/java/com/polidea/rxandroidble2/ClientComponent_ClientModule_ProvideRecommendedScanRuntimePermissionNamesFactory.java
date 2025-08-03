package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.ClientComponent;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory implements InterfaceC3628<String[]> {
    private final InterfaceC4461<Integer> deviceSdkProvider;
    private final InterfaceC4461<Integer> targetSdkProvider;

    public ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory(InterfaceC4461<Integer> interfaceC4461, InterfaceC4461<Integer> interfaceC44612) {
        this.deviceSdkProvider = interfaceC4461;
        this.targetSdkProvider = interfaceC44612;
    }

    public static ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory create(InterfaceC4461<Integer> interfaceC4461, InterfaceC4461<Integer> interfaceC44612) {
        return new ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory(interfaceC4461, interfaceC44612);
    }

    public static String[] proxyProvideRecommendedScanRuntimePermissionNames(int i, int i2) {
        return (String[]) C4618.m14073(ClientComponent.ClientModule.provideRecommendedScanRuntimePermissionNames(i, i2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public String[] get() {
        return (String[]) C4618.m14073(ClientComponent.ClientModule.provideRecommendedScanRuntimePermissionNames(this.deviceSdkProvider.get().intValue(), this.targetSdkProvider.get().intValue()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
