package com.polidea.rxandroidble2.internal.scan;

import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble2.internal.operations.ScanOperationApi18;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;
import defpackage.AbstractC4262;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC5298;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class ScanSetupBuilderImplApi18 implements ScanSetupBuilder {
    private final InternalScanResultCreator internalScanResultCreator;
    private final RxBleAdapterWrapper rxBleAdapterWrapper;
    private final ScanSettingsEmulator scanSettingsEmulator;

    public ScanSetupBuilderImplApi18(RxBleAdapterWrapper rxBleAdapterWrapper, InternalScanResultCreator internalScanResultCreator, ScanSettingsEmulator scanSettingsEmulator) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
        this.internalScanResultCreator = internalScanResultCreator;
        this.scanSettingsEmulator = scanSettingsEmulator;
    }

    @Override // com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder
    public ScanSetup build(ScanSettings scanSettings, ScanFilter... scanFilterArr) {
        final InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> interfaceC5298EmulateScanMode = this.scanSettingsEmulator.emulateScanMode(scanSettings.getScanMode());
        final InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> interfaceC5298EmulateCallbackType = this.scanSettingsEmulator.emulateCallbackType(scanSettings.getCallbackType());
        return new ScanSetup(new ScanOperationApi18(this.rxBleAdapterWrapper, this.internalScanResultCreator, new EmulatedScanFilterMatcher(scanFilterArr)), new InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi18.1
            @Override // defpackage.InterfaceC5298
            public InterfaceC2856<RxBleInternalScanResult> apply(AbstractC4262<RxBleInternalScanResult> abstractC4262) {
                return abstractC4262.compose(interfaceC5298EmulateScanMode).compose(interfaceC5298EmulateCallbackType);
            }
        });
    }
}
