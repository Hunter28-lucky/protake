package org.jcodec.api.transcode;

import com.blink.academy.film.support.stream.ts.TsConstants;
import com.google.android.gms.common.Scopes;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jcodec.api.transcode.Transcoder;
import org.jcodec.api.transcode.filters.ScaleFilter;
import org.jcodec.common.Codec;
import org.jcodec.common.Demuxer;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.Format;
import org.jcodec.common.JCodecUtil;
import org.jcodec.common.TrackType;
import org.jcodec.common.Tuple;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Packet;
import org.jcodec.common.tools.MainUtils;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class TranscodeMain {
    private static final MainUtils.Flag[] ALL_FLAGS;
    private static final MainUtils.Flag FLAG_AUDIO_CODEC;
    private static final MainUtils.Flag FLAG_DOWNSCALE;
    private static final MainUtils.Flag FLAG_DUMPMV;
    private static final MainUtils.Flag FLAG_DUMPMVJS;
    private static final MainUtils.Flag FLAG_FORMAT;
    private static final MainUtils.Flag FLAG_INPUT;
    private static final MainUtils.Flag FLAG_INTERLACED;
    private static final MainUtils.Flag FLAG_MAP_AUDIO;
    private static final MainUtils.Flag FLAG_MAP_VIDEO;
    private static final MainUtils.Flag FLAG_MAX_FRAMES;
    private static final MainUtils.Flag FLAG_PROFILE;
    private static final MainUtils.Flag FLAG_SEEK_FRAMES;
    private static final MainUtils.Flag FLAG_VIDEO_CODEC;
    private static final MainUtils.Flag FLAG_VIDEO_FILTER;
    private static Map<Format, Codec> audioCodecsForF;
    private static Map<String, Codec> extensionToC;
    private static Map<String, Format> extensionToF;
    private static Map<String, Class<? extends Filter>> knownFilters;
    private static Set<Codec> supportedDecoders;
    private static Map<Format, Codec> videoCodecsForF;

    static {
        MainUtils.Flag flag = new MainUtils.Flag("input", "i", "Designates an input argument", MainUtils.FlagType.VOID);
        FLAG_INPUT = flag;
        MainUtils.Flag flag2 = MainUtils.Flag.flag("map:v", "mv", "Map a video from a specified input into this output");
        FLAG_MAP_VIDEO = flag2;
        MainUtils.Flag flag3 = MainUtils.Flag.flag("map:a", "ma", "Map a audio from a specified input into this output");
        FLAG_MAP_AUDIO = flag3;
        MainUtils.Flag flag4 = MainUtils.Flag.flag("seek-frames", null, "Seek frames");
        FLAG_SEEK_FRAMES = flag4;
        MainUtils.Flag flag5 = MainUtils.Flag.flag("max-frames", "limit", "Max frames");
        FLAG_MAX_FRAMES = flag5;
        MainUtils.Flag flag6 = MainUtils.Flag.flag("codec:audio", "acodec", "Audio codec [default=auto].");
        FLAG_AUDIO_CODEC = flag6;
        MainUtils.Flag flag7 = MainUtils.Flag.flag("codec:video", "vcodec", "Video codec [default=auto].");
        FLAG_VIDEO_CODEC = flag7;
        MainUtils.Flag flag8 = MainUtils.Flag.flag("format", TsConstants.kLinkParam_recording, "Format [default=auto].");
        FLAG_FORMAT = flag8;
        MainUtils.Flag flag9 = MainUtils.Flag.flag(Scopes.PROFILE, null, "Profile to use (supported by some encoders).");
        FLAG_PROFILE = flag9;
        MainUtils.Flag flag10 = MainUtils.Flag.flag("interlaced", null, "Encode output as interlaced (supported by Prores encoder).");
        FLAG_INTERLACED = flag10;
        MainUtils.Flag flag11 = MainUtils.Flag.flag("dumpMv", null, "Dump motion vectors (supported by h.264 decoder).");
        FLAG_DUMPMV = flag11;
        MainUtils.Flag flag12 = MainUtils.Flag.flag("dumpMvJs", null, "Dump motion vectors in form of JASON file (supported by h.264 decoder).");
        FLAG_DUMPMVJS = flag12;
        MainUtils.Flag flag13 = MainUtils.Flag.flag("downscale", null, "Decode frames in downscale (supported by MPEG, Prores and Jpeg decoders).");
        FLAG_DOWNSCALE = flag13;
        MainUtils.Flag flag14 = MainUtils.Flag.flag("videoFilter", "vf", "Contains a comma separated list of video filters with arguments.");
        FLAG_VIDEO_FILTER = flag14;
        ALL_FLAGS = new MainUtils.Flag[]{flag, flag8, flag7, flag6, flag4, flag5, flag9, flag10, flag11, flag12, flag13, flag2, flag3, flag14};
        extensionToF = new HashMap();
        extensionToC = new HashMap();
        videoCodecsForF = new HashMap();
        audioCodecsForF = new HashMap();
        supportedDecoders = new HashSet();
        knownFilters = new HashMap();
        Map<String, Format> map = extensionToF;
        Format format = Format.MPEG_AUDIO;
        map.put("mp3", format);
        extensionToF.put("mp2", format);
        extensionToF.put("mp1", format);
        Map<String, Format> map2 = extensionToF;
        Format format2 = Format.MPEG_PS;
        map2.put("mpg", format2);
        extensionToF.put("mpeg", format2);
        extensionToF.put("m2p", format2);
        extensionToF.put("ps", format2);
        extensionToF.put("vob", format2);
        extensionToF.put("evo", format2);
        extensionToF.put("mod", format2);
        extensionToF.put("tod", format2);
        Map<String, Format> map3 = extensionToF;
        Format format3 = Format.MPEG_TS;
        map3.put("ts", format3);
        extensionToF.put("m2t", format3);
        Map<String, Format> map4 = extensionToF;
        Format format4 = Format.MOV;
        map4.put("mp4", format4);
        extensionToF.put("m4a", format4);
        extensionToF.put("m4v", format4);
        extensionToF.put("mov", format4);
        extensionToF.put("3gp", format4);
        Map<String, Format> map5 = extensionToF;
        Format format5 = Format.MKV;
        map5.put("mkv", format5);
        extensionToF.put("webm", format5);
        Map<String, Format> map6 = extensionToF;
        Format format6 = Format.H264;
        map6.put("264", format6);
        extensionToF.put("jsv", format6);
        extensionToF.put("h264", format6);
        Map<String, Format> map7 = extensionToF;
        Format format7 = Format.RAW;
        map7.put("raw", format7);
        extensionToF.put("", format7);
        Map<String, Format> map8 = extensionToF;
        Format format8 = Format.FLV;
        map8.put("flv", format8);
        Map<String, Format> map9 = extensionToF;
        Format format9 = Format.AVI;
        map9.put("avi", format9);
        Map<String, Format> map10 = extensionToF;
        Format format10 = Format.IMG;
        map10.put("jpg", format10);
        extensionToF.put("jpeg", format10);
        extensionToF.put("png", format10);
        Map<String, Format> map11 = extensionToF;
        Format format11 = Format.MJPEG;
        map11.put("mjp", format11);
        Map<String, Format> map12 = extensionToF;
        Format format12 = Format.IVF;
        map12.put("ivf", format12);
        Map<String, Format> map13 = extensionToF;
        Format format13 = Format.Y4M;
        map13.put("y4m", format13);
        Map<String, Format> map14 = extensionToF;
        Format format14 = Format.WAV;
        map14.put("wav", format14);
        Map<String, Codec> map15 = extensionToC;
        Codec codec = Codec.MPEG2;
        map15.put("mpg", codec);
        extensionToC.put("mpeg", codec);
        extensionToC.put("m2p", codec);
        extensionToC.put("ps", codec);
        extensionToC.put("vob", codec);
        extensionToC.put("evo", codec);
        extensionToC.put("mod", codec);
        extensionToC.put("tod", codec);
        extensionToC.put("ts", codec);
        extensionToC.put("m2t", codec);
        Map<String, Codec> map16 = extensionToC;
        Codec codec2 = Codec.AAC;
        map16.put("m4a", codec2);
        Map<String, Codec> map17 = extensionToC;
        Codec codec3 = Codec.H264;
        map17.put("mkv", codec3);
        Map<String, Codec> map18 = extensionToC;
        Codec codec4 = Codec.VP8;
        map18.put("webm", codec4);
        extensionToC.put("264", codec3);
        Map<String, Codec> map19 = extensionToC;
        Codec codec5 = Codec.RAW;
        map19.put("raw", codec5);
        Map<String, Codec> map20 = extensionToC;
        Codec codec6 = Codec.JPEG;
        map20.put("jpg", codec6);
        extensionToC.put("jpeg", codec6);
        Map<String, Codec> map21 = extensionToC;
        Codec codec7 = Codec.PNG;
        map21.put("png", codec7);
        extensionToC.put("mjp", codec6);
        extensionToC.put("y4m", codec5);
        videoCodecsForF.put(format2, codec);
        Map<Format, Codec> map22 = audioCodecsForF;
        Codec codec8 = Codec.MP2;
        map22.put(format2, codec8);
        videoCodecsForF.put(format4, codec3);
        audioCodecsForF.put(format4, codec2);
        videoCodecsForF.put(format5, codec4);
        audioCodecsForF.put(format5, Codec.VORBIS);
        Map<Format, Codec> map23 = audioCodecsForF;
        Codec codec9 = Codec.PCM;
        map23.put(format14, codec9);
        videoCodecsForF.put(format6, codec3);
        videoCodecsForF.put(format7, codec5);
        videoCodecsForF.put(format8, codec3);
        Map<Format, Codec> map24 = videoCodecsForF;
        Codec codec10 = Codec.MPEG4;
        map24.put(format9, codec10);
        videoCodecsForF.put(format10, codec7);
        videoCodecsForF.put(format11, codec6);
        videoCodecsForF.put(format12, codec4);
        videoCodecsForF.put(format13, codec5);
        supportedDecoders.add(codec2);
        supportedDecoders.add(codec3);
        supportedDecoders.add(codec6);
        supportedDecoders.add(codec);
        supportedDecoders.add(codec9);
        supportedDecoders.add(codec7);
        supportedDecoders.add(codec10);
        supportedDecoders.add(Codec.PRORES);
        supportedDecoders.add(codec5);
        supportedDecoders.add(codec4);
        supportedDecoders.add(Codec.MP3);
        supportedDecoders.add(codec8);
        supportedDecoders.add(Codec.MP1);
        knownFilters.put("scale", ScaleFilter.class);
    }

    private static void addVideoFilters(String str, Transcoder.TranscoderBuilder transcoderBuilder, int i) {
        if (str == null) {
            return;
        }
        for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            String[] strArrSplit = str2.split("=");
            String str3 = strArrSplit[0];
            Class<? extends Filter> cls = knownFilters.get(str3);
            if (cls == null) {
                Logger.error("Unknown filter: " + str3);
                throw new RuntimeException("Unknown filter: " + str3);
            }
            if (strArrSplit.length > 1) {
                String[] strArrSplit2 = strArrSplit[1].split(Constants.COLON_SEPARATOR);
                Integer[] numArr = new Integer[strArrSplit2.length];
                for (int i2 = 0; i2 < strArrSplit2.length; i2++) {
                    numArr[i2] = Integer.valueOf(Integer.parseInt(strArrSplit2[i2]));
                }
                try {
                    transcoderBuilder.addFilter(i, (Filter) Platform.newInstance(cls, numArr));
                } catch (Exception unused) {
                    String str4 = "The filter " + str3 + " doesn't take " + strArrSplit2.length + " arguments.";
                    Logger.error(str4);
                    throw new RuntimeException(str4);
                }
            }
        }
    }

    private static Codec detectVideoDecoder(DemuxerTrack demuxerTrack) throws IOException {
        Codec codec;
        DemuxerTrackMeta meta = demuxerTrack.getMeta();
        if (meta != null && (codec = meta.getCodec()) != null) {
            return codec;
        }
        Packet packetNextFrame = demuxerTrack.nextFrame();
        if (packetNextFrame == null) {
            return null;
        }
        return JCodecUtil.detectDecoder(packetNextFrame.getData());
    }

    private static Codec getCodecFromExtension(String str) {
        return extensionToC.get(str.replaceFirst(".*\\.([^\\.]+$)", "$1"));
    }

    private static Codec getFirstAudioCodecForFormat(Format format) {
        return audioCodecsForF.get(format);
    }

    private static Codec getFirstVideoCodecForFormat(Format format) {
        return videoCodecsForF.get(format);
    }

    private static Format getFormatFromExtension(String str) {
        return extensionToF.get(str.replaceFirst(".*\\.([^\\.]+$)", "$1"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x039a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void main(java.lang.String[] r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 975
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.api.transcode.TranscodeMain.main(java.lang.String[]):void");
    }

    private static Tuple._3<Integer, Integer, Codec> selectSuitableTrack(String str, Format format, TrackType trackType) throws IOException {
        Demuxer demuxer;
        int i = 0;
        Tuple._2<Integer, Demuxer> _2CreateM2TSDemuxer = format == Format.MPEG_TS ? JCodecUtil.createM2TSDemuxer(new File(str), trackType) : Tuple.pair(0, JCodecUtil.createDemuxer(format, new File(str)));
        if (_2CreateM2TSDemuxer != null && (demuxer = _2CreateM2TSDemuxer.v1) != null) {
            Demuxer demuxer2 = demuxer;
            Iterator<? extends DemuxerTrack> it = (trackType == TrackType.VIDEO ? demuxer2.getVideoTracks() : demuxer2.getAudioTracks()).iterator();
            while (it.hasNext()) {
                Codec codecDetectVideoDecoder = detectVideoDecoder(it.next());
                if (supportedDecoders.contains(codecDetectVideoDecoder)) {
                    return Tuple.triple(_2CreateM2TSDemuxer.v0, Integer.valueOf(i), codecDetectVideoDecoder);
                }
                i++;
            }
        }
        return null;
    }
}
