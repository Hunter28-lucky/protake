package com.blink.academy.film.support.stream.ts.google.API.DVB;

import com.blink.academy.film.support.stream.ts.google.API.SITable;

/* loaded from: classes.dex */
public interface EITPF extends SITable {
    DVBEITEvent getFollowingEvent();

    int getOrgNetworkId();

    DVBEITEvent getPresentEvent();

    int getServiceId();

    int getTransportStreamId();

    int getVersionNumber();

    boolean isActual();

    void setFollowingEvent(DVBEITEvent dVBEITEvent);

    void setIsActual(boolean z);

    void setOrgNetworkId(int i);

    void setPresentEvent(DVBEITEvent dVBEITEvent);

    void setServiceId(int i);

    void setTransportStreamId(int i);

    void setVersionNumber(int i);
}
