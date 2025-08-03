package io.reactivex.internal.operators.single;

import defpackage.AbstractC4585;
import defpackage.AbstractC4838;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleSubscribeOn<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f7612;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AbstractC4585 f7613;

    public static final class SubscribeOnObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<T>, InterfaceC4478, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        public final InterfaceC4782<? super T> downstream;
        public final InterfaceC3951<? extends T> source;
        public final SequentialDisposable task = new SequentialDisposable();

        public SubscribeOnObserver(InterfaceC4782<? super T> interfaceC4782, InterfaceC3951<? extends T> interfaceC3951) {
            this.downstream = interfaceC4782;
            this.source = interfaceC3951;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.subscribe(this);
        }
    }

    public SingleSubscribeOn(InterfaceC3951<? extends T> interfaceC3951, AbstractC4585 abstractC4585) {
        this.f7612 = interfaceC3951;
        this.f7613 = abstractC4585;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(interfaceC4782, this.f7612);
        interfaceC4782.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.task.m6311(this.f7613.mo6987(subscribeOnObserver));
    }
}
