package com.blink.academy.film.support.stream.ts;

/* loaded from: classes.dex */
public interface TsReceiver {

    public interface DataCallback {
        void onConnectionClose();

        void onDataReceived(byte[] bArr);

        void onInitFail(Exception exc);
    }

    void release();
}
