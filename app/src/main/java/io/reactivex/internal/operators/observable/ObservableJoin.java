package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.C2527;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5247;
import defpackage.d;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractC3414<TLeft, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<? extends TRight> f7391;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super TLeft, ? extends InterfaceC2856<TLeftEnd>> f7392;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC2368<? super TRight, ? extends InterfaceC2856<TRightEnd>> f7393;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC5247<? super TLeft, ? super TRight, ? extends R> f7394;

    public static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements InterfaceC4478, ObservableGroupJoin.InterfaceC2077 {
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final Integer f7395 = 1;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final Integer f7396 = 2;

        /* renamed from: ԭ, reason: contains not printable characters */
        public static final Integer f7397 = 3;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public static final Integer f7398 = 4;
        public volatile boolean cancelled;
        public final InterfaceC5102<? super R> downstream;
        public final InterfaceC2368<? super TLeft, ? extends InterfaceC2856<TLeftEnd>> leftEnd;
        public int leftIndex;
        public final InterfaceC5247<? super TLeft, ? super TRight, ? extends R> resultSelector;
        public final InterfaceC2368<? super TRight, ? extends InterfaceC2856<TRightEnd>> rightEnd;
        public int rightIndex;
        public final C2527 disposables = new C2527();
        public final d<Object> queue = new d<>(AbstractC4262.bufferSize());
        public final Map<Integer, TLeft> lefts = new LinkedHashMap();
        public final Map<Integer, TRight> rights = new LinkedHashMap();
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final AtomicInteger active = new AtomicInteger(2);

        public JoinDisposable(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super TLeft, ? extends InterfaceC2856<TLeftEnd>> interfaceC2368, InterfaceC2368<? super TRight, ? extends InterfaceC2856<TRightEnd>> interfaceC23682, InterfaceC5247<? super TLeft, ? super TRight, ? extends R> interfaceC5247) {
            this.downstream = interfaceC5102;
            this.leftEnd = interfaceC2368;
            this.rightEnd = interfaceC23682;
            this.resultSelector = interfaceC5247;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            m6811();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.InterfaceC2077
        /* renamed from: Ϳ */
        public void mo6800(Throwable th) {
            if (!ExceptionHelper.m7020(this.error, th)) {
                C3671.m11803(th);
            } else {
                this.active.decrementAndGet();
                m6812();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.InterfaceC2077
        /* renamed from: Ԩ */
        public void mo6801(Throwable th) {
            if (ExceptionHelper.m7020(this.error, th)) {
                m6812();
            } else {
                C3671.m11803(th);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.InterfaceC2077
        /* renamed from: ԩ */
        public void mo6802(boolean z, Object obj) {
            synchronized (this) {
                this.queue.m5884(z ? f7395 : f7396, obj);
            }
            m6812();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.InterfaceC2077
        /* renamed from: Ԫ */
        public void mo6803(boolean z, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.queue.m5884(z ? f7397 : f7398, leftRightEndObserver);
            }
            m6812();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.InterfaceC2077
        /* renamed from: ԫ */
        public void mo6804(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
            this.disposables.mo9335(leftRightObserver);
            this.active.decrementAndGet();
            m6812();
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6811() {
            this.disposables.dispose();
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public void m6812() {
            if (getAndIncrement() != 0) {
                return;
            }
            d<?> dVar = this.queue;
            InterfaceC5102<? super R> interfaceC5102 = this.downstream;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    dVar.clear();
                    m6811();
                    m6813(interfaceC5102);
                    return;
                }
                boolean z = this.active.get() == 0;
                Integer num = (Integer) dVar.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    interfaceC5102.onComplete();
                    return;
                }
                if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = dVar.poll();
                    if (num == f7395) {
                        int i = this.leftIndex;
                        this.leftIndex = i + 1;
                        this.lefts.put(Integer.valueOf(i), objPoll);
                        try {
                            InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.leftEnd.apply(objPoll), "The leftEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i);
                            this.disposables.mo9333(leftRightEndObserver);
                            interfaceC2856.subscribe(leftRightEndObserver);
                            if (this.error.get() != null) {
                                dVar.clear();
                                m6811();
                                m6813(interfaceC5102);
                                return;
                            } else {
                                Iterator<TRight> it = this.rights.values().iterator();
                                while (it.hasNext()) {
                                    try {
                                        interfaceC5102.onNext((Object) C4246.m13353(this.resultSelector.apply(objPoll, it.next()), "The resultSelector returned a null value"));
                                    } catch (Throwable th) {
                                        m6814(th, interfaceC5102, dVar);
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            m6814(th2, interfaceC5102, dVar);
                            return;
                        }
                    } else if (num == f7396) {
                        int i2 = this.rightIndex;
                        this.rightIndex = i2 + 1;
                        this.rights.put(Integer.valueOf(i2), objPoll);
                        try {
                            InterfaceC2856 interfaceC28562 = (InterfaceC2856) C4246.m13353(this.rightEnd.apply(objPoll), "The rightEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i2);
                            this.disposables.mo9333(leftRightEndObserver2);
                            interfaceC28562.subscribe(leftRightEndObserver2);
                            if (this.error.get() != null) {
                                dVar.clear();
                                m6811();
                                m6813(interfaceC5102);
                                return;
                            } else {
                                Iterator<TLeft> it2 = this.lefts.values().iterator();
                                while (it2.hasNext()) {
                                    try {
                                        interfaceC5102.onNext((Object) C4246.m13353(this.resultSelector.apply(it2.next(), objPoll), "The resultSelector returned a null value"));
                                    } catch (Throwable th3) {
                                        m6814(th3, interfaceC5102, dVar);
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            m6814(th4, interfaceC5102, dVar);
                            return;
                        }
                    } else if (num == f7397) {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) objPoll;
                        this.lefts.remove(Integer.valueOf(leftRightEndObserver3.index));
                        this.disposables.mo9334(leftRightEndObserver3);
                    } else {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver4 = (ObservableGroupJoin.LeftRightEndObserver) objPoll;
                        this.rights.remove(Integer.valueOf(leftRightEndObserver4.index));
                        this.disposables.mo9334(leftRightEndObserver4);
                    }
                }
            }
            dVar.clear();
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public void m6813(InterfaceC5102<?> interfaceC5102) {
            Throwable thM7021 = ExceptionHelper.m7021(this.error);
            this.lefts.clear();
            this.rights.clear();
            interfaceC5102.onError(thM7021);
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public void m6814(Throwable th, InterfaceC5102<?> interfaceC5102, d<?> dVar) {
            C4089.m13026(th);
            ExceptionHelper.m7020(this.error, th);
            dVar.clear();
            m6811();
            m6813(interfaceC5102);
        }
    }

    public ObservableJoin(InterfaceC2856<TLeft> interfaceC2856, InterfaceC2856<? extends TRight> interfaceC28562, InterfaceC2368<? super TLeft, ? extends InterfaceC2856<TLeftEnd>> interfaceC2368, InterfaceC2368<? super TRight, ? extends InterfaceC2856<TRightEnd>> interfaceC23682, InterfaceC5247<? super TLeft, ? super TRight, ? extends R> interfaceC5247) {
        super(interfaceC2856);
        this.f7391 = interfaceC28562;
        this.f7392 = interfaceC2368;
        this.f7393 = interfaceC23682;
        this.f7394 = interfaceC5247;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        JoinDisposable joinDisposable = new JoinDisposable(interfaceC5102, this.f7392, this.f7393, this.f7394);
        interfaceC5102.onSubscribe(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        joinDisposable.disposables.mo9333(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        joinDisposable.disposables.mo9333(leftRightObserver2);
        this.f11778.subscribe(leftRightObserver);
        this.f7391.subscribe(leftRightObserver2);
    }
}
