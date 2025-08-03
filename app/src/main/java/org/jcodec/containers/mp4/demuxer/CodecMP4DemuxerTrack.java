package org.jcodec.containers.mp4.demuxer;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jcodec.codecs.aac.AACUtils;
import org.jcodec.codecs.aac.ADTSParser;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.mp4.AvcCBox;
import org.jcodec.common.Codec;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.containers.mp4.boxes.VideoSampleEntry;

/* loaded from: classes2.dex */
public class CodecMP4DemuxerTrack extends MP4DemuxerTrack {
    private AvcCBox avcC;
    private ByteBuffer codecPrivate;

    public CodecMP4DemuxerTrack(MovieBox movieBox, TrakBox trakBox, SeekableByteChannel seekableByteChannel) {
        super(movieBox, trakBox, seekableByteChannel);
        if (Codec.codecByFourcc(getFourcc()) == Codec.H264) {
            this.avcC = H264Utils.parseAVCC((VideoSampleEntry) getSampleEntries()[0]);
        }
        this.codecPrivate = MP4DemuxerTrackMeta.getCodecPrivate(this);
    }

    @Override // org.jcodec.containers.mp4.demuxer.AbstractMP4DemuxerTrack
    public ByteBuffer convertPacket(ByteBuffer byteBuffer) {
        if (this.codecPrivate == null) {
            return byteBuffer;
        }
        if (Codec.codecByFourcc(getFourcc()) == Codec.H264) {
            ByteBuffer byteBufferDecodeMOVPacket = H264Utils.decodeMOVPacket(byteBuffer, this.avcC);
            return H264Utils.isByteBufferIDRSlice(byteBufferDecodeMOVPacket) ? NIOUtils.combineBuffers(Arrays.asList(this.codecPrivate, byteBufferDecodeMOVPacket)) : byteBufferDecodeMOVPacket;
        }
        if (Codec.codecByFourcc(getFourcc()) != Codec.AAC) {
            return byteBuffer;
        }
        ADTSParser.Header headerStreamInfoToADTS = AACUtils.streamInfoToADTS(this.codecPrivate, true, 1, byteBuffer.remaining());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(7);
        ADTSParser.write(headerStreamInfoToADTS, byteBufferAllocate);
        return NIOUtils.combineBuffers(Arrays.asList(byteBufferAllocate, byteBuffer));
    }
}
