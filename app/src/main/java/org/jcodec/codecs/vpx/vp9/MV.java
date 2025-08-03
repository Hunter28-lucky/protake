package org.jcodec.codecs.vpx.vp9;

/* loaded from: classes2.dex */
public class MV {
    public static int create(int i, int i2, int i3) {
        return (i & 16383) | ((i2 & 16383) << 14) | (i3 << 28);
    }

    public static int ref(int i) {
        return (i >> 28) & 3;
    }

    public static int x(int i) {
        return (i << 18) >> 18;
    }

    public static int y(int i) {
        return (i << 4) >> 18;
    }
}
