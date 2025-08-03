package defpackage;

/* compiled from: StringNumberConversions.kt */
/* loaded from: classes2.dex */
public class d0 extends c0 {
    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final Integer m5892(String str) {
        C3921.m12666(str, "<this>");
        return m5893(str, 10);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final Integer m5893(String str, int i) {
        boolean z;
        int i2;
        C3921.m12666(str, "<this>");
        C5042.m14848(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        int i4 = -2147483647;
        int i5 = 1;
        if (C3921.m12668(cCharAt, 48) >= 0) {
            z = false;
            i5 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i4 = Integer.MIN_VALUE;
                z = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z = false;
            }
        }
        int i6 = -59652323;
        while (i5 < length) {
            int iM14849 = C5042.m14849(str.charAt(i5), i);
            if (iM14849 < 0) {
                return null;
            }
            if ((i3 < i6 && (i6 != -59652323 || i3 < (i6 = i4 / i))) || (i2 = i3 * i) < i4 + iM14849) {
                return null;
            }
            i3 = i2 - iM14849;
            i5++;
        }
        return z ? Integer.valueOf(i3) : Integer.valueOf(-i3);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final Long m5894(String str) {
        C3921.m12666(str, "<this>");
        return m5895(str, 10);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final Long m5895(String str, int i) {
        C3921.m12666(str, "<this>");
        C5042.m14848(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        long j = -9223372036854775807L;
        boolean z = true;
        if (C3921.m12668(cCharAt, 48) >= 0) {
            z = false;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j = Long.MIN_VALUE;
                i2 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z = false;
                i2 = 1;
            }
        }
        long j2 = -256204778801521550L;
        long j3 = 0;
        long j4 = -256204778801521550L;
        while (i2 < length) {
            int iM14849 = C5042.m14849(str.charAt(i2), i);
            if (iM14849 < 0) {
                return null;
            }
            if (j3 < j4) {
                if (j4 == j2) {
                    j4 = j / i;
                    if (j3 < j4) {
                    }
                }
                return null;
            }
            long j5 = j3 * i;
            long j6 = iM14849;
            if (j5 < j + j6) {
                return null;
            }
            j3 = j5 - j6;
            i2++;
            j2 = -256204778801521550L;
        }
        return z ? Long.valueOf(j3) : Long.valueOf(-j3);
    }
}
