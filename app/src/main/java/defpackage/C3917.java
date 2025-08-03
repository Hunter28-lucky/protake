package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableTakeWhile.java */
/* renamed from: ࡁ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3917<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f13537;

    /* compiled from: ObservableTakeWhile.java */
    /* renamed from: ࡁ$Ϳ, reason: contains not printable characters */
    public static final class C3918<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f13538;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f13539;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f13540;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f13541;

        public C3918(InterfaceC5102<? super T> interfaceC5102, InterfaceC4178<? super T> interfaceC4178) {
            this.f13538 = interfaceC5102;
            this.f13539 = interfaceC4178;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f13540.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f13540.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f13541) {
                return;
            }
            this.f13541 = true;
            this.f13538.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f13541) {
                C3671.m11803(th);
            } else {
                this.f13541 = true;
                this.f13538.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f13541) {
                return;
            }
            try {
                if (this.f13539.test(t)) {
                    this.f13538.onNext(t);
                    return;
                }
                this.f13541 = true;
                this.f13540.dispose();
                this.f13538.onComplete();
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f13540.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f13540, interfaceC4478)) {
                this.f13540 = interfaceC4478;
                this.f13538.onSubscribe(this);
            }
        }
    }

    public C3917(InterfaceC2856<T> interfaceC2856, InterfaceC4178<? super T> interfaceC4178) {
        super(interfaceC2856);
        this.f13537 = interfaceC4178;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C3918(interfaceC5102, this.f13537));
    }
}
