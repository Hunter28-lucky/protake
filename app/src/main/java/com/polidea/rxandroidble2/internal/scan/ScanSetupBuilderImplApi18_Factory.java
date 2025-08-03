package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ScanSetupBuilderImplApi18_Factory implements InterfaceC3628<ScanSetupBuilderImplApi18> {
    private final InterfaceC4461<InternalScanResultCreator> internalScanResultCreatorProvider;
    private final InterfaceC4461<RxBleAdapterWrapper> rxBleAdapterWrapperProvider;
    private final InterfaceC4461<ScanSettingsEmulator> scanSettingsEmulatorProvider;

    public ScanSetupBuilderImplApi18_Factory(InterfaceC4461<RxBleAdapterWrapper> interfaceC4461, InterfaceC4461<InternalScanResultCreator> interfaceC44612, InterfaceC4461<ScanSettingsEmulator> interfaceC44613) {
        this.rxBleAdapterWrapperProvider = interfaceC4461;
        this.internalScanResultCreatorProvider = interfaceC44612;
        this.scanSettingsEmulatorProvider = interfaceC44613;
    }

    public static ScanSetupBuilderImplApi18_Factory create(InterfaceC4461<RxBleAdapterWrapper> interfaceC4461, InterfaceC4461<InternalScanResultCreator> interfaceC44612, InterfaceC4461<ScanSettingsEmulator> interfaceC44613) {
        return new ScanSetupBuilderImplApi18_Factory(interfaceC4461, interfaceC44612, interfaceC44613);
    }

    public static ScanSetupBuilderImplApi18 newScanSetupBuilderImplApi18(RxBleAdapterWrapper rxBleAdapterWrapper, InternalScanResultCreator internalScanResultCreator, ScanSettingsEmulator scanSettingsEmulator) {
        return new ScanSetupBuilderImplApi18(rxBleAdapterWrapper, internalScanResultCreator, scanSettingsEmulator);
    }

    @Override // defpackage.InterfaceC4461
    public ScanSetupBuilderImplApi18 get() {
        return new ScanSetupBuilderImplApi18(this.rxBleAdapterWrapperProvider.get(), this.internalScanResultCreatorProvider.get(), this.scanSettingsEmulatorProvider.get());
    }
}
