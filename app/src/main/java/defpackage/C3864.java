package defpackage;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: MutableCollections.kt */
/* renamed from: ߤ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3864 extends C5043 {
    /* renamed from: ށ, reason: contains not printable characters */
    public static final <T> boolean m12311(Collection<? super T> collection, Iterable<? extends T> iterable) {
        C3921.m12666(collection, "<this>");
        C3921.m12666(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static final <T> boolean m12312(Collection<? super T> collection, T[] tArr) {
        C3921.m12666(collection, "<this>");
        C3921.m12666(tArr, "elements");
        return collection.addAll(C4955.m14725(tArr));
    }
}
