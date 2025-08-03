package com.github.thibaultbee.srtdroid.models;

import com.github.thibaultbee.srtdroid.enums.EpollOpt;
import com.umeng.analytics.pro.d;
import defpackage.C3921;
import java.util.List;

/* compiled from: EpollEvent.kt */
/* loaded from: classes.dex */
public final class EpollEvent {
    private final List<EpollOpt> events;
    private final Socket socket;

    /* JADX WARN: Multi-variable type inference failed */
    public EpollEvent(Socket socket, List<? extends EpollOpt> list) {
        C3921.m12666(socket, "socket");
        C3921.m12666(list, d.ar);
        this.socket = socket;
        this.events = list;
    }

    public final List<EpollOpt> getEvents() {
        return this.events;
    }

    public final Socket getSocket() {
        return this.socket;
    }
}
