package defpackage;

import java.util.ArrayList;

/* compiled from: InlineList.kt */
/* renamed from: ɦ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2593<E> {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <E> Object m9494(Object obj) {
        return obj;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static /* synthetic */ Object m9495(Object obj, int i, C4184 c4184) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return m9494(obj);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final Object m9496(Object obj, E e2) {
        if (obj == null) {
            return m9494(e2);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e2);
            return m9494(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e2);
        return m9494(arrayList);
    }
}
