package org.jcodec.common.tools;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class MD5 {
    private static String digestToString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            int i = b & ExifInterface.MARKER;
            if (i < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }

    public static MessageDigest getDigest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String md5sum(ByteBuffer byteBuffer) {
        MessageDigest digest = getDigest();
        digest.update(byteBuffer);
        return digestToString(digest.digest());
    }

    public static String md5sumBytes(byte[] bArr) {
        MessageDigest digest = getDigest();
        digest.update(bArr);
        return digestToString(digest.digest());
    }
}
