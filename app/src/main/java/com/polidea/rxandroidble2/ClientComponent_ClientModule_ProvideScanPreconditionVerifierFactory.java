package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi18;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi24;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideScanPreconditionVerifierFactory implements InterfaceC3628<ScanPreconditionsVerifier> {
    private final InterfaceC4461<Integer> deviceSdkProvider;
    private final InterfaceC4461<ScanPreconditionsVerifierApi18> scanPreconditionVerifierForApi18Provider;
    private final InterfaceC4461<ScanPreconditionsVerifierApi24> scanPreconditionVerifierForApi24Provider;

    public ClientComponent_ClientModule_ProvideScanPreconditionVerifierFactory(InterfaceC4461<Integer> interfaceC4461, InterfaceC4461<ScanPreconditionsVerifierApi18> interfaceC44612, InterfaceC4461<ScanPreconditionsVerifierApi24> interfaceC44613) {
        this.deviceSdkProvider = interfaceC4461;
        this.scanPreconditionVerifierForApi18Provider = interfaceC44612;
        this.scanPreconditionVerifierForApi24Provider = interfaceC44613;
    }

    public static ClientComponent_ClientModule_ProvideScanPreconditionVerifierFactory create(InterfaceC4461<Integer> interfaceC4461, InterfaceC4461<ScanPreconditionsVerifierApi18> interfaceC44612, InterfaceC4461<ScanPreconditionsVerifierApi24> interfaceC44613) {
        return new ClientComponent_ClientModule_ProvideScanPreconditionVerifierFactory(interfaceC4461, interfaceC44612, interfaceC44613);
    }

    public static ScanPreconditionsVerifier proxyProvideScanPreconditionVerifier(int i, InterfaceC4461<ScanPreconditionsVerifierApi18> interfaceC4461, InterfaceC4461<ScanPreconditionsVerifierApi24> interfaceC44612) {
        return (ScanPreconditionsVerifier) C4618.m14073(ClientComponent.ClientModule.provideScanPreconditionVerifier(i, interfaceC4461, interfaceC44612), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public ScanPreconditionsVerifier get() {
        return (ScanPreconditionsVerifier) C4618.m14073(ClientComponent.ClientModule.provideScanPreconditionVerifier(this.deviceSdkProvider.get().intValue(), this.scanPreconditionVerifierForApi18Provider, this.scanPreconditionVerifierForApi24Provider), "Cannot return null from a non-@Nullable @Provides method");
    }
}
