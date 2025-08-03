package defpackage;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: CompletablePeek.java */
/* renamed from: ծ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3241 extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2837 f11397;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super InterfaceC4478> f11398;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super Throwable> f11399;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC3809 f11400;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC3809 f11401;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final InterfaceC3809 f11402;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final InterfaceC3809 f11403;

    /* compiled from: CompletablePeek.java */
    /* renamed from: ծ$Ϳ, reason: contains not printable characters */
    public final class C3242 implements InterfaceC5053, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5053 f11404;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f11405;

        public C3242(InterfaceC5053 interfaceC5053) {
            this.f11404 = interfaceC5053;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            try {
                C3241.this.f11403.run();
            } catch (Throwable th) {
                C4089.m13026(th);
                C3671.m11803(th);
            }
            this.f11405.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f11405.isDisposed();
        }

        @Override // defpackage.InterfaceC5053
        public void onComplete() {
            if (this.f11405 == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                C3241.this.f11400.run();
                C3241.this.f11401.run();
                this.f11404.onComplete();
                m10904();
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f11404.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5053
        public void onError(Throwable th) {
            if (this.f11405 == DisposableHelper.DISPOSED) {
                C3671.m11803(th);
                return;
            }
            try {
                C3241.this.f11399.accept(th);
                C3241.this.f11401.run();
            } catch (Throwable th2) {
                C4089.m13026(th2);
                th = new CompositeException(th, th2);
            }
            this.f11404.onError(th);
            m10904();
        }

        @Override // defpackage.InterfaceC5053
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            try {
                C3241.this.f11398.accept(interfaceC4478);
                if (DisposableHelper.validate(this.f11405, interfaceC4478)) {
                    this.f11405 = interfaceC4478;
                    this.f11404.onSubscribe(this);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                interfaceC4478.dispose();
                this.f11405 = DisposableHelper.DISPOSED;
                EmptyDisposable.error(th, this.f11404);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m10904() {
            try {
                C3241.this.f11402.run();
            } catch (Throwable th) {
                C4089.m13026(th);
                C3671.m11803(th);
            }
        }
    }

    public C3241(InterfaceC2837 interfaceC2837, InterfaceC2857<? super InterfaceC4478> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, InterfaceC3809 interfaceC38092, InterfaceC3809 interfaceC38093, InterfaceC3809 interfaceC38094) {
        this.f11397 = interfaceC2837;
        this.f11398 = interfaceC2857;
        this.f11399 = interfaceC28572;
        this.f11400 = interfaceC3809;
        this.f11401 = interfaceC38092;
        this.f11402 = interfaceC38093;
        this.f11403 = interfaceC38094;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        this.f11397.mo10180(new C3242(interfaceC5053));
    }
}
