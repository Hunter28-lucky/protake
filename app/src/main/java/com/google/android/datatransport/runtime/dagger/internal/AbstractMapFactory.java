package com.google.android.datatransport.runtime.dagger.internal;

import com.umeng.analytics.pro.d;
import defpackage.InterfaceC4815;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {
    private final Map<K, InterfaceC4815<V>> contributingMap;

    public static abstract class Builder<K, V, V2> {
        public final LinkedHashMap<K, InterfaceC4815<V>> map;

        public Builder(int i) {
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder<K, V, V2> put(K k, InterfaceC4815<V> interfaceC4815) {
            this.map.put(Preconditions.checkNotNull(k, "key"), Preconditions.checkNotNull(interfaceC4815, d.M));
            return this;
        }

        public Builder<K, V, V2> putAll(InterfaceC4815<Map<K, V2>> interfaceC4815) {
            if (interfaceC4815 instanceof DelegateFactory) {
                return putAll(((DelegateFactory) interfaceC4815).getDelegate());
            }
            this.map.putAll(((AbstractMapFactory) interfaceC4815).contributingMap);
            return this;
        }
    }

    public AbstractMapFactory(Map<K, InterfaceC4815<V>> map) {
        this.contributingMap = Collections.unmodifiableMap(map);
    }

    public final Map<K, InterfaceC4815<V>> contributingMap() {
        return this.contributingMap;
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public abstract /* synthetic */ Object get();
}
