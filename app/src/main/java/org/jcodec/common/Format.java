package org.jcodec.common;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Format {
    public static final Format AVI;
    public static final Format FLV;
    public static final Format H264;
    public static final Format IMG;
    public static final Format IVF;
    public static final Format MJPEG;
    public static final Format MKV;
    public static final Format MOV;
    public static final Format MPEG_AUDIO;
    public static final Format MPEG_PS;
    public static final Format MPEG_TS;
    public static final Format RAW;
    public static final Format WAV;
    public static final Format WEBP;
    public static final Format Y4M;
    private static final Map<String, Format> _values;
    private final boolean audio;
    private final String name;
    private final boolean video;

    static {
        Format format = new Format("MOV", true, true);
        MOV = format;
        Format format2 = new Format("MPEG_PS", true, true);
        MPEG_PS = format2;
        Format format3 = new Format("MPEG_TS", true, true);
        MPEG_TS = format3;
        Format format4 = new Format("MKV", true, true);
        MKV = format4;
        Format format5 = new Format("H264", true, false);
        H264 = format5;
        Format format6 = new Format("RAW", true, true);
        RAW = format6;
        Format format7 = new Format("FLV", true, true);
        FLV = format7;
        Format format8 = new Format("AVI", true, true);
        AVI = format8;
        Format format9 = new Format("IMG", true, false);
        IMG = format9;
        Format format10 = new Format("IVF", true, false);
        IVF = format10;
        Format format11 = new Format("MJPEG", true, false);
        MJPEG = format11;
        Format format12 = new Format("Y4M", true, false);
        Y4M = format12;
        Format format13 = new Format("WAV", false, true);
        WAV = format13;
        Format format14 = new Format("WEBP", true, false);
        WEBP = format14;
        Format format15 = new Format("MPEG_AUDIO", false, true);
        MPEG_AUDIO = format15;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        _values = linkedHashMap;
        linkedHashMap.put("MOV", format);
        linkedHashMap.put("MPEG_PS", format2);
        linkedHashMap.put("MPEG_TS", format3);
        linkedHashMap.put("MKV", format4);
        linkedHashMap.put("H264", format5);
        linkedHashMap.put("RAW", format6);
        linkedHashMap.put("FLV", format7);
        linkedHashMap.put("AVI", format8);
        linkedHashMap.put("IMG", format9);
        linkedHashMap.put("IVF", format10);
        linkedHashMap.put("MJPEG", format11);
        linkedHashMap.put("Y4M", format12);
        linkedHashMap.put("WAV", format13);
        linkedHashMap.put("WEBP", format14);
        linkedHashMap.put("MPEG_AUDIO", format15);
    }

    private Format(String str, boolean z, boolean z2) {
        this.name = str;
        this.video = z;
        this.audio = z2;
    }

    public static Format valueOf(String str) {
        return _values.get(str);
    }

    public boolean isAudio() {
        return this.audio;
    }

    public boolean isVideo() {
        return this.video;
    }
}
