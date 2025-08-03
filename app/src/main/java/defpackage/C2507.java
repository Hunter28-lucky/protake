package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ModelLoaderRegistry.java */
/* renamed from: ǿ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2507 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C4057 f9303;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C2508 f9304;

    /* compiled from: ModelLoaderRegistry.java */
    /* renamed from: ǿ$Ϳ, reason: contains not printable characters */
    public static class C2508 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Map<Class<?>, C2509<?>> f9305 = new HashMap();

        /* compiled from: ModelLoaderRegistry.java */
        /* renamed from: ǿ$Ϳ$Ϳ, reason: contains not printable characters */
        public static class C2509<Model> {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final List<InterfaceC4900<Model, ?>> f9306;

            public C2509(List<InterfaceC4900<Model, ?>> list) {
                this.f9306 = list;
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m9261() {
            this.f9305.clear();
        }

        @Nullable
        /* renamed from: Ԩ, reason: contains not printable characters */
        public <Model> List<InterfaceC4900<Model, ?>> m9262(Class<Model> cls) {
            C2509<?> c2509 = this.f9305.get(cls);
            if (c2509 == null) {
                return null;
            }
            return (List<InterfaceC4900<Model, ?>>) c2509.f9306;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public <Model> void m9263(Class<Model> cls, List<InterfaceC4900<Model, ?>> list) {
            if (this.f9305.put(cls, new C2509<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public C2507(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new C4057(pool));
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <A> Class<A> m9256(@NonNull A a) {
        return (Class<A>) a.getClass();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public synchronized <Model, Data> void m9257(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC5295<? extends Model, ? extends Data> interfaceC5295) {
        this.f9303.m12982(cls, cls2, interfaceC5295);
        this.f9304.m9261();
    }

    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters */
    public synchronized List<Class<?>> m9258(@NonNull Class<?> cls) {
        return this.f9303.m12986(cls);
    }

    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters */
    public synchronized <A> List<InterfaceC4900<A, ?>> m9259(@NonNull A a) {
        ArrayList arrayList;
        List<InterfaceC4900<A, ?>> listM9260 = m9260(m9256(a));
        int size = listM9260.size();
        arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            InterfaceC4900<A, ?> interfaceC4900 = listM9260.get(i);
            if (interfaceC4900.mo7(a)) {
                arrayList.add(interfaceC4900);
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: ԫ, reason: contains not printable characters */
    public final <A> List<InterfaceC4900<A, ?>> m9260(@NonNull Class<A> cls) {
        List<InterfaceC4900<A, ?>> listM9262 = this.f9304.m9262(cls);
        if (listM9262 != null) {
            return listM9262;
        }
        List<InterfaceC4900<A, ?>> listUnmodifiableList = Collections.unmodifiableList(this.f9303.m12985(cls));
        this.f9304.m9263(cls, listUnmodifiableList);
        return listUnmodifiableList;
    }

    public C2507(@NonNull C4057 c4057) {
        this.f9304 = new C2508();
        this.f9303 = c4057;
    }
}
