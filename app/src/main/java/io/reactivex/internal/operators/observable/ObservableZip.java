package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4262;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableZip<T, R> extends AbstractC4262<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<? extends T>[] f7555;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Iterable<? extends InterfaceC2856<? extends T>> f7556;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Object[], ? extends R> f7557;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7558;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean f7559;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements InterfaceC4478 {
        private static final long serialVersionUID = 2983708048395377667L;
        public volatile boolean cancelled;
        public final boolean delayError;
        public final InterfaceC5102<? super R> downstream;
        public final C2104<T, R>[] observers;
        public final T[] row;
        public final InterfaceC2368<? super Object[], ? extends R> zipper;

        public ZipCoordinator(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i, boolean z) {
            this.downstream = interfaceC5102;
            this.zipper = interfaceC2368;
            this.observers = new C2104[i];
            this.row = (T[]) new Object[i];
            this.delayError = z;
        }

        public void clear() {
            for (C2104<T, R> c2104 : this.observers) {
                c2104.f7561.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            m6940();
            if (getAndIncrement() == 0) {
                clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6939() {
            clear();
            m6940();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6940() {
            for (C2104<T, R> c2104 : this.observers) {
                c2104.m6944();
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public boolean m6941(boolean z, boolean z2, InterfaceC5102<? super R> interfaceC5102, boolean z3, C2104<?, ?> c2104) {
            if (this.cancelled) {
                m6939();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = c2104.f7563;
                this.cancelled = true;
                m6939();
                if (th != null) {
                    interfaceC5102.onError(th);
                } else {
                    interfaceC5102.onComplete();
                }
                return true;
            }
            Throwable th2 = c2104.f7563;
            if (th2 != null) {
                this.cancelled = true;
                m6939();
                interfaceC5102.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            this.cancelled = true;
            m6939();
            interfaceC5102.onComplete();
            return true;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6942() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            C2104<T, R>[] c2104Arr = this.observers;
            InterfaceC5102<? super R> interfaceC5102 = this.downstream;
            T[] tArr = this.row;
            boolean z = this.delayError;
            int iAddAndGet = 1;
            while (true) {
                int i = 0;
                int i2 = 0;
                for (C2104<T, R> c2104 : c2104Arr) {
                    if (tArr[i2] == null) {
                        boolean z2 = c2104.f7562;
                        T tPoll = c2104.f7561.poll();
                        boolean z3 = tPoll == null;
                        if (m6941(z2, z3, interfaceC5102, z, c2104)) {
                            return;
                        }
                        if (z3) {
                            i++;
                        } else {
                            tArr[i2] = tPoll;
                        }
                    } else if (c2104.f7562 && !z && (th = c2104.f7563) != null) {
                        this.cancelled = true;
                        m6939();
                        interfaceC5102.onError(th);
                        return;
                    }
                    i2++;
                }
                if (i != 0) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        interfaceC5102.onNext((Object) C4246.m13353(this.zipper.apply(tArr.clone()), "The zipper returned a null value"));
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        C4089.m13026(th2);
                        m6939();
                        interfaceC5102.onError(th2);
                        return;
                    }
                }
            }
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6943(InterfaceC2856<? extends T>[] interfaceC2856Arr, int i) {
            C2104<T, R>[] c2104Arr = this.observers;
            int length = c2104Arr.length;
            for (int i2 = 0; i2 < length; i2++) {
                c2104Arr[i2] = new C2104<>(this, i);
            }
            lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i3 = 0; i3 < length && !this.cancelled; i3++) {
                interfaceC2856Arr[i3].subscribe(c2104Arr[i3]);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableZip$Ϳ, reason: contains not printable characters */
    public static final class C2104<T, R> implements InterfaceC5102<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final ZipCoordinator<T, R> f7560;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final d<T> f7561;

        /* renamed from: ԭ, reason: contains not printable characters */
        public volatile boolean f7562;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public Throwable f7563;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final AtomicReference<InterfaceC4478> f7564 = new AtomicReference<>();

        public C2104(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.f7560 = zipCoordinator;
            this.f7561 = new d<>(i);
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f7562 = true;
            this.f7560.m6942();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f7563 = th;
            this.f7562 = true;
            this.f7560.m6942();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f7561.offer(t);
            this.f7560.m6942();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.f7564, interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6944() {
            DisposableHelper.dispose(this.f7564);
        }
    }

    public ObservableZip(InterfaceC2856<? extends T>[] interfaceC2856Arr, Iterable<? extends InterfaceC2856<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i, boolean z) {
        this.f7555 = interfaceC2856Arr;
        this.f7556 = iterable;
        this.f7557 = interfaceC2368;
        this.f7558 = i;
        this.f7559 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        int length;
        InterfaceC2856<? extends T>[] interfaceC2856Arr = this.f7555;
        if (interfaceC2856Arr == null) {
            interfaceC2856Arr = new InterfaceC2856[8];
            length = 0;
            for (InterfaceC2856<? extends T> interfaceC2856 : this.f7556) {
                if (length == interfaceC2856Arr.length) {
                    InterfaceC2856<? extends T>[] interfaceC2856Arr2 = new InterfaceC2856[(length >> 2) + length];
                    System.arraycopy(interfaceC2856Arr, 0, interfaceC2856Arr2, 0, length);
                    interfaceC2856Arr = interfaceC2856Arr2;
                }
                interfaceC2856Arr[length] = interfaceC2856;
                length++;
            }
        } else {
            length = interfaceC2856Arr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(interfaceC5102);
        } else {
            new ZipCoordinator(interfaceC5102, this.f7557, length, this.f7559).m6943(interfaceC2856Arr, this.f7558);
        }
    }
}
