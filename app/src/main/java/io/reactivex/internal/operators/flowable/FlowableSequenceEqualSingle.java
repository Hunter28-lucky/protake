package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.AbstractC4838;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC2583;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC4851;
import defpackage.InterfaceC5324;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* loaded from: classes2.dex */
public final class FlowableSequenceEqualSingle<T> extends AbstractC4838<Boolean> implements InterfaceC2583<Boolean> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<? extends T> f7122;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<? extends T> f7123;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5324<? super T, ? super T> f7124;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7125;

    public static final class EqualCoordinator<T> extends AtomicInteger implements InterfaceC4478, FlowableSequenceEqual.InterfaceC2053 {
        private static final long serialVersionUID = -6178010334400373240L;
        public final InterfaceC5324<? super T, ? super T> comparer;
        public final InterfaceC4782<? super Boolean> downstream;
        public final AtomicThrowable error = new AtomicThrowable();
        public final FlowableSequenceEqual.EqualSubscriber<T> first;
        public final FlowableSequenceEqual.EqualSubscriber<T> second;
        public T v1;
        public T v2;

        public EqualCoordinator(InterfaceC4782<? super Boolean> interfaceC4782, int i, InterfaceC5324<? super T, ? super T> interfaceC5324) {
            this.downstream = interfaceC4782;
            this.comparer = interfaceC5324;
            this.first = new FlowableSequenceEqual.EqualSubscriber<>(this, i);
            this.second = new FlowableSequenceEqual.EqualSubscriber<>(this, i);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.first.m6628();
            this.second.m6628();
            if (getAndIncrement() == 0) {
                this.first.clear();
                this.second.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.first.get() == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.InterfaceC2053
        /* renamed from: Ϳ */
        public void mo6624(Throwable th) {
            if (this.error.m7018(th)) {
                mo6625();
            } else {
                C3671.m11803(th);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.InterfaceC2053
        /* renamed from: Ԩ */
        public void mo6625() {
            if (getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                InterfaceC4851<T> interfaceC4851 = this.first.queue;
                InterfaceC4851<T> interfaceC48512 = this.second.queue;
                if (interfaceC4851 != null && interfaceC48512 != null) {
                    while (!isDisposed()) {
                        if (this.error.get() != null) {
                            m6630();
                            this.downstream.onError(this.error.m7019());
                            return;
                        }
                        boolean z = this.first.done;
                        T tPoll = this.v1;
                        if (tPoll == null) {
                            try {
                                tPoll = interfaceC4851.poll();
                                this.v1 = tPoll;
                            } catch (Throwable th) {
                                C4089.m13026(th);
                                m6630();
                                this.error.m7018(th);
                                this.downstream.onError(this.error.m7019());
                                return;
                            }
                        }
                        boolean z2 = tPoll == null;
                        boolean z3 = this.second.done;
                        T tPoll2 = this.v2;
                        if (tPoll2 == null) {
                            try {
                                tPoll2 = interfaceC48512.poll();
                                this.v2 = tPoll2;
                            } catch (Throwable th2) {
                                C4089.m13026(th2);
                                m6630();
                                this.error.m7018(th2);
                                this.downstream.onError(this.error.m7019());
                                return;
                            }
                        }
                        boolean z4 = tPoll2 == null;
                        if (z && z3 && z2 && z4) {
                            this.downstream.onSuccess(Boolean.TRUE);
                            return;
                        }
                        if (z && z3 && z2 != z4) {
                            m6630();
                            this.downstream.onSuccess(Boolean.FALSE);
                            return;
                        }
                        if (!z2 && !z4) {
                            try {
                                if (!this.comparer.test(tPoll, tPoll2)) {
                                    m6630();
                                    this.downstream.onSuccess(Boolean.FALSE);
                                    return;
                                } else {
                                    this.v1 = null;
                                    this.v2 = null;
                                    this.first.m6629();
                                    this.second.m6629();
                                }
                            } catch (Throwable th3) {
                                C4089.m13026(th3);
                                m6630();
                                this.error.m7018(th3);
                                this.downstream.onError(this.error.m7019());
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                }
                if (isDisposed()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (this.error.get() != null) {
                    m6630();
                    this.downstream.onError(this.error.m7019());
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6630() {
            this.first.m6628();
            this.first.clear();
            this.second.m6628();
            this.second.clear();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6631(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
            publisher.subscribe(this.first);
            publisher2.subscribe(this.second);
        }
    }

    public FlowableSequenceEqualSingle(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, InterfaceC5324<? super T, ? super T> interfaceC5324, int i) {
        this.f7122 = publisher;
        this.f7123 = publisher2;
        this.f7124 = interfaceC5324;
        this.f7125 = i;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super Boolean> interfaceC4782) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(interfaceC4782, this.f7125, this.f7124);
        interfaceC4782.onSubscribe(equalCoordinator);
        equalCoordinator.m6631(this.f7122, this.f7123);
    }

    @Override // defpackage.InterfaceC2583
    /* renamed from: ԩ */
    public AbstractC3630<Boolean> mo6444() {
        return C3671.m11796(new FlowableSequenceEqual(this.f7122, this.f7123, this.f7124, this.f7125));
    }
}
