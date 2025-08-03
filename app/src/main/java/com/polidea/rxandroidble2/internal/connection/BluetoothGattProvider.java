package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import androidx.annotation.NonNull;
import defpackage.C4905;
import java.util.concurrent.atomic.AtomicReference;

@ConnectionScope
/* loaded from: classes2.dex */
public class BluetoothGattProvider {
    private final AtomicReference<BluetoothGatt> reference = new AtomicReference<>();

    public BluetoothGatt getBluetoothGatt() {
        return this.reference.get();
    }

    public void updateBluetoothGatt(@NonNull BluetoothGatt bluetoothGatt) {
        C4905.m14631(this.reference, null, bluetoothGatt);
    }
}
