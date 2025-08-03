package defpackage;

import com.blink.academy.film.support.stream.ts.TsConstants;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* renamed from: આ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4303 implements Comparator<Comparable<? super Object>> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final C4303 f14740 = new C4303();

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return C2713.f10033;
    }

    @Override // java.util.Comparator
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public int compare(Comparable<Object> comparable, Comparable<Object> comparable2) {
        C3921.m12666(comparable, "a");
        C3921.m12666(comparable2, TsConstants.kLinkParam_suffix);
        return comparable2.compareTo(comparable);
    }
}
