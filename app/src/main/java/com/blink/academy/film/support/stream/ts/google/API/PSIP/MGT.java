package com.blink.academy.film.support.stream.ts.google.API.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.API.SITable;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface MGT extends SITable, DescriptorMethod {
    boolean addTable(MGTTable mGTTable);

    boolean addTableAt(int i, MGTTable mGTTable);

    MGTTable getTableAt(int i);

    Iterator<MGTTable> getTables();

    int getTablesDefined();

    int getVersionNumber();

    void removeAllTables();

    boolean removeTable(MGTTable mGTTable);

    boolean removeTableAt(int i);

    boolean setTableAt(int i, MGTTable mGTTable);

    void setVersionNumber(int i);
}
