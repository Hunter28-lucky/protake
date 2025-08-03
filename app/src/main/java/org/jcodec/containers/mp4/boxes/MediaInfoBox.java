package org.jcodec.containers.mp4.boxes;

/* loaded from: classes2.dex */
public class MediaInfoBox extends NodeBox {
    public MediaInfoBox(Header header) {
        super(header);
    }

    public static MediaInfoBox createMediaInfoBox() {
        return new MediaInfoBox(new Header(fourcc()));
    }

    public static String fourcc() {
        return "minf";
    }

    public DataInfoBox getDinf() {
        return (DataInfoBox) NodeBox.findFirst(this, DataInfoBox.class, "dinf");
    }

    public NodeBox getStbl() {
        return (NodeBox) NodeBox.findFirst(this, NodeBox.class, "stbl");
    }
}
