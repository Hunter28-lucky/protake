package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4262;
import defpackage.C4089;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5324;
import defpackage.d;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableSequenceEqual<T> extends AbstractC4262<Boolean> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<? extends T> f7467;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<? extends T> f7468;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5324<? super T, ? super T> f7469;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7470;

    public static final class EqualCoordinator<T> extends AtomicInteger implements InterfaceC4478 {
        private static final long serialVersionUID = -6178010334400373240L;
        public volatile boolean cancelled;
        public final InterfaceC5324<? super T, ? super T> comparer;
        public final InterfaceC5102<? super Boolean> downstream;
        public final InterfaceC2856<? extends T> first;
        public final C2092<T>[] observers;
        public final ArrayCompositeDisposable resources = new ArrayCompositeDisposable(2);
        public final InterfaceC2856<? extends T> second;
        public T v1;
        public T v2;

        public EqualCoordinator(InterfaceC5102<? super Boolean> interfaceC5102, int i, InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562, InterfaceC5324<? super T, ? super T> interfaceC5324) {
            this.downstream = interfaceC5102;
            this.first = interfaceC2856;
            this.second = interfaceC28562;
            this.comparer = interfaceC5324;
            this.observers = new C2092[]{new C2092<>(this, 0, i), new C2092<>(this, 1, i)};
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.resources.dispose();
            if (getAndIncrement() == 0) {
                C2092<T>[] c2092Arr = this.observers;
                c2092Arr[0].f7472.clear();
                c2092Arr[1].f7472.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6896(d<T> dVar, d<T> dVar2) {
            this.cancelled = true;
            dVar.clear();
            dVar2.clear();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6897() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            C2092<T>[] c2092Arr = this.observers;
            C2092<T> c2092 = c2092Arr[0];
            d<T> dVar = c2092.f7472;
            C2092<T> c20922 = c2092Arr[1];
            d<T> dVar2 = c20922.f7472;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = c2092.f7474;
                if (z && (th2 = c2092.f7475) != null) {
                    m6896(dVar, dVar2);
                    this.downstream.onError(th2);
                    return;
                }
                boolean z2 = c20922.f7474;
                if (z2 && (th = c20922.f7475) != null) {
                    m6896(dVar, dVar2);
                    this.downstream.onError(th);
                    return;
                }
                if (this.v1 == null) {
                    this.v1 = dVar.poll();
                }
                boolean z3 = this.v1 == null;
                if (this.v2 == null) {
                    this.v2 = dVar2.poll();
                }
                T t = this.v2;
                boolean z4 = t == null;
                if (z && z2 && z3 && z4) {
                    this.downstream.onNext(Boolean.TRUE);
                    this.downstream.onComplete();
                    return;
                }
                if (z && z2 && z3 != z4) {
                    m6896(dVar, dVar2);
                    this.downstream.onNext(Boolean.FALSE);
                    this.downstream.onComplete();
                    return;
                }
                if (!z3 && !z4) {
                    try {
                        if (!this.comparer.test(this.v1, t)) {
                            m6896(dVar, dVar2);
                            this.downstream.onNext(Boolean.FALSE);
                            this.downstream.onComplete();
                            return;
                        }
                        this.v1 = null;
                        this.v2 = null;
                    } catch (Throwable th3) {
                        C4089.m13026(th3);
                        m6896(dVar, dVar2);
                        this.downstream.onError(th3);
                        return;
                    }
                }
                if (z3 || z4) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            dVar.clear();
            dVar2.clear();
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public boolean m6898(InterfaceC4478 interfaceC4478, int i) {
            return this.resources.m6309(i, interfaceC4478);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6899() {
            C2092<T>[] c2092Arr = this.observers;
            this.first.subscribe(c2092Arr[0]);
            this.second.subscribe(c2092Arr[1]);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableSequenceEqual$Ϳ, reason: contains not printable characters */
    public static final class C2092<T> implements InterfaceC5102<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final EqualCoordinator<T> f7471;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final d<T> f7472;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final int f7473;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public volatile boolean f7474;

        /* renamed from: ԯ, reason: contains not printable characters */
        public Throwable f7475;

        public C2092(EqualCoordinator<T> equalCoordinator, int i, int i2) {
            this.f7471 = equalCoordinator;
            this.f7473 = i;
            this.f7472 = new d<>(i2);
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f7474 = true;
            this.f7471.m6897();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f7475 = th;
            this.f7474 = true;
            this.f7471.m6897();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f7472.offer(t);
            this.f7471.m6897();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f7471.m6898(interfaceC4478, this.f7473);
        }
    }

    public ObservableSequenceEqual(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562, InterfaceC5324<? super T, ? super T> interfaceC5324, int i) {
        this.f7467 = interfaceC2856;
        this.f7468 = interfaceC28562;
        this.f7469 = interfaceC5324;
        this.f7470 = i;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super Boolean> interfaceC5102) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(interfaceC5102, this.f7470, this.f7467, this.f7468, this.f7469);
        interfaceC5102.onSubscribe(equalCoordinator);
        equalCoordinator.m6899();
    }
}
