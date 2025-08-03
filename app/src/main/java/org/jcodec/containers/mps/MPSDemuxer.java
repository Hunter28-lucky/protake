package org.jcodec.containers.mps;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jcodec.codecs.aac.AACConts;
import org.jcodec.codecs.aac.ADTSParser;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.mpeg12.MPEGDecoder;
import org.jcodec.codecs.mpeg12.MPEGES;
import org.jcodec.codecs.mpeg12.SegmentReader;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.IntIntHistogram;
import org.jcodec.common.LongArrayList;
import org.jcodec.common.TrackType;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.Packet;
import org.jcodec.containers.mps.MPEGDemuxer;

/* loaded from: classes2.dex */
public class MPSDemuxer extends SegmentReader implements MPEGDemuxer {
    private static final int BUFFER_SIZE = 1048576;
    private List<ByteBuffer> bufPool;
    private ReadableByteChannel channel;
    private Map<Integer, BaseTrack> streams;

    public static class AACTrack extends PlainTrack {
        private List<Packet> audioStash;

        public AACTrack(MPSDemuxer mPSDemuxer, int i, PESPacket pESPacket) throws IOException {
            super(mPSDemuxer, i, pESPacket);
            this.audioStash = new ArrayList();
        }

        @Override // org.jcodec.containers.mps.MPSDemuxer.PlainTrack, org.jcodec.common.DemuxerTrack
        public Packet nextFrame() throws IOException {
            Packet packetNextFrameWithBuffer;
            if (this.audioStash.size() == 0 && (packetNextFrameWithBuffer = nextFrameWithBuffer(null)) != null) {
                ByteBuffer data = packetNextFrameWithBuffer.getData();
                ADTSParser.Header header = ADTSParser.read(data.duplicate());
                long pts = packetNextFrameWithBuffer.getPts();
                while (data.hasRemaining()) {
                    Packet packetCreatePacketWithData = Packet.createPacketWithData(packetNextFrameWithBuffer, NIOUtils.read(data, header.getSize()));
                    packetCreatePacketWithData.setDuration((packetCreatePacketWithData.getTimescale() * 1024) / AACConts.AAC_SAMPLE_RATES[header.getSamplingIndex()]);
                    packetCreatePacketWithData.setPts(pts);
                    pts += packetCreatePacketWithData.getDuration();
                    this.audioStash.add(packetCreatePacketWithData);
                    if (data.hasRemaining()) {
                        header = ADTSParser.read(data.duplicate());
                    }
                }
            }
            if (this.audioStash.size() == 0) {
                return null;
            }
            return this.audioStash.remove(0);
        }
    }

    public static abstract class BaseTrack implements MPEGDemuxer.MPEGDemuxerTrack {
        public List<PESPacket> _pending;
        public MPSDemuxer demuxer;
        public int streamId;

        public BaseTrack(MPSDemuxer mPSDemuxer, int i, PESPacket pESPacket) throws IOException {
            ArrayList arrayList = new ArrayList();
            this._pending = arrayList;
            this.demuxer = mPSDemuxer;
            this.streamId = i;
            arrayList.add(pESPacket);
        }

        @Override // org.jcodec.containers.mps.MPEGDemuxer.MPEGDemuxerTrack
        public List<PESPacket> getPending() {
            return this._pending;
        }

        @Override // org.jcodec.containers.mps.MPEGDemuxer.MPEGDemuxerTrack
        public int getSid() {
            return this.streamId;
        }

        @Override // org.jcodec.containers.mps.MPEGDemuxer.MPEGDemuxerTrack
        public void ignore() {
            List<PESPacket> list = this._pending;
            if (list == null) {
                return;
            }
            Iterator<PESPacket> it = list.iterator();
            while (it.hasNext()) {
                this.demuxer.putBack(it.next().data);
            }
            this._pending = null;
        }

        public void pending(PESPacket pESPacket) {
            List<PESPacket> list = this._pending;
            if (list != null) {
                list.add(pESPacket);
            } else {
                this.demuxer.putBack(pESPacket.data);
            }
        }
    }

    public static class MPEGTrack extends BaseTrack implements ReadableByteChannel {
        private IntIntHistogram durationHistogram;
        private MPEGES es;
        private long lastPts;
        private int lastSeq;
        private int lastSeqSeen;
        private LongArrayList ptsSeen;
        private int seqWrap;

        public MPEGTrack(MPSDemuxer mPSDemuxer, int i, PESPacket pESPacket) throws IOException {
            super(mPSDemuxer, i, pESPacket);
            this.es = new MPEGES(this, 4096);
            this.ptsSeen = new LongArrayList(32);
            this.lastSeq = Integer.MIN_VALUE;
            this.lastSeqSeen = 2147482647;
            this.seqWrap = 2147482647;
            this.durationHistogram = new IntIntHistogram();
        }

        private PESPacket getPacket() throws IOException {
            if (this._pending.size() > 0) {
                return this._pending.remove(0);
            }
            while (true) {
                MPSDemuxer mPSDemuxer = this.demuxer;
                PESPacket pESPacketNextPacket = mPSDemuxer.nextPacket(mPSDemuxer.getBuffer());
                if (pESPacketNextPacket == null) {
                    return null;
                }
                if (pESPacketNextPacket.streamId == this.streamId) {
                    long j = pESPacketNextPacket.pts;
                    if (j != -1) {
                        this.ptsSeen.add(j);
                    }
                    return pESPacketNextPacket;
                }
                this.demuxer.addToStream(pESPacketNextPacket);
            }
        }

        @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public MPEGES getES() {
            return this.es;
        }

        @Override // org.jcodec.containers.mps.MPEGDemuxer.MPEGDemuxerTrack, org.jcodec.common.DemuxerTrack
        public DemuxerTrackMeta getMeta() {
            return null;
        }

        @Override // java.nio.channels.Channel
        public boolean isOpen() {
            return true;
        }

        @Override // org.jcodec.common.DemuxerTrack
        public Packet nextFrame() throws IOException {
            MPEGPacket frame = this.es.getFrame();
            if (frame == null) {
                return null;
            }
            int sequenceNumber = MPEGDecoder.getSequenceNumber(frame.getData());
            if (sequenceNumber == 0) {
                this.seqWrap = this.lastSeqSeen + 1;
            }
            this.lastSeqSeen = sequenceNumber;
            if (this.ptsSeen.size() <= 0) {
                int i = this.lastSeq;
                frame.setPts((Math.min(sequenceNumber - i, (sequenceNumber - i) + this.seqWrap) * this.durationHistogram.max()) + this.lastPts);
            } else {
                frame.setPts(this.ptsSeen.shift());
                int i2 = this.lastSeq;
                if (i2 >= 0 && sequenceNumber > i2) {
                    IntIntHistogram intIntHistogram = this.durationHistogram;
                    int pts = (int) (frame.getPts() - this.lastPts);
                    int i3 = this.lastSeq;
                    intIntHistogram.increment(pts / Math.min(sequenceNumber - i3, (sequenceNumber - i3) + this.seqWrap));
                }
                this.lastPts = frame.getPts();
                this.lastSeq = sequenceNumber;
            }
            frame.setDuration(this.durationHistogram.max());
            System.out.println(sequenceNumber);
            return frame;
        }

        @Override // org.jcodec.containers.mps.MPEGDemuxer.MPEGDemuxerTrack
        public Packet nextFrameWithBuffer(ByteBuffer byteBuffer) throws IOException {
            return this.es.frame(byteBuffer);
        }

        @Override // java.nio.channels.ReadableByteChannel
        public int read(ByteBuffer byteBuffer) throws IOException {
            PESPacket pESPacketRemove = this._pending.size() > 0 ? this._pending.remove(0) : getPacket();
            if (pESPacketRemove == null || !pESPacketRemove.data.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(byteBuffer.remaining(), pESPacketRemove.data.remaining());
            byteBuffer.put(NIOUtils.read(pESPacketRemove.data, iMin));
            if (pESPacketRemove.data.hasRemaining()) {
                this._pending.add(0, pESPacketRemove);
            } else {
                this.demuxer.putBack(pESPacketRemove.data);
            }
            return iMin;
        }
    }

    public static class PlainTrack extends BaseTrack {
        private int frameNo;
        private Packet lastFrame;
        private long lastKnownDuration;

        public PlainTrack(MPSDemuxer mPSDemuxer, int i, PESPacket pESPacket) throws IOException {
            super(mPSDemuxer, i, pESPacket);
            this.lastKnownDuration = 3003L;
        }

        public void close() throws IOException {
        }

        @Override // org.jcodec.containers.mps.MPEGDemuxer.MPEGDemuxerTrack, org.jcodec.common.DemuxerTrack
        public DemuxerTrackMeta getMeta() {
            if (!MPSUtils.videoStream(this.streamId)) {
                MPSUtils.audioStream(this.streamId);
            }
            TrackType trackType = TrackType.VIDEO;
            return null;
        }

        public boolean isOpen() {
            return true;
        }

        @Override // org.jcodec.common.DemuxerTrack
        public Packet nextFrame() throws IOException {
            if (this.lastFrame == null) {
                this.lastFrame = nextFrameWithBuffer(null);
            }
            Packet packet = this.lastFrame;
            if (packet == null) {
                return null;
            }
            Packet packetNextFrameWithBuffer = nextFrameWithBuffer(null);
            this.lastFrame = packetNextFrameWithBuffer;
            if (packetNextFrameWithBuffer != null) {
                this.lastKnownDuration = packetNextFrameWithBuffer.getPts() - packet.getPts();
            }
            packet.setDuration(this.lastKnownDuration);
            return packet;
        }

        @Override // org.jcodec.containers.mps.MPEGDemuxer.MPEGDemuxerTrack
        public Packet nextFrameWithBuffer(ByteBuffer byteBuffer) throws IOException {
            PESPacket pESPacketNextPacket;
            if (this._pending.size() > 0) {
                pESPacketNextPacket = this._pending.remove(0);
            } else {
                while (true) {
                    MPSDemuxer mPSDemuxer = this.demuxer;
                    pESPacketNextPacket = mPSDemuxer.nextPacket(mPSDemuxer.getBuffer());
                    if (pESPacketNextPacket == null || pESPacketNextPacket.streamId == this.streamId) {
                        break;
                    }
                    this.demuxer.addToStream(pESPacketNextPacket);
                }
            }
            if (pESPacketNextPacket == null) {
                return null;
            }
            ByteBuffer byteBuffer2 = pESPacketNextPacket.data;
            long j = pESPacketNextPacket.pts;
            int i = this.frameNo;
            this.frameNo = i + 1;
            return Packet.createPacket(byteBuffer2, j, 90000, 0L, i, Packet.FrameType.UNKNOWN, null);
        }
    }

    public MPSDemuxer(ReadableByteChannel readableByteChannel) throws IOException {
        super(readableByteChannel, 4096);
        this.streams = new HashMap();
        this.channel = readableByteChannel;
        this.bufPool = new ArrayList();
        findStreams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToStream(PESPacket pESPacket) throws IOException {
        BaseTrack baseTrack = this.streams.get(Integer.valueOf(pESPacket.streamId));
        if (baseTrack == null) {
            this.streams.put(Integer.valueOf(pESPacket.streamId), isMPEG(pESPacket.data) ? new MPEGTrack(this, pESPacket.streamId, pESPacket) : isAAC(pESPacket.data) ? new AACTrack(this, pESPacket.streamId, pESPacket) : new PlainTrack(this, pESPacket.streamId, pESPacket));
        } else {
            baseTrack.pending(pESPacket);
        }
    }

    private boolean isAAC(ByteBuffer byteBuffer) {
        return ADTSParser.read(byteBuffer.duplicate()) != null;
    }

    private boolean isMPEG(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        int i = -1;
        boolean z = false;
        boolean z2 = false;
        int i2 = 0;
        while (byteBufferDuplicate.hasRemaining()) {
            i = (i << 8) | (byteBufferDuplicate.get() & ExifInterface.MARKER);
            if (i >= 256 && i <= 440) {
                if (i >= 432 && i <= 440) {
                    if ((z2 && i != 437 && i != 434) || z) {
                        break;
                    }
                    i2 += 5;
                } else if (i == 256) {
                    if (z) {
                        break;
                    }
                    z2 = true;
                } else if (i > 256 && i < 432) {
                    if (!z2) {
                        break;
                    }
                    if (!z) {
                        i2 += 50;
                        z = true;
                    }
                    i2++;
                }
            }
        }
        return i2 > 50;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00aa A[EDGE_INSN: B:77:0x00aa->B:63:0x00aa BREAK  A[LOOP:0: B:3:0x0011->B:78:0x0011], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0011 A[SYNTHETIC] */
    @org.jcodec.common.UsedViaReflection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int probe(java.nio.ByteBuffer r14) {
        /*
            Method dump skipped, instructions count: 186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.containers.mps.MPSDemuxer.probe(java.nio.ByteBuffer):int");
    }

    private static int rateSeq(List<NALUnit> list) {
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (NALUnit nALUnit : list) {
            NALUnitType nALUnitType = NALUnitType.SPS;
            NALUnitType nALUnitType2 = nALUnit.type;
            if (nALUnitType == nALUnitType2) {
                i = (!z || z3) ? i + 30 : i - 30;
                z = true;
            } else if (NALUnitType.PPS == nALUnitType2) {
                if (z2 && !z3) {
                    i -= 30;
                }
                if (z) {
                    i += 20;
                }
                z2 = true;
            } else if (NALUnitType.IDR_SLICE == nALUnitType2 || NALUnitType.NON_IDR_SLICE == nALUnitType2) {
                if (!z3) {
                    i += 20;
                }
                z3 = true;
            }
        }
        return i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.channel.close();
    }

    public void findStreams() throws IOException {
        int i = 0;
        while (true) {
            if (i != 0 && (i >= this.streams.size() * 5 || this.streams.size() >= 2)) {
                return;
            }
            PESPacket pESPacketNextPacket = nextPacket(getBuffer());
            if (pESPacketNextPacket == null) {
                return;
            }
            addToStream(pESPacketNextPacket);
            i++;
        }
    }

    @Override // org.jcodec.containers.mps.MPEGDemuxer, org.jcodec.common.Demuxer
    public List<MPEGDemuxer.MPEGDemuxerTrack> getAudioTracks() {
        ArrayList arrayList = new ArrayList();
        for (BaseTrack baseTrack : this.streams.values()) {
            if (MPSUtils.audioStream(baseTrack.streamId)) {
                arrayList.add(baseTrack);
            }
        }
        return arrayList;
    }

    public ByteBuffer getBuffer() {
        synchronized (this.bufPool) {
            if (this.bufPool.size() <= 0) {
                return ByteBuffer.allocate(1048576);
            }
            return this.bufPool.remove(0);
        }
    }

    @Override // org.jcodec.containers.mps.MPEGDemuxer, org.jcodec.common.Demuxer
    public List<MPEGDemuxer.MPEGDemuxerTrack> getTracks() {
        return new ArrayList(this.streams.values());
    }

    @Override // org.jcodec.containers.mps.MPEGDemuxer, org.jcodec.common.Demuxer
    public List<MPEGDemuxer.MPEGDemuxerTrack> getVideoTracks() {
        ArrayList arrayList = new ArrayList();
        for (BaseTrack baseTrack : this.streams.values()) {
            if (MPSUtils.videoStream(baseTrack.streamId)) {
                arrayList.add(baseTrack);
            }
        }
        return arrayList;
    }

    public PESPacket nextPacket(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        while (!MPSUtils.psMarker(this.curMarker)) {
            if (!skipToMarker()) {
                return null;
            }
        }
        ByteBuffer byteBufferDuplicate2 = byteBufferDuplicate.duplicate();
        readToNextMarker(byteBufferDuplicate);
        PESPacket pESHeader = MPSUtils.readPESHeader(byteBufferDuplicate2, curPos());
        int i = pESHeader.length;
        if (i == 0) {
            while (!MPSUtils.psMarker(this.curMarker) && readToNextMarker(byteBufferDuplicate)) {
            }
        } else {
            read(byteBufferDuplicate, (i - byteBufferDuplicate.position()) + 6);
        }
        byteBufferDuplicate2.limit(byteBufferDuplicate.position());
        pESHeader.data = byteBufferDuplicate2;
        return pESHeader;
    }

    public void putBack(ByteBuffer byteBuffer) {
        byteBuffer.clear();
        synchronized (this.bufPool) {
            this.bufPool.add(byteBuffer);
        }
    }

    public void reset() {
        Iterator<BaseTrack> it = this.streams.values().iterator();
        while (it.hasNext()) {
            it.next()._pending.clear();
        }
    }
}
