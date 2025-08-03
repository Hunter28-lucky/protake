package kotlin.collections;

import defpackage.C3921;
import defpackage.C4432;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* compiled from: Maps.kt */
/* renamed from: kotlin.collections.Ϳ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C2138 extends C4432 {
    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final <K, V> Map<K, V> m7235() {
        return EmptyMap.f7830;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ԫ, reason: contains not printable characters */
    public static final <K, V> Map<K, V> m7236(Map<K, ? extends V> map) {
        C3921.m12666(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : C4432.m13667(map) : m7235();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final <K, V> void m7237(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        C3921.m12666(map, "<this>");
        C3921.m12666(iterable, "pairs");
        for (Pair<? extends K, ? extends V> pair : iterable) {
            map.put(pair.m7207(), pair.m7208());
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final <K, V> Map<K, V> m7238(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        C3921.m12666(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return m7236(m7239(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return m7235();
        }
        if (size != 1) {
            return m7239(iterable, new LinkedHashMap(C4432.m13665(collection.size())));
        }
        return C4432.m13666(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final <K, V, M extends Map<? super K, ? super V>> M m7239(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m) {
        C3921.m12666(iterable, "<this>");
        C3921.m12666(m, "destination");
        m7237(m, iterable);
        return m;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final <K, V> Map<K, V> m7240(Map<? extends K, ? extends V> map) {
        C3921.m12666(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? m7241(map) : C4432.m13667(map) : m7235();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final <K, V> Map<K, V> m7241(Map<? extends K, ? extends V> map) {
        C3921.m12666(map, "<this>");
        return new LinkedHashMap(map);
    }
}
