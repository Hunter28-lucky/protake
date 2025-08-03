package com.blink.academy.film.support.stream.ts.google.API.DVB;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;

/* loaded from: classes.dex */
public interface DVBEITEvent extends ByteRepresentation, XMLRepresentation, DescriptorMethod {
    int getDuration();

    int getEventId();

    int getFreeCaMode();

    int getRunningStatus();

    long getStartTime();

    void setDuration(int i);

    void setDuration(int i, int i2, int i3);

    void setEventId(int i);

    void setFreeCaMode(int i);

    void setRunningStatus(int i);

    void setStartTime(int i, int i2, int i3, int i4, int i5, int i6);

    void setStartTime(long j);
}
