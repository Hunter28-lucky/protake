package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

/* compiled from: ObservableDetach.java */
/* renamed from: బ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4547<T> extends AbstractC3414<T, T> {

    /* compiled from: ObservableDetach.java */
    /* renamed from: బ$Ϳ, reason: contains not printable characters */
    public static final class C4548<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public InterfaceC5102<? super T> f15567;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f15568;

        public C4548(InterfaceC5102<? super T> interfaceC5102) {
            this.f15567 = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            InterfaceC4478 interfaceC4478 = this.f15568;
            this.f15568 = EmptyComponent.INSTANCE;
            this.f15567 = EmptyComponent.asObserver();
            interfaceC4478.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15568.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            InterfaceC5102<? super T> interfaceC5102 = this.f15567;
            this.f15568 = EmptyComponent.INSTANCE;
            this.f15567 = EmptyComponent.asObserver();
            interfaceC5102.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            InterfaceC5102<? super T> interfaceC5102 = this.f15567;
            this.f15568 = EmptyComponent.INSTANCE;
            this.f15567 = EmptyComponent.asObserver();
            interfaceC5102.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f15567.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15568, interfaceC4478)) {
                this.f15568 = interfaceC4478;
                this.f15567.onSubscribe(this);
            }
        }
    }

    public C4547(InterfaceC2856<T> interfaceC2856) {
        super(interfaceC2856);
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C4548(interfaceC5102));
    }
}
