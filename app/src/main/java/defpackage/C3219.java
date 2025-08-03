package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: DisposableLambdaObserver.java */
/* renamed from: Կ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3219<T> implements InterfaceC5102<T>, InterfaceC4478 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC5102<? super T> f11342;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super InterfaceC4478> f11343;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC3809 f11344;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC4478 f11345;

    public C3219(InterfaceC5102<? super T> interfaceC5102, InterfaceC2857<? super InterfaceC4478> interfaceC2857, InterfaceC3809 interfaceC3809) {
        this.f11342 = interfaceC5102;
        this.f11343 = interfaceC2857;
        this.f11344 = interfaceC3809;
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        InterfaceC4478 interfaceC4478 = this.f11345;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (interfaceC4478 != disposableHelper) {
            this.f11345 = disposableHelper;
            try {
                this.f11344.run();
            } catch (Throwable th) {
                C4089.m13026(th);
                C3671.m11803(th);
            }
            interfaceC4478.dispose();
        }
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return this.f11345.isDisposed();
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        InterfaceC4478 interfaceC4478 = this.f11345;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (interfaceC4478 != disposableHelper) {
            this.f11345 = disposableHelper;
            this.f11342.onComplete();
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        InterfaceC4478 interfaceC4478 = this.f11345;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (interfaceC4478 == disposableHelper) {
            C3671.m11803(th);
        } else {
            this.f11345 = disposableHelper;
            this.f11342.onError(th);
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        this.f11342.onNext(t);
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        try {
            this.f11343.accept(interfaceC4478);
            if (DisposableHelper.validate(this.f11345, interfaceC4478)) {
                this.f11345 = interfaceC4478;
                this.f11342.onSubscribe(this);
            }
        } catch (Throwable th) {
            C4089.m13026(th);
            interfaceC4478.dispose();
            this.f11345 = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, this.f11342);
        }
    }
}
