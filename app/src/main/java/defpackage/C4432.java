package defpackage;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;

/* compiled from: MapsJVM.kt */
/* renamed from: ଯ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4432 extends C2396 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final int m13665(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final <K, V> Map<K, V> m13666(Pair<? extends K, ? extends V> pair) {
        C3921.m12666(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.m7209(), pair.m7210());
        C3921.m12665(mapSingletonMap, "singletonMap(pair.first, pair.second)");
        return mapSingletonMap;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final <K, V> Map<K, V> m13667(Map<? extends K, ? extends V> map) {
        C3921.m12666(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        C3921.m12665(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }
}
