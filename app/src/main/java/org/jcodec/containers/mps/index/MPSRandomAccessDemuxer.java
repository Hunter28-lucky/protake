package org.jcodec.containers.mps.index;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jcodec.api.NotSupportedException;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.SeekableDemuxerTrack;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Packet;
import org.jcodec.containers.mps.MPSUtils;
import org.jcodec.containers.mps.index.MPSIndex;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class MPSRandomAccessDemuxer {
    private int[] pesStreamIds;
    private long[] pesTokens;
    private Stream[] streams;

    public static class Stream extends MPSIndex.MPSStreamIndex implements SeekableDemuxerTrack {
        private static final int MPEG_TIMESCALE = 90000;
        private int _seekToFrame;
        private int curFrame;
        private int curPesIdx;
        private MPSRandomAccessDemuxer demuxer;
        private long[] foffs;
        private ByteBuffer pesBuf;
        public SeekableByteChannel source;

        public Stream(MPSRandomAccessDemuxer mPSRandomAccessDemuxer, MPSIndex.MPSStreamIndex mPSStreamIndex, SeekableByteChannel seekableByteChannel) throws IOException {
            super(mPSStreamIndex.streamId, mPSStreamIndex.fsizes, mPSStreamIndex.fpts, mPSStreamIndex.fdur, mPSStreamIndex.sync);
            this._seekToFrame = -1;
            this.demuxer = mPSRandomAccessDemuxer;
            this.source = seekableByteChannel;
            this.foffs = new long[this.fsizes.length];
            long j = 0;
            int i = 0;
            while (true) {
                if (i >= this.fsizes.length) {
                    Arrays.sort(Platform.copyOfInt(mPSStreamIndex.getFpts(), 100));
                    this._seekToFrame = 0;
                    seekToFrame();
                    return;
                } else {
                    this.foffs[i] = j;
                    j += r2[i];
                    i++;
                }
            }
        }

        private Packet _nextFrame(ByteBuffer byteBuffer) throws IOException {
            seekToFrame();
            int i = this.curFrame;
            int[] iArr = this.fsizes;
            if (i >= iArr.length) {
                return null;
            }
            int i2 = iArr[i];
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.limit(byteBufferDuplicate.position() + i2);
            while (byteBufferDuplicate.hasRemaining()) {
                if (this.pesBuf.hasRemaining()) {
                    ByteBuffer byteBuffer2 = this.pesBuf;
                    byteBufferDuplicate.put(NIOUtils.read(byteBuffer2, Math.min(byteBuffer2.remaining(), byteBufferDuplicate.remaining())));
                } else {
                    this.curPesIdx++;
                    long jPesLen = 0;
                    while (this.demuxer.pesStreamIds[this.curPesIdx] != this.streamId) {
                        jPesLen += MPSIndex.pesLen(this.demuxer.pesTokens[this.curPesIdx]) + MPSIndex.leadingSize(this.demuxer.pesTokens[this.curPesIdx]);
                        this.curPesIdx++;
                    }
                    skip(jPesLen + MPSIndex.leadingSize(this.demuxer.pesTokens[this.curPesIdx]));
                    ByteBuffer byteBufferFetch = fetch(MPSIndex.pesLen(this.demuxer.pesTokens[this.curPesIdx]));
                    this.pesBuf = byteBufferFetch;
                    MPSUtils.readPESHeader(byteBufferFetch, 0L);
                }
            }
            byteBufferDuplicate.flip();
            int[] iArr2 = this.fpts;
            int i3 = this.curFrame;
            long j = iArr2[i3];
            long j2 = this.fdur[i3];
            long j3 = i3;
            int[] iArr3 = this.sync;
            Packet packetCreatePacket = Packet.createPacket(byteBufferDuplicate, j, MPEG_TIMESCALE, j2, j3, (iArr3.length == 0 || Arrays.binarySearch(iArr3, i3) >= 0) ? Packet.FrameType.KEY : Packet.FrameType.INTER, null);
            this.curFrame++;
            return packetCreatePacket;
        }

        private void seekToFrame() throws IOException {
            int i = this._seekToFrame;
            if (i == -1) {
                return;
            }
            this.curFrame = i;
            long j = this.foffs[i];
            reset();
            this.curPesIdx = 0;
            long jPesLen = 0;
            while (true) {
                if (this.demuxer.pesStreamIds[this.curPesIdx] == this.streamId) {
                    long jPayLoadSize = MPSIndex.payLoadSize(this.demuxer.pesTokens[this.curPesIdx]);
                    if (j < jPayLoadSize) {
                        skip(jPesLen + MPSIndex.leadingSize(this.demuxer.pesTokens[this.curPesIdx]));
                        ByteBuffer byteBufferFetch = fetch(MPSIndex.pesLen(this.demuxer.pesTokens[this.curPesIdx]));
                        this.pesBuf = byteBufferFetch;
                        MPSUtils.readPESHeader(byteBufferFetch, 0L);
                        NIOUtils.skip(this.pesBuf, (int) j);
                        this._seekToFrame = -1;
                        return;
                    }
                    j -= jPayLoadSize;
                }
                jPesLen += MPSIndex.pesLen(this.demuxer.pesTokens[this.curPesIdx]) + MPSIndex.leadingSize(this.demuxer.pesTokens[this.curPesIdx]);
                this.curPesIdx++;
            }
        }

        public ByteBuffer fetch(int i) throws IOException {
            return NIOUtils.fetchFromChannel(this.source, i);
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public long getCurFrame() {
            return this.curFrame;
        }

        @Override // org.jcodec.common.DemuxerTrack
        public DemuxerTrackMeta getMeta() {
            return null;
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public boolean gotoFrame(long j) {
            this._seekToFrame = (int) j;
            return true;
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public boolean gotoSyncFrame(long j) {
            int i = 0;
            while (true) {
                int[] iArr = this.sync;
                if (i >= iArr.length) {
                    this._seekToFrame = iArr[iArr.length - 1];
                    return true;
                }
                if (iArr[i] > j) {
                    this._seekToFrame = iArr[i - 1];
                    return true;
                }
                i++;
            }
        }

        @Override // org.jcodec.common.DemuxerTrack
        public Packet nextFrame() throws IOException {
            seekToFrame();
            int i = this.curFrame;
            int[] iArr = this.fsizes;
            if (i >= iArr.length) {
                return null;
            }
            return _nextFrame(ByteBuffer.allocate(iArr[i]));
        }

        public void reset() throws IOException {
            this.source.setPosition(0L);
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public void seek(double d) {
            throw new NotSupportedException("");
        }

        public void skip(long j) throws IOException {
            SeekableByteChannel seekableByteChannel = this.source;
            seekableByteChannel.setPosition(seekableByteChannel.position() + j);
        }
    }

    public MPSRandomAccessDemuxer(SeekableByteChannel seekableByteChannel, MPSIndex mPSIndex) throws IOException {
        this.pesTokens = mPSIndex.getPesTokens();
        this.pesStreamIds = mPSIndex.getPesStreamIds().flattern();
        MPSIndex.MPSStreamIndex[] streams = mPSIndex.getStreams();
        this.streams = new Stream[streams.length];
        for (int i = 0; i < streams.length; i++) {
            this.streams[i] = newStream(seekableByteChannel, streams[i]);
        }
    }

    public Stream[] getStreams() {
        return this.streams;
    }

    public Stream newStream(SeekableByteChannel seekableByteChannel, MPSIndex.MPSStreamIndex mPSStreamIndex) throws IOException {
        return new Stream(this, mPSStreamIndex, seekableByteChannel);
    }
}
