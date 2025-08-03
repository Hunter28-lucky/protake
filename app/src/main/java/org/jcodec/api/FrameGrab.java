package org.jcodec.api;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.api.specific.AVCMP4Adaptor;
import org.jcodec.api.specific.ContainerAdaptor;
import org.jcodec.common.Codec;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.Format;
import org.jcodec.common.JCodecUtil;
import org.jcodec.common.SeekableDemuxerTrack;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Picture;
import org.jcodec.containers.mp4.demuxer.MP4Demuxer;

/* loaded from: classes2.dex */
public class FrameGrab {
    private final ThreadLocal<byte[][]> buffers = new ThreadLocal<>();
    private ContainerAdaptor decoder;
    private SeekableDemuxerTrack videoTrack;

    public FrameGrab(SeekableDemuxerTrack seekableDemuxerTrack, ContainerAdaptor containerAdaptor) {
        this.videoTrack = seekableDemuxerTrack;
        this.decoder = containerAdaptor;
    }

    public static FrameGrab createFrameGrab(SeekableByteChannel seekableByteChannel) throws JCodecException, IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(65536);
        seekableByteChannel.read(byteBufferAllocate);
        byteBufferAllocate.flip();
        Format formatDetectFormatBuffer = JCodecUtil.detectFormatBuffer(byteBufferAllocate);
        if (formatDetectFormatBuffer == null) {
            throw new UnsupportedFormatException("Could not detect the format of the input video.");
        }
        if (Format.MOV == formatDetectFormatBuffer) {
            SeekableDemuxerTrack seekableDemuxerTrack = (SeekableDemuxerTrack) MP4Demuxer.createMP4Demuxer(seekableByteChannel).getVideoTrack();
            FrameGrab frameGrab = new FrameGrab(seekableDemuxerTrack, detectDecoder(seekableDemuxerTrack));
            frameGrab.decodeLeadingFrames();
            return frameGrab;
        }
        if (Format.MPEG_PS == formatDetectFormatBuffer) {
            throw new UnsupportedFormatException("MPEG PS is temporarily unsupported.");
        }
        if (Format.MPEG_TS == formatDetectFormatBuffer) {
            throw new UnsupportedFormatException("MPEG TS is temporarily unsupported.");
        }
        throw new UnsupportedFormatException("Container format is not supported by JCodec");
    }

    private void decodeLeadingFrames() throws JCodecException, IOException {
        SeekableDemuxerTrack seekableDemuxerTrackSdt = sdt();
        int curFrame = (int) seekableDemuxerTrackSdt.getCurFrame();
        seekableDemuxerTrackSdt.gotoFrame(detectKeyFrame(curFrame));
        Packet packetNextFrame = seekableDemuxerTrackSdt.nextFrame();
        if (this.decoder == null) {
            this.decoder = detectDecoder(seekableDemuxerTrackSdt);
        }
        while (true) {
            long j = curFrame;
            if (packetNextFrame.getFrameNo() >= j) {
                seekableDemuxerTrackSdt.gotoFrame(j);
                return;
            } else {
                this.decoder.decodeFrame(packetNextFrame, getBuffer());
                packetNextFrame = seekableDemuxerTrackSdt.nextFrame();
            }
        }
    }

    private static ContainerAdaptor detectDecoder(SeekableDemuxerTrack seekableDemuxerTrack) throws JCodecException {
        DemuxerTrackMeta meta = seekableDemuxerTrack.getMeta();
        if (Codec.H264 == meta.getCodec()) {
            return new AVCMP4Adaptor(meta);
        }
        throw new UnsupportedFormatException("Codec is not supported");
    }

    private int detectKeyFrame(int i) throws IOException {
        int i2;
        int[] seekFrames = this.videoTrack.getMeta().getSeekFrames();
        if (seekFrames == null) {
            return i;
        }
        int i3 = seekFrames[0];
        int i4 = 1;
        while (i4 < seekFrames.length && (i2 = seekFrames[i4]) <= i) {
            i4++;
            i3 = i2;
        }
        return i3;
    }

    private byte[][] getBuffer() {
        byte[][] bArr = this.buffers.get();
        if (bArr != null) {
            return bArr;
        }
        byte[][] bArrAllocatePicture = this.decoder.allocatePicture();
        this.buffers.set(bArrAllocatePicture);
        return bArrAllocatePicture;
    }

    public static Picture getFrameAtSec(File file, double d) throws Throwable {
        FileChannelWrapper fileChannelWrapper;
        try {
            fileChannelWrapper = NIOUtils.readableChannel(file);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapper = null;
        }
        try {
            Picture nativeFrame = createFrameGrab(fileChannelWrapper).seekToSecondPrecise(d).getNativeFrame();
            NIOUtils.closeQuietly(fileChannelWrapper);
            return nativeFrame;
        } catch (Throwable th2) {
            th = th2;
            NIOUtils.closeQuietly(fileChannelWrapper);
            throw th;
        }
    }

    public static Picture getFrameFromChannel(SeekableByteChannel seekableByteChannel, int i) throws JCodecException, IOException {
        return createFrameGrab(seekableByteChannel).seekToFramePrecise(i).getNativeFrame();
    }

    public static Picture getFrameFromChannelAtSec(SeekableByteChannel seekableByteChannel, double d) throws JCodecException, IOException {
        return createFrameGrab(seekableByteChannel).seekToSecondPrecise(d).getNativeFrame();
    }

    public static Picture getFrameFromFile(File file, int i) throws Throwable {
        FileChannelWrapper fileChannelWrapper;
        try {
            fileChannelWrapper = NIOUtils.readableChannel(file);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapper = null;
        }
        try {
            Picture nativeFrame = createFrameGrab(fileChannelWrapper).seekToFramePrecise(i).getNativeFrame();
            NIOUtils.closeQuietly(fileChannelWrapper);
            return nativeFrame;
        } catch (Throwable th2) {
            th = th2;
            NIOUtils.closeQuietly(fileChannelWrapper);
            throw th;
        }
    }

    public static Picture getNativeFrameAtFrame(SeekableDemuxerTrack seekableDemuxerTrack, ContainerAdaptor containerAdaptor, int i) throws JCodecException, IOException {
        return new FrameGrab(seekableDemuxerTrack, containerAdaptor).seekToFramePrecise(i).getNativeFrame();
    }

    public static Picture getNativeFrameAtSec(SeekableDemuxerTrack seekableDemuxerTrack, ContainerAdaptor containerAdaptor, double d) throws JCodecException, IOException {
        return new FrameGrab(seekableDemuxerTrack, containerAdaptor).seekToSecondPrecise(d).getNativeFrame();
    }

    public static Picture getNativeFrameAtSecSloppy(SeekableDemuxerTrack seekableDemuxerTrack, ContainerAdaptor containerAdaptor, double d) throws JCodecException, IOException {
        return new FrameGrab(seekableDemuxerTrack, containerAdaptor).seekToSecondSloppy(d).getNativeFrame();
    }

    public static Picture getNativeFrameSloppy(SeekableDemuxerTrack seekableDemuxerTrack, ContainerAdaptor containerAdaptor, int i) throws JCodecException, IOException {
        return new FrameGrab(seekableDemuxerTrack, containerAdaptor).seekToFrameSloppy(i).getNativeFrame();
    }

    private void goToPrevKeyframe() throws JCodecException, IOException {
        sdt().gotoFrame(detectKeyFrame((int) sdt().getCurFrame()));
    }

    private SeekableDemuxerTrack sdt() throws JCodecException {
        SeekableDemuxerTrack seekableDemuxerTrack = this.videoTrack;
        if (seekableDemuxerTrack instanceof SeekableDemuxerTrack) {
            return seekableDemuxerTrack;
        }
        throw new JCodecException("Not a seekable track");
    }

    public ContainerAdaptor getDecoder() {
        return this.decoder;
    }

    public MediaInfo getMediaInfo() {
        return this.decoder.getMediaInfo();
    }

    public Picture getNativeFrame() throws IOException {
        Packet packetNextFrame = this.videoTrack.nextFrame();
        if (packetNextFrame == null) {
            return null;
        }
        return this.decoder.decodeFrame(packetNextFrame, getBuffer());
    }

    public PictureWithMetadata getNativeFrameWithMetadata() throws IOException {
        Packet packetNextFrame = this.videoTrack.nextFrame();
        if (packetNextFrame == null) {
            return null;
        }
        return new PictureWithMetadata(this.decoder.decodeFrame(packetNextFrame, getBuffer()), packetNextFrame.getPtsD(), packetNextFrame.getDurationD(), this.videoTrack.getMeta().getOrientation());
    }

    public SeekableDemuxerTrack getVideoTrack() {
        return this.videoTrack;
    }

    public FrameGrab seekToFramePrecise(int i) throws JCodecException, IOException {
        sdt().gotoFrame(i);
        decodeLeadingFrames();
        return this;
    }

    public FrameGrab seekToFrameSloppy(int i) throws JCodecException, IOException {
        sdt().gotoFrame(i);
        goToPrevKeyframe();
        return this;
    }

    public FrameGrab seekToSecondPrecise(double d) throws JCodecException, IOException {
        sdt().seek(d);
        decodeLeadingFrames();
        return this;
    }

    public FrameGrab seekToSecondSloppy(double d) throws JCodecException, IOException {
        sdt().seek(d);
        goToPrevKeyframe();
        return this;
    }
}
