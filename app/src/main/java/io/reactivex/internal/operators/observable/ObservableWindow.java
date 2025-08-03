package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableWindow<T> extends AbstractC3414<T, AbstractC4262<T>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7533;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f7534;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7535;

    public static final class WindowExactObserver<T> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        public volatile boolean cancelled;
        public final int capacityHint;
        public final long count;
        public final InterfaceC5102<? super AbstractC4262<T>> downstream;
        public long size;
        public InterfaceC4478 upstream;
        public UnicastSubject<T> window;

        public WindowExactObserver(InterfaceC5102<? super AbstractC4262<T>> interfaceC5102, long j, int i) {
            this.downstream = interfaceC5102;
            this.count = j;
            this.capacityHint = i;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.cancelled = true;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onError(th);
            }
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            UnicastSubject<T> unicastSubjectM7042 = this.window;
            if (unicastSubjectM7042 == null && !this.cancelled) {
                unicastSubjectM7042 = UnicastSubject.m7042(this.capacityHint, this);
                this.window = unicastSubjectM7042;
                this.downstream.onNext(unicastSubjectM7042);
            }
            if (unicastSubjectM7042 != null) {
                unicastSubjectM7042.onNext(t);
                long j = this.size + 1;
                this.size = j;
                if (j >= this.count) {
                    this.size = 0L;
                    this.window = null;
                    unicastSubjectM7042.onComplete();
                    if (this.cancelled) {
                        this.upstream.dispose();
                    }
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.upstream.dispose();
            }
        }
    }

    public static final class WindowSkipObserver<T> extends AtomicBoolean implements InterfaceC5102<T>, InterfaceC4478, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        public volatile boolean cancelled;
        public final int capacityHint;
        public final long count;
        public final InterfaceC5102<? super AbstractC4262<T>> downstream;
        public long firstEmission;
        public long index;
        public final long skip;
        public InterfaceC4478 upstream;
        public final AtomicInteger wip = new AtomicInteger();
        public final ArrayDeque<UnicastSubject<T>> windows = new ArrayDeque<>();

        public WindowSkipObserver(InterfaceC5102<? super AbstractC4262<T>> interfaceC5102, long j, long j2, int i) {
            this.downstream = interfaceC5102;
            this.count = j;
            this.skip = j2;
            this.capacityHint = i;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.cancelled = true;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            long j = this.index;
            long j2 = this.skip;
            if (j % j2 == 0 && !this.cancelled) {
                this.wip.getAndIncrement();
                UnicastSubject<T> unicastSubjectM7042 = UnicastSubject.m7042(this.capacityHint, this);
                arrayDeque.offer(unicastSubjectM7042);
                this.downstream.onNext(unicastSubjectM7042);
            }
            long j3 = this.firstEmission + 1;
            Iterator<UnicastSubject<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (j3 >= this.count) {
                arrayDeque.poll().onComplete();
                if (arrayDeque.isEmpty() && this.cancelled) {
                    this.upstream.dispose();
                    return;
                }
                this.firstEmission = j3 - j2;
            } else {
                this.firstEmission = j3;
            }
            this.index = j + 1;
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.decrementAndGet() == 0 && this.cancelled) {
                this.upstream.dispose();
            }
        }
    }

    public ObservableWindow(InterfaceC2856<T> interfaceC2856, long j, long j2, int i) {
        super(interfaceC2856);
        this.f7533 = j;
        this.f7534 = j2;
        this.f7535 = i;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super AbstractC4262<T>> interfaceC5102) {
        if (this.f7533 == this.f7534) {
            this.f11778.subscribe(new WindowExactObserver(interfaceC5102, this.f7533, this.f7535));
        } else {
            this.f11778.subscribe(new WindowSkipObserver(interfaceC5102, this.f7533, this.f7534, this.f7535));
        }
    }
}
