package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.AbstractC5105;
import defpackage.C3671;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableWindowBoundary<T, B> extends AbstractC3414<T, AbstractC4262<T>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<B> f7536;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f7537;

    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478, Runnable {
        private static final long serialVersionUID = 2233020065421370272L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final Object f7538 = new Object();
        public final int capacityHint;
        public volatile boolean done;
        public final InterfaceC5102<? super AbstractC4262<T>> downstream;
        public UnicastSubject<T> window;
        public final C2100<T, B> boundaryObserver = new C2100<>(this);
        public final AtomicReference<InterfaceC4478> upstream = new AtomicReference<>();
        public final AtomicInteger windows = new AtomicInteger(1);
        public final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicBoolean stopWindows = new AtomicBoolean();

        public WindowBoundaryMainObserver(InterfaceC5102<? super AbstractC4262<T>> interfaceC5102, int i) {
            this.downstream = interfaceC5102;
            this.capacityHint = i;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                this.boundaryObserver.dispose();
                if (this.windows.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.upstream);
                }
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.boundaryObserver.dispose();
            this.done = true;
            m6922();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.boundaryObserver.dispose();
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
            } else {
                this.done = true;
                m6922();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.queue.offer(t);
            m6922();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.setOnce(this.upstream, interfaceC4478)) {
                m6925();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.upstream);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6922() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC5102<? super AbstractC4262<T>> interfaceC5102 = this.downstream;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            int iAddAndGet = 1;
            while (this.windows.get() != 0) {
                UnicastSubject<T> unicastSubject = this.window;
                boolean z = this.done;
                if (z && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable thM7019 = atomicThrowable.m7019();
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onError(thM7019);
                    }
                    interfaceC5102.onError(thM7019);
                    return;
                }
                Object objPoll = mpscLinkedQueue.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    Throwable thM70192 = atomicThrowable.m7019();
                    if (thM70192 == null) {
                        if (unicastSubject != 0) {
                            this.window = null;
                            unicastSubject.onComplete();
                        }
                        interfaceC5102.onComplete();
                        return;
                    }
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onError(thM70192);
                    }
                    interfaceC5102.onError(thM70192);
                    return;
                }
                if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else if (objPoll != f7538) {
                    unicastSubject.onNext(objPoll);
                } else {
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.stopWindows.get()) {
                        UnicastSubject<T> unicastSubjectM7042 = UnicastSubject.m7042(this.capacityHint, this);
                        this.window = unicastSubjectM7042;
                        this.windows.getAndIncrement();
                        interfaceC5102.onNext(unicastSubjectM7042);
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6923() {
            DisposableHelper.dispose(this.upstream);
            this.done = true;
            m6922();
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6924(Throwable th) {
            DisposableHelper.dispose(this.upstream);
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
            } else {
                this.done = true;
                m6922();
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6925() {
            this.queue.offer(f7538);
            m6922();
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableWindowBoundary$Ϳ, reason: contains not printable characters */
    public static final class C2100<T, B> extends AbstractC5105<B> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final WindowBoundaryMainObserver<T, B> f7539;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f7540;

        public C2100(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f7539 = windowBoundaryMainObserver;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f7540) {
                return;
            }
            this.f7540 = true;
            this.f7539.m6923();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f7540) {
                C3671.m11803(th);
            } else {
                this.f7540 = true;
                this.f7539.m6924(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(B b) {
            if (this.f7540) {
                return;
            }
            this.f7539.m6925();
        }
    }

    public ObservableWindowBoundary(InterfaceC2856<T> interfaceC2856, InterfaceC2856<B> interfaceC28562, int i) {
        super(interfaceC2856);
        this.f7536 = interfaceC28562;
        this.f7537 = i;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super AbstractC4262<T>> interfaceC5102) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(interfaceC5102, this.f7537);
        interfaceC5102.onSubscribe(windowBoundaryMainObserver);
        this.f7536.subscribe(windowBoundaryMainObserver.boundaryObserver);
        this.f11778.subscribe(windowBoundaryMainObserver);
    }
}
