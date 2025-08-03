package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.C4217;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableMergeWithCompletable<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2837 f7399;

    public static final class MergeWithObserver<T> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -4592979584110982903L;
        public final InterfaceC5102<? super T> downstream;
        public volatile boolean mainDone;
        public volatile boolean otherDone;
        public final AtomicReference<InterfaceC4478> mainDisposable = new AtomicReference<>();
        public final OtherObserver otherObserver = new OtherObserver(this);
        public final AtomicThrowable error = new AtomicThrowable();

        public static final class OtherObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5053 {
            private static final long serialVersionUID = -2935427570954647017L;
            public final MergeWithObserver<?> parent;

            public OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // defpackage.InterfaceC5053
            public void onComplete() {
                this.parent.m6815();
            }

            @Override // defpackage.InterfaceC5053
            public void onError(Throwable th) {
                this.parent.m6816(th);
            }

            @Override // defpackage.InterfaceC5053
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }
        }

        public MergeWithObserver(InterfaceC5102<? super T> interfaceC5102) {
            this.downstream = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                C4217.m13296(this.downstream, this, this.error);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.otherObserver);
            C4217.m13298(this.downstream, th, this, this.error);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            C4217.m13300(this.downstream, t, this, this.error);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.mainDisposable, interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6815() {
            this.otherDone = true;
            if (this.mainDone) {
                C4217.m13296(this.downstream, this, this.error);
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6816(Throwable th) {
            DisposableHelper.dispose(this.mainDisposable);
            C4217.m13298(this.downstream, th, this, this.error);
        }
    }

    public ObservableMergeWithCompletable(AbstractC4262<T> abstractC4262, InterfaceC2837 interfaceC2837) {
        super(abstractC4262);
        this.f7399 = interfaceC2837;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(interfaceC5102);
        interfaceC5102.onSubscribe(mergeWithObserver);
        this.f11778.subscribe(mergeWithObserver);
        this.f7399.mo10180(mergeWithObserver.otherObserver);
    }
}
