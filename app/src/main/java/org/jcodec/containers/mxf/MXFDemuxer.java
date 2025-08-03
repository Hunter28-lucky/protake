package org.jcodec.containers.mxf;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.jcodec.api.NotSupportedException;
import org.jcodec.common.Codec;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.SeekableDemuxerTrack;
import org.jcodec.common.TrackType;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.common.model.TapeTimecode;
import org.jcodec.containers.mxf.model.FileDescriptor;
import org.jcodec.containers.mxf.model.GenericDescriptor;
import org.jcodec.containers.mxf.model.GenericPictureEssenceDescriptor;
import org.jcodec.containers.mxf.model.GenericSoundEssenceDescriptor;
import org.jcodec.containers.mxf.model.IndexSegment;
import org.jcodec.containers.mxf.model.KLV;
import org.jcodec.containers.mxf.model.MXFMetadata;
import org.jcodec.containers.mxf.model.MXFPartition;
import org.jcodec.containers.mxf.model.MXFUtil;
import org.jcodec.containers.mxf.model.SourceClip;
import org.jcodec.containers.mxf.model.TimecodeComponent;
import org.jcodec.containers.mxf.model.TimelineTrack;
import org.jcodec.containers.mxf.model.UL;
import org.jcodec.containers.mxf.model.WaveAudioDescriptor;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class MXFDemuxer {
    public SeekableByteChannel ch;
    public double duration;
    public MXFPartition header;
    public List<IndexSegment> indexSegments;
    public List<MXFMetadata> metadata;
    public List<MXFPartition> partitions;
    public TimecodeComponent timecode;
    public int totalFrames;
    public MXFDemuxerTrack[] tracks;

    public static class Fast extends MXFDemuxer {
        public Fast(SeekableByteChannel seekableByteChannel) throws IOException {
            super(seekableByteChannel);
        }

        @Override // org.jcodec.containers.mxf.MXFDemuxer
        public void parseHeader(SeekableByteChannel seekableByteChannel) throws IOException {
            this.partitions = new ArrayList();
            this.metadata = new ArrayList();
            MXFPartition headerPartition = MXFDemuxer.readHeaderPartition(seekableByteChannel);
            this.header = headerPartition;
            this.metadata.addAll(MXFDemuxer.readPartitionMeta(seekableByteChannel, headerPartition));
            this.partitions.add(this.header);
            seekableByteChannel.setPosition(this.header.getPack().getFooterPartition());
            KLV kl = KLV.readKL(seekableByteChannel);
            if (kl != null) {
                this.metadata.addAll(MXFDemuxer.readPartitionMeta(seekableByteChannel, MXFPartition.read(kl.key, NIOUtils.fetchFromChannel(seekableByteChannel, (int) kl.len), seekableByteChannel.position() - kl.offset, seekableByteChannel.size())));
            }
        }
    }

    public static class MXFDemuxerTrack implements SeekableDemuxerTrack {
        private boolean audio;
        private int audioFrameDuration;
        private int audioTimescale;
        private MXFCodec codec;
        private int dataLen;
        private MXFDemuxer demuxer;
        private GenericDescriptor descriptor;
        private UL essenceUL;
        private int frameNo;
        private int indexSegmentIdx;
        private int indexSegmentSubIdx;
        private long partEssenceOffset;
        private int partIdx;
        private long pts;
        private TimelineTrack track;
        private boolean video;

        public MXFDemuxerTrack(MXFDemuxer mXFDemuxer, UL ul, TimelineTrack timelineTrack, GenericDescriptor genericDescriptor) throws IOException {
            this.demuxer = mXFDemuxer;
            this.essenceUL = ul;
            this.track = timelineTrack;
            this.descriptor = genericDescriptor;
            if (genericDescriptor instanceof GenericPictureEssenceDescriptor) {
                this.video = true;
            } else if (genericDescriptor instanceof GenericSoundEssenceDescriptor) {
                this.audio = true;
            }
            MXFCodec mXFCodecResolveCodec = resolveCodec();
            this.codec = mXFCodecResolveCodec;
            if (mXFCodecResolveCodec != null || (genericDescriptor instanceof WaveAudioDescriptor)) {
                Logger.warn("Track type: " + this.video + ", " + this.audio);
                if (this.audio && (genericDescriptor instanceof WaveAudioDescriptor)) {
                    WaveAudioDescriptor waveAudioDescriptor = (WaveAudioDescriptor) genericDescriptor;
                    cacheAudioFrameSizes(mXFDemuxer.ch);
                    this.audioFrameDuration = this.dataLen / ((waveAudioDescriptor.getQuantizationBits() >> 3) * waveAudioDescriptor.getChannelCount());
                    this.audioTimescale = (int) waveAudioDescriptor.getAudioSamplingRate().scalar();
                }
            }
        }

        private void cacheAudioFrameSizes(SeekableByteChannel seekableByteChannel) throws IOException {
            KLV kl;
            for (MXFPartition mXFPartition : this.demuxer.partitions) {
                if (mXFPartition.getEssenceLength() > 0) {
                    seekableByteChannel.setPosition(mXFPartition.getEssenceFilePos());
                    do {
                        kl = KLV.readKL(seekableByteChannel);
                        if (kl == null) {
                            break;
                        } else {
                            seekableByteChannel.setPosition(seekableByteChannel.position() + kl.len);
                        }
                    } while (!this.essenceUL.equals(kl.key));
                    if (kl != null && this.essenceUL.equals(kl.key)) {
                        this.dataLen = (int) kl.len;
                        return;
                    }
                }
            }
        }

        private MXFCodec resolveCodec() {
            UL soundEssenceCompression;
            if (!this.video) {
                if (this.audio) {
                    soundEssenceCompression = ((GenericSoundEssenceDescriptor) this.descriptor).getSoundEssenceCompression();
                }
                return null;
            }
            soundEssenceCompression = ((GenericPictureEssenceDescriptor) this.descriptor).getPictureEssenceCoding();
            for (MXFCodec mXFCodec : MXFCodec.values()) {
                if (mXFCodec.getUl().equals(soundEssenceCompression)) {
                    return mXFCodec;
                }
            }
            Logger.warn("Unknown codec: " + soundEssenceCompression);
            return null;
        }

        public MXFCodec getCodec() {
            return this.codec;
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public long getCurFrame() {
            return this.frameNo;
        }

        public GenericDescriptor getDescriptor() {
            return this.descriptor;
        }

        public double getDuration() {
            return this.demuxer.duration;
        }

        public Rational getEditRate() {
            return this.track.getEditRate();
        }

        public UL getEssenceUL() {
            return this.essenceUL;
        }

        @Override // org.jcodec.common.DemuxerTrack
        public DemuxerTrackMeta getMeta() {
            Size size;
            if (this.video) {
                GenericPictureEssenceDescriptor genericPictureEssenceDescriptor = (GenericPictureEssenceDescriptor) this.descriptor;
                size = new Size(genericPictureEssenceDescriptor.getStoredWidth(), genericPictureEssenceDescriptor.getStoredHeight());
            } else {
                size = null;
            }
            TrackType trackType = this.video ? TrackType.VIDEO : this.audio ? TrackType.AUDIO : TrackType.OTHER;
            Codec codec = getCodec().getCodec();
            MXFDemuxer mXFDemuxer = this.demuxer;
            return new DemuxerTrackMeta(trackType, codec, mXFDemuxer.duration, null, mXFDemuxer.totalFrames, null, VideoCodecMeta.createSimpleVideoCodecMeta(size, ColorSpace.YUV420), null);
        }

        public String getName() {
            return this.track.getName();
        }

        public int getNumFrames() {
            return this.demuxer.totalFrames;
        }

        public int getTrackId() {
            return this.track.getTrackId();
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public boolean gotoFrame(long j) {
            if (j == this.frameNo) {
                return true;
            }
            this.indexSegmentSubIdx = (int) j;
            this.indexSegmentIdx = 0;
            while (this.indexSegmentIdx < this.demuxer.indexSegments.size() && this.indexSegmentSubIdx >= this.demuxer.indexSegments.get(this.indexSegmentIdx).getIndexDuration()) {
                this.indexSegmentSubIdx = (int) (this.indexSegmentSubIdx - this.demuxer.indexSegments.get(this.indexSegmentIdx).getIndexDuration());
                this.indexSegmentIdx++;
            }
            this.indexSegmentSubIdx = Math.min(this.indexSegmentSubIdx, (int) this.demuxer.indexSegments.get(this.indexSegmentIdx).getIndexDuration());
            return true;
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public boolean gotoSyncFrame(long j) {
            if (gotoFrame(j)) {
                return gotoFrame(j + this.demuxer.indexSegments.get(this.indexSegmentIdx).getIe().getKeyFrameOff()[this.indexSegmentSubIdx]);
            }
            return false;
        }

        public boolean isAudio() {
            return this.audio;
        }

        public boolean isVideo() {
            return this.video;
        }

        @Override // org.jcodec.common.DemuxerTrack
        public Packet nextFrame() throws IOException {
            MXFPacket packet;
            if (this.indexSegmentIdx >= this.demuxer.indexSegments.size()) {
                return null;
            }
            IndexSegment indexSegment = this.demuxer.indexSegments.get(this.indexSegmentIdx);
            long[] fileOff = indexSegment.getIe().getFileOff();
            int indexEditRateNum = indexSegment.getIndexEditRateNum();
            int indexEditRateDen = indexSegment.getIndexEditRateDen();
            long j = fileOff[this.indexSegmentSubIdx];
            byte b = indexSegment.getIe().getDisplayOff()[this.indexSegmentSubIdx];
            boolean z = indexSegment.getIe().getKeyFrameOff()[this.indexSegmentSubIdx] == 0;
            while (j >= this.partEssenceOffset + this.demuxer.partitions.get(this.partIdx).getEssenceLength() && this.partIdx < this.demuxer.partitions.size() - 1) {
                this.partEssenceOffset += this.demuxer.partitions.get(this.partIdx).getEssenceLength();
                this.partIdx++;
            }
            long essenceFilePos = (j - this.partEssenceOffset) + this.demuxer.partitions.get(this.partIdx).getEssenceFilePos();
            if (this.audio) {
                int i = this.dataLen;
                long j2 = this.pts;
                int i2 = this.audioTimescale;
                int i3 = this.audioFrameDuration;
                int i4 = this.frameNo;
                this.frameNo = i4 + 1;
                packet = readPacket(essenceFilePos, i, j2, i2, i3, i4, z);
                this.pts += this.audioFrameDuration;
            } else {
                int i5 = this.dataLen;
                long j3 = this.pts + (b * indexEditRateDen);
                int i6 = this.frameNo;
                this.frameNo = i6 + 1;
                packet = readPacket(essenceFilePos, i5, j3, indexEditRateNum, indexEditRateDen, i6, z);
                this.pts += indexEditRateDen;
            }
            int i7 = this.indexSegmentSubIdx + 1;
            this.indexSegmentSubIdx = i7;
            if (i7 >= fileOff.length) {
                int i8 = this.indexSegmentIdx + 1;
                this.indexSegmentIdx = i8;
                this.indexSegmentSubIdx = 0;
                if (this.dataLen == 0 && i8 < this.demuxer.indexSegments.size()) {
                    this.pts = (this.pts * this.demuxer.indexSegments.get(this.indexSegmentIdx).getIndexEditRateNum()) / indexEditRateNum;
                }
            }
            return packet;
        }

        public MXFPacket readPacket(long j, int i, long j2, int i2, int i3, int i4, boolean z) throws IOException {
            MXFPacket mXFPacket;
            SeekableByteChannel seekableByteChannel = this.demuxer.ch;
            synchronized (seekableByteChannel) {
                seekableByteChannel.setPosition(j);
                KLV kl = KLV.readKL(seekableByteChannel);
                while (kl != null && !this.essenceUL.equals(kl.key)) {
                    seekableByteChannel.setPosition(seekableByteChannel.position() + kl.len);
                    kl = KLV.readKL(seekableByteChannel);
                }
                if (kl == null || !this.essenceUL.equals(kl.key)) {
                    mXFPacket = null;
                } else {
                    mXFPacket = new MXFPacket(NIOUtils.fetchFromChannel(seekableByteChannel, (int) kl.len), j2, i2, i3, i4, z ? Packet.FrameType.KEY : Packet.FrameType.INTER, null, j, i);
                }
            }
            return mXFPacket;
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public void seek(double d) {
            throw new NotSupportedException("");
        }
    }

    public static class MXFPacket extends Packet {
        private int len;
        private long offset;

        public MXFPacket(ByteBuffer byteBuffer, long j, int i, long j2, long j3, Packet.FrameType frameType, TapeTimecode tapeTimecode, long j4, int i2) {
            super(byteBuffer, j, i, j2, j3, frameType, tapeTimecode, 0);
            this.offset = j4;
            this.len = i2;
        }

        public int getLen() {
            return this.len;
        }

        public long getOffset() {
            return this.offset;
        }
    }

    public static final class OP {
        public static final OP OP1a;
        public static final OP OP1b;
        public static final OP OP1c;
        public static final OP OP2a;
        public static final OP OP2b;
        public static final OP OP2c;
        public static final OP OP3a;
        public static final OP OP3b;
        public static final OP OP3c;
        public static final OP OPAtom;
        private static final OP[] _values;
        public int major;
        public int minor;

        static {
            OP op = new OP(1, 1);
            OP1a = op;
            OP op2 = new OP(1, 2);
            OP1b = op2;
            OP op3 = new OP(1, 3);
            OP1c = op3;
            OP op4 = new OP(2, 1);
            OP2a = op4;
            OP op5 = new OP(2, 2);
            OP2b = op5;
            OP op6 = new OP(2, 3);
            OP2c = op6;
            OP op7 = new OP(3, 1);
            OP3a = op7;
            OP op8 = new OP(3, 2);
            OP3b = op8;
            OP op9 = new OP(3, 3);
            OP3c = op9;
            OP op10 = new OP(16, 0);
            OPAtom = op10;
            _values = new OP[]{op, op2, op3, op4, op5, op6, op7, op8, op9, op10};
        }

        private OP(int i, int i2) {
            this.major = i;
            this.minor = i2;
        }

        public static OP[] values() {
            return _values;
        }
    }

    public MXFDemuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        this.ch = seekableByteChannel;
        seekableByteChannel.setPosition(0L);
        parseHeader(seekableByteChannel);
        findIndex();
        this.tracks = findTracks();
        this.timecode = (TimecodeComponent) MXFUtil.findMeta(this.metadata, TimecodeComponent.class);
    }

    public static FileDescriptor findDescriptor(List<FileDescriptor> list, int i) {
        for (FileDescriptor fileDescriptor : list) {
            if (fileDescriptor.getLinkedTrackId() == i) {
                return fileDescriptor;
            }
        }
        return null;
    }

    private void findIndex() {
        this.indexSegments = new ArrayList();
        for (MXFMetadata mXFMetadata : this.metadata) {
            if (mXFMetadata instanceof IndexSegment) {
                IndexSegment indexSegment = (IndexSegment) mXFMetadata;
                this.indexSegments.add(indexSegment);
                this.totalFrames = (int) (this.totalFrames + indexSegment.getIndexDuration());
                this.duration += (indexSegment.getIndexEditRateDen() * indexSegment.getIndexDuration()) / indexSegment.getIndexEditRateNum();
            }
        }
    }

    private static MXFMetadata parseMeta(UL ul, ByteBuffer byteBuffer) {
        Class<? extends MXFMetadata> cls = MXFConst.klMetadata.get(ul);
        if (cls == null) {
            Logger.warn("Unknown metadata piece: " + ul);
            return null;
        }
        try {
            MXFMetadata mXFMetadata = (MXFMetadata) Platform.newInstance(cls, new Object[]{ul});
            mXFMetadata.readBuf(byteBuffer);
            return mXFMetadata;
        } catch (Exception unused) {
            Logger.warn("Unknown metadata piece: " + ul);
            return null;
        }
    }

    public static MXFPartition readHeaderPartition(SeekableByteChannel seekableByteChannel) throws IOException {
        while (true) {
            KLV kl = KLV.readKL(seekableByteChannel);
            if (kl == null) {
                return null;
            }
            if (MXFConst.HEADER_PARTITION_KLV.equals(kl.key)) {
                return MXFPartition.read(kl.key, NIOUtils.fetchFromChannel(seekableByteChannel, (int) kl.len), seekableByteChannel.position() - kl.offset, 0L);
            }
            seekableByteChannel.setPosition(seekableByteChannel.position() + kl.len);
        }
    }

    public static List<MXFMetadata> readPartitionMeta(SeekableByteChannel seekableByteChannel, MXFPartition mXFPartition) throws IOException {
        KLV kLFromBuffer;
        long jPosition = seekableByteChannel.position();
        ArrayList arrayList = new ArrayList();
        ByteBuffer byteBufferFetchFromChannel = NIOUtils.fetchFromChannel(seekableByteChannel, (int) Math.max(0L, mXFPartition.getEssenceFilePos() - jPosition));
        while (byteBufferFetchFromChannel.hasRemaining() && (kLFromBuffer = KLV.readKLFromBuffer(byteBufferFetchFromChannel, jPosition)) != null) {
            long jRemaining = byteBufferFetchFromChannel.remaining();
            long j = kLFromBuffer.len;
            if (jRemaining < j) {
                break;
            }
            MXFMetadata meta = parseMeta(kLFromBuffer.key, NIOUtils.read(byteBufferFetchFromChannel, (int) j));
            if (meta != null) {
                arrayList.add(meta);
            }
        }
        return arrayList;
    }

    public static TapeTimecode readTapeTimecode(File file) throws IOException {
        Rational editRate;
        FileChannelWrapper fileChannelWrapper = NIOUtils.readableChannel(file);
        try {
            Fast fast = new Fast(fileChannelWrapper);
            MXFDemuxerTrack videoTrack = fast.getVideoTrack();
            TimecodeComponent timecode = fast.getTimecode();
            List<SourceClip> sourceClips = fast.getSourceClips(videoTrack.getTrackId());
            long startPosition = 0;
            if (timecode != null) {
                editRate = videoTrack.getEditRate();
                z = timecode.getDropFrame() != 0;
                startPosition = timecode.getStart();
            } else {
                editRate = null;
            }
            Iterator<SourceClip> it = sourceClips.iterator();
            while (it.hasNext()) {
                startPosition += it.next().getStartPosition();
            }
            if (editRate != null) {
                return TapeTimecode.tapeTimecode(startPosition, z, (int) Math.ceil(editRate.toDouble()));
            }
            return null;
        } finally {
            fileChannelWrapper.close();
        }
    }

    public MXFDemuxerTrack createTrack(UL ul, TimelineTrack timelineTrack, GenericDescriptor genericDescriptor) throws IOException {
        return new MXFDemuxerTrack(this, ul, timelineTrack, genericDescriptor);
    }

    public MXFDemuxerTrack[] findTracks() throws IOException {
        List<TimelineTrack> listFindAllMeta = MXFUtil.findAllMeta(this.metadata, TimelineTrack.class);
        List listFindAllMeta2 = MXFUtil.findAllMeta(this.metadata, FileDescriptor.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (TimelineTrack timelineTrack : listFindAllMeta) {
            if (timelineTrack.getTrackId() == 0 || timelineTrack.getTrackNumber() == 0) {
                Logger.warn("trackId == 0 || trackNumber == 0");
            } else {
                int trackId = timelineTrack.getTrackId();
                if (linkedHashMap.containsKey(Integer.valueOf(trackId))) {
                    Logger.warn("duplicate trackId " + trackId);
                } else {
                    FileDescriptor fileDescriptorFindDescriptor = findDescriptor(listFindAllMeta2, timelineTrack.getTrackId());
                    if (fileDescriptorFindDescriptor == null) {
                        Logger.warn("No generic descriptor for track: " + timelineTrack.getTrackId());
                        if (listFindAllMeta2.size() == 1 && ((FileDescriptor) listFindAllMeta2.get(0)).getLinkedTrackId() == 0) {
                            fileDescriptorFindDescriptor = (FileDescriptor) listFindAllMeta2.get(0);
                        }
                    }
                    if (fileDescriptorFindDescriptor == null) {
                        Logger.warn("Track without descriptor: " + timelineTrack.getTrackId());
                    } else {
                        int trackNumber = timelineTrack.getTrackNumber();
                        MXFDemuxerTrack mXFDemuxerTrackCreateTrack = createTrack(UL.newULFromInts(new int[]{6, 14, 43, 52, 1, 2, 1, 1, 13, 1, 3, 1, (trackNumber >>> 24) & 255, (trackNumber >>> 16) & 255, (trackNumber >>> 8) & 255, trackNumber & 255}), timelineTrack, fileDescriptorFindDescriptor);
                        if (mXFDemuxerTrackCreateTrack.getCodec() != null || (fileDescriptorFindDescriptor instanceof WaveAudioDescriptor)) {
                            linkedHashMap.put(Integer.valueOf(trackId), mXFDemuxerTrackCreateTrack);
                        }
                    }
                }
            }
        }
        return (MXFDemuxerTrack[]) linkedHashMap.values().toArray(new MXFDemuxerTrack[linkedHashMap.size()]);
    }

    public MXFDemuxerTrack[] getAudioTracks() {
        ArrayList arrayList = new ArrayList();
        for (MXFDemuxerTrack mXFDemuxerTrack : this.tracks) {
            if (mXFDemuxerTrack.isAudio()) {
                arrayList.add(mXFDemuxerTrack);
            }
        }
        return (MXFDemuxerTrack[]) arrayList.toArray(new MXFDemuxerTrack[0]);
    }

    public List<MXFPartition> getEssencePartitions() {
        return this.partitions;
    }

    public List<IndexSegment> getIndexes() {
        return this.indexSegments;
    }

    public List<MXFMetadata> getMetadata() {
        return Collections.unmodifiableList(this.metadata);
    }

    public OP getOp() {
        UL op = this.header.getPack().getOp();
        for (OP op2 : OP.values()) {
            if (op.get(12) == op2.major && op.get(13) == op2.minor) {
                return op2;
            }
        }
        return OP.OPAtom;
    }

    public List<SourceClip> getSourceClips(int i) {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (MXFMetadata mXFMetadata : this.metadata) {
            if (mXFMetadata instanceof TimelineTrack) {
                z = ((TimelineTrack) mXFMetadata).getTrackId() == i;
            }
            if (z && (mXFMetadata instanceof SourceClip)) {
                SourceClip sourceClip = (SourceClip) mXFMetadata;
                if (sourceClip.getSourceTrackId() == i) {
                    arrayList.add(sourceClip);
                }
            }
        }
        return arrayList;
    }

    public TimecodeComponent getTimecode() {
        return this.timecode;
    }

    public MXFDemuxerTrack[] getTracks() {
        return this.tracks;
    }

    public MXFDemuxerTrack getVideoTrack() {
        for (MXFDemuxerTrack mXFDemuxerTrack : this.tracks) {
            if (mXFDemuxerTrack.isVideo()) {
                return mXFDemuxerTrack;
            }
        }
        return null;
    }

    public void parseHeader(SeekableByteChannel seekableByteChannel) throws IOException {
        this.header = readHeaderPartition(seekableByteChannel);
        this.metadata = new ArrayList();
        this.partitions = new ArrayList();
        long size = seekableByteChannel.size();
        seekableByteChannel.setPosition(this.header.getPack().getFooterPartition());
        do {
            long j = size;
            size = seekableByteChannel.position();
            KLV kl = KLV.readKL(seekableByteChannel);
            MXFPartition mXFPartition = MXFPartition.read(kl.key, NIOUtils.fetchFromChannel(seekableByteChannel, (int) kl.len), seekableByteChannel.position() - kl.offset, j);
            this.header = mXFPartition;
            if (mXFPartition.getPack().getNbEssenceContainers() > 0) {
                this.partitions.add(0, this.header);
            }
            this.metadata.addAll(0, readPartitionMeta(seekableByteChannel, this.header));
            seekableByteChannel.setPosition(this.header.getPack().getPrevPartition());
        } while (this.header.getPack().getThisPartition() != 0);
    }
}
