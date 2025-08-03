package com.blink.academy.film.support.stream.ts;

import com.github.thibaultbee.srtdroid.models.Socket;

/* loaded from: classes.dex */
public interface TsSender {
    Socket getSocket();

    void release();

    void sendData(byte[] bArr);

    void sendInfoData(byte[] bArr);

    boolean socketAlive();
}
