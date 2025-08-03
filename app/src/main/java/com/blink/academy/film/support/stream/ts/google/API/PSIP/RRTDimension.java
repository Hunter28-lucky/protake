package com.blink.academy.film.support.stream.ts.google.API.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure;
import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface RRTDimension extends ByteRepresentation, XMLRepresentation {
    boolean addValue(RRTDimensionValue rRTDimensionValue);

    boolean addValueAt(int i, RRTDimensionValue rRTDimensionValue);

    int getDimensionNameLength();

    MultipleStringStructure getDimensionNameText();

    int getGraduatedScale();

    RRTDimensionValue getValueAt(int i);

    Iterator<RRTDimensionValue> getValues();

    int getValuesDefined();

    int getValuesLength();

    void removeAllValues();

    boolean removeValue(RRTDimensionValue rRTDimensionValue);

    boolean removeValueAt(int i, RRTDimensionValue rRTDimensionValue);

    void setDimensionNameText(MultipleStringStructure multipleStringStructure);

    void setGraduatedScale(int i);

    boolean setValueAt(int i, RRTDimensionValue rRTDimensionValue);
}
