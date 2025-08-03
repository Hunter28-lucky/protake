package com.blink.academy.film.support.stream.ts;

/* loaded from: classes.dex */
public class ContinuityCounter {
    private int videoCC = 15;

    public int incrementAndGetVideo() {
        int i = (this.videoCC + 1) & 15;
        this.videoCC = i;
        return i;
    }
}
