package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class DataRefBox extends NodeBox {
    public DataRefBox(Header header) {
        super(header);
    }

    public static DataRefBox createDataRefBox() {
        return new DataRefBox(new Header(fourcc()));
    }

    public static String fourcc() {
        return "dref";
    }

    @Override // org.jcodec.containers.mp4.boxes.NodeBox, org.jcodec.containers.mp4.boxes.Box
    public void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.putInt(0);
        byteBuffer.putInt(this.boxes.size());
        super.doWrite(byteBuffer);
    }

    @Override // org.jcodec.containers.mp4.boxes.NodeBox, org.jcodec.containers.mp4.boxes.Box
    public int estimateSize() {
        return super.estimateSize() + 8;
    }

    @Override // org.jcodec.containers.mp4.boxes.NodeBox, org.jcodec.containers.mp4.boxes.Box
    public void parse(ByteBuffer byteBuffer) {
        byteBuffer.getInt();
        byteBuffer.getInt();
        super.parse(byteBuffer);
    }
}
