package com.blink.academy.film.support.stream.ts.google.API.Descriptor;

/* loaded from: classes.dex */
public interface DC_ISO639Language extends DescriptorContent {
    boolean addLanguage(int i, int i2);

    boolean addLanguageAt(int i, int i2, int i3);

    int getAudioTypeAt(int i);

    int getLanguageCodeAt(int i);

    int getLanguagesDefined();

    boolean setLanguageAt(int i, int i2, int i3);
}
