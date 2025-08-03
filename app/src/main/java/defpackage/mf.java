package defpackage;

/* loaded from: classes.dex */
public class mf {

    /* renamed from: mf$Ԩ, reason: contains not printable characters */
    public static class C2177 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public int[] f8006;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f8007;

        /* renamed from: ԩ, reason: contains not printable characters */
        public int f8008;

        public C2177() {
            this.f8006 = new int[256];
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C2177 m7573(String str) {
        if (str == null) {
            return null;
        }
        C2177 c2177 = new C2177();
        for (int i = 0; i < 256; i++) {
            c2177.f8006[i] = i;
        }
        c2177.f8007 = 0;
        c2177.f8008 = 0;
        int length = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            try {
                char cCharAt = str.charAt(length);
                int[] iArr = c2177.f8006;
                int i4 = iArr[i3];
                i2 = ((cCharAt + i4) + i2) % 256;
                iArr[i3] = iArr[i2];
                iArr[i2] = i4;
                length = (length + 1) % str.length();
            } catch (Exception unused) {
                return null;
            }
        }
        return c2177;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static byte[] m7574(byte[] bArr) {
        C2177 c2177M7573;
        if (bArr == null || (c2177M7573 = m7573("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return m7575(bArr, c2177M7573);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static byte[] m7575(byte[] bArr, C2177 c2177) {
        if (bArr == null || c2177 == null) {
            return null;
        }
        int i = c2177.f8007;
        int i2 = c2177.f8008;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) % 256;
            int[] iArr = c2177.f8006;
            int i4 = iArr[i];
            i2 = (i2 + i4) % 256;
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            int i5 = (iArr[i] + i4) % 256;
            bArr[i3] = (byte) (iArr[i5] ^ bArr[i3]);
        }
        c2177.f8007 = i;
        c2177.f8008 = i2;
        return bArr;
    }
}
