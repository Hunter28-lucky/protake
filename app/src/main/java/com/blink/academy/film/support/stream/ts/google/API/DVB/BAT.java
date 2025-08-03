package com.blink.academy.film.support.stream.ts.google.API.DVB;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.API.SITable;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface BAT extends SITable, DescriptorMethod {
    boolean addTransportStream(BATTransportStream bATTransportStream);

    int getBouquetId();

    BATTransportStream getTransportStreamAt(int i);

    Iterator<BATTransportStream> getTransportStreams();

    int getVersionNumber();

    int numTransportStreams();

    void removeAllTransportStreams();

    boolean removeTransportStream(BATTransportStream bATTransportStream);

    void setBouquetId(int i);

    void setVersionNumber(int i);
}
