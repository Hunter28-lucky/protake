package org.jcodec.codecs.h264;

/* loaded from: classes2.dex */
public class H264Utils2 {
    public static int golomb2Signed(int i) {
        return ((i >> 1) + (i & 1)) * ((r0 << 1) - 1);
    }
}
