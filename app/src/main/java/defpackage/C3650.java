package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: SetBuilder.java */
/* renamed from: ۻ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3650<T> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final List<T> f12664;

    public C3650(int i) {
        this.f12664 = new ArrayList(i);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T> C3650<T> m11736(int i) {
        return new C3650<>(i);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C3650<T> m11737(T t) {
        this.f12664.add(C4618.m14073(t, "Set contributions cannot be null"));
        return this;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Set<T> m11738() {
        int size = this.f12664.size();
        return size != 0 ? size != 1 ? Collections.unmodifiableSet(new HashSet(this.f12664)) : Collections.singleton(this.f12664.get(0)) : Collections.emptySet();
    }
}
