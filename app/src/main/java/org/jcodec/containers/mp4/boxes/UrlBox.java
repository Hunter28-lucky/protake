package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class UrlBox extends FullBox {
    private String url;

    public UrlBox(Header header) {
        super(header);
    }

    public static UrlBox createUrlBox(String str) {
        UrlBox urlBox = new UrlBox(new Header(fourcc()));
        urlBox.url = str;
        return urlBox;
    }

    public static String fourcc() {
        return "url ";
    }

    @Override // org.jcodec.containers.mp4.boxes.FullBox, org.jcodec.containers.mp4.boxes.Box
    public void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        String str = this.url;
        if (str != null) {
            NIOUtils.write(byteBuffer, ByteBuffer.wrap(Platform.getBytesForCharset(str, Platform.UTF_8)));
            byteBuffer.put((byte) 0);
        }
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public int estimateSize() {
        String str = this.url;
        if (str != null) {
            return 13 + Platform.getBytesForCharset(str, Platform.UTF_8).length;
        }
        return 13;
    }

    public String getUrl() {
        return this.url;
    }

    @Override // org.jcodec.containers.mp4.boxes.FullBox, org.jcodec.containers.mp4.boxes.Box
    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        if ((this.flags & 1) != 0) {
            return;
        }
        this.url = NIOUtils.readNullTermStringCharset(byteBuffer, Platform.UTF_8);
    }
}
