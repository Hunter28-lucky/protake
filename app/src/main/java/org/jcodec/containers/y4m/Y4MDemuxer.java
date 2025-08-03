package org.jcodec.containers.y4m;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.Codec;
import org.jcodec.common.Demuxer;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.StringUtils;
import org.jcodec.common.TrackType;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class Y4MDemuxer implements DemuxerTrack, Demuxer {
    private int bufSize;
    private Rational fps;
    private int frameNum;
    private int height;
    private String invalidFormat;
    private SeekableByteChannel is;
    private int totalDuration;
    private int totalFrames;
    private int width;

    public Y4MDemuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        this.is = seekableByteChannel;
        String[] strArrSplitC = StringUtils.splitC(readLine(NIOUtils.fetchFromChannel(seekableByteChannel, 2048)), ' ');
        if (!"YUV4MPEG2".equals(strArrSplitC[0])) {
            this.invalidFormat = "Not yuv4mpeg stream";
            return;
        }
        String strFind = find(strArrSplitC, 'C');
        if (strFind != null && !strFind.startsWith("420")) {
            this.invalidFormat = "Only yuv420p is supported";
            return;
        }
        this.width = Integer.parseInt(find(strArrSplitC, 'W'));
        this.height = Integer.parseInt(find(strArrSplitC, 'H'));
        String strFind2 = find(strArrSplitC, 'F');
        if (strFind2 != null) {
            String[] strArrSplitC2 = StringUtils.splitC(strFind2, ':');
            this.fps = new Rational(Integer.parseInt(strArrSplitC2[0]), Integer.parseInt(strArrSplitC2[1]));
        }
        this.is.setPosition(r5.position());
        int i = this.width * this.height;
        this.bufSize = i;
        this.bufSize = i + (i / 2);
        int size = (int) (this.is.size() / (this.bufSize + 7));
        this.totalFrames = size;
        this.totalDuration = (size * this.fps.getDen()) / this.fps.getNum();
    }

    private static String find(String[] strArr, char c) {
        for (String str : strArr) {
            if (str.charAt(0) == c) {
                return str.substring(1);
            }
        }
        return null;
    }

    private static String readLine(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        while (byteBuffer.hasRemaining() && byteBuffer.get() != 10) {
        }
        if (byteBuffer.hasRemaining()) {
            byteBufferDuplicate.limit(byteBuffer.position() - 1);
        }
        return Platform.stringFromBytes(NIOUtils.toArray(byteBufferDuplicate));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.is.close();
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getAudioTracks() {
        return new ArrayList();
    }

    public Rational getFps() {
        return this.fps;
    }

    @Override // org.jcodec.common.DemuxerTrack
    public DemuxerTrackMeta getMeta() {
        return new DemuxerTrackMeta(TrackType.VIDEO, Codec.RAW, this.totalDuration, null, this.totalFrames, null, VideoCodecMeta.createSimpleVideoCodecMeta(new Size(this.width, this.height), ColorSpace.YUV420), null);
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getTracks() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        return arrayList;
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getVideoTracks() {
        return getTracks();
    }

    @Override // org.jcodec.common.DemuxerTrack
    public Packet nextFrame() throws IOException {
        if (this.invalidFormat != null) {
            throw new RuntimeException("Invalid input: " + this.invalidFormat);
        }
        String line = readLine(NIOUtils.fetchFromChannel(this.is, 2048));
        if (line == null || !line.startsWith("FRAME")) {
            return null;
        }
        SeekableByteChannel seekableByteChannel = this.is;
        seekableByteChannel.setPosition(seekableByteChannel.position() - r0.remaining());
        ByteBuffer byteBufferFetchFromChannel = NIOUtils.fetchFromChannel(this.is, this.bufSize);
        long den = this.frameNum * this.fps.getDen();
        int num = this.fps.getNum();
        long den2 = this.fps.getDen();
        int i = this.frameNum;
        Packet packet = new Packet(byteBufferFetchFromChannel, den, num, den2, i, Packet.FrameType.KEY, null, i);
        this.frameNum++;
        return packet;
    }
}
