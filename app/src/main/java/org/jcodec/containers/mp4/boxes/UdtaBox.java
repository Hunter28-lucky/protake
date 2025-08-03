package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.containers.mp4.IBoxFactory;
import org.jcodec.containers.mp4.boxes.Box;

/* loaded from: classes2.dex */
public class UdtaBox extends NodeBox {
    private static final String FOURCC = "udta";

    public UdtaBox(Header header) {
        super(header);
    }

    public static UdtaBox createUdtaBox() {
        return new UdtaBox(Header.createHeader(fourcc(), 0L));
    }

    public static Box findGps(UdtaBox udtaBox) {
        for (Box box : udtaBox.getBoxes()) {
            if (box.getFourcc().endsWith("xyz")) {
                return box;
            }
        }
        return null;
    }

    public static String fourcc() {
        return FOURCC;
    }

    public static ByteBuffer getData(Box box) {
        if (box instanceof Box.LeafBox) {
            return ((Box.LeafBox) box).getData();
        }
        return null;
    }

    public String latlng() {
        ByteBuffer data;
        Box boxFindGps = findGps(this);
        if (boxFindGps == null || (data = getData(boxFindGps)) == null || data.remaining() < 4) {
            return null;
        }
        data.getInt();
        byte[] bArr = new byte[data.remaining()];
        data.get(bArr);
        return new String(bArr);
    }

    public MetaBox meta() {
        return (MetaBox) NodeBox.findFirst(this, MetaBox.class, MetaBox.fourcc());
    }

    @Override // org.jcodec.containers.mp4.boxes.NodeBox
    public void setFactory(final IBoxFactory iBoxFactory) {
        this.factory = new IBoxFactory() { // from class: org.jcodec.containers.mp4.boxes.UdtaBox.1
            @Override // org.jcodec.containers.mp4.IBoxFactory
            public Box newBox(Header header) {
                if (!header.getFourcc().equals(MetaBox.fourcc())) {
                    return iBoxFactory.newBox(header);
                }
                UdtaMetaBox udtaMetaBox = new UdtaMetaBox(header);
                udtaMetaBox.setFactory(iBoxFactory);
                return udtaMetaBox;
            }
        };
    }
}
