package com.blink.academy.film.support.stream.ts.google.API.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure;
import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;

/* loaded from: classes.dex */
public interface RRTDimensionValue extends ByteRepresentation, XMLRepresentation {
    int getAbbrevRatingValueLength();

    MultipleStringStructure getAbbrevRatingValueText();

    int getRatingValueLength();

    MultipleStringStructure getRatingValueText();

    void setAbbrevRatingValueText(MultipleStringStructure multipleStringStructure);

    void setRatingValueText(MultipleStringStructure multipleStringStructure);
}
