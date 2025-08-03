package com.blink.academy.film.support.stream.ts.google.API.PSI;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.API.SITable;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface PMT extends SITable, DescriptorMethod {
    boolean addStream(PMTStream pMTStream);

    boolean addStreamAt(int i, PMTStream pMTStream);

    int getPCR_PID();

    int getProgramNumber();

    PMTStream getStreamAt(int i);

    int getStreamSize();

    Iterator<PMTStream> getStreams();

    int getStreamsLength();

    int getVersionNumber();

    void removeAllStreams();

    boolean removeStream(PMTStream pMTStream);

    boolean removeStreamAt(int i, PMTStream pMTStream);

    void setPCR_PID(int i);

    void setProgramNumber(int i);

    boolean setStreamAt(int i, PMTStream pMTStream);

    void setVersionNumber(int i);
}
