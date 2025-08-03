package com.blink.academy.film.custom;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ABPointMessage {
    public static final int AB_POINT_MODE_BOTH = 3;
    public static final int AB_POINT_MODE_FOCUS = 2;
    public static final int AB_POINT_MODE_ZOOM = 1;
    private float endFocusP;
    private long endMs;
    private float endZoomP;
    private float startFocusP;
    private long startMs;
    private float startZoomP;
    private long totalMs;
    private int type;

    public float getEndFocusP() {
        return this.endFocusP;
    }

    public long getEndMs() {
        return this.endMs;
    }

    public float getEndZoomP() {
        return this.endZoomP;
    }

    public float getStartFocusP() {
        return this.startFocusP;
    }

    public long getStartMs() {
        return this.startMs;
    }

    public float getStartZoomP() {
        return this.startZoomP;
    }

    public long getTotalMs() {
        return this.totalMs;
    }

    public int getType() {
        return this.type;
    }

    public void setEndFocusP(float f) {
        this.endFocusP = f;
    }

    public void setEndMs(long j) {
        this.endMs = j;
    }

    public void setEndZoomP(float f) {
        this.endZoomP = f;
    }

    public void setStartFocusP(float f) {
        this.startFocusP = f;
    }

    public void setStartMs(long j) {
        this.startMs = j;
    }

    public void setStartZoomP(float f) {
        this.startZoomP = f;
    }

    public void setTotalMs(long j) {
        this.totalMs = j;
    }

    public void setType(int i) {
        this.type = i;
    }

    @NonNull
    public String toString() {
        return "startMs:" + getStartMs() + " endMs:" + getEndMs();
    }
}
