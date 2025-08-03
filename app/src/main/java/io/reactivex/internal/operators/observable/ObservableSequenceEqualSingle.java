package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4262;
import defpackage.AbstractC4838;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC2325;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5324;
import defpackage.d;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableSequenceEqualSingle<T> extends AbstractC4838<Boolean> implements InterfaceC2325<Boolean> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<? extends T> f7476;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<? extends T> f7477;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5324<? super T, ? super T> f7478;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7479;

    public static final class EqualCoordinator<T> extends AtomicInteger implements InterfaceC4478 {
        private static final long serialVersionUID = -6178010334400373240L;
        public volatile boolean cancelled;
        public final InterfaceC5324<? super T, ? super T> comparer;
        public final InterfaceC4782<? super Boolean> downstream;
        public final InterfaceC2856<? extends T> first;
        public final C2093<T>[] observers;
        public final ArrayCompositeDisposable resources = new ArrayCompositeDisposable(2);
        public final InterfaceC2856<? extends T> second;
        public T v1;
        public T v2;

        public EqualCoordinator(InterfaceC4782<? super Boolean> interfaceC4782, int i, InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562, InterfaceC5324<? super T, ? super T> interfaceC5324) {
            this.downstream = interfaceC4782;
            this.first = interfaceC2856;
            this.second = interfaceC28562;
            this.comparer = interfaceC5324;
            this.observers = new C2093[]{new C2093<>(this, 0, i), new C2093<>(this, 1, i)};
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.resources.dispose();
            if (getAndIncrement() == 0) {
                C2093<T>[] c2093Arr = this.observers;
                c2093Arr[0].f7481.clear();
                c2093Arr[1].f7481.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6900(d<T> dVar, d<T> dVar2) {
            this.cancelled = true;
            dVar.clear();
            dVar2.clear();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6901() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            C2093<T>[] c2093Arr = this.observers;
            C2093<T> c2093 = c2093Arr[0];
            d<T> dVar = c2093.f7481;
            C2093<T> c20932 = c2093Arr[1];
            d<T> dVar2 = c20932.f7481;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = c2093.f7483;
                if (z && (th2 = c2093.f7484) != null) {
                    m6900(dVar, dVar2);
                    this.downstream.onError(th2);
                    return;
                }
                boolean z2 = c20932.f7483;
                if (z2 && (th = c20932.f7484) != null) {
                    m6900(dVar, dVar2);
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
                    this.downstream.onSuccess(Boolean.TRUE);
                    return;
                }
                if (z && z2 && z3 != z4) {
                    m6900(dVar, dVar2);
                    this.downstream.onSuccess(Boolean.FALSE);
                    return;
                }
                if (!z3 && !z4) {
                    try {
                        if (!this.comparer.test(this.v1, t)) {
                            m6900(dVar, dVar2);
                            this.downstream.onSuccess(Boolean.FALSE);
                            return;
                        } else {
                            this.v1 = null;
                            this.v2 = null;
                        }
                    } catch (Throwable th3) {
                        C4089.m13026(th3);
                        m6900(dVar, dVar2);
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
        public boolean m6902(InterfaceC4478 interfaceC4478, int i) {
            return this.resources.m6309(i, interfaceC4478);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6903() {
            C2093<T>[] c2093Arr = this.observers;
            this.first.subscribe(c2093Arr[0]);
            this.second.subscribe(c2093Arr[1]);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle$Ϳ, reason: contains not printable characters */
    public static final class C2093<T> implements InterfaceC5102<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final EqualCoordinator<T> f7480;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final d<T> f7481;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final int f7482;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public volatile boolean f7483;

        /* renamed from: ԯ, reason: contains not printable characters */
        public Throwable f7484;

        public C2093(EqualCoordinator<T> equalCoordinator, int i, int i2) {
            this.f7480 = equalCoordinator;
            this.f7482 = i;
            this.f7481 = new d<>(i2);
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f7483 = true;
            this.f7480.m6901();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f7484 = th;
            this.f7483 = true;
            this.f7480.m6901();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f7481.offer(t);
            this.f7480.m6901();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f7480.m6902(interfaceC4478, this.f7482);
        }
    }

    public ObservableSequenceEqualSingle(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562, InterfaceC5324<? super T, ? super T> interfaceC5324, int i) {
        this.f7476 = interfaceC2856;
        this.f7477 = interfaceC28562;
        this.f7478 = interfaceC5324;
        this.f7479 = i;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super Boolean> interfaceC4782) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(interfaceC4782, this.f7479, this.f7476, this.f7477, this.f7478);
        interfaceC4782.onSubscribe(equalCoordinator);
        equalCoordinator.m6903();
    }

    @Override // defpackage.InterfaceC2325
    /* renamed from: Ϳ */
    public AbstractC4262<Boolean> mo6779() {
        return C3671.m11798(new ObservableSequenceEqual(this.f7476, this.f7477, this.f7478, this.f7479));
    }
}
