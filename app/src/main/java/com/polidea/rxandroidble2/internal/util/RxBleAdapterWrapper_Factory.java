package com.polidea.rxandroidble2.internal.util;

import android.bluetooth.BluetoothAdapter;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class RxBleAdapterWrapper_Factory implements InterfaceC3628<RxBleAdapterWrapper> {
    private final InterfaceC4461<BluetoothAdapter> bluetoothAdapterProvider;

    public RxBleAdapterWrapper_Factory(InterfaceC4461<BluetoothAdapter> interfaceC4461) {
        this.bluetoothAdapterProvider = interfaceC4461;
    }

    public static RxBleAdapterWrapper_Factory create(InterfaceC4461<BluetoothAdapter> interfaceC4461) {
        return new RxBleAdapterWrapper_Factory(interfaceC4461);
    }

    @Override // defpackage.InterfaceC4461
    public RxBleAdapterWrapper get() {
        return new RxBleAdapterWrapper(this.bluetoothAdapterProvider.get());
    }
}
