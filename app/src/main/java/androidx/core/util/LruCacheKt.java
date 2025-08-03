package androidx.core.util;

import android.util.LruCache;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC4365;
import defpackage.i4;

/* compiled from: LruCache.kt */
/* loaded from: classes.dex */
public final class LruCacheKt {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: LruCache.kt */
    /* renamed from: androidx.core.util.LruCacheKt$lruCache$4, reason: invalid class name */
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        public final /* synthetic */ InterfaceC2392<K, V> $create;
        public final /* synthetic */ InterfaceC4365<Boolean, K, V, V, i4> $onEntryRemoved;
        public final /* synthetic */ InterfaceC2849<K, V, Integer> $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(int i, InterfaceC2849<? super K, ? super V, Integer> interfaceC2849, InterfaceC2392<? super K, ? extends V> interfaceC2392, InterfaceC4365<? super Boolean, ? super K, ? super V, ? super V, i4> interfaceC4365) {
            super(i);
            this.$sizeOf = interfaceC2849;
            this.$create = interfaceC2392;
            this.$onEntryRemoved = interfaceC4365;
        }

        @Override // android.util.LruCache
        public V create(K k) {
            C3921.m12666(k, "key");
            return this.$create.invoke(k);
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean z, K k, V v, V v2) {
            C3921.m12666(k, "key");
            C3921.m12666(v, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(z), k, v, v2);
        }

        @Override // android.util.LruCache
        public int sizeOf(K k, V v) {
            C3921.m12666(k, "key");
            C3921.m12666(v, "value");
            return this.$sizeOf.invoke(k, v).intValue();
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int i, InterfaceC2849<? super K, ? super V, Integer> interfaceC2849, InterfaceC2392<? super K, ? extends V> interfaceC2392, InterfaceC4365<? super Boolean, ? super K, ? super V, ? super V, i4> interfaceC4365) {
        C3921.m12666(interfaceC2849, "sizeOf");
        C3921.m12666(interfaceC2392, "create");
        C3921.m12666(interfaceC4365, "onEntryRemoved");
        return new AnonymousClass4(i, interfaceC2849, interfaceC2392, interfaceC4365);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, InterfaceC2849 interfaceC2849, InterfaceC2392 interfaceC2392, InterfaceC4365 interfaceC4365, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            interfaceC2849 = new InterfaceC2849() { // from class: androidx.core.util.LruCacheKt.lruCache.1
                @Override // defpackage.InterfaceC2849
                public final Integer invoke(Object obj2, Object obj3) {
                    C3921.m12666(obj2, "<anonymous parameter 0>");
                    C3921.m12666(obj3, "<anonymous parameter 1>");
                    return 1;
                }
            };
        }
        if ((i2 & 4) != 0) {
            interfaceC2392 = new InterfaceC2392() { // from class: androidx.core.util.LruCacheKt.lruCache.2
                @Override // defpackage.InterfaceC2392
                public final Object invoke(Object obj2) {
                    C3921.m12666(obj2, "it");
                    return null;
                }
            };
        }
        if ((i2 & 8) != 0) {
            interfaceC4365 = new InterfaceC4365() { // from class: androidx.core.util.LruCacheKt.lruCache.3
                @Override // defpackage.InterfaceC4365
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                    invoke(((Boolean) obj2).booleanValue(), obj3, obj4, obj5);
                    return i4.f6762;
                }

                public final void invoke(boolean z, Object obj2, Object obj3, Object obj4) {
                    C3921.m12666(obj2, "<anonymous parameter 1>");
                    C3921.m12666(obj3, "<anonymous parameter 2>");
                }
            };
        }
        C3921.m12666(interfaceC2849, "sizeOf");
        C3921.m12666(interfaceC2392, "create");
        C3921.m12666(interfaceC4365, "onEntryRemoved");
        return new AnonymousClass4(i, interfaceC2849, interfaceC2392, interfaceC4365);
    }
}
