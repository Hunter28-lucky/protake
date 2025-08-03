package com.polidea.rxandroidble2.internal.util;

import android.content.Context;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class BleConnectionCompat_Factory implements InterfaceC3628<BleConnectionCompat> {
    private final InterfaceC4461<Context> contextProvider;

    public BleConnectionCompat_Factory(InterfaceC4461<Context> interfaceC4461) {
        this.contextProvider = interfaceC4461;
    }

    public static BleConnectionCompat_Factory create(InterfaceC4461<Context> interfaceC4461) {
        return new BleConnectionCompat_Factory(interfaceC4461);
    }

    @Override // defpackage.InterfaceC4461
    public BleConnectionCompat get() {
        return new BleConnectionCompat(this.contextProvider.get());
    }
}
