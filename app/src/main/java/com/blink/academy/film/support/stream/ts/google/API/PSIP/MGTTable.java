package com.blink.academy.film.support.stream.ts.google.API.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.API.TableType;
import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;

/* loaded from: classes.dex */
public interface MGTTable extends ByteRepresentation, XMLRepresentation, DescriptorMethod {
    long getNumberBytes();

    TableType getTableType();

    int getTableTypePID();

    int getTableTypeVersionNumber();

    void setNumberBytes(int i);

    void setTableType(TableType tableType);

    void setTableTypePID(int i);

    void setTableTypeVersionNumber(int i);
}
