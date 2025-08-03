package defpackage;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* compiled from: CachedHashCodeArrayMap.java */
/* renamed from: ˬ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2756<K, V> extends ArrayMap<K, V> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f10095;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.f10095 = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.f10095 == 0) {
            this.f10095 = super.hashCode();
        }
        return this.f10095;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k, V v) {
        this.f10095 = 0;
        return (V) super.put(k, v);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f10095 = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i) {
        this.f10095 = 0;
        return (V) super.removeAt(i);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i, V v) {
        this.f10095 = 0;
        return (V) super.setValueAt(i, v);
    }
}
