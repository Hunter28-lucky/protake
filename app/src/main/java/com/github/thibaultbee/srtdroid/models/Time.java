package com.github.thibaultbee.srtdroid.models;

import com.github.thibaultbee.srtdroid.Srt;

/* compiled from: Time.kt */
/* loaded from: classes.dex */
public final class Time {
    public static final Time INSTANCE = new Time();

    static {
        Srt.INSTANCE.startUp();
    }

    private Time() {
    }

    public final native long now();
}
