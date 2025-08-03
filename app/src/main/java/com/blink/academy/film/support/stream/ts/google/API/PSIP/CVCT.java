package com.blink.academy.film.support.stream.ts.google.API.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.API.SITable;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface CVCT extends SITable, DescriptorMethod {
    boolean addChannel(CVCTChannel cVCTChannel);

    boolean addChannelAt(int i, CVCTChannel cVCTChannel);

    CVCTChannel getChannelAt(int i);

    Iterator<CVCTChannel> getChannels();

    int getNumChannels();

    int getTransportStreamId();

    int getVersionNumber();

    boolean setChannelAt(int i, CVCTChannel cVCTChannel);

    void setTransportStreamId(int i);

    void setVersionNumber(int i);
}
