package org.jcodec.containers.mp4.boxes;

/* loaded from: classes2.dex */
public class WaveExtension extends NodeBox {
    public WaveExtension(Header header) {
        super(header);
    }

    public static String fourcc() {
        return "wave";
    }
}
