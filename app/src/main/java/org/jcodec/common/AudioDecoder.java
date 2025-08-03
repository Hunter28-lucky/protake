package org.jcodec.common;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.model.AudioBuffer;

/* loaded from: classes2.dex */
public interface AudioDecoder {
    AudioBuffer decodeFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws IOException;

    AudioCodecMeta getCodecMeta(ByteBuffer byteBuffer) throws IOException;
}
