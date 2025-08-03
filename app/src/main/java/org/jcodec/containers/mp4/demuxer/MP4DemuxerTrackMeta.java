package org.jcodec.containers.mp4.demuxer;

import java.nio.ByteBuffer;
import java.util.List;
import org.jcodec.codecs.aac.AACUtils;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.Codec;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.Ints;
import org.jcodec.common.TrackType;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.RationalLarge;
import org.jcodec.containers.mp4.MP4TrackType;
import org.jcodec.containers.mp4.boxes.AudioSampleEntry;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.PixelAspectExt;
import org.jcodec.containers.mp4.boxes.SyncSamplesBox;
import org.jcodec.containers.mp4.boxes.TrackHeaderBox;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.containers.mp4.boxes.VideoSampleEntry;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class MP4DemuxerTrackMeta {
    public static DemuxerTrackMeta fromTrack(AbstractMP4DemuxerTrack abstractMP4DemuxerTrack) {
        int[] iArrCopyOfInt;
        VideoCodecMeta videoCodecMeta;
        AudioCodecMeta audioCodecMetaFromAudioFormat;
        TrakBox box = abstractMP4DemuxerTrack.getBox();
        SyncSamplesBox syncSamplesBox = (SyncSamplesBox) NodeBox.findFirstPath(box, SyncSamplesBox.class, Box.path("mdia.minf.stbl.stss"));
        int[] syncSamples = syncSamplesBox == null ? null : syncSamplesBox.getSyncSamples();
        if (syncSamples == null) {
            int frameCount = (int) abstractMP4DemuxerTrack.getFrameCount();
            iArrCopyOfInt = new int[frameCount];
            for (int i = 0; i < frameCount; i++) {
                iArrCopyOfInt[i] = i;
            }
        } else {
            iArrCopyOfInt = Platform.copyOfInt(syncSamples, syncSamples.length);
            for (int i2 = 0; i2 < iArrCopyOfInt.length; i2++) {
                iArrCopyOfInt[i2] = iArrCopyOfInt[i2] - 1;
            }
        }
        int[] iArr = iArrCopyOfInt;
        MP4TrackType type = abstractMP4DemuxerTrack.getType();
        MP4TrackType mP4TrackType = MP4TrackType.VIDEO;
        TrackType trackType = type == mP4TrackType ? TrackType.VIDEO : type == MP4TrackType.SOUND ? TrackType.AUDIO : TrackType.OTHER;
        if (type == mP4TrackType) {
            VideoCodecMeta videoCodecMetaCreateSimpleVideoCodecMeta = VideoCodecMeta.createSimpleVideoCodecMeta(box.getCodedSize(), getColorInfo(abstractMP4DemuxerTrack));
            PixelAspectExt pixelAspectExt = (PixelAspectExt) NodeBox.findFirst(abstractMP4DemuxerTrack.getSampleEntries()[0], PixelAspectExt.class, "pasp");
            if (pixelAspectExt != null) {
                videoCodecMetaCreateSimpleVideoCodecMeta.setPixelAspectRatio(pixelAspectExt.getRational());
            }
            audioCodecMetaFromAudioFormat = null;
            videoCodecMeta = videoCodecMetaCreateSimpleVideoCodecMeta;
        } else if (type == MP4TrackType.SOUND) {
            videoCodecMeta = null;
            audioCodecMetaFromAudioFormat = AudioCodecMeta.fromAudioFormat(((AudioSampleEntry) abstractMP4DemuxerTrack.getSampleEntries()[0]).getFormat());
        } else {
            videoCodecMeta = null;
            audioCodecMetaFromAudioFormat = null;
        }
        RationalLarge duration = abstractMP4DemuxerTrack.getDuration();
        DemuxerTrackMeta demuxerTrackMeta = new DemuxerTrackMeta(trackType, Codec.codecByFourcc(abstractMP4DemuxerTrack.getFourcc()), duration.getNum() / duration.getDen(), iArr, Ints.checkedCast(abstractMP4DemuxerTrack.getFrameCount()), getCodecPrivate(abstractMP4DemuxerTrack), videoCodecMeta, audioCodecMetaFromAudioFormat);
        if (type == mP4TrackType) {
            TrackHeaderBox trackHeaderBox = (TrackHeaderBox) NodeBox.findFirstPath(box, TrackHeaderBox.class, Box.path("tkhd"));
            demuxerTrackMeta.setOrientation(trackHeaderBox.isOrientation90() ? DemuxerTrackMeta.Orientation.D_90 : trackHeaderBox.isOrientation180() ? DemuxerTrackMeta.Orientation.D_180 : trackHeaderBox.isOrientation270() ? DemuxerTrackMeta.Orientation.D_270 : DemuxerTrackMeta.Orientation.D_0);
        }
        return demuxerTrackMeta;
    }

    public static ByteBuffer getCodecPrivate(AbstractMP4DemuxerTrack abstractMP4DemuxerTrack) {
        Codec codecCodecByFourcc = Codec.codecByFourcc(abstractMP4DemuxerTrack.getFourcc());
        if (codecCodecByFourcc == Codec.H264) {
            return H264Utils.avcCToAnnexB(H264Utils.parseAVCC((VideoSampleEntry) abstractMP4DemuxerTrack.getSampleEntries()[0]));
        }
        if (codecCodecByFourcc == Codec.AAC) {
            return AACUtils.getCodecPrivate(abstractMP4DemuxerTrack.getSampleEntries()[0]);
        }
        return null;
    }

    public static ColorSpace getColorInfo(AbstractMP4DemuxerTrack abstractMP4DemuxerTrack) {
        if (Codec.codecByFourcc(abstractMP4DemuxerTrack.getFourcc()) != Codec.H264) {
            return null;
        }
        List<ByteBuffer> spsList = H264Utils.parseAVCC((VideoSampleEntry) abstractMP4DemuxerTrack.getSampleEntries()[0]).getSpsList();
        if (spsList.size() > 0) {
            return SeqParameterSet.read(spsList.get(0).duplicate()).getChromaFormatIdc();
        }
        return null;
    }
}
