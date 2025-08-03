package com.blink.academy.film.support.stream.ts.google.API.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.API.ServiceType;
import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;

/* loaded from: classes.dex */
public interface CVCTChannel extends ByteRepresentation, XMLRepresentation, DescriptorMethod {
    int getAccessControlled();

    long getCarrierFrequency();

    int getChannelTSID();

    int getETMLocation();

    int getHidden();

    int getHideGuide();

    int getMajorChannelNumber();

    int getMinorChannelNumber();

    int getModulationMode();

    int getOutOfBand();

    int getPathSelect();

    int getProgramNumber();

    ServiceType getServiceType();

    char[] getShortName();

    int getSourceId();

    void setAccessControlled(int i);

    void setCarrierFrequency(long j);

    void setChannelTSID(int i);

    void setETMLocation(int i);

    void setHidden(int i);

    void setHideGuide(int i);

    void setMajorChannelNumber(int i);

    void setMinorChannelNumber(int i);

    void setModulationMode(int i);

    void setOutOfBand(int i);

    void setPathSelect(int i);

    void setProgramNumber(int i);

    void setServiceType(ServiceType serviceType);

    void setShortName(char[] cArr);

    void setSourceId(int i);
}
