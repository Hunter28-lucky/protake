package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableTimeInterval.java */
/* renamed from: ਓ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4236<T> extends AbstractC3414<T, o2<T>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AbstractC4585 f14559;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f14560;

    /* compiled from: ObservableTimeInterval.java */
    /* renamed from: ਓ$Ϳ, reason: contains not printable characters */
    public static final class C4237<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super o2<T>> f14561;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final TimeUnit f14562;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final AbstractC4585 f14563;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public long f14564;

        /* renamed from: ԯ, reason: contains not printable characters */
        public InterfaceC4478 f14565;

        public C4237(InterfaceC5102<? super o2<T>> interfaceC5102, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            this.f14561 = interfaceC5102;
            this.f14563 = abstractC4585;
            this.f14562 = timeUnit;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f14565.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f14565.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f14561.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f14561.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            long jM14050 = this.f14563.m14050(this.f14562);
            long j = this.f14564;
            this.f14564 = jM14050;
            this.f14561.onNext(new o2(t, jM14050 - j, this.f14562));
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f14565, interfaceC4478)) {
                this.f14565 = interfaceC4478;
                this.f14564 = this.f14563.m14050(this.f14562);
                this.f14561.onSubscribe(this);
            }
        }
    }

    public C4236(InterfaceC2856<T> interfaceC2856, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        super(interfaceC2856);
        this.f14559 = abstractC4585;
        this.f14560 = timeUnit;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super o2<T>> interfaceC5102) {
        this.f11778.subscribe(new C4237(interfaceC5102, this.f14560, this.f14559));
    }
}
