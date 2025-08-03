package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.C2527;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5102;
import defpackage.a;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableFlatMapSingle<T, R> extends AbstractC3414<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> f7365;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7366;

    public static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = 8600231336733376951L;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public final InterfaceC5102<? super R> downstream;
        public final InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> mapper;
        public InterfaceC4478 upstream;
        public final C2527 set = new C2527();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicInteger active = new AtomicInteger(1);
        public final AtomicReference<d<R>> queue = new AtomicReference<>();

        public final class InnerObserver extends AtomicReference<InterfaceC4478> implements InterfaceC4782<R>, InterfaceC4478 {
            private static final long serialVersionUID = -502562646270949838L;

            public InnerObserver() {
            }

            @Override // defpackage.InterfaceC4478
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // defpackage.InterfaceC4478
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // defpackage.InterfaceC4782
            public void onError(Throwable th) {
                FlatMapSingleObserver.this.m6791(this, th);
            }

            @Override // defpackage.InterfaceC4782
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }

            @Override // defpackage.InterfaceC4782
            public void onSuccess(R r) {
                FlatMapSingleObserver.this.m6792(this, r);
            }
        }

        public FlatMapSingleObserver(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, boolean z) {
            this.downstream = interfaceC5102;
            this.mapper = interfaceC2368;
            this.delayErrors = z;
        }

        public void clear() {
            d<R> dVar = this.queue.get();
            if (dVar != null) {
                dVar.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.active.decrementAndGet();
            m6788();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.active.decrementAndGet();
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                this.set.dispose();
            }
            m6788();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            try {
                InterfaceC3951 interfaceC3951 = (InterfaceC3951) C4246.m13353(this.mapper.apply(t), "The mapper returned a null SingleSource");
                this.active.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.cancelled || !this.set.mo9333(innerObserver)) {
                    return;
                }
                interfaceC3951.subscribe(innerObserver);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6788() {
            if (getAndIncrement() == 0) {
                m6789();
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6789() {
            InterfaceC5102<? super R> interfaceC5102 = this.downstream;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<d<R>> atomicReference = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (!this.delayErrors && this.errors.get() != null) {
                    Throwable thM7019 = this.errors.m7019();
                    clear();
                    interfaceC5102.onError(thM7019);
                    return;
                }
                boolean z = atomicInteger.get() == 0;
                d<R> dVar = atomicReference.get();
                a aVarPoll = dVar != null ? dVar.poll() : null;
                boolean z2 = aVarPoll == null;
                if (z && z2) {
                    Throwable thM70192 = this.errors.m7019();
                    if (thM70192 != null) {
                        interfaceC5102.onError(thM70192);
                        return;
                    } else {
                        interfaceC5102.onComplete();
                        return;
                    }
                }
                if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    interfaceC5102.onNext(aVarPoll);
                }
            }
            clear();
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public d<R> m6790() {
            d<R> dVar;
            do {
                d<R> dVar2 = this.queue.get();
                if (dVar2 != null) {
                    return dVar2;
                }
                dVar = new d<>(AbstractC4262.bufferSize());
            } while (!C4905.m14631(this.queue, null, dVar));
            return dVar;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6791(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, Throwable th) {
            this.set.mo9335(innerObserver);
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                this.set.dispose();
            }
            this.active.decrementAndGet();
            m6788();
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
        /* renamed from: ԫ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m6792(io.reactivex.internal.operators.observable.ObservableFlatMapSingle.FlatMapSingleObserver<T, R>.InnerObserver r3, R r4) {
            /*
                r2 = this;
                Ȝ r0 = r2.set
                r0.mo9335(r3)
                int r3 = r2.get()
                if (r3 != 0) goto L4e
                r3 = 0
                r0 = 1
                boolean r1 = r2.compareAndSet(r3, r0)
                if (r1 == 0) goto L4e
                ဏ<? super R> r1 = r2.downstream
                r1.onNext(r4)
                java.util.concurrent.atomic.AtomicInteger r4 = r2.active
                int r4 = r4.decrementAndGet()
                if (r4 != 0) goto L21
                r3 = r0
            L21:
                java.util.concurrent.atomic.AtomicReference<d<R>> r4 = r2.queue
                java.lang.Object r4 = r4.get()
                d r4 = (defpackage.d) r4
                if (r3 == 0) goto L47
                if (r4 == 0) goto L33
                boolean r3 = r4.isEmpty()
                if (r3 == 0) goto L47
            L33:
                io.reactivex.internal.util.AtomicThrowable r3 = r2.errors
                java.lang.Throwable r3 = r3.m7019()
                if (r3 == 0) goto L41
                ဏ<? super R> r4 = r2.downstream
                r4.onError(r3)
                goto L46
            L41:
                ဏ<? super R> r3 = r2.downstream
                r3.onComplete()
            L46:
                return
            L47:
                int r3 = r2.decrementAndGet()
                if (r3 != 0) goto L63
                return
            L4e:
                d r3 = r2.m6790()
                monitor-enter(r3)
                r3.offer(r4)     // Catch: java.lang.Throwable -> L67
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L67
                java.util.concurrent.atomic.AtomicInteger r3 = r2.active
                r3.decrementAndGet()
                int r3 = r2.getAndIncrement()
                if (r3 == 0) goto L63
                return
            L63:
                r2.m6789()
                return
            L67:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L67
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMapSingle.FlatMapSingleObserver.m6792(io.reactivex.internal.operators.observable.ObservableFlatMapSingle$FlatMapSingleObserver$InnerObserver, java.lang.Object):void");
        }
    }

    public ObservableFlatMapSingle(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, boolean z) {
        super(interfaceC2856);
        this.f7365 = interfaceC2368;
        this.f7366 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        this.f11778.subscribe(new FlatMapSingleObserver(interfaceC5102, this.f7365, this.f7366));
    }
}
