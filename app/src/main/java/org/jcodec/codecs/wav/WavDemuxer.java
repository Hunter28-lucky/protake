package org.jcodec.codecs.wav;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.Codec;
import org.jcodec.common.Demuxer;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.TrackType;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Packet;

/* loaded from: classes2.dex */
public class WavDemuxer implements Demuxer, DemuxerTrack {
    private static final int FRAMES_PER_PKT = 1024;
    private SeekableByteChannel ch;
    private long dataSize;
    private int frameNo;
    private short frameSize;
    private WavHeader header;
    private long pts;

    public WavDemuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        this.ch = seekableByteChannel;
        this.header = WavHeader.readChannel(seekableByteChannel);
        this.dataSize = seekableByteChannel.size() - seekableByteChannel.position();
        this.frameSize = this.header.getFormat().getFrameSize();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ch.close();
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getAudioTracks() {
        return getTracks();
    }

    @Override // org.jcodec.common.DemuxerTrack
    public DemuxerTrackMeta getMeta() {
        AudioCodecMeta audioCodecMetaFromAudioFormat = AudioCodecMeta.fromAudioFormat(this.header.getFormat());
        long frameSize = this.dataSize / r0.getFrameSize();
        return new DemuxerTrackMeta(TrackType.AUDIO, Codec.PCM, frameSize / r0.getFrameRate(), null, (int) frameSize, null, null, audioCodecMetaFromAudioFormat);
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getTracks() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        return arrayList;
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getVideoTracks() {
        return new ArrayList();
    }

    @Override // org.jcodec.common.DemuxerTrack
    public Packet nextFrame() throws IOException {
        ByteBuffer byteBufferFetchFromChannel = NIOUtils.fetchFromChannel(this.ch, this.frameSize * 1024);
        if (!byteBufferFetchFromChannel.hasRemaining()) {
            return null;
        }
        long j = this.pts;
        this.pts += byteBufferFetchFromChannel.remaining() / this.frameSize;
        int frameRate = this.header.getFormat().getFrameRate();
        long jRemaining = byteBufferFetchFromChannel.remaining() / this.frameSize;
        int i = this.frameNo;
        this.frameNo = i + 1;
        return Packet.createPacket(byteBufferFetchFromChannel, j, frameRate, jRemaining, i, Packet.FrameType.KEY, null);
    }
}
