package org.jcodec.common;

import androidx.core.view.InputDeviceCompat;

/* loaded from: classes2.dex */
public class Vector4Int {
    public static int el8(int i, int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? el8_3(i) : el8_2(i) : el8_1(i) : el8_0(i);
    }

    public static int el8_0(int i) {
        return (i << 24) >> 24;
    }

    public static int el8_1(int i) {
        return (i << 16) >> 24;
    }

    public static int el8_2(int i) {
        return (i << 8) >> 24;
    }

    public static int el8_3(int i) {
        return i >> 24;
    }

    public static int pack8(int i, int i2, int i3, int i4) {
        return (i & 255) | ((i2 & 255) << 8) | ((i3 & 255) << 16) | ((i4 & 255) << 24);
    }

    public static int set8(int i, int i2, int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? set8_3(i, i2) : set8_2(i, i2) : set8_1(i, i2) : set8_0(i, i2);
    }

    public static int set8_0(int i, int i2) {
        return (i & InputDeviceCompat.SOURCE_ANY) | (i2 & 255);
    }

    public static int set8_1(int i, int i2) {
        return (i & (-65281)) | ((i2 & 255) << 8);
    }

    public static int set8_2(int i, int i2) {
        return (i & (-16711681)) | ((i2 & 255) << 16);
    }

    public static int set8_3(int i, int i2) {
        return (i & (-16711681)) | ((i2 & 255) << 24);
    }
}
