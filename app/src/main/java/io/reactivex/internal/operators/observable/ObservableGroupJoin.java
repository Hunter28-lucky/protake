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
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractC3414<TLeft, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<? extends TRight> f7373;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super TLeft, ? extends InterfaceC2856<TLeftEnd>> f7374;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC2368<? super TRight, ? extends InterfaceC2856<TRightEnd>> f7375;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC5247<? super TLeft, ? super AbstractC4262<TRight>, ? extends R> f7376;

    public static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements InterfaceC4478, InterfaceC2077 {
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final Integer f7377 = 1;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final Integer f7378 = 2;

        /* renamed from: ԭ, reason: contains not printable characters */
        public static final Integer f7379 = 3;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public static final Integer f7380 = 4;
        public volatile boolean cancelled;
        public final InterfaceC5102<? super R> downstream;
        public final InterfaceC2368<? super TLeft, ? extends InterfaceC2856<TLeftEnd>> leftEnd;
        public int leftIndex;
        public final InterfaceC5247<? super TLeft, ? super AbstractC4262<TRight>, ? extends R> resultSelector;
        public final InterfaceC2368<? super TRight, ? extends InterfaceC2856<TRightEnd>> rightEnd;
        public int rightIndex;
        public final C2527 disposables = new C2527();
        public final d<Object> queue = new d<>(AbstractC4262.bufferSize());
        public final Map<Integer, UnicastSubject<TRight>> lefts = new LinkedHashMap();
        public final Map<Integer, TRight> rights = new LinkedHashMap();
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final AtomicInteger active = new AtomicInteger(2);

        public GroupJoinDisposable(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super TLeft, ? extends InterfaceC2856<TLeftEnd>> interfaceC2368, InterfaceC2368<? super TRight, ? extends InterfaceC2856<TRightEnd>> interfaceC23682, InterfaceC5247<? super TLeft, ? super AbstractC4262<TRight>, ? extends R> interfaceC5247) {
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
            m6805();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.InterfaceC2077
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo6800(Throwable th) {
            if (!ExceptionHelper.m7020(this.error, th)) {
                C3671.m11803(th);
            } else {
                this.active.decrementAndGet();
                m6806();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.InterfaceC2077
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo6801(Throwable th) {
            if (ExceptionHelper.m7020(this.error, th)) {
                m6806();
            } else {
                C3671.m11803(th);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.InterfaceC2077
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo6802(boolean z, Object obj) {
            synchronized (this) {
                this.queue.m5884(z ? f7377 : f7378, obj);
            }
            m6806();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.InterfaceC2077
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo6803(boolean z, LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.queue.m5884(z ? f7379 : f7380, leftRightEndObserver);
            }
            m6806();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.InterfaceC2077
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo6804(LeftRightObserver leftRightObserver) {
            this.disposables.mo9335(leftRightObserver);
            this.active.decrementAndGet();
            m6806();
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6805() {
            this.disposables.dispose();
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public void m6806() {
            if (getAndIncrement() != 0) {
                return;
            }
            d<?> dVar = this.queue;
            InterfaceC5102<? super R> interfaceC5102 = this.downstream;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    dVar.clear();
                    m6805();
                    m6807(interfaceC5102);
                    return;
                }
                boolean z = this.active.get() == 0;
                Integer num = (Integer) dVar.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    Iterator<UnicastSubject<TRight>> it = this.lefts.values().iterator();
                    while (it.hasNext()) {
                        it.next().onComplete();
                    }
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
                    if (num == f7377) {
                        UnicastSubject unicastSubjectM7040 = UnicastSubject.m7040();
                        int i = this.leftIndex;
                        this.leftIndex = i + 1;
                        this.lefts.put(Integer.valueOf(i), unicastSubjectM7040);
                        try {
                            InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.leftEnd.apply(objPoll), "The leftEnd returned a null ObservableSource");
                            LeftRightEndObserver leftRightEndObserver = new LeftRightEndObserver(this, true, i);
                            this.disposables.mo9333(leftRightEndObserver);
                            interfaceC2856.subscribe(leftRightEndObserver);
                            if (this.error.get() != null) {
                                dVar.clear();
                                m6805();
                                m6807(interfaceC5102);
                                return;
                            } else {
                                try {
                                    interfaceC5102.onNext((Object) C4246.m13353(this.resultSelector.apply(objPoll, unicastSubjectM7040), "The resultSelector returned a null value"));
                                    Iterator<TRight> it2 = this.rights.values().iterator();
                                    while (it2.hasNext()) {
                                        unicastSubjectM7040.onNext(it2.next());
                                    }
                                } catch (Throwable th) {
                                    m6808(th, interfaceC5102, dVar);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            m6808(th2, interfaceC5102, dVar);
                            return;
                        }
                    } else if (num == f7378) {
                        int i2 = this.rightIndex;
                        this.rightIndex = i2 + 1;
                        this.rights.put(Integer.valueOf(i2), objPoll);
                        try {
                            InterfaceC2856 interfaceC28562 = (InterfaceC2856) C4246.m13353(this.rightEnd.apply(objPoll), "The rightEnd returned a null ObservableSource");
                            LeftRightEndObserver leftRightEndObserver2 = new LeftRightEndObserver(this, false, i2);
                            this.disposables.mo9333(leftRightEndObserver2);
                            interfaceC28562.subscribe(leftRightEndObserver2);
                            if (this.error.get() != null) {
                                dVar.clear();
                                m6805();
                                m6807(interfaceC5102);
                                return;
                            } else {
                                Iterator<UnicastSubject<TRight>> it3 = this.lefts.values().iterator();
                                while (it3.hasNext()) {
                                    it3.next().onNext(objPoll);
                                }
                            }
                        } catch (Throwable th3) {
                            m6808(th3, interfaceC5102, dVar);
                            return;
                        }
                    } else if (num == f7379) {
                        LeftRightEndObserver leftRightEndObserver3 = (LeftRightEndObserver) objPoll;
                        UnicastSubject<TRight> unicastSubjectRemove = this.lefts.remove(Integer.valueOf(leftRightEndObserver3.index));
                        this.disposables.mo9334(leftRightEndObserver3);
                        if (unicastSubjectRemove != null) {
                            unicastSubjectRemove.onComplete();
                        }
                    } else if (num == f7380) {
                        LeftRightEndObserver leftRightEndObserver4 = (LeftRightEndObserver) objPoll;
                        this.rights.remove(Integer.valueOf(leftRightEndObserver4.index));
                        this.disposables.mo9334(leftRightEndObserver4);
                    }
                }
            }
            dVar.clear();
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public void m6807(InterfaceC5102<?> interfaceC5102) {
            Throwable thM7021 = ExceptionHelper.m7021(this.error);
            Iterator<UnicastSubject<TRight>> it = this.lefts.values().iterator();
            while (it.hasNext()) {
                it.next().onError(thM7021);
            }
            this.lefts.clear();
            this.rights.clear();
            interfaceC5102.onError(thM7021);
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public void m6808(Throwable th, InterfaceC5102<?> interfaceC5102, d<?> dVar) {
            C4089.m13026(th);
            ExceptionHelper.m7020(this.error, th);
            dVar.clear();
            m6805();
            m6807(interfaceC5102);
        }
    }

    public static final class LeftRightEndObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5102<Object>, InterfaceC4478 {
        private static final long serialVersionUID = 1883890389173668373L;
        public final int index;
        public final boolean isLeft;
        public final InterfaceC2077 parent;

        public LeftRightEndObserver(InterfaceC2077 interfaceC2077, boolean z, int i) {
            this.parent = interfaceC2077;
            this.isLeft = z;
            this.index = i;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.parent.mo6803(this.isLeft, this);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.parent.mo6801(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(Object obj) {
            if (DisposableHelper.dispose(this)) {
                this.parent.mo6803(this.isLeft, this);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }
    }

    public static final class LeftRightObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5102<Object>, InterfaceC4478 {
        private static final long serialVersionUID = 1883890389173668373L;
        public final boolean isLeft;
        public final InterfaceC2077 parent;

        public LeftRightObserver(InterfaceC2077 interfaceC2077, boolean z) {
            this.parent = interfaceC2077;
            this.isLeft = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.parent.mo6804(this);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.parent.mo6800(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(Object obj) {
            this.parent.mo6802(this.isLeft, obj);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableGroupJoin$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2077 {
        /* renamed from: Ϳ */
        void mo6800(Throwable th);

        /* renamed from: Ԩ */
        void mo6801(Throwable th);

        /* renamed from: ԩ */
        void mo6802(boolean z, Object obj);

        /* renamed from: Ԫ */
        void mo6803(boolean z, LeftRightEndObserver leftRightEndObserver);

        /* renamed from: ԫ */
        void mo6804(LeftRightObserver leftRightObserver);
    }

    public ObservableGroupJoin(InterfaceC2856<TLeft> interfaceC2856, InterfaceC2856<? extends TRight> interfaceC28562, InterfaceC2368<? super TLeft, ? extends InterfaceC2856<TLeftEnd>> interfaceC2368, InterfaceC2368<? super TRight, ? extends InterfaceC2856<TRightEnd>> interfaceC23682, InterfaceC5247<? super TLeft, ? super AbstractC4262<TRight>, ? extends R> interfaceC5247) {
        super(interfaceC2856);
        this.f7373 = interfaceC28562;
        this.f7374 = interfaceC2368;
        this.f7375 = interfaceC23682;
        this.f7376 = interfaceC5247;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        GroupJoinDisposable groupJoinDisposable = new GroupJoinDisposable(interfaceC5102, this.f7374, this.f7375, this.f7376);
        interfaceC5102.onSubscribe(groupJoinDisposable);
        LeftRightObserver leftRightObserver = new LeftRightObserver(groupJoinDisposable, true);
        groupJoinDisposable.disposables.mo9333(leftRightObserver);
        LeftRightObserver leftRightObserver2 = new LeftRightObserver(groupJoinDisposable, false);
        groupJoinDisposable.disposables.mo9333(leftRightObserver2);
        this.f11778.subscribe(leftRightObserver);
        this.f7373.subscribe(leftRightObserver2);
    }
}
