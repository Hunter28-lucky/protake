package org.jcodec.containers.mps.index;

import java.io.File;
import org.jcodec.codecs.mpeg12.MPEGDecoder;
import org.jcodec.common.Codec;
import org.jcodec.common.MuxerTrack;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.Packet;
import org.jcodec.containers.mp4.Brand;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.muxer.MP4Muxer;
import org.jcodec.containers.mps.index.MPSRandomAccessDemuxer;

/* loaded from: classes2.dex */
public class MTSRandomAccessDemuxerMain {
    private static MPSRandomAccessDemuxer.Stream getVideoStream(MPSRandomAccessDemuxer mPSRandomAccessDemuxer) {
        for (MPSRandomAccessDemuxer.Stream stream : mPSRandomAccessDemuxer.getStreams()) {
            if (stream.getStreamId() >= 224 && stream.getStreamId() <= 239) {
                return stream;
            }
        }
        return null;
    }

    public static void main1(String[] strArr) throws Throwable {
        MTSIndex mTSIndexSerialize;
        MTSIndexer mTSIndexer = new MTSIndexer();
        File file = new File(strArr[0]);
        File file2 = new File(file.getParentFile(), file.getName() + ".idx");
        if (file2.exists()) {
            System.out.println("Reading index from: " + file2.getName());
            mTSIndexSerialize = MTSIndex.parse(NIOUtils.fetchFromFile(file2));
        } else {
            mTSIndexer.index(file, null);
            mTSIndexSerialize = mTSIndexer.serialize();
            NIOUtils.writeTo(mTSIndexSerialize.serialize(), file2);
        }
        MTSRandomAccessDemuxer mTSRandomAccessDemuxer = new MTSRandomAccessDemuxer(NIOUtils.readableChannel(file), mTSIndexSerialize);
        MPSRandomAccessDemuxer.Stream videoStream = getVideoStream(mTSRandomAccessDemuxer.getProgramDemuxer(mTSRandomAccessDemuxer.getGuids()[0]));
        FileChannelWrapper fileChannelWrapperWritableChannel = NIOUtils.writableChannel(new File(strArr[1]));
        MP4Muxer mP4MuxerCreateMP4Muxer = MP4Muxer.createMP4Muxer(fileChannelWrapperWritableChannel, Brand.MOV);
        videoStream.gotoSyncFrame(175L);
        Packet packetNextFrame = videoStream.nextFrame();
        MuxerTrack muxerTrackAddVideoTrack = mP4MuxerCreateMP4Muxer.addVideoTrack(Codec.MPEG2, new MPEGDecoder().getCodecMeta(packetNextFrame.getData()));
        long pts = packetNextFrame.getPts();
        for (int i = 0; packetNextFrame != null && i < 150; i++) {
            muxerTrackAddVideoTrack.addFrame(MP4Packet.createMP4Packet(packetNextFrame.getData(), packetNextFrame.getPts() - pts, packetNextFrame.getTimescale(), packetNextFrame.getDuration(), packetNextFrame.getFrameNo(), packetNextFrame.getFrameType(), packetNextFrame.getTapeTimecode(), 0, packetNextFrame.getPts() - pts, 0));
            packetNextFrame = videoStream.nextFrame();
        }
        mP4MuxerCreateMP4Muxer.finish();
        NIOUtils.closeQuietly(fileChannelWrapperWritableChannel);
    }
}
