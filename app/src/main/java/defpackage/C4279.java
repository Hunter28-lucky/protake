package defpackage;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.C1812;
import com.bumptech.glide.load.engine.C1826;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LoadPathCache.java */
/* renamed from: ਸ਼, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4279 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final C1826<?, ?, ?> f14662 = new C1826<>(Object.class, Object.class, Object.class, Collections.singletonList(new C1812(Object.class, Object.class, Object.class, Collections.emptyList(), new m4(), null)), null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final ArrayMap<C3674, C1826<?, ?, ?>> f14663 = new ArrayMap<>();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final AtomicReference<C3674> f14664 = new AtomicReference<>();

    @Nullable
    /* renamed from: Ϳ, reason: contains not printable characters */
    public <Data, TResource, Transcode> C1826<Data, TResource, Transcode> m13394(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        C1826<Data, TResource, Transcode> c1826;
        C3674 c3674M13395 = m13395(cls, cls2, cls3);
        synchronized (this.f14663) {
            c1826 = (C1826) this.f14663.get(c3674M13395);
        }
        this.f14664.set(c3674M13395);
        return c1826;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C3674 m13395(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        C3674 andSet = this.f14664.getAndSet(null);
        if (andSet == null) {
            andSet = new C3674();
        }
        andSet.m11819(cls, cls2, cls3);
        return andSet;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean m13396(@Nullable C1826<?, ?, ?> c1826) {
        return f14662.equals(c1826);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m13397(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable C1826<?, ?, ?> c1826) {
        synchronized (this.f14663) {
            ArrayMap<C3674, C1826<?, ?, ?>> arrayMap = this.f14663;
            C3674 c3674 = new C3674(cls, cls2, cls3);
            if (c1826 == null) {
                c1826 = f14662;
            }
            arrayMap.put(c3674, c1826);
        }
    }
}
