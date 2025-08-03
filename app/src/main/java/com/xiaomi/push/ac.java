package com.xiaomi.push;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;

/* loaded from: classes2.dex */
public class ac {
    public static final char[] a = "0123456789ABCDEF".toCharArray();

    public static boolean a(Context context) {
        return ab.a;
    }

    public static String a(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2 * 2);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i + i3] & ExifInterface.MARKER;
            char[] cArr = a;
            sb.append(cArr[i4 >> 4]);
            sb.append(cArr[i4 & 15]);
        }
        return sb.toString();
    }
}
