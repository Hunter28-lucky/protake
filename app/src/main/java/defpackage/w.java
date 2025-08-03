package defpackage;

import androidx.exifinterface.media.ExifInterface;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.jcodec.platform.Platform;

/* compiled from: StringUtils.java */
/* loaded from: classes.dex */
public class w {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m8494() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        for (int i = 0; i < 32; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(secureRandom.nextInt(62)));
        }
        return sb.toString();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m8495(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes(Platform.UTF_8));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i = b & ExifInterface.MARKER;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m8496(String str) {
        return str.indexOf(".") > 0 ? str.replaceAll("0+?$", "").replaceAll("[.]$", "") : str;
    }
}
