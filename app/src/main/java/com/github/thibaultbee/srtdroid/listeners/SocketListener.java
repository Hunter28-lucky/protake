package com.github.thibaultbee.srtdroid.listeners;

import com.github.thibaultbee.srtdroid.enums.ErrorType;
import com.github.thibaultbee.srtdroid.models.Socket;
import java.net.InetSocketAddress;

/* compiled from: SocketListener.kt */
/* loaded from: classes.dex */
public interface SocketListener {
    void onConnectionLost(Socket socket, ErrorType errorType, InetSocketAddress inetSocketAddress, int i);

    int onListen(Socket socket, int i, InetSocketAddress inetSocketAddress, String str);
}
