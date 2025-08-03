package org.jcodec.api.transcode;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.sourceforge.jaad.aac.AACException;
import org.jcodec.api.transcode.PixelStore;
import org.jcodec.codecs.aac.AACDecoder;
import org.jcodec.codecs.h264.BufferH264ES;
import org.jcodec.codecs.h264.H264Decoder;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.mjpeg.JpegDecoder;
import org.jcodec.codecs.mjpeg.JpegToThumb2x2;
import org.jcodec.codecs.mjpeg.JpegToThumb4x4;
import org.jcodec.codecs.mpeg12.MPEGDecoder;
import org.jcodec.codecs.mpeg12.Mpeg2Thumb2x2;
import org.jcodec.codecs.mpeg12.Mpeg2Thumb4x4;
import org.jcodec.codecs.mpeg4.MPEG4Decoder;
import org.jcodec.codecs.png.PNGDecoder;
import org.jcodec.codecs.prores.ProresDecoder;
import org.jcodec.codecs.prores.ProresToThumb;
import org.jcodec.codecs.prores.ProresToThumb2x2;
import org.jcodec.codecs.prores.ProresToThumb4x4;
import org.jcodec.codecs.raw.RAWVideoDecoder;
import org.jcodec.codecs.vpx.VP8Decoder;
import org.jcodec.codecs.wav.WavDemuxer;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.AudioDecoder;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.Codec;
import org.jcodec.common.Demuxer;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.Format;
import org.jcodec.common.SeekableDemuxerTrack;
import org.jcodec.common.Tuple;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.io.IOUtils;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.AudioBuffer;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Size;
import org.jcodec.containers.imgseq.ImageSequenceDemuxer;
import org.jcodec.containers.mkv.demuxer.MKVDemuxer;
import org.jcodec.containers.mp3.MPEGAudioDemuxer;
import org.jcodec.containers.mp4.demuxer.MP4Demuxer;
import org.jcodec.containers.mps.MPEGDemuxer;
import org.jcodec.containers.mps.MPSDemuxer;
import org.jcodec.containers.mps.MTSDemuxer;
import org.jcodec.containers.webp.WebpDemuxer;
import org.jcodec.containers.y4m.Y4MDemuxer;

/* loaded from: classes2.dex */
public class SourceImpl implements Source, PacketSource {
    private AudioCodecMeta audioCodecMeta;
    private AudioDecoder audioDecoder;
    private DemuxerTrack audioInputTrack;
    private Demuxer demuxAudio;
    private Demuxer demuxVideo;
    private Tuple._3<Integer, Integer, Codec> inputAudioCodec;
    private Format inputFormat;
    private Tuple._3<Integer, Integer, Codec> inputVideoCodec;
    private PixelStore pixelStore;
    private String sourceName;
    private SeekableByteChannel sourceStream;
    private VideoCodecMeta videoCodecMeta;
    private VideoDecoder videoDecoder;
    private DemuxerTrack videoInputTrack;
    private int downscale = 1;
    private List<VideoFrameWithPacket> frameReorderBuffer = new ArrayList();
    private List<Packet> videoPacketReorderBuffer = new ArrayList();

    public static class RawAudioDecoder implements AudioDecoder {
        private AudioFormat format;

        public RawAudioDecoder(AudioFormat audioFormat) {
            this.format = audioFormat;
        }

        @Override // org.jcodec.common.AudioDecoder
        public AudioBuffer decodeFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws IOException {
            return new AudioBuffer(byteBuffer, this.format, byteBuffer.remaining() / this.format.getFrameSize());
        }

        @Override // org.jcodec.common.AudioDecoder
        public AudioCodecMeta getCodecMeta(ByteBuffer byteBuffer) throws IOException {
            return AudioCodecMeta.fromAudioFormat(this.format);
        }
    }

    public SourceImpl(String str, Format format, Tuple._3<Integer, Integer, Codec> _3, Tuple._3<Integer, Integer, Codec> _32) {
        this.sourceName = str;
        this.inputFormat = format;
        this.inputVideoCodec = _3;
        this.inputAudioCodec = _32;
    }

    private AudioDecoder createAudioDecoder(ByteBuffer byteBuffer) throws AACException {
        Codec codec = Codec.AAC;
        Codec codec2 = this.inputAudioCodec.v2;
        if (codec == codec2) {
            return new AACDecoder(byteBuffer);
        }
        if (Codec.PCM == codec2) {
            return new RawAudioDecoder(getAudioMeta().getAudioCodecMeta().getFormat());
        }
        return null;
    }

    public static JpegDecoder createJpegDecoder(int i) {
        return i == 2 ? new JpegToThumb4x4() : i == 4 ? new JpegToThumb2x2() : new JpegDecoder();
    }

    public static MPEGDecoder createMpegDecoder(int i) {
        return i == 2 ? new Mpeg2Thumb4x4() : i == 4 ? new Mpeg2Thumb2x2() : new MPEGDecoder();
    }

    public static ProresDecoder createProresDecoder(int i) {
        return 2 == i ? new ProresToThumb4x4() : 4 == i ? new ProresToThumb2x2() : 8 == i ? new ProresToThumb() : new ProresDecoder();
    }

    private VideoDecoder createVideoDecoder(Codec codec, int i, ByteBuffer byteBuffer, VideoCodecMeta videoCodecMeta) {
        if (Codec.H264 == codec) {
            return H264Decoder.createH264DecoderFromCodecPrivate(byteBuffer);
        }
        if (Codec.PNG == codec) {
            return new PNGDecoder();
        }
        if (Codec.MPEG2 == codec) {
            return createMpegDecoder(i);
        }
        if (Codec.PRORES == codec) {
            return createProresDecoder(i);
        }
        if (Codec.VP8 == codec) {
            return new VP8Decoder();
        }
        if (Codec.JPEG == codec) {
            return createJpegDecoder(i);
        }
        if (Codec.MPEG4 == codec) {
            return new MPEG4Decoder();
        }
        if (Codec.RAW != codec) {
            return null;
        }
        Size size = videoCodecMeta.getSize();
        return new RAWVideoDecoder(size.getWidth(), size.getHeight());
    }

    private void detectFrameType(Packet packet) {
        if (this.inputVideoCodec.v2 != Codec.H264) {
            return;
        }
        packet.setFrameType(H264Utils.isByteBufferIDRSlice(packet.getData()) ? Packet.FrameType.KEY : Packet.FrameType.INTER);
    }

    private Packet getNextVideoPacket() throws IOException {
        DemuxerTrack demuxerTrack = this.videoInputTrack;
        if (demuxerTrack == null) {
            return null;
        }
        Packet packetNextFrame = demuxerTrack.nextFrame();
        if (this.videoDecoder == null) {
            VideoDecoder videoDecoderCreateVideoDecoder = createVideoDecoder(this.inputVideoCodec.v2, this.downscale, packetNextFrame.getData(), null);
            this.videoDecoder = videoDecoderCreateVideoDecoder;
            if (videoDecoderCreateVideoDecoder != null) {
                this.videoCodecMeta = videoDecoderCreateVideoDecoder.getCodecMeta(packetNextFrame.getData());
            }
        }
        return packetNextFrame;
    }

    private MPEGDemuxer.MPEGDemuxerTrack openTSTrack(MPSDemuxer mPSDemuxer, Integer num) {
        int i = 0;
        for (MPEGDemuxer.MPEGDemuxerTrack mPEGDemuxerTrack : mPSDemuxer.getTracks()) {
            if (i == num.intValue()) {
                return mPEGDemuxerTrack;
            }
            mPEGDemuxerTrack.ignore();
            i++;
        }
        return null;
    }

    private VideoFrameWithPacket removeFirstFixDuration(List<VideoFrameWithPacket> list) {
        Collections.sort(list);
        VideoFrameWithPacket videoFrameWithPacketRemove = list.remove(0);
        if (!list.isEmpty()) {
            videoFrameWithPacketRemove.getPacket().setDuration(list.get(0).getPacket().getPts() - videoFrameWithPacketRemove.getPacket().getPts());
        }
        return videoFrameWithPacketRemove;
    }

    public ByteBuffer decodeAudio(ByteBuffer byteBuffer) throws IOException {
        return this.inputAudioCodec.v2 == Codec.PCM ? byteBuffer : this.audioDecoder.decodeFrame(byteBuffer, null).getData();
    }

    public Picture decodeVideo(ByteBuffer byteBuffer, Picture picture) {
        return this.videoDecoder.decodeFrame(byteBuffer, picture.getData());
    }

    @Override // org.jcodec.api.transcode.Source
    public void finish() throws IOException {
        SeekableByteChannel seekableByteChannel = this.sourceStream;
        if (seekableByteChannel != null) {
            IOUtils.closeQuietly(seekableByteChannel);
        }
    }

    @Override // org.jcodec.api.transcode.Source
    public AudioCodecMeta getAudioCodecMeta() {
        DemuxerTrack demuxerTrack = this.audioInputTrack;
        return (demuxerTrack == null || demuxerTrack.getMeta() == null || this.audioInputTrack.getMeta().getAudioCodecMeta() == null) ? this.audioCodecMeta : this.audioInputTrack.getMeta().getAudioCodecMeta();
    }

    public DemuxerTrackMeta getAudioMeta() {
        DemuxerTrack demuxerTrack = this.audioInputTrack;
        if (demuxerTrack == null) {
            return null;
        }
        return demuxerTrack.getMeta();
    }

    public Tuple._3<Integer, Integer, Codec> getInputAudioCode() {
        return this.inputAudioCodec;
    }

    public Tuple._3<Integer, Integer, Codec> getIntputVideoCodec() {
        return this.inputVideoCodec;
    }

    @Override // org.jcodec.api.transcode.Source
    public AudioFrameWithPacket getNextAudioFrame() throws IOException {
        AudioBuffer audioBufferDecodeFrame;
        Packet packetInputAudioPacket = inputAudioPacket();
        if (packetInputAudioPacket == null) {
            return null;
        }
        if (this.inputAudioCodec.v2 == Codec.PCM) {
            DemuxerTrackMeta audioMeta = getAudioMeta();
            audioBufferDecodeFrame = new AudioBuffer(packetInputAudioPacket.getData(), audioMeta.getAudioCodecMeta().getFormat(), audioMeta.getTotalFrames());
        } else {
            audioBufferDecodeFrame = this.audioDecoder.decodeFrame(packetInputAudioPacket.getData(), null);
        }
        return new AudioFrameWithPacket(audioBufferDecodeFrame, packetInputAudioPacket);
    }

    @Override // org.jcodec.api.transcode.Source
    public VideoFrameWithPacket getNextVideoFrame() throws IOException {
        while (true) {
            Packet nextVideoPacket = getNextVideoPacket();
            if (nextVideoPacket == null) {
                if (this.frameReorderBuffer.size() > 0) {
                    return removeFirstFixDuration(this.frameReorderBuffer);
                }
                return null;
            }
            if (nextVideoPacket.getFrameType() == Packet.FrameType.UNKNOWN) {
                detectFrameType(nextVideoPacket);
            }
            PixelStore.LoanerPicture pixelBuffer = getPixelBuffer(nextVideoPacket.getData());
            Picture pictureDecodeVideo = decodeVideo(nextVideoPacket.getData(), pixelBuffer.getPicture());
            if (pictureDecodeVideo == null) {
                this.pixelStore.putBack(pixelBuffer);
            } else {
                this.frameReorderBuffer.add(new VideoFrameWithPacket(nextVideoPacket, new PixelStore.LoanerPicture(pictureDecodeVideo, 1)));
                if (this.frameReorderBuffer.size() > 7) {
                    return removeFirstFixDuration(this.frameReorderBuffer);
                }
            }
        }
    }

    public PixelStore.LoanerPicture getPixelBuffer(ByteBuffer byteBuffer) {
        VideoCodecMeta videoCodecMeta = getVideoCodecMeta();
        Size size = videoCodecMeta.getSize();
        return this.pixelStore.getPicture((size.getWidth() + 15) & (-16), (size.getHeight() + 15) & (-16), videoCodecMeta.getColor());
    }

    public DemuxerTrackMeta getTrackVideoMeta() {
        DemuxerTrack demuxerTrack = this.videoInputTrack;
        if (demuxerTrack == null) {
            return null;
        }
        return demuxerTrack.getMeta();
    }

    @Override // org.jcodec.api.transcode.Source
    public VideoCodecMeta getVideoCodecMeta() {
        VideoCodecMeta videoCodecMeta = this.videoCodecMeta;
        if (videoCodecMeta != null) {
            return videoCodecMeta;
        }
        DemuxerTrackMeta trackVideoMeta = getTrackVideoMeta();
        if (trackVideoMeta != null && trackVideoMeta.getVideoCodecMeta() != null) {
            this.videoCodecMeta = trackVideoMeta.getVideoCodecMeta();
        }
        return this.videoCodecMeta;
    }

    @Override // org.jcodec.api.transcode.Source
    public boolean haveAudio() {
        return this.audioInputTrack != null;
    }

    @Override // org.jcodec.api.transcode.Source
    public void init(PixelStore pixelStore) throws IOException {
        this.pixelStore = pixelStore;
        initDemuxer();
    }

    public void initDemuxer() throws IOException {
        Format format = this.inputFormat;
        Format format2 = Format.IMG;
        if (format != format2) {
            this.sourceStream = NIOUtils.readableFileChannel(this.sourceName);
        }
        Format format3 = Format.MOV;
        Format format4 = this.inputFormat;
        if (format3 == format4) {
            MP4Demuxer mP4DemuxerCreateMP4Demuxer = MP4Demuxer.createMP4Demuxer(this.sourceStream);
            this.demuxAudio = mP4DemuxerCreateMP4Demuxer;
            this.demuxVideo = mP4DemuxerCreateMP4Demuxer;
        } else if (Format.MKV == format4) {
            MKVDemuxer mKVDemuxer = new MKVDemuxer(this.sourceStream);
            this.demuxAudio = mKVDemuxer;
            this.demuxVideo = mKVDemuxer;
        } else if (format2 == format4) {
            this.demuxVideo = new ImageSequenceDemuxer(this.sourceName, Integer.MAX_VALUE);
        } else if (Format.WEBP == format4) {
            this.demuxVideo = new WebpDemuxer(this.sourceStream);
        } else if (Format.MPEG_PS == format4) {
            MPSDemuxer mPSDemuxer = new MPSDemuxer(this.sourceStream);
            this.demuxAudio = mPSDemuxer;
            this.demuxVideo = mPSDemuxer;
        } else if (Format.Y4M == format4) {
            Y4MDemuxer y4MDemuxer = new Y4MDemuxer(this.sourceStream);
            this.demuxAudio = y4MDemuxer;
            this.demuxVideo = y4MDemuxer;
            this.videoInputTrack = y4MDemuxer;
        } else if (Format.H264 == format4) {
            this.demuxVideo = new BufferH264ES(NIOUtils.fetchAllFromChannel(this.sourceStream));
        } else if (Format.WAV == format4) {
            this.demuxAudio = new WavDemuxer(this.sourceStream);
        } else if (Format.MPEG_AUDIO == format4) {
            this.demuxAudio = new MPEGAudioDemuxer(this.sourceStream);
        } else {
            if (Format.MPEG_TS != format4) {
                throw new RuntimeException("Input format: " + this.inputFormat + " is not supported.");
            }
            MTSDemuxer mTSDemuxer = new MTSDemuxer(this.sourceStream);
            MPSDemuxer mPSDemuxer2 = null;
            Tuple._3<Integer, Integer, Codec> _3 = this.inputVideoCodec;
            if (_3 != null) {
                mPSDemuxer2 = new MPSDemuxer(mTSDemuxer.getProgram(_3.v0.intValue()));
                this.videoInputTrack = openTSTrack(mPSDemuxer2, this.inputVideoCodec.v1);
                this.demuxVideo = mPSDemuxer2;
            }
            Tuple._3<Integer, Integer, Codec> _32 = this.inputAudioCodec;
            if (_32 != null) {
                Tuple._3<Integer, Integer, Codec> _33 = this.inputVideoCodec;
                if (_33 == null || _33.v0 != _32.v0) {
                    mPSDemuxer2 = new MPSDemuxer(mTSDemuxer.getProgram(_32.v0.intValue()));
                }
                this.audioInputTrack = openTSTrack(mPSDemuxer2, this.inputAudioCodec.v1);
                this.demuxAudio = mPSDemuxer2;
            }
            Iterator<Integer> it = mTSDemuxer.getPrograms().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                Tuple._3<Integer, Integer, Codec> _34 = this.inputVideoCodec;
                if (_34 == null || iIntValue != _34.v0.intValue()) {
                    Tuple._3<Integer, Integer, Codec> _35 = this.inputAudioCodec;
                    if (_35 == null || iIntValue != _35.v0.intValue()) {
                        Logger.info("Unused program: " + iIntValue);
                        mTSDemuxer.getProgram(iIntValue).close();
                    }
                }
            }
        }
        Demuxer demuxer = this.demuxVideo;
        if (demuxer != null && this.inputVideoCodec != null) {
            List<? extends DemuxerTrack> videoTracks = demuxer.getVideoTracks();
            if (videoTracks.size() > 0) {
                this.videoInputTrack = videoTracks.get(this.inputVideoCodec.v1.intValue());
            }
        }
        Demuxer demuxer2 = this.demuxAudio;
        if (demuxer2 == null || this.inputAudioCodec == null) {
            return;
        }
        List<? extends DemuxerTrack> audioTracks = demuxer2.getAudioTracks();
        if (audioTracks.size() > 0) {
            this.audioInputTrack = audioTracks.get(this.inputAudioCodec.v1.intValue());
        }
    }

    @Override // org.jcodec.api.transcode.PacketSource
    public Packet inputAudioPacket() throws IOException {
        DemuxerTrack demuxerTrack = this.audioInputTrack;
        if (demuxerTrack == null) {
            return null;
        }
        Packet packetNextFrame = demuxerTrack.nextFrame();
        if (this.audioDecoder == null && packetNextFrame != null) {
            AudioDecoder audioDecoderCreateAudioDecoder = createAudioDecoder(packetNextFrame.getData());
            this.audioDecoder = audioDecoderCreateAudioDecoder;
            if (audioDecoderCreateAudioDecoder != null) {
                this.audioCodecMeta = audioDecoderCreateAudioDecoder.getCodecMeta(packetNextFrame.getData());
            }
        }
        return packetNextFrame;
    }

    @Override // org.jcodec.api.transcode.PacketSource
    public Packet inputVideoPacket() throws IOException {
        do {
            Packet nextVideoPacket = getNextVideoPacket();
            if (nextVideoPacket != null) {
                this.videoPacketReorderBuffer.add(nextVideoPacket);
            }
            if (nextVideoPacket == null) {
                break;
            }
        } while (this.videoPacketReorderBuffer.size() <= 7);
        if (this.videoPacketReorderBuffer.size() == 0) {
            return null;
        }
        Packet packetRemove = this.videoPacketReorderBuffer.remove(0);
        Iterator<Packet> it = this.videoPacketReorderBuffer.iterator();
        int i = Integer.MAX_VALUE;
        while (it.hasNext()) {
            int pts = (int) (it.next().getPts() - packetRemove.getPts());
            if (pts > 0 && pts < i) {
                i = pts;
            }
        }
        if (i != Integer.MAX_VALUE) {
            packetRemove.setDuration(i);
        }
        return packetRemove;
    }

    @Override // org.jcodec.api.transcode.Source
    public boolean isAudio() {
        List<? extends DemuxerTrack> audioTracks;
        return this.inputFormat.isAudio() && (audioTracks = this.demuxAudio.getAudioTracks()) != null && audioTracks.size() > 0;
    }

    @Override // org.jcodec.api.transcode.Source
    public boolean isVideo() {
        List<? extends DemuxerTrack> videoTracks;
        return this.inputFormat.isVideo() && (videoTracks = this.demuxVideo.getVideoTracks()) != null && videoTracks.size() > 0;
    }

    @Override // org.jcodec.api.transcode.Source
    public void seekFrames(int i) throws IOException {
        if (i == 0) {
            return;
        }
        int iSeekToKeyFrame = i - seekToKeyFrame(i);
        while (iSeekToKeyFrame > 0) {
            Packet nextVideoPacket = getNextVideoPacket();
            if (nextVideoPacket == null) {
                return;
            }
            PixelStore.LoanerPicture pixelBuffer = getPixelBuffer(nextVideoPacket.getData());
            Picture pictureDecodeVideo = decodeVideo(nextVideoPacket.getData(), pixelBuffer.getPicture());
            if (pictureDecodeVideo == null) {
                this.pixelStore.putBack(pixelBuffer);
            } else {
                this.frameReorderBuffer.add(new VideoFrameWithPacket(nextVideoPacket, new PixelStore.LoanerPicture(pictureDecodeVideo, 1)));
                if (this.frameReorderBuffer.size() > 7) {
                    Collections.sort(this.frameReorderBuffer);
                    VideoFrameWithPacket videoFrameWithPacketRemove = this.frameReorderBuffer.remove(0);
                    iSeekToKeyFrame--;
                    if (videoFrameWithPacketRemove.getFrame() != null) {
                        this.pixelStore.putBack(videoFrameWithPacketRemove.getFrame());
                    }
                }
            }
        }
    }

    public int seekToKeyFrame(int i) throws IOException {
        DemuxerTrack demuxerTrack = this.videoInputTrack;
        if (demuxerTrack instanceof SeekableDemuxerTrack) {
            SeekableDemuxerTrack seekableDemuxerTrack = (SeekableDemuxerTrack) demuxerTrack;
            seekableDemuxerTrack.gotoSyncFrame(i);
            return (int) seekableDemuxerTrack.getCurFrame();
        }
        Logger.warn("Can not seek in " + this.videoInputTrack + " container.");
        return -1;
    }

    @Override // org.jcodec.api.transcode.Source
    public void setOption(Options options, Object obj) {
        if (options == Options.DOWNSCALE) {
            this.downscale = ((Integer) obj).intValue();
        }
    }
}
