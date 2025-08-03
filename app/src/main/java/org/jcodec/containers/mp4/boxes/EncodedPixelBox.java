package org.jcodec.containers.mp4.boxes;

/* loaded from: classes2.dex */
public class EncodedPixelBox extends ClearApertureBox {
    public static final String ENOF = "enof";

    public EncodedPixelBox(Header header) {
        super(header);
    }

    public static EncodedPixelBox createEncodedPixelBox(int i, int i2) {
        EncodedPixelBox encodedPixelBox = new EncodedPixelBox(new Header(ENOF));
        encodedPixelBox.width = i;
        encodedPixelBox.height = i2;
        return encodedPixelBox;
    }
}
