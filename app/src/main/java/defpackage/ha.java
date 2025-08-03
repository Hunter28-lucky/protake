package defpackage;

import com.umeng.analytics.pro.cb;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import okio.Utf8;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes.dex */
public final class ha {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final byte[] f6723 = new byte[128];

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final char[] f6724 = new char[64];

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 128; i4++) {
            f6723[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            f6723[i5] = (byte) (i5 - 65);
        }
        int i6 = 122;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            f6723[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            f6723[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = f6723;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        for (int i8 = 0; i8 <= 25; i8++) {
            f6724[i8] = (char) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            f6724[i] = (char) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            f6724[i2] = (char) (i3 + 48);
            i2++;
            i3++;
        }
        char[] cArr = f6724;
        cArr[62] = PhoneNumberUtil.PLUS_SIGN;
        cArr[63] = '/';
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m6184(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!m6189(cArr[i2])) {
                cArr[i] = cArr[i2];
                i++;
            }
        }
        return i;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m6185(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i = length % 24;
        int i2 = length / 24;
        char[] cArr = new char[(i != 0 ? i2 + 1 : i2) * 4];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            int i6 = i4 + 1;
            byte b = bArr[i4];
            int i7 = i6 + 1;
            byte b2 = bArr[i6];
            int i8 = i7 + 1;
            byte b3 = bArr[i7];
            byte b4 = (byte) (b2 & cb.m);
            byte b5 = (byte) (b & 3);
            int i9 = b & BER.ASN_LONG_LEN;
            int i10 = b >> 2;
            if (i9 != 0) {
                i10 ^= 192;
            }
            byte b6 = (byte) i10;
            int i11 = b2 & BER.ASN_LONG_LEN;
            int i12 = b2 >> 4;
            if (i11 != 0) {
                i12 ^= 240;
            }
            byte b7 = (byte) i12;
            int i13 = (b3 & BER.ASN_LONG_LEN) == 0 ? b3 >> 6 : (b3 >> 6) ^ 252;
            int i14 = i5 + 1;
            char[] cArr2 = f6724;
            cArr[i5] = cArr2[b6];
            int i15 = i14 + 1;
            cArr[i14] = cArr2[(b5 << 4) | b7];
            int i16 = i15 + 1;
            cArr[i15] = cArr2[(b4 << 2) | ((byte) i13)];
            cArr[i16] = cArr2[b3 & Utf8.REPLACEMENT_BYTE];
            i3++;
            i5 = i16 + 1;
            i4 = i8;
        }
        if (i == 8) {
            byte b8 = bArr[i4];
            byte b9 = (byte) (b8 & 3);
            int i17 = b8 & BER.ASN_LONG_LEN;
            int i18 = b8 >> 2;
            if (i17 != 0) {
                i18 ^= 192;
            }
            int i19 = i5 + 1;
            char[] cArr3 = f6724;
            cArr[i5] = cArr3[(byte) i18];
            int i20 = i19 + 1;
            cArr[i19] = cArr3[b9 << 4];
            cArr[i20] = '=';
            cArr[i20 + 1] = '=';
        } else if (i == 16) {
            byte b10 = bArr[i4];
            byte b11 = bArr[i4 + 1];
            byte b12 = (byte) (b11 & cb.m);
            byte b13 = (byte) (b10 & 3);
            int i21 = b10 & BER.ASN_LONG_LEN;
            int i22 = b10 >> 2;
            if (i21 != 0) {
                i22 ^= 192;
            }
            byte b14 = (byte) i22;
            int i23 = b11 & BER.ASN_LONG_LEN;
            int i24 = b11 >> 4;
            if (i23 != 0) {
                i24 ^= 240;
            }
            int i25 = i5 + 1;
            char[] cArr4 = f6724;
            cArr[i5] = cArr4[b14];
            int i26 = i25 + 1;
            cArr[i25] = cArr4[((byte) i24) | (b13 << 4)];
            cArr[i26] = cArr4[b12 << 2];
            cArr[i26 + 1] = '=';
        }
        return new String(cArr);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m6186(char c) {
        return c < 128 && f6723[c] != -1;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static byte[] m6187(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int iM6184 = m6184(charArray);
        if (iM6184 % 4 != 0) {
            return null;
        }
        int i = iM6184 / 4;
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i * 3];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i - 1) {
            int i5 = i3 + 1;
            char c = charArray[i3];
            if (m6186(c)) {
                int i6 = i5 + 1;
                char c2 = charArray[i5];
                if (m6186(c2)) {
                    int i7 = i6 + 1;
                    char c3 = charArray[i6];
                    if (m6186(c3)) {
                        int i8 = i7 + 1;
                        char c4 = charArray[i7];
                        if (m6186(c4)) {
                            byte[] bArr2 = f6723;
                            byte b = bArr2[c];
                            byte b2 = bArr2[c2];
                            byte b3 = bArr2[c3];
                            byte b4 = bArr2[c4];
                            int i9 = i4 + 1;
                            bArr[i4] = (byte) ((b << 2) | (b2 >> 4));
                            int i10 = i9 + 1;
                            bArr[i9] = (byte) (((b2 & cb.m) << 4) | ((b3 >> 2) & 15));
                            i4 = i10 + 1;
                            bArr[i10] = (byte) ((b3 << 6) | b4);
                            i2++;
                            i3 = i8;
                        }
                    }
                }
            }
            return null;
        }
        int i11 = i3 + 1;
        char c5 = charArray[i3];
        if (!m6186(c5)) {
            return null;
        }
        int i12 = i11 + 1;
        char c6 = charArray[i11];
        if (!m6186(c6)) {
            return null;
        }
        byte[] bArr3 = f6723;
        byte b5 = bArr3[c5];
        byte b6 = bArr3[c6];
        int i13 = i12 + 1;
        char c7 = charArray[i12];
        char c8 = charArray[i13];
        if (m6186(c7) && m6186(c8)) {
            byte b7 = bArr3[c7];
            byte b8 = bArr3[c8];
            int i14 = i4 + 1;
            bArr[i4] = (byte) ((b5 << 2) | (b6 >> 4));
            bArr[i14] = (byte) (((b6 & cb.m) << 4) | ((b7 >> 2) & 15));
            bArr[i14 + 1] = (byte) (b8 | (b7 << 6));
            return bArr;
        }
        if (m6188(c7) && m6188(c8)) {
            if ((b6 & cb.m) != 0) {
                return null;
            }
            int i15 = i2 * 3;
            byte[] bArr4 = new byte[i15 + 1];
            System.arraycopy(bArr, 0, bArr4, 0, i15);
            bArr4[i4] = (byte) ((b5 << 2) | (b6 >> 4));
            return bArr4;
        }
        if (m6188(c7) || !m6188(c8)) {
            return null;
        }
        byte b9 = bArr3[c7];
        if ((b9 & 3) != 0) {
            return null;
        }
        int i16 = i2 * 3;
        byte[] bArr5 = new byte[i16 + 2];
        System.arraycopy(bArr, 0, bArr5, 0, i16);
        bArr5[i4] = (byte) ((b5 << 2) | (b6 >> 4));
        bArr5[i4 + 1] = (byte) (((b9 >> 2) & 15) | ((b6 & cb.m) << 4));
        return bArr5;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean m6188(char c) {
        return c == '=';
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static boolean m6189(char c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }
}
