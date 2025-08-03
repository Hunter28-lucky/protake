package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.C4905;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableCache<T> extends AbstractC3414<T, T> implements InterfaceC5102<T> {

    /* renamed from: ހ, reason: contains not printable characters */
    public static final CacheDisposable[] f7311 = new CacheDisposable[0];

    /* renamed from: ށ, reason: contains not printable characters */
    public static final CacheDisposable[] f7312 = new CacheDisposable[0];

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AtomicBoolean f7313;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f7314;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AtomicReference<CacheDisposable<T>[]> f7315;

    /* renamed from: ԯ, reason: contains not printable characters */
    public volatile long f7316;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final C2074<T> f7317;

    /* renamed from: ֈ, reason: contains not printable characters */
    public C2074<T> f7318;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f7319;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Throwable f7320;

    /* renamed from: ؠ, reason: contains not printable characters */
    public volatile boolean f7321;

    public static final class CacheDisposable<T> extends AtomicInteger implements InterfaceC4478 {
        private static final long serialVersionUID = 6770240836423125754L;
        public volatile boolean disposed;
        public final InterfaceC5102<? super T> downstream;
        public long index;
        public C2074<T> node;
        public int offset;
        public final ObservableCache<T> parent;

        public CacheDisposable(InterfaceC5102<? super T> interfaceC5102, ObservableCache<T> observableCache) {
            this.downstream = interfaceC5102;
            this.parent = observableCache;
            this.node = observableCache.f7317;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.parent.m6740(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableCache$Ϳ, reason: contains not printable characters */
    public static final class C2074<T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final T[] f7322;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public volatile C2074<T> f7323;

        public C2074(int i) {
            this.f7322 = (T[]) new Object[i];
        }
    }

    public ObservableCache(AbstractC4262<T> abstractC4262, int i) {
        super(abstractC4262);
        this.f7314 = i;
        this.f7313 = new AtomicBoolean();
        C2074<T> c2074 = new C2074<>(i);
        this.f7317 = c2074;
        this.f7318 = c2074;
        this.f7315 = new AtomicReference<>(f7311);
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        this.f7321 = true;
        for (CacheDisposable<T> cacheDisposable : this.f7315.getAndSet(f7312)) {
            m6741(cacheDisposable);
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        this.f7320 = th;
        this.f7321 = true;
        for (CacheDisposable<T> cacheDisposable : this.f7315.getAndSet(f7312)) {
            m6741(cacheDisposable);
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        int i = this.f7319;
        if (i == this.f7314) {
            C2074<T> c2074 = new C2074<>(i);
            c2074.f7322[0] = t;
            this.f7319 = 1;
            this.f7318.f7323 = c2074;
            this.f7318 = c2074;
        } else {
            this.f7318.f7322[i] = t;
            this.f7319 = i + 1;
        }
        this.f7316++;
        for (CacheDisposable<T> cacheDisposable : this.f7315.get()) {
            m6741(cacheDisposable);
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(interfaceC5102, this);
        interfaceC5102.onSubscribe(cacheDisposable);
        m6739(cacheDisposable);
        if (this.f7313.get() || !this.f7313.compareAndSet(false, true)) {
            m6741(cacheDisposable);
        } else {
            this.f11778.subscribe(this);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m6739(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f7315.get();
            if (cacheDisposableArr == f7312) {
                return;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!C4905.m14631(this.f7315, cacheDisposableArr, cacheDisposableArr2));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m6740(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f7315.get();
            int length = cacheDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (cacheDisposableArr[i2] == cacheDisposable) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                cacheDisposableArr2 = f7311;
            } else {
                CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!C4905.m14631(this.f7315, cacheDisposableArr, cacheDisposableArr2));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m6741(CacheDisposable<T> cacheDisposable) {
        if (cacheDisposable.getAndIncrement() != 0) {
            return;
        }
        long j = cacheDisposable.index;
        int i = cacheDisposable.offset;
        C2074<T> c2074 = cacheDisposable.node;
        InterfaceC5102<? super T> interfaceC5102 = cacheDisposable.downstream;
        int i2 = this.f7314;
        int iAddAndGet = 1;
        while (!cacheDisposable.disposed) {
            boolean z = this.f7321;
            boolean z2 = this.f7316 == j;
            if (z && z2) {
                cacheDisposable.node = null;
                Throwable th = this.f7320;
                if (th != null) {
                    interfaceC5102.onError(th);
                    return;
                } else {
                    interfaceC5102.onComplete();
                    return;
                }
            }
            if (z2) {
                cacheDisposable.index = j;
                cacheDisposable.offset = i;
                cacheDisposable.node = c2074;
                iAddAndGet = cacheDisposable.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                if (i == i2) {
                    c2074 = c2074.f7323;
                    i = 0;
                }
                interfaceC5102.onNext(c2074.f7322[i]);
                i++;
                j++;
            }
        }
        cacheDisposable.node = null;
    }
}
