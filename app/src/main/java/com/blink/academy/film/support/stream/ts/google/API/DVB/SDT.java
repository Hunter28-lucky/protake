package com.blink.academy.film.support.stream.ts.google.API.DVB;

import com.blink.academy.film.support.stream.ts.google.API.SITable;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface SDT extends SITable {
    boolean addService(SDTService sDTService);

    int getOrgNetworkId();

    SDTService getServiceAt(int i);

    Iterator<SDTService> getServices();

    int getTransportStreamId();

    int getVersionNumber();

    boolean isActual();

    int numServices();

    boolean removeAllServices();

    boolean removeService(SDTService sDTService);

    void setIsActual(boolean z);

    void setOrgNetworkId(int i);

    void setTransportStreamId(int i);

    void setVersionNumber(int i);
}
