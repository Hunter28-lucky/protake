package defpackage;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class xa {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m8596() {
        byte[] bArrM8598 = m8598(m8597("com.nearme.mcs"));
        return bArrM8598 != null ? new String(bArrM8598, Charset.forName(Platform.UTF_8)) : "";
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static byte[] m8597(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes(Platform.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static byte[] m8598(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i = 0; i < length; i += 2) {
            byte b = bArr[i];
            int i2 = i + 1;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
        return bArr;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m8599(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return sc.m8237(str, m8596());
            } catch (Exception e2) {
                qd.m8125("desDecrypt-" + e2.getMessage());
            }
        }
        return "";
    }
}
