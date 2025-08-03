package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWindowBoundarySelector.java */
/* renamed from: ჸ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5314<T, B, V> extends AbstractC3414<T, AbstractC4262<T>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<B> f17582;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super B, ? extends InterfaceC2856<V>> f17583;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f17584;

    /* compiled from: ObservableWindowBoundarySelector.java */
    /* renamed from: ჸ$Ϳ, reason: contains not printable characters */
    public static final class C5315<T, V> extends AbstractC5105<V> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C5317<T, ?, V> f17585;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final UnicastSubject<T> f17586;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f17587;

        public C5315(C5317<T, ?, V> c5317, UnicastSubject<T> unicastSubject) {
            this.f17585 = c5317;
            this.f17586 = unicastSubject;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f17587) {
                return;
            }
            this.f17587 = true;
            this.f17585.m15366(this);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f17587) {
                C3671.m11803(th);
            } else {
                this.f17587 = true;
                this.f17585.m15369(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(V v) {
            dispose();
            onComplete();
        }
    }

    /* compiled from: ObservableWindowBoundarySelector.java */
    /* renamed from: ჸ$Ԩ, reason: contains not printable characters */
    public static final class C5316<T, B> extends AbstractC5105<B> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C5317<T, B, ?> f17588;

        public C5316(C5317<T, B, ?> c5317) {
            this.f17588 = c5317;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f17588.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f17588.m15369(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(B b) {
            this.f17588.m15370(b);
        }
    }

    /* compiled from: ObservableWindowBoundarySelector.java */
    /* renamed from: ჸ$Ԫ, reason: contains not printable characters */
    public static final class C5317<T, B, V> extends AbstractC4701<T, Object, AbstractC4262<T>> implements InterfaceC4478 {

        /* renamed from: ֈ, reason: contains not printable characters */
        public final InterfaceC2856<B> f17589;

        /* renamed from: ֏, reason: contains not printable characters */
        public final InterfaceC2368<? super B, ? extends InterfaceC2856<V>> f17590;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final int f17591;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final C2527 f17592;

        /* renamed from: ހ, reason: contains not printable characters */
        public InterfaceC4478 f17593;

        /* renamed from: ށ, reason: contains not printable characters */
        public final AtomicReference<InterfaceC4478> f17594;

        /* renamed from: ނ, reason: contains not printable characters */
        public final List<UnicastSubject<T>> f17595;

        /* renamed from: ރ, reason: contains not printable characters */
        public final AtomicLong f17596;

        /* renamed from: ބ, reason: contains not printable characters */
        public final AtomicBoolean f17597;

        public C5317(InterfaceC5102<? super AbstractC4262<T>> interfaceC5102, InterfaceC2856<B> interfaceC2856, InterfaceC2368<? super B, ? extends InterfaceC2856<V>> interfaceC2368, int i) {
            super(interfaceC5102, new MpscLinkedQueue());
            this.f17594 = new AtomicReference<>();
            AtomicLong atomicLong = new AtomicLong();
            this.f17596 = atomicLong;
            this.f17597 = new AtomicBoolean();
            this.f17589 = interfaceC2856;
            this.f17590 = interfaceC2368;
            this.f17591 = i;
            this.f17592 = new C2527();
            this.f17595 = new ArrayList();
            atomicLong.lazySet(1L);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.f17597.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.f17594);
                if (this.f17596.decrementAndGet() == 0) {
                    this.f17593.dispose();
                }
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f17597.get();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f15961) {
                return;
            }
            this.f15961 = true;
            if (m14234()) {
                m15368();
            }
            if (this.f17596.decrementAndGet() == 0) {
                this.f17592.dispose();
            }
            this.f15958.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f15961) {
                C3671.m11803(th);
                return;
            }
            this.f15962 = th;
            this.f15961 = true;
            if (m14234()) {
                m15368();
            }
            if (this.f17596.decrementAndGet() == 0) {
                this.f17592.dispose();
            }
            this.f15958.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (m14235()) {
                Iterator<UnicastSubject<T>> it = this.f17595.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (mo11502(-1) == 0) {
                    return;
                }
            } else {
                this.f15959.offer(NotificationLite.next(t));
                if (!m14234()) {
                    return;
                }
            }
            m15368();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f17593, interfaceC4478)) {
                this.f17593 = interfaceC4478;
                this.f15958.onSubscribe(this);
                if (this.f17597.get()) {
                    return;
                }
                C5316 c5316 = new C5316(this);
                if (C4905.m14631(this.f17594, null, c5316)) {
                    this.f17589.subscribe(c5316);
                }
            }
        }

        @Override // defpackage.AbstractC4701, defpackage.InterfaceC3556
        /* renamed from: ԫ */
        public void mo10684(InterfaceC5102<? super AbstractC4262<T>> interfaceC5102, Object obj) {
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public void m15366(C5315<T, V> c5315) {
            this.f17592.mo9335(c5315);
            this.f15959.offer(new C5318(c5315.f17586, null));
            if (m14234()) {
                m15368();
            }
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public void m15367() {
            this.f17592.dispose();
            DisposableHelper.dispose(this.f17594);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: ֏, reason: contains not printable characters */
        public void m15368() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f15959;
            InterfaceC5102<? super V> interfaceC5102 = this.f15958;
            List<UnicastSubject<T>> list = this.f17595;
            int iMo11502 = 1;
            while (true) {
                boolean z = this.f15961;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    m15367();
                    Throwable th = this.f15962;
                    if (th != null) {
                        Iterator<UnicastSubject<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastSubject<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z2) {
                    iMo11502 = mo11502(-iMo11502);
                    if (iMo11502 == 0) {
                        return;
                    }
                } else if (objPoll instanceof C5318) {
                    C5318 c5318 = (C5318) objPoll;
                    UnicastSubject<T> unicastSubject = c5318.f17598;
                    if (unicastSubject != null) {
                        if (list.remove(unicastSubject)) {
                            c5318.f17598.onComplete();
                            if (this.f17596.decrementAndGet() == 0) {
                                m15367();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f17597.get()) {
                        UnicastSubject<T> unicastSubjectM7041 = UnicastSubject.m7041(this.f17591);
                        list.add(unicastSubjectM7041);
                        interfaceC5102.onNext(unicastSubjectM7041);
                        try {
                            InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.f17590.apply(c5318.f17599), "The ObservableSource supplied is null");
                            C5315 c5315 = new C5315(this, unicastSubjectM7041);
                            if (this.f17592.mo9333(c5315)) {
                                this.f17596.getAndIncrement();
                                interfaceC2856.subscribe(c5315);
                            }
                        } catch (Throwable th2) {
                            C4089.m13026(th2);
                            this.f17597.set(true);
                            interfaceC5102.onError(th2);
                        }
                    }
                } else {
                    Iterator<UnicastSubject<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(NotificationLite.getValue(objPoll));
                    }
                }
            }
        }

        /* renamed from: ׯ, reason: contains not printable characters */
        public void m15369(Throwable th) {
            this.f17593.dispose();
            this.f17592.dispose();
            onError(th);
        }

        /* renamed from: ؠ, reason: contains not printable characters */
        public void m15370(B b) {
            this.f15959.offer(new C5318(null, b));
            if (m14234()) {
                m15368();
            }
        }
    }

    /* compiled from: ObservableWindowBoundarySelector.java */
    /* renamed from: ჸ$Ԭ, reason: contains not printable characters */
    public static final class C5318<T, B> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final UnicastSubject<T> f17598;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final B f17599;

        public C5318(UnicastSubject<T> unicastSubject, B b) {
            this.f17598 = unicastSubject;
            this.f17599 = b;
        }
    }

    public C5314(InterfaceC2856<T> interfaceC2856, InterfaceC2856<B> interfaceC28562, InterfaceC2368<? super B, ? extends InterfaceC2856<V>> interfaceC2368, int i) {
        super(interfaceC2856);
        this.f17582 = interfaceC28562;
        this.f17583 = interfaceC2368;
        this.f17584 = i;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super AbstractC4262<T>> interfaceC5102) {
        this.f11778.subscribe(new C5317(new C5312(interfaceC5102), this.f17582, this.f17583, this.f17584));
    }
}
