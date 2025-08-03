package defpackage;

import java.io.UnsupportedEncodingException;
import org.jcodec.platform.Platform;

/* compiled from: StringFogImpl.java */
/* loaded from: classes.dex */
public final class u {
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static byte[] m8327(byte[] bArr, String str) {
        int length = bArr.length;
        int length2 = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (i2 >= length2) {
                i2 = 0;
            }
            bArr[i] = (byte) (bArr[i] ^ str.charAt(i2));
            i++;
            i2++;
        }
        return bArr;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String m8328(String str, String str2) {
        try {
            return new String(m8327(C5154.m15075(str, 2), str2), Platform.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return new String(m8327(C5154.m15075(str, 2), str2));
        }
    }
}
