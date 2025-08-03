package com.blink.academy.film.support.stream.ts.google.API.Descriptor;

import java.util.Iterator;

/* loaded from: classes.dex */
public interface DescriptorMethod {
    boolean addDescriptor(Descriptor descriptor);

    boolean addDescriptorAt(int i, Descriptor descriptor);

    Descriptor getDescriptorAt(int i);

    int getDescriptorSize();

    Iterator<Descriptor> getDescriptors();

    int getDescriptorsLength();

    void removeAllDescriptors();

    boolean removeDescriptor(Descriptor descriptor);

    boolean removeDescriptorAt(int i);

    boolean setDescriptorAt(int i, Descriptor descriptor);
}
