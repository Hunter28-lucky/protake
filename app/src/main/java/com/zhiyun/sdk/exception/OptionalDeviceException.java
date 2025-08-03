package com.zhiyun.sdk.exception;

import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class OptionalDeviceException extends Exception {
    public static final int TYPE_DEVICE_UNCONNECTED = 1;
    public static final int TYPE_TIMEOUT = 2;
    private int tag;

    public OptionalDeviceException(String str, int i) {
        super(str);
        this.tag = i;
    }

    public static OptionalDeviceException getInstance(Throwable th) {
        return th instanceof BleDisconnectedException ? new OptionalDeviceException("Device not connected.", 1) : th instanceof TimeoutException ? new OptionalDeviceException("Time out.", 2) : th instanceof OptionalDeviceException ? (OptionalDeviceException) th : new OptionalDeviceException("Unknown error", 0);
    }

    public int getTag() {
        return this.tag;
    }
}
