package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C5153;
import defpackage.InterfaceC2697;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableFromIterable<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Iterable<? extends T> f6950;

    public static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        public volatile boolean cancelled;
        public Iterator<? extends T> it;
        public boolean once;

        public BaseRangeSubscription(Iterator<? extends T> it) {
            this.it = it;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // defpackage.InterfaceC4851
        public final void clear() {
            this.it = null;
        }

        @Override // defpackage.InterfaceC4851
        public final boolean isEmpty() {
            Iterator<? extends T> it = this.it;
            return it == null || !it.hasNext();
        }

        @Override // defpackage.InterfaceC4851
        public final T poll() {
            Iterator<? extends T> it = this.it;
            if (it == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!it.hasNext()) {
                return null;
            }
            return (T) C4246.m13353(this.it.next(), "Iterator.next() returned a null value");
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && C5153.m15069(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    mo6464();
                } else {
                    mo6465(j);
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public abstract void mo6464();

        /* renamed from: Ԩ, reason: contains not printable characters */
        public abstract void mo6465(long j);

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public final int mo6310(int i) {
            return i & 1;
        }
    }

    public static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        public final InterfaceC2697<? super T> downstream;

        public IteratorConditionalSubscription(InterfaceC2697<? super T> interfaceC2697, Iterator<? extends T> it) {
            super(it);
            this.downstream = interfaceC2697;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /* renamed from: Ϳ */
        public void mo6464() {
            Iterator<? extends T> it = this.it;
            InterfaceC2697<? super T> interfaceC2697 = this.downstream;
            while (!this.cancelled) {
                try {
                    T next = it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        interfaceC2697.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    interfaceC2697.mo6426(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            interfaceC2697.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        interfaceC2697.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    interfaceC2697.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x005b, code lost:
        
            r9 = addAndGet(-r4);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /* renamed from: Ԩ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo6465(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.it
                ʢ<? super T> r1 = r8.downstream
                r2 = 0
            L6:
                r4 = r2
            L7:
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 == 0) goto L53
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L10
                return
            L10:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L4b
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L19
                return
            L19:
                if (r6 != 0) goto L26
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L26:
                boolean r6 = r1.mo6426(r6)
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L2f
                return
            L2f:
                boolean r7 = r0.hasNext()     // Catch: java.lang.Throwable -> L43
                if (r7 != 0) goto L3d
                boolean r9 = r8.cancelled
                if (r9 != 0) goto L3c
                r1.onComplete()
            L3c:
                return
            L3d:
                if (r6 == 0) goto L7
                r6 = 1
                long r4 = r4 + r6
                goto L7
            L43:
                r9 = move-exception
                defpackage.C4089.m13026(r9)
                r1.onError(r9)
                return
            L4b:
                r9 = move-exception
                defpackage.C4089.m13026(r9)
                r1.onError(r9)
                return
            L53:
                long r9 = r8.get()
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 != 0) goto L7
                long r9 = -r4
                long r9 = r8.addAndGet(r9)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 != 0) goto L6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromIterable.IteratorConditionalSubscription.mo6465(long):void");
        }
    }

    public static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        public final Subscriber<? super T> downstream;

        public IteratorSubscription(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            super(it);
            this.downstream = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /* renamed from: Ϳ */
        public void mo6464() {
            Iterator<? extends T> it = this.it;
            Subscriber<? super T> subscriber = this.downstream;
            while (!this.cancelled) {
                try {
                    T next = it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    subscriber.onNext(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            subscriber.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        subscriber.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    subscriber.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0058, code lost:
        
            r9 = addAndGet(-r4);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /* renamed from: Ԩ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo6465(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.it
                org.reactivestreams.Subscriber<? super T> r1 = r8.downstream
                r2 = 0
            L6:
                r4 = r2
            L7:
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 == 0) goto L50
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L10
                return
            L10:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L48
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L19
                return
            L19:
                if (r6 != 0) goto L26
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L26:
                r1.onNext(r6)
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L2e
                return
            L2e:
                boolean r6 = r0.hasNext()     // Catch: java.lang.Throwable -> L40
                if (r6 != 0) goto L3c
                boolean r9 = r8.cancelled
                if (r9 != 0) goto L3b
                r1.onComplete()
            L3b:
                return
            L3c:
                r6 = 1
                long r4 = r4 + r6
                goto L7
            L40:
                r9 = move-exception
                defpackage.C4089.m13026(r9)
                r1.onError(r9)
                return
            L48:
                r9 = move-exception
                defpackage.C4089.m13026(r9)
                r1.onError(r9)
                return
            L50:
                long r9 = r8.get()
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 != 0) goto L7
                long r9 = -r4
                long r9 = r8.addAndGet(r9)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 != 0) goto L6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromIterable.IteratorSubscription.mo6465(long):void");
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.f6950 = iterable;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static <T> void m6463(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                EmptySubscription.complete(subscriber);
            } else if (subscriber instanceof InterfaceC2697) {
                subscriber.onSubscribe(new IteratorConditionalSubscription((InterfaceC2697) subscriber, it));
            } else {
                subscriber.onSubscribe(new IteratorSubscription(subscriber, it));
            }
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            m6463(subscriber, this.f6950.iterator());
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
