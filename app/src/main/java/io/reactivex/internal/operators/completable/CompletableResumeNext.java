package io.reactivex.internal.operators.completable;

import defpackage.AbstractC2900;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class CompletableResumeNext extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2837 f6849;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Throwable, ? extends InterfaceC2837> f6850;

    public static final class ResumeNextObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5053, InterfaceC4478 {
        private static final long serialVersionUID = 5018523762564524046L;
        public final InterfaceC5053 downstream;
        public final InterfaceC2368<? super Throwable, ? extends InterfaceC2837> errorMapper;
        public boolean once;

        public ResumeNextObserver(InterfaceC5053 interfaceC5053, InterfaceC2368<? super Throwable, ? extends InterfaceC2837> interfaceC2368) {
            this.downstream = interfaceC5053;
            this.errorMapper = interfaceC2368;
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
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5053
        public void onError(Throwable th) {
            if (this.once) {
                this.downstream.onError(th);
                return;
            }
            this.once = true;
            try {
                ((InterfaceC2837) C4246.m13353(this.errorMapper.apply(th), "The errorMapper returned a null CompletableSource")).mo10180(this);
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        @Override // defpackage.InterfaceC5053
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.replace(this, interfaceC4478);
        }
    }

    public CompletableResumeNext(InterfaceC2837 interfaceC2837, InterfaceC2368<? super Throwable, ? extends InterfaceC2837> interfaceC2368) {
        this.f6849 = interfaceC2837;
        this.f6850 = interfaceC2368;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        ResumeNextObserver resumeNextObserver = new ResumeNextObserver(interfaceC5053, this.f6850);
        interfaceC5053.onSubscribe(resumeNextObserver);
        this.f6849.mo10180(resumeNextObserver);
    }
}
