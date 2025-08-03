package org.jcodec.common;

/* loaded from: classes2.dex */
public class Vector2Int {
    public static int el16(int i, int i2) {
        return i2 != 0 ? el16_1(i) : el16_0(i);
    }

    public static int el16_0(int i) {
        return (i << 16) >> 16;
    }

    public static int el16_1(int i) {
        return i >> 16;
    }

    public static int pack16(int i, int i2) {
        return (i & 65535) | ((i2 & 65535) << 16);
    }

    public static int set16(int i, int i2, int i3) {
        return i3 != 0 ? set16_1(i, i2) : set16_0(i, i2);
    }

    public static int set16_0(int i, int i2) {
        return (i & (-65536)) | (i2 & 65535);
    }

    public static int set16_1(int i, int i2) {
        return (i & 65535) | ((i2 & 65535) << 16);
    }
}
