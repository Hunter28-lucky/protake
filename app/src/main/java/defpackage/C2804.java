package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: CompletableToObservable.java */
/* renamed from: Ϋ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2804<T> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2837 f10233;

    /* compiled from: CompletableToObservable.java */
    /* renamed from: Ϋ$Ϳ, reason: contains not printable characters */
    public static final class C2805 extends AbstractC5180<Void> implements InterfaceC5053 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<?> f10234;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f10235;

        public C2805(InterfaceC5102<?> interfaceC5102) {
            this.f10234 = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f10235.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f10235.isDisposed();
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return true;
        }

        @Override // defpackage.InterfaceC5053
        public void onComplete() {
            this.f10234.onComplete();
        }

        @Override // defpackage.InterfaceC5053
        public void onError(Throwable th) {
            this.f10234.onError(th);
        }

        @Override // defpackage.InterfaceC5053
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f10235, interfaceC4478)) {
                this.f10235 = interfaceC4478;
                this.f10234.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4851
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Void poll() throws Exception {
            return null;
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return i & 2;
        }
    }

    public C2804(InterfaceC2837 interfaceC2837) {
        this.f10233 = interfaceC2837;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f10233.mo10180(new C2805(interfaceC5102));
    }
}
