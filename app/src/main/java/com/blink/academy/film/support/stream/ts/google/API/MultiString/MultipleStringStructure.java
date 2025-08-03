package com.blink.academy.film.support.stream.ts.google.API.MultiString;

import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface MultipleStringStructure extends ByteRepresentation, XMLRepresentation {
    boolean addStringData(MultipleStringData multipleStringData);

    boolean addStringDataAt(int i, MultipleStringData multipleStringData);

    Iterator<MultipleStringData> getAllStringData();

    int getAllStringDataLength();

    int getNumberStrings();

    MultipleStringData getStringDataAt(int i);

    void removeAllStringData();

    boolean removeStringData(MultipleStringData multipleStringData);

    boolean removeStringDataAt(int i);

    boolean setStringDataAt(int i, MultipleStringData multipleStringData);
}
