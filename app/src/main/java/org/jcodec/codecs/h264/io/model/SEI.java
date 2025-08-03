package org.jcodec.codecs.h264.io.model;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.jcodec.codecs.h264.io.write.CAVLCWriter;
import org.jcodec.common.io.BitWriter;

/* loaded from: classes2.dex */
public class SEI {
    public SEIMessage[] messages;

    public static class SEIMessage {
        public byte[] payload;
        public int payloadSize;
        public int payloadType;

        public SEIMessage(int i, int i2, byte[] bArr) {
            this.payload = bArr;
            this.payloadType = i;
            this.payloadSize = i2;
        }
    }

    public SEI(SEIMessage[] sEIMessageArr) {
        this.messages = sEIMessageArr;
    }

    public static SEI read(ByteBuffer byteBuffer) {
        SEIMessage sEIMessageSei_message;
        ArrayList arrayList = new ArrayList();
        do {
            sEIMessageSei_message = sei_message(byteBuffer);
            if (sEIMessageSei_message != null) {
                arrayList.add(sEIMessageSei_message);
            }
        } while (sEIMessageSei_message != null);
        return new SEI((SEIMessage[]) arrayList.toArray(new SEIMessage[0]));
    }

    private static SEIMessage sei_message(ByteBuffer byteBuffer) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (byteBuffer.hasRemaining() && (i3 = byteBuffer.get() & ExifInterface.MARKER) == 255) {
            i2 += 255;
        }
        if (!byteBuffer.hasRemaining()) {
            return null;
        }
        int i4 = i2 + i3;
        while (byteBuffer.hasRemaining() && (i3 = byteBuffer.get() & ExifInterface.MARKER) == 255) {
            i += 255;
        }
        if (!byteBuffer.hasRemaining()) {
            return null;
        }
        int i5 = i + i3;
        byte[] bArrSei_payload = sei_payload(i4, i5, byteBuffer);
        if (bArrSei_payload.length != i5) {
            return null;
        }
        return new SEIMessage(i4, i5, bArrSei_payload);
    }

    private static byte[] sei_payload(int i, int i2, ByteBuffer byteBuffer) {
        byte[] bArr = new byte[i2];
        byteBuffer.get(bArr);
        return bArr;
    }

    public void write(ByteBuffer byteBuffer) {
        CAVLCWriter.writeTrailingBits(new BitWriter(byteBuffer));
    }
}
