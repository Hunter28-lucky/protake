package io.jsonwebtoken.io;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.stream.ts.google.CRC32.AbstractChecksum;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class Base64 {
    private static final char[] BASE64URL_ALPHABET;
    private static final int[] BASE64URL_IALPHABET;
    private static final char[] BASE64_ALPHABET;
    private static final int[] BASE64_IALPHABET;
    public static final Base64 DEFAULT;
    private static final int IALPHABET_MAX_INDEX;
    public static final Base64 URL_SAFE;
    private final char[] ALPHABET;
    private final int[] IALPHABET;
    private final boolean urlsafe;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        BASE64_ALPHABET = charArray;
        BASE64URL_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();
        int[] iArr = new int[256];
        BASE64_IALPHABET = iArr;
        int[] iArr2 = new int[256];
        BASE64URL_IALPHABET = iArr2;
        IALPHABET_MAX_INDEX = iArr.length - 1;
        Arrays.fill(iArr, -1);
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            BASE64_IALPHABET[BASE64_ALPHABET[i]] = i;
            BASE64URL_IALPHABET[BASE64URL_ALPHABET[i]] = i;
        }
        BASE64_IALPHABET[61] = 0;
        BASE64URL_IALPHABET[61] = 0;
        DEFAULT = new Base64(false);
        URL_SAFE = new Base64(true);
    }

    private Base64(boolean z) {
        this.urlsafe = z;
        this.ALPHABET = z ? BASE64URL_ALPHABET : BASE64_ALPHABET;
        this.IALPHABET = z ? BASE64URL_IALPHABET : BASE64_IALPHABET;
    }

    private int ctoi(char c) {
        int i = c > IALPHABET_MAX_INDEX ? -1 : this.IALPHABET[c];
        if (i >= 0) {
            return i;
        }
        throw new DecodingException("Illegal " + getName() + " character: '" + c + "'");
    }

    private char[] encodeToChar(byte[] bArr, boolean z) {
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return new char[0];
        }
        int i = (length / 3) * 3;
        int i2 = length - i;
        int i3 = length - 1;
        int i4 = ((i3 / 3) + 1) << 2;
        int i5 = i4 + (z ? ((i4 - 1) / 76) << 1 : 0);
        char[] cArr = new char[this.urlsafe ? i5 - (i2 == 2 ? 1 : i2 == 1 ? 2 : 0) : i5];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < i) {
            int i9 = i6 + 1;
            int i10 = i9 + 1;
            int i11 = ((bArr[i6] & ExifInterface.MARKER) << 16) | ((bArr[i9] & ExifInterface.MARKER) << 8);
            int i12 = i10 + 1;
            int i13 = i11 | (bArr[i10] & ExifInterface.MARKER);
            int i14 = i7 + 1;
            char[] cArr2 = this.ALPHABET;
            cArr[i7] = cArr2[(i13 >>> 18) & 63];
            int i15 = i14 + 1;
            cArr[i14] = cArr2[(i13 >>> 12) & 63];
            int i16 = i15 + 1;
            cArr[i15] = cArr2[(i13 >>> 6) & 63];
            i7 = i16 + 1;
            cArr[i16] = cArr2[i13 & 63];
            if (z && (i8 = i8 + 1) == 19 && i7 < i5 - 2) {
                int i17 = i7 + 1;
                cArr[i7] = '\r';
                cArr[i17] = '\n';
                i7 = i17 + 1;
                i8 = 0;
            }
            i6 = i12;
        }
        if (i2 > 0) {
            int i18 = ((bArr[i] & ExifInterface.MARKER) << 10) | (i2 == 2 ? (bArr[i3] & ExifInterface.MARKER) << 2 : 0);
            char[] cArr3 = this.ALPHABET;
            cArr[i5 - 4] = cArr3[i18 >> 12];
            cArr[i5 - 3] = cArr3[(i18 >>> 6) & 63];
            if (i2 == 2) {
                cArr[i5 - 2] = cArr3[i18 & 63];
            } else if (!this.urlsafe) {
                cArr[i5 - 2] = '=';
            }
            if (!this.urlsafe) {
                cArr[i5 - 1] = '=';
            }
        }
        return cArr;
    }

    private String getName() {
        return this.urlsafe ? "base64url" : AbstractChecksum.BASE64;
    }

    public final byte[] decodeFast(char[] cArr) throws DecodingException {
        int i;
        int iCtoi = 0;
        int length = cArr != null ? cArr.length : 0;
        if (length == 0) {
            return new byte[0];
        }
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < i2 && this.IALPHABET[cArr[i3]] < 0) {
            i3++;
        }
        while (i2 > 0 && this.IALPHABET[cArr[i2]] < 0) {
            i2--;
        }
        int i4 = cArr[i2] == '=' ? cArr[i2 + (-1)] == '=' ? 2 : 1 : 0;
        int i5 = (i2 - i3) + 1;
        if (length > 76) {
            i = (cArr[76] == '\r' ? i5 / 78 : 0) << 1;
        } else {
            i = 0;
        }
        int i6 = (((i5 - i) * 6) >> 3) - i4;
        byte[] bArr = new byte[i6];
        int i7 = (i6 / 3) * 3;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i7) {
            int i10 = i3 + 1;
            int i11 = i10 + 1;
            int iCtoi2 = (ctoi(cArr[i3]) << 18) | (ctoi(cArr[i10]) << 12);
            int i12 = i11 + 1;
            int iCtoi3 = iCtoi2 | (ctoi(cArr[i11]) << 6);
            int i13 = i12 + 1;
            int iCtoi4 = iCtoi3 | ctoi(cArr[i12]);
            int i14 = i8 + 1;
            bArr[i8] = (byte) (iCtoi4 >> 16);
            int i15 = i14 + 1;
            bArr[i14] = (byte) (iCtoi4 >> 8);
            int i16 = i15 + 1;
            bArr[i15] = (byte) iCtoi4;
            if (i > 0 && (i9 = i9 + 1) == 19) {
                i13 += 2;
                i9 = 0;
            }
            i3 = i13;
            i8 = i16;
        }
        if (i8 < i6) {
            int i17 = 0;
            while (i3 <= i2 - i4) {
                iCtoi |= ctoi(cArr[i3]) << (18 - (i17 * 6));
                i17++;
                i3++;
            }
            int i18 = 16;
            while (i8 < i6) {
                bArr[i8] = (byte) (iCtoi >> i18);
                i18 -= 8;
                i8++;
            }
        }
        return bArr;
    }

    public final String encodeToString(byte[] bArr, boolean z) {
        return new String(encodeToChar(bArr, z));
    }
}
