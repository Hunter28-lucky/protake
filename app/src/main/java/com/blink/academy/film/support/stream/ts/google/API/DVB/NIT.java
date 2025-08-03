package com.blink.academy.film.support.stream.ts.google.API.DVB;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.API.SITable;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface NIT extends SITable, DescriptorMethod {
    boolean addTransportStream(NITTransportStream nITTransportStream);

    int getNetworkId();

    NITTransportStream getTransportStreamAt(int i);

    Iterator<NITTransportStream> getTransportStreams();

    int getVersionNumber();

    boolean isActual();

    int numTransportStreams();

    void removeAllTransportStreams();

    boolean removeTransportStream(NITTransportStream nITTransportStream);

    void setIsActual(boolean z);

    void setNetworkId(int i);

    void setVersionNumber(int i);
}
