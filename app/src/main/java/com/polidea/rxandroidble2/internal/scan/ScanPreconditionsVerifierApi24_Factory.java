package com.polidea.rxandroidble2.internal.scan;

import defpackage.AbstractC4585;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ScanPreconditionsVerifierApi24_Factory implements InterfaceC3628<ScanPreconditionsVerifierApi24> {
    private final InterfaceC4461<ScanPreconditionsVerifierApi18> scanPreconditionVerifierApi18Provider;
    private final InterfaceC4461<AbstractC4585> timeSchedulerProvider;

    public ScanPreconditionsVerifierApi24_Factory(InterfaceC4461<ScanPreconditionsVerifierApi18> interfaceC4461, InterfaceC4461<AbstractC4585> interfaceC44612) {
        this.scanPreconditionVerifierApi18Provider = interfaceC4461;
        this.timeSchedulerProvider = interfaceC44612;
    }

    public static ScanPreconditionsVerifierApi24_Factory create(InterfaceC4461<ScanPreconditionsVerifierApi18> interfaceC4461, InterfaceC4461<AbstractC4585> interfaceC44612) {
        return new ScanPreconditionsVerifierApi24_Factory(interfaceC4461, interfaceC44612);
    }

    @Override // defpackage.InterfaceC4461
    public ScanPreconditionsVerifierApi24 get() {
        return new ScanPreconditionsVerifierApi24(this.scanPreconditionVerifierApi18Provider.get(), this.timeSchedulerProvider.get());
    }
}
