package com.blink.academy.film.support.stream.ts.google.API.MultiString;

import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface MultipleStringData extends ByteRepresentation, XMLRepresentation {
    boolean addStringSegment(StringSegment stringSegment);

    boolean addStringSegmentAt(int i, StringSegment stringSegment);

    int getLanguageCode();

    int getNumberSegments();

    StringSegment getStringSegmentAt(int i);

    Iterator<StringSegment> getStringSegments();

    int getStringSegmentsLength();

    void removeAllStringSegments();

    boolean removeStringSegment(StringSegment stringSegment);

    boolean removeStringSegmentAt(int i, StringSegment stringSegment);

    void setLanguageCode(int i);

    boolean setStringSegmentAt(int i, StringSegment stringSegment);
}
