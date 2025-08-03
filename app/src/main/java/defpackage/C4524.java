package defpackage;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableSkipUntil.java */
/* renamed from: చ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4524<T, U> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<U> f15487;

    /* compiled from: ObservableSkipUntil.java */
    /* renamed from: చ$Ϳ, reason: contains not printable characters */
    public final class C4525 implements InterfaceC5102<U> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final ArrayCompositeDisposable f15488;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C4526<T> f15489;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final C5312<T> f15490;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public InterfaceC4478 f15491;

        public C4525(ArrayCompositeDisposable arrayCompositeDisposable, C4526<T> c4526, C5312<T> c5312) {
            this.f15488 = arrayCompositeDisposable;
            this.f15489 = c4526;
            this.f15490 = c5312;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f15489.f15496 = true;
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f15488.dispose();
            this.f15490.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(U u) {
            this.f15491.dispose();
            this.f15489.f15496 = true;
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15491, interfaceC4478)) {
                this.f15491 = interfaceC4478;
                this.f15488.m6309(1, interfaceC4478);
            }
        }
    }

    /* compiled from: ObservableSkipUntil.java */
    /* renamed from: చ$Ԩ, reason: contains not printable characters */
    public static final class C4526<T> implements InterfaceC5102<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f15493;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final ArrayCompositeDisposable f15494;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f15495;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public volatile boolean f15496;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f15497;

        public C4526(InterfaceC5102<? super T> interfaceC5102, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.f15493 = interfaceC5102;
            this.f15494 = arrayCompositeDisposable;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f15494.dispose();
            this.f15493.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f15494.dispose();
            this.f15493.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f15497) {
                this.f15493.onNext(t);
            } else if (this.f15496) {
                this.f15497 = true;
                this.f15493.onNext(t);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15495, interfaceC4478)) {
                this.f15495 = interfaceC4478;
                this.f15494.m6309(0, interfaceC4478);
            }
        }
    }

    public C4524(InterfaceC2856<T> interfaceC2856, InterfaceC2856<U> interfaceC28562) {
        super(interfaceC2856);
        this.f15487 = interfaceC28562;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        C5312 c5312 = new C5312(interfaceC5102);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        c5312.onSubscribe(arrayCompositeDisposable);
        C4526 c4526 = new C4526(c5312, arrayCompositeDisposable);
        this.f15487.subscribe(new C4525(arrayCompositeDisposable, c4526, c5312));
        this.f11778.subscribe(c4526);
    }
}
