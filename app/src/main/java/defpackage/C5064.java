package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: CollectionsJVM.kt */
/* renamed from: ལ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C5064 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <T> Object[] m14876(T[] tArr, boolean z) {
        C3921.m12666(tArr, "<this>");
        if (z && C3921.m12662(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        C3921.m12665(objArrCopyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final <T> List<T> m14877(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        C3921.m12665(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }
}
