package org.jcodec.codecs.mpeg4.es;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.jcodec.common.JCodecUtil2;
import org.jcodec.common.Preconditions;
import org.jcodec.common.UsedViaReflection;
import org.jcodec.common.io.NIOUtils;

/* loaded from: classes2.dex */
public class DescriptorParser {
    private static final int DC_TAG = 4;
    private static final int DS_TAG = 5;
    private static final int ES_TAG = 3;
    private static final int SL_TAG = 6;

    private static DecoderConfig parseDecoderConfig(ByteBuffer byteBuffer) {
        int i = byteBuffer.get() & ExifInterface.MARKER;
        byteBuffer.get();
        return new DecoderConfig(i, ((byteBuffer.get() & ExifInterface.MARKER) << 16) | (byteBuffer.getShort() & 65535), byteBuffer.getInt(), byteBuffer.getInt(), parseNodeDesc(byteBuffer).getChildren());
    }

    private static DecoderSpecific parseDecoderSpecific(ByteBuffer byteBuffer) {
        return new DecoderSpecific(NIOUtils.readBuf(byteBuffer));
    }

    private static ES parseES(ByteBuffer byteBuffer) {
        short s = byteBuffer.getShort();
        byteBuffer.get();
        return new ES(s, parseNodeDesc(byteBuffer).getChildren());
    }

    @UsedViaReflection
    private static NodeDescriptor parseNodeDesc(ByteBuffer byteBuffer) {
        Descriptor descriptor;
        ArrayList arrayList = new ArrayList();
        do {
            descriptor = read(byteBuffer);
            if (descriptor != null) {
                arrayList.add(descriptor);
            }
        } while (descriptor != null);
        return new NodeDescriptor(0, arrayList);
    }

    private static SL parseSL(ByteBuffer byteBuffer) {
        Preconditions.checkState(2 == (byteBuffer.get() & ExifInterface.MARKER));
        return new SL();
    }

    public static Descriptor read(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 2) {
            return null;
        }
        int i = byteBuffer.get() & ExifInterface.MARKER;
        ByteBuffer byteBuffer2 = NIOUtils.read(byteBuffer, JCodecUtil2.readBER32(byteBuffer));
        if (i == 3) {
            return parseES(byteBuffer2);
        }
        if (i == 4) {
            return parseDecoderConfig(byteBuffer2);
        }
        if (i == 5) {
            return parseDecoderSpecific(byteBuffer2);
        }
        if (i == 6) {
            return parseSL(byteBuffer2);
        }
        throw new RuntimeException("unknown tag " + i);
    }
}
