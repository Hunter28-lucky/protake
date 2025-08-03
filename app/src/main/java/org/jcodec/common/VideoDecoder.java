package org.jcodec.common;

import java.nio.ByteBuffer;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public abstract class VideoDecoder {
    private byte[][] byteBuffer;

    public abstract Picture decodeFrame(ByteBuffer byteBuffer, byte[][] bArr);

    public VideoDecoder downscaled(int i) {
        if (i == 1) {
            return this;
        }
        return null;
    }

    public abstract VideoCodecMeta getCodecMeta(ByteBuffer byteBuffer);

    public byte[][] getSameSizeBuffer(int[][] iArr) {
        byte[][] bArr = this.byteBuffer;
        if (bArr == null || bArr.length != iArr.length || bArr[0].length != iArr[0].length) {
            this.byteBuffer = ArrayUtil.create2D(iArr[0].length, iArr.length);
        }
        return this.byteBuffer;
    }
}
