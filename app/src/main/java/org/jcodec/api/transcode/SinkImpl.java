package org.jcodec.api.transcode;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.codecs.h264.H264Encoder;
import org.jcodec.codecs.png.PNGEncoder;
import org.jcodec.codecs.prores.ProresEncoder;
import org.jcodec.codecs.raw.RAWVideoEncoder;
import org.jcodec.codecs.vpx.IVFMuxer;
import org.jcodec.codecs.vpx.VP8Encoder;
import org.jcodec.codecs.wav.WavMuxer;
import org.jcodec.codecs.y4m.Y4MMuxer;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.AudioEncoder;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.Codec;
import org.jcodec.common.Format;
import org.jcodec.common.Muxer;
import org.jcodec.common.MuxerTrack;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.VideoEncoder;
import org.jcodec.common.io.IOUtils;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.AudioBuffer;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Size;
import org.jcodec.containers.imgseq.ImageSequenceMuxer;
import org.jcodec.containers.mkv.muxer.MKVMuxer;
import org.jcodec.containers.mp4.muxer.MP4Muxer;
import org.jcodec.containers.raw.RawMuxer;

/* loaded from: classes2.dex */
public class SinkImpl implements Sink, PacketSink {
    private AudioEncoder audioEncoder;
    private MuxerTrack audioOutputTrack;
    private final ThreadLocal<ByteBuffer> bufferStore;
    private String destName;
    private SeekableByteChannel destStream;
    private boolean framesOutput;
    private boolean interlaced;
    private Muxer muxer;
    private Codec outputAudioCodec;
    private Format outputFormat;
    private Codec outputVideoCodec;
    private String profile;
    private VideoEncoder videoEncoder;
    private MuxerTrack videoOutputTrack;

    public static class RawAudioEncoder implements AudioEncoder {
        private RawAudioEncoder() {
        }

        @Override // org.jcodec.common.AudioEncoder
        public ByteBuffer encode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
            return byteBuffer;
        }
    }

    public SinkImpl(String str, Format format, Codec codec, Codec codec2) {
        if (str == null && format == Format.IMG) {
            throw new IllegalArgumentException("A destination file should be specified for the image muxer.");
        }
        this.destName = str;
        this.outputVideoCodec = codec;
        this.outputAudioCodec = codec2;
        this.outputFormat = format;
        this.bufferStore = new ThreadLocal<>();
    }

    private AudioEncoder createAudioEncoder(Codec codec, AudioFormat audioFormat) {
        if (codec == Codec.PCM) {
            return new RawAudioEncoder();
        }
        throw new RuntimeException("Only PCM audio encoding (RAW audio) is supported.");
    }

    public static SinkImpl createWithStream(SeekableByteChannel seekableByteChannel, Format format, Codec codec, Codec codec2) {
        SinkImpl sinkImpl = new SinkImpl(null, format, codec, codec2);
        sinkImpl.destStream = seekableByteChannel;
        return sinkImpl;
    }

    public ByteBuffer encodeAudio(AudioBuffer audioBuffer) {
        if (this.audioEncoder == null) {
            this.audioEncoder = createAudioEncoder(this.outputAudioCodec, audioBuffer.getFormat());
        }
        return this.audioEncoder.encode(audioBuffer.getData(), null);
    }

    public VideoEncoder.EncodedFrame encodeVideo(Picture picture, ByteBuffer byteBuffer) {
        if (this.outputFormat.isVideo()) {
            return this.videoEncoder.encodeFrame(picture, byteBuffer);
        }
        return null;
    }

    @Override // org.jcodec.api.transcode.Sink
    public void finish() throws IOException {
        if (this.framesOutput) {
            this.muxer.finish();
        } else {
            Logger.warn("No frames output.");
        }
        SeekableByteChannel seekableByteChannel = this.destStream;
        if (seekableByteChannel != null) {
            IOUtils.closeQuietly(seekableByteChannel);
        }
    }

    @Override // org.jcodec.api.transcode.Sink
    public ColorSpace getInputColor() {
        VideoEncoder videoEncoder = this.videoEncoder;
        if (videoEncoder == null) {
            throw new IllegalStateException("Video encoder has not been initialized, init() must be called before using this class.");
        }
        ColorSpace[] supportedColorSpaces = videoEncoder.getSupportedColorSpaces();
        if (supportedColorSpaces == null) {
            return null;
        }
        return supportedColorSpaces[0];
    }

    @Override // org.jcodec.api.transcode.Sink
    public void init() throws IOException {
        Codec codec;
        initMuxer();
        if (!this.outputFormat.isVideo() || (codec = this.outputVideoCodec) == null) {
            return;
        }
        if (Codec.PRORES == codec) {
            this.videoEncoder = ProresEncoder.createProresEncoder(this.profile, this.interlaced);
            return;
        }
        if (Codec.H264 == codec) {
            this.videoEncoder = H264Encoder.createH264Encoder();
            return;
        }
        if (Codec.VP8 == codec) {
            this.videoEncoder = VP8Encoder.createVP8Encoder(10);
            return;
        }
        if (Codec.PNG == codec) {
            this.videoEncoder = new PNGEncoder();
        } else {
            if (Codec.RAW == codec) {
                this.videoEncoder = new RAWVideoEncoder();
                return;
            }
            throw new RuntimeException("Could not find encoder for the codec: " + this.outputVideoCodec);
        }
    }

    public void initMuxer() throws IOException {
        if (this.destStream == null && this.outputFormat != Format.IMG) {
            this.destStream = NIOUtils.writableFileChannel(this.destName);
        }
        Format format = Format.MKV;
        Format format2 = this.outputFormat;
        if (format == format2) {
            this.muxer = new MKVMuxer(this.destStream);
            return;
        }
        if (Format.MOV == format2) {
            this.muxer = MP4Muxer.createMP4MuxerToChannel(this.destStream);
            return;
        }
        if (Format.IVF == format2) {
            this.muxer = new IVFMuxer(this.destStream);
            return;
        }
        if (Format.IMG == format2) {
            this.muxer = new ImageSequenceMuxer(this.destName);
            return;
        }
        if (Format.WAV == format2) {
            this.muxer = new WavMuxer(this.destStream);
            return;
        }
        if (Format.Y4M == format2) {
            this.muxer = new Y4MMuxer(this.destStream);
            return;
        }
        if (Format.RAW == format2) {
            this.muxer = new RawMuxer(this.destStream);
            return;
        }
        throw new RuntimeException("The output format " + this.outputFormat + " is not supported.");
    }

    @Override // org.jcodec.api.transcode.Sink
    public boolean isAudio() {
        return this.outputFormat.isAudio();
    }

    @Override // org.jcodec.api.transcode.Sink
    public boolean isVideo() {
        return this.outputFormat.isVideo();
    }

    @Override // org.jcodec.api.transcode.Sink
    public void outputAudioFrame(AudioFrameWithPacket audioFrameWithPacket) throws IOException {
        if (!this.outputFormat.isAudio() || this.outputAudioCodec == null) {
            return;
        }
        outputAudioPacket(Packet.createPacketWithData(audioFrameWithPacket.getPacket(), encodeAudio(audioFrameWithPacket.getAudio())), AudioCodecMeta.fromAudioFormat(audioFrameWithPacket.getAudio().getFormat()));
    }

    @Override // org.jcodec.api.transcode.PacketSink
    public void outputAudioPacket(Packet packet, AudioCodecMeta audioCodecMeta) throws IOException {
        if (this.outputFormat.isAudio()) {
            if (this.audioOutputTrack == null) {
                this.audioOutputTrack = this.muxer.addAudioTrack(this.outputAudioCodec, audioCodecMeta);
            }
            this.audioOutputTrack.addFrame(packet);
            this.framesOutput = true;
        }
    }

    @Override // org.jcodec.api.transcode.Sink
    public void outputVideoFrame(VideoFrameWithPacket videoFrameWithPacket) throws IOException {
        if (!this.outputFormat.isVideo() || this.outputVideoCodec == null) {
            return;
        }
        ByteBuffer byteBufferAllocate = this.bufferStore.get();
        int iEstimateBufferSize = this.videoEncoder.estimateBufferSize(videoFrameWithPacket.getFrame().getPicture());
        if (byteBufferAllocate == null || iEstimateBufferSize < byteBufferAllocate.capacity()) {
            byteBufferAllocate = ByteBuffer.allocate(iEstimateBufferSize);
            this.bufferStore.set(byteBufferAllocate);
        }
        byteBufferAllocate.clear();
        Picture picture = videoFrameWithPacket.getFrame().getPicture();
        VideoEncoder.EncodedFrame encodedFrameEncodeVideo = encodeVideo(picture, byteBufferAllocate);
        Packet packetCreatePacketWithData = Packet.createPacketWithData(videoFrameWithPacket.getPacket(), NIOUtils.clone(encodedFrameEncodeVideo.getData()));
        packetCreatePacketWithData.setFrameType(encodedFrameEncodeVideo.isKeyFrame() ? Packet.FrameType.KEY : Packet.FrameType.INTER);
        outputVideoPacket(packetCreatePacketWithData, VideoCodecMeta.createSimpleVideoCodecMeta(new Size(picture.getWidth(), picture.getHeight()), picture.getColor()));
    }

    @Override // org.jcodec.api.transcode.PacketSink
    public void outputVideoPacket(Packet packet, VideoCodecMeta videoCodecMeta) throws IOException {
        if (this.outputFormat.isVideo()) {
            if (this.videoOutputTrack == null) {
                this.videoOutputTrack = this.muxer.addVideoTrack(this.outputVideoCodec, videoCodecMeta);
            }
            this.videoOutputTrack.addFrame(packet);
            this.framesOutput = true;
        }
    }

    public void setInterlaced(Boolean bool) {
        this.interlaced = bool.booleanValue();
    }

    @Override // org.jcodec.api.transcode.Sink
    public void setOption(Options options, Object obj) {
        if (options == Options.PROFILE) {
            this.profile = (String) obj;
        } else if (options == Options.INTERLACED) {
            this.interlaced = ((Boolean) obj).booleanValue();
        }
    }

    public void setProfile(String str) {
        this.profile = str;
    }
}
