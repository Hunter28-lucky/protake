package com.github.thibaultbee.srtdroid.models;

import com.github.thibaultbee.srtdroid.Srt;
import com.github.thibaultbee.srtdroid.enums.ErrorType;

/* compiled from: Error.kt */
/* loaded from: classes.dex */
public final class Error {
    public static final Error INSTANCE = new Error();

    static {
        Srt.INSTANCE.startUp();
    }

    private Error() {
    }

    private final native ErrorType nativeGetLastError();

    private final native String nativeGetLastErrorMessage();

    public final native void clearLastError();

    public final ErrorType getLastError() {
        return nativeGetLastError();
    }

    public final String getLastErrorMessage() {
        return nativeGetLastErrorMessage();
    }
}
