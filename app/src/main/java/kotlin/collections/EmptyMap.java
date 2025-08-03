package kotlin.collections;

import defpackage.C3921;
import defpackage.InterfaceC4947;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: Maps.kt */
/* loaded from: classes2.dex */
final class EmptyMap implements Map, Serializable, InterfaceC4947 {
    private static final long serialVersionUID = 8246714829545688274L;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final EmptyMap f7830 = new EmptyMap();

    private EmptyMap() {
    }

    private final Object readResolve() {
        return f7830;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return m7226((Void) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry> entrySet() {
        return m7228();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Object> keySet() {
        return m7229();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return m7230();
    }

    public String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return m7231();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m7226(Void r2) {
        C3921.m12666(r2, "value");
        return false;
    }

    @Override // java.util.Map
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Void get(Object obj) {
        return null;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public Set<Map.Entry> m7228() {
        return EmptySet.f7831;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public Set<Object> m7229() {
        return EmptySet.f7831;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public int m7230() {
        return 0;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Collection m7231() {
        return EmptyList.f7829;
    }

    @Override // java.util.Map
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Void remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
