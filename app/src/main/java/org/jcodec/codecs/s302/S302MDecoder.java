package org.jcodec.codecs.s302;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.cb;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.AudioDecoder;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.model.AudioBuffer;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class S302MDecoder implements AudioDecoder {
    public static int SAMPLE_RATE = 48000;

    @Override // org.jcodec.common.AudioDecoder
    public AudioBuffer decodeFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
        int i = byteBuffer.getInt();
        if (byteBuffer.remaining() != ((i >> 16) & 65535)) {
            throw new IllegalArgumentException("Wrong s302m frame");
        }
        int i2 = (((i >> 14) & 3) * 2) + 2;
        int i3 = (((i >> 4) & 3) * 4) + 16;
        if (i3 == 24) {
            int iRemaining = (byteBuffer.remaining() / 7) * 2;
            while (byteBuffer.remaining() > 6) {
                byte bReverse = (byte) MathUtil.reverse(byteBuffer.get() & ExifInterface.MARKER);
                byte bReverse2 = (byte) MathUtil.reverse(byteBuffer.get() & ExifInterface.MARKER);
                byte bReverse3 = (byte) MathUtil.reverse(byteBuffer.get() & ExifInterface.MARKER);
                int iReverse = MathUtil.reverse(byteBuffer.get() & cb.m);
                int iReverse2 = MathUtil.reverse(byteBuffer.get() & ExifInterface.MARKER);
                int iReverse3 = MathUtil.reverse(byteBuffer.get() & ExifInterface.MARKER);
                int iReverse4 = MathUtil.reverse(byteBuffer.get() & 240);
                byteBufferDuplicate.put(bReverse3);
                byteBufferDuplicate.put(bReverse2);
                byteBufferDuplicate.put(bReverse);
                byteBufferDuplicate.put((byte) ((iReverse4 << 4) | (iReverse3 >> 4)));
                byteBufferDuplicate.put((byte) ((iReverse3 << 4) | (iReverse2 >> 4)));
                byteBufferDuplicate.put((byte) ((iReverse2 << 4) | (iReverse >> 4)));
            }
            byteBufferDuplicate.flip();
            return new AudioBuffer(byteBufferDuplicate, new AudioFormat(SAMPLE_RATE, 24, i2, true, true), iRemaining / i2);
        }
        if (i3 != 20) {
            int iRemaining2 = (byteBuffer.remaining() / 5) * 2;
            while (byteBuffer.remaining() > 4) {
                byte bReverse4 = (byte) MathUtil.reverse(byteBuffer.get() & ExifInterface.MARKER);
                byte bReverse5 = (byte) MathUtil.reverse(byteBuffer.get() & ExifInterface.MARKER);
                int iReverse5 = MathUtil.reverse(byteBuffer.get() & ExifInterface.MARKER);
                int iReverse6 = MathUtil.reverse(byteBuffer.get() & ExifInterface.MARKER);
                int iReverse7 = MathUtil.reverse(byteBuffer.get() & 240);
                byteBuffer2.put(bReverse5);
                byteBuffer2.put(bReverse4);
                byteBuffer2.put((byte) ((iReverse7 << 4) | (iReverse6 >> 4)));
                byteBuffer2.put((byte) ((iReverse6 << 4) | (iReverse5 >> 4)));
            }
            byteBufferDuplicate.flip();
            return new AudioBuffer(byteBufferDuplicate, new AudioFormat(SAMPLE_RATE, 16, i2, true, true), iRemaining2 / i2);
        }
        int iRemaining3 = (byteBuffer.remaining() / 6) * 2;
        while (byteBuffer.remaining() > 5) {
            int iReverse8 = MathUtil.reverse(byteBuffer.get() & ExifInterface.MARKER);
            int iReverse9 = MathUtil.reverse(byteBuffer.get() & ExifInterface.MARKER);
            byteBufferDuplicate.put((byte) ((MathUtil.reverse(byteBuffer.get() & 240) << 4) | (iReverse9 >> 4)));
            byteBufferDuplicate.put((byte) ((iReverse9 << 4) | (iReverse8 >> 4)));
            byteBufferDuplicate.put((byte) (iReverse8 << 4));
            int iReverse10 = MathUtil.reverse(byteBuffer.get() & ExifInterface.MARKER);
            int iReverse11 = MathUtil.reverse(byteBuffer.get() & ExifInterface.MARKER);
            byteBufferDuplicate.put((byte) ((MathUtil.reverse(byteBuffer.get() & 240) << 4) | (iReverse11 >> 4)));
            byteBufferDuplicate.put((byte) ((iReverse11 << 4) | (iReverse10 >> 4)));
            byteBufferDuplicate.put((byte) (iReverse10 << 4));
        }
        byteBufferDuplicate.flip();
        return new AudioBuffer(byteBufferDuplicate, new AudioFormat(SAMPLE_RATE, 24, i2, true, true), iRemaining3 / i2);
    }

    @Override // org.jcodec.common.AudioDecoder
    public AudioCodecMeta getCodecMeta(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        int i = byteBufferDuplicate.getInt();
        if (byteBufferDuplicate.remaining() != ((i >> 16) & 65535)) {
            throw new IllegalArgumentException("Wrong s302m frame");
        }
        int i2 = (((i >> 14) & 3) * 2) + 2;
        return AudioCodecMeta.fromAudioFormat(new AudioFormat(SAMPLE_RATE, (((i >> 4) & 3) * 4) + 16, i2, true, true));
    }
}
