package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableElementAtMaybe.java */
/* renamed from: ඊ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4777<T> extends AbstractC4274<T> implements InterfaceC2325<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f16107;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f16108;

    /* compiled from: ObservableElementAtMaybe.java */
    /* renamed from: ඊ$Ϳ, reason: contains not printable characters */
    public static final class C4778<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5216<? super T> f16109;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f16110;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f16111;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public long f16112;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f16113;

        public C4778(InterfaceC5216<? super T> interfaceC5216, long j) {
            this.f16109 = interfaceC5216;
            this.f16110 = j;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f16111.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f16111.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f16113) {
                return;
            }
            this.f16113 = true;
            this.f16109.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f16113) {
                C3671.m11803(th);
            } else {
                this.f16113 = true;
                this.f16109.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f16113) {
                return;
            }
            long j = this.f16112;
            if (j != this.f16110) {
                this.f16112 = j + 1;
                return;
            }
            this.f16113 = true;
            this.f16111.dispose();
            this.f16109.onSuccess(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f16111, interfaceC4478)) {
                this.f16111 = interfaceC4478;
                this.f16109.onSubscribe(this);
            }
        }
    }

    public C4777(InterfaceC2856<T> interfaceC2856, long j) {
        this.f16107 = interfaceC2856;
        this.f16108 = j;
    }

    @Override // defpackage.InterfaceC2325
    /* renamed from: Ϳ */
    public AbstractC4262<T> mo6779() {
        return C3671.m11798(new C4616(this.f16107, this.f16108, null, false));
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ */
    public void mo6675(InterfaceC5216<? super T> interfaceC5216) {
        this.f16107.subscribe(new C4778(interfaceC5216, this.f16108));
    }
}
