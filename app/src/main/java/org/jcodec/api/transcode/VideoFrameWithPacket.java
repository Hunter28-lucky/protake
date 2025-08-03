package org.jcodec.api.transcode;

import org.jcodec.api.transcode.PixelStore;
import org.jcodec.common.model.Packet;

/* loaded from: classes2.dex */
public class VideoFrameWithPacket implements Comparable<VideoFrameWithPacket> {
    private PixelStore.LoanerPicture frame;
    private Packet packet;

    public VideoFrameWithPacket(Packet packet, PixelStore.LoanerPicture loanerPicture) {
        this.packet = packet;
        this.frame = loanerPicture;
    }

    public PixelStore.LoanerPicture getFrame() {
        return this.frame;
    }

    public Packet getPacket() {
        return this.packet;
    }

    @Override // java.lang.Comparable
    public int compareTo(VideoFrameWithPacket videoFrameWithPacket) {
        if (videoFrameWithPacket == null) {
            return -1;
        }
        long pts = this.packet.getPts();
        long pts2 = videoFrameWithPacket.packet.getPts();
        if (pts > pts2) {
            return 1;
        }
        return pts == pts2 ? 0 : -1;
    }
}
