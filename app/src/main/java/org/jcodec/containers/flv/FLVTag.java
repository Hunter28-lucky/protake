package org.jcodec.containers.flv;

import java.nio.ByteBuffer;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.Codec;

/* loaded from: classes2.dex */
public class FLVTag {
    private ByteBuffer data;
    private long frameNo;
    private boolean keyFrame;
    private long position;
    private int prevPacketSize;
    private int pts;
    private int streamId;
    private TagHeader tagHeader;
    private Type type;

    public static class AacAudioTagHeader extends AudioTagHeader {
        private int packetType;

        public AacAudioTagHeader(Codec codec, AudioFormat audioFormat, int i) {
            super(codec, audioFormat);
            this.packetType = i;
        }

        public int getPacketType() {
            return this.packetType;
        }
    }

    public static class AudioTagHeader extends TagHeader {
        private AudioFormat audioFormat;

        public AudioTagHeader(Codec codec, AudioFormat audioFormat) {
            super(codec);
            this.audioFormat = audioFormat;
        }

        public AudioFormat getAudioFormat() {
            return this.audioFormat;
        }
    }

    public static class AvcVideoTagHeader extends VideoTagHeader {
        private byte avcPacketType;
        private int compOffset;

        public AvcVideoTagHeader(Codec codec, int i, byte b, int i2) {
            super(codec, i);
            this.avcPacketType = b;
            this.compOffset = i2;
        }

        public byte getAvcPacketType() {
            return this.avcPacketType;
        }

        public int getCompOffset() {
            return this.compOffset;
        }
    }

    public static class TagHeader {
        private Codec codec;

        public TagHeader(Codec codec) {
            this.codec = codec;
        }

        public Codec getCodec() {
            return this.codec;
        }
    }

    public enum Type {
        VIDEO,
        AUDIO,
        SCRIPT
    }

    public static class VideoTagHeader extends TagHeader {
        private int frameType;

        public VideoTagHeader(Codec codec, int i) {
            super(codec);
            this.frameType = i;
        }

        public int getFrameType() {
            return this.frameType;
        }
    }

    public FLVTag(Type type, long j, TagHeader tagHeader, int i, ByteBuffer byteBuffer, boolean z, long j2, int i2, int i3) {
        this.type = type;
        this.position = j;
        this.tagHeader = tagHeader;
        this.pts = i;
        this.data = byteBuffer;
        this.keyFrame = z;
        this.frameNo = j2;
        this.streamId = i2;
        this.prevPacketSize = i3;
    }

    public ByteBuffer getData() {
        return this.data;
    }

    public long getFrameNo() {
        return this.frameNo;
    }

    public long getPosition() {
        return this.position;
    }

    public int getPrevPacketSize() {
        return this.prevPacketSize;
    }

    public int getPts() {
        return this.pts;
    }

    public double getPtsD() {
        return this.pts / 1000.0d;
    }

    public int getStreamId() {
        return this.streamId;
    }

    public TagHeader getTagHeader() {
        return this.tagHeader;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isKeyFrame() {
        return this.keyFrame;
    }

    public void setPrevPacketSize(int i) {
        this.prevPacketSize = i;
    }

    public void setPts(int i) {
        this.pts = i;
    }

    public void setStreamId(int i) {
        this.streamId = i;
    }
}
