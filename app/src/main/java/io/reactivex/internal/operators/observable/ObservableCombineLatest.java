package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4262;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableCombineLatest<T, R> extends AbstractC4262<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<? extends T>[] f7324;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Iterable<? extends InterfaceC2856<? extends T>> f7325;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Object[], ? extends R> f7326;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7327;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean f7328;

    public static final class CombinerObserver<T, R> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        public final int index;
        public final LatestCoordinator<T, R> parent;

        public CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.parent = latestCoordinator;
            this.index = i;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.parent.m6746(this.index);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.parent.m6747(this.index, th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.parent.m6748(this.index, t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6742() {
            DisposableHelper.dispose(this);
        }
    }

    public static final class LatestCoordinator<T, R> extends AtomicInteger implements InterfaceC4478 {
        private static final long serialVersionUID = 8567835998786448817L;
        public int active;
        public volatile boolean cancelled;
        public final InterfaceC2368<? super Object[], ? extends R> combiner;
        public int complete;
        public final boolean delayError;
        public volatile boolean done;
        public final InterfaceC5102<? super R> downstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public Object[] latest;
        public final CombinerObserver<T, R>[] observers;
        public final d<Object[]> queue;

        public LatestCoordinator(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i, int i2, boolean z) {
            this.downstream = interfaceC5102;
            this.combiner = interfaceC2368;
            this.delayError = z;
            this.latest = new Object[i];
            CombinerObserver<T, R>[] combinerObserverArr = new CombinerObserver[i];
            for (int i3 = 0; i3 < i; i3++) {
                combinerObserverArr[i3] = new CombinerObserver<>(this, i3);
            }
            this.observers = combinerObserverArr;
            this.queue = new d<>(i2);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            m6743();
            if (getAndIncrement() == 0) {
                m6744(this.queue);
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6743() {
            for (CombinerObserver<T, R> combinerObserver : this.observers) {
                combinerObserver.m6742();
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6744(d<?> dVar) {
            synchronized (this) {
                this.latest = null;
            }
            dVar.clear();
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6745() {
            if (getAndIncrement() != 0) {
                return;
            }
            d<Object[]> dVar = this.queue;
            InterfaceC5102<? super R> interfaceC5102 = this.downstream;
            boolean z = this.delayError;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (!z && this.errors.get() != null) {
                    m6743();
                    m6744(dVar);
                    interfaceC5102.onError(this.errors.m7019());
                    return;
                }
                boolean z2 = this.done;
                Object[] objArrPoll = dVar.poll();
                boolean z3 = objArrPoll == null;
                if (z2 && z3) {
                    m6744(dVar);
                    Throwable thM7019 = this.errors.m7019();
                    if (thM7019 == null) {
                        interfaceC5102.onComplete();
                        return;
                    } else {
                        interfaceC5102.onError(thM7019);
                        return;
                    }
                }
                if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        interfaceC5102.onNext((Object) C4246.m13353(this.combiner.apply(objArrPoll), "The combiner returned a null value"));
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        this.errors.m7018(th);
                        m6743();
                        m6744(dVar);
                        interfaceC5102.onError(this.errors.m7019());
                        return;
                    }
                }
            }
            m6744(dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0019 A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0007, B:12:0x0011, B:15:0x001b, B:14:0x0019), top: B:23:0x0001 }] */
        /* renamed from: Ԫ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m6746(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.latest     // Catch: java.lang.Throwable -> L25
                if (r0 != 0) goto L7
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                return
            L7:
                r4 = r0[r4]     // Catch: java.lang.Throwable -> L25
                r1 = 1
                if (r4 != 0) goto Le
                r4 = r1
                goto Lf
            Le:
                r4 = 0
            Lf:
                if (r4 != 0) goto L19
                int r2 = r3.complete     // Catch: java.lang.Throwable -> L25
                int r2 = r2 + r1
                r3.complete = r2     // Catch: java.lang.Throwable -> L25
                int r0 = r0.length     // Catch: java.lang.Throwable -> L25
                if (r2 != r0) goto L1b
            L19:
                r3.done = r1     // Catch: java.lang.Throwable -> L25
            L1b:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                if (r4 == 0) goto L21
                r3.m6743()
            L21:
                r3.m6745()
                return
            L25:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.m6746(int):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0025 A[Catch: all -> 0x002a, TryCatch #0 {, blocks: (B:7:0x000e, B:9:0x0012, B:11:0x0014, B:16:0x001d, B:19:0x0027, B:18:0x0025), top: B:29:0x000e }] */
        /* renamed from: ԫ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m6747(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                io.reactivex.internal.util.AtomicThrowable r0 = r2.errors
                boolean r0 = r0.m7018(r4)
                if (r0 == 0) goto L36
                boolean r4 = r2.delayError
                r0 = 1
                if (r4 == 0) goto L2d
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.latest     // Catch: java.lang.Throwable -> L2a
                if (r4 != 0) goto L14
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                return
            L14:
                r3 = r4[r3]     // Catch: java.lang.Throwable -> L2a
                if (r3 != 0) goto L1a
                r3 = r0
                goto L1b
            L1a:
                r3 = 0
            L1b:
                if (r3 != 0) goto L25
                int r1 = r2.complete     // Catch: java.lang.Throwable -> L2a
                int r1 = r1 + r0
                r2.complete = r1     // Catch: java.lang.Throwable -> L2a
                int r4 = r4.length     // Catch: java.lang.Throwable -> L2a
                if (r1 != r4) goto L27
            L25:
                r2.done = r0     // Catch: java.lang.Throwable -> L2a
            L27:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                r0 = r3
                goto L2d
            L2a:
                r3 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                throw r3
            L2d:
                if (r0 == 0) goto L32
                r2.m6743()
            L32:
                r2.m6745()
                goto L39
            L36:
                defpackage.C3671.m11803(r4)
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.m6747(int, java.lang.Throwable):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6748(int i, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr == null) {
                    return;
                }
                Object obj = objArr[i];
                int i2 = this.active;
                if (obj == null) {
                    i2++;
                    this.active = i2;
                }
                objArr[i] = t;
                if (i2 == objArr.length) {
                    this.queue.offer(objArr.clone());
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    m6745();
                }
            }
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public void m6749(InterfaceC2856<? extends T>[] interfaceC2856Arr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.observers;
            int length = combinerObserverArr.length;
            this.downstream.onSubscribe(this);
            for (int i = 0; i < length && !this.done && !this.cancelled; i++) {
                interfaceC2856Arr[i].subscribe(combinerObserverArr[i]);
            }
        }
    }

    public ObservableCombineLatest(InterfaceC2856<? extends T>[] interfaceC2856Arr, Iterable<? extends InterfaceC2856<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i, boolean z) {
        this.f7324 = interfaceC2856Arr;
        this.f7325 = iterable;
        this.f7326 = interfaceC2368;
        this.f7327 = i;
        this.f7328 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        int length;
        InterfaceC2856<? extends T>[] interfaceC2856Arr = this.f7324;
        if (interfaceC2856Arr == null) {
            interfaceC2856Arr = new InterfaceC2856[8];
            length = 0;
            for (InterfaceC2856<? extends T> interfaceC2856 : this.f7325) {
                if (length == interfaceC2856Arr.length) {
                    InterfaceC2856<? extends T>[] interfaceC2856Arr2 = new InterfaceC2856[(length >> 2) + length];
                    System.arraycopy(interfaceC2856Arr, 0, interfaceC2856Arr2, 0, length);
                    interfaceC2856Arr = interfaceC2856Arr2;
                }
                interfaceC2856Arr[length] = interfaceC2856;
                length++;
            }
        } else {
            length = interfaceC2856Arr.length;
        }
        int i = length;
        if (i == 0) {
            EmptyDisposable.complete(interfaceC5102);
        } else {
            new LatestCoordinator(interfaceC5102, this.f7326, i, this.f7327, this.f7328).m6749(interfaceC2856Arr);
        }
    }
}
