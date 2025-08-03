package com.google.android.datatransport.runtime.dagger.internal;

import defpackage.InterfaceC4815;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class SetFactory<T> implements Factory<Set<T>> {
    private static final Factory<Set<Object>> EMPTY_FACTORY = InstanceFactory.create(Collections.emptySet());
    private final List<InterfaceC4815<Collection<T>>> collectionProviders;
    private final List<InterfaceC4815<T>> individualProviders;

    public static final class Builder<T> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<InterfaceC4815<Collection<T>>> collectionProviders;
        private final List<InterfaceC4815<T>> individualProviders;

        public Builder<T> addCollectionProvider(InterfaceC4815<? extends Collection<? extends T>> interfaceC4815) {
            this.collectionProviders.add(interfaceC4815);
            return this;
        }

        public Builder<T> addProvider(InterfaceC4815<? extends T> interfaceC4815) {
            this.individualProviders.add(interfaceC4815);
            return this;
        }

        public SetFactory<T> build() {
            return new SetFactory<>(this.individualProviders, this.collectionProviders);
        }

        private Builder(int i, int i2) {
            this.individualProviders = DaggerCollections.presizedList(i);
            this.collectionProviders = DaggerCollections.presizedList(i2);
        }
    }

    public static <T> Builder<T> builder(int i, int i2) {
        return new Builder<>(i, i2);
    }

    public static <T> Factory<Set<T>> empty() {
        return (Factory<Set<T>>) EMPTY_FACTORY;
    }

    private SetFactory(List<InterfaceC4815<T>> list, List<InterfaceC4815<Collection<T>>> list2) {
        this.individualProviders = list;
        this.collectionProviders = list2;
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.InterfaceC4815
    public Set<T> get() {
        int size = this.individualProviders.size();
        ArrayList arrayList = new ArrayList(this.collectionProviders.size());
        int size2 = this.collectionProviders.size();
        for (int i = 0; i < size2; i++) {
            Collection<T> collection = this.collectionProviders.get(i).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet hashSetNewHashSetWithExpectedSize = DaggerCollections.newHashSetWithExpectedSize(size);
        int size3 = this.individualProviders.size();
        for (int i2 = 0; i2 < size3; i2++) {
            hashSetNewHashSetWithExpectedSize.add(Preconditions.checkNotNull(this.individualProviders.get(i2).get()));
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            Iterator it = ((Collection) arrayList.get(i3)).iterator();
            while (it.hasNext()) {
                hashSetNewHashSetWithExpectedSize.add(Preconditions.checkNotNull(it.next()));
            }
        }
        return Collections.unmodifiableSet(hashSetNewHashSetWithExpectedSize);
    }
}
