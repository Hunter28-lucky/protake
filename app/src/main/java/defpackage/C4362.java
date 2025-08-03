package defpackage;

import java.util.Collection;

/* compiled from: Iterables.kt */
/* renamed from: ર, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4362 extends C3131 {
    /* renamed from: ؠ, reason: contains not printable characters */
    public static final <T> int m13522(Iterable<? extends T> iterable, int i) {
        C3921.m12666(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
