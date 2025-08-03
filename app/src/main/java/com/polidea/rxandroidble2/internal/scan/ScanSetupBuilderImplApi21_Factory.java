package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ScanSetupBuilderImplApi21_Factory implements InterfaceC3628<ScanSetupBuilderImplApi21> {
    private final InterfaceC4461<AndroidScanObjectsConverter> androidScanObjectsConverterProvider;
    private final InterfaceC4461<InternalScanResultCreator> internalScanResultCreatorProvider;
    private final InterfaceC4461<RxBleAdapterWrapper> rxBleAdapterWrapperProvider;
    private final InterfaceC4461<ScanSettingsEmulator> scanSettingsEmulatorProvider;

    public ScanSetupBuilderImplApi21_Factory(InterfaceC4461<RxBleAdapterWrapper> interfaceC4461, InterfaceC4461<InternalScanResultCreator> interfaceC44612, InterfaceC4461<ScanSettingsEmulator> interfaceC44613, InterfaceC4461<AndroidScanObjectsConverter> interfaceC44614) {
        this.rxBleAdapterWrapperProvider = interfaceC4461;
        this.internalScanResultCreatorProvider = interfaceC44612;
        this.scanSettingsEmulatorProvider = interfaceC44613;
        this.androidScanObjectsConverterProvider = interfaceC44614;
    }

    public static ScanSetupBuilderImplApi21_Factory create(InterfaceC4461<RxBleAdapterWrapper> interfaceC4461, InterfaceC4461<InternalScanResultCreator> interfaceC44612, InterfaceC4461<ScanSettingsEmulator> interfaceC44613, InterfaceC4461<AndroidScanObjectsConverter> interfaceC44614) {
        return new ScanSetupBuilderImplApi21_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614);
    }

    public static ScanSetupBuilderImplApi21 newScanSetupBuilderImplApi21(RxBleAdapterWrapper rxBleAdapterWrapper, InternalScanResultCreator internalScanResultCreator, ScanSettingsEmulator scanSettingsEmulator, AndroidScanObjectsConverter androidScanObjectsConverter) {
        return new ScanSetupBuilderImplApi21(rxBleAdapterWrapper, internalScanResultCreator, scanSettingsEmulator, androidScanObjectsConverter);
    }

    @Override // defpackage.InterfaceC4461
    public ScanSetupBuilderImplApi21 get() {
        return new ScanSetupBuilderImplApi21(this.rxBleAdapterWrapperProvider.get(), this.internalScanResultCreatorProvider.get(), this.scanSettingsEmulatorProvider.get(), this.androidScanObjectsConverterProvider.get());
    }
}
