package defpackage;

import com.umeng.analytics.pro.cb;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8;
import org.jcodec.platform.Platform;

/* loaded from: classes.dex */
public class fa {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m6056(String str) {
        byte[] bArrM6061;
        try {
            bArrM6061 = m6061(m6059(), str.getBytes());
        } catch (Exception unused) {
            bArrM6061 = null;
        }
        if (bArrM6061 != null) {
            return m6057(bArrM6061);
        }
        return null;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m6057(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            m6058(stringBuffer, b);
        }
        return stringBuffer.toString();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m6058(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b & cb.m));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static byte[] m6059() throws Exception {
        return mf.m7574(new byte[]{33, 83, -50, -89, -84, -114, 80, 99, 10, Utf8.REPLACEMENT_BYTE, 22, -65, -11, 30, 101, -118});
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static byte[] m6060(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static byte[] m6061(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(m6063()));
        return cipher.doFinal(bArr2);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m6062(String str) {
        try {
            return new String(m6064(m6059(), m6060(str)));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static byte[] m6063() {
        try {
            byte[] bArrM5936 = dc.m5936("IUQSvE6r1TfFPdPEjfklLw==".getBytes(Platform.UTF_8), 2);
            if (bArrM5936 != null) {
                return mf.m7574(bArrM5936);
            }
        } catch (Exception unused) {
        }
        return new byte[16];
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static byte[] m6064(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(m6063()));
        return cipher.doFinal(bArr2);
    }
}
