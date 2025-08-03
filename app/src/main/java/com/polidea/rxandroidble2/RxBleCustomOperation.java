package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothGatt;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;

/* loaded from: classes2.dex */
public interface RxBleCustomOperation<T> {
    @NonNull
    AbstractC4262<T> asObservable(BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, AbstractC4585 abstractC4585) throws Throwable;
}
