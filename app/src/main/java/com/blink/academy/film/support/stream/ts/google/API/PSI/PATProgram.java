package com.blink.academy.film.support.stream.ts.google.API.PSI;

import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;

/* loaded from: classes.dex */
public interface PATProgram extends ByteRepresentation, XMLRepresentation {
    int getPID();

    int getProgramNumber();

    void setPID(int i);

    void setProgramNumber(int i);
}
