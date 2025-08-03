package com.mob.tools.utils;

import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class Data implements PublicMemberKeeper {
    public static String AES128Decode(String str, byte[] bArr) throws Throwable {
        if (str == null || bArr == null) {
            return null;
        }
        return new String(AES128Decode(str.getBytes(Platform.UTF_8), bArr), Platform.UTF_8);
    }

    public static byte[] AES128Encode(String str, String str2) throws Throwable {
        if (str == null || str2 == null) {
            return null;
        }
        byte[] bytes = str.getBytes(Platform.UTF_8);
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 16));
        byte[] bytes2 = str2.getBytes(Platform.UTF_8);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, com.mob.commons.a.d.a("003Tfkhefi"));
        Cipher cipher = getCipher(com.mob.commons.a.d.a("003+fkhefi") + com.mob.commons.a.d.a("003h-hehh") + com.mob.commons.a.d.a("008?gk,hJhiikhhfijihi") + com.mob.commons.a.d.a("006FegCii]efelgg"), com.mob.commons.a.d.a("002Rgkhh"));
        cipher.init(1, secretKeySpec);
        byte[] bArr2 = new byte[cipher.getOutputSize(bytes2.length)];
        cipher.doFinal(bArr2, cipher.update(bytes2, 0, bytes2.length, bArr2, 0));
        return bArr2;
    }

    @Deprecated
    public static String Base64AES(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        try {
            String strEncodeToString = Base64.encodeToString(AES128Encode(str2, str), 0);
            return (!TextUtils.isEmpty(strEncodeToString) && strEncodeToString.contains("\n")) ? strEncodeToString.replace("\n", "") : strEncodeToString;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static String CRC32(byte[] bArr) throws Throwable {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        long value = crc32.getValue();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 56)) & ExifInterface.MARKER)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 48)) & ExifInterface.MARKER)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 40)) & ExifInterface.MARKER)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 32)) & ExifInterface.MARKER)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 24)) & ExifInterface.MARKER)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 16)) & ExifInterface.MARKER)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 8)) & ExifInterface.MARKER)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) value) & ExifInterface.MARKER)));
        while (sb.charAt(0) == '0') {
            sb = sb.deleteCharAt(0);
        }
        return sb.toString().toLowerCase();
    }

    public static String MD5(String str) {
        byte[] bArrRawMD5;
        if (str == null || (bArrRawMD5 = rawMD5(str)) == null) {
            return null;
        }
        return a(bArrRawMD5);
    }

    public static byte[] SHA1(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return SHA1(str.getBytes("utf-8"));
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }

    public static String byteToHex(byte[] bArr) {
        return byteToHex(bArr, 0, bArr.length);
    }

    public static Cipher getCipher(String str, String str2) throws Throwable {
        Cipher cipher = null;
        if (!TextUtils.isEmpty(str2)) {
            try {
                Provider provider = Security.getProvider(str2);
                if (provider != null) {
                    cipher = Cipher.getInstance(str, provider);
                }
            } catch (Throwable unused) {
            }
        }
        return cipher == null ? Cipher.getInstance(str, str2) : cipher;
    }

    public static byte[] rawMD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            return rawMD5(str.getBytes("utf-8"));
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static String urlEncode(String str) {
        try {
            return urlEncode(str, "utf-8");
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static String byteToHex(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            return stringBuffer.toString();
        }
        while (i < i2) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i])));
            i++;
        }
        return stringBuffer.toString();
    }

    public static String MD5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return MD5(bArr, 0, bArr.length);
    }

    public static byte[] rawMD5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return rawMD5(bArr, 0, bArr.length);
    }

    public static String urlEncode(String str, String str2) throws Throwable {
        String strEncode = TextUtils.isEmpty(str) ? "" : URLEncoder.encode(str, str2);
        return TextUtils.isEmpty(strEncode) ? strEncode : strEncode.replace("+", "%20");
    }

    public static byte[] AES128Decode(byte[] bArr, byte[] bArr2) throws Throwable {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, 0, bArr3, 0, Math.min(bArr.length, 16));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, com.mob.commons.a.d.a("0039fkhefi"));
        Cipher cipher = getCipher(com.mob.commons.a.d.a("003[fkhefi") + com.mob.commons.a.d.a("003hZhehh") + com.mob.commons.a.d.a("005Cgk.hEfgfdhi") + com.mob.commons.a.d.a("006]eg4iiGefelgg"), com.mob.commons.a.d.a("002Cgkhh"));
        cipher.init(2, secretKeySpec);
        byte[] bArr4 = new byte[cipher.getOutputSize(bArr2.length)];
        cipher.doFinal(bArr4, cipher.update(bArr2, 0, bArr2.length, bArr4, 0));
        return bArr4;
    }

    public static String MD5(byte[] bArr, int i, int i2) {
        byte[] bArrRawMD5;
        if (bArr == null || (bArrRawMD5 = rawMD5(bArr, i, i2)) == null) {
            return null;
        }
        return a(bArrRawMD5);
    }

    public static byte[] SHA1(byte[] bArr) throws Throwable {
        MessageDigest messageDigest = MessageDigest.getInstance(com.mob.commons.a.d.a("005Efiiefkijhm"));
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static byte[] rawMD5(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            byte[] bArrRawMD5 = rawMD5(byteArrayInputStream);
            byteArrayInputStream.close();
            return bArrRawMD5;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static String MD5(File file) {
        if (file != null && file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArrRawMD5 = rawMD5(fileInputStream);
                fileInputStream.close();
                if (bArrRawMD5 == null) {
                    return null;
                }
                return a(bArrRawMD5);
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
            }
        }
        return null;
    }

    public static byte[] rawMD5(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance(com.mob.commons.a.d.a("0039hjgjif"));
            int i = inputStream.read(bArr);
            while (i != -1) {
                messageDigest.update(bArr, 0, i);
                i = inputStream.read(bArr);
            }
            return messageDigest.digest();
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static byte[] AES128Encode(byte[] bArr, String str) throws Throwable {
        if (bArr == null || str == null) {
            return null;
        }
        return AES128Encode(bArr, str.getBytes(Platform.UTF_8));
    }

    public static void AES128Decode(String str, InputStream inputStream, OutputStream outputStream) throws Throwable {
        if (str == null) {
            return;
        }
        AES128Decode(str.getBytes(Platform.UTF_8), inputStream, outputStream);
    }

    public static byte[] AES128Encode(byte[] bArr, byte[] bArr2) throws Throwable {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, com.mob.commons.a.d.a("003Bfkhefi"));
        Cipher cipher = getCipher(com.mob.commons.a.d.a("003Jfkhefi") + com.mob.commons.a.d.a("003h$hehh") + com.mob.commons.a.d.a("008Tgk%h[hiikhhfijihi") + com.mob.commons.a.d.a("006TegVii8efelgg"), com.mob.commons.a.d.a("002-gkhh"));
        cipher.init(1, secretKeySpec);
        byte[] bArr3 = new byte[cipher.getOutputSize(bArr2.length)];
        cipher.doFinal(bArr3, cipher.update(bArr2, 0, bArr2.length, bArr3, 0));
        return bArr3;
    }

    public static void AES128Decode(byte[] bArr, InputStream inputStream, OutputStream outputStream) throws Throwable {
        if (bArr == null || inputStream == null || outputStream == null) {
            return;
        }
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, 16));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, com.mob.commons.a.d.a("0036fkhefi"));
        Cipher cipher = getCipher(com.mob.commons.a.d.a("003)fkhefi") + com.mob.commons.a.d.a("003h?hehh") + com.mob.commons.a.d.a("008NgkCh;hiikhhfijihi") + com.mob.commons.a.d.a("006Xeg(ii7efelgg"), com.mob.commons.a.d.a("002Mgkhh"));
        cipher.init(2, secretKeySpec);
        CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
        byte[] bArr3 = new byte[1024];
        for (int i = cipherInputStream.read(bArr3); i != -1; i = cipherInputStream.read(bArr3)) {
            outputStream.write(bArr3, 0, i);
        }
        outputStream.flush();
    }
}
