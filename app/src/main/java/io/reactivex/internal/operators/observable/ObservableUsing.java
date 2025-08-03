package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class ObservableUsing<T, D> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<? extends D> f7529;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super D, ? extends InterfaceC2856<? extends T>> f7530;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super D> f7531;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean f7532;

    public static final class UsingObserver<T, D> extends AtomicBoolean implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = 5904473792286235046L;
        public final InterfaceC2857<? super D> disposer;
        public final InterfaceC5102<? super T> downstream;
        public final boolean eager;
        public final D resource;
        public InterfaceC4478 upstream;

        public UsingObserver(InterfaceC5102<? super T> interfaceC5102, D d, InterfaceC2857<? super D> interfaceC2857, boolean z) {
            this.downstream = interfaceC5102;
            this.resource = d;
            this.disposer = interfaceC2857;
            this.eager = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            m6921();
            this.upstream.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (!this.eager) {
                this.downstream.onComplete();
                this.upstream.dispose();
                m6921();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.downstream.onError(th);
                    return;
                }
            }
            this.upstream.dispose();
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (!this.eager) {
                this.downstream.onError(th);
                this.upstream.dispose();
                m6921();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.upstream.dispose();
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6921() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    C4089.m13026(th);
                    C3671.m11803(th);
                }
            }
        }
    }

    public ObservableUsing(Callable<? extends D> callable, InterfaceC2368<? super D, ? extends InterfaceC2856<? extends T>> interfaceC2368, InterfaceC2857<? super D> interfaceC2857, boolean z) {
        this.f7529 = callable;
        this.f7530 = interfaceC2368;
        this.f7531 = interfaceC2857;
        this.f7532 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        try {
            D dCall = this.f7529.call();
            try {
                ((InterfaceC2856) C4246.m13353(this.f7530.apply(dCall), "The sourceSupplier returned a null ObservableSource")).subscribe(new UsingObserver(interfaceC5102, dCall, this.f7531, this.f7532));
            } catch (Throwable th) {
                C4089.m13026(th);
                try {
                    this.f7531.accept(dCall);
                    EmptyDisposable.error(th, interfaceC5102);
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    EmptyDisposable.error(new CompositeException(th, th2), interfaceC5102);
                }
            }
        } catch (Throwable th3) {
            C4089.m13026(th3);
            EmptyDisposable.error(th3, interfaceC5102);
        }
    }
}
