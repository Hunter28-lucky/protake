package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: _Collections.kt */
/* renamed from: ȷ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C2543 extends C2759 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: ȷ$Ϳ, reason: contains not printable characters */
    public static final class C2544<T> implements InterfaceC4590<T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ Iterable f9403;

        public C2544(Iterable iterable) {
            this.f9403 = iterable;
        }

        @Override // defpackage.InterfaceC4590
        public Iterator<T> iterator() {
            return this.f9403.iterator();
        }
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static final <T> InterfaceC4590<T> m9367(Iterable<? extends T> iterable) {
        C3921.m12666(iterable, "<this>");
        return new C2544(iterable);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static final <T> List<T> m9368(List<? extends T> list, int i) {
        C3921.m12666(list, "<this>");
        if (i >= 0) {
            return m9380(list, C4542.m13943(list.size() - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public static final <T> T m9369(Iterable<? extends T> iterable) {
        C3921.m12666(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) m9370((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public static final <T> T m9370(List<? extends T> list) {
        C3921.m12666(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public static final <T, A extends Appendable> A m9371(Iterable<? extends T> iterable, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC2392<? super T, ? extends CharSequence> interfaceC2392) throws IOException {
        C3921.m12666(iterable, "<this>");
        C3921.m12666(a, "buffer");
        C3921.m12666(charSequence, "separator");
        C3921.m12666(charSequence2, "prefix");
        C3921.m12666(charSequence3, "postfix");
        C3921.m12666(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (T t : iterable) {
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

    /* renamed from: މ, reason: contains not printable characters */
    public static final <T> String m9373(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC2392<? super T, ? extends CharSequence> interfaceC2392) {
        C3921.m12666(iterable, "<this>");
        C3921.m12666(charSequence, "separator");
        C3921.m12666(charSequence2, "prefix");
        C3921.m12666(charSequence3, "postfix");
        C3921.m12666(charSequence4, "truncated");
        String string = ((StringBuilder) m9371(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, interfaceC2392)).toString();
        C3921.m12665(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public static /* synthetic */ String m9374(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC2392 interfaceC2392, int i2, Object obj) {
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
        return m9373(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, interfaceC2392);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public static final <T> T m9375(List<? extends T> list) {
        C3921.m12666(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(C3131.m10713(list));
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public static final <T> List<T> m9376(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        C3921.m12666(collection, "<this>");
        C3921.m12666(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            C3864.m12311(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public static final <T> List<T> m9377(Collection<? extends T> collection, T t) {
        C3921.m12666(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public static final <T> T m9378(Iterable<? extends T> iterable) {
        C3921.m12666(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) m9379((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public static final <T> T m9379(List<? extends T> list) {
        C3921.m12666(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public static final <T> List<T> m9380(Iterable<? extends T> iterable, int i) {
        C3921.m12666(iterable, "<this>");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return C3131.m10712();
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return m9382(iterable);
            }
            if (i == 1) {
                return C5064.m14877(m9369(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return C3131.m10717(arrayList);
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public static final <T, C extends Collection<? super T>> C m9381(Iterable<? extends T> iterable, C c) {
        C3921.m12666(iterable, "<this>");
        C3921.m12666(c, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public static final <T> List<T> m9382(Iterable<? extends T> iterable) {
        C3921.m12666(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return C3131.m10717(m9383(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return C3131.m10712();
        }
        if (size != 1) {
            return m9384(collection);
        }
        return C5064.m14877(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public static final <T> List<T> m9383(Iterable<? extends T> iterable) {
        C3921.m12666(iterable, "<this>");
        return iterable instanceof Collection ? m9384((Collection) iterable) : (List) m9381(iterable, new ArrayList());
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public static final <T> List<T> m9384(Collection<? extends T> collection) {
        C3921.m12666(collection, "<this>");
        return new ArrayList(collection);
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public static final <T> Set<T> m9385(Iterable<? extends T> iterable) {
        C3921.m12666(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return C5094.m14923((Set) m9381(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return C5094.m14922();
        }
        if (size != 1) {
            return (Set) m9381(iterable, new LinkedHashSet(C4432.m13665(collection.size())));
        }
        return C4756.m14295(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }
}
