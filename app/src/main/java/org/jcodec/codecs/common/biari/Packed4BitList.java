package org.jcodec.codecs.common.biari;

/* loaded from: classes2.dex */
public class Packed4BitList {
    private static int[] CLEAR_MASK = {268435440, -16, -16, -16, -16, -16, -16};

    public static int _3(int i, int i2, int i3) {
        return _7(i, i2, i3, 0, 0, 0, 0);
    }

    public static int _7(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return ((i & 15) << 24) | 1879048192 | ((i2 & 15) << 20) | ((i3 & 15) << 16) | ((i4 & 15) << 12) | ((i5 & 15) << 8) | ((i6 & 15) << 4) | (i7 & 15);
    }

    public static int get(int i, int i2) {
        if (i2 > 6) {
            return 0;
        }
        return (i >> (i2 << 2)) & 255;
    }

    public static int set(int i, int i2, int i3) {
        int i4 = (i >> 28) & 15;
        int i5 = i3 + 1;
        if (i5 > i4) {
            i4 = i5;
        }
        return (i & CLEAR_MASK[i3]) | ((i2 & 255) << (i3 << 2)) | (i4 << 28);
    }
}
