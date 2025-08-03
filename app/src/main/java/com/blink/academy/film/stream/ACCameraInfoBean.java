package com.blink.academy.film.stream;

import java.util.Map;

/* loaded from: classes.dex */
public class ACCameraInfoBean {
    private int albumControlable;
    private boolean albumMode;
    private String[] block;
    private int cameraType;
    private String cityCN;
    private String cityCNT;
    private String cityEN;
    private String[] controlable;
    private boolean cropVideo;
    private String dimension;
    private String fps;
    private boolean init;
    private String latitude;
    private String longitude;
    private String machine;
    private String netType;
    private String[] outRange;
    private int pixelFormat;
    private boolean playing;
    private int ratio;
    private boolean recording;
    private Map<String, Integer> safeMap;
    private int streamType;
    private String time;
    private String uuid;
    private int wifiStatus;

    public int getAlbumControlable() {
        return this.albumControlable;
    }

    public String[] getBlock() {
        return this.block;
    }

    public int getCameraType() {
        return this.cameraType;
    }

    public String getCityCN() {
        return this.cityCN;
    }

    public String getCityCNT() {
        return this.cityCNT;
    }

    public String getCityEN() {
        return this.cityEN;
    }

    public String[] getControlable() {
        return this.controlable;
    }

    public boolean getCropVideo() {
        return this.cropVideo;
    }

    public String getDimension() {
        return this.dimension;
    }

    public String getFps() {
        return this.fps;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getMachine() {
        return this.machine;
    }

    public String getNetType() {
        return this.netType;
    }

    public String[] getOutRange() {
        return this.outRange;
    }

    public int getPixelFormat() {
        return this.pixelFormat;
    }

    public int getRatio() {
        return this.ratio;
    }

    public boolean getRecording() {
        return this.recording;
    }

    public Map<String, Integer> getSafeMap() {
        return this.safeMap;
    }

    public int getStreamType() {
        return this.streamType;
    }

    public String getTime() {
        return this.time;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getWifiStatus() {
        return this.wifiStatus;
    }

    public boolean isAlbumMode() {
        return this.albumMode;
    }

    public boolean isAnamorphic() {
        return this.streamType == 1;
    }

    public boolean isInit() {
        return this.init;
    }

    public boolean isPlaying() {
        return this.playing;
    }

    public void setAlbumControlable(int i) {
        this.albumControlable = i;
    }

    public void setAlbumMode(boolean z) {
        this.albumMode = z;
    }

    public void setBlock(String[] strArr) {
        this.block = strArr;
    }

    public void setCameraType(int i) {
        this.cameraType = i;
    }

    public void setCityCN(String str) {
        this.cityCN = str;
    }

    public void setCityCNT(String str) {
        this.cityCNT = str;
    }

    public void setCityEN(String str) {
        this.cityEN = str;
    }

    public void setControlable(String[] strArr) {
        this.controlable = strArr;
    }

    public void setCropVideo(boolean z) {
        this.cropVideo = z;
    }

    public void setDimension(String str) {
        this.dimension = str;
    }

    public void setFps(String str) {
        this.fps = str;
    }

    public void setInit(boolean z) {
        this.init = z;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setMachine(String str) {
        this.machine = str;
    }

    public void setNetType(String str) {
        this.netType = str;
    }

    public void setOutRange(String[] strArr) {
        this.outRange = strArr;
    }

    public void setPixelFormat(int i) {
        this.pixelFormat = i;
    }

    public void setPlaying(boolean z) {
        this.playing = z;
    }

    public void setRatio(int i) {
        this.ratio = i;
    }

    public void setRecording(boolean z) {
        this.recording = z;
    }

    public void setSafeMap(Map<String, Integer> map) {
        this.safeMap = map;
    }

    public void setStreamType(int i) {
        this.streamType = i;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setWifiStatus(int i) {
        this.wifiStatus = i;
    }
}
