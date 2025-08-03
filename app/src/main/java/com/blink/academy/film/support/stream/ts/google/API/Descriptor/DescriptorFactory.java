package com.blink.academy.film.support.stream.ts.google.API.Descriptor;

import com.blink.academy.film.support.stream.ts.google.Core.Descriptor.AC3_AudioImpl;
import com.blink.academy.film.support.stream.ts.google.Core.Descriptor.DescriptorImpl;
import com.blink.academy.film.support.stream.ts.google.Core.Descriptor.ISO_639_LanguageImpl;
import com.blink.academy.film.support.stream.ts.google.Core.Descriptor.ServiceLocationImpl;

/* loaded from: classes.dex */
public class DescriptorFactory {
    public static DC_AC3Audio createAC3Audio() {
        return new AC3_AudioImpl();
    }

    public static Descriptor createDescriptor(DescriptorTag descriptorTag) {
        return new DescriptorImpl(descriptorTag);
    }

    public static DC_ISO639Language createISO_639_Language() {
        return new ISO_639_LanguageImpl();
    }

    public static DC_ServiceLocation createServiceLocation() {
        return new ServiceLocationImpl();
    }
}
