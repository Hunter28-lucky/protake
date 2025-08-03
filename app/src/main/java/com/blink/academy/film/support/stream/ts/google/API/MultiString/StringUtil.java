package com.blink.academy.film.support.stream.ts.google.API.MultiString;

import androidx.exifinterface.media.ExifInterface;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jcodec.platform.Platform;

/* loaded from: classes.dex */
public class StringUtil {
    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] EncryptToByte(java.lang.String r1, java.lang.String r2) throws java.security.NoSuchAlgorithmException {
        /*
            byte[] r1 = r1.getBytes()
            if (r2 == 0) goto Le
            java.lang.String r0 = ""
            boolean r0 = r2.equals(r0)     // Catch: java.security.NoSuchAlgorithmException -> L1c
            if (r0 == 0) goto L10
        Le:
            java.lang.String r2 = "SHA-256"
        L10:
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch: java.security.NoSuchAlgorithmException -> L1c
            r2.update(r1)     // Catch: java.security.NoSuchAlgorithmException -> L1c
            byte[] r1 = r2.digest()     // Catch: java.security.NoSuchAlgorithmException -> L1c
            return r1
        L1c:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.support.stream.ts.google.API.MultiString.StringUtil.EncryptToByte(java.lang.String, java.lang.String):byte[]");
    }

    public static byte[] StringToUTF16BE(String str) {
        return str.getBytes(Charset.forName(Platform.UTF_16BE));
    }

    public static byte[] StringToUTF8(String str) {
        return str.getBytes(Charset.forName(Platform.UTF_8));
    }

    public static byte[] UTF16BEToUTF8(byte[] bArr) {
        return new String(bArr, Charset.forName(Platform.UTF_16BE)).getBytes(Charset.forName(Platform.UTF_8));
    }

    public static byte[] UTF8ToUTF16(byte[] bArr) {
        return new String(bArr, Charset.forName(Platform.UTF_8)).getBytes(Charset.forName(Platform.UTF_16BE));
    }

    public static String bytes2Hex(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & ExifInterface.MARKER);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }

    public static String bytesToMD5(byte[] bArr) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i = b & ExifInterface.MARKER;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
