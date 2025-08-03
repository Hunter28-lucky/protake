package defpackage;

import com.umeng.analytics.pro.cb;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class md {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String f7994 = "idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m7556() {
        String str = new String();
        for (int i = 0; i < f7994.length() - 1; i += 4) {
            str = str + f7994.charAt(i);
        }
        return str;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m7557(String str, String str2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException {
        try {
            PBEKeySpec pBEKeySpecM7559 = m7559(str);
            byte[] bytes = str2.getBytes();
            byte[] bArrM7561 = m7561();
            SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(pBEKeySpecM7559).getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArrM7561));
            byte[] salt = pBEKeySpecM7559.getSalt();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(salt.length + cipher.getOutputSize(bytes.length));
            byteBufferAllocate.put(salt);
            cipher.doFinal(ByteBuffer.wrap(bytes), byteBufferAllocate);
            return m7558(byteBufferAllocate.array());
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m7558(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(b & cb.m));
        }
        return stringBuffer.toString();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static PBEKeySpec m7559(String str) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = Class.forName(new String(ta.m8298("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
        Object objNewInstance = cls.newInstance();
        byte[] bArr = new byte[16];
        Method method = cls.getMethod("nextBytes", bArr.getClass());
        method.setAccessible(true);
        method.invoke(objNewInstance, bArr);
        return new PBEKeySpec(str.toCharArray(), bArr, 10, 128);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m7560(String str, String str2) throws Exception {
        byte[] bArrDoFinal;
        try {
            PBEKeySpec pBEKeySpecM7559 = m7559(str);
            int length = str2.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = Integer.valueOf(str2.substring(i2, i2 + 2), 16).byteValue();
            }
            byte[] bArrM7561 = m7561();
            if (length <= 16) {
                bArrDoFinal = null;
            } else {
                SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(pBEKeySpecM7559.getPassword(), Arrays.copyOf(bArr, 16), 10, 128)).getEncoded(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, new IvParameterSpec(bArrM7561));
                bArrDoFinal = cipher.doFinal(bArr, 16, length - 16);
            }
        } catch (Exception unused) {
        }
        if (bArrDoFinal == null) {
            throw new Exception();
        }
        String str3 = new String(bArrDoFinal);
        if (ua.m8374(str3)) {
            return str3;
        }
        return null;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static byte[] m7561() {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 48; i += 2) {
                sb.append("AsAgAtA5A6AdAgABABACADAfAsAdAfAsAgAaAgA3A5A6=8=0".charAt(i));
            }
            return ta.m8298(sb.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
