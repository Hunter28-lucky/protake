package com.polidea.rxandroidble2.internal.connection;

import defpackage.InterfaceC3628;

/* loaded from: classes2.dex */
public final class ConnectionModule_MinimumMtuFactory implements InterfaceC3628<Integer> {
    private static final ConnectionModule_MinimumMtuFactory INSTANCE = new ConnectionModule_MinimumMtuFactory();

    public static ConnectionModule_MinimumMtuFactory create() {
        return INSTANCE;
    }

    public static int proxyMinimumMtu() {
        return ConnectionModule.minimumMtu();
    }

    @Override // defpackage.InterfaceC4461
    public Integer get() {
        return Integer.valueOf(ConnectionModule.minimumMtu());
    }
}
