package org.jcodec.api.transcode;

import org.jcodec.common.model.AudioBuffer;
import org.jcodec.common.model.Packet;

/* loaded from: classes2.dex */
public class AudioFrameWithPacket {
    private AudioBuffer audio;
    private Packet packet;

    public AudioFrameWithPacket(AudioBuffer audioBuffer, Packet packet) {
        this.audio = audioBuffer;
        this.packet = packet;
    }

    public AudioBuffer getAudio() {
        return this.audio;
    }

    public Packet getPacket() {
        return this.packet;
    }
}
