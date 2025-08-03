package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ModelToResourceClassCache.java */
/* renamed from: ϙ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2841 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final AtomicReference<C3674> f10319 = new AtomicReference<>();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final ArrayMap<C3674, List<Class<?>>> f10320 = new ArrayMap<>();

    @Nullable
    /* renamed from: Ϳ, reason: contains not printable characters */
    public List<Class<?>> m10181(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        List<Class<?>> list;
        C3674 andSet = this.f10319.getAndSet(null);
        if (andSet == null) {
            andSet = new C3674(cls, cls2);
        } else {
            andSet.m11818(cls, cls2);
        }
        synchronized (this.f10320) {
            list = this.f10320.get(andSet);
        }
        this.f10319.set(andSet);
        return list;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m10182(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull List<Class<?>> list) {
        synchronized (this.f10320) {
            this.f10320.put(new C3674(cls, cls2), list);
        }
    }
}
