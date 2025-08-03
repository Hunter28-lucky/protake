package org.jcodec.containers.mp4.boxes;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class FielExtension extends Box {
    private int order;
    private int type;

    public FielExtension(Header header) {
        super(header);
    }

    public static String fourcc() {
        return "fiel";
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) this.type);
        byteBuffer.put((byte) this.order);
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public int estimateSize() {
        return 10;
    }

    public String getOrderInterpretation() {
        if (!isInterlaced()) {
            return "";
        }
        int i = this.order;
        return i != 1 ? i != 6 ? i != 9 ? i != 14 ? "" : "topbottom" : "bottomtop" : "bottom" : "top";
    }

    public boolean isInterlaced() {
        return this.type == 2;
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public void parse(ByteBuffer byteBuffer) {
        this.type = byteBuffer.get() & ExifInterface.MARKER;
        if (isInterlaced()) {
            this.order = byteBuffer.get() & ExifInterface.MARKER;
        }
    }

    public boolean topFieldFirst() {
        int i = this.order;
        return i == 1 || i == 6;
    }
}
