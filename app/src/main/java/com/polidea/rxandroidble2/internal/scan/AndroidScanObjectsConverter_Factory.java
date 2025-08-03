package com.polidea.rxandroidble2.internal.scan;

import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class AndroidScanObjectsConverter_Factory implements InterfaceC3628<AndroidScanObjectsConverter> {
    private final InterfaceC4461<Integer> deviceSdkProvider;

    public AndroidScanObjectsConverter_Factory(InterfaceC4461<Integer> interfaceC4461) {
        this.deviceSdkProvider = interfaceC4461;
    }

    public static AndroidScanObjectsConverter_Factory create(InterfaceC4461<Integer> interfaceC4461) {
        return new AndroidScanObjectsConverter_Factory(interfaceC4461);
    }

    @Override // defpackage.InterfaceC4461
    public AndroidScanObjectsConverter get() {
        return new AndroidScanObjectsConverter(this.deviceSdkProvider.get().intValue());
    }
}
