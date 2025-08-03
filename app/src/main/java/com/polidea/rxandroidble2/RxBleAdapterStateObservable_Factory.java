package com.polidea.rxandroidble2;

import android.content.Context;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class RxBleAdapterStateObservable_Factory implements InterfaceC3628<RxBleAdapterStateObservable> {
    private final InterfaceC4461<Context> contextProvider;

    public RxBleAdapterStateObservable_Factory(InterfaceC4461<Context> interfaceC4461) {
        this.contextProvider = interfaceC4461;
    }

    public static RxBleAdapterStateObservable_Factory create(InterfaceC4461<Context> interfaceC4461) {
        return new RxBleAdapterStateObservable_Factory(interfaceC4461);
    }

    @Override // defpackage.InterfaceC4461
    public RxBleAdapterStateObservable get() {
        return new RxBleAdapterStateObservable(this.contextProvider.get());
    }
}
