package org.jcodec.codecs.mpeg12;

import androidx.core.app.FrameMetricsAggregator;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public class MPEGUtil {
    public static final ByteBuffer gotoMarker(ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (!byteBuffer.hasRemaining()) {
            return null;
        }
        int iPosition = byteBuffer.position();
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.order(ByteOrder.BIG_ENDIAN);
        int i4 = -1;
        while (true) {
            if (!byteBuffer.hasRemaining()) {
                break;
            }
            i4 = (i4 << 8) | (byteBuffer.get() & ExifInterface.MARKER);
            if (i4 >= i2 && i4 <= i3) {
                if (i == 0) {
                    byteBuffer.position(byteBuffer.position() - 4);
                    byteBufferSlice.limit(byteBuffer.position() - iPosition);
                    break;
                }
                i--;
            }
        }
        return byteBufferSlice;
    }

    public static final ByteBuffer gotoNextMarker(ByteBuffer byteBuffer) {
        return gotoMarker(byteBuffer, 0, 256, FrameMetricsAggregator.EVERY_DURATION);
    }

    public static final ByteBuffer nextSegment(ByteBuffer byteBuffer) {
        gotoMarker(byteBuffer, 0, 256, FrameMetricsAggregator.EVERY_DURATION);
        return gotoMarker(byteBuffer, 1, 256, FrameMetricsAggregator.EVERY_DURATION);
    }
}
