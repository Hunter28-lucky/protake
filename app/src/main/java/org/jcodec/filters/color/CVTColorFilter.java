package org.jcodec.filters.color;

import java.nio.ByteBuffer;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class CVTColorFilter {
    private static byte blue(int i, int i2) {
        int i3 = (((i2 * 1192) + (i * 2064)) + 512) >> 10;
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > 1023) {
            i3 = 1023;
        }
        return (byte) ((i3 >> 2) & 255);
    }

    private static byte green(int i, int i2, int i3) {
        int i4 = ((((i3 * 1192) - (i * 400)) - (i2 * 832)) + 512) >> 10;
        if (i4 < 0) {
            i4 = 0;
        } else if (i4 > 1023) {
            i4 = 1023;
        }
        return (byte) ((i4 >> 2) & 255);
    }

    private static byte red(int i, int i2) {
        int i3 = (((i2 * 1192) + (i * 1636)) + 512) >> 10;
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > 1023) {
            i3 = 1023;
        }
        return (byte) ((i3 >> 2) & 255);
    }

    public void yuv422BitTObgr24(Picture picture, ByteBuffer byteBuffer) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(picture.getPlaneData(0));
        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(picture.getPlaneData(1));
        ByteBuffer byteBufferWrap3 = ByteBuffer.wrap(picture.getPlaneData(2));
        while (byteBufferWrap.hasRemaining()) {
            int i = (byteBufferWrap.get() + 112) << 2;
            int i2 = (byteBufferWrap.get() + 112) << 2;
            int i3 = byteBufferWrap2.get() << 2;
            int i4 = byteBufferWrap3.get() << 2;
            byteBuffer.put(blue(i3, i));
            byteBuffer.put(green(i3, i4, i));
            byteBuffer.put(red(i4, i));
            byteBuffer.put(blue(i3, i2));
            byteBuffer.put(green(i3, i4, i2));
            byteBuffer.put(red(i4, i2));
        }
    }
}
