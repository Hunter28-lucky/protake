package com.polidea.rxandroidble2.internal.scan;

import defpackage.AbstractC4585;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ScanSettingsEmulator_Factory implements InterfaceC3628<ScanSettingsEmulator> {
    private final InterfaceC4461<AbstractC4585> schedulerProvider;

    public ScanSettingsEmulator_Factory(InterfaceC4461<AbstractC4585> interfaceC4461) {
        this.schedulerProvider = interfaceC4461;
    }

    public static ScanSettingsEmulator_Factory create(InterfaceC4461<AbstractC4585> interfaceC4461) {
        return new ScanSettingsEmulator_Factory(interfaceC4461);
    }

    @Override // defpackage.InterfaceC4461
    public ScanSettingsEmulator get() {
        return new ScanSettingsEmulator(this.schedulerProvider.get());
    }
}
