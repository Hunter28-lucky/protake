package org.jcodec.containers.mp4.muxer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.Codec;
import org.jcodec.common.Muxer;
import org.jcodec.common.MuxerTrack;
import org.jcodec.common.Preconditions;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mp4.Brand;
import org.jcodec.containers.mp4.MP4TrackType;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.FileTypeBox;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieHeaderBox;

/* loaded from: classes2.dex */
public class MP4Muxer implements Muxer {
    public long mdatOffset;
    public SeekableByteChannel out;
    private int nextTrackId = 1;
    private List<AbstractMP4MuxerTrack> tracks = new ArrayList();

    public MP4Muxer(SeekableByteChannel seekableByteChannel, FileTypeBox fileTypeBox) throws IOException {
        this.out = seekableByteChannel;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1024);
        fileTypeBox.write(byteBufferAllocate);
        Header.createHeader("wide", 8L).write(byteBufferAllocate);
        Header.createHeader("mdat", 1L).write(byteBufferAllocate);
        this.mdatOffset = byteBufferAllocate.position();
        byteBufferAllocate.putLong(0L);
        byteBufferAllocate.flip();
        seekableByteChannel.write(byteBufferAllocate);
    }

    public static MP4Muxer createMP4Muxer(SeekableByteChannel seekableByteChannel, Brand brand) throws IOException {
        return new MP4Muxer(seekableByteChannel, brand.getFileTypeBox());
    }

    public static MP4Muxer createMP4MuxerToChannel(SeekableByteChannel seekableByteChannel) throws IOException {
        return new MP4Muxer(seekableByteChannel, Brand.MP4.getFileTypeBox());
    }

    private CodecMP4MuxerTrack doAddTrack(MP4TrackType mP4TrackType, Codec codec) {
        int i = this.nextTrackId;
        this.nextTrackId = i + 1;
        return (CodecMP4MuxerTrack) addTrack(new CodecMP4MuxerTrack(i, mP4TrackType, codec));
    }

    private MovieHeaderBox movieHeader() {
        int timescale = this.tracks.get(0).getTimescale();
        long trackTotalDuration = this.tracks.get(0).getTrackTotalDuration();
        AbstractMP4MuxerTrack videoTrack = getVideoTrack();
        if (videoTrack != null) {
            timescale = videoTrack.getTimescale();
            trackTotalDuration = videoTrack.getTrackTotalDuration();
        }
        return MovieHeaderBox.createMovieHeaderBox(timescale, trackTotalDuration, 1.0f, 1.0f, new Date().getTime(), new Date().getTime(), new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824}, this.nextTrackId);
    }

    @Override // org.jcodec.common.Muxer
    public MuxerTrack addAudioTrack(Codec codec, AudioCodecMeta audioCodecMeta) {
        AudioFormat format = audioCodecMeta.getFormat();
        return codec == Codec.PCM ? addPCMAudioTrack(format) : addCompressedAudioTrack(codec, format);
    }

    public CodecMP4MuxerTrack addCompressedAudioTrack(Codec codec, AudioFormat audioFormat) {
        CodecMP4MuxerTrack codecMP4MuxerTrackDoAddTrack = doAddTrack(MP4TrackType.SOUND, codec);
        codecMP4MuxerTrackDoAddTrack.addAudioSampleEntry(audioFormat);
        return codecMP4MuxerTrackDoAddTrack;
    }

    public PCMMP4MuxerTrack addPCMAudioTrack(AudioFormat audioFormat) {
        int i = this.nextTrackId;
        this.nextTrackId = i + 1;
        return (PCMMP4MuxerTrack) addTrack(new PCMMP4MuxerTrack(i, audioFormat));
    }

    public TimecodeMP4MuxerTrack addTimecodeTrack() {
        int i = this.nextTrackId;
        this.nextTrackId = i + 1;
        return (TimecodeMP4MuxerTrack) addTrack(new TimecodeMP4MuxerTrack(i));
    }

    public <T extends AbstractMP4MuxerTrack> T addTrack(T t) {
        Preconditions.checkNotNull(t, "track can not be null");
        int trackId = t.getTrackId();
        Preconditions.checkArgument(trackId <= this.nextTrackId);
        Preconditions.checkArgument(!hasTrackId(trackId), "track with id %s already exists", trackId);
        this.tracks.add(t.setOut(this.out));
        this.nextTrackId = Math.max(trackId + 1, this.nextTrackId);
        return t;
    }

    public CodecMP4MuxerTrack addTrackWithId(MP4TrackType mP4TrackType, Codec codec, int i) {
        Preconditions.checkArgument(!hasTrackId(i), "track with id %s already exists", i);
        CodecMP4MuxerTrack codecMP4MuxerTrack = new CodecMP4MuxerTrack(i, mP4TrackType, codec);
        this.tracks.add(codecMP4MuxerTrack);
        this.nextTrackId = Math.max(this.nextTrackId, i + 1);
        return codecMP4MuxerTrack;
    }

    @Override // org.jcodec.common.Muxer
    public MuxerTrack addVideoTrack(Codec codec, VideoCodecMeta videoCodecMeta) {
        CodecMP4MuxerTrack codecMP4MuxerTrackDoAddTrack = doAddTrack(MP4TrackType.VIDEO, codec);
        Preconditions.checkArgument(videoCodecMeta != null || codec == Codec.H264, "VideoCodecMeta is required upfront for all codecs but H.264");
        codecMP4MuxerTrackDoAddTrack.addVideoSampleEntry(videoCodecMeta);
        return codecMP4MuxerTrackDoAddTrack;
    }

    public MovieBox finalizeHeader() throws IOException {
        MovieBox movieBoxCreateMovieBox = MovieBox.createMovieBox();
        MovieHeaderBox movieHeaderBoxMovieHeader = movieHeader();
        movieBoxCreateMovieBox.addFirst(movieHeaderBoxMovieHeader);
        Iterator<AbstractMP4MuxerTrack> it = this.tracks.iterator();
        while (it.hasNext()) {
            Box boxFinish = it.next().finish(movieHeaderBoxMovieHeader);
            if (boxFinish != null) {
                movieBoxCreateMovieBox.add(boxFinish);
            }
        }
        return movieBoxCreateMovieBox;
    }

    @Override // org.jcodec.common.Muxer
    public void finish() throws IOException {
        Preconditions.checkState(this.tracks.size() != 0, "Can not save header with 0 tracks.");
        storeHeader(finalizeHeader());
    }

    public List<AbstractMP4MuxerTrack> getAudioTracks() {
        ArrayList arrayList = new ArrayList();
        for (AbstractMP4MuxerTrack abstractMP4MuxerTrack : this.tracks) {
            if (abstractMP4MuxerTrack.isAudio()) {
                arrayList.add(abstractMP4MuxerTrack);
            }
        }
        return arrayList;
    }

    public int getNextTrackId() {
        return this.nextTrackId;
    }

    public AbstractMP4MuxerTrack getTimecodeTrack() {
        for (AbstractMP4MuxerTrack abstractMP4MuxerTrack : this.tracks) {
            if (abstractMP4MuxerTrack.isTimecode()) {
                return abstractMP4MuxerTrack;
            }
        }
        return null;
    }

    public List<AbstractMP4MuxerTrack> getTracks() {
        return Collections.unmodifiableList(this.tracks);
    }

    public AbstractMP4MuxerTrack getVideoTrack() {
        for (AbstractMP4MuxerTrack abstractMP4MuxerTrack : this.tracks) {
            if (abstractMP4MuxerTrack.isVideo()) {
                return abstractMP4MuxerTrack;
            }
        }
        return null;
    }

    public boolean hasTrackId(int i) {
        Iterator<AbstractMP4MuxerTrack> it = this.tracks.iterator();
        while (it.hasNext()) {
            if (it.next().getTrackId() == i) {
                return true;
            }
        }
        return false;
    }

    public void storeHeader(MovieBox movieBox) throws IOException {
        long jPosition = (this.out.position() - this.mdatOffset) + 8;
        MP4Util.writeMovie(this.out, movieBox);
        this.out.setPosition(this.mdatOffset);
        NIOUtils.writeLong(this.out, jPosition);
    }
}
