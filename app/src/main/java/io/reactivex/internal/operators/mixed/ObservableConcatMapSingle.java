package io.reactivex.internal.operators.mixed;

import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4053;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2475;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5102;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableConcatMapSingle<T, R> extends AbstractC4262<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4262<T> f7267;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> f7268;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final ErrorMode f7269;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7270;

    public static final class ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -9140123220065488293L;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final InterfaceC5102<? super R> downstream;
        public final ErrorMode errorMode;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final ConcatMapSingleObserver<R> inner = new ConcatMapSingleObserver<>(this);
        public R item;
        public final InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> mapper;
        public final InterfaceC2475<T> queue;
        public volatile int state;
        public InterfaceC4478 upstream;

        public static final class ConcatMapSingleObserver<R> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            public final ConcatMapSingleMainObserver<?, R> parent;

            public ConcatMapSingleObserver(ConcatMapSingleMainObserver<?, R> concatMapSingleMainObserver) {
                this.parent = concatMapSingleMainObserver;
            }

            @Override // defpackage.InterfaceC4782
            public void onError(Throwable th) {
                this.parent.m6713(th);
            }

            @Override // defpackage.InterfaceC4782
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.replace(this, interfaceC4478);
            }

            @Override // defpackage.InterfaceC4782
            public void onSuccess(R r) {
                this.parent.m6714(r);
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public void m6715() {
                DisposableHelper.dispose(this);
            }
        }

        public ConcatMapSingleMainObserver(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, int i, ErrorMode errorMode) {
            this.downstream = interfaceC5102;
            this.mapper = interfaceC2368;
            this.errorMode = errorMode;
            this.queue = new d(i);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.inner.m6715();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.done = true;
            m6712();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.inner.m6715();
            }
            this.done = true;
            m6712();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.queue.offer(t);
            m6712();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        
            r2.clear();
            r10.item = null;
            r0.onError(r3.m7019());
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
        
            return;
         */
        /* renamed from: Ϳ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m6712() {
            /*
                r10 = this;
                int r0 = r10.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                ဏ<? super R> r0 = r10.downstream
                io.reactivex.internal.util.ErrorMode r1 = r10.errorMode
                ǅ<T> r2 = r10.queue
                io.reactivex.internal.util.AtomicThrowable r3 = r10.errors
                r4 = 1
                r5 = r4
            L11:
                boolean r6 = r10.cancelled
                r7 = 0
                if (r6 == 0) goto L1d
                r2.clear()
                r10.item = r7
                goto L98
            L1d:
                int r6 = r10.state
                java.lang.Object r8 = r3.get()
                if (r8 == 0) goto L3c
                io.reactivex.internal.util.ErrorMode r8 = io.reactivex.internal.util.ErrorMode.IMMEDIATE
                if (r1 == r8) goto L2f
                io.reactivex.internal.util.ErrorMode r8 = io.reactivex.internal.util.ErrorMode.BOUNDARY
                if (r1 != r8) goto L3c
                if (r6 != 0) goto L3c
            L2f:
                r2.clear()
                r10.item = r7
                java.lang.Throwable r1 = r3.m7019()
                r0.onError(r1)
                return
            L3c:
                r8 = 0
                if (r6 != 0) goto L8a
                boolean r6 = r10.done
                java.lang.Object r7 = r2.poll()
                if (r7 != 0) goto L48
                r8 = r4
            L48:
                if (r6 == 0) goto L5a
                if (r8 == 0) goto L5a
                java.lang.Throwable r1 = r3.m7019()
                if (r1 != 0) goto L56
                r0.onComplete()
                goto L59
            L56:
                r0.onError(r1)
            L59:
                return
            L5a:
                if (r8 == 0) goto L5d
                goto L98
            L5d:
                ō<? super T, ? extends ࡗ<? extends R>> r6 = r10.mapper     // Catch: java.lang.Throwable -> L73
                java.lang.Object r6 = r6.apply(r7)     // Catch: java.lang.Throwable -> L73
                java.lang.String r7 = "The mapper returned a null SingleSource"
                java.lang.Object r6 = defpackage.C4246.m13353(r6, r7)     // Catch: java.lang.Throwable -> L73
                ࡗ r6 = (defpackage.InterfaceC3951) r6     // Catch: java.lang.Throwable -> L73
                r10.state = r4
                io.reactivex.internal.operators.mixed.ObservableConcatMapSingle$ConcatMapSingleMainObserver$ConcatMapSingleObserver<R> r7 = r10.inner
                r6.subscribe(r7)
                goto L98
            L73:
                r1 = move-exception
                defpackage.C4089.m13026(r1)
                ப r4 = r10.upstream
                r4.dispose()
                r2.clear()
                r3.m7018(r1)
                java.lang.Throwable r1 = r3.m7019()
                r0.onError(r1)
                return
            L8a:
                r9 = 2
                if (r6 != r9) goto L98
                R r6 = r10.item
                r10.item = r7
                r0.onNext(r6)
                r10.state = r8
                goto L11
            L98:
                int r5 = -r5
                int r5 = r10.addAndGet(r5)
                if (r5 != 0) goto L11
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.ObservableConcatMapSingle.ConcatMapSingleMainObserver.m6712():void");
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6713(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (this.errorMode != ErrorMode.END) {
                this.upstream.dispose();
            }
            this.state = 0;
            m6712();
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6714(R r) {
            this.item = r;
            this.state = 2;
            m6712();
        }
    }

    public ObservableConcatMapSingle(AbstractC4262<T> abstractC4262, InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, ErrorMode errorMode, int i) {
        this.f7267 = abstractC4262;
        this.f7268 = interfaceC2368;
        this.f7269 = errorMode;
        this.f7270 = i;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        if (C4053.m12974(this.f7267, this.f7268, interfaceC5102)) {
            return;
        }
        this.f7267.subscribe(new ConcatMapSingleMainObserver(interfaceC5102, this.f7268, this.f7270, this.f7269));
    }
}
