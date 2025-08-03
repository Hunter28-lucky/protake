package org.jcodec.common;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Codec {
    public static final Codec AAC;
    public static final Codec AC3;
    public static final Codec ADPCM;
    public static final Codec ALAW;
    public static final Codec DTS;
    public static final Codec DV;
    public static final Codec FLASH_SCREEN_V2;
    public static final Codec FLASH_SCREEN_VIDEO;
    public static final Codec G711;
    public static final Codec H264;
    public static final Codec J2K;
    public static final Codec JPEG;
    public static final Codec MP1;
    public static final Codec MP2;
    public static final Codec MP3;
    public static final Codec MPEG2;
    public static final Codec MPEG4;
    public static final Codec NELLYMOSER;
    public static final Codec PCM;
    public static final Codec PCM_DVD;
    public static final Codec PNG;
    public static final Codec PRORES;
    public static final Codec RAW;
    public static final Codec SORENSON;
    public static final Codec SPEEX;
    public static final Codec TIMECODE;
    public static final Codec TRUEHD;
    public static final Codec V210;
    public static final Codec VC1;
    public static final Codec VC3;
    public static final Codec VORBIS;
    public static final Codec VP6;
    public static final Codec VP8;
    public static final Codec VP9;
    private static final Map<String, Codec> _values;
    private final String _name;
    private final TrackType type;

    static {
        TrackType trackType = TrackType.VIDEO;
        Codec codec = new Codec("H264", trackType);
        H264 = codec;
        Codec codec2 = new Codec("MPEG2", trackType);
        MPEG2 = codec2;
        Codec codec3 = new Codec("MPEG4", trackType);
        MPEG4 = codec3;
        Codec codec4 = new Codec("PRORES", trackType);
        PRORES = codec4;
        Codec codec5 = new Codec("DV", trackType);
        DV = codec5;
        Codec codec6 = new Codec("VC1", trackType);
        VC1 = codec6;
        Codec codec7 = new Codec("VC3", trackType);
        VC3 = codec7;
        Codec codec8 = new Codec("V210", trackType);
        V210 = codec8;
        Codec codec9 = new Codec("SORENSON", trackType);
        SORENSON = codec9;
        Codec codec10 = new Codec("FLASH_SCREEN_VIDEO", trackType);
        FLASH_SCREEN_VIDEO = codec10;
        Codec codec11 = new Codec("FLASH_SCREEN_V2", trackType);
        FLASH_SCREEN_V2 = codec11;
        Codec codec12 = new Codec("PNG", trackType);
        PNG = codec12;
        Codec codec13 = new Codec("JPEG", trackType);
        JPEG = codec13;
        Codec codec14 = new Codec("J2K", trackType);
        J2K = codec14;
        Codec codec15 = new Codec("VP6", trackType);
        VP6 = codec15;
        Codec codec16 = new Codec("VP8", trackType);
        VP8 = codec16;
        Codec codec17 = new Codec("VP9", trackType);
        VP9 = codec17;
        Codec codec18 = new Codec("VORBIS", trackType);
        VORBIS = codec18;
        TrackType trackType2 = TrackType.AUDIO;
        Codec codec19 = new Codec("AAC", trackType2);
        AAC = codec19;
        Codec codec20 = new Codec("MP3", trackType2);
        MP3 = codec20;
        Codec codec21 = new Codec("MP2", trackType2);
        MP2 = codec21;
        Codec codec22 = new Codec("MP1", trackType2);
        MP1 = codec22;
        Codec codec23 = new Codec("AC3", trackType2);
        AC3 = codec23;
        Codec codec24 = new Codec("DTS", trackType2);
        DTS = codec24;
        Codec codec25 = new Codec("TRUEHD", trackType2);
        TRUEHD = codec25;
        Codec codec26 = new Codec("PCM_DVD", trackType2);
        PCM_DVD = codec26;
        Codec codec27 = new Codec("PCM", trackType2);
        PCM = codec27;
        Codec codec28 = new Codec("ADPCM", trackType2);
        ADPCM = codec28;
        Codec codec29 = new Codec("ALAW", trackType2);
        ALAW = codec29;
        Codec codec30 = new Codec("NELLYMOSER", trackType2);
        NELLYMOSER = codec30;
        Codec codec31 = new Codec("G711", trackType2);
        G711 = codec31;
        Codec codec32 = new Codec("SPEEX", trackType2);
        SPEEX = codec32;
        Codec codec33 = new Codec("RAW", null);
        RAW = codec33;
        Codec codec34 = new Codec("TIMECODE", TrackType.OTHER);
        TIMECODE = codec34;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        _values = linkedHashMap;
        linkedHashMap.put("H264", codec);
        linkedHashMap.put("MPEG2", codec2);
        linkedHashMap.put("MPEG4", codec3);
        linkedHashMap.put("PRORES", codec4);
        linkedHashMap.put("DV", codec5);
        linkedHashMap.put("VC1", codec6);
        linkedHashMap.put("VC3", codec7);
        linkedHashMap.put("V210", codec8);
        linkedHashMap.put("SORENSON", codec9);
        linkedHashMap.put("FLASH_SCREEN_VIDEO", codec10);
        linkedHashMap.put("FLASH_SCREEN_V2", codec11);
        linkedHashMap.put("PNG", codec12);
        linkedHashMap.put("JPEG", codec13);
        linkedHashMap.put("J2K", codec14);
        linkedHashMap.put("VP6", codec15);
        linkedHashMap.put("VP8", codec16);
        linkedHashMap.put("VP9", codec17);
        linkedHashMap.put("VORBIS", codec18);
        linkedHashMap.put("AAC", codec19);
        linkedHashMap.put("MP3", codec20);
        linkedHashMap.put("MP2", codec21);
        linkedHashMap.put("MP1", codec22);
        linkedHashMap.put("AC3", codec23);
        linkedHashMap.put("DTS", codec24);
        linkedHashMap.put("TRUEHD", codec25);
        linkedHashMap.put("PCM_DVD", codec26);
        linkedHashMap.put("PCM", codec27);
        linkedHashMap.put("ADPCM", codec28);
        linkedHashMap.put("ALAW", codec29);
        linkedHashMap.put("NELLYMOSER", codec30);
        linkedHashMap.put("G711", codec31);
        linkedHashMap.put("SPEEX", codec32);
        linkedHashMap.put("RAW", codec33);
        linkedHashMap.put("TIMECODE", codec34);
    }

    public Codec(String str, TrackType trackType) {
        this._name = str;
        this.type = trackType;
    }

    public static Codec codecByFourcc(String str) {
        if (str.equals("avc1")) {
            return H264;
        }
        if (str.equals("m1v1") || str.equals("m2v1")) {
            return MPEG2;
        }
        if (str.equals("apco") || str.equals("apcs") || str.equals("apcn") || str.equals("apch") || str.equals("ap4h")) {
            return PRORES;
        }
        if (str.equals("mp4a")) {
            return AAC;
        }
        if (str.equals("jpeg")) {
            return JPEG;
        }
        return null;
    }

    public static Codec valueOf(String str) {
        return _values.get(str);
    }

    public TrackType getType() {
        return this.type;
    }

    public String name() {
        return this._name;
    }

    public String toString() {
        return this._name;
    }
}
