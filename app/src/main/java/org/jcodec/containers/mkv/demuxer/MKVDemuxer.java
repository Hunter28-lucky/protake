package org.jcodec.containers.mkv.demuxer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.mp4.AvcCBox;
import org.jcodec.common.Codec;
import org.jcodec.common.Demuxer;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.SeekableDemuxerTrack;
import org.jcodec.common.TrackType;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Size;
import org.jcodec.common.model.TapeTimecode;
import org.jcodec.containers.mkv.MKVParser;
import org.jcodec.containers.mkv.MKVType;
import org.jcodec.containers.mkv.boxes.EbmlBase;
import org.jcodec.containers.mkv.boxes.EbmlBin;
import org.jcodec.containers.mkv.boxes.EbmlFloat;
import org.jcodec.containers.mkv.boxes.EbmlMaster;
import org.jcodec.containers.mkv.boxes.EbmlString;
import org.jcodec.containers.mkv.boxes.EbmlUint;
import org.jcodec.containers.mkv.boxes.MkvBlock;

/* loaded from: classes2.dex */
public final class MKVDemuxer implements Demuxer {
    private static Map<String, Codec> codecMapping;
    private SeekableByteChannel channel;
    public int pictureHeight;
    public int pictureWidth;
    private List<EbmlMaster> t;
    private VideoTrack vTrack = null;
    public int timescale = 1;
    private List<AudioTrack> aTracks = new ArrayList();
    private List<SubtitlesTrack> subsTracks = new ArrayList();

    public static class AudioTrack extends MkvTrack {
        public double samplingFrequency;

        public AudioTrack(int i, MKVDemuxer mKVDemuxer) {
            super(i, mKVDemuxer);
        }

        @Override // org.jcodec.containers.mkv.demuxer.MKVDemuxer.MkvTrack
        public Packet getFrames(int i) throws IOException {
            MkvBlockData frameBlock = getFrameBlock(i);
            if (frameBlock == null) {
                return null;
            }
            return Packet.createPacket(frameBlock.data, frameBlock.block.absoluteTimecode, (int) Math.round(this.samplingFrequency), frameBlock.count, 0L, Packet.FrameType.KEY, TapeTimecode.ZERO_TAPE_TIMECODE);
        }

        @Override // org.jcodec.containers.mkv.demuxer.MKVDemuxer.MkvTrack, org.jcodec.common.DemuxerTrack
        public DemuxerTrackMeta getMeta() {
            return null;
        }

        @Override // org.jcodec.containers.mkv.demuxer.MKVDemuxer.MkvTrack, org.jcodec.common.SeekableDemuxerTrack
        public boolean gotoSyncFrame(long j) {
            return gotoFrame(j);
        }

        @Override // org.jcodec.containers.mkv.demuxer.MKVDemuxer.MkvTrack, org.jcodec.common.DemuxerTrack
        public Packet nextFrame() throws IOException {
            MkvBlockData mkvBlockDataNextBlock = nextBlock();
            if (mkvBlockDataNextBlock == null) {
                return null;
            }
            return Packet.createPacket(mkvBlockDataNextBlock.data, mkvBlockDataNextBlock.block.absoluteTimecode, (int) Math.round(this.samplingFrequency), 1L, 0L, Packet.FrameType.KEY, TapeTimecode.ZERO_TAPE_TIMECODE);
        }
    }

    public static class IndexedBlock {
        public MkvBlock block;
        public int firstFrameNo;

        public static IndexedBlock make(int i, MkvBlock mkvBlock) {
            IndexedBlock indexedBlock = new IndexedBlock();
            indexedBlock.firstFrameNo = i;
            indexedBlock.block = mkvBlock;
            return indexedBlock;
        }
    }

    public static class MkvBlockData {
        public final MkvBlock block;
        public final int count;
        public final ByteBuffer data;

        public MkvBlockData(MkvBlock mkvBlock, ByteBuffer byteBuffer, int i) {
            this.block = mkvBlock;
            this.data = byteBuffer;
            this.count = i;
        }
    }

    public static class MkvTrack implements SeekableDemuxerTrack {
        private MKVDemuxer demuxer;
        public final int trackNo;
        public int framesCount = 0;
        private int frameIdx = 0;
        private int blockIdx = 0;
        private int frameInBlockIdx = 0;
        public List<IndexedBlock> blocks = new ArrayList();

        public MkvTrack(int i, MKVDemuxer mKVDemuxer) {
            this.trackNo = i;
            this.demuxer = mKVDemuxer;
        }

        private int findBlockIndex(long j) {
            for (int i = 0; i < this.blocks.size(); i++) {
                if (j < this.blocks.get(i).block.frameSizes.length) {
                    return i;
                }
                j -= this.blocks.get(i).block.frameSizes.length;
            }
            return -1;
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public long getCurFrame() {
            return this.frameIdx;
        }

        public MkvBlockData getFrameBlock(int i) throws IOException {
            int iLimit;
            if (this.frameIdx + i >= this.framesCount) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            MkvBlock mkvBlock = this.blocks.get(this.blockIdx).block;
            while (true) {
                iLimit = 0;
                if (i <= 0) {
                    break;
                }
                MkvBlock mkvBlock2 = this.blocks.get(this.blockIdx).block;
                ByteBuffer[] byteBufferArr = mkvBlock2.frames;
                if (byteBufferArr == null || byteBufferArr.length == 0) {
                    try {
                        this.demuxer.channel.setPosition(mkvBlock2.dataOffset);
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(mkvBlock2.dataLen);
                        this.demuxer.channel.read(byteBufferAllocate);
                        mkvBlock2.readFrames(byteBufferAllocate);
                    } catch (IOException e2) {
                        throw new RuntimeException("while reading frames of a Block at offset 0x" + Long.toHexString(mkvBlock2.dataOffset).toUpperCase() + ")", e2);
                    }
                }
                arrayList.add(mkvBlock2.frames[this.frameInBlockIdx].duplicate());
                this.frameIdx++;
                int i2 = this.frameInBlockIdx + 1;
                this.frameInBlockIdx = i2;
                if (i2 >= mkvBlock2.frames.length) {
                    this.frameInBlockIdx = 0;
                    this.blockIdx++;
                }
                i--;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                iLimit += ((ByteBuffer) it.next()).limit();
            }
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(iLimit);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byteBufferAllocate2.put((ByteBuffer) it2.next());
            }
            return new MkvBlockData(mkvBlock, byteBufferAllocate2, arrayList.size());
        }

        public Packet getFrames(int i) throws IOException {
            MkvBlockData frameBlock = getFrameBlock(i);
            if (frameBlock == null) {
                return null;
            }
            return Packet.createPacket(frameBlock.data, frameBlock.block.absoluteTimecode, this.demuxer.timescale, frameBlock.count, 0L, Packet.FrameType.KEY, TapeTimecode.ZERO_TAPE_TIMECODE);
        }

        @Override // org.jcodec.common.DemuxerTrack
        public DemuxerTrackMeta getMeta() {
            return null;
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public boolean gotoFrame(long j) {
            int iFindBlockIndex;
            if (j > 2147483647L || j > this.framesCount || (iFindBlockIndex = findBlockIndex(j)) == -1) {
                return false;
            }
            int i = (int) j;
            this.frameIdx = i;
            this.blockIdx = iFindBlockIndex;
            this.frameInBlockIdx = i - this.blocks.get(iFindBlockIndex).firstFrameNo;
            return true;
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public boolean gotoSyncFrame(long j) {
            return gotoFrame(j);
        }

        public MkvBlockData nextBlock() throws IOException {
            if (this.frameIdx >= this.blocks.size() || this.blockIdx >= this.blocks.size()) {
                return null;
            }
            MkvBlock mkvBlock = this.blocks.get(this.blockIdx).block;
            if (mkvBlock == null) {
                throw new RuntimeException("Something somewhere went wrong.");
            }
            ByteBuffer[] byteBufferArr = mkvBlock.frames;
            if (byteBufferArr == null || byteBufferArr.length == 0) {
                this.demuxer.channel.setPosition(mkvBlock.dataOffset);
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(mkvBlock.dataLen);
                this.demuxer.channel.read(byteBufferAllocate);
                mkvBlock.readFrames(byteBufferAllocate);
            }
            ByteBuffer byteBufferDuplicate = mkvBlock.frames[this.frameInBlockIdx].duplicate();
            int i = this.frameInBlockIdx + 1;
            this.frameInBlockIdx = i;
            this.frameIdx++;
            if (i >= mkvBlock.frames.length) {
                this.blockIdx++;
                this.frameInBlockIdx = 0;
            }
            return new MkvBlockData(mkvBlock, byteBufferDuplicate, 1);
        }

        @Override // org.jcodec.common.DemuxerTrack
        public Packet nextFrame() throws IOException {
            MkvBlockData mkvBlockDataNextBlock = nextBlock();
            if (mkvBlockDataNextBlock == null) {
                return null;
            }
            return Packet.createPacket(mkvBlockDataNextBlock.data, mkvBlockDataNextBlock.block.absoluteTimecode, this.demuxer.timescale, 1L, this.frameIdx - 1, Packet.FrameType.KEY, TapeTimecode.ZERO_TAPE_TIMECODE);
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public void seek(double d) {
            throw new RuntimeException("Not implemented yet");
        }
    }

    public static class SubtitlesTrack extends MkvTrack {
        public SubtitlesTrack(int i, MKVDemuxer mKVDemuxer) {
            super(i, mKVDemuxer);
        }
    }

    public static class VideoTrack implements SeekableDemuxerTrack {
        private AvcCBox avcC;
        private Codec codec;
        private MKVDemuxer demuxer;
        private ByteBuffer state;
        public final int trackNo;
        private int frameIdx = 0;
        public List<MkvBlock> blocks = new ArrayList();

        public VideoTrack(MKVDemuxer mKVDemuxer, int i, ByteBuffer byteBuffer, Codec codec) {
            this.demuxer = mKVDemuxer;
            this.trackNo = i;
            this.codec = codec;
            if (codec != Codec.H264) {
                this.state = byteBuffer;
                return;
            }
            AvcCBox aVCCFromBuffer = H264Utils.parseAVCCFromBuffer(byteBuffer);
            this.avcC = aVCCFromBuffer;
            this.state = H264Utils.avcCToAnnexB(aVCCFromBuffer);
        }

        public ByteBuffer getCodecState() {
            return this.state;
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public long getCurFrame() {
            return this.frameIdx;
        }

        public int getFrameCount() {
            return this.blocks.size();
        }

        @Override // org.jcodec.common.DemuxerTrack
        public DemuxerTrackMeta getMeta() {
            TrackType trackType = TrackType.VIDEO;
            Codec codec = this.codec;
            ByteBuffer byteBuffer = this.state;
            MKVDemuxer mKVDemuxer = this.demuxer;
            return new DemuxerTrackMeta(trackType, codec, 0.0d, null, 0, byteBuffer, VideoCodecMeta.createSimpleVideoCodecMeta(new Size(mKVDemuxer.pictureWidth, mKVDemuxer.pictureHeight), ColorSpace.YUV420), null);
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public boolean gotoFrame(long j) {
            if (j > 2147483647L || j > this.blocks.size()) {
                return false;
            }
            this.frameIdx = (int) j;
            return true;
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public boolean gotoSyncFrame(long j) {
            throw new RuntimeException("Unsupported");
        }

        @Override // org.jcodec.common.DemuxerTrack
        public Packet nextFrame() throws IOException {
            if (this.frameIdx >= this.blocks.size()) {
                return null;
            }
            MkvBlock mkvBlock = this.blocks.get(this.frameIdx);
            if (mkvBlock == null) {
                throw new RuntimeException("Something somewhere went wrong.");
            }
            this.frameIdx++;
            this.demuxer.channel.setPosition(mkvBlock.dataOffset);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(mkvBlock.dataLen);
            this.demuxer.channel.read(byteBufferAllocate);
            byteBufferAllocate.flip();
            mkvBlock.readFrames(byteBufferAllocate.duplicate());
            long j = this.frameIdx < this.blocks.size() ? this.blocks.get(this.frameIdx).absoluteTimecode - mkvBlock.absoluteTimecode : 1L;
            ByteBuffer byteBufferDuplicate = mkvBlock.frames[0].duplicate();
            if (this.codec == Codec.H264) {
                byteBufferDuplicate = H264Utils.decodeMOVPacket(byteBufferDuplicate, this.avcC);
            }
            return Packet.createPacket(byteBufferDuplicate, mkvBlock.absoluteTimecode, this.demuxer.timescale, j, this.frameIdx - 1, mkvBlock._keyFrame ? Packet.FrameType.KEY : Packet.FrameType.INTER, TapeTimecode.ZERO_TAPE_TIMECODE);
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public void seek(double d) {
            throw new RuntimeException("Not implemented yet");
        }
    }

    static {
        HashMap map = new HashMap();
        codecMapping = map;
        map.put("V_VP8", Codec.VP8);
        codecMapping.put("V_VP9", Codec.VP9);
        codecMapping.put("V_MPEG4/ISO/AVC", Codec.H264);
    }

    public MKVDemuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        this.channel = seekableByteChannel;
        this.t = new MKVParser(this.channel).parse();
        demux();
    }

    private void demux() {
        Class<EbmlMaster> cls;
        Iterator it;
        Class<EbmlMaster> cls2 = EbmlMaster.class;
        MKVType mKVType = MKVType.Segment;
        int i = 2;
        EbmlUint ebmlUint = (EbmlUint) MKVType.findFirstTree(this.t, new MKVType[]{mKVType, MKVType.Info, MKVType.TimecodeScale});
        if (ebmlUint != null) {
            this.timescale = (int) ebmlUint.getUint();
        }
        Iterator it2 = MKVType.findList(this.t, cls2, new MKVType[]{mKVType, MKVType.Tracks, MKVType.TrackEntry}).iterator();
        while (it2.hasNext()) {
            EbmlMaster ebmlMaster = (EbmlMaster) it2.next();
            MKVType[] mKVTypeArr = new MKVType[i];
            MKVType mKVType2 = MKVType.TrackEntry;
            mKVTypeArr[0] = mKVType2;
            mKVTypeArr[1] = MKVType.TrackType;
            long uint = ((EbmlUint) MKVType.findFirst(ebmlMaster, mKVTypeArr)).getUint();
            MKVType[] mKVTypeArr2 = new MKVType[i];
            mKVTypeArr2[0] = mKVType2;
            mKVTypeArr2[1] = MKVType.TrackNumber;
            long uint2 = ((EbmlUint) MKVType.findFirst(ebmlMaster, mKVTypeArr2)).getUint();
            if (uint != 1) {
                cls = cls2;
                it = it2;
                if (uint == 2) {
                    AudioTrack audioTrack = new AudioTrack((int) uint2, this);
                    EbmlFloat ebmlFloat = (EbmlFloat) MKVType.findFirst(ebmlMaster, new MKVType[]{mKVType2, MKVType.Audio, MKVType.SamplingFrequency});
                    if (ebmlFloat != null) {
                        audioTrack.samplingFrequency = ebmlFloat.getDouble();
                    }
                    this.aTracks.add(audioTrack);
                } else if (uint == 17) {
                    this.subsTracks.add(new SubtitlesTrack((int) uint2, this));
                }
            } else {
                if (this.vTrack != null) {
                    throw new RuntimeException("More then 1 video track, can not compute...");
                }
                MKVType[] mKVTypeArr3 = new MKVType[i];
                mKVTypeArr3[0] = mKVType2;
                mKVTypeArr3[1] = MKVType.CodecPrivate;
                MKVType[] mKVTypeArr4 = new MKVType[i];
                mKVTypeArr4[0] = mKVType2;
                mKVTypeArr4[1] = MKVType.CodecID;
                Codec codec = codecMapping.get(((EbmlString) MKVType.findFirst(ebmlMaster, mKVTypeArr4)).getString());
                EbmlBin ebmlBin = (EbmlBin) MKVType.findFirst(ebmlMaster, mKVTypeArr3);
                ByteBuffer byteBuffer = ebmlBin != null ? ebmlBin.data : null;
                MKVType[] mKVTypeArr5 = new MKVType[3];
                mKVTypeArr5[0] = mKVType2;
                MKVType mKVType3 = MKVType.Video;
                mKVTypeArr5[1] = mKVType3;
                mKVTypeArr5[i] = MKVType.PixelWidth;
                EbmlUint ebmlUint2 = (EbmlUint) MKVType.findFirst(ebmlMaster, mKVTypeArr5);
                MKVType[] mKVTypeArr6 = new MKVType[3];
                mKVTypeArr6[0] = mKVType2;
                mKVTypeArr6[1] = mKVType3;
                mKVTypeArr6[i] = MKVType.PixelHeight;
                EbmlUint ebmlUint3 = (EbmlUint) MKVType.findFirst(ebmlMaster, mKVTypeArr6);
                EbmlUint ebmlUint4 = (EbmlUint) MKVType.findFirst(ebmlMaster, new MKVType[]{mKVType2, mKVType3, MKVType.DisplayWidth});
                it = it2;
                EbmlUint ebmlUint5 = (EbmlUint) MKVType.findFirst(ebmlMaster, new MKVType[]{mKVType2, mKVType3, MKVType.DisplayHeight});
                cls = cls2;
                EbmlUint ebmlUint6 = (EbmlUint) MKVType.findFirst(ebmlMaster, new MKVType[]{mKVType2, mKVType3, MKVType.DisplayUnit});
                if (ebmlUint2 != null && ebmlUint3 != null) {
                    this.pictureWidth = (int) ebmlUint2.getUint();
                    this.pictureHeight = (int) ebmlUint3.getUint();
                } else if (ebmlUint4 != null && ebmlUint5 != null) {
                    if (ebmlUint6 != null && ebmlUint6.getUint() != 0) {
                        throw new RuntimeException("DisplayUnits other then 0 are not implemented yet");
                    }
                    this.pictureHeight = (int) ebmlUint5.getUint();
                    this.pictureWidth = (int) ebmlUint4.getUint();
                }
                this.vTrack = new VideoTrack(this, (int) uint2, byteBuffer, codec);
            }
            it2 = it;
            cls2 = cls;
            i = 2;
        }
        MKVType[] mKVTypeArr7 = new MKVType[i];
        mKVTypeArr7[0] = MKVType.Segment;
        mKVTypeArr7[1] = MKVType.Cluster;
        for (EbmlMaster ebmlMaster2 : MKVType.findList(this.t, cls2, mKVTypeArr7)) {
            long uint3 = ((EbmlUint) MKVType.findFirst(ebmlMaster2, new MKVType[]{MKVType.Cluster, MKVType.Timecode})).getUint();
            Iterator<EbmlBase> it3 = ebmlMaster2.children.iterator();
            while (it3.hasNext()) {
                EbmlBase next = it3.next();
                if (MKVType.SimpleBlock.equals(next.type)) {
                    MkvBlock mkvBlock = (MkvBlock) next;
                    mkvBlock.absoluteTimecode = mkvBlock.timecode + uint3;
                    putIntoRightBasket(mkvBlock);
                } else if (MKVType.BlockGroup.equals(next.type)) {
                    Iterator<EbmlBase> it4 = ((EbmlMaster) next).children.iterator();
                    while (it4.hasNext()) {
                        EbmlBase next2 = it4.next();
                        if (next2.type == MKVType.Block) {
                            MkvBlock mkvBlock2 = (MkvBlock) next2;
                            mkvBlock2.absoluteTimecode = mkvBlock2.timecode + uint3;
                            putIntoRightBasket(mkvBlock2);
                        }
                    }
                }
            }
        }
    }

    private void putIntoRightBasket(MkvBlock mkvBlock) {
        long j = mkvBlock.trackNumber;
        VideoTrack videoTrack = this.vTrack;
        if (j == videoTrack.trackNo) {
            videoTrack.blocks.add(mkvBlock);
            return;
        }
        for (int i = 0; i < this.aTracks.size(); i++) {
            AudioTrack audioTrack = this.aTracks.get(i);
            if (mkvBlock.trackNumber == audioTrack.trackNo) {
                audioTrack.blocks.add(IndexedBlock.make(audioTrack.framesCount, mkvBlock));
                audioTrack.framesCount += mkvBlock.frameSizes.length;
            }
        }
        for (int i2 = 0; i2 < this.subsTracks.size(); i2++) {
            SubtitlesTrack subtitlesTrack = this.subsTracks.get(i2);
            if (mkvBlock.trackNumber == subtitlesTrack.trackNo) {
                subtitlesTrack.blocks.add(IndexedBlock.make(subtitlesTrack.framesCount, mkvBlock));
                subtitlesTrack.framesCount += mkvBlock.frameSizes.length;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.channel.close();
    }

    @Override // org.jcodec.common.Demuxer
    public List<DemuxerTrack> getAudioTracks() {
        return this.aTracks;
    }

    public int getPictureHeight() {
        return this.pictureHeight;
    }

    public int getPictureWidth() {
        return this.pictureWidth;
    }

    public List<DemuxerTrack> getSubtitleTracks() {
        return this.subsTracks;
    }

    @Override // org.jcodec.common.Demuxer
    public List<DemuxerTrack> getTracks() {
        ArrayList arrayList = new ArrayList(this.aTracks);
        arrayList.add(this.vTrack);
        arrayList.addAll(this.subsTracks);
        return arrayList;
    }

    public List<? extends EbmlBase> getTree() {
        return this.t;
    }

    @Override // org.jcodec.common.Demuxer
    public List<DemuxerTrack> getVideoTracks() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.vTrack);
        return arrayList;
    }
}
