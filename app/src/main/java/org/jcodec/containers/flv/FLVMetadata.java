package org.jcodec.containers.flv;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class FLVMetadata {
    private double audiochannels;
    private String audiocodecid;
    private double audiodatarate;
    private String audiodevice;
    private double audioinputvolume;
    private double audiosamplerate;
    private double avclevel;
    private double avcprofile;
    private Date creationdate;
    private double duration;
    private double framerate;
    private double height;
    private String presetname;
    private String videocodecid;
    private double videodatarate;
    private String videodevice;
    private double videokeyframe_frequency;
    private double width;

    public FLVMetadata(Map<String, Object> map) throws IllegalAccessException, IllegalArgumentException {
        for (Field field : Platform.getDeclaredFields(getClass())) {
            Object obj = map.get(field.getName());
            try {
                if (obj instanceof Double) {
                    field.setDouble(this, ((Double) obj).doubleValue());
                } else if (obj instanceof Boolean) {
                    field.setBoolean(this, ((Boolean) obj).booleanValue());
                } else {
                    field.set(this, obj);
                }
            } catch (Exception unused) {
            }
        }
    }

    public double getAudiochannels() {
        return this.audiochannels;
    }

    public String getAudiocodecid() {
        return this.audiocodecid;
    }

    public double getAudiodatarate() {
        return this.audiodatarate;
    }

    public String getAudiodevice() {
        return this.audiodevice;
    }

    public double getAudioinputvolume() {
        return this.audioinputvolume;
    }

    public double getAudiosamplerate() {
        return this.audiosamplerate;
    }

    public double getAvclevel() {
        return this.avclevel;
    }

    public double getAvcprofile() {
        return this.avcprofile;
    }

    public Date getCreationdate() {
        return this.creationdate;
    }

    public double getDuration() {
        return this.duration;
    }

    public double getFramerate() {
        return this.framerate;
    }

    public double getHeight() {
        return this.height;
    }

    public String getPresetname() {
        return this.presetname;
    }

    public String getVideocodecid() {
        return this.videocodecid;
    }

    public double getVideodatarate() {
        return this.videodatarate;
    }

    public String getVideodevice() {
        return this.videodevice;
    }

    public double getVideokeyframe_frequency() {
        return this.videokeyframe_frequency;
    }

    public double getWidth() {
        return this.width;
    }
}
