package io.reactivex.internal.operators.single;

import defpackage.AbstractC4838;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class SingleDoFinally<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f7582;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3809 f7583;

    public static final class DoFinallyObserver<T> extends AtomicInteger implements InterfaceC4782<T>, InterfaceC4478 {
        private static final long serialVersionUID = 4109457741734051389L;
        public final InterfaceC4782<? super T> downstream;
        public final InterfaceC3809 onFinally;
        public InterfaceC4478 upstream;

        public DoFinallyObserver(InterfaceC4782<? super T> interfaceC4782, InterfaceC3809 interfaceC3809) {
            this.downstream = interfaceC4782;
            this.onFinally = interfaceC3809;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.upstream.dispose();
            m6951();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.downstream.onError(th);
            m6951();
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
            this.downstream.onSuccess(t);
            m6951();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6951() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    C3671.m11803(th);
                }
            }
        }
    }

    public SingleDoFinally(InterfaceC3951<T> interfaceC3951, InterfaceC3809 interfaceC3809) {
        this.f7582 = interfaceC3951;
        this.f7583 = interfaceC3809;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f7582.subscribe(new DoFinallyObserver(interfaceC4782, this.f7583));
    }
}
