package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableScan.java */
/* renamed from: ઐ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4318<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5247<T, T, T> f14798;

    /* compiled from: ObservableScan.java */
    /* renamed from: ઐ$Ϳ, reason: contains not printable characters */
    public static final class C4319<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f14799;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5247<T, T, T> f14800;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f14801;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public T f14802;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f14803;

        public C4319(InterfaceC5102<? super T> interfaceC5102, InterfaceC5247<T, T, T> interfaceC5247) {
            this.f14799 = interfaceC5102;
            this.f14800 = interfaceC5247;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f14801.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f14801.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f14803) {
                return;
            }
            this.f14803 = true;
            this.f14799.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f14803) {
                C3671.m11803(th);
            } else {
                this.f14803 = true;
                this.f14799.onError(th);
            }
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f14803) {
                return;
            }
            InterfaceC5102<? super T> interfaceC5102 = this.f14799;
            T t2 = this.f14802;
            if (t2 == null) {
                this.f14802 = t;
                interfaceC5102.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) C4246.m13353(this.f14800.apply(t2, t), "The value returned by the accumulator is null");
                this.f14802 = r4;
                interfaceC5102.onNext(r4);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f14801.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f14801, interfaceC4478)) {
                this.f14801 = interfaceC4478;
                this.f14799.onSubscribe(this);
            }
        }
    }

    public C4318(InterfaceC2856<T> interfaceC2856, InterfaceC5247<T, T, T> interfaceC5247) {
        super(interfaceC2856);
        this.f14798 = interfaceC5247;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C4319(interfaceC5102, this.f14798));
    }
}
