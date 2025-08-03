package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableScanSeed.java */
/* renamed from: ശ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4736<T, R> extends AbstractC3414<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5247<R, ? super T, R> f15997;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Callable<R> f15998;

    /* compiled from: ObservableScanSeed.java */
    /* renamed from: ശ$Ϳ, reason: contains not printable characters */
    public static final class C4737<T, R> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super R> f15999;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5247<R, ? super T, R> f16000;

        /* renamed from: ԭ, reason: contains not printable characters */
        public R f16001;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public InterfaceC4478 f16002;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f16003;

        public C4737(InterfaceC5102<? super R> interfaceC5102, InterfaceC5247<R, ? super T, R> interfaceC5247, R r) {
            this.f15999 = interfaceC5102;
            this.f16000 = interfaceC5247;
            this.f16001 = r;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f16002.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f16002.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f16003) {
                return;
            }
            this.f16003 = true;
            this.f15999.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f16003) {
                C3671.m11803(th);
            } else {
                this.f16003 = true;
                this.f15999.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f16003) {
                return;
            }
            try {
                R r = (R) C4246.m13353(this.f16000.apply(this.f16001, t), "The accumulator returned a null value");
                this.f16001 = r;
                this.f15999.onNext(r);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f16002.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f16002, interfaceC4478)) {
                this.f16002 = interfaceC4478;
                this.f15999.onSubscribe(this);
                this.f15999.onNext(this.f16001);
            }
        }
    }

    public C4736(InterfaceC2856<T> interfaceC2856, Callable<R> callable, InterfaceC5247<R, ? super T, R> interfaceC5247) {
        super(interfaceC2856);
        this.f15997 = interfaceC5247;
        this.f15998 = callable;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        try {
            this.f11778.subscribe(new C4737(interfaceC5102, this.f15997, C4246.m13353(this.f15998.call(), "The seed supplied is null")));
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC5102);
        }
    }
}
