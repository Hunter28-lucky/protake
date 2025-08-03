package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.AbstractC5105;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableWindowBoundarySupplier<T, B> extends AbstractC3414<T, AbstractC4262<T>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<? extends InterfaceC2856<B>> f7541;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f7542;

    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478, Runnable {
        private static final long serialVersionUID = 2233020065421370272L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final C2101<Object, Object> f7543 = new C2101<>(null);

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final Object f7544 = new Object();
        public final int capacityHint;
        public volatile boolean done;
        public final InterfaceC5102<? super AbstractC4262<T>> downstream;
        public final Callable<? extends InterfaceC2856<B>> other;
        public InterfaceC4478 upstream;
        public UnicastSubject<T> window;
        public final AtomicReference<C2101<T, B>> boundaryObserver = new AtomicReference<>();
        public final AtomicInteger windows = new AtomicInteger(1);
        public final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicBoolean stopWindows = new AtomicBoolean();

        public WindowBoundaryMainObserver(InterfaceC5102<? super AbstractC4262<T>> interfaceC5102, int i, Callable<? extends InterfaceC2856<B>> callable) {
            this.downstream = interfaceC5102;
            this.capacityHint = i;
            this.other = callable;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                m6926();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.dispose();
                }
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            m6926();
            this.done = true;
            m6927();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            m6926();
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
            } else {
                this.done = true;
                m6927();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.queue.offer(t);
            m6927();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
                this.queue.offer(f7544);
                m6927();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6926() {
            AtomicReference<C2101<T, B>> atomicReference = this.boundaryObserver;
            C2101<Object, Object> c2101 = f7543;
            InterfaceC4478 interfaceC4478 = (InterfaceC4478) atomicReference.getAndSet(c2101);
            if (interfaceC4478 == null || interfaceC4478 == c2101) {
                return;
            }
            interfaceC4478.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6927() {
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
                } else if (objPoll != f7544) {
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
                        try {
                            InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.other.call(), "The other Callable returned a null ObservableSource");
                            C2101 c2101 = new C2101(this);
                            if (C4905.m14631(this.boundaryObserver, null, c2101)) {
                                interfaceC2856.subscribe(c2101);
                                interfaceC5102.onNext(unicastSubjectM7042);
                            }
                        } catch (Throwable th) {
                            C4089.m13026(th);
                            atomicThrowable.m7018(th);
                            this.done = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6928() {
            this.upstream.dispose();
            this.done = true;
            m6927();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6929(Throwable th) {
            this.upstream.dispose();
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
            } else {
                this.done = true;
                m6927();
            }
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6930(C2101<T, B> c2101) {
            C4905.m14631(this.boundaryObserver, c2101, null);
            this.queue.offer(f7544);
            m6927();
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier$Ϳ, reason: contains not printable characters */
    public static final class C2101<T, B> extends AbstractC5105<B> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final WindowBoundaryMainObserver<T, B> f7545;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f7546;

        public C2101(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f7545 = windowBoundaryMainObserver;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f7546) {
                return;
            }
            this.f7546 = true;
            this.f7545.m6928();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f7546) {
                C3671.m11803(th);
            } else {
                this.f7546 = true;
                this.f7545.m6929(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(B b) {
            if (this.f7546) {
                return;
            }
            this.f7546 = true;
            dispose();
            this.f7545.m6930(this);
        }
    }

    public ObservableWindowBoundarySupplier(InterfaceC2856<T> interfaceC2856, Callable<? extends InterfaceC2856<B>> callable, int i) {
        super(interfaceC2856);
        this.f7541 = callable;
        this.f7542 = i;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super AbstractC4262<T>> interfaceC5102) {
        this.f11778.subscribe(new WindowBoundaryMainObserver(interfaceC5102, this.f7542, this.f7541));
    }
}
