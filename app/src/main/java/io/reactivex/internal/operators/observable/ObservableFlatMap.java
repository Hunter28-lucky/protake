package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2475;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC3164;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4851;
import defpackage.InterfaceC5102;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableFlatMap<T, U> extends AbstractC3414<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> f7352;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7353;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7354;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f7355;

    public static final class InnerObserver<T, U> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        public volatile boolean done;
        public int fusionMode;
        public final long id;
        public final MergeObserver<T, U> parent;
        public volatile InterfaceC4851<U> queue;

        public InnerObserver(MergeObserver<T, U> mergeObserver, long j) {
            this.id = j;
            this.parent = mergeObserver;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.done = true;
            this.parent.m6771();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (!this.parent.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            MergeObserver<T, U> mergeObserver = this.parent;
            if (!mergeObserver.delayErrors) {
                mergeObserver.m6770();
            }
            this.done = true;
            this.parent.m6771();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(U u) {
            if (this.fusionMode == 0) {
                this.parent.m6775(u, this);
            } else {
                this.parent.m6771();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.setOnce(this, interfaceC4478) && (interfaceC4478 instanceof InterfaceC3164)) {
                InterfaceC3164 interfaceC3164 = (InterfaceC3164) interfaceC4478;
                int iMo6310 = interfaceC3164.mo6310(7);
                if (iMo6310 == 1) {
                    this.fusionMode = iMo6310;
                    this.queue = interfaceC3164;
                    this.done = true;
                    this.parent.m6771();
                    return;
                }
                if (iMo6310 == 2) {
                    this.fusionMode = iMo6310;
                    this.queue = interfaceC3164;
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6767() {
            DisposableHelper.dispose(this);
        }
    }

    public static final class MergeObserver<T, U> extends AtomicInteger implements InterfaceC4478, InterfaceC5102<T> {
        private static final long serialVersionUID = -2117620485640801370L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final InnerObserver<?, ?>[] f7356 = new InnerObserver[0];

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final InnerObserver<?, ?>[] f7357 = new InnerObserver[0];
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final InterfaceC5102<? super U> downstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public long lastId;
        public int lastIndex;
        public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> mapper;
        public final int maxConcurrency;
        public final AtomicReference<InnerObserver<?, ?>[]> observers;
        public volatile InterfaceC2475<U> queue;
        public Queue<InterfaceC2856<? extends U>> sources;
        public long uniqueId;
        public InterfaceC4478 upstream;
        public int wip;

        public MergeObserver(InterfaceC5102<? super U> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> interfaceC2368, boolean z, int i, int i2) {
            this.downstream = interfaceC5102;
            this.mapper = interfaceC2368;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            if (i != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i);
            }
            this.observers = new AtomicReference<>(f7356);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            Throwable thM7019;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (!m6770() || (thM7019 = this.errors.m7019()) == null || thM7019 == ExceptionHelper.f7687) {
                return;
            }
            C3671.m11803(thM7019);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            m6771();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
            } else if (!this.errors.m7018(th)) {
                C3671.m11803(th);
            } else {
                this.done = true;
                m6771();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                InterfaceC2856<? extends U> interfaceC2856 = (InterfaceC2856) C4246.m13353(this.mapper.apply(t), "The mapper returned a null ObservableSource");
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        int i = this.wip;
                        if (i == this.maxConcurrency) {
                            this.sources.offer(interfaceC2856);
                            return;
                        }
                        this.wip = i + 1;
                    }
                }
                m6774(interfaceC2856);
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
        public boolean m6768(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                if (innerObserverArr == f7357) {
                    innerObserver.m6767();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[length + 1];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!C4905.m14631(this.observers, innerObserverArr, innerObserverArr2));
            return true;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean m6769() {
            if (this.cancelled) {
                return true;
            }
            Throwable th = this.errors.get();
            if (this.delayErrors || th == null) {
                return false;
            }
            m6770();
            Throwable thM7019 = this.errors.m7019();
            if (thM7019 != ExceptionHelper.f7687) {
                this.downstream.onError(thM7019);
            }
            return true;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public boolean m6770() {
            InnerObserver<?, ?>[] andSet;
            this.upstream.dispose();
            InnerObserver<?, ?>[] innerObserverArr = this.observers.get();
            InnerObserver<?, ?>[] innerObserverArr2 = f7357;
            if (innerObserverArr == innerObserverArr2 || (andSet = this.observers.getAndSet(innerObserverArr2)) == innerObserverArr2) {
                return false;
            }
            for (InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.m6767();
            }
            return true;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6771() {
            if (getAndIncrement() == 0) {
                m6772();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:128:0x0004, code lost:
        
            continue;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:120:0x00ea A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:133:0x00f2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x00f1 A[PHI: r4
          0x00f1: PHI (r4v10 int) = (r4v8 int), (r4v11 int) binds: [B:72:0x00d0, B:84:0x00ef] A[DONT_GENERATE, DONT_INLINE]] */
        /* renamed from: ԫ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m6772() {
            /*
                Method dump skipped, instructions count: 299
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver.m6772():void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6773(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerObserverArr[i2] == innerObserver) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr2 = f7356;
                } else {
                    InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i);
                    System.arraycopy(innerObserverArr, i + 1, innerObserverArr3, i, (length - i) - 1);
                    innerObserverArr2 = innerObserverArr3;
                }
            } while (!C4905.m14631(this.observers, innerObserverArr, innerObserverArr2));
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public void m6774(InterfaceC2856<? extends U> interfaceC2856) {
            InterfaceC2856<? extends U> interfaceC2856Poll;
            while (interfaceC2856 instanceof Callable) {
                if (!m6776((Callable) interfaceC2856) || this.maxConcurrency == Integer.MAX_VALUE) {
                    return;
                }
                boolean z = false;
                synchronized (this) {
                    interfaceC2856Poll = this.sources.poll();
                    if (interfaceC2856Poll == null) {
                        this.wip--;
                        z = true;
                    }
                }
                if (z) {
                    m6771();
                    return;
                }
                interfaceC2856 = interfaceC2856Poll;
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            InnerObserver<T, U> innerObserver = new InnerObserver<>(this, j);
            if (m6768(innerObserver)) {
                interfaceC2856.subscribe(innerObserver);
            }
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public void m6775(U u, InnerObserver<T, U> innerObserver) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.downstream.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                InterfaceC4851 dVar = innerObserver.queue;
                if (dVar == null) {
                    dVar = new d(this.bufferSize);
                    innerObserver.queue = dVar;
                }
                dVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            m6772();
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean m6776(Callable<? extends U> callable) {
            try {
                U uCall = callable.call();
                if (uCall == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.downstream.onNext(uCall);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    InterfaceC2475<U> dVar = this.queue;
                    if (dVar == null) {
                        dVar = this.maxConcurrency == Integer.MAX_VALUE ? new d<>(this.bufferSize) : new SpscArrayQueue<>(this.maxConcurrency);
                        this.queue = dVar;
                    }
                    if (!dVar.offer(uCall)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    }
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                m6772();
                return true;
            } catch (Throwable th) {
                C4089.m13026(th);
                this.errors.m7018(th);
                m6771();
                return true;
            }
        }
    }

    public ObservableFlatMap(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> interfaceC2368, boolean z, int i, int i2) {
        super(interfaceC2856);
        this.f7352 = interfaceC2368;
        this.f7353 = z;
        this.f7354 = i;
        this.f7355 = i2;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super U> interfaceC5102) {
        if (ObservableScalarXMap.m6895(this.f11778, interfaceC5102, this.f7352)) {
            return;
        }
        this.f11778.subscribe(new MergeObserver(interfaceC5102, this.f7352, this.f7353, this.f7354, this.f7355));
    }
}
