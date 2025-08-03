package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.C5153;
import defpackage.InterfaceC2697;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableRange extends AbstractC3630<Integer> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f7070;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f7071;

    public static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        public volatile boolean cancelled;
        public final int end;
        public int index;

        public BaseRangeSubscription(int i, int i2) {
            this.index = i;
            this.end = i2;
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
                    mo6570();
                } else {
                    mo6572(j);
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public abstract void mo6570();

        @Override // defpackage.InterfaceC4851
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public final Integer poll() {
            int i = this.index;
            if (i == this.end) {
                return null;
            }
            this.index = i + 1;
            return Integer.valueOf(i);
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public final int mo6310(int i) {
            return i & 1;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public abstract void mo6572(long j);
    }

    public static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        public final InterfaceC2697<? super Integer> downstream;

        public RangeConditionalSubscription(InterfaceC2697<? super Integer> interfaceC2697, int i, int i2) {
            super(i, i2);
            this.downstream = interfaceC2697;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        /* renamed from: Ϳ */
        public void mo6570() {
            int i = this.end;
            InterfaceC2697<? super Integer> interfaceC2697 = this.downstream;
            for (int i2 = this.index; i2 != i; i2++) {
                if (this.cancelled) {
                    return;
                }
                interfaceC2697.mo6426(Integer.valueOf(i2));
            }
            if (this.cancelled) {
                return;
            }
            interfaceC2697.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
        
            r9.index = r1;
            r10 = addAndGet(-r5);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        /* renamed from: Ԫ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo6572(long r10) {
            /*
                r9 = this;
                int r0 = r9.end
                int r1 = r9.index
                ʢ<? super java.lang.Integer> r2 = r9.downstream
                r3 = 0
            L8:
                r5 = r3
            L9:
                int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r7 == 0) goto L24
                if (r1 == r0) goto L24
                boolean r7 = r9.cancelled
                if (r7 == 0) goto L14
                return
            L14:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                boolean r7 = r2.mo6426(r7)
                if (r7 == 0) goto L21
                r7 = 1
                long r5 = r5 + r7
            L21:
                int r1 = r1 + 1
                goto L9
            L24:
                if (r1 != r0) goto L2e
                boolean r10 = r9.cancelled
                if (r10 != 0) goto L2d
                r2.onComplete()
            L2d:
                return
            L2e:
                long r10 = r9.get()
                int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r7 != 0) goto L9
                r9.index = r1
                long r10 = -r5
                long r10 = r9.addAndGet(r10)
                int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r5 != 0) goto L8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRange.RangeConditionalSubscription.mo6572(long):void");
        }
    }

    public static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        public final Subscriber<? super Integer> downstream;

        public RangeSubscription(Subscriber<? super Integer> subscriber, int i, int i2) {
            super(i, i2);
            this.downstream = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        /* renamed from: Ϳ */
        public void mo6570() {
            int i = this.end;
            Subscriber<? super Integer> subscriber = this.downstream;
            for (int i2 = this.index; i2 != i; i2++) {
                if (this.cancelled) {
                    return;
                }
                subscriber.onNext(Integer.valueOf(i2));
            }
            if (this.cancelled) {
                return;
            }
            subscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
        
            r9.index = r1;
            r10 = addAndGet(-r5);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        /* renamed from: Ԫ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo6572(long r10) {
            /*
                r9 = this;
                int r0 = r9.end
                int r1 = r9.index
                org.reactivestreams.Subscriber<? super java.lang.Integer> r2 = r9.downstream
                r3 = 0
            L8:
                r5 = r3
            L9:
                int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r7 == 0) goto L21
                if (r1 == r0) goto L21
                boolean r7 = r9.cancelled
                if (r7 == 0) goto L14
                return
            L14:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                r2.onNext(r7)
                r7 = 1
                long r5 = r5 + r7
                int r1 = r1 + 1
                goto L9
            L21:
                if (r1 != r0) goto L2b
                boolean r10 = r9.cancelled
                if (r10 != 0) goto L2a
                r2.onComplete()
            L2a:
                return
            L2b:
                long r10 = r9.get()
                int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r7 != 0) goto L9
                r9.index = r1
                long r10 = -r5
                long r10 = r9.addAndGet(r10)
                int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r5 != 0) goto L8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRange.RangeSubscription.mo6572(long):void");
        }
    }

    public FlowableRange(int i, int i2) {
        this.f7070 = i;
        this.f7071 = i + i2;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super Integer> subscriber) {
        if (subscriber instanceof InterfaceC2697) {
            subscriber.onSubscribe(new RangeConditionalSubscription((InterfaceC2697) subscriber, this.f7070, this.f7071));
        } else {
            subscriber.onSubscribe(new RangeSubscription(subscriber, this.f7070, this.f7071));
        }
    }
}
