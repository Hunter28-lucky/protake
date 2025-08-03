package com.blink.academy.film.support.stream.ts.google.API.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.API.SITable;

/* loaded from: classes.dex */
public interface STT extends SITable, DescriptorMethod {
    int getDatlightSavings();

    int getGPS_UTC_Offset();

    long getSystemTime();

    int getVersionNumber();

    void setDatlightSavings(int i);

    void setGPS_UTC_Offset(int i);

    void setSystemTime(long j);

    void setVersionNumber(int i);
}
