package org.jcodec.codecs.mpeg12;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import org.jcodec.codecs.mpeg12.bitstream.PictureHeader;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.Packet;
import org.jcodec.containers.mps.MPEGPacket;

/* loaded from: classes2.dex */
public class MPEGES extends SegmentReader {
    private int frameNo;
    public long lastKnownDuration;

    public MPEGES(ReadableByteChannel readableByteChannel, int i) throws IOException {
        super(readableByteChannel, i);
    }

    public MPEGPacket frame(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        do {
            int i = this.curMarker;
            if (i == 256 || i == 435) {
                break;
            }
        } while (skipToMarker());
        while (this.curMarker != 256 && readToNextMarker(byteBufferDuplicate)) {
        }
        readToNextMarker(byteBufferDuplicate);
        do {
            int i2 = this.curMarker;
            if (i2 == 256 || i2 == 435) {
                break;
            }
        } while (readToNextMarker(byteBufferDuplicate));
        byteBufferDuplicate.flip();
        PictureHeader pictureHeader = MPEGDecoder.getPictureHeader(byteBufferDuplicate.duplicate());
        if (!byteBufferDuplicate.hasRemaining()) {
            return null;
        }
        int i3 = this.frameNo;
        this.frameNo = i3 + 1;
        return new MPEGPacket(byteBufferDuplicate, 0L, 90000, 0L, i3, pictureHeader.picture_coding_type <= 1 ? Packet.FrameType.KEY : Packet.FrameType.INTER, null);
    }

    public MPEGPacket getFrame() throws IOException {
        do {
            int i = this.curMarker;
            if (i == 256 || i == 435) {
                break;
            }
        } while (skipToMarker());
        ArrayList arrayList = new ArrayList();
        while (this.curMarker != 256 && !this.done) {
            readToNextMarkerBuffers(arrayList);
        }
        readToNextMarkerBuffers(arrayList);
        while (true) {
            int i2 = this.curMarker;
            if (i2 == 256 || i2 == 435 || this.done) {
                break;
            }
            readToNextMarkerBuffers(arrayList);
        }
        ByteBuffer byteBufferCombineBuffers = NIOUtils.combineBuffers(arrayList);
        PictureHeader pictureHeader = MPEGDecoder.getPictureHeader(byteBufferCombineBuffers.duplicate());
        if (!byteBufferCombineBuffers.hasRemaining()) {
            return null;
        }
        int i3 = this.frameNo;
        this.frameNo = i3 + 1;
        return new MPEGPacket(byteBufferCombineBuffers, 0L, 90000, 0L, i3, pictureHeader.picture_coding_type <= 1 ? Packet.FrameType.KEY : Packet.FrameType.INTER, null);
    }
}
