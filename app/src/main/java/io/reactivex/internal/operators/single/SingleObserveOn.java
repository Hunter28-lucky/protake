package io.reactivex.internal.operators.single;

import defpackage.AbstractC4585;
import defpackage.AbstractC4838;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleObserveOn<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f7608;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AbstractC4585 f7609;

    public static final class ObserveOnSingleObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<T>, InterfaceC4478, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        public final InterfaceC4782<? super T> downstream;
        public Throwable error;
        public final AbstractC4585 scheduler;
        public T value;

        public ObserveOnSingleObserver(InterfaceC4782<? super T> interfaceC4782, AbstractC4585 abstractC4585) {
            this.downstream = interfaceC4782;
            this.scheduler = abstractC4585;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.mo6987(this));
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.setOnce(this, interfaceC4478)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.value = t;
            DisposableHelper.replace(this, this.scheduler.mo6987(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.downstream.onError(th);
            } else {
                this.downstream.onSuccess(this.value);
            }
        }
    }

    public SingleObserveOn(InterfaceC3951<T> interfaceC3951, AbstractC4585 abstractC4585) {
        this.f7608 = interfaceC3951;
        this.f7609 = abstractC4585;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f7608.subscribe(new ObserveOnSingleObserver(interfaceC4782, this.f7609));
    }
}
