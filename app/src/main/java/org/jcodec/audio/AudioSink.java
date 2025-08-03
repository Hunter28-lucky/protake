package org.jcodec.audio;

import java.io.IOException;
import java.nio.FloatBuffer;

/* loaded from: classes2.dex */
public interface AudioSink {
    void writeFloat(FloatBuffer floatBuffer) throws IOException;
}
