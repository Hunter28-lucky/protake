package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ConnectionModule_ProvideBluetoothGattFactory implements InterfaceC3628<BluetoothGatt> {
    private final InterfaceC4461<BluetoothGattProvider> bluetoothGattProvider;

    public ConnectionModule_ProvideBluetoothGattFactory(InterfaceC4461<BluetoothGattProvider> interfaceC4461) {
        this.bluetoothGattProvider = interfaceC4461;
    }

    public static ConnectionModule_ProvideBluetoothGattFactory create(InterfaceC4461<BluetoothGattProvider> interfaceC4461) {
        return new ConnectionModule_ProvideBluetoothGattFactory(interfaceC4461);
    }

    public static BluetoothGatt proxyProvideBluetoothGatt(BluetoothGattProvider bluetoothGattProvider) {
        return (BluetoothGatt) C4618.m14073(ConnectionModule.provideBluetoothGatt(bluetoothGattProvider), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public BluetoothGatt get() {
        return (BluetoothGatt) C4618.m14073(ConnectionModule.provideBluetoothGatt(this.bluetoothGattProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
