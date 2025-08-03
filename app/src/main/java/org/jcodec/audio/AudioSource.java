package org.jcodec.audio;

import java.io.IOException;
import java.nio.FloatBuffer;
import org.jcodec.common.AudioFormat;

/* loaded from: classes2.dex */
public interface AudioSource {
    AudioFormat getFormat();

    int readFloat(FloatBuffer floatBuffer) throws IOException;
}
