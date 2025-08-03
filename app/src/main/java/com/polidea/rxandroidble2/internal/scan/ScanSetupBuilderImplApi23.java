package com.polidea.rxandroidble2.internal.scan;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.operations.ScanOperationApi21;
import com.polidea.rxandroidble2.internal.util.ObservableUtil;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;
import defpackage.InterfaceC5298;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class ScanSetupBuilderImplApi23 implements ScanSetupBuilder {
    private final AndroidScanObjectsConverter androidScanObjectsConverter;
    private final InternalScanResultCreator internalScanResultCreator;
    private final RxBleAdapterWrapper rxBleAdapterWrapper;
    private final ScanSettingsEmulator scanSettingsEmulator;

    public ScanSetupBuilderImplApi23(RxBleAdapterWrapper rxBleAdapterWrapper, InternalScanResultCreator internalScanResultCreator, ScanSettingsEmulator scanSettingsEmulator, AndroidScanObjectsConverter androidScanObjectsConverter) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
        this.internalScanResultCreator = internalScanResultCreator;
        this.scanSettingsEmulator = scanSettingsEmulator;
        this.androidScanObjectsConverter = androidScanObjectsConverter;
    }

    private static boolean areFiltersSpecified(ScanFilter[] scanFilterArr) {
        boolean zIsAllFieldsEmpty = true;
        for (ScanFilter scanFilter : scanFilterArr) {
            zIsAllFieldsEmpty &= scanFilter.isAllFieldsEmpty();
        }
        return !zIsAllFieldsEmpty;
    }

    @Override // com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder
    @RequiresApi(21)
    public ScanSetup build(ScanSettings scanSettings, ScanFilter... scanFilterArr) {
        boolean zAreFiltersSpecified = areFiltersSpecified(scanFilterArr);
        boolean z = scanSettings.getCallbackType() != 1;
        InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> interfaceC5298IdentityTransformer = ObservableUtil.identityTransformer();
        if (z && !zAreFiltersSpecified) {
            RxBleLog.d("ScanSettings.callbackType != CALLBACK_TYPE_ALL_MATCHES but no (or only empty) filters are specified. Falling back to callbackType emulation.", new Object[0]);
            interfaceC5298IdentityTransformer = this.scanSettingsEmulator.emulateCallbackType(scanSettings.getCallbackType());
            scanSettings = scanSettings.copyWithCallbackType(1);
        }
        return new ScanSetup(new ScanOperationApi21(this.rxBleAdapterWrapper, this.internalScanResultCreator, this.androidScanObjectsConverter, scanSettings, new EmulatedScanFilterMatcher(new ScanFilterInterface[0]), scanFilterArr), interfaceC5298IdentityTransformer);
    }
}
