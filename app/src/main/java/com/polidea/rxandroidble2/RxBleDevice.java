package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothDevice;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.polidea.rxandroidble2.RxBleConnection;
import defpackage.AbstractC4262;

/* loaded from: classes2.dex */
public interface RxBleDevice {
    AbstractC4262<RxBleConnection> establishConnection(boolean z);

    AbstractC4262<RxBleConnection> establishConnection(boolean z, @NonNull Timeout timeout);

    BluetoothDevice getBluetoothDevice();

    RxBleConnection.RxBleConnectionState getConnectionState();

    String getMacAddress();

    @Nullable
    String getName();

    AbstractC4262<RxBleConnection.RxBleConnectionState> observeConnectionStateChanges();
}
