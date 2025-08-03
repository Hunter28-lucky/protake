package defpackage;

import okio.ByteString;

/* compiled from: Http2.kt */
/* renamed from: ݏ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3700 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final String[] f12832;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final C3700 f12833 = new C3700();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final ByteString f12829 = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final String[] f12830 = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final String[] f12831 = new String[64];

    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            C3921.m12663(binaryString, "Integer.toBinaryString(it)");
            strArr[i] = e0.m5975(i5.m6247("%8s", binaryString), ' ', '0', false, 4, null);
        }
        f12832 = strArr;
        String[] strArr2 = f12831;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i2 = 0; i2 < 1; i2++) {
            int i3 = iArr[i2];
            String[] strArr3 = f12831;
            strArr3[i3 | 8] = C3921.m12673(strArr3[i3], "|PADDED");
        }
        String[] strArr4 = f12831;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            for (int i6 = 0; i6 < 1; i6++) {
                int i7 = iArr[i6];
                String[] strArr5 = f12831;
                int i8 = i7 | i5;
                strArr5[i8] = strArr5[i7] + "|" + strArr5[i5];
                strArr5[i8 | 8] = strArr5[i7] + "|" + strArr5[i5] + "|PADDED";
            }
        }
        int length = f12831.length;
        for (int i9 = 0; i9 < length; i9++) {
            String[] strArr6 = f12831;
            if (strArr6[i9] == null) {
                strArr6[i9] = f12832[i9];
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String m11849(int i, int i2) {
        String str;
        if (i2 == 0) {
            return "";
        }
        if (i != 2 && i != 3) {
            if (i == 4 || i == 6) {
                return i2 == 1 ? "ACK" : f12832[i2];
            }
            if (i != 7 && i != 8) {
                String[] strArr = f12831;
                if (i2 < strArr.length) {
                    str = strArr[i2];
                    if (str == null) {
                        C3921.m12675();
                    }
                } else {
                    str = f12832[i2];
                }
                String str2 = str;
                return (i != 5 || (i2 & 4) == 0) ? (i != 0 || (i2 & 32) == 0) ? str2 : e0.m5976(str2, "PRIORITY", "COMPRESSED", false, 4, null) : e0.m5976(str2, "HEADERS", "PUSH_PROMISE", false, 4, null);
            }
        }
        return f12832[i2];
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m11850(int i) {
        String[] strArr = f12830;
        return i < strArr.length ? strArr[i] : i5.m6247("0x%02x", Integer.valueOf(i));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String m11851(boolean z, int i, int i2, int i3, int i4) {
        return i5.m6247("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), m11850(i3), m11849(i3, i4));
    }
}
