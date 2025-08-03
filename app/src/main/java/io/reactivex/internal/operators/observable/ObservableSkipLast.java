package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
public final class ObservableSkipLast<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f7485;

    public static final class SkipLastObserver<T> extends ArrayDeque<T> implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -3807491841935125653L;
        public final InterfaceC5102<? super T> downstream;
        public final int skip;
        public InterfaceC4478 upstream;

        public SkipLastObserver(InterfaceC5102<? super T> interfaceC5102, int i) {
            super(i);
            this.downstream = interfaceC5102;
            this.skip = i;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.upstream.isDisposed();
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
            if (this.skip == size()) {
                this.downstream.onNext(poll());
            }
            offer(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLast(InterfaceC2856<T> interfaceC2856, int i) {
        super(interfaceC2856);
        this.f7485 = i;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new SkipLastObserver(interfaceC5102, this.f7485));
    }
}
