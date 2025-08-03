package org.jcodec.common;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jcodec.codecs.aac.AACDecoder;
import org.jcodec.codecs.h264.BufferH264ES;
import org.jcodec.codecs.h264.H264Decoder;
import org.jcodec.codecs.mjpeg.JpegDecoder;
import org.jcodec.codecs.mpeg12.MPEGDecoder;
import org.jcodec.codecs.mpeg4.MPEG4Decoder;
import org.jcodec.codecs.ppm.PPMEncoder;
import org.jcodec.codecs.prores.ProresDecoder;
import org.jcodec.codecs.vpx.VP8Decoder;
import org.jcodec.codecs.wav.WavDemuxer;
import org.jcodec.common.Tuple;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.containers.imgseq.ImageSequenceDemuxer;
import org.jcodec.containers.mkv.demuxer.MKVDemuxer;
import org.jcodec.containers.mp3.MPEGAudioDemuxer;
import org.jcodec.containers.mp4.demuxer.MP4Demuxer;
import org.jcodec.containers.mps.MPSDemuxer;
import org.jcodec.containers.mps.MTSDemuxer;
import org.jcodec.containers.webp.WebpDemuxer;
import org.jcodec.containers.y4m.Y4MDemuxer;
import org.jcodec.platform.Platform;
import org.jcodec.scale.ColorUtil;
import org.jcodec.scale.Transform;

/* loaded from: classes2.dex */
public class JCodecUtil {
    private static final Map<Codec, Class<?>> decoders;
    private static final Map<Format, Class<?>> demuxers;

    static {
        HashMap map = new HashMap();
        decoders = map;
        HashMap map2 = new HashMap();
        demuxers = map2;
        map.put(Codec.VP8, VP8Decoder.class);
        map.put(Codec.PRORES, ProresDecoder.class);
        map.put(Codec.MPEG2, MPEGDecoder.class);
        map.put(Codec.H264, H264Decoder.class);
        map.put(Codec.AAC, AACDecoder.class);
        map.put(Codec.MPEG4, MPEG4Decoder.class);
        map2.put(Format.MPEG_TS, MTSDemuxer.class);
        map2.put(Format.MPEG_PS, MPSDemuxer.class);
        map2.put(Format.MOV, MP4Demuxer.class);
        map2.put(Format.WEBP, WebpDemuxer.class);
        map2.put(Format.MPEG_AUDIO, MPEGAudioDemuxer.class);
    }

    public static byte[] asciiString(String str) {
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            bArr[i] = (byte) charArray[i];
        }
        return bArr;
    }

    public static AudioDecoder createAudioDecoder(Codec codec, ByteBuffer byteBuffer) throws IOException {
        if (Codec.AAC == codec) {
            return new AACDecoder(byteBuffer);
        }
        Logger.error("Codec " + codec + " is not supported");
        return null;
    }

    public static Demuxer createDemuxer(Format format, File file) throws IOException {
        Format format2 = Format.IMG;
        FileChannelWrapper fileChannelWrapper = format != format2 ? NIOUtils.readableChannel(file) : null;
        if (Format.MOV == format) {
            return MP4Demuxer.createMP4Demuxer(fileChannelWrapper);
        }
        if (Format.MPEG_PS == format) {
            return new MPSDemuxer(fileChannelWrapper);
        }
        if (Format.MKV == format) {
            return new MKVDemuxer(fileChannelWrapper);
        }
        if (format2 == format) {
            return new ImageSequenceDemuxer(file.getAbsolutePath(), Integer.MAX_VALUE);
        }
        if (Format.Y4M == format) {
            return new Y4MDemuxer(fileChannelWrapper);
        }
        if (Format.WEBP == format) {
            return new WebpDemuxer(fileChannelWrapper);
        }
        if (Format.H264 == format) {
            return new BufferH264ES(NIOUtils.fetchAllFromChannel(fileChannelWrapper));
        }
        if (Format.WAV == format) {
            return new WavDemuxer(fileChannelWrapper);
        }
        if (Format.MPEG_AUDIO == format) {
            return new MPEGAudioDemuxer(fileChannelWrapper);
        }
        Logger.error("Format " + format + " is not supported");
        return null;
    }

    public static Tuple._2<Integer, Demuxer> createM2TSDemuxer(File file, TrackType trackType) throws IOException {
        MTSDemuxer mTSDemuxer = new MTSDemuxer(NIOUtils.readableChannel(file));
        Set<Integer> programs = mTSDemuxer.getPrograms();
        Tuple._2<Integer, Demuxer> _2Pair = null;
        if (programs.size() == 0) {
            Logger.error("The MPEG TS stream contains no programs");
            return null;
        }
        for (Integer num : programs) {
            ReadableByteChannel program = mTSDemuxer.getProgram(num.intValue());
            if (_2Pair != null) {
                program.close();
            } else {
                MPSDemuxer mPSDemuxer = new MPSDemuxer(program);
                if ((trackType != TrackType.AUDIO || mPSDemuxer.getAudioTracks().size() <= 0) && (trackType != TrackType.VIDEO || mPSDemuxer.getVideoTracks().size() <= 0)) {
                    program.close();
                } else {
                    _2Pair = Tuple.pair(num, mPSDemuxer);
                    Logger.info("Using M2TS program: " + num + " for " + trackType + " track.");
                }
            }
        }
        return _2Pair;
    }

    public static VideoDecoder createVideoDecoder(Codec codec, ByteBuffer byteBuffer) {
        if (Codec.H264 == codec) {
            return byteBuffer != null ? H264Decoder.createH264DecoderFromCodecPrivate(byteBuffer) : new H264Decoder();
        }
        if (Codec.MPEG2 == codec) {
            return new MPEGDecoder();
        }
        if (Codec.VP8 == codec) {
            return new VP8Decoder();
        }
        if (Codec.JPEG == codec) {
            return new JpegDecoder();
        }
        Logger.error("Codec " + codec + " is not supported");
        return null;
    }

    public static Codec detectDecoder(ByteBuffer byteBuffer) {
        int i = 0;
        Codec key = null;
        for (Map.Entry<Codec, Class<?>> entry : decoders.entrySet()) {
            int iProbe = probe(byteBuffer.duplicate(), entry.getValue());
            if (iProbe > i) {
                key = entry.getKey();
                i = iProbe;
            }
        }
        return key;
    }

    public static Format detectFormat(File file) throws IOException {
        return detectFormatBuffer(NIOUtils.fetchFromFileL(file, 204800));
    }

    public static Format detectFormatBuffer(ByteBuffer byteBuffer) {
        int i = 0;
        Format key = null;
        for (Map.Entry<Format, Class<?>> entry : demuxers.entrySet()) {
            int iProbe = probe(byteBuffer.duplicate(), entry.getValue());
            if (iProbe > i) {
                key = entry.getKey();
                i = iProbe;
            }
        }
        return key;
    }

    public static Format detectFormatChannel(ReadableByteChannel readableByteChannel) throws IOException {
        return detectFormatBuffer(NIOUtils.fetchFromChannel(readableByteChannel, 204800));
    }

    public static int[] getAsIntArray(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        int[] iArr = new int[i];
        byteBuffer.get(bArr);
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = bArr[i2] & ExifInterface.MARKER;
        }
        return iArr;
    }

    public static VideoDecoder getVideoDecoder(String str) {
        if ("apch".equals(str) || "apcs".equals(str) || "apco".equals(str) || "apcn".equals(str) || "ap4h".equals(str)) {
            return new ProresDecoder();
        }
        if ("m2v1".equals(str)) {
            return new MPEGDecoder();
        }
        return null;
    }

    private static int probe(ByteBuffer byteBuffer, Class<?> cls) {
        try {
            return ((Integer) Platform.invokeStaticMethod(cls, "probe", new Object[]{byteBuffer})).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int readBER32(ByteBuffer byteBuffer) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            byte b = byteBuffer.get();
            i = (i << 7) | (b & Byte.MAX_VALUE);
            if (((b & ExifInterface.MARKER) >> 7) == 0) {
                break;
            }
        }
        return i;
    }

    public static String removeExtension(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("\\.[^\\.]+$", "");
    }

    public static void savePictureAsPPM(Picture picture, File file) throws IOException {
        ColorSpace color = picture.getColor();
        ColorSpace colorSpace = ColorSpace.RGB;
        Transform transform = ColorUtil.getTransform(color, colorSpace);
        Picture pictureCreate = Picture.create(picture.getWidth(), picture.getHeight(), colorSpace);
        transform.transform(picture, pictureCreate);
        NIOUtils.writeTo(new PPMEncoder().encodeFrame(pictureCreate), file);
    }

    public static void writeBER32(ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) ((i >> 21) | 128));
        byteBuffer.put((byte) ((i >> 14) | 128));
        byteBuffer.put((byte) ((i >> 7) | 128));
        byteBuffer.put((byte) (i & 127));
    }

    public static void writeBER32Var(ByteBuffer byteBuffer, int i) {
        int iLog2 = MathUtil.log2(i);
        for (int i2 = 0; i2 < 4 && iLog2 > 0; i2++) {
            iLog2 -= 7;
            int i3 = i >> iLog2;
            if (iLog2 > 0) {
                i3 |= 128;
            }
            byteBuffer.put((byte) i3);
        }
    }
}
