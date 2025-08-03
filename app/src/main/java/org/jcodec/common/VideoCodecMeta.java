package org.jcodec.common;

import java.nio.ByteBuffer;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;

/* loaded from: classes2.dex */
public class VideoCodecMeta extends CodecMeta {
    private ColorSpace color;
    private boolean interlaced;
    private Rational pasp;
    private Size size;
    private boolean topFieldFirst;

    public VideoCodecMeta(String str, ByteBuffer byteBuffer) {
        super(str, byteBuffer);
    }

    public static VideoCodecMeta createSimpleVideoCodecMeta(Size size, ColorSpace colorSpace) {
        VideoCodecMeta videoCodecMeta = new VideoCodecMeta(null, null);
        videoCodecMeta.size = size;
        videoCodecMeta.color = colorSpace;
        return videoCodecMeta;
    }

    public static VideoCodecMeta createVideoCodecMeta(String str, ByteBuffer byteBuffer, Size size, Rational rational) {
        VideoCodecMeta videoCodecMeta = new VideoCodecMeta(str, byteBuffer);
        videoCodecMeta.size = size;
        videoCodecMeta.pasp = rational;
        return videoCodecMeta;
    }

    public static VideoCodecMeta createVideoCodecMeta2(String str, ByteBuffer byteBuffer, Size size, Rational rational, boolean z, boolean z2) {
        VideoCodecMeta videoCodecMeta = new VideoCodecMeta(str, byteBuffer);
        videoCodecMeta.size = size;
        videoCodecMeta.pasp = rational;
        videoCodecMeta.interlaced = z;
        videoCodecMeta.topFieldFirst = z2;
        return videoCodecMeta;
    }

    public ColorSpace getColor() {
        return this.color;
    }

    public Rational getPasp() {
        return this.pasp;
    }

    public Rational getPixelAspectRatio() {
        return this.pasp;
    }

    public Size getSize() {
        return this.size;
    }

    public boolean isInterlaced() {
        return this.interlaced;
    }

    public boolean isTopFieldFirst() {
        return this.topFieldFirst;
    }

    public void setPixelAspectRatio(Rational rational) {
        this.pasp = rational;
    }
}
