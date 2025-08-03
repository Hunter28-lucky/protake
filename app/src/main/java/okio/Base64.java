package okio;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.cb;
import defpackage.C3921;
import java.util.Arrays;
import okio.ByteString;

/* compiled from: -Base64.kt */
/* renamed from: okio.-Base64, reason: invalid class name */
/* loaded from: classes2.dex */
public final class Base64 {
    private static final byte[] BASE64;
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final byte[] decodeBase64ToArray(String str) {
        int i;
        char cCharAt;
        C3921.m12667(str, "$this$decodeBase64ToArray");
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i2 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt2 = str.charAt(i6);
            if ('A' <= cCharAt2 && 'Z' >= cCharAt2) {
                i = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && 'z' >= cCharAt2) {
                i = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && '9' >= cCharAt2) {
                i = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i = 62;
            } else if (cCharAt2 == '/' || cCharAt2 == '_') {
                i = 63;
            } else {
                if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i4 = (i4 << 6) | i;
            i3++;
            if (i3 % 4 == 0) {
                int i7 = i5 + 1;
                bArr[i5] = (byte) (i4 >> 16);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (i4 >> 8);
                bArr[i8] = (byte) i4;
                i5 = i8 + 1;
            }
        }
        int i9 = i3 % 4;
        if (i9 == 1) {
            return null;
        }
        if (i9 == 2) {
            bArr[i5] = (byte) ((i4 << 12) >> 16);
            i5++;
        } else if (i9 == 3) {
            int i10 = i4 << 6;
            int i11 = i5 + 1;
            bArr[i5] = (byte) (i10 >> 16);
            i5 = i11 + 1;
            bArr[i11] = (byte) (i10 >> 8);
        }
        if (i5 == i2) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i5);
        C3921.m12663(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf;
    }

    public static final String encodeBase64(byte[] bArr, byte[] bArr2) {
        C3921.m12667(bArr, "$this$encodeBase64");
        C3921.m12667(bArr2, "map");
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            byte b = bArr[i];
            int i4 = i3 + 1;
            byte b2 = bArr[i3];
            int i5 = i4 + 1;
            byte b3 = bArr[i4];
            int i6 = i2 + 1;
            bArr3[i2] = bArr2[(b & ExifInterface.MARKER) >> 2];
            int i7 = i6 + 1;
            bArr3[i6] = bArr2[((b & 3) << 4) | ((b2 & ExifInterface.MARKER) >> 4)];
            int i8 = i7 + 1;
            bArr3[i7] = bArr2[((b2 & cb.m) << 2) | ((b3 & ExifInterface.MARKER) >> 6)];
            i2 = i8 + 1;
            bArr3[i8] = bArr2[b3 & Utf8.REPLACEMENT_BYTE];
            i = i5;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b4 = bArr[i];
            int i9 = i2 + 1;
            bArr3[i2] = bArr2[(b4 & ExifInterface.MARKER) >> 2];
            int i10 = i9 + 1;
            bArr3[i9] = bArr2[(b4 & 3) << 4];
            byte b5 = (byte) 61;
            bArr3[i10] = b5;
            bArr3[i10 + 1] = b5;
        } else if (length2 == 2) {
            int i11 = i + 1;
            byte b6 = bArr[i];
            byte b7 = bArr[i11];
            int i12 = i2 + 1;
            bArr3[i2] = bArr2[(b6 & ExifInterface.MARKER) >> 2];
            int i13 = i12 + 1;
            bArr3[i12] = bArr2[((b6 & 3) << 4) | ((b7 & ExifInterface.MARKER) >> 4)];
            bArr3[i13] = bArr2[(b7 & cb.m) << 2];
            bArr3[i13 + 1] = (byte) 61;
        }
        return Platform.toUtf8String(bArr3);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }
}
