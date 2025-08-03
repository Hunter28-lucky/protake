package com.blink.academy.film.support.stream.ts.google.API.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.API.SITable;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface TVCT extends SITable, DescriptorMethod {
    boolean addChannel(TVCTChannel tVCTChannel);

    boolean addChannelAt(int i, TVCTChannel tVCTChannel);

    TVCTChannel getChannelAt(int i);

    Iterator<TVCTChannel> getChannels();

    int getNumChannels();

    int getTransportStreamId();

    int getVersionNumber();

    boolean setChannelAt(int i, TVCTChannel tVCTChannel);

    void setTransportStreamId(int i);

    void setVersionNumber(int i);
}
