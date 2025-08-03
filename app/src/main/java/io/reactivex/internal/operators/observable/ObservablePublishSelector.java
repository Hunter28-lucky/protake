package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservablePublishSelector<T, R> extends AbstractC3414<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super AbstractC4262<T>, ? extends InterfaceC2856<R>> f7419;

    public static final class TargetObserver<T, R> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<R>, InterfaceC4478 {
        private static final long serialVersionUID = 854110278590336484L;
        public final InterfaceC5102<? super R> downstream;
        public InterfaceC4478 upstream;

        public TargetObserver(InterfaceC5102<? super R> interfaceC5102) {
            this.downstream = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.upstream.dispose();
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            DisposableHelper.dispose(this);
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservablePublishSelector$Ϳ, reason: contains not printable characters */
    public static final class C2080<T, R> implements InterfaceC5102<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final PublishSubject<T> f7420;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AtomicReference<InterfaceC4478> f7421;

        public C2080(PublishSubject<T> publishSubject, AtomicReference<InterfaceC4478> atomicReference) {
            this.f7420 = publishSubject;
            this.f7421 = atomicReference;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f7420.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f7420.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f7420.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.f7421, interfaceC4478);
        }
    }

    public ObservablePublishSelector(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super AbstractC4262<T>, ? extends InterfaceC2856<R>> interfaceC2368) {
        super(interfaceC2856);
        this.f7419 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        PublishSubject publishSubjectM7034 = PublishSubject.m7034();
        try {
            InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.f7419.apply(publishSubjectM7034), "The selector returned a null ObservableSource");
            TargetObserver targetObserver = new TargetObserver(interfaceC5102);
            interfaceC2856.subscribe(targetObserver);
            this.f11778.subscribe(new C2080(publishSubjectM7034, targetObserver));
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC5102);
        }
    }
}
