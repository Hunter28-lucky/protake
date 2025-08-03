package io.reactivex.internal.operators.single;

import defpackage.AbstractC4838;
import defpackage.C4905;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleCache<T> extends AbstractC4838<T> implements InterfaceC4782<T> {

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final CacheDisposable[] f7566 = new CacheDisposable[0];

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final CacheDisposable[] f7567 = new CacheDisposable[0];

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f7568;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AtomicInteger f7569 = new AtomicInteger();

    /* renamed from: ԭ, reason: contains not printable characters */
    public final AtomicReference<CacheDisposable<T>[]> f7570 = new AtomicReference<>(f7566);

    /* renamed from: Ԯ, reason: contains not printable characters */
    public T f7571;

    /* renamed from: ԯ, reason: contains not printable characters */
    public Throwable f7572;

    public static final class CacheDisposable<T> extends AtomicBoolean implements InterfaceC4478 {
        private static final long serialVersionUID = 7514387411091976596L;
        public final InterfaceC4782<? super T> downstream;
        public final SingleCache<T> parent;

        public CacheDisposable(InterfaceC4782<? super T> interfaceC4782, SingleCache<T> singleCache) {
            this.downstream = interfaceC4782;
            this.parent = singleCache;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.m6947(this);
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get();
        }
    }

    public SingleCache(InterfaceC3951<? extends T> interfaceC3951) {
        this.f7568 = interfaceC3951;
    }

    @Override // defpackage.InterfaceC4782
    public void onError(Throwable th) {
        this.f7572 = th;
        for (CacheDisposable<T> cacheDisposable : this.f7570.getAndSet(f7567)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onError(th);
            }
        }
    }

    @Override // defpackage.InterfaceC4782
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
    }

    @Override // defpackage.InterfaceC4782
    public void onSuccess(T t) {
        this.f7571 = t;
        for (CacheDisposable<T> cacheDisposable : this.f7570.getAndSet(f7567)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onSuccess(t);
            }
        }
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(interfaceC4782, this);
        interfaceC4782.onSubscribe(cacheDisposable);
        if (m6946(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                m6947(cacheDisposable);
            }
            if (this.f7569.getAndIncrement() == 0) {
                this.f7568.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.f7572;
        if (th != null) {
            interfaceC4782.onError(th);
        } else {
            interfaceC4782.onSuccess(this.f7571);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean m6946(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f7570.get();
            if (cacheDisposableArr == f7567) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!C4905.m14631(this.f7570, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m6947(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f7570.get();
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
                cacheDisposableArr2 = f7566;
            } else {
                CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!C4905.m14631(this.f7570, cacheDisposableArr, cacheDisposableArr2));
    }
}
