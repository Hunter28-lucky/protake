package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4113;
import defpackage.C4217;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public final class ObservableWithLatestFromMany<T, R> extends AbstractC3414<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<?>[] f7551;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Iterable<? extends InterfaceC2856<?>> f7552;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC2368<? super Object[], R> f7553;

    public static final class WithLatestFromObserver<T, R> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = 1577321883966341961L;
        public final InterfaceC2368<? super Object[], R> combiner;
        public volatile boolean done;
        public final InterfaceC5102<? super R> downstream;
        public final AtomicThrowable error;
        public final WithLatestInnerObserver[] observers;
        public final AtomicReference<InterfaceC4478> upstream;
        public final AtomicReferenceArray<Object> values;

        public WithLatestFromObserver(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super Object[], R> interfaceC2368, int i) {
            this.downstream = interfaceC5102;
            this.combiner = interfaceC2368;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i];
            for (int i2 = 0; i2 < i; i2++) {
                withLatestInnerObserverArr[i2] = new WithLatestInnerObserver(this, i2);
            }
            this.observers = withLatestInnerObserverArr;
            this.values = new AtomicReferenceArray<>(i);
            this.upstream = new AtomicReference<>();
            this.error = new AtomicThrowable();
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            for (WithLatestInnerObserver withLatestInnerObserver : this.observers) {
                withLatestInnerObserver.m6938();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            m6933(-1);
            C4217.m13296(this.downstream, this, this.error);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.done = true;
            m6933(-1);
            C4217.m13298(this.downstream, th, this, this.error);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i = 0;
            objArr[0] = t;
            while (i < length) {
                Object obj = atomicReferenceArray.get(i);
                if (obj == null) {
                    return;
                }
                i++;
                objArr[i] = obj;
            }
            try {
                C4217.m13300(this.downstream, C4246.m13353(this.combiner.apply(objArr), "combiner returned a null value"), this, this.error);
            } catch (Throwable th) {
                C4089.m13026(th);
                dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.upstream, interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6933(int i) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            for (int i2 = 0; i2 < withLatestInnerObserverArr.length; i2++) {
                if (i2 != i) {
                    withLatestInnerObserverArr[i2].m6938();
                }
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6934(int i, boolean z) {
            if (z) {
                return;
            }
            this.done = true;
            m6933(i);
            C4217.m13296(this.downstream, this, this.error);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6935(int i, Throwable th) {
            this.done = true;
            DisposableHelper.dispose(this.upstream);
            m6933(i);
            C4217.m13298(this.downstream, th, this, this.error);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6936(int i, Object obj) {
            this.values.set(i, obj);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6937(InterfaceC2856<?>[] interfaceC2856Arr, int i) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            AtomicReference<InterfaceC4478> atomicReference = this.upstream;
            for (int i2 = 0; i2 < i && !DisposableHelper.isDisposed(atomicReference.get()) && !this.done; i2++) {
                interfaceC2856Arr[i2].subscribe(withLatestInnerObserverArr[i2]);
            }
        }
    }

    public static final class WithLatestInnerObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5102<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        public boolean hasValue;
        public final int index;
        public final WithLatestFromObserver<?, ?> parent;

        public WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i) {
            this.parent = withLatestFromObserver;
            this.index = i;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.parent.m6934(this.index, this.hasValue);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.parent.m6935(this.index, th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.m6936(this.index, obj);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6938() {
            DisposableHelper.dispose(this);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableWithLatestFromMany$Ϳ, reason: contains not printable characters */
    public final class C2103 implements InterfaceC2368<T, R> {
        public C2103() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // defpackage.InterfaceC2368
        public R apply(T t) throws Exception {
            return (R) C4246.m13353(ObservableWithLatestFromMany.this.f7553.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }

    public ObservableWithLatestFromMany(InterfaceC2856<T> interfaceC2856, InterfaceC2856<?>[] interfaceC2856Arr, InterfaceC2368<? super Object[], R> interfaceC2368) {
        super(interfaceC2856);
        this.f7551 = interfaceC2856Arr;
        this.f7552 = null;
        this.f7553 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        int length;
        InterfaceC2856<?>[] interfaceC2856Arr = this.f7551;
        if (interfaceC2856Arr == null) {
            interfaceC2856Arr = new InterfaceC2856[8];
            try {
                length = 0;
                for (InterfaceC2856<?> interfaceC2856 : this.f7552) {
                    if (length == interfaceC2856Arr.length) {
                        interfaceC2856Arr = (InterfaceC2856[]) Arrays.copyOf(interfaceC2856Arr, (length >> 1) + length);
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
            new C4113(this.f11778, new C2103()).subscribeActual(interfaceC5102);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(interfaceC5102, this.f7553, length);
        interfaceC5102.onSubscribe(withLatestFromObserver);
        withLatestFromObserver.m6937(interfaceC2856Arr, length);
        this.f11778.subscribe(withLatestFromObserver);
    }

    public ObservableWithLatestFromMany(InterfaceC2856<T> interfaceC2856, Iterable<? extends InterfaceC2856<?>> iterable, InterfaceC2368<? super Object[], R> interfaceC2368) {
        super(interfaceC2856);
        this.f7551 = null;
        this.f7552 = iterable;
        this.f7553 = interfaceC2368;
    }
}
