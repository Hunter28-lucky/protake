package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import defpackage.InterfaceC4900;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: MultiModelLoaderFactory.java */
/* renamed from: क, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4057 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final C4060 f14080 = new C4060();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final InterfaceC4900<Object, Object> f14081 = new C4058();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final List<C4059<?, ?>> f14082;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C4060 f14083;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Set<C4059<?, ?>> f14084;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Pools.Pool<List<Throwable>> f14085;

    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: क$Ϳ, reason: contains not printable characters */
    public static class C4058 implements InterfaceC4900<Object, Object> {
        @Override // defpackage.InterfaceC4900
        /* renamed from: Ϳ */
        public boolean mo7(@NonNull Object obj) {
            return false;
        }

        @Override // defpackage.InterfaceC4900
        @Nullable
        /* renamed from: Ԩ */
        public InterfaceC4900.C4901<Object> mo8(@NonNull Object obj, int i, int i2, @NonNull C3475 c3475) {
            return null;
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: क$Ԩ, reason: contains not printable characters */
    public static class C4059<Model, Data> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Class<Model> f14086;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final Class<Data> f14087;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final InterfaceC5295<? extends Model, ? extends Data> f14088;

        public C4059(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC5295<? extends Model, ? extends Data> interfaceC5295) {
            this.f14086 = cls;
            this.f14087 = cls2;
            this.f14088 = interfaceC5295;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m12987(@NonNull Class<?> cls) {
            return this.f14086.isAssignableFrom(cls);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean m12988(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return m12987(cls) && this.f14087.isAssignableFrom(cls2);
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: क$Ԫ, reason: contains not printable characters */
    public static class C4060 {
        @NonNull
        /* renamed from: Ϳ, reason: contains not printable characters */
        public <Model, Data> C5196<Model, Data> m12989(@NonNull List<InterfaceC4900<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new C5196<>(list, pool);
        }
    }

    public C4057(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f14080);
    }

    @NonNull
    /* renamed from: Ԭ, reason: contains not printable characters */
    public static <Model, Data> InterfaceC4900<Model, Data> m12980() {
        return (InterfaceC4900<Model, Data>) f14081;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final <Model, Data> void m12981(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC5295<? extends Model, ? extends Data> interfaceC5295, boolean z) {
        C4059<?, ?> c4059 = new C4059<>(cls, cls2, interfaceC5295);
        List<C4059<?, ?>> list = this.f14082;
        list.add(z ? list.size() : 0, c4059);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized <Model, Data> void m12982(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC5295<? extends Model, ? extends Data> interfaceC5295) {
        m12981(cls, cls2, interfaceC5295, true);
    }

    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters */
    public final <Model, Data> InterfaceC4900<Model, Data> m12983(@NonNull C4059<?, ?> c4059) {
        return (InterfaceC4900) C4513.m13867(c4059.f14088.mo12(this));
    }

    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters */
    public synchronized <Model, Data> InterfaceC4900<Model, Data> m12984(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (C4059<?, ?> c4059 : this.f14082) {
                if (this.f14084.contains(c4059)) {
                    z = true;
                } else if (c4059.m12988(cls, cls2)) {
                    this.f14084.add(c4059);
                    arrayList.add(m12983(c4059));
                    this.f14084.remove(c4059);
                }
            }
            if (arrayList.size() > 1) {
                return this.f14083.m12989(arrayList, this.f14085);
            }
            if (arrayList.size() == 1) {
                return (InterfaceC4900) arrayList.get(0);
            }
            if (!z) {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            }
            return m12980();
        } catch (Throwable th) {
            this.f14084.clear();
            throw th;
        }
    }

    @NonNull
    /* renamed from: ԫ, reason: contains not printable characters */
    public synchronized <Model> List<InterfaceC4900<Model, ?>> m12985(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (C4059<?, ?> c4059 : this.f14082) {
                if (!this.f14084.contains(c4059) && c4059.m12987(cls)) {
                    this.f14084.add(c4059);
                    arrayList.add(m12983(c4059));
                    this.f14084.remove(c4059);
                }
            }
        } catch (Throwable th) {
            this.f14084.clear();
            throw th;
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: ԭ, reason: contains not printable characters */
    public synchronized List<Class<?>> m12986(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (C4059<?, ?> c4059 : this.f14082) {
            if (!arrayList.contains(c4059.f14087) && c4059.m12987(cls)) {
                arrayList.add(c4059.f14087);
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    public C4057(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull C4060 c4060) {
        this.f14082 = new ArrayList();
        this.f14084 = new HashSet();
        this.f14085 = pool;
        this.f14083 = c4060;
    }
}
