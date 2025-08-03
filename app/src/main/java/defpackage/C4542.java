package defpackage;

import defpackage.C3181;
import io.jsonwebtoken.JwtParser;

/* compiled from: _Ranges.kt */
/* renamed from: ధ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4542 extends C4754 {
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final int m13943(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final long m13944(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final int m13945(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final long m13946(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final int m13947(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + JwtParser.SEPARATOR_CHAR);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final C3181 m13948(int i, int i2) {
        return C3181.f11260.m10814(i, i2, -1);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final C3181 m13949(C3181 c3181, int i) {
        C3921.m12666(c3181, "<this>");
        C4754.m14294(i > 0, Integer.valueOf(i));
        C3181.C3182 c3182 = C3181.f11260;
        int iM10810 = c3181.m10810();
        int iM10811 = c3181.m10811();
        if (c3181.m10812() <= 0) {
            i = -i;
        }
        return c3182.m10814(iM10810, iM10811, i);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final C2523 m13950(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? C2523.f9347.m9332() : new C2523(i, i2 - 1);
    }
}
