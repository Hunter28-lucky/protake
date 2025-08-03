package org.jcodec.containers.mp4;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.logging.Logger;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.containers.mp4.muxer.MP4Muxer;

/* loaded from: classes2.dex */
public class WebOptimizedMP4Muxer extends MP4Muxer {
    private ByteBuffer header;
    private long headerPos;

    public WebOptimizedMP4Muxer(SeekableByteChannel seekableByteChannel, Brand brand, int i) throws IOException {
        super(seekableByteChannel, brand.getFileTypeBox());
        long jPosition = seekableByteChannel.position() - 24;
        this.headerPos = jPosition;
        seekableByteChannel.setPosition(jPosition);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        this.header = byteBufferAllocate;
        seekableByteChannel.write(byteBufferAllocate);
        this.header.clear();
        Header.createHeader("wide", 8L).writeChannel(seekableByteChannel);
        Header.createHeader("mdat", 1L).writeChannel(seekableByteChannel);
        this.mdatOffset = seekableByteChannel.position();
        NIOUtils.writeLong(seekableByteChannel, 0L);
    }

    public static WebOptimizedMP4Muxer withOldHeader(SeekableByteChannel seekableByteChannel, Brand brand, MovieBox movieBox) throws IOException {
        int length;
        int frameCount;
        int size = (int) movieBox.getHeader().getSize();
        TrakBox videoTrack = movieBox.getVideoTrack();
        int length2 = (size - (videoTrack.getStsc().getSampleToChunk().length * 12)) + 12;
        ChunkOffsetsBox stco = videoTrack.getStco();
        if (stco != null) {
            length = length2 - (stco.getChunkOffsets().length << 2);
            frameCount = videoTrack.getFrameCount();
        } else {
            length = length2 - (videoTrack.getCo64().getChunkOffsets().length << 3);
            frameCount = videoTrack.getFrameCount();
        }
        int i = length + (frameCount << 3);
        return new WebOptimizedMP4Muxer(seekableByteChannel, brand, i + (i >> 1));
    }

    @Override // org.jcodec.containers.mp4.muxer.MP4Muxer
    public void storeHeader(MovieBox movieBox) throws IOException {
        long jPosition = this.out.position();
        long j = this.mdatOffset;
        this.out.setPosition(j);
        NIOUtils.writeLong(this.out, (jPosition - j) + 8);
        this.out.setPosition(this.headerPos);
        try {
            movieBox.write(this.header);
            this.header.flip();
            int iCapacity = this.header.capacity() - this.header.limit();
            if (iCapacity < 8) {
                this.header.duplicate().putInt(this.header.capacity());
            }
            this.out.write(this.header);
            if (iCapacity >= 8) {
                Header.createHeader("free", iCapacity).writeChannel(this.out);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            Logger.warn("Could not web-optimize, header is bigger then allocated space.");
            Header.createHeader("free", this.header.remaining()).writeChannel(this.out);
            this.out.setPosition(jPosition);
            MP4Util.writeMovie(this.out, movieBox);
        }
    }
}
