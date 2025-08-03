package org.jcodec.common;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class DemuxerTrackMeta {
    private AudioCodecMeta audioCodecMeta;
    private Codec codec;
    private ByteBuffer codecPrivate;
    private int index;
    private Orientation orientation = Orientation.D_0;
    private int[] seekFrames;
    private double totalDuration;
    private int totalFrames;
    private TrackType type;
    private VideoCodecMeta videoCodecMeta;

    public enum Orientation {
        D_0,
        D_90,
        D_180,
        D_270
    }

    public DemuxerTrackMeta(TrackType trackType, Codec codec, double d, int[] iArr, int i, ByteBuffer byteBuffer, VideoCodecMeta videoCodecMeta, AudioCodecMeta audioCodecMeta) {
        this.type = trackType;
        this.codec = codec;
        this.totalDuration = d;
        this.seekFrames = iArr;
        this.totalFrames = i;
        this.codecPrivate = byteBuffer;
        this.videoCodecMeta = videoCodecMeta;
        this.audioCodecMeta = audioCodecMeta;
    }

    public AudioCodecMeta getAudioCodecMeta() {
        return this.audioCodecMeta;
    }

    public Codec getCodec() {
        return this.codec;
    }

    public ByteBuffer getCodecPrivate() {
        return this.codecPrivate;
    }

    public int getIndex() {
        return this.index;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public int[] getSeekFrames() {
        return this.seekFrames;
    }

    public double getTotalDuration() {
        return this.totalDuration;
    }

    public int getTotalFrames() {
        return this.totalFrames;
    }

    public TrackType getType() {
        return this.type;
    }

    public VideoCodecMeta getVideoCodecMeta() {
        return this.videoCodecMeta;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
