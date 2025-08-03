package io.reactivex.internal.operators.single;

import defpackage.AbstractC4838;
import defpackage.C3671;
import defpackage.C4495;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleDelayWithObservable<T, U> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f7576;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<U> f7577;

    public static final class OtherSubscriber<T, U> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<U>, InterfaceC4478 {
        private static final long serialVersionUID = -8565274649390031272L;
        public boolean done;
        public final InterfaceC4782<? super T> downstream;
        public final InterfaceC3951<T> source;

        public OtherSubscriber(InterfaceC4782<? super T> interfaceC4782, InterfaceC3951<T> interfaceC3951) {
            this.downstream = interfaceC4782;
            this.source = interfaceC3951;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.source.subscribe(new C4495(this, this.downstream));
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
            } else {
                this.done = true;
                this.downstream.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(U u) {
            get().dispose();
            onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.set(this, interfaceC4478)) {
                this.downstream.onSubscribe(this);
            }
        }
    }

    public SingleDelayWithObservable(InterfaceC3951<T> interfaceC3951, InterfaceC2856<U> interfaceC2856) {
        this.f7576 = interfaceC3951;
        this.f7577 = interfaceC2856;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f7577.subscribe(new OtherSubscriber(interfaceC4782, this.f7576));
    }
}
