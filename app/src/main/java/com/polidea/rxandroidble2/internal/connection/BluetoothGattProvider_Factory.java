package com.polidea.rxandroidble2.internal.connection;

import defpackage.InterfaceC3628;

/* loaded from: classes2.dex */
public final class BluetoothGattProvider_Factory implements InterfaceC3628<BluetoothGattProvider> {
    private static final BluetoothGattProvider_Factory INSTANCE = new BluetoothGattProvider_Factory();

    public static BluetoothGattProvider_Factory create() {
        return INSTANCE;
    }

    public static BluetoothGattProvider newBluetoothGattProvider() {
        return new BluetoothGattProvider();
    }

    @Override // defpackage.InterfaceC4461
    public BluetoothGattProvider get() {
        return new BluetoothGattProvider();
    }
}
