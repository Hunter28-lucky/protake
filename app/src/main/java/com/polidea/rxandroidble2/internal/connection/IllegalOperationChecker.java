package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.internal.BleIllegalOperationException;
import defpackage.AbstractC2900;
import defpackage.InterfaceC3809;

/* loaded from: classes2.dex */
public class IllegalOperationChecker {
    public final IllegalOperationHandler resultHandler;

    public IllegalOperationChecker(IllegalOperationHandler illegalOperationHandler) {
        this.resultHandler = illegalOperationHandler;
    }

    public AbstractC2900 checkAnyPropertyMatches(final BluetoothGattCharacteristic bluetoothGattCharacteristic, final int i) {
        return AbstractC2900.m10271(new InterfaceC3809() { // from class: com.polidea.rxandroidble2.internal.connection.IllegalOperationChecker.1
            @Override // defpackage.InterfaceC3809
            public void run() {
                BleIllegalOperationException bleIllegalOperationExceptionHandleMismatchData;
                int properties = bluetoothGattCharacteristic.getProperties();
                int i2 = i;
                if ((properties & i2) == 0 && (bleIllegalOperationExceptionHandleMismatchData = IllegalOperationChecker.this.resultHandler.handleMismatchData(bluetoothGattCharacteristic, i2)) != null) {
                    throw bleIllegalOperationExceptionHandleMismatchData;
                }
            }
        });
    }
}
