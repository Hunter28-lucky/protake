package defpackage;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.jcodec.platform.Platform;

/* loaded from: classes.dex */
public final class ua {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m8368(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m8369(Map<String, String> map, String str, String str2) {
        String str3;
        return (map == null || (str3 = map.get(str)) == null) ? str2 : str3;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m8370(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m8371(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m8372(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static boolean m8373(String str) {
        return !m8370(str);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static boolean m8374(String str) {
        for (byte b : str.getBytes()) {
            if ((b >= 0 && b <= 31) || b >= Byte.MAX_VALUE) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static String m8375(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static String m8376(String str) throws NoSuchAlgorithmException {
        try {
            if (m8370(str)) {
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

    /* renamed from: ՠ, reason: contains not printable characters */
    public static String m8377(String str) throws IOException {
        try {
            byte[] bArrArray = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(str.length()).array();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes(Platform.UTF_8));
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] bArr = new byte[byteArrayOutputStream.toByteArray().length + 4];
            System.arraycopy(bArrArray, 0, bArr, 0, 4);
            System.arraycopy(byteArrayOutputStream.toByteArray(), 0, bArr, 4, byteArrayOutputStream.toByteArray().length);
            return Base64.encodeToString(bArr, 8);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static String m8378(String str) throws IOException {
        if (m8370(str)) {
            return "";
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("utf-8"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = byteArrayInputStream.read(bArr, 0, 1024);
                if (i == -1) {
                    gZIPOutputStream.flush();
                    gZIPOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    byteArrayInputStream.close();
                    return new String(Base64.encode(byteArray, 2));
                }
                gZIPOutputStream.write(bArr, 0, i);
            }
        } catch (Exception unused) {
            return "";
        }
    }
}
