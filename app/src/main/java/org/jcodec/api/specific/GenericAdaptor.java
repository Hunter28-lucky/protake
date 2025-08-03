package org.jcodec.api.specific;

import org.jcodec.api.MediaInfo;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Size;
import org.jcodec.containers.dpx.DPXReader;

/* loaded from: classes2.dex */
public class GenericAdaptor implements ContainerAdaptor {
    private VideoDecoder decoder;

    public GenericAdaptor(VideoDecoder videoDecoder) {
        this.decoder = videoDecoder;
    }

    @Override // org.jcodec.api.specific.ContainerAdaptor
    public byte[][] allocatePicture() {
        return Picture.create(DPXReader.TVINFO_OFFSET, 1088, ColorSpace.YUV444).getData();
    }

    @Override // org.jcodec.api.specific.ContainerAdaptor
    public boolean canSeek(Packet packet) {
        return true;
    }

    @Override // org.jcodec.api.specific.ContainerAdaptor
    public Picture decodeFrame(Packet packet, byte[][] bArr) {
        return this.decoder.decodeFrame(packet.getData(), bArr);
    }

    @Override // org.jcodec.api.specific.ContainerAdaptor
    public MediaInfo getMediaInfo() {
        return new MediaInfo(new Size(0, 0));
    }
}
