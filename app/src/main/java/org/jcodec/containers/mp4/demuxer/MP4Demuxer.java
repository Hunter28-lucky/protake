package org.jcodec.containers.mp4.demuxer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.common.Demuxer;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.Fourcc;
import org.jcodec.common.UsedViaReflection;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mp4.MP4TrackType;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.HandlerBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class MP4Demuxer implements Demuxer {
    public SeekableByteChannel input;
    public MovieBox movie;
    private TimecodeMP4DemuxerTrack timecodeTrack;
    private List<AbstractMP4DemuxerTrack> tracks = new LinkedList();

    public MP4Demuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        this.input = seekableByteChannel;
        findMovieBox(seekableByteChannel);
    }

    public static MP4Demuxer createMP4Demuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        return new MP4Demuxer(seekableByteChannel);
    }

    public static MP4Demuxer createRawMP4Demuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        return new MP4Demuxer(seekableByteChannel) { // from class: org.jcodec.containers.mp4.demuxer.MP4Demuxer.1
            @Override // org.jcodec.containers.mp4.demuxer.MP4Demuxer
            public AbstractMP4DemuxerTrack newTrack(TrakBox trakBox) {
                return new MP4DemuxerTrack(this.movie, trakBox, this.input);
            }
        };
    }

    private void findMovieBox(SeekableByteChannel seekableByteChannel) throws IOException {
        MP4Util.Movie fullMovieChannel = MP4Util.parseFullMovieChannel(seekableByteChannel);
        if (fullMovieChannel == null || fullMovieChannel.getMoov() == null) {
            throw new IOException("Could not find movie meta information box");
        }
        MovieBox moov = fullMovieChannel.getMoov();
        this.movie = moov;
        processHeader(moov);
    }

    private AbstractMP4DemuxerTrack fromTrakBox(TrakBox trakBox) {
        return ((SampleSizesBox) NodeBox.findFirstPath(trakBox, SampleSizesBox.class, Box.path("mdia.minf.stbl.stsz"))).getDefaultSize() == 0 ? newTrack(trakBox) : new PCMMP4DemuxerTrack(this.movie, trakBox, this.input);
    }

    public static MP4TrackType getTrackType(TrakBox trakBox) {
        return MP4TrackType.fromHandler(((HandlerBox) NodeBox.findFirstPath(trakBox, HandlerBox.class, Box.path("mdia.hdlr"))).getComponentSubType());
    }

    @UsedViaReflection
    public static int probe(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 8;
            if (byteBufferDuplicate.remaining() < 8) {
                break;
            }
            long jUnsignedInt = Platform.unsignedInt(byteBufferDuplicate.getInt());
            int i4 = byteBufferDuplicate.getInt();
            if (jUnsignedInt != 1) {
                if (jUnsignedInt >= 8) {
                    break;
                    break;
                }
                break;
            }
            jUnsignedInt = byteBufferDuplicate.getLong();
            i3 = 16;
            if ((i4 == Fourcc.ftyp && jUnsignedInt < 64) || ((i4 == Fourcc.moov && jUnsignedInt < 104857600) || i4 == Fourcc.free || i4 == Fourcc.mdat || i4 == Fourcc.wide)) {
                i++;
            }
            i2++;
            if (jUnsignedInt >= 2147483647L) {
                break;
            }
            NIOUtils.skip(byteBufferDuplicate, (int) (jUnsignedInt - i3));
        }
        if (i2 == 0) {
            return 0;
        }
        return (i * 100) / i2;
    }

    private void processHeader(NodeBox nodeBox) throws IOException {
        TrakBox trakBox = null;
        for (TrakBox trakBox2 : (TrakBox[]) NodeBox.findAll(nodeBox, TrakBox.class, "trak")) {
            SampleEntry sampleEntry = (SampleEntry) NodeBox.findFirstPath(trakBox2, SampleEntry.class, new String[]{"mdia", "minf", "stbl", "stsd", null});
            if (sampleEntry == null || !"tmcd".equals(sampleEntry.getFourcc())) {
                this.tracks.add(fromTrakBox(trakBox2));
            } else {
                trakBox = trakBox2;
            }
        }
        if (trakBox == null || getVideoTrack() == null) {
            return;
        }
        this.timecodeTrack = new TimecodeMP4DemuxerTrack(this.movie, trakBox, this.input);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.input.close();
    }

    @Override // org.jcodec.common.Demuxer
    public List<DemuxerTrack> getAudioTracks() {
        ArrayList arrayList = new ArrayList();
        for (AbstractMP4DemuxerTrack abstractMP4DemuxerTrack : this.tracks) {
            if (abstractMP4DemuxerTrack.box.isAudio()) {
                arrayList.add(abstractMP4DemuxerTrack);
            }
        }
        return arrayList;
    }

    public MovieBox getMovie() {
        return this.movie;
    }

    public TimecodeMP4DemuxerTrack getTimecodeTrack() {
        return this.timecodeTrack;
    }

    public AbstractMP4DemuxerTrack getTrack(int i) {
        for (AbstractMP4DemuxerTrack abstractMP4DemuxerTrack : this.tracks) {
            if (abstractMP4DemuxerTrack.getNo() == i) {
                return abstractMP4DemuxerTrack;
            }
        }
        return null;
    }

    @Override // org.jcodec.common.Demuxer
    public List<AbstractMP4DemuxerTrack> getTracks() {
        return new ArrayList(this.tracks);
    }

    public DemuxerTrack getVideoTrack() {
        for (AbstractMP4DemuxerTrack abstractMP4DemuxerTrack : this.tracks) {
            if (abstractMP4DemuxerTrack.box.isVideo()) {
                return abstractMP4DemuxerTrack;
            }
        }
        return null;
    }

    @Override // org.jcodec.common.Demuxer
    public List<DemuxerTrack> getVideoTracks() {
        ArrayList arrayList = new ArrayList();
        for (AbstractMP4DemuxerTrack abstractMP4DemuxerTrack : this.tracks) {
            if (abstractMP4DemuxerTrack.box.isVideo()) {
                arrayList.add(abstractMP4DemuxerTrack);
            }
        }
        return arrayList;
    }

    public AbstractMP4DemuxerTrack newTrack(TrakBox trakBox) {
        return new CodecMP4DemuxerTrack(this.movie, trakBox, this.input);
    }
}
