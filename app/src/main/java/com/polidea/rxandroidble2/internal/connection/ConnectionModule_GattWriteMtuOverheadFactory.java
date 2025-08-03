package com.polidea.rxandroidble2.internal.connection;

import defpackage.InterfaceC3628;

/* loaded from: classes2.dex */
public final class ConnectionModule_GattWriteMtuOverheadFactory implements InterfaceC3628<Integer> {
    private static final ConnectionModule_GattWriteMtuOverheadFactory INSTANCE = new ConnectionModule_GattWriteMtuOverheadFactory();

    public static ConnectionModule_GattWriteMtuOverheadFactory create() {
        return INSTANCE;
    }

    public static int proxyGattWriteMtuOverhead() {
        return ConnectionModule.gattWriteMtuOverhead();
    }

    @Override // defpackage.InterfaceC4461
    public Integer get() {
        return Integer.valueOf(ConnectionModule.gattWriteMtuOverhead());
    }
}
