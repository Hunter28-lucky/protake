package org.jcodec.common;

import java.nio.ByteBuffer;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public abstract class VideoEncoder {

    public static class EncodedFrame {
        private ByteBuffer data;
        private boolean keyFrame;

        public EncodedFrame(ByteBuffer byteBuffer, boolean z) {
            this.data = byteBuffer;
            this.keyFrame = z;
        }

        public ByteBuffer getData() {
            return this.data;
        }

        public boolean isKeyFrame() {
            return this.keyFrame;
        }
    }

    public abstract EncodedFrame encodeFrame(Picture picture, ByteBuffer byteBuffer);

    public abstract int estimateBufferSize(Picture picture);

    public abstract ColorSpace[] getSupportedColorSpaces();
}
