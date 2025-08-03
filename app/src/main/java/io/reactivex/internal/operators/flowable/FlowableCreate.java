package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C5153;
import defpackage.InterfaceC2910;
import defpackage.InterfaceC4354;
import defpackage.d;
import io.reactivex.BackpressureStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableCreate<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC4354<T> f6910;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final BackpressureStrategy f6911;

    public static abstract class BaseEmitter<T> extends AtomicLong implements InterfaceC2910<T>, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        public final Subscriber<? super T> downstream;
        public final SequentialDisposable serial = new SequentialDisposable();

        public BaseEmitter(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.serial.dispose();
            mo6415();
        }

        @Override // defpackage.InterfaceC3487
        public void onComplete() {
            m6411();
        }

        @Override // defpackage.InterfaceC3487
        public final void onError(Throwable th) {
            if (mo6410(th)) {
                return;
            }
            C3671.m11803(th);
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this, j);
                mo6414();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean mo6410(Throwable th) {
            return m6412(th);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6411() {
            if (m6413()) {
                return;
            }
            try {
                this.downstream.onComplete();
            } finally {
                this.serial.dispose();
            }
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public boolean m6412(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (m6413()) {
                return false;
            }
            try {
                this.downstream.onError(th);
                this.serial.dispose();
                return true;
            } catch (Throwable th2) {
                this.serial.dispose();
                throw th2;
            }
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final boolean m6413() {
            return this.serial.isDisposed();
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public void mo6414() {
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public void mo6415() {
        }
    }

    public static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        public volatile boolean done;
        public Throwable error;
        public final d<T> queue;
        public final AtomicInteger wip;

        public BufferAsyncEmitter(Subscriber<? super T> subscriber, int i) {
            super(subscriber);
            this.queue = new d<>(i);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, defpackage.InterfaceC3487
        public void onComplete() {
            this.done = true;
            m6416();
        }

        @Override // defpackage.InterfaceC3487
        public void onNext(T t) {
            if (this.done || m6413()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.offer(t);
                m6416();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        /* renamed from: Ϳ */
        public boolean mo6410(Throwable th) {
            if (this.done || m6413()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.error = th;
            this.done = true;
            m6416();
            return true;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        /* renamed from: ԭ */
        public void mo6414() {
            m6416();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        /* renamed from: Ԯ */
        public void mo6415() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public void m6416() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.downstream;
            d<T> dVar = this.queue;
            int iAddAndGet = 1;
            do {
                long j = get();
                long j2 = 0;
                while (j2 != j) {
                    if (m6413()) {
                        dVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    T tPoll = dVar.poll();
                    boolean z2 = tPoll == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            m6412(th);
                            return;
                        } else {
                            m6411();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(tPoll);
                    j2++;
                }
                if (j2 == j) {
                    if (m6413()) {
                        dVar.clear();
                        return;
                    }
                    boolean z3 = this.done;
                    boolean zIsEmpty = dVar.isEmpty();
                    if (z3 && zIsEmpty) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            m6412(th2);
                            return;
                        } else {
                            m6411();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    C5153.m15073(this, j2);
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }
    }

    public static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public DropAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        /* renamed from: ԯ, reason: contains not printable characters */
        public void mo6417() {
        }
    }

    public static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        public ErrorAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        /* renamed from: ԯ */
        public void mo6417() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    public static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        public volatile boolean done;
        public Throwable error;
        public final AtomicReference<T> queue;
        public final AtomicInteger wip;

        public LatestAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, defpackage.InterfaceC3487
        public void onComplete() {
            this.done = true;
            m6418();
        }

        @Override // defpackage.InterfaceC3487
        public void onNext(T t) {
            if (this.done || m6413()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.set(t);
                m6418();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        /* renamed from: Ϳ */
        public boolean mo6410(Throwable th) {
            if (this.done || m6413()) {
                return false;
            }
            if (th == null) {
                onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.error = th;
            this.done = true;
            m6418();
            return true;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        /* renamed from: ԭ */
        public void mo6414() {
            m6418();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        /* renamed from: Ԯ */
        public void mo6415() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:
        
            if (r9 != r5) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
        
            if (m6413() == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            r2.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
        
            r5 = r17.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
        
            if (r2.get() != null) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
        
            if (r5 == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
        
            if (r12 == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
        
            r1 = r17.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x006a, code lost:
        
            if (r1 == null) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x006c, code lost:
        
            m6412(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0070, code lost:
        
            m6411();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0076, code lost:
        
            if (r9 == 0) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0078, code lost:
        
            defpackage.C5153.m15073(r17, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x007b, code lost:
        
            r4 = r17.wip.addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        
            return;
         */
        /* renamed from: ԯ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m6418() {
            /*
                r17 = this;
                r0 = r17
                java.util.concurrent.atomic.AtomicInteger r1 = r0.wip
                int r1 = r1.getAndIncrement()
                if (r1 == 0) goto Lb
                return
            Lb:
                org.reactivestreams.Subscriber<? super T> r1 = r0.downstream
                java.util.concurrent.atomic.AtomicReference<T> r2 = r0.queue
                r3 = 1
                r4 = r3
            L11:
                long r5 = r17.get()
                r7 = 0
                r9 = r7
            L18:
                int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
                r12 = 0
                r13 = 0
                if (r11 == 0) goto L4f
                boolean r14 = r17.m6413()
                if (r14 == 0) goto L28
                r2.lazySet(r13)
                return
            L28:
                boolean r14 = r0.done
                java.lang.Object r15 = r2.getAndSet(r13)
                if (r15 != 0) goto L33
                r16 = r3
                goto L35
            L33:
                r16 = r12
            L35:
                if (r14 == 0) goto L45
                if (r16 == 0) goto L45
                java.lang.Throwable r1 = r0.error
                if (r1 == 0) goto L41
                r0.m6412(r1)
                goto L44
            L41:
                r17.m6411()
            L44:
                return
            L45:
                if (r16 == 0) goto L48
                goto L4f
            L48:
                r1.onNext(r15)
                r11 = 1
                long r9 = r9 + r11
                goto L18
            L4f:
                if (r11 != 0) goto L74
                boolean r5 = r17.m6413()
                if (r5 == 0) goto L5b
                r2.lazySet(r13)
                return
            L5b:
                boolean r5 = r0.done
                java.lang.Object r6 = r2.get()
                if (r6 != 0) goto L64
                r12 = r3
            L64:
                if (r5 == 0) goto L74
                if (r12 == 0) goto L74
                java.lang.Throwable r1 = r0.error
                if (r1 == 0) goto L70
                r0.m6412(r1)
                goto L73
            L70:
                r17.m6411()
            L73:
                return
            L74:
                int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                if (r5 == 0) goto L7b
                defpackage.C5153.m15073(r0, r9)
            L7b:
                java.util.concurrent.atomic.AtomicInteger r5 = r0.wip
                int r4 = -r4
                int r4 = r5.addAndGet(r4)
                if (r4 != 0) goto L11
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCreate.LatestAsyncEmitter.m6418():void");
        }
    }

    public static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public MissingEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // defpackage.InterfaceC3487
        public void onNext(T t) {
            long j;
            if (m6413()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            this.downstream.onNext(t);
            do {
                j = get();
                if (j == 0) {
                    return;
                }
            } while (!compareAndSet(j, j - 1));
        }
    }

    public static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        public NoOverflowBaseAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // defpackage.InterfaceC3487
        public final void onNext(T t) {
            if (m6413()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() == 0) {
                mo6417();
            } else {
                this.downstream.onNext(t);
                C5153.m15073(this, 1L);
            }
        }

        /* renamed from: ԯ */
        public abstract void mo6417();
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCreate$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C2020 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f6912;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            f6912 = iArr;
            try {
                iArr[BackpressureStrategy.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6912[BackpressureStrategy.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6912[BackpressureStrategy.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6912[BackpressureStrategy.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public FlowableCreate(InterfaceC4354<T> interfaceC4354, BackpressureStrategy backpressureStrategy) {
        this.f6910 = interfaceC4354;
        this.f6911 = backpressureStrategy;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        int i = C2020.f6912[this.f6911.ordinal()];
        BaseEmitter bufferAsyncEmitter = i != 1 ? i != 2 ? i != 3 ? i != 4 ? new BufferAsyncEmitter(subscriber, AbstractC3630.bufferSize()) : new LatestAsyncEmitter(subscriber) : new DropAsyncEmitter(subscriber) : new ErrorAsyncEmitter(subscriber) : new MissingEmitter(subscriber);
        subscriber.onSubscribe(bufferAsyncEmitter);
        try {
            this.f6910.m13510(bufferAsyncEmitter);
        } catch (Throwable th) {
            C4089.m13026(th);
            bufferAsyncEmitter.onError(th);
        }
    }
}
