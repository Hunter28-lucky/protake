package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: _Arrays.kt */
/* renamed from: ຘ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4962 extends C4955 {
    /* renamed from: ֈ, reason: contains not printable characters */
    public static final <T> boolean m14738(T[] tArr, T t) {
        C3921.m12666(tArr, "<this>");
        return m14743(tArr, t) >= 0;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static final <T> List<T> m14739(T[] tArr) {
        C3921.m12666(tArr, "<this>");
        return (List) m14740(tArr, new ArrayList());
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final <C extends Collection<? super T>, T> C m14740(T[] tArr, C c) {
        C3921.m12666(tArr, "<this>");
        C3921.m12666(c, "destination");
        for (T t : tArr) {
            if (t != null) {
                c.add(t);
            }
        }
        return c;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static final <T> C2523 m14741(T[] tArr) {
        C3921.m12666(tArr, "<this>");
        return new C2523(0, m14742(tArr));
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static final <T> int m14742(T[] tArr) {
        C3921.m12666(tArr, "<this>");
        return tArr.length - 1;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static final <T> int m14743(T[] tArr, T t) {
        C3921.m12666(tArr, "<this>");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (C3921.m12662(t, tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static final char m14744(char[] cArr) {
        C3921.m12666(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static final <T> T m14745(T[] tArr) {
        C3921.m12666(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static final <T> List<T> m14746(T[] tArr) {
        C3921.m12666(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? m14747(tArr) : C5064.m14877(tArr[0]) : C3131.m10712();
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public static final <T> List<T> m14747(T[] tArr) {
        C3921.m12666(tArr, "<this>");
        return new ArrayList(C3131.m10709(tArr));
    }
}
