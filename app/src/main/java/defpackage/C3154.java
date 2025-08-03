package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableDematerialize.java */
/* renamed from: ԗ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3154<T, R> extends AbstractC3414<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends C3906<R>> f11201;

    /* compiled from: ObservableDematerialize.java */
    /* renamed from: ԗ$Ϳ, reason: contains not printable characters */
    public static final class C3155<T, R> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super R> f11202;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends C3906<R>> f11203;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f11204;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public InterfaceC4478 f11205;

        public C3155(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super T, ? extends C3906<R>> interfaceC2368) {
            this.f11202 = interfaceC5102;
            this.f11203 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f11205.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f11205.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f11204) {
                return;
            }
            this.f11204 = true;
            this.f11202.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f11204) {
                C3671.m11803(th);
            } else {
                this.f11204 = true;
                this.f11202.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f11204) {
                if (t instanceof C3906) {
                    C3906 c3906 = (C3906) t;
                    if (c3906.m12651()) {
                        C3671.m11803(c3906.m12648());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                C3906 c39062 = (C3906) C4246.m13353(this.f11203.apply(t), "The selector returned a null Notification");
                if (c39062.m12651()) {
                    this.f11205.dispose();
                    onError(c39062.m12648());
                } else if (!c39062.m12650()) {
                    this.f11202.onNext((Object) c39062.m12649());
                } else {
                    this.f11205.dispose();
                    onComplete();
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f11205.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f11205, interfaceC4478)) {
                this.f11205 = interfaceC4478;
                this.f11202.onSubscribe(this);
            }
        }
    }

    public C3154(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, ? extends C3906<R>> interfaceC2368) {
        super(interfaceC2856);
        this.f11201 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        this.f11778.subscribe(new C3155(interfaceC5102, this.f11201));
    }
}
