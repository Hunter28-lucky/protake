package org.jcodec.codecs.pcmdvd;

import androidx.exifinterface.media.ExifInterface;
import com.uc.crashsdk.export.LogType;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.AudioDecoder;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.AudioBuffer;

/* loaded from: classes2.dex */
public class PCMDVDDecoder implements AudioDecoder {
    private static final int[] lpcm_freq_tab = {48000, 96000, 44100, LogType.UNEXP_KNOWN_REASON};

    @Override // org.jcodec.common.AudioDecoder
    public AudioBuffer decodeFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
        ByteBuffer byteBufferDuplicate2 = byteBuffer.duplicate();
        byteBufferDuplicate2.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        int i = byteBufferDuplicate2.get() & ExifInterface.MARKER;
        NIOUtils.skip(byteBufferDuplicate2, 3);
        int i2 = i & 224;
        if (i2 != 160) {
            if (i2 != 128) {
                throw new RuntimeException("MPEG DVD unknown coded");
            }
            if ((i & 248) == 136) {
                throw new RuntimeException("CODEC_ID_DTS");
            }
            throw new RuntimeException("CODEC_ID_AC3");
        }
        byteBufferDuplicate2.get();
        int i3 = byteBufferDuplicate2.get() & ExifInterface.MARKER;
        byteBufferDuplicate2.get();
        int i4 = lpcm_freq_tab[(i3 >> 4) & 3];
        int i5 = (i3 & 7) + 1;
        int i6 = (((i3 >> 6) & 3) * 4) + 16;
        int iRemaining = byteBufferDuplicate2.remaining() / ((i6 >> 3) * i5);
        if (i6 == 20) {
            for (int i7 = 0; i7 < (iRemaining >> 1); i7++) {
                for (int i8 = 0; i8 < i5; i8++) {
                    byteBufferDuplicate.putShort(byteBufferDuplicate2.getShort());
                    byteBufferDuplicate.putShort(byteBufferDuplicate2.getShort());
                }
                NIOUtils.skip(byteBufferDuplicate2, i5);
            }
        } else if (i6 == 24) {
            for (int i9 = 0; i9 < (iRemaining >> 1); i9++) {
                for (int i10 = 0; i10 < i5; i10++) {
                    byteBufferDuplicate.putShort(byteBufferDuplicate2.getShort());
                    byteBufferDuplicate.putShort(byteBufferDuplicate2.getShort());
                }
                NIOUtils.skip(byteBufferDuplicate2, i5 << 1);
            }
        }
        byteBufferDuplicate.flip();
        return new AudioBuffer(byteBufferDuplicate, new AudioFormat(i4, i6, i5, true, false), iRemaining);
    }

    @Override // org.jcodec.common.AudioDecoder
    public AudioCodecMeta getCodecMeta(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        int i = byteBufferDuplicate.get() & ExifInterface.MARKER;
        NIOUtils.skip(byteBufferDuplicate, 3);
        int i2 = i & 224;
        if (i2 != 160) {
            if (i2 != 128) {
                throw new RuntimeException("MPEG DVD unknown coded");
            }
            if ((i & 248) == 136) {
                throw new RuntimeException("CODEC_ID_DTS");
            }
            throw new RuntimeException("CODEC_ID_AC3");
        }
        byteBufferDuplicate.get();
        int i3 = byteBufferDuplicate.get() & ExifInterface.MARKER;
        byteBufferDuplicate.get();
        return AudioCodecMeta.fromAudioFormat(new AudioFormat(lpcm_freq_tab[(i3 >> 4) & 3], (((i3 >> 6) & 3) * 4) + 16, (i3 & 7) + 1, true, false));
    }
}
