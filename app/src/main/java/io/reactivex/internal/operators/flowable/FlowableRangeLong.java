package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.C5153;
import defpackage.InterfaceC2697;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableRangeLong extends AbstractC3630<Long> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final long f7072;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7073;

    public static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        public volatile boolean cancelled;
        public final long end;
        public long index;

        public BaseRangeSubscription(long j, long j2) {
            this.index = j;
            this.end = j2;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // defpackage.InterfaceC4851
        public final void clear() {
            this.index = this.end;
        }

        @Override // defpackage.InterfaceC4851
        public final boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && C5153.m15069(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    mo6573();
                } else {
                    mo6575(j);
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public abstract void mo6573();

        @Override // defpackage.InterfaceC4851
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public final Long poll() {
            long j = this.index;
            if (j == this.end) {
                return null;
            }
            this.index = 1 + j;
            return Long.valueOf(j);
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public final int mo6310(int i) {
            return i & 1;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public abstract void mo6575(long j);
    }

    public static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        public final InterfaceC2697<? super Long> downstream;

        public RangeConditionalSubscription(InterfaceC2697<? super Long> interfaceC2697, long j, long j2) {
            super(j, j2);
            this.downstream = interfaceC2697;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        /* renamed from: Ϳ */
        public void mo6573() {
            long j = this.end;
            InterfaceC2697<? super Long> interfaceC2697 = this.downstream;
            for (long j2 = this.index; j2 != j; j2++) {
                if (this.cancelled) {
                    return;
                }
                interfaceC2697.mo6426(Long.valueOf(j2));
            }
            if (this.cancelled) {
                return;
            }
            interfaceC2697.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
        
            r12.index = r2;
            r13 = addAndGet(-r7);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        /* renamed from: Ԫ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo6575(long r13) {
            /*
                r12 = this;
                long r0 = r12.end
                long r2 = r12.index
                ʢ<? super java.lang.Long> r4 = r12.downstream
                r5 = 0
            L8:
                r7 = r5
            L9:
                int r9 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
                if (r9 == 0) goto L25
                int r9 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r9 == 0) goto L25
                boolean r9 = r12.cancelled
                if (r9 == 0) goto L16
                return
            L16:
                java.lang.Long r9 = java.lang.Long.valueOf(r2)
                boolean r9 = r4.mo6426(r9)
                r10 = 1
                if (r9 == 0) goto L23
                long r7 = r7 + r10
            L23:
                long r2 = r2 + r10
                goto L9
            L25:
                int r13 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r13 != 0) goto L31
                boolean r13 = r12.cancelled
                if (r13 != 0) goto L30
                r4.onComplete()
            L30:
                return
            L31:
                long r13 = r12.get()
                int r9 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
                if (r9 != 0) goto L9
                r12.index = r2
                long r13 = -r7
                long r13 = r12.addAndGet(r13)
                int r7 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
                if (r7 != 0) goto L8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRangeLong.RangeConditionalSubscription.mo6575(long):void");
        }
    }

    public static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        public final Subscriber<? super Long> downstream;

        public RangeSubscription(Subscriber<? super Long> subscriber, long j, long j2) {
            super(j, j2);
            this.downstream = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        /* renamed from: Ϳ */
        public void mo6573() {
            long j = this.end;
            Subscriber<? super Long> subscriber = this.downstream;
            for (long j2 = this.index; j2 != j; j2++) {
                if (this.cancelled) {
                    return;
                }
                subscriber.onNext(Long.valueOf(j2));
            }
            if (this.cancelled) {
                return;
            }
            subscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
        
            r11.index = r2;
            r12 = addAndGet(-r7);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        /* renamed from: Ԫ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo6575(long r12) {
            /*
                r11 = this;
                long r0 = r11.end
                long r2 = r11.index
                org.reactivestreams.Subscriber<? super java.lang.Long> r4 = r11.downstream
                r5 = 0
            L8:
                r7 = r5
            L9:
                int r9 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
                if (r9 == 0) goto L22
                int r9 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r9 == 0) goto L22
                boolean r9 = r11.cancelled
                if (r9 == 0) goto L16
                return
            L16:
                java.lang.Long r9 = java.lang.Long.valueOf(r2)
                r4.onNext(r9)
                r9 = 1
                long r7 = r7 + r9
                long r2 = r2 + r9
                goto L9
            L22:
                int r12 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r12 != 0) goto L2e
                boolean r12 = r11.cancelled
                if (r12 != 0) goto L2d
                r4.onComplete()
            L2d:
                return
            L2e:
                long r12 = r11.get()
                int r9 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
                if (r9 != 0) goto L9
                r11.index = r2
                long r12 = -r7
                long r12 = r11.addAndGet(r12)
                int r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
                if (r7 != 0) goto L8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRangeLong.RangeSubscription.mo6575(long):void");
        }
    }

    public FlowableRangeLong(long j, long j2) {
        this.f7072 = j;
        this.f7073 = j + j2;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        if (subscriber instanceof InterfaceC2697) {
            subscriber.onSubscribe(new RangeConditionalSubscription((InterfaceC2697) subscriber, this.f7072, this.f7073));
        } else {
            subscriber.onSubscribe(new RangeSubscription(subscriber, this.f7072, this.f7073));
        }
    }
}
