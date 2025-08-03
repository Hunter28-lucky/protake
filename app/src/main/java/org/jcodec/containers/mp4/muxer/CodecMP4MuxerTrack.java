package org.jcodec.containers.mp4.muxer;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jcodec.codecs.aac.ADTSParser;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.mpeg4.mp4.EsdsBox;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.Codec;
import org.jcodec.common.Preconditions;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Packet;
import org.jcodec.containers.mp4.MP4TrackType;
import org.jcodec.containers.mp4.boxes.AudioSampleEntry;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.MovieHeaderBox;
import org.jcodec.containers.mp4.boxes.PixelAspectExt;
import org.jcodec.containers.mp4.boxes.VideoSampleEntry;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class CodecMP4MuxerTrack extends MP4MuxerTrack {
    private static Map<Codec, String> codec2fourcc;
    private ADTSParser.Header adtsHeader;
    private Codec codec;
    private List<ByteBuffer> ppsList;
    private List<ByteBuffer> spsList;

    public static class ByteArrayWrapper {
        private byte[] bytes;

        public ByteArrayWrapper(ByteBuffer byteBuffer) {
            this.bytes = NIOUtils.toArray(byteBuffer);
        }

        public boolean equals(Object obj) {
            if (obj instanceof ByteArrayWrapper) {
                return Platform.arrayEqualsByte(this.bytes, ((ByteArrayWrapper) obj).bytes);
            }
            return false;
        }

        public ByteBuffer get() {
            return ByteBuffer.wrap(this.bytes);
        }

        public int hashCode() {
            return Arrays.hashCode(this.bytes);
        }
    }

    static {
        HashMap map = new HashMap();
        codec2fourcc = map;
        map.put(Codec.MP1, ".mp1");
        codec2fourcc.put(Codec.MP2, ".mp2");
        codec2fourcc.put(Codec.MP3, ".mp3");
        codec2fourcc.put(Codec.H264, "avc1");
        codec2fourcc.put(Codec.AAC, "mp4a");
        codec2fourcc.put(Codec.PRORES, "apch");
        codec2fourcc.put(Codec.JPEG, "mjpg");
        codec2fourcc.put(Codec.PNG, "png ");
        codec2fourcc.put(Codec.V210, "v210");
    }

    public CodecMP4MuxerTrack(int i, MP4TrackType mP4TrackType, Codec codec) {
        super(i, mP4TrackType);
        this.codec = codec;
        this.spsList = new ArrayList();
        this.ppsList = new ArrayList();
    }

    private static List<ByteBuffer> selectUnique(List<ByteBuffer> list) {
        HashSet hashSet = new HashSet();
        Iterator<ByteBuffer> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(new ByteArrayWrapper(it.next()));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(((ByteArrayWrapper) it2.next()).get());
        }
        return arrayList;
    }

    public void addAudioSampleEntry(AudioFormat audioFormat) {
        addSampleEntry(AudioSampleEntry.compressedAudioSampleEntry(codec2fourcc.get(this.codec), 1, 16, audioFormat.getChannels(), audioFormat.getSampleRate(), 0, 0, 0));
    }

    @Override // org.jcodec.containers.mp4.muxer.MP4MuxerTrack, org.jcodec.common.MuxerTrack
    public void addFrame(Packet packet) throws IOException {
        Codec codec = this.codec;
        if (codec == Codec.H264) {
            ByteBuffer data = packet.getData();
            if (packet.frameType == Packet.FrameType.UNKNOWN) {
                packet.setFrameType(H264Utils.isByteBufferIDRSlice(data) ? Packet.FrameType.KEY : Packet.FrameType.INTER);
            }
            H264Utils.wipePSinplace(data, this.spsList, this.ppsList);
            packet = Packet.createPacketWithData(packet, H264Utils.encodeMOVPacket(data));
        } else if (codec == Codec.AAC) {
            ByteBuffer data2 = packet.getData();
            this.adtsHeader = ADTSParser.read(data2);
            packet = Packet.createPacketWithData(packet, data2);
        }
        super.addFrame(packet);
    }

    @Override // org.jcodec.containers.mp4.muxer.MP4MuxerTrack
    public void addFrameInternal(Packet packet, int i) throws IOException {
        Preconditions.checkState(!this.finished, "The muxer track has finished muxing");
        if (this._timescale == -1) {
            ADTSParser.Header header = this.adtsHeader;
            if (header != null) {
                this._timescale = header.getSampleRate();
            } else {
                this._timescale = packet.getTimescale();
            }
        }
        if (this._timescale != packet.getTimescale()) {
            packet.setPts((packet.getPts() * this._timescale) / packet.getTimescale());
            packet.setDuration((packet.getPts() * this._timescale) / packet.getDuration());
        }
        if (this.adtsHeader != null) {
            packet.setDuration(ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
        }
        super.addFrameInternal(packet, i);
    }

    public void addVideoSampleEntry(VideoCodecMeta videoCodecMeta) {
        VideoSampleEntry videoSampleEntry = VideoSampleEntry.videoSampleEntry(codec2fourcc.get(this.codec), videoCodecMeta.getSize(), "JCodec");
        if (videoCodecMeta.getPixelAspectRatio() != null) {
            videoSampleEntry.add(PixelAspectExt.createPixelAspectExt(videoCodecMeta.getPixelAspectRatio()));
        }
        addSampleEntry(videoSampleEntry);
    }

    @Override // org.jcodec.containers.mp4.muxer.MP4MuxerTrack, org.jcodec.containers.mp4.muxer.AbstractMP4MuxerTrack
    public Box finish(MovieHeaderBox movieHeaderBox) throws IOException {
        Preconditions.checkState(!this.finished, "The muxer track has finished muxing");
        if (getEntries().isEmpty()) {
            if (this.codec != Codec.H264 || this.spsList.isEmpty()) {
                Logger.warn("CodecMP4MuxerTrack: Creating a track without sample entry");
            } else {
                addVideoSampleEntry(VideoCodecMeta.createSimpleVideoCodecMeta(H264Utils.getPicSize(SeqParameterSet.read(this.spsList.get(0).duplicate())), ColorSpace.YUV420));
            }
        }
        setCodecPrivateIfNeeded();
        return super.finish(movieHeaderBox);
    }

    public void setCodecPrivateIfNeeded() {
        Codec codec = this.codec;
        if (codec != Codec.H264) {
            if (codec == Codec.AAC) {
                if (this.adtsHeader != null) {
                    getEntries().get(0).add(EsdsBox.fromADTS(this.adtsHeader));
                    return;
                } else {
                    Logger.warn("CodecMP4MuxerTrack: Not adding a sample entry for AAC track, missing any ADTS headers.");
                    return;
                }
            }
            return;
        }
        List<ByteBuffer> listSelectUnique = selectUnique(this.spsList);
        List<ByteBuffer> listSelectUnique2 = selectUnique(this.ppsList);
        if (listSelectUnique.isEmpty() || listSelectUnique2.isEmpty()) {
            Logger.warn("CodecMP4MuxerTrack: Not adding a sample entry for h.264 track, missing any SPS/PPS NAL units");
        } else {
            getEntries().get(0).add(H264Utils.createAvcCFromPS(listSelectUnique, listSelectUnique2, 4));
        }
    }
}
