package com.zhiyun.sdk.util;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;

/* loaded from: classes2.dex */
public class ArrayUtil {
    public static String bytesToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        int i = 0;
        while (i < bArr.length) {
            String hexString = Integer.toHexString(bArr[i] & ExifInterface.MARKER);
            if (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
            i++;
            if (i % 4 == 0) {
                sb.append(MyUTIL.white_space);
            }
        }
        return sb.toString();
    }
}
