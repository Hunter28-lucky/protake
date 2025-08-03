package org.jcodec.containers.mp4.boxes;

/* loaded from: classes2.dex */
public class MediaBox extends NodeBox {
    public MediaBox(Header header) {
        super(header);
    }

    public static MediaBox createMediaBox() {
        return new MediaBox(new Header(fourcc()));
    }

    public static String fourcc() {
        return "mdia";
    }

    public MediaInfoBox getMinf() {
        return (MediaInfoBox) NodeBox.findFirst(this, MediaInfoBox.class, "minf");
    }
}
