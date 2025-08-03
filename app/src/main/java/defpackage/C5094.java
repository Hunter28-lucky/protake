package defpackage;

import java.util.Set;
import kotlin.collections.EmptySet;

/* compiled from: Sets.kt */
/* renamed from: ဈ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C5094 extends C4756 {
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final <T> Set<T> m14922() {
        return EmptySet.f7831;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ԩ, reason: contains not printable characters */
    public static final <T> Set<T> m14923(Set<? extends T> set) {
        C3921.m12666(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : C4756.m14295(set.iterator().next()) : m14922();
    }
}
