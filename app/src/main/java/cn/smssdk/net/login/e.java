package cn.smssdk.net.login;

import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.support.stream.ts.TsConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: Md5Util.java */
/* loaded from: classes.dex */
public class e {
    private static final String[] a = {"0", "1", "2", "3", FinderManager.MACHINE_C, "5", "6", "7", FinderManager.MACHINE_D, "9", "a", TsConstants.kLinkParam_suffix, "c", "d", TsConstants.kLinkParam_machine, TsConstants.kLinkParam_recording};

    public static String a(String str, String str2) throws NoSuchAlgorithmException {
        try {
            String str3 = new String(str);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                return (str2 == null || "".equals(str2)) ? a(messageDigest.digest(str3.getBytes())) : a(messageDigest.digest(str3.getBytes(str2)));
            } catch (Exception unused) {
                return str3;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(a(b));
        }
        return stringBuffer.toString();
    }

    public static String a(byte b) {
        int i = b;
        if (b < 0) {
            i = b + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = a;
        sb.append(strArr[i / 16]);
        sb.append(strArr[i % 16]);
        return sb.toString();
    }
}
