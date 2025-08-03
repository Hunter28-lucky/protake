package org.jcodec.containers.mp4.demuxer;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Packet;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.QTTimeUtil;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.CompositionOffsetsBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.SyncSamplesBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

/* loaded from: classes2.dex */
public class MP4DemuxerTrack extends AbstractMP4DemuxerTrack {
    private CompositionOffsetsBox.Entry[] compOffsets;
    private int cttsInd;
    private int cttsSubInd;
    private SeekableByteChannel input;
    private MovieBox movie;
    private int noInChunk;
    private long offInChunk;
    private int[] partialSync;
    private int psOff;
    private int[] sizes;
    private int ssOff;
    private int[] syncSamples;

    public MP4DemuxerTrack(MovieBox movieBox, TrakBox trakBox, SeekableByteChannel seekableByteChannel) {
        super(trakBox);
        this.input = seekableByteChannel;
        this.movie = movieBox;
        SampleSizesBox sampleSizesBox = (SampleSizesBox) NodeBox.findFirstPath(trakBox, SampleSizesBox.class, Box.path("mdia.minf.stbl.stsz"));
        SyncSamplesBox syncSamplesBox = (SyncSamplesBox) NodeBox.findFirstPath(trakBox, SyncSamplesBox.class, Box.path("mdia.minf.stbl.stss"));
        SyncSamplesBox syncSamplesBox2 = (SyncSamplesBox) NodeBox.findFirstPath(trakBox, SyncSamplesBox.class, Box.path("mdia.minf.stbl.stps"));
        CompositionOffsetsBox compositionOffsetsBox = (CompositionOffsetsBox) NodeBox.findFirstPath(trakBox, CompositionOffsetsBox.class, Box.path("mdia.minf.stbl.ctts"));
        this.compOffsets = compositionOffsetsBox == null ? null : compositionOffsetsBox.getEntries();
        if (syncSamplesBox != null) {
            this.syncSamples = syncSamplesBox.getSyncSamples();
        }
        if (syncSamplesBox2 != null) {
            this.partialSync = syncSamplesBox2.getSyncSamples();
        }
        this.sizes = sampleSizesBox.getSizes();
    }

    @Override // org.jcodec.containers.mp4.demuxer.AbstractMP4DemuxerTrack
    public long getFrameCount() {
        return this.sizes.length;
    }

    @Override // org.jcodec.containers.mp4.demuxer.AbstractMP4DemuxerTrack
    public synchronized MP4Packet getNextFrame(ByteBuffer byteBuffer) throws IOException {
        boolean z;
        int i;
        int i2;
        long j = this.curFrame;
        int[] iArr = this.sizes;
        ByteBuffer byteBufferConvertPacket = null;
        if (j >= iArr.length) {
            return null;
        }
        int i3 = iArr[(int) j];
        if (byteBuffer != null && byteBuffer.remaining() < i3) {
            throw new IllegalArgumentException("Buffer size is not enough to fit a packet");
        }
        long j2 = this.chunkOffsets[Math.min(r1.length - 1, this.stcoInd)] + this.offInChunk;
        ByteBuffer packetData = readPacketData(this.input, byteBuffer, j2, i3);
        if (packetData != null && packetData.remaining() < i3) {
            return null;
        }
        int sampleDuration = this.timeToSamples[this.sttsInd].getSampleDuration();
        int[] iArr2 = this.syncSamples;
        boolean z2 = iArr2 == null;
        if (iArr2 != null && (i2 = this.ssOff) < iArr2.length && this.curFrame + 1 == iArr2[i2]) {
            this.ssOff = i2 + 1;
            z2 = true;
        }
        int[] iArr3 = this.partialSync;
        if (iArr3 == null || (i = this.psOff) >= iArr3.length || this.curFrame + 1 != iArr3[i]) {
            z = false;
        } else {
            this.psOff = i + 1;
            z = true;
        }
        long offset = this.pts;
        if (this.compOffsets != null) {
            offset += r3[this.cttsInd].getOffset();
            int i4 = this.cttsSubInd + 1;
            this.cttsSubInd = i4;
            int i5 = this.cttsInd;
            CompositionOffsetsBox.Entry[] entryArr = this.compOffsets;
            if (i5 < entryArr.length - 1 && i4 == entryArr[i5].getCount()) {
                this.cttsInd++;
                this.cttsSubInd = 0;
            }
        }
        long j3 = offset;
        if (packetData != null) {
            byteBufferConvertPacket = convertPacket(packetData);
        }
        MP4Packet mP4Packet = new MP4Packet(byteBufferConvertPacket, QTTimeUtil.mediaToEdited(this.box, j3, this.movie.getTimescale()), this.timescale, sampleDuration, this.curFrame, z2 ? Packet.FrameType.KEY : Packet.FrameType.INTER, null, 0, j3, this.sampleToChunks[this.stscInd].getEntry() - 1, j2, i3, z);
        this.offInChunk += i3;
        this.curFrame++;
        int i6 = this.noInChunk + 1;
        this.noInChunk = i6;
        if (i6 >= this.sampleToChunks[this.stscInd].getCount()) {
            this.noInChunk = 0;
            this.offInChunk = 0L;
            nextChunk();
        }
        shiftPts(1L);
        return mP4Packet;
    }

    @Override // org.jcodec.common.SeekableDemuxerTrack
    public boolean gotoSyncFrame(long j) {
        if (this.syncSamples == null) {
            return gotoFrame(j);
        }
        if (j < 0) {
            throw new IllegalArgumentException("negative frame number");
        }
        int i = 0;
        if (j >= getFrameCount()) {
            return false;
        }
        if (j == this.curFrame) {
            return true;
        }
        while (true) {
            if (i >= this.syncSamples.length) {
                return gotoFrame(r0[r0.length - 1] - 1);
            }
            if (r0[i] - 1 > j) {
                return gotoFrame(r0[i - 1] - 1);
            }
            i++;
        }
    }

    @Override // org.jcodec.containers.mp4.demuxer.AbstractMP4DemuxerTrack
    public void seekPointer(long j) {
        if (this.compOffsets != null) {
            this.cttsSubInd = (int) j;
            this.cttsInd = 0;
            while (this.cttsSubInd >= this.compOffsets[this.cttsInd].getCount()) {
                this.cttsSubInd -= this.compOffsets[this.cttsInd].getCount();
                this.cttsInd++;
            }
        }
        int i = (int) j;
        this.curFrame = i;
        this.stcoInd = 0;
        this.stscInd = 0;
        this.noInChunk = i;
        this.offInChunk = 0L;
        while (this.noInChunk >= this.sampleToChunks[this.stscInd].getCount()) {
            this.noInChunk -= this.sampleToChunks[this.stscInd].getCount();
            nextChunk();
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.noInChunk) {
                break;
            }
            this.offInChunk += this.sizes[(i - r0) + i2];
            i2++;
        }
        if (this.syncSamples != null) {
            this.ssOff = 0;
            while (true) {
                int i3 = this.ssOff;
                if (i3 >= this.syncSamples.length || r10[i3] >= this.curFrame + 1) {
                    break;
                } else {
                    this.ssOff = i3 + 1;
                }
            }
        }
        if (this.partialSync == null) {
            return;
        }
        this.psOff = 0;
        while (true) {
            int i4 = this.psOff;
            if (i4 >= this.partialSync.length || r10[i4] >= this.curFrame + 1) {
                return;
            } else {
                this.psOff = i4 + 1;
            }
        }
    }

    @Override // org.jcodec.common.DemuxerTrack
    public synchronized MP4Packet nextFrame() throws IOException {
        long j = this.curFrame;
        int[] iArr = this.sizes;
        if (j >= iArr.length) {
            return null;
        }
        return getNextFrame(ByteBuffer.allocate(iArr[(int) j]));
    }
}
