package com.blink.academy.film.support.stream.ts.google.API;

import com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;

/* loaded from: classes.dex */
public interface SITable extends XMLRepresentation, SectionRepresentation, Cloneable {
    SITable clone();

    long getDuration();

    long getEndTime();

    long getIntervalMillis();

    long getStartTime();

    TableID getTableID();

    int getTablePID();

    int getTableVersion();

    int getUniqueID();

    void setEndTime(long j);

    void setIntervalMillis(long j);

    void setStartTime(long j);
}
