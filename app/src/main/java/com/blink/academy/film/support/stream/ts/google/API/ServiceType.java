package com.blink.academy.film.support.stream.ts.google.API;

/* loaded from: classes.dex */
public enum ServiceType {
    RESERVED(0),
    ANALOG_TELEVISION(1),
    ATSC_DIGITAL_TELEVISION(2),
    ATSC_AUDIO(3),
    ATSC_DATA_ONLY_SERVICE(4);

    private int value;

    ServiceType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
