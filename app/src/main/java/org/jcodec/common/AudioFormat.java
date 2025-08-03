package org.jcodec.common;

/* loaded from: classes2.dex */
public class AudioFormat {
    private boolean bigEndian;
    private int channelCount;
    private int sampleRate;
    private int sampleSizeInBits;
    private boolean signed;
    public static AudioFormat STEREO_48K_S16_BE = new AudioFormat(48000, 16, 2, true, true);
    public static AudioFormat STEREO_48K_S16_LE = new AudioFormat(48000, 16, 2, true, false);
    public static AudioFormat STEREO_48K_S24_BE = new AudioFormat(48000, 24, 2, true, true);
    public static AudioFormat STEREO_48K_S24_LE = new AudioFormat(48000, 24, 2, true, false);
    public static AudioFormat MONO_48K_S16_BE = new AudioFormat(48000, 16, 1, true, true);
    public static AudioFormat MONO_48K_S16_LE = new AudioFormat(48000, 16, 1, true, false);
    public static AudioFormat MONO_48K_S24_BE = new AudioFormat(48000, 24, 1, true, true);
    public static AudioFormat MONO_48K_S24_LE = new AudioFormat(48000, 24, 1, true, false);
    public static AudioFormat STEREO_44K_S16_BE = new AudioFormat(44100, 16, 2, true, true);
    public static AudioFormat STEREO_44K_S16_LE = new AudioFormat(44100, 16, 2, true, false);
    public static AudioFormat STEREO_44K_S24_BE = new AudioFormat(44100, 24, 2, true, true);
    public static AudioFormat STEREO_44K_S24_LE = new AudioFormat(44100, 24, 2, true, false);
    public static AudioFormat MONO_44K_S16_BE = new AudioFormat(44100, 16, 1, true, true);
    public static AudioFormat MONO_44K_S16_LE = new AudioFormat(44100, 16, 1, true, false);
    public static AudioFormat MONO_44K_S24_BE = new AudioFormat(44100, 24, 1, true, true);
    public static AudioFormat MONO_44K_S24_LE = new AudioFormat(44100, 24, 1, true, false);

    public AudioFormat(int i, int i2, int i3, boolean z, boolean z2) {
        this.sampleRate = i;
        this.sampleSizeInBits = i2;
        this.channelCount = i3;
        this.signed = z;
        this.bigEndian = z2;
    }

    public static AudioFormat MONO_S16_BE(int i) {
        return new AudioFormat(i, 16, 1, true, true);
    }

    public static AudioFormat MONO_S16_LE(int i) {
        return new AudioFormat(i, 16, 1, true, false);
    }

    public static AudioFormat MONO_S24_BE(int i) {
        return new AudioFormat(i, 24, 1, true, true);
    }

    public static AudioFormat MONO_S24_LE(int i) {
        return new AudioFormat(i, 24, 1, true, false);
    }

    public static AudioFormat NCH_44K_S16_BE(int i) {
        return new AudioFormat(44100, 16, i, true, true);
    }

    public static AudioFormat NCH_44K_S16_LE(int i) {
        return new AudioFormat(44100, 16, i, true, false);
    }

    public static AudioFormat NCH_44K_S24_BE(int i) {
        return new AudioFormat(44100, 24, i, true, true);
    }

    public static AudioFormat NCH_44K_S24_LE(int i) {
        return new AudioFormat(44100, 24, i, true, false);
    }

    public static AudioFormat NCH_48K_S16_BE(int i) {
        return new AudioFormat(48000, 16, i, true, true);
    }

    public static AudioFormat NCH_48K_S16_LE(int i) {
        return new AudioFormat(48000, 16, i, true, false);
    }

    public static AudioFormat NCH_48K_S24_BE(int i) {
        return new AudioFormat(48000, 24, i, true, true);
    }

    public static AudioFormat NCH_48K_S24_LE(int i) {
        return new AudioFormat(48000, 24, i, true, false);
    }

    public static AudioFormat STEREO_S16_BE(int i) {
        return new AudioFormat(i, 16, 2, true, true);
    }

    public static AudioFormat STEREO_S16_LE(int i) {
        return new AudioFormat(i, 16, 2, true, false);
    }

    public static AudioFormat STEREO_S24_BE(int i) {
        return new AudioFormat(i, 24, 2, true, true);
    }

    public static AudioFormat STEREO_S24_LE(int i) {
        return new AudioFormat(i, 24, 2, true, false);
    }

    public static AudioFormat createAudioFormat(AudioFormat audioFormat) {
        return new AudioFormat(audioFormat.sampleRate, audioFormat.sampleSizeInBits, audioFormat.channelCount, audioFormat.signed, audioFormat.bigEndian);
    }

    public static AudioFormat createAudioFormat2(AudioFormat audioFormat, int i) {
        AudioFormat audioFormat2 = new AudioFormat(audioFormat.sampleRate, audioFormat.sampleSizeInBits, audioFormat.channelCount, audioFormat.signed, audioFormat.bigEndian);
        audioFormat2.sampleRate = i;
        return audioFormat2;
    }

    public int bytesToFrames(int i) {
        return i / ((this.channelCount * this.sampleSizeInBits) >> 3);
    }

    public int bytesToSamples(int i) {
        return i / (this.sampleSizeInBits >> 3);
    }

    public int framesToBytes(int i) {
        return i * ((this.channelCount * this.sampleSizeInBits) >> 3);
    }

    public int getChannels() {
        return this.channelCount;
    }

    public int getFrameRate() {
        return this.sampleRate;
    }

    public short getFrameSize() {
        return (short) ((this.sampleSizeInBits >> 3) * this.channelCount);
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public int getSampleSizeInBits() {
        return this.sampleSizeInBits;
    }

    public boolean isBigEndian() {
        return this.bigEndian;
    }

    public boolean isSigned() {
        return this.signed;
    }

    public int samplesToBytes(int i) {
        return i * (this.sampleSizeInBits >> 3);
    }
}
