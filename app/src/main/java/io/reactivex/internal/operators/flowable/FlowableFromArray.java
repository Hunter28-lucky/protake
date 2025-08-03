package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.C4246;
import defpackage.C5153;
import defpackage.InterfaceC2697;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableFromArray<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final T[] f6949;

    public static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        public final InterfaceC2697<? super T> downstream;

        public ArrayConditionalSubscription(InterfaceC2697<? super T> interfaceC2697, T[] tArr) {
            super(tArr);
            this.downstream = interfaceC2697;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo6461() {
            T[] tArr = this.array;
            int length = tArr.length;
            InterfaceC2697<? super T> interfaceC2697 = this.downstream;
            for (int i = this.index; i != length; i++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[i];
                if (t == null) {
                    interfaceC2697.onError(new NullPointerException("The element at index " + i + " is null"));
                    return;
                }
                interfaceC2697.mo6426(t);
            }
            if (this.cancelled) {
                return;
            }
            interfaceC2697.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        
            r10.index = r2;
            r11 = addAndGet(-r6);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /* renamed from: Ԩ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo6462(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.array
                int r1 = r0.length
                int r2 = r10.index
                ʢ<? super T> r3 = r10.downstream
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L44
                if (r2 == r1) goto L44
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L15
                return
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L38
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r0 = "The element at index "
                r12.append(r0)
                r12.append(r2)
                java.lang.String r0 = " is null"
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                r11.<init>(r12)
                r3.onError(r11)
                return
            L38:
                boolean r8 = r3.mo6426(r8)
                if (r8 == 0) goto L41
                r8 = 1
                long r6 = r6 + r8
            L41:
                int r2 = r2 + 1
                goto La
            L44:
                if (r2 != r1) goto L4e
                boolean r11 = r10.cancelled
                if (r11 != 0) goto L4d
                r3.onComplete()
            L4d:
                return
            L4e:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.index = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromArray.ArrayConditionalSubscription.mo6462(long):void");
        }
    }

    public static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        public final Subscriber<? super T> downstream;

        public ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.downstream = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /* renamed from: Ϳ */
        public void mo6461() {
            T[] tArr = this.array;
            int length = tArr.length;
            Subscriber<? super T> subscriber = this.downstream;
            for (int i = this.index; i != length; i++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[i];
                if (t == null) {
                    subscriber.onError(new NullPointerException("The element at index " + i + " is null"));
                    return;
                }
                subscriber.onNext(t);
            }
            if (this.cancelled) {
                return;
            }
            subscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
        
            r10.index = r2;
            r11 = addAndGet(-r6);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /* renamed from: Ԩ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo6462(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.array
                int r1 = r0.length
                int r2 = r10.index
                org.reactivestreams.Subscriber<? super T> r3 = r10.downstream
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L41
                if (r2 == r1) goto L41
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L15
                return
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L38
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r0 = "The element at index "
                r12.append(r0)
                r12.append(r2)
                java.lang.String r0 = " is null"
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                r11.<init>(r12)
                r3.onError(r11)
                return
            L38:
                r3.onNext(r8)
                r8 = 1
                long r6 = r6 + r8
                int r2 = r2 + 1
                goto La
            L41:
                if (r2 != r1) goto L4b
                boolean r11 = r10.cancelled
                if (r11 != 0) goto L4a
                r3.onComplete()
            L4a:
                return
            L4b:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.index = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromArray.ArraySubscription.mo6462(long):void");
        }
    }

    public static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        public final T[] array;
        public volatile boolean cancelled;
        public int index;

        public BaseArraySubscription(T[] tArr) {
            this.array = tArr;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // defpackage.InterfaceC4851
        public final void clear() {
            this.index = this.array.length;
        }

        @Override // defpackage.InterfaceC4851
        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // defpackage.InterfaceC4851
        public final T poll() {
            int i = this.index;
            T[] tArr = this.array;
            if (i == tArr.length) {
                return null;
            }
            this.index = i + 1;
            return (T) C4246.m13353(tArr[i], "array element is null");
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && C5153.m15069(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    mo6461();
                } else {
                    mo6462(j);
                }
            }
        }

        /* renamed from: Ϳ */
        public abstract void mo6461();

        /* renamed from: Ԩ */
        public abstract void mo6462(long j);

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public final int mo6310(int i) {
            return i & 1;
        }
    }

    public FlowableFromArray(T[] tArr) {
        this.f6949 = tArr;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof InterfaceC2697) {
            subscriber.onSubscribe(new ArrayConditionalSubscription((InterfaceC2697) subscriber, this.f6949));
        } else {
            subscriber.onSubscribe(new ArraySubscription(subscriber, this.f6949));
        }
    }
}
