package defpackage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jcodec.platform.Platform;

/* loaded from: classes.dex */
public final class pc {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m7968(String str) throws NoSuchAlgorithmException {
        try {
            if (ua.m8370(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes(Platform.UTF_8));
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
