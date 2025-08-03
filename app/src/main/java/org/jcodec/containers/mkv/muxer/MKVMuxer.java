package org.jcodec.containers.mkv.muxer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.Codec;
import org.jcodec.common.Muxer;
import org.jcodec.common.MuxerTrack;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mkv.CuesFactory;
import org.jcodec.containers.mkv.MKVType;
import org.jcodec.containers.mkv.SeekHeadFactory;
import org.jcodec.containers.mkv.boxes.EbmlBase;
import org.jcodec.containers.mkv.boxes.EbmlBin;
import org.jcodec.containers.mkv.boxes.EbmlDate;
import org.jcodec.containers.mkv.boxes.EbmlFloat;
import org.jcodec.containers.mkv.boxes.EbmlMaster;
import org.jcodec.containers.mkv.boxes.EbmlString;
import org.jcodec.containers.mkv.boxes.EbmlUint;
import org.jcodec.containers.mkv.boxes.MkvBlock;
import org.jcodec.containers.mkv.muxer.MKVMuxerTrack;

/* loaded from: classes2.dex */
public class MKVMuxer implements Muxer {
    private static Map<Codec, String> codec2mkv;
    private MKVMuxerTrack audioTrack;
    private EbmlMaster mkvCues;
    private EbmlMaster mkvInfo;
    private EbmlMaster mkvSeekHead;
    private EbmlMaster mkvTracks;
    private SeekableByteChannel sink;
    private MKVMuxerTrack videoTrack;
    private List<MKVMuxerTrack> tracks = new ArrayList();
    private List<EbmlMaster> clusterList = new LinkedList();

    static {
        HashMap map = new HashMap();
        codec2mkv = map;
        map.put(Codec.H264, "V_MPEG4/ISO/AVC");
        codec2mkv.put(Codec.VP8, "V_VP8");
        codec2mkv.put(Codec.VP9, "V_VP9");
    }

    public MKVMuxer(SeekableByteChannel seekableByteChannel) {
        this.sink = seekableByteChannel;
    }

    public static void createBuffer(EbmlMaster ebmlMaster, MKVType mKVType, ByteBuffer byteBuffer) {
        EbmlBin ebmlBin = (EbmlBin) MKVType.createByType(mKVType);
        ebmlBin.setBuf(byteBuffer);
        ebmlMaster.add(ebmlBin);
    }

    public static void createDate(EbmlMaster ebmlMaster, MKVType mKVType, Date date) {
        EbmlDate ebmlDate = (EbmlDate) MKVType.createByType(mKVType);
        ebmlDate.setDate(date);
        ebmlMaster.add(ebmlDate);
    }

    public static void createDouble(EbmlMaster ebmlMaster, MKVType mKVType, double d) {
        try {
            EbmlFloat ebmlFloat = (EbmlFloat) MKVType.createByType(mKVType);
            ebmlFloat.setDouble(d);
            ebmlMaster.add(ebmlFloat);
        } catch (ClassCastException e2) {
            throw new RuntimeException("Element of type " + mKVType + " can't be cast to EbmlFloat", e2);
        }
    }

    public static void createLong(EbmlMaster ebmlMaster, MKVType mKVType, long j) {
        EbmlUint ebmlUint = (EbmlUint) MKVType.createByType(mKVType);
        ebmlUint.setUint(j);
        ebmlMaster.add(ebmlUint);
    }

    public static void createString(EbmlMaster ebmlMaster, MKVType mKVType, String str) {
        EbmlString ebmlString = (EbmlString) MKVType.createByType(mKVType);
        ebmlString.setString(str);
        ebmlMaster.add(ebmlString);
    }

    private EbmlMaster defaultEbmlHeader() {
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.EBML);
        createLong(ebmlMaster, MKVType.EBMLVersion, 1L);
        createLong(ebmlMaster, MKVType.EBMLReadVersion, 1L);
        createLong(ebmlMaster, MKVType.EBMLMaxIDLength, 4L);
        createLong(ebmlMaster, MKVType.EBMLMaxSizeLength, 8L);
        createString(ebmlMaster, MKVType.DocType, "webm");
        createLong(ebmlMaster, MKVType.DocTypeVersion, 2L);
        createLong(ebmlMaster, MKVType.DocTypeReadVersion, 2L);
        return ebmlMaster;
    }

    private void muxCues() {
        CuesFactory cuesFactory = new CuesFactory(this.mkvSeekHead.size() + this.mkvInfo.size() + this.mkvTracks.size(), this.videoTrack.trackNo);
        Iterator<MkvBlock> it = this.videoTrack.trackBlocks.iterator();
        while (it.hasNext()) {
            EbmlMaster ebmlMasterSingleBlockedCluster = singleBlockedCluster(it.next());
            this.clusterList.add(ebmlMasterSingleBlockedCluster);
            cuesFactory.add(CuesFactory.CuePointMock.make(ebmlMasterSingleBlockedCluster));
        }
        Iterator<EbmlBase> it2 = cuesFactory.createCues().children.iterator();
        while (it2.hasNext()) {
            this.mkvCues.add(it2.next());
        }
    }

    private EbmlMaster muxInfo() {
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.Info);
        createLong(ebmlMaster, MKVType.TimecodeScale, 40000000);
        createString(ebmlMaster, MKVType.WritingApp, "JCodec");
        createString(ebmlMaster, MKVType.MuxingApp, "JCodec");
        Iterator<MKVMuxerTrack> it = this.tracks.iterator();
        long j = 0;
        while (it.hasNext()) {
            long j2 = it.next().trackBlocks.get(r6.size() - 1).absoluteTimecode;
            if (j2 > j) {
                j = j2;
            }
        }
        createDouble(ebmlMaster, MKVType.Duration, (j + 1) * r2 * 1.0d);
        createDate(ebmlMaster, MKVType.DateUTC, new Date());
        return ebmlMaster;
    }

    private EbmlMaster muxSeekHead() {
        SeekHeadFactory seekHeadFactory = new SeekHeadFactory();
        seekHeadFactory.add(this.mkvInfo);
        seekHeadFactory.add(this.mkvTracks);
        seekHeadFactory.add(this.mkvCues);
        return seekHeadFactory.indexSeekHead();
    }

    private EbmlMaster muxTracks() {
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.Tracks);
        for (int i = 0; i < this.tracks.size(); i++) {
            MKVMuxerTrack mKVMuxerTrack = this.tracks.get(i);
            EbmlMaster ebmlMaster2 = (EbmlMaster) MKVType.createByType(MKVType.TrackEntry);
            createLong(ebmlMaster2, MKVType.TrackNumber, mKVMuxerTrack.trackNo);
            createLong(ebmlMaster2, MKVType.TrackUID, mKVMuxerTrack.trackNo);
            if (MKVMuxerTrack.MKVMuxerTrackType.VIDEO.equals(mKVMuxerTrack.type)) {
                createLong(ebmlMaster2, MKVType.TrackType, 1L);
                createString(ebmlMaster2, MKVType.Name, "Track " + (i + 1) + " Video");
                createString(ebmlMaster2, MKVType.CodecID, mKVMuxerTrack.codecId);
                EbmlMaster ebmlMaster3 = (EbmlMaster) MKVType.createByType(MKVType.Video);
                createLong(ebmlMaster3, MKVType.PixelWidth, (long) mKVMuxerTrack.videoMeta.getSize().getWidth());
                createLong(ebmlMaster3, MKVType.PixelHeight, (long) mKVMuxerTrack.videoMeta.getSize().getHeight());
                ebmlMaster2.add(ebmlMaster3);
            } else {
                createLong(ebmlMaster2, MKVType.TrackType, 2L);
                createString(ebmlMaster2, MKVType.Name, "Track " + (i + 1) + " Audio");
                createString(ebmlMaster2, MKVType.CodecID, mKVMuxerTrack.codecId);
            }
            ebmlMaster.add(ebmlMaster2);
        }
        return ebmlMaster;
    }

    private EbmlMaster singleBlockedCluster(MkvBlock mkvBlock) {
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.Cluster);
        createLong(ebmlMaster, MKVType.Timecode, mkvBlock.absoluteTimecode - mkvBlock.timecode);
        ebmlMaster.add(mkvBlock);
        return ebmlMaster;
    }

    @Override // org.jcodec.common.Muxer
    public MuxerTrack addAudioTrack(Codec codec, AudioCodecMeta audioCodecMeta) {
        MKVMuxerTrack mKVMuxerTrack = new MKVMuxerTrack();
        this.audioTrack = mKVMuxerTrack;
        this.tracks.add(mKVMuxerTrack);
        this.audioTrack.codecId = codec2mkv.get(codec);
        this.audioTrack.trackNo = this.tracks.size();
        return this.audioTrack;
    }

    @Override // org.jcodec.common.Muxer
    public MuxerTrack addVideoTrack(Codec codec, VideoCodecMeta videoCodecMeta) {
        return createVideoTrack(videoCodecMeta, codec2mkv.get(codec));
    }

    public MKVMuxerTrack createVideoTrack(VideoCodecMeta videoCodecMeta, String str) {
        if (this.videoTrack == null) {
            MKVMuxerTrack mKVMuxerTrack = new MKVMuxerTrack();
            this.videoTrack = mKVMuxerTrack;
            this.tracks.add(mKVMuxerTrack);
            MKVMuxerTrack mKVMuxerTrack2 = this.videoTrack;
            mKVMuxerTrack2.codecId = str;
            mKVMuxerTrack2.videoMeta = videoCodecMeta;
            mKVMuxerTrack2.trackNo = this.tracks.size();
        }
        return this.videoTrack;
    }

    @Override // org.jcodec.common.Muxer
    public void finish() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(defaultEbmlHeader());
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.Segment);
        this.mkvInfo = muxInfo();
        this.mkvTracks = muxTracks();
        this.mkvCues = (EbmlMaster) MKVType.createByType(MKVType.Cues);
        this.mkvSeekHead = muxSeekHead();
        muxCues();
        ebmlMaster.add(this.mkvSeekHead);
        ebmlMaster.add(this.mkvInfo);
        ebmlMaster.add(this.mkvTracks);
        ebmlMaster.add(this.mkvCues);
        Iterator<EbmlMaster> it = this.clusterList.iterator();
        while (it.hasNext()) {
            ebmlMaster.add(it.next());
        }
        arrayList.add(ebmlMaster);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((EbmlMaster) it2.next()).mux(this.sink);
        }
    }
}
