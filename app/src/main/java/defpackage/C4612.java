package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: ObservableTake.java */
/* renamed from: ಘ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4612<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f15718;

    /* compiled from: ObservableTake.java */
    /* renamed from: ಘ$Ϳ, reason: contains not printable characters */
    public static final class C4613<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f15719;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f15720;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f15721;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public long f15722;

        public C4613(InterfaceC5102<? super T> interfaceC5102, long j) {
            this.f15719 = interfaceC5102;
            this.f15722 = j;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15721.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15721.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f15720) {
                return;
            }
            this.f15720 = true;
            this.f15721.dispose();
            this.f15719.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f15720) {
                C3671.m11803(th);
                return;
            }
            this.f15720 = true;
            this.f15721.dispose();
            this.f15719.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f15720) {
                return;
            }
            long j = this.f15722;
            long j2 = j - 1;
            this.f15722 = j2;
            if (j > 0) {
                boolean z = j2 == 0;
                this.f15719.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15721, interfaceC4478)) {
                this.f15721 = interfaceC4478;
                if (this.f15722 != 0) {
                    this.f15719.onSubscribe(this);
                    return;
                }
                this.f15720 = true;
                interfaceC4478.dispose();
                EmptyDisposable.complete(this.f15719);
            }
        }
    }

    public C4612(InterfaceC2856<T> interfaceC2856, long j) {
        super(interfaceC2856);
        this.f15718 = j;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C4613(interfaceC5102, this.f15718));
    }
}
