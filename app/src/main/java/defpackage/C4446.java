package defpackage;

import com.xiaomi.mipush.sdk.Constants;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.TypeCastException;
import kotlin.text.StringsKt__StringsKt;
import okio.Buffer;

/* compiled from: hostnames.kt */
/* renamed from: ୡ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4446 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final boolean m13706(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127 || StringsKt__StringsKt.m7285(" #%/:?@[\\]", cCharAt, 0, false, 6, null) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final boolean m13707(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0097, code lost:
    
        if (r13 == 16) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0099, code lost:
    
        if (r14 != (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009c, code lost:
    
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ae, code lost:
    
        return java.net.InetAddress.getByAddress(r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /* renamed from: ԩ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.net.InetAddress m13708(java.lang.String r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 175
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C4446.m13708(java.lang.String, int, int):java.net.InetAddress");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final String m13709(byte[] bArr) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i2 = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        Buffer buffer = new Buffer();
        while (i < bArr.length) {
            if (i == i2) {
                buffer.writeByte(58);
                i += i4;
                if (i == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((i5.m6232(bArr[i], 255) << 8) | i5.m6232(bArr[i + 1], 255));
                i += 2;
            }
        }
        return buffer.readUtf8();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final String m13710(String str) {
        C3921.m12667(str, "$this$toCanonicalHost");
        if (!StringsKt__StringsKt.m7275(str, Constants.COLON_SEPARATOR, false, 2, null)) {
            try {
                String ascii = IDN.toASCII(str);
                C3921.m12663(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                C3921.m12663(locale, "Locale.US");
                if (ascii == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = ascii.toLowerCase(locale);
                C3921.m12663(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!(lowerCase.length() == 0) && !m13706(lowerCase)) {
                    return lowerCase;
                }
                return null;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressM13708 = (e0.m5980(str, "[", false, 2, null) && e0.m5966(str, "]", false, 2, null)) ? m13708(str, 1, str.length() - 1) : m13708(str, 0, str.length());
        if (inetAddressM13708 == null) {
            return null;
        }
        byte[] address = inetAddressM13708.getAddress();
        if (address.length == 16) {
            C3921.m12663(address, "address");
            return m13709(address);
        }
        if (address.length == 4) {
            return inetAddressM13708.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
    }
}
