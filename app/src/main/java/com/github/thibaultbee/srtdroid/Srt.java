package com.github.thibaultbee.srtdroid;

/* compiled from: Srt.kt */
/* loaded from: classes.dex */
public final class Srt {
    public static final Srt INSTANCE = new Srt();

    static {
        System.loadLibrary("jnisrt");
    }

    private Srt() {
    }

    private final native int nativeGetVersion();

    public final native int cleanUp();

    public final int getVersion() {
        return nativeGetVersion();
    }

    public final native void setLogLevel(int i);

    public final native int startUp();
}
