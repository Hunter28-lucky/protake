package com.blink.academy.film.support.stream.ts.google.API.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.SITable;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface EIT extends SITable {
    boolean addEvent(EITEvent eITEvent);

    boolean addEventAt(int i, EITEvent eITEvent);

    EITEvent getEventAt(int i);

    Iterator<EITEvent> getEvents();

    int getEventsLength();

    int getNumEventsInSection();

    int getSourceId();

    int getVersionNumber();

    void removeAllEvents();

    boolean removeEvent(EITEvent eITEvent);

    boolean removeEventAt(int i);

    boolean setEventAt(int i, EITEvent eITEvent);

    void setSourceId(int i);

    void setVersionNumber(int i);
}
