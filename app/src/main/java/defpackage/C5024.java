package defpackage;

import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* renamed from: ཆ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C5024 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <T extends Comparable<?>> int m14813(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final <T extends Comparable<? super T>> Comparator<T> m14814() {
        return C2713.f10033;
    }
}
