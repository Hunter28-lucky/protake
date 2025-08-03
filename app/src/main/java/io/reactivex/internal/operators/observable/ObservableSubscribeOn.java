package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4585;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableSubscribeOn<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AbstractC4585 f7491;

    public static final class SubscribeOnObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = 8094547886072529208L;
        public final InterfaceC5102<? super T> downstream;
        public final AtomicReference<InterfaceC4478> upstream = new AtomicReference<>();

        public SubscribeOnObserver(InterfaceC5102<? super T> interfaceC5102) {
            this.downstream = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.upstream, interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6905(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableSubscribeOn$Ϳ, reason: contains not printable characters */
    public final class RunnableC2094 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final SubscribeOnObserver<T> f7492;

        public RunnableC2094(SubscribeOnObserver<T> subscribeOnObserver) {
            this.f7492 = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableSubscribeOn.this.f11778.subscribe(this.f7492);
        }
    }

    public ObservableSubscribeOn(InterfaceC2856<T> interfaceC2856, AbstractC4585 abstractC4585) {
        super(interfaceC2856);
        this.f7491 = abstractC4585;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(interfaceC5102);
        interfaceC5102.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.m6905(this.f7491.mo6987(new RunnableC2094(subscribeOnObserver)));
    }
}
