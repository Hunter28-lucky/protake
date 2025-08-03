package com.blink.academy.film.support.stream.ts.google.API.PSI;

import com.blink.academy.film.support.stream.ts.google.API.SITable;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface PAT extends SITable {
    boolean addProgram(PATProgram pATProgram);

    boolean addProgramAt(int i, PATProgram pATProgram);

    PATProgram getProgramAt(int i);

    int getProgramSize();

    Iterator<PATProgram> getPrograms();

    int getTransportStreamId();

    int getVersionNumber();

    void removeAllPrograms();

    boolean removeProgram(PATProgram pATProgram);

    boolean removeProgramAt(int i);

    boolean setProgramAt(int i, PATProgram pATProgram);

    void setTransportStreamId(int i);

    void setVersionNumber(int i);
}
