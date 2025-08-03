package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC3164;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4851;
import defpackage.InterfaceC5102;
import defpackage.d;
import defpackage.y2;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* loaded from: classes2.dex */
public final class ObservableObserveOn<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AbstractC4585 f7402;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7403;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7404;

    public static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements InterfaceC5102<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        public final int bufferSize;
        public final boolean delayError;
        public volatile boolean disposed;
        public volatile boolean done;
        public final InterfaceC5102<? super T> downstream;
        public Throwable error;
        public boolean outputFused;
        public InterfaceC4851<T> queue;
        public int sourceMode;
        public InterfaceC4478 upstream;
        public final AbstractC4585.AbstractC4588 worker;

        public ObserveOnObserver(InterfaceC5102<? super T> interfaceC5102, AbstractC4585.AbstractC4588 abstractC4588, boolean z, int i) {
            this.downstream = interfaceC5102;
            this.worker = abstractC4588;
            this.delayError = z;
            this.bufferSize = i;
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            this.queue.clear();
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (this.outputFused || getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            m6831();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.error = th;
            this.done = true;
            m6831();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            m6831();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                if (interfaceC4478 instanceof InterfaceC3164) {
                    InterfaceC3164 interfaceC3164 = (InterfaceC3164) interfaceC4478;
                    int iMo6310 = interfaceC3164.mo6310(7);
                    if (iMo6310 == 1) {
                        this.sourceMode = iMo6310;
                        this.queue = interfaceC3164;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        m6831();
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.sourceMode = iMo6310;
                        this.queue = interfaceC3164;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new d(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                m6829();
            } else {
                m6830();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6828(boolean z, boolean z2, InterfaceC5102<? super T> interfaceC5102) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (this.delayError) {
                if (!z2) {
                    return false;
                }
                this.disposed = true;
                if (th != null) {
                    interfaceC5102.onError(th);
                } else {
                    interfaceC5102.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            if (th != null) {
                this.disposed = true;
                this.queue.clear();
                interfaceC5102.onError(th);
                this.worker.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            this.disposed = true;
            interfaceC5102.onComplete();
            this.worker.dispose();
            return true;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6829() {
            int iAddAndGet = 1;
            while (!this.disposed) {
                boolean z = this.done;
                Throwable th = this.error;
                if (!this.delayError && z && th != null) {
                    this.disposed = true;
                    this.downstream.onError(this.error);
                    this.worker.dispose();
                    return;
                }
                this.downstream.onNext(null);
                if (z) {
                    this.disposed = true;
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.downstream.onError(th2);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        
            r3 = addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        
            if (r3 != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        
            return;
         */
        /* renamed from: Ԫ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m6830() {
            /*
                r7 = this;
                හ<T> r0 = r7.queue
                ဏ<? super T> r1 = r7.downstream
                r2 = 1
                r3 = r2
            L6:
                boolean r4 = r7.done
                boolean r5 = r0.isEmpty()
                boolean r4 = r7.m6828(r4, r5, r1)
                if (r4 == 0) goto L13
                return
            L13:
                boolean r4 = r7.done
                java.lang.Object r5 = r0.poll()     // Catch: java.lang.Throwable -> L33
                if (r5 != 0) goto L1d
                r6 = r2
                goto L1e
            L1d:
                r6 = 0
            L1e:
                boolean r4 = r7.m6828(r4, r6, r1)
                if (r4 == 0) goto L25
                return
            L25:
                if (r6 == 0) goto L2f
                int r3 = -r3
                int r3 = r7.addAndGet(r3)
                if (r3 != 0) goto L6
                return
            L2f:
                r1.onNext(r5)
                goto L13
            L33:
                r3 = move-exception
                defpackage.C4089.m13026(r3)
                r7.disposed = r2
                ப r2 = r7.upstream
                r2.dispose()
                r0.clear()
                r1.onError(r3)
                ౠ$Ԫ r0 = r7.worker
                r0.dispose()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableObserveOn.ObserveOnObserver.m6830():void");
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6831() {
            if (getAndIncrement() == 0) {
                this.worker.mo6990(this);
            }
        }
    }

    public ObservableObserveOn(InterfaceC2856<T> interfaceC2856, AbstractC4585 abstractC4585, boolean z, int i) {
        super(interfaceC2856);
        this.f7402 = abstractC4585;
        this.f7403 = z;
        this.f7404 = i;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        AbstractC4585 abstractC4585 = this.f7402;
        if (abstractC4585 instanceof y2) {
            this.f11778.subscribe(interfaceC5102);
        } else {
            this.f11778.subscribe(new ObserveOnObserver(interfaceC5102, abstractC4585.mo6986(), this.f7403, this.f7404));
        }
    }
}
