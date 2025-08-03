package com.blink.academy.film.support.stream.ts.google.API.DVB;

import com.blink.academy.film.support.stream.ts.google.API.SITable;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface EITSchedule extends SITable {
    boolean addEvent(DVBEITEvent dVBEITEvent);

    DVBEITEvent getEventAt(int i);

    Iterator<DVBEITEvent> getEvents();

    int getOrgNetworkId();

    int getServiceId();

    int getTransportStreamId();

    int getVersionNumber();

    boolean isActual();

    int numEvents();

    boolean removeEvent(DVBEITEvent dVBEITEvent);

    void setIsActual(boolean z);

    void setOrgNetworkId(int i);

    void setServiceId(int i);

    void setTransportStreamId(int i);

    void setVersionNumber(int i);
}
