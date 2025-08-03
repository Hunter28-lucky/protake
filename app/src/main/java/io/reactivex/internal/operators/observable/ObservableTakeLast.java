package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
public final class ObservableTakeLast<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f7498;

    public static final class TakeLastObserver<T> extends ArrayDeque<T> implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = 7240042530241604978L;
        public volatile boolean cancelled;
        public final int count;
        public final InterfaceC5102<? super T> downstream;
        public InterfaceC4478 upstream;

        public TakeLastObserver(InterfaceC5102<? super T> interfaceC5102, int i) {
            this.downstream = interfaceC5102;
            this.count = i;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            InterfaceC5102<? super T> interfaceC5102 = this.downstream;
            while (!this.cancelled) {
                T tPoll = poll();
                if (tPoll == null) {
                    if (this.cancelled) {
                        return;
                    }
                    interfaceC5102.onComplete();
                    return;
                }
                interfaceC5102.onNext(tPoll);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
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

    public ObservableTakeLast(InterfaceC2856<T> interfaceC2856, int i) {
        super(interfaceC2856);
        this.f7498 = i;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new TakeLastObserver(interfaceC5102, this.f7498));
    }
}
