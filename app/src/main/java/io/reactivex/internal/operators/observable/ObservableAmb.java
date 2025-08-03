package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableAmb<T> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<? extends T>[] f7294;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Iterable<? extends InterfaceC2856<? extends T>> f7295;

    public static final class AmbInnerObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        public final InterfaceC5102<? super T> downstream;
        public final int index;
        public final C2072<T> parent;
        public boolean won;

        public AmbInnerObserver(C2072<T> c2072, int i, InterfaceC5102<? super T> interfaceC5102) {
            this.parent = c2072;
            this.index = i;
            this.downstream = interfaceC5102;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (this.parent.m6732(this.index)) {
                this.won = true;
                this.downstream.onComplete();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.won) {
                this.downstream.onError(th);
            } else if (!this.parent.m6732(this.index)) {
                C3671.m11803(th);
            } else {
                this.won = true;
                this.downstream.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.won) {
                this.downstream.onNext(t);
            } else if (!this.parent.m6732(this.index)) {
                get().dispose();
            } else {
                this.won = true;
                this.downstream.onNext(t);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6730() {
            DisposableHelper.dispose(this);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableAmb$Ϳ, reason: contains not printable characters */
    public static final class C2072<T> implements InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f7296;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AmbInnerObserver<T>[] f7297;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final AtomicInteger f7298 = new AtomicInteger();

        public C2072(InterfaceC5102<? super T> interfaceC5102, int i) {
            this.f7296 = interfaceC5102;
            this.f7297 = new AmbInnerObserver[i];
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.f7298.get() != -1) {
                this.f7298.lazySet(-1);
                for (AmbInnerObserver<T> ambInnerObserver : this.f7297) {
                    ambInnerObserver.m6730();
                }
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f7298.get() == -1;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6731(InterfaceC2856<? extends T>[] interfaceC2856Arr) {
            AmbInnerObserver<T>[] ambInnerObserverArr = this.f7297;
            int length = ambInnerObserverArr.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                ambInnerObserverArr[i] = new AmbInnerObserver<>(this, i2, this.f7296);
                i = i2;
            }
            this.f7298.lazySet(0);
            this.f7296.onSubscribe(this);
            for (int i3 = 0; i3 < length && this.f7298.get() == 0; i3++) {
                interfaceC2856Arr[i3].subscribe(ambInnerObserverArr[i3]);
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean m6732(int i) {
            int i2 = this.f7298.get();
            int i3 = 0;
            if (i2 != 0) {
                return i2 == i;
            }
            if (!this.f7298.compareAndSet(0, i)) {
                return false;
            }
            AmbInnerObserver<T>[] ambInnerObserverArr = this.f7297;
            int length = ambInnerObserverArr.length;
            while (i3 < length) {
                int i4 = i3 + 1;
                if (i4 != i) {
                    ambInnerObserverArr[i3].m6730();
                }
                i3 = i4;
            }
            return true;
        }
    }

    public ObservableAmb(InterfaceC2856<? extends T>[] interfaceC2856Arr, Iterable<? extends InterfaceC2856<? extends T>> iterable) {
        this.f7294 = interfaceC2856Arr;
        this.f7295 = iterable;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        int length;
        InterfaceC2856<? extends T>[] interfaceC2856Arr = this.f7294;
        if (interfaceC2856Arr == null) {
            interfaceC2856Arr = new InterfaceC2856[8];
            try {
                length = 0;
                for (InterfaceC2856<? extends T> interfaceC2856 : this.f7295) {
                    if (interfaceC2856 == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), interfaceC5102);
                        return;
                    }
                    if (length == interfaceC2856Arr.length) {
                        InterfaceC2856<? extends T>[] interfaceC2856Arr2 = new InterfaceC2856[(length >> 2) + length];
                        System.arraycopy(interfaceC2856Arr, 0, interfaceC2856Arr2, 0, length);
                        interfaceC2856Arr = interfaceC2856Arr2;
                    }
                    int i = length + 1;
                    interfaceC2856Arr[length] = interfaceC2856;
                    length = i;
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                EmptyDisposable.error(th, interfaceC5102);
                return;
            }
        } else {
            length = interfaceC2856Arr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(interfaceC5102);
        } else if (length == 1) {
            interfaceC2856Arr[0].subscribe(interfaceC5102);
        } else {
            new C2072(interfaceC5102, length).m6731(interfaceC2856Arr);
        }
    }
}
