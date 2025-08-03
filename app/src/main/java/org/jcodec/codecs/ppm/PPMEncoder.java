package org.jcodec.codecs.ppm;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.nio.ByteBuffer;
import org.jcodec.common.JCodecUtil2;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public class PPMEncoder {
    public ByteBuffer encodeFrame(Picture picture) {
        if (picture.getColor() != ColorSpace.RGB) {
            throw new IllegalArgumentException("Only RGB image can be stored in PPM");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((picture.getWidth() * picture.getHeight() * 3) + 200);
        byteBufferAllocate.put(JCodecUtil2.asciiString("P6 " + picture.getWidth() + MyUTIL.white_space + picture.getHeight() + " 255\n"));
        byte[][] data = picture.getData();
        for (int i = 0; i < picture.getWidth() * picture.getHeight() * 3; i += 3) {
            byteBufferAllocate.put((byte) (data[0][i + 2] + BER.ASN_LONG_LEN));
            byteBufferAllocate.put((byte) (data[0][i + 1] + BER.ASN_LONG_LEN));
            byteBufferAllocate.put((byte) (data[0][i] + BER.ASN_LONG_LEN));
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }
}
