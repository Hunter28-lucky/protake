package com.blink.academy.film.support.stream.ts.google.API.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure;
import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;

/* loaded from: classes.dex */
public interface EITEvent extends ByteRepresentation, XMLRepresentation, DescriptorMethod {
    int getETMLocation();

    int getEventId();

    int getLengthInSeconds();

    long getStartTime();

    int getTitleLength();

    MultipleStringStructure getTitleText();

    void setETMLocation(int i);

    void setEventId(int i);

    void setLengthInSeconds(int i);

    void setStartTime(long j);

    void setTitleText(MultipleStringStructure multipleStringStructure);
}
