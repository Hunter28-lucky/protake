package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory;
import defpackage.InterfaceC4815;
import java.util.Map;

/* loaded from: classes.dex */
public final class MapProviderFactory<K, V> extends AbstractMapFactory<K, V, InterfaceC4815<V>> implements Lazy<Map<K, InterfaceC4815<V>>> {

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, InterfaceC4815<V>> {
        public MapProviderFactory<K, V> build() {
            return new MapProviderFactory<>(this.map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        public /* bridge */ /* synthetic */ AbstractMapFactory.Builder put(Object obj, InterfaceC4815 interfaceC4815) {
            return put((Builder<K, V>) obj, interfaceC4815);
        }

        private Builder(int i) {
            super(i);
        }

        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> put(K k, InterfaceC4815<V> interfaceC4815) {
            super.put((Builder<K, V>) k, (InterfaceC4815) interfaceC4815);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> putAll(InterfaceC4815<Map<K, InterfaceC4815<V>>> interfaceC4815) {
            super.putAll((InterfaceC4815) interfaceC4815);
            return this;
        }
    }

    public static <K, V> Builder<K, V> builder(int i) {
        return new Builder<>(i);
    }

    private MapProviderFactory(Map<K, InterfaceC4815<V>> map) {
        super(map);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory, com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public Map<K, InterfaceC4815<V>> get() {
        return contributingMap();
    }
}
