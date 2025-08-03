package io.reactivex.internal.operators.completable;

import defpackage.AbstractC2900;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class CompletableAndThenCompletable extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2837 f6841;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2837 f6842;

    public static final class SourceObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5053, InterfaceC4478 {
        private static final long serialVersionUID = -4101678820158072998L;
        public final InterfaceC5053 actualObserver;
        public final InterfaceC2837 next;

        public SourceObserver(InterfaceC5053 interfaceC5053, InterfaceC2837 interfaceC2837) {
            this.actualObserver = interfaceC5053;
            this.next = interfaceC2837;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC5053
        public void onComplete() {
            this.next.mo10180(new C2012(this, this.actualObserver));
        }

        @Override // defpackage.InterfaceC5053
        public void onError(Throwable th) {
            this.actualObserver.onError(th);
        }

        @Override // defpackage.InterfaceC5053
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.setOnce(this, interfaceC4478)) {
                this.actualObserver.onSubscribe(this);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableAndThenCompletable$Ϳ, reason: contains not printable characters */
    public static final class C2012 implements InterfaceC5053 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AtomicReference<InterfaceC4478> f6843;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5053 f6844;

        public C2012(AtomicReference<InterfaceC4478> atomicReference, InterfaceC5053 interfaceC5053) {
            this.f6843 = atomicReference;
            this.f6844 = interfaceC5053;
        }

        @Override // defpackage.InterfaceC5053
        public void onComplete() {
            this.f6844.onComplete();
        }

        @Override // defpackage.InterfaceC5053
        public void onError(Throwable th) {
            this.f6844.onError(th);
        }

        @Override // defpackage.InterfaceC5053
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.replace(this.f6843, interfaceC4478);
        }
    }

    public CompletableAndThenCompletable(InterfaceC2837 interfaceC2837, InterfaceC2837 interfaceC28372) {
        this.f6841 = interfaceC2837;
        this.f6842 = interfaceC28372;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ, reason: contains not printable characters */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        this.f6841.mo10180(new SourceObserver(interfaceC5053, this.f6842));
    }
}
