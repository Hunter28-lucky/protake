package com.blink.academy.film.stream;

/* loaded from: classes.dex */
public class ACLinkFrameInfoBean {
    private int captureMode;
    private boolean focusHasAuto;
    private float focusValue;
    private boolean isFocusEnable;
    private boolean isTouching;
    private boolean isZoomEnable;
    private int pixelFormat;
    private int priorityType;
    private String videoDes;
    private int videoMode;
    private double videoPercent;
    private int videoTag;
    private String videoTimeCode;
    private int wheelMode;
    private float zoomValue;

    public int getCaptureMode() {
        return this.captureMode;
    }

    public float getFocusValue() {
        return this.focusValue;
    }

    public int getPixelFormat() {
        return this.pixelFormat;
    }

    public int getPriorityType() {
        return this.priorityType;
    }

    public String getVideoDes() {
        return this.videoDes;
    }

    public int getVideoMode() {
        return this.videoMode;
    }

    public double getVideoPercent() {
        return this.videoPercent;
    }

    public int getVideoTag() {
        return this.videoTag;
    }

    public String getVideoTimeCode() {
        return this.videoTimeCode;
    }

    public int getWheelMode() {
        return this.wheelMode;
    }

    public float getZoomValue() {
        return this.zoomValue;
    }

    public boolean isFocusEnable() {
        return this.isFocusEnable;
    }

    public boolean isFocusHasAuto() {
        return this.focusHasAuto;
    }

    public boolean isTouching() {
        return this.isTouching;
    }

    public boolean isZoomEnable() {
        return this.isZoomEnable;
    }

    public void setCaptureMode(int i) {
        this.captureMode = i;
    }

    public void setFocusEnable(boolean z) {
        this.isFocusEnable = z;
    }

    public void setFocusHasAuto(boolean z) {
        this.focusHasAuto = z;
    }

    public void setFocusValue(float f) {
        this.focusValue = f;
    }

    public void setPixelFormat(int i) {
        this.pixelFormat = i;
    }

    public void setPriorityType(int i) {
        this.priorityType = i;
    }

    public void setTouching(boolean z) {
        this.isTouching = z;
    }

    public void setVideoDes(String str) {
        this.videoDes = str;
    }

    public void setVideoMode(int i) {
        this.videoMode = i;
    }

    public void setVideoPercent(double d) {
        this.videoPercent = d;
    }

    public void setVideoTag(int i) {
        this.videoTag = i;
    }

    public void setVideoTimeCode(String str) {
        this.videoTimeCode = str;
    }

    public void setWheelMode(int i) {
        this.wheelMode = i;
    }

    public void setZoomEnable(boolean z) {
        this.isZoomEnable = z;
    }

    public void setZoomValue(float f) {
        this.zoomValue = f;
    }
}
