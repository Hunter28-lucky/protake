package org.jcodec.common;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.common.model.Label;

/* loaded from: classes2.dex */
public class AudioCodecMeta extends CodecMeta {
    private int bytesPerFrame;
    private int bytesPerPacket;
    private int channelCount;
    private ByteOrder endian;
    private Label[] labels;
    private boolean pcm;
    private int sampleRate;
    private int sampleSize;
    private int samplesPerPacket;

    public AudioCodecMeta(String str, ByteBuffer byteBuffer) {
        super(str, byteBuffer);
    }

    public static AudioCodecMeta createAudioCodecMeta(String str, int i, int i2, int i3, ByteOrder byteOrder, boolean z, Label[] labelArr, ByteBuffer byteBuffer) {
        AudioCodecMeta audioCodecMeta = new AudioCodecMeta(str, byteBuffer);
        audioCodecMeta.sampleSize = i;
        audioCodecMeta.channelCount = i2;
        audioCodecMeta.sampleRate = i3;
        audioCodecMeta.endian = byteOrder;
        audioCodecMeta.pcm = z;
        audioCodecMeta.labels = labelArr;
        return audioCodecMeta;
    }

    public static AudioCodecMeta createAudioCodecMeta2(String str, int i, int i2, int i3, ByteOrder byteOrder, boolean z, Label[] labelArr, int i4, int i5, int i6, ByteBuffer byteBuffer) {
        AudioCodecMeta audioCodecMeta = new AudioCodecMeta(str, byteBuffer);
        audioCodecMeta.sampleSize = i;
        audioCodecMeta.channelCount = i2;
        audioCodecMeta.sampleRate = i3;
        audioCodecMeta.endian = byteOrder;
        audioCodecMeta.samplesPerPacket = i4;
        audioCodecMeta.bytesPerPacket = i5;
        audioCodecMeta.bytesPerFrame = i6;
        audioCodecMeta.pcm = z;
        audioCodecMeta.labels = labelArr;
        return audioCodecMeta;
    }

    public static AudioCodecMeta createAudioCodecMeta3(String str, ByteBuffer byteBuffer, AudioFormat audioFormat, boolean z, Label[] labelArr) {
        AudioCodecMeta audioCodecMeta = new AudioCodecMeta(str, byteBuffer);
        audioCodecMeta.sampleSize = audioFormat.getSampleSizeInBits() >> 3;
        audioCodecMeta.channelCount = audioFormat.getChannels();
        audioCodecMeta.sampleRate = audioFormat.getSampleRate();
        audioCodecMeta.endian = audioFormat.isBigEndian() ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
        audioCodecMeta.pcm = z;
        audioCodecMeta.labels = labelArr;
        return audioCodecMeta;
    }

    public static AudioCodecMeta fromAudioFormat(AudioFormat audioFormat) {
        AudioCodecMeta audioCodecMeta = new AudioCodecMeta(null, null);
        audioCodecMeta.sampleSize = audioFormat.getSampleSizeInBits() >> 3;
        audioCodecMeta.channelCount = audioFormat.getChannels();
        audioCodecMeta.sampleRate = audioFormat.getSampleRate();
        audioCodecMeta.endian = audioFormat.isBigEndian() ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
        audioCodecMeta.pcm = false;
        return audioCodecMeta;
    }

    public int getBytesPerFrame() {
        return this.bytesPerFrame;
    }

    public int getBytesPerPacket() {
        return this.bytesPerPacket;
    }

    public int getChannelCount() {
        return this.channelCount;
    }

    public Label[] getChannelLabels() {
        return this.labels;
    }

    public ByteOrder getEndian() {
        return this.endian;
    }

    public AudioFormat getFormat() {
        return new AudioFormat(this.sampleRate, this.sampleSize << 3, this.channelCount, true, this.endian == ByteOrder.BIG_ENDIAN);
    }

    public int getFrameSize() {
        return this.sampleSize * this.channelCount;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public int getSampleSize() {
        return this.sampleSize;
    }

    public int getSamplesPerPacket() {
        return this.samplesPerPacket;
    }

    public boolean isPCM() {
        return this.pcm;
    }
}
