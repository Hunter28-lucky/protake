package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC3164;
import defpackage.InterfaceC5102;
import defpackage.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableScalarXMap {

    public static final class ScalarDisposable<T> extends AtomicInteger implements InterfaceC3164<T>, Runnable {
        private static final long serialVersionUID = 3880992722410194083L;
        public final InterfaceC5102<? super T> observer;
        public final T value;

        public ScalarDisposable(InterfaceC5102<? super T> interfaceC5102, T t) {
            this.observer = interfaceC5102;
            this.value = t;
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            lazySet(3);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            set(3);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // defpackage.InterfaceC4851
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableScalarXMap$Ϳ, reason: contains not printable characters */
    public static final class C2091<T, R> extends AbstractC4262<R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final T f7465;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> f7466;

        public C2091(T t, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368) {
            this.f7465 = t;
            this.f7466 = interfaceC2368;
        }

        @Override // defpackage.AbstractC4262
        public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
            try {
                InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.f7466.apply(this.f7465), "The mapper returned a null ObservableSource");
                if (!(interfaceC2856 instanceof Callable)) {
                    interfaceC2856.subscribe(interfaceC5102);
                    return;
                }
                try {
                    Object objCall = ((Callable) interfaceC2856).call();
                    if (objCall == null) {
                        EmptyDisposable.complete(interfaceC5102);
                        return;
                    }
                    ScalarDisposable scalarDisposable = new ScalarDisposable(interfaceC5102, objCall);
                    interfaceC5102.onSubscribe(scalarDisposable);
                    scalarDisposable.run();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    EmptyDisposable.error(th, interfaceC5102);
                }
            } catch (Throwable th2) {
                EmptyDisposable.error(th2, interfaceC5102);
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T, U> AbstractC4262<U> m6894(T t, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> interfaceC2368) {
        return C3671.m11798(new C2091(t, interfaceC2368));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T, R> boolean m6895(InterfaceC2856<T> interfaceC2856, InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368) {
        if (!(interfaceC2856 instanceof Callable)) {
            return false;
        }
        try {
            a aVar = (Object) ((Callable) interfaceC2856).call();
            if (aVar == null) {
                EmptyDisposable.complete(interfaceC5102);
                return true;
            }
            try {
                InterfaceC2856 interfaceC28562 = (InterfaceC2856) C4246.m13353(interfaceC2368.apply(aVar), "The mapper returned a null ObservableSource");
                if (interfaceC28562 instanceof Callable) {
                    try {
                        Object objCall = ((Callable) interfaceC28562).call();
                        if (objCall == null) {
                            EmptyDisposable.complete(interfaceC5102);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(interfaceC5102, objCall);
                        interfaceC5102.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        EmptyDisposable.error(th, interfaceC5102);
                        return true;
                    }
                } else {
                    interfaceC28562.subscribe(interfaceC5102);
                }
                return true;
            } catch (Throwable th2) {
                C4089.m13026(th2);
                EmptyDisposable.error(th2, interfaceC5102);
                return true;
            }
        } catch (Throwable th3) {
            C4089.m13026(th3);
            EmptyDisposable.error(th3, interfaceC5102);
            return true;
        }
    }
}
