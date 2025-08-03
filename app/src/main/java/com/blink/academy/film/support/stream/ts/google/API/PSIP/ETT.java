package com.blink.academy.film.support.stream.ts.google.API.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure;
import com.blink.academy.film.support.stream.ts.google.API.SITable;

/* loaded from: classes.dex */
public interface ETT extends SITable {
    long getETMId();

    int getETTTableIdExtension();

    MultipleStringStructure getExtendedTextMessage();

    int getExtendedTextMessageSize();

    int getVersionNumber();

    void setETMId(long j);

    void setETTTableIdExtension(int i);

    void setExtendedTextMessage(MultipleStringStructure multipleStringStructure);

    void setVersionNumber(int i);
}
