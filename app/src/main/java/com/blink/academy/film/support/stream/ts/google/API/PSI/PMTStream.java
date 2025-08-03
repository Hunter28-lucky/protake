package com.blink.academy.film.support.stream.ts.google.API.PSI;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.API.StreamType;
import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;

/* loaded from: classes.dex */
public interface PMTStream extends ByteRepresentation, XMLRepresentation, DescriptorMethod {
    int getElementaryPID();

    StreamType getStreamType();

    void setElementaryPID(int i);

    void setStreamType(StreamType streamType);
}
