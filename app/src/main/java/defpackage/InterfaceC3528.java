package defpackage;

import java.lang.Comparable;

/* compiled from: Range.kt */
/* renamed from: ڐ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public interface InterfaceC3528<T extends Comparable<? super T>> {

    /* compiled from: Range.kt */
    /* renamed from: ڐ$Ϳ, reason: contains not printable characters */
    public static final class C3529 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public static <T extends Comparable<? super T>> boolean m11468(InterfaceC3528<T> interfaceC3528, T t) {
            C3921.m12666(t, "value");
            return t.compareTo(interfaceC3528.getStart()) >= 0 && t.compareTo(interfaceC3528.getEndInclusive()) <= 0;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static <T extends Comparable<? super T>> boolean m11469(InterfaceC3528<T> interfaceC3528) {
            return interfaceC3528.getStart().compareTo(interfaceC3528.getEndInclusive()) > 0;
        }
    }

    T getEndInclusive();

    T getStart();
}
