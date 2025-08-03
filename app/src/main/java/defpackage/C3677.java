package defpackage;

import defpackage.AbstractC4585;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableWindowTimed.java */
/* renamed from: ܢ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3677<T> extends AbstractC3232<T, AbstractC3630<T>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f12762;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f12763;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final TimeUnit f12764;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AbstractC4585 f12765;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final long f12766;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final int f12767;

    /* renamed from: ֏, reason: contains not printable characters */
    public final boolean f12768;

    /* compiled from: FlowableWindowTimed.java */
    /* renamed from: ܢ$Ϳ, reason: contains not printable characters */
    public static final class C3678<T> extends AbstractC3894<T, Object, AbstractC3630<T>> implements Subscription {

        /* renamed from: ֏, reason: contains not printable characters */
        public final long f12769;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final TimeUnit f12770;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final AbstractC4585 f12771;

        /* renamed from: ހ, reason: contains not printable characters */
        public final int f12772;

        /* renamed from: ށ, reason: contains not printable characters */
        public final boolean f12773;

        /* renamed from: ނ, reason: contains not printable characters */
        public final long f12774;

        /* renamed from: ރ, reason: contains not printable characters */
        public final AbstractC4585.AbstractC4588 f12775;

        /* renamed from: ބ, reason: contains not printable characters */
        public long f12776;

        /* renamed from: ޅ, reason: contains not printable characters */
        public long f12777;

        /* renamed from: ކ, reason: contains not printable characters */
        public Subscription f12778;

        /* renamed from: އ, reason: contains not printable characters */
        public UnicastProcessor<T> f12779;

        /* renamed from: ވ, reason: contains not printable characters */
        public volatile boolean f12780;

        /* renamed from: މ, reason: contains not printable characters */
        public final SequentialDisposable f12781;

        /* compiled from: FlowableWindowTimed.java */
        /* renamed from: ܢ$Ϳ$Ϳ, reason: contains not printable characters */
        public static final class RunnableC3679 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final long f12782;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final C3678<?> f12783;

            public RunnableC3679(long j, C3678<?> c3678) {
                this.f12782 = j;
                this.f12783 = c3678;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3678<?> c3678 = this.f12783;
                if (c3678.f13476) {
                    c3678.f12780 = true;
                } else {
                    c3678.f13475.offer(this);
                }
                if (c3678.m12561()) {
                    c3678.m11825();
                }
            }
        }

        public C3678(Subscriber<? super AbstractC3630<T>> subscriber, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i, long j2, boolean z) {
            super(subscriber, new MpscLinkedQueue());
            this.f12781 = new SequentialDisposable();
            this.f12769 = j;
            this.f12770 = timeUnit;
            this.f12771 = abstractC4585;
            this.f12772 = i;
            this.f12774 = j2;
            this.f12773 = z;
            if (z) {
                this.f12775 = abstractC4585.mo6986();
            } else {
                this.f12775 = null;
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f13476 = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f13477 = true;
            if (m12561()) {
                m11825();
            }
            this.f13474.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f13478 = th;
            this.f13477 = true;
            if (m12561()) {
                m11825();
            }
            this.f13474.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f12780) {
                return;
            }
            if (m12562()) {
                UnicastProcessor<T> unicastProcessor = this.f12779;
                unicastProcessor.onNext(t);
                long j = this.f12776 + 1;
                if (j >= this.f12774) {
                    this.f12777++;
                    this.f12776 = 0L;
                    unicastProcessor.onComplete();
                    long jMo9364 = mo9364();
                    if (jMo9364 == 0) {
                        this.f12779 = null;
                        this.f12778.cancel();
                        this.f13474.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                        m11824();
                        return;
                    }
                    UnicastProcessor<T> unicastProcessorM7027 = UnicastProcessor.m7027(this.f12772);
                    this.f12779 = unicastProcessorM7027;
                    this.f13474.onNext(unicastProcessorM7027);
                    if (jMo9364 != Long.MAX_VALUE) {
                        mo9366(1L);
                    }
                    if (this.f12773) {
                        this.f12781.get().dispose();
                        AbstractC4585.AbstractC4588 abstractC4588 = this.f12775;
                        RunnableC3679 runnableC3679 = new RunnableC3679(this.f12777, this);
                        long j2 = this.f12769;
                        this.f12781.m6311(abstractC4588.mo11922(runnableC3679, j2, j2, this.f12770));
                    }
                } else {
                    this.f12776 = j;
                }
                if (mo9363(-1) == 0) {
                    return;
                }
            } else {
                this.f13475.offer(NotificationLite.next(t));
                if (!m12561()) {
                    return;
                }
            }
            m11825();
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            InterfaceC4478 interfaceC4478Mo6989;
            if (SubscriptionHelper.validate(this.f12778, subscription)) {
                this.f12778 = subscription;
                Subscriber<? super V> subscriber = this.f13474;
                subscriber.onSubscribe(this);
                if (this.f13476) {
                    return;
                }
                UnicastProcessor<T> unicastProcessorM7027 = UnicastProcessor.m7027(this.f12772);
                this.f12779 = unicastProcessorM7027;
                long jMo9364 = mo9364();
                if (jMo9364 == 0) {
                    this.f13476 = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
                    return;
                }
                subscriber.onNext(unicastProcessorM7027);
                if (jMo9364 != Long.MAX_VALUE) {
                    mo9366(1L);
                }
                RunnableC3679 runnableC3679 = new RunnableC3679(this.f12777, this);
                if (this.f12773) {
                    AbstractC4585.AbstractC4588 abstractC4588 = this.f12775;
                    long j = this.f12769;
                    interfaceC4478Mo6989 = abstractC4588.mo11922(runnableC3679, j, j, this.f12770);
                } else {
                    AbstractC4585 abstractC4585 = this.f12771;
                    long j2 = this.f12769;
                    interfaceC4478Mo6989 = abstractC4585.mo6989(runnableC3679, j2, j2, this.f12770);
                }
                if (this.f12781.m6311(interfaceC4478Mo6989)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            m12565(j);
        }

        /* renamed from: ށ, reason: contains not printable characters */
        public void m11824() {
            this.f12781.dispose();
            AbstractC4585.AbstractC4588 abstractC4588 = this.f12775;
            if (abstractC4588 != null) {
                abstractC4588.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
        /* renamed from: ނ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m11825() {
            /*
                Method dump skipped, instructions count: 289
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C3677.C3678.m11825():void");
        }
    }

    /* compiled from: FlowableWindowTimed.java */
    /* renamed from: ܢ$Ԩ, reason: contains not printable characters */
    public static final class RunnableC3680<T> extends AbstractC3894<T, Object, AbstractC3630<T>> implements Subscription, Runnable {

        /* renamed from: ޅ, reason: contains not printable characters */
        public static final Object f12784 = new Object();

        /* renamed from: ֏, reason: contains not printable characters */
        public final long f12785;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final TimeUnit f12786;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final AbstractC4585 f12787;

        /* renamed from: ހ, reason: contains not printable characters */
        public final int f12788;

        /* renamed from: ށ, reason: contains not printable characters */
        public Subscription f12789;

        /* renamed from: ނ, reason: contains not printable characters */
        public UnicastProcessor<T> f12790;

        /* renamed from: ރ, reason: contains not printable characters */
        public final SequentialDisposable f12791;

        /* renamed from: ބ, reason: contains not printable characters */
        public volatile boolean f12792;

        public RunnableC3680(Subscriber<? super AbstractC3630<T>> subscriber, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.f12791 = new SequentialDisposable();
            this.f12785 = j;
            this.f12786 = timeUnit;
            this.f12787 = abstractC4585;
            this.f12788 = i;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f13476 = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f13477 = true;
            if (m12561()) {
                m11826();
            }
            this.f13474.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f13478 = th;
            this.f13477 = true;
            if (m12561()) {
                m11826();
            }
            this.f13474.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f12792) {
                return;
            }
            if (m12562()) {
                this.f12790.onNext(t);
                if (mo9363(-1) == 0) {
                    return;
                }
            } else {
                this.f13475.offer(NotificationLite.next(t));
                if (!m12561()) {
                    return;
                }
            }
            m11826();
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f12789, subscription)) {
                this.f12789 = subscription;
                this.f12790 = UnicastProcessor.m7027(this.f12788);
                Subscriber<? super V> subscriber = this.f13474;
                subscriber.onSubscribe(this);
                long jMo9364 = mo9364();
                if (jMo9364 == 0) {
                    this.f13476 = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                    return;
                }
                subscriber.onNext(this.f12790);
                if (jMo9364 != Long.MAX_VALUE) {
                    mo9366(1L);
                }
                if (this.f13476) {
                    return;
                }
                SequentialDisposable sequentialDisposable = this.f12791;
                AbstractC4585 abstractC4585 = this.f12787;
                long j = this.f12785;
                if (sequentialDisposable.m6311(abstractC4585.mo6989(this, j, j, this.f12786))) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            m12565(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13476) {
                this.f12792 = true;
            }
            this.f13475.offer(f12784);
            if (m12561()) {
                m11826();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
        
            r10.f12791.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        
            r10.f12790 = null;
            r0.clear();
            r0 = r10.f13478;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.processors.UnicastProcessor<T>] */
        /* renamed from: ؠ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m11826() {
            /*
                r10 = this;
                ǅ<U> r0 = r10.f13475
                org.reactivestreams.Subscriber<? super V> r1 = r10.f13474
                io.reactivex.processors.UnicastProcessor<T> r2 = r10.f12790
                r3 = 1
            L7:
                boolean r4 = r10.f12792
                boolean r5 = r10.f13477
                java.lang.Object r6 = r0.poll()
                r7 = 0
                if (r5 == 0) goto L2e
                if (r6 == 0) goto L18
                java.lang.Object r5 = defpackage.C3677.RunnableC3680.f12784
                if (r6 != r5) goto L2e
            L18:
                r10.f12790 = r7
                r0.clear()
                java.lang.Throwable r0 = r10.f13478
                if (r0 == 0) goto L25
                r2.onError(r0)
                goto L28
            L25:
                r2.onComplete()
            L28:
                io.reactivex.internal.disposables.SequentialDisposable r0 = r10.f12791
                r0.dispose()
                return
            L2e:
                if (r6 != 0) goto L38
                int r3 = -r3
                int r3 = r10.mo9363(r3)
                if (r3 != 0) goto L7
                return
            L38:
                java.lang.Object r5 = defpackage.C3677.RunnableC3680.f12784
                if (r6 != r5) goto L87
                r2.onComplete()
                if (r4 != 0) goto L81
                int r2 = r10.f12788
                io.reactivex.processors.UnicastProcessor r2 = io.reactivex.processors.UnicastProcessor.m7027(r2)
                r10.f12790 = r2
                long r4 = r10.mo9364()
                r8 = 0
                int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r6 == 0) goto L65
                r1.onNext(r2)
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 == 0) goto L7
                r4 = 1
                r10.mo9366(r4)
                goto L7
            L65:
                r10.f12790 = r7
                ǅ<U> r0 = r10.f13475
                r0.clear()
                org.reactivestreams.Subscription r0 = r10.f12789
                r0.cancel()
                io.reactivex.exceptions.MissingBackpressureException r0 = new io.reactivex.exceptions.MissingBackpressureException
                java.lang.String r2 = "Could not deliver first window due to lack of requests."
                r0.<init>(r2)
                r1.onError(r0)
                io.reactivex.internal.disposables.SequentialDisposable r0 = r10.f12791
                r0.dispose()
                return
            L81:
                org.reactivestreams.Subscription r4 = r10.f12789
                r4.cancel()
                goto L7
            L87:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C3677.RunnableC3680.m11826():void");
        }
    }

    /* compiled from: FlowableWindowTimed.java */
    /* renamed from: ܢ$Ԫ, reason: contains not printable characters */
    public static final class RunnableC3681<T> extends AbstractC3894<T, Object, AbstractC3630<T>> implements Subscription, Runnable {

        /* renamed from: ֏, reason: contains not printable characters */
        public final long f12793;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final long f12794;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final TimeUnit f12795;

        /* renamed from: ހ, reason: contains not printable characters */
        public final AbstractC4585.AbstractC4588 f12796;

        /* renamed from: ށ, reason: contains not printable characters */
        public final int f12797;

        /* renamed from: ނ, reason: contains not printable characters */
        public final List<UnicastProcessor<T>> f12798;

        /* renamed from: ރ, reason: contains not printable characters */
        public Subscription f12799;

        /* renamed from: ބ, reason: contains not printable characters */
        public volatile boolean f12800;

        /* compiled from: FlowableWindowTimed.java */
        /* renamed from: ܢ$Ԫ$Ϳ, reason: contains not printable characters */
        public final class RunnableC3682 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final UnicastProcessor<T> f12801;

            public RunnableC3682(UnicastProcessor<T> unicastProcessor) {
                this.f12801 = unicastProcessor;
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC3681.this.m11827(this.f12801);
            }
        }

        /* compiled from: FlowableWindowTimed.java */
        /* renamed from: ܢ$Ԫ$Ԩ, reason: contains not printable characters */
        public static final class C3683<T> {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final UnicastProcessor<T> f12803;

            /* renamed from: Ԩ, reason: contains not printable characters */
            public final boolean f12804;

            public C3683(UnicastProcessor<T> unicastProcessor, boolean z) {
                this.f12803 = unicastProcessor;
                this.f12804 = z;
            }
        }

        public RunnableC3681(Subscriber<? super AbstractC3630<T>> subscriber, long j, long j2, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.f12793 = j;
            this.f12794 = j2;
            this.f12795 = timeUnit;
            this.f12796 = abstractC4588;
            this.f12797 = i;
            this.f12798 = new LinkedList();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f13476 = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f13477 = true;
            if (m12561()) {
                m11828();
            }
            this.f13474.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f13478 = th;
            this.f13477 = true;
            if (m12561()) {
                m11828();
            }
            this.f13474.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (m12562()) {
                Iterator<UnicastProcessor<T>> it = this.f12798.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (mo9363(-1) == 0) {
                    return;
                }
            } else {
                this.f13475.offer(t);
                if (!m12561()) {
                    return;
                }
            }
            m11828();
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f12799, subscription)) {
                this.f12799 = subscription;
                this.f13474.onSubscribe(this);
                if (this.f13476) {
                    return;
                }
                long jMo9364 = mo9364();
                if (jMo9364 == 0) {
                    subscription.cancel();
                    this.f13474.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
                    return;
                }
                UnicastProcessor<T> unicastProcessorM7027 = UnicastProcessor.m7027(this.f12797);
                this.f12798.add(unicastProcessorM7027);
                this.f13474.onNext(unicastProcessorM7027);
                if (jMo9364 != Long.MAX_VALUE) {
                    mo9366(1L);
                }
                this.f12796.mo6991(new RunnableC3682(unicastProcessorM7027), this.f12793, this.f12795);
                AbstractC4585.AbstractC4588 abstractC4588 = this.f12796;
                long j = this.f12794;
                abstractC4588.mo11922(this, j, j, this.f12795);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            m12565(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            C3683 c3683 = new C3683(UnicastProcessor.m7027(this.f12797), true);
            if (!this.f13476) {
                this.f13475.offer(c3683);
            }
            if (m12561()) {
                m11828();
            }
        }

        /* renamed from: ؠ, reason: contains not printable characters */
        public void m11827(UnicastProcessor<T> unicastProcessor) {
            this.f13475.offer(new C3683(unicastProcessor, false));
            if (m12561()) {
                m11828();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: ހ, reason: contains not printable characters */
        public void m11828() {
            InterfaceC4851 interfaceC4851 = this.f13475;
            Subscriber<? super V> subscriber = this.f13474;
            List<UnicastProcessor<T>> list = this.f12798;
            int iMo9363 = 1;
            while (!this.f12800) {
                boolean z = this.f13477;
                Object objPoll = interfaceC4851.poll();
                boolean z2 = objPoll == null;
                boolean z3 = objPoll instanceof C3683;
                if (z && (z2 || z3)) {
                    interfaceC4851.clear();
                    Throwable th = this.f13478;
                    if (th != null) {
                        Iterator<UnicastProcessor<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastProcessor<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    this.f12796.dispose();
                    return;
                }
                if (z2) {
                    iMo9363 = mo9363(-iMo9363);
                    if (iMo9363 == 0) {
                        return;
                    }
                } else if (z3) {
                    C3683 c3683 = (C3683) objPoll;
                    if (!c3683.f12804) {
                        list.remove(c3683.f12803);
                        c3683.f12803.onComplete();
                        if (list.isEmpty() && this.f13476) {
                            this.f12800 = true;
                        }
                    } else if (!this.f13476) {
                        long jMo9364 = mo9364();
                        if (jMo9364 != 0) {
                            UnicastProcessor<T> unicastProcessorM7027 = UnicastProcessor.m7027(this.f12797);
                            list.add(unicastProcessorM7027);
                            subscriber.onNext(unicastProcessorM7027);
                            if (jMo9364 != Long.MAX_VALUE) {
                                mo9366(1L);
                            }
                            this.f12796.mo6991(new RunnableC3682(unicastProcessorM7027), this.f12793, this.f12795);
                        } else {
                            subscriber.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<UnicastProcessor<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(objPoll);
                    }
                }
            }
            this.f12799.cancel();
            interfaceC4851.clear();
            list.clear();
            this.f12796.dispose();
        }
    }

    public C3677(AbstractC3630<T> abstractC3630, long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585, long j3, int i, boolean z) {
        super(abstractC3630);
        this.f12762 = j;
        this.f12763 = j2;
        this.f12764 = timeUnit;
        this.f12765 = abstractC4585;
        this.f12766 = j3;
        this.f12767 = i;
        this.f12768 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super AbstractC3630<T>> subscriber) {
        C4056 c4056 = new C4056(subscriber);
        long j = this.f12762;
        long j2 = this.f12763;
        if (j != j2) {
            this.f11385.subscribe((InterfaceC3899) new RunnableC3681(c4056, j, j2, this.f12764, this.f12765.mo6986(), this.f12767));
            return;
        }
        long j3 = this.f12766;
        if (j3 == Long.MAX_VALUE) {
            this.f11385.subscribe((InterfaceC3899) new RunnableC3680(c4056, this.f12762, this.f12764, this.f12765, this.f12767));
        } else {
            this.f11385.subscribe((InterfaceC3899) new C3678(c4056, j, this.f12764, this.f12765, this.f12767, j3, this.f12768));
        }
    }
}
