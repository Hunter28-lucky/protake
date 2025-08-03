package defpackage;

import android.util.Base64;
import java.security.SecureRandom;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ce {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static volatile SecureRandom f214;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final char[] f215 = "0123456789ABCDEF".toCharArray();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m297(byte[] bArr) {
        return Base64.encodeToString(bArr, 3);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static SecureRandom m298() {
        if (f214 != null) {
            return f214;
        }
        synchronized (ce.class) {
            if (f214 == null) {
                f214 = new SecureRandom();
            }
        }
        return f214;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static byte[] m299(byte b) {
        return new byte[]{b};
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static byte[] m300(char c, char c2) {
        return new byte[]{(byte) (c & 255), (byte) (c2 & 255)};
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static byte[] m301(long j) {
        return new byte[]{(byte) j, (byte) (j >> 8), (byte) (j >> 16), (byte) (j >> 24), (byte) (j >> 32), (byte) (j >> 40), (byte) (j >> 48), (byte) (j >> 56)};
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static byte[] m302(short s) {
        return new byte[]{(byte) s, (byte) (s >> 8)};
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static byte[] m303(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArrCopyOf = null;
        int length2 = 0;
        for (byte[] bArr3 : bArr) {
            if (bArrCopyOf == null) {
                bArrCopyOf = Arrays.copyOf(bArr3, length);
                length2 = bArr3.length;
            } else {
                System.arraycopy(bArr3, 0, bArrCopyOf, length2, bArr3.length);
                length2 += bArr3.length;
            }
        }
        return bArrCopyOf;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static byte[] m304() {
        byte[] bArr = new byte[2];
        m298().nextBytes(bArr);
        return bArr;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static byte[] m305() {
        byte[] bArr = new byte[4];
        m298().nextBytes(bArr);
        return bArr;
    }
}
