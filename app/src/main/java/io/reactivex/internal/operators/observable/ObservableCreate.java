package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC2672;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5201;
import defpackage.InterfaceC5245;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableCreate<T> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC5201<T> f7339;

    public static final class CreateEmitter<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5245<T>, InterfaceC4478 {
        private static final long serialVersionUID = -3434801548987643227L;
        public final InterfaceC5102<? super T> observer;

        public CreateEmitter(InterfaceC5102<? super T> interfaceC5102) {
            this.observer = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC5245, defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC3487
        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            try {
                this.observer.onComplete();
            } finally {
                dispose();
            }
        }

        @Override // defpackage.InterfaceC3487
        public void onError(Throwable th) {
            if (mo6761(th)) {
                return;
            }
            C3671.m11803(th);
        }

        @Override // defpackage.InterfaceC3487
        public void onNext(T t) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                if (isDisposed()) {
                    return;
                }
                this.observer.onNext(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", CreateEmitter.class.getSimpleName(), super.toString());
        }

        @Override // defpackage.InterfaceC5245
        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean mo6761(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.observer.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }

        @Override // defpackage.InterfaceC5245
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo6762(InterfaceC4478 interfaceC4478) {
            DisposableHelper.set(this, interfaceC4478);
        }

        @Override // defpackage.InterfaceC5245
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo6763(InterfaceC2672 interfaceC2672) {
            mo6762(new CancellableDisposable(interfaceC2672));
        }
    }

    public ObservableCreate(InterfaceC5201<T> interfaceC5201) {
        this.f7339 = interfaceC5201;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        CreateEmitter createEmitter = new CreateEmitter(interfaceC5102);
        interfaceC5102.onSubscribe(createEmitter);
        try {
            this.f7339.subscribe(createEmitter);
        } catch (Throwable th) {
            C4089.m13026(th);
            createEmitter.onError(th);
        }
    }
}
