package com.blink.academy.film.support.stream.ts.google.API.Descriptor;

import com.blink.academy.film.support.stream.ts.google.API.StreamType;

/* loaded from: classes.dex */
public interface DC_ServiceLocation extends DescriptorContent {
    boolean addElement(StreamType streamType, int i, int i2);

    boolean addElementAt(int i, StreamType streamType, int i2, int i3);

    int getElementaryPidAt(int i);

    int getElementsLength();

    int getLanguageCodeAt(int i);

    int getNumberElements();

    int getPCR_PID();

    StreamType getStreamTypeAt(int i);

    void removeAllElements();

    boolean removeElementAt(int i);

    boolean setElementAt(int i, StreamType streamType, int i2, int i3);
}
