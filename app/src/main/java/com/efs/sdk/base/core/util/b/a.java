package com.efs.sdk.base.core.util.b;

import com.efs.sdk.base.core.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jcodec.platform.Platform;

/* loaded from: classes.dex */
public final class a {
    private static final IvParameterSpec a = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    public static byte[] a(byte[] bArr, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            SecretKeySpec secretKeySpecA = a(str);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpecA, a);
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            Log.e("efs.base", "aes decrypt error", e2);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            SecretKeySpec secretKeySpecA = a(str);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpecA, a);
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            Log.e("efs.base", "aes encrypt error", e2);
            return null;
        }
    }

    private static SecretKeySpec a(String str) {
        return new SecretKeySpec(str.getBytes(), "AES");
    }

    public static byte[] a(String str, String str2) {
        try {
            return b(str.getBytes(Platform.UTF_8), str2);
        } catch (UnsupportedEncodingException e2) {
            Log.e("efs.base", "getBytes error", e2);
            return null;
        }
    }
}
