package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: Collections.kt */
/* renamed from: ӷ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3131 extends C5064 {
    /* renamed from: ԩ, reason: contains not printable characters */
    public static final <T> Collection<T> m10709(T[] tArr) {
        C3921.m12666(tArr, "<this>");
        return new C4750(tArr, false);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final <T extends Comparable<? super T>> int m10710(List<? extends T> list, T t, int i, int i2) {
        C3921.m12666(list, "<this>");
        m10718(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iM14813 = C5024.m14813(list.get(i4), t);
            if (iM14813 < 0) {
                i = i4 + 1;
            } else {
                if (iM14813 <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static /* synthetic */ int m10711(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return m10710(list, comparable, i, i2);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final <T> List<T> m10712() {
        return EmptyList.f7829;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final <T> int m10713(List<? extends T> list) {
        C3921.m12666(list, "<this>");
        return list.size() - 1;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final <T> List<T> m10714(T... tArr) {
        C3921.m12666(tArr, "elements");
        return tArr.length > 0 ? C4955.m14725(tArr) : m10712();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final <T> List<T> m10715(T... tArr) {
        C3921.m12666(tArr, "elements");
        return C4962.m14739(tArr);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final <T> List<T> m10716(T... tArr) {
        C3921.m12666(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new C4750(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ֈ, reason: contains not printable characters */
    public static final <T> List<T> m10717(List<? extends T> list) {
        C3921.m12666(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : C5064.m14877(list.get(0)) : m10712();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static final void m10718(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        }
        if (i3 <= i) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final void m10719() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
