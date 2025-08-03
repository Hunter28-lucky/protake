package com.blink.academy.film.support.stream.ts.google.API.Descriptor;

import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;

/* loaded from: classes.dex */
public interface Descriptor extends ByteRepresentation, XMLRepresentation {
    DescriptorContent getContent();

    int getDescriptorLength();

    DescriptorTag getDescriptorTag();

    void setContent(DescriptorContent descriptorContent);
}
