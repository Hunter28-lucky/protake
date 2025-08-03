package io.reactivex.internal.operators.single;

import defpackage.AbstractC4838;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleUsing<T, U> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<U> f7628;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super U, ? extends InterfaceC3951<? extends T>> f7629;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super U> f7630;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean f7631;

    public static final class UsingSingleObserver<T, U> extends AtomicReference<Object> implements InterfaceC4782<T>, InterfaceC4478 {
        private static final long serialVersionUID = -5331524057054083935L;
        public final InterfaceC2857<? super U> disposer;
        public final InterfaceC4782<? super T> downstream;
        public final boolean eager;
        public InterfaceC4478 upstream;

        public UsingSingleObserver(InterfaceC4782<? super T> interfaceC4782, U u, boolean z, InterfaceC2857<? super U> interfaceC2857) {
            super(u);
            this.downstream = interfaceC4782;
            this.eager = z;
            this.disposer = interfaceC2857;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            m6964();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.downstream.onError(th);
            if (this.eager) {
                return;
            }
            m6964();
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.downstream.onError(th);
                    return;
                }
            }
            this.downstream.onSuccess(t);
            if (this.eager) {
                return;
            }
            m6964();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6964() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    C4089.m13026(th);
                    C3671.m11803(th);
                }
            }
        }
    }

    public SingleUsing(Callable<U> callable, InterfaceC2368<? super U, ? extends InterfaceC3951<? extends T>> interfaceC2368, InterfaceC2857<? super U> interfaceC2857, boolean z) {
        this.f7628 = callable;
        this.f7629 = interfaceC2368;
        this.f7630 = interfaceC2857;
        this.f7631 = z;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        try {
            U uCall = this.f7628.call();
            try {
                ((InterfaceC3951) C4246.m13353(this.f7629.apply(uCall), "The singleFunction returned a null SingleSource")).subscribe(new UsingSingleObserver(interfaceC4782, uCall, this.f7631, this.f7630));
            } catch (Throwable th) {
                th = th;
                C4089.m13026(th);
                if (this.f7631) {
                    try {
                        this.f7630.accept(uCall);
                    } catch (Throwable th2) {
                        C4089.m13026(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                EmptyDisposable.error(th, interfaceC4782);
                if (this.f7631) {
                    return;
                }
                try {
                    this.f7630.accept(uCall);
                } catch (Throwable th3) {
                    C4089.m13026(th3);
                    C3671.m11803(th3);
                }
            }
        } catch (Throwable th4) {
            C4089.m13026(th4);
            EmptyDisposable.error(th4, interfaceC4782);
        }
    }
}
