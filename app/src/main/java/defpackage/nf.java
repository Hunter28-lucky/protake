package defpackage;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class nf {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String f8070 = "DESede/CBC/PKCS5Padding";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m7653(String str, String str2, String str3) {
        try {
            return new String(m7654(str, ha.m6187(str2), str3));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static byte[] m7654(String str, byte[] bArr, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher cipher = Cipher.getInstance(f8070);
            cipher.init(2, secretKeySpec, new IvParameterSpec(id.m6290(cipher, str2)));
            return cipher.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m7655(String str, String str2, String str3) {
        try {
            return ha.m6185(m7656(str, str2.getBytes(), str3));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static byte[] m7656(String str, byte[] bArr, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher cipher = Cipher.getInstance(f8070);
            cipher.init(1, secretKeySpec, new IvParameterSpec(id.m6290(cipher, str2)));
            return cipher.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
