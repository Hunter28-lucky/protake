package defpackage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FactoryPools.java */
/* renamed from: ţ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2380 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final InterfaceC2387<Object> f8939 = new C2381();

    /* compiled from: FactoryPools.java */
    /* renamed from: ţ$Ϳ, reason: contains not printable characters */
    public class C2381 implements InterfaceC2387<Object> {
        @Override // defpackage.C2380.InterfaceC2387
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo8871(@NonNull Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FactoryPools.java */
    /* renamed from: ţ$Ԩ, reason: contains not printable characters */
    public class C2382<T> implements InterfaceC2384<List<T>> {
        @Override // defpackage.C2380.InterfaceC2384
        @NonNull
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public List<T> mo4957() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FactoryPools.java */
    /* renamed from: ţ$Ԫ, reason: contains not printable characters */
    public class C2383<T> implements InterfaceC2387<List<T>> {
        @Override // defpackage.C2380.InterfaceC2387
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo8871(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: ţ$Ԭ, reason: contains not printable characters */
    public interface InterfaceC2384<T> {
        /* renamed from: Ϳ */
        T mo4957();
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: ţ$Ԯ, reason: contains not printable characters */
    public static final class C2385<T> implements Pools.Pool<T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC2384<T> f8940;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final InterfaceC2387<T> f8941;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final Pools.Pool<T> f8942;

        public C2385(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC2384<T> interfaceC2384, @NonNull InterfaceC2387<T> interfaceC2387) {
            this.f8942 = pool;
            this.f8940 = interfaceC2384;
            this.f8941 = interfaceC2387;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T tAcquire = this.f8942.acquire();
            if (tAcquire == null) {
                tAcquire = this.f8940.mo4957();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + tAcquire.getClass());
                }
            }
            if (tAcquire instanceof InterfaceC2386) {
                tAcquire.mo4858().mo6229(false);
            }
            return (T) tAcquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof InterfaceC2386) {
                ((InterfaceC2386) t).mo4858().mo6229(true);
            }
            this.f8941.mo8871(t);
            return this.f8942.release(t);
        }
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: ţ$ՠ, reason: contains not printable characters */
    public interface InterfaceC2386 {
        @NonNull
        /* renamed from: Ԭ */
        i mo4858();
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: ţ$ֈ, reason: contains not printable characters */
    public interface InterfaceC2387<T> {
        /* renamed from: Ϳ */
        void mo8871(@NonNull T t);
    }

    @NonNull
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T extends InterfaceC2386> Pools.Pool<T> m8864(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC2384<T> interfaceC2384) {
        return m8865(pool, interfaceC2384, m8866());
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T> Pools.Pool<T> m8865(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC2384<T> interfaceC2384, @NonNull InterfaceC2387<T> interfaceC2387) {
        return new C2385(pool, interfaceC2384, interfaceC2387);
    }

    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T> InterfaceC2387<T> m8866() {
        return (InterfaceC2387<T>) f8939;
    }

    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters */
    public static <T extends InterfaceC2386> Pools.Pool<T> m8867(int i, @NonNull InterfaceC2384<T> interfaceC2384) {
        return m8864(new Pools.SimplePool(i), interfaceC2384);
    }

    @NonNull
    /* renamed from: ԫ, reason: contains not printable characters */
    public static <T extends InterfaceC2386> Pools.Pool<T> m8868(int i, @NonNull InterfaceC2384<T> interfaceC2384) {
        return m8864(new Pools.SynchronizedPool(i), interfaceC2384);
    }

    @NonNull
    /* renamed from: Ԭ, reason: contains not printable characters */
    public static <T> Pools.Pool<List<T>> m8869() {
        return m8870(20);
    }

    @NonNull
    /* renamed from: ԭ, reason: contains not printable characters */
    public static <T> Pools.Pool<List<T>> m8870(int i) {
        return m8865(new Pools.SynchronizedPool(i), new C2382(), new C2383());
    }
}
