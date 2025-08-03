package defpackage;

import androidx.annotation.Nullable;
import defpackage.InterfaceC2902;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap.java */
/* renamed from: غ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3467<K extends InterfaceC2902, V> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C3468<K, V> f11963 = new C3468<>();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Map<K, C3468<K, V>> f11964 = new HashMap();

    /* compiled from: GroupedLinkedMap.java */
    /* renamed from: غ$Ϳ, reason: contains not printable characters */
    public static class C3468<K, V> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final K f11965;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public List<V> f11966;

        /* renamed from: ԩ, reason: contains not printable characters */
        public C3468<K, V> f11967;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public C3468<K, V> f11968;

        public C3468() {
            this(null);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m11305(V v) {
            if (this.f11966 == null) {
                this.f11966 = new ArrayList();
            }
            this.f11966.add(v);
        }

        @Nullable
        /* renamed from: Ԩ, reason: contains not printable characters */
        public V m11306() {
            int iM11307 = m11307();
            if (iM11307 > 0) {
                return this.f11966.remove(iM11307 - 1);
            }
            return null;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public int m11307() {
            List<V> list = this.f11966;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public C3468(K k) {
            this.f11968 = this;
            this.f11967 = this;
            this.f11965 = k;
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static <K, V> void m11298(C3468<K, V> c3468) {
        C3468<K, V> c34682 = c3468.f11968;
        c34682.f11967 = c3468.f11967;
        c3468.f11967.f11968 = c34682;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static <K, V> void m11299(C3468<K, V> c3468) {
        c3468.f11967.f11968 = c3468;
        c3468.f11968.f11967 = c3468;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (C3468 c3468 = this.f11963.f11967; !c3468.equals(this.f11963); c3468 = c3468.f11967) {
            z = true;
            sb.append('{');
            sb.append(c3468.f11965);
            sb.append(':');
            sb.append(c3468.m11307());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    @Nullable
    /* renamed from: Ϳ, reason: contains not printable characters */
    public V m11300(K k) {
        C3468<K, V> c3468 = this.f11964.get(k);
        if (c3468 == null) {
            c3468 = new C3468<>(k);
            this.f11964.put(k, c3468);
        } else {
            k.mo9486();
        }
        m11301(c3468);
        return c3468.m11306();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m11301(C3468<K, V> c3468) {
        m11298(c3468);
        C3468<K, V> c34682 = this.f11963;
        c3468.f11968 = c34682;
        c3468.f11967 = c34682.f11967;
        m11299(c3468);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m11302(C3468<K, V> c3468) {
        m11298(c3468);
        C3468<K, V> c34682 = this.f11963;
        c3468.f11968 = c34682.f11968;
        c3468.f11967 = c34682;
        m11299(c3468);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m11303(K k, V v) {
        C3468<K, V> c3468 = this.f11964.get(k);
        if (c3468 == null) {
            c3468 = new C3468<>(k);
            m11302(c3468);
            this.f11964.put(k, c3468);
        } else {
            k.mo9486();
        }
        c3468.m11305(v);
    }

    @Nullable
    /* renamed from: Ԭ, reason: contains not printable characters */
    public V m11304() {
        for (C3468 c3468 = this.f11963.f11968; !c3468.equals(this.f11963); c3468 = c3468.f11968) {
            V v = (V) c3468.m11306();
            if (v != null) {
                return v;
            }
            m11298(c3468);
            this.f11964.remove(c3468.f11965);
            ((InterfaceC2902) c3468.f11965).mo9486();
        }
        return null;
    }
}
