package io.reactivex.subjects;

import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4851;
import defpackage.InterfaceC5102;
import defpackage.d;
import defpackage.k0;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class UnicastSubject<T> extends k0<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final d<T> f7712;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AtomicReference<InterfaceC5102<? super T>> f7713;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final AtomicReference<Runnable> f7714;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean f7715;

    /* renamed from: ԯ, reason: contains not printable characters */
    public volatile boolean f7716;

    /* renamed from: ՠ, reason: contains not printable characters */
    public volatile boolean f7717;

    /* renamed from: ֈ, reason: contains not printable characters */
    public Throwable f7718;

    /* renamed from: ֏, reason: contains not printable characters */
    public final AtomicBoolean f7719;

    /* renamed from: ׯ, reason: contains not printable characters */
    public final BasicIntQueueDisposable<T> f7720;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f7721;

    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        public UnicastQueueDisposable() {
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            UnicastSubject.this.f7712.clear();
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (UnicastSubject.this.f7716) {
                return;
            }
            UnicastSubject.this.f7716 = true;
            UnicastSubject.this.m7043();
            UnicastSubject.this.f7713.lazySet(null);
            if (UnicastSubject.this.f7720.getAndIncrement() == 0) {
                UnicastSubject.this.f7713.lazySet(null);
                UnicastSubject unicastSubject = UnicastSubject.this;
                if (unicastSubject.f7721) {
                    return;
                }
                unicastSubject.f7712.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return UnicastSubject.this.f7716;
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return UnicastSubject.this.f7712.isEmpty();
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            return UnicastSubject.this.f7712.poll();
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.f7721 = true;
            return 2;
        }
    }

    public UnicastSubject(int i, boolean z) {
        this.f7712 = new d<>(C4246.m13354(i, "capacityHint"));
        this.f7714 = new AtomicReference<>();
        this.f7715 = z;
        this.f7713 = new AtomicReference<>();
        this.f7719 = new AtomicBoolean();
        this.f7720 = new UnicastQueueDisposable();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static <T> UnicastSubject<T> m7040() {
        return new UnicastSubject<>(AbstractC4262.bufferSize(), true);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static <T> UnicastSubject<T> m7041(int i) {
        return new UnicastSubject<>(i, true);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static <T> UnicastSubject<T> m7042(int i, Runnable runnable) {
        return new UnicastSubject<>(i, runnable, true);
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        if (this.f7717 || this.f7716) {
            return;
        }
        this.f7717 = true;
        m7043();
        m7044();
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        C4246.m13353(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f7717 || this.f7716) {
            C3671.m11803(th);
            return;
        }
        this.f7718 = th;
        this.f7717 = true;
        m7043();
        m7044();
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        C4246.m13353(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f7717 || this.f7716) {
            return;
        }
        this.f7712.offer(t);
        m7044();
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        if (this.f7717 || this.f7716) {
            interfaceC4478.dispose();
        }
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        if (this.f7719.get() || !this.f7719.compareAndSet(false, true)) {
            EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), interfaceC5102);
            return;
        }
        interfaceC5102.onSubscribe(this.f7720);
        this.f7713.lazySet(interfaceC5102);
        if (this.f7716) {
            this.f7713.lazySet(null);
        } else {
            m7044();
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m7043() {
        Runnable runnable = this.f7714.get();
        if (runnable == null || !C4905.m14631(this.f7714, runnable, null)) {
            return;
        }
        runnable.run();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m7044() {
        if (this.f7720.getAndIncrement() != 0) {
            return;
        }
        InterfaceC5102<? super T> interfaceC5102 = this.f7713.get();
        int iAddAndGet = 1;
        while (interfaceC5102 == null) {
            iAddAndGet = this.f7720.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                interfaceC5102 = this.f7713.get();
            }
        }
        if (this.f7721) {
            m7045(interfaceC5102);
        } else {
            m7046(interfaceC5102);
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m7045(InterfaceC5102<? super T> interfaceC5102) {
        d<T> dVar = this.f7712;
        int iAddAndGet = 1;
        boolean z = !this.f7715;
        while (!this.f7716) {
            boolean z2 = this.f7717;
            if (z && z2 && m7048(dVar, interfaceC5102)) {
                return;
            }
            interfaceC5102.onNext(null);
            if (z2) {
                m7047(interfaceC5102);
                return;
            } else {
                iAddAndGet = this.f7720.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
        this.f7713.lazySet(null);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m7046(InterfaceC5102<? super T> interfaceC5102) {
        d<T> dVar = this.f7712;
        boolean z = !this.f7715;
        boolean z2 = true;
        int iAddAndGet = 1;
        while (!this.f7716) {
            boolean z3 = this.f7717;
            T tPoll = this.f7712.poll();
            boolean z4 = tPoll == null;
            if (z3) {
                if (z && z2) {
                    if (m7048(dVar, interfaceC5102)) {
                        return;
                    } else {
                        z2 = false;
                    }
                }
                if (z4) {
                    m7047(interfaceC5102);
                    return;
                }
            }
            if (z4) {
                iAddAndGet = this.f7720.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                interfaceC5102.onNext(tPoll);
            }
        }
        this.f7713.lazySet(null);
        dVar.clear();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m7047(InterfaceC5102<? super T> interfaceC5102) {
        this.f7713.lazySet(null);
        Throwable th = this.f7718;
        if (th != null) {
            interfaceC5102.onError(th);
        } else {
            interfaceC5102.onComplete();
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean m7048(InterfaceC4851<T> interfaceC4851, InterfaceC5102<? super T> interfaceC5102) {
        Throwable th = this.f7718;
        if (th == null) {
            return false;
        }
        this.f7713.lazySet(null);
        interfaceC4851.clear();
        interfaceC5102.onError(th);
        return true;
    }

    public UnicastSubject(int i, Runnable runnable, boolean z) {
        this.f7712 = new d<>(C4246.m13354(i, "capacityHint"));
        this.f7714 = new AtomicReference<>(C4246.m13353(runnable, "onTerminate"));
        this.f7715 = z;
        this.f7713 = new AtomicReference<>();
        this.f7719 = new AtomicBoolean();
        this.f7720 = new UnicastQueueDisposable();
    }
}
