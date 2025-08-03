package org.jcodec.api.specific;

import java.nio.ByteBuffer;
import org.jcodec.api.MediaInfo;
import org.jcodec.codecs.h264.H264Decoder;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mp4.MP4Packet;

/* loaded from: classes2.dex */
public class AVCMP4Adaptor implements ContainerAdaptor {
    private int curENo = -1;
    private H264Decoder decoder;
    private DemuxerTrackMeta meta;
    private Size size;

    public AVCMP4Adaptor(DemuxerTrackMeta demuxerTrackMeta) {
        this.meta = demuxerTrackMeta;
        calcBufferSize();
    }

    private void calcBufferSize() {
        ByteBuffer byteBufferDuplicate = this.meta.getCodecPrivate().duplicate();
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MIN_VALUE;
        while (true) {
            ByteBuffer byteBufferNextNALUnit = H264Utils.nextNALUnit(byteBufferDuplicate);
            if (byteBufferNextNALUnit == null) {
                this.size = new Size(i << 4, i2 << 4);
                return;
            }
            if (NALUnit.read(byteBufferNextNALUnit).type == NALUnitType.SPS) {
                SeqParameterSet sps = H264Utils.readSPS(byteBufferNextNALUnit);
                int i3 = sps.picWidthInMbsMinus1 + 1;
                if (i3 > i) {
                    i = i3;
                }
                int picHeightInMbs = SeqParameterSet.getPicHeightInMbs(sps);
                if (picHeightInMbs > i2) {
                    i2 = picHeightInMbs;
                }
            }
        }
    }

    private void updateState(Packet packet) {
        int entryNo = ((MP4Packet) packet).getEntryNo();
        if (entryNo != this.curENo) {
            this.curENo = entryNo;
        }
        if (this.decoder == null) {
            this.decoder = H264Decoder.createH264DecoderFromCodecPrivate(this.meta.getCodecPrivate());
        }
    }

    @Override // org.jcodec.api.specific.ContainerAdaptor
    public byte[][] allocatePicture() {
        return Picture.create(this.size.getWidth(), this.size.getHeight(), ColorSpace.YUV444).getData();
    }

    @Override // org.jcodec.api.specific.ContainerAdaptor
    public boolean canSeek(Packet packet) {
        updateState(packet);
        return H264Utils.idrSlice(H264Utils.splitFrame(packet.getData()));
    }

    @Override // org.jcodec.api.specific.ContainerAdaptor
    public Picture decodeFrame(Packet packet, byte[][] bArr) {
        updateState(packet);
        Frame frameDecodeFrame = this.decoder.decodeFrame(packet.getData(), bArr);
        this.meta.getVideoCodecMeta().getPixelAspectRatio();
        return frameDecodeFrame;
    }

    @Override // org.jcodec.api.specific.ContainerAdaptor
    public MediaInfo getMediaInfo() {
        return new MediaInfo(this.size);
    }
}
