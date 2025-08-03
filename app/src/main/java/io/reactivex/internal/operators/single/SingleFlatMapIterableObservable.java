package io.reactivex.internal.operators.single;

import defpackage.AbstractC4262;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class SingleFlatMapIterableObservable<T, R> extends AbstractC4262<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f7594;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends Iterable<? extends R>> f7595;

    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements InterfaceC4782<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        public volatile boolean cancelled;
        public final InterfaceC5102<? super R> downstream;
        public volatile Iterator<? extends R> it;
        public final InterfaceC2368<? super T, ? extends Iterable<? extends R>> mapper;
        public boolean outputFused;
        public InterfaceC4478 upstream;

        public FlatMapIterableObserver(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super T, ? extends Iterable<? extends R>> interfaceC2368) {
            this.downstream = interfaceC5102;
            this.mapper = interfaceC2368;
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            this.it = null;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return this.it == null;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
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
            InterfaceC5102<? super R> interfaceC5102 = this.downstream;
            try {
                Iterator<? extends R> it = this.mapper.apply(t).iterator();
                if (!it.hasNext()) {
                    interfaceC5102.onComplete();
                    return;
                }
                if (this.outputFused) {
                    this.it = it;
                    interfaceC5102.onNext(null);
                    interfaceC5102.onComplete();
                    return;
                }
                while (!this.cancelled) {
                    try {
                        interfaceC5102.onNext(it.next());
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                interfaceC5102.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            C4089.m13026(th);
                            interfaceC5102.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        C4089.m13026(th2);
                        interfaceC5102.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                C4089.m13026(th3);
                this.downstream.onError(th3);
            }
        }

        @Override // defpackage.InterfaceC4851
        public R poll() throws Exception {
            Iterator<? extends R> it = this.it;
            if (it == null) {
                return null;
            }
            R r = (R) C4246.m13353(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.it = null;
            }
            return r;
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public SingleFlatMapIterableObservable(InterfaceC3951<T> interfaceC3951, InterfaceC2368<? super T, ? extends Iterable<? extends R>> interfaceC2368) {
        this.f7594 = interfaceC3951;
        this.f7595 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        this.f7594.subscribe(new FlatMapIterableObserver(interfaceC5102, this.f7595));
    }
}
