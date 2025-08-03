package com.blink.academy.film.support.stream.ts.google.API.DVB;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;

/* loaded from: classes.dex */
public interface SDTService extends ByteRepresentation, XMLRepresentation, DescriptorMethod {
    int getEitPfFlag();

    int getEitSchedFlag();

    int getFreeCaMode();

    int getRunningStatus();

    int getServiceId();

    void setEitPfFlag(int i);

    void setEitSchedFlag(int i);

    void setFreeCaMode(int i);

    void setRunningStatus(int i);

    void setServiceId(int i);
}
