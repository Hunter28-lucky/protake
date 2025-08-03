package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class BackgroundScannerImpl_Factory implements InterfaceC3628<BackgroundScannerImpl> {
    private final InterfaceC4461<InternalScanResultCreator> internalScanResultCreatorProvider;
    private final InterfaceC4461<InternalToExternalScanResultConverter> internalToExternalScanResultConverterProvider;
    private final InterfaceC4461<RxBleAdapterWrapper> rxBleAdapterWrapperProvider;
    private final InterfaceC4461<AndroidScanObjectsConverter> scanObjectsConverterProvider;

    public BackgroundScannerImpl_Factory(InterfaceC4461<RxBleAdapterWrapper> interfaceC4461, InterfaceC4461<AndroidScanObjectsConverter> interfaceC44612, InterfaceC4461<InternalScanResultCreator> interfaceC44613, InterfaceC4461<InternalToExternalScanResultConverter> interfaceC44614) {
        this.rxBleAdapterWrapperProvider = interfaceC4461;
        this.scanObjectsConverterProvider = interfaceC44612;
        this.internalScanResultCreatorProvider = interfaceC44613;
        this.internalToExternalScanResultConverterProvider = interfaceC44614;
    }

    public static BackgroundScannerImpl_Factory create(InterfaceC4461<RxBleAdapterWrapper> interfaceC4461, InterfaceC4461<AndroidScanObjectsConverter> interfaceC44612, InterfaceC4461<InternalScanResultCreator> interfaceC44613, InterfaceC4461<InternalToExternalScanResultConverter> interfaceC44614) {
        return new BackgroundScannerImpl_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614);
    }

    public static BackgroundScannerImpl newBackgroundScannerImpl(RxBleAdapterWrapper rxBleAdapterWrapper, AndroidScanObjectsConverter androidScanObjectsConverter, InternalScanResultCreator internalScanResultCreator, InternalToExternalScanResultConverter internalToExternalScanResultConverter) {
        return new BackgroundScannerImpl(rxBleAdapterWrapper, androidScanObjectsConverter, internalScanResultCreator, internalToExternalScanResultConverter);
    }

    @Override // defpackage.InterfaceC4461
    public BackgroundScannerImpl get() {
        return new BackgroundScannerImpl(this.rxBleAdapterWrapperProvider.get(), this.scanObjectsConverterProvider.get(), this.internalScanResultCreatorProvider.get(), this.internalToExternalScanResultConverterProvider.get());
    }
}
