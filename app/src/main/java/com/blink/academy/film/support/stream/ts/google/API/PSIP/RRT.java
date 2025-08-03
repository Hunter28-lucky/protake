package com.blink.academy.film.support.stream.ts.google.API.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod;
import com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure;
import com.blink.academy.film.support.stream.ts.google.API.SITable;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface RRT extends SITable, DescriptorMethod {
    boolean addDimension(RRTDimension rRTDimension);

    boolean addDimensionAt(int i, RRTDimension rRTDimension);

    RRTDimension getDimensionAt(int i);

    Iterator<RRTDimension> getDimensions();

    int getDimensionsDefined();

    int getDimensionsLength();

    int getRatingRegion();

    int getRatingRegionNameLength();

    MultipleStringStructure getRatingRegionNameText();

    int getVersionNumber();

    void removeAllDimensions();

    boolean removeDimension(RRTDimension rRTDimension);

    boolean removeDimensionAt(int i, RRTDimension rRTDimension);

    boolean setDimensionAt(int i, RRTDimension rRTDimension);

    void setRatingRegion(int i);

    void setRatingRegionNameText(MultipleStringStructure multipleStringStructure);

    void setVersionNumber(int i);
}
