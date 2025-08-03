package com.blink.academy.film.support.stream.ts.google.API.DVB;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;

/* loaded from: classes.dex */
public interface BATTransportStream extends ByteRepresentation, XMLRepresentation, DescriptorMethod {
    int getOrgNetworkId();

    int getTransportStreamId();

    void setOrgNetworkId(int i);

    void setTransportStreamId(int i);
}
