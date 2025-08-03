package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: _Sequences.kt */
/* renamed from: ॵ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4119 extends C3551 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.kt */
    /* renamed from: ॵ$Ϳ, reason: contains not printable characters */
    public static final class C4120<T> implements Iterable<T>, InterfaceC4947 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4590 f14272;

        public C4120(InterfaceC4590 interfaceC4590) {
            this.f14272 = interfaceC4590;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f14272.iterator();
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final <T> Iterable<T> m13073(InterfaceC4590<? extends T> interfaceC4590) {
        C3921.m12666(interfaceC4590, "<this>");
        return new C4120(interfaceC4590);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ԭ, reason: contains not printable characters */
    public static final <T> InterfaceC4590<T> m13074(InterfaceC4590<? extends T> interfaceC4590, int i) {
        C3921.m12666(interfaceC4590, "<this>");
        if (i >= 0) {
            return i == 0 ? interfaceC4590 : interfaceC4590 instanceof InterfaceC2473 ? ((InterfaceC2473) interfaceC4590).mo9073(i) : new C3248(interfaceC4590, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final <T, A extends Appendable> A m13075(InterfaceC4590<? extends T> interfaceC4590, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC2392<? super T, ? extends CharSequence> interfaceC2392) throws IOException {
        C3921.m12666(interfaceC4590, "<this>");
        C3921.m12666(a, "buffer");
        C3921.m12666(charSequence, "separator");
        C3921.m12666(charSequence2, "prefix");
        C3921.m12666(charSequence3, "postfix");
        C3921.m12666(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (T t : interfaceC4590) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            x.m8583(a, t, interfaceC2392);
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final <T> String m13076(InterfaceC4590<? extends T> interfaceC4590, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC2392<? super T, ? extends CharSequence> interfaceC2392) {
        C3921.m12666(interfaceC4590, "<this>");
        C3921.m12666(charSequence, "separator");
        C3921.m12666(charSequence2, "prefix");
        C3921.m12666(charSequence3, "postfix");
        C3921.m12666(charSequence4, "truncated");
        String string = ((StringBuilder) m13075(interfaceC4590, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, interfaceC2392)).toString();
        C3921.m12665(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static /* synthetic */ String m13077(InterfaceC4590 interfaceC4590, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC2392 interfaceC2392, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            interfaceC2392 = null;
        }
        return m13076(interfaceC4590, charSequence, charSequence5, charSequence6, i3, charSequence7, interfaceC2392);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final <T, R> InterfaceC4590<R> m13078(InterfaceC4590<? extends T> interfaceC4590, InterfaceC2392<? super T, ? extends R> interfaceC2392) {
        C3921.m12666(interfaceC4590, "<this>");
        C3921.m12666(interfaceC2392, "transform");
        return new c3(interfaceC4590, interfaceC2392);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static final <T, C extends Collection<? super T>> C m13079(InterfaceC4590<? extends T> interfaceC4590, C c) {
        C3921.m12666(interfaceC4590, "<this>");
        C3921.m12666(c, "destination");
        Iterator<? extends T> it = interfaceC4590.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final <T> List<T> m13080(InterfaceC4590<? extends T> interfaceC4590) {
        C3921.m12666(interfaceC4590, "<this>");
        return C3131.m10717(m13081(interfaceC4590));
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static final <T> List<T> m13081(InterfaceC4590<? extends T> interfaceC4590) {
        C3921.m12666(interfaceC4590, "<this>");
        return (List) m13079(interfaceC4590, new ArrayList());
    }
}
