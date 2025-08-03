package org.jcodec.api;

import java.io.File;
import java.io.IOException;
import org.jcodec.api.transcode.PixelStore;
import org.jcodec.api.transcode.PixelStoreImpl;
import org.jcodec.api.transcode.Sink;
import org.jcodec.api.transcode.SinkImpl;
import org.jcodec.api.transcode.VideoFrameWithPacket;
import org.jcodec.common.Codec;
import org.jcodec.common.Format;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rational;
import org.jcodec.scale.ColorUtil;
import org.jcodec.scale.Transform;

/* loaded from: classes2.dex */
public class SequenceEncoder {
    private Rational fps;
    private int frameNo;
    private PixelStore pixelStore;
    private Sink sink;
    private int timestamp;
    private Transform transform;

    public SequenceEncoder(SeekableByteChannel seekableByteChannel, Rational rational, Format format, Codec codec, Codec codec2) throws IOException {
        this.fps = rational;
        SinkImpl sinkImplCreateWithStream = SinkImpl.createWithStream(seekableByteChannel, format, codec, codec2);
        this.sink = sinkImplCreateWithStream;
        sinkImplCreateWithStream.init();
        if (this.sink.getInputColor() != null) {
            this.transform = ColorUtil.getTransform(ColorSpace.RGB, this.sink.getInputColor());
        }
        this.pixelStore = new PixelStoreImpl();
    }

    public static SequenceEncoder create24Fps(File file) throws IOException {
        return new SequenceEncoder(NIOUtils.writableChannel(file), Rational.R(24, 1), Format.MOV, Codec.H264, null);
    }

    public static SequenceEncoder create25Fps(File file) throws IOException {
        return new SequenceEncoder(NIOUtils.writableChannel(file), Rational.R(25, 1), Format.MOV, Codec.H264, null);
    }

    public static SequenceEncoder create2997Fps(File file) throws IOException {
        return new SequenceEncoder(NIOUtils.writableChannel(file), Rational.R(30000, 1001), Format.MOV, Codec.H264, null);
    }

    public static SequenceEncoder create30Fps(File file) throws IOException {
        return new SequenceEncoder(NIOUtils.writableChannel(file), Rational.R(30, 1), Format.MOV, Codec.H264, null);
    }

    public static SequenceEncoder createSequenceEncoder(File file, int i) throws IOException {
        return new SequenceEncoder(NIOUtils.writableChannel(file), Rational.R(i, 1), Format.MOV, Codec.H264, null);
    }

    public static SequenceEncoder createWithFps(SeekableByteChannel seekableByteChannel, Rational rational) throws IOException {
        return new SequenceEncoder(seekableByteChannel, rational, Format.MOV, Codec.H264, null);
    }

    public void encodeNativeFrame(Picture picture) throws IOException {
        PixelStore.LoanerPicture loanerPicture;
        if (picture.getColor() != ColorSpace.RGB) {
            throw new IllegalArgumentException("The input images is expected in RGB color.");
        }
        ColorSpace inputColor = this.sink.getInputColor();
        if (inputColor != null) {
            loanerPicture = this.pixelStore.getPicture(picture.getWidth(), picture.getHeight(), inputColor);
            this.transform.transform(picture, loanerPicture.getPicture());
        } else {
            loanerPicture = new PixelStore.LoanerPicture(picture, 0);
        }
        this.sink.outputVideoFrame(new VideoFrameWithPacket(Packet.createPacket(null, this.timestamp, this.fps.getNum(), this.fps.getDen(), this.frameNo, Packet.FrameType.KEY, null), loanerPicture));
        if (inputColor != null) {
            this.pixelStore.putBack(loanerPicture);
        }
        this.timestamp += this.fps.getDen();
        this.frameNo++;
    }

    public void finish() throws IOException {
        this.sink.finish();
    }
}
