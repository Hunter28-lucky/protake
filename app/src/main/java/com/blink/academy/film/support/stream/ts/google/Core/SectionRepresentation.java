package com.blink.academy.film.support.stream.ts.google.Core;

import com.blink.academy.film.support.stream.ts.google.API.Section;

/* loaded from: classes.dex */
public interface SectionRepresentation {
    int getTotalSectionNumber();

    boolean isMultiSection();

    Section[] toSection();
}
