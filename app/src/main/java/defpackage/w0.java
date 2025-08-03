package defpackage;

/* compiled from: SystemProps.common.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class w0 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final int m8497(String str, int i, int i2, int i3) {
        return (int) u0.m8331(str, i, i2, i3);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final long m8498(String str, long j, long j2, long j3) {
        String strM8332 = u0.m8332(str);
        if (strM8332 == null) {
            return j;
        }
        Long lM5894 = d0.m5894(strM8332);
        if (lM5894 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strM8332 + '\'').toString());
        }
        long jLongValue = lM5894.longValue();
        boolean z = false;
        if (j2 <= jLongValue && jLongValue <= j3) {
            z = true;
        }
        if (z) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + jLongValue + '\'').toString());
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final boolean m8499(String str, boolean z) {
        String strM8332 = u0.m8332(str);
        return strM8332 == null ? z : Boolean.parseBoolean(strM8332);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static /* synthetic */ int m8500(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return u0.m8330(str, i, i2, i3);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static /* synthetic */ long m8501(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return u0.m8331(str, j, j4, j3);
    }
}
